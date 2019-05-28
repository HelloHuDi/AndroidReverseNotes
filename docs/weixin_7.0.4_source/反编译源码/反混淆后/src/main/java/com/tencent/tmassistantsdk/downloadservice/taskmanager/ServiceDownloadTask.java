package com.tencent.tmassistantsdk.downloadservice.taskmanager;

public class ServiceDownloadTask {
    public String mClientKey = null;
    public long mProgressUpdateTimestamp = 0;
    public long mReceivedBytes = 0;
    public int mState = 0;
    public long mTotalBytes = 0;
    public String mUrl = null;

    public ServiceDownloadTask(String str, String str2) {
        this.mClientKey = str;
        this.mUrl = str2;
    }

    public boolean checkIsNeedUpdateProgress(long j, long j2, long j3) {
        if (j == j2) {
            this.mReceivedBytes = j;
            this.mTotalBytes = j2;
            this.mProgressUpdateTimestamp = j3;
            return true;
        } else if (j3 - this.mProgressUpdateTimestamp >= 1000 && j != this.mReceivedBytes) {
            this.mReceivedBytes = j;
            this.mTotalBytes = j2;
            this.mProgressUpdateTimestamp = j3;
            return true;
        } else if (j2 <= 0 || ((double) ((((((float) j) * 1.0f) - (((float) this.mReceivedBytes) * 1.0f)) / ((float) j2)) * 1.0f)) <= 0.009999999776482582d) {
            return false;
        } else {
            this.mReceivedBytes = j;
            this.mTotalBytes = j2;
            this.mProgressUpdateTimestamp = j3;
            return true;
        }
    }
}
