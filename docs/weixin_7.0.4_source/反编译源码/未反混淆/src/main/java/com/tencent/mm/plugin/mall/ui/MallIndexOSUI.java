package com.tencent.mm.plugin.mall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.mall.a.h;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.util.ActUtil;

public class MallIndexOSUI extends MallIndexBaseUI {
    private boolean eTM = false;
    private View jNV = null;
    private long lastUpdateTime = 0;
    private a[] omO = new a[4];
    private ag omP = new ag();
    private TextView omQ = null;
    private boolean omR = false;
    private long omS = 0;
    private boolean omT = false;
    private boolean omU = false;
    private String omV = "";
    private int omW = 0;
    private c omX = new c<vo>() {
        {
            AppMethodBeat.i(43177);
            this.xxI = vo.class.getName().hashCode();
            AppMethodBeat.o(43177);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(43178);
            ab.i("MicroMsg.MallIndexOSUI", "WebViewCloseWindowEventListener %s", ((vo) bVar).cSB.clP);
            if (MallIndexOSUI.this.omV != null && MallIndexOSUI.this.omV.equals(r7.cSB.clP)) {
                MallIndexOSUI.this.omT = true;
            }
            AppMethodBeat.o(43178);
            return false;
        }
    };
    private c omY = new c<vr>() {
        {
            AppMethodBeat.i(43180);
            this.xxI = vr.class.getName().hashCode();
            AppMethodBeat.o(43180);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(43181);
            ab.i("MicroMsg.MallIndexOSUI", "WebViewUIDestroyEvent %s isCloseWindow %s", ((vr) bVar).cSE.clP, Boolean.valueOf(MallIndexOSUI.this.omT));
            if (MallIndexOSUI.this.omV != null && MallIndexOSUI.this.omV.equals(r8.cSE.clP)) {
                MallIndexOSUI.this.omU = true;
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(43179);
                        if (!MallIndexOSUI.this.omT) {
                            MallIndexOSUI.this.finish();
                        }
                        AppMethodBeat.o(43179);
                    }
                }, 500);
            }
            AppMethodBeat.o(43181);
            return false;
        }
    };

    class a {
        public TextView eku;
        public CdnImageView oll;
        public TextView ong;
        public View view;

        a() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallIndexOSUI() {
        AppMethodBeat.i(43187);
        AppMethodBeat.o(43187);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43188);
        c.iR(false);
        a.a(this, false, false);
        this.ylm = true;
        super.onCreate(bundle);
        this.jNV = View.inflate(this, R.layout.abg, null);
        this.jNV.setClickable(false);
        this.jNV.setEnabled(false);
        this.omQ = (TextView) this.jNV.findViewById(R.id.d2x);
        this.omP = r.cPO().Ht(this.okT);
        nf(1577);
        ab.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        m hVar = new h();
        if (this.omP != null) {
            boolean z;
            ag agVar = this.omP;
            if (agVar.tCG == null || agVar.tCG.wmz == null || agVar.tCG.wmz.size() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                a(hVar, false, false);
                AppMethodBeat.o(43188);
                return;
            }
        }
        a(hVar, true, false);
        AppMethodBeat.o(43188);
    }

    public final void initView() {
        AppMethodBeat.i(43189);
        super.initView();
        this.omu.setOnScrollListener(new OnScrollListener() {
            boolean cLR = ah.getContext().getSharedPreferences(ah.doA() + "_redesign", com.tencent.mm.compatible.util.h.Mu()).getBoolean("dark_actionbar", false);
            int color;
            final int maxHeight = com.tencent.mm.bz.a.fromDPToPix(MallIndexOSUI.this.mController.ylL, 200);
            final int minHeight = com.tencent.mm.bz.a.fromDPToPix(MallIndexOSUI.this.mController.ylL, 50);
            int onb;

            {
                AppMethodBeat.i(43182);
                this.onb = this.cLR ? R.color.l8 : R.color.vy;
                this.color = MallIndexOSUI.this.mController.ylL.getResources().getColor(this.onb);
                AppMethodBeat.o(43182);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int i4 = 0;
                AppMethodBeat.i(43183);
                if (absListView.getChildCount() == 0) {
                    AppMethodBeat.o(43183);
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
                            MallIndexOSUI.this.xE(MallIndexOSUI.this.mController.ylL.getResources().getColor(R.color.a3p));
                        } else {
                            MallIndexOSUI.this.xE(com.tencent.mm.ui.ah.dJ(this.color, i4));
                        }
                    }
                    MallIndexOSUI.this.omW = i4;
                    AppMethodBeat.o(43183);
                }
                i4 = 100;
                if (MallIndexOSUI.this.omW != i4) {
                }
                MallIndexOSUI.this.omW = i4;
                AppMethodBeat.o(43183);
            }
        });
        AppMethodBeat.o(43189);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNh() {
        AppMethodBeat.i(43190);
        e.a(this.omz, "1", this.omP.tCL, this.omP.nYG);
        bNc();
        AppMethodBeat.o(43190);
    }

    public final void a(MallFunction mallFunction, int i) {
        AppMethodBeat.i(43191);
        super.a(mallFunction, i);
        com.tencent.mm.plugin.report.service.h.pYm.e(13720, mallFunction.nmz, Long.valueOf(bo.anl(mallFunction.pFP)));
        AppMethodBeat.o(43191);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFY() {
        AppMethodBeat.i(43192);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.ul));
        }
        if (d.iW(21)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.a4q));
        }
        if (VERSION.SDK_INT >= 16) {
            getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        }
        xE(this.mController.ylL.getResources().getColor(R.color.a3p));
        AppMethodBeat.o(43192);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bbC() {
        AppMethodBeat.i(43193);
        String str = this.omP.tCJ;
        String str2 = this.omP.tCK;
        setMMTitle(str);
        if (!bo.isNullOrNil(str2)) {
            setMMSubTitle(str2);
        }
        AppMethodBeat.o(43193);
    }

    /* Access modifiers changed, original: protected|final */
    public final void initHeaderView() {
        AppMethodBeat.i(43194);
        this.omD = v.hu(this).inflate(R.layout.abn, null);
        this.omu.addHeaderView(this.omD);
        LayoutParams layoutParams = (LayoutParams) this.omD.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        layoutParams.height = a.bMX();
        this.omD.setLayoutParams(layoutParams);
        AppMethodBeat.o(43194);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bGb() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void dp(View view) {
        AppMethodBeat.i(43195);
        this.omO[0] = new a();
        this.omO[0].view = view.findViewById(R.id.d3d);
        this.omO[0].oll = (CdnImageView) view.findViewById(R.id.d3e);
        this.omO[0].eku = (TextView) view.findViewById(R.id.d3f);
        this.omO[0].ong = (TextView) view.findViewById(R.id.d3g);
        this.omO[0].oll.setVisibility(4);
        this.omO[1] = new a();
        this.omO[1].view = view.findViewById(R.id.d3h);
        this.omO[1].oll = (CdnImageView) view.findViewById(R.id.d3i);
        this.omO[1].eku = (TextView) view.findViewById(R.id.d3j);
        this.omO[1].ong = (TextView) view.findViewById(R.id.d3k);
        this.omO[1].oll.setVisibility(4);
        this.omO[2] = new a();
        this.omO[2].view = view.findViewById(R.id.d3q);
        this.omO[2].oll = (CdnImageView) view.findViewById(R.id.d3r);
        this.omO[2].eku = (TextView) view.findViewById(R.id.d3s);
        this.omO[2].ong = (TextView) view.findViewById(R.id.d3u);
        this.omO[2].oll.setVisibility(4);
        this.omO[3] = new a();
        this.omO[3].view = view.findViewById(R.id.d3m);
        this.omO[3].oll = (CdnImageView) view.findViewById(R.id.d3n);
        this.omO[3].eku = (TextView) view.findViewById(R.id.d3o);
        this.omO[3].oll.setVisibility(4);
        this.omO[3].view.setVisibility(8);
        AppMethodBeat.o(43195);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNa() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNb() {
    }

    public void onResume() {
        AppMethodBeat.i(43196);
        super.onResume();
        ab.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", Integer.valueOf(g.Nu().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis()));
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (g.Nu().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            a(new h(), false, false);
        }
        bbC();
        AppMethodBeat.o(43196);
    }

    public void onPause() {
        AppMethodBeat.i(43197);
        super.onPause();
        AppMethodBeat.o(43197);
    }

    public void onDestroy() {
        AppMethodBeat.i(43198);
        super.onDestroy();
        ng(1577);
        this.omX.dead();
        this.omY.dead();
        AppMethodBeat.o(43198);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bNd() {
        AppMethodBeat.i(43199);
        csg csg = this.omP.tCG;
        for (int i = 0; i < this.omO.length; i++) {
            this.omO[i].view.setVisibility(8);
            this.omO[i].oll.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < csg.wmz.size() && i2 < this.omO.length) {
            final csh csh = (csh) csg.wmz.get(i2);
            this.omO[i2].view.setVisibility(0);
            this.omO[i2].oll.setUrl(aa.a(csh.xpE));
            this.omO[i2].oll.setVisibility(0);
            this.omO[i2].eku.setText(aa.a(csh.xpD));
            ab.i("MicroMsg.MallIndexOSUI", "item %d url %s", Integer.valueOf(i2), aa.a(csh.xpE));
            this.omO[i2].ong.setVisibility(8);
            String a = aa.a(csh.xpG);
            if (!bo.isNullOrNil(a)) {
                this.omO[i2].ong.setText(a);
                this.omO[i2].ong.setVisibility(0);
            }
            this.omO[i2].view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(43184);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13867, aa.a(csh.xpF), Integer.valueOf(MallIndexOSUI.this.okT));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aa.a(csh.xpF));
                    intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.bp.d.b(MallIndexOSUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(43184);
                }
            });
            i2++;
        }
        if (!(this.omu == null || this.jNV == null || this.omR)) {
            this.omu.addFooterView(this.jNV);
            this.omR = true;
        }
        if (!bo.isNullOrNil(this.omP.tCM)) {
            this.omQ.setText(this.omP.tCM);
            this.omQ.setVisibility(0);
        }
        AppMethodBeat.o(43199);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNi() {
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNm() {
    }

    public void finish() {
        AppMethodBeat.i(43201);
        this.eTM = true;
        super.finish();
        AppMethodBeat.o(43201);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43202);
        super.c(i, i2, str, mVar);
        if (mVar.getType() == 1577) {
            int i3;
            h hVar = (h) mVar;
            if (hVar.okW == null) {
                i3 = 0;
            } else {
                i3 = hVar.okW.xpH;
            }
            if (i3 == 1 && !bo.isNullOrNil(hVar.bMU())) {
                if (this.eTM) {
                    AppMethodBeat.o(43202);
                    return true;
                } else if (System.currentTimeMillis() - this.omS > 500) {
                    this.omS = System.currentTimeMillis();
                    this.omX.dnU();
                    this.omY.dnU();
                    Bundle bundle = new Bundle();
                    this.omV = hVar.bMU();
                    Intent intent = new Intent();
                    ab.i("MicroMsg.MallIndexOSUI", "startWebViewUI %s", this.omV);
                    bundle.putString("KoriginUrl", this.omV);
                    bundle.putBoolean("KIsHKAgreeUrl", true);
                    intent.putExtra("rawUrl", this.omV);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.bp.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 4);
                }
            }
            this.omP = r.cPO().Ht(this.okT);
            bNh();
            bNd();
            bbC();
        }
        AppMethodBeat.o(43202);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(43203);
        ab.i("MicroMsg.MallIndexOSUI", "onActivityResult requestCode %s resultCode %s", Integer.valueOf(i), Integer.valueOf(i2));
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(43203);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNk() {
        AppMethodBeat.i(43200);
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] strArr;
                AppMethodBeat.i(43186);
                final csl csl = MallIndexOSUI.this.omP.tCH;
                final boolean z = MallIndexOSUI.this.omP.tCI;
                if (z) {
                    strArr = new String[(csl.wmz.size() + 1)];
                    strArr[csl.wmz.size()] = MallIndexOSUI.this.getString(R.string.fgc);
                } else {
                    strArr = new String[csl.wmz.size()];
                }
                for (int i = 0; i < csl.wmz.size(); i++) {
                    strArr[i] = aa.a(((csm) csl.wmz.get(i)).xpD);
                }
                com.tencent.mm.ui.base.h.a(MallIndexOSUI.this.mController.ylL, null, strArr, null, false, new com.tencent.mm.ui.base.h.c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(43185);
                        if (i < csl.wmz.size()) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", aa.a(((csm) csl.wmz.get(i)).xpN));
                            com.tencent.mm.bp.d.b(MallIndexOSUI.this, "webview", ".ui.tools.WebViewUI", intent);
                            AppMethodBeat.o(43185);
                            return;
                        }
                        if (z) {
                            com.tencent.mm.bp.d.c(MallIndexOSUI.this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
                        }
                        AppMethodBeat.o(43185);
                    }
                });
                AppMethodBeat.o(43186);
                return true;
            }
        });
        AppMethodBeat.o(43200);
    }
}
