package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;

public class AdLandingVideoWrapper extends RelativeLayout implements com.tencent.mm.model.d.a, h, com.tencent.mm.pluginsdk.ui.h.a, b, c {
    private boolean bkJ;
    private boolean fdh;
    private h hZY;
    private g iaa;
    private float iac;
    private int iad;
    private boolean iae;
    private d iaf;
    private Context mContext;
    private b rcd;
    private h.d rce;
    private a rcf;
    public ap rcg;
    private String url;

    public interface a {
        void Dq(int i);
    }

    public AdLandingVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdLandingVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(37370);
        this.rce = h.d.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.rcg = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(37369);
                if (AdLandingVideoWrapper.this.hZY == null || AdLandingVideoWrapper.this.rcf == null) {
                    AppMethodBeat.o(37369);
                    return false;
                }
                if (AdLandingVideoWrapper.this.rcf != null && AdLandingVideoWrapper.this.hZY.isPlaying()) {
                    AdLandingVideoWrapper.this.rcf.Dq(AdLandingVideoWrapper.this.hZY.getCurrPosSec());
                }
                AppMethodBeat.o(37369);
                return true;
            }
        }, true);
        this.mContext = context;
        this.iaf = new d();
        AppMethodBeat.o(37370);
    }

    public final void c(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.i(37371);
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
            if (cpS()) {
                ab.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                ab.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
            }
        } else if (cpS()) {
            if (this.hZY instanceof MMVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                ab.i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                ab.i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
                this.hZY.stop();
                i2 = 0;
            }
        } else if (this.hZY instanceof CommonVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            ab.i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
            this.hZY = aFU();
        } else {
            ab.i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", Integer.valueOf(hashCode()));
            this.hZY.stop();
            i2 = 0;
        }
        setScaleType(this.rce);
        as(this.iac);
        setMute(this.fdh);
        if (i2 != 0) {
            setVideoFooterView(this.iaa);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.hZY, layoutParams);
        }
        this.hZY.c(this.bkJ, this.url, this.iad);
        AppMethodBeat.o(37371);
    }

    private h aFT() {
        AppMethodBeat.i(37372);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        AppMethodBeat.o(37372);
        return commonVideoView;
    }

    private h aFU() {
        AppMethodBeat.i(37373);
        MMVideoView mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.setReporter(this);
        mMVideoView.setIMMVideoViewCallback(this);
        mMVideoView.setIMMDownloadFinish(this);
        String cqi = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.cqi();
        j.aih(cqi);
        mMVideoView.setRootPath(cqi);
        mMVideoView.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a());
        AppMethodBeat.o(37373);
        return mMVideoView;
    }

    private boolean cpS() {
        if (this.bkJ || this.iae) {
            return true;
        }
        return false;
    }

    public void setIMMVideoViewCallback(b bVar) {
        this.rcd = bVar;
    }

    public void setVideoPlayCallback(a aVar) {
        this.rcf = aVar;
    }

    public final void cpT() {
        AppMethodBeat.i(37374);
        this.rcg.stopTimer();
        this.rcg.ae(1000, 1000);
        AppMethodBeat.o(37374);
    }

    public void setVideoFooterView(g gVar) {
        AppMethodBeat.i(37375);
        this.iaa = gVar;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.o(37375);
    }

    public final void cpU() {
        AppMethodBeat.i(37376);
        if (this.hZY != null) {
            this.hZY.cpU();
        }
        AppMethodBeat.o(37376);
    }

    public int getPlayerType() {
        AppMethodBeat.i(37377);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.o(37377);
            return playerType;
        }
        AppMethodBeat.o(37377);
        return 0;
    }

    public final boolean s(double d) {
        AppMethodBeat.i(37378);
        if (this.hZY != null) {
            boolean s = this.hZY.s(d);
            AppMethodBeat.o(37378);
            return s;
        }
        AppMethodBeat.o(37378);
        return false;
    }

    public final boolean e(double d, boolean z) {
        AppMethodBeat.i(37379);
        if (this.hZY != null) {
            boolean e = this.hZY.e(d, z);
            AppMethodBeat.o(37379);
            return e;
        }
        AppMethodBeat.o(37379);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(37380);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(37380);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.i(37381);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.o(37381);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.i(37382);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.o(37382);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.o(37382);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(37383);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.o(37383);
            return currPosMs;
        }
        AppMethodBeat.o(37383);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(37384);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.o(37384);
            return currPosSec;
        }
        AppMethodBeat.o(37384);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(37385);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.o(37385);
            return cacheTimeSec;
        }
        AppMethodBeat.o(37385);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(37386);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.o(37386);
            return isPlaying;
        }
        AppMethodBeat.o(37386);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.i(37387);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.o(37387);
            return isLive;
        }
        AppMethodBeat.o(37387);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(37388);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.o(37388);
    }

    public final void start() {
        AppMethodBeat.i(37389);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.a(this);
        }
        AppMethodBeat.o(37389);
    }

    public final void stop() {
        AppMethodBeat.i(37390);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(37390);
    }

    public final boolean pause() {
        AppMethodBeat.i(37391);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.o(37391);
            return pause;
        }
        AppMethodBeat.o(37391);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(37392);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.o(37392);
    }

    public final void akW() {
        AppMethodBeat.i(37393);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.o(37393);
    }

    public final void akV() {
        AppMethodBeat.i(37394);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(37394);
    }

    public final void aEX() {
        AppMethodBeat.i(37395);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(37395);
    }

    public void setScaleType(h.d dVar) {
        AppMethodBeat.i(37396);
        this.rce = dVar;
        if (this.hZY != null) {
            this.hZY.setScaleType(this.rce);
        }
        AppMethodBeat.o(37396);
    }

    public final boolean as(float f) {
        AppMethodBeat.i(37397);
        if (f <= 0.0f) {
            AppMethodBeat.o(37397);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.as(this.iac);
            AppMethodBeat.o(37397);
            return as;
        }
        AppMethodBeat.o(37397);
        return false;
    }

    public final void am(String str, boolean z) {
        AppMethodBeat.i(37398);
        ab.i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        AppMethodBeat.o(37398);
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(37399);
        ab.w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.c(str, str2, str3, i, i2);
        }
        com.tencent.mm.plugin.report.service.h.pYm.k(955, 36, 1);
        AppMethodBeat.o(37399);
    }

    public final void cp(String str, String str2) {
        AppMethodBeat.i(37400);
        ab.i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.cp(str, str2);
        }
        AppMethodBeat.o(37400);
    }

    public final void cq(String str, String str2) {
        AppMethodBeat.i(37401);
        ab.i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.cq(str, str2);
        }
        com.tencent.mm.plugin.report.service.h.pYm.k(955, 35, 1);
        AppMethodBeat.o(37401);
    }

    public final void d(String str, String str2, int i, int i2) {
        AppMethodBeat.i(37402);
        ab.i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.d(str, str2, i, i2);
        }
        AppMethodBeat.o(37402);
    }

    public final void cr(String str, String str2) {
        AppMethodBeat.i(37403);
        ab.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.cy(false);
        if (this.rcd != null) {
            this.rcd.cr(str, str2);
        }
        AppMethodBeat.o(37403);
    }

    public final void cs(String str, String str2) {
        AppMethodBeat.i(37404);
        ab.d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.a(this);
        if (this.rcd != null) {
            this.rcd.cs(str, str2);
        }
        AppMethodBeat.o(37404);
    }

    public final void ct(String str, String str2) {
        AppMethodBeat.i(37405);
        if (this.rcd != null) {
            this.rcd.ct(str, str2);
        }
        AppMethodBeat.o(37405);
    }

    public final void cu(String str, String str2) {
        AppMethodBeat.i(37406);
        if (this.rcd != null) {
            this.rcd.cu(str, str2);
        }
        AppMethodBeat.o(37406);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(37407);
        ab.d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(37407);
    }

    public final void gp(long j) {
        AppMethodBeat.i(37408);
        com.tencent.mm.plugin.report.service.h.pYm.a(600, j, 1, false);
        AppMethodBeat.o(37408);
    }

    public final void wB(String str) {
        AppMethodBeat.i(37409);
        com.tencent.mm.plugin.report.service.h.pYm.X(14349, str);
        AppMethodBeat.o(37409);
    }
}
