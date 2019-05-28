package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18416uq;
import com.tencent.p177mm.p230g.p231a.C26260vc;
import com.tencent.p177mm.p230g.p231a.C6553ut;
import com.tencent.p177mm.p230g.p231a.C9493vd;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C40071a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1312c.C22530f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C14157b;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.C14196a.C14198a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C22584ac;
import com.tencent.p177mm.plugin.wallet_core.model.C43809g;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22624d;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40128i;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q.C29682c;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.ttpic.VError;
import java.util.ArrayList;
import java.util.Comparator;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI */
public class WalletChangeBankcardUI extends WalletBaseUI implements C14198a {
    public static int toB = 1;
    protected int cIf = 0;
    public String gHr;
    protected TextView klD;
    protected Button pTi;
    private C4884c pUc = new C295991();
    protected PayInfo pVL = null;
    protected Orders pWy = null;
    public ArrayList<Bankcard> tgB;
    protected Bankcard tgC = null;
    protected Authen tms = null;
    protected ListView toC;
    public C40131q toD;
    protected int toE;
    public C40128i toF = null;
    protected String toG = null;
    public FavorPayInfo toH;
    private C14196a toI;
    C22624d toJ = null;
    private boolean toK = false;

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$3 */
    class C141833 implements OnClickListener {
        C141833() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45960);
            WalletChangeBankcardUI.this.cNQ();
            AppMethodBeat.m2505o(45960);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$5 */
    class C141845 implements C29682c {
        C141845() {
        }

