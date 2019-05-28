package com.tencent.p177mm.plugin.appbrand.jsapi.video;

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
import com.tencent.p177mm.plugin.appbrand.jsapi.video.AppBrandVideoView.C19507b;
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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper */
public class AppBrandVideoWrapper extends RelativeLayout implements C42190a, C45630d, C23323a, C23324b, C23325c {
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

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper$1 */
    static class C271261 implements C19507b {
        C271261() {
        }

        /* renamed from: cM */
        public final AppBrandVideoView mo34685cM(Context context) {
            AppMethodBeat.m2504i(131585);
            View appBrandVideoWrapper = new AppBrandVideoWrapper(context);
            AppBrandVideoView appBrandVideoView = new AppBrandVideoView(context, appBrandVideoWrapper);
            C38399a appBrandVideoViewControlBar = new AppBrandVideoViewControlBar(context);
            appBrandVideoView.mo34618a(appBrandVideoViewControlBar);
            appBrandVideoWrapper.setVideoFooterView(appBrandVideoViewControlBar);
            AppMethodBeat.m2505o(131585);
            return appBrandVideoView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper$2 */
    class C383972 implements Runnable {
        C383972() {
        }

        public final void run() {
            AppMethodBeat.m2504i(131586);
            AppBrandVideoWrapper.m81321a(AppBrandVideoWrapper.this);
            AppMethodBeat.m2505o(131586);
        }
    }

    public static void aDc() {
        AppMethodBeat.m2504i(131587);
        AppBrandVideoView.setProxy(new C271261());
        AppMethodBeat.m2505o(131587);
    }

    public AppBrandVideoWrapper(Context context) {
        this(context, null);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(131588);
        this.iab = C27130g.CONTAIN;
        this.fdh = false;
        this.iac = -1.0f;
        this.hZs = 0;
        this.mContext = context;
        this.iaf = new C42192d();
        AppMethodBeat.m2505o(131588);
    }

    /* renamed from: c */
    public final void mo61580c(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        AppMethodBeat.m2504i(131589);
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
            if (m81322a(this.bkJ, this.url, "")) {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", Integer.valueOf(hashCode()));
                this.hZY = aFT();
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", Integer.valueOf(hashCode()));
                this.hZY = aFU();
            }
        } else if (m81322a(this.bkJ, this.url, "")) {
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
        C7305d.post(new C383972(), "AppBrandVideo_checkVideoUrl");
        AppMethodBeat.m2505o(131589);
    }

    public void setVideoSource(int i) {
        this.hZs = i;
    }

    private C44091h aFT() {
        AppMethodBeat.m2504i(131590);
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.mo27218KM(this.hZs);
        commonVideoView.setIMMVideoViewCallback(this);
        mo26918gp(200);
        AppMethodBeat.m2505o(131590);
        return commonVideoView;
    }

    private C44091h aFU() {
        AppMethodBeat.m2504i(131591);
        MMVideoView mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.setReporter(this);
        mMVideoView.setIMMVideoViewCallback(this);
        mMVideoView.setIOnlineVideoProxy(new AppBrandOnlineVideoProxy());
        mMVideoView.setIMMDownloadFinish(this);
        String str = C6457e.eSn + "appbrandvideo/";
        C15428j.aih(str);
        mMVideoView.setRootPath(str);
        mo26918gp(201);
        AppMethodBeat.m2505o(131591);
        return mMVideoView;
    }

    /* renamed from: a */
    private boolean m81322a(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(131592);
        if (z || this.iae) {
            AppMethodBeat.m2505o(131592);
            return true;
        } else if (C1443d.m3067fP(18)) {
            AppMethodBeat.m2505o(131592);
            return true;
        } else {
            C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", Integer.valueOf(C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("appbrand_video_player", -1)));
            if (C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("appbrand_video_player", -1) <= 0) {
                C4990ab.m7416i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
                AppMethodBeat.m2505o(131592);
                return true;
            } else if (!C5046bo.isNullOrNil(str) && str.contains(".m3u8")) {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
                mo26918gp(204);
                AppMethodBeat.m2505o(131592);
                return true;
            } else if (C26492r.m42231ud(str2)) {
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", Integer.valueOf(hashCode()));
                mo26918gp(204);
                AppMethodBeat.m2505o(131592);
                return true;
            } else {
                AppMethodBeat.m2505o(131592);
                return false;
            }
        }
    }

    public void setIMMVideoViewCallback(C42593b c42593b) {
        this.hZZ = c42593b;
    }

    public void setVideoFooterView(C30135g c30135g) {
        AppMethodBeat.m2504i(131593);
        this.iaa = c30135g;
        if (this.hZY != null) {
            this.hZY.setVideoFooterView(this.iaa);
        }
        AppMethodBeat.m2505o(131593);
    }

    public int getPlayerType() {
        AppMethodBeat.m2504i(131594);
        if (this.hZY != null) {
            int playerType = this.hZY.getPlayerType();
            AppMethodBeat.m2505o(131594);
            return playerType;
        }
        AppMethodBeat.m2505o(131594);
        return 0;
    }

    /* renamed from: s */
    public final boolean mo61590s(double d) {
        AppMethodBeat.m2504i(131595);
        if (this.hZY != null) {
            boolean s = this.hZY.mo26920s(d);
            AppMethodBeat.m2505o(131595);
            return s;
        }
        AppMethodBeat.m2505o(131595);
        return false;
    }

    /* renamed from: e */
    public final boolean mo61581e(double d, boolean z) {
        AppMethodBeat.m2504i(131596);
        if (this.hZY != null) {
            boolean e = this.hZY.mo26912e(d, z);
            AppMethodBeat.m2505o(131596);
            return e;
        }
        AppMethodBeat.m2505o(131596);
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(131597);
        if (this.hZY != null) {
            this.hZY.setIsShowBasicControls(z);
        }
        AppMethodBeat.m2505o(131597);
    }

    public void setFullDirection(int i) {
        AppMethodBeat.m2504i(131598);
        if (this.hZY != null) {
            this.hZY.setFullDirection(i);
        }
        AppMethodBeat.m2505o(131598);
    }

    public int getVideoDurationSec() {
        AppMethodBeat.m2504i(131599);
        int videoDurationSec;
        if (this.hZY != null) {
            videoDurationSec = this.hZY.getVideoDurationSec();
            AppMethodBeat.m2505o(131599);
            return videoDurationSec;
        }
        videoDurationSec = this.iad;
        AppMethodBeat.m2505o(131599);
        return videoDurationSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(131600);
        if (this.hZY != null) {
            int currPosMs = this.hZY.getCurrPosMs();
            AppMethodBeat.m2505o(131600);
            return currPosMs;
        }
        AppMethodBeat.m2505o(131600);
        return 0;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(131601);
        if (this.hZY != null) {
            int currPosSec = this.hZY.getCurrPosSec();
            AppMethodBeat.m2505o(131601);
            return currPosSec;
        }
        AppMethodBeat.m2505o(131601);
        return 0;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(131602);
        if (this.hZY != null) {
            int cacheTimeSec = this.hZY.getCacheTimeSec();
            AppMethodBeat.m2505o(131602);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(131602);
        return 0;
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(131603);
        if (this.hZY != null) {
            boolean isPlaying = this.hZY.isPlaying();
            AppMethodBeat.m2505o(131603);
            return isPlaying;
        }
        AppMethodBeat.m2505o(131603);
        return false;
    }

    public final boolean isLive() {
        AppMethodBeat.m2504i(131604);
        if (this.hZY != null) {
            boolean isLive = this.hZY.isLive();
            AppMethodBeat.m2505o(131604);
            return isLive;
        }
        AppMethodBeat.m2505o(131604);
        return false;
    }

    public void setCover(Bitmap bitmap) {
        AppMethodBeat.m2504i(131605);
        if (this.hZY != null) {
            this.hZY.setCover(bitmap);
        }
        AppMethodBeat.m2505o(131605);
    }

    public final void start() {
        AppMethodBeat.m2504i(131606);
        if (this.hZY != null) {
            this.hZY.start();
            setKeepScreenOn(true);
            this.iaf.mo67732a(this);
        }
        AppMethodBeat.m2505o(131606);
    }

    public final void stop() {
        AppMethodBeat.m2504i(131607);
        if (this.hZY != null) {
            this.hZY.stop();
            this.iaf.mo67733cy(false);
            setKeepScreenOn(false);
        }
        AppMethodBeat.m2505o(131607);
    }

    public final boolean pause() {
        AppMethodBeat.m2504i(131608);
        if (this.hZY != null) {
            setKeepScreenOn(false);
            this.iaf.mo67733cy(false);
            boolean pause = this.hZY.pause();
            AppMethodBeat.m2505o(131608);
            return pause;
        }
        AppMethodBeat.m2505o(131608);
        return false;
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(131609);
        this.fdh = z;
        if (this.hZY != null) {
            this.hZY.setMute(this.fdh);
        }
        AppMethodBeat.m2505o(131609);
    }

    public final void akW() {
        AppMethodBeat.m2504i(131610);
        if (this.hZY != null) {
            this.hZY.akW();
        }
        AppMethodBeat.m2505o(131610);
    }

    public final void akV() {
        AppMethodBeat.m2504i(131611);
        if (this.hZY != null) {
            this.hZY.akV();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(131611);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(131612);
        if (this.hZY != null) {
            this.hZY.aEX();
        }
        this.iaf.mo67733cy(false);
        setKeepScreenOn(false);
        AppMethodBeat.m2505o(131612);
    }

    public void setScaleType(C27130g c27130g) {
        AppMethodBeat.m2504i(131613);
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
        AppMethodBeat.m2505o(131613);
    }

    /* renamed from: as */
    public final boolean mo61579as(float f) {
        AppMethodBeat.m2504i(131614);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(131614);
            return false;
        }
        this.iac = f;
        if (this.hZY != null) {
            boolean as = this.hZY.mo26910as(this.iac);
            AppMethodBeat.m2505o(131614);
            return as;
        }
        AppMethodBeat.m2505o(131614);
        return false;
    }

    public void setControlBar(C38399a c38399a) {
    }

    /* renamed from: am */
    public final void mo39053am(String str, boolean z) {
        AppMethodBeat.m2504i(131615);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", Integer.valueOf(hashCode()), str, Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.m2505o(131615);
            return;
        }
        int i;
        if (m81322a(false, "", str)) {
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
        AppMethodBeat.m2505o(131615);
    }

    /* renamed from: c */
    public final void mo9209c(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(131616);
        C4990ab.m7421w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hZZ != null) {
            this.hZZ.mo34677H(str3, i, i2);
        }
        AppMethodBeat.m2505o(131616);
    }

    /* renamed from: cp */
    public final void mo9210cp(String str, String str2) {
        AppMethodBeat.m2504i(131617);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", Integer.valueOf(hashCode()));
        if (this.hZZ != null) {
            this.hZZ.aFq();
        }
        if (isLive()) {
            mo26918gp(203);
            AppMethodBeat.m2505o(131617);
            return;
        }
        mo26918gp(202);
        AppMethodBeat.m2505o(131617);
    }

    /* renamed from: cq */
    public final void mo9211cq(String str, String str2) {
        AppMethodBeat.m2504i(131618);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", Integer.valueOf(hashCode()));
        if (this.hZZ != null) {
            this.hZZ.aFr();
        }
        AppMethodBeat.m2505o(131618);
    }

    /* renamed from: d */
    public final void mo9216d(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(131619);
        C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hZZ != null) {
            this.hZZ.mo34684de(i, i2);
        }
        AppMethodBeat.m2505o(131619);
    }

