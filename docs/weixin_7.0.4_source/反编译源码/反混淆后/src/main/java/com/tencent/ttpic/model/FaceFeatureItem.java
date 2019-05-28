package com.tencent.ttpic.model;

import java.util.List;

public class FaceFeatureItem {
    private String dataPath;
    private List<DistortionItem> distortionItemList;
    private List<FaceItem> faceOffItemList;
    /* renamed from: id */
    private String f4884id;
    private int maskAnchorPoint;
    private List<StickerItem> stickerItems;

    public String getId() {
        return this.f4884id;
    }

    public void setId(String str) {
        this.f4884id = str;
    }

    public void setDataPath(String str) {
        this.dataPath = str;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public void setMaskAnchorPoint(int i) {
        this.maskAnchorPoint = i;
    }

    public int getMaskAnchorPoint() {
        return this.maskAnchorPoint;
    }

    public List<DistortionItem> getDistortionItemList() {
        return this.distortionItemList;
    }

    public void setDistortionItemList(List<DistortionItem> list) {
        this.distortionItemList = list;
    }

    public List<FaceItem> getFaceOffItemList() {
        return this.faceOffItemList;
    }

    public void setFaceOffItemList(List<FaceItem> list) {
        this.faceOffItemList = list;
    }

    public List<StickerItem> getStickerItems() {
        return this.stickerItems;
    }

    public void setStickerItems(List<StickerItem> list) {
        this.stickerItems = list;
    }
}
