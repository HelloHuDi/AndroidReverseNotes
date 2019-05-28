package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FtsVideoWrapper extends RelativeLayout implements a, h, h.a, b, c {
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
    private String url;

    public FtsVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FtsVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(5777);
        this.rce = h.d.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.mContext = context;
        this.iaf = new d();
        AppMethodBeat.o(5777);
    }

    public final void c(boolean z, String str, int i) {
        int i2;
        AppMethodBeat.i(5778);
        this.iad = i;
        this.bkJ = z;
        PString pString = new PString();
        pString.value = str;
        bo.isNullOrNil(pString.value);
        this.iae = false;
        this.url = pString.value;
        if (this.hZY == null) {
            ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
            this.hZY = aFT();
            i2 = 1;
        } else if (this.hZY instanceof MMVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
            this.hZY = aFT();
            i2 = 1;
        } else {
            ab.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
            this.hZY.stop();
            boolean i22 = false;
        }
        setScaleType(this.rce);
        as(this.iac);
        setMute(this.fdh);
        if (i22 != 0) {
            setVideoFooterView(this.iaa);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.hZY, layoutParams);
        }
        this.hZY.c(this.bkJ, this.url, this.iad);
        AppMethodBeat.o(5778);
    }

    private h aFT() {
        AppMethodBeat.i(5779);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        AppMethodBeat.o(5779);
        return commonVideoView;
    }

    public void setIMMVideoViewCallback(b bVar) {
        this.rcd = bVar;
    }

    public void setVideoFooterView(g gVar) {
        AppMethodBeat.i(5780);
        this.iaa = gVar;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.o(5780);
    }

    public final void cpU() {
        AppMethodBeat.i(5781);
        if (this.hZY != null) {
            this.hZY.cpU();
        }
        AppMethodBeat.o(5781);
    }

    public int getPlayerType() {
        AppMethodBeat.i(5782);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.o(5782);
            return playerType;
        }
        AppMethodBeat.o(5782);
        return 0;
    }

    public final boolean s(double d) {
        AppMethodBeat.i(5783);
        if (this.hZY != null) {
            boolean s = this.hZY.s(d);
            AppMethodBeat.o(5783);
            return s;
        }
        AppMethodBeat.o(5783);
        return false;
    }

    public final boolean e(double d, boolean z) {
        AppMethodBeat.i(5784);
        if (this.hZY != null) {
            boolean e = this.hZY.e(d, z);
            AppMethodBeat.o(5784);
            return e;
        }
        AppMethodBeat.o(5784);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(5785);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.o(5785);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.i(5786);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.o(5786);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.i(5787);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.o(5787);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.o(5787);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(5788);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.o(5788);
            return currPosMs;
        }
        AppMethodBeat.o(5788);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(5789);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.o(5789);
            return currPosSec;
        }
        AppMethodBeat.o(5789);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(5790);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.o(5790);
            return cacheTimeSec;
        }
        AppMethodBeat.o(5790);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(5791);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.o(5791);
            return isPlaying;
        }
        AppMethodBeat.o(5791);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.i(5792);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.o(5792);
            return isLive;
        }
        AppMethodBeat.o(5792);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.i(5793);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.o(5793);
    }

    public final void start() {
        AppMethodBeat.i(5794);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.a(this);
        }
        AppMethodBeat.o(5794);
    }

    public final void stop() {
        AppMethodBeat.i(5795);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.o(5795);
    }

    public final boolean pause() {
        AppMethodBeat.i(5796);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.o(5796);
            return pause;
        }
        AppMethodBeat.o(5796);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(5797);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.o(5797);
    }

    public final void akW() {
        AppMethodBeat.i(5798);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.o(5798);
    }

    public final void akV() {
        AppMethodBeat.i(5799);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(5799);
    }

    public final void aEX() {
        AppMethodBeat.i(5800);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.o(5800);
    }

    public void setScaleType(h.d dVar) {
        AppMethodBeat.i(5801);
        this.rce = dVar;
        if (this.hZY != null) {
            this.hZY.setScaleType(this.rce);
        }
        AppMethodBeat.o(5801);
    }

    public final boolean as(float f) {
        AppMethodBeat.i(5802);
        if (f <= 0.0f) {
            AppMethodBeat.o(5802);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.as(this.iac);
            AppMethodBeat.o(5802);
            return as;
        }
        AppMethodBeat.o(5802);
        return false;
    }

    public final void am(String str, boolean z) {
        AppMethodBeat.i(5803);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(5803);
            return;
        }
        int i;
        if (this.hZY instanceof MMVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", Integer.valueOf(hashCode()));
            this.hZY = aFT();
            i = 1;
        } else {
            i = 0;
        }
        setScaleType(this.rce);
        as(this.iac);
        setMute(this.fdh);
        if (i != 0) {
            setVideoFooterView(this.iaa);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.hZY, layoutParams);
            this.hZY.c(this.bkJ, this.url, this.iad);
            this.hZY.start();
        }
        AppMethodBeat.o(5803);
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(5804);
        ab.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.c(str, str2, str3, i, i2);
        }
        AppMethodBeat.o(5804);
    }

    public final void cp(String str, String str2) {
        AppMethodBeat.i(5805);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.cp(str, str2);
        }
        AppMethodBeat.o(5805);
    }

    public final void cq(String str, String str2) {
        AppMethodBeat.i(5806);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.cq(str, str2);
        }
        AppMethodBeat.o(5806);
    }

    public final void d(String str, String str2, int i, int i2) {
        AppMethodBeat.i(5807);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.d(str, str2, i, i2);
        }
        AppMethodBeat.o(5807);
    }

    public final void cr(String str, String str2) {
        AppMethodBeat.i(5808);
        ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.cy(false);
        if (this.rcd != null) {
            this.rcd.cr(str, str2);
        }
        AppMethodBeat.o(5808);
    }

    public final void cs(String str, String str2) {
        AppMethodBeat.i(5809);
        ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.a(this);
        if (this.rcd != null) {
            this.rcd.cs(str, str2);
        }
        AppMethodBeat.o(5809);
    }

    public final void ct(String str, String str2) {
        AppMethodBeat.i(5810);
        if (this.rcd != null) {
            this.rcd.ct(str, str2);
        }
        AppMethodBeat.o(5810);
    }

    public final void cu(String str, String str2) {
        AppMethodBeat.i(5811);
        if (this.rcd != null) {
            this.rcd.cu(str, str2);
        }
        AppMethodBeat.o(5811);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(5812);
        ab.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.o(5812);
    }

    public final void gp(long j) {
        AppMethodBeat.i(5813);
        com.tencent.mm.plugin.report.service.h.pYm.a(600, j, 1, false);
        AppMethodBeat.o(5813);
    }

    public final void wB(String str) {
        AppMethodBeat.i(5814);
        com.tencent.mm.plugin.report.service.h.pYm.X(14349, str);
        AppMethodBeat.o(5814);
    }
}