    /* renamed from: cr */
    public final void mo9212cr(String str, String str2) {
        AppMethodBeat.m2504i(131620);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", Integer.valueOf(hashCode()));
        setKeepScreenOn(false);
        this.iaf.mo67733cy(false);
        if (this.hZZ != null) {
            this.hZZ.aFs();
        }
        AppMethodBeat.m2505o(131620);
    }

    /* renamed from: cs */
    public final void mo9213cs(String str, String str2) {
        AppMethodBeat.m2504i(131621);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", Integer.valueOf(hashCode()));
        setKeepScreenOn(true);
        this.iaf.mo67732a(this);
        if (this.hZZ != null) {
            this.hZZ.aFt();
        }
        AppMethodBeat.m2505o(131621);
    }

    /* renamed from: ct */
    public final void mo9214ct(String str, String str2) {
        AppMethodBeat.m2504i(131622);
        if (this.hZZ != null) {
            this.hZZ.aFu();
        }
        AppMethodBeat.m2505o(131622);
    }

    /* renamed from: cu */
    public final void mo9215cu(String str, String str2) {
        AppMethodBeat.m2504i(131623);
        if (this.hZZ != null) {
            this.hZZ.aFv();
        }
        AppMethodBeat.m2505o(131623);
    }

    public void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(131624);
        C4990ab.m7411d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", Boolean.valueOf(z), C5046bo.dpG());
        super.setKeepScreenOn(z);
        AppMethodBeat.m2505o(131624);
    }

