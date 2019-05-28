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
import com.tencent.liteav.C25658f;
import com.tencent.liteav.C41684c;
import com.tencent.liteav.C41684c.C0962a;
import com.tencent.liteav.C41687d;
import com.tencent.liteav.C45109m;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.audio.TXCAudioUGCRecorder;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C8802n;
import com.tencent.liteav.basic.p810c.C37352e;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.muxer.C8818c;
import com.tencent.liteav.network.C32171h;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.qos.C45113a;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
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

public class TXLivePusher implements C0946a, C0962a, C45109m, C45113a {
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
    private C41684c mCaptureAndEnc = null;
    private TXLivePushConfig mConfig = null;
    private Context mContext = null;
    private C41687d mDataReport = null;
    private String mID = "";
    private boolean mIsRecording = false;
    private HashMap<Integer, Long> mLastReportTime = new HashMap();
    private ITXLivePushListener mListener = null;
    private C8818c mMP4Muxer = null;
    private Handler mMainHandler = null;
    private ArrayList<MsgInfo> mMsgArray = new ArrayList();
    private C25658f mNewConfig = null;
    private boolean mNotifyStatus = false;
    private VideoCustomProcessListener mPreprocessListener;
    private String mPushUrl = "";
    private TXCQoS mQos = null;
    private ITXVideoRecordListener mRecordListener;
    private long mRecordStartTime = 0;
    private Runnable mSnapShotTimeOutRunnable = new C161372();
    private boolean mSnapshotRunning = false;
    private boolean mStartMuxer = false;
    private TXCStreamUploader mStreamUploader = null;
    private TXCloudVideoView mTXCloudVideoView;
    private HashSet<String> mUserList = new HashSet();
    private String mVideoFilePath = "";
    private int mVideoQuality = -1;
    private int mVoiceEnvironment = -1;
    private int mVoiceKind = -1;

    /* renamed from: com.tencent.rtmp.TXLivePusher$9 */
    class C58059 implements Runnable {
        C58059() {
        }

        public void run() {
            AppMethodBeat.m2504i(65972);
            if (TXLivePusher.this.mNotifyStatus) {
                TXLivePusher.access$900(TXLivePusher.this);
            }
            AppMethodBeat.m2505o(65972);
        }
    }

    /* renamed from: com.tencent.rtmp.TXLivePusher$2 */
    class C161372 implements Runnable {
        C161372() {
        }

        public void run() {
            AppMethodBeat.m2504i(65609);
            TXLivePusher.this.mSnapshotRunning = false;
            AppMethodBeat.m2505o(65609);
        }
    }

    public interface OnBGMNotify {
        void onBGMComplete(int i);

        void onBGMProgress(long j, long j2);

        void onBGMStart();
    }

    /* renamed from: com.tencent.rtmp.TXLivePusher$10 */
    class C3092110 implements Runnable {
        C3092110() {
        }

