package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.support.p057v4.widget.C8415j;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ugc.TXRecordCommon;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.l */
public final class C2309l implements ITXLivePushListener, OnBGMNotify {
    private String hGr = "front";
    TXCloudVideoView hLH;
    private String hLP = "vertical";
    private boolean hLV = false;
    private TXLivePushConfig hLZ;
    private boolean hLf = false;
    private String hMA = "";
    TXLivePusher hMa;
    ITXLivePushListener hMb;
    String hMc;
    private boolean hMd = false;
    private boolean hMe = false;
    private boolean hMf = false;
    ITXSnapshotListener hMg;
    OnBGMNotify hMh;
    private boolean hMi = false;
    private boolean hMj = false;
    boolean hMk = false;
    private int hMl = 2;
    private int hMm = -1;
    private int hMn = -1;
    private int hMo = 0;
    boolean hMp = true;
    private String hMq = "high";
    private int hMr = 5;
    private int hMs = 3;
    private String hMt = "";
    private boolean hMu = false;
    private boolean hMv = false;
    private boolean hMw = false;
    private boolean hMx = false;
    private float hMy = 0.0f;
    private float hMz = 0.0f;
    private Context mContext;
    private boolean mEnableZoom = true;
    private boolean mFrontCamera = true;
    private Handler mHandler;
    boolean mInited = false;
    private int mMode = 1;
    private boolean mMute = false;
    private float mWatermarkWidth = 0.1f;

    public C2309l(Context context) {
        AppMethodBeat.m2504i(96143);
        this.mContext = context;
        this.mHandler = new Handler(this.mContext.getMainLooper());
        this.hLZ = new TXLivePushConfig();
        this.hMa = new TXLivePusher(context);
        this.hMa.setConfig(this.hLZ);
        this.hMa.setPushListener(this);
        this.hMa.setBGMNofify(this);
        AppMethodBeat.m2505o(96143);
    }

