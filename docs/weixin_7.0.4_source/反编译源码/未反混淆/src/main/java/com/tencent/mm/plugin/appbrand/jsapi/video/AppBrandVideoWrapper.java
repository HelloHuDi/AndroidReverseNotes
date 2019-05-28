package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.network.u;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;

public class AppBrandVideoWrapper extends RelativeLayout implements a, d, h.a, b, c {
    private boolean bkJ;
    private boolean fdh;
    private h hZY;
    private d.b hZZ;
    protected int hZs;
    private g iaa;
    private d.g iab;
    private float iac;
    private int iad;
    private boolean iae;
    private d iaf;
    private Context mContext;
    private String url;

    public static void aDc() {
        AppMethodBeat.i(131587);
        AppBrandVideoView.setProxy(new AppBrandVideoView.b() {
            public final AppBrandVideoView cM(Context context) {
                AppMethodBeat.i(131585);
                View appBrandVideoWrapper = new AppBrandVideoWrapper(context);
                AppBrandVideoView appBrandVideoView = new AppBrandVideoView(context, appBrandVideoWrapper);
                d.a appBrandVideoViewControlBar = new AppBrandVideoViewControlBar(context);
                appBrandVideoView.a(appBrandVideoViewControlBar);
                appBrandVideoWrapper.setVideoFooterView(appBrandVideoViewControlBar);
                AppMethodBeat.o(131585);
                return appBrandVideoView;
            }
        });
        AppMethodBeat.o(131587);
    }

    public AppBrandVideoWrapper(Context context) {
        this(context, null);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(131588);
        this.iab = d.g.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.hZs = 0;
        this.mContext = context;
        this.iaf = new d();
        AppMethodBeat.o(131588);
    }

