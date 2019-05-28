package com.tencent.p177mm.plugin.sight.base;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.tencent.mm.plugin.sight.base.SightVideoJNI */
public class SightVideoJNI {
    public static final int MMSIGHT_YUV420P = 2;
    public static final int MMSIGHT_YUV420SP = 1;
    private static final Object MMSightLock = new Object();
    private static final String TAG = "MicroMsg.SightVideoJNI";
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_SURFACE = 0;

    public static native void NV21ToYUV420P(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void NV21ToYUV420PAndRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void NV21ToYUV420PAndScaleRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, boolean z, int i6);

    public static native void NV21ToYUV420SP(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void NV21ToYUV420SPAndRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void NV21ToYUV420SPAndScaleRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, boolean z, int i6);

    public static native void NV21ToYUV420XXAndScaleRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2);

    public static native void YUV420SPScale(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4);

    public static native void YUV420SPScaleCtxRelease();

    public static native void blendYuvFrame(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void cropCameraData(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void cropCameraDataLongEdge(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native int drawFrame(int i, Bitmap bitmap, int i2, Bitmap bitmap2, boolean z, boolean z2);

    public static native int drawScaledFrame(int i, Bitmap bitmap, int i2, int i3);

    public static native int drawSurfaceColor(Surface surface, int i);

    public static native int drawSurfaceFrame(int i, Surface surface, int i2, Bitmap bitmap, boolean z);

    public static native int drawSurfaceThumb(Surface surface, Bitmap bitmap, Bitmap bitmap2);

    public static native int freeAll();

    public static native int freeObj(int i);

    public static native int[] getBlurThumbData(int i);

    public static native int[] getBlurThumbDataFromBmp(Bitmap bitmap);

    public static native int getHeight(int i);

    private static native byte[] getMP4RecordInfo(String str);

    public static native int getMp4Rotate(String str);

    public static native String getSimpleMp4Info(String str);

    public static native byte[] getThumbData(int i);

    public static native double getVideoDuration(int i);

    public static native int getVideoHeight(int i);

    public static native String getVideoInfo(int i);

    public static native double getVideoPlayTime(int i);

    public static native double getVideoRate(int i);

    public static native double getVideoStartTime(int i);

    public static native int getVideoWidth(int i);

    public static native int getWidth(int i);

    public static native int handleThumb(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3);

    public static native int initBlurBuffer(int i, int i2, int i3);

    public static native int initDataBuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11, float f2, int i12);

    public static native int initDataBufferForMMSight(int i, int i2, int i3, int i4, int i5, float f, int i6, int i7, int i8, int i9, float f2, boolean z, boolean z2, int i10, boolean z3);

    public static native int initDataBufferForRemux();

    public static native void initScaleAndRoateBuffer(int i);

    public static native int isSightOk(String str, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i);

    public static native byte[] loadAACData(int i);

    public static native void mirrorCameraData(byte[] bArr, int i, int i2, boolean z);

    public static native int muxing(int i, String str, int i2, int i3, int i4, int i5, long j, String str2, float f, int i6, int i7, int i8, int i9, int i10, float f2, byte[] bArr, int i11, boolean z, boolean z2);

    public static native int openFile(String str, int i, int i2, boolean z);

    public static native void optimizeMP4(String str);

    public static native void paddingYuvData16(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void registerALL();

    public static native void releaseBigSightDataBuffer(int i);

    public static native void releaseDataBuffer(int i);

    public static native int releaseRecorderBuffer();

    public static native void releaseScaleAndRoateBuffer(int i);

    public static native int remuxing(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, byte[] bArr, int i7, boolean z);

    public static native void rgbaToNV21(int[] iArr, byte[] bArr, int i, int i2);

    public static native int seekStream(double d, int i);

    public static native int seekStreamWithFlag(double d, int i, int i2);

    public static native void setRotateForBufId(int i, int i2);

    public static native int shouldRemuxing(String str, int i, int i2, int i3, double d, int i4);

    private static native void tagMP4Dscp(String str, byte[] bArr, int i);

    private static native void tagMP4RecordInfo(String str, byte[] bArr, int i);

    public static native int tagRotateVideo(String str, String str2, int i);

    public static native int triggerEncode(int i, int i2, boolean z);

    public static native int triggerEncodeForBigSight(int i, int i2, int i3);

    public static native void writeAACData(int i, ByteBuffer byteBuffer, int i2);

    public static native void writeBlurData(int i, byte[] bArr, int i2, int i3, int i4);

    public static native void writeH264Data(int i, ByteBuffer byteBuffer, int i2);

    public static native void writeThumbData(int i, byte[] bArr, int i2, int i3, int i4);

    public static native void writeYuvData(int i, byte[] bArr, int i2, int i3, int i4);

    public static native void writeYuvDataForMMSight(int i, byte[] bArr, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6);

    static {
        AppMethodBeat.m2504i(117325);
        AppMethodBeat.m2505o(117325);
    }

    public static int initDataBufferForMMSightLock(int i, int i2, int i3, int i4, int i5, float f, int i6, int i7, int i8, int i9, float f2, boolean z, boolean z2, int i10, boolean z3) {
        int initDataBufferForMMSight;
        AppMethodBeat.m2504i(117313);
        synchronized (MMSightLock) {
            try {
                initDataBufferForMMSight = SightVideoJNI.initDataBufferForMMSight(i, i2, i3, i4, i5, f, i6, i7, i8, i9, f2, z, z2, i10, z3);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117313);
            }
        }
        return initDataBufferForMMSight;
    }

    public static void releaseBigSightDataBufferLock(int i) {
        AppMethodBeat.m2504i(117314);
        synchronized (MMSightLock) {
            try {
                SightVideoJNI.releaseBigSightDataBuffer(i);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117314);
            }
        }
    }

    public static int initDataBufferRef(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11, float f2, int i12) {
        AppMethodBeat.m2504i(117315);
        C4990ab.m7411d(TAG, "ashutest::call initDataBuffer, ret %d", Integer.valueOf(SightVideoJNI.initDataBuffer(i, i2, i3, i4, i5, i6, i7, f, i8, i9, i10, i11, f2, i12)));
        AppMethodBeat.m2505o(117315);
        return SightVideoJNI.initDataBuffer(i, i2, i3, i4, i5, i6, i7, f, i8, i9, i10, i11, f2, i12);
    }

    public static void releaseRecorderBufferRef(String str) {
        AppMethodBeat.m2504i(117316);
        C4990ab.m7411d(TAG, "ashutest::call release recorder buffer, %s", str);
        SightVideoJNI.releaseRecorderBuffer();
        AppMethodBeat.m2505o(117316);
    }

    public static void releaseDataBufferRef(int i) {
        AppMethodBeat.m2504i(117317);
        C4990ab.m7411d(TAG, "ashutest::call release dataBufferRef %d", Integer.valueOf(i));
        SightVideoJNI.releaseDataBuffer(i);
        AppMethodBeat.m2505o(117317);
    }

    public static void writeAACDataLock(int i, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.m2504i(117318);
        synchronized (MMSightLock) {
            try {
                SightVideoJNI.writeAACData(i, byteBuffer, i2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117318);
            }
        }
    }

    public static void writeYuvDataForMMSightLock(int i, byte[] bArr, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
        AppMethodBeat.m2504i(117319);
        synchronized (MMSightLock) {
            try {
                SightVideoJNI.writeYuvDataForMMSight(i, bArr, i2, i3, i4, z, z2, i5, i6);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117319);
            }
        }
    }

    public static void writeH264DataLock(int i, ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.m2504i(117320);
        synchronized (MMSightLock) {
            try {
                SightVideoJNI.writeH264Data(i, byteBuffer, i2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117320);
            }
        }
    }

    public static int muxingLock(int i, String str, int i2, int i3, int i4, int i5, long j, String str2, float f, int i6, int i7, int i8, int i9, int i10, float f2, byte[] bArr, int i11, boolean z, boolean z2) {
        int muxing;
        AppMethodBeat.m2504i(117321);
        synchronized (MMSightLock) {
            try {
                muxing = SightVideoJNI.muxing(i, str, i2, i3, i4, i5, j, str2, f, i6, i7, i8, i9, i10, f2, bArr, i11, z, z2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(117321);
            }
        }
        return muxing;
    }

    public static void tagMp4RecordInfo(String str, String str2) {
        AppMethodBeat.m2504i(117322);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(117322);
            return;
        }
        long yz = C5046bo.m7588yz();
        byte[] bArr = new byte[]{(byte) 85, (byte) -60};
        byte[] bytes = str2.getBytes();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length + 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(bArr);
        allocateDirect.put(bytes);
        bArr = allocateDirect.array();
        SightVideoJNI.tagMP4RecordInfo(str, bArr, bArr.length);
        C4990ab.m7417i(TAG, "tagMP4RecordInfo used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(117322);
    }

    public static String getMp4RecordInfo(String str) {
        AppMethodBeat.m2504i(117323);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(117323);
            return null;
        }
        byte[] mP4RecordInfo = SightVideoJNI.getMP4RecordInfo(str);
        if (mP4RecordInfo != null && mP4RecordInfo.length > 0) {
            int i = 0;
            while (i < mP4RecordInfo.length) {
                if (mP4RecordInfo[i] == (byte) -60) {
                    break;
                }
                i++;
            }
            i = 0;
            C4990ab.m7417i(TAG, "getMp4RecordInfo, index: %s", Integer.valueOf(i));
            if (i + 1 < mP4RecordInfo.length) {
                try {
                    byte[] bArr = new byte[(mP4RecordInfo.length - (i + 1))];
                    System.arraycopy(mP4RecordInfo, i + 1, bArr, 0, bArr.length);
                    String str2 = new String(bArr);
                    AppMethodBeat.m2505o(117323);
                    return str2;
                } catch (Exception e) {
                }
            }
        }
        AppMethodBeat.m2505o(117323);
        return null;
    }

    public static void tagMP4Dscp(String str, byte[] bArr) {
        AppMethodBeat.m2504i(117324);
        if (C5046bo.isNullOrNil(str) || bArr == null) {
            AppMethodBeat.m2505o(117324);
            return;
        }
        long yz = C5046bo.m7588yz();
        byte[] bArr2 = new byte[]{(byte) 85, (byte) -60};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length + 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(bArr2);
        allocateDirect.put(bArr);
        bArr2 = allocateDirect.array();
        SightVideoJNI.tagMP4Dscp(str, bArr2, bArr2.length);
        C4990ab.m7417i(TAG, "tagMP4Dscp used %sms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(117324);
    }
}
