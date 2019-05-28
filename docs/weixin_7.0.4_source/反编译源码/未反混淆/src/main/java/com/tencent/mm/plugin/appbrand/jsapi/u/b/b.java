package com.tencent.mm.plugin.appbrand.jsapi.u.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements g {
    com.tencent.mm.plugin.appbrand.jsapi.c hcM;
    private ap ias;
    c idM;
    double idN;
    int idO;
    private String idP;

    static final class h extends ah {
        private static final int CTRL_INDEX = 540;
        private static final String NAME = "onXWebVideoWaiting";

        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    static final class b extends ah {
        private static final int CTRL_INDEX = 545;
        private static final String NAME = "onXWebVideoError";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class a extends ah {
        private static final int CTRL_INDEX = 543;
        private static final String NAME = "onXWebVideoEnded";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class c extends ah {
        private static final int CTRL_INDEX = 546;
        private static final String NAME = "onXWebVideoLoadedMetaData";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static final class e extends ah {
        private static final int CTRL_INDEX = 541;
        private static final String NAME = "onXWebVideoPlay";

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    static final class f extends ah {
        private static final int CTRL_INDEX = 547;
        private static final String NAME = "onXWebVideoProgress";

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    static final class g extends ah {
        private static final int CTRL_INDEX = 544;
        private static final String NAME = "onXWebVideoTimeUpdate";

        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    static final class d extends ah {
        private static final int CTRL_INDEX = 542;
        private static final String NAME = "onXWebVideoPause";

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    public b(c cVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar2) {
        this.hcM = cVar2;
        this.idM = cVar;
    }

    public final void onVideoPlay() {
        AppMethodBeat.i(117375);
        try {
            this.idO = 0;
            JSONObject aFV = aFV();
            aFV.put("timeStamp", System.currentTimeMillis());
            a(new e(), aFV);
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer");
            if (this.ias == null) {
                ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "start video update timer, create new timer");
                this.ias = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(117372);
                        if (b.this.idM != null) {
                            int currentPosition;
                            b bVar = b.this;
                            c cVar = b.this.idM;
                            if (cVar.idR != null) {
                                currentPosition = cVar.idR.getCurrentPosition();
                            } else {
                                currentPosition = 0;
                            }
                            int i = (int) (b.this.idN * 1000.0d);
                            try {
                                if (Math.abs(currentPosition - bVar.idO) >= 250) {
                                    bVar.idO = currentPosition;
                                    double d = (((double) i) * 1.0d) / 1000.0d;
                                    double doubleValue = new BigDecimal((((double) currentPosition) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue();
                                    JSONObject aFV = bVar.aFV();
                                    aFV.put("position", doubleValue);
                                    aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, d);
                                    bVar.a(new g(), aFV);
                                }
                            } catch (JSONException e) {
                                ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoTimeUpdate fail", e);
                            }
                        }
                        AppMethodBeat.o(117372);
                        return true;
                    }
                }, true);
            }
            this.ias.ae(250, 250);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(117373);
                    if (b.this.hcM != null) {
                        Activity activity = null;
                        if (b.this.hcM instanceof q) {
                            activity = ((q) b.this.hcM).ad(Activity.class);
                        } else if ((b.this.hcM instanceof u) && (b.this.hcM.getContext() instanceof Activity)) {
                            activity = (Activity) b.this.hcM.getContext();
                        }
                        if (activity != null) {
                            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "startKeepScreenOn");
                            activity.getWindow().addFlags(128);
                        }
                    }
                    AppMethodBeat.o(117373);
                }
            });
            AppMethodBeat.o(117375);
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPlay fail", e);
            AppMethodBeat.o(117375);
        }
    }

    public final void onVideoPause() {
        AppMethodBeat.i(117376);
        try {
            a(new d(), aFV());
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoPause fail", e);
        }
        aFW();
        aGF();
        AppMethodBeat.o(117376);
    }

    public final void aGE() {
        AppMethodBeat.i(117377);
        try {
            a(new a(), aFV());
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoEnded fail", e);
        }
        aFW();
        aGF();
        AppMethodBeat.o(117377);
    }

    public final void onVideoWaiting() {
        AppMethodBeat.i(117378);
        try {
            JSONObject aFV = aFV();
            aFV.put("timeStamp", System.currentTimeMillis());
            a(new h(), aFV);
            AppMethodBeat.o(117378);
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoWaiting fail", e);
            AppMethodBeat.o(117378);
        }
    }

    public final void oJ(int i) {
        AppMethodBeat.i(117379);
        try {
            JSONObject aFV = aFV();
            aFV.put("buffered", i);
            a(new f(), aFV);
            AppMethodBeat.o(117379);
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoProgress fail", e);
            AppMethodBeat.o(117379);
        }
    }

    public final void I(String str, int i, int i2) {
        AppMethodBeat.i(117380);
        aFW();
        aGF();
        try {
            JSONObject aFV = aFV();
            aFV.put("errMsg", String.format(Locale.US, "%s(%d,%d)", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}));
            a(new b(), aFV);
            AppMethodBeat.o(117380);
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "OnXWebVideoError fail", e);
            AppMethodBeat.o(117380);
        }
    }

    public final void L(int i, int i2, int i3) {
        AppMethodBeat.i(117381);
        try {
            JSONObject aFV = aFV();
            aFV.put("width", i);
            aFV.put("height", i2);
            this.idN = (((double) i3) * 1.0d) / 1000.0d;
            aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, this.idN);
            a(new c(), aFV);
            AppMethodBeat.o(117381);
        } catch (JSONException e) {
            ab.e("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "onXWebVideoLoadedMetaData fail", e);
            AppMethodBeat.o(117381);
        }
    }

    public final void Cd(String str) {
        this.idP = str;
    }

    public final void destroy() {
        AppMethodBeat.i(117382);
        aFW();
        AppMethodBeat.o(117382);
    }

    private void aFW() {
        AppMethodBeat.i(117383);
        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stop video update timer");
        if (this.ias != null) {
            this.ias.stopTimer();
        }
        AppMethodBeat.o(117383);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject aFV() {
        AppMethodBeat.i(117384);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.idP);
        AppMethodBeat.o(117384);
        return jSONObject;
    }

    /* Access modifiers changed, original: final */
    public final void a(ah ahVar, JSONObject jSONObject) {
        AppMethodBeat.i(117385);
        if (!((ahVar instanceof g) || (ahVar instanceof f))) {
            ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "dispatch event:%s, data:%s", ahVar.getName(), jSONObject.toString());
        }
        ah AM = ahVar.AM(jSONObject.toString());
        if (this.hcM != null) {
            q qVar;
            u currentPageView;
            if (this.hcM instanceof q) {
                qVar = (q) this.hcM;
                qVar.b(AM);
                currentPageView = qVar.getCurrentPageView();
                if (currentPageView != null) {
                    currentPageView.b(AM);
                }
                AppMethodBeat.o(117385);
                return;
            } else if (this.hcM instanceof u) {
                currentPageView = (u) this.hcM;
                currentPageView.b(AM);
                qVar = currentPageView.xT();
                if (qVar != null) {
                    qVar.b(AM);
                }
                AppMethodBeat.o(117385);
                return;
            } else {
                this.hcM.b(AM);
            }
        }
        AppMethodBeat.o(117385);
    }

    private void aGF() {
        AppMethodBeat.i(117386);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(117374);
                if (b.this.hcM != null) {
                    Activity activity = null;
                    if (b.this.hcM instanceof q) {
                        activity = ((q) b.this.hcM).ad(Activity.class);
                    } else if ((b.this.hcM instanceof u) && (b.this.hcM.getContext() instanceof Activity)) {
                        activity = (Activity) b.this.hcM.getContext();
                    }
                    if (activity != null) {
                        ab.i("MicroMsg.AppBrand.SameLayer.AppBrandVideoEventHandler", "stopKeepScreenOn");
                        activity.getWindow().clearFlags(128);
                    }
                }
                AppMethodBeat.o(117374);
            }
        });
        AppMethodBeat.o(117386);
    }
}
