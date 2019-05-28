package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ttpic.baseutils.IOUtils;

public final class k implements ITXLivePlayListener {
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

    public k(Context context) {
        AppMethodBeat.i(96131);
        this.mContext = context;
        this.hLI = new TXLivePlayConfig();
        this.hLJ = new TXLivePlayer(this.mContext);
        this.hLJ.setConfig(this.hLI);
        this.hLJ.setPlayListener(this);
        AppMethodBeat.o(96131);
    }

    public final i Bd(String str) {
        boolean z = true;
        AppMethodBeat.i(96132);
        i iVar;
        if (str == null) {
            iVar = new i(-1, "invalid params");
            AppMethodBeat.o(96132);
            return iVar;
        }
        ab.i("TXLivePlayerJSAdapter", "operateLivePlayer: ".concat(String.valueOf(str)));
        if (this.mInited) {
            if (str.equalsIgnoreCase("play")) {
                Be(this.hLM);
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
                a(this.hLL);
            } else {
                iVar = new i(-4, "invalid operate command");
                AppMethodBeat.o(96132);
                return iVar;
            }
            iVar = new i();
            AppMethodBeat.o(96132);
            return iVar;
        }
        iVar = new i(-3, "uninited livePlayer");
        AppMethodBeat.o(96132);
        return iVar;
    }

    private void a(final ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(96133);
        if (this.hLJ != null) {
            this.hLJ.snapshot(new ITXSnapshotListener() {
                public final void onSnapshot(Bitmap bitmap) {
                    AppMethodBeat.i(96130);
                    if (iTXSnapshotListener != null) {
                        int width = bitmap.getWidth();
                        int height = bitmap.getHeight();
                        if (width < 1000 || height < 1000) {
                            iTXSnapshotListener.onSnapshot(bitmap);
                        } else {
                            Matrix matrix = new Matrix();
                            matrix.setScale(0.5f, 0.5f);
                            iTXSnapshotListener.onSnapshot(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false));
                            k.G(bitmap);
                            AppMethodBeat.o(96130);
                            return;
                        }
                    }
                    AppMethodBeat.o(96130);
                }
            });
        }
        AppMethodBeat.o(96133);
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        AppMethodBeat.i(96134);
        if (i == TXLiveConstants.PLAY_EVT_PLAY_END || i == TXLiveConstants.PLAY_ERR_NET_DISCONNECT) {
            Bd("stop");
        }
        if (this.hLf && this.hLK != null) {
            this.hLK.onPlayEvent(i, bundle);
        }
        ab.i("TXLivePlayerJSAdapter", "onPushEvent: event = " + i + " message = " + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
        AppMethodBeat.o(96134);
    }

    public final void onNetStatus(Bundle bundle) {
        AppMethodBeat.i(96135);
        if (this.hLK != null) {
            this.hLK.onNetStatus(bundle);
        }
        r1 = new Object[12];
        r1[7] = "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_CACHE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", new Object[]{Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED))}).toString();
        r1[8] = "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps";
        r1[9] = "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_CODEC_DROP_CNT) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_DROP_SIZE);
        r1[10] = "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP);
        r1[11] = "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO);
        ab.i("TXLivePlayerJSAdapter", "onNetStatus:".concat(String.valueOf(String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", r1))));
        AppMethodBeat.o(96135);
    }

    /* Access modifiers changed, original: final */
    public final int z(Bundle bundle) {
        AppMethodBeat.i(96136);
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            AppMethodBeat.o(96136);
            return 5;
        } else if (this.hLM == null) {
            AppMethodBeat.o(96136);
            return 0;
        } else if (this.hLM == null || !((this.hLM.startsWith("http://") || this.hLM.startsWith("https://")) && this.hLM.contains(".flv"))) {
            AppMethodBeat.o(96136);
            return 0;
        } else {
            AppMethodBeat.o(96136);
            return 1;
        }
    }

    /* Access modifiers changed, original: final */
    public final void Be(String str) {
        AppMethodBeat.i(96137);
        if (str != null) {
            boolean z = !str.startsWith("room");
            this.hLJ.enableHardwareDecode(z);
            ab.i("TXLivePlayerJSAdapter", "checkHardWareDecoder: hardwareDecode = " + z + ", playUrl = " + str);
            AppMethodBeat.o(96137);
            return;
        }
        ab.i("TXLivePlayerJSAdapter", "checkHardWareDecoder: invalid playUrl");
        AppMethodBeat.o(96137);
    }

    /* Access modifiers changed, original: final */
    public final void A(Bundle bundle) {
        AppMethodBeat.i(96138);
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
        AppMethodBeat.o(96138);
    }

    static void l(String str, Bundle bundle) {
        AppMethodBeat.i(96139);
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
        ab.i("TXLivePlayerJSAdapter", str);
        AppMethodBeat.o(96139);
    }

    static /* synthetic */ void G(Bitmap bitmap) {
        AppMethodBeat.i(96140);
        if (!(bitmap == null || bitmap.isRecycled())) {
            ab.i("TXLivePlayerJSAdapter", "bitmap recycle " + bitmap.toString());
            bitmap.recycle();
        }
        AppMethodBeat.o(96140);
    }
}