        /* renamed from: a */
        public final void mo9392a(String str, FavorPayInfo favorPayInfo, boolean z) {
            AppMethodBeat.m2504i(45962);
            if (WalletChangeBankcardUI.this.toK) {
                C4990ab.m7420w("MicroMsg.WalletChangeBankcardUI", "has receive cancel");
                C7060h.pYm.mo15419k(965, 3, 1);
                AppMethodBeat.m2505o(45962);
                return;
            }
            WalletChangeBankcardUI.this.toH = favorPayInfo;
            WalletChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.toH);
            if (WalletChangeBankcardUI.this.toH == null || !z) {
                WalletChangeBankcardUI.this.gHr = str;
                WalletChangeBankcardUI.this.aqX();
                WalletChangeBankcardUI.this.acs(str);
                WalletChangeBankcardUI.this.toJ = null;
                AppMethodBeat.m2505o(45962);
                return;
            }
            if (WalletChangeBankcardUI.this.toH != null) {
                WalletChangeBankcardUI.this.mo47846mW(true);
                WalletChangeBankcardUI.this.toF.mo63459f(WalletChangeBankcardUI.this.tgB, false);
            }
            if (WalletChangeBankcardUI.this.toD != null) {
                WalletChangeBankcardUI.this.toD.dismiss();
            }
            WalletChangeBankcardUI.this.mo47845cu();
            WalletChangeBankcardUI.this.mo9439AM(0);
            AppMethodBeat.m2505o(45962);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$6 */
    class C141856 implements OnClickListener {
        C141856() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45963);
            if (WalletChangeBankcardUI.this.toD != null) {
                WalletChangeBankcardUI.this.toD.dismiss();
            }
            WalletChangeBankcardUI.this.mo47846mW(false);
            WalletChangeBankcardUI.this.toF.mo63459f(WalletChangeBankcardUI.this.tgB, true);
            WalletChangeBankcardUI.this.toH = (FavorPayInfo) view.getTag();
            if (WalletChangeBankcardUI.this.toH != null) {
                WalletChangeBankcardUI.this.toH.tzf = "";
            }
            WalletChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletChangeBankcardUI.this.toH);
            WalletChangeBankcardUI.this.mo47845cu();
            WalletChangeBankcardUI.this.mo9439AM(0);
            WalletChangeBankcardUI.this.toJ = null;
            AppMethodBeat.m2505o(45963);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$4 */
    class C295984 implements OnItemClickListener {
        C295984() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(45961);
            WalletChangeBankcardUI.this.mo47843Hf(i);
            AppMethodBeat.m2505o(45961);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$1 */
    class C295991 extends C4884c<C26260vc> {
        C295991() {
            AppMethodBeat.m2504i(45957);
            this.xxI = C26260vc.class.getName().hashCode();
            AppMethodBeat.m2505o(45957);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(45958);
            final C26260vc c26260vc = (C26260vc) c4883b;
            C4990ab.m7417i("MicroMsg.WalletChangeBankcardUI", "realnameNotifyListener %s", Integer.valueOf(c26260vc.cRZ.result));
            C18416uq c18416uq = new C18416uq();
            if (c26260vc.cRZ.result == -1) {
                c18416uq.cQP.scene = 17;
            } else if (c26260vc.cRZ.result == 0) {
                c18416uq.cQP.scene = 18;
            } else {
                c18416uq.cQP.scene = 0;
            }
            c18416uq.cQQ.cQH = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(45956);
                    if (-1 == c26260vc.cRZ.result) {
                        WalletChangeBankcardUI.m46944a(WalletChangeBankcardUI.this);
                    }
                    AppMethodBeat.m2505o(45956);
                }
            };
            C4879a.xxA.mo10055m(c18416uq);
            AppMethodBeat.m2505o(45958);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$7 */
    class C296007 implements OnCancelListener {
        C296007() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(45964);
            C4990ab.m7417i("MicroMsg.WalletChangeBankcardUI", "WalletPwdDialog event2 %s", C5046bo.dpG().toString());
            WalletChangeBankcardUI.this.toK = true;
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            WalletChangeBankcardUI.this.gHr = null;
            if (WalletChangeBankcardUI.this.mController.contentView.getVisibility() != 0) {
                WalletChangeBankcardUI.this.bwW();
            }
            WalletChangeBankcardUI.this.toJ = null;
            AppMethodBeat.m2505o(45964);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI$2 */
    class C296012 implements Comparator<Bankcard> {
        C296012() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(45959);
            Bankcard bankcard = (Bankcard) obj;
            Bankcard bankcard2 = (Bankcard) obj2;
            if (bankcard.cPc()) {
                AppMethodBeat.m2505o(45959);
                return -1;
            } else if (bankcard.cPd()) {
                if (bankcard2.cPc()) {
                    AppMethodBeat.m2505o(45959);
                    return 1;
                }
                AppMethodBeat.m2505o(45959);
                return -1;
            } else if (C5046bo.amZ(bankcard.field_forbidWord) < C5046bo.amZ(bankcard2.field_forbidWord)) {
                AppMethodBeat.m2505o(45959);
                return -1;
            } else if (C5046bo.amZ(bankcard.field_forbidWord) > C5046bo.amZ(bankcard2.field_forbidWord)) {
                AppMethodBeat.m2505o(45959);
                return 1;
            } else {
                AppMethodBeat.m2505o(45959);
                return 0;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletChangeBankcardUI() {
        AppMethodBeat.m2504i(45965);
        AppMethodBeat.m2505o(45965);
    }

    /* renamed from: a */
    static /* synthetic */ void m46944a(WalletChangeBankcardUI walletChangeBankcardUI) {
        AppMethodBeat.m2504i(45986);
        walletChangeBankcardUI.cNN();
        AppMethodBeat.m2505o(45986);
    }

    private void cNN() {
        AppMethodBeat.m2504i(45966);
        C40931c aE = C24143a.m37112aE(this);
        if (aE != null) {
            aE.mo8127c((Activity) this, 1);
        } else {
            finish();
        }
        C9493vd c9493vd = new C9493vd();
        c9493vd.cSa.result = -1;
        C4879a.xxA.mo10055m(c9493vd);
        AppMethodBeat.m2505o(45966);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45967);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7417i("MicroMsg.WalletChangeBankcardUI", "onActivityResult %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == toB) {
            cNN();
        }
        AppMethodBeat.m2505o(45967);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45968);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ft4);
        Bundle bundle2 = this.mBundle;
        bundle2.putInt("key_err_code", 0);
        this.toE = bundle2.getInt("key_support_bankcard", 1);
        this.tms = (Authen) bundle2.getParcelable("key_authen");
        this.pWy = (Orders) bundle2.getParcelable("key_orders");
        this.pVL = (PayInfo) bundle2.getParcelable("key_pay_info");
        this.toH = (FavorPayInfo) bundle2.getParcelable("key_favor_pay_info");
        this.cIf = this.pVL == null ? 0 : this.pVL.cIf;
        C4990ab.m7417i("MicroMsg.WalletChangeBankcardUI", "pay_scene %d", Integer.valueOf(this.cIf));
        if (this.mBundle.getBoolean("key_is_filter_bank_type")) {
            mo47846mW(true);
        } else {
            this.tgB = cNO();
        }
        if (!(this.pWy == null || this.pWy.tAq == null || this.pWy.tAq.size() <= 0)) {
            this.toG = getString(C25738R.string.fcy, new Object[]{C36391e.m60006e(this.pWy.pTN, this.pWy.pcl), ((Commodity) this.pWy.tAq.get(0)).desc});
        }
        initView();
        C36381z.m59954hL(7, 0);
        C4879a.xxA.mo10052c(this.pUc);
        if (this.mBundle.getBoolean("key_is_filter_bank_type") && this.toF != null) {
            this.toF.tGM = false;
        }
        AppMethodBeat.m2505o(45968);
    }

