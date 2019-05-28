package com.tencent.matrix.iocanary.core;

public final class IOIssue {
    public final long bufferSize;
    public final long fileSize;
    public final int opCnt;
    public final long opCostTime;
    public final long opSize;
    public final int opType;
    public final String path;
    public final int repeatReadCnt;
    public final String stack;
    public final String threadName;
    public final int type;

    public IOIssue(int i, String str, long j, int i2, long j2, long j3, int i3, long j4, String str2, String str3, int i4) {
        this.type = i;
        this.path = str;
        this.fileSize = j;
        this.opCnt = i2;
        this.bufferSize = j2;
        this.opCostTime = j3;
        this.opType = i3;
        this.opSize = j4;
        this.threadName = str2;
        this.stack = str3;
        this.repeatReadCnt = i4;
    }
}
