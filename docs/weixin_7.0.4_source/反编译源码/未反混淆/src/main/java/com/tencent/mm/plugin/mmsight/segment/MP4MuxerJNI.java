package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

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
        AppMethodBeat.i(117300);
        AppMethodBeat.o(117300);
    }

    public static int initDataBufLock(int i) {
        int initDataBuf;
        AppMethodBeat.i(117285);
        synchronized (lock) {
            try {
                initDataBuf = initDataBuf(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117285);
            }
        }
        return initDataBuf;
    }

    public static void writeH264DataLock(int i, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(117286);
        synchronized (lock) {
            try {
                writeH264Data(i, byteBuffer, i2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117286);
            }
        }
    }

    public static void writeAACDataLock(int i, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(117287);
        synchronized (lock) {
            try {
                writeAACData(i, byteBuffer, i2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117287);
            }
        }
    }

    public static void releaseDataBufLock(int i) {
        AppMethodBeat.i(117288);
        synchronized (lock) {
            try {
                releaseDataBuf(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117288);
            }
        }
    }

    public static int muxingLock(int i, int i2, int i3, int i4, int i5, String str, float f, byte[] bArr, int i6) {
        int muxing;
        AppMethodBeat.i(117289);
        synchronized (lock) {
            try {
                muxing = muxing(i, i2, i3, i4, i5, str, f, bArr, i6);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117289);
            }
        }
        return muxing;
    }

    public static int initH264EncoderLock(int i, int i2, float f, int i3, int i4, int i5, int i6, float f2) {
        int initH264Encoder;
        AppMethodBeat.i(117290);
        synchronized (lock) {
            try {
                initH264Encoder = initH264Encoder(i, i2, f, i3, i4, i5, i6, f2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117290);
            }
        }
        return initH264Encoder;
    }

    public static int muxingForX264Lock(int i, int i2, int i3, int i4, String str, float f, int i5, byte[] bArr, int i6) {
        int muxingForX264;
        AppMethodBeat.i(117291);
        synchronized (lock) {
            try {
                muxingForX264 = muxingForX264(i, i2, i3, i4, str, f, i5, bArr, i6);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117291);
            }
        }
        return muxingForX264;
    }

    public static int writeYuvDataForSegmentLock(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int writeYuvDataForSegment;
        AppMethodBeat.i(117292);
        synchronized (lock) {
            try {
                writeYuvDataForSegment = writeYuvDataForSegment(bArr, i, i2, i3, i4, i5, i6, i7);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117292);
            }
        }
        return writeYuvDataForSegment;
    }

    public static void yuv420pTo420XXAndScaleLock(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(117293);
        synchronized (lock) {
            try {
                yuv420pTo420XXAndScale(bArr, i, bArr2, i2, i3, i4, i5, i6, i7, i8);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117293);
            }
        }
    }

    public static int triggerEncodeForSegmentLock(int i, boolean z) {
        int triggerEncodeForSegment;
        AppMethodBeat.i(117294);
        synchronized (lock) {
            try {
                triggerEncodeForSegment = triggerEncodeForSegment(i, z);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117294);
            }
        }
        return triggerEncodeForSegment;
    }

    public static int ffmpegOpenAndSeekFileLock(String str, double d, double d2) {
        int ffmpegOpenAndSeekFile;
        AppMethodBeat.i(117295);
        synchronized (lock) {
            try {
                ffmpegOpenAndSeekFile = ffmpegOpenAndSeekFile(str, d, d2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117295);
            }
        }
        return ffmpegOpenAndSeekFile;
    }

    public static byte[] ffmpegGetNextVideoFrameDataLock(byte[] bArr) {
        byte[] ffmpegGetNextVideoFrameData;
        AppMethodBeat.i(117296);
        synchronized (lock) {
            try {
                ffmpegGetNextVideoFrameData = ffmpegGetNextVideoFrameData(bArr);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117296);
            }
        }
        return ffmpegGetNextVideoFrameData;
    }

    public static boolean ffmpegCheckIfReachEndTimestampLock() {
        boolean ffmpegCheckIfReachEndTimestamp;
        AppMethodBeat.i(117297);
        synchronized (lock) {
            try {
                ffmpegCheckIfReachEndTimestamp = ffmpegCheckIfReachEndTimestamp();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117297);
            }
        }
        return ffmpegCheckIfReachEndTimestamp;
    }

    public static int ffmpegGetVideoWidthLock() {
        int ffmpegGetVideoWidth;
        AppMethodBeat.i(117298);
        synchronized (lock) {
            try {
                ffmpegGetVideoWidth = ffmpegGetVideoWidth();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117298);
            }
        }
        return ffmpegGetVideoWidth;
    }

    public static int ffmpegGetVideoHeightLock() {
        int ffmpegGetVideoHeight;
        AppMethodBeat.i(117299);
        synchronized (lock) {
            try {
                ffmpegGetVideoHeight = ffmpegGetVideoHeight();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(117299);
            }
        }
        return ffmpegGetVideoHeight;
    }
}
