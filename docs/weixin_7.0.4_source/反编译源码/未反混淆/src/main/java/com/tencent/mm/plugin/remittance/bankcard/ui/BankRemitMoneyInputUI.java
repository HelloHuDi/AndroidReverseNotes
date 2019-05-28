package com.tencent.mm.plugin.remittance.bankcard.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI extends BankRemitBaseUI {
    private String eeO;
    private Button gHn;
    private final int gnS = a.fromDPToPix(ah.getContext(), 270);
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
    private o pNO;
    private long pNP;
    private int pNQ = 0;
    private int pNR;
    private int pNS;
    private String pNn;
    private TextView pNz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BankRemitMoneyInputUI() {
        AppMethodBeat.i(44642);
        AppMethodBeat.o(44642);
    }

    static /* synthetic */ void b(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(44652);
        bankRemitMoneyInputUI.cfi();
        AppMethodBeat.o(44652);
    }

    static /* synthetic */ void h(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(44657);
        bankRemitMoneyInputUI.cfm();
        AppMethodBeat.o(44657);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44643);
        super.onCreate(bundle);
        dyb();
        nf(1380);
        nf(2739);
        int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, Integer.valueOf(10))).intValue();
        if (intValue < 0) {
            intValue = 10;
        }
        this.pNR = intValue;
        intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf(GmsVersion.VERSION_LONGHORN))).intValue();
        if (intValue <= 0) {
            intValue = GmsVersion.VERSION_LONGHORN;
        }
        this.pNS = intValue;
        ab.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", Integer.valueOf(this.pNR), Integer.valueOf(this.pNS));
        this.ogi = getIntent().getStringExtra("key_unique_id");
        this.pNG = (BankcardElemParcel) getIntent().getParcelableExtra("key_bank_card_elem_parcel");
        this.pNH = getIntent().getStringExtra("key_payee_name");
        this.pNI = getIntent().getStringExtra("key_bank_card_seqno");
        this.pNJ = getIntent().getStringExtra("key_bank_card_tailno");
        this.pNK = getIntent().getStringExtra("key_encrypt_data");
        this.pNM = getIntent().getIntExtra("key_enter_time_scene", 0);
        this.pNN = getIntent().getIntExtra("key_input_type", 0);
        ab.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", this.ogi);
        if (this.pNG == null) {
            ab.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
            this.pNG = new BankcardElemParcel();
        }
        this.pNL = this.pNG.pbn;
        initView();
        setMMTitle((int) R.string.a59);
        AppMethodBeat.o(44643);
    }

    public final void initView() {
        AppMethodBeat.i(44644);
        this.nsk = (ScrollView) findViewById(R.id.ih);
        this.pMa = (CdnImageView) findViewById(R.id.a3g);
        this.pMc = (TextView) findViewById(R.id.a3h);
        this.pNz = (TextView) findViewById(R.id.a3i);
        this.pNA = (WalletFormView) findViewById(R.id.a3j);
        this.pNB = (LinearLayout) findViewById(R.id.a3k);
        this.pNC = (TextView) this.pNB.findViewById(R.id.a3l);
        this.pND = (TextView) this.pNB.findViewById(R.id.a3m);
        this.pNE = (TextView) this.pNB.findViewById(R.id.a3n);
        this.pNF = (TextView) this.pNB.findViewById(R.id.a3o);
        this.gHn = (Button) findViewById(R.id.a3p);
        this.pNC.setText(getString(R.string.a4h, new Object[]{this.pNG.pLO}));
        this.pMa.setUrl(this.pNG.pLH);
        this.pMc.setText(getString(R.string.a51, new Object[]{this.pNG.nuL, this.pNJ}));
        this.pNz.setText(this.pNH);
        this.pNA.setTitleText(ae.dOd());
        e(this.pNA, 2, false);
        this.pNA.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(44630);
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
                if (bo.isNullOrNil(obj) || bo.getDouble(obj, 0.0d) <= 0.0d) {
                    BankRemitMoneyInputUI.this.pNB.setVisibility(8);
                } else {
                    BankRemitMoneyInputUI.this.pNB.setVisibility(0);
                }
                BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, obj);
                BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this);
                AppMethodBeat.o(44630);
            }
        });
        cfl();
        this.gHn.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(44632);
                ab.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
                if (com.tencent.mm.plugin.remittance.bankcard.model.a.fM(BankRemitMoneyInputUI.this.pNA.getText(), "100") <= 0.0d) {
                    ab.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", Double.valueOf(com.tencent.mm.plugin.remittance.bankcard.model.a.fM(BankRemitMoneyInputUI.this.pNA.getText(), "100")));
                    Toast.makeText(BankRemitMoneyInputUI.this, R.string.a4l, 1).show();
                    AppMethodBeat.o(44632);
                    return;
                }
                BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
                AppMethodBeat.o(44632);
            }
        });
        cfi();
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(44633);
                if (z) {
                    BankRemitMoneyInputUI.e(BankRemitMoneyInputUI.this);
                    AppMethodBeat.o(44633);
                    return;
                }
                BankRemitMoneyInputUI.this.nsk.scrollTo(0, 0);
                AppMethodBeat.o(44633);
            }
        };
        AppMethodBeat.o(44644);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44645);
        if (mVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.o) {
            final com.tencent.mm.plugin.remittance.bankcard.a.o oVar = (com.tencent.mm.plugin.remittance.bankcard.a.o) mVar;
            oVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44636);
                    ab.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", oVar.pLG.nYX, oVar.pLG.vPX);
                    ab.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", oVar.pLG.pMf, oVar.pLG.nuL);
                    BankRemitMoneyInputUI.this.pNn = oVar.pLG.vPX;
                    if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar)) {
                        BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar.pLG.nYX, oVar.pLG.pMf, oVar.pLG.nuL, oVar.pLG.pMe);
                    }
                    AppMethodBeat.o(44636);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44635);
                    ab.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", Integer.valueOf(oVar.pLG.kCl), oVar.pLG.kCm);
                    BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, oVar);
                    AppMethodBeat.o(44635);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44634);
                    ab.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", mVar);
                    AppMethodBeat.o(44634);
                }
            });
        }
        AppMethodBeat.o(44645);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(44646);
        super.onDestroy();
        ng(1380);
        ng(2739);
        AppMethodBeat.o(44646);
    }

    public final int getLayoutId() {
        return R.layout.fx;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44647);
        Intent intent2;
        if (i == 1) {
            m nVar;
            if (i2 == -1) {
                ab.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
                intent2 = new Intent(this.mController.ylL, BankRemitDetailUI.class);
                intent2.putExtra("key_transfer_bill_id", this.pNn);
                intent2.putExtra("key_enter_scene", 0);
                startActivityForResult(intent2, 2);
                String str = "";
                if (intent != null) {
                    str = intent.getStringExtra("key_trans_id");
                }
                ab.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", this.pNn, str);
                a(new c(this.pNn, str), false, false);
                this.pNQ = 1;
                nVar = new n(this.pNn, this.ogi, 1);
            } else if (com.tencent.mm.plugin.wallet_core.utils.c.aw(intent)) {
                finish();
                AppMethodBeat.o(44647);
                return;
            } else if (com.tencent.mm.plugin.wallet_core.utils.c.ax(intent)) {
                AppMethodBeat.o(44647);
                return;
            } else {
                ab.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", Integer.valueOf(i2));
                this.pNQ = intent.getIntExtra("key_pay_reslut_type", 0);
                nVar = new n(this.pNn, this.ogi, this.pNQ);
                ab.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", Integer.valueOf(this.pNQ));
            }
            a(nVar, false, false);
            AppMethodBeat.o(44647);
        } else if (i == 2) {
            ab.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
            intent2 = new Intent();
            intent2.addFlags(67108864);
            d.b(this.mController.ylL, "offline", ".ui.WalletOfflineCoinPurseUI", intent2);
            AppMethodBeat.o(44647);
        } else {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(44647);
        }
    }

    private void cfl() {
        AppMethodBeat.i(44648);
        this.pNF.setClickable(true);
        this.pNF.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        this.pNO = new o(new o.a() {
            public final void df(View view) {
                AppMethodBeat.i(44640);
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(R.string.a4w), BankRemitMoneyInputUI.this.eeO, BankRemitMoneyInputUI.this.getString(R.string.do7), 20, new b() {
                    public final boolean s(CharSequence charSequence) {
                        AppMethodBeat.i(44637);
                        if (bo.isNullOrNil(charSequence.toString())) {
                            BankRemitMoneyInputUI.this.eeO = null;
                            BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this);
                        } else {
                            BankRemitMoneyInputUI.this.eeO = charSequence.toString();
                            BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this);
                        }
                        AppMethodBeat.o(44637);
                        return true;
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(44639);
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(44638);
                                BankRemitMoneyInputUI.this.aqX();
                                AppMethodBeat.o(44638);
                            }
                        }, 500);
                        AppMethodBeat.o(44639);
                    }
                });
                h.pYm.e(14673, Integer.valueOf(4));
                AppMethodBeat.o(44640);
            }
        });
        cfm();
        AppMethodBeat.o(44648);
    }

    private void cfm() {
        AppMethodBeat.i(44649);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (bo.isNullOrNil(this.eeO)) {
            spannableStringBuilder.append(getString(R.string.a4w));
            spannableStringBuilder.setSpan(this.pNO, 0, spannableStringBuilder.length(), 18);
        } else {
            spannableStringBuilder.append(j.b(this.mController.ylL, this.eeO));
            spannableStringBuilder.append(getString(R.string.a4v));
            spannableStringBuilder.setSpan(this.pNO, this.eeO.length(), spannableStringBuilder.length(), 34);
        }
        this.pNF.setText(spannableStringBuilder);
        AppMethodBeat.o(44649);
    }

    private void cfi() {
        AppMethodBeat.i(44650);
        if (bo.getDouble(this.pNA.getText(), 0.0d) <= 0.0d || bo.isNullOrNil(this.pNI) || bo.isNullOrNil(this.pNJ) || bo.isNullOrNil(this.pNL) || bo.isNullOrNil(this.pNK)) {
            ab.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", this.pNA.getText(), Boolean.valueOf(bo.isNullOrNil(this.pNI)), Boolean.valueOf(bo.isNullOrNil(this.pNJ)), Boolean.valueOf(bo.isNullOrNil(this.pNL)), Boolean.valueOf(bo.isNullOrNil(this.pNK)));
            this.gHn.setEnabled(false);
            AppMethodBeat.o(44650);
            return;
        }
        this.gHn.setEnabled(true);
        AppMethodBeat.o(44650);
    }

    static /* synthetic */ void d(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(44653);
        ab.i("MicroMsg.BankRemitMoneyInputUI", "do request order, money: %s, fee: %s, desc: %s, input: %s, timeScene: %s", Integer.valueOf((int) Math.round(bo.getDouble(bankRemitMoneyInputUI.pNA.getText(), 0.0d) * 100.0d)), Long.valueOf(bankRemitMoneyInputUI.pNP), bankRemitMoneyInputUI.eeO, Integer.valueOf(bankRemitMoneyInputUI.pNN), Integer.valueOf(bankRemitMoneyInputUI.pNM));
        m oVar = new com.tencent.mm.plugin.remittance.bankcard.a.o(bankRemitMoneyInputUI.pNI, bankRemitMoneyInputUI.pNJ, bankRemitMoneyInputUI.pNL, bankRemitMoneyInputUI.pNM, r5, bankRemitMoneyInputUI.eeO, (int) bankRemitMoneyInputUI.pNP, bankRemitMoneyInputUI.pNN, bankRemitMoneyInputUI.pNK, bo.nullAsNil(bankRemitMoneyInputUI.ogi), new com.tencent.mm.bt.b((bankRemitMoneyInputUI.pNn).getBytes()), bankRemitMoneyInputUI.pNQ);
        oVar.o(bankRemitMoneyInputUI);
        bankRemitMoneyInputUI.a(oVar, true, true);
        AppMethodBeat.o(44653);
    }

    static /* synthetic */ void e(BankRemitMoneyInputUI bankRemitMoneyInputUI) {
        AppMethodBeat.i(44654);
        if (bankRemitMoneyInputUI.nsk != null) {
            final int i;
            int[] iArr = new int[2];
            bankRemitMoneyInputUI.gHn.getLocationInWindow(iArr);
            int ge = (a.ge(bankRemitMoneyInputUI) - i) - a.fromDPToPix(bankRemitMoneyInputUI, 30);
            ab.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + bankRemitMoneyInputUI.gHn.getHeight()), Integer.valueOf(a.ge(bankRemitMoneyInputUI)), Integer.valueOf(ge), Integer.valueOf(bankRemitMoneyInputUI.gnS));
            if (ge > 0 && ge < bankRemitMoneyInputUI.gnS) {
                i = bankRemitMoneyInputUI.gnS - ge;
                ab.d("MicroMsg.BankRemitMoneyInputUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                bankRemitMoneyInputUI.nsk.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44631);
                        BankRemitMoneyInputUI.this.nsk.scrollBy(0, i);
                        AppMethodBeat.o(44631);
                    }
                });
            }
        }
        AppMethodBeat.o(44654);
    }

    static /* synthetic */ void a(BankRemitMoneyInputUI bankRemitMoneyInputUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(44656);
        ab.i("MicroMsg.BankRemitMoneyInputUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = str;
        payInfo.cIf = 49;
        String str5 = bankRemitMoneyInputUI.getString(R.string.a51, new Object[]{str3, str4}) + str2;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str5);
        payInfo.vwh = bundle;
        com.tencent.mm.pluginsdk.wallet.h.a(bankRemitMoneyInputUI, payInfo, 1);
        AppMethodBeat.o(44656);
    }
}
