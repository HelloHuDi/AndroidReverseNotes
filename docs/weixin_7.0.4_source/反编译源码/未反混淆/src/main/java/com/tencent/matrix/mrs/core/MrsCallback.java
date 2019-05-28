package com.tencent.matrix.mrs.core;

public interface MrsCallback {
    String getCryptKey(MatrixUploadDataSlice matrixUploadDataSlice);

    String getHost(MatrixUploadDataSlice matrixUploadDataSlice);

    String getPublicSharePath();

    String getUrl(MatrixUploadDataSlice matrixUploadDataSlice);

    boolean onRequestGetMrsStrategy(byte[] bArr);

    void onStrategyNotify(String str, boolean z);
}
