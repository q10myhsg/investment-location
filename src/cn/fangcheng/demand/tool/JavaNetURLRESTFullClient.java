package cn.fangcheng.demand.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.net.www.protocol.http.HttpURLConnection;
import cn.fangcheng.demand.bean.StaticBean;
import cn.fangcheng.demand.service.other.imp.Storage;
import cn.fangcheng.demand.servlet.InitServlet;

public class JavaNetURLRESTFullClient {
	/**
	 * 日志
	 */
	public static Logger logger = LoggerFactory
			.getLogger(JavaNetURLRESTFullClient.class);
	/**
	 * 连接超时时间
	 */
	public static int connectionTimeOut = 2000;
	/**
	 * 读取超时时间
	 */
	public static int readTimeOut = 3000;

	public static String code = "utf-8";

	public static String DELETE = "DELETE";
	public static String GET = "GET";
	public static String POST = "POST";
	public static String PUT = "PUT";


	/**
	 * 发送rest并 获取状态
	 * 
	 * @param url
	 * @param method
	 * @param json
	 * @return
	 */
	public static boolean runAndGetStatus(int bid, String url, String method, String json, String alias) throws Exception {

		String result = post(bid, url, method, json, alias);

		return suggestStatus(result);
	}

	/**
	 * 放松rest并获取文本
	 * 
	 * @param url
	 * @param method
	 * @param json
	 * @return
	 */
	public static String runAndGetText(int bid, String url, String method, String json, String alias) throws Exception {
		String result = post(bid, url, method, json, alias);
		boolean flag = suggestStatus(result);
		if (flag) {
			return result;
		} else {
			return null;
		}
	}

	/**
	 * http 请求方法
	 * 
	 * @param url
	 * @param method
	 * @param json
	 * @param alias
	 *            别名
	 * @return
	 */
	public static String post(int typeCategory, String url, String method, String json, String alias) throws Exception {
		String target = null;
		if (typeCategory == StaticBean.MALL_TYPE) {
			if (alias != null) {
				target = InitServlet.mallTargetURL.replaceAll(InitServlet.indexTarget, alias);
			} else {
				target = InitServlet.mallTargetURL;
			}
			if (url != null) {
				url = target + url;
			} else if (method.equals(Storage.GET)) {
				url = target + "_search";
			} else {
				url = target;
			}
		} else {
			if (alias != null) {
				target = InitServlet.brandTargetURL.replaceAll(InitServlet.indexTarget, alias);
			} else {
				target = InitServlet.brandTargetURL;
			}
			if (url != null) {
				url = target + url;
			} else if (method.equals(Storage.GET)) {
				url = target + "_search";
			} else {
				url = target;
			}
		}
		logger.info("post to es:" + url + "  -X" + method + " -d " + json);
		String str = null;
		str = post2(url, method, json, JavaNetURLRESTFullClient.code);
		return str;
	}

	public static String post(String url, String method, String json)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		HttpURLConnection httpConnection = null;
		OutputStream outputStream = null;
		BufferedReader responseBuffer = null;
		URL targetUrl = new URL(url);
		httpConnection = (HttpURLConnection) targetUrl.openConnection();
		httpConnection.setRequestProperty("Accept",
				"application/json;charset=UTF-8");
		// httpConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36");
		// httpConnection.setRequestProperty("Accept",
		// "text/plain, */*; q=0.01");
		// httpConnection.setRequestProperty("Accept-Encoding",
		// "gzip, deflate");
		// httpConnection.setRequestProperty("Accept-Language",
		// "zh-CN,zh;q=0.8");
		// httpConnection.setRequestProperty("Connection", "keep-alive");
		httpConnection.setConnectTimeout(connectionTimeOut);
		httpConnection.setReadTimeout(readTimeOut);
		httpConnection.setDoOutput(true);
		httpConnection.setDoInput(true);
		httpConnection.setRequestMethod(method);
		httpConnection.setRequestProperty("Content-Type", "application/json");
		if (json != null) {
			outputStream = httpConnection.getOutputStream();
			outputStream.write(json.getBytes());
			outputStream.flush();
		}
		if (httpConnection.getResponseCode() != 200
				&& httpConnection.getResponseCode() != 201) {
			// throw new RuntimeException("Failed : HTTP error code : "
			// + httpConnection.getResponseCode());
			logger.error("Failed : HTTP error code : "
					+ httpConnection.getResponseCode());
			logger.error("error data :" + httpConnection.getResponseMessage());
			// return null;
		}

