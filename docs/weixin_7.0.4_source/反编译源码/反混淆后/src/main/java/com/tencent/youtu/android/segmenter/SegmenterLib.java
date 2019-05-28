package com.tencent.youtu.android.segmenter;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.manager.FeatureManager;

public class SegmenterLib {
    private static boolean sLoadOpenclSuccess;
    private int mErrorCode = 0;
    private int mErrorType = 0;
    private long nativePtr;

    private native boolean getGPUSupportOpenCL();

    private native int getInitErrorCode();

    private native int getInitErrorType();

    private native boolean initWithProto(String str, String str2);

    public native void clearSegmentBuffer();

    public native int compileKernel();

    public native int copyBufferToTexture(int i, int i2, int i3);

    public native int copyTextureToBuffer(int i, int i2, int i3);

    public native void destroy();

    public native Bitmap segment(Bitmap bitmap);

    public native void segmentOnBit(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4);

    public native void segmentOnBitmap(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, int i4);

    public native int segmentOnTexture(int i, int i2, int i3, int i4, boolean z, int i5, int i6);

    public native int segmentOnTextureV2(int i, int i2, int i3, int i4);

    static {
        AppMethodBeat.m2504i(84507);
        sLoadOpenclSuccess = false;
        if (FeatureManager.isSegmentationReady()) {
            try {
                System.loadLibrary("YTCommon");
                System.loadLibrary("nnpack");
                if (FabbyManager.sChooseGPU_Segment) {
                    FeatureManager.loadLibrary("segmentero");
                    sLoadOpenclSuccess = true;
                } else {
                    FeatureManager.loadLibrary("segmentern");
                    sLoadOpenclSuccess = false;
                }
                if (!sLoadOpenclSuccess && FabbyManager.sChooseGPU_Segment) {
                    try {
                        FeatureManager.loadLibrary("segmentern");
                        AppMethodBeat.m2505o(84507);
                        return;
                    } catch (Exception e) {
                        LogUtils.m50206e(e);
                        AppMethodBeat.m2505o(84507);
                        return;
                    }
                }
            } catch (UnsatisfiedLinkError e2) {
                LogUtils.m50206e(e2);
                if (!sLoadOpenclSuccess && FabbyManager.sChooseGPU_Segment) {
                    try {
                        FeatureManager.loadLibrary("segmentern");
                        AppMethodBeat.m2505o(84507);
                        return;
                    } catch (Exception e3) {
                        LogUtils.m50206e(e3);
                        AppMethodBeat.m2505o(84507);
                        return;
                    }
                }
            } catch (RuntimeException e4) {
                LogUtils.m50206e(e4);
                if (!sLoadOpenclSuccess && FabbyManager.sChooseGPU_Segment) {
                    try {
                        FeatureManager.loadLibrary("segmentern");
                        AppMethodBeat.m2505o(84507);
                        return;
                    } catch (Exception e32) {
                        LogUtils.m50206e(e32);
                        AppMethodBeat.m2505o(84507);
                        return;
                    }
                }
            } catch (Exception e322) {
                LogUtils.m50206e(e322);
                if (!sLoadOpenclSuccess && FabbyManager.sChooseGPU_Segment) {
                    try {
                        FeatureManager.loadLibrary("segmentern");
                        AppMethodBeat.m2505o(84507);
                        return;
                    } catch (Exception e3222) {
                        LogUtils.m50206e(e3222);
                        AppMethodBeat.m2505o(84507);
                        return;
                    }
                }
            } catch (Throwable th) {
                if (!sLoadOpenclSuccess && FabbyManager.sChooseGPU_Segment) {
                    try {
                        FeatureManager.loadLibrary("segmentern");
                    } catch (Exception e5) {
                        LogUtils.m50206e(e5);
                    }
                }
                AppMethodBeat.m2505o(84507);
            }
        }
        AppMethodBeat.m2505o(84507);
    }

    public void setNativePtr(long j) {
        this.nativePtr = j;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public boolean isGPUSupportOpenCL() {
        AppMethodBeat.m2504i(84505);
        if (sLoadOpenclSuccess) {
            boolean gPUSupportOpenCL = getGPUSupportOpenCL();
            AppMethodBeat.m2505o(84505);
            return gPUSupportOpenCL;
        }
        AppMethodBeat.m2505o(84505);
        return false;
    }

    public SegmenterLib(String str, String str2) {
        AppMethodBeat.m2504i(84506);
        initWithProto(str, str2);
        this.mErrorCode = getInitErrorCode();
        this.mErrorType = getInitErrorType();
        AppMethodBeat.m2505o(84506);
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public boolean isInitSuccess() {
        return this.mErrorCode == 0 && this.mErrorType == 0;
    }
}