    /* renamed from: op */
    public final void mo6183op(final int i) {
        AppMethodBeat.m2504i(96144);
        this.mHandler.post(new Runnable() {
            /* JADX WARNING: Missing block: B:3:0x001d, code skipped:
            if (com.tencent.p177mm.plugin.appbrand.jsapi.live.C2309l.m4526a(r6.hMC).equals(com.facebook.share.internal.MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL) == false) goto L_0x001f;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                int i = 0;
                AppMethodBeat.m2504i(96141);
                if (i != 1) {
                    if (i == 3) {
                        i = C2309l.this.hLP.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL) ? 1 : 2;
                    } else if (i == 0) {
                        if (!C2309l.this.hLP.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                            i = 1;
                        }
                    } else if (i == 2) {
                        if (C2309l.this.hLP.equals(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                            i = 2;
                        }
                        i = 3;
                    } else {
                        i = C8415j.INVALID_ID;
                    }
                }
                if (i != C8415j.INVALID_ID) {
                    C2309l.this.hLZ.setHomeOrientation(i);
                    C2309l.this.hMa.setConfig(C2309l.this.hLZ);
                }
                AppMethodBeat.m2505o(96141);
            }
        });
        AppMethodBeat.m2505o(96144);
    }

    /* renamed from: c */
    public final C33353i mo6179c(String str, JSONObject jSONObject) {
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(96145);
        C33353i c33353i;
        if (str == null) {
            c33353i = new C33353i(-1, "invalid params");
            AppMethodBeat.m2505o(96145);
            return c33353i;
        } else if (this.mInited) {
            C4990ab.m7416i("TXLivePusherJSAdapter", "operateLivePusher: ".concat(String.valueOf(str)));
            if (str.equalsIgnoreCase("start")) {
                if (!(this.hMc == null || this.hMc.isEmpty() || this.hMa.isPushing())) {
                    mo6181ea(this.hMp);
                    this.hMa.startPusher(this.hMc);
                }
            } else if (str.equalsIgnoreCase("stop")) {
                this.hMv = false;
                this.hMa.stopBGM();
                stopPreview();
                this.hMa.stopPusher();
            } else if (str.equalsIgnoreCase("pause")) {
                if (this.hMv && this.hMa.isPushing()) {
                    this.hMa.turnOnFlashLight(false);
                }
                this.hMa.pausePusher();
                this.hMj = this.hMi;
                if (this.hMj) {
                    mo6179c("pauseBGM", null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                this.hMa.resumePusher();
                if (this.hMj) {
                    mo6179c("resumeBGM", null);
                }
            } else if (str.equalsIgnoreCase("startPreview")) {
                if (this.hMa.isPushing()) {
                    C4990ab.m7416i("TXLivePusherJSAdapter", "do not support startPreview when pushing");
                } else {
                    stopPreview();
                    mo6181ea(this.hMp);
                }
            } else if (str.equalsIgnoreCase("stopPreview")) {
                if (this.hMa.isPushing()) {
                    C4990ab.m7416i("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
                } else {
                    stopPreview();
                }
            } else if (str.equalsIgnoreCase("switchCamera")) {
                if (this.mFrontCamera) {
                    z = false;
                }
                this.mFrontCamera = z;
                this.hLZ.setFrontCamera(this.mFrontCamera);
                this.hMa.switchCamera();
            } else if (str.equalsIgnoreCase("snapshot")) {
                m4527a(this.hMg);
            } else if (str.equalsIgnoreCase("toggleTorch")) {
                if (this.hMa.isPushing()) {
                    String str2;
                    if (this.hMv) {
                        z = false;
                    }
                    boolean turnOnFlashLight = this.hMa.turnOnFlashLight(z);
                    if (!turnOnFlashLight) {
                        z = this.hMv;
                    }
                    this.hMv = z;
                    if (!turnOnFlashLight) {
                        i = -2;
                    }
                    if (turnOnFlashLight) {
                        str2 = "Success";
                    } else {
                        str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
                    }
                    C33353i c33353i2 = new C33353i(i, str2);
                    AppMethodBeat.m2505o(96145);
                    return c33353i2;
                }
                c33353i = new C33353i(-2, "fail");
                AppMethodBeat.m2505o(96145);
                return c33353i;
            } else if (str.equalsIgnoreCase("playBGM")) {
                Object obj = "";
                if (jSONObject != null) {
                    obj = jSONObject.optString("BGMFilePath", "");
                }
                C4990ab.m7416i("TXLivePusherJSAdapter", "playBGM filePath = ".concat(String.valueOf(obj)));
                if (obj == null || obj.length() <= 0) {
                    c33353i = new C33353i(-2, "fail");
                    AppMethodBeat.m2505o(96145);
                    return c33353i;
                }
                this.hMa.playBGM(obj);
            } else if (str.equalsIgnoreCase("stopBGM")) {
                this.hMa.stopBGM();
                this.hMi = false;
            } else if (str.equalsIgnoreCase("pauseBGM")) {
                this.hMa.pauseBGM();
                this.hMi = false;
            } else if (str.equalsIgnoreCase("resumeBGM")) {
                this.hMa.resumeBGM();
                this.hMi = true;
            } else if (str.equalsIgnoreCase("setBGMVolume")) {
                double optDouble;
                if (jSONObject != null) {
                    optDouble = jSONObject.optDouble("volume", 1.0d);
                } else {
                    optDouble = 1.0d;
                }
                this.hMa.setBGMVolume((float) optDouble);
            } else {
                c33353i = new C33353i(-4, "invalid operate command");
                AppMethodBeat.m2505o(96145);
                return c33353i;
            }
            c33353i = new C33353i();
            AppMethodBeat.m2505o(96145);
            return c33353i;
        } else {
            c33353i = new C33353i(-3, "uninited livePusher");
            AppMethodBeat.m2505o(96145);
            return c33353i;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ea */
    public final void mo6181ea(boolean z) {
        AppMethodBeat.m2504i(96146);
        if (!this.hMd && z) {
            this.hLH.setVisibility(0);
            this.hMa.startCameraPreview(this.hLH);
            this.hMd = true;
        }
        AppMethodBeat.m2505o(96146);
    }

    /* Access modifiers changed, original: final */
    public final void stopPreview() {
        AppMethodBeat.m2504i(96147);
        this.hMa.stopCameraPreview(true);
        this.hMd = false;
        AppMethodBeat.m2505o(96147);
    }

    /* renamed from: eb */
    public final C33353i mo6182eb(boolean z) {
        AppMethodBeat.m2504i(96148);
        this.hMe = this.hMa.isPushing();
        C33353i c33353i;
        if (!this.hMe) {
            c33353i = new C33353i();
            AppMethodBeat.m2505o(96148);
            return c33353i;
        } else if (z) {
            this.hMf = z;
            if (this.hLf && this.hMb != null) {
                this.hMb.onPushEvent(5000, new Bundle());
            }
            c33353i = mo6179c("stop", null);
            AppMethodBeat.m2505o(96148);
            return c33353i;
        } else {
            c33353i = mo6179c("pause", null);
            AppMethodBeat.m2505o(96148);
            return c33353i;
        }
    }

    public final C33353i aDK() {
        AppMethodBeat.m2504i(96149);
        C33353i c33353i;
        if (!this.hMe) {
            c33353i = new C33353i();
            AppMethodBeat.m2505o(96149);
            return c33353i;
        } else if (this.hMf) {
            c33353i = mo6179c("start", null);
            AppMethodBeat.m2505o(96149);
            return c33353i;
        } else {
            c33353i = mo6179c("resume", null);
            AppMethodBeat.m2505o(96149);
            return c33353i;
        }
    }

    /* renamed from: a */
    private void m4527a(final ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.m2504i(96150);
        if (this.hMa != null && this.hMa.isPushing()) {
            this.hMa.snapshot(new ITXSnapshotListener() {
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.m2504i(96142);
                    if (iTXSnapshotListener != null) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (width < 1000 || height < 1000) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        } else {
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            C2309l.m4525H(bitmap);
                            AppMethodBeat.m2505o(96142);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(96142);
                }
            });
        }
        AppMethodBeat.m2505o(96150);
    }

    public final void onPushEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(96151);
        if (i == TXLiveConstants.PUSH_ERR_NET_DISCONNECT || i == TXLiveConstants.PUSH_ERR_INVALID_ADDRESS) {
            mo6179c("stop", null);
        } else if (i == 1003 && this.hMv) {
            this.hMa.turnOnFlashLight(this.hMv);
        }
        if (this.hLf && this.hMb != null) {
            this.hMb.onPushEvent(i, bundle);
        }
        C4990ab.m7416i("TXLivePusherJSAdapter", "onPushEvent: event = " + i + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.m2505o(96151);
    }

    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.m2504i(96152);
        if (this.hMb != null) {
            this.hMb.onNetStatus(bundle);
        }
        r1 = new Object[12];
        r1[7] = "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_CACHE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", new Object[]{Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED))}).toString();
        r1[8] = "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps";
        r1[9] = "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_DROP_CNT) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_DROP_SIZE);
        r1[10] = "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
        r1[11] = "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO);
        C4990ab.m7416i("TXLivePusherJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", r1))));
        AppMethodBeat.m2505o(96152);
    }

