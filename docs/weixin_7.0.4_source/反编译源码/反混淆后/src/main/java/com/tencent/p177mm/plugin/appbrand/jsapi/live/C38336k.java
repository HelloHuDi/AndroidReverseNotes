package com.tencent.p177mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.k */
public final class C38336k implements ITXLivePlayListener {
    TXCloudVideoView hLH;
    private TXLivePlayConfig hLI;
    TXLivePlayer hLJ;
    ITXLivePlayListener hLK;
    ITXSnapshotListener hLL;
    String hLM = "";
    int hLN = 0;
    boolean hLO = false;
    private String hLP = "vertical";
    private String hLQ = "contain";
    private String hLR = "speaker";
    private float hLS = 1.0f;
    private float hLT = 3.0f;
    private boolean hLU = true;
    private boolean hLV = false;
    boolean hLW = true;
    boolean hLX = true;
    boolean hLf = false;
    boolean mAutoPlay = false;
    private Context mContext;
    boolean mInited = false;
    private int mMode = 1;
    private boolean mMute = false;

    public C38336k(Context context) {
        AppMethodBeat.m2504i(96131);
        this.mContext = context;
        this.hLI = new TXLivePlayConfig();
        this.hLJ = new TXLivePlayer(this.mContext);
        this.hLJ.setConfig(this.hLI);
        this.hLJ.setPlayListener(this);
        AppMethodBeat.m2505o(96131);
    }

    /* renamed from: Bd */
    public final C33353i mo61009Bd(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(96132);
        C33353i c33353i;
        if (str == null) {
            c33353i = new C33353i(-1, "invalid params");
            AppMethodBeat.m2505o(96132);
            return c33353i;
        }
        C4990ab.m7416i("TXLivePlayerJSAdapter", "operateLivePlayer: ".concat(String.valueOf(str)));
        if (this.mInited) {
            if (str.equalsIgnoreCase("play")) {
                mo61010Be(this.hLM);
                this.hLJ.startPlay(this.hLM, this.hLN);
            } else if (str.equalsIgnoreCase("stop")) {
                this.hLJ.stopPlay(true);
            } else if (str.equalsIgnoreCase("pause")) {
                this.hLJ.pause();
            } else if (str.equalsIgnoreCase("resume")) {
                this.hLJ.resume();
            } else if (str.equalsIgnoreCase("mute")) {
                if (this.mMute) {
                    z = false;
                }
                this.mMute = z;
                this.hLJ.setMute(this.mMute);
            } else if (str.equalsIgnoreCase("snapshot")) {
                m64873a(this.hLL);
            } else {
                c33353i = new C33353i(-4, "invalid operate command");
                AppMethodBeat.m2505o(96132);
                return c33353i;
            }
            c33353i = new C33353i();
            AppMethodBeat.m2505o(96132);
            return c33353i;
        }
        c33353i = new C33353i(-3, "uninited livePlayer");
        AppMethodBeat.m2505o(96132);
        return c33353i;
    }

