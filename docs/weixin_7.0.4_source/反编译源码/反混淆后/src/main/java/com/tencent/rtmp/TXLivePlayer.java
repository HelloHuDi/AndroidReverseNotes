package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.C17787g;
import com.tencent.liteav.C25666p;
import com.tencent.liteav.C37368j;
import com.tencent.liteav.C37368j.C0963a;
import com.tencent.liteav.C45110n;
import com.tencent.liteav.C8832o;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.view.C31128d;
import java.util.Iterator;
import java.util.Vector;

public class TXLivePlayer implements C0946a {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final int PLAY_TYPE_LOCAL_VIDEO = 6;
    public static final int PLAY_TYPE_VOD_FLV = 2;
    public static final int PLAY_TYPE_VOD_HLS = 3;
    public static final int PLAY_TYPE_VOD_MP4 = 4;
    public static final String TAG = "TXLivePlayer";
    private ITXAudioRawDataListener mAudioRawDataListener;
    private int mAudioRoute = 0;
    private boolean mAutoPlay = true;
    private Vector<String> mCallFuncBeforeStartPlay = new Vector();
    private TXLivePlayConfig mConfig;
    private Context mContext;
    private int mCurrentPlayType = -1;
    private boolean mEnableHWDec = false;
    private boolean mIsNeedClearLastImg = true;
    private boolean mIsShiftPlaying;
    private long mLastReportTime = 0;
    private ITXLivePlayListener mListener;
    private String mLivePlayUrl;
    private boolean mMute = false;
    private String mPlayUrl = "";
    private C45110n mPlayer;
    private long mProgressStartTime;
    private float mRate = 1.0f;
    private int mRenderMode;
    private int mRenderRotation;
    private boolean mSnapshotRunning = false;
    private Surface mSurface;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private TXCloudVideoView mTXCloudVideoView;
    private C37368j mTimeShiftUtil;
    private ITXVideoRawDataListener mVideoRawDataListener = null;

    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i, int i2, int i3);

        void onPcmDataAvailable(byte[] bArr, long j);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    /* renamed from: com.tencent.rtmp.TXLivePlayer$1 */
    class C364141 implements C0963a {
        C364141() {
        }

        public void onLiveTime(long j) {
            AppMethodBeat.m2504i(65990);
            TXLivePlayer.this.mProgressStartTime = j;
            if (TXLivePlayer.this.mPlayer != null) {
                TXLivePlayer.this.mPlayer.mo67329g();
            }
            AppMethodBeat.m2505o(65990);
        }
    }

    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i, int i2, int i3);
    }

    public TXLivePlayer(Context context) {
        AppMethodBeat.m2504i(65938);
        TXCLog.init();
        this.mListener = null;
        this.mContext = context.getApplicationContext();
        AppMethodBeat.m2505o(65938);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        AppMethodBeat.m2504i(65939);
        TXCLog.m15675d(TAG, "liteav_api setConfig ".concat(String.valueOf(this)));
        this.mConfig = tXLivePlayConfig;
        if (this.mConfig == null) {
            this.mConfig = new TXLivePlayConfig();
        }
        if (this.mPlayer != null) {
            C17787g h = this.mPlayer.mo72894h();
            if (h == null) {
                h = new C17787g();
            }
            h.f4172a = this.mConfig.mCacheTime;
            h.f4178g = this.mConfig.mAutoAdjustCacheTime;
            h.f4174c = this.mConfig.mMinAutoAdjustCacheTime;
            h.f4173b = this.mConfig.mMaxAutoAdjustCacheTime;
            h.f4175d = this.mConfig.mVideoBlockThreshold;
            h.f4176e = this.mConfig.mConnectRetryCount;
            h.f4177f = this.mConfig.mConnectRetryInterval;
            h.f4179h = this.mConfig.mEnableAec;
            h.f4181j = this.mConfig.mEnableNearestIP;
            h.f4183l = this.mConfig.mRtmpChannelType;
            h.f4180i = this.mEnableHWDec;
            h.f4184m = this.mConfig.mCacheFolderPath;
            h.f4185n = this.mConfig.mMaxCacheItems;
            h.f4182k = this.mConfig.mEnableMessage;
            h.f4186o = this.mConfig.mHeaders;
            this.mPlayer.mo67315a(h);
        }
        String str = "setConfig:" + this.mConfig.mCacheTime + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mConfig.mAutoAdjustCacheTime + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mConfig.mMinAutoAdjustCacheTime + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.mConfig.mMaxAutoAdjustCacheTime;
        if (this.mPlayUrl == null || this.mPlayUrl.length() <= 0) {
            this.mCallFuncBeforeStartPlay.add(str);
            AppMethodBeat.m2505o(65939);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, str, "");
        AppMethodBeat.m2505o(65939);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.m2504i(65940);
        TXCLog.m15675d(TAG, "liteav_api setPlayerView old view : " + this.mTXCloudVideoView + ", new view : " + tXCloudVideoView + ", " + this);
        this.mTXCloudVideoView = tXCloudVideoView;
        if (this.mPlayer != null) {
            this.mPlayer.mo67318a(tXCloudVideoView);
        }
        AppMethodBeat.m2505o(65940);
    }

    public void setSurface(Surface surface) {
        AppMethodBeat.m2504i(65941);
        TXCLog.m15675d(TAG, "liteav_api setSurface old : " + this.mSurface + ", new : " + surface + ", " + this);
        this.mSurface = surface;
        if (this.mPlayer != null) {
            this.mPlayer.mo67314a(this.mSurface);
        }
        AppMethodBeat.m2505o(65941);
    }

    public void setSurfaceSize(int i, int i2) {
        AppMethodBeat.m2504i(65942);
        this.mSurfaceWidth = i;
        this.mSurfaceHeight = i2;
        if (this.mPlayer != null) {
            this.mPlayer.mo67312a(i, i2);
        }
        AppMethodBeat.m2505o(65942);
    }

    public int startPlay(String str, int i) {
        AppMethodBeat.m2504i(65943);
        TXCLog.m15675d(TAG, "liteav_api startPlay ".concat(String.valueOf(this)));
        if (TextUtils.isEmpty(str)) {
            TXCLog.m15676e(TAG, "start play error when url is empty ".concat(String.valueOf(this)));
            AppMethodBeat.m2505o(65943);
            return -1;
        }
        if (!TextUtils.isEmpty(this.mPlayUrl) && isPlaying()) {
            if (this.mPlayUrl.equalsIgnoreCase(str)) {
                TXCLog.m15676e(TAG, "start play error when new url is the same with old url  ".concat(String.valueOf(this)));
                AppMethodBeat.m2505o(65943);
                return -1;
            }
            TXCLog.m15679w(TAG, " stop old play when new url is not the same with old url  ".concat(String.valueOf(this)));
            if (this.mPlayer != null) {
                this.mPlayer.mo67309a(false);
            }
            this.mPlayUrl = "";
        }
        TXCDRApi.initCrashReport(this.mContext);
        TXCLog.m15675d(TAG, "===========================================================================================================================================================");
        TXCLog.m15675d(TAG, "===========================================================================================================================================================");
        TXCLog.m15675d(TAG, "=====  StartPlay url = " + str + " playType = " + i + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
        TXCLog.m15675d(TAG, "===========================================================================================================================================================");
        TXCLog.m15675d(TAG, "===========================================================================================================================================================");
        if (this.mCurrentPlayType == -1 || this.mCurrentPlayType != i) {
            this.mPlayer = C25666p.m40716a(this.mContext, i);
        }
        this.mCurrentPlayType = i;
        if (this.mPlayer == null) {
            AppMethodBeat.m2505o(65943);
            return -2;
        }
        this.mPlayUrl = checkPlayUrl(str, i);
        setConfig(this.mConfig);
        if (this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.clearLog();
            this.mTXCloudVideoView.setVisibility(0);
        }
        this.mPlayer.mo67318a(this.mTXCloudVideoView);
        this.mPlayer.mo72891a((C0946a) this);
        this.mPlayer.mo72892c(this.mAutoPlay);
        if (this.mSurface != null) {
            this.mPlayer.mo67314a(this.mSurface);
            this.mPlayer.mo67312a(this.mSurfaceWidth, this.mSurfaceHeight);
        }
        this.mPlayer.mo67308a(this.mPlayUrl, i);
        this.mPlayer.mo67323b(this.mMute);
        this.mPlayer.mo72890a(this.mRate);
        this.mPlayer.mo67322b(this.mRenderRotation);
        this.mPlayer.mo67311a(this.mRenderMode);
        setAudioRoute(this.mAudioRoute);
        this.mPlayer.mo67317a(this.mAudioRawDataListener);
        setVideoRawDataListener(this.mVideoRawDataListener);
        if (this.mPlayer.mo67328f()) {
            this.mLivePlayUrl = this.mPlayUrl;
            this.mProgressStartTime = this.mTimeShiftUtil != null ? this.mTimeShiftUtil.mo60179a() : 0;
            if (this.mProgressStartTime > 0) {
                this.mPlayer.mo67329g();
            }
        }
        Iterator it = this.mCallFuncBeforeStartPlay.iterator();
        while (it.hasNext()) {
            TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, (String) it.next(), "");
        }
        this.mCallFuncBeforeStartPlay.clear();
        TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, "startPlay:".concat(String.valueOf(i)), "");
        AppMethodBeat.m2505o(65943);
        return 0;
    }

    public int switchStream(String str) {
        AppMethodBeat.m2504i(65944);
        if (this.mPlayer != null) {
            int a = this.mPlayer.mo67307a(str);
            AppMethodBeat.m2505o(65944);
            return a;
        }
        AppMethodBeat.m2505o(65944);
        return -1;
    }

    public int stopPlay(boolean z) {
        AppMethodBeat.m2504i(65945);
        TXCLog.m15675d(TAG, "liteav_api stopPlay " + z + ", " + this);
        if (this.mPlayUrl != null && this.mPlayUrl.length() > 0) {
            TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, "stopPlay", "");
        }
        if (z && this.mTXCloudVideoView != null) {
            this.mTXCloudVideoView.setVisibility(8);
        }
        if (this.mPlayer != null) {
            this.mPlayer.mo67309a(z);
        }
        this.mPlayUrl = "";
        this.mProgressStartTime = 0;
        this.mTimeShiftUtil = null;
        this.mIsShiftPlaying = false;
        AppMethodBeat.m2505o(65945);
        return 0;
    }

    public boolean isPlaying() {
        AppMethodBeat.m2504i(65946);
        if (this.mPlayer != null) {
            boolean c = this.mPlayer.mo67325c();
            AppMethodBeat.m2505o(65946);
            return c;
        }
        AppMethodBeat.m2505o(65946);
        return false;
    }

    public void pause() {
        AppMethodBeat.m2504i(65947);
        TXCLog.m15675d(TAG, "liteav_api pause ".concat(String.valueOf(this)));
        if (this.mPlayer != null) {
            TXCLog.m15679w(TAG, "pause play");
            this.mPlayer.mo67310a();
        }
        if (this.mPlayUrl != null && this.mPlayUrl.length() > 0) {
            TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, "pause", "");
        }
        AppMethodBeat.m2505o(65947);
    }

    public void resume() {
        AppMethodBeat.m2504i(65948);
        TXCLog.m15675d(TAG, "liteav_api resume ".concat(String.valueOf(this)));
        if (this.mPlayer != null) {
            TXCLog.m15679w(TAG, "resume play");
            this.mPlayer.mo67321b();
            setAudioRoute(this.mAudioRoute);
        }
        if (this.mPlayUrl != null && this.mPlayUrl.length() > 0) {
            TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, "resume", "");
        }
        AppMethodBeat.m2505o(65948);
    }

    public void seek(int i) {
        AppMethodBeat.m2504i(65949);
        TXCLog.m15675d(TAG, "liteav_api ");
        if (this.mPlayer != null) {
            if (this.mPlayer.mo67328f() || this.mIsShiftPlaying) {
                CharSequence a = this.mTimeShiftUtil != null ? this.mTimeShiftUtil.mo60180a((long) i) : "";
                if (!TextUtils.isEmpty(a)) {
                    this.mIsShiftPlaying = startPlay(a, 3) == 0;
                    if (this.mIsShiftPlaying) {
                        this.mProgressStartTime = (long) (i * 1000);
                        AppMethodBeat.m2505o(65949);
                        return;
                    }
                } else if (this.mListener != null) {
                    this.mListener.onPlayEvent(TXLiveConstants.PLAY_ERR_NET_DISCONNECT, new Bundle());
                }
                AppMethodBeat.m2505o(65949);
                return;
            }
            this.mPlayer.mo72893e(i);
        }
        AppMethodBeat.m2505o(65949);
    }

    public int prepareLiveSeek(String str, int i) {
        AppMethodBeat.m2504i(65950);
        TXCLog.m15675d(TAG, "liteav_api prepareLiveSeek ".concat(String.valueOf(this)));
        if (this.mTimeShiftUtil == null) {
            this.mTimeShiftUtil = new C37368j(this.mContext);
        }
        if (this.mTimeShiftUtil != null) {
            int a = this.mTimeShiftUtil.mo60178a(this.mPlayUrl, str, i, new C364141());
            AppMethodBeat.m2505o(65950);
            return a;
        }
        AppMethodBeat.m2505o(65950);
        return -1;
    }

    public int resumeLive() {
        AppMethodBeat.m2504i(65951);
        TXCLog.m15675d(TAG, "liteav_api resumeLive ".concat(String.valueOf(this)));
        if (this.mIsShiftPlaying) {
            this.mIsShiftPlaying = false;
            int startPlay = startPlay(this.mLivePlayUrl, 1);
            AppMethodBeat.m2505o(65951);
            return startPlay;
        }
        AppMethodBeat.m2505o(65951);
        return -1;
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        AppMethodBeat.m2504i(65952);
        TXCLog.m15675d(TAG, "liteav_api setPlayListener ".concat(String.valueOf(this)));
        this.mListener = iTXLivePlayListener;
        AppMethodBeat.m2505o(65952);
    }

    public void setVideoRecordListener(ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.m2504i(65953);
        TXCLog.m15675d(TAG, "liteav_api setVideoRecordListener");
        if (this.mPlayer != null) {
            this.mPlayer.mo67319a(iTXVideoRecordListener);
        }
        AppMethodBeat.m2505o(65953);
    }

    public int startRecord(int i) {
        AppMethodBeat.m2504i(65954);
        TXCLog.m15675d(TAG, "liteav_api startRecord ".concat(String.valueOf(this)));
        if (VERSION.SDK_INT < 18) {
            TXCLog.m15676e(TAG, "API levl is too low (record need 18, current is" + VERSION.SDK_INT + ")");
            AppMethodBeat.m2505o(65954);
            return -3;
        } else if (!isPlaying()) {
            TXCLog.m15676e(TAG, "startRecord: there is no playing stream");
            AppMethodBeat.m2505o(65954);
            return -1;
        } else if (this.mPlayer != null) {
            int c = this.mPlayer.mo67324c(i);
            AppMethodBeat.m2505o(65954);
            return c;
        } else {
            AppMethodBeat.m2505o(65954);
            return -1;
        }
    }

    public int stopRecord() {
        AppMethodBeat.m2504i(65955);
        TXCLog.m15675d(TAG, "liteav_api stopRecord ".concat(String.valueOf(this)));
        if (this.mPlayer != null) {
            int e = this.mPlayer.mo67327e();
            AppMethodBeat.m2505o(65955);
            return e;
        }
        AppMethodBeat.m2505o(65955);
        return -1;
    }

    public void setRenderMode(int i) {
        AppMethodBeat.m2504i(65956);
        TXCLog.m15675d(TAG, "liteav_api setRenderMode ".concat(String.valueOf(i)));
        this.mRenderMode = i;
        if (this.mPlayer != null) {
            this.mPlayer.mo67311a(i);
        }
        AppMethodBeat.m2505o(65956);
    }

    public void setRenderRotation(int i) {
        AppMethodBeat.m2504i(65957);
        TXCLog.m15675d(TAG, "liteav_api setRenderRotation ".concat(String.valueOf(i)));
        this.mRenderRotation = i;
        if (this.mPlayer != null) {
            this.mPlayer.mo67322b(i);
        }
        AppMethodBeat.m2505o(65957);
    }

    public boolean enableHardwareDecode(boolean z) {
        AppMethodBeat.m2504i(65958);
        TXCLog.m15675d(TAG, "liteav_api enableHardwareDecode ".concat(String.valueOf(z)));
        if (z) {
            if (VERSION.SDK_INT < 18) {
                TXCLog.m15676e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
                AppMethodBeat.m2505o(65958);
                return false;
            } else if (isAVCDecBlacklistDevices()) {
                TXCLog.m15676e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
                AppMethodBeat.m2505o(65958);
                return false;
            }
        }
        this.mEnableHWDec = z;
        if (this.mPlayer != null) {
            C17787g h = this.mPlayer.mo72894h();
            if (h == null) {
                h = new C17787g();
            }
            h.f4180i = this.mEnableHWDec;
            this.mPlayer.mo67315a(h);
        }
        AppMethodBeat.m2505o(65958);
        return true;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(65959);
        TXCLog.m15675d(TAG, "liteav_api setMute ".concat(String.valueOf(z)));
        this.mMute = z;
        if (this.mPlayer != null) {
            this.mPlayer.mo67323b(z);
        }
        if (this.mPlayUrl == null || this.mPlayUrl.length() <= 0) {
            this.mCallFuncBeforeStartPlay.add("setMute:".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(65959);
            return;
        }
        TXCDRApi.reportEvent40003(this.mPlayUrl, C8795a.f2493S, 0, "setMute:".concat(String.valueOf(z)), "");
        AppMethodBeat.m2505o(65959);
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.m2504i(65960);
        TXCLog.m15675d(TAG, "liteav_api setAutoPlay ".concat(String.valueOf(z)));
        this.mAutoPlay = z;
        AppMethodBeat.m2505o(65960);
    }

    public void setRate(float f) {
        AppMethodBeat.m2504i(65961);
        TXCLog.m15675d(TAG, "liteav_api setRate ".concat(String.valueOf(f)));
        this.mRate = f;
        if (this.mPlayer != null) {
            this.mPlayer.mo72890a(f);
        }
        AppMethodBeat.m2505o(65961);
    }

    public void setAudioRoute(int i) {
        AppMethodBeat.m2504i(65962);
        TXCLog.m15675d(TAG, "liteav_api setAudioRoute ".concat(String.valueOf(i)));
        this.mAudioRoute = i;
        if (this.mPlayer != null) {
            this.mPlayer.mo67313a(this.mContext, this.mAudioRoute);
        }
        AppMethodBeat.m2505o(65962);
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(65963);
        long j;
        if (i == 15001) {
            if (this.mTXCloudVideoView != null) {
                this.mTXCloudVideoView.setLogText(bundle, null, 0);
            }
            if (this.mListener != null) {
                this.mListener.onNetStatus(bundle);
                AppMethodBeat.m2505o(65963);
                return;
            }
        } else if (i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS) {
            j = ((long) bundle.getInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS)) + this.mProgressStartTime;
            if (j > 0) {
                bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (j / 1000));
                bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) j);
                if (this.mListener != null) {
                    this.mListener.onPlayEvent(i, bundle);
                }
            }
            AppMethodBeat.m2505o(65963);
            return;
        } else {
            if (this.mTXCloudVideoView != null) {
                this.mTXCloudVideoView.setLogText(null, bundle, i);
            }
            if (this.mListener != null) {
                this.mListener.onPlayEvent(i, bundle);
            }
            j = System.currentTimeMillis();
            if (i == TXLiveConstants.PUSH_ERR_VIDEO_ENCODE_FAIL) {
                if (j - this.mLastReportTime < 5000) {
                    AppMethodBeat.m2505o(65963);
                    return;
                }
                this.mLastReportTime = j;
            }
            if (!(i == TXLiveConstants.PLAY_EVT_PLAY_PROGRESS || i == 2012 || this.mPlayUrl == null || this.mPlayUrl.length() <= 0)) {
                String string = bundle.getString(TXLiveConstants.EVT_DESCRIPTION);
                String str = this.mPlayUrl;
                int i2 = C8795a.f2494T;
                if (string == null) {
                    string = "";
                }
                TXCDRApi.reportEvent40003(str, i2, i, string, "");
            }
        }
        AppMethodBeat.m2505o(65963);
    }

    public boolean addVideoRawData(byte[] bArr) {
        AppMethodBeat.m2504i(65964);
        TXCLog.m15675d(TAG, "liteav_api addVideoRawData ".concat(String.valueOf(bArr)));
        if (this.mPlayUrl == null || this.mPlayUrl.isEmpty()) {
            AppMethodBeat.m2505o(65964);
            return false;
        } else if (this.mEnableHWDec) {
            TXLog.m71029e(TAG, "can not addVideoRawData because of hw decode has set!");
            AppMethodBeat.m2505o(65964);
            return false;
        } else if (this.mPlayer == null) {
            TXCLog.m15676e(TAG, "player hasn't created or not instanceof live player");
            AppMethodBeat.m2505o(65964);
            return false;
        } else {
            this.mPlayer.mo67320a(bArr);
            AppMethodBeat.m2505o(65964);
            return true;
        }
    }

    public void setVideoRawDataListener(final ITXVideoRawDataListener iTXVideoRawDataListener) {
        AppMethodBeat.m2504i(65965);
        TXCLog.m15675d(TAG, "liteav_api setVideoRawDataListener ".concat(String.valueOf(iTXVideoRawDataListener)));
        this.mVideoRawDataListener = iTXVideoRawDataListener;
        if (this.mPlayer == null) {
            AppMethodBeat.m2505o(65965);
        } else if (iTXVideoRawDataListener != null) {
            this.mPlayer.mo67316a(new C8832o() {
                public void onVideoRawDataAvailable(byte[] bArr, int i, int i2, int i3) {
                    AppMethodBeat.m2504i(65594);
                    iTXVideoRawDataListener.onVideoRawDataAvailable(bArr, i, i2, i3);
                    AppMethodBeat.m2505o(65594);
                }
            });
            AppMethodBeat.m2505o(65965);
        } else {
            this.mPlayer.mo67316a(null);
            AppMethodBeat.m2505o(65965);
        }
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.m2504i(65966);
        TXCLog.m15675d(TAG, "liteav_api snapshot ".concat(String.valueOf(iTXSnapshotListener)));
        if (this.mSnapshotRunning || iTXSnapshotListener == null) {
            AppMethodBeat.m2505o(65966);
            return;
        }
        TextureView d;
        this.mSnapshotRunning = true;
        if (this.mPlayer != null) {
            d = this.mPlayer.mo67326d();
        } else {
            d = null;
        }
        if (d != null) {
            Bitmap bitmap;
            try {
                bitmap = d.getBitmap();
            } catch (OutOfMemoryError e) {
                bitmap = null;
            }
            if (bitmap != null) {
                int i = 0;
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, i, bitmap.getWidth(), bitmap.getHeight(), d.getTransform(null), true);
                bitmap.recycle();
                bitmap = createBitmap;
            }
            postBitmapToMainThread(iTXSnapshotListener, bitmap);
            AppMethodBeat.m2505o(65966);
            return;
        }
        this.mSnapshotRunning = false;
        AppMethodBeat.m2505o(65966);
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        AppMethodBeat.m2504i(65967);
        TXCLog.m15675d(TAG, "liteav_api setAudioRawDataListener ".concat(String.valueOf(iTXAudioRawDataListener)));
        this.mAudioRawDataListener = iTXAudioRawDataListener;
        if (this.mPlayer != null) {
            this.mPlayer.mo67317a(iTXAudioRawDataListener);
        }
        AppMethodBeat.m2505o(65967);
    }

    private boolean isAVCDecBlacklistDevices() {
        AppMethodBeat.m2504i(65968);
        if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && Build.MODEL.equalsIgnoreCase("Che2-TL00")) {
            AppMethodBeat.m2505o(65968);
            return true;
        }
        AppMethodBeat.m2505o(65968);
        return false;
    }

    private String checkPlayUrl(String str, int i) {
        AppMethodBeat.m2504i(65969);
        if (i != 6) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                StringBuilder stringBuilder = new StringBuilder(bytes.length);
                int i2 = 0;
                while (i2 < bytes.length) {
                    int i3 = bytes[i2] < (byte) 0 ? bytes[i2] + 256 : bytes[i2];
                    if (i3 <= 32 || i3 >= C31128d.MIC_SketchMark || i3 == 34 || i3 == 37 || i3 == 60 || i3 == 62 || i3 == 91 || i3 == 125 || i3 == 92 || i3 == 93 || i3 == 94 || i3 == 96 || i3 == 123 || i3 == 124) {
                        stringBuilder.append(String.format("%%%02X", new Object[]{Integer.valueOf(i3)}));
                    } else {
                        stringBuilder.append((char) i3);
                    }
                    i2++;
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        String trim = str.trim();
        AppMethodBeat.m2505o(65969);
        return trim;
    }

    private void postBitmapToMainThread(final ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        AppMethodBeat.m2504i(65970);
        if (iTXSnapshotListener == null) {
            AppMethodBeat.m2505o(65970);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(65608);
                if (iTXSnapshotListener != null) {
                    iTXSnapshotListener.onSnapshot(bitmap);
                }
                TXLivePlayer.this.mSnapshotRunning = false;
                AppMethodBeat.m2505o(65608);
            }
        });
        AppMethodBeat.m2505o(65970);
    }
}
