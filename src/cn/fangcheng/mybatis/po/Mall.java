package cn.fangcheng.mybatis.po;

import java.util.Date;

public class Mall {
    private int mallId;

    private String mallName;

    private String mallDesc;

    private Date mallCtime;

    private Date mallOpeningDate;

    private Date mallClosedDate;

    private int areaId;

    private int districtId;

    private String mallAddress;

    private int mallBuildingSize;

    private int mallBusinessSize;

    private String mallCoverArea;

    private String developerName;

    private int mallFloorSize;

    private String mallHandbook;

    private int mallLongitude;

    private int mallLatitude;

    private String mallLogo;

    private int mallParking;

    private String mallPropertyCompany;

    private int mallRentSize;

    private String mallTel;

    private String mallType;

    private Byte mallUnderFloor;

    private Byte mallUpperFloor;

    private String mallWebsite;

    private String mallWeibo;

    private String mallWeixin;

    private int spiderChannelId;

    private int spiderChannelWebId;

    private int spiderChannelHot;

    private int spiderChannelHotOld;

    private int spiderChannelHotUp;

    private String mallSearchName;

    private String mallBaikeUrl;

    private Byte mallInWeb;

    private String weekdayHours;

    private String weekendHours;

    private int businessCircleId;

    private int companyId;

    private Byte mallHasContact;

    private String mallSearchOption;

    private String mallSearchKeywords;

    private Byte mallStatus;

    private Byte mallCombineStatus;
    
    private MallData malldata;
    
    public MallData getMalldata() {
		return malldata;
	}

	public void setMalldata(MallData malldata) {
		this.malldata = malldata;
	}

	public int getMallId() {
        return mallId;
    }

    public void setMallId(int mallId) {
        this.mallId = mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName == null ? null : mallName.trim();
    }

    public String getMallDesc() {
        return mallDesc;
    }

    public void setMallDesc(String mallDesc) {
        this.mallDesc = mallDesc == null ? null : mallDesc.trim();
    }

    public Date getMallCtime() {
        return mallCtime;
    }

    public void setMallCtime(Date mallCtime) {
        this.mallCtime = mallCtime;
    }

    public Date getMallOpeningDate() {
        return mallOpeningDate;
    }

    public void setMallOpeningDate(Date mallOpeningDate) {
        this.mallOpeningDate = mallOpeningDate;
    }

    public Date getMallClosedDate() {
        return mallClosedDate;
    }

