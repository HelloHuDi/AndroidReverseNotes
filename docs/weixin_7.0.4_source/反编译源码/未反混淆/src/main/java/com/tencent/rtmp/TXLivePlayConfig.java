package com.tencent.rtmp;

import java.util.Map;

public class TXLivePlayConfig {
    boolean mAutoAdjustCacheTime = true;
    boolean mAutoRotate = true;
    String mCacheFolderPath;
    float mCacheTime = 5.0f;
    int mConnectRetryCount = 3;
    int mConnectRetryInterval = 3;
    boolean mEnableAec = false;
    boolean mEnableMessage = false;
    boolean mEnableNearestIP = true;
    protected Map<String, String> mHeaders;
    float mMaxAutoAdjustCacheTime = 5.0f;
    int mMaxCacheItems;
    float mMinAutoAdjustCacheTime = 1.0f;
    int mRtmpChannelType = 0;
    int mVideoBlockThreshold = 800;

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public void setCacheTime(float f) {
        this.mCacheTime = f;
    }

    public void setAutoAdjustCacheTime(boolean z) {
        this.mAutoAdjustCacheTime = z;
    }

    public void setMaxAutoAdjustCacheTime(float f) {
        this.mMaxAutoAdjustCacheTime = f;
    }

    public void setMinAutoAdjustCacheTime(float f) {
        this.mMinAutoAdjustCacheTime = f;
    }

    public void setVideoBlockThreshold(int i) {
        this.mVideoBlockThreshold = i;
    }

    public void setConnectRetryCount(int i) {
        this.mConnectRetryCount = i;
    }

    public void setConnectRetryInterval(int i) {
        this.mConnectRetryInterval = i;
    }

    public void enableAEC(boolean z) {
        this.mEnableAec = z;
    }

    public void setEnableNearestIP(boolean z) {
        this.mEnableNearestIP = z;
    }

    public void setRtmpChannelType(int i) {
        this.mRtmpChannelType = i;
    }

    public void setCacheFolderPath(String str) {
        this.mCacheFolderPath = str;
    }

    public void setMaxCacheItems(int i) {
        this.mMaxCacheItems = i;
    }

    public void setEnableMessage(boolean z) {
        this.mEnableMessage = z;
    }
}
