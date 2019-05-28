package com.tencent.qqmusic.mediaplayer.upstream;

public interface TransferListener {
    void onBytesTransferError(long j, long j2, long j3);

    void onBytesTransferred(long j, long j2);

    void onBytesTransferring(long j, long j2);

    void onTransferEnd();

    void onTransferStart();
}
