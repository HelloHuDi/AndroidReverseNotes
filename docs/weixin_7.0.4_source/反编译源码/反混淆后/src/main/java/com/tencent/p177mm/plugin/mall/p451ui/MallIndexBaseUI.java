package com.tencent.p177mm.plugin.mall.p451ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C6533on;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C33253d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.mall.p450a.C12480f;
import com.tencent.p177mm.plugin.mall.p450a.C43288j;
import com.tencent.p177mm.plugin.mall.p451ui.C39355b.C28478c;
import com.tencent.p177mm.plugin.mall.p451ui.C39355b.C28479d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C29633l;
import com.tencent.p177mm.plugin.wallet_core.model.C43803ae;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C29636b;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C46367d;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.C14991i;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexBaseUI */
public abstract class MallIndexBaseUI extends WalletBaseUI implements C18765a, C29633l {
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
    private C39355b omv = null;
    protected ImageView omw = null;
    protected ImageView omx;
    protected TextView omy = null;
    protected TextView omz;

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexBaseUI$1 */
    class C212621 implements OnMenuItemClickListener {
        C212621() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(43165);
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.putExtra("preferred_tab", 3);
            C25985d.m41473f(MallIndexBaseUI.this, "com.tencent.mm.ui.LauncherUI", intent);
            MallIndexBaseUI.this.finish();
            if (!C46512f.dlH()) {
                C7060h.pYm.mo8381e(14954, C46512f.dlI(), "open_wcpay_specific_view:ok");
                C46512f.dlJ();
            }
            C7060h.pYm.mo8381e(14419, MallIndexBaseUI.this.eCq, Integer.valueOf(6));
            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "set BackBtn");
            AppMethodBeat.m2505o(43165);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexBaseUI$2 */
    class C212632 implements C28479d {
        C212632() {
        }

        /* renamed from: a */
        public final void mo36636a(final int i, final MallFunction mallFunction) {
            AppMethodBeat.m2504i(43167);
            if (mallFunction != null) {
                int i2;
                String str = mallFunction.pFP;
                if (C5046bo.isNullOrNil(str)) {
                    i2 = 1;
                } else {
                    C1720g.m3537RQ();
                    String str2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, null);
                    if (C5046bo.isNullOrNil(str2)) {
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
                if (i2 != 0 || C5046bo.isNullOrNil(mallFunction.tDo)) {
                    MallIndexBaseUI.this.mo7874a(mallFunction, i);
                } else {
                    C4990ab.m7417i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", mallFunction.pFP);
                    C30379h.m48443a(MallIndexBaseUI.this.mController.ylL, mallFunction.tDo, MallIndexBaseUI.this.getString(C25738R.string.cyo), MallIndexBaseUI.this.getString(C25738R.string.dpi), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Object obj = null;
                            AppMethodBeat.m2504i(43166);
                            String str = mallFunction.pFP;
                            if (!C5046bo.isNullOrNil(str)) {
                                C1720g.m3537RQ();
                                Object obj2 = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, null);
                                if (C5046bo.isNullOrNil(obj2)) {
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
                                C1720g.m3537RQ();
                                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, obj22);
                            }
                            MallIndexBaseUI.this.mo7874a(mallFunction, i);
                            AppMethodBeat.m2505o(43166);
                        }
                    });
                }
                C4990ab.m7411d("MicroMsg.MallIndexBaseUI", "type: %s", Integer.valueOf(mallFunction.type));
                C7060h.pYm.mo8381e(14419, MallIndexBaseUI.this.eCq, Integer.valueOf(4), Integer.valueOf(mallFunction.type));
                AppMethodBeat.m2505o(43167);
                return;
            }
            C4990ab.m7421w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(43167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexBaseUI$3 */
    class C432893 implements C30382d {
        C432893() {
        }

        /* renamed from: bV */
        public final void mo4975bV(int i, int i2) {
            AppMethodBeat.m2504i(43168);
            switch (i2) {
                case 0:
                    C7060h.pYm.mo8381e(11458, Integer.valueOf(2));
                    if (C1853r.m3831YM()) {
                        C24143a.m37114b(MallIndexBaseUI.this.mController.ylL, "PayURemittanceProcess", null);
                        AppMethodBeat.m2505o(43168);
                        return;
                    }
                    C24143a.m37114b(MallIndexBaseUI.this.mController.ylL, "RemittanceProcess", null);
                    AppMethodBeat.m2505o(43168);
                    return;
                case 1:
                    C7060h.pYm.mo8381e(11458, Integer.valueOf(3));
                    C35899h.m58860ai(MallIndexBaseUI.this, 2);
                    break;
            }
            AppMethodBeat.m2505o(43168);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mall.ui.MallIndexBaseUI$4 */
    class C432904 implements OnClickListener {
        C432904() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43169);
            MallIndexBaseUI.this.bNj();
            AppMethodBeat.m2505o(43169);
        }
    }

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

    /* renamed from: dp */
    public abstract void mo7886dp(View view);

    public abstract void initHeaderView();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970038;
    }

