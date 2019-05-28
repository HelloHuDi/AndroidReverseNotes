package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.on;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.d;
import com.tencent.mm.plugin.mall.a.f;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.l;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class MallIndexBaseUI extends WalletBaseUI implements a, l {
    protected String eCq;
    private String ocK = null;
    private String okO = null;
    private ArrayList<MallFunction> okP = null;
    protected int okT;
    private int omA = 0;
    private boolean omB = true;
    protected int omC;
    protected View omD;
    protected View omE;
    private boolean omF = false;
    private TextView omt = null;
    protected ListView omu = null;
    private b omv = null;
    protected ImageView omw = null;
    protected ImageView omx;
    protected TextView omy = null;
    protected TextView omz;

    public abstract void bFY();

    public abstract void bGb();

    public abstract void bNa();

    public abstract void bNb();

    public abstract boolean bNd();

    public abstract void bNh();

    public abstract void bNi();

    public abstract void bNk();

    public abstract void bNm();

    public abstract void bbC();

    public abstract void dp(View view);

    public abstract void initHeaderView();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.abp;
    }

    public void onCreate(Bundle bundle) {
        ab.i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!g.RK()) {
            ab.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        g.RQ();
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        this.okT = getIntent().getIntExtra("key_wallet_region", intValue);
        this.eCq = getIntent().getStringExtra("key_uuid");
        if (!bo.isNullOrNil(this.eCq)) {
            this.eCq = UUID.randomUUID().toString();
        }
        nf(d.CTRL_INDEX);
        r.cPP();
        ae.a(this);
        this.okO = getIntent().getStringExtra("key_func_id");
        ab.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.okO + " wallet_region: " + this.okT + " walletType: " + com.tencent.mm.model.r.YG() + " default_region: " + intValue);
        this.ocK = getIntent().getStringExtra("key_native_url");
        ab.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.ocK);
        if (!bwP()) {
            bFY();
            AM(0);
            ab.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            bbC();
            initView();
            c.cQW();
            bNa();
            ab.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            bNb();
            if (com.tencent.mm.model.r.YM()) {
                ab.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                com.tencent.mm.pluginsdk.l lVar = (com.tencent.mm.pluginsdk.l) g.K(com.tencent.mm.pluginsdk.l.class);
                if (lVar != null) {
                    ab.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    lVar.bxd();
                } else {
                    ab.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            z.hL(1, 0);
            h.pYm.e(11850, Integer.valueOf(1), Integer.valueOf(0));
        }
    }

    public final void bht() {
    }

    public final boolean bwP() {
        if (bo.isNullOrNil(this.okO) && bo.isNullOrNil(this.ocK)) {
            return false;
        }
        return true;
    }

    public void onResume() {
        int i = 1;
        super.onResume();
        i.Lt(1);
        ab.i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!g.RK()) {
            ab.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (bwP()) {
            this.okP = j.bMV().ym(this.okT);
            if (this.okP == null || this.okP.size() <= 0) {
                ab.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !bo.isNullOrNil(this.ocK)) {
                        a(new f(this.okT, b.cQS(), 0), true, false);
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    a(new f(this.okT, b.cQS(), getIntent().getStringExtra("key_app_id"), this.okO, stringExtra), true, false);
                    return;
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.MallIndexBaseUI", e, "", new Object[0]);
                    bNg();
                    return;
                }
            }
            MallFunction cm = cm(this.okP);
            if (cm == null) {
                cm = cn(this.okP);
            }
            a(cm, -1);
            finish();
            return;
        }
        bNd();
        ab.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
        if (j.bMV().ym(this.okT) == null) {
            a(new f(this.okT, b.cQS(), 0), true, false);
            ab.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
            i = 0;
        } else {
            a(new f(this.okT, b.cQS(), 1), false, false);
            this.okP = j.bMV().ym(this.okT);
        }
        if (i != 0) {
            ab.i("MicroMsg.MallIndexBaseUI", "has data");
            cu();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNc() {
        if (this.omz.getVisibility() == 0) {
            a.a(this, true, false);
            LayoutParams layoutParams = (LayoutParams) this.omD.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            layoutParams.height = a.bMX();
            this.omD.setLayoutParams(layoutParams);
        }
    }

    private void bNe() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.omu.getChildCount() != 0) {
            ab.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", Boolean.valueOf(booleanExtra), Integer.valueOf(this.omu.getFirstVisiblePosition()), Integer.valueOf(this.omu.getChildAt(0).getTop()));
            if (this.omu.getFirstVisiblePosition() == 0 && r2 == 0 && booleanExtra && !this.omF && this.okP != null) {
                this.omF = true;
                int headerViewsCount = this.omu.getHeaderViewsCount() + this.omv.getCount();
                List list = this.omv.olz;
                if (list != null) {
                    for (int size = list.size() - 1; size > 0; size--) {
                        Iterator it = ((ArrayList) list.get(size)).iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar != null && cVar.omd != null && b.a(cVar.omd)) {
                                ab.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", Integer.valueOf(this.omu.getFirstVisiblePosition()), Integer.valueOf(this.omu.getLastVisiblePosition()), Integer.valueOf(headerViewsCount));
                                if (headerViewsCount < this.omu.getFirstVisiblePosition() || headerViewsCount > r1) {
                                    size = a.bMY();
                                    int bMX = (a.bMX() + (a.bMW() * (headerViewsCount + 1))) + size;
                                    if (headerViewsCount > 2) {
                                        bMX += size;
                                    }
                                    if (headerViewsCount > 3) {
                                        bMX += size;
                                    }
                                    size = (bMX + (a.bMW() / 3)) - this.omu.getScrollY();
                                    bMX = com.tencent.mm.ui.ae.hy(this).y;
                                    if (com.tencent.mm.ui.ae.hw(this)) {
                                        bMX -= com.tencent.mm.ui.ae.fr(this);
                                    }
                                    if (getSupportActionBar() != null) {
                                        bMX -= getSupportActionBar().getHeight();
                                    }
                                    this.omu.smoothScrollBy(size - bMX, 1000);
                                    return;
                                }
                                return;
                            }
                        }
                        headerViewsCount--;
                    }
                }
            }
        }
    }

    public void a(MallFunction mallFunction, int i) {
        int i2;
        if (mallFunction != null && i >= 0) {
            String str = "";
            if (!(mallFunction.tDn == null || bo.isNullOrNil(mallFunction.tDn.ssr))) {
                str = mallFunction.tDn.ssr;
            }
            int size = this.okP == null ? 0 : this.okP.size();
            boolean a = b.a(mallFunction);
            h hVar = h.pYm;
            Object[] objArr = new Object[6];
            objArr[0] = mallFunction.pFP;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = str;
            if (a) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            objArr[5] = Integer.valueOf(i2);
            hVar.e(10881, objArr);
        }
        if (mallFunction == null || bo.isNullOrNil(mallFunction.cRS) || !((com.tencent.mm.plugin.appbrand.service.f) g.K(com.tencent.mm.plugin.appbrand.service.f.class)).Cl(mallFunction.cRS)) {
            if (mallFunction != null) {
                c.cQT().acI(mallFunction.pFP);
                com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().acI(mallFunction.pFP);
                if (mallFunction.tDn != null) {
                    c.cQT();
                    c.e(mallFunction);
                }
                if ("wxpay://bizmall/mobile_recharge".equals(mallFunction.cRS)) {
                    i2 = 0;
                } else if ("wxpay://bizmall/weixin_hongbao".equals(mallFunction.cRS)) {
                    i2 = 4;
                } else if ("wxpay://bizmall/weixin_scan_qrcode".equals(mallFunction.cRS)) {
                    i2 = 8;
                } else if ("wxpay://bizmall/weixin_transfer".equals(mallFunction.cRS)) {
                    i2 = 5;
                } else if ("wxpay://bizmall/weixin_offline_pay".equals(mallFunction.cRS)) {
                    i2 = 6;
                } else if ("wxpay://bizmall/old_mobile_recharge".equals(mallFunction.cRS)) {
                    i2 = 7;
                } else if (!bo.isNullOrNil(mallFunction.nmz)) {
                    i2 = 1;
                } else if ("wxpay://bizmall/f2f_hongbao".equals(mallFunction.cRS)) {
                    i2 = 9;
                } else {
                    ab.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            ab.i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(i2)));
            Intent intent;
            switch (i2) {
                case 0:
                    intent = new Intent();
                    if (bwP()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bp.d.b((Context) this, "recharge", ".ui.PhoneRechargeUI", intent);
                    z.hL(15, 0);
                    return;
                case 1:
                    g.RQ();
                    this.okT = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    intent = new Intent();
                    intent.putExtra("rawUrl", mallFunction.nmz);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.r.Yz());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra("KPublisherId", "pay_wallet");
                    intent.putExtra("key_download_restrict", mallFunction.tDp);
                    intent.putExtra("key_wallet_region", this.okT);
                    intent.putExtra("key_function_id", mallFunction.pFP);
                    intent.putExtra("geta8key_scene", 46);
                    com.tencent.mm.bp.d.b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    ab.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    ab.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    t.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    h.pYm.e(11701, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    intent = new Intent();
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.bp.d.b((Context) this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent);
                    z.hL(13, 0);
                    h.pYm.e(11850, Integer.valueOf(4), Integer.valueOf(0));
                    return;
                case 5:
                    h.pYm.e(11458, Integer.valueOf(1));
                    if (com.tencent.mm.model.r.YM()) {
                        List linkedList = new LinkedList();
                        List linkedList2 = new LinkedList();
                        linkedList.add(getString(R.string.dqi));
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(getString(R.string.asx));
                        linkedList2.add(Integer.valueOf(1));
                        com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.do4), linkedList, linkedList2, null, true, new com.tencent.mm.ui.base.h.d() {
                            public final void bV(int i, int i2) {
                                AppMethodBeat.i(43168);
                                switch (i2) {
                                    case 0:
                                        h.pYm.e(11458, Integer.valueOf(2));
                                        if (com.tencent.mm.model.r.YM()) {
                                            com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.mController.ylL, "PayURemittanceProcess", null);
                                            AppMethodBeat.o(43168);
                                            return;
                                        }
                                        com.tencent.mm.wallet_core.a.b(MallIndexBaseUI.this.mController.ylL, "RemittanceProcess", null);
                                        AppMethodBeat.o(43168);
                                        return;
                                    case 1:
                                        h.pYm.e(11458, Integer.valueOf(3));
                                        com.tencent.mm.pluginsdk.wallet.h.ai(MallIndexBaseUI.this, 2);
                                        break;
                                }
                                AppMethodBeat.o(43168);
                            }
                        });
                    } else {
                        g.RQ();
                        if (((Boolean) g.RP().Ry().get(ac.a.USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                            bNj();
                        } else {
                            g.RQ();
                            g.RP().Ry().set(ac.a.USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN, Boolean.TRUE);
                            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fg5), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(43169);
                                    MallIndexBaseUI.this.bNj();
                                    AppMethodBeat.o(43169);
                                }
                            });
                        }
                    }
                    z.hL(14, 0);
                    h.pYm.e(11850, Integer.valueOf(3), Integer.valueOf(0));
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.bp.d.b(this.mController.ylL, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    z.hL(9, 0);
                    h.pYm.e(11850, Integer.valueOf(5), Integer.valueOf(0));
                    return;
                case 7:
                    intent = new Intent();
                    if (bwP()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bp.d.b((Context) this, "recharge", ".ui.RechargeUI", intent);
                    return;
                case 8:
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    com.tencent.mm.bp.d.b(this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                    return;
                case 9:
                    com.tencent.mm.bp.d.H(this.mController.ylL, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    return;
                default:
                    return;
            }
        }
        ab.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", mallFunction.cRS);
        c.cQT().acI(mallFunction.pFP);
        com.tencent.mm.plugin.wallet_core.model.mall.d.cQX().acI(mallFunction.pFP);
        if (mallFunction.tDn != null) {
            c.cQT();
            c.e(mallFunction);
        }
    }

    public void onDestroy() {
        ng(d.CTRL_INDEX);
        r.cPP();
        ae.b(this);
        super.onDestroy();
    }

    public boolean c(int i, int i2, String str, m mVar) {
        ab.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.b.a) {
            ab.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i != 0 || i2 != 0) {
                finish();
                return true;
            } else if (this.omB) {
                this.omB = false;
                if (r.cPE().cRh().cQi()) {
                    com.tencent.mm.wallet_core.a.b((Activity) this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (mVar.getType()) {
            case d.CTRL_INDEX /*495*/:
                f fVar = (f) mVar;
                if (fVar.okT != this.okT) {
                    ab.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", Integer.valueOf(this.okT), Integer.valueOf(fVar.okT));
                }
                if (bwP()) {
                    ab.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0 && fVar.okP != null) {
                        MallFunction cm;
                        if (getIntent().getIntExtra("key_scene", 0) == 1) {
                            cm = cm(fVar.okP);
                            if (cm != null) {
                                a(cm, -1);
                            }
                        } else if (!bo.isNullOrNil(this.ocK)) {
                            ab.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", this.ocK);
                            cm = cn(fVar.okP);
                            if (cm != null) {
                                a(cm, -1);
                            } else {
                                bNg();
                                return true;
                            }
                        } else if (fVar.okP != null && fVar.okP.size() > 0) {
                            ab.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                            a(cm(fVar.okP), -1);
                        } else if (j.bMV().ym(this.okT) == null || j.bMV().ym(this.okT).size() <= 0) {
                            ab.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                        } else {
                            ab.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                            a(cm(j.bMV().ym(this.okT)), -1);
                        }
                        setResult(-1);
                        finish();
                        return true;
                    }
                    bNg();
                    return true;
                }
                if (i == 0 && i2 == 0 && j.bMV().ym(this.okT) != null && fVar.okP != null) {
                    this.okP = j.bMV().ym(this.okT);
                    ab.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.okT + " " + this.okP.size());
                    c.cQT().X(this.okP);
                }
                cu();
                bNe();
                bGb();
                return true;
            default:
                return false;
        }
    }

    private MallFunction cm(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.okO)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            MallFunction mallFunction = (MallFunction) list.get(i2);
            if (mallFunction != null && this.okO.equals(mallFunction.pFP)) {
                return mallFunction;
            }
            i = i2 + 1;
        }
    }

    private MallFunction cn(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.ocK)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            MallFunction mallFunction = (MallFunction) list.get(i2);
            if (mallFunction != null && this.ocK.equals(mallFunction.cRS)) {
                return mallFunction;
            }
            i = i2 + 1;
        }
    }

    public final boolean bwQ() {
        if (!bwP()) {
            cu();
        }
        return true;
    }

    public final boolean bNf() {
        return false;
    }

    public final void m(String str, Bitmap bitmap) {
    }

    private void bNg() {
        setResult(0);
        finish();
    }

    public final void cu() {
        showOptionMenu(true);
        this.omv.J(this.okP);
        bNi();
        bNk();
        bNl();
        bNm();
    }

    public void onStop() {
        super.onStop();
    }

    public void initView() {
        ab.d("MicroMsg.MallIndexBaseUI", "index initView");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(43165);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 3);
                com.tencent.mm.bp.d.f(MallIndexBaseUI.this, "com.tencent.mm.ui.LauncherUI", intent);
                MallIndexBaseUI.this.finish();
                if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
                    h.pYm.e(14954, com.tencent.mm.pluginsdk.wallet.f.dlI(), "open_wcpay_specific_view:ok");
                    com.tencent.mm.pluginsdk.wallet.f.dlJ();
                }
                h.pYm.e(14419, MallIndexBaseUI.this.eCq, Integer.valueOf(6));
                ab.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
                AppMethodBeat.o(43165);
                return true;
            }
        });
        this.omu = (ListView) findViewById(R.id.d3w);
        initHeaderView();
        bGb();
        this.omv = new b(this, this.okT);
        this.omu.setAdapter(this.omv);
        this.omv.olA = new b.d() {
            public final void a(final int i, final MallFunction mallFunction) {
                AppMethodBeat.i(43167);
                if (mallFunction != null) {
                    int i2;
                    String str = mallFunction.pFP;
                    if (bo.isNullOrNil(str)) {
                        i2 = 1;
                    } else {
                        g.RQ();
                        String str2 = (String) g.RP().Ry().get(ac.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, null);
                        if (bo.isNullOrNil(str2)) {
                            i2 = 0;
                        } else {
                            String[] split = str2.split(",");
                            if (split == null || split.length == 0) {
                                i2 = 0;
                            } else {
                                for (String equals : split) {
                                    if (equals.equals(str)) {
                                        i2 = 1;
                                        break;
                                    }
                                }
                                i2 = 0;
                            }
                        }
                    }
                    if (i2 != 0 || bo.isNullOrNil(mallFunction.tDo)) {
                        MallIndexBaseUI.this.a(mallFunction, i);
                    } else {
                        ab.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", mallFunction.pFP);
                        com.tencent.mm.ui.base.h.a(MallIndexBaseUI.this.mController.ylL, mallFunction.tDo, MallIndexBaseUI.this.getString(R.string.cyo), MallIndexBaseUI.this.getString(R.string.dpi), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Object obj = null;
                                AppMethodBeat.i(43166);
                                String str = mallFunction.pFP;
                                if (!bo.isNullOrNil(str)) {
                                    g.RQ();
                                    Object obj2 = (String) g.RP().Ry().get(ac.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, null);
                                    if (bo.isNullOrNil(obj2)) {
                                        obj2 = str;
                                    } else {
                                        String[] split = obj2.split(",");
                                        if (split == null || split.length == 0) {
                                            String obj22 = str;
                                        } else {
                                            for (String equals : split) {
                                                if (equals.equals(str)) {
                                                    obj = 1;
                                                    break;
                                                }
                                            }
                                            if (obj == null) {
                                                obj22 = obj22 + "," + str;
                                            }
                                        }
                                    }
                                    g.RQ();
                                    g.RP().Ry().set(ac.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, obj22);
                                }
                                MallIndexBaseUI.this.a(mallFunction, i);
                                AppMethodBeat.o(43166);
                            }
                        });
                    }
                    ab.d("MicroMsg.MallIndexBaseUI", "type: %s", Integer.valueOf(mallFunction.type));
                    h.pYm.e(14419, MallIndexBaseUI.this.eCq, Integer.valueOf(4), Integer.valueOf(mallFunction.type));
                    AppMethodBeat.o(43167);
                    return;
                }
                ab.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", Integer.valueOf(i));
                AppMethodBeat.o(43167);
            }
        };
        dp(this.omD);
        this.omz = (TextView) findViewById(R.id.a2f);
        bNh();
    }

    private void bNj() {
        if (com.tencent.mm.model.r.YM()) {
            com.tencent.mm.wallet_core.a.b(this.mController.ylL, "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        com.tencent.mm.wallet_core.a.b(this.mController.ylL, "RemittanceProcess", bundle);
    }

    public void finish() {
        super.finish();
    }

    private void bNl() {
        if (this.omt != null) {
            this.omt.setVisibility(8);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final void yq(int i) {
        if (i == 12 && this.omy != null) {
            bNi();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            g.RQ();
            this.okT = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (com.tencent.mm.model.r.YN()) {
                finish();
                return;
            }
            finish();
            on onVar = new on();
            onVar.cKQ.context = this.mController.ylL;
            com.tencent.mm.sdk.b.a.xxA.m(onVar);
        }
    }
}