    public void setMallClosedDate(Date mallClosedDate) {
        this.mallClosedDate = mallClosedDate;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getMallAddress() {
        return mallAddress;
    }

    public void setMallAddress(String mallAddress) {
        this.mallAddress = mallAddress == null ? null : mallAddress.trim();
    }

    public int getMallBuildingSize() {
        return mallBuildingSize;
    }

    public void setMallBuildingSize(int mallBuildingSize) {
        this.mallBuildingSize = mallBuildingSize;
    }

    public int getMallBusinessSize() {
        return mallBusinessSize;
    }

    public void setMallBusinessSize(int mallBusinessSize) {
        this.mallBusinessSize = mallBusinessSize;
    }

    public String getMallCoverArea() {
        return mallCoverArea;
    }

    public void setMallCoverArea(String mallCoverArea) {
        this.mallCoverArea = mallCoverArea == null ? null : mallCoverArea.trim();
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName == null ? null : developerName.trim();
    }

    public int getMallFloorSize() {
        return mallFloorSize;
    }

    public void setMallFloorSize(int mallFloorSize) {
        this.mallFloorSize = mallFloorSize;
    }

    public String getMallHandbook() {
        return mallHandbook;
    }

    public void setMallHandbook(String mallHandbook) {
        this.mallHandbook = mallHandbook == null ? null : mallHandbook.trim();
    }

    public int getMallLongitude() {
        return mallLongitude;
    }

    public void setMallLongitude(int mallLongitude) {
        this.mallLongitude = mallLongitude;
    }

    public int getMallLatitude() {
        return mallLatitude;
    }

    public void setMallLatitude(int mallLatitude) {
        this.mallLatitude = mallLatitude;
    }

    public String getMallLogo() {
        return mallLogo;
    }

    public void setMallLogo(String mallLogo) {
        this.mallLogo = mallLogo == null ? null : mallLogo.trim();
    }

    public int getMallParking() {
        return mallParking;
    }

    public void setMallParking(int mallParking) {
        this.mallParking = mallParking;
    }

    public String getMallPropertyCompany() {
        return mallPropertyCompany;
    }

    public void setMallPropertyCompany(String mallPropertyCompany) {
        this.mallPropertyCompany = mallPropertyCompany == null ? null : mallPropertyCompany.trim();
    }

    public int getMallRentSize() {
        return mallRentSize;
    }

    public void setMallRentSize(int mallRentSize) {
        this.mallRentSize = mallRentSize;
    }

    public String getMallTel() {
        return mallTel;
    }

    public void setMallTel(String mallTel) {
        this.mallTel = mallTel == null ? null : mallTel.trim();
    }

    public String getMallType() {
        return mallType;
    }

    public void setMallType(String mallType) {
        this.mallType = mallType == null ? null : mallType.trim();
    }

    public Byte getMallUnderFloor() {
        return mallUnderFloor;
    }

    public void setMallUnderFloor(Byte mallUnderFloor) {
        this.mallUnderFloor = mallUnderFloor;
    }

    public Byte getMallUpperFloor() {
        return mallUpperFloor;
    }

    public void setMallUpperFloor(Byte mallUpperFloor) {
        this.mallUpperFloor = mallUpperFloor;
    }

    public String getMallWebsite() {
        return mallWebsite;
    }

    public void setMallWebsite(String mallWebsite) {
        this.mallWebsite = mallWebsite == null ? null : mallWebsite.trim();
    }

    public String getMallWeibo() {
        return mallWeibo;
    }

    public void setMallWeibo(String mallWeibo) {
        this.mallWeibo = mallWeibo == null ? null : mallWeibo.trim();
    }

    public String getMallWeixin() {
        return mallWeixin;
    }

    public void setMallWeixin(String mallWeixin) {
        this.mallWeixin = mallWeixin == null ? null : mallWeixin.trim();
    }

    public int getSpiderChannelId() {
        return spiderChannelId;
    }

    public void setSpiderChannelId(int spiderChannelId) {
        this.spiderChannelId = spiderChannelId;
    }

    public int getSpiderChannelWebId() {
        return spiderChannelWebId;
    }

    public void setSpiderChannelWebId(int spiderChannelWebId) {
        this.spiderChannelWebId = spiderChannelWebId;
    }

    public int getSpiderChannelHot() {
        return spiderChannelHot;
    }

    public void setSpiderChannelHot(int spiderChannelHot) {
        this.spiderChannelHot = spiderChannelHot;
    }

    public int getSpiderChannelHotOld() {
        return spiderChannelHotOld;
    }

    public void setSpiderChannelHotOld(int spiderChannelHotOld) {
        this.spiderChannelHotOld = spiderChannelHotOld;
    }

    public int getSpiderChannelHotUp() {
        return spiderChannelHotUp;
    }

    public void setSpiderChannelHotUp(int spiderChannelHotUp) {
        this.spiderChannelHotUp = spiderChannelHotUp;
    }

    public String getMallSearchName() {
        return mallSearchName;
    }

    public void setMallSearchName(String mallSearchName) {
        this.mallSearchName = mallSearchName == null ? null : mallSearchName.trim();
    }

    public String getMallBaikeUrl() {
        return mallBaikeUrl;
    }

    public void setMallBaikeUrl(String mallBaikeUrl) {
        this.mallBaikeUrl = mallBaikeUrl == null ? null : mallBaikeUrl.trim();
    }

    public Byte getMallInWeb() {
        return mallInWeb;
    }

    public void setMallInWeb(Byte mallInWeb) {
        this.mallInWeb = mallInWeb;
    }

    public String getWeekdayHours() {
        return weekdayHours;
    }

    public void setWeekdayHours(String weekdayHours) {
        this.weekdayHours = weekdayHours == null ? null : weekdayHours.trim();
    }

    public String getWeekendHours() {
        return weekendHours;
    }

    public void setWeekendHours(String weekendHours) {
        this.weekendHours = weekendHours == null ? null : weekendHours.trim();
    }

    public int getBusinessCircleId() {
        return businessCircleId;
    }

    public void setBusinessCircleId(int businessCircleId) {
        this.businessCircleId = businessCircleId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Byte getMallHasContact() {
        return mallHasContact;
    }

    public void setMallHasContact(Byte mallHasContact) {
        this.mallHasContact = mallHasContact;
    }

    public String getMallSearchOption() {
        return mallSearchOption;
    }

    public void setMallSearchOption(String mallSearchOption) {
        this.mallSearchOption = mallSearchOption == null ? null : mallSearchOption.trim();
    }

    public String getMallSearchKeywords() {
        return mallSearchKeywords;
    }

    public void setMallSearchKeywords(String mallSearchKeywords) {
        this.mallSearchKeywords = mallSearchKeywords == null ? null : mallSearchKeywords.trim();
    }

    public Byte getMallStatus() {
        return mallStatus;
    }

    public void setMallStatus(Byte mallStatus) {
        this.mallStatus = mallStatus;
    }

    public Byte getMallCombineStatus() {
        return mallCombineStatus;
    }

    public void setMallCombineStatus(Byte mallCombineStatus) {
        this.mallCombineStatus = mallCombineStatus;
    }
}