package com.tencent.p177mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI */
public final class MP4MuxerJNI {
    public static final int SEGMENT_COLOR_FORMAT_YUV420P = 2;
    public static final int SEGMENT_COLOR_FORMAT_YUV420SP = 1;
    private static final Object lock = new Object();

    public static native boolean ffmpegCheckIfReachEndTimestamp();

    public static native byte[] ffmpegGetNextVideoFrameData(byte[] bArr);

    public static native int ffmpegGetVideoHeight();

    public static native int ffmpegGetVideoWidth();

    public static native int ffmpegOpenAndSeekFile(String str, double d, double d2);

    public static native byte[] getVideoThumb(String str, int i, int i2);

    public static native int initDataBuf(int i);

    public static native int initH264Encoder(int i, int i2, float f, int i3, int i4, int i5, int i6, float f2);

    public static native int muxing(int i, int i2, int i3, int i4, int i5, String str, float f, byte[] bArr, int i6);

    public static native int muxingForX264(int i, int i2, int i3, int i4, String str, float f, int i5, byte[] bArr, int i6);

    public static native void releaseDataBuf(int i);

    public static native int triggerEncodeForSegment(int i, boolean z);

    public static native void writeAACData(int i, ByteBuffer byteBuffer, int i2);

    public static native void writeH264Data(int i, ByteBuffer byteBuffer, int i2);

    public static native int writeYuvDataForSegment(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void yuv420pTo420XXAndScale(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    static {
        AppMethodBeat.m2504i(117300);
        AppMethodBeat.m2505o(117300);
    }

    public static int initDataBufLock(int i) {
        int initDataBuf;
        AppMethodBeat.m2504i(117285);
        synchronized (lock) {
            try {
                initDataBuf = MP4MuxerJNI.initDataBuf(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117285);
            }
        }
        return initDataBuf;
    }

    public static void writeH264DataLock(int i, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.m2504i(117286);
        synchronized (lock) {
            try {
                MP4MuxerJNI.writeH264Data(i, byteBuffer, i2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117286);
            }
        }
    }

    public static void writeAACDataLock(int i, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.m2504i(117287);
        synchronized (lock) {
            try {
                MP4MuxerJNI.writeAACData(i, byteBuffer, i2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117287);
            }
        }
    }

    public static void releaseDataBufLock(int i) {
        AppMethodBeat.m2504i(117288);
        synchronized (lock) {
            try {
                MP4MuxerJNI.releaseDataBuf(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117288);
            }
        }
    }

    public static int muxingLock(int i, int i2, int i3, int i4, int i5, String str, float f, byte[] bArr, int i6) {
        int muxing;
        AppMethodBeat.m2504i(117289);
        synchronized (lock) {
            try {
                muxing = MP4MuxerJNI.muxing(i, i2, i3, i4, i5, str, f, bArr, i6);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117289);
            }
        }
        return muxing;
    }

    public static int initH264EncoderLock(int i, int i2, float f, int i3, int i4, int i5, int i6, float f2) {
        int initH264Encoder;
        AppMethodBeat.m2504i(117290);
        synchronized (lock) {
            try {
                initH264Encoder = MP4MuxerJNI.initH264Encoder(i, i2, f, i3, i4, i5, i6, f2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117290);
            }
        }
        return initH264Encoder;
    }

    public static int muxingForX264Lock(int i, int i2, int i3, int i4, String str, float f, int i5, byte[] bArr, int i6) {
        int muxingForX264;
        AppMethodBeat.m2504i(117291);
        synchronized (lock) {
            try {
                muxingForX264 = MP4MuxerJNI.muxingForX264(i, i2, i3, i4, str, f, i5, bArr, i6);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117291);
            }
        }
        return muxingForX264;
    }

    public static int writeYuvDataForSegmentLock(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int writeYuvDataForSegment;
        AppMethodBeat.m2504i(117292);
        synchronized (lock) {
            try {
                writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, i, i2, i3, i4, i5, i6, i7);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117292);
            }
        }
        return writeYuvDataForSegment;
    }

    public static void yuv420pTo420XXAndScaleLock(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.m2504i(117293);
        synchronized (lock) {
            try {
                MP4MuxerJNI.yuv420pTo420XXAndScale(bArr, i, bArr2, i2, i3, i4, i5, i6, i7, i8);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117293);
            }
        }
    }

    public static int triggerEncodeForSegmentLock(int i, boolean z) {
        int triggerEncodeForSegment;
        AppMethodBeat.m2504i(117294);
        synchronized (lock) {
            try {
                triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(i, z);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117294);
            }
        }
        return triggerEncodeForSegment;
    }

    public static int ffmpegOpenAndSeekFileLock(String str, double d, double d2) {
        int ffmpegOpenAndSeekFile;
        AppMethodBeat.m2504i(117295);
        synchronized (lock) {
            try {
                ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, d, d2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117295);
            }
        }
        return ffmpegOpenAndSeekFile;
    }

    public static byte[] ffmpegGetNextVideoFrameDataLock(byte[] bArr) {
        byte[] ffmpegGetNextVideoFrameData;
        AppMethodBeat.m2504i(117296);
        synchronized (lock) {
            try {
                ffmpegGetNextVideoFrameData = MP4MuxerJNI.ffmpegGetNextVideoFrameData(bArr);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117296);
            }
        }
        return ffmpegGetNextVideoFrameData;
    }

    public static boolean ffmpegCheckIfReachEndTimestampLock() {
        boolean ffmpegCheckIfReachEndTimestamp;
        AppMethodBeat.m2504i(117297);
        synchronized (lock) {
            try {
                ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117297);
            }
        }
        return ffmpegCheckIfReachEndTimestamp;
    }

    public static int ffmpegGetVideoWidthLock() {
        int ffmpegGetVideoWidth;
        AppMethodBeat.m2504i(117298);
        synchronized (lock) {
            try {
                ffmpegGetVideoWidth = MP4MuxerJNI.ffmpegGetVideoWidth();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117298);
            }
        }
        return ffmpegGetVideoWidth;
    }

    public static int ffmpegGetVideoHeightLock() {
        int ffmpegGetVideoHeight;
        AppMethodBeat.m2504i(117299);
        synchronized (lock) {
            try {
                ffmpegGetVideoHeight = MP4MuxerJNI.ffmpegGetVideoHeight();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117299);
            }
        }
        return ffmpegGetVideoHeight;
    }
}
