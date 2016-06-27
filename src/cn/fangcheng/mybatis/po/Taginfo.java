package cn.fangcheng.mybatis.po;

public class Taginfo {
    private int tagId;

    private String tagName;

    private Byte tagDeep;

    private int tagIdParent;

    private Byte tagType;

    private int tagGroupId;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Byte getTagDeep() {
        return tagDeep;
    }

    public void setTagDeep(Byte tagDeep) {
        this.tagDeep = tagDeep;
    }

    public int getTagIdParent() {
        return tagIdParent;
    }

    public void setTagIdParent(int tagIdParent) {
        this.tagIdParent = tagIdParent;
    }

    public Byte getTagType() {
        return tagType;
    }

    public void setTagType(Byte tagType) {
        this.tagType = tagType;
    }

    public int getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(int tagGroupId) {
        this.tagGroupId = tagGroupId;
    }
}