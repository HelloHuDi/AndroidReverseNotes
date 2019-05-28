package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.support.p069v7.widget.C31895y;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.statusbar.C7355b;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C42371i;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.C45536u;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.collection.C10869h;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1671b.C46949a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19693f;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.ams;
import com.tencent.p177mm.protocal.protobuf.amt;
import com.tencent.p177mm.protocal.protobuf.cki;
import com.tencent.p177mm.protocal.protobuf.ckj;
import com.tencent.p177mm.protocal.protobuf.cxk;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI */
public final class AppBrandProfileUI extends MMActivity implements C4931a {
    private static final int iHp = C1338a.fromDPToPix(C4996ah.getContext(), 24);
    private static final int iHq = C1338a.fromDPToPix(C4996ah.getContext(), 20);
    private static final int iHr = C1338a.fromDPToPix(C4996ah.getContext(), 2);
    private static final int iHs = C1338a.fromDPToPix(C4996ah.getContext(), 40);
    private static final int iHt = C1338a.fromDPToPix(C4996ah.getContext(), 44);
    private static final int iHu = C1338a.fromDPToPix(C4996ah.getContext(), 32);
    private static final int iHv = C1338a.fromDPToPix(C4996ah.getContext(), 4);
    private C45536u iFD;
    private ImageView iFW;
    private LinkedList<cxk> iHA = new LinkedList();
    private LinearLayout iHB;
    private ImageView iHC;
    private TextView iHD;
    private TextView iHE;
    private TextView iHF;
    private RatingBar iHG;
    private TextView iHH;
    private LinearLayout iHI;
    private RecyclerView iHJ;
    private LinearLayout iHK;
    private LinearLayout iHL;
    private LinearLayout iHM;
    private TextView iHN;
    private AppBrandNearbyShowcaseView iHO;
    private LinearLayout iHP;
    private FrameLayout iHQ;
    private TextView iHR;
    private TextView iHS;
    private LinearLayout iHT;
    private ImageView iHU;
    private LinearLayout iHV;
    private AppBrandNearbyShowcaseView iHW;
    private TextView iHX;
    private int iHY;
    private C36356d iHZ;
    private long iHw = 0;
    private boolean iHx = false;
    private boolean iHy = false;
    private int iHz = 0;
    private WxaExposedParams iIa;
    private boolean iIb = false;
    private C37932f iIc;
    private C37932f iId;
    private C37932f iIe;
    private String igi;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$12 */
    class C1077212 implements OnClickListener {
        C1077212() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133037);
            AppBrandProfileUI.m18475g(AppBrandProfileUI.this);
            AppMethodBeat.m2505o(133037);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$17 */
    class C1077417 implements OnClickListener {
        C1077417() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133042);
            AppBrandProfileUI.m18462a(AppBrandProfileUI.this, view);
            AppMethodBeat.m2505o(133042);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$19 */
    class C1077519 implements OnClickListener {
        C1077519() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133044);
            if (AppBrandProfileUI.this.iIa == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "wxaExposedParams is null");
                AppMethodBeat.m2505o(133044);
                return;
            }
            Intent intent = new Intent();
            C4990ab.m7417i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "feedbackUrl:%s, wxaExposedParams:%s", C42700v.m75631a(AppBrandProfileUI.this.iIa), AppBrandProfileUI.this.iIa.toString());
            intent.putExtra("title", view.getContext().getString(C25738R.string.f9018mn));
            intent.putExtra("rawUrl", r1);
            intent.putExtra("forceHideShare", true);
            C25985d.m41467b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppBrandProfileUI.m18460a(AppBrandProfileUI.this, 20, 1);
            AppMethodBeat.m2505o(133044);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$a */
    static class C10779a implements C9557a {
        WeakReference<AppBrandProfileUI> iIm;

        public C10779a(AppBrandProfileUI appBrandProfileUI) {
            AppMethodBeat.m2504i(133049);
            this.iIm = new WeakReference(appBrandProfileUI);
            AppMethodBeat.m2505o(133049);
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(133050);
            if (!(this.iIm == null || this.iIm.get() == null)) {
                if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof amt)) {
                    C4990ab.m7416i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
                    final amt amt = (amt) c7472b.fsH.fsP;
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(133048);
                            if (!(C10779a.this.iIm == null || C10779a.this.iIm.get() == null)) {
                                AppBrandProfileUI.m18464a((AppBrandProfileUI) C10779a.this.iIm.get(), amt);
                            }
                            AppMethodBeat.m2505o(133048);
                        }
                    });
                    AppMethodBeat.m2505o(133050);
                    return;
                }
                C4990ab.m7412e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
            }
            AppMethodBeat.m2505o(133050);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$b */
    static class C10780b implements C9557a {
        WeakReference<AppBrandProfileUI> iIm;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$b$1 */
        class C107811 implements Runnable {
            C107811() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133051);
                if (!(C10780b.this.iIm == null || C10780b.this.iIm.get() == null)) {
                    AppBrandProfileUI appBrandProfileUI = (AppBrandProfileUI) C10780b.this.iIm.get();
                    if (appBrandProfileUI.iHx) {
                        appBrandProfileUI.iHA.removeFirst();
                        appBrandProfileUI.iHz = appBrandProfileUI.iHz - 1;
                    } else {
                        cxk cxk = new cxk();
                        cxk.xsL = true;
                        cxk.nSa = C41730b.m73505pX(C1853r.m3846Yz());
                        cxk.nickname = C1853r.m3820YB();
                        appBrandProfileUI.iHA.addFirst(cxk);
                        appBrandProfileUI.iHz = appBrandProfileUI.iHz + 1;
                    }
                    appBrandProfileUI.iHx = !appBrandProfileUI.iHx;
                    AppBrandProfileUI.m18481m(appBrandProfileUI);
                    if (appBrandProfileUI.iHy) {
                        AppBrandProfileUI.m18460a(appBrandProfileUI, 17, 1);
                        AppMethodBeat.m2505o(133051);
                        return;
                    }
                    AppBrandProfileUI.m18460a(appBrandProfileUI, 18, 1);
                }
                AppMethodBeat.m2505o(133051);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$b$2 */
        class C107822 implements Runnable {
            C107822() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133052);
                if (!(C10780b.this.iIm == null || C10780b.this.iIm.get() == null)) {
                    AppBrandProfileUI appBrandProfileUI = (AppBrandProfileUI) C10780b.this.iIm.get();
                    if (appBrandProfileUI.iHy) {
                        Toast.makeText(appBrandProfileUI, C25738R.string.f9019mo, 0).show();
                        AppBrandProfileUI.m18460a(appBrandProfileUI, 17, 2);
                        AppMethodBeat.m2505o(133052);
                        return;
                    }
                    Toast.makeText(appBrandProfileUI, C25738R.string.f9017ml, 0).show();
                    AppBrandProfileUI.m18460a(appBrandProfileUI, 18, 2);
                }
                AppMethodBeat.m2505o(133052);
            }
        }

        public C10780b(AppBrandProfileUI appBrandProfileUI) {
            AppMethodBeat.m2504i(133053);
            this.iIm = new WeakReference(appBrandProfileUI);
            AppMethodBeat.m2505o(133053);
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(133054);
            if (!(this.iIm == null || this.iIm.get() == null)) {
                if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof ckj)) {
                    C4990ab.m7416i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
                    C5004al.m7441d(new C107811());
                    AppMethodBeat.m2505o(133054);
                    return;
                }
                C4990ab.m7412e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
                C5004al.m7441d(new C107822());
            }
            AppMethodBeat.m2505o(133054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$11 */
    class C1078311 implements OnMenuItemClickListener {
        C1078311() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(133036);
            AppBrandProfileUI.m18459a(AppBrandProfileUI.this);
            AppMethodBeat.m2505o(133036);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$7 */
    class C107847 implements OnClickListener {
        C107847() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133032);
            AppBrandProfileUI.m18460a(AppBrandProfileUI.this, 22, 1);
            AppMethodBeat.m2505o(133032);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$18 */
    class C1078518 extends C25373h {
        C1078518() {
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(133043);
            int al = C1338a.m2856al(AppBrandProfileUI.this, C25738R.dimen.f10164ss);
            int al2 = C1338a.m2856al(AppBrandProfileUI.this, C25738R.dimen.f10161sn);
            if (RecyclerView.m72547bo(view) == 0) {
                rect.left = al;
            } else {
                rect.left = 0;
            }
            rect.right = al2;
            AppMethodBeat.m2505o(133043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$20 */
    class C1078620 implements C5681a<Void, C7355b> {
        C1078620() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(133045);
            ((C7355b) obj).setLayoutFrozen(false);
            Void voidR = zXH;
            AppMethodBeat.m2505o(133045);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$21 */
    class C1078721 implements C5681a<Void, C7355b> {
        C1078721() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(133046);
            ((C7355b) obj).setLayoutFrozen(true);
            Void voidR = zXH;
            AppMethodBeat.m2505o(133046);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$2 */
    class C107892 implements C36073c {
        C107892() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(133026);
            c44273l.clear();
            c44273l.mo70072hi(4, ((C10118af) C1720g.m3528K(C10118af.class)).mo21471aB(AppBrandProfileUI.this.igi, 0) ? C25738R.string.f9068od : C25738R.string.f9065oa);
            c44273l.mo70072hi(2, C25738R.string.f8850h2);
            if (AppBrandProfileUI.this.iFD != null && AppBrandProfileUI.this.iFD.bQl == 0) {
                c44273l.mo70072hi(5, C25738R.string.f9021mq);
            }
            AppMethodBeat.m2505o(133026);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$14 */
    class C1079014 implements OnClickListener {
        C1079014() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133039);
            AppBrandProfileUI.m18476h(AppBrandProfileUI.this);
            AppMethodBeat.m2505o(133039);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$16 */
    class C1079216 implements OnClickListener {
        C1079216() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133041);
            AppBrandProfileUI.m18467b(AppBrandProfileUI.this);
            AppMethodBeat.m2505o(133041);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$1 */
    class C107931 implements OnMenuItemClickListener {
        C107931() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(133025);
            AppBrandProfileUI.this.onBackPressed();
            AppMethodBeat.m2505o(133025);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$13 */
    class C1079713 implements OnClickListener {
        C1079713() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133038);
            AppBrandProfileUI.m18476h(AppBrandProfileUI.this);
            AppMethodBeat.m2505o(133038);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI$3 */
    class C107983 implements C5279d {
        C107983() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(133027);
            switch (menuItem.getItemId()) {
                case 2:
                    C25985d.m41467b(AppBrandProfileUI.this, "appbrand", ".ui.AppBrandAuthorizeUI", new Intent(AppBrandProfileUI.this, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.this.igi));
                    AppBrandProfileUI.m18460a(AppBrandProfileUI.this, 10, 1);
                    AppMethodBeat.m2505o(133027);
                    return;
                case 4:
                    boolean aB = ((C10118af) C1720g.m3528K(C10118af.class)).mo21471aB(AppBrandProfileUI.this.igi, 0);
                    AppBrandProfileUI.m18460a(AppBrandProfileUI.this, aB ? 12 : 11, C10869h.m18573a(aB, AppBrandProfileUI.this, AppBrandProfileUI.this.igi, 0) ? 1 : 2);
                    AppMethodBeat.m2505o(133027);
                    return;
                case 5:
                    if (!(AppBrandProfileUI.this.iFD == null || C5046bo.isNullOrNil(AppBrandProfileUI.this.iFD.appId))) {
                        C25985d.m41467b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", C42700v.m75635xg(AppBrandProfileUI.this.iFD.appId)).putExtra("forceHideShare", true));
                        AppBrandProfileUI.m18460a(AppBrandProfileUI.this, 16, 1);
                        break;
                    }
            }
            AppMethodBeat.m2505o(133027);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppBrandProfileUI() {
        AppMethodBeat.m2504i(133055);
        AppMethodBeat.m2505o(133055);
    }

    /* renamed from: m */
    static /* synthetic */ void m18481m(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.m2504i(133081);
        appBrandProfileUI.aMn();
        AppMethodBeat.m2505o(133081);
    }

    static {
        AppMethodBeat.m2504i(133082);
        AppMethodBeat.m2505o(133082);
    }

    /* renamed from: a */
    public static void m18458a(Context context, String str, int i, String str2, WxaExposedParams wxaExposedParams, Bundle bundle, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.m2504i(133056);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(133056);
            return;
        }
        if (context == null) {
            context = C4996ah.getContext();
        }
        Intent putExtra = new Intent(context, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", i).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", wxaExposedParams).putExtra("key_extra_bundle", bundle);
        if (wxaExposedParams != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("stat_scene", 6);
            bundle2.putString("stat_app_id", wxaExposedParams.appId);
            bundle2.putString("stat_url", wxaExposedParams.pageId);
            putExtra.putExtra("_stat_obj", bundle2);
        }
        putExtra.putExtra("KEY_DELEGATED_ACTIVITY_STARTER", activityStarterIpcDelegate);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(268435456);
        }
        context.startActivity(putExtra);
        AppMethodBeat.m2505o(133056);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133057);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.igi = stringExtra;
        if (C5046bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.m2505o(133057);
            return;
        }
        if (!(getIntent().getExtras() == null || getIntent().getExtras().containsKey("key_extra_bundle"))) {
            getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
        }
        getIntent().setExtrasClassLoader(getClassLoader());
        this.iIa = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        setBackBtn(new C107931());
        addIconOptionMenu(0, C25738R.string.f9169rn, C25738R.drawable.f6899uu, new C1078311());
        setMMTitle("");
        dyb();
        mo17446xE(-1);
        View inflate = LayoutInflater.from(this).inflate(2130968709, this.iHB, true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        this.iHC = (ImageView) inflate.findViewById(2131821282);
        this.iHD = (TextView) inflate.findViewById(2131821283);
        this.iHE = (TextView) inflate.findViewById(2131821285);
        this.iHF = (TextView) inflate.findViewById(2131821288);
        this.iHG = (RatingBar) inflate.findViewById(2131821289);
        this.iHH = (TextView) inflate.findViewById(2131821286);
        this.iHI = (LinearLayout) inflate.findViewById(2131821287);
        this.iFW = (ImageView) inflate.findViewById(2131821284);
        this.iHK = (LinearLayout) inflate.findViewById(2131821299);
        this.iHJ = (RecyclerView) inflate.findViewById(2131821300);
        this.iHJ.setItemAnimator(new C31895y());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        this.iHJ.setLayoutManager(linearLayoutManager);
        this.iHJ.mo66330a(new C1078518());
        this.iHL = (LinearLayout) inflate.findViewById(2131821301);
        this.iHM = (LinearLayout) inflate.findViewById(2131821302);
        this.iHN = (TextView) inflate.findViewById(2131821304);
        this.iHO = (AppBrandNearbyShowcaseView) inflate.findViewById(2131821303);
        this.iHO.setIconGap(iHq);
        this.iHO.setIconSize(iHp + (iHr * 2));
        final LinearLayout linearLayout = this.iHM;
        if (linearLayout.getVisibility() == 0) {
            linearLayout.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133040);
                    linearLayout.setVisibility(8);
                    AppMethodBeat.m2505o(133040);
                }
            }).start();
        }
        this.iHQ = (FrameLayout) inflate.findViewById(2131821292);
        this.iHR = (TextView) inflate.findViewById(2131821293);
        this.iHS = (TextView) inflate.findViewById(2131821295);
        this.iHU = (ImageView) inflate.findViewById(2131821298);
        this.iHW = (AppBrandNearbyShowcaseView) inflate.findViewById(2131821297);
        this.iHV = (LinearLayout) inflate.findViewById(2131821296);
        this.iHT = (LinearLayout) inflate.findViewById(2131821294);
        this.iHX = (TextView) inflate.findViewById(2131821310);
        this.iHP = (LinearLayout) inflate.findViewById(2131821306);
        this.iHP.setVisibility(0);
        this.iHP.setOnClickListener(new C1077519());
        View findViewById = inflate.findViewById(2131821290);
        inflate = inflate.findViewById(2131821291);
        findViewById.setOnClickListener(new C1079216());
        inflate.setOnClickListener(new C1077417());
        m18473eF(true);
        aMm();
        AppMethodBeat.m2505o(133057);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(133058);
        super.dealContentView(view);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        scrollView.setBackgroundResource(C25738R.color.f11751fv);
        scrollView.setFillViewport(true);
        this.iHB = new LinearLayout(this);
        this.iHB.setOrientation(1);
        this.iHB.setFocusable(true);
        this.iHB.setFocusableInTouchMode(true);
        scrollView.addView(this.iHB, new LayoutParams(-1, -1));
        ((FrameLayout) view).addView(scrollView);
        AppMethodBeat.m2505o(133058);
    }

    public final void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(133059);
        super.onNewIntent(intent);
        setIntent(intent);
        if (!C5046bo.isNullOrNil(this.igi)) {
            C26842p.ayH().mo10117d(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.igi = stringExtra;
        if (C5046bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.m2505o(133059);
            return;
        }
        m18473eF(true);
        aMm();
        AppMethodBeat.m2505o(133059);
    }

    public final boolean apx() {
        return true;
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(133060);
        if (VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
        m18471dl(6, 1);
        AppMethodBeat.m2505o(133060);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133061);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
        }
        C42697o.m75625a(this, new C1078620());
        AppMethodBeat.m2505o(133061);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(133062);
        super.onPause();
        C42697o.m75625a(this, new C1078721());
        AppMethodBeat.m2505o(133062);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133063);
        super.onDestroy();
        C26842p.ayH().mo10117d(this);
        AppMethodBeat.m2505o(133063);
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(133064);
        if (c4935m.hsh == 3 && (c4935m.obj instanceof String) && !C5046bo.isNullOrNil(this.igi) && this.igi.equals((String) c4935m.obj)) {
            m18473eF(false);
        }
        AppMethodBeat.m2505o(133064);
    }

    public final void initActivityCloseAnimation() {
        AppMethodBeat.m2504i(133065);
        if (this.iIb) {
            AppMethodBeat.m2505o(133065);
            return;
        }
        super.initActivityCloseAnimation();
        AppMethodBeat.m2505o(133065);
    }

    /* renamed from: dl */
    private void m18471dl(int i, int i2) {
        AppMethodBeat.m2504i(133066);
        m18469c(i, i2, C5046bo.anT());
        AppMethodBeat.m2505o(133066);
    }

    /* renamed from: c */
    private void m18469c(int i, int i2, long j) {
        AppMethodBeat.m2504i(133067);
        String str = this.iFD == null ? null : this.iFD.appId;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(133067);
            return;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", 3);
        String nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("key_scene_note"));
        int i3 = 0;
        WxaAttributes e = C42340f.auO().mo21573e(str, "appInfo", "brandIconURL", "nickname");
        if (e != null) {
            i3 = e.ayJ().fmr;
        }
        i3 += 1000;
        C4990ab.m7411d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", Integer.valueOf(13919), str, Integer.valueOf(intExtra), nullAsNil, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        C7060h.pYm.mo8381e(13919, str, Integer.valueOf(intExtra), nullAsNil, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3));
        this.iHY = intExtra;
        AppMethodBeat.m2505o(133067);
    }

    /* renamed from: eF */
    private void m18473eF(final boolean z) {
        AppMethodBeat.m2504i(133068);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(133029);
                final C45536u zh = C26842p.m42735zh(AppBrandProfileUI.this.igi);
                final long zk = C26842p.m42738zk(AppBrandProfileUI.this.igi);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(133028);
                        AppBrandProfileUI.m18463a(AppBrandProfileUI.this, zh, zk);
                        if (!(!z || AppBrandProfileUI.this.isFinishing() || AppBrandProfileUI.this.uiu)) {
                            C26842p.ayH().mo10114a(AppBrandProfileUI.this, C42677e.aNS().oAl.getLooper());
                        }
                        AppMethodBeat.m2505o(133028);
                    }
                });
                if (z) {
                    C42406r.m75080zu(AppBrandProfileUI.this.igi);
                    AppBrandProfileUI.m18460a(AppBrandProfileUI.this, 1, 1);
                }
                AppMethodBeat.m2505o(133029);
            }
        }, "AppBrandProfile");
        AppMethodBeat.m2505o(133068);
    }

    private void aMm() {
        AppMethodBeat.m2504i(133069);
        if (!C5046bo.isNullOrNil(this.igi)) {
            C4990ab.m7416i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
            ams ams = new ams();
            ams.username = this.igi;
            C1196a c1196a = new C1196a();
            c1196a.fsI = 2921;
            c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
            c1196a.fsJ = ams;
            c1196a.fsK = new amt();
            C42146b.m74301a(c1196a.acD(), new C10779a(this));
        }
        AppMethodBeat.m2505o(133069);
    }

    private void aMn() {
        AppMethodBeat.m2504i(133070);
        if (this.iHA == null || this.iHA.size() <= 0) {
            this.iHQ.setVisibility(0);
            this.iHR.setVisibility(0);
            this.iHT.setVisibility(8);
        } else {
            this.iHQ.setVisibility(0);
            this.iHT.setVisibility(0);
            this.iHR.setVisibility(8);
            this.iHW.setIconGap(iHt);
            this.iHW.setIconSize(iHs);
            this.iHW.setIconLayerCount(Math.min(this.iHA.size(), 4));
            if (this.iId == null) {
                this.iId = new C46949a(iHu);
            }
            if (this.iIe == null) {
                this.iIe = new C46949a(iHv);
            }
            int i = 0;
            while (i < this.iHW.getChildCount()) {
                String str = this.iHA.size() > i ? ((cxk) this.iHA.get(i)).nSa : null;
                C37926b abR = C37926b.abR();
                ImageView qf = this.iHW.mo54072qf(i);
                C37932f c37932f = (str == null || str.startsWith("http")) ? this.iId : this.iIe;
                abR.mo60682a(qf, str, (int) C25738R.drawable.ad2, c37932f);
                i++;
            }
            if (this.iHz != 1) {
                this.iHS.setText(String.format(getString(C25738R.string.f9022mr), new Object[]{Integer.valueOf(this.iHz)}));
            } else if (this.iHx) {
                this.iHS.setText(getString(C25738R.string.f9020mp));
            } else {
                this.iHS.setText(String.format(getString(C25738R.string.f9022mr), new Object[]{Integer.valueOf(this.iHz)}));
            }
            if (this.iHx) {
                this.iHS.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.awa, 0, 0, 0);
            } else {
                this.iHS.setCompoundDrawablesWithIntrinsicBounds(C25738R.drawable.aw_, 0, 0, 0);
            }
            if (this.iHz > 4) {
                this.iHU.setVisibility(0);
                this.iHV.setOnClickListener(new C1077212());
            } else {
                this.iHU.setVisibility(8);
                this.iHV.setOnClickListener(null);
            }
        }
        this.iHR.setOnClickListener(new C1079713());
        this.iHS.setOnClickListener(new C1079014());
        AppMethodBeat.m2505o(133070);
    }

    /* renamed from: a */
    static /* synthetic */ void m18459a(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.m2504i(133071);
        if (appBrandProfileUI.iHZ == null || !appBrandProfileUI.iHZ.isShowing()) {
            appBrandProfileUI.iHZ = new C36356d(appBrandProfileUI, 1, false);
            appBrandProfileUI.iHZ.rBl = new C107892();
            appBrandProfileUI.iHZ.rBm = new C107983();
        }
        appBrandProfileUI.iHZ.cpD();
        AppMethodBeat.m2505o(133071);
    }

    /* renamed from: b */
    static /* synthetic */ void m18467b(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.m2504i(133072);
        if (appBrandProfileUI.iFD != null) {
            Bundle bundleExtra = appBrandProfileUI.getIntent().getBundleExtra("_stat_obj");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            appBrandStatObject.cOq = C19693f.m30514h(appBrandStatObject.scene, bundleExtra);
            appBrandStatObject.cOr = C19693f.m30515i(appBrandStatObject.scene, bundleExtra);
            if (appBrandProfileUI.getIntent().getIntExtra("key_from_scene", 3) == 7) {
                appBrandStatObject.cOq = 14;
                appBrandStatObject.cOr = appBrandProfileUI.getIntent().getStringExtra("key_scene_note");
                bundleExtra = appBrandProfileUI.getIntent().getBundleExtra("key_extra_bundle");
                if (!(bundleExtra == null || bundleExtra.getParcelable("key_recommend_stat_obj") == null)) {
                    AppBrandRecommendStatObj appBrandRecommendStatObj = (AppBrandRecommendStatObj) bundleExtra.getParcelable("key_recommend_stat_obj");
                    C4990ab.m7416i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "recommendStatObj is got!");
                    if (appBrandRecommendStatObj != null) {
                        C42371i.m74963b(2, 0, 0, appBrandRecommendStatObj);
                    }
                }
            }
            ActivityStarterIpcDelegate activityStarterIpcDelegate = (ActivityStarterIpcDelegate) appBrandProfileUI.getIntent().getParcelableExtra("KEY_DELEGATED_ACTIVITY_STARTER");
            LaunchParcel launchParcel = new LaunchParcel();
            launchParcel.username = appBrandProfileUI.iFD.username;
            launchParcel.har = 0;
            launchParcel.ijy = appBrandStatObject;
            launchParcel.ifP = activityStarterIpcDelegate;
            C10600f.ijT.mo33002a(appBrandProfileUI, launchParcel);
            appBrandProfileUI.m18471dl(4, 1);
            if (appBrandStatObject.cOq == 6) {
                appBrandProfileUI.iIb = true;
                appBrandProfileUI.finish();
            }
        }
        AppMethodBeat.m2505o(133072);
    }

    /* renamed from: a */
    static /* synthetic */ void m18465a(AppBrandProfileUI appBrandProfileUI, String str, String str2, String[] strArr) {
        AppMethodBeat.m2504i(133077);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(133077);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str2);
        intent.putExtra("thumbUrl", str);
        intent.putExtra("urlList", strArr);
        intent.putExtra("isFromWebView", false);
        intent.putExtra("shouldShowScanQrCodeMenu", false);
        Context context = appBrandProfileUI;
        C25985d.m41453a(context, "subapp", ".ui.gallery.GestureGalleryUI", intent, CdnLogic.kBizGeneric & appBrandProfileUI.hashCode(), false);
        appBrandProfileUI.m18471dl(14, 1);
        AppMethodBeat.m2505o(133077);
    }

    /* renamed from: g */
    static /* synthetic */ void m18475g(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.m2504i(133079);
        if (appBrandProfileUI.iFD == null || C5046bo.isNullOrNil(appBrandProfileUI.iFD.appId)) {
            C4990ab.m7412e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "jumpToLikeWall, attrs is null or appid is null");
            AppMethodBeat.m2505o(133079);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "jumpToLikeWall, path:%s", String.format("pages/like/like.html?appid=%s", new Object[]{appBrandProfileUI.iFD.appId}));
        AppCompatActivity appCompatActivity = appBrandProfileUI.mController.ylL;
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if ((appCompatActivity instanceof Activity) && appCompatActivity.getIntent() != null) {
            Bundle bundleExtra = appCompatActivity.getIntent().getBundleExtra("_stat_obj");
            appBrandStatObject.cOq = C19693f.m30514h(appBrandStatObject.scene, bundleExtra);
            appBrandStatObject.cOr = C19693f.m30515i(appBrandStatObject.scene, bundleExtra);
        }
        C10600f.ijT.mo33003a(appBrandProfileUI, "gh_af145dc05189@app", "wxbfac0b7aca45dd68", r4, 0, -1, appBrandStatObject, null, null);
        appBrandProfileUI.m18471dl(19, 1);
        AppMethodBeat.m2505o(133079);
    }

    /* renamed from: h */
    static /* synthetic */ void m18476h(AppBrandProfileUI appBrandProfileUI) {
        int i = 1;
        AppMethodBeat.m2504i(133080);
        if (appBrandProfileUI.iFD == null || C5046bo.isNullOrNil(appBrandProfileUI.iFD.username)) {
            AppMethodBeat.m2505o(133080);
            return;
        }
        appBrandProfileUI.iHy = !appBrandProfileUI.iHx;
        cki cki = new cki();
        if (!appBrandProfileUI.iHy) {
            i = 2;
        }
        cki.xin = i;
        cki.username = appBrandProfileUI.iFD.username;
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2521;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
        c1196a.fsJ = cki;
        c1196a.fsK = new ckj();
        C42146b.m74301a(c1196a.acD(), new C10780b(appBrandProfileUI));
        AppMethodBeat.m2505o(133080);
    }
}
