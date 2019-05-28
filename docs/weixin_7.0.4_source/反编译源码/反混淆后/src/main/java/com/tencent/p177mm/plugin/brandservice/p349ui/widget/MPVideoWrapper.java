package com.tencent.p177mm.plugin.brandservice.p349ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C42192d;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.modelvideo.C26492r;
import com.tencent.p177mm.modelvideo.MMVideoView;
import com.tencent.p177mm.network.C1897b;
import com.tencent.p177mm.network.C1936u;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C27130g;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C38399a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C42593b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C30135g;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23323a;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23324b;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C23325c;
import com.tencent.p177mm.pluginsdk.p597ui.C44091h.C35873d;
import com.tencent.p177mm.pluginsdk.p597ui.CommonVideoView;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C15428j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoWrapper */
public class MPVideoWrapper extends RelativeLayout implements C42190a, C45630d, C23323a, C23324b, C23325c {
    private boolean bkJ;
    private boolean fdh;
    private C44091h hZY;
    private C42593b hZZ;
    protected int hZs;
    private C30135g iaa;
    private C27130g iab;
    private float iac;
    private int iad;
    private boolean iae;
    private C42192d iaf;
    private Context mContext;
    private String url;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoWrapper$1 */
    class C387251 implements Runnable {
        C387251() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14631);
            MPVideoWrapper.m65676a(MPVideoWrapper.this);
            AppMethodBeat.m2505o(14631);
        }
    }

    public MPVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MPVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(14632);
        this.iab = C27130g.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.hZs = 0;
        this.mContext = context;
        this.iaf = new C42192d();
        AppMethodBeat.m2505o(14632);
    }

    /* renamed from: c */
    public final void mo61580c(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.m2504i(14633);
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
            if (m65677a(this.bkJ, this.url, "")) {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
            }
        } else if (m65677a(this.bkJ, this.url, "")) {
            if (this.hZY instanceof MMVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", Integer.valueOf(hashCode()));
                this.hZY.stop();
                i2 = 0;
            }
        } else if (this.hZY instanceof CommonVideoView) {
            this.hZY.stop();
            this.hZY.cpU();
            removeView((View) this.hZY);
            C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
            this.hZY = aFU();
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", Integer.valueOf(hashCode()));
            this.hZY.stop();
            i2 = 0;
        }
        setScaleType(this.iab);
        mo61579as(this.iac);
        setMute(this.fdh);
        if (i2 != 0) {
            setVideoFooterView(this.iaa);
            addView((View) this.hZY, new LayoutParams(-1, -1));
        }
        this.hZY.mo9063c(this.bkJ, this.url, this.iad);
        C7305d.post(new C387251(), "AppBrandVideo_checkVideoUrl");
        AppMethodBeat.m2505o(14633);
    }

    public void setVideoSource(int i) {
        this.hZs = i;
    }

    private C44091h aFT() {
        AppMethodBeat.m2504i(14634);
        MPCommonVideoView mPCommonVideoView = new MPCommonVideoView(this.mContext);
        mPCommonVideoView.setReporter(this);
        mPCommonVideoView.mo27218KM(this.hZs);
        mPCommonVideoView.setIMMVideoViewCallback(this);
        mo26918gp(200);
        AppMethodBeat.m2505o(14634);
        return mPCommonVideoView;
    }

    private C44091h aFU() {
        AppMethodBeat.m2504i(14635);
        MMVideoView mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.setReporter(this);
        mMVideoView.setIMMVideoViewCallback(this);
        mMVideoView.setIMMDownloadFinish(this);
        String str = C6457e.eSn + "appbrandvideo/";
        C15428j.aih(str);
        mMVideoView.setRootPath(str);
        mo26918gp(201);
        AppMethodBeat.m2505o(14635);
        return mMVideoView;
    }

    /* renamed from: a */
    private boolean m65677a(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(14636);
        if (z || this.iae) {
            AppMethodBeat.m2505o(14636);
            return true;
        } else if (C1443d.m3067fP(18)) {
            AppMethodBeat.m2505o(14636);
            return true;
        } else {
            C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", Integer.valueOf(C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("appbrand_video_player", -1)));
            if (C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("appbrand_video_player", -1) <= 0) {
                C4990ab.m7416i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
                AppMethodBeat.m2505o(14636);
                return true;
            } else if (!C5046bo.isNullOrNil(str) && str.contains(".m3u8")) {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
                mo26918gp(204);
                AppMethodBeat.m2505o(14636);
                return true;
            } else if (C26492r.m42231ud(str2)) {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
                mo26918gp(204);
                AppMethodBeat.m2505o(14636);
                return true;
            } else {
                AppMethodBeat.m2505o(14636);
                return false;
            }
        }
    }

    public void setIMMVideoViewCallback(C42593b c42593b) {
        this.hZZ = c42593b;
    }

    public void setVideoFooterView(C30135g c30135g) {
        AppMethodBeat.m2504i(14637);
        this.iaa = c30135g;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.m2505o(14637);
    }

    public int getPlayerType() {
        AppMethodBeat.m2504i(14638);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.m2505o(14638);
            return playerType;
        }
        AppMethodBeat.m2505o(14638);
        return 0;
    }

    /* renamed from: s */
    public final boolean mo61590s(double d) {
        AppMethodBeat.m2504i(14639);
        if (this.hZY != null) {
            boolean s = this.hZY.mo26920s(d);
            AppMethodBeat.m2505o(14639);
            return s;
        }
        AppMethodBeat.m2505o(14639);
        return false;
    }

    /* renamed from: e */
    public final boolean mo61581e(double d, boolean z) {
        AppMethodBeat.m2504i(14640);
        if (this.hZY != null) {
            boolean e = this.hZY.mo26912e(d, z);
            AppMethodBeat.m2505o(14640);
            return e;
        }
        AppMethodBeat.m2505o(14640);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(14641);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.m2505o(14641);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.m2504i(14642);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.m2505o(14642);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.m2504i(14643);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.m2505o(14643);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.m2505o(14643);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(14644);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.m2505o(14644);
            return currPosMs;
        }
        AppMethodBeat.m2505o(14644);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(14645);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.m2505o(14645);
            return currPosSec;
        }
        AppMethodBeat.m2505o(14645);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(14646);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.m2505o(14646);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(14646);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(14647);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.m2505o(14647);
            return isPlaying;
        }
        AppMethodBeat.m2505o(14647);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.m2504i(14648);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.m2505o(14648);
            return isLive;
        }
        AppMethodBeat.m2505o(14648);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.m2504i(14649);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.m2505o(14649);
    }

    public final void start() {
        AppMethodBeat.m2504i(14650);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.mo67732a(this);
        }
        AppMethodBeat.m2505o(14650);
    }

    public final void stop() {
        AppMethodBeat.m2504i(14651);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.mo67733cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.m2505o(14651);
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(14652);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.mo67733cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.m2505o(14652);
            return pause;
        }
        AppMethodBeat.m2505o(14652);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(14653);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.m2505o(14653);
    }

    public final void akW() {
        AppMethodBeat.m2504i(14654);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.m2505o(14654);
    }

    public final void akV() {
        AppMethodBeat.m2504i(14655);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(14655);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(14656);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(14656);
    }

    public void setScaleType(C27130g c27130g) {
        AppMethodBeat.m2504i(14657);
        this.iab = c27130g;
        if (this.hZY != null) {
            C35873d c35873d;
            C44091h c44091h = this.hZY;
            C27130g c27130g2 = this.iab;
            if (c27130g2 != null) {
                String name = c27130g2.name();
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
                        c35873d = C35873d.CONTAIN;
                        break;
                    case 1:
                        c35873d = C35873d.COVER;
                        break;
                    case 2:
                        c35873d = C35873d.FILL;
                        break;
                }
            }
            c35873d = C35873d.DEFAULT;
            c44091h.setScaleType(c35873d);
        }
        AppMethodBeat.m2505o(14657);
    }

    /* renamed from: as */
    public final boolean mo61579as(float f) {
        AppMethodBeat.m2504i(14658);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(14658);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.mo26910as(this.iac);
            AppMethodBeat.m2505o(14658);
            return as;
        }
        AppMethodBeat.m2505o(14658);
        return false;
    }

    public void setControlBar(C38399a c38399a) {
    }

    /* renamed from: am */
    public final void mo39053am(String str, boolean z) {
        AppMethodBeat.m2504i(14659);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.m2505o(14659);
            return;
        }
        int i;
        if (m65677a(false, "", str)) {
            if (this.hZY instanceof MMVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
                i = 1;
            }
            i = 0;
        } else {
            if (this.hZY instanceof CommonVideoView) {
                this.hZY.stop();
                this.hZY.cpU();
                removeView((View) this.hZY);
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
                i = 1;
            }
            i = 0;
        }
        setScaleType(this.iab);
        mo61579as(this.iac);
        setMute(this.fdh);
        if (i != 0) {
            setVideoFooterView(this.iaa);
            addView((View) this.hZY, new LayoutParams(-1, -1));
            this.hZY.mo9063c(this.bkJ, this.url, this.iad);
            this.hZY.start();
        }
        AppMethodBeat.m2505o(14659);
    }

    /* renamed from: c */
    public final void mo9209c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(14660);
        C4990ab.m7421w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hZZ != null) {
            this.hZZ.mo34677H(str3, i, i2);
        }
        AppMethodBeat.m2505o(14660);
    }

    /* renamed from: cp */
    public final void mo9210cp(String str, String str2) {
        AppMethodBeat.m2504i(14661);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.hZZ != null) {
            this.hZZ.aFq();
        }
        if (isLive()) {
            mo26918gp(203);
            AppMethodBeat.m2505o(14661);
            return;
        }
        mo26918gp(202);
        AppMethodBeat.m2505o(14661);
    }

    /* renamed from: cq */
    public final void mo9211cq(String str, String str2) {
        AppMethodBeat.m2504i(14662);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.hZZ != null) {
            this.hZZ.aFr();
        }
        AppMethodBeat.m2505o(14662);
    }

    /* renamed from: d */
    public final void mo9216d(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(14663);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hZZ != null) {
            this.hZZ.mo34684de(i, i2);
        }
        AppMethodBeat.m2505o(14663);
    }

    /* renamed from: cr */
    public final void mo9212cr(String str, String str2) {
        AppMethodBeat.m2504i(14664);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.mo67733cy(false);
        if (this.hZZ != null) {
            this.hZZ.aFs();
        }
        AppMethodBeat.m2505o(14664);
    }

    /* renamed from: cs */
    public final void mo9213cs(String str, String str2) {
        AppMethodBeat.m2504i(14665);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.mo67732a(this);
        if (this.hZZ != null) {
            this.hZZ.aFt();
        }
        AppMethodBeat.m2505o(14665);
    }

    /* renamed from: ct */
    public final void mo9214ct(String str, String str2) {
        AppMethodBeat.m2504i(14666);
        if (this.hZZ != null) {
            this.hZZ.aFu();
        }
        AppMethodBeat.m2505o(14666);
    }

    /* renamed from: cu */
    public final void mo9215cu(String str, String str2) {
        AppMethodBeat.m2504i(14667);
        if (this.hZZ != null) {
            this.hZZ.aFv();
        }
        AppMethodBeat.m2505o(14667);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(14668);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), C5046bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.m2505o(14668);
    }

    /* renamed from: gp */
    public final void mo26918gp(long j) {
        AppMethodBeat.m2504i(14669);
        C7060h.pYm.mo8378a(600, j, 1, false);
        AppMethodBeat.m2505o(14669);
    }

    /* renamed from: wB */
    public final void mo26927wB(String str) {
        AppMethodBeat.m2504i(14670);
        C7060h.pYm.mo8374X(14349, str);
        AppMethodBeat.m2505o(14670);
    }

    /* renamed from: a */
    static /* synthetic */ void m65676a(MPVideoWrapper mPVideoWrapper) {
        AppMethodBeat.m2504i(14671);
        if (!C5046bo.isNullOrNil(mPVideoWrapper.url) && mPVideoWrapper.url.startsWith("http")) {
            try {
                C1936u a = C1897b.m4020a(mPVideoWrapper.url, null);
                a.connect();
                int responseCode = a.getResponseCode();
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "check video url http ret code: %s", Integer.valueOf(responseCode));
                if (responseCode >= 400 && mPVideoWrapper.hZZ != null) {
                    mPVideoWrapper.hZZ.mo34677H("http error", -1, responseCode);
                }
                a.connection.disconnect();
                AppMethodBeat.m2505o(14671);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandVideoWrapper", e, "check video url error: %s", e.getMessage());
                if (null != null) {
                    null.connection.disconnect();
                    AppMethodBeat.m2505o(14671);
                    return;
                }
            } catch (Throwable th) {
                if (null != null) {
                    null.connection.disconnect();
                }
                AppMethodBeat.m2505o(14671);
            }
        }
        AppMethodBeat.m2505o(14671);
    }
}
