package com.tencent.p177mm.plugin.mall.p451ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C26263vo;
import com.tencent.p177mm.p230g.p231a.C37814vr;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.mall.p450a.C21261h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C43806ag;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.csg;
import com.tencent.p177mm.protocal.protobuf.csh;
import com.tencent.p177mm.protocal.protobuf.csl;
import com.tencent.p177mm.protocal.protobuf.csm;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.ttpic.util.ActUtil;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI */
public class MallIndexOSUI extends MallIndexBaseUI {
    private boolean eTM = false;
    private View jNV = null;
    private long lastUpdateTime = 0;
    private C3439a[] omO = new C3439a[4];
    private C43806ag omP = new C43806ag();
    private TextView omQ = null;
    private boolean omR = false;
    private long omS = 0;
    private boolean omT = false;
    private boolean omU = false;
    private String omV = "";
    private int omW = 0;
    private C4884c omX = new C34331();
    private C4884c omY = new C34342();

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI$1 */
    class C34331 extends C4884c<C26263vo> {
        C34331() {
            AppMethodBeat.m2504i(43177);
            this.xxI = C26263vo.class.getName().hashCode();
            AppMethodBeat.m2505o(43177);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43178);
            C4990ab.m7417i("MicroMsg.MallIndexOSUI", "WebViewCloseWindowEventListener %s", ((C26263vo) c4883b).cSB.clP);
            if (MallIndexOSUI.this.omV != null && MallIndexOSUI.this.omV.equals(r7.cSB.clP)) {
                MallIndexOSUI.this.omT = true;
            }
            AppMethodBeat.m2505o(43178);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI$2 */
    class C34342 extends C4884c<C37814vr> {

        /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI$2$1 */
        class C34351 implements Runnable {
            C34351() {
            }

            public final void run() {
                AppMethodBeat.m2504i(43179);
                if (!MallIndexOSUI.this.omT) {
                    MallIndexOSUI.this.finish();
                }
                AppMethodBeat.m2505o(43179);
            }
        }

        C34342() {
            AppMethodBeat.m2504i(43180);
            this.xxI = C37814vr.class.getName().hashCode();
            AppMethodBeat.m2505o(43180);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43181);
            C4990ab.m7417i("MicroMsg.MallIndexOSUI", "WebViewUIDestroyEvent %s isCloseWindow %s", ((C37814vr) c4883b).cSE.clP, Boolean.valueOf(MallIndexOSUI.this.omT));
            if (MallIndexOSUI.this.omV != null && MallIndexOSUI.this.omV.equals(r8.cSE.clP)) {
                MallIndexOSUI.this.omU = true;
                C5004al.m7442n(new C34351(), 500);
            }
            AppMethodBeat.m2505o(43181);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI$3 */
    class C34363 implements OnScrollListener {
        boolean cLR = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", C1448h.m3078Mu()).getBoolean("dark_actionbar", false);
        int color;
        final int maxHeight = C1338a.fromDPToPix(MallIndexOSUI.this.mController.ylL, 200);
        final int minHeight = C1338a.fromDPToPix(MallIndexOSUI.this.mController.ylL, 50);
        int onb;