		responseBuffer = new BufferedReader(new InputStreamReader(
				(httpConnection.getInputStream())));

		String output;
		// System.out.println("Output from Server:\n");
		while ((output = responseBuffer.readLine()) != null) {
			sb.append(output);
			// System.out.println(output);
		}

		if (responseBuffer != null) {
			try {
				responseBuffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (httpConnection != null) {
			try {
				httpConnection.getInputStream().close();
			} catch (Exception e) {
				throw e;
			}
		}
		if (httpConnection != null) {
			httpConnection.disconnect();
		}
		return sb.toString();
	}

	public static String post2(String url, String method, String json, String code) {
		try {
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(connectionTimeOut);
			client.getHttpConnectionManager().getParams()
					.setSoTimeout(readTimeOut);
			HttpMethodBase methodBase = null;
			RequestEntity entiry = null;
			if (json != null) {
				entiry = new StringRequestEntity(new String(json.getBytes(),
						code));
			}
			if (method.equals(JavaNetURLRESTFullClient.DELETE)) {
				DeleteMethod delete = new DeleteMethod(url);
				methodBase = delete;
			} else if (method.equals(JavaNetURLRESTFullClient.GET)) {
				if (entiry == null) {
					GetMethod get = new GetMethod(url);
					// logger.info("json:"+new String(json.getBytes(),code));
					// get.setQueryString(new String(json.getBytes(),code));
					methodBase = get;
				} else {
					return post(url, method, json);
				}
			} else if (method.equals(JavaNetURLRESTFullClient.PUT)) {
				logger.info("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:::::::::"+url);
				PutMethod put = new PutMethod(url);
				methodBase = put;
				put.setRequestEntity(entiry);
			} else if (method.equals(JavaNetURLRESTFullClient.POST)) {
				PostMethod post = new PostMethod(url);
				methodBase = post;
				post.setRequestEntity(entiry);
			} else {
				return null;
			}
			methodBase.addRequestHeader("Content-Type",
					"application/json;charset=UTF-8");

			// postMethod
			// .addRequestHeader("User-Agent",
			// "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
			// postMethod.removeRequestHeader("Proxy-Connection");
			// postMethod.addRequestHeader("Connection", "Keep-Alive");
			// System.out.println(Arrays.toString(postMethod.getParameters()));
			// 使用POST方法
			// HttpMethod method = new PostMethod("http://java.sun.com");
			client.executeMethod(client.getHostConfiguration(), methodBase);
			InputStream is = methodBase.getResponseBodyAsStream();
			Header header = methodBase.getResponseHeader("Content-Encoding");
			InputStreamReader isr = null;
			GZIPInputStream gzin = null;
			boolean useGip = false;
			if (header == null) {
				isr = new InputStreamReader(is);
			} else {
				if (header.getValue().contains("gzip")) {
					useGip = true;
					gzin = new GZIPInputStream(is);
					isr = new InputStreamReader(gzin, code);
				}
			}
			java.io.BufferedReader br = new java.io.BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String tempbf;
			while ((tempbf = br.readLine()) != null) {
				sb.append(tempbf);
				sb.append("\r\n");
			}
			isr.close();
			if (useGip) {
				gzin.close();
			}
			// 释放连接
			methodBase.releaseConnection();
			logger.info("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbba:::::::::"+sb.toString());
			return sb.toString();
		} catch (ConnectTimeoutException e1) {
			e1.printStackTrace();
			return null;
		} catch (ConnectException e2) {
			e2.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static String post2(int connectionTimer,int readTimer,String url, String method, String json, String code) throws Exception{
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimer);
			client.getHttpConnectionManager().getParams().setSoTimeout(readTimer);
			HttpMethodBase methodBase = null;
			RequestEntity entiry = null;
			if (json != null) {
				entiry = new StringRequestEntity(new String(json.getBytes(),
						code));
			}
			if (method.equals(JavaNetURLRESTFullClient.DELETE)) {
				DeleteMethod delete = new DeleteMethod(url);
				methodBase = delete;
			} else if (method.equals(JavaNetURLRESTFullClient.GET)) {
				if (entiry == null) {
					GetMethod get = new GetMethod(url);
					// logger.info("json:"+new String(json.getBytes(),code));
					// get.setQueryString(new String(json.getBytes(),code));
					methodBase = get;
				} else {
					return post(url, method, json);
				}
			} else if (method.equals(JavaNetURLRESTFullClient.PUT)) {
				PutMethod put = new PutMethod(url);
				methodBase = put;
				put.setRequestEntity(entiry);
			} else if (method.equals(JavaNetURLRESTFullClient.POST)) {
				PostMethod post = new PostMethod(url);
				methodBase = post;
				post.setRequestEntity(entiry);
			} else {
				return null;
			}
			methodBase.addRequestHeader("Content-Type", "application/json;charset=UTF-8");

			// postMethod
			// .addRequestHeader("User-Agent",
			// "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
			// postMethod.removeRequestHeader("Proxy-Connection");
			// postMethod.addRequestHeader("Connection", "Keep-Alive");
			// System.out.println(Arrays.toString(postMethod.getParameters()));
			// 使用POST方法
			// HttpMethod method = new PostMethod("http://java.sun.com");
			client.executeMethod(client.getHostConfiguration(), methodBase);
			InputStream is = methodBase.getResponseBodyAsStream();
			Header header = methodBase.getResponseHeader("Content-Encoding");
			InputStreamReader isr = null;
			GZIPInputStream gzin = null;
			boolean useGip = false;
			if (header == null) {
				isr = new InputStreamReader(is);
			} else {
				if (header.getValue().contains("gzip")) {
					useGip = true;
					gzin = new GZIPInputStream(is);
					isr = new InputStreamReader(gzin, code);
				}
			}
			java.io.BufferedReader br = new java.io.BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String tempbf;
			while ((tempbf = br.readLine()) != null) {
				sb.append(tempbf);
				sb.append("\r\n");
			}
			isr.close();
			if (useGip) {
				gzin.close();
			}
			// 释放连接
			methodBase.releaseConnection();
			return sb.toString();
	}

	/**
	 * 判断rest的文档状态
	 * 
	 * @param str
	 * @return
	 */
	public static boolean suggestStatus(String str) {
		if (str == null) {
			return false;
		} else if (str.equals("")) {
			return false;
		}
		if (str.startsWith("{\"error\"")||str.contains("\\{\\{\"Exception\"") || str.contains("found\":false")) {
			logger.error("error data:" + str);
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(JavaNetURLRESTFullClient.brandTargetURL);
		// String json =
		// "{\"brand_demand\":{\"properties\":{\"bid\":{\"type\":\"integer\",\"store\":\"no\"},\"info\":{\"properties\":{\"country_code\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_name\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_name_en\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_desc\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_charact\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_product_desc\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_alias\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_ceo\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_ctime\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_created_year\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_created_year_cn\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_closed_date\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_founder\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_group\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_handbook\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_hq\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_hq_cn\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_is_listed\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_logo\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_stock\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_tel\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_website\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_website_cn\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_weibo\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_weixin\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"spider_channel_id\":{\"type\":\"integer\",\"store\":\"no\"},\"spider_channel_web_id\":{\"type\":\"long\",\"store\":\"no\"},\"brand_black_list\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_status\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_search_name\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_search_option\":{\"properties\":{\"baidu\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"news\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"}}},\"brand_search_keywords\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_has_contact\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_in_web\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_status_desc\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_combine_status\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"brand_passportNumTol\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_categorys\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_category_name\":{\"properties\":{\"cat1\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"cat2\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"cat3\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"}}},\"brand_demandCount\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_inChengTV\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_inRecommend\":{\"type\":\"integer\",\"store\":\"no\"},\"avg_dp_index\":{\"type\":\"double\",\"store\":\"no\"},\"avg_price\":{\"type\":\"double\",\"store\":\"no\"},\"size\":{\"properties\":{\"min\":{\"type\":\"integer\",\"store\":\"no\"},\"max\":{\"type\":\"integer\",\"store\":\"no\"}}},\"business_circle\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"mall\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"}}},\"infoScore\":{\"properties\":{\"demand_utime_val\":{\"type\":\"long\",\"store\":\"no\"},\"demand_show_mobile\":{\"type\":\"integer\",\"store\":\"no\"},\"demand_level\":{\"type\":\"integer\",\"store\":\"no\"}}},\"demand_ctime\":{\"type\":\"date\",\"format\":\"yyyy-MM-dd HH:mm:ss\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"demand_utime\":{\"type\":\"date\",\"format\":\"yyyy-MM-dd HH:mmm:ss\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"demand_expiry_at\":{\"type\":\"date\",\"format\":\"yyyy-MM-dd\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"passport_id\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_id\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_name\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"category_ids\":{\"type\":\"integer\",\"store\":\"no\"},\"brand_category_name\":{\"properties\":{\"cat1\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"cat2\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"cat3\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"}}},\"category_ids_other\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"area_id\":{\"type\":\"long\",\"store\":\"no\"},\"demand_desc\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"demand_show_mobile\":{\"type\":\"integer\",\"store\":\"no\"},\"demand_level\":{\"type\":\"integer\",\"store\":\"no\"},\"demand_status\":{\"type\":\"integer\",\"store\":\"no\"},\"demand_type\":{\"type\":\"integer\",\"store\":\"no\"},\"passport_type\":{\"type\":\"integer\",\"store\":\"no\"},\"passport_company\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"tag\":{\"properties\":{\"preferredProperty\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"shopType\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"shopSpecifications\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"termCooperation\":{\"type\":\"integer\",\"store\":\"no\"},\"areaDemand\":{\"properties\":{\"lower\":{\"type\":\"integer\",\"store\":\"no\"},\"upper\":{\"type\":\"integer\",\"store\":\"no\"}}},\"budgetRent\":{\"properties\":{\"lower\":{\"type\":\"integer\",\"store\":\"no\"},\"upper\":{\"type\":\"integer\",\"store\":\"no\"}}},\"shopArea\":{\"properties\":{\"lower\":{\"type\":\"long\",\"store\":\"no\"},\"upper\":{\"type\":\"long\",\"store\":\"no\"}}}}},\"demandId\":{\"type\":\"string\",\"index\":\"not_analyzed\",\"store\":\"no\"},\"demandType\":{\"type\":\"integer\",\"store\":\"no\"}}}}";
		// try {
		// System.out
		// .println(JavaNetURLRESTFullClient
		// .post("http://192.168.1.64:9200/search_demand_test/brand_demand/_mapping",
		// "POST", json));
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(new Date());
		// long startTime=System.currentTimeMillis();
		// int start=1;
		// int count=300;
		// for (int i = start; i < count; i++) {
		// String url=JavaNetURLRESTFulClient.targetURL+"mall/"+i;
		// PostBean bean=new PostBean(86007050,10000,0,10);
		// String code=JavaNetURLRESTFulClient.post(url,
		// JsonUtil.getJsonStr(bean));
		// //System.out.println(code);
		// }
		// start=10001;
		// count=30000;
		// for (int i = start; i < count; i++) {
		// String url=JavaNetURLRESTFulClient.targetURL+"brand/"+i;
		// PostBean bean=new PostBean(86007050,10000,0,10);
		// String code=JavaNetURLRESTFulClient.post(url,
		// JsonUtil.getJsonStr(bean));
		// //System.out.println(code);
		// }
		// long endTime=System.currentTimeMillis();
		// System.out.println(new Date());
		// System.out.println("总用时间:"+(endTime-startTime)*1d/1000+"秒");
		// System.out.println("平均一个时间:"+(endTime-startTime)*1d/(count-start)+"毫秒");
		// System.out.println("平均美秒处理:"+(count-start)*1d/(endTime-startTime)*1000+"个");
		System.out.println(JavaNetURLRESTFullClient.post2(InitServlet.targetURL+ "search_demand_test_2015-10-23", "PUT", null,"utf-8"));
		
		
		
		
		
	}
}