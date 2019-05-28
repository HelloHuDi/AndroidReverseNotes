package com.tencent.matrix.mrs.core;

import com.tencent.p177mm.sdk.platformtools.C5046bo;

public class MatrixUploadIssue {
    public static final int DATA_TYPE_BYTE = 0;
    public static final int DATA_TYPE_FILE = 1;
    private byte[] byteData = null;
    private boolean canSplitSlice = false;
    private int dataType = 0;
    private String desKey = "";
    private String filePath = "";
    /* renamed from: id */
    private long f1215id = C5046bo.anU();
    private boolean needDeleteFileAfterSucc = false;
    private String tag = "";
    private int type = 0;

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getDesKey() {
        return this.desKey;
    }

    public void setDesKey(String str) {
        this.desKey = str;
    }

    public boolean getCanSplitSlice() {
        return this.canSplitSlice;
    }

    public void setCanSplitSlice(boolean z) {
        this.canSplitSlice = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public byte[] getByteData() {
        return this.byteData;
    }

    public void setByteData(byte[] bArr) {
        this.byteData = bArr;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public boolean isNeedDeleteFileAfterSucc() {
        return this.needDeleteFileAfterSucc;
    }

    public void setNeedDeleteFileAfterSucc(boolean z) {
        this.needDeleteFileAfterSucc = z;
    }

    public long getId() {
        return this.f1215id;
    }
}
