package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k */
public final class C33404k implements C10380c {
    C7564ap hZL;
    AppBrandVideoView iaq;
    private C33303e iar;
    C7564ap ias;
    int iat;
    int iau = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$h */
    static final class C10560h extends C42467ah {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        private C10560h() {
        }

        /* synthetic */ C10560h(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$a */
    static final class C19519a extends C42467ah {
        private static final int CTRL_INDEX = 480;
        private static final String NAME = "onVideoCanPlay";

        private C19519a() {
        }

        /* synthetic */ C19519a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$j */
    static final class C19520j extends C42467ah {
        private static final int CTRL_INDEX = 485;
        private static final String NAME = "onVideoResourceError";

        C19520j() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$b */
    static final class C27131b extends C42467ah {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        private C27131b() {
        }

        /* synthetic */ C27131b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$i */
    static final class C27132i extends C42467ah {
        private static final int CTRL_INDEX = 548;
        private static final String NAME = "onVideoProgress";

        private C27132i() {
        }

        /* synthetic */ C27132i(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$k */
    static final class C27133k extends C42467ah {
        private static final int CTRL_INDEX = 484;
        private static final String NAME = "onVideoResourceLoad";

        C27133k() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$m */
    static final class C33403m extends C42467ah {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        private C33403m() {
        }

        /* synthetic */ C33403m(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$1 */
    class C334051 implements C5015a {
        C334051() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(126570);
            try {
                int currPosMs = C33404k.this.iaq.getCurrPosMs();
                if (Math.abs(currPosMs - C33404k.this.iat) < 250) {
                    AppMethodBeat.m2505o(126570);
                    return true;
                }
                JSONObject aFV = C33404k.this.aFV();
                C33404k.this.iat = currPosMs;
                aFV.put("position", new BigDecimal((((double) currPosMs) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue());
                aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, C33404k.this.iaq.getDuration());
                C33404k.this.mo53894a(new C33407l(), aFV);
                AppMethodBeat.m2505o(126570);
                return true;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$c */
    static final class C33406c extends C42467ah {
        private static final int CTRL_INDEX = 129;
        private static final String NAME = "onVideoEnded";

        private C33406c() {
        }

        /* synthetic */ C33406c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$l */
    static final class C33407l extends C42467ah {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoTimeUpdate";

        private C33407l() {
        }

        /* synthetic */ C33407l(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$d */
    static final class C33408d extends C42467ah {
        private static final int CTRL_INDEX = 349;
        private static final String NAME = "onVideoError";

        private C33408d() {
        }

        /* synthetic */ C33408d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$e */
    static final class C33409e extends C42467ah {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        private C33409e() {
        }

        /* synthetic */ C33409e(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$f */
    static final class C33410f extends C42467ah {
        private static final int CTRL_INDEX = 628;
        private static final String NAME = "onVideoLoadedMetaData";

        private C33410f() {
        }

        /* synthetic */ C33410f(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$2 */
    class C334112 implements C5015a {
        C334112() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(126571);
            if (C33404k.this.iaq != null) {
                int cacheTimeSec = C33404k.this.iaq.getCacheTimeSec();
                int duration = C33404k.this.iaq.getDuration();
                if (duration != 0) {
                    cacheTimeSec = (int) ((((float) cacheTimeSec) * 100.0f) / ((float) duration));
                    if (cacheTimeSec != C33404k.this.iau) {
                        C33404k.this.iau = cacheTimeSec;
                        C33404k c33404k = C33404k.this;
                        try {
                            C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d", Integer.valueOf(cacheTimeSec));
                            JSONObject aFV = c33404k.aFV();
                            aFV.put("buffered", cacheTimeSec);
                            c33404k.mo53894a(new C27132i(), aFV);
                        } catch (JSONException e) {
                            C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate e=%s", e);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(126571);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.k$g */
    static final class C33412g extends C42467ah {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        private C33412g() {
        }

        /* synthetic */ C33412g(byte b) {
            this();
        }
    }

    public C33404k(AppBrandVideoView appBrandVideoView, C33303e c33303e) {
        AppMethodBeat.m2504i(126572);
        this.iaq = appBrandVideoView;
        this.iar = c33303e;
        this.iar.mo53828a((C10380c) this);
        AppMethodBeat.m2505o(126572);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(126573);
        C4990ab.m7410d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.iaq.setCallback(null);
        AppMethodBeat.m2505o(126573);
    }

    public final void clean() {
        AppMethodBeat.m2504i(126574);
        this.iar.mo53833b((C10380c) this);
        aFW();
        aFX();
        AppMethodBeat.m2505o(126574);
    }

    /* renamed from: c */
    public final void mo53898c(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(126575);
        try {
            C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
            JSONObject aFV = aFV();
            aFV.put("fullScreen", z);
            aFV.put("videoPlayerId", i);
            aFV.put(TencentLocation.EXTRA_DIRECTION, i2);
            mo53894a(new C33409e(), aFV);
            AppMethodBeat.m2505o(126575);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e);
            AppMethodBeat.m2505o(126575);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo53894a(C42467ah c42467ah, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126576);
        if (!((c42467ah instanceof C33407l) || (c42467ah instanceof C27132i))) {
            C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", c42467ah.getName());
        }
        this.iar.mo6115b(c42467ah.mo61028AM(jSONObject.toString()));
        AppMethodBeat.m2505o(126576);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject aFV() {
        AppMethodBeat.m2504i(126577);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.iaq.getCookieData());
        AppMethodBeat.m2505o(126577);
        return jSONObject;
    }

    /* Access modifiers changed, original: final */
    public final void aFW() {
        AppMethodBeat.m2504i(126578);
        if (this.ias != null) {
            this.ias.stopTimer();
        }
        AppMethodBeat.m2505o(126578);
    }

    /* Access modifiers changed, original: final */
    public final void aFX() {
        AppMethodBeat.m2504i(126579);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        AppMethodBeat.m2505o(126579);
    }
}
