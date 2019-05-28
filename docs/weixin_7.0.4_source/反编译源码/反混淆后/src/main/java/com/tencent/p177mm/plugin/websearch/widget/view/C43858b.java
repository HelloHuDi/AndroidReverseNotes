package com.tencent.p177mm.plugin.websearch.widget.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a;
import com.tencent.p177mm.ipcinvoker.wx_extension.p1463a.C42142a.C32718b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C1598o;
import com.tencent.p177mm.p230g.p232b.p233a.C37830cw;
import com.tencent.p177mm.p230g.p232b.p233a.C46885cx;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.websearch.api.C14427x;
import com.tencent.p177mm.plugin.websearch.api.C22759r;
import com.tencent.p177mm.plugin.websearch.api.C29739g;
import com.tencent.p177mm.plugin.websearch.api.C29740h;
import com.tencent.p177mm.plugin.websearch.api.C29741i;
import com.tencent.p177mm.plugin.websearch.api.C29742q;
import com.tencent.p177mm.plugin.websearch.api.C29743y;
import com.tencent.p177mm.plugin.websearch.api.C40192f;
import com.tencent.p177mm.plugin.websearch.api.C43852n;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C46405w;
import com.tencent.p177mm.plugin.websearch.api.WidgetData;
import com.tencent.p177mm.plugin.websearch.widget.C46409f;
import com.tencent.p177mm.plugin.websearch.widget.p1067b.C14436a.C14435a;
import com.tencent.p177mm.plugin.websearch.widget.p1067b.C14436a.C144371;
import com.tencent.p177mm.plugin.websearch.widget.p1067b.C14436a.C144382;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.BtnSwitchFooter;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.C43862a;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.C43862a.C43861a;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.DirectionSwitchFooter;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.DownArrowSwitchFooter;
import com.tencent.p177mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.p177mm.protocal.protobuf.bsj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.b */
public final class C43858b implements C29742q {
    ViewGroup eAl;
    boolean gBF;
    MMActivity hwd;
    volatile boolean isLoading;
    boolean isRetry;
    C29739g mJG;
    C29741i mJs;
    private boolean mVC;
    TextView pNv;
    C43860b udH;
    View udL;
    LinearLayout udM;
    C40192f udN;
    String udO;
    String udP;
    View udQ;
    View udR;
    private C43862a udS;
    LinearLayout udT;
    MoreFooter udU;
    float[] udV = new float[2];
    int udW;
    C40210a udX;
    WidgetData udY;
    WidgetData udZ;
    ThreeDotsLoadingView uea;
    View ueb;
    View uec;
    private C43861a ued = new C227751();
    OnClickListener uee = new C227772();
    View view;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$1 */
    class C227751 implements C43861a {

        /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$1$1 */
        class C227761 implements C14427x {
            C227761() {
            }

            /* renamed from: go */
            public final void mo9690go(int i, int i2) {
                AppMethodBeat.m2504i(91511);
                if (i2 != C43858b.this.udW) {
                    AppMethodBeat.m2505o(91511);
                    return;
                }
                C43858b.this.udH.mo63560It(i);
                AppMethodBeat.m2505o(91511);
            }
        }

        C227751() {
        }

        public final void cWf() {
            AppMethodBeat.m2504i(91512);
            List cVW = C43858b.this.udX.cVW();
            if (cVW == null || cVW.isEmpty() || cVW.size() == 1) {
                AppMethodBeat.m2505o(91512);
                return;
            }
            C46409f.m87355a(1, C43858b.this.udY, null);
            C43858b.this.udW = ((C29740h) C1720g.m3528K(C29740h.class)).mo47978a(C43858b.this.hwd, C4996ah.getContext().getString(C25738R.string.g8y), "", cVW, new C227761());
            AppMethodBeat.m2505o(91512);
        }

        public final void cWg() {
            AppMethodBeat.m2504i(91513);
            C43858b.this.mJs.cUT();
            AppMethodBeat.m2505o(91513);
        }

