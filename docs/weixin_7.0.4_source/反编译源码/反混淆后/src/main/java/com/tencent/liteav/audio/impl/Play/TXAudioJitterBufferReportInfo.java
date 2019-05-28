package com.tencent.liteav.audio.impl.Play;

public class TXAudioJitterBufferReportInfo {
    public int mAvgCacheTime = 0;
    public int mIsRealTime = 0;
    public int mLoadCnt = 0;
    public int mLoadMaxTime = 0;
    public int mLoadTime = 0;
    public int mNoDataCnt = 0;
    public int mSpeedCnt = 0;
    public int mTimeDropCnt = 0;
    public long mTimeTotalCacheTime = 0;
    public long mTimeTotalCacheTimeCnt = 0;
    public int mTimeTotalJitt = 0;
    public int mTimeTotalJittCnt = 0;

    public void init() {
        this.mLoadTime = 0;
        this.mLoadCnt = 0;
        this.mLoadMaxTime = 0;
        this.mSpeedCnt = 0;
        this.mNoDataCnt = 0;
        this.mAvgCacheTime = 0;
        this.mIsRealTime = 0;
        this.mTimeTotalCacheTimeCnt = 0;
        this.mTimeTotalCacheTime = 0;
        this.mTimeTotalJitt = 0;
        this.mTimeTotalJittCnt = 0;
        this.mTimeDropCnt = 0;
    }
}
