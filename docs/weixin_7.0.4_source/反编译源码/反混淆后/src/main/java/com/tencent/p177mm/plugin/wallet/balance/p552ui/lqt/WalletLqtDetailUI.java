package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C17391c;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14103ab;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4309q;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4314r;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.C35953sw;
import com.tencent.p177mm.protocal.protobuf.C44191xg;
import com.tencent.p177mm.protocal.protobuf.ace;
import com.tencent.p177mm.protocal.protobuf.axi;
import com.tencent.p177mm.protocal.protobuf.bdy;
import com.tencent.p177mm.protocal.protobuf.bnr;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI */
public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private static final int koS = C1338a.fromDPToPix(C4996ah.getContext(), 16);
    private Dialog gnn;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private TextView tiA;
    private LinearLayout tiB;
    private TextView tiC;
    private TextView tiD;
    private TextView tiE;
    private TextView tiF;
    private boolean tiG = true;
    private C4309q tic = ((C4309q) mo74556Z(C4309q.class));
    private C4314r tie = ((C4314r) mo74555V(C4314r.class));
    private bnr tif;
    private ViewGroup tig;
    private TextView tih;
    private WalletTextView tii;
    private ViewGroup tij;
    private TextView tik;
    private TextView til;
    private ViewGroup tim;
    private TextView tin;
    private WalletTextView tio;
    private Button tip;
    private Button tiq;
    private LinearLayout tir;
    private TextView tis;
    private TextView tit;
    private View tiu;
    private TextView tiv;
    private View tiw;
    private View tix;
    private CdnImageView tiy;
    private TextView tiz;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$3 */
    class C43253 implements OnClickListener {
        C43253() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45524);
            C36391e.m60016n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQA.wdd, false);
            AppMethodBeat.m2505o(45524);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$6 */
    class C43266 implements OnClickListener {
        C43266() {
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.m2504i(45527);
            if (C1947ae.gjv) {
                boolean z2;
                Intent intent = new Intent(WalletLqtDetailUI.this, WalletLqtSaveFetchUI.class);
                intent.putExtra("lqt_save_fund_code", WalletLqtDetailUI.this.tif != null ? WalletLqtDetailUI.this.tif.wPv : null);
                intent.putExtra("lqt_save_fetch_mode", 1);
                String str = "lqt_is_show_protocol";
                if (WalletLqtDetailUI.this.tif.cRh == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                intent.putExtra(str, z2);
                String str2 = "lqt_is_agree_protocol";
                if (WalletLqtDetailUI.this.tif.wQw != 1) {
                    z = false;
                }
                intent.putExtra(str2, z);
                intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.m46915e(WalletLqtDetailUI.this));
                intent.putExtra("lqt_profile_wording", WalletLqtDetailUI.this.tif.wQp);
                WalletLqtDetailUI.this.startActivity(intent);
                AppMethodBeat.m2505o(45527);
                return;
            }
            WalletLqtDetailUI.this.tie.tfF.mo9336ge(WalletLqtDetailUI.this.tif.wao, 1);
            if (C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQC)) {
                WalletLqtDetailUI.m46911a(WalletLqtDetailUI.this, true, WalletLqtDetailUI.this.tif.wQP);
                AppMethodBeat.m2505o(45527);
                return;
            }
            C4990ab.m7417i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", WalletLqtDetailUI.this.tif.wQC);
            C36391e.m60016n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQC, false);
            AppMethodBeat.m2505o(45527);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$10 */
    class C1414110 implements C5690a {
        C1414110() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(45534);
            if (WalletLqtDetailUI.this.gnn != null) {
                WalletLqtDetailUI.this.gnn.dismiss();
            }
            C4990ab.m7417i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", obj);
            if (obj != null) {
                CharSequence obj2;
                if (obj instanceof String) {
                    obj2 = obj.toString();
                } else {
                    obj2 = WalletLqtDetailUI.this.getString(C25738R.string.fiu);
                }
                Toast.makeText(WalletLqtDetailUI.this, obj2, 1).show();
            }
            AppMethodBeat.m2505o(45534);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$4 */
    class C141434 implements OnClickListener {
        C141434() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45525);
            C32628se c32628se = new C32628se();
            c32628se.cOf.userName = WalletLqtDetailUI.this.tif.wQB.username;
            c32628se.cOf.cOh = C5046bo.m7532bc(WalletLqtDetailUI.this.tif.wQB.path, "");
            c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_QINSHUI;
            c32628se.cOf.cOi = 0;
            C4879a.xxA.mo10055m(c32628se);
            AppMethodBeat.m2505o(45525);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$5 */
    class C141445 implements OnClickListener {
        C141445() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45526);
            C4990ab.m7416i("MicroMsg.WalletLqtDetailUI", "click top biz");
            if (WalletLqtDetailUI.this.tif.wQO.wHE == 2) {
                if (!C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQO.wdd)) {
                    C36391e.m60016n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQO.wdd, false);
                    C7060h.pYm.mo8381e(16807, Integer.valueOf(1), Integer.valueOf(2), WalletLqtDetailUI.this.tif.wQO.wdd);
                    AppMethodBeat.m2505o(45526);
                    return;
                }
            } else if (!(WalletLqtDetailUI.this.tif.wQO.wHE != 3 || C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQO.vTT) || C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQO.wdd))) {
                C36391e.m60018p(WalletLqtDetailUI.this.tif.wQO.vTT, WalletLqtDetailUI.this.tif.wQO.wdd, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                C7060h.pYm.mo8381e(16807, Integer.valueOf(1), Integer.valueOf(3), WalletLqtDetailUI.this.tif.wQO.wdd, WalletLqtDetailUI.this.tif.wQO.vTT);
            }
            AppMethodBeat.m2505o(45526);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$19 */
    class C2250819 implements OnClickListener {
        C2250819() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45544);
            WalletLqtDetailUI.m46914d(WalletLqtDetailUI.this);
            C7060h.pYm.mo8381e(17084, Integer.valueOf(3));
            AppMethodBeat.m2505o(45544);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$7 */
    class C295627 implements OnClickListener {
        C295627() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45528);
            C5698f.m8551D(Integer.valueOf(WalletLqtDetailUI.this.tif.wao), Integer.valueOf(1)).mo15892c(WalletLqtDetailUI.this.tie.tfE);
            WalletLqtDetailUI.m46911a(WalletLqtDetailUI.this, false, WalletLqtDetailUI.this.tif.wQQ);
            AppMethodBeat.m2505o(45528);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$12 */
    class C2956412 implements C5681a<Void, bnr> {
        C2956412() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45537);
            bnr bnr = (bnr) obj;
            if (bnr != null) {
                C4990ab.m7417i("MicroMsg.WalletLqtDetailUI", "fetch detail success, account_type: %s, is_hide_close_account_btn: %s", Integer.valueOf(bnr.wao), Boolean.valueOf(bnr.wQG));
                WalletLqtDetailUI.this.tif = bnr;
                WalletLqtDetailUI.m46912b(WalletLqtDetailUI.this);
            } else {
                C4990ab.m7416i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
            }
            if (WalletLqtDetailUI.this.gnn != null) {
                WalletLqtDetailUI.this.gnn.dismiss();
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45537);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$14 */
    class C2956514 implements OnClickListener {
        C2956514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45539);
            if (!C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQI)) {
                C36391e.m60016n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQI, false);
                C7060h.pYm.mo8381e(17084, Integer.valueOf(2));
            }
            AppMethodBeat.m2505o(45539);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$1 */
    class C295661 implements C5690a {
        C295661() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(45522);
            if (WalletLqtDetailUI.this.gnn != null) {
                WalletLqtDetailUI.this.gnn.dismiss();
            }
            C4990ab.m7417i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", obj);
            if (obj != null) {
                CharSequence obj2;
                if (obj instanceof String) {
                    obj2 = obj.toString();
                } else {
                    obj2 = WalletLqtDetailUI.this.getString(C25738R.string.fiu);
                }
                Toast.makeText(WalletLqtDetailUI.this, obj2, 1).show();
            }
            AppMethodBeat.m2505o(45522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$11 */
    class C2956711 implements C5681a<Void, C35953sw> {

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$11$1 */
        class C295681 implements Runnable {
            C295681() {
            }

            public final void run() {
                AppMethodBeat.m2504i(45535);
                if (WalletLqtDetailUI.this.gnn != null) {
                    WalletLqtDetailUI.this.gnn.dismiss();
                }
                Toast.makeText(WalletLqtDetailUI.this, WalletLqtDetailUI.this.getString(C25738R.string.fi1), 1).show();
                WalletLqtDetailUI.this.finish();
                AppMethodBeat.m2505o(45535);
            }
        }

        C2956711() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45536);
            WalletLqtDetailUI.this.handler.postDelayed(new C295681(), 1000);
            Void voidR = zXH;
            AppMethodBeat.m2505o(45536);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$13 */
    class C2956913 implements OnClickListener {
        C2956913() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45538);
            if (!C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQH)) {
                C36391e.m60016n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQH, false);
                C7060h.pYm.mo8381e(17084, Integer.valueOf(1));
            }
            AppMethodBeat.m2505o(45538);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$2 */
    class C295702 implements OnClickListener {
        C295702() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45523);
            C36391e.m60016n(WalletLqtDetailUI.this, WalletLqtDetailUI.this.tif.wQy.wdd, false);
            C7060h.pYm.mo8381e(17084, Integer.valueOf(4));
            AppMethodBeat.m2505o(45523);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$9 */
    class C295719 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$9$2 */
        class C295722 implements C5279d {

            /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$9$2$1 */
            class C295731 implements DialogInterface.OnClickListener {
                C295731() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(45531);
                    WalletLqtDetailUI.this.tiG = false;
                    WalletLqtDetailUI.this.startActivityForResult(new Intent(WalletLqtDetailUI.this, WalletLqtSimpleCheckPwdUI.class), 123);
                    AppMethodBeat.m2505o(45531);
                }
            }

            C295722() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(45532);
                if (menuItem.getItemId() != -1 || WalletLqtDetailUI.this.tif.wQG) {
                    if (WalletLqtDetailUI.this.tif.wQz != null && WalletLqtDetailUI.this.tif.wQz.size() > 0 && menuItem.getItemId() < WalletLqtDetailUI.this.tif.wQz.size()) {
                        C36391e.m60016n(WalletLqtDetailUI.this, ((C44191xg) WalletLqtDetailUI.this.tif.wQz.get(menuItem.getItemId())).wdd, false);
                    }
                    AppMethodBeat.m2505o(45532);
                    return;
                }
                String str;
                if (!C5046bo.isNullOrNil(WalletLqtDetailUI.this.tif.wQL)) {
                    str = WalletLqtDetailUI.this.tif.wQL;
                } else if (WalletLqtDetailUI.this.tif.wao == 0) {
                    str = WalletLqtDetailUI.this.getString(C25738R.string.fi2);
                } else {
                    str = WalletLqtDetailUI.this.getString(C25738R.string.fht);
                }
                C30379h.m48443a(WalletLqtDetailUI.this, str, "", WalletLqtDetailUI.this.getString(C25738R.string.ar5), new C295731());
                AppMethodBeat.m2505o(45532);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI$9$1 */
        class C295741 implements C36073c {
            C295741() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(45530);
                if (WalletLqtDetailUI.this.tif.wQz != null && WalletLqtDetailUI.this.tif.wQz.size() > 0) {
                    Iterator it = WalletLqtDetailUI.this.tif.wQz.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        C44191xg c44191xg = (C44191xg) it.next();
                        if (!(C5046bo.isNullOrNil(c44191xg.title) || C5046bo.isNullOrNil(c44191xg.wdd))) {
                            c44273l.add(0, i, 0, c44191xg.title);
                        }
                        i++;
                    }
                }
                if (!WalletLqtDetailUI.this.tif.wQG) {
                    c44273l.add(0, -1, 0, (int) C25738R.string.fi0);
                }
                AppMethodBeat.m2505o(45530);
            }
        }

        C295719() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45533);
            C36356d c36356d = new C36356d(WalletLqtDetailUI.this, 1, false);
            c36356d.rBl = new C295741();
            c36356d.rBm = new C295722();
            c36356d.cpD();
            AppMethodBeat.m2505o(45533);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletLqtDetailUI() {
        AppMethodBeat.m2504i(45545);
        AppMethodBeat.m2505o(45545);
    }

    /* renamed from: e */
    static /* synthetic */ ArrayList m46915e(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.m2504i(45555);
        ArrayList cNh = walletLqtDetailUI.cNh();
        AppMethodBeat.m2505o(45555);
        return cNh;
    }

    static {
        AppMethodBeat.m2504i(45557);
        AppMethodBeat.m2505o(45557);
    }

    private ArrayList<String> cNh() {
        AppMethodBeat.m2504i(45547);
        ArrayList arrayList = new ArrayList();
        if (this.tif.wQx != null && this.tif.wQx.size() > 0) {
            Iterator it = this.tif.wQx.iterator();
            while (it.hasNext()) {
                C44191xg c44191xg = (C44191xg) it.next();
                if (!(C5046bo.isNullOrNil(c44191xg.title) || C5046bo.isNullOrNil(c44191xg.wdd))) {
                    arrayList.add(String.format("%s||%s", new Object[]{c44191xg.title, c44191xg.wdd}));
                }
            }
        }
        AppMethodBeat.m2505o(45547);
        return arrayList;
    }

    public void onResume() {
        AppMethodBeat.m2504i(45548);
        super.onResume();
        if (this.tiG) {
            this.tig.setVisibility(8);
            this.gnn = C30901g.m49318b(this, false, null);
            this.tie.tfC.aor().mo15896f(new C2956412()).mo11586a((C5690a) new C295661());
        }
        this.tiG = true;
        AppMethodBeat.m2505o(45548);
    }

    private void ack(String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(45549);
        C4990ab.m7416i("MicroMsg.WalletLqtDetailUI", "go to save ui");
        Intent intent = new Intent(this, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fund_code", this.tif != null ? this.tif.wPv : null);
        intent.putExtra("lqt_save_fetch_mode", 1);
        String str2 = "lqt_is_show_protocol";
        if (this.tif.cRh == 1) {
            z = true;
        } else {
            z = false;
        }
        intent.putExtra(str2, z);
        String str3 = "lqt_is_agree_protocol";
        if (this.tif.wQw != 1) {
            z2 = false;
        }
        intent.putExtra(str3, z2);
        intent.putStringArrayListExtra("lqt_protocol_list", cNh());
        intent.putExtra("lqt_profile_wording", this.tif.wQp);
        intent.putExtra("lqt_account_type", this.tif.wao);
        intent.putExtra("lqt_fund_spid", this.tif.wPx);
        intent.putExtra("operate_id", str);
        startActivity(intent);
        AppMethodBeat.m2505o(45549);
    }

    private void acl(String str) {
        AppMethodBeat.m2504i(45550);
        C4990ab.m7416i("MicroMsg.WalletLqtDetailUI", "go to fetch ui");
        Intent intent = new Intent(this, WalletLqtSaveFetchUI.class);
        intent.putExtra("lqt_save_fetch_mode", 2);
        intent.putExtra("lqt_balance", this.tif.wJb);
        intent.putExtra("lqt_max_redeem_amount", this.tif.wQD);
        intent.putExtra("lqt_redeem_invalid_amount_hint", this.tif.wQE);
        intent.putExtra("lqt_account_type", this.tif.wao);
        intent.putExtra("operate_id", str);
        startActivity(intent);
        AppMethodBeat.m2505o(45550);
    }

    public final int getLayoutId() {
        return 2130971117;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45551);
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            this.tiG = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.gnn == null) {
                this.gnn = C30901g.m49318b(this, false, null);
            } else {
                this.gnn.show();
            }
            C5698f.m8551D(stringExtra, Integer.valueOf(this.tif.wao)).mo15892c(this.tie.tfD).mo15896f(new C2956711()).mo11586a((C5690a) new C1414110());
        }
        AppMethodBeat.m2505o(45551);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45552);
        super.onDestroy();
        this.tic = null;
        this.tie = null;
        AppMethodBeat.m2505o(45552);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45546);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.a4p));
        mo17373Nc(getResources().getColor(C25738R.color.a69));
        dyb();
        setMMTitle("");
        int intExtra = getIntent().getIntExtra("key_account_type", 1);
        C4990ab.m7417i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", Integer.valueOf(intExtra));
        this.tig = (ViewGroup) findViewById(2131828823);
        this.tih = (TextView) findViewById(2131828824);
        this.tii = (WalletTextView) findViewById(2131828831);
        this.tij = (ViewGroup) findViewById(2131828832);
        this.tik = (TextView) findViewById(2131828833);
        this.til = (TextView) findViewById(2131828835);
        this.tim = (ViewGroup) findViewById(2131828837);
        this.tin = (TextView) findViewById(2131828838);
        this.tio = (WalletTextView) findViewById(2131828840);
        this.tip = (Button) findViewById(2131828842);
        this.tiq = (Button) findViewById(2131828843);
        this.tir = (LinearLayout) findViewById(2131828845);
        this.tis = (TextView) findViewById(2131828853);
        this.tiu = findViewById(2131825354);
        this.tiv = (TextView) findViewById(2131825355);
        this.tix = findViewById(2131828847);
        this.tiy = (CdnImageView) findViewById(2131828848);
        this.tiz = (TextView) findViewById(2131828849);
        this.tiA = (TextView) findViewById(2131828850);
        this.tiw = findViewById(2131828846);
        this.tit = (TextView) findViewById(2131828854);
        this.tiB = (LinearLayout) findViewById(2131828827);
        this.tiC = (TextView) findViewById(2131828828);
        this.tiD = (TextView) findViewById(2131828836);
        this.tiE = (TextView) findViewById(2131828841);
        this.tiF = (TextView) findViewById(2131828851);
        this.tis.setVisibility(4);
        AppMethodBeat.m2505o(45546);
    }

    /* renamed from: b */
    static /* synthetic */ void m46912b(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.m2504i(45553);
        if (walletLqtDetailUI.tif != null) {
            walletLqtDetailUI.tii.setText(C36391e.m59971F(C36391e.m59996b(walletLqtDetailUI.tif.wJb, "100", RoundingMode.HALF_UP)));
            ImageView imageView = (ImageView) walletLqtDetailUI.findViewById(2131828834);
            if (imageView != null) {
                if (C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQH)) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            imageView = (ImageView) walletLqtDetailUI.findViewById(2131828839);
            if (imageView != null) {
                if (C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQH)) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
            }
            walletLqtDetailUI.tij.setOnClickListener(new C2956913());
            walletLqtDetailUI.tik.setText(walletLqtDetailUI.tif.wQr);
            walletLqtDetailUI.til.setText(walletLqtDetailUI.tif.wQs);
            walletLqtDetailUI.tin.setText(walletLqtDetailUI.tif.wQt);
            walletLqtDetailUI.tio.setText(C36391e.m59972G(C36391e.m59996b(walletLqtDetailUI.tif.wQu, "100", RoundingMode.HALF_UP)));
            walletLqtDetailUI.tim.setOnClickListener(new C2956514());
            if (C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQK)) {
                walletLqtDetailUI.tiD.setVisibility(4);
            } else {
                walletLqtDetailUI.tiD.setText(walletLqtDetailUI.tif.wQK);
                walletLqtDetailUI.tiD.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQR)) {
                walletLqtDetailUI.tiE.setVisibility(4);
            } else {
                walletLqtDetailUI.tiE.setText(walletLqtDetailUI.tif.wQR);
                walletLqtDetailUI.tiE.setVisibility(0);
            }
            walletLqtDetailUI.tir.removeAllViews();
            final ViewGroup viewGroup;
            TextView textView;
            if (walletLqtDetailUI.tif.wQJ != null && !walletLqtDetailUI.tif.wQJ.isEmpty()) {
                Iterator it = walletLqtDetailUI.tif.wQJ.iterator();
                int i = 0;
                while (it.hasNext()) {
                    final bdy bdy = (bdy) it.next();
                    viewGroup = (ViewGroup) walletLqtDetailUI.getLayoutInflater().inflate(2130969956, walletLqtDetailUI.tir, false);
                    TextView textView2 = (TextView) viewGroup.findViewById(2131825330);
                    textView = (TextView) viewGroup.findViewById(2131825331);
                    View findViewById = viewGroup.findViewById(2131825332);
                    if (i == walletLqtDetailUI.tif.wQJ.size() - 1) {
                        findViewById.setVisibility(8);
                    }
                    textView2.setText(bdy.title);
                    textView.setText(bdy.desc);
                    if (bdy.wHE == 1) {
                        if (bdy.wHD == 1) {
                            viewGroup.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(45540);
                                    C4990ab.m7416i("MicroMsg.WalletLqtDetailUI", "go to lqt plan home");
                                    WalletLqtDetailUI.this.startActivity(new Intent(WalletLqtDetailUI.this.mController.ylL, WalletLqtPlanHomeUI.class));
                                    C7060h.pYm.mo8381e(16807, Integer.valueOf(2), Integer.valueOf(1), "", "", Integer.valueOf(bdy.wHD));
                                    AppMethodBeat.m2505o(45540);
                                }
                            });
                        }
                    } else if (bdy.wHE == 2) {
                        if (!C5046bo.isNullOrNil(bdy.wdd)) {
                            viewGroup.setTag(bdy.wdd);
                            viewGroup.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    AppMethodBeat.m2504i(45541);
                                    C36391e.m60016n(WalletLqtDetailUI.this, (String) viewGroup.getTag(), false);
                                    C7060h.pYm.mo8381e(16807, Integer.valueOf(2), Integer.valueOf(2), bdy.wdd);
                                    AppMethodBeat.m2505o(45541);
                                }
                            });
                        }
                    } else if (!(bdy.wHE != 3 || C5046bo.isNullOrNil(bdy.vTT) || C5046bo.isNullOrNil(bdy.wdd))) {
                        viewGroup.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(45542);
                                C36391e.m60018p(bdy.vTT, bdy.wdd, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
                                C7060h.pYm.mo8381e(16807, Integer.valueOf(2), Integer.valueOf(2), bdy.wdd, bdy.vTT);
                                AppMethodBeat.m2505o(45542);
                            }
                        });
                    }
                    walletLqtDetailUI.tir.addView(viewGroup, new LayoutParams(-1, -2, -1.0f));
                    i++;
                }
            } else if (walletLqtDetailUI.tif.wQv != null && walletLqtDetailUI.tif.wQv.size() > 0) {
                Iterator it2 = walletLqtDetailUI.tif.wQv.iterator();
                while (it2.hasNext()) {
                    C44191xg c44191xg = (C44191xg) it2.next();
                    viewGroup = (ViewGroup) walletLqtDetailUI.getLayoutInflater().inflate(2130969956, walletLqtDetailUI.tir, false);
                    textView = (TextView) viewGroup.findViewById(2131825331);
                    ((TextView) viewGroup.findViewById(2131825330)).setText(c44191xg.title);
                    textView.setText(c44191xg.desc);
                    if (!C5046bo.isNullOrNil(c44191xg.wdd)) {
                        viewGroup.setTag(c44191xg.wdd);
                        viewGroup.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(45543);
                                C36391e.m60016n(WalletLqtDetailUI.this, (String) viewGroup.getTag(), false);
                                AppMethodBeat.m2505o(45543);
                            }
                        });
                    }
                    walletLqtDetailUI.tir.addView(viewGroup, new LayoutParams(-1, -2, -1.0f));
                }
            }
            if (walletLqtDetailUI.tir.getChildCount() == 0) {
                View findViewById2 = walletLqtDetailUI.findViewById(2131828844);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(4);
                }
            }
            walletLqtDetailUI.tig.setVisibility(0);
            if (walletLqtDetailUI.tif.wJb <= 0) {
                walletLqtDetailUI.tiq.setEnabled(false);
            } else {
                walletLqtDetailUI.tiq.setEnabled(true);
            }
            if (C4872b.dnO()) {
                walletLqtDetailUI.tiq.setEnabled(true);
            }
            if (C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQS)) {
                walletLqtDetailUI.tiF.setVisibility(8);
                walletLqtDetailUI.findViewById(2131828852).setVisibility(8);
                walletLqtDetailUI.tis.setGravity(17);
                walletLqtDetailUI.tis.setPadding(0, 0, 0, 0);
            } else {
                walletLqtDetailUI.tiF.setText(walletLqtDetailUI.tif.wQS);
                C36391e.m59990aA(walletLqtDetailUI.tiF, 50);
                walletLqtDetailUI.tiF.setOnClickListener(new C2250819());
                walletLqtDetailUI.tiF.setVisibility(0);
                walletLqtDetailUI.findViewById(2131828852).setVisibility(0);
                walletLqtDetailUI.tis.setGravity(3);
                walletLqtDetailUI.tis.setPadding(C1338a.fromDPToPix(walletLqtDetailUI.mController.ylL, 5), 0, 0, 0);
            }
            if (walletLqtDetailUI.tif.wQy != null) {
                walletLqtDetailUI.tis.setText(walletLqtDetailUI.tif.wQy.title);
                walletLqtDetailUI.tis.setOnClickListener(new C295702());
            }
            walletLqtDetailUI.tiu.setVisibility(8);
            if (!(walletLqtDetailUI.tif.wQA == null || C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQA.title))) {
                walletLqtDetailUI.tiu.setVisibility(0);
                walletLqtDetailUI.tiv.setText(walletLqtDetailUI.tif.wQA.title);
                if (!C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQA.wdd)) {
                    walletLqtDetailUI.tiu.setOnClickListener(new C43253());
                }
            }
            walletLqtDetailUI.tix.setVisibility(8);
            walletLqtDetailUI.tiw.setVisibility(8);
            if (!(walletLqtDetailUI.tif.wQB == null || C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQB.username))) {
                walletLqtDetailUI.tiy.setUrl(walletLqtDetailUI.tif.wQB.kbV);
                walletLqtDetailUI.tiz.setText(walletLqtDetailUI.tif.wQB.title);
                walletLqtDetailUI.tiA.setText(walletLqtDetailUI.tif.wQB.desc);
                walletLqtDetailUI.tix.setOnClickListener(new C141434());
                walletLqtDetailUI.tiw.setVisibility(0);
                walletLqtDetailUI.tix.setVisibility(0);
            }
            walletLqtDetailUI.tis.setVisibility(0);
            if (!C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQN)) {
                walletLqtDetailUI.tit.setText(walletLqtDetailUI.tif.wQN);
            } else if (walletLqtDetailUI.tif.wao == 1) {
                walletLqtDetailUI.tit.setText(C25738R.string.fi4);
            } else if (walletLqtDetailUI.tif.wao == 2) {
                walletLqtDetailUI.tit.setText(C25738R.string.fi5);
            }
            if (walletLqtDetailUI.tif.wQO == null || C5046bo.isNullOrNil(walletLqtDetailUI.tif.wQO.title)) {
                walletLqtDetailUI.tiB.setVisibility(8);
            } else {
                walletLqtDetailUI.tiB.setVisibility(0);
                walletLqtDetailUI.tiC.setText(walletLqtDetailUI.tif.wQO.title);
                walletLqtDetailUI.tiB.setOnClickListener(new C141445());
            }
            walletLqtDetailUI.tip.setOnClickListener(new C43266());
            walletLqtDetailUI.tiq.setOnClickListener(new C295627());
        }
        walletLqtDetailUI.mController.removeAllOptionMenu();
        if (walletLqtDetailUI.tif != null) {
            walletLqtDetailUI.addIconOptionMenu(0, C25738R.drawable.f6899uu, new C295719());
        }
        AppMethodBeat.m2505o(45553);
    }

    /* renamed from: d */
    static /* synthetic */ void m46914d(WalletLqtDetailUI walletLqtDetailUI) {
        AppMethodBeat.m2504i(45554);
        if (walletLqtDetailUI.tif.wQT != null) {
            final C17391c c17391c = new C17391c(walletLqtDetailUI.mController.ylL);
            View inflate = View.inflate(walletLqtDetailUI.mController.ylL, 2130969957, null);
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(2131825334);
            TextView textView = (TextView) inflate.findViewById(2131825335);
            ((TextView) inflate.findViewById(2131825333)).setText(walletLqtDetailUI.tif.wQT.title);
            textView.setText(walletLqtDetailUI.tif.wQT.wjT);
            if (walletLqtDetailUI.tif.wQT.wjU != null) {
                LayoutParams layoutParams = new LayoutParams(-1, -2);
                layoutParams.topMargin = koS;
                Iterator it = walletLqtDetailUI.tif.wQT.wjU.iterator();
                while (it.hasNext()) {
                    ace ace = (ace) it.next();
                    ViewGroup viewGroup2 = (ViewGroup) View.inflate(walletLqtDetailUI.mController.ylL, 2130969958, null);
                    TextView textView2 = (TextView) viewGroup2.findViewById(2131825337);
                    TextView textView3 = (TextView) viewGroup2.findViewById(2131825338);
                    ((CdnImageView) viewGroup2.findViewById(2131825336)).setUrl(ace.kbV);
                    textView2.setText(ace.title);
                    textView3.setText(ace.desc);
                    viewGroup.addView(viewGroup2, layoutParams);
                }
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(45529);
                    c17391c.dismiss();
                    AppMethodBeat.m2505o(45529);
                }
            });
            c17391c.setContentView(inflate);
            BottomSheetBehavior j = BottomSheetBehavior.m38322j((View) inflate.getParent());
            if (j != null) {
                j.mo41462K(C1338a.fromDPToPix(walletLqtDetailUI.mController.ylL, JsApiOpenAdCanvas.CTRL_INDEX));
                j.f4913nj = false;
            }
            c17391c.show();
        }
        AppMethodBeat.m2505o(45554);
    }

    /* renamed from: a */
    static /* synthetic */ void m46911a(WalletLqtDetailUI walletLqtDetailUI, boolean z, axi axi) {
        AppMethodBeat.m2504i(45556);
        if (axi == null) {
            if (z) {
                walletLqtDetailUI.ack("");
                AppMethodBeat.m2505o(45556);
                return;
            }
            walletLqtDetailUI.acl("");
            AppMethodBeat.m2505o(45556);
        } else if (axi.type == 1 && !C5046bo.isNullOrNil(axi.url)) {
            String aci = C14103ab.aci(axi.url);
            if (z) {
                walletLqtDetailUI.ack(aci);
                AppMethodBeat.m2505o(45556);
                return;
            }
            walletLqtDetailUI.acl(aci);
            AppMethodBeat.m2505o(45556);
        } else if (axi.type == 2) {
            C36391e.m60016n(walletLqtDetailUI.mController.ylL, axi.url, true);
            AppMethodBeat.m2505o(45556);
        } else if (axi.type == 3) {
            C36391e.m60018p(axi.vTT, axi.url, 0, FilterEnum4Shaka.MIC_WEISHI_QINSHUI);
            AppMethodBeat.m2505o(45556);
        } else if (z) {
            walletLqtDetailUI.ack("");
            AppMethodBeat.m2505o(45556);
        } else {
            walletLqtDetailUI.acl("");
            AppMethodBeat.m2505o(45556);
        }
    }
}