        public void run() {
            AppMethodBeat.m2504i(65930);
            if (TXLivePusher.this.mNotifyStatus) {
                TXLivePusher.access$900(TXLivePusher.this);
            }
            AppMethodBeat.m2505o(65930);
        }
    }

    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j, int i, int i2, int i3);

        void onRecordRawPcmData(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    /* renamed from: com.tencent.rtmp.TXLivePusher$5 */
    class C364195 implements Runnable {
        C364195() {
        }

        public void run() {
            AppMethodBeat.m2504i(65929);
            TXRecordResult tXRecordResult = new TXRecordResult();
            tXRecordResult.retCode = -1;
            tXRecordResult.descMsg = "record video failed";
            if (TXLivePusher.this.mRecordListener != null) {
                TXLivePusher.this.mRecordListener.onRecordComplete(tXRecordResult);
            }
            TXCLog.m15679w(TXLivePusher.TAG, "record complete fail");
            AppMethodBeat.m2505o(65929);
        }
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
        /* renamed from: ts */
        long f16227ts;

        private MsgInfo() {
        }

        /* synthetic */ MsgInfo(TXLivePusher tXLivePusher, C170791 c170791) {
            this();
        }
    }

    static /* synthetic */ void access$000(TXLivePusher tXLivePusher, ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        AppMethodBeat.m2504i(65924);
        tXLivePusher.postBitmapToMainThread(iTXSnapshotListener, bitmap);
        AppMethodBeat.m2505o(65924);
    }

    static /* synthetic */ void access$400(TXLivePusher tXLivePusher, String str, String str2) {
        AppMethodBeat.m2504i(65925);
        tXLivePusher.callbackRecordSuccess(str, str2);
        AppMethodBeat.m2505o(65925);
    }

    static /* synthetic */ void access$900(TXLivePusher tXLivePusher) {
        AppMethodBeat.m2504i(65926);
        tXLivePusher.statusNotify();
        AppMethodBeat.m2505o(65926);
    }

    static {
        AppMethodBeat.m2504i(65927);
        AppMethodBeat.m2505o(65927);
    }

    public TXLivePusher(Context context) {
        AppMethodBeat.m2504i(65825);
        TXCLog.init();
        this.mNewConfig = new C25658f();
        this.mContext = context.getApplicationContext();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mCaptureAndEnc = new C41684c(this.mContext);
        this.mCaptureAndEnc.mo67239a((C0946a) this);
        C37352e.m62754a().mo60118a(null, this.mContext);
        this.mLastReportTime.put(Integer.valueOf(TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL), Long.valueOf(0));
        this.mLastReportTime.put(Integer.valueOf(1101), Long.valueOf(0));
        this.mLastReportTime.put(Integer.valueOf(1006), Long.valueOf(0));
        AppMethodBeat.m2505o(65825);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.m2504i(65826);
        TXCLog.m15675d(TAG, "liteav_api setConfig " + tXLivePushConfig + ", " + this);
        if (tXLivePushConfig == null) {
            tXLivePushConfig = new TXLivePushConfig();
        }
        this.mConfig = tXLivePushConfig;
        transferConfig(tXLivePushConfig);
        applyConfig();
        String str = "setConfig:" + this.mNewConfig.f5309h + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.f5302a + "*" + this.mNewConfig.f5303b + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.f5304c + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.f5306e + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mNewConfig.f5305d;
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add(str);
            AppMethodBeat.m2505o(65826);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, str, "");
        AppMethodBeat.m2505o(65826);
    }

    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        AppMethodBeat.m2504i(65827);
        TXCLog.m15675d(TAG, "liteav_api setPushListener ".concat(String.valueOf(iTXLivePushListener)));
        this.mListener = iTXLivePushListener;
        AppMethodBeat.m2505o(65827);
    }

    public int startPusher(String str) {
        AppMethodBeat.m2504i(65828);
        TXCLog.m15675d(TAG, "liteav_api startPusher ".concat(String.valueOf(this)));
        if (TextUtils.isEmpty(str)) {
            TXCLog.m15676e(TAG, "start push error when url is empty ".concat(String.valueOf(this)));
            AppMethodBeat.m2505o(65828);
            return -1;
        }
        if (!TextUtils.isEmpty(this.mPushUrl) && isPushing()) {
            if (this.mPushUrl.equalsIgnoreCase(str)) {
                TXCLog.m15679w(TAG, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
                AppMethodBeat.m2505o(65828);
                return -1;
            }
            TXCLog.m15679w(TAG, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
            stopPusher();
        }
        TXCLog.m15675d(TAG, "================================================================================================================================================");
        TXCLog.m15675d(TAG, "================================================================================================================================================");
        TXCLog.m15675d(TAG, "============= startPush pushUrl = " + str + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
        TXCLog.m15675d(TAG, "================================================================================================================================================");
        TXCLog.m15675d(TAG, "================================================================================================================================================");
        this.mPushUrl = str;
        updateId(this.mPushUrl);
        startNetworkModule();
        startEncoder();
        startQosModule();
        startDataReportModule();
        Iterator it = this.mCallFuncBeforeStartPush.iterator();
        while (it.hasNext()) {
            TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, (String) it.next(), "");
        }
        this.mCallFuncBeforeStartPush.clear();
        TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "startPush", "");
        startStatusNotify();
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.clearLog();
        }
        AppMethodBeat.m2505o(65828);
        return 0;
    }

    public void stopPusher() {
        AppMethodBeat.m2504i(65829);
        TXCLog.m15675d(TAG, "liteav_api stopPusher ".concat(String.valueOf(this)));
        if (this.mPushUrl != null && this.mPushUrl.length() > 0) {
            TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "stopPush", "");
        }
        stopRecord();
        stopStatusNotify();
        stopDataReportModule();
        stopQosModule();
        stopEncoder();
        this.mNewConfig.f5296I = false;
        stopNetworkModule();
        this.mPushUrl = "";
        this.mUserList.clear();
        AppMethodBeat.m2505o(65829);
    }

    public void pausePusher() {
        AppMethodBeat.m2504i(65830);
        TXCLog.m15675d(TAG, "liteav_api pausePusher ".concat(String.valueOf(this)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67273g();
        }
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("pausePusher");
            AppMethodBeat.m2505o(65830);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "pausePusher", "");
        AppMethodBeat.m2505o(65830);
    }

    public void resumePusher() {
        AppMethodBeat.m2504i(65831);
        TXCLog.m15675d(TAG, "liteav_api resumePusher ".concat(String.valueOf(this)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67275h();
        }
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("resumePusher");
            AppMethodBeat.m2505o(65831);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "resumePusher", "");
        AppMethodBeat.m2505o(65831);
    }

    public boolean isPushing() {
        AppMethodBeat.m2504i(65832);
        if (this.mCaptureAndEnc != null) {
            boolean i = this.mCaptureAndEnc.mo67277i();
            AppMethodBeat.m2505o(65832);
            return i;
        }
        AppMethodBeat.m2505o(65832);
        return false;
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.m2504i(65833);
        TXCLog.m15675d(TAG, "liteav_api startCameraPreview " + tXCloudVideoView + ", " + this);
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("startPreview");
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "startPreview", "");
        }
        setConfig(this.mConfig);
        if (this.mNewConfig.f5293F) {
            TXCLog.m15676e(TAG, "enable pure audio push , so can not start preview!");
            AppMethodBeat.m2505o(65833);
            return;
        }
        if (!(this.mTXCloudVideoView == tXCloudVideoView || this.mTXCloudVideoView == null)) {
            this.mTXCloudVideoView.removeVideoView();
        }
        this.mTXCloudVideoView = tXCloudVideoView;
        if (this.mCaptureAndEnc == null) {
            this.mCaptureAndEnc = new C41684c(this.mContext);
        }
        this.mCaptureAndEnc.mo67239a((C0946a) this);
        this.mCaptureAndEnc.mo67241a((C0962a) this);
        this.mCaptureAndEnc.mo67245a(tXCloudVideoView);
        this.mCaptureAndEnc.mo67253b(this.mConfig.mBeautyLevel, this.mConfig.mWhiteningLevel, this.mConfig.mRuddyLevel);
        C37352e.m62754a().mo60118a(null, this.mContext);
        AppMethodBeat.m2505o(65833);
    }

    public void stopCameraPreview(boolean z) {
        AppMethodBeat.m2504i(65834);
        TXCLog.m15675d(TAG, "liteav_api stopCameraPreview " + z + ", " + this);
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("stopPreview");
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "stopPreview", "");
        }
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65834);
            return;
        }
        this.mCaptureAndEnc.mo67247a(z);
        AppMethodBeat.m2505o(65834);
    }

    public void setSurface(Surface surface) {
        AppMethodBeat.m2504i(65835);
        TXCLog.m15675d(TAG, "liteav_api setSurface ".concat(String.valueOf(surface)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65835);
            return;
        }
        this.mCaptureAndEnc.mo67238a(surface);
        AppMethodBeat.m2505o(65835);
    }

    public void setSurfaceSize(int i, int i2) {
        AppMethodBeat.m2504i(65836);
        TXCLog.m15675d(TAG, "liteav_api setSurfaceSize " + i + "," + i2);
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65836);
            return;
        }
        this.mCaptureAndEnc.mo67235a(i, i2);
        AppMethodBeat.m2505o(65836);
    }

    public void switchCamera() {
        AppMethodBeat.m2504i(65837);
        TXCLog.m15675d(TAG, "liteav_api switchCamera ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65837);
            return;
        }
        this.mCaptureAndEnc.mo67279j();
        AppMethodBeat.m2505o(65837);
    }

    public boolean turnOnFlashLight(boolean z) {
        AppMethodBeat.m2504i(65838);
        TXCLog.m15675d(TAG, "liteav_api turnOnFlashLight ".concat(String.valueOf(z)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65838);
            return false;
        }
        boolean b = this.mCaptureAndEnc.mo67255b(z);
        AppMethodBeat.m2505o(65838);
        return b;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(65839);
        TXCLog.m15675d(TAG, "liteav_api setMute ".concat(String.valueOf(z)));
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add("setMute:".concat(String.valueOf(z)));
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, "setMute:".concat(String.valueOf(z)), "");
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67265d(z);
        }
        if (this.mConfig.mEnablePureAudioPush && this.mStreamUploader != null) {
            this.mStreamUploader.setAudioMute(z);
        }
        AppMethodBeat.m2505o(65839);
    }

    public void onLogRecord(String str) {
        AppMethodBeat.m2504i(65840);
        TXCLog.m15675d("User", str);
        AppMethodBeat.m2505o(65840);
    }

    public int sendCustomVideoData(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(65841);
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
                    AppMethodBeat.m2505o(65841);
                    return -1000;
            }
            i4 = this.mCaptureAndEnc.mo67231a(bArr, i4, i2, i3);
            AppMethodBeat.m2505o(65841);
            return i4;
        }
        AppMethodBeat.m2505o(65841);
        return -1000;
    }

    public int sendCustomVideoTexture(int i, int i2, int i3) {
        AppMethodBeat.m2504i(65842);
        if (this.mCaptureAndEnc != null) {
            int c = this.mCaptureAndEnc.mo67257c(i, i2, i3);
            AppMethodBeat.m2505o(65842);
            return c;
        }
        AppMethodBeat.m2505o(65842);
        return -1000;
    }

    public void sendCustomPCMData(byte[] bArr) {
        AppMethodBeat.m2504i(65843);
        this.mCaptureAndEnc.mo67248a(bArr);
        AppMethodBeat.m2505o(65843);
    }

    public int getMaxZoom() {
        AppMethodBeat.m2504i(65844);
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65844);
            return 0;
        }
        int n = this.mCaptureAndEnc.mo67284n();
        AppMethodBeat.m2505o(65844);
        return n;
    }

    public boolean setZoom(int i) {
        AppMethodBeat.m2504i(65845);
        TXCLog.m15675d(TAG, "liteav_api setZoom ".concat(String.valueOf(i)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65845);
            return false;
        }
        boolean i2 = this.mCaptureAndEnc.mo67278i(i);
        AppMethodBeat.m2505o(65845);
        return i2;
    }

    public void setFocusPosition(float f, float f2) {
        AppMethodBeat.m2504i(65846);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67233a(f, f2);
        }
        AppMethodBeat.m2505o(65846);
    }

    public boolean setMirror(boolean z) {
        AppMethodBeat.m2504i(65847);
        TXCLog.m15675d(TAG, "liteav_api setMirror ".concat(String.valueOf(z)));
        if (this.mConfig != null) {
            this.mConfig.setVideoEncoderXMirror(z);
        }
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65847);
            return false;
        }
        this.mCaptureAndEnc.mo67270e(z);
        AppMethodBeat.m2505o(65847);
        return true;
    }

    public void setExposureCompensation(float f) {
        AppMethodBeat.m2504i(65848);
        TXCLog.m15675d(TAG, "liteav_api setExposureCompensation ".concat(String.valueOf(f)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65848);
            return;
        }
        this.mCaptureAndEnc.mo67258c(f);
        AppMethodBeat.m2505o(65848);
    }

    public void setBGMNofify(OnBGMNotify onBGMNotify) {
        AppMethodBeat.m2504i(65849);
        TXCLog.m15675d(TAG, "liteav_api setBGMNofify ".concat(String.valueOf(onBGMNotify)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67244a(onBGMNotify);
        }
        AppMethodBeat.m2505o(65849);
    }

    public boolean playBGM(String str) {
        AppMethodBeat.m2504i(65850);
        TXCLog.m15675d(TAG, "liteav_api playBGM ".concat(String.valueOf(str)));
        boolean c = this.mCaptureAndEnc.mo67261c(str);
        AppMethodBeat.m2505o(65850);
        return c;
    }

    public boolean stopBGM() {
        AppMethodBeat.m2504i(65851);
        TXCLog.m15675d(TAG, "liteav_api stopBGM ");
        boolean o = this.mCaptureAndEnc.mo67285o();
        AppMethodBeat.m2505o(65851);
        return o;
    }

    public boolean pauseBGM() {
        AppMethodBeat.m2504i(65852);
        TXCLog.m15675d(TAG, "liteav_api pauseBGM ");
        boolean p = this.mCaptureAndEnc.mo67286p();
        AppMethodBeat.m2505o(65852);
        return p;
    }

    public boolean resumeBGM() {
        AppMethodBeat.m2504i(65853);
        TXCLog.m15675d(TAG, "liteav_api resumeBGM ");
        boolean q = this.mCaptureAndEnc.mo67287q();
        AppMethodBeat.m2505o(65853);
        return q;
    }

    public boolean setMicVolume(float f) {
        AppMethodBeat.m2504i(65854);
        TXCLog.m15675d(TAG, "liteav_api setMicVolume ".concat(String.valueOf(f)));
        boolean d = this.mCaptureAndEnc.mo67266d(f);
        AppMethodBeat.m2505o(65854);
        return d;
    }

    public boolean setBGMVolume(float f) {
        AppMethodBeat.m2504i(65855);
        TXCLog.m15675d(TAG, "liteav_api setBGMVolume ".concat(String.valueOf(f)));
        boolean e = this.mCaptureAndEnc.mo67269e(f);
        AppMethodBeat.m2505o(65855);
        return e;
    }

    public void setBgmPitch(float f) {
        AppMethodBeat.m2504i(65856);
        this.mBgmPitch = f;
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67250b(f);
        }
        AppMethodBeat.m2505o(65856);
    }

    public int getMusicDuration(String str) {
        AppMethodBeat.m2504i(65857);
        int d = this.mCaptureAndEnc.mo67262d(str);
        AppMethodBeat.m2505o(65857);
        return d;
    }

    public void startScreenCapture() {
        AppMethodBeat.m2504i(65858);
        TXCLog.m15675d(TAG, "liteav_api startScreenCapture ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65858);
            return;
        }
        this.mCaptureAndEnc.mo67281k();
        AppMethodBeat.m2505o(65858);
    }

    public void stopScreenCapture() {
        AppMethodBeat.m2504i(65859);
        TXCLog.m15675d(TAG, "liteav_api stopScreenCapture ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65859);
            return;
        }
        this.mCaptureAndEnc.mo67282l();
        AppMethodBeat.m2505o(65859);
    }

    public void setRenderRotation(int i) {
        AppMethodBeat.m2504i(65860);
        TXCLog.m15675d(TAG, "liteav_api setRenderRotation ");
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65860);
            return;
        }
        this.mCaptureAndEnc.mo67234a(i);
        AppMethodBeat.m2505o(65860);
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        AppMethodBeat.m2504i(65861);
        TXCLog.m15675d(TAG, "liteav_api setVideoProcessListener ".concat(String.valueOf(videoCustomProcessListener)));
        this.mPreprocessListener = videoCustomProcessListener;
        if (this.mPreprocessListener == null) {
            if (this.mCaptureAndEnc != null) {
                this.mCaptureAndEnc.mo67243a(null);
                AppMethodBeat.m2505o(65861);
                return;
            }
        } else if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67243a((C45109m) this);
        }
        AppMethodBeat.m2505o(65861);
    }

    public void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        AppMethodBeat.m2504i(65862);
        TXCLog.m15675d(TAG, "liteav_api setAudioProcessListener ".concat(String.valueOf(audioCustomProcessListener)));
        this.mAudioProcessListener = audioCustomProcessListener;
        AppMethodBeat.m2505o(65862);
    }

    public void snapshot(final ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.m2504i(65863);
        TXCLog.m15675d(TAG, "liteav_api snapshot ".concat(String.valueOf(iTXSnapshotListener)));
        if (this.mSnapshotRunning || iTXSnapshotListener == null || this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65863);
        } else if (this.mCaptureAndEnc != null) {
            this.mSnapshotRunning = true;
            this.mCaptureAndEnc.mo67240a(new C8802n() {
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.m2504i(65989);
                    TXLivePusher.access$000(TXLivePusher.this, iTXSnapshotListener, bitmap);
                    TXLivePusher.this.mSnapshotRunning = false;
                    TXLivePusher.this.mMainHandler.removeCallbacks(TXLivePusher.this.mSnapShotTimeOutRunnable);
                    AppMethodBeat.m2505o(65989);
                }
            });
            this.mMainHandler.postDelayed(this.mSnapShotTimeOutRunnable, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(65863);
        } else {
            this.mSnapshotRunning = false;
            AppMethodBeat.m2505o(65863);
        }
    }

    public int startRecord(String str) {
        AppMethodBeat.m2504i(65864);
        TXCLog.m15675d(TAG, "liteav_api startRecord ".concat(String.valueOf(str)));
        if (VERSION.SDK_INT < 18) {
            TXCLog.m15676e(TAG, "API levl is too low (record need 18, current is" + VERSION.SDK_INT + ")");
            AppMethodBeat.m2505o(65864);
            return -3;
        } else if (this.mIsRecording) {
            TXCLog.m15679w(TAG, "ignore start record when recording");
            AppMethodBeat.m2505o(65864);
            return -1;
        } else if (this.mCaptureAndEnc == null || !this.mCaptureAndEnc.mo67277i()) {
            TXCLog.m15679w(TAG, "ignore start record when not pushing");
            AppMethodBeat.m2505o(65864);
            return -2;
        } else {
            TXCLog.m15679w(TAG, "start record ");
            this.mIsRecording = true;
            this.mVideoFilePath = str;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            this.mMP4Muxer = new C8818c(this.mContext, 1);
            this.mStartMuxer = false;
            this.mMP4Muxer.mo19919a(this.mVideoFilePath);
            addAudioTrack();
            TXCDRApi.txReportDAU(this.mContext.getApplicationContext(), C8795a.f2514aM);
            if (this.mCaptureAndEnc != null) {
                this.mCaptureAndEnc.mo67288s();
            }
            AppMethodBeat.m2505o(65864);
            return 0;
        }
    }

    public void stopRecord() {
        AppMethodBeat.m2504i(65865);
        TXCLog.m15675d(TAG, "liteav_api stopRecord ");
        if (this.mIsRecording && this.mMP4Muxer != null) {
            int b = this.mMP4Muxer.mo19922b();
            TXCLog.m15679w(TAG, "start record ");
            this.mIsRecording = false;
            if (b == 0) {
                final String str = this.mVideoFilePath;
                AsyncTask.execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.m2504i(65593);
                        File parentFile = new File(str).getParentFile();
                        String format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
                        String str = parentFile + File.separator + String.format("TXUGCCover_%s.jpg", new Object[]{format});
                        C17778b.m27746a(str, str);
                        TXLivePusher.access$400(TXLivePusher.this, str, str);
                        AppMethodBeat.m2505o(65593);
                    }
                });
                AppMethodBeat.m2505o(65865);
                return;
            }
            callbackRecordFail();
        }
        AppMethodBeat.m2505o(65865);
    }

    public void setVideoRecordListener(ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.m2504i(65866);
        TXCLog.m15675d(TAG, "liteav_api setVideoRecordListener ".concat(String.valueOf(iTXVideoRecordListener)));
        this.mRecordListener = iTXVideoRecordListener;
        AppMethodBeat.m2505o(65866);
    }

    public boolean setBeautyFilter(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(65867);
        TXCLog.m15675d(TAG, "liteav_api setBeautyFilter " + i + ", " + i2 + ", " + i3 + ", " + i4);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67251b(i);
            this.mCaptureAndEnc.mo67253b(i2, i3, i4);
        }
        if (this.mConfig != null) {
            this.mConfig.mBeautyLevel = i2;
            this.mConfig.mWhiteningLevel = i3;
            this.mConfig.mRuddyLevel = i4;
        }
        AppMethodBeat.m2505o(65867);
        return true;
    }

    public void setFilter(Bitmap bitmap) {
        AppMethodBeat.m2504i(65868);
        TXCLog.m15675d(TAG, "liteav_api setFilter ".concat(String.valueOf(bitmap)));
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67237a(bitmap);
        }
        AppMethodBeat.m2505o(65868);
    }

    public void setMotionTmpl(String str) {
        AppMethodBeat.m2504i(65869);
        TXCLog.m15675d(TAG, "liteav_api motionPath ".concat(String.valueOf(str)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67246a(str);
        }
        AppMethodBeat.m2505o(65869);
    }

    public void setMotionMute(boolean z) {
        AppMethodBeat.m2504i(65870);
        TXCLog.m15675d(TAG, "liteav_api setMotionMute ".concat(String.valueOf(z)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67260c(z);
        }
        AppMethodBeat.m2505o(65870);
    }

    @TargetApi(18)
    public boolean setGreenScreenFile(String str) {
        AppMethodBeat.m2504i(65871);
        TXCLog.m15675d(TAG, "liteav_api setGreenScreenFile ".concat(String.valueOf(str)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            boolean b = this.mCaptureAndEnc.mo67254b(str);
            AppMethodBeat.m2505o(65871);
            return b;
        }
        AppMethodBeat.m2505o(65871);
        return false;
    }

    public void setEyeScaleLevel(int i) {
        AppMethodBeat.m2504i(65872);
        TXCLog.m15675d(TAG, "liteav_api setEyeScaleLevel ".concat(String.valueOf(i)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mConfig != null) {
            this.mConfig.setEyeScaleLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67259c(i);
        }
        AppMethodBeat.m2505o(65872);
    }

    public void setFaceSlimLevel(int i) {
        AppMethodBeat.m2504i(65873);
        TXCLog.m15675d(TAG, "liteav_api setFaceSlimLevel ".concat(String.valueOf(i)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mConfig != null) {
            this.mConfig.setFaceSlimLevel(i);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67264d(i);
        }
        AppMethodBeat.m2505o(65873);
    }

    public void setFaceVLevel(int i) {
        AppMethodBeat.m2504i(65874);
        TXCLog.m15675d(TAG, "liteav_api setFaceVLevel ".concat(String.valueOf(i)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67268e(i);
        }
        AppMethodBeat.m2505o(65874);
    }

    public void setSpecialRatio(float f) {
        AppMethodBeat.m2504i(65875);
        TXCLog.m15675d(TAG, "liteav_api setSpecialRatio ".concat(String.valueOf(f)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67232a(f);
        }
        AppMethodBeat.m2505o(65875);
    }

    public void setFaceShortLevel(int i) {
        AppMethodBeat.m2504i(65876);
        TXCLog.m15675d(TAG, "liteav_api setFaceShortLevel ".concat(String.valueOf(i)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67272f(i);
        }
        AppMethodBeat.m2505o(65876);
    }

    public void setChinLevel(int i) {
        AppMethodBeat.m2504i(65877);
        TXCLog.m15675d(TAG, "liteav_api setChinLevel ".concat(String.valueOf(i)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67274g(i);
        }
        AppMethodBeat.m2505o(65877);
    }

    public void setNoseSlimLevel(int i) {
        AppMethodBeat.m2504i(65878);
        TXCLog.m15675d(TAG, "liteav_api setNoseSlimLevel ".concat(String.valueOf(i)));
        C37352e.m62754a().mo60118a(null, this.mContext);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67276h(i);
        }
        AppMethodBeat.m2505o(65878);
    }

    public void setVideoQuality(int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5 = false;
        int i2 = 1;
        AppMethodBeat.m2504i(65879);
        TXCLog.m15675d(TAG, "liteav_api setVideoQuality " + i + ", " + z + ", " + z2);
        if (VERSION.SDK_INT < 18 && (i == 2 || i == 3)) {
            i = 1;
        }
        String str = "setVideoQuality:" + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + z + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + z2;
        if (this.mPushUrl == null || this.mPushUrl.length() <= 0) {
            this.mCallFuncBeforeStartPush.add(str);
        } else {
            TXCDRApi.reportEvent40003(this.mPushUrl, C8795a.f2490P, 0, str, "");
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
                TXCLog.m15676e(TAG, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(65879);
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
            this.mNewConfig.f5296I = z4;
            this.mNewConfig.f5297J = z3;
        }
        setConfig(this.mConfig);
        AppMethodBeat.m2505o(65879);
    }

    public void setReverb(int i) {
        AppMethodBeat.m2504i(65880);
        TXCLog.m15675d(TAG, "liteav_api setReverb ".concat(String.valueOf(i)));
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65880);
            return;
        }
        this.mCaptureAndEnc.mo67280j(i);
        AppMethodBeat.m2505o(65880);
    }

    public void setVoiceChangerType(int i) {
        AppMethodBeat.m2504i(65881);
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
            this.mCaptureAndEnc.mo67252b(this.mVoiceKind, this.mVoiceEnvironment);
        }
        AppMethodBeat.m2505o(65881);
    }

    public void onNotifyEvent(final int i, final Bundle bundle) {
        int i2 = 1;
        AppMethodBeat.m2504i(65882);
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(65932);
                    if (TXLivePusher.this.mTXCloudVideoView != null) {
                        TXLivePusher.this.mTXCloudVideoView.setLogText(null, bundle, i);
                    }
                    AppMethodBeat.m2505o(65932);
                }
            });
        }
        transferPushEvent(i, bundle);
        String str = this.mPushUrl;
        if (str != null && str.length() > 0) {
            if (i == 1018 || i == 1019 || i == TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER || i == 1020) {
                switch (i) {
                    case 1018:
                        TXCDRApi.reportEvent40003(str, C8795a.f2492R, 0, "enter", "");
                        AppMethodBeat.m2505o(65882);
                        return;
                    case 1019:
                        TXCDRApi.reportEvent40003(str, C8795a.f2492R, 0, "exit", "");
                        AppMethodBeat.m2505o(65882);
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
                                    TXCDRApi.reportEvent40003(str, C8795a.f2492R, 0, "userlist:", "");
                                    AppMethodBeat.m2505o(65882);
                                    return;
                                }
                                this.mUserList.clear();
                                this.mUserList.addAll(hashSet);
                                TXCDRApi.reportEvent40003(str, C8795a.f2492R, 0, "userlist:" + stringBuilder.toString(), "");
                            }
                            AppMethodBeat.m2505o(65882);
                            return;
                        } catch (JSONException e) {
                            AppMethodBeat.m2505o(65882);
                            return;
                        }
                    case TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER /*1021*/:
                        TXCDRApi.reportEvent40003(str, C8795a.f2492R, 0, "reenter", "");
                        AppMethodBeat.m2505o(65882);
                        return;
                    default:
                        AppMethodBeat.m2505o(65882);
                        return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL || i == 1101 || i == 1006) {
                if (currentTimeMillis - ((Long) this.mLastReportTime.get(Integer.valueOf(i))).longValue() < 5000) {
                    AppMethodBeat.m2505o(65882);
                    return;
                }
                this.mLastReportTime.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            }
            if (!(i == 1018 || i == 1019 || i == TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER || i == 1020)) {
                TXCDRApi.reportEvent40003(str, C8795a.f2491Q, i, bundle.getString(TXLiveConstants.EVT_DESCRIPTION), "");
            }
        }
        AppMethodBeat.m2505o(65882);
    }

    public int onTextureCustomProcess(int i, int i2, int i3) {
        AppMethodBeat.m2504i(65883);
        if (this.mPreprocessListener != null) {
            int onTextureCustomProcess = this.mPreprocessListener.onTextureCustomProcess(i, i2, i3);
            AppMethodBeat.m2505o(65883);
            return onTextureCustomProcess;
        }
        AppMethodBeat.m2505o(65883);
        return 0;
    }

    public void onDetectFacePoints(float[] fArr) {
        AppMethodBeat.m2504i(65884);
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onDetectFacePoints(fArr);
        }
        AppMethodBeat.m2505o(65884);
    }

    public void onTextureDestoryed() {
        AppMethodBeat.m2504i(65885);
        if (this.mPreprocessListener != null) {
            this.mPreprocessListener.onTextureDestoryed();
        }
        AppMethodBeat.m2505o(65885);
    }

    public int onGetEncoderRealBitrate() {
        AppMethodBeat.m2504i(65886);
        int d = TXCStatus.m40656d(this.mID, WearableStatusCodes.UNKNOWN_LISTENER);
        AppMethodBeat.m2505o(65886);
        return d;
    }

    public int onGetQueueInputSize() {
        AppMethodBeat.m2504i(65887);
        int d = TXCStatus.m40656d(this.mID, 7002);
        if (this.mNewConfig.f5296I) {
            d += TXCStatus.m40656d(this.mID, 7001);
        } else {
            d += TXCStatus.m40656d(this.mID, WearableStatusCodes.UNKNOWN_LISTENER);
        }
        AppMethodBeat.m2505o(65887);
        return d;
    }

    public int onGetQueueOutputSize() {
        AppMethodBeat.m2504i(65888);
        if (this.mStreamUploader == null) {
            AppMethodBeat.m2505o(65888);
            return 0;
        }
        int d = TXCStatus.m40656d(this.mID, 7004) + TXCStatus.m40656d(this.mID, 7003);
        AppMethodBeat.m2505o(65888);
        return d;
    }

    public int onGetVideoQueueMaxCount() {
        return 5;
    }

    public int onGetVideoQueueCurrentCount() {
        AppMethodBeat.m2504i(65889);
        int d = TXCStatus.m40656d(this.mID, 7005);
        AppMethodBeat.m2505o(65889);
        return d;
    }

    public int onGetVideoDropCount() {
        AppMethodBeat.m2504i(65890);
        int d = TXCStatus.m40656d(this.mID, 7007);
        AppMethodBeat.m2505o(65890);
        return d;
    }

    public void onEncoderParamsChanged(int i, int i2, int i3) {
        AppMethodBeat.m2504i(65891);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67236a(i, i2, i3);
        }
        if (!(i2 == 0 || i3 == 0)) {
            this.mNewConfig.f5302a = i2;
            this.mNewConfig.f5303b = i3;
        }
        if (i != 0) {
            this.mNewConfig.f5304c = i;
        }
        AppMethodBeat.m2505o(65891);
    }

    public void onEnableDropStatusChanged(boolean z) {
        AppMethodBeat.m2504i(65892);
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setDropEanble(z);
        }
        AppMethodBeat.m2505o(65892);
    }

    public void onEncAudio(byte[] bArr, long j, int i, int i2) {
        AppMethodBeat.m2504i(65893);
        if (!(this.mStreamUploader == null || bArr == null)) {
            this.mStreamUploader.pushAAC(bArr, j);
        }
        if (this.mIsRecording && this.mMP4Muxer != null && this.mStartMuxer && bArr != null) {
            this.mMP4Muxer.mo19921a(bArr, 0, bArr.length, 1000 * j, 0);
        }
        AppMethodBeat.m2505o(65893);
    }

    public void onEncVideo(C25649b c25649b) {
        AppMethodBeat.m2504i(65894);
        if (this.mQos != null) {
            this.mQos.setHasVideo(true);
        }
        if (!(this.mStreamUploader == null || c25649b == null || c25649b.f5251a == null)) {
            synchronized (this) {
                try {
                    if (!(this.mMsgArray == null || this.mMsgArray.isEmpty())) {
                        MsgInfo msgInfo;
                        Iterator it = this.mMsgArray.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            msgInfo = (MsgInfo) it.next();
                            if (msgInfo.f16227ts > c25649b.f5257g) {
                                break;
                            }
                            i = ((msgInfo.msg.length <= 10240 ? msgInfo.msg.length : 10240) + 5) + i;
                        }
                        if (i != 0) {
                            int i2;
                            byte[] bArr = new byte[(c25649b.f5251a.length + i)];
                            byte[] bArr2 = new byte[5];
                            Iterator it2 = this.mMsgArray.iterator();
                            i = 0;
                            int i3 = 0;
                            while (it2.hasNext()) {
                                msgInfo = (MsgInfo) it2.next();
                                if (msgInfo.f16227ts > c25649b.f5257g) {
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
                            System.arraycopy(c25649b.f5251a, 0, bArr, i3, c25649b.f5251a.length);
                            c25649b.f5251a = bArr;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(65894);
                    }
                }
            }
            this.mStreamUploader.pushNAL(c25649b);
        }
        if (!(!this.mIsRecording || this.mMP4Muxer == null || c25649b == null || c25649b.f5251a == null)) {
            byte[] transferAvccToAnnexb = transferAvccToAnnexb(c25649b.f5251a);
            if (!this.mStartMuxer) {
                if (c25649b.f5252b == 0) {
                    MediaFormat a = C17778b.m27737a(transferAvccToAnnexb, this.mCaptureAndEnc.mo67249b(), this.mCaptureAndEnc.mo67256c());
                    if (a != null) {
                        this.mMP4Muxer.mo19918a(a);
                        this.mMP4Muxer.mo19917a();
                        this.mStartMuxer = true;
                        this.mRecordStartTime = 0;
                    }
                }
            }
            recordVideoData(c25649b, transferAvccToAnnexb);
        }
        AppMethodBeat.m2505o(65894);
    }

    public void onRecordRawPcm(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(65895);
        AudioCustomProcessListener audioCustomProcessListener = this.mAudioProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j, i, i2, i3, z);
        }
        AppMethodBeat.m2505o(65895);
    }

    public void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(65896);
        AudioCustomProcessListener audioCustomProcessListener = this.mAudioProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j, i, i2, i3);
        }
        AppMethodBeat.m2505o(65896);
    }

    public void onEncVideoFormat(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(65897);
        if (this.mIsRecording && this.mMP4Muxer != null) {
            this.mMP4Muxer.mo19918a(mediaFormat);
            if (!this.mStartMuxer) {
                this.mMP4Muxer.mo19917a();
                this.mStartMuxer = true;
                this.mRecordStartTime = 0;
            }
        }
        AppMethodBeat.m2505o(65897);
    }

    private void callbackRecordFail() {
        AppMethodBeat.m2504i(65898);
        this.mMainHandler.post(new C364195());
        AppMethodBeat.m2505o(65898);
    }

    private void callbackRecordSuccess(final String str, final String str2) {
        AppMethodBeat.m2504i(65899);
        this.mMainHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(65933);
                TXRecordResult tXRecordResult = new TXRecordResult();
                tXRecordResult.retCode = 0;
                tXRecordResult.descMsg = "record success";
                tXRecordResult.videoPath = str;
                tXRecordResult.coverPath = str2;
                if (TXLivePusher.this.mRecordListener != null) {
                    TXLivePusher.this.mRecordListener.onRecordComplete(tXRecordResult);
                }
                TXCLog.m15679w(TXLivePusher.TAG, "record complete success");
                AppMethodBeat.m2505o(65933);
            }
        });
        AppMethodBeat.m2505o(65899);
    }

    @TargetApi(16)
    private void addAudioTrack() {
        AppMethodBeat.m2504i(65900);
        MediaFormat a = C17778b.m27736a(TXCAudioUGCRecorder.getInstance().getSampleRate(), TXCAudioUGCRecorder.getInstance().getChannels(), 2);
        if (this.mMP4Muxer != null) {
            this.mMP4Muxer.mo19923b(a);
        }
        AppMethodBeat.m2505o(65900);
    }

    private void recordVideoData(C25649b c25649b, byte[] bArr) {
        AppMethodBeat.m2504i(65901);
        if (this.mRecordStartTime == 0) {
            this.mRecordStartTime = c25649b.f5257g;
        }
        final long j = c25649b.f5257g - this.mRecordStartTime;
        int i = c25649b.f5261k == null ? c25649b.f5252b == 0 ? 1 : 0 : c25649b.f5261k.flags;
        this.mMP4Muxer.mo19925b(bArr, 0, bArr.length, c25649b.f5257g * 1000, i);
        this.mMainHandler.post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(65592);
                if (TXLivePusher.this.mRecordListener != null) {
                    TXLivePusher.this.mRecordListener.onRecordProgress(j);
                }
                AppMethodBeat.m2505o(65592);
            }
        });
        AppMethodBeat.m2505o(65901);
    }

    private void postBitmapToMainThread(final ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        AppMethodBeat.m2504i(65902);
        if (iTXSnapshotListener == null) {
            AppMethodBeat.m2505o(65902);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(65928);
                if (iTXSnapshotListener != null) {
                    iTXSnapshotListener.onSnapshot(bitmap);
                }
                AppMethodBeat.m2505o(65928);
            }
        });
        AppMethodBeat.m2505o(65902);
    }

    private void setAdjustStrategy(boolean z, boolean z2) {
        AppMethodBeat.m2504i(65903);
        int adjustStrategy = getAdjustStrategy(z, z2);
        if (adjustStrategy == -1) {
            this.mConfig.setAutoAdjustBitrate(false);
            this.mConfig.setAutoAdjustStrategy(-1);
            AppMethodBeat.m2505o(65903);
            return;
        }
        this.mConfig.setAutoAdjustBitrate(true);
        this.mConfig.setAutoAdjustStrategy(adjustStrategy);
        AppMethodBeat.m2505o(65903);
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
        AppMethodBeat.m2504i(65904);
        String format = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.mStreamUploader != null) {
            this.mStreamUploader.setID(format);
        }
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(format);
        }
        if (this.mDataReport != null) {
            this.mDataReport.mo67300d(format);
        }
        this.mID = format;
        AppMethodBeat.m2505o(65904);
    }

    private void startStatusNotify() {
        AppMethodBeat.m2504i(65905);
        this.mNotifyStatus = true;
        if (this.mMainHandler != null) {
            this.mMainHandler.postDelayed(new C58059(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(65905);
    }

    private void stopStatusNotify() {
        this.mNotifyStatus = false;
    }

    private void statusNotify() {
        AppMethodBeat.m2504i(65906);
        int[] a = C17778b.m27747a();
        int i = a[0] / 10;
        String str = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.m40656d(this.mID, 7004);
        int d2 = TXCStatus.m40656d(this.mID, 7003);
        int d3 = TXCStatus.m40656d(this.mID, 7002);
        int d4 = TXCStatus.m40656d(this.mID, 7001);
        int d5 = TXCStatus.m40656d(this.mID, 7007);
        int d6 = TXCStatus.m40656d(this.mID, 7005);
        int d7 = TXCStatus.m40656d(this.mID, 7006);
        String c = TXCStatus.m40655c(this.mID, 7012);
        double e = TXCStatus.m40657e(this.mID, WearableStatusCodes.DUPLICATE_LISTENER);
        int d8 = TXCStatus.m40656d(this.mID, WearableStatusCodes.DATA_ITEM_TOO_LARGE);
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
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.mCaptureAndEnc.mo67263d());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.mCaptureAndEnc.mo67249b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.mCaptureAndEnc.mo67256c());
        }
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setLogText(bundle, null, 0);
        }
        if (this.mListener != null) {
            this.mListener.onNetStatus(bundle);
        }
        if (this.mDataReport != null) {
            this.mDataReport.mo67301e();
        }
        if (this.mMainHandler != null && this.mNotifyStatus) {
            this.mMainHandler.postDelayed(new C3092110(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(65906);
    }

    private void startNetworkModule() {
        int i = 5;
        int i2 = 1;
        AppMethodBeat.m2504i(65907);
        C32171h c32171h = new C32171h();
        c32171h.f14924d = C8790b.m15606a().mo19847d();
        c32171h.f14925e = C8790b.m15606a().mo19849e();
        c32171h.f14921a = 0;
        c32171h.f14923c = 20;
        c32171h.f14922b = 0;
        c32171h.f14926f = 3;
        c32171h.f14930j = true;
        c32171h.f14932l = true;
        c32171h.f14931k = false;
        c32171h.f14928h = 40;
        c32171h.f14929i = 5000;
        c32171h.f14933m = this.mNewConfig.f5296I;
        c32171h.f14934n = this.mNewConfig.f5297J;
        c32171h.f14935o = getQuicMode(this.mVideoQuality);
        this.mStreamUploader = new TXCStreamUploader(this.mContext, c32171h);
        this.mStreamUploader.setID(this.mID);
        if ((this.mNewConfig.f5298K & 1) != 0) {
            if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.f5318q, this.mNewConfig.f5319r);
            }
        } else if (this.mStreamUploader != null) {
            this.mStreamUploader.setAudioInfo(this.mNewConfig.f5318q, 1);
        }
        this.mStreamUploader.setNotifyListener(this);
        if (this.mConfig.mEnablePureAudioPush && this.mCaptureAndEnc != null) {
            this.mStreamUploader.setAudioMute(this.mCaptureAndEnc.mo67283m());
        }
        this.mPushUrl = this.mStreamUploader.start(this.mPushUrl, this.mNewConfig.f5294G, this.mNewConfig.f5295H);
        if (this.mNewConfig.f5293F) {
            this.mStreamUploader.setMode(1);
        }
        if (this.mNewConfig.f5296I) {
            int i3 = this.mNewConfig.f5316o;
            int i4 = this.mNewConfig.f5317p;
            if (i3 >= 5) {
                i = i3;
            }
            if (i4 <= 1) {
                i2 = i4;
            }
            this.mStreamUploader.setRetryInterval(i2);
            this.mStreamUploader.setRetryTimes(i);
            this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.f5309h, 1000);
        } else {
            this.mStreamUploader.setRetryInterval(this.mNewConfig.f5317p);
            this.mStreamUploader.setRetryTimes(this.mNewConfig.f5316o);
            this.mStreamUploader.setVideoDropParams(true, 40, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        }
        this.mStreamUploader.setSendStrategy(this.mNewConfig.f5296I, this.mNewConfig.f5297J);
        AppMethodBeat.m2505o(65907);
    }

    private void stopNetworkModule() {
        AppMethodBeat.m2504i(65908);
        if (this.mStreamUploader != null) {
            this.mStreamUploader.stop();
            this.mStreamUploader.setNotifyListener(null);
            this.mStreamUploader = null;
        }
        AppMethodBeat.m2505o(65908);
    }

    private void startQosModule() {
        AppMethodBeat.m2504i(65909);
        this.mQos = new TXCQoS(true);
        this.mQos.setListener(this);
        this.mQos.setNotifyListener(this);
        this.mQos.setAutoAdjustBitrate(this.mNewConfig.f5308g);
        this.mQos.setAutoAdjustStrategy(this.mNewConfig.f5307f);
        this.mQos.setDefaultVideoResolution(this.mNewConfig.f5312k);
        this.mQos.setVideoEncBitrate(this.mNewConfig.f5306e, this.mNewConfig.f5305d, this.mNewConfig.f5304c);
        if (this.mNewConfig.f5308g) {
            this.mQos.start(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(65909);
    }

    private void stopQosModule() {
        AppMethodBeat.m2504i(65910);
        if (this.mQos != null) {
            this.mQos.stop();
            this.mQos.setListener(null);
            this.mQos.setNotifyListener(null);
            this.mQos = null;
        }
        AppMethodBeat.m2505o(65910);
    }

    private void startDataReportModule() {
        AppMethodBeat.m2504i(65911);
        this.mDataReport = new C41687d(this.mContext);
        this.mDataReport.mo67300d(this.mID);
        this.mDataReport.mo67291a(this.mNewConfig.f5304c);
        this.mDataReport.mo67296b(this.mNewConfig.f5318q);
        this.mDataReport.mo67292a(this.mNewConfig.f5302a, this.mNewConfig.f5303b);
        this.mDataReport.mo67293a(this.mPushUrl);
        this.mDataReport.mo67290a();
        AppMethodBeat.m2505o(65911);
    }

    private void stopDataReportModule() {
        AppMethodBeat.m2504i(65912);
        if (this.mDataReport != null) {
            this.mDataReport.mo67295b();
            this.mDataReport = null;
        }
        AppMethodBeat.m2505o(65912);
    }

    private void startEncoder() {
        AppMethodBeat.m2504i(65913);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.setID(this.mID);
            this.mCaptureAndEnc.mo67241a((C0962a) this);
            this.mCaptureAndEnc.mo67252b(this.mVoiceKind, this.mVoiceEnvironment);
            this.mCaptureAndEnc.mo67250b(this.mBgmPitch);
            this.mCaptureAndEnc.mo67267e();
        }
        AppMethodBeat.m2505o(65913);
    }

    private void stopEncoder() {
        AppMethodBeat.m2504i(65914);
        if (this.mCaptureAndEnc != null) {
            this.mCaptureAndEnc.mo67241a(null);
            this.mCaptureAndEnc.mo67271f();
            this.mCaptureAndEnc.mo67241a(null);
        }
        AppMethodBeat.m2505o(65914);
    }

    private void transferConfig(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.m2504i(65915);
        C25658f c25658f = this.mNewConfig;
        c25658f.f5304c = tXLivePushConfig.mVideoBitrate;
        c25658f.f5306e = tXLivePushConfig.mMinVideoBitrate;
        c25658f.f5305d = tXLivePushConfig.mMaxVideoBitrate;
        c25658f.f5307f = tXLivePushConfig.mAutoAdjustStrategy;
        c25658f.f5308g = tXLivePushConfig.mAutoAdjustBitrate;
        c25658f.f5309h = tXLivePushConfig.mVideoFPS;
        c25658f.f5310i = tXLivePushConfig.mVideoEncodeGop;
        c25658f.f5311j = tXLivePushConfig.mHardwareAccel;
        c25658f.f5312k = tXLivePushConfig.mVideoResolution;
        c25658f.f5315n = tXLivePushConfig.mEnableVideoHardEncoderMainProfile;
        c25658f.f5318q = tXLivePushConfig.mAudioSample;
        c25658f.f5319r = tXLivePushConfig.mAudioChannels;
        c25658f.f5320s = tXLivePushConfig.mEnableAec;
        c25658f.f5324w = tXLivePushConfig.mPauseFlag;
        c25658f.f5323v = tXLivePushConfig.mPauseFps;
        c25658f.f5321t = tXLivePushConfig.mPauseImg;
        c25658f.f5322u = tXLivePushConfig.mPauseTime;
        c25658f.f5293F = tXLivePushConfig.mEnablePureAudioPush;
        c25658f.f5291D = tXLivePushConfig.mTouchFocus;
        c25658f.f5292E = tXLivePushConfig.mEnableZoom;
        c25658f.f5325x = tXLivePushConfig.mWatermark;
        c25658f.f5326y = tXLivePushConfig.mWatermarkX;
        c25658f.f5327z = tXLivePushConfig.mWatermarkY;
        c25658f.f5288A = tXLivePushConfig.mWatermarkXF;
        c25658f.f5289B = tXLivePushConfig.mWatermarkYF;
        c25658f.f5290C = tXLivePushConfig.mWatermarkWidth;
        c25658f.f5313l = tXLivePushConfig.mHomeOrientation;
        c25658f.f5294G = tXLivePushConfig.mEnableNearestIP;
        c25658f.f5295H = tXLivePushConfig.mRtmpChannelType;
        c25658f.f5316o = tXLivePushConfig.mConnectRetryCount;
        c25658f.f5317p = tXLivePushConfig.mConnectRetryInterval;
        c25658f.f5314m = tXLivePushConfig.mFrontCamera;
        c25658f.f5298K = tXLivePushConfig.mCustomModeType;
        c25658f.f5299L = tXLivePushConfig.mVideoEncoderXMirror;
        c25658f.f5300M = tXLivePushConfig.mEnableHighResolutionCapture;
        c25658f.f5301N = tXLivePushConfig.mEnableScreenCaptureAutoRotate;
        c25658f.mo43387a();
        AppMethodBeat.m2505o(65915);
    }

    private void applyConfig() {
        int i = 5;
        int i2 = 1;
        AppMethodBeat.m2504i(65916);
        if (this.mCaptureAndEnc == null) {
            AppMethodBeat.m2505o(65916);
            return;
        }
        this.mCaptureAndEnc.mo67242a(this.mNewConfig);
        if (this.mCaptureAndEnc.mo67277i()) {
            if (this.mStreamUploader != null) {
                if (this.mNewConfig.f5296I) {
                    int i3 = this.mNewConfig.f5316o;
                    int i4 = this.mNewConfig.f5317p;
                    if (i3 >= 5) {
                        i = i3;
                    }
                    if (i4 <= 1) {
                        i2 = i4;
                    }
                    this.mStreamUploader.setRetryInterval(i2);
                    this.mStreamUploader.setRetryTimes(i);
                    this.mStreamUploader.setVideoDropParams(false, this.mNewConfig.f5309h, 1000);
                } else {
                    this.mStreamUploader.setRetryInterval(this.mNewConfig.f5317p);
                    this.mStreamUploader.setRetryTimes(this.mNewConfig.f5316o);
                    this.mStreamUploader.setVideoDropParams(true, 40, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                }
                this.mStreamUploader.setSendStrategy(this.mNewConfig.f5296I, this.mNewConfig.f5297J);
            }
            if (this.mQos != null) {
                this.mQos.stop();
                this.mQos.setAutoAdjustBitrate(this.mNewConfig.f5308g);
                this.mQos.setAutoAdjustStrategy(this.mNewConfig.f5307f);
                this.mQos.setDefaultVideoResolution(this.mNewConfig.f5312k);
                this.mQos.setVideoEncBitrate(this.mNewConfig.f5306e, this.mNewConfig.f5305d, this.mNewConfig.f5304c);
                if (this.mNewConfig.f5308g) {
                    this.mQos.start(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    AppMethodBeat.m2505o(65916);
                    return;
                }
            }
        } else if ((this.mNewConfig.f5298K & 1) != 0) {
            if (this.mStreamUploader != null) {
                this.mStreamUploader.setAudioInfo(this.mNewConfig.f5318q, this.mNewConfig.f5319r);
                AppMethodBeat.m2505o(65916);
                return;
            }
        } else if (this.mStreamUploader != null) {
            this.mStreamUploader.setAudioInfo(this.mNewConfig.f5318q, 1);
        }
        AppMethodBeat.m2505o(65916);
    }

    private void transferPushEvent(int i, final Bundle bundle) {
        int i2;
        AppMethodBeat.m2504i(65917);
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
                TXCLog.m15679w(TAG, "unhandled event : ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(65917);
                return;
        }
        if (this.mMainHandler != null) {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(65971);
                    if (TXLivePusher.this.mListener != null) {
                        TXLivePusher.this.mListener.onPushEvent(i2, bundle);
                    }
                    AppMethodBeat.m2505o(65971);
                }
            });
        }
        AppMethodBeat.m2505o(65917);
    }

    private byte[] transferAvccToAnnexb(byte[] bArr) {
        AppMethodBeat.m2504i(65918);
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
        AppMethodBeat.m2505o(65918);
        return bArr2;
    }

    private byte[] add_emulation_prevention_three_byte(byte[] bArr) {
        AppMethodBeat.m2504i(65919);
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
        AppMethodBeat.m2505o(65919);
        return bArr3;
    }

    @Deprecated
    public void sendMessage(byte[] bArr) {
        AppMethodBeat.m2504i(65920);
        synchronized (this) {
            try {
                if (this.mMsgArray != null) {
                    MsgInfo msgInfo = new MsgInfo(this, null);
                    msgInfo.f16227ts = TXCTimeUtil.getTimeTick();
                    msgInfo.msg = add_emulation_prevention_three_byte(bArr);
                    this.mMsgArray.add(msgInfo);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(65920);
            }
        }
    }

    public boolean sendMessageEx(byte[] bArr) {
        AppMethodBeat.m2504i(65921);
        if (bArr.length <= 0 || bArr.length > 2048) {
            AppMethodBeat.m2505o(65921);
            return false;
        }
        synchronized (this) {
            try {
                if (this.mMsgArray != null) {
                    MsgInfo msgInfo = new MsgInfo(this, null);
                    msgInfo.f16227ts = TXCTimeUtil.getTimeTick();
                    msgInfo.msg = appendSEIBuffer(bArr.length, add_emulation_prevention_three_byte(bArr));
                    this.mMsgArray.add(msgInfo);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(65921);
            }
        }
        return true;
    }

    private byte[] appendSEIBuffer(int i, byte[] bArr) {
        AppMethodBeat.m2504i(65922);
        byte[] intToBytes = intToBytes(i);
        byte[] bArr2 = new byte[(((intToBytes.length + 1) + bArr.length) + 1)];
        bArr2[0] = SEI_MSG_TYPE;
        System.arraycopy(intToBytes, 0, bArr2, 1, intToBytes.length);
        int length = intToBytes.length + 1;
        System.arraycopy(bArr, 0, bArr2, length, bArr.length);
        bArr2[length + bArr.length] = Byte.MIN_VALUE;
        AppMethodBeat.m2505o(65922);
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
        AppMethodBeat.m2504i(65923);
        switch (i) {
            case 1:
                a = (int) C45104b.m82752a().mo72874a("QUICMode", "Live");
                break;
            case 2:
                a = (int) C45104b.m82752a().mo72874a("QUICMode", "Live");
                break;
            case 3:
                a = (int) C45104b.m82752a().mo72874a("QUICMode", "Live");
                break;
            case 4:
                a = (int) C45104b.m82752a().mo72874a("QUICMode", "LinkMain");
                break;
            case 5:
                a = (int) C45104b.m82752a().mo72874a("QUICMode", "LinkSub");
                break;
            case 6:
                a = (int) C45104b.m82752a().mo72874a("QUICMode", "RTC");
                break;
            default:
                a = 0;
                break;
        }
        AppMethodBeat.m2505o(65923);
        return a;
    }
}
