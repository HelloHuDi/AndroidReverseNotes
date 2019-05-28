package com.tencent.p177mm.plugin.webview.p580ui.tools.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C30135g;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.media.WebVideoWrapper */
public class WebVideoWrapper extends RelativeLayout implements C42190a, C44091h, C23324b, C23325c {
    private boolean bkJ;
    private C44091h hZY;
    private int iad;
    private C42192d iaf;
    private Context mContext;
    private C23324b rcd;
    private String url;

    public WebVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(9860);
        this.mContext = context;
        this.iaf = new C42192d();
        if (this.hZY == null) {
            CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
            commonVideoView.setReporter(this);
            commonVideoView.setIMMVideoViewCallback(this);
            mo26918gp(200);
            this.hZY = commonVideoView;
        }
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView((View) this.hZY, layoutParams);
        AppMethodBeat.m2505o(9860);
    }

    /* renamed from: c */
    public final void mo9063c(boolean z, String str, int i) {
        AppMethodBeat.m2504i(9861);
        this.iad = i;
        this.bkJ = z;
        this.url = str;
        if (this.hZY != null) {
            this.hZY.mo9063c(this.bkJ, this.url, this.iad);
        }
        AppMethodBeat.m2505o(9861);
    }

    public void setIMMVideoViewCallback(C23324b c23324b) {
        this.rcd = c23324b;
    }

    public void setVideoFooterView(C30135g c30135g) {
        AppMethodBeat.m2504i(9862);
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(c30135g);
        }
        AppMethodBeat.m2505o(9862);
    }

    public final void cpU() {
        AppMethodBeat.m2504i(9863);
        if (this.hZY != null) {
            this.hZY.cpU();
        }
        AppMethodBeat.m2505o(9863);
    }

    public int getPlayerType() {
        AppMethodBeat.m2504i(9864);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.m2505o(9864);
            return playerType;
        }
        AppMethodBeat.m2505o(9864);
        return 0;
    }

    /* renamed from: s */
    public final boolean mo26920s(double d) {
        AppMethodBeat.m2504i(9865);
        if (this.hZY != null) {
            boolean s = this.hZY.mo26920s(d);
            AppMethodBeat.m2505o(9865);
            return s;
        }
        AppMethodBeat.m2505o(9865);
        return false;
    }

    /* renamed from: e */
    public final boolean mo26912e(double d, boolean z) {
        AppMethodBeat.m2504i(9866);
        if (this.hZY != null) {
            boolean e = this.hZY.mo26912e(d, z);
            AppMethodBeat.m2505o(9866);
            return e;
        }
        AppMethodBeat.m2505o(9866);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(9867);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.m2505o(9867);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.m2504i(9868);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.m2505o(9868);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.m2504i(9869);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.m2505o(9869);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.m2505o(9869);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(9870);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.m2505o(9870);
            return currPosMs;
        }
        AppMethodBeat.m2505o(9870);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(9871);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.m2505o(9871);
            return currPosSec;
        }
        AppMethodBeat.m2505o(9871);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(9872);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.m2505o(9872);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(9872);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(9873);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.m2505o(9873);
            return isPlaying;
        }
        AppMethodBeat.m2505o(9873);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.m2504i(9874);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.m2505o(9874);
            return isLive;
        }
        AppMethodBeat.m2505o(9874);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.m2504i(9875);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.m2505o(9875);
    }

    public final void start() {
        AppMethodBeat.m2504i(9876);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.mo67732a(this);
        }
        AppMethodBeat.m2505o(9876);
    }

    public final void stop() {
        AppMethodBeat.m2504i(9877);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.mo67733cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.m2505o(9877);
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(9878);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.mo67733cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.m2505o(9878);
            return pause;
        }
        AppMethodBeat.m2505o(9878);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(9879);
        if (this.hZY != null) {
            this.hZY.setMute(z);
        }
        AppMethodBeat.m2505o(9879);
    }

    public final void akW() {
        AppMethodBeat.m2504i(9880);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.m2505o(9880);
    }

    public final void akV() {
        AppMethodBeat.m2504i(9881);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(9881);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(9882);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(9882);
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(9883);
        if (this.hZY != null) {
            this.hZY.setScaleType(c35873d);
        }
        AppMethodBeat.m2505o(9883);
    }

    /* renamed from: as */
    public final boolean mo26910as(float f) {
        AppMethodBeat.m2504i(9884);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(9884);
            return false;
        } else if (this.hZY != null) {
            boolean as = this.hZY.mo26910as(f);
            AppMethodBeat.m2505o(9884);
            return as;
        } else {
            AppMethodBeat.m2505o(9884);
            return false;
        }
    }

    /* renamed from: c */
    public final void mo9209c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(9885);
        C4990ab.m7421w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9209c(str, str2, str3, i, i2);
        }
        AppMethodBeat.m2505o(9885);
    }

    /* renamed from: cp */
    public final void mo9210cp(String str, String str2) {
        AppMethodBeat.m2504i(9886);
        C4990ab.m7417i("MicroMsg.WebVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.mo9210cp(str, str2);
        }
        AppMethodBeat.m2505o(9886);
    }

    /* renamed from: cq */
    public final void mo9211cq(String str, String str2) {
        AppMethodBeat.m2504i(9887);
        C4990ab.m7417i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.mo9211cq(str, str2);
        }
        AppMethodBeat.m2505o(9887);
    }

    /* renamed from: d */
    public final void mo9216d(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(9888);
        C4990ab.m7417i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9216d(str, str2, i, i2);
        }
        AppMethodBeat.m2505o(9888);
    }

    /* renamed from: cr */
    public final void mo9212cr(String str, String str2) {
        AppMethodBeat.m2504i(9889);
        C4990ab.m7411d("MicroMsg.WebVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.mo67733cy(false);
        if (this.rcd != null) {
            this.rcd.mo9212cr(str, str2);
        }
        AppMethodBeat.m2505o(9889);
    }

    /* renamed from: cs */
    public final void mo9213cs(String str, String str2) {
        AppMethodBeat.m2504i(9890);
        C4990ab.m7411d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.mo67732a(this);
        if (this.rcd != null) {
            this.rcd.mo9213cs(str, str2);
        }
        AppMethodBeat.m2505o(9890);
    }

    /* renamed from: ct */
    public final void mo9214ct(String str, String str2) {
        AppMethodBeat.m2504i(9891);
        if (this.rcd != null) {
            this.rcd.mo9214ct(str, str2);
        }
        AppMethodBeat.m2505o(9891);
    }

    /* renamed from: cu */
    public final void mo9215cu(String str, String str2) {
        AppMethodBeat.m2504i(9892);
        if (this.rcd != null) {
            this.rcd.mo9215cu(str, str2);
        }
        AppMethodBeat.m2505o(9892);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(9893);
        C4990ab.m7411d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), C5046bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.m2505o(9893);
    }

    /* renamed from: gp */
    public final void mo26918gp(long j) {
        AppMethodBeat.m2504i(9894);
        C7060h.pYm.mo8378a(600, j, 1, false);
        AppMethodBeat.m2505o(9894);
    }

    /* renamed from: wB */
    public final void mo26927wB(String str) {
        AppMethodBeat.m2504i(9895);
        C7060h.pYm.mo8374X(14349, str);
        AppMethodBeat.m2505o(9895);
    }
}
