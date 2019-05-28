package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.SoNotFindException;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.List;

public abstract class BaseDecoder {
    private AudioType mAudioType = null;
    private final boolean mHasLoadSoSuccess = NativeLibs.loadAll(getNativeLibs());
    public int mNativeApeDecoderRef = 0;

    public abstract long getBytePositionOfTime(long j);

    public abstract List<NativeLibs> getNativeLibs();

    private void throwIfSoNotLoadSuccess() {
        if (!this.mHasLoadSoSuccess) {
            throw new SoNotFindException("has't load so success , can't call native funcation");
        }
    }

    public int init(String str, boolean z) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int init(IDataSource iDataSource) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int init(INativeDataSource iNativeDataSource) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public AudioInformation getAudioInformation() {
        throwIfSoNotLoadSuccess();
        return null;
    }

    public int decodeData(int i, byte[] bArr) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public long getCurrentTime() {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int seekTo(int i) {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int release() {
        throwIfSoNotLoadSuccess();
        return -1;
    }

    public int getErrorCodeMask() {
        return -1;
    }

    public AudioType getAudioType() {
        return this.mAudioType;
    }

    public void setAudioType(AudioType audioType) {
        this.mAudioType = audioType;
    }

    public long getDuration() {
        return -1;
    }

    public long getMinBufferSize() {
        return 0;
    }
}