    public void onCreate(Bundle bundle) {
        C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!C1720g.m3531RK()) {
            C4990ab.m7418v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        this.okT = getIntent().getIntExtra("key_wallet_region", intValue);
        this.eCq = getIntent().getStringExtra("key_uuid");
        if (!C5046bo.isNullOrNil(this.eCq)) {
            this.eCq = UUID.randomUUID().toString();
        }
        mo39992nf(C33253d.CTRL_INDEX);
        C14241r.cPP();
        C43803ae.m78511a(this);
        this.okO = getIntent().getStringExtra("key_func_id");
        C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.okO + " wallet_region: " + this.okT + " walletType: " + C1853r.m3825YG() + " default_region: " + intValue);
        this.ocK = getIntent().getStringExtra("key_native_url");
        C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.ocK);
        if (!bwP()) {
            bFY();
            mo9439AM(0);
            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            bbC();
            initView();
            C40113c.cQW();
            bNa();
            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            bNb();
            if (C1853r.m3831YM()) {
                C4990ab.m7412e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
                if (c30052l != null) {
                    C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    c30052l.bxd();
                } else {
                    C4990ab.m7412e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            C36381z.m59954hL(1, 0);
            C7060h.pYm.mo8381e(11850, Integer.valueOf(1), Integer.valueOf(0));
        }
    }

    public final void bht() {
    }

    public final boolean bwP() {
        if (C5046bo.isNullOrNil(this.okO) && C5046bo.isNullOrNil(this.ocK)) {
            return false;
        }
        return true;
    }

    public void onResume() {
        int i = 1;
        super.onResume();
        C14991i.m23324Lt(1);
        C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!C1720g.m3531RK()) {
            C4990ab.m7418v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (bwP()) {
            this.okP = C43288j.bMV().mo68837ym(this.okT);
            if (this.okP == null || this.okP.size() <= 0) {
                C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !C5046bo.isNullOrNil(this.ocK)) {
                        mo39970a(new C12480f(this.okT, C29636b.cQS(), 0), true, false);
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    mo39970a(new C12480f(this.okT, C29636b.cQS(), getIntent().getStringExtra("key_app_id"), this.okO, stringExtra), true, false);
                    return;
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MallIndexBaseUI", e, "", new Object[0]);
                    bNg();
                    return;
                }
            }
            MallFunction cm = m89317cm(this.okP);
            if (cm == null) {
                cm = m89318cn(this.okP);
            }
            mo7874a(cm, -1);
            finish();
            return;
        }
        bNd();
        C4990ab.m7410d("MicroMsg.MallIndexBaseUI", "initFunctionList");
        if (C43288j.bMV().mo68837ym(this.okT) == null) {
            mo39970a(new C12480f(this.okT, C29636b.cQS(), 0), true, false);
            C4990ab.m7412e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
            i = 0;
        } else {
            mo39970a(new C12480f(this.okT, C29636b.cQS(), 1), false, false);
            this.okP = C43288j.bMV().mo68837ym(this.okT);
        }
        if (i != 0) {
            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "has data");
            mo76125cu();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bNc() {
        if (this.omz.getVisibility() == 0) {
            C43291a.m77161a(this, true, false);
            LayoutParams layoutParams = (LayoutParams) this.omD.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -2);
            }
            layoutParams.height = C43291a.bMX();
            this.omD.setLayoutParams(layoutParams);
        }
    }

    private void bNe() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.omu.getChildCount() != 0) {
            C4990ab.m7417i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", Boolean.valueOf(booleanExtra), Integer.valueOf(this.omu.getFirstVisiblePosition()), Integer.valueOf(this.omu.getChildAt(0).getTop()));
            if (this.omu.getFirstVisiblePosition() == 0 && r2 == 0 && booleanExtra && !this.omF && this.okP != null) {
                this.omF = true;
                int headerViewsCount = this.omu.getHeaderViewsCount() + this.omv.getCount();
                List list = this.omv.olz;
                if (list != null) {
                    for (int size = list.size() - 1; size > 0; size--) {
                        Iterator it = ((ArrayList) list.get(size)).iterator();
                        while (it.hasNext()) {
                            C28478c c28478c = (C28478c) it.next();
                            if (c28478c != null && c28478c.omd != null && C39355b.m67114a(c28478c.omd)) {
                                C4990ab.m7417i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", Integer.valueOf(this.omu.getFirstVisiblePosition()), Integer.valueOf(this.omu.getLastVisiblePosition()), Integer.valueOf(headerViewsCount));
                                if (headerViewsCount < this.omu.getFirstVisiblePosition() || headerViewsCount > r1) {
                                    size = C43291a.bMY();
                                    int bMX = (C43291a.bMX() + (C43291a.bMW() * (headerViewsCount + 1))) + size;
                                    if (headerViewsCount > 2) {
                                        bMX += size;
                                    }
                                    if (headerViewsCount > 3) {
                                        bMX += size;
                                    }
                                    size = (bMX + (C43291a.bMW() / 3)) - this.omu.getScrollY();
                                    bMX = C5222ae.m7953hy(this).y;
                                    if (C5222ae.m7951hw(this)) {
                                        bMX -= C5222ae.m7944fr(this);
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

    /* renamed from: a */
    public void mo7874a(MallFunction mallFunction, int i) {
        int i2;
        if (mallFunction != null && i >= 0) {
            String str = "";
            if (!(mallFunction.tDn == null || C5046bo.isNullOrNil(mallFunction.tDn.ssr))) {
                str = mallFunction.tDn.ssr;
            }
            int size = this.okP == null ? 0 : this.okP.size();
            boolean a = C39355b.m67114a(mallFunction);
            C7060h c7060h = C7060h.pYm;
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
            c7060h.mo8381e(10881, objArr);
        }
        if (mallFunction == null || C5046bo.isNullOrNil(mallFunction.cRS) || !((C42687f) C1720g.m3528K(C42687f.class)).mo68089Cl(mallFunction.cRS)) {
            if (mallFunction != null) {
                C40113c.cQT().acI(mallFunction.pFP);
                C46367d.cQX().acI(mallFunction.pFP);
                if (mallFunction.tDn != null) {
                    C40113c.cQT();
                    C40113c.m68765e(mallFunction);
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
                } else if (!C5046bo.isNullOrNil(mallFunction.nmz)) {
                    i2 = 1;
                } else if ("wxpay://bizmall/f2f_hongbao".equals(mallFunction.cRS)) {
                    i2 = 9;
                } else {
                    C4990ab.m7420w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "functionType : ".concat(String.valueOf(i2)));
            Intent intent;
            switch (i2) {
                case 0:
                    intent = new Intent();
                    if (bwP()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    C25985d.m41467b((Context) this, "recharge", ".ui.PhoneRechargeUI", intent);
                    C36381z.m59954hL(15, 0);
                    return;
                case 1:
                    C1720g.m3537RQ();
                    this.okT = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    intent = new Intent();
                    intent.putExtra("rawUrl", mallFunction.nmz);
                    intent.putExtra("geta8key_username", C1853r.m3846Yz());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra("KPublisherId", "pay_wallet");
                    intent.putExtra("key_download_restrict", mallFunction.tDp);
                    intent.putExtra("key_wallet_region", this.okT);
                    intent.putExtra("key_function_id", mallFunction.pFP);
                    intent.putExtra("geta8key_scene", 46);
                    C25985d.m41467b((Context) this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    C4990ab.m7420w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    C4990ab.m7420w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    C23639t.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    C7060h.pYm.mo8381e(11701, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
                    intent = new Intent();
                    intent.putExtra("pay_channel", 1);
                    C25985d.m41467b((Context) this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent);
                    C36381z.m59954hL(13, 0);
                    C7060h.pYm.mo8381e(11850, Integer.valueOf(4), Integer.valueOf(0));
                    return;
                case 5:
                    C7060h.pYm.mo8381e(11458, Integer.valueOf(1));
                    if (C1853r.m3831YM()) {
                        List linkedList = new LinkedList();
                        List linkedList2 = new LinkedList();
                        linkedList.add(getString(C25738R.string.dqi));
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(getString(C25738R.string.asx));
                        linkedList2.add(Integer.valueOf(1));
                        C30379h.m48420a((Context) this, getString(C25738R.string.do4), linkedList, linkedList2, null, true, new C432893());
                    } else {
                        C1720g.m3537RQ();
                        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                            bNj();
                        } else {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MALL_INDEX_HAS_SHOWN_FTF_NOTICE_BOOLEAN, Boolean.TRUE);
                            C30379h.m48438a((Context) this, getString(C25738R.string.fg5), "", new C432904());
                        }
                    }
                    C36381z.m59954hL(14, 0);
                    C7060h.pYm.mo8381e(11850, Integer.valueOf(3), Integer.valueOf(0));
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    C25985d.m41467b(this.mController.ylL, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    C36381z.m59954hL(9, 0);
                    C7060h.pYm.mo8381e(11850, Integer.valueOf(5), Integer.valueOf(0));
                    return;
                case 7:
                    intent = new Intent();
                    if (bwP()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    C25985d.m41467b((Context) this, "recharge", ".ui.RechargeUI", intent);
                    return;
                case 8:
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    C25985d.m41467b(this.mController.ylL, "scanner", ".ui.BaseScanUI", intent);
                    return;
                case 9:
                    C25985d.m41448H(this.mController.ylL, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    return;
                default:
                    return;
            }
        }
        C4990ab.m7417i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", mallFunction.cRS);
        C40113c.cQT().acI(mallFunction.pFP);
        C46367d.cQX().acI(mallFunction.pFP);
        if (mallFunction.tDn != null) {
            C40113c.cQT();
            C40113c.m68765e(mallFunction);
        }
    }

    public void onDestroy() {
        mo39993ng(C33253d.CTRL_INDEX);
        C14241r.cPP();
        C43803ae.m78512b(this);
        super.onDestroy();
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        C4990ab.m7410d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (c1207m instanceof C46358a) {
            C4990ab.m7410d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i != 0 || i2 != 0) {
                finish();
                return true;
            } else if (this.omB) {
                this.omB = false;
                if (C14241r.cPE().cRh().cQi()) {
                    C24143a.m37114b((Activity) this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (c1207m.getType()) {
            case C33253d.CTRL_INDEX /*495*/:
                C12480f c12480f = (C12480f) c1207m;
                if (c12480f.okT != this.okT) {
                    C4990ab.m7417i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", Integer.valueOf(this.okT), Integer.valueOf(c12480f.okT));
                }
                if (bwP()) {
                    C4990ab.m7411d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0 && c12480f.okP != null) {
                        MallFunction cm;
                        if (getIntent().getIntExtra("key_scene", 0) == 1) {
                            cm = m89317cm(c12480f.okP);
                            if (cm != null) {
                                mo7874a(cm, -1);
                            }
                        } else if (!C5046bo.isNullOrNil(this.ocK)) {
                            C4990ab.m7411d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", this.ocK);
                            cm = m89318cn(c12480f.okP);
                            if (cm != null) {
                                mo7874a(cm, -1);
                            } else {
                                bNg();
                                return true;
                            }
                        } else if (c12480f.okP != null && c12480f.okP.size() > 0) {
                            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                            mo7874a(m89317cm(c12480f.okP), -1);
                        } else if (C43288j.bMV().mo68837ym(this.okT) == null || C43288j.bMV().mo68837ym(this.okT).size() <= 0) {
                            C4990ab.m7412e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                        } else {
                            C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                            mo7874a(m89317cm(C43288j.bMV().mo68837ym(this.okT)), -1);
                        }
                        setResult(-1);
                        finish();
                        return true;
                    }
                    bNg();
                    return true;
                }
                if (i == 0 && i2 == 0 && C43288j.bMV().mo68837ym(this.okT) != null && c12480f.okP != null) {
                    this.okP = C43288j.bMV().mo68837ym(this.okT);
                    C4990ab.m7416i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.okT + " " + this.okP.size());
                    C40113c.cQT().mo63443X(this.okP);
                }
                mo76125cu();
                bNe();
                bGb();
                return true;
            default:
                return false;
        }
    }

    /* renamed from: cm */
    private MallFunction m89317cm(List<MallFunction> list) {
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

    /* renamed from: cn */
    private MallFunction m89318cn(List<MallFunction> list) {
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
            mo76125cu();
        }
        return true;
    }

    public final boolean bNf() {
        return false;
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
    }

    private void bNg() {
        setResult(0);
        finish();
    }

    /* renamed from: cu */
    public final void mo76125cu() {
        showOptionMenu(true);
        this.omv.mo62243J(this.okP);
        bNi();
        bNk();
        bNl();
        bNm();
    }

    public void onStop() {
        super.onStop();
    }

    public void initView() {
        C4990ab.m7410d("MicroMsg.MallIndexBaseUI", "index initView");
        setBackBtn(new C212621());
        this.omu = (ListView) findViewById(2131825793);
        initHeaderView();
        bGb();
        this.omv = new C39355b(this, this.okT);
        this.omu.setAdapter(this.omv);
        this.omv.olA = new C212632();
        mo7886dp(this.omD);
        this.omz = (TextView) findViewById(2131821634);
        bNh();
    }

    private void bNj() {
        if (C1853r.m3831YM()) {
            C24143a.m37114b(this.mController.ylL, "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        C24143a.m37114b(this.mController.ylL, "RemittanceProcess", bundle);
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

    /* renamed from: yq */
    public final void mo41704yq(int i) {
        if (i == 12 && this.omy != null) {
            bNi();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            C1720g.m3537RQ();
            this.okT = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (C1853r.m3832YN()) {
                finish();
                return;
            }
            finish();
            C6533on c6533on = new C6533on();
            c6533on.cKQ.context = this.mController.ylL;
            C4879a.xxA.mo10055m(c6533on);
        }
    }
}
