package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.p177mm.plugin.remittance.bankcard.model.C21625a;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C13022o;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C21624c;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C3716n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C22657a;
import com.tencent.p177mm.plugin.wallet_core.utils.C46374c;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI */
public class BankRemitMoneyInputUI extends BankRemitBaseUI {
    private String eeO;
    private Button gHn;
    private final int gnS = C1338a.fromDPToPix(C4996ah.getContext(), 270);
    private ScrollView nsk;
    private String ogi;
    private CdnImageView pMa;
    private TextView pMc;
    private WalletFormView pNA;
    private LinearLayout pNB;
    private TextView pNC;
    private TextView pND;
    private TextView pNE;
    private TextView pNF;
    private BankcardElemParcel pNG;
    private String pNH;
    private String pNI;
    private String pNJ;
    private String pNK;
    private String pNL;
    private int pNM;
    private int pNN;
    private C35503o pNO;
    private long pNP;
    private int pNQ = 0;
    private int pNR;
    private int pNS;
    private String pNn;
    private TextView pNz;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$4 */
    class C216324 implements C40947a {
        C216324() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(44633);
            if (z) {
                BankRemitMoneyInputUI.m67694e(BankRemitMoneyInputUI.this);
                AppMethodBeat.m2505o(44633);
                return;
            }
            BankRemitMoneyInputUI.this.nsk.scrollTo(0, 0);
            AppMethodBeat.m2505o(44633);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$5 */
    class C216335 implements C40929a {
        C216335() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44634);
            C4990ab.m7413e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44634);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$3 */
    class C248213 extends C24019s {
        C248213() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(44632);
            C4990ab.m7410d("MicroMsg.BankRemitMoneyInputUI", "on click next");
            if (C21625a.m33132fM(BankRemitMoneyInputUI.this.pNA.getText(), "100") <= 0.0d) {
                C4990ab.m7421w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", Double.valueOf(C21625a.m33132fM(BankRemitMoneyInputUI.this.pNA.getText(), "100")));
                Toast.makeText(BankRemitMoneyInputUI.this, C25738R.string.a4l, 1).show();
                AppMethodBeat.m2505o(44632);
                return;
            }
            BankRemitMoneyInputUI.m67693d(BankRemitMoneyInputUI.this);
            AppMethodBeat.m2505o(44632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$10 */
    class C2886610 implements OnClickListener {
        C2886610() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$1 */
    class C395901 implements TextWatcher {
        C395901() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(44630);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            obj = editable.toString();
            if (C5046bo.isNullOrNil(obj) || C5046bo.getDouble(obj, 0.0d) <= 0.0d) {
                BankRemitMoneyInputUI.this.pNB.setVisibility(8);
            } else {
                BankRemitMoneyInputUI.this.pNB.setVisibility(0);
            }
            BankRemitMoneyInputUI.m67686a(BankRemitMoneyInputUI.this, obj);
            BankRemitMoneyInputUI.m67690b(BankRemitMoneyInputUI.this);
            AppMethodBeat.m2505o(44630);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$8 */
    class C395928 implements C35502a {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$8$2 */
        class C348052 implements OnClickListener {

            /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$8$2$1 */
            class C130451 implements Runnable {
                C130451() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(44638);
                    BankRemitMoneyInputUI.this.aqX();
                    AppMethodBeat.m2505o(44638);
                }
            }

            C348052() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44639);
                C5004al.m7442n(new C130451(), 500);
                AppMethodBeat.m2505o(44639);
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI$8$1 */
        class C395931 implements C30387b {
            C395931() {
            }

            /* renamed from: s */
            public final boolean mo4760s(CharSequence charSequence) {
                AppMethodBeat.m2504i(44637);
                if (C5046bo.isNullOrNil(charSequence.toString())) {
                    BankRemitMoneyInputUI.this.eeO = null;
                    BankRemitMoneyInputUI.m67697h(BankRemitMoneyInputUI.this);
                } else {
                    BankRemitMoneyInputUI.this.eeO = charSequence.toString();
                    BankRemitMoneyInputUI.m67697h(BankRemitMoneyInputUI.this);
                }
                AppMethodBeat.m2505o(44637);
                return true;
            }
        }

        C395928() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(44640);
            C22657a.m34348a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(C25738R.string.a4w), BankRemitMoneyInputUI.this.eeO, BankRemitMoneyInputUI.this.getString(C25738R.string.do7), 20, new C395931(), new C348052());
            C7060h.pYm.mo8381e(14673, Integer.valueOf(4));
            AppMethodBeat.m2505o(44640);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BankRemitMoneyInputUI() {
        AppMethodBeat.m2504i(44642);
        AppMethodBeat.m2505o(44642);
    }

    /* renamed from: b */
    static /* synthetic */ void m67690b(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.m2504i(44652);
        bankRemitMoneyInputUI.cfi();
        AppMethodBeat.m2505o(44652);
    }

    /* renamed from: h */
    static /* synthetic */ void m67697h(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.m2504i(44657);
        bankRemitMoneyInputUI.cfm();
        AppMethodBeat.m2505o(44657);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44643);
        super.onCreate(bundle);
        dyb();
        mo39992nf(1380);
        mo39992nf(2739);
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, Integer.valueOf(10))).intValue();
        if (intValue < 0) {
            intValue = 10;
        }
        this.pNR = intValue;
        intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf(GmsVersion.VERSION_LONGHORN))).intValue();
        if (intValue <= 0) {
            intValue = GmsVersion.VERSION_LONGHORN;
        }
        this.pNS = intValue;
        C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", Integer.valueOf(this.pNR), Integer.valueOf(this.pNS));
        this.ogi = getIntent().getStringExtra("key_unique_id");
        this.pNG = (BankcardElemParcel) getIntent().getParcelableExtra("key_bank_card_elem_parcel");
        this.pNH = getIntent().getStringExtra("key_payee_name");
        this.pNI = getIntent().getStringExtra("key_bank_card_seqno");
        this.pNJ = getIntent().getStringExtra("key_bank_card_tailno");
        this.pNK = getIntent().getStringExtra("key_encrypt_data");
        this.pNM = getIntent().getIntExtra("key_enter_time_scene", 0);
        this.pNN = getIntent().getIntExtra("key_input_type", 0);
        C4990ab.m7411d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", this.ogi);
        if (this.pNG == null) {
            C4990ab.m7420w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
            this.pNG = new BankcardElemParcel();
        }
        this.pNL = this.pNG.pbn;
        initView();
        setMMTitle((int) C25738R.string.a59);
        AppMethodBeat.m2505o(44643);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44644);
        this.nsk = (ScrollView) findViewById(2131820884);
        this.pMa = (CdnImageView) findViewById(2131821672);
        this.pMc = (TextView) findViewById(2131821673);
        this.pNz = (TextView) findViewById(2131821674);
        this.pNA = (WalletFormView) findViewById(2131821675);
        this.pNB = (LinearLayout) findViewById(2131821676);
        this.pNC = (TextView) this.pNB.findViewById(2131821677);
        this.pND = (TextView) this.pNB.findViewById(2131821678);
        this.pNE = (TextView) this.pNB.findViewById(2131821679);
        this.pNF = (TextView) this.pNB.findViewById(2131821680);
        this.gHn = (Button) findViewById(2131821681);
        this.pNC.setText(getString(C25738R.string.a4h, new Object[]{this.pNG.pLO}));
        this.pMa.setUrl(this.pNG.pLH);
        this.pMc.setText(getString(C25738R.string.a51, new Object[]{this.pNG.nuL, this.pNJ}));
        this.pNz.setText(this.pNH);
        this.pNA.setTitleText(C44423ae.dOd());
        mo39989e(this.pNA, 2, false);
        this.pNA.mo64594a(new C395901());
        cfl();
        this.gHn.setOnClickListener(new C248213());
        cfi();
        this.obM = new C216324();
        AppMethodBeat.m2505o(44644);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44645);
        if (c1207m instanceof C13022o) {
            final C13022o c13022o = (C13022o) c1207m;
            c13022o.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44636);
                    C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", c13022o.pLG.nYX, c13022o.pLG.vPX);
                    C4990ab.m7411d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", c13022o.pLG.pMf, c13022o.pLG.nuL);
                    BankRemitMoneyInputUI.this.pNn = c13022o.pLG.vPX;
                    if (!BankRemitMoneyInputUI.m67688a(BankRemitMoneyInputUI.this, c13022o)) {
                        BankRemitMoneyInputUI.m67687a(BankRemitMoneyInputUI.this, c13022o.pLG.nYX, c13022o.pLG.pMf, c13022o.pLG.nuL, c13022o.pLG.pMe);
                    }
                    AppMethodBeat.m2505o(44636);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44635);
                    C4990ab.m7413e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", Integer.valueOf(c13022o.pLG.kCl), c13022o.pLG.kCm);
                    BankRemitMoneyInputUI.m67688a(BankRemitMoneyInputUI.this, c13022o);
                    AppMethodBeat.m2505o(44635);
                }
            }).mo70320c(new C216335());
        }
        AppMethodBeat.m2505o(44645);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44646);
        super.onDestroy();
        mo39993ng(1380);
        mo39993ng(2739);
        AppMethodBeat.m2505o(44646);
    }

    public final int getLayoutId() {
        return 2130968821;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44647);
        Intent intent2;
        if (i == 1) {
            C1207m c3716n;
            if (i2 == -1) {
                C4990ab.m7416i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
                intent2 = new Intent(this.mController.ylL, BankRemitDetailUI.class);
                intent2.putExtra("key_transfer_bill_id", this.pNn);
                intent2.putExtra("key_enter_scene", 0);
                startActivityForResult(intent2, 2);
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", this.pNn, str);
                mo39970a(new C21624c(this.pNn, str), false, false);
                this.pNQ = 1;
                c3716n = new C3716n(this.pNn, this.ogi, 1);
            } else if (C46374c.m87176aw(intent)) {
                finish();
                AppMethodBeat.m2505o(44647);
                return;
            } else if (C46374c.m87177ax(intent)) {
                AppMethodBeat.m2505o(44647);
                return;
            } else {
                C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", Integer.valueOf(i2));
                this.pNQ = intent.getIntExtra("key_pay_reslut_type", 0);
                c3716n = new C3716n(this.pNn, this.ogi, this.pNQ);
                C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", Integer.valueOf(this.pNQ));
            }
            mo39970a(c3716n, false, false);
            AppMethodBeat.m2505o(44647);
        } else if (i == 2) {
            C4990ab.m7410d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
            intent2 = new Intent();
            intent2.addFlags(67108864);
            C25985d.m41467b(this.mController.ylL, "offline", ".ui.WalletOfflineCoinPurseUI", intent2);
            AppMethodBeat.m2505o(44647);
        } else {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(44647);
        }
    }

    private void cfl() {
        AppMethodBeat.m2504i(44648);
        this.pNF.setClickable(true);
        this.pNF.setOnTouchListener(new C30132m(this));
        this.pNO = new C35503o(new C395928());
        cfm();
        AppMethodBeat.m2505o(44648);
    }

    private void cfm() {
        AppMethodBeat.m2504i(44649);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (C5046bo.isNullOrNil(this.eeO)) {
            spannableStringBuilder.append(getString(C25738R.string.a4w));
            spannableStringBuilder.setSpan(this.pNO, 0, spannableStringBuilder.length(), 18);
        } else {
            spannableStringBuilder.append(C44089j.m79292b(this.mController.ylL, this.eeO));
            spannableStringBuilder.append(getString(C25738R.string.a4v));
            spannableStringBuilder.setSpan(this.pNO, this.eeO.length(), spannableStringBuilder.length(), 34);
        }
        this.pNF.setText(spannableStringBuilder);
        AppMethodBeat.m2505o(44649);
    }

    private void cfi() {
        AppMethodBeat.m2504i(44650);
        if (C5046bo.getDouble(this.pNA.getText(), 0.0d) <= 0.0d || C5046bo.isNullOrNil(this.pNI) || C5046bo.isNullOrNil(this.pNJ) || C5046bo.isNullOrNil(this.pNL) || C5046bo.isNullOrNil(this.pNK)) {
            C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", this.pNA.getText(), Boolean.valueOf(C5046bo.isNullOrNil(this.pNI)), Boolean.valueOf(C5046bo.isNullOrNil(this.pNJ)), Boolean.valueOf(C5046bo.isNullOrNil(this.pNL)), Boolean.valueOf(C5046bo.isNullOrNil(this.pNK)));
            this.gHn.setEnabled(false);
            AppMethodBeat.m2505o(44650);
            return;
        }
        this.gHn.setEnabled(true);
        AppMethodBeat.m2505o(44650);
    }

    /* renamed from: d */
    static /* synthetic */ void m67693d(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.m2504i(44653);
        C4990ab.m7417i("MicroMsg.BankRemitMoneyInputUI", "do request order, money: %s, fee: %s, desc: %s, input: %s, timeScene: %s", Integer.valueOf((int) Math.round(C5046bo.getDouble(bankRemitMoneyInputUI.pNA.getText(), 0.0d) * 100.0d)), Long.valueOf(bankRemitMoneyInputUI.pNP), bankRemitMoneyInputUI.eeO, Integer.valueOf(bankRemitMoneyInputUI.pNN), Integer.valueOf(bankRemitMoneyInputUI.pNM));
        C1207m c13022o = new C13022o(bankRemitMoneyInputUI.pNI, bankRemitMoneyInputUI.pNJ, bankRemitMoneyInputUI.pNL, bankRemitMoneyInputUI.pNM, r5, bankRemitMoneyInputUI.eeO, (int) bankRemitMoneyInputUI.pNP, bankRemitMoneyInputUI.pNN, bankRemitMoneyInputUI.pNK, C5046bo.nullAsNil(bankRemitMoneyInputUI.ogi), new C1332b((bankRemitMoneyInputUI.pNn).getBytes()), bankRemitMoneyInputUI.pNQ);
        c13022o.mo70321o(bankRemitMoneyInputUI);
        bankRemitMoneyInputUI.mo39970a(c13022o, true, true);
        AppMethodBeat.m2505o(44653);
    }

    /* renamed from: e */
    static /* synthetic */ void m67694e(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.m2504i(44654);
        if (bankRemitMoneyInputUI.nsk != null) {
            final int i;
            int[] iArr = new int[2];
            bankRemitMoneyInputUI.gHn.getLocationInWindow(iArr);
            int ge = (C1338a.m2869ge(bankRemitMoneyInputUI) - i) - C1338a.fromDPToPix(bankRemitMoneyInputUI, 30);
            C4990ab.m7411d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + bankRemitMoneyInputUI.gHn.getHeight()), Integer.valueOf(C1338a.m2869ge(bankRemitMoneyInputUI)), Integer.valueOf(ge), Integer.valueOf(bankRemitMoneyInputUI.gnS));
            if (ge > 0 && ge < bankRemitMoneyInputUI.gnS) {
                i = bankRemitMoneyInputUI.gnS - ge;
                C4990ab.m7411d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                bankRemitMoneyInputUI.nsk.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(44631);
                        BankRemitMoneyInputUI.this.nsk.scrollBy(0, i);
                        AppMethodBeat.m2505o(44631);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(44654);
    }

    /* renamed from: a */
    static /* synthetic */ void m67687a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(44656);
        C4990ab.m7416i("MicroMsg.BankRemitMoneyInputUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = str;
        payInfo.cIf = 49;
        String str5 = bankRemitMoneyInputUI.getString(C25738R.string.a51, new Object[]{str3, str4}) + str2;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str5);
        payInfo.vwh = bundle;
        C35899h.m58853a(bankRemitMoneyInputUI, payInfo, 1);
        AppMethodBeat.m2505o(44656);
    }
}
