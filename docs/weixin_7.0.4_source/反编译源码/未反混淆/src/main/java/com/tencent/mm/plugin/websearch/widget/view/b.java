package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.w;
import com.tencent.mm.g.b.a.cw;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.b.a.o;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements q {
    ViewGroup eAl;
    boolean gBF;
    MMActivity hwd;
    volatile boolean isLoading;
    boolean isRetry;
    g mJG;
    i mJs;
    private boolean mVC;
    TextView pNv;
    b udH;
    View udL;
    LinearLayout udM;
    f udN;
    String udO;
    String udP;
    View udQ;
    View udR;
    private com.tencent.mm.plugin.websearch.widget.view.footer.a udS;
    LinearLayout udT;
    MoreFooter udU;
    float[] udV = new float[2];
    int udW;
    a udX;
    WidgetData udY;
    WidgetData udZ;
    ThreeDotsLoadingView uea;
    View ueb;
    View uec;
    private com.tencent.mm.plugin.websearch.widget.view.footer.a.a ued = new com.tencent.mm.plugin.websearch.widget.view.footer.a.a() {
        public final void cWf() {
            AppMethodBeat.i(91512);
            List cVW = b.this.udX.cVW();
            if (cVW == null || cVW.isEmpty() || cVW.size() == 1) {
                AppMethodBeat.o(91512);
                return;
            }
            com.tencent.mm.plugin.websearch.widget.f.a(1, b.this.udY, null);
            b.this.udW = ((h) com.tencent.mm.kernel.g.K(h.class)).a(b.this.hwd, ah.getContext().getString(R.string.g8y), "", cVW, new x() {
                public final void go(int i, int i2) {
                    AppMethodBeat.i(91511);
                    if (i2 != b.this.udW) {
                        AppMethodBeat.o(91511);
                        return;
                    }
                    b.this.udH.It(i);
                    AppMethodBeat.o(91511);
                }
            });
            AppMethodBeat.o(91512);
        }

        public final void cWg() {
            AppMethodBeat.i(91513);
            b.this.mJs.cUT();
            AppMethodBeat.o(91513);
        }

        public final void cWh() {
            AppMethodBeat.i(91514);
            b.this.mJs.cUU();
            AppMethodBeat.o(91514);
        }

        public final boolean hasNext() {
            AppMethodBeat.i(91515);
            boolean hasNext = b.this.udX.hasNext();
            AppMethodBeat.o(91515);
            return hasNext;
        }

        public final boolean hasPrevious() {
            AppMethodBeat.i(91516);
            boolean cVX = b.this.udX.cVX();
            AppMethodBeat.o(91516);
            return cVX;
        }

        public final int getItemCount() {
            AppMethodBeat.i(91517);
            int cVV = b.this.udX.cVV();
            AppMethodBeat.o(91517);
            return cVV;
        }
    };
    OnClickListener uee = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(91518);
            if (b.this.udY.ubr != null) {
                b.this.K(b.this.udY.ubr.ubG, b.this.udY.ubr.ubF, b.this.udY.ubs.ubz);
                b.this.iv(true);
            }
            AppMethodBeat.o(91518);
        }
    };
    View view;

    public interface a {
        int cVV();

        List<y> cVW();

        boolean cVX();

        boolean hasNext();
    }

    public interface b {
        void It(int i);

        void a(b bVar);
    }

    public b() {
        AppMethodBeat.i(91536);
        AppMethodBeat.o(91536);
    }

    /* Access modifiers changed, original: final */
    public final void K(String str, String str2, int i) {
        AppMethodBeat.i(91537);
        if (this.udY == null) {
            AppMethodBeat.o(91537);
            return;
        }
        CharSequence str3;
        String str4;
        String str5;
        int i2;
        if (!TextUtils.isEmpty(str3)) {
            Uri parse = Uri.parse(str3);
            String path = parse.getPath();
            if (!(TextUtils.isEmpty(path) || path.endsWith(".html"))) {
                str3 = parse.buildUpon().path(path + ".html").build().toString();
            }
        }
        u.i("WidgetView", "open app with path %s", str3);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_NO_FACE;
        appBrandStatObject.cst = this.udY.ubv + "::" + this.udY.ubs.hlm + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.udY.ubs.ubA + ":1:" + String.format("1:%s:%d:%s:%s:%s:%s:%d:%s", new Object[]{"", Long.valueOf(System.currentTimeMillis()), this.udY.ubs.ubB, "isWidget=1", this.udO, this.udY.ubs.fpS, Integer.valueOf(this.udY.ubs.fmr), Integer.valueOf(0)});
        if (TextUtils.isEmpty(str3)) {
            str4 = this.udY.ubs.csu;
        } else {
            CharSequence str42 = str3;
        }
        if (TextUtils.isEmpty(str2)) {
            str5 = this.udY.ubs.userName;
        } else {
            str5 = str2;
        }
        e eVar = (e) com.tencent.mm.kernel.g.K(e.class);
        Context context = ah.getContext();
        if (i == -1) {
            i2 = this.udY.ubs.ubz;
        } else {
            i2 = i;
        }
        eVar.a(context, str5, null, i2, this.udY.ubs.version, str42, appBrandStatObject);
        WidgetData widgetData = this.udY;
        o oVar = new o();
        oVar.cWq = 1;
        oVar = oVar.eK(str42).eJ(widgetData.query).Fp().eH(widgetData.ubs.hlm);
        oVar.cWt = (long) widgetData.ubs.fmr;
        oVar.eI(widgetData.ubv).eL(str5).ajK();
        AppMethodBeat.o(91537);
    }

    public final void hide() {
        AppMethodBeat.i(91538);
        if (this.gBF) {
            onPause();
            AppMethodBeat.o(91538);
            return;
        }
        AppMethodBeat.o(91538);
    }

    public final void onResume() {
        AppMethodBeat.i(91540);
        if (this.gBF) {
            this.udN.onResume();
            cVY();
            ab.v("WidgetView", "%s resume", toString());
            AppMethodBeat.o(91540);
            return;
        }
        AppMethodBeat.o(91540);
    }

    public final void onPause() {
        AppMethodBeat.i(91541);
        if (this.gBF) {
            if (this.udN != null) {
                this.udN.onPause();
            }
            this.mVC = false;
            ab.v("WidgetView", "%s paused", toString());
            AppMethodBeat.o(91541);
            return;
        }
        AppMethodBeat.o(91541);
    }

    public final void onDestroy() {
        AppMethodBeat.i(91542);
        if (this.udN == null) {
            AppMethodBeat.o(91542);
            return;
        }
        this.udN.adE(this.udO);
        this.udN.onDestroy();
        this.udY = null;
        this.udO = null;
        this.hwd = null;
        AppMethodBeat.o(91542);
    }

    public final void e(WidgetData widgetData) {
        AppMethodBeat.i(91543);
        if (widgetData == null) {
            AppMethodBeat.o(91543);
            return;
        }
        this.udY = widgetData;
        ab.v("WidgetView", "%s, cur data %s", toString(), this.udY.toString());
        if (this.gBF) {
            cWa();
            AppMethodBeat.o(91543);
            return;
        }
        if (this.udY != this.udZ) {
            cVZ();
        }
        AppMethodBeat.o(91543);
    }

    /* Access modifiers changed, original: final */
    public final void cVZ() {
        AppMethodBeat.i(91544);
        this.udL.setVisibility(8);
        this.udM.setVisibility(8);
        this.ueb.setVisibility(0);
        this.uea.dKS();
        if (this.udN != null) {
            this.udN.adE(this.udO);
        }
        AppMethodBeat.o(91544);
    }

    public final void bcM() {
        AppMethodBeat.i(91545);
        this.udN.adE(this.udO);
        AppMethodBeat.o(91545);
    }

    /* Access modifiers changed, original: final */
    public final void cWa() {
        AppMethodBeat.i(91546);
        if (this.eAl == null || this.udZ == this.udY) {
            ab.v("WidgetView", "%s same widgetData", toString());
            AppMethodBeat.o(91546);
            return;
        }
        this.udL.setVisibility(8);
        this.udM.setVisibility(0);
        f(this.udY);
        AppMethodBeat.o(91546);
    }

    private void f(WidgetData widgetData) {
        AppMethodBeat.i(91547);
        if (widgetData != null) {
            this.isLoading = true;
            this.ueb.setVisibility(8);
            this.uea.dKT();
            this.udM.removeView(this.uea);
            this.udZ = widgetData;
            this.udL.setVisibility(8);
            this.udM.setVisibility(0);
            this.udN.adE(this.udO);
            this.udY = widgetData;
            this.udO = "widgetid_" + System.currentTimeMillis();
            this.udN.a(widgetData, this.udO, ((n) com.tencent.mm.kernel.g.K(n.class)).cUM(), 47);
            cu();
            ab.v("WidgetView", "%s, last %s, cur %s", toString(), this.udZ.toString(), this.udY.toString());
        }
        AppMethodBeat.o(91547);
    }

    /* Access modifiers changed, original: final */
    public final void cu() {
        AppMethodBeat.i(91548);
        if (this.udY == null) {
            AppMethodBeat.o(91548);
            return;
        }
        if (this.udY.ubs.ubE) {
            this.udR.setVisibility(0);
            this.udQ.setVisibility(0);
            clQ();
        } else {
            this.udR.setVisibility(8);
            this.udQ.setVisibility(8);
        }
        this.pNv.setText(cWd());
        AppMethodBeat.o(91548);
    }

    private void clQ() {
        AppMethodBeat.i(91549);
        switch (this.udY.ubu) {
            case 1:
                this.udU.setVisibility(8);
                this.udT.setVisibility(0);
                cWc();
                AppMethodBeat.o(91549);
                return;
            case 2:
                this.udT.setVisibility(8);
                this.udU.setVisibility(0);
                cWb();
                AppMethodBeat.o(91549);
                return;
            default:
                ab.w("WidgetView", "unknown footer type %d", Integer.valueOf(this.udY.ubu));
                AppMethodBeat.o(91549);
                return;
        }
    }

    private void cWb() {
        AppMethodBeat.i(91550);
        if (this.udY.ubr != null) {
            this.udU.setTitle(this.udY.ubr.title);
            AppMethodBeat.o(91550);
            return;
        }
        this.udU.setVisibility(8);
        ab.e("WidgetView", "more footer has empty title");
        AppMethodBeat.o(91550);
    }

    private String cWd() {
        AppMethodBeat.i(91552);
        String string;
        if (TextUtils.isEmpty(this.udY.ubs.ubD)) {
            string = ah.getContext().getString(R.string.g91);
            AppMethodBeat.o(91552);
            return string;
        }
        string = this.udY.ubs.ubD;
        AppMethodBeat.o(91552);
        return string;
    }

    private String cWe() {
        AppMethodBeat.i(91553);
        String string;
        if (TextUtils.isEmpty(this.udY.ubs.kcx)) {
            string = ah.getContext().getString(R.string.g8z, new Object[]{this.udY.ubs.bCu});
            AppMethodBeat.o(91553);
            return string;
        }
        string = this.udY.ubs.kcx;
        AppMethodBeat.o(91553);
        return string;
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.i(91554);
        ab.v("WidgetView", "%s selected %b", toString(), Boolean.valueOf(z));
        this.gBF = z;
        if (this.gBF) {
            cWa();
            cVY();
            AppMethodBeat.o(91554);
            return;
        }
        this.mVC = false;
        AppMethodBeat.o(91554);
    }

    private static void ap(Map<String, String> map) {
        AppMethodBeat.i(91555);
        bsj bsj = new bsj();
        bsj.wUu = aq(map);
        w.a(new com.tencent.mm.plugin.websearch.api.w(bsj).fAT, null);
        AppMethodBeat.o(91555);
    }

    private static String aq(Map<String, String> map) {
        AppMethodBeat.i(91556);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append((String) entry.getKey()).append("=").append(URLEncoder.encode((String) entry.getValue())).append("&");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(91556);
        return stringBuilder2;
    }

    public final void iv(boolean z) {
        AppMethodBeat.i(91557);
        ab.i("WidgetView", "report click");
        HashMap hashMap = new HashMap();
        hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, String.format("262144:%s:%d:%s", new Object[]{this.udY.ubs.ubA, Long.valueOf(System.currentTimeMillis() / 1000), this.udY.ubs.ubB}));
        hashMap.put("searchid", this.udY.ubs.hlm);
        hashMap.put("scene", "47");
        hashMap.put(SearchIntents.EXTRA_QUERY, this.udY.query);
        hashMap.put("sessionid", this.udY.ubv);
        hashMap.put("docid", this.udY.ubs.ubA);
        hashMap.put(Param.TIMESTAMP, (System.currentTimeMillis() / 1000));
        hashMap.put("jumpurl", this.udY.ubs.csu);
        String str = "expand2";
        String str2 = "{\"statBuffer\":\"%s\";\"adBuffer\":\"\";\"clickId\":%s;\"isMore\":%s}";
        Object[] objArr = new Object[3];
        objArr[0] = this.udY.ubs.ubB;
        objArr[1] = System.currentTimeMillis();
        objArr[2] = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        hashMap.put(str, String.format(str2, objArr));
        hashMap.put("businesstype", "262144");
        hashMap.put("h5version", aa.HV(0));
        hashMap.put("resulttype", "262144");
        hashMap.put("resultsubtype", this.udY.ubs.fmr);
        ap(hashMap);
        if (this.mJG != null) {
            this.mJG.onClick();
        }
        cw cwVar = new cw();
        cwVar.dio = (long) bo.ank((String) hashMap.get("businesstype"));
        cwVar = cwVar.hN((String) hashMap.get("docid")).hO((String) hashMap.get("expand2")).hP((String) hashMap.get(SearchIntents.EXTRA_QUERY));
        cwVar.dit = (long) bo.ank((String) hashMap.get("resultsubtype"));
        cwVar.diq = System.currentTimeMillis();
        cw hQ = cwVar.hM(this.udY.ubs.hlm).hQ(this.udY.ubv);
        hQ.cXP = 47;
        hQ.ajK();
        AppMethodBeat.o(91557);
    }

    private void cVY() {
        AppMethodBeat.i(91539);
        if (this.view != null) {
            boolean z = this.mVC;
            if (this.view.getVisibility() != 0) {
                this.mVC = false;
                AppMethodBeat.o(91539);
                return;
            }
            int[] iArr = new int[2];
            this.view.getLocationOnScreen(iArr);
            if (this.mJG == null || !this.mJG.u(iArr)) {
                this.mVC = false;
            } else {
                this.mVC = true;
            }
            if (z != this.mVC && this.mVC) {
                ab.i("WidgetView", "exposure");
                String format = String.format("262144:%s:%d:%s;", new Object[]{this.udY.ubs.ubA, Long.valueOf(System.currentTimeMillis() / 1000), this.udY.ubs.ubB});
                String str = this.udY.ubs.fmr + ";";
                String str2 = "262144:" + this.udY.ubs.fmr + ";";
                HashMap hashMap = new HashMap();
                hashMap.put("isexpose", "1");
                hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, format);
                hashMap.put("searchid", this.udY.ubs.hlm);
                hashMap.put("scene", "47");
                hashMap.put(SearchIntents.EXTRA_QUERY, this.udY.query);
                hashMap.put("sessionid", this.udY.ubv);
                hashMap.put("resulttype", str2);
                hashMap.put("resultsubtypelist", str);
                hashMap.put("ishomepage", "1");
                hashMap.put("height", this.udM.getHeight() + ";");
                hashMap.put("requestid", System.currentTimeMillis());
                ap(hashMap);
                if (this.mJG != null) {
                    this.mJG.bBg();
                }
                cx hT = new cx().hR(format).hU(this.udY.query).hW(str).hV(str2).hS(this.udY.ubs.hlm).hT(this.udY.ubv);
                hT.cXP = 47;
                hT.ajK();
            }
        }
        AppMethodBeat.o(91539);
    }

    private void cWc() {
        AppMethodBeat.i(91551);
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = com.tencent.mm.ipcinvoker.wx_extension.a.a.b.eGM;
        c ll = com.tencent.mm.ipcinvoker.wx_extension.a.a.ll("100443");
        if (ll == null) {
            ab.i("WidgetView", "openSearchPreload item is null");
            AppMethodBeat.o(91551);
            return;
        }
        int i = 3;
        if (ll.isValid()) {
            i = bo.ank((String) ll.dru().get("switchType"));
        }
        switch (i) {
            case 1:
                if (!(this.udS instanceof BtnSwitchFooter)) {
                    this.udT.removeView((View) this.udS);
                    this.udS = new BtnSwitchFooter(this.udT.getContext());
                    this.udT.addView((View) this.udS);
                    break;
                }
                break;
            case 2:
                if (!(this.udS instanceof DirectionSwitchFooter)) {
                    this.udT.removeView((View) this.udS);
                    this.udS = new DirectionSwitchFooter(this.udT.getContext());
                    this.udT.addView((View) this.udS);
                    break;
                }
                break;
            default:
                if (!(this.udS instanceof DownArrowSwitchFooter)) {
                    this.udT.removeView((View) this.udS);
                    this.udS = new DownArrowSwitchFooter(this.udT.getContext());
                    this.udT.addView((View) this.udS);
                    break;
                }
                break;
        }
        this.udS.setCallback(this.ued);
        this.udS.setTitle(cWe());
        this.udS.setIcon(this.udY.ubs.iconUrl);
        AppMethodBeat.o(91551);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(91558);
        ab.i("WidgetView", "handle tap event %s", bVar.udP);
        bVar.K(bVar.udY.ubs.csu, "", -1);
        AppMethodBeat.o(91558);
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(91559);
        if (!(!bVar.gBF || bVar.view == null || bVar.udY == null)) {
            ab.i("WidgetView", "reload widget");
            bVar.udZ = null;
            bVar.cWa();
        }
        AppMethodBeat.o(91559);
    }
}
