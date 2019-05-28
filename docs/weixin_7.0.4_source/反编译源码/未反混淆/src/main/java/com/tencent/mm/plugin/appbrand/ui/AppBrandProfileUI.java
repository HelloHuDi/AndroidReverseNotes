package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.y;
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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appusage.a.i;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.ams;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class AppBrandProfileUI extends MMActivity implements com.tencent.mm.sdk.e.k.a {
    private static final int iHp = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 24);
    private static final int iHq = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 20);
    private static final int iHr = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 2);
    private static final int iHs = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 40);
    private static final int iHt = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 44);
    private static final int iHu = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 32);
    private static final int iHv = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 4);
    private u iFD;
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
    private d iHZ;
    private long iHw = 0;
    private boolean iHx = false;
    private boolean iHy = false;
    private int iHz = 0;
    private WxaExposedParams iIa;
    private boolean iIb = false;
    private f iIc;
    private f iId;
    private f iIe;
    private String igi;

    static class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
        WeakReference<AppBrandProfileUI> iIm;

        public a(AppBrandProfileUI appBrandProfileUI) {
            AppMethodBeat.i(133049);
            this.iIm = new WeakReference(appBrandProfileUI);
            AppMethodBeat.o(133049);
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
            AppMethodBeat.i(133050);
            if (!(this.iIm == null || this.iIm.get() == null)) {
                if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof amt)) {
                    ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request success");
                    final amt amt = (amt) bVar.fsH.fsP;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133048);
                            if (!(a.this.iIm == null || a.this.iIm.get() == null)) {
                                AppBrandProfileUI.a((AppBrandProfileUI) a.this.iIm.get(), amt);
                            }
                            AppMethodBeat.o(133048);
                        }
                    });
                    AppMethodBeat.o(133050);
                    return;
                }
                ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile, request fail");
            }
            AppMethodBeat.o(133050);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
        WeakReference<AppBrandProfileUI> iIm;

        public b(AppBrandProfileUI appBrandProfileUI) {
            AppMethodBeat.i(133053);
            this.iIm = new WeakReference(appBrandProfileUI);
            AppMethodBeat.o(133053);
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
            AppMethodBeat.i(133054);
            if (!(this.iIm == null || this.iIm.get() == null)) {
                if (i == 0 && i2 == 0 && bVar != null && bVar.fsH.fsP != null && (bVar.fsH.fsP instanceof ckj)) {
                    ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request success");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133051);
                            if (!(b.this.iIm == null || b.this.iIm.get() == null)) {
                                AppBrandProfileUI appBrandProfileUI = (AppBrandProfileUI) b.this.iIm.get();
                                if (appBrandProfileUI.iHx) {
                                    appBrandProfileUI.iHA.removeFirst();
                                    appBrandProfileUI.iHz = appBrandProfileUI.iHz - 1;
                                } else {
                                    cxk cxk = new cxk();
                                    cxk.xsL = true;
                                    cxk.nSa = com.tencent.mm.ah.b.pX(r.Yz());
                                    cxk.nickname = r.YB();
                                    appBrandProfileUI.iHA.addFirst(cxk);
                                    appBrandProfileUI.iHz = appBrandProfileUI.iHz + 1;
                                }
                                appBrandProfileUI.iHx = !appBrandProfileUI.iHx;
                                AppBrandProfileUI.m(appBrandProfileUI);
                                if (appBrandProfileUI.iHy) {
                                    AppBrandProfileUI.a(appBrandProfileUI, 17, 1);
                                    AppMethodBeat.o(133051);
                                    return;
                                }
                                AppBrandProfileUI.a(appBrandProfileUI, 18, 1);
                            }
                            AppMethodBeat.o(133051);
                        }
                    });
                    AppMethodBeat.o(133054);
                    return;
                }
                ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "cgiUpdateUserLike, request fail");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133052);
                        if (!(b.this.iIm == null || b.this.iIm.get() == null)) {
                            AppBrandProfileUI appBrandProfileUI = (AppBrandProfileUI) b.this.iIm.get();
                            if (appBrandProfileUI.iHy) {
                                Toast.makeText(appBrandProfileUI, R.string.mo, 0).show();
                                AppBrandProfileUI.a(appBrandProfileUI, 17, 2);
                                AppMethodBeat.o(133052);
                                return;
                            }
                            Toast.makeText(appBrandProfileUI, R.string.ml, 0).show();
                            AppBrandProfileUI.a(appBrandProfileUI, 18, 2);
                        }
                        AppMethodBeat.o(133052);
                    }
                });
            }
            AppMethodBeat.o(133054);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandProfileUI() {
        AppMethodBeat.i(133055);
        AppMethodBeat.o(133055);
    }

    static /* synthetic */ void m(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(133081);
        appBrandProfileUI.aMn();
        AppMethodBeat.o(133081);
    }

    static {
        AppMethodBeat.i(133082);
        AppMethodBeat.o(133082);
    }

    public static void a(Context context, String str, int i, String str2, WxaExposedParams wxaExposedParams, Bundle bundle, ActivityStarterIpcDelegate activityStarterIpcDelegate) {
        AppMethodBeat.i(133056);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(133056);
            return;
        }
        if (context == null) {
            context = ah.getContext();
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
        AppMethodBeat.o(133056);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(133057);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.igi = stringExtra;
        if (bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(133057);
            return;
        }
        if (!(getIntent().getExtras() == null || getIntent().getExtras().containsKey("key_extra_bundle"))) {
            getIntent().getExtras().putBundle("key_extra_bundle", Bundle.EMPTY);
        }
        getIntent().setExtrasClassLoader(getClassLoader());
        this.iIa = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(133025);
                AppBrandProfileUI.this.onBackPressed();
                AppMethodBeat.o(133025);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.rn, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(133036);
                AppBrandProfileUI.a(AppBrandProfileUI.this);
                AppMethodBeat.o(133036);
                return true;
            }
        });
        setMMTitle("");
        dyb();
        xE(-1);
        View inflate = LayoutInflater.from(this).inflate(R.layout.cw, this.iHB, true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        this.iHC = (ImageView) inflate.findViewById(R.id.t9);
        this.iHD = (TextView) inflate.findViewById(R.id.t_);
        this.iHE = (TextView) inflate.findViewById(R.id.tb);
        this.iHF = (TextView) inflate.findViewById(R.id.te);
        this.iHG = (RatingBar) inflate.findViewById(R.id.tf);
        this.iHH = (TextView) inflate.findViewById(R.id.tc);
        this.iHI = (LinearLayout) inflate.findViewById(R.id.td);
        this.iFW = (ImageView) inflate.findViewById(R.id.ta);
        this.iHK = (LinearLayout) inflate.findViewById(R.id.tp);
        this.iHJ = (RecyclerView) inflate.findViewById(R.id.tq);
        this.iHJ.setItemAnimator(new y());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        this.iHJ.setLayoutManager(linearLayoutManager);
        this.iHJ.a(new h() {
            public final void a(Rect rect, View view, RecyclerView recyclerView, s sVar) {
                AppMethodBeat.i(133043);
                int al = com.tencent.mm.bz.a.al(AppBrandProfileUI.this, R.dimen.ss);
                int al2 = com.tencent.mm.bz.a.al(AppBrandProfileUI.this, R.dimen.sn);
                if (RecyclerView.bo(view) == 0) {
                    rect.left = al;
                } else {
                    rect.left = 0;
                }
                rect.right = al2;
                AppMethodBeat.o(133043);
            }
        });
        this.iHL = (LinearLayout) inflate.findViewById(R.id.tr);
        this.iHM = (LinearLayout) inflate.findViewById(R.id.ts);
        this.iHN = (TextView) inflate.findViewById(R.id.tu);
        this.iHO = (AppBrandNearbyShowcaseView) inflate.findViewById(R.id.tt);
        this.iHO.setIconGap(iHq);
        this.iHO.setIconSize(iHp + (iHr * 2));
        final LinearLayout linearLayout = this.iHM;
        if (linearLayout.getVisibility() == 0) {
            linearLayout.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133040);
                    linearLayout.setVisibility(8);
                    AppMethodBeat.o(133040);
                }
            }).start();
        }
        this.iHQ = (FrameLayout) inflate.findViewById(R.id.ti);
        this.iHR = (TextView) inflate.findViewById(R.id.tj);
        this.iHS = (TextView) inflate.findViewById(R.id.tl);
        this.iHU = (ImageView) inflate.findViewById(R.id.to);
        this.iHW = (AppBrandNearbyShowcaseView) inflate.findViewById(R.id.tn);
        this.iHV = (LinearLayout) inflate.findViewById(R.id.tm);
        this.iHT = (LinearLayout) inflate.findViewById(R.id.tk);
        this.iHX = (TextView) inflate.findViewById(R.id.u0);
        this.iHP = (LinearLayout) inflate.findViewById(R.id.tw);
        this.iHP.setVisibility(0);
        this.iHP.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133044);
                if (AppBrandProfileUI.this.iIa == null) {
                    ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "wxaExposedParams is null");
                    AppMethodBeat.o(133044);
                    return;
                }
                Intent intent = new Intent();
                ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "feedbackUrl:%s, wxaExposedParams:%s", v.a(AppBrandProfileUI.this.iIa), AppBrandProfileUI.this.iIa.toString());
                intent.putExtra("title", view.getContext().getString(R.string.mn));
                intent.putExtra("rawUrl", r1);
                intent.putExtra("forceHideShare", true);
                com.tencent.mm.bp.d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppBrandProfileUI.a(AppBrandProfileUI.this, 20, 1);
                AppMethodBeat.o(133044);
            }
        });
        View findViewById = inflate.findViewById(R.id.tg);
        inflate = inflate.findViewById(R.id.th);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133041);
                AppBrandProfileUI.b(AppBrandProfileUI.this);
                AppMethodBeat.o(133041);
            }
        });
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133042);
                AppBrandProfileUI.a(AppBrandProfileUI.this, view);
                AppMethodBeat.o(133042);
            }
        });
        eF(true);
        aMm();
        AppMethodBeat.o(133057);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void dealContentView(View view) {
        AppMethodBeat.i(133058);
        super.dealContentView(view);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        scrollView.setBackgroundResource(R.color.fv);
        scrollView.setFillViewport(true);
        this.iHB = new LinearLayout(this);
        this.iHB.setOrientation(1);
        this.iHB.setFocusable(true);
        this.iHB.setFocusableInTouchMode(true);
        scrollView.addView(this.iHB, new LayoutParams(-1, -1));
        ((FrameLayout) view).addView(scrollView);
        AppMethodBeat.o(133058);
    }

    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(133059);
        super.onNewIntent(intent);
        setIntent(intent);
        if (!bo.isNullOrNil(this.igi)) {
            p.ayH().d(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.igi = stringExtra;
        if (bo.isNullOrNil(stringExtra)) {
            finish();
            AppMethodBeat.o(133059);
            return;
        }
        eF(true);
        aMm();
        AppMethodBeat.o(133059);
    }

    public final boolean apx() {
        return true;
    }

    public final void onBackPressed() {
        AppMethodBeat.i(133060);
        if (VERSION.SDK_INT >= 21) {
            super.finishAfterTransition();
        } else {
            super.finish();
        }
        dl(6, 1);
        AppMethodBeat.o(133060);
    }

    public final void onResume() {
        AppMethodBeat.i(133061);
        super.onResume();
        if (getSwipeBackLayout() != null) {
            getSwipeBackLayout().setEnableGesture(getIntent().getBooleanExtra("key_can_swipe_back", true));
        }
        o.a(this, new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ui.statusbar.b>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(133045);
                ((com.tencent.mm.ui.statusbar.b) obj).setLayoutFrozen(false);
                Void voidR = zXH;
                AppMethodBeat.o(133045);
                return voidR;
            }
        });
        AppMethodBeat.o(133061);
    }

    public final void onPause() {
        AppMethodBeat.i(133062);
        super.onPause();
        o.a(this, new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ui.statusbar.b>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(133046);
                ((com.tencent.mm.ui.statusbar.b) obj).setLayoutFrozen(true);
                Void voidR = zXH;
                AppMethodBeat.o(133046);
                return voidR;
            }
        });
        AppMethodBeat.o(133062);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133063);
        super.onDestroy();
        p.ayH().d(this);
        AppMethodBeat.o(133063);
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(133064);
        if (mVar.hsh == 3 && (mVar.obj instanceof String) && !bo.isNullOrNil(this.igi) && this.igi.equals((String) mVar.obj)) {
            eF(false);
        }
        AppMethodBeat.o(133064);
    }

    public final void initActivityCloseAnimation() {
        AppMethodBeat.i(133065);
        if (this.iIb) {
            AppMethodBeat.o(133065);
            return;
        }
        super.initActivityCloseAnimation();
        AppMethodBeat.o(133065);
    }

    private void dl(int i, int i2) {
        AppMethodBeat.i(133066);
        c(i, i2, bo.anT());
        AppMethodBeat.o(133066);
    }

    private void c(int i, int i2, long j) {
        AppMethodBeat.i(133067);
        String str = this.iFD == null ? null : this.iFD.appId;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(133067);
            return;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", 3);
        String nullAsNil = bo.nullAsNil(getIntent().getStringExtra("key_scene_note"));
        int i3 = 0;
        WxaAttributes e = com.tencent.mm.plugin.appbrand.app.f.auO().e(str, "appInfo", "brandIconURL", "nickname");
        if (e != null) {
            i3 = e.ayJ().fmr;
        }
        i3 += 1000;
        ab.d("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s, appType %s", Integer.valueOf(13919), str, Integer.valueOf(intExtra), nullAsNil, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.plugin.report.service.h.pYm.e(13919, str, Integer.valueOf(intExtra), nullAsNil, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3));
        this.iHY = intExtra;
        AppMethodBeat.o(133067);
    }

    private void eF(final boolean z) {
        AppMethodBeat.i(133068);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133029);
                final u zh = p.zh(AppBrandProfileUI.this.igi);
                final long zk = p.zk(AppBrandProfileUI.this.igi);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133028);
                        AppBrandProfileUI.a(AppBrandProfileUI.this, zh, zk);
                        if (!(!z || AppBrandProfileUI.this.isFinishing() || AppBrandProfileUI.this.uiu)) {
                            p.ayH().a(AppBrandProfileUI.this, e.aNS().oAl.getLooper());
                        }
                        AppMethodBeat.o(133028);
                    }
                });
                if (z) {
                    com.tencent.mm.plugin.appbrand.config.r.zu(AppBrandProfileUI.this.igi);
                    AppBrandProfileUI.a(AppBrandProfileUI.this, 1, 1);
                }
                AppMethodBeat.o(133029);
            }
        }, "AppBrandProfile");
        AppMethodBeat.o(133068);
    }

    private void aMm() {
        AppMethodBeat.i(133069);
        if (!bo.isNullOrNil(this.igi)) {
            ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "queryProfile start");
            ams ams = new ams();
            ams.username = this.igi;
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsI = 2921;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getprofileinfo";
            aVar.fsJ = ams;
            aVar.fsK = new amt();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), new a(this));
        }
        AppMethodBeat.o(133069);
    }

    private void aMn() {
        AppMethodBeat.i(133070);
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
                this.iId = new com.tencent.mm.plugin.appbrand.ui.b.a(iHu);
            }
            if (this.iIe == null) {
                this.iIe = new com.tencent.mm.plugin.appbrand.ui.b.a(iHv);
            }
            int i = 0;
            while (i < this.iHW.getChildCount()) {
                String str = this.iHA.size() > i ? ((cxk) this.iHA.get(i)).nSa : null;
                com.tencent.mm.modelappbrand.a.b abR = com.tencent.mm.modelappbrand.a.b.abR();
                ImageView qf = this.iHW.qf(i);
                f fVar = (str == null || str.startsWith("http")) ? this.iId : this.iIe;
                abR.a(qf, str, (int) R.drawable.ad2, fVar);
                i++;
            }
            if (this.iHz != 1) {
                this.iHS.setText(String.format(getString(R.string.mr), new Object[]{Integer.valueOf(this.iHz)}));
            } else if (this.iHx) {
                this.iHS.setText(getString(R.string.mp));
            } else {
                this.iHS.setText(String.format(getString(R.string.mr), new Object[]{Integer.valueOf(this.iHz)}));
            }
            if (this.iHx) {
                this.iHS.setCompoundDrawablesWithIntrinsicBounds(R.drawable.awa, 0, 0, 0);
            } else {
                this.iHS.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aw_, 0, 0, 0);
            }
            if (this.iHz > 4) {
                this.iHU.setVisibility(0);
                this.iHV.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(133037);
                        AppBrandProfileUI.g(AppBrandProfileUI.this);
                        AppMethodBeat.o(133037);
                    }
                });
            } else {
                this.iHU.setVisibility(8);
                this.iHV.setOnClickListener(null);
            }
        }
        this.iHR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133038);
                AppBrandProfileUI.h(AppBrandProfileUI.this);
                AppMethodBeat.o(133038);
            }
        });
        this.iHS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133039);
                AppBrandProfileUI.h(AppBrandProfileUI.this);
                AppMethodBeat.o(133039);
            }
        });
        AppMethodBeat.o(133070);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(133071);
        if (appBrandProfileUI.iHZ == null || !appBrandProfileUI.iHZ.isShowing()) {
            appBrandProfileUI.iHZ = new d(appBrandProfileUI, 1, false);
            appBrandProfileUI.iHZ.rBl = new c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(133026);
                    lVar.clear();
                    lVar.hi(4, ((af) g.K(af.class)).aB(AppBrandProfileUI.this.igi, 0) ? R.string.od : R.string.oa);
                    lVar.hi(2, R.string.h2);
                    if (AppBrandProfileUI.this.iFD != null && AppBrandProfileUI.this.iFD.bQl == 0) {
                        lVar.hi(5, R.string.mq);
                    }
                    AppMethodBeat.o(133026);
                }
            };
            appBrandProfileUI.iHZ.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(133027);
                    switch (menuItem.getItemId()) {
                        case 2:
                            com.tencent.mm.bp.d.b(AppBrandProfileUI.this, "appbrand", ".ui.AppBrandAuthorizeUI", new Intent(AppBrandProfileUI.this, AppBrandAuthorizeUI.class).putExtra("key_username", AppBrandProfileUI.this.igi));
                            AppBrandProfileUI.a(AppBrandProfileUI.this, 10, 1);
                            AppMethodBeat.o(133027);
                            return;
                        case 4:
                            boolean aB = ((af) g.K(af.class)).aB(AppBrandProfileUI.this.igi, 0);
                            AppBrandProfileUI.a(AppBrandProfileUI.this, aB ? 12 : 11, com.tencent.mm.plugin.appbrand.ui.collection.h.a(aB, AppBrandProfileUI.this, AppBrandProfileUI.this.igi, 0) ? 1 : 2);
                            AppMethodBeat.o(133027);
                            return;
                        case 5:
                            if (!(AppBrandProfileUI.this.iFD == null || bo.isNullOrNil(AppBrandProfileUI.this.iFD.appId))) {
                                com.tencent.mm.bp.d.b(AppBrandProfileUI.this, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", v.xg(AppBrandProfileUI.this.iFD.appId)).putExtra("forceHideShare", true));
                                AppBrandProfileUI.a(AppBrandProfileUI.this, 16, 1);
                                break;
                            }
                    }
                    AppMethodBeat.o(133027);
                }
            };
        }
        appBrandProfileUI.iHZ.cpD();
        AppMethodBeat.o(133071);
    }

    static /* synthetic */ void b(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(133072);
        if (appBrandProfileUI.iFD != null) {
            Bundle bundleExtra = appBrandProfileUI.getIntent().getBundleExtra("_stat_obj");
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            appBrandStatObject.cOq = com.tencent.mm.plugin.appbrand.report.f.h(appBrandStatObject.scene, bundleExtra);
            appBrandStatObject.cOr = com.tencent.mm.plugin.appbrand.report.f.i(appBrandStatObject.scene, bundleExtra);
            if (appBrandProfileUI.getIntent().getIntExtra("key_from_scene", 3) == 7) {
                appBrandStatObject.cOq = 14;
                appBrandStatObject.cOr = appBrandProfileUI.getIntent().getStringExtra("key_scene_note");
                bundleExtra = appBrandProfileUI.getIntent().getBundleExtra("key_extra_bundle");
                if (!(bundleExtra == null || bundleExtra.getParcelable("key_recommend_stat_obj") == null)) {
                    AppBrandRecommendStatObj appBrandRecommendStatObj = (AppBrandRecommendStatObj) bundleExtra.getParcelable("key_recommend_stat_obj");
                    ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "recommendStatObj is got!");
                    if (appBrandRecommendStatObj != null) {
                        i.b(2, 0, 0, appBrandRecommendStatObj);
                    }
                }
            }
            ActivityStarterIpcDelegate activityStarterIpcDelegate = (ActivityStarterIpcDelegate) appBrandProfileUI.getIntent().getParcelableExtra("KEY_DELEGATED_ACTIVITY_STARTER");
            LaunchParcel launchParcel = new LaunchParcel();
            launchParcel.username = appBrandProfileUI.iFD.username;
            launchParcel.har = 0;
            launchParcel.ijy = appBrandStatObject;
            launchParcel.ifP = activityStarterIpcDelegate;
            com.tencent.mm.plugin.appbrand.launching.precondition.f.ijT.a(appBrandProfileUI, launchParcel);
            appBrandProfileUI.dl(4, 1);
            if (appBrandStatObject.cOq == 6) {
                appBrandProfileUI.iIb = true;
                appBrandProfileUI.finish();
            }
        }
        AppMethodBeat.o(133072);
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, String str, String str2, String[] strArr) {
        AppMethodBeat.i(133077);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(133077);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("nowUrl", str2);
        intent.putExtra("thumbUrl", str);
        intent.putExtra("urlList", strArr);
        intent.putExtra("isFromWebView", false);
        intent.putExtra("shouldShowScanQrCodeMenu", false);
        Context context = appBrandProfileUI;
        com.tencent.mm.bp.d.a(context, "subapp", ".ui.gallery.GestureGalleryUI", intent, CdnLogic.kBizGeneric & appBrandProfileUI.hashCode(), false);
        appBrandProfileUI.dl(14, 1);
        AppMethodBeat.o(133077);
    }

    static /* synthetic */ void g(AppBrandProfileUI appBrandProfileUI) {
        AppMethodBeat.i(133079);
        if (appBrandProfileUI.iFD == null || bo.isNullOrNil(appBrandProfileUI.iFD.appId)) {
            ab.e("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "jumpToLikeWall, attrs is null or appid is null");
            AppMethodBeat.o(133079);
            return;
        }
        ab.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "jumpToLikeWall, path:%s", String.format("pages/like/like.html?appid=%s", new Object[]{appBrandProfileUI.iFD.appId}));
        AppCompatActivity appCompatActivity = appBrandProfileUI.mController.ylL;
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if ((appCompatActivity instanceof Activity) && appCompatActivity.getIntent() != null) {
            Bundle bundleExtra = appCompatActivity.getIntent().getBundleExtra("_stat_obj");
            appBrandStatObject.cOq = com.tencent.mm.plugin.appbrand.report.f.h(appBrandStatObject.scene, bundleExtra);
            appBrandStatObject.cOr = com.tencent.mm.plugin.appbrand.report.f.i(appBrandStatObject.scene, bundleExtra);
        }
        com.tencent.mm.plugin.appbrand.launching.precondition.f.ijT.a(appBrandProfileUI, "gh_af145dc05189@app", "wxbfac0b7aca45dd68", r4, 0, -1, appBrandStatObject, null, null);
        appBrandProfileUI.dl(19, 1);
        AppMethodBeat.o(133079);
    }

    static /* synthetic */ void h(AppBrandProfileUI appBrandProfileUI) {
        int i = 1;
        AppMethodBeat.i(133080);
        if (appBrandProfileUI.iFD == null || bo.isNullOrNil(appBrandProfileUI.iFD.username)) {
            AppMethodBeat.o(133080);
            return;
        }
        appBrandProfileUI.iHy = !appBrandProfileUI.iHx;
        cki cki = new cki();
        if (!appBrandProfileUI.iHy) {
            i = 2;
        }
        cki.xin = i;
        cki.username = appBrandProfileUI.iFD.username;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsI = 2521;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
        aVar.fsJ = cki;
        aVar.fsK = new ckj();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), new b(appBrandProfileUI));
        AppMethodBeat.o(133080);
    }
}