    /* renamed from: a */
    private void m64873a(final ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.m2504i(96133);
        if (this.hLJ != null) {
            this.hLJ.snapshot(new ITXSnapshotListener() {
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.m2504i(96130);
                    if (iTXSnapshotListener != null) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (width < 1000 || height < 1000) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        } else {
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            C38336k.m64872G(bitmap);
                            AppMethodBeat.m2505o(96130);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(96130);
                }
            });
        }
        AppMethodBeat.m2505o(96133);
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(96134);
        if (i == TXLiveConstants.PLAY_EVT_PLAY_END || i == TXLiveConstants.PLAY_ERR_NET_DISCONNECT) {
            mo61009Bd("stop");
        }
        if (this.hLf && this.hLK != null) {
            this.hLK.onPlayEvent(i, bundle);
        }
        C4990ab.m7416i("TXLivePlayerJSAdapter", "onPushEvent: event = " + i + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.m2505o(96134);
    }

    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.m2504i(96135);
        if (this.hLK != null) {
            this.hLK.onNetStatus(bundle);
        }
        r1 = new Object[12];
        r1[7] = "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_CACHE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", new Object[]{Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED))}).toString();
        r1[8] = "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps";
        r1[9] = "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_DROP_CNT) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_DROP_SIZE);
        r1[10] = "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
        r1[11] = "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO);
        C4990ab.m7416i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", r1))));
        AppMethodBeat.m2505o(96135);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: z */
    public final int mo61011z(Bundle bundle) {
        AppMethodBeat.m2504i(96136);
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            AppMethodBeat.m2505o(96136);
            return 5;
        } else if (this.hLM == null) {
            AppMethodBeat.m2505o(96136);
            return 0;
        } else if (this.hLM == null || !((this.hLM.startsWith("http://") || this.hLM.startsWith("https://")) && this.hLM.contains(".flv"))) {
            AppMethodBeat.m2505o(96136);
            return 0;
        } else {
            AppMethodBeat.m2505o(96136);
            return 1;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Be */
    public final void mo61010Be(String str) {
        AppMethodBeat.m2504i(96137);
        if (str != null) {
            boolean z = !str.startsWith("room");
            this.hLJ.enableHardwareDecode(z);
            C4990ab.m7416i("TXLivePlayerJSAdapter", "checkHardWareDecoder: hardwareDecode = " + z + ", playUrl = " + str);
            AppMethodBeat.m2505o(96137);
            return;
        }
        C4990ab.m7416i("TXLivePlayerJSAdapter", "checkHardWareDecoder: invalid playUrl");
        AppMethodBeat.m2505o(96137);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: A */
    public final void mo61008A(Bundle bundle) {
        AppMethodBeat.m2504i(96138);
        this.mMute = bundle.getBoolean("muted", this.mMute);
        this.hLJ.setMute(this.mMute);
        this.hLP = bundle.getString("orientation", this.hLP);
        if (this.hLP.equalsIgnoreCase(MessengerShareContentUtility.IMAGE_RATIO_HORIZONTAL)) {
            this.hLJ.setRenderRotation(270);
        } else if (this.hLP.equalsIgnoreCase("vertical")) {
            this.hLJ.setRenderRotation(0);
        }
        this.hLQ = bundle.getString("objectFit", this.hLQ);
        if (this.hLQ.equalsIgnoreCase("fillCrop")) {
            this.hLJ.setRenderMode(0);
        } else if (this.hLQ.equalsIgnoreCase("contain")) {
            this.hLJ.setRenderMode(1);
        }
        if (bundle.keySet().contains("soundMode")) {
            this.hLR = bundle.getString("soundMode", this.hLR);
            if (this.hLR.equalsIgnoreCase("speaker")) {
                this.hLJ.setAudioRoute(0);
            } else if (this.hLR.equalsIgnoreCase("ear")) {
                this.hLJ.setAudioRoute(1);
            }
        }
        this.hLS = bundle.getFloat("minCache", this.hLS);
        this.hLT = bundle.getFloat("maxCache", this.hLT);
        this.hLI.setAutoAdjustCacheTime(true);
        this.hLI.setCacheTime(this.hLS);
        this.hLI.setMinAutoAdjustCacheTime(this.hLS);
        this.hLI.setMaxAutoAdjustCacheTime(this.hLT);
        this.hLJ.setConfig(this.hLI);
        this.hLf = bundle.getBoolean("needEvent", this.hLf);
        this.hLW = bundle.getBoolean("autoPauseIfNavigate", this.hLW);
        this.hLX = bundle.getBoolean("autoPauseIfOpenNative", this.hLX);
        this.hLV = bundle.getBoolean("debug", this.hLV);
        this.hLH.showLog(this.hLV);
        AppMethodBeat.m2505o(96138);
    }

    /* renamed from: l */
    static void m64874l(String str, Bundle bundle) {
        AppMethodBeat.m2504i(96139);
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("playUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("objectFit") || str2.equalsIgnoreCase("soundMode")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("playType")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("minCache") || str2.equalsIgnoreCase("maxCache")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getFloat(str2);
            } else if (str2.equalsIgnoreCase(MessengerShareContentUtility.SHARE_BUTTON_HIDE) || str2.equalsIgnoreCase("autoplay") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        C4990ab.m7416i("TXLivePlayerJSAdapter", str);
        AppMethodBeat.m2505o(96139);
    }

    /* renamed from: G */
    static /* synthetic */ void m64872G(Bitmap bitmap) {
        AppMethodBeat.m2504i(96140);
        if (!(bitmap == null || bitmap.isRecycled())) {
            C4990ab.m7416i("TXLivePlayerJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.m2505o(96140);
    }
}