    /* renamed from: gp */
    public final void mo26918gp(long j) {
        AppMethodBeat.m2504i(131625);
        C7060h.pYm.mo8378a(600, j, 1, false);
        AppMethodBeat.m2505o(131625);
    }

    /* renamed from: wB */
    public final void mo26927wB(String str) {
        AppMethodBeat.m2504i(131626);
        C7060h.pYm.mo8374X(14349, str);
        AppMethodBeat.m2505o(131626);
    }

    /* renamed from: a */
    static /* synthetic */ void m81321a(AppBrandVideoWrapper appBrandVideoWrapper) {
        AppMethodBeat.m2504i(131627);
        if (!C5046bo.isNullOrNil(appBrandVideoWrapper.url) && appBrandVideoWrapper.url.startsWith("http")) {
            try {
                C1936u a = C1897b.m4020a(appBrandVideoWrapper.url, null);
                a.connect();
                int responseCode = a.getResponseCode();
                C4990ab.m7417i("MicroMsg.AppBrandVideoWrapper", "check video url http ret code: %s", Integer.valueOf(responseCode));
                if (responseCode >= 400 && appBrandVideoWrapper.hZZ != null) {
                    appBrandVideoWrapper.hZZ.mo34677H("http error", -1, responseCode);
                }
                a.connection.disconnect();
                AppMethodBeat.m2505o(131627);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandVideoWrapper", e, "check video url error: %s", e.getMessage());
                if (null != null) {
                    null.connection.disconnect();
                    AppMethodBeat.m2505o(131627);
                    return;
                }
            } catch (Throwable th) {
                if (null != null) {
                    null.connection.disconnect();
                }
                AppMethodBeat.m2505o(131627);
            }
        }
        AppMethodBeat.m2505o(131627);
    }
}
