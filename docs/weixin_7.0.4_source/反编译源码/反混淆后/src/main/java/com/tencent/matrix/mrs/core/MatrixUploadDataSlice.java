package com.tencent.matrix.mrs.core;

public class MatrixUploadDataSlice {
    private long endPos = 0;
    private int packageIndex = 0;
    private long startPos = 0;
    private int totalPackage = 1;
    private MatrixUploadIssue uploadIssue = null;

    public long getDataSize() {
        return this.endPos - this.startPos;
    }

    public long getStartPos() {
        return this.startPos;
    }

    public void setStartPos(long j) {
        this.startPos = j;
    }

    public long getEndPos() {
        return this.endPos;
    }

    public int getPackageIndex() {
        return this.packageIndex;
    }

    public int getTotalPackage() {
        return this.totalPackage;
    }

    public MatrixUploadIssue getUploadIssue() {
        return this.uploadIssue;
    }
}
