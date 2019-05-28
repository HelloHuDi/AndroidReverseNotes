package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;

public class TXCQoS {
    public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
    public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
    static final String TAG = "TXCQos";
    private int mAutoStrategy = -1;
    private int mBitrate = 0;
    private Handler mHandler = new Handler();
    private int mHeight = 0;
    private long mInstance;
    private long mInterval = 1000;
    private boolean mIsEnableDrop = false;
    private C45113a mListener;
    private C0946a mNotifyListener;
    private Runnable mRunnable = new C178031();
    private long mUserID = 0;
    private int mWidth = 0;

    /* renamed from: com.tencent.liteav.qos.TXCQoS$1 */
    class C178031 implements Runnable {
        C178031() {
        }

        public void run() {
            AppMethodBeat.m2504i(66822);
            if (TXCQoS.this.mListener != null) {
                int onGetEncoderRealBitrate = TXCQoS.this.mListener.onGetEncoderRealBitrate();
                int onGetQueueInputSize = TXCQoS.this.mListener.onGetQueueInputSize();
                int onGetQueueOutputSize = TXCQoS.this.mListener.onGetQueueOutputSize();
                int onGetVideoQueueMaxCount = TXCQoS.this.mListener.onGetVideoQueueMaxCount();
                int onGetVideoQueueCurrentCount = TXCQoS.this.mListener.onGetVideoQueueCurrentCount();
                int onGetVideoDropCount = TXCQoS.this.mListener.onGetVideoDropCount();
                TXCQoS.access$200(TXCQoS.this, TXCQoS.this.mInstance, onGetEncoderRealBitrate);
                TXCQoS.access$300(TXCQoS.this, TXCQoS.this.mInstance, onGetVideoQueueMaxCount, onGetVideoQueueCurrentCount, onGetVideoDropCount, onGetQueueOutputSize, onGetQueueInputSize);
                boolean access$400 = TXCQoS.access$400(TXCQoS.this, TXCQoS.this.mInstance);
                if (TXCQoS.this.mIsEnableDrop != access$400) {
                    TXCQoS.this.mIsEnableDrop = access$400;
                    TXCQoS.this.mListener.onEnableDropStatusChanged(access$400);
                }
                onGetEncoderRealBitrate = TXCQoS.access$600(TXCQoS.this, TXCQoS.this.mInstance);
                int access$700 = TXCQoS.access$700(TXCQoS.this, TXCQoS.this.mInstance);
                int access$800 = TXCQoS.access$800(TXCQoS.this, TXCQoS.this.mInstance);
                Bundle bundle;
                if (access$700 == TXCQoS.this.mWidth && access$800 == TXCQoS.this.mHeight) {
                    if (onGetEncoderRealBitrate != TXCQoS.this.mBitrate) {
                        TXCQoS.this.mListener.onEncoderParamsChanged(onGetEncoderRealBitrate, 0, 0);
                        if (TXCQoS.this.mNotifyListener != null) {
                            bundle = new Bundle();
                            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "调整编码码率:new bitrate:".concat(String.valueOf(onGetEncoderRealBitrate)));
                            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                            bundle.putLong("EVT_USERID", TXCQoS.this.mUserID);
                            TXCQoS.this.mNotifyListener.onNotifyEvent(1006, bundle);
                        }
                    }
                } else if (TXCQoS.this.mAutoStrategy == 1 || TXCQoS.this.mAutoStrategy == 5) {
                    TXCQoS.this.mListener.onEncoderParamsChanged(onGetEncoderRealBitrate, access$700, access$800);
                    if (TXCQoS.this.mNotifyListener != null) {
                        bundle = new Bundle();
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "调整分辨率:new bitrate:" + onGetEncoderRealBitrate + " new resolution:" + access$700 + "*" + access$800);
                        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                        TXCQoS.this.mNotifyListener.onNotifyEvent(1005, bundle);
                    }
                }
                TXCQoS.this.mBitrate = onGetEncoderRealBitrate;
                TXCQoS.this.mWidth = access$700;
                TXCQoS.this.mHeight = access$800;
            }
            TXCQoS.this.mHandler.postDelayed(this, TXCQoS.this.mInterval);
            AppMethodBeat.m2505o(66822);
        }
    }

    private native void nativeAddQueueInputSize(long j, int i);

    private native void nativeAddQueueOutputSize(long j, int i);

    private native void nativeAdjustBitrate(long j, int i, int i2, int i3, int i4, int i5);

    private native void nativeDeinit(long j);

    private native int nativeGetBitrate(long j);

    private native int nativeGetHeight(long j);

    public static native int nativeGetProperResolutionByVideoBitrate(boolean z, int i, int i2);

    private native int nativeGetWidth(long j);

    private native long nativeInit(boolean z);

    private native boolean nativeIsEnableDrop(long j);

    private native void nativeReset(long j, boolean z);

    private native void nativeSetAutoAdjustBitrate(long j, boolean z);

    private native void nativeSetAutoAdjustStrategy(long j, int i);

    private native void nativeSetHasVideo(long j, boolean z);

    private native void nativeSetVideoDefaultResolution(long j, int i);

    private native void nativeSetVideoEncBitrate(long j, int i, int i2, int i3);

    private native void nativeSetVideoExpectBitrate(long j, int i);

    private native void nativeSetVideoRealBitrate(long j, int i);

    static /* synthetic */ void access$200(TXCQoS tXCQoS, long j, int i) {
        AppMethodBeat.m2504i(66815);
        tXCQoS.nativeSetVideoRealBitrate(j, i);
        AppMethodBeat.m2505o(66815);
    }

    static /* synthetic */ void access$300(TXCQoS tXCQoS, long j, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(66816);
        tXCQoS.nativeAdjustBitrate(j, i, i2, i3, i4, i5);
        AppMethodBeat.m2505o(66816);
    }

    static /* synthetic */ boolean access$400(TXCQoS tXCQoS, long j) {
        AppMethodBeat.m2504i(66817);
        boolean nativeIsEnableDrop = tXCQoS.nativeIsEnableDrop(j);
        AppMethodBeat.m2505o(66817);
        return nativeIsEnableDrop;
    }

    static /* synthetic */ int access$600(TXCQoS tXCQoS, long j) {
        AppMethodBeat.m2504i(66818);
        int nativeGetBitrate = tXCQoS.nativeGetBitrate(j);
        AppMethodBeat.m2505o(66818);
        return nativeGetBitrate;
    }

    static /* synthetic */ int access$700(TXCQoS tXCQoS, long j) {
        AppMethodBeat.m2504i(66819);
        int nativeGetWidth = tXCQoS.nativeGetWidth(j);
        AppMethodBeat.m2505o(66819);
        return nativeGetWidth;
    }

    static /* synthetic */ int access$800(TXCQoS tXCQoS, long j) {
        AppMethodBeat.m2504i(66820);
        int nativeGetHeight = tXCQoS.nativeGetHeight(j);
        AppMethodBeat.m2505o(66820);
        return nativeGetHeight;
    }

    public TXCQoS(boolean z) {
        AppMethodBeat.m2504i(66803);
        this.mInstance = nativeInit(z);
        AppMethodBeat.m2505o(66803);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        AppMethodBeat.m2504i(66804);
        try {
            nativeDeinit(this.mInstance);
        } finally {
            super.finalize();
            AppMethodBeat.m2505o(66804);
        }
    }

    public void start(long j) {
        AppMethodBeat.m2504i(66805);
        this.mInterval = j;
        this.mHandler.postDelayed(this.mRunnable, this.mInterval);
        AppMethodBeat.m2505o(66805);
    }

    public void stop() {
        AppMethodBeat.m2504i(66806);
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mAutoStrategy = -1;
        AppMethodBeat.m2505o(66806);
    }

    public long getUserID() {
        return this.mUserID;
    }

    public void setUserID(long j) {
        this.mUserID = j;
    }

    public void setNotifyListener(C0946a c0946a) {
        this.mNotifyListener = c0946a;
    }

    public void setListener(C45113a c45113a) {
        this.mListener = c45113a;
    }

    public void reset(boolean z) {
        AppMethodBeat.m2504i(66807);
        nativeReset(this.mInstance, z);
        AppMethodBeat.m2505o(66807);
    }

    public boolean isEnableDrop() {
        AppMethodBeat.m2504i(66808);
        boolean nativeIsEnableDrop = nativeIsEnableDrop(this.mInstance);
        AppMethodBeat.m2505o(66808);
        return nativeIsEnableDrop;
    }

    public void setHasVideo(boolean z) {
        AppMethodBeat.m2504i(66809);
        nativeSetHasVideo(this.mInstance, z);
        AppMethodBeat.m2505o(66809);
    }

    public void setAutoAdjustBitrate(boolean z) {
        AppMethodBeat.m2504i(66810);
        TXCLog.m15675d(TAG, "autoAdjustBitrate is " + (z ? "yes" : "no"));
        nativeSetAutoAdjustBitrate(this.mInstance, z);
        AppMethodBeat.m2505o(66810);
    }

    public void setAutoAdjustStrategy(int i) {
        AppMethodBeat.m2504i(66811);
        TXCLog.m15675d(TAG, "autoAdjustStrategy is ".concat(String.valueOf(i)));
        nativeSetAutoAdjustStrategy(this.mInstance, i);
        this.mAutoStrategy = i;
        AppMethodBeat.m2505o(66811);
    }

    public void setDefaultVideoResolution(int i) {
        AppMethodBeat.m2504i(66812);
        TXCLog.m15675d(TAG, "DefaultVideoResolution is ".concat(String.valueOf(i)));
        this.mWidth = 0;
        this.mHeight = 0;
        nativeSetVideoDefaultResolution(this.mInstance, i);
        AppMethodBeat.m2505o(66812);
    }

    public void setVideoEncBitrate(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66813);
        this.mBitrate = 0;
        nativeSetVideoEncBitrate(this.mInstance, i, i2, i3);
        AppMethodBeat.m2505o(66813);
    }

    public void setVideoExpectBitrate(int i) {
        AppMethodBeat.m2504i(66814);
        nativeSetVideoExpectBitrate(this.mInstance, i);
        AppMethodBeat.m2505o(66814);
    }

    static {
        AppMethodBeat.m2504i(66821);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66821);
    }
}
