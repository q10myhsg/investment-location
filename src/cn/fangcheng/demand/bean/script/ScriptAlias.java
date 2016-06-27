package cn.fangcheng.demand.bean.script;

import java.util.ArrayList;
import java.util.List;

import cn.fangcheng.demand.servlet.InitServlet;
import cn.fangcheng.demand.tool.JsonUtil;

/**
 * 别名处理方法
 * 
 * @author Administrator
 *
 */
public class ScriptAlias {

	public List<Object> actions = null;

	public ScriptAlias(List<Object> actions) {
		this.actions = actions;
	}

	public List<Object> getActions() {
		return actions;
	}

	public void setActions(List<Object> actions) {
		this.actions = actions;
	}

	public static class Remove {
		public Alias remove = null;

		public Remove(Alias remove) {
			this.remove = remove;
		}

		public Alias getRemove() {
			return remove;
		}

		public void setRemove(Alias remove) {
			this.remove = remove;
		}

	};

	public static class Add {
		public Alias add = null;

		public Add(Alias add) {
			this.add = add;
		}

		public Alias getAdd() {
			return add;
		}

		public void setAdd(Alias add) {
			this.add = add;
		}

	};

	public static class Alias {
		String index;
		String alias;

		public Alias(String index, String alias) {
			this.index = index;
			this.alias = alias;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}

	};

	/**
	 * 获取对应的别名修改方法
	 * 
	 * @param index
	 *            使用的索引别名
	 * @param oldStr
	 *            目前在使用的名字
	 * @param newStr
	 *            需求变更成的名字
	 * @return
	 */
	public static String getAction(String index, String oldStr, String newStr) {
		Alias remove = null;
		if (oldStr != null) {
			remove = new Alias(oldStr, index);
		}
		Alias add = new Alias(newStr, index);
		ArrayList<Object> list = new ArrayList<Object>();
		if (remove != null) {
			list.add(new Remove(remove));
		}
		list.add(new Add(add));
		ScriptAlias al = new ScriptAlias(list);
		return JsonUtil.getJsonStr(al);

	}
	public static void main(String[] args) {
		String aliasAction = ScriptAlias.getAction(InitServlet.indexTarget,"aaaaaaold", "bbbbnew");
		System.out.println(aliasAction);
	}
	
}
