package com.tencent.p177mm.plugin.appbrand.jsapi.p317u.p320b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b */
public final class C10533b implements C42588g {
    C2241c hcM;
    private C7564ap ias;
    C27116c idM;
    double idN;
    int idO;
    private String idP;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$h */
    static final class C2349h extends C42467ah {
        private static final int CTRL_INDEX = 540;
        private static final String NAME = "onXWebVideoWaiting";

        private C2349h() {
        }

        /* synthetic */ C2349h(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$b */
    static final class C10534b extends C42467ah {
        private static final int CTRL_INDEX = 545;
        private static final String NAME = "onXWebVideoError";

        private C10534b() {
        }

        /* synthetic */ C10534b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$a */
    static final class C10535a extends C42467ah {
        private static final int CTRL_INDEX = 543;
        private static final String NAME = "onXWebVideoEnded";

        private C10535a() {
        }

        /* synthetic */ C10535a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$c */
    static final class C10536c extends C42467ah {
        private static final int CTRL_INDEX = 546;
        private static final String NAME = "onXWebVideoLoadedMetaData";

        private C10536c() {
        }

        /* synthetic */ C10536c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$e */
    static final class C10537e extends C42467ah {
        private static final int CTRL_INDEX = 541;
        private static final String NAME = "onXWebVideoPlay";

        private C10537e() {
        }

        /* synthetic */ C10537e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$f */
    static final class C10538f extends C42467ah {
        private static final int CTRL_INDEX = 547;
        private static final String NAME = "onXWebVideoProgress";

        private C10538f() {
        }

        /* synthetic */ C10538f(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$g */
    static final class C10539g extends C42467ah {
        private static final int CTRL_INDEX = 544;
        private static final String NAME = "onXWebVideoTimeUpdate";

        private C10539g() {
        }

        /* synthetic */ C10539g(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$2 */
    class C105402 implements Runnable {
        C105402() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117373);
            if (C10533b.this.hcM != null) {
                Activity activity = null;
                if (C10533b.this.hcM instanceof C38492q) {
                    activity = ((C38492q) C10533b.this.hcM).mo61197ad(Activity.class);
                } else if ((C10533b.this.hcM instanceof C44709u) && (C10533b.this.hcM.getContext() instanceof Activity)) {
                    activity = (Activity) C10533b.this.hcM.getContext();
                }
                if (activity != null) {
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
                    activity.getWindow().addFlags(128);
                }
            }
            AppMethodBeat.m2505o(117373);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$d */
    static final class C10541d extends C42467ah {
        private static final int CTRL_INDEX = 542;
        private static final String NAME = "onXWebVideoPause";

        private C10541d() {
        }

        /* synthetic */ C10541d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$1 */
    class C105421 implements C5015a {
        C105421() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(117372);
            if (C10533b.this.idM != null) {
                int currentPosition;
                C10533b c10533b = C10533b.this;
                C27116c c27116c = C10533b.this.idM;
                if (c27116c.idR != null) {
                    currentPosition = c27116c.idR.getCurrentPosition();
                } else {
                    currentPosition = 0;
                }
                int i = (int) (C10533b.this.idN * 1000.0d);
                try {
                    if (Math.abs(currentPosition - c10533b.idO) >= 250) {
                        c10533b.idO = currentPosition;
                        double d = (((double) i) * 1.0d) / 1000.0d;
                        double doubleValue = new BigDecimal((((double) currentPosition) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue();
                        JSONObject aFV = c10533b.aFV();
                        aFV.put("position", doubleValue);
                        aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, d);
                        c10533b.mo22025a(new C10539g(), aFV);
                    }
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", e);
                }
            }
            AppMethodBeat.m2505o(117372);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.u.b.b$3 */
    class C105433 implements Runnable {
        C105433() {
        }

        public final void run() {
            AppMethodBeat.m2504i(117374);
            if (C10533b.this.hcM != null) {
                Activity activity = null;
                if (C10533b.this.hcM instanceof C38492q) {
                    activity = ((C38492q) C10533b.this.hcM).mo61197ad(Activity.class);
                } else if ((C10533b.this.hcM instanceof C44709u) && (C10533b.this.hcM.getContext() instanceof Activity)) {
                    activity = (Activity) C10533b.this.hcM.getContext();
                }
                if (activity != null) {
                    C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
                    activity.getWindow().clearFlags(128);
                }
            }
            AppMethodBeat.m2505o(117374);
        }
    }

    public C10533b(C27116c c27116c, C2241c c2241c) {
        this.hcM = c2241c;
        this.idM = c27116c;
    }

    public final void onVideoPlay() {
        AppMethodBeat.m2504i(117375);
        try {
            this.idO = 0;
            JSONObject aFV = aFV();
            aFV.put("timeStamp", System.currentTimeMillis());
            mo22025a(new C10537e(), aFV);
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer");
            if (this.ias == null) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
                this.ias = new C7564ap(new C105421(), true);
            }
            this.ias.mo16770ae(250, 250);
            C5004al.m7441d(new C105402());
            AppMethodBeat.m2505o(117375);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", e);
            AppMethodBeat.m2505o(117375);
        }
    }

    public final void onVideoPause() {
        AppMethodBeat.m2504i(117376);
        try {
            mo22025a(new C10541d(), aFV());
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", e);
        }
        aFW();
        aGF();
        AppMethodBeat.m2505o(117376);
    }

    public final void aGE() {
        AppMethodBeat.m2504i(117377);
        try {
            mo22025a(new C10535a(), aFV());
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", e);
        }
        aFW();
        aGF();
        AppMethodBeat.m2505o(117377);
    }

    public final void onVideoWaiting() {
        AppMethodBeat.m2504i(117378);
        try {
            JSONObject aFV = aFV();
            aFV.put("timeStamp", System.currentTimeMillis());
            mo22025a(new C2349h(), aFV);
            AppMethodBeat.m2505o(117378);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", e);
            AppMethodBeat.m2505o(117378);
        }
    }

    /* renamed from: oJ */
    public final void mo22029oJ(int i) {
        AppMethodBeat.m2504i(117379);
        try {
            JSONObject aFV = aFV();
            aFV.put("buffered", i);
            mo22025a(new C10538f(), aFV);
            AppMethodBeat.m2505o(117379);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", e);
            AppMethodBeat.m2505o(117379);
        }
    }

    /* renamed from: I */
    public final void mo22023I(String str, int i, int i2) {
        AppMethodBeat.m2504i(117380);
        aFW();
        aGF();
        try {
            JSONObject aFV = aFV();
            aFV.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}));
            mo22025a(new C10534b(), aFV);
            AppMethodBeat.m2505o(117380);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", e);
            AppMethodBeat.m2505o(117380);
        }
    }

    /* renamed from: L */
    public final void mo22024L(int i, int i2, int i3) {
        AppMethodBeat.m2504i(117381);
        try {
            JSONObject aFV = aFV();
            aFV.put("width", i);
            aFV.put("height", i2);
            this.idN = (((double) i3) * 1.0d) / 1000.0d;
            aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, this.idN);
            mo22025a(new C10536c(), aFV);
            AppMethodBeat.m2505o(117381);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", e);
            AppMethodBeat.m2505o(117381);
        }
    }

    /* renamed from: Cd */
    public final void mo22022Cd(String str) {
        this.idP = str;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(117382);
        aFW();
        AppMethodBeat.m2505o(117382);
    }

    private void aFW() {
        AppMethodBeat.m2504i(117383);
        C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
        if (this.ias != null) {
            this.ias.stopTimer();
        }
        AppMethodBeat.m2505o(117383);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject aFV() {
        AppMethodBeat.m2504i(117384);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.idP);
        AppMethodBeat.m2505o(117384);
        return jSONObject;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo22025a(C42467ah c42467ah, JSONObject jSONObject) {
        AppMethodBeat.m2504i(117385);
        if (!((c42467ah instanceof C10539g) || (c42467ah instanceof C10538f))) {
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", c42467ah.getName(), jSONObject.toString());
        }
        C42467ah AM = c42467ah.mo61028AM(jSONObject.toString());
        if (this.hcM != null) {
            C38492q c38492q;
            C44709u currentPageView;
            if (this.hcM instanceof C38492q) {
                c38492q = (C38492q) this.hcM;
                c38492q.mo6115b(AM);
                currentPageView = c38492q.getCurrentPageView();
                if (currentPageView != null) {
                    currentPageView.mo6115b(AM);
                }
                AppMethodBeat.m2505o(117385);
                return;
            } else if (this.hcM instanceof C44709u) {
                currentPageView = (C44709u) this.hcM;
                currentPageView.mo6115b(AM);
                c38492q = currentPageView.mo44926xT();
                if (c38492q != null) {
                    c38492q.mo6115b(AM);
                }
                AppMethodBeat.m2505o(117385);
                return;
            } else {
                this.hcM.mo6115b(AM);
            }
        }
        AppMethodBeat.m2505o(117385);
    }

    private void aGF() {
        AppMethodBeat.m2504i(117386);
        C5004al.m7441d(new C105433());
        AppMethodBeat.m2505o(117386);
    }
}
