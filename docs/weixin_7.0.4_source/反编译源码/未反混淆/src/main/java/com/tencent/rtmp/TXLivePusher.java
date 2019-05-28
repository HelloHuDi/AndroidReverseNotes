package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.basic.c.e;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.e.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.liteav.c;
import com.tencent.liteav.d;
import com.tencent.liteav.f;
import com.tencent.liteav.m;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TXLivePusher implements a, c.a, m, com.tencent.liteav.qos.a {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    private static final byte SEI_MSG_TYPE = (byte) -14;
    private static final String TAG = TXLivePusher.class.getSimpleName();
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private AudioCustomProcessListener mAudioProcessListener;
    private float mBgmPitch = 0.0f;
    private Vector<String> mCallFuncBeforeStartPush = new Vector();
    private c mCaptureAndEnc = null;
    private TXLivePushConfig mConfig = null;
    private Context mContext = null;
    private d mDataReport = null;
    private String mID = "";
    private boolean mIsRecording = false;
    private HashMap<Integer, Long> mLastReportTime = new HashMap();
    private ITXLivePushListener mListener = null;
    private com.tencent.liteav.muxer.c mMP4Muxer = null;
    private Handler mMainHandler = null;
    private ArrayList<MsgInfo> mMsgArray = new ArrayList();
    private f mNewConfig = null;
    private boolean mNotifyStatus = false;
    private VideoCustomProcessListener mPreprocessListener;
    private String mPushUrl = "";
    private TXCQoS mQos = null;
    private ITXVideoRecordListener mRecordListener;
    private long mRecordStartTime = 0;
    private Runnable mSnapShotTimeOutRunnable = new Runnable() {
        public void run() {
            AppMethodBeat.i(65609);
            TXLivePusher.this.mSnapshotRunning = false;
            AppMethodBeat.o(65609);
        }
    };
    private boolean mSnapshotRunning = false;
    private boolean mStartMuxer = false;
    private TXCStreamUploader mStreamUploader = null;
    private TXCloudVideoView mTXCloudVideoView;
    private HashSet<String> mUserList = new HashSet();
    private String mVideoFilePath = "";
    private int mVideoQuality = -1;
    private int mVoiceEnvironment = -1;
    private int mVoiceKind = -1;

    public interface OnBGMNotify {
        void onBGMComplete(int i);

        void onBGMProgress(long j, long j2);

        void onBGMStart();
    }

    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j, int i, int i2, int i3);

        void onRecordRawPcmData(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i, int i2, int i3);

        void onTextureDestoryed();
    }

    class MsgInfo {
        byte[] msg;
        long ts;

        private MsgInfo() {
        }

        /* synthetic */ MsgInfo(TXLivePusher tXLivePusher, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static /* synthetic */ void access$000(TXLivePusher tXLivePusher, ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        AppMethodBeat.i(65924);
        tXLivePusher.postBitmapToMainThread(iTXSnapshotListener, bitmap);
        AppMethodBeat.o(65924);
    }

    static /* synthetic */ void access$400(TXLivePusher tXLivePusher, String str, String str2) {
        AppMethodBeat.i(65925);
        tXLivePusher.callbackRecordSuccess(str, str2);
        AppMethodBeat.o(65925);
    }

    static /* synthetic */ void access$900(TXLivePusher tXLivePusher) {
        AppMethodBeat.i(65926);
        tXLivePusher.statusNotify();
        AppMethodBeat.o(65926);
    }

    static {
        AppMethodBeat.i(65927);
        AppMethodBeat.o(65927);
    }

    public TXLivePusher(Context context) {
        AppMethodBeat.i(65825);
        TXCLog.init();
        this.mNewConfig = new f();
        this.mContext = context.getApplicationContext();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mCaptureAndEnc = new c(this.mContext);
        this.mCaptureAndEnc.a((a) this);
        e.a().a(null, this.mContext);
        this.mLastReportTime.put(Integer.valueOf(TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL), Long.valueOf(0));
        this.mLastReportTime.put(Integer.valueOf(1101), Long.valueOf(0));
        this.mLastReportTime.put(Integer.valueOf(1006), Long.valueOf(0));
        AppMethodBeat.o(65825);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.i(65826);
        TXCLog.d(TAG, "liteav_api setConfig " + tXLivePushConfig + ", " + this);
        if (tXLivePushConfig == null) {
            tXLivePushConfig = new TXLivePushConfig();
        }
        this.mConfig = tXLivePushConfig;
        transferConfig(tXLivePushConfig);
        applyConfig();
        String str = "setConfig:" + this.mNewConfig.h + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.a + "*" + this.mNewConfig.b + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.c + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.e + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.d;
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add(str);
            AppMethodBeat.o(65826);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, str, "");
        AppMethodBeat.o(65826);
    }

    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        AppMethodBeat.i(65827);
        TXCLog.d(TAG, "liteav_api setPushListener ".concat(String.valueOf(iTXLivePushListener)));
        this.mListener = iTXLivePushListener;
        AppMethodBeat.o(65827);
    }

    public int startPusher(String str) {
        AppMethodBeat.i(65828);
        TXCLog.d(TAG, "liteav_api startPusher ".concat(String.valueOf(this)));
        if (TextUtils.isEmpty(str)) {
            TXCLog.e(TAG, "start push error when url is empty ".concat(String.valueOf(this)));
            AppMethodBeat.o(65828);
            return -1;
        }
        if (!TextUtils.isEmpty(this.mPushUrl) && isPushing()) {
            if (this.mPushUrl.equalsIgnoreCase(str)) {
                TXCLog.w(TAG, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
                AppMethodBeat.o(65828);
                return -1;
            }
            TXCLog.w(TAG, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
            stopPusher();
        }
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "============= startPush pushUrl = " + str + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
        TXCLog.d(TAG, "================================================================================================================================================");
        TXCLog.d(TAG, "================================================================================================================================================");
        this.mPushUrl = str;
        updateId(this.mPushUrl);
        startNetworkModule();
        startEncoder();
        startQosModule();
        startDataReportModule();
        Iterator it = this.mCallFuncBeforeStartPush.iterator();
        while (it.hasNext()) {
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, (String) it.next(), "");
        }
        this.mCallFuncBeforeStartPush.clear();
        TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "startPush", "");
        startStatusNotify();
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.clearLog();
        }
        AppMethodBeat.o(65828);
        return 0;
    }

    public void stopPusher() {
        AppMethodBeat.i(65829);
        TXCLog.d(TAG, "liteav_api stopPusher ".concat(String.valueOf(this)));
        if (this.mPushUrl != null && this.mPushUrl.length() > 0) {
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "stopPush", "");
        }
        stopRecord();
        stopStatusNotify();
        stopDataReportModule();
        stopQosModule();
        stopEncoder();
        this.mNewConfig.I = false;
        stopNetworkModule();
        this.mPushUrl = "";
        this.mUserList.clear();
        AppMethodBeat.o(65829);
    }

    public void pausePusher() {
        AppMethodBeat.i(65830);
        TXCLog.d(TAG, "liteav_api pausePusher ".concat(String.valueOf(this)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.g();
        }
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("pausePusher");
            AppMethodBeat.o(65830);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "pausePusher", "");
        AppMethodBeat.o(65830);
    }

    public void resumePusher() {
        AppMethodBeat.i(65831);
        TXCLog.d(TAG, "liteav_api resumePusher ".concat(String.valueOf(this)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.h();
        }
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("resumePusher");
            AppMethodBeat.o(65831);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "resumePusher", "");
        AppMethodBeat.o(65831);
    }

    public boolean isPushing() {
        AppMethodBeat.i(65832);
        if (this.mCaptureAndEnc != null) {
            boolean i = this.mCaptureAndEnc.i();
            AppMethodBeat.o(65832);
            return i;
        }
        AppMethodBeat.o(65832);
        return false;
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(65833);
        TXCLog.d(TAG, "liteav_api startCameraPreview " + tXCloudVideoView + ", " + this);
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("startPreview");
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "startPreview", "");
        }
        setConfig(this.mConfig);
        if (this.mNewConfig.F) {
            TXCLog.e(TAG, "enable pure audio push , so can not start preview!");
            AppMethodBeat.o(65833);
            return;
        }
        if (!(this.mTXCloudVideoView == tXCloudVideoView || this.mTXCloudVideoView == null)) {
            this.mTXCloudVideoView.removeVideoView();
        }
        this.mTXCloudVideoView = tXCloudVideoView;
        if (this.mCaptureAndEnc == null) {
            this.mCaptureAndEnc = new c(this.mContext);
        }
        this.mCaptureAndEnc.a((a) this);
        this.mCaptureAndEnc.a((c.a) this);
        this.mCaptureAndEnc.a(tXCloudVideoView);
        this.mCaptureAndEnc.b(this.mConfig.mBeautyLevel, this.mConfig.mWhiteningLevel, this.mConfig.mRuddyLevel);
        e.a().a(null, this.mContext);
        AppMethodBeat.o(65833);
    }

    public void stopCameraPreview(boolean z) {
        AppMethodBeat.i(65834);
        TXCLog.d(TAG, "liteav_api stopCameraPreview " + z + ", " + this);
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("stopPreview");
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "stopPreview", "");
        }
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65834);
            return;
        }
        this.mCaptureAndEnc.a(z);
        AppMethodBeat.o(65834);
    }

    public void setSurface(Surface surface) {
        AppMethodBeat.i(65835);
        TXCLog.d(TAG, "liteav_api setSurface ".concat(String.valueOf(surface)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65835);
            return;
        }
        this.mCaptureAndEnc.a(surface);
        AppMethodBeat.o(65835);
    }

    public void setSurfaceSize(int i, int i2) {
        AppMethodBeat.i(65836);
        TXCLog.d(TAG, "liteav_api setSurfaceSize " + i + "," + i2);
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65836);
            return;
        }
        this.mCaptureAndEnc.a(i, i2);
        AppMethodBeat.o(65836);
    }

    public void switchCamera() {
        AppMethodBeat.i(65837);
        TXCLog.d(TAG, "liteav_api switchCamera ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65837);
            return;
        }
        this.mCaptureAndEnc.j();
        AppMethodBeat.o(65837);
    }

    public boolean turnOnFlashLight(boolean z) {
        AppMethodBeat.i(65838);
        TXCLog.d(TAG, "liteav_api turnOnFlashLight ".concat(String.valueOf(z)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65838);
            return false;
        }
        boolean b = this.mCaptureAndEnc.b(z);
        AppMethodBeat.o(65838);
        return b;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(65839);
        TXCLog.d(TAG, "liteav_api setMute ".concat(String.valueOf(z)));
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("setMute:".concat(String.valueOf(z)));
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, "setMute:".concat(String.valueOf(z)), "");
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.d(z);
        }
        if (this.mConfig.mEnablePureAudioPush && this.mStreamUploader != null) {
            this.mStreamUploader.setAudioMute(z);
        }
        AppMethodBeat.o(65839);
    }

    public void onLogRecord(String str) {
        AppMethodBeat.i(65840);
        TXCLog.d("User", str);
        AppMethodBeat.o(65840);
    }

    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(65841);
        if (this.mCaptureAndEnc != null) {
            int i4;
            switch (i) {
                case 3:
                    i4 = 1;
                    break;
                case 5:
                    i4 = 2;
                    break;
                default:
                    AppMethodBeat.o(65841);
                    return -1000;
            }
            i4 = this.mCaptureAndEnc.a(bArr, i4, i2, i3);
            AppMethodBeat.o(65841);
            return i4;
        }
        AppMethodBeat.o(65841);
        return -1000;
    }

    public int sendCustomVideoTexture(int i, int i2, int i3) {
        AppMethodBeat.i(65842);
        if (this.mCaptureAndEnc != null) {
            int c = this.mCaptureAndEnc.c(i, i2, i3);
            AppMethodBeat.o(65842);
            return c;
        }
        AppMethodBeat.o(65842);
        return -1000;
    }

    public void sendCustomPCMData(byte[] bArr) {
        AppMethodBeat.i(65843);
        this.mCaptureAndEnc.a(bArr);
        AppMethodBeat.o(65843);
    }

    public int getMaxZoom() {
        AppMethodBeat.i(65844);
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65844);
            return 0;
        }
        int n = this.mCaptureAndEnc.n();
        AppMethodBeat.o(65844);
        return n;
    }

    public boolean setZoom(int i) {
        AppMethodBeat.i(65845);
        TXCLog.d(TAG, "liteav_api setZoom ".concat(String.valueOf(i)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65845);
            return false;
        }
        boolean i2 = this.mCaptureAndEnc.i(i);
        AppMethodBeat.o(65845);
        return i2;
    }

    public void setFocusPosition(float f, float f2) {
        AppMethodBeat.i(65846);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(f, f2);
        }
        AppMethodBeat.o(65846);
    }

    public boolean setMirror(boolean z) {
        AppMethodBeat.i(65847);
        TXCLog.d(TAG, "liteav_api setMirror ".concat(String.valueOf(z)));
        if (this.mConfig != null) {
            this.mConfig.setVideoEncoderXMirror(z);
        }
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65847);
            return false;
        }
        this.mCaptureAndEnc.e(z);
        AppMethodBeat.o(65847);
        return true;
    }

    public void setExposureCompensation(float f) {
        AppMethodBeat.i(65848);
        TXCLog.d(TAG, "liteav_api setExposureCompensation ".concat(String.valueOf(f)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65848);
            return;
        }
        this.mCaptureAndEnc.c(f);
        AppMethodBeat.o(65848);
    }

    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        AppMethodBeat.i(65849);
        TXCLog.d(TAG, "liteav_api setBGMNofify ".concat(String.valueOf(onBGMNotify)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(onBGMNotify);
        }
        AppMethodBeat.o(65849);
    }

    public boolean playBGM(String str) {
        AppMethodBeat.i(65850);
        TXCLog.d(TAG, "liteav_api playBGM ".concat(String.valueOf(str)));
        boolean c = this.mCaptureAndEnc.c(str);
        AppMethodBeat.o(65850);
        return c;
    }

    public boolean stopBGM() {
        AppMethodBeat.i(65851);
        TXCLog.d(TAG, "liteav_api stopBGM ");
        boolean o = this.mCaptureAndEnc.o();
        AppMethodBeat.o(65851);
        return o;
    }

    public boolean pauseBGM() {
        AppMethodBeat.i(65852);
        TXCLog.d(TAG, "liteav_api pauseBGM ");
        boolean p = this.mCaptureAndEnc.p();
        AppMethodBeat.o(65852);
        return p;
    }

    public boolean resumeBGM() {
        AppMethodBeat.i(65853);
        TXCLog.d(TAG, "liteav_api resumeBGM ");
        boolean q = this.mCaptureAndEnc.q();
        AppMethodBeat.o(65853);
        return q;
    }

    public boolean setMicVolume(float f) {
        AppMethodBeat.i(65854);
        TXCLog.d(TAG, "liteav_api setMicVolume ".concat(String.valueOf(f)));
        boolean d = this.mCaptureAndEnc.d(f);
        AppMethodBeat.o(65854);
        return d;
    }

    public boolean setBGMVolume(float f) {
        AppMethodBeat.i(65855);
        TXCLog.d(TAG, "liteav_api setBGMVolume ".concat(String.valueOf(f)));
        boolean e = this.mCaptureAndEnc.e(f);
        AppMethodBeat.o(65855);
        return e;
    }

    public void setBgmPitch(float f) {
        AppMethodBeat.i(65856);
        this.mBgmPitch = f;
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(f);
        }
        AppMethodBeat.o(65856);
    }

    public int getMusicDuration(String str) {
        AppMethodBeat.i(65857);
        int d = this.mCaptureAndEnc.d(str);
        AppMethodBeat.o(65857);
        return d;
    }

    public void startScreenCapture() {
        AppMethodBeat.i(65858);
        TXCLog.d(TAG, "liteav_api startScreenCapture ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65858);
            return;
        }
        this.mCaptureAndEnc.k();
        AppMethodBeat.o(65858);
    }

    public void stopScreenCapture() {
        AppMethodBeat.i(65859);
        TXCLog.d(TAG, "liteav_api stopScreenCapture ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65859);
            return;
        }
        this.mCaptureAndEnc.l();
        AppMethodBeat.o(65859);
    }

    public void setRenderRotation(int i) {
        AppMethodBeat.i(65860);
        TXCLog.d(TAG, "liteav_api setRenderRotation ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65860);
            return;
        }
        this.mCaptureAndEnc.a(i);
        AppMethodBeat.o(65860);
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        AppMethodBeat.i(65861);
        TXCLog.d(TAG, "liteav_api setVideoProcessListener ".concat(String.valueOf(videoCustomProcessListener)));
        this.mPreprocessListener = videoCustomProcessListener;
        if (this.mPreprocessListener == null) {
            if (this.mCaptureAndEnc != null) {
                this.mCaptureAndEnc.a(null);
                AppMethodBeat.o(65861);
                return;
            }
        } else if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a((m) this);
        }
        AppMethodBeat.o(65861);
    }

    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        AppMethodBeat.i(65862);
        TXCLog.d(TAG, "liteav_api setAudioProcessListener ".concat(String.valueOf(audioCustomProcessListener)));
        this.mAudioProcessListener = audioCustomProcessListener;
        AppMethodBeat.o(65862);
    }

    public void snapshot(final ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(65863);
        TXCLog.d(TAG, "liteav_api snapshot ".concat(String.valueOf(iTXSnapshotListener)));
        if (this.mSnapshotRunning || iTXSnapshotListener == null || this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65863);
        } else if (this.mCaptureAndEnc != null) {
            this.mSnapshotRunning = true;
            this.mCaptureAndEnc.a(new n() {
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.i(65989);
                    TXLivePusher.access$000(TXLivePusher.this, iTXSnapshotListener, bitmap);
                    TXLivePusher.this.mSnapshotRunning = false;
                    TXLivePusher.this.mMainHandler.removeCallbacks(TXLivePusher.this.mSnapShotTimeOutRunnable);
                    AppMethodBeat.o(65989);
                }
            });
            this.mMainHandler.postDelayed(this.mSnapShotTimeOutRunnable, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(65863);
        } else {
            this.mSnapshotRunning = false;
            AppMethodBeat.o(65863);
        }
    }

    public int startRecord(String str) {
        AppMethodBeat.i(65864);
        TXCLog.d(TAG, "liteav_api startRecord ".concat(String.valueOf(str)));
        if (VERSION.SDK_INT < 18) {
            TXCLog.e(TAG, "API levl is too low (record need 18, current is" + VERSION.SDK_INT + ")");
            AppMethodBeat.o(65864);
            return -3;
        } else if (this.mIsRecording) {
            TXCLog.w(TAG, "ignore start record when recording");
            AppMethodBeat.o(65864);
            return -1;
        } else if (this.mCaptureAndEnc == null || !this.mCaptureAndEnc.i()) {
            TXCLog.w(TAG, "ignore start record when not pushing");
            AppMethodBeat.o(65864);
            return -2;
        } else {
            TXCLog.w(TAG, "start record ");
            this.mIsRecording = true;
            this.mVideoFilePath = str;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            this.mMP4Muxer = new com.tencent.liteav.muxer.c(this.mContext, 1);
            this.mStartMuxer = false;
            this.mMP4Muxer.a(this.mVideoFilePath);
            addAudioTrack();
            TXCDRApi.txReportDAU(this.mContext.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aM);
            if (this.mCaptureAndEnc != null) {
                this.mCaptureAndEnc.s();
            }
            AppMethodBeat.o(65864);
            return 0;
        }
    }

    public void stopRecord() {
        AppMethodBeat.i(65865);
        TXCLog.d(TAG, "liteav_api stopRecord ");
        if (this.mIsRecording && this.mMP4Muxer != null) {
            int b = this.mMP4Muxer.b();
            TXCLog.w(TAG, "start record ");
            this.mIsRecording = false;
            if (b == 0) {
                final String str = this.mVideoFilePath;
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(65593);
                        File parentFile = new File(str).getParentFile();
                        String format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
                        String str = parentFile + File.separator + String.format("TXUGCCover_%s.jpg", new Object[]{format});
                        b.a(str, str);
                        TXLivePusher.access$400(TXLivePusher.this, str, str);
                        AppMethodBeat.o(65593);
                    }
                });
                AppMethodBeat.o(65865);
                return;
            }
            callbackRecordFail();
        }
        AppMethodBeat.o(65865);
    }

    public void setVideoRecordListener(ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.i(65866);
        TXCLog.d(TAG, "liteav_api setVideoRecordListener ".concat(String.valueOf(iTXVideoRecordListener)));
        this.mRecordListener = iTXVideoRecordListener;
        AppMethodBeat.o(65866);
    }

    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(65867);
        TXCLog.d(TAG, "liteav_api setBeautyFilter " + i + ", " + i2 + ", " + i3 + ", " + i4);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(i);
            this.mCaptureAndEnc.b(i2, i3, i4);
        }
        if (this.mConfig != null) {
            this.mConfig.mBeautyLevel = i2;
            this.mConfig.mWhiteningLevel = i3;
            this.mConfig.mRuddyLevel = i4;
        }
        AppMethodBeat.o(65867);
        return true;
    }

    public void setFilter(Bitmap bitmap) {
        AppMethodBeat.i(65868);
        TXCLog.d(TAG, "liteav_api setFilter ".concat(String.valueOf(bitmap)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(bitmap);
        }
        AppMethodBeat.o(65868);
    }

    public void setMotionTmpl(String str) {
        AppMethodBeat.i(65869);
        TXCLog.d(TAG, "liteav_api motionPath ".concat(String.valueOf(str)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(str);
        }
        AppMethodBeat.o(65869);
    }

    public void setMotionMute(boolean z) {
        AppMethodBeat.i(65870);
        TXCLog.d(TAG, "liteav_api setMotionMute ".concat(String.valueOf(z)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.c(z);
        }
        AppMethodBeat.o(65870);
    }

    @TargetApi(18)
    public boolean setGreenScreenFile(String str) {
        AppMethodBeat.i(65871);
        TXCLog.d(TAG, "liteav_api setGreenScreenFile ".concat(String.valueOf(str)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            boolean b = this.mCaptureAndEnc.b(str);
            AppMethodBeat.o(65871);
            return b;
        }
        AppMethodBeat.o(65871);
        return false;
    }

    public void setEyeScaleLevel(int i) {
        AppMethodBeat.i(65872);
        TXCLog.d(TAG, "liteav_api setEyeScaleLevel ".concat(String.valueOf(i)));
        e.a().a(null, this.mContext);
        if (this.mConfig != null) {
            this.mConfig.setEyeScaleLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.c(i);
        }
        AppMethodBeat.o(65872);
    }

    public void setFaceSlimLevel(int i) {
        AppMethodBeat.i(65873);
        TXCLog.d(TAG, "liteav_api setFaceSlimLevel ".concat(String.valueOf(i)));
        e.a().a(null, this.mContext);
        if (this.mConfig != null) {
            this.mConfig.setFaceSlimLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.d(i);
        }
        AppMethodBeat.o(65873);
    }

    public void setFaceVLevel(int i) {
        AppMethodBeat.i(65874);
        TXCLog.d(TAG, "liteav_api setFaceVLevel ".concat(String.valueOf(i)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.e(i);
        }
        AppMethodBeat.o(65874);
    }

    public void setSpecialRatio(float f) {
        AppMethodBeat.i(65875);
        TXCLog.d(TAG, "liteav_api setSpecialRatio ".concat(String.valueOf(f)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(f);
        }
        AppMethodBeat.o(65875);
    }

    public void setFaceShortLevel(int i) {
        AppMethodBeat.i(65876);
        TXCLog.d(TAG, "liteav_api setFaceShortLevel ".concat(String.valueOf(i)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.f(i);
        }
        AppMethodBeat.o(65876);
    }

    public void setChinLevel(int i) {
        AppMethodBeat.i(65877);
        TXCLog.d(TAG, "liteav_api setChinLevel ".concat(String.valueOf(i)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.g(i);
        }
        AppMethodBeat.o(65877);
    }

    public void setNoseSlimLevel(int i) {
        AppMethodBeat.i(65878);
        TXCLog.d(TAG, "liteav_api setNoseSlimLevel ".concat(String.valueOf(i)));
        e.a().a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.h(i);
        }
        AppMethodBeat.o(65878);
    }

    public void setVideoQuality(int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5 = false;
        int i2 = 1;
        AppMethodBeat.i(65879);
        TXCLog.d(TAG, "liteav_api setVideoQuality " + i + ", " + z + ", " + z2);
        if (VERSION.SDK_INT < 18 && (i == 2 || i == 3)) {
            i = 1;
        }
        String str = "setVideoQuality:" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + z + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + z2;
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add(str);
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, com.tencent.liteav.basic.datareport.a.P, 0, str, "");
        }
        if (this.mConfig == null) {
            this.mConfig = new TXLivePushConfig();
        }
        this.mConfig.setVideoFPS(18);
        switch (i) {
            case 1:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(2);
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(301);
                this.mConfig.setVideoBitrate(800);
                this.mConfig.setMaxVideoBitrate(800);
                z3 = false;
                z4 = false;
                break;
            case 2:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(2);
                this.mConfig.setVideoResolution(1);
                this.mConfig.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(600);
                this.mConfig.setVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                this.mConfig.setMaxVideoBitrate(1500);
                z3 = false;
                z4 = false;
                break;
            case 3:
                this.mConfig.enableAEC(false);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(2);
                this.mConfig.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                setAdjustStrategy(z, z2);
                this.mConfig.setMinVideoBitrate(600);
                this.mConfig.setVideoBitrate(1800);
                this.mConfig.setMaxVideoBitrate(1800);
                z3 = false;
                z4 = false;
                break;
            case 4:
                if (VERSION.SDK_INT < 18) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(0);
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(301);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(800);
                } else if (this.mVideoQuality == 1) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(301);
                    this.mConfig.setVideoBitrate(800);
                    this.mConfig.setMaxVideoBitrate(800);
                } else if (this.mVideoQuality == 3) {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(2);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(600);
                    this.mConfig.setVideoBitrate(1800);
                    this.mConfig.setMaxVideoBitrate(1800);
                } else {
                    this.mConfig.enableAEC(true);
                    this.mConfig.setHardwareAcceleration(1);
                    this.mConfig.setVideoResolution(1);
                    this.mConfig.setAutoAdjustBitrate(true);
                    this.mConfig.setAutoAdjustStrategy(4);
                    this.mConfig.setMinVideoBitrate(600);
                    this.mConfig.setVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                    this.mConfig.setMaxVideoBitrate(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
                }
                this.mConfig.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                z3 = false;
                z4 = true;
                break;
            case 5:
                this.mConfig.enableAEC(true);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(6);
                this.mConfig.setAutoAdjustBitrate(false);
                this.mConfig.setVideoBitrate(350);
                this.mConfig.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                z3 = false;
                z4 = true;
                break;
            case 6:
                this.mConfig.enableAEC(true);
                this.mConfig.setHardwareAcceleration(1);
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                this.mConfig.setAutoAdjustBitrate(true);
                this.mConfig.setAutoAdjustStrategy(5);
                this.mConfig.setMinVideoBitrate(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                this.mConfig.setVideoBitrate(400);
                this.mConfig.setMaxVideoBitrate(810);
                z3 = true;
                z4 = true;
                break;
            default:
                this.mConfig.setHardwareAcceleration(2);
                TXCLog.e(TAG, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i)));
                AppMethodBeat.o(65879);
                return;
        }
        this.mVideoQuality = i;
        TXLivePushConfig tXLivePushConfig = this.mConfig;
        if (!z4) {
            z5 = true;
        }
        tXLivePushConfig.enableVideoHardEncoderMainProfile(z5);
        TXLivePushConfig tXLivePushConfig2 = this.mConfig;
        if (!z4) {
            i2 = 3;
        }
        tXLivePushConfig2.setVideoEncodeGop(i2);
        if (this.mNewConfig != null) {
            this.mNewConfig.I = z4;
            this.mNewConfig.J = z3;
        }
        setConfig(this.mConfig);
        AppMethodBeat.o(65879);
    }

    public void setReverb(int i) {
        AppMethodBeat.i(65880);
        TXCLog.d(TAG, "liteav_api setReverb ".concat(String.valueOf(i)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65880);
            return;
        }
        this.mCaptureAndEnc.j(i);
        AppMethodBeat.o(65880);
    }

    public void setVoiceChangerType(int i) {
        AppMethodBeat.i(65881);
        switch (i) {
            case 1:
                this.mVoiceKind = 6;
                this.mVoiceEnvironment = -1;
                break;
            case 2:
                this.mVoiceKind = 4;
                this.mVoiceEnvironment = -1;
                break;
            case 3:
                this.mVoiceKind = 5;
                this.mVoiceEnvironment = -1;
                break;
            case 4:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = 9;
                break;
            case 5:
                this.mVoiceKind = 536936433;
                this.mVoiceEnvironment = 50;
                break;
            case 6:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = 5;
                break;
            case 7:
                this.mVoiceKind = 13;
                this.mVoiceEnvironment = 1;
                break;
            case 8:
                this.mVoiceKind = 13;
                this.mVoiceEnvironment = -1;
                break;
            case 9:
                this.mVoiceKind = 10;
                this.mVoiceEnvironment = 4;
                break;
            case 10:
                this.mVoiceKind = 10;
                this.mVoiceEnvironment = 20;
                break;
            case 11:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = 2;
                break;
            default:
                this.mVoiceKind = -1;
                this.mVoiceEnvironment = -1;
                break;
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.b(this.mVoiceKind, this.mVoiceEnvironment);
        }
        AppMethodBeat.o(65881);
    }

    public void onNotifyEvent(final int i, final Bundle bundle) {
        int i2 = 1;
        AppMethodBeat.i(65882);
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65932);
                    if (TXLivePusher.this.mTXCloudVideoView != null) {
                        TXLivePusher.this.mTXCloudVideoView.setLogText(null, bundle, i);
                    }
                    AppMethodBeat.o(65932);
                }
            });
        }
        transferPushEvent(i, bundle);
        String str = this.mPushUrl;
        if (str != null && str.length() > 0) {
            if (i == 1018 || i == 1019 || i == TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER || i == 1020) {
                switch (i) {
                    case 1018:
                        TXCDRApi.reportEvent40003(str, com.tencent.liteav.basic.datareport.a.R, 0, "enter", "");
                        AppMethodBeat.o(65882);
                        return;
                    case 1019:
                        TXCDRApi.reportEvent40003(str, com.tencent.liteav.basic.datareport.a.R, 0, "exit", "");
                        AppMethodBeat.o(65882);
                        return;
                    case 1020:
                        try {
                            JSONArray jSONArray = new JSONObject(bundle.getString(TXLiveConstants.EVT_DESCRIPTION)).getJSONArray("userlist");
                            HashSet hashSet = new HashSet();
                            StringBuilder stringBuilder = new StringBuilder();
                            if (!(jSONArray == null || jSONArray.length() == 0) || this.mUserList.size() <= 0) {
                                if (jSONArray != null) {
                                    int i3 = 0;
                                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                        String string = jSONArray.getJSONObject(i4).getString("userid");
                                        hashSet.add(string);
                                        if (i4 == 0) {
                                            stringBuilder.append(string);
                                        } else {
                                            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D.concat(String.valueOf(string)));
                                        }
                                        if (this.mUserList == null || this.mUserList.size() <= 0 || !this.mUserList.contains(string)) {
                                            i3 = 1;
                                        }
                                    }
                                    if (this.mUserList == null || jSONArray.length() == this.mUserList.size()) {
                                        i2 = i3;
                                    }
                                } else {
                                    i2 = 0;
                                }
                            }
                            if (i2 != 0) {
                                if (hashSet.size() == 0) {
                                    this.mUserList.clear();
                                    TXCDRApi.reportEvent40003(str, com.tencent.liteav.basic.datareport.a.R, 0, "userlist:", "");
                                    AppMethodBeat.o(65882);
                                    return;
                                }
                                this.mUserList.clear();
                                this.mUserList.addAll(hashSet);
                                TXCDRApi.reportEvent40003(str, com.tencent.liteav.basic.datareport.a.R, 0, "userlist:" + stringBuilder.toString(), "");
                            }
                            AppMethodBeat.o(65882);
                            return;
                        } catch (JSONException e) {
                            AppMethodBeat.o(65882);
                            return;
                        }
                    case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                        TXCDRApi.reportEvent40003(str, com.tencent.liteav.basic.datareport.a.R, 0, "reenter", "");
                        AppMethodBeat.o(65882);
                        return;
                    default:
                        AppMethodBeat.o(65882);
                        return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL || i == 1101 || i == 1006) {
                if (currentTimeMillis - ((Long) this.mLastReportTime.get(Integer.valueOf(i))).longValue() < 5000) {
                    AppMethodBeat.o(65882);
                    return;
                }
                this.mLastReportTime.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            }
            if (!(i == 1018 || i == 1019 || i == TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER || i == 1020)) {
                TXCDRApi.reportEvent40003(str, com.tencent.liteav.basic.datareport.a.Q, i, bundle.getString(TXLiveConstants.EVT_DESCRIPTION), "");
            }
        }
        AppMethodBeat.o(65882);
    }

    public int onTextureCustomProcess(int i, int i2, int i3) {
        AppMethodBeat.i(65883);
        if (this.mPreprocessListener != null) {
            int onTextureCustomProcess = this.mPreprocessListener.onTextureCustomProcess(i, i2, i3);
            AppMethodBeat.o(65883);
            return onTextureCustomProcess;
        }
        AppMethodBeat.o(65883);
        return 0;
    }

    public void onDetectFacePoints(float[] fArr) {
        AppMethodBeat.i(65884);
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onDetectFacePoints(fArr);
        }
        AppMethodBeat.o(65884);
    }

    public void onTextureDestoryed() {
        AppMethodBeat.i(65885);
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onTextureDestoryed();
        }
        AppMethodBeat.o(65885);
    }

    public int onGetEncoderRealBitrate() {
        AppMethodBeat.i(65886);
        int d = TXCStatus.d(this.mID, WearableStatusCodes.UNKNOWN_LISTENER);
        AppMethodBeat.o(65886);
        return d;
    }

    public int onGetQueueInputSize() {
        AppMethodBeat.i(65887);
        int d = TXCStatus.d(this.mID, 7002);
        if (this.mNewConfig.I) {
            d += TXCStatus.d(this.mID, 7001);
        } else {
            d += TXCStatus.d(this.mID, WearableStatusCodes.UNKNOWN_LISTENER);
        }
        AppMethodBeat.o(65887);
        return d;
    }

    public int onGetQueueOutputSize() {
        AppMethodBeat.i(65888);
        if (this.mStreamUploader == null) {
            AppMethodBeat.o(65888);
            return 0;
        }
        int d = TXCStatus.d(this.mID, 7004) + TXCStatus.d(this.mID, 7003);
        AppMethodBeat.o(65888);
        return d;
    }

    public int onGetVideoQueueMaxCount() {
        return 5;
    }

    public int onGetVideoQueueCurrentCount() {
        AppMethodBeat.i(65889);
        int d = TXCStatus.d(this.mID, 7005);
        AppMethodBeat.o(65889);
        return d;
    }

    public int onGetVideoDropCount() {
        AppMethodBeat.i(65890);
        int d = TXCStatus.d(this.mID, 7007);
        AppMethodBeat.o(65890);
        return d;
    }

    public void onEncoderParamsChanged(int i, int i2, int i3) {
        AppMethodBeat.i(65891);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(i, i2, i3);
        }
        if (!(i2 == 0 || i3 == 0)) {
            this.mNewConfig.a = i2;
            this.mNewConfig.b = i3;
        }
        if (i != 0) {
            this.mNewConfig.c = i;
        }
        AppMethodBeat.o(65891);
    }

    public void onEnableDropStatusChanged(boolean z) {
        AppMethodBeat.i(65892);
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setDropEanble(z);
        }
        AppMethodBeat.o(65892);
    }

    public void onEncAudio(byte[] bArr, long j, int i, int i2) {
        AppMethodBeat.i(65893);
        if (!(this.mStreamUploader == null || bArr == null)) {
            this.mStreamUploader.pushAAC(bArr, j);
        }
        if (this.mIsRecording && this.mMP4Muxer != null && this.mStartMuxer && bArr != null) {
            this.mMP4Muxer.a(bArr, 0, bArr.length, 1000 * j, 0);
        }
        AppMethodBeat.o(65893);
    }

    public void onEncVideo(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(65894);
        if (this.mQos != null) {
            this.mQos.setHasVideo(true);
        }
        if (!(this.mStreamUploader == null || bVar == null || bVar.a == null)) {
            synchronized (this) {
                try {
                    if (!(this.mMsgArray == null || this.mMsgArray.isEmpty())) {
                        MsgInfo msgInfo;
                        Iterator it = this.mMsgArray.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            msgInfo = (MsgInfo) it.next();
                            if (msgInfo.ts > bVar.g) {
                                break;
                            }
                            i = ((msgInfo.msg.length <= 10240 ? msgInfo.msg.length : 10240) + 5) + i;
                        }
                        if (i != 0) {
                            int i2;
                            byte[] bArr = new byte[(bVar.a.length + i)];
                            byte[] bArr2 = new byte[5];
                            Iterator it2 = this.mMsgArray.iterator();
                            i = 0;
                            int i3 = 0;
                            while (it2.hasNext()) {
                                msgInfo = (MsgInfo) it2.next();
                                if (msgInfo.ts > bVar.g) {
                                    break;
                                }
                                int i4 = i + 1;
                                i = msgInfo.msg.length <= 10240 ? msgInfo.msg.length : 10240;
                                int i5 = i + 1;
                                bArr2[0] = (byte) ((i5 >> 24) & 255);
                                bArr2[1] = (byte) ((i5 >> 16) & 255);
                                bArr2[2] = (byte) ((i5 >> 8) & 255);
                                bArr2[3] = (byte) (i5 & 255);
                                bArr2[4] = (byte) 6;
                                System.arraycopy(bArr2, 0, bArr, i3, 5);
                                i3 += 5;
                                System.arraycopy(msgInfo.msg, 0, bArr, i3, i);
                                i2 = i3 + i;
                                i = i4;
                                i3 = i2;
                            }
                            for (i2 = 0; i2 < i; i2++) {
                                this.mMsgArray.remove(0);
                            }
                            System.arraycopy(bVar.a, 0, bArr, i3, bVar.a.length);
                            bVar.a = bArr;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65894);
                    }
                }
            }
            this.mStreamUploader.pushNAL(bVar);
        }
        if (!(!this.mIsRecording || this.mMP4Muxer == null || bVar == null || bVar.a == null)) {
            byte[] transferAvccToAnnexb = transferAvccToAnnexb(bVar.a);
            if (!this.mStartMuxer) {
                if (bVar.b == 0) {
                    MediaFormat a = b.a(transferAvccToAnnexb, this.mCaptureAndEnc.b(), this.mCaptureAndEnc.c());
                    if (a != null) {
                        this.mMP4Muxer.a(a);
                        this.mMP4Muxer.a();
                        this.mStartMuxer = true;
                        this.mRecordStartTime = 0;
                    }
                }
            }
            recordVideoData(bVar, transferAvccToAnnexb);
        }
        AppMethodBeat.o(65894);
    }

    public void onRecordRawPcm(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(65895);
        AudioCustomProcessListener audioCustomProcessListener = this.mAudioProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j, i, i2, i3, z);
        }
        AppMethodBeat.o(65895);
    }

    public void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.i(65896);
        AudioCustomProcessListener audioCustomProcessListener = this.mAudioProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j, i, i2, i3);
        }
        AppMethodBeat.o(65896);
    }

    public void onEncVideoFormat(MediaFormat mediaFormat) {
        AppMethodBeat.i(65897);
        if (this.mIsRecording && this.mMP4Muxer != null) {
            this.mMP4Muxer.a(mediaFormat);
            if (!this.mStartMuxer) {
                this.mMP4Muxer.a();
                this.mStartMuxer = true;
                this.mRecordStartTime = 0;
            }
        }
        AppMethodBeat.o(65897);
    }

    private void callbackRecordFail() {
        AppMethodBeat.i(65898);
        this.mMainHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65929);
                TXRecordResult tXRecordResult = new TXRecordResult();
                tXRecordResult.retCode = -1;
                tXRecordResult.descMsg = "record video failed";
                if (TXLivePusher.this.mRecordListener != null) {
                    TXLivePusher.this.mRecordListener.onRecordComplete(tXRecordResult);
                }
                TXCLog.w(TXLivePusher.TAG, "record complete fail");
                AppMethodBeat.o(65929);
            }
        });
        AppMethodBeat.o(65898);
    }

    private void callbackRecordSuccess(final String str, final String str2) {
        AppMethodBeat.i(65899);
        this.mMainHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65933);
                TXRecordResult tXRecordResult = new TXRecordResult();
                tXRecordResult.retCode = 0;
                tXRecordResult.descMsg = "record success";
                tXRecordResult.videoPath = str;
                tXRecordResult.coverPath = str2;
                if (TXLivePusher.this.mRecordListener != null) {
                    TXLivePusher.this.mRecordListener.onRecordComplete(tXRecordResult);
                }
                TXCLog.w(TXLivePusher.TAG, "record complete success");
                AppMethodBeat.o(65933);
            }
        });
        AppMethodBeat.o(65899);
    }

    @TargetApi(16)
    private void addAudioTrack() {
        AppMethodBeat.i(65900);
        MediaFormat a = b.a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
        if (this.mMP4Muxer != null) {
            this.mMP4Muxer.b(a);
        }
        AppMethodBeat.o(65900);
    }

    private void recordVideoData(com.tencent.liteav.basic.g.b bVar, byte[] bArr) {
        AppMethodBeat.i(65901);
        if (this.mRecordStartTime == 0) {
            this.mRecordStartTime = bVar.g;
        }
        final long j = bVar.g - this.mRecordStartTime;
        int i = bVar.k == null ? bVar.b == 0 ? 1 : 0 : bVar.k.flags;
        this.mMP4Muxer.b(bArr, 0, bArr.length, bVar.g * 1000, i);
        this.mMainHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65592);
                if (TXLivePusher.this.mRecordListener != null) {
                    TXLivePusher.this.mRecordListener.onRecordProgress(j);
                }
                AppMethodBeat.o(65592);
            }
        });
        AppMethodBeat.o(65901);
    }

    private void postBitmapToMainThread(final ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        AppMethodBeat.i(65902);
        if (iTXSnapshotListener == null) {
            AppMethodBeat.o(65902);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65928);
                if (iTXSnapshotListener != null) {
                    iTXSnapshotListener.onSnapshot(bitmap);
                }
                AppMethodBeat.o(65928);
            }
        });
        AppMethodBeat.o(65902);
    }

    private void setAdjustStrategy(boolean z, boolean z2) {
        AppMethodBeat.i(65903);
        int adjustStrategy = getAdjustStrategy(z, z2);
        if (adjustStrategy == -1) {
            this.mConfig.setAutoAdjustBitrate(false);
            this.mConfig.setAutoAdjustStrategy(-1);
            AppMethodBeat.o(65903);
            return;
        }
        this.mConfig.setAutoAdjustBitrate(true);
        this.mConfig.setAutoAdjustStrategy(adjustStrategy);
        AppMethodBeat.o(65903);
    }

    private int getAdjustStrategy(boolean z, boolean z2) {
        if (!z) {
            return -1;
        }
        if (z2) {
            return 1;
        }
        return 0;
    }

    private void updateId(String str) {
        AppMethodBeat.i(65904);
        String format = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setID(format);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(format);
        }
        if (this.mDataReport != null) {
            this.mDataReport.d(format);
        }
        this.mID = format;
        AppMethodBeat.o(65904);
    }

    private void startStatusNotify() {
        AppMethodBeat.i(65905);
        this.mNotifyStatus = true;
        if (this.mMainHandler != null) {
            this.mMainHandler.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65972);
                    if (TXLivePusher.this.mNotifyStatus) {
                        TXLivePusher.access$900(TXLivePusher.this);
                    }
                    AppMethodBeat.o(65972);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(65905);
    }

    private void stopStatusNotify() {
        this.mNotifyStatus = false;
    }

    private void statusNotify() {
        AppMethodBeat.i(65906);
        int[] a = b.a();
        int i = a[0] / 10;
        String str = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.d(this.mID, 7004);
        int d2 = TXCStatus.d(this.mID, 7003);
        int d3 = TXCStatus.d(this.mID, 7002);
        int d4 = TXCStatus.d(this.mID, 7001);
        int d5 = TXCStatus.d(this.mID, 7007);
        int d6 = TXCStatus.d(this.mID, 7005);
        int d7 = TXCStatus.d(this.mID, 7006);
        String c = TXCStatus.c(this.mID, 7012);
        double e = TXCStatus.e(this.mID, WearableStatusCodes.DUPLICATE_LISTENER);
        int d8 = TXCStatus.d(this.mID, WearableStatusCodes.DATA_ITEM_TOO_LARGE);
        Bundle bundle = new Bundle();
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, d + d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, (int) e);
        if (e < 1.0d) {
            e = 15.0d;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((d8 * 10) / ((int) e))) / 10.0f)) + 0.5d));
        bundle.putInt(TXLiveConstants.NET_STATUS_DROP_SIZE, d5);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, d4);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, d3);
        bundle.putInt(TXLiveConstants.NET_STATUS_CODEC_CACHE, d7);
        bundle.putInt(TXLiveConstants.NET_STATUS_CACHE_SIZE, d6);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, c);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        if (this.mCaptureAndEnc != null) {
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.mCaptureAndEnc.d());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.mCaptureAndEnc.b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.mCaptureAndEnc.c());
        }
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setLogText(bundle, null, 0);
        }
        if (this.mListener != null) {
            this.mListener.onNetStatus(bundle);
        }
        if (this.mDataReport != null) {
            this.mDataReport.e();
        }
        if (this.mMainHandler != null && this.mNotifyStatus) {
            this.mMainHandler.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65930);
                    if (TXLivePusher.this.mNotifyStatus) {
                        TXLivePusher.access$900(TXLivePusher.this);
                    }
                    AppMethodBeat.o(65930);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(65906);
    }

    private void startNetworkModule() {
        int i = 5;
        int i2 = 1;
        AppMethodBeat.i(65907);
        h hVar = new h();
        hVar.d = com.tencent.liteav.audio.b.a().d();
        hVar.e = com.tencent.liteav.audio.b.a().e();
        hVar.a = 0;
        hVar.c = 20;
        hVar.b = 0;
        hVar.f = 3;
        hVar.j = true;
        hVar.l = true;
        hVar.k = false;
        hVar.h = 40;
        hVar.i = 5000;
        hVar.m = this.mNewConfig.I;
        hVar.n = this.mNewConfig.J;
        hVar.o = getQuicMode(this.mVideoQuality);
        this.mStreamUploader = new TXCStreamUploader(this.mContext, hVar);
        this.mStreamUploader.setID(this.mID);
        if ((this.mNewConfig.K & 1) != 0) {
            if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
            }
        } else if (this.mStreamUploader != null) {
            this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
        }
        this.mStreamUploader.setNotifyListener(this);
        if (this.mConfig.mEnablePureAudioPush && this.mCaptureAndEnc != null) {
            this.mStreamUploader.setAudioMute(this.mCaptureAndEnc.m());
        }
        this.mPushUrl = this.mStreamUploader.start(this.mPushUrl, this.mNewConfig.G, this.mNewConfig.H);
        if (this.mNewConfig.F) {
            this.mStreamUploader.setMode(1);
        }
        if (this.mNewConfig.I) {
            int i3 = this.mNewConfig.o;
            int i4 = this.mNewConfig.p;
            if (i3 >= 5) {
                i = i3;
            }
            if (i4 <= 1) {
                i2 = i4;
            }
            this.mStreamUploader.setRetryInterval(i2);
            this.mStreamUploader.setRetryTimes(i);
            this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
        } else {
            this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
            this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
            this.mStreamUploader.setVideoDropParams(true, 40, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        }
        this.mStreamUploader.setSendStrategy(this.mNewConfig.I, this.mNewConfig.J);
        AppMethodBeat.o(65907);
    }

    private void stopNetworkModule() {
        AppMethodBeat.i(65908);
        if (this.mStreamUploader != null) {
            this.mStreamUploader.stop();
            this.mStreamUploader.setNotifyListener(null);
            this.mStreamUploader = null;
        }
        AppMethodBeat.o(65908);
    }

    private void startQosModule() {
        AppMethodBeat.i(65909);
        this.mQos = new TXCQoS(true);
        this.mQos.setListener(this);
        this.mQos.setNotifyListener(this);
        this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
        this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
        this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
        this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
        if (this.mNewConfig.g) {
            this.mQos.start(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(65909);
    }

    private void stopQosModule() {
        AppMethodBeat.i(65910);
        if (this.mQos != null) {
            this.mQos.stop();
            this.mQos.setListener(null);
            this.mQos.setNotifyListener(null);
            this.mQos = null;
        }
        AppMethodBeat.o(65910);
    }

    private void startDataReportModule() {
        AppMethodBeat.i(65911);
        this.mDataReport = new d(this.mContext);
        this.mDataReport.d(this.mID);
        this.mDataReport.a(this.mNewConfig.c);
        this.mDataReport.b(this.mNewConfig.q);
        this.mDataReport.a(this.mNewConfig.a, this.mNewConfig.b);
        this.mDataReport.a(this.mPushUrl);
        this.mDataReport.a();
        AppMethodBeat.o(65911);
    }

    private void stopDataReportModule() {
        AppMethodBeat.i(65912);
        if (this.mDataReport != null) {
            this.mDataReport.b();
            this.mDataReport = null;
        }
        AppMethodBeat.o(65912);
    }

    private void startEncoder() {
        AppMethodBeat.i(65913);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(this.mID);
            this.mCaptureAndEnc.a((c.a) this);
            this.mCaptureAndEnc.b(this.mVoiceKind, this.mVoiceEnvironment);
            this.mCaptureAndEnc.b(this.mBgmPitch);
            this.mCaptureAndEnc.e();
        }
        AppMethodBeat.o(65913);
    }

    private void stopEncoder() {
        AppMethodBeat.i(65914);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.a(null);
            this.mCaptureAndEnc.f();
            this.mCaptureAndEnc.a(null);
        }
        AppMethodBeat.o(65914);
    }

    private void transferConfig(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.i(65915);
        f fVar = this.mNewConfig;
        fVar.c = tXLivePushConfig.mVideoBitrate;
        fVar.e = tXLivePushConfig.mMinVideoBitrate;
        fVar.d = tXLivePushConfig.mMaxVideoBitrate;
        fVar.f = tXLivePushConfig.mAutoAdjustStrategy;
        fVar.g = tXLivePushConfig.mAutoAdjustBitrate;
        fVar.h = tXLivePushConfig.mVideoFPS;
        fVar.i = tXLivePushConfig.mVideoEncodeGop;
        fVar.j = tXLivePushConfig.mHardwareAccel;
        fVar.k = tXLivePushConfig.mVideoResolution;
        fVar.n = tXLivePushConfig.mEnableVideoHardEncoderMainProfile;
        fVar.q = tXLivePushConfig.mAudioSample;
        fVar.r = tXLivePushConfig.mAudioChannels;
        fVar.s = tXLivePushConfig.mEnableAec;
        fVar.w = tXLivePushConfig.mPauseFlag;
        fVar.v = tXLivePushConfig.mPauseFps;
        fVar.t = tXLivePushConfig.mPauseImg;
        fVar.u = tXLivePushConfig.mPauseTime;
        fVar.F = tXLivePushConfig.mEnablePureAudioPush;
        fVar.D = tXLivePushConfig.mTouchFocus;
        fVar.E = tXLivePushConfig.mEnableZoom;
        fVar.x = tXLivePushConfig.mWatermark;
        fVar.y = tXLivePushConfig.mWatermarkX;
        fVar.z = tXLivePushConfig.mWatermarkY;
        fVar.A = tXLivePushConfig.mWatermarkXF;
        fVar.B = tXLivePushConfig.mWatermarkYF;
        fVar.C = tXLivePushConfig.mWatermarkWidth;
        fVar.l = tXLivePushConfig.mHomeOrientation;
        fVar.G = tXLivePushConfig.mEnableNearestIP;
        fVar.H = tXLivePushConfig.mRtmpChannelType;
        fVar.o = tXLivePushConfig.mConnectRetryCount;
        fVar.p = tXLivePushConfig.mConnectRetryInterval;
        fVar.m = tXLivePushConfig.mFrontCamera;
        fVar.K = tXLivePushConfig.mCustomModeType;
        fVar.L = tXLivePushConfig.mVideoEncoderXMirror;
        fVar.M = tXLivePushConfig.mEnableHighResolutionCapture;
        fVar.N = tXLivePushConfig.mEnableScreenCaptureAutoRotate;
        fVar.a();
        AppMethodBeat.o(65915);
    }

    private void applyConfig() {
        int i = 5;
        int i2 = 1;
        AppMethodBeat.i(65916);
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.o(65916);
            return;
        }
        this.mCaptureAndEnc.a(this.mNewConfig);
        if (this.mCaptureAndEnc.i()) {
            if (this.mStreamUploader != null) {
                if (this.mNewConfig.I) {
                    int i3 = this.mNewConfig.o;
                    int i4 = this.mNewConfig.p;
                    if (i3 >= 5) {
                        i = i3;
                    }
                    if (i4 <= 1) {
                        i2 = i4;
                    }
                    this.mStreamUploader.setRetryInterval(i2);
                    this.mStreamUploader.setRetryTimes(i);
                    this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.h, 1000);
                } else {
                    this.mStreamUploader.setRetryInterval(this.mNewConfig.p);
                    this.mStreamUploader.setRetryTimes(this.mNewConfig.o);
                    this.mStreamUploader.setVideoDropParams(true, 40, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                }
                this.mStreamUploader.setSendStrategy(this.mNewConfig.I, this.mNewConfig.J);
            }
            if (this.mQos != null) {
                this.mQos.stop();
                this.mQos.setAutoAdjustBitrate(this.mNewConfig.g);
                this.mQos.setAutoAdjustStrategy(this.mNewConfig.f);
                this.mQos.setDefaultVideoResolution(this.mNewConfig.k);
                this.mQos.setVideoEncBitrate(this.mNewConfig.e, this.mNewConfig.d, this.mNewConfig.c);
                if (this.mNewConfig.g) {
                    this.mQos.start(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    AppMethodBeat.o(65916);
                    return;
                }
            }
        } else if ((this.mNewConfig.K & 1) != 0) {
            if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.q, this.mNewConfig.r);
                AppMethodBeat.o(65916);
                return;
            }
        } else if (this.mStreamUploader != null) {
            this.mStreamUploader.setAudioInfo(this.mNewConfig.q, 1);
        }
        AppMethodBeat.o(65916);
    }

    private void transferPushEvent(int i, final Bundle bundle) {
        int i2;
        AppMethodBeat.i(65917);
        switch (i) {
            case TXLiveConstants.PUSH_ERR_INVALID_ADDRESS /*-1313*/:
                i2 = TXLiveConstants.PUSH_ERR_INVALID_ADDRESS;
                break;
            case TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT /*-1309*/:
                i2 = TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT;
                break;
            case TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED /*-1308*/:
                i2 = TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_START_FAILED;
                break;
            case TXLiveConstants.PUSH_ERR_NET_DISCONNECT /*-1307*/:
                i2 = TXLiveConstants.PUSH_ERR_NET_DISCONNECT;
                break;
            case TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL /*-1303*/:
                i2 = TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL;
                break;
            case TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL /*-1302*/:
                i2 = TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL;
                break;
            case TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL /*-1301*/:
                i2 = TXLiveConstants.PUSH_ERR_OPEN_CAMERA_FAIL;
                break;
            case 1001:
                i2 = 1001;
                break;
            case 1002:
                i2 = 1002;
                break;
            case 1003:
                i2 = 1003;
                break;
            case 1004:
                i2 = 1004;
                break;
            case 1005:
                i2 = 1005;
                break;
            case 1006:
                i2 = 1006;
                break;
            case 1007:
                i2 = 1007;
                break;
            case 1008:
                i2 = 1008;
                break;
            case 1018:
                i2 = 1018;
                break;
            case 1019:
                i2 = 1019;
                break;
            case 1020:
                i2 = 1020;
                break;
            case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                i2 = TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER;
                break;
            case 1101:
                i2 = 1101;
                break;
            case 1102:
                i2 = 1102;
                break;
            case 1103:
                i2 = 1103;
                break;
            case 1107:
                i2 = 1107;
                break;
            case 3002:
                i2 = 3002;
                break;
            case 3003:
                i2 = 3003;
                break;
            case 3004:
                i2 = 3004;
                break;
            case 3005:
                i2 = 3005;
                break;
            default:
                TXCLog.w(TAG, "unhandled event : ".concat(String.valueOf(i)));
                AppMethodBeat.o(65917);
                return;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65971);
                    if (TXLivePusher.this.mListener != null) {
                        TXLivePusher.this.mListener.onPushEvent(i2, bundle);
                    }
                    AppMethodBeat.o(65971);
                }
            });
        }
        AppMethodBeat.o(65917);
    }

    private byte[] transferAvccToAnnexb(byte[] bArr) {
        AppMethodBeat.i(65918);
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i = 0;
        while (i + 4 < length) {
            int i2 = ByteBuffer.wrap(bArr, i, 4).getInt();
            if ((i + 4) + i2 <= length) {
                bArr2[i] = (byte) 0;
                bArr2[i + 1] = (byte) 0;
                bArr2[i + 2] = (byte) 0;
                bArr2[i + 3] = (byte) 1;
            }
            i = (i + i2) + 4;
        }
        AppMethodBeat.o(65918);
        return bArr2;
    }

    private byte[] add_emulation_prevention_three_byte(byte[] bArr) {
        AppMethodBeat.i(65919);
        int length = ((bArr.length * 4) / 3) + 2;
        byte[] bArr2 = new byte[length];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length && i2 < length) {
            if (i + 3 < bArr.length && bArr[i] == (byte) 0 && bArr[i + 1] == (byte) 0 && bArr[i + 2] >= (byte) 0 && bArr[i + 2] <= (byte) 3) {
                int i3 = i2 + 1;
                int i4 = i + 1;
                bArr2[i2] = bArr[i];
                int i5 = i3 + 1;
                i = i4 + 1;
                bArr2[i3] = bArr[i4];
                i2 = i5 + 1;
                bArr2[i5] = (byte) 3;
            }
            bArr2[i2] = bArr[i];
            i++;
            i2++;
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        AppMethodBeat.o(65919);
        return bArr3;
    }

    @Deprecated
    public void sendMessage(byte[] bArr) {
        AppMethodBeat.i(65920);
        synchronized (this) {
            try {
                if (this.mMsgArray != null) {
                    MsgInfo msgInfo = new MsgInfo(this, null);
                    msgInfo.ts = TXCTimeUtil.getTimeTick();
                    msgInfo.msg = add_emulation_prevention_three_byte(bArr);
                    this.mMsgArray.add(msgInfo);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(65920);
            }
        }
    }

    public boolean sendMessageEx(byte[] bArr) {
        AppMethodBeat.i(65921);
        if (bArr.length <= 0 || bArr.length > 2048) {
            AppMethodBeat.o(65921);
            return false;
        }
        synchronized (this) {
            try {
                if (this.mMsgArray != null) {
                    MsgInfo msgInfo = new MsgInfo(this, null);
                    msgInfo.ts = TXCTimeUtil.getTimeTick();
                    msgInfo.msg = appendSEIBuffer(bArr.length, add_emulation_prevention_three_byte(bArr));
                    this.mMsgArray.add(msgInfo);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(65921);
            }
        }
        return true;
    }

    private byte[] appendSEIBuffer(int i, byte[] bArr) {
        AppMethodBeat.i(65922);
        byte[] intToBytes = intToBytes(i);
        byte[] bArr2 = new byte[(((intToBytes.length + 1) + bArr.length) + 1)];
        bArr2[0] = SEI_MSG_TYPE;
        System.arraycopy(intToBytes, 0, bArr2, 1, intToBytes.length);
        int length = intToBytes.length + 1;
        System.arraycopy(bArr, 0, bArr2, length, bArr.length);
        bArr2[length + bArr.length] = Byte.MIN_VALUE;
        AppMethodBeat.o(65922);
        return bArr2;
    }

    private byte[] intToBytes(int i) {
        int i2 = (i / 255) + 1;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2 - 1; i3++) {
            bArr[i3] = (byte) -1;
        }
        bArr[i2 - 1] = (byte) ((i % 255) & 255);
        return bArr;
    }

    private int getQuicMode(int i) {
        int a;
        AppMethodBeat.i(65923);
        switch (i) {
            case 1:
                a = (int) com.tencent.liteav.basic.f.b.a().a("QUICMode", "Live");
                break;
            case 2:
                a = (int) com.tencent.liteav.basic.f.b.a().a("QUICMode", "Live");
                break;
            case 3:
                a = (int) com.tencent.liteav.basic.f.b.a().a("QUICMode", "Live");
                break;
            case 4:
                a = (int) com.tencent.liteav.basic.f.b.a().a("QUICMode", "LinkMain");
                break;
            case 5:
                a = (int) com.tencent.liteav.basic.f.b.a().a("QUICMode", "LinkSub");
                break;
            case 6:
                a = (int) com.tencent.liteav.basic.f.b.a().a("QUICMode", "RTC");
                break;
            default:
                a = 0;
                break;
        }
        AppMethodBeat.o(65923);
        return a;
    }
}
