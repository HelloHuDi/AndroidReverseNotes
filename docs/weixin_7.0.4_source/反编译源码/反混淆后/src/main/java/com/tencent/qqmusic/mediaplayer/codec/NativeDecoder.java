package com.tencent.qqmusic.mediaplayer.codec;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NativeDecoder extends BaseDecoder {
    private static final String TAG = "NativeDecoder";
    private long mNativePointer = 0;
    private final ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();

    private native int nativeDecode(long j, byte[] bArr, int i, int i2);

    private native AudioInformation nativeGetAudioInformation(long j);

    private native long nativeGetBytePositionOfTime(long j, long j2);

    private native long nativeGetCurrentPosition(long j);

    private native int nativeGetDetailErrorCode(long j);

    private native String nativeGetDetailErrorDescription(long j);

    private native long nativeGetDuration(long j);

    private native long nativeGetMinBufferSize(long j);

    private native long[] nativeInit(long j);

    private native long[] nativeInit(IDataSource iDataSource);

    private native int nativeRelease(long j);

    private native long nativeSeekTo(long j, long j2);

    public NativeDecoder() {
        AppMethodBeat.m2504i(128552);
        AppMethodBeat.m2505o(128552);
    }

    public int init(IDataSource iDataSource) {
        AppMethodBeat.m2504i(128553);
        this.mReadWriteLock.writeLock().lock();
        try {
            long[] nativeInit = nativeInit(iDataSource);
            long j = -1;
            if (nativeInit != null && nativeInit.length >= 2) {
                this.mNativePointer = nativeInit[0];
                j = nativeInit[1];
            }
            int i = (int) j;
            this.mReadWriteLock.writeLock().unlock();
            AppMethodBeat.m2505o(128553);
            return i;
        } catch (Throwable th) {
            this.mReadWriteLock.writeLock().unlock();
            AppMethodBeat.m2505o(128553);
        }
    }

    public int init(INativeDataSource iNativeDataSource) {
        AppMethodBeat.m2504i(128554);
        this.mReadWriteLock.writeLock().lock();
        long j = -1;
        if (iNativeDataSource != null) {
            try {
                long[] nativeInit = nativeInit(iNativeDataSource.getNativeInstance());
                if (nativeInit != null && nativeInit.length >= 2) {
                    this.mNativePointer = nativeInit[0];
                    j = nativeInit[1];
                }
            } catch (Throwable th) {
                this.mReadWriteLock.writeLock().unlock();
                AppMethodBeat.m2505o(128554);
            }
        }
        int i = (int) j;
        this.mReadWriteLock.writeLock().unlock();
        AppMethodBeat.m2505o(128554);
        return i;
    }

    public int init(String str, boolean z) {
        AppMethodBeat.m2504i(128555);
        int init = init(new FileDataSource(str));
        AppMethodBeat.m2505o(128555);
        return init;
    }

    public int decodeData(int i, byte[] bArr) {
        AppMethodBeat.m2504i(128556);
        this.mReadWriteLock.readLock().lock();
        try {
            int nativeDecode = nativeDecode(this.mNativePointer, bArr, 0, i);
            return nativeDecode;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128556);
        }
    }

    public int seekTo(int i) {
        AppMethodBeat.m2504i(128557);
        this.mReadWriteLock.readLock().lock();
        try {
            int nativeSeekTo = (int) nativeSeekTo(this.mNativePointer, (long) i);
            return nativeSeekTo;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128557);
        }
    }

    public long getCurrentTime() {
        AppMethodBeat.m2504i(128558);
        this.mReadWriteLock.readLock().lock();
        try {
            long nativeGetCurrentPosition = nativeGetCurrentPosition(this.mNativePointer);
            return nativeGetCurrentPosition;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128558);
        }
    }

    public long getDuration() {
        AppMethodBeat.m2504i(128559);
        this.mReadWriteLock.readLock().lock();
        try {
            long nativeGetDuration = nativeGetDuration(this.mNativePointer);
            return nativeGetDuration;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128559);
        }
    }

    public AudioInformation getAudioInformation() {
        AppMethodBeat.m2504i(128560);
        this.mReadWriteLock.readLock().lock();
        try {
            AudioInformation nativeGetAudioInformation = nativeGetAudioInformation(this.mNativePointer);
            return nativeGetAudioInformation;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128560);
        }
    }

    public int release() {
        AppMethodBeat.m2504i(128561);
        this.mReadWriteLock.writeLock().lock();
        try {
            int nativeRelease = nativeRelease(this.mNativePointer);
            this.mNativePointer = 0;
            return nativeRelease;
        } finally {
            this.mReadWriteLock.writeLock().unlock();
            AppMethodBeat.m2505o(128561);
        }
    }

    public long getMinBufferSize() {
        AppMethodBeat.m2504i(128562);
        this.mReadWriteLock.readLock().lock();
        try {
            long nativeGetMinBufferSize = nativeGetMinBufferSize(this.mNativePointer);
            return nativeGetMinBufferSize;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128562);
        }
    }

    public long getBytePositionOfTime(long j) {
        AppMethodBeat.m2504i(128563);
        this.mReadWriteLock.readLock().lock();
        try {
            long nativeGetBytePositionOfTime = nativeGetBytePositionOfTime(this.mNativePointer, j);
            return nativeGetBytePositionOfTime;
        } finally {
            this.mReadWriteLock.readLock().unlock();
            AppMethodBeat.m2505o(128563);
        }
    }

    public int getErrorCodeMask() {
        return -1;
    }

    /* Access modifiers changed, original: protected */
    public List<NativeLibs> getNativeLibs() {
        AppMethodBeat.m2504i(128564);
        List asList = Arrays.asList(new NativeLibs[]{NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg});
        AppMethodBeat.m2505o(128564);
        return asList;
    }
}