    private ArrayList<Bankcard> cNO() {
        AppMethodBeat.m2504i(45969);
        if (this.cIf == 8) {
            ArrayList ne = C22584ac.m34277ne(true);
            AppMethodBeat.m2505o(45969);
            return ne;
        }
        ArrayList<Bankcard> ne2 = C22584ac.m34277ne(false);
        AppMethodBeat.m2505o(45969);
        return ne2;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45970);
        if (this.toI != null) {
            this.toI.cNM();
            this.toI.release();
        }
        C4879a.xxA.mo10053d(this.pUc);
        this.toJ = null;
        super.onDestroy();
        AppMethodBeat.m2505o(45970);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45971);
        this.pTi = (Button) findViewById(2131828747);
        this.pTi.setEnabled(false);
        this.pTi.setOnClickListener(new C141833());
        if (C5046bo.isNullOrNil(this.mBundle.getString("key_pwd1"))) {
            this.pTi.setText(C25738R.string.f9187s6);
        } else {
            this.pTi.setText(C25738R.string.fq2);
        }
        this.toC = (ListView) findViewById(2131828588);
        this.toF = cNP();
        this.toC.setAdapter(this.toF);
        this.toC.setOnItemClickListener(new C295984());
        mo47845cu();
        AppMethodBeat.m2505o(45971);
    }

    /* Access modifiers changed, original: protected */
    public C40128i cNP() {
        AppMethodBeat.m2504i(45972);
        C40128i c40128i = new C40128i(this, this.tgB, this.toE, this.pWy);
        AppMethodBeat.m2505o(45972);
        return c40128i;
    }

    /* renamed from: cu */
    public final void mo47845cu() {
        AppMethodBeat.m2504i(45973);
        this.klD = (TextView) findViewById(2131828577);
        if (this.toH != null && !C5046bo.isNullOrNil(this.toH.tzf)) {
            this.klD.setVisibility(0);
            this.klD.setText(this.toH.tzf);
            AppMethodBeat.m2505o(45973);
        } else if (this.mBundle.getInt("key_main_bankcard_state", 0) != 0) {
            this.klD.setVisibility(0);
            this.klD.setText(this.toG);
            AppMethodBeat.m2505o(45973);
        } else {
            this.klD.setVisibility(8);
            AppMethodBeat.m2505o(45973);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Hf */
    public void mo47843Hf(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(45974);
        int size = this.tgB != null ? this.tgB.size() : 0;
        C4990ab.m7417i("MicroMsg.WalletChangeBankcardUI", "on select bankcard: %s, %s", Integer.valueOf(i), Integer.valueOf(size));
        if (this.tgB == null || i >= size) {
            if (size == i) {
                C43809g cPl = C43809g.cPl();
                if (cPl.aFF()) {
                    C30379h.m48461b((Context) this, cPl.pbp, getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(45974);
                    return;
                }
                String str;
                if (this.pVL != null) {
                    i2 = this.pVL.cIf;
                }
                if (this.pVL == null) {
                    str = "";
                } else {
                    str = this.pVL.czZ;
                }
                C44422ad.m80306e(i2, str, 14, "");
                this.mBundle.putInt("key_err_code", VError.ERROR_DETECTOR_INSTANCE_INIT);
                this.mBundle.putBoolean("key_has_click_bind_new_card", true);
                C24143a.m37116j(this, this.mBundle);
            }
            AppMethodBeat.m2505o(45974);
            return;
        }
        Bankcard bankcard = (Bankcard) this.tgB.get(i);
        this.tgC = bankcard;
        if (this.pVL != null) {
            i2 = this.pVL.cIf;
        }
        C44422ad.m80306e(i2, this.pVL == null ? "" : this.pVL.czZ, 13, this.tgC.field_bindSerial);
        this.toF.tGL = bankcard.field_bindSerial;
        this.pTi.setEnabled(true);
        this.toF.notifyDataSetChanged();
        cNQ();
        AppMethodBeat.m2505o(45974);
    }

    public final boolean bwP() {
        AppMethodBeat.m2504i(45976);
        if (super.bwP()) {
            AppMethodBeat.m2505o(45976);
            return true;
        } else if (this.pVL == null || !this.pVL.mXg) {
            AppMethodBeat.m2505o(45976);
            return false;
        } else if (this.pVL.mXg) {
            AppMethodBeat.m2505o(45976);
            return true;
        } else {
            C46332s.cNC();
            if (C46332s.cND().cQg()) {
                AppMethodBeat.m2505o(45976);
                return false;
            }
            AppMethodBeat.m2505o(45976);
            return false;
        }
    }

    public final int getLayoutId() {
        return 2130971079;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean onKeyUp;
        int i2 = 0;
        AppMethodBeat.m2504i(45977);
        if (i == 4 && this.toH != null && this.tgB.size() == 0) {
            int i3;
            FavorPayInfo favorPayInfo = this.toH;
            if (favorPayInfo == null || favorPayInfo.tzc == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "favor need bankcard bind but usr cancel");
                String string = this.mBundle.getString("key_is_cur_bankcard_bind_serial");
                if (C5046bo.isNullOrNil(string)) {
                    C4990ab.m7412e("MicroMsg.WalletChangeBankcardUI", "curBankcardBindSerial null & finish");
                    onKeyUp = super.onKeyUp(i, keyEvent);
                    AppMethodBeat.m2505o(45977);
                    return onKeyUp;
                }
                ArrayList cNO = cNO();
                if (cNO != null && this.tgC == null) {
                    while (true) {
                        i3 = i2;
                        if (i3 >= cNO.size()) {
                            break;
                        } else if (string.equals(((Bankcard) cNO.get(i3)).field_bindSerial)) {
                            C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "get cur bankcard, bind_serial:".concat(String.valueOf(string)));
                            this.tgC = (Bankcard) cNO.get(i3);
                            break;
                        } else {
                            i2 = i3 + 1;
                        }
                    }
                    if (this.tgC == null) {
                        C4990ab.m7412e("MicroMsg.WalletChangeBankcardUI", "mDefaultBankcard still null & finish");
                        onKeyUp = super.onKeyUp(i, keyEvent);
                        AppMethodBeat.m2505o(45977);
                        return onKeyUp;
                    }
                }
                cNQ();
                AppMethodBeat.m2505o(45977);
                return true;
            }
        }
        onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(45977);
        return onKeyUp;
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(45978);
        Bundle bundle;
        if (i != 0 || i2 != 0) {
            bundle = new Bundle();
            bundle.putString("pwd", this.gHr);
            this.mBundle.putBoolean("key_need_verify_sms", false);
            ((C30052l) C1720g.m3528K(C30052l.class)).mo48287a(this.tms.pGr.tKd == 1, true, bundle);
            switch (i2) {
                case 100000:
                case 100001:
                case 100102:
                    this.pVL.vwi = i2;
                    cNQ();
                    AppMethodBeat.m2505o(45978);
                    return true;
                case 100100:
                case 100101:
                    this.pVL.vwi = i2;
                    if (i2 == 100100) {
                        z = true;
                    }
                    if (this.toI == null) {
                        this.toI = new C14196a(this, this);
                    }
                    this.toI.mo26486a(z, this.pVL.cBS, this.pVL.czZ);
                    C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "mRegenFingerPrintRsaKey.genRsaKey isGenRsa is ".concat(String.valueOf(z)));
                    AppMethodBeat.m2505o(45978);
                    return true;
            }
        } else if (c1207m instanceof C22530f) {
            AppMethodBeat.m2505o(45978);
            return true;
        } else if (c1207m instanceof C14157b) {
            boolean z2;
            int i3;
            Bundle bundle2 = this.mBundle;
            C14157b c14157b = (C14157b) c1207m;
            if (!C5046bo.isNullOrNil(this.gHr)) {
                bundle2.putString("key_pwd1", this.gHr);
            }
            bundle2.putString("kreq_token", c14157b.token);
            bundle2.putParcelable("key_authen", c14157b.toh);
            bundle2.putBoolean("key_need_verify_sms", !c14157b.tof);
            bundle2.putParcelable("key_pay_info", this.pVL);
            bundle2.putInt("key_pay_flag", 3);
            bundle2.putInt("key_can_verify_tail", c14157b.tol);
            bundle2.putString("key_verify_tail_wording", c14157b.tom);
            RealnameGuideHelper realnameGuideHelper = c14157b.oYc;
            Bundle bundle3 = this.mBundle;
            String str2 = "key_block_bind_new_card";
            if (c14157b.ton == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            bundle3.putBoolean(str2, z2);
            if (C5046bo.isNullOrNil(c14157b.toi)) {
                bundle2.putString("key_mobile", this.tgC.field_mobile);
            } else {
                bundle2.putString("key_mobile", c14157b.toi);
            }
            bundle2.putString("key_QADNA_URL", c14157b.toj);
            if (realnameGuideHelper != null) {
                bundle2.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            }
            bundle = new Bundle();
            bundle.putString("pwd", this.gHr);
            C30052l c30052l = (C30052l) C1720g.m3528K(C30052l.class);
            if (c30052l.bxe()) {
                i3 = 1;
            } else if (c30052l.bxh()) {
                i3 = 2;
            }
            bundle.putInt("key_open_biometric_type", i3);
            c30052l.mo48287a(c14157b.cNJ(), true, bundle);
            if (c14157b.tpw) {
                bundle2.putParcelable("key_orders", c14157b.tog);
                if (this.pVL != null && this.pVL.cIf == 8) {
                    C6553ut c6553ut = new C6553ut();
                    c6553ut.cRA.cRB = this.tms.pbo;
                    C4879a.xxA.mo10055m(c6553ut);
                }
            }
            C24143a.m37116j(this, bundle2);
            AppMethodBeat.m2505o(45978);
            return true;
        }
        AppMethodBeat.m2505o(45978);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void cNQ() {
        AppMethodBeat.m2504i(45979);
        C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "pay with old bankcard!");
        this.mBundle.getString("key_pwd1");
        this.toK = false;
        mo9439AM(4);
        this.toD = C40131q.m68800a((Context) this, this.pWy, this.toH, this.tgC, this.pVL, new C141845(), new C141856(), new C296007());
        this.toJ = this.toD;
        AppMethodBeat.m2505o(45979);
    }

    /* Access modifiers changed, original: protected */
    public void acs(String str) {
        AppMethodBeat.m2504i(45980);
        this.tms.twc = str;
        boolean z = this.mBundle.getBoolean("key_has_click_bind_new_card", false);
        int i = this.mBundle.getInt("key_pay_flag");
        if (z && i == 3) {
            C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "fix authen flag after bind card fail");
            this.tms.bJt = 3;
        }
        if (this.tgC != null) {
            this.mBundle.putString("key_mobile", this.tgC.field_mobile);
            this.mBundle.putParcelable("key_bankcard", this.tgC);
            this.tms.pbo = this.tgC.field_bindSerial;
            this.tms.pbn = this.tgC.field_bankcardType;
            if (this.toH != null) {
                this.tms.two = this.toH.tzb;
            } else {
                this.tms.two = null;
            }
            if (this.pWy.tAr != null) {
                this.tms.twn = this.pWy.tAr.tmU;
            }
            if (this.pWy != null && this.pWy.tuo == 3) {
                if (this.tgC.cPf()) {
                    this.tms.bJt = 3;
                } else {
                    this.tms.bJt = 6;
                }
                Bundle bundle = this.mBundle;
                String str2 = "key_is_oversea";
                if (this.tgC.cPf()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.mBundle.putString("key_pwd1", str);
        this.mBundle.putParcelable("key_authen", this.tms);
        C1207m a = C40071a.m68666a(this.tms, this.pWy, false);
        if (a != null) {
            a.eHT = "PayProcess";
            a.mBundle = this.mBundle;
            if (this.pVL.cIf == 6 && this.pVL.vwe == 100) {
                a.gOW = 100;
            } else {
                a.gOW = this.pVL.cIf;
            }
            mo39970a(a, true, true);
        }
        AppMethodBeat.m2505o(45980);
    }

    public final boolean cNR() {
        return true;
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(45981);
        if (i == 0) {
            bwW();
            AppMethodBeat.m2505o(45981);
        } else if (i == 1) {
            this.mBundle.putString("key_pwd1", "");
            cNQ();
            AppMethodBeat.m2505o(45981);
        } else {
            C4990ab.m7420w("MicroMsg.WalletChangeBankcardUI", "hy: clean ui data not handled");
            AppMethodBeat.m2505o(45981);
        }
    }

    public final void bwW() {
        AppMethodBeat.m2504i(45982);
        dOy();
        C40931c aE = C24143a.m37112aE(this);
        if (aE != null) {
            aE.mo8125b(this, this.mBundle);
            AppMethodBeat.m2505o(45982);
            return;
        }
        finish();
        AppMethodBeat.m2505o(45982);
    }

    public int getForceOrientation() {
        return 1;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mW */
    public final void mo47846mW(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(45983);
        this.tgB = cNO();
        if (this.toH != null) {
            int i2;
            if (this.toH.tzc != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0 && z) {
                String str = this.toH.tzd;
                ArrayList arrayList = new ArrayList();
                while (true) {
                    i2 = i;
                    if (i2 < this.tgB.size()) {
                        Bankcard bankcard = (Bankcard) this.tgB.get(i2);
                        if (C5046bo.isNullOrNil(str)) {
                            if (!bankcard.field_bankcardType.equalsIgnoreCase("CFT")) {
                                arrayList.add(bankcard);
                            }
                        } else if (bankcard.field_bankcardType.equals(str)) {
                            arrayList.add(bankcard);
                        }
                        i = i2 + 1;
                    } else {
                        this.tgB = arrayList;
                        AppMethodBeat.m2505o(45983);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(45983);
    }

    public final boolean bwQ() {
        return true;
    }

    /* renamed from: c */
    public final void mo26490c(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(45984);
        C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback");
        if (z) {
            C4990ab.m7416i("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is true");
            this.pVL.cBU = str;
            this.pVL.cBV = str2;
            acs(this.gHr);
            AppMethodBeat.m2505o(45984);
            return;
        }
        C4990ab.m7412e("MicroMsg.WalletChangeBankcardUI", "onGenFinish callback, result.isSuccess is false");
        acs(this.gHr);
        AppMethodBeat.m2505o(45984);
    }

    public void onPause() {
        AppMethodBeat.m2504i(45985);
        super.onPause();
        if (this.toJ != null) {
            this.toJ.onActivityPause();
        }
        AppMethodBeat.m2505o(45985);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45975);
        this.mBundle.putInt("key_err_code", 0);
        super.onResume();
        if (this.toJ != null) {
            this.toJ.cRm();
        }
        AppMethodBeat.m2505o(45975);
    }
}