    public final void c(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.i(131589);
        this.iad = i;
        this.bkJ = z;
        PString pString = new PString();
        pString.value = str;
        if (bo.isNullOrNil(pString.value) || pString.value.indexOf("file://") != 0) {
            z2 = false;
        } else {
            pString.value = pString.value.substring(7);
            z2 = true;
        }
        this.iae = z2;
        this.url = pString.value;
        if (this.hZY == null) {
            if (a(this.bkJ, this.url, "")) {
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
            }
        } else if (a(this.bkJ, this.url, "")) {
            if (this.hZY instanceof MMVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
                this.hZY.stop();
                i2 = 0;
            }
        } else if (this.hZY instanceof CommonVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            ab.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
            this.hZY = aFU();
        } else {
            ab.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", Integer.valueOf(hashCode()));
            this.hZY.stop();
            i2 = 0;
        }
        setScaleType(this.iab);
        as(this.iac);
        setMute(this.fdh);
        if (i2 != 0) {
            setVideoFooterView(this.iaa);
            addView((View) this.hZY, new LayoutParams(-1, -1));
        }
        this.hZY.c(this.bkJ, this.url, this.iad);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131586);
                AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
                AppMethodBeat.o(131586);
            }
        }, "AppBrandVideo_checkVideoUrl");
        AppMethodBeat.o(131589);
    }

    public void setVideoSource(int i) {
        this.hZs = i;
    }

    private h aFT() {
        AppMethodBeat.i(131590);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.KM(this.hZs);
        commonVideoView.setIMMVideoViewCallback(this);
        gp(200);
        AppMethodBeat.o(131590);
        return commonVideoView;
    }

    private h aFU() {
        AppMethodBeat.i(131591);
        MMVideoView mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.setReporter(this);
        mMVideoView.setIMMVideoViewCallback(this);
        mMVideoView.setIOnlineVideoProxy(new AppBrandOnlineVideoProxy());
        mMVideoView.setIMMDownloadFinish(this);
        String str = e.eSn + "appbrandvideo/";
        j.aih(str);
        mMVideoView.setRootPath(str);
        gp(201);
        AppMethodBeat.o(131591);
        return mMVideoView;
    }

    private boolean a(boolean z, String str, String str2) {
        AppMethodBeat.i(131592);
        if (z || this.iae) {
            AppMethodBeat.o(131592);
            return true;
        } else if (com.tencent.mm.compatible.util.d.fP(18)) {
            AppMethodBeat.o(131592);
            return true;
        } else {
            ab.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", Integer.valueOf(ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getInt("appbrand_video_player", -1)));
            if (ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mu()).getInt("appbrand_video_player", -1) <= 0) {
                ab.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
                AppMethodBeat.o(131592);
                return true;
            } else if (!bo.isNullOrNil(str) && str.contains(".m3u8")) {
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
                gp(204);
                AppMethodBeat.o(131592);
                return true;
            } else if (r.ud(str2)) {
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
                gp(204);
                AppMethodBeat.o(131592);
                return true;
            } else {
                AppMethodBeat.o(131592);
                return false;
            }
        }
    }

    public void setIMMVideoViewCallback(d.b bVar) {
        this.hZZ = bVar;
    }

    public void setVideoFooterView(g gVar) {
        AppMethodBeat.i(131593);
        this.iaa = gVar;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.o(131593);
    }

    public int getPlayerType() {
        AppMethodBeat.i(131594);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.o(131594);
            return playerType;
        }
        AppMethodBeat.o(131594);
        return 0;
    }

    public final boolean s(double d) {
        AppMethodBeat.i(131595);
        if (this.hZY != null) {
            boolean s = this.hZY.s(d);
            AppMethodBeat.o(131595);
            return s;
        }
        AppMethodBeat.o(131595);
        return false;
    }

    public final boolean e(double d, boolean z) {
        AppMethodBeat.i(131596);
        if (this.hZY != null) {
            boolean e = this.hZY.e(d, z);
            AppMethodBeat.o(131596);
            return e;
        }
        AppMethodBeat.o(131596);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(131597);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(131597);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.i(131598);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.o(131598);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.i(131599);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.o(131599);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.o(131599);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(131600);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.o(131600);
            return currPosMs;
        }
        AppMethodBeat.o(131600);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(131601);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.o(131601);
            return currPosSec;
        }
        AppMethodBeat.o(131601);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(131602);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.o(131602);
            return cacheTimeSec;
        }
        AppMethodBeat.o(131602);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(131603);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.o(131603);
            return isPlaying;
        }
        AppMethodBeat.o(131603);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.i(131604);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.o(131604);
            return isLive;
        }
        AppMethodBeat.o(131604);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(131605);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.o(131605);
    }

    public final void start() {
        AppMethodBeat.i(131606);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.a(this);
        }
        AppMethodBeat.o(131606);
    }

    public final void stop() {
        AppMethodBeat.i(131607);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(131607);
    }

    public final boolean pause() {
        AppMethodBeat.i(131608);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.o(131608);
            return pause;
        }
        AppMethodBeat.o(131608);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(131609);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.o(131609);
    }

    public final void akW() {
        AppMethodBeat.i(131610);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.o(131610);
    }

    public final void akV() {
        AppMethodBeat.i(131611);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(131611);
    }

    public final void aEX() {
        AppMethodBeat.i(131612);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(131612);
    }

    public void setScaleType(d.g gVar) {
        AppMethodBeat.i(131613);
        this.iab = gVar;
        if (this.hZY != null) {
            h.d dVar;
            h hVar = this.hZY;
            d.g gVar2 = this.iab;
            if (gVar2 != null) {
                String name = gVar2.name();
                Object obj = -1;
                switch (name.hashCode()) {
                    case 2157955:
                        if (name.equals("FILL")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 64314263:
                        if (name.equals("COVER")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case 1669509300:
                        if (name.equals("CONTAIN")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        dVar = h.d.CONTAIN;
                        break;
                    case 1:
                        dVar = h.d.COVER;
                        break;
                    case 2:
                        dVar = h.d.FILL;
                        break;
                }
            }
            dVar = h.d.DEFAULT;
            hVar.setScaleType(dVar);
        }
        AppMethodBeat.o(131613);
    }

    public final boolean as(float f) {
        AppMethodBeat.i(131614);
        if (f <= 0.0f) {
            AppMethodBeat.o(131614);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.as(this.iac);
            AppMethodBeat.o(131614);
            return as;
        }
        AppMethodBeat.o(131614);
        return false;
    }

    public void setControlBar(d.a aVar) {
    }

    public final void am(String str, boolean z) {
        AppMethodBeat.i(131615);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(131615);
            return;
        }
        int i;
        if (a(false, "", str)) {
            if (this.hZY instanceof MMVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
                i = 1;
            }
            i = 0;
        } else {
            if (this.hZY instanceof CommonVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
                i = 1;
            }
            i = 0;
        }
        setScaleType(this.iab);
        as(this.iac);
        setMute(this.fdh);
        if (i != 0) {
            setVideoFooterView(this.iaa);
            addView((View) this.hZY, new LayoutParams(-1, -1));
            this.hZY.c(this.bkJ, this.url, this.iad);
            this.hZY.start();
        }
        AppMethodBeat.o(131615);
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(131616);
        ab.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hZZ != null) {
            this.hZZ.H(str3, i, i2);
        }
        AppMethodBeat.o(131616);
    }

    public final void cp(String str, String str2) {
        AppMethodBeat.i(131617);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.hZZ != null) {
            this.hZZ.aFq();
        }
        if (isLive()) {
            gp(203);
            AppMethodBeat.o(131617);
            return;
        }
        gp(202);
        AppMethodBeat.o(131617);
    }

    public final void cq(String str, String str2) {
        AppMethodBeat.i(131618);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.hZZ != null) {
            this.hZZ.aFr();
        }
        AppMethodBeat.o(131618);
    }

    public final void d(String str, String str2, int i, int i2) {
        AppMethodBeat.i(131619);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hZZ != null) {
            this.hZZ.de(i, i2);
        }
        AppMethodBeat.o(131619);
    }

    public final void cr(String str, String str2) {
        AppMethodBeat.i(131620);
        ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.cy(false);
        if (this.hZZ != null) {
            this.hZZ.aFs();
        }
        AppMethodBeat.o(131620);
    }

    public final void cs(String str, String str2) {
        AppMethodBeat.i(131621);
        ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.a(this);
        if (this.hZZ != null) {
            this.hZZ.aFt();
        }
        AppMethodBeat.o(131621);
    }

    public final void ct(String str, String str2) {
        AppMethodBeat.i(131622);
        if (this.hZZ != null) {
            this.hZZ.aFu();
        }
        AppMethodBeat.o(131622);
    }

    public final void cu(String str, String str2) {
        AppMethodBeat.i(131623);
        if (this.hZZ != null) {
            this.hZZ.aFv();
        }
        AppMethodBeat.o(131623);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(131624);
        ab.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(131624);
    }

    public final void gp(long j) {
        AppMethodBeat.i(131625);
        com.tencent.mm.plugin.report.service.h.pYm.a(600, j, 1, false);
        AppMethodBeat.o(131625);
    }

    public final void wB(String str) {
        AppMethodBeat.i(131626);
        com.tencent.mm.plugin.report.service.h.pYm.X(14349, str);
        AppMethodBeat.o(131626);
    }

    static /* synthetic */ void a(AppBrandVideoWrapper appBrandVideoWrapper) {
        AppMethodBeat.i(131627);
        if (!bo.isNullOrNil(appBrandVideoWrapper.url) && appBrandVideoWrapper.url.startsWith("http")) {
            try {
                u a = com.tencent.mm.network.b.a(appBrandVideoWrapper.url, null);
                a.connect();
                int responseCode = a.getResponseCode();
                ab.i("MicroMsg.AppBrandVideoWrapper", "check video url http ret code: %s", Integer.valueOf(responseCode));
                if (responseCode >= 400 && appBrandVideoWrapper.hZZ != null) {
                    appBrandVideoWrapper.hZZ.H("http error", -1, responseCode);
                }
                a.connection.disconnect();
                AppMethodBeat.o(131627);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandVideoWrapper", e, "check video url error: %s", e.getMessage());
                if (null != null) {
                    null.connection.disconnect();
                    AppMethodBeat.o(131627);
                    return;
                }
            } catch (Throwable th) {
                if (null != null) {
                    null.connection.disconnect();
                }
                AppMethodBeat.o(131627);
            }
        }
        AppMethodBeat.o(131627);
    }
}
