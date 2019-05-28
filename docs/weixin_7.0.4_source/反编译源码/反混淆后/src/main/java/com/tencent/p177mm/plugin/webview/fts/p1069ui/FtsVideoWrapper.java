package com.tencent.p177mm.plugin.webview.fts.p1069ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.modelvideo.MMVideoView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C30135g;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23323a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper */
public class FtsVideoWrapper extends RelativeLayout implements C42190a, C44091h, C23323a, C23324b, C23325c {
    private boolean bkJ;
    private boolean fdh;
    private C44091h hZY;
    private C30135g iaa;
    private float iac;
    private int iad;
    private boolean iae;
    private C42192d iaf;
    private Context mContext;
    private C23324b rcd;
    private C35873d rce;
    private String url;

    public FtsVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FtsVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(5777);
        this.rce = C35873d.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.mContext = context;
        this.iaf = new C42192d();
        AppMethodBeat.m2505o(5777);
    }

    /* renamed from: c */
    public final void mo9063c(boolean z, String str, int i) {
        int i2;
        AppMethodBeat.m2504i(5778);
        this.iad = i;
        this.bkJ = z;
        PString pString = new PString();
        pString.value = str;
        C5046bo.isNullOrNil(pString.value);
        this.iae = false;
        this.url = pString.value;
        if (this.hZY == null) {
            C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
            this.hZY = aFT();
            i2 = 1;
        } else if (this.hZY instanceof MMVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
            this.hZY = aFT();
            i2 = 1;
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
            this.hZY.stop();
            boolean i22 = false;
        }
        setScaleType(this.rce);
        mo26910as(this.iac);
        setMute(this.fdh);
        if (i22 != 0) {
            setVideoFooterView(this.iaa);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.hZY, layoutParams);
        }
        this.hZY.mo9063c(this.bkJ, this.url, this.iad);
        AppMethodBeat.m2505o(5778);
    }

    private C44091h aFT() {
        AppMethodBeat.m2504i(5779);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        AppMethodBeat.m2505o(5779);
        return commonVideoView;
    }

    public void setIMMVideoViewCallback(C23324b c23324b) {
        this.rcd = c23324b;
    }

    public void setVideoFooterView(C30135g c30135g) {
        AppMethodBeat.m2504i(5780);
        this.iaa = c30135g;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.m2505o(5780);
    }

    public final void cpU() {
        AppMethodBeat.m2504i(5781);
        if (this.hZY != null) {
            this.hZY.cpU();
        }
        AppMethodBeat.m2505o(5781);
    }

    public int getPlayerType() {
        AppMethodBeat.m2504i(5782);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.m2505o(5782);
            return playerType;
        }
        AppMethodBeat.m2505o(5782);
        return 0;
    }

    /* renamed from: s */
    public final boolean mo26920s(double d) {
        AppMethodBeat.m2504i(5783);
        if (this.hZY != null) {
            boolean s = this.hZY.mo26920s(d);
            AppMethodBeat.m2505o(5783);
            return s;
        }
        AppMethodBeat.m2505o(5783);
        return false;
    }

    /* renamed from: e */
    public final boolean mo26912e(double d, boolean z) {
        AppMethodBeat.m2504i(5784);
        if (this.hZY != null) {
            boolean e = this.hZY.mo26912e(d, z);
            AppMethodBeat.m2505o(5784);
            return e;
        }
        AppMethodBeat.m2505o(5784);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(5785);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.m2505o(5785);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.m2504i(5786);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.m2505o(5786);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.m2504i(5787);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.m2505o(5787);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.m2505o(5787);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(5788);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.m2505o(5788);
            return currPosMs;
        }
        AppMethodBeat.m2505o(5788);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(5789);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.m2505o(5789);
            return currPosSec;
        }
        AppMethodBeat.m2505o(5789);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(5790);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.m2505o(5790);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(5790);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(5791);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.m2505o(5791);
            return isPlaying;
        }
        AppMethodBeat.m2505o(5791);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.m2504i(5792);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.m2505o(5792);
            return isLive;
        }
        AppMethodBeat.m2505o(5792);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.m2504i(5793);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.m2505o(5793);
    }

    public final void start() {
        AppMethodBeat.m2504i(5794);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.mo67732a(this);
        }
        AppMethodBeat.m2505o(5794);
    }

    public final void stop() {
        AppMethodBeat.m2504i(5795);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.mo67733cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.m2505o(5795);
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(5796);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.mo67733cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.m2505o(5796);
            return pause;
        }
        AppMethodBeat.m2505o(5796);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(5797);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.m2505o(5797);
    }

    public final void akW() {
        AppMethodBeat.m2504i(5798);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.m2505o(5798);
    }

    public final void akV() {
        AppMethodBeat.m2504i(5799);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(5799);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(5800);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(5800);
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(5801);
        this.rce = c35873d;
        if (this.hZY != null) {
            this.hZY.setScaleType(this.rce);
        }
        AppMethodBeat.m2505o(5801);
    }

    /* renamed from: as */
    public final boolean mo26910as(float f) {
        AppMethodBeat.m2504i(5802);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(5802);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.mo26910as(this.iac);
            AppMethodBeat.m2505o(5802);
            return as;
        }
        AppMethodBeat.m2505o(5802);
        return false;
    }

    /* renamed from: am */
    public final void mo39053am(String str, boolean z) {
        AppMethodBeat.m2504i(5803);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.m2505o(5803);
            return;
        }
        int i;
        if (this.hZY instanceof MMVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", Integer.valueOf(hashCode()));
            this.hZY = aFT();
            i = 1;
        } else {
            i = 0;
        }
        setScaleType(this.rce);
        mo26910as(this.iac);
        setMute(this.fdh);
        if (i != 0) {
            setVideoFooterView(this.iaa);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.hZY, layoutParams);
            this.hZY.mo9063c(this.bkJ, this.url, this.iad);
            this.hZY.start();
        }
        AppMethodBeat.m2505o(5803);
    }

    /* renamed from: c */
    public final void mo9209c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(5804);
        C4990ab.m7421w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9209c(str, str2, str3, i, i2);
        }
        AppMethodBeat.m2505o(5804);
    }

    /* renamed from: cp */
    public final void mo9210cp(String str, String str2) {
        AppMethodBeat.m2504i(5805);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.mo9210cp(str, str2);
        }
        AppMethodBeat.m2505o(5805);
    }

    /* renamed from: cq */
    public final void mo9211cq(String str, String str2) {
        AppMethodBeat.m2504i(5806);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.mo9211cq(str, str2);
        }
        AppMethodBeat.m2505o(5806);
    }

    /* renamed from: d */
    public final void mo9216d(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(5807);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9216d(str, str2, i, i2);
        }
        AppMethodBeat.m2505o(5807);
    }

    /* renamed from: cr */
    public final void mo9212cr(String str, String str2) {
        AppMethodBeat.m2504i(5808);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.mo67733cy(false);
        if (this.rcd != null) {
            this.rcd.mo9212cr(str, str2);
        }
        AppMethodBeat.m2505o(5808);
    }

    /* renamed from: cs */
    public final void mo9213cs(String str, String str2) {
        AppMethodBeat.m2504i(5809);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.mo67732a(this);
        if (this.rcd != null) {
            this.rcd.mo9213cs(str, str2);
        }
        AppMethodBeat.m2505o(5809);
    }

    /* renamed from: ct */
    public final void mo9214ct(String str, String str2) {
        AppMethodBeat.m2504i(5810);
        if (this.rcd != null) {
            this.rcd.mo9214ct(str, str2);
        }
        AppMethodBeat.m2505o(5810);
    }

    /* renamed from: cu */
    public final void mo9215cu(String str, String str2) {
        AppMethodBeat.m2504i(5811);
        if (this.rcd != null) {
            this.rcd.mo9215cu(str, str2);
        }
        AppMethodBeat.m2505o(5811);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(5812);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), C5046bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.m2505o(5812);
    }

    /* renamed from: gp */
    public final void mo26918gp(long j) {
        AppMethodBeat.m2504i(5813);
        C7060h.pYm.mo8378a(600, j, 1, false);
        AppMethodBeat.m2505o(5813);
    }

    /* renamed from: wB */
    public final void mo26927wB(String str) {
        AppMethodBeat.m2504i(5814);
        C7060h.pYm.mo8374X(14349, str);
        AppMethodBeat.m2505o(5814);
    }
}