        public final void cWh() {
            AppMethodBeat.m2504i(91514);
            C43858b.this.mJs.cUU();
            AppMethodBeat.m2505o(91514);
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(91515);
            boolean hasNext = C43858b.this.udX.hasNext();
            AppMethodBeat.m2505o(91515);
            return hasNext;
        }

        public final boolean hasPrevious() {
            AppMethodBeat.m2504i(91516);
            boolean cVX = C43858b.this.udX.cVX();
            AppMethodBeat.m2505o(91516);
            return cVX;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(91517);
            int cVV = C43858b.this.udX.cVV();
            AppMethodBeat.m2505o(91517);
            return cVV;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$2 */
    class C227772 implements OnClickListener {
        C227772() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91518);
            if (C43858b.this.udY.ubr != null) {
                C43858b.this.mo69537K(C43858b.this.udY.ubr.ubG, C43858b.this.udY.ubr.ubF, C43858b.this.udY.ubs.ubz);
                C43858b.this.mo69544iv(true);
            }
            AppMethodBeat.m2505o(91518);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$8 */
    class C227798 implements OnLongClickListener {

        /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$8$1 */
        class C227781 implements C14435a {
            C227781() {
            }

            public final void cVR() {
                AppMethodBeat.m2504i(91533);
                C43858b.this.udN.adD(C43858b.this.udO);
                AppMethodBeat.m2505o(91533);
            }

            public final void cUT() {
                AppMethodBeat.m2504i(91534);
                C43858b.this.mJs.cUT();
                AppMethodBeat.m2505o(91534);
            }
        }

        C227798() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(91535);
            if (C43858b.this.udY != null && C5047bp.dpL()) {
                Context context = C43858b.this.eAl.getContext();
                C227781 c227781 = new C227781();
                C36356d c36356d = new C36356d(context, 2, true);
                c36356d.mo57242q("当前服务为体验版本，可以选择以下调试功能", 48);
                c36356d.rBl = new C144371();
                c36356d.rBm = new C144382(c227781);
                c36356d.cpD();
            }
            AppMethodBeat.m2505o(91535);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$3 */
    class C297633 implements C22759r {
        C297633() {
        }

        public final void addView(View view) {
            AppMethodBeat.m2504i(91519);
            C43858b.this.udM.removeAllViews();
            C43858b.this.udM.addView(view);
            AppMethodBeat.m2505o(91519);
        }

        public final void removeView(View view) {
            AppMethodBeat.m2504i(91520);
            C43858b.this.udM.removeAllViews();
            AppMethodBeat.m2505o(91520);
        }

        /* renamed from: dw */
        public final void mo38346dw(String str, int i) {
            AppMethodBeat.m2504i(91521);
            if (i == 3) {
                if (C43858b.this.isRetry) {
                    C43858b.this.udL.setVisibility(8);
                    C43858b.this.udM.setVisibility(8);
                    C43858b.this.uec.setVisibility(0);
                    C43858b.this.udR.setVisibility(8);
                } else {
                    C43858b.this.udL.setVisibility(0);
                    C43858b.this.udM.setVisibility(8);
                    C43858b.this.udR.setVisibility(8);
                }
            }
            if (i != 1) {
                C43858b.this.isLoading = false;
                if (C43858b.this.udH != null) {
                    C43858b.this.udH.mo63561a(C43858b.this);
                }
                if (!C43858b.this.gBF) {
                    C43858b.this.udN.onPause();
                }
            }
            AppMethodBeat.m2505o(91521);
        }

        /* renamed from: g */
        public final void mo38349g(String str, boolean z, String str2) {
            AppMethodBeat.m2504i(91522);
            mo38342a(str, z, "", str2);
            AppMethodBeat.m2505o(91522);
        }

        /* renamed from: a */
        public final void mo38342a(String str, boolean z, String str2, String str3) {
            AppMethodBeat.m2504i(91523);
            C18652u.m29151i("WidgetView", "on tap callback eventId %s, consume %b, errMsg %s", str, Boolean.valueOf(z), str2);
            if (str3.equals(C43858b.this.udO) && str.equals(C43858b.this.udP)) {
                if (z) {
                    C4990ab.m7417i("WidgetView", "click event %s consumed by widget", C43858b.this.udP);
                } else {
                    C43858b.m78643b(C43858b.this);
                }
                C43858b.this.udP = null;
            }
            AppMethodBeat.m2505o(91523);
        }

        public final void adG(String str) {
            AppMethodBeat.m2504i(91524);
            if (str.equals(C43858b.this.udO)) {
                C43858b.m78644c(C43858b.this);
            }
            AppMethodBeat.m2505o(91524);
        }

        /* renamed from: gS */
        public final void mo38350gS(String str, String str2) {
            AppMethodBeat.m2504i(91525);
            C4990ab.m7417i("WidgetView", "onSearchWAWidgetDataPush %s", str);
            AppMethodBeat.m2505o(91525);
        }

        /* renamed from: g */
        public final void mo38348g(String str, String str2, String str3, int i) {
            AppMethodBeat.m2504i(91526);
            if (str.equals(C43858b.this.udO)) {
                C43858b.this.mo69537K(str2, str3, i);
                AppMethodBeat.m2505o(91526);
                return;
            }
            C4990ab.m7413e("WidgetView", "callback for expired widget %s", str);
            AppMethodBeat.m2505o(91526);
        }

        /* renamed from: dx */
        public final void mo38347dx(String str, int i) {
            AppMethodBeat.m2504i(91527);
            C43858b.this.udY.ubt.height = i;
            C43858b.this.udN.mo48001a(C43858b.this.udY, C43858b.this.udO);
            C43858b.this.mJs.mo47981a(C1338a.fromDPToPix(C43858b.this.hwd.mController.ylL, i + 131), C43858b.this);
            AppMethodBeat.m2505o(91527);
        }

        public final void cUV() {
            AppMethodBeat.m2504i(91528);
            C43858b.m78644c(C43858b.this);
            AppMethodBeat.m2505o(91528);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$6 */
    class C402096 implements OnTouchListener {
        C402096() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(91531);
            C43858b.this.udV[0] = motionEvent.getX();
            C43858b.this.udV[1] = motionEvent.getY();
            AppMethodBeat.m2505o(91531);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$a */
    public interface C40210a {
        int cVV();

        List<C29743y> cVW();

        boolean cVX();

        boolean hasNext();
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$4 */
    class C438564 implements OnClickListener {
        C438564() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91529);
            C43858b.m78643b(C43858b.this);
            AppMethodBeat.m2505o(91529);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$5 */
    class C438575 implements OnClickListener {
        C438575() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91530);
            C43858b.m78644c(C43858b.this);
            AppMethodBeat.m2505o(91530);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$7 */
    class C438597 implements OnClickListener {
        C438597() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(91532);
            C43858b.this.udP = "tap_" + System.currentTimeMillis();
            int i = (int) C43858b.this.udV[0];
            int i2 = (int) C43858b.this.udV[1];
            if (i < 2) {
                i = 2;
            }
            if (i2 < 2) {
                i2 = 2;
            }
            if (i2 > C43858b.this.udM.getHeight() - 2) {
                i2 = C43858b.this.udM.getHeight() - 2;
            }
            C43858b.this.udN.mo48006f(C42668g.m75570qa(i), C42668g.m75570qa(i2), C43858b.this.udO, C43858b.this.udP);
            C43858b.this.mo69544iv(false);
            C18652u.m29151i("WidgetView", "tap event id %s, location x %f, y %f", C43858b.this.udP, Float.valueOf(C43858b.this.udV[0]), Float.valueOf(C43858b.this.udV[1]));
            AppMethodBeat.m2505o(91532);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.b$b */
    public interface C43860b {
        /* renamed from: It */
        void mo63560It(int i);

        /* renamed from: a */
        void mo63561a(C43858b c43858b);
    }

    public C43858b() {
        AppMethodBeat.m2504i(91536);
        AppMethodBeat.m2505o(91536);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: K */
    public final void mo69537K(String str, String str2, int i) {
        AppMethodBeat.m2504i(91537);
        if (this.udY == null) {
            AppMethodBeat.m2505o(91537);
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
        C18652u.m29151i("WidgetView", "open app with path %s", str3);
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
        C45691e c45691e = (C45691e) C1720g.m3528K(C45691e.class);
        Context context = C4996ah.getContext();
        if (i == -1) {
            i2 = this.udY.ubs.ubz;
        } else {
            i2 = i;
        }
        c45691e.mo68045a(context, str5, null, i2, this.udY.ubs.version, str42, appBrandStatObject);
        WidgetData widgetData = this.udY;
        C1598o c1598o = new C1598o();
        c1598o.cWq = 1;
        c1598o = c1598o.mo5042eK(str42).mo5041eJ(widgetData.query).mo5038Fp().mo5039eH(widgetData.ubs.hlm);
        c1598o.cWt = (long) widgetData.ubs.fmr;
        c1598o.mo5040eI(widgetData.ubv).mo5043eL(str5).ajK();
        AppMethodBeat.m2505o(91537);
    }

    public final void hide() {
        AppMethodBeat.m2504i(91538);
        if (this.gBF) {
            onPause();
            AppMethodBeat.m2505o(91538);
            return;
        }
        AppMethodBeat.m2505o(91538);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(91540);
        if (this.gBF) {
            this.udN.onResume();
            cVY();
            C4990ab.m7419v("WidgetView", "%s resume", toString());
            AppMethodBeat.m2505o(91540);
            return;
        }
        AppMethodBeat.m2505o(91540);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(91541);
        if (this.gBF) {
            if (this.udN != null) {
                this.udN.onPause();
            }
            this.mVC = false;
            C4990ab.m7419v("WidgetView", "%s paused", toString());
            AppMethodBeat.m2505o(91541);
            return;
        }
        AppMethodBeat.m2505o(91541);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(91542);
        if (this.udN == null) {
            AppMethodBeat.m2505o(91542);
            return;
        }
        this.udN.adE(this.udO);
        this.udN.onDestroy();
        this.udY = null;
        this.udO = null;
        this.hwd = null;
        AppMethodBeat.m2505o(91542);
    }

    /* renamed from: e */
    public final void mo69542e(WidgetData widgetData) {
        AppMethodBeat.m2504i(91543);
        if (widgetData == null) {
            AppMethodBeat.m2505o(91543);
            return;
        }
        this.udY = widgetData;
        C4990ab.m7419v("WidgetView", "%s, cur data %s", toString(), this.udY.toString());
        if (this.gBF) {
            cWa();
            AppMethodBeat.m2505o(91543);
            return;
        }
        if (this.udY != this.udZ) {
            cVZ();
        }
        AppMethodBeat.m2505o(91543);
    }

    /* Access modifiers changed, original: final */
    public final void cVZ() {
        AppMethodBeat.m2504i(91544);
        this.udL.setVisibility(8);
        this.udM.setVisibility(8);
        this.ueb.setVisibility(0);
        this.uea.dKS();
        if (this.udN != null) {
            this.udN.adE(this.udO);
        }
        AppMethodBeat.m2505o(91544);
    }

    public final void bcM() {
        AppMethodBeat.m2504i(91545);
        this.udN.adE(this.udO);
        AppMethodBeat.m2505o(91545);
    }

    /* Access modifiers changed, original: final */
    public final void cWa() {
        AppMethodBeat.m2504i(91546);
        if (this.eAl == null || this.udZ == this.udY) {
            C4990ab.m7419v("WidgetView", "%s same widgetData", toString());
            AppMethodBeat.m2505o(91546);
            return;
        }
        this.udL.setVisibility(8);
        this.udM.setVisibility(0);
        m78645f(this.udY);
        AppMethodBeat.m2505o(91546);
    }

    /* renamed from: f */
    private void m78645f(WidgetData widgetData) {
        AppMethodBeat.m2504i(91547);
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
            this.udN.mo48002a(widgetData, this.udO, ((C43852n) C1720g.m3528K(C43852n.class)).cUM(), 47);
            mo69541cu();
            C4990ab.m7419v("WidgetView", "%s, last %s, cur %s", toString(), this.udZ.toString(), this.udY.toString());
        }
        AppMethodBeat.m2505o(91547);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cu */
    public final void mo69541cu() {
        AppMethodBeat.m2504i(91548);
        if (this.udY == null) {
            AppMethodBeat.m2505o(91548);
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
        AppMethodBeat.m2505o(91548);
    }

    private void clQ() {
        AppMethodBeat.m2504i(91549);
        switch (this.udY.ubu) {
            case 1:
                this.udU.setVisibility(8);
                this.udT.setVisibility(0);
                cWc();
                AppMethodBeat.m2505o(91549);
                return;
            case 2:
                this.udT.setVisibility(8);
                this.udU.setVisibility(0);
                cWb();
                AppMethodBeat.m2505o(91549);
                return;
            default:
                C4990ab.m7421w("WidgetView", "unknown footer type %d", Integer.valueOf(this.udY.ubu));
                AppMethodBeat.m2505o(91549);
                return;
        }
    }

    private void cWb() {
        AppMethodBeat.m2504i(91550);
        if (this.udY.ubr != null) {
            this.udU.setTitle(this.udY.ubr.title);
            AppMethodBeat.m2505o(91550);
            return;
        }
        this.udU.setVisibility(8);
        C4990ab.m7412e("WidgetView", "more footer has empty title");
        AppMethodBeat.m2505o(91550);
    }

    private String cWd() {
        AppMethodBeat.m2504i(91552);
        String string;
        if (TextUtils.isEmpty(this.udY.ubs.ubD)) {
            string = C4996ah.getContext().getString(C25738R.string.g91);
            AppMethodBeat.m2505o(91552);
            return string;
        }
        string = this.udY.ubs.ubD;
        AppMethodBeat.m2505o(91552);
        return string;
    }

    private String cWe() {
        AppMethodBeat.m2504i(91553);
        String string;
        if (TextUtils.isEmpty(this.udY.ubs.kcx)) {
            string = C4996ah.getContext().getString(C25738R.string.g8z, new Object[]{this.udY.ubs.bCu});
            AppMethodBeat.m2505o(91553);
            return string;
        }
        string = this.udY.ubs.kcx;
        AppMethodBeat.m2505o(91553);
        return string;
    }

    public final void setSelected(boolean z) {
        AppMethodBeat.m2504i(91554);
        C4990ab.m7419v("WidgetView", "%s selected %b", toString(), Boolean.valueOf(z));
        this.gBF = z;
        if (this.gBF) {
            cWa();
            cVY();
            AppMethodBeat.m2505o(91554);
            return;
        }
        this.mVC = false;
        AppMethodBeat.m2505o(91554);
    }

    /* renamed from: ap */
    private static void m78641ap(Map<String, String> map) {
        AppMethodBeat.m2504i(91555);
        bsj bsj = new bsj();
        bsj.wUu = C43858b.m78642aq(map);
        C1226w.m2654a(new C46405w(bsj).fAT, null);
        AppMethodBeat.m2505o(91555);
    }

    /* renamed from: aq */
    private static String m78642aq(Map<String, String> map) {
        AppMethodBeat.m2504i(91556);
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append((String) entry.getKey()).append("=").append(URLEncoder.encode((String) entry.getValue())).append("&");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(91556);
        return stringBuilder2;
    }

    /* renamed from: iv */
    public final void mo69544iv(boolean z) {
        AppMethodBeat.m2504i(91557);
        C4990ab.m7416i("WidgetView", "report click");
        HashMap hashMap = new HashMap();
        hashMap.put(C8741b.CONTENT, String.format("262144:%s:%d:%s", new Object[]{this.udY.ubs.ubA, Long.valueOf(System.currentTimeMillis() / 1000), this.udY.ubs.ubB}));
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
        hashMap.put("h5version", C46400aa.m87305HV(0));
        hashMap.put("resulttype", "262144");
        hashMap.put("resultsubtype", this.udY.ubs.fmr);
        C43858b.m78641ap(hashMap);
        if (this.mJG != null) {
            this.mJG.onClick();
        }
        C37830cw c37830cw = new C37830cw();
        c37830cw.dio = (long) C5046bo.ank((String) hashMap.get("businesstype"));
        c37830cw = c37830cw.mo60547hN((String) hashMap.get("docid")).mo60548hO((String) hashMap.get("expand2")).mo60549hP((String) hashMap.get(SearchIntents.EXTRA_QUERY));
        c37830cw.dit = (long) C5046bo.ank((String) hashMap.get("resultsubtype"));
        c37830cw.diq = System.currentTimeMillis();
        C37830cw hQ = c37830cw.mo60546hM(this.udY.ubs.hlm).mo60550hQ(this.udY.ubv);
        hQ.cXP = 47;
        hQ.ajK();
        AppMethodBeat.m2505o(91557);
    }

    private void cVY() {
        AppMethodBeat.m2504i(91539);
        if (this.view != null) {
            boolean z = this.mVC;
            if (this.view.getVisibility() != 0) {
                this.mVC = false;
                AppMethodBeat.m2505o(91539);
                return;
            }
            int[] iArr = new int[2];
            this.view.getLocationOnScreen(iArr);
            if (this.mJG == null || !this.mJG.mo7479u(iArr)) {
                this.mVC = false;
            } else {
                this.mVC = true;
            }
            if (z != this.mVC && this.mVC) {
                C4990ab.m7416i("WidgetView", "exposure");
                String format = String.format("262144:%s:%d:%s;", new Object[]{this.udY.ubs.ubA, Long.valueOf(System.currentTimeMillis() / 1000), this.udY.ubs.ubB});
                String str = this.udY.ubs.fmr + ";";
                String str2 = "262144:" + this.udY.ubs.fmr + ";";
                HashMap hashMap = new HashMap();
                hashMap.put("isexpose", "1");
                hashMap.put(C8741b.CONTENT, format);
                hashMap.put("searchid", this.udY.ubs.hlm);
                hashMap.put("scene", "47");
                hashMap.put(SearchIntents.EXTRA_QUERY, this.udY.query);
                hashMap.put("sessionid", this.udY.ubv);
                hashMap.put("resulttype", str2);
                hashMap.put("resultsubtypelist", str);
                hashMap.put("ishomepage", "1");
                hashMap.put("height", this.udM.getHeight() + ";");
                hashMap.put("requestid", System.currentTimeMillis());
                C43858b.m78641ap(hashMap);
                if (this.mJG != null) {
                    this.mJG.bBg();
                }
                C46885cx hT = new C46885cx().mo76078hR(format).mo76081hU(this.udY.query).mo76083hW(str).mo76082hV(str2).mo76079hS(this.udY.ubs.hlm).mo76080hT(this.udY.ubv);
                hT.cXP = 47;
                hT.ajK();
            }
        }
        AppMethodBeat.m2505o(91539);
    }

    private void cWc() {
        AppMethodBeat.m2504i(91551);
        C42142a c42142a = C32718b.eGM;
        C5141c ll = C42142a.m74295ll("100443");
        if (ll == null) {
            C4990ab.m7416i("WidgetView", "openSearchPreload item is null");
            AppMethodBeat.m2505o(91551);
            return;
        }
        int i = 3;
        if (ll.isValid()) {
            i = C5046bo.ank((String) ll.dru().get("switchType"));
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
        AppMethodBeat.m2505o(91551);
    }

    /* renamed from: b */
    static /* synthetic */ void m78643b(C43858b c43858b) {
        AppMethodBeat.m2504i(91558);
        C4990ab.m7417i("WidgetView", "handle tap event %s", c43858b.udP);
        c43858b.mo69537K(c43858b.udY.ubs.csu, "", -1);
        AppMethodBeat.m2505o(91558);
    }

    /* renamed from: c */
    static /* synthetic */ void m78644c(C43858b c43858b) {
        AppMethodBeat.m2504i(91559);
        if (!(!c43858b.gBF || c43858b.view == null || c43858b.udY == null)) {
            C4990ab.m7416i("WidgetView", "reload widget");
            c43858b.udZ = null;
            c43858b.cWa();
        }
        AppMethodBeat.m2505o(91559);
    }
}
