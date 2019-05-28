package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

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
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.C3945a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.pluginsdk.p597ui.C30135g;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23323a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper */
public class AdLandingVideoWrapper extends RelativeLayout implements C42190a, C44091h, C23323a, C23324b, C23325c {
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
    private C29078a rcf;
    public C7564ap rcg;
    private String url;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper$a */
    public interface C29078a {
        /* renamed from: Dq */
        void mo15472Dq(int i);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper$1 */
    class C290791 implements C5015a {
        C290791() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(37369);
            if (AdLandingVideoWrapper.this.hZY == null || AdLandingVideoWrapper.this.rcf == null) {
                AppMethodBeat.m2505o(37369);
                return false;
            }
            if (AdLandingVideoWrapper.this.rcf != null && AdLandingVideoWrapper.this.hZY.isPlaying()) {
                AdLandingVideoWrapper.this.rcf.mo15472Dq(AdLandingVideoWrapper.this.hZY.getCurrPosSec());
            }
            AppMethodBeat.m2505o(37369);
            return true;
        }
    }

    public AdLandingVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdLandingVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(37370);
        this.rce = C35873d.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.rcg = new C7564ap(new C290791(), true);
        this.mContext = context;
        this.iaf = new C42192d();
        AppMethodBeat.m2505o(37370);
    }

    /* renamed from: c */
    public final void mo9063c(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.m2504i(37371);
        this.iad = i;
        this.bkJ = z;
        PString pString = new PString();
        pString.value = str;
        if (C5046bo.isNullOrNil(pString.value) || pString.value.indexOf("file://") != 0) {
            z2 = false;
        } else {
            pString.value = pString.value.substring(7);
            z2 = true;
        }
        this.iae = z2;
        this.url = pString.value;
        if (this.hZY == null) {
            if (cpS()) {
                C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
            }
        } else if (cpS()) {
            if (this.hZY instanceof MMVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
                this.hZY.stop();
                i2 = 0;
            }
        } else if (this.hZY instanceof CommonVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
            this.hZY = aFU();
        } else {
            C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d use last mm video view !", Integer.valueOf(hashCode()));
            this.hZY.stop();
            i2 = 0;
        }
        setScaleType(this.rce);
        mo26910as(this.iac);
        setMute(this.fdh);
        if (i2 != 0) {
            setVideoFooterView(this.iaa);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.hZY, layoutParams);
        }
        this.hZY.mo9063c(this.bkJ, this.url, this.iad);
        AppMethodBeat.m2505o(37371);
    }

    private C44091h aFT() {
        AppMethodBeat.m2504i(37372);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        AppMethodBeat.m2505o(37372);
        return commonVideoView;
    }

    private C44091h aFU() {
        AppMethodBeat.m2504i(37373);
        MMVideoView mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.setReporter(this);
        mMVideoView.setIMMVideoViewCallback(this);
        mMVideoView.setIMMDownloadFinish(this);
        String cqi = C13473h.cqi();
        C15428j.aih(cqi);
        mMVideoView.setRootPath(cqi);
        mMVideoView.setIOnlineVideoProxy(new C3945a());
        AppMethodBeat.m2505o(37373);
        return mMVideoView;
    }

    private boolean cpS() {
        if (this.bkJ || this.iae) {
            return true;
        }
        return false;
    }

    public void setIMMVideoViewCallback(C23324b c23324b) {
        this.rcd = c23324b;
    }

    public void setVideoPlayCallback(C29078a c29078a) {
        this.rcf = c29078a;
    }

    public final void cpT() {
        AppMethodBeat.m2504i(37374);
        this.rcg.stopTimer();
        this.rcg.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(37374);
    }

    public void setVideoFooterView(C30135g c30135g) {
        AppMethodBeat.m2504i(37375);
        this.iaa = c30135g;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.m2505o(37375);
    }

    public final void cpU() {
        AppMethodBeat.m2504i(37376);
        if (this.hZY != null) {
            this.hZY.cpU();
        }
        AppMethodBeat.m2505o(37376);
    }

    public int getPlayerType() {
        AppMethodBeat.m2504i(37377);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.m2505o(37377);
            return playerType;
        }
        AppMethodBeat.m2505o(37377);
        return 0;
    }

    /* renamed from: s */
    public final boolean mo26920s(double d) {
        AppMethodBeat.m2504i(37378);
        if (this.hZY != null) {
            boolean s = this.hZY.mo26920s(d);
            AppMethodBeat.m2505o(37378);
            return s;
        }
        AppMethodBeat.m2505o(37378);
        return false;
    }

    /* renamed from: e */
    public final boolean mo26912e(double d, boolean z) {
        AppMethodBeat.m2504i(37379);
        if (this.hZY != null) {
            boolean e = this.hZY.mo26912e(d, z);
            AppMethodBeat.m2505o(37379);
            return e;
        }
        AppMethodBeat.m2505o(37379);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(37380);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.m2505o(37380);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.m2504i(37381);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.m2505o(37381);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.m2504i(37382);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.m2505o(37382);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.m2505o(37382);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(37383);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.m2505o(37383);
            return currPosMs;
        }
        AppMethodBeat.m2505o(37383);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(37384);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.m2505o(37384);
            return currPosSec;
        }
        AppMethodBeat.m2505o(37384);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(37385);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.m2505o(37385);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(37385);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(37386);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.m2505o(37386);
            return isPlaying;
        }
        AppMethodBeat.m2505o(37386);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.m2504i(37387);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.m2505o(37387);
            return isLive;
        }
        AppMethodBeat.m2505o(37387);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.m2504i(37388);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.m2505o(37388);
    }

    public final void start() {
        AppMethodBeat.m2504i(37389);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.mo67732a(this);
        }
        AppMethodBeat.m2505o(37389);
    }

    public final void stop() {
        AppMethodBeat.m2504i(37390);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.mo67733cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.m2505o(37390);
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(37391);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.mo67733cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.m2505o(37391);
            return pause;
        }
        AppMethodBeat.m2505o(37391);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(37392);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.m2505o(37392);
    }

    public final void akW() {
        AppMethodBeat.m2504i(37393);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.m2505o(37393);
    }

    public final void akV() {
        AppMethodBeat.m2504i(37394);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(37394);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(37395);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(37395);
    }

    public void setScaleType(C35873d c35873d) {
        AppMethodBeat.m2504i(37396);
        this.rce = c35873d;
        if (this.hZY != null) {
            this.hZY.setScaleType(this.rce);
        }
        AppMethodBeat.m2505o(37396);
    }

    /* renamed from: as */
    public final boolean mo26910as(float f) {
        AppMethodBeat.m2504i(37397);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(37397);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.mo26910as(this.iac);
            AppMethodBeat.m2505o(37397);
            return as;
        }
        AppMethodBeat.m2505o(37397);
        return false;
    }

    /* renamed from: am */
    public final void mo39053am(String str, boolean z) {
        AppMethodBeat.m2504i(37398);
        C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        AppMethodBeat.m2505o(37398);
    }

    /* renamed from: c */
    public final void mo9209c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(37399);
        C4990ab.m7421w("MicroMsg.AdLandingVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9209c(str, str2, str3, i, i2);
        }
        C7060h.pYm.mo15419k(955, 36, 1);
        AppMethodBeat.m2505o(37399);
    }

    /* renamed from: cp */
    public final void mo9210cp(String str, String str2) {
        AppMethodBeat.m2504i(37400);
        C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.mo9210cp(str, str2);
        }
        AppMethodBeat.m2505o(37400);
    }

    /* renamed from: cq */
    public final void mo9211cq(String str, String str2) {
        AppMethodBeat.m2504i(37401);
        C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.rcd != null) {
            this.rcd.mo9211cq(str, str2);
        }
        C7060h.pYm.mo15419k(955, 35, 1);
        AppMethodBeat.m2505o(37401);
    }

    /* renamed from: d */
    public final void mo9216d(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(37402);
        C4990ab.m7417i("MicroMsg.AdLandingVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.rcd != null) {
            this.rcd.mo9216d(str, str2, i, i2);
        }
        AppMethodBeat.m2505o(37402);
    }

    /* renamed from: cr */
    public final void mo9212cr(String str, String str2) {
        AppMethodBeat.m2504i(37403);
        C4990ab.m7411d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.mo67733cy(false);
        if (this.rcd != null) {
            this.rcd.mo9212cr(str, str2);
        }
        AppMethodBeat.m2505o(37403);
    }

    /* renamed from: cs */
    public final void mo9213cs(String str, String str2) {
        AppMethodBeat.m2504i(37404);
        C4990ab.m7411d("MicroMsg.AdLandingVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.mo67732a(this);
        if (this.rcd != null) {
            this.rcd.mo9213cs(str, str2);
        }
        AppMethodBeat.m2505o(37404);
    }

    /* renamed from: ct */
    public final void mo9214ct(String str, String str2) {
        AppMethodBeat.m2504i(37405);
        if (this.rcd != null) {
            this.rcd.mo9214ct(str, str2);
        }
        AppMethodBeat.m2505o(37405);
    }

    /* renamed from: cu */
    public final void mo9215cu(String str, String str2) {
        AppMethodBeat.m2504i(37406);
        if (this.rcd != null) {
            this.rcd.mo9215cu(str, str2);
        }
        AppMethodBeat.m2505o(37406);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(37407);
        C4990ab.m7411d("MicroMsg.AdLandingVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), C5046bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.m2505o(37407);
    }

    /* renamed from: gp */
    public final void mo26918gp(long j) {
        AppMethodBeat.m2504i(37408);
        C7060h.pYm.mo8378a(600, j, 1, false);
        AppMethodBeat.m2505o(37408);
    }

    /* renamed from: wB */
    public final void mo26927wB(String str) {
        AppMethodBeat.m2504i(37409);
        C7060h.pYm.mo8374X(14349, str);
        AppMethodBeat.m2505o(37409);
    }
}