    public final void onBGMStart() {
        AppMethodBeat.m2504i(96153);
        this.hMi = true;
        if (this.hMw && this.hMh != null) {
            this.hMh.onBGMStart();
        }
        AppMethodBeat.m2505o(96153);
    }

    public final void onBGMProgress(long j, long j2) {
        AppMethodBeat.m2504i(96154);
        if (this.hMw && this.hMh != null) {
            this.hMh.onBGMProgress(j, j2);
        }
        AppMethodBeat.m2505o(96154);
    }

    public final void onBGMComplete(int i) {
        AppMethodBeat.m2504i(96155);
        this.hMi = false;
        if (this.hMw && this.hMh != null) {
            this.hMh.onBGMComplete(i);
        }
        AppMethodBeat.m2505o(96155);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:20:0x005f, code skipped:
            if (r6 <= r4) goto L_0x0061;
     */
    /* JADX WARNING: Missing block: B:94:0x02fd, code skipped:
            if (r24.equalsIgnoreCase(r27.hMA) != false) goto L_0x0300;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final void mo6180c(Bundle bundle, boolean z) {
        AppMethodBeat.m2504i(96156);
        if (z || bundle.keySet().size() != 0) {
            int i = bundle.getInt("mode", this.mMode);
            if (z || i != this.mMode) {
                switch (i) {
                    case 1:
                        this.hMa.setVideoQuality(1, false, false);
                        this.hLZ.setVideoEncodeGop(5);
                        break;
                    case 2:
                        this.hMa.setVideoQuality(2, true, false);
                        this.hLZ.setVideoEncodeGop(5);
                        break;
                    case 3:
                        this.hMa.setVideoQuality(3, true, false);
                        this.hLZ.setVideoEncodeGop(5);
                        break;
                    case 4:
                        this.hMa.setVideoQuality(4, true, false);
                        break;
                    case 5:
                        this.hMa.setVideoQuality(5, true, false);
                        break;
                    case 6:
                        this.hMa.setVideoQuality(6, false, false);
                        break;
                }
            }
            int i2 = this.hMm;
            int i3 = this.hMn;
            int i4 = bundle.getInt("minBitrate", -1);
            int i5 = bundle.getInt("maxBitrate", -1);
            if (!(i4 == -1 || i5 == -1)) {
                if (i4 < 200) {
                    i4 = 200;
                }
                if (i5 > 1800) {
                    i5 = 1800;
                }
            }
            i5 = i3;
            i4 = i2;
            int i6 = bundle.getInt("aspect", this.hMl);
            String string = bundle.getString("audioQuality", this.hMq);
            if (i == 6) {
                if (i6 == 1) {
                    this.hLZ.setVideoResolution(13);
                } else if (i6 == 2) {
                    this.hLZ.setVideoResolution(0);
                }
                if (!(i4 == -1 || i5 == -1 || i4 > i5)) {
                    this.hLZ.setMinVideoBitrate(i4);
                    this.hLZ.setMaxVideoBitrate(i5);
                }
                if (string.equalsIgnoreCase("low")) {
                    this.hLZ.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_16000);
                } else if (string.equalsIgnoreCase("high")) {
                    this.hLZ.setAudioSampleRate(TXRecordCommon.AUDIO_SAMPLERATE_48000);
                }
            }
            int i7 = bundle.getInt("focusMode", this.hMo);
            this.hLZ.setTouchFocus(i7 != 0);
            boolean z2 = bundle.getBoolean("enableCamera", this.hMp);
            this.hLZ.enablePureAudioPush(!z2);
            boolean z3 = this.mFrontCamera;
            if (bundle.keySet().contains("devicePosition")) {
                this.hGr = bundle.getString("devicePosition", this.hGr);
                if (this.hGr.equalsIgnoreCase("back")) {
                    z3 = false;
                }
                this.hLZ.setFrontCamera(z3);
            }
            String string2 = bundle.getString("orientation", this.hLP);
            i2 = 0;
            if (string2.equalsIgnoreCase(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
                this.hLZ.setHomeOrientation(0);
                i2 = 90;
            } else if (string2.equalsIgnoreCase("vertical")) {
                this.hLZ.setHomeOrientation(1);
                i2 = 0;
            }
            int i8 = bundle.getInt("beauty", this.hMr);
            int i9 = bundle.getInt("whiteness", this.hMs);
            this.hLZ.setBeautyFilter(i8, i9, 5);
            String string3 = bundle.getString("backgroundImage", this.hMt);
            Bitmap decodeFile = BitmapFactory.decodeFile(string3);
            if (decodeFile != null) {
                this.hLZ.setPauseImg(decodeFile);
            }
            boolean z4 = bundle.getBoolean("backgroundMute", this.hMu);
            if (z4) {
                this.hLZ.setPauseFlag(3);
            } else {
                this.hLZ.setPauseFlag(1);
            }
            boolean z5 = bundle.getBoolean("zoom", this.mEnableZoom);
            this.hLZ.setEnableZoom(z5);
            boolean z6 = bundle.getBoolean("mirror", this.hMx);
            this.hMa.setMirror(z6);
            float f = bundle.getFloat("watermarkLeft", this.hMy);
            float f2 = bundle.getFloat("watermarkTop", this.hMz);
            float f3 = bundle.getFloat("watermarkWidth", this.mWatermarkWidth);
            String string4 = bundle.getString("watermarkImage", this.hMA);
            decodeFile = BitmapFactory.decodeFile(string4);
            if (decodeFile != null) {
                this.hLZ.setWatermark(decodeFile, f, f2, f3);
            } else if (this.hMa.isPushing() && bundle.keySet().contains("watermarkImage")) {
                this.hLZ.setWatermark(decodeFile, f, f2, f3);
            }
            Object obj = null;
            if (i6 == this.hMl && i4 == this.hMm && i5 == this.hMn && i7 == this.hMo && z3 == this.mFrontCamera && z2 == this.hMp && i8 == this.hMr && i9 == this.hMs && z4 == this.hMu && z5 == this.mEnableZoom && z6 == this.hMx && f == this.hMy && f2 == this.hMz && f3 == this.mWatermarkWidth) {
                if (string3.equalsIgnoreCase(this.hMt)) {
                    if (string2.equalsIgnoreCase(this.hLP)) {
                        if (string.equalsIgnoreCase(this.hMq)) {
                        }
                    }
                }
            }
            obj = 1;
            if (z || obj != null) {
                this.hMa.setConfig(this.hLZ);
                this.hMa.setRenderRotation(i2);
                this.hMa.setBeautyFilter(0, i8, i9, 2);
            }
            if (z2 != this.hMp) {
                if (z2) {
                    stopPreview();
                    mo6181ea(z2);
                } else {
                    stopPreview();
                }
            }
            this.mMode = i;
            this.hMl = i6;
            this.hMo = i7;
            this.hMp = z2;
            this.mFrontCamera = z3;
            this.hLP = string2;
            this.hMr = i8;
            this.hMs = i9;
            this.hMu = z4;
            this.hMt = string3;
            this.hMm = i4;
            this.hMn = i5;
            this.hMq = string;
            this.mEnableZoom = z5;
            this.hMx = z6;
            this.hMy = f;
            this.hMz = f2;
            this.mWatermarkWidth = f3;
            this.hMA = string4;
            this.hLf = bundle.getBoolean("needEvent", this.hLf);
            this.hMw = bundle.getBoolean("needBGMEvent", this.hMw);
            boolean z7 = bundle.getBoolean("muted", this.mMute);
            if (z || z7 != this.mMute) {
                this.hMa.setMute(z7);
            }
            this.mMute = z7;
            z7 = bundle.getBoolean("debug", this.hLV);
            if (z || z7 != this.hLV) {
                this.hLH.showLog(z7);
            }
            this.hLV = z7;
            AppMethodBeat.m2505o(96156);
            return;
        }
        AppMethodBeat.m2505o(96156);
    }

    /* renamed from: l */
    static void m4530l(String str, Bundle bundle) {
        AppMethodBeat.m2504i(96157);
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("pushUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("backgroundImage") || str2.equalsIgnoreCase("audioQuality") || str2.equalsIgnoreCase("watermarkImage") || str2.equalsIgnoreCase("devicePosition")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("focusMode") || str2.equalsIgnoreCase("beauty") || str2.equalsIgnoreCase("whiteness") || str2.equalsIgnoreCase("aspect") || str2.equalsIgnoreCase("minBitrate") || str2.equalsIgnoreCase("maxBitrate")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase(MessengerShareContentUtility.SHARE_BUTTON_HIDE) || str2.equalsIgnoreCase("autopush") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("enableCamera") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("zoom") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("needBGMEvent") || str2.equalsIgnoreCase("debug") || str2.equalsIgnoreCase("mirror")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getBoolean(str2);
            } else if (str2.equalsIgnoreCase("watermarkLeft") || str2.equalsIgnoreCase("watermarkTop") || str2.equalsIgnoreCase("watermarkWidth")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getFloat(str2);
            }
        }
        C4990ab.m7416i("TXLivePusherJSAdapter", str);
        AppMethodBeat.m2505o(96157);
    }

    /* renamed from: H */
    static /* synthetic */ void m4525H(Bitmap bitmap) {
        AppMethodBeat.m2504i(96158);
        if (!(bitmap == null || bitmap.isRecycled())) {
            C4990ab.m7416i("TXLivePusherJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.m2505o(96158);
    }
}
