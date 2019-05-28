package com.tencent.ttpic.model;

public class VideoMaterialMetaData {
    public String id;
    public String path;
    public String thumbPath;
    public String url;

    public VideoMaterialMetaData(String str, String str2, String str3, String str4) {
        this.id = str;
        this.path = str2;
        this.url = str3;
        this.thumbPath = str4;
    }
}