        C34363() {
            AppMethodBeat.m2504i(43182);
            this.onb = this.cLR ? C25738R.color.f11906l8 : C25738R.color.f12206vy;
            this.color = MallIndexOSUI.this.mController.ylL.getResources().getColor(this.onb);
            AppMethodBeat.m2505o(43182);
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            int i4 = 0;
            AppMethodBeat.m2504i(43183);
            if (absListView.getChildCount() == 0) {
                AppMethodBeat.m2505o(43183);
                return;
            }
            if (i == 0) {
                int abs = Math.abs(absListView.getChildAt(0).getTop());
                if (abs > this.minHeight) {
                    if (abs < this.maxHeight) {
                        i4 = ((abs - this.minHeight) * 100) / (this.maxHeight - this.minHeight);
                    }
                }
                if (MallIndexOSUI.this.omW != i4) {
                    if (i4 <= 0) {
                        MallIndexOSUI.this.mo17446xE(MallIndexOSUI.this.mController.ylL.getResources().getColor(C25738R.color.a3p));
                    } else {
                        MallIndexOSUI.this.mo17446xE(C5225ah.m7960dJ(this.color, i4));
                    }
                }
                MallIndexOSUI.this.omW = i4;
                AppMethodBeat.m2505o(43183);
            }
            i4 = 100;
            if (MallIndexOSUI.this.omW != i4) {
            }
            MallIndexOSUI.this.omW = i4;
            AppMethodBeat.m2505o(43183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI$5 */
    class C34375 implements OnMenuItemClickListener {
        C34375() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            String[] strArr;
            AppMethodBeat.m2504i(43186);
            final csl csl = MallIndexOSUI.this.omP.tCH;
            final boolean z = MallIndexOSUI.this.omP.tCI;
            if (z) {
                strArr = new String[(csl.wmz.size() + 1)];
                strArr[csl.wmz.size()] = MallIndexOSUI.this.getString(C25738R.string.fgc);
            } else {
                strArr = new String[csl.wmz.size()];
            }
            for (int i = 0; i < csl.wmz.size(); i++) {
                strArr[i] = C1946aa.m4147a(((csm) csl.wmz.get(i)).xpD);
            }
            C30379h.m48424a(MallIndexOSUI.this.mController.ylL, null, strArr, null, false, new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    AppMethodBeat.m2504i(43185);
                    if (i < csl.wmz.size()) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", C1946aa.m4147a(((csm) csl.wmz.get(i)).xpN));
                        C25985d.m41467b(MallIndexOSUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.m2505o(43185);
                        return;
                    }
                    if (z) {
                        C25985d.m41471c(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                    }
                    AppMethodBeat.m2505o(43185);
                }
            });
            AppMethodBeat.m2505o(43186);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexOSUI$a */
    class C3439a {
        public TextView eku;
        public CdnImageView oll;
        public TextView ong;
        public View view;

        C3439a() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallIndexOSUI() {
        AppMethodBeat.m2504i(43187);
        AppMethodBeat.m2505o(43187);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43188);
        C46068c.m85830iR(false);
        C43291a.m77161a(this, false, false);
        this.ylm = true;
        super.onCreate(bundle);
        this.jNV = View.inflate(this, 2130970029, null);
        this.jNV.setClickable(false);
        this.jNV.setEnabled(false);
        this.omQ = (TextView) this.jNV.findViewById(2131825757);
        this.omP = C14241r.cPO().mo38095Ht(this.okT);
        mo39992nf(1577);
        C4990ab.m7416i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        C1207m c21261h = new C21261h();
        if (this.omP != null) {
            boolean z;
            C43806ag c43806ag = this.omP;
            if (c43806ag.tCG == null || c43806ag.tCG.wmz == null || c43806ag.tCG.wmz.size() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                mo39970a(c21261h, false, false);
                AppMethodBeat.m2505o(43188);
                return;
            }
        }
        mo39970a(c21261h, true, false);
        AppMethodBeat.m2505o(43188);
    }

    public final void initView() {
        AppMethodBeat.m2504i(43189);
        super.initView();
        this.omu.setOnScrollListener(new C34363());
        AppMethodBeat.m2505o(43189);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNh() {
        AppMethodBeat.m2504i(43190);
        C36391e.m59985a(this.omz, "1", this.omP.tCL, this.omP.nYG);
        bNc();
        AppMethodBeat.m2505o(43190);
    }

    /* renamed from: a */
    public final void mo7874a(MallFunction mallFunction, int i) {
        AppMethodBeat.m2504i(43191);
        super.mo7874a(mallFunction, i);
        C7060h.pYm.mo8381e(13720, mallFunction.nmz, Long.valueOf(C5046bo.anl(mallFunction.pFP)));
        AppMethodBeat.m2505o(43191);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
        AppMethodBeat.m2504i(43192);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(C25738R.color.f12165ul));
        }
        if (C1443d.m3068iW(21)) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.a4q));
        }
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        }
        mo17446xE(this.mController.ylL.getResources().getColor(C25738R.color.a3p));
        AppMethodBeat.m2505o(43192);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bbC() {
        AppMethodBeat.m2504i(43193);
        String str = this.omP.tCJ;
        String str2 = this.omP.tCK;
        setMMTitle(str);
        if (!C5046bo.isNullOrNil(str2)) {
            setMMSubTitle(str2);
        }
        AppMethodBeat.m2505o(43193);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initHeaderView() {
        AppMethodBeat.m2504i(43194);
        this.omD = C5616v.m8409hu(this).inflate(2130970036, null);
        this.omu.addHeaderView(this.omD);
        LayoutParams layoutParams = (LayoutParams) this.omD.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = C43291a.bMX();
        this.omD.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(43194);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bGb() {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dp */
    public final void mo7886dp(View view) {
        AppMethodBeat.m2504i(43195);
        this.omO[0] = new C3439a();
        this.omO[0].view = view.findViewById(2131825774);
        this.omO[0].oll = (CdnImageView) view.findViewById(2131825775);
        this.omO[0].eku = (TextView) view.findViewById(2131825776);
        this.omO[0].ong = (TextView) view.findViewById(2131825777);
        this.omO[0].oll.setVisibility(4);
        this.omO[1] = new C3439a();
        this.omO[1].view = view.findViewById(2131825778);
        this.omO[1].oll = (CdnImageView) view.findViewById(2131825779);
        this.omO[1].eku = (TextView) view.findViewById(2131825780);
        this.omO[1].ong = (TextView) view.findViewById(2131825781);
        this.omO[1].oll.setVisibility(4);
        this.omO[2] = new C3439a();
        this.omO[2].view = view.findViewById(2131825787);
        this.omO[2].oll = (CdnImageView) view.findViewById(2131825788);
        this.omO[2].eku = (TextView) view.findViewById(2131825789);
        this.omO[2].ong = (TextView) view.findViewById(2131825791);
        this.omO[2].oll.setVisibility(4);
        this.omO[3] = new C3439a();
        this.omO[3].view = view.findViewById(2131825783);
        this.omO[3].oll = (CdnImageView) view.findViewById(2131825784);
        this.omO[3].eku = (TextView) view.findViewById(2131825785);
        this.omO[3].oll.setVisibility(4);
        this.omO[3].view.setVisibility(8);
        AppMethodBeat.m2505o(43195);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNa() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNb() {
    }

    public void onResume() {
        AppMethodBeat.m2504i(43196);
        super.onResume();
        C4990ab.m7411d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", Integer.valueOf(C26373g.m41964Nu().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (C26373g.m41964Nu().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            mo39970a(new C21261h(), false, false);
        }
        bbC();
        AppMethodBeat.m2505o(43196);
    }

    public void onPause() {
        AppMethodBeat.m2504i(43197);
        super.onPause();
        AppMethodBeat.m2505o(43197);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43198);
        super.onDestroy();
        mo39993ng(1577);
        this.omX.dead();
        this.omY.dead();
        AppMethodBeat.m2505o(43198);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bNd() {
        AppMethodBeat.m2504i(43199);
        csg csg = this.omP.tCG;
        for (int i = 0; i < this.omO.length; i++) {
            this.omO[i].view.setVisibility(8);
            this.omO[i].oll.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < csg.wmz.size() && i2 < this.omO.length) {
            final csh csh = (csh) csg.wmz.get(i2);
            this.omO[i2].view.setVisibility(0);
            this.omO[i2].oll.setUrl(C1946aa.m4147a(csh.xpE));
            this.omO[i2].oll.setVisibility(0);
            this.omO[i2].eku.setText(C1946aa.m4147a(csh.xpD));
            C4990ab.m7417i("MicroMsg.MallIndexOSUI", "item %d url %s", Integer.valueOf(i2), C1946aa.m4147a(csh.xpE));
            this.omO[i2].ong.setVisibility(8);
            String a = C1946aa.m4147a(csh.xpG);
            if (!C5046bo.isNullOrNil(a)) {
                this.omO[i2].ong.setText(a);
                this.omO[i2].ong.setVisibility(0);
            }
            this.omO[i2].view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(43184);
                    C7060h.pYm.mo8381e(13867, C1946aa.m4147a(csh.xpF), Integer.valueOf(MallIndexOSUI.this.okT));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", C1946aa.m4147a(csh.xpF));
                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                    intent.putExtra("pay_channel", 1);
                    C25985d.m41467b(MallIndexOSUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(43184);
                }
            });
            i2++;
        }
        if (!(this.omu == null || this.jNV == null || this.omR)) {
            this.omu.addFooterView(this.jNV);
            this.omR = true;
        }
        if (!C5046bo.isNullOrNil(this.omP.tCM)) {
            this.omQ.setText(this.omP.tCM);
            this.omQ.setVisibility(0);
        }
        AppMethodBeat.m2505o(43199);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNi() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNm() {
    }

    public void finish() {
        AppMethodBeat.m2504i(43201);
        this.eTM = true;
        super.finish();
        AppMethodBeat.m2505o(43201);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43202);
        super.mo7885c(i, i2, str, c1207m);
        if (c1207m.getType() == 1577) {
            int i3;
            C21261h c21261h = (C21261h) c1207m;
            if (c21261h.okW == null) {
                i3 = 0;
            } else {
                i3 = c21261h.okW.xpH;
            }
            if (i3 == 1 && !C5046bo.isNullOrNil(c21261h.bMU())) {
                if (this.eTM) {
                    AppMethodBeat.m2505o(43202);
                    return true;
                } else if (System.currentTimeMillis() - this.omS > 500) {
                    this.omS = System.currentTimeMillis();
                    this.omX.dnU();
                    this.omY.dnU();
                    Bundle bundle = new Bundle();
                    this.omV = c21261h.bMU();
                    Intent intent = new Intent();
                    C4990ab.m7417i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", this.omV);
                    bundle.putString("KoriginUrl", this.omV);
                    bundle.putBoolean("KIsHKAgreeUrl", true);
                    intent.putExtra("rawUrl", this.omV);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                    intent.putExtra("pay_channel", 1);
                    C25985d.m41468b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 4);
                }
            }
            this.omP = C14241r.cPO().mo38095Ht(this.okT);
            bNh();
            bNd();
            bbC();
        }
        AppMethodBeat.m2505o(43202);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(43203);
        C4990ab.m7417i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", Integer.valueOf(i), Integer.valueOf(i2));
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(43203);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNk() {
        AppMethodBeat.m2504i(43200);
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C34375());
        AppMethodBeat.m2505o(43200);
    }
}
