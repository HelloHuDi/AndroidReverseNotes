package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.a.aa;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet.balance.a.a.p.a;
import com.tencent.mm.plugin.wallet.balance.a.a.x;
import com.tencent.mm.plugin.wallet.balance.a.a.y;
import com.tencent.mm.plugin.wallet.balance.a.a.z;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.azb;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtSaveFetchUI extends WalletLqtBasePresenterUI {
    private int accountType;
    private Dialog gnn;
    private int mode;
    private HashMap<String, Integer> pas = new HashMap();
    private Bankcard tgC;
    private x tgd = ((x) Z(x.class));
    private y tge = ((y) V(y.class));
    private TextView tkA;
    private WalletLqtArriveTimeLayout tkB;
    private ScrollView tkC;
    private WcPayKeyboard tkD;
    private CharSequence tkE;
    private Bankcard tkF;
    private int tkG;
    private String tkH;
    private String tkI;
    private long tkJ = -1;
    private String tkK;
    private boolean tkL = false;
    private List<Bankcard> tkM;
    private boolean tkN = true;
    private a tkO = new a() {
        public final void cMI() {
            AppMethodBeat.i(45663);
            WalletLqtSaveFetchUI.this.cNm();
            AppMethodBeat.o(45663);
        }
    };
    private z tkm = new z(this.tgd, this.tge, this);
    private aa tkn = new aa(this.tkm);
    private ViewGroup tko;
    private WalletFormView tkp;
    private TextView tkq;
    private TextView tkr;
    private ImageView tks;
    private TextView tkt;
    private TextView tku;
    private ViewGroup tkv;
    private TextView tkw;
    private CheckBox tkx;
    private TextView tky;
    private TextView tkz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtSaveFetchUI() {
        AppMethodBeat.i(45676);
        AppMethodBeat.o(45676);
    }

    static /* synthetic */ double gI(String str, String str2) {
        AppMethodBeat.i(45699);
        double gG = gG(str, str2);
        AppMethodBeat.o(45699);
        return gG;
    }

    static /* synthetic */ int gJ(String str, String str2) {
        AppMethodBeat.i(45708);
        int gH = gH(str, str2);
        AppMethodBeat.o(45708);
        return gH;
    }

    static /* synthetic */ void i(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(45701);
        walletLqtSaveFetchUI.mP(false);
        AppMethodBeat.o(45701);
    }

    static /* synthetic */ List k(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(45703);
        List cNo = walletLqtSaveFetchUI.cNo();
        AppMethodBeat.o(45703);
        return cNo;
    }

    static /* synthetic */ void m(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(45706);
        walletLqtSaveFetchUI.cNp();
        AppMethodBeat.o(45706);
    }

    public final void cNm() {
        AppMethodBeat.i(45678);
        if (this.mode == 1) {
            this.tkF = p.tfu.cMF();
            if (this.tkF == null) {
                s.cNC();
                this.tkF = s.cND().thy;
            }
            if (this.tkF != null) {
                String cMG = p.tfu.cMG();
                int cMH = p.tfu.cMH();
                if (cMH == 0) {
                    this.tkE = cMG;
                } else if (cMH == 1) {
                    cMH = cMG.length();
                    SpannableString spannableString = new SpannableString(cMG + getString(R.string.fhy));
                    spannableString.setSpan(new a(new a.a() {
                        public final void aos() {
                            AppMethodBeat.i(45667);
                            WalletLqtSaveFetchUI.this.tkp.setText(e.F(WalletLqtSaveFetchUI.this.tkF.twS));
                            WalletLqtSaveFetchUI.this.dOA();
                            AppMethodBeat.o(45667);
                        }
                    }), cMH + 1, spannableString.length(), 18);
                    this.tkE = spannableString;
                } else {
                    ab.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", Integer.valueOf(cMH));
                    this.tkE = cMG;
                }
                if (this.tkt != null) {
                    this.tkt.setText(this.tkE);
                }
            }
            if (this.tko != null) {
                this.tko.setVisibility(0);
            }
        }
        mP(true);
        AppMethodBeat.o(45678);
    }

    private void cNn() {
        AppMethodBeat.i(45679);
        WalletLqtArriveTimeLayout walletLqtArriveTimeLayout = this.tkB;
        walletLqtArriveTimeLayout.thY = false;
        if (walletLqtArriveTimeLayout.thU != null) {
            walletLqtArriveTimeLayout.thU.clear();
        }
        walletLqtArriveTimeLayout.thW = null;
        walletLqtArriveTimeLayout.thV.clear();
        walletLqtArriveTimeLayout.setVisibility(4);
        AppMethodBeat.o(45679);
    }

    private void t(boolean z, String str) {
        AppMethodBeat.i(45680);
        ab.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", Boolean.valueOf(z));
        if (this.mode == 2) {
            if (this.tkB.thY) {
                this.tkB.acj(str);
            } else {
                bfi bfi = com.tencent.mm.plugin.wallet.balance.a.a.s.cMK().tfI;
                if (bfi == null) {
                    ab.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
                    AppMethodBeat.o(45680);
                    return;
                }
                boolean z2;
                if (this.tgC.cPc()) {
                    ab.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
                    this.tkB.setRedeemTypeList(bfi.wJf);
                    this.tkB.acj(str);
                    if (!(bfi.wJf == null || bfi.wJf.isEmpty())) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (bfi.wJg != null) {
                        Iterator it = bfi.wJg.iterator();
                        z2 = false;
                        while (it.hasNext()) {
                            boolean z3;
                            hc hcVar = (hc) it.next();
                            if (hcVar.vJF.equals(this.tgC.field_bindSerial)) {
                                ab.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                                this.tkB.setRedeemTypeList(hcVar.vJL);
                                this.tkB.acj(str);
                                if (!(hcVar.vJL == null || hcVar.vJL.isEmpty())) {
                                    z3 = true;
                                    z2 = z3;
                                }
                            }
                            z3 = z2;
                            z2 = z3;
                        }
                    }
                    z2 = false;
                }
                ab.d("MicroMsg.WalletLqtSaveFetchUI", "show title: %s", Boolean.valueOf(z2));
                cNp();
                AppMethodBeat.o(45680);
                return;
            }
        }
        AppMethodBeat.o(45680);
    }

    private void mP(boolean z) {
        Bankcard bankcard;
        int i;
        String str;
        AppMethodBeat.i(45681);
        List mJ = p.tfu.mJ(this.mode == 1);
        if (mJ == null || mJ.size() == 0) {
            s.cNC();
            mJ = s.cND().cQF();
        }
        LinkedList linkedList = new LinkedList();
        if (mJ != null) {
            for (Bankcard bankcard2 : mJ) {
                if (bankcard2.cPc()) {
                    s.cNC();
                    if (!s.cND().cQi()) {
                        linkedList.add(bankcard2);
                    }
                }
                if (this.mode == 1 && bankcard2.field_support_lqt_turn_in == 1) {
                    linkedList.add(bankcard2);
                }
                if (this.mode == 2 && bankcard2.field_support_lqt_turn_out == 1) {
                    linkedList.add(bankcard2);
                }
            }
        }
        if (z) {
            boolean z2;
            p pVar = p.tfu;
            if (this.mode == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.tgC = pVar.mI(z2);
            if (!bo.isNullOrNil(this.tkK) && this.tgC == null) {
                for (i = 0; i < linkedList.size(); i++) {
                    bankcard2 = (Bankcard) linkedList.get(i);
                    if (!bo.isNullOrNil(bankcard2.field_bindSerial) && this.tkK.equals(bankcard2.field_bindSerial)) {
                        this.tgC = bankcard2;
                    }
                }
            }
        } else if (!bo.isNullOrNil(this.tkK)) {
            for (i = 0; i < linkedList.size(); i++) {
                bankcard2 = (Bankcard) linkedList.get(i);
                if (!bo.isNullOrNil(bankcard2.field_bindSerial) && this.tkK.equals(bankcard2.field_bindSerial)) {
                    this.tgC = bankcard2;
                }
            }
        }
        String str2 = "MicroMsg.WalletLqtSaveFetchUI";
        String str3 = "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s";
        Object[] objArr = new Object[3];
        objArr[0] = this.tgC != null ? this.tgC.field_bindSerial : "";
        objArr[1] = this.tkK;
        objArr[2] = Boolean.valueOf(z);
        ab.i(str2, str3, objArr);
        if (this.tgC == null) {
            s.cNC();
            this.tgC = s.cND().thy;
            if (this.tgC == null) {
                finish();
                AppMethodBeat.o(45681);
                return;
            }
        }
        if (this.tgC.cPc()) {
            this.tkr.setText(this.tgC.field_desc);
        } else {
            this.tkr.setText(getString(R.string.f9r, new Object[]{this.tgC.field_bankName, this.tgC.field_bankcardTail}));
        }
        this.tkr.setText(this.tgC.field_desc);
        this.tkr.setVisibility(0);
        this.tks.setTag(this.tgC.field_bindSerial);
        if (this.tks != null) {
            str = "";
            com.tencent.mm.plugin.wallet_core.model.e i2 = b.i(this, this.tgC.field_bankcardType, this.tgC.cPb());
            if (i2 != null) {
                str = i2.oRi;
            }
            this.tks.setImageBitmap(null);
            if (this.tgC.cPc()) {
                this.tks.setImageResource(R.drawable.bki);
            } else {
                Bitmap a = com.tencent.mm.platformtools.x.a(new c(str));
                com.tencent.mm.platformtools.x.a(new com.tencent.mm.platformtools.x.a() {
                    public final void m(String str, final Bitmap bitmap) {
                        AppMethodBeat.i(45671);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(45670);
                                if (!(WalletLqtSaveFetchUI.this.tgC == null || WalletLqtSaveFetchUI.this.tks == null || WalletLqtSaveFetchUI.this.tks.getTag() == null || !WalletLqtSaveFetchUI.this.tks.getTag().equals(WalletLqtSaveFetchUI.this.tgC.field_bindSerial))) {
                                    WalletLqtSaveFetchUI.this.tks.setImageBitmap(bitmap);
                                }
                                AppMethodBeat.o(45670);
                            }
                        });
                        AppMethodBeat.o(45671);
                    }
                });
                if (a != null) {
                    this.tks.setImageBitmap(d.a(a, getResources().getDimensionPixelOffset(R.dimen.aaq), getResources().getDimensionPixelOffset(R.dimen.aaq), true, false));
                }
            }
        }
        this.tky.setVisibility(8);
        this.tkz.setVisibility(8);
        if (!(this.mode == 2 || this.mode != 1 || this.tgC.cPc() || bo.isNullOrNil(this.tgC.field_avail_save_wording))) {
            this.tky.setText(this.tgC.field_avail_save_wording);
            this.tky.setVisibility(0);
        }
        String string;
        SpannableString spannableString;
        if (this.mode == 1) {
            setMMTitle(getString(R.string.fjx));
            final ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("lqt_protocol_list");
            boolean booleanExtra = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || !booleanExtra) {
                this.tkv.setVisibility(8);
            } else {
                this.tkv.setVisibility(0);
                this.tkx.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
                this.tkv.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(45647);
                        WalletLqtSaveFetchUI.this.tkx.setChecked(!WalletLqtSaveFetchUI.this.tkx.isChecked());
                        AppMethodBeat.o(45647);
                    }
                });
                this.tkx.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(45648);
                        if (z) {
                            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, true);
                            AppMethodBeat.o(45648);
                            return;
                        }
                        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, false);
                        AppMethodBeat.o(45648);
                    }
                });
                string = getString(R.string.fjl);
                i = string.length();
                spannableString = new SpannableString(string + getString(R.string.fjm));
                spannableString.setSpan(new a(new a.a() {
                    public final void aos() {
                        AppMethodBeat.i(45651);
                        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(WalletLqtSaveFetchUI.this, 1, false);
                        dVar.rBl = new n.c() {
                            public final void a(l lVar) {
                                AppMethodBeat.i(45649);
                                Iterator it = stringArrayListExtra.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    lVar.add(0, i, 0, ((String) it.next()).split("\\|\\|")[0]);
                                    i++;
                                }
                                AppMethodBeat.o(45649);
                            }
                        };
                        dVar.rBm = new n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(45650);
                                int itemId = menuItem.getItemId();
                                if (itemId < stringArrayListExtra.size()) {
                                    e.n(WalletLqtSaveFetchUI.this, ((String) stringArrayListExtra.get(itemId)).split("\\|\\|")[1], false);
                                }
                                AppMethodBeat.o(45650);
                            }
                        };
                        dVar.cpD();
                        AppMethodBeat.o(45651);
                    }
                }), i, spannableString.length(), 17);
                this.tkw.setText(spannableString);
                this.tkw.setClickable(true);
                this.tkw.setOnTouchListener(new m());
            }
        } else if (this.mode == 2) {
            findViewById(R.id.fc7).setVisibility(8);
            this.tkv.setVisibility(8);
            setMMTitle(getString(R.string.fir));
            this.tku.setVisibility(8);
            final com.tencent.mm.plugin.wallet.balance.a.a.s cMK = com.tencent.mm.plugin.wallet.balance.a.a.s.cMK();
            int i3;
            if (this.tgC == null || !this.tgC.cPc()) {
                if (cMK.tfI == null) {
                    i3 = 0;
                } else {
                    i3 = cMK.tfI.wJb;
                }
                i = cMK.tfI == null ? 0 : cMK.tfI.wJd;
                if (ae.gjv) {
                    i3 = 100000000;
                    i = 50000000;
                }
                str = getString(R.string.fim, new Object[]{Double.valueOf(gG(String.valueOf(i3), "100")), Double.valueOf(gG(String.valueOf(i), "100"))});
                int length = str.length();
                SpannableString spannableString2 = new SpannableString(str + getString(R.string.fin));
                spannableString2.setSpan(new a(new a.a() {
                    public final void aos() {
                        AppMethodBeat.i(45669);
                        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, cMK.tfI);
                        AppMethodBeat.o(45669);
                    }
                }), length, spannableString2.length(), 18);
                this.tkE = spannableString2;
                this.tkt.setText(spannableString2);
            } else {
                i3 = getIntent().getIntExtra("lqt_balance", 0);
                if (ae.gjv) {
                    i3 = 50000000;
                }
                if (i3 > 0) {
                    string = getString(R.string.fil, new Object[]{Double.valueOf(gG(String.valueOf(i3), "100"))});
                    i = string.length();
                    spannableString = new SpannableString(string + getString(R.string.fio));
                    spannableString.setSpan(new a(new a.a() {
                        public final void aos() {
                            AppMethodBeat.i(45668);
                            WalletLqtSaveFetchUI.this.tkp.setText(e.F(WalletLqtSaveFetchUI.gI(i3, "100")));
                            WalletLqtSaveFetchUI.this.dOA();
                            AppMethodBeat.o(45668);
                        }
                    }), i, spannableString.length(), 18);
                    this.tkE = spannableString;
                    this.tkt.setText(spannableString);
                }
            }
        }
        if (this.mode == 1) {
            if (this.tgC == null || !this.tgC.cPc()) {
                this.tkt.setText("");
            } else {
                this.tkt.setText(this.tkE);
                AppMethodBeat.o(45681);
                return;
            }
        }
        AppMethodBeat.o(45681);
    }

    private List<Bankcard> cNo() {
        AppMethodBeat.i(45682);
        List mJ = p.tfu.mJ(this.mode == 1);
        if (mJ == null || mJ.size() == 0) {
            s.cNC();
            mJ = s.cND().cQF();
        }
        LinkedList linkedList = new LinkedList();
        if (mJ != null) {
            for (Bankcard bankcard : mJ) {
                if (bankcard.cPc()) {
                    s.cNC();
                    if (!s.cND().cQi()) {
                        linkedList.add(bankcard);
                    }
                }
                if (this.mode == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.cPc())) {
                    linkedList.add(bankcard);
                }
                if (this.mode == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.cPc())) {
                    linkedList.add(bankcard);
                }
            }
        }
        AppMethodBeat.o(45682);
        return linkedList;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(45683);
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
        super.onNewIntent(intent);
        final List cNo = cNo();
        if (this.mode == 1) {
            this.tkn.tgs.gf(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45645);
                    for (Bankcard bankcard : WalletLqtSaveFetchUI.k(WalletLqtSaveFetchUI.this)) {
                        Object obj2;
                        for (Bankcard bankcard2 : cNo) {
                            if (bankcard.field_bindSerial.equals(bankcard2.field_bindSerial)) {
                                obj2 = 1;
                                continue;
                                break;
                            }
                        }
                        obj2 = null;
                        continue;
                        if (obj2 == null) {
                            WalletLqtSaveFetchUI.this.tkK = bankcard.field_bindSerial;
                            break;
                        }
                    }
                    WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this);
                    Void voidR = zXH;
                    AppMethodBeat.o(45645);
                    return voidR;
                }
            });
        }
        AppMethodBeat.o(45683);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(45684);
        if (this.tkD.isShown() && bo.isNullOrNil(this.tkp.getText())) {
            dOz();
            AppMethodBeat.o(45684);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(45684);
        return onKeyUp;
    }

    private void cNp() {
        AppMethodBeat.i(45685);
        this.tkC.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(45664);
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                WalletLqtSaveFetchUI.this.findViewById(R.id.fc4).getLocationInWindow(iArr);
                WalletLqtSaveFetchUI.this.tkC.getLocationInWindow(iArr2);
                ab.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", Integer.valueOf(iArr[1] - iArr2[1]));
                WalletLqtSaveFetchUI.this.tkC.scrollBy(0, iArr[1] - iArr2[1]);
                AppMethodBeat.o(45664);
            }
        }, 100);
        AppMethodBeat.o(45685);
    }

    private void mQ(boolean z) {
        AppMethodBeat.i(45686);
        this.tkD.Aff.setEnabled(z);
        AppMethodBeat.o(45686);
    }

    private void mR(boolean z) {
        AppMethodBeat.i(45687);
        if (z) {
            if (this.mode == 1) {
                if (this.tkv.getVisibility() != 0) {
                    if (this.tkL) {
                        mQ(true);
                        AppMethodBeat.o(45687);
                        return;
                    }
                    AppMethodBeat.o(45687);
                } else if (this.tkx.isChecked() && this.tkL) {
                    mQ(true);
                    AppMethodBeat.o(45687);
                    return;
                } else {
                    mQ(false);
                    AppMethodBeat.o(45687);
                    return;
                }
            } else if (this.tkL && this.tkB.getVisibility() == 0 && (this.tkB.getSelectRedeemType() != null || this.tkB.getRedeemTypeList() == null || this.tkB.getRedeemTypeList().isEmpty())) {
                String str = "MicroMsg.WalletLqtSaveFetchUI";
                String str2 = "redeem type: %s";
                Object[] objArr = new Object[1];
                objArr[0] = this.tkB.getSelectRedeemType() == null ? null : Integer.valueOf(this.tkB.getSelectRedeemType().wOl);
                ab.v(str, str2, objArr);
                mQ(true);
                AppMethodBeat.o(45687);
                return;
            }
        }
        mQ(false);
        AppMethodBeat.o(45687);
    }

    public void onResume() {
        AppMethodBeat.i(45688);
        super.onResume();
        AppMethodBeat.o(45688);
    }

    public final int getLayoutId() {
        return R.layout.b4w;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45689);
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            this.tkn.tgs.gf(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a<Object, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45666);
                    WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.this.tkp.getText());
                    AppMethodBeat.o(45666);
                    return null;
                }
            });
            AppMethodBeat.o(45689);
            return;
        }
        z zVar = this.tkm;
        String str;
        if (i == z.tgb && i2 == -1) {
            Orders orders = (Orders) intent.getParcelableExtra("key_orders");
            if (!(orders == null || orders.tAq == null || orders.tAq.size() <= 0)) {
                ab.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", Integer.valueOf(zVar.hashCode()), Integer.valueOf(zVar.accountType), orders.czZ);
                zVar.cAa = ((Commodity) orders.tAq.get(0)).cAa;
                str = (String) zVar.tgl.get(orders.czZ);
                if (!bo.isNullOrNil(str)) {
                    zVar.tgg = str;
                }
                ab.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
                zVar.tgf.mS(false);
                str = zVar.tgf.getIntent().getStringExtra("operate_id");
                f.a(zVar.tgg, zVar.cAa, Integer.valueOf(zVar.tgh), Integer.valueOf(zVar.accountType), str).c(zVar.tge.tfX).f(new com.tencent.mm.vending.c.a<Void, bnp>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(45313);
                        bnp bnp = (bnp) obj;
                        ab.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult finish: %s", bnp);
                        z.this.tgf.aDw();
                        z.this.tgf.cNq();
                        if (z.this.glt != null) {
                            z.this.glt.B(bnp);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(45313);
                        return voidR;
                    }
                }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                    public final void bi(Object obj) {
                        AppMethodBeat.i(45312);
                        ab.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", obj);
                        z.this.tgf.aDw();
                        if (z.this.glt != null) {
                            z.this.glt.cR(obj);
                        }
                        AppMethodBeat.o(45312);
                    }
                });
            }
            AppMethodBeat.o(45689);
            return;
        }
        if (i == z.tgc && i2 == -1) {
            str = intent.getStringExtra("lqt_fetch_enc_pwd");
            ab.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", Integer.valueOf(zVar.hashCode()), Integer.valueOf(zVar.accountType), intent.getStringExtra("lqt_redeem_listid"));
            ab.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", Integer.valueOf(zVar.hashCode()), r1);
            if (bo.isNullOrNil(zVar.tgj)) {
                ab.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", Integer.valueOf(zVar.hashCode()), r1);
                zVar.tgj = r1;
            }
            String stringExtra = zVar.tgf.getIntent().getStringExtra("operate_id");
            zVar.tgf.mS(true);
            y.c cVar = zVar.tge.tfY;
            int i3 = zVar.tgi;
            f.a(Integer.valueOf(i3), str, zVar.tgj, Integer.valueOf(zVar.accountType), stringExtra).c(cVar).f(new com.tencent.mm.vending.c.a<Void, bqq>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45315);
                    bqq bqq = (bqq) obj;
                    ab.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund finish: %s", Integer.valueOf(z.this.hashCode()), bqq);
                    z.this.tgf.aDw();
                    z.this.tgf.cNq();
                    if (z.this.glt != null) {
                        z.this.glt.B(bqq);
                    }
                    Void voidR = zXH;
                    AppMethodBeat.o(45315);
                    return voidR;
                }
            }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(45314);
                    ab.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund interrupt: %s", obj);
                    z.this.tgf.aDw();
                    if (z.this.glt != null) {
                        z.this.glt.cR(obj);
                    }
                    AppMethodBeat.o(45314);
                }
            });
        }
        AppMethodBeat.o(45689);
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(45690);
        z zVar = this.tkm;
        ab.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.y) {
            s.cNC();
            zVar.tgk = s.cND().thy;
            if (zVar.glt != null) {
                zVar.glt.B(mVar);
                zVar.glt.resume();
            }
        }
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
        cNm();
        boolean c = super.c(i, i2, str, mVar);
        AppMethodBeat.o(45690);
        return c;
    }

    public final void mS(boolean z) {
        AppMethodBeat.i(45691);
        if (this.gnn == null || !this.gnn.isShowing()) {
            if (z) {
                this.gnn = g.a((Context) this, false, null);
                AppMethodBeat.o(45691);
                return;
            }
            this.gnn = g.b(this, false, null);
        }
        AppMethodBeat.o(45691);
    }

    public final void aDw() {
        AppMethodBeat.i(45692);
        if (this.gnn != null) {
            this.gnn.dismiss();
        }
        AppMethodBeat.o(45692);
    }

    public final void cNq() {
        boolean z = true;
        AppMethodBeat.i(45693);
        if (this.mode == 1) {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC, this.tkK);
        } else {
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_LQT_DEFAULTCARD_FETCH_STRING_SYNC, this.tkK);
        }
        p pVar = p.tfu;
        if (this.mode != 1) {
            z = false;
        }
        if (pVar.mH(z)) {
            ab.i("MicroMsg.WalletLqtSaveFetchUI", "saveOrfetchDone, req again after deal");
            this.tkn.tgs.gf(this.mode, this.accountType);
        }
        AppMethodBeat.o(45693);
    }

    public final void Vz(String str) {
        AppMethodBeat.i(45694);
        Toast.makeText(this, str, 1).show();
        AppMethodBeat.o(45694);
    }

    public void onDestroy() {
        AppMethodBeat.i(45695);
        super.onDestroy();
        p pVar = p.tfu;
        pVar.tft.remove(this.tkO);
        this.tkm = null;
        this.tkn = null;
        AppMethodBeat.o(45695);
    }

    private static double gG(String str, String str2) {
        double d = 0.0d;
        AppMethodBeat.i(45696);
        try {
            d = new BigDecimal(bo.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 5, 2).doubleValue();
            AppMethodBeat.o(45696);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            AppMethodBeat.o(45696);
        }
        return d;
    }

    private static int gH(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(45697);
        try {
            double d = bo.getDouble(str, 0.0d);
            double d2 = bo.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            i = bigDecimal.multiply(new BigDecimal(str2)).intValue();
            AppMethodBeat.o(45697);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            AppMethodBeat.o(45697);
        }
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45677);
        this.yll = true;
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.a5));
        dyb();
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
        this.tkp = (WalletFormView) findViewById(R.id.fc5);
        this.tks = (ImageView) findViewById(R.id.f60);
        this.tkt = (TextView) findViewById(R.id.fc6);
        this.tku = (TextView) findViewById(R.id.fc8);
        this.tkq = (TextView) findViewById(R.id.fc4);
        this.tkr = (TextView) findViewById(R.id.fc2);
        this.tkA = (TextView) findViewById(R.id.dc);
        this.tkv = (ViewGroup) findViewById(R.id.fc_);
        this.tkw = (TextView) findViewById(R.id.fcb);
        this.tkx = (CheckBox) findViewById(R.id.fca);
        this.tko = (ViewGroup) findViewById(R.id.c6f);
        this.tky = (TextView) findViewById(R.id.f62);
        this.tkz = (TextView) findViewById(R.id.f63);
        this.tkB = (WalletLqtArriveTimeLayout) findViewById(R.id.fc9);
        this.tkC = (ScrollView) findViewById(R.id.fc0);
        this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
        this.tkG = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
        this.tkH = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
        this.tkI = getIntent().getStringExtra("lqt_profile_wording");
        this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
        if (this.mode == 1) {
            com.tencent.mm.kernel.g.RQ();
            this.tkK = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC, (Object) "");
        } else {
            com.tencent.mm.kernel.g.RQ();
            this.tkK = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_LQT_DEFAULTCARD_FETCH_STRING_SYNC, (Object) "");
        }
        if (bo.isNullOrNil(this.tkK)) {
            com.tencent.mm.kernel.g.RQ();
            this.tkK = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_LQT_DEFAULTCARD_STRING_SYNC, (Object) "");
        }
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.tkK);
        this.tkp.getTitleTv().setText(com.tencent.mm.wallet_core.c.ae.dOd());
        this.tkD = (WcPayKeyboard) findViewById(R.id.fjg);
        if (this.mode == 1) {
            e(this.tkp.getContentEt());
            this.tkD.setActionText(getString(R.string.fjx));
        } else {
            this.Ahz = false;
            e(this.tkp.getContentEt());
            this.tkD.setActionText(getString(R.string.fiq));
        }
        if (this.mode == 1) {
            this.tkq.setText(getString(R.string.fjq));
            this.tkA.setText(getString(R.string.fjt));
        } else if (this.mode == 2) {
            this.tkq.setText(getString(R.string.fi_));
            this.tkA.setText(getString(R.string.fie));
        }
        this.tkp.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(45652);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 12) {
                    editable.delete(12, indexOf);
                } else if (indexOf == -1 && length > 12) {
                    editable.delete(12, length);
                }
                WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, editable.toString());
                AppMethodBeat.o(45652);
            }
        });
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(45653);
                if (!z) {
                    WalletLqtSaveFetchUI.this.tkC.scrollTo(0, 0);
                    if (WalletLqtSaveFetchUI.this.mode == 2 && bo.isNullOrNil(WalletLqtSaveFetchUI.this.tkp.getText())) {
                        WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
                    }
                } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                    WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this);
                    AppMethodBeat.o(45653);
                    return;
                } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                    WalletLqtSaveFetchUI.m(WalletLqtSaveFetchUI.this);
                    AppMethodBeat.o(45653);
                    return;
                }
                AppMethodBeat.o(45653);
            }
        };
        final AnonymousClass9 anonymousClass9 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45660);
                if (bo.az(WalletLqtSaveFetchUI.this.tkJ) < 800) {
                    ab.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
                    AppMethodBeat.o(45660);
                    return;
                }
                WalletLqtSaveFetchUI.this.tkJ = bo.yz();
                final int gJ = WalletLqtSaveFetchUI.gJ(WalletLqtSaveFetchUI.this.tkp.getText(), "100");
                if (gJ > 0) {
                    WalletLqtSaveFetchUI.this.dOz();
                    int q;
                    if (WalletLqtSaveFetchUI.this.mode == 1) {
                        ab.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
                        aa.c cVar = WalletLqtSaveFetchUI.this.tkn.tgp;
                        q = WalletLqtSaveFetchUI.this.accountType;
                        f.h(Integer.valueOf(gJ), Integer.valueOf(q), WalletLqtSaveFetchUI.this.tgC).c(cVar).f(new com.tencent.mm.vending.c.a<Void, bnp>() {
                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.i(45656);
                                Void a = a((bnp) obj);
                                AppMethodBeat.o(45656);
                                return a;
                            }

                            private Void a(bnp bnp) {
                                AppMethodBeat.i(45655);
                                ab.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", Integer.valueOf(bnp.wQn));
                                Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                                intent.putExtra("key_amount", e.b(gJ, "100", RoundingMode.HALF_UP));
                                intent.putExtra("key_mode", 1);
                                intent.putExtra("profile_date_wording", bnp.wQp);
                                intent.putExtra("profile_upgrade_wording", bnp.wQo);
                                if (bnp.wQq != null) {
                                    try {
                                        intent.putExtra("key_guide_cell", bnp.wQq.toByteArray());
                                    } catch (IOException e) {
                                        ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
                                    }
                                }
                                WalletLqtSaveFetchUI.this.startActivity(intent);
                                WalletLqtSaveFetchUI.this.finish();
                                Void voidR = zXH;
                                AppMethodBeat.o(45655);
                                return voidR;
                            }
                        }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                            public final void bi(Object obj) {
                                AppMethodBeat.i(45654);
                                ab.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", obj);
                                WalletLqtSaveFetchUI.this.aDw();
                                if (obj != null) {
                                    String obj2;
                                    if (obj instanceof String) {
                                        obj2 = obj.toString();
                                    } else {
                                        obj2 = WalletLqtSaveFetchUI.this.getString(R.string.fiu);
                                    }
                                    WalletLqtSaveFetchUI.this.Vz(obj2);
                                }
                                AppMethodBeat.o(45654);
                            }
                        });
                        AppMethodBeat.o(45660);
                        return;
                    } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                        ab.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
                        Object obj = null;
                        if (!(WalletLqtSaveFetchUI.this.tgC == null || WalletLqtSaveFetchUI.this.tgC.cPc())) {
                            obj = new ha();
                            obj.nuL = WalletLqtSaveFetchUI.this.tgC.field_bankName;
                            obj.pbn = WalletLqtSaveFetchUI.this.tgC.field_bankcardType;
                            obj.vJF = WalletLqtSaveFetchUI.this.tgC.field_bindSerial;
                            obj.pck = WalletLqtSaveFetchUI.this.tgC.field_bankcardTail;
                        }
                        q = -1;
                        if (WalletLqtSaveFetchUI.this.tkB.getSelectRedeemType() != null) {
                            q = WalletLqtSaveFetchUI.this.tkB.getSelectRedeemType().wOl;
                        }
                        f.b(Integer.valueOf(gJ), Integer.valueOf(WalletLqtSaveFetchUI.this.accountType), Integer.valueOf(q), obj).c(WalletLqtSaveFetchUI.this.tkn.tgq).f(new com.tencent.mm.vending.c.a<Void, bqq>() {
                            public final /* synthetic */ Object call(Object obj) {
                                AppMethodBeat.i(45659);
                                Void a = a((bqq) obj);
                                AppMethodBeat.o(45659);
                                return a;
                            }

                            private Void a(bqq bqq) {
                                AppMethodBeat.i(45658);
                                ab.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", bqq, Boolean.valueOf(bqq.wSW), Boolean.valueOf(bqq.wSX));
                                if (bqq.wSW && bqq.wSX) {
                                    Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                                    intent.putExtra("key_amount", e.b(gJ, "100", RoundingMode.HALF_UP));
                                    intent.putExtra("key_mode", 2);
                                    WalletLqtSaveFetchUI.this.startActivity(intent);
                                } else {
                                    Intent intent2 = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressUI.class);
                                    try {
                                        intent2.putExtra("key_redeem_res", bqq.toByteArray());
                                    } catch (Exception e) {
                                        ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "pass redeemFundRes error: %s", e.getMessage());
                                    }
                                    WalletLqtSaveFetchUI.this.startActivity(intent2);
                                }
                                WalletLqtSaveFetchUI.this.finish();
                                Void voidR = zXH;
                                AppMethodBeat.o(45658);
                                return voidR;
                            }
                        }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                            public final void bi(Object obj) {
                                AppMethodBeat.i(45657);
                                WalletLqtSaveFetchUI.this.aDw();
                                if (obj != null) {
                                    String obj2;
                                    if (obj instanceof String) {
                                        obj2 = obj.toString();
                                    } else {
                                        obj2 = WalletLqtSaveFetchUI.this.getString(R.string.fiu);
                                    }
                                    WalletLqtSaveFetchUI.this.Vz(obj2);
                                }
                                AppMethodBeat.o(45657);
                            }
                        });
                    }
                }
                AppMethodBeat.o(45660);
            }
        };
        this.tkp.getContentEt().setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(45661);
                if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    ab.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
                    anonymousClass9.onClick(null);
                    AppMethodBeat.o(45661);
                } else {
                    AppMethodBeat.o(45661);
                }
                return true;
            }
        });
        if (!bo.isNullOrNil(this.tkI)) {
            this.tkD.setTipText(this.tkI);
        }
        if (this.mode == 2) {
            this.tkB.setCallback(new WalletLqtArriveTimeLayout.a() {
                public final void cNf() {
                    AppMethodBeat.i(45662);
                    WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, true);
                    AppMethodBeat.o(45662);
                }
            });
        }
        this.tkt.setText("");
        this.tkt.setClickable(true);
        this.tkt.setOnTouchListener(new m(this));
        mR(false);
        if (this.mode == 1) {
            this.tko.setVisibility(4);
        }
        if (this.tkr.findViewById(R.id.db) != null) {
            this.tkr.findViewById(R.id.db).setVisibility(8);
        }
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45644);
                WalletLqtSaveFetchUI.this.aoB();
                WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this);
                AppMethodBeat.o(45644);
            }
        };
        this.tkr.setOnClickListener(anonymousClass1);
        if (findViewById(R.id.f5z) != null) {
            findViewById(R.id.f5z).setOnClickListener(anonymousClass1);
        }
        cNm();
        p pVar = p.tfu;
        pVar.tft.add(this.tkO);
        AppMethodBeat.o(45677);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        String str;
        int i;
        int i2;
        View inflate;
        AppMethodBeat.i(45698);
        walletLqtSaveFetchUI.pas.clear();
        final com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(walletLqtSaveFetchUI, 2, true);
        p pVar = p.tfu;
        walletLqtSaveFetchUI.tkM = p.Ha(walletLqtSaveFetchUI.mode);
        String str2 = null;
        if (walletLqtSaveFetchUI.tgC != null) {
            str2 = walletLqtSaveFetchUI.tgC.field_bindSerial;
        }
        if (bo.isNullOrNil(str2)) {
            str2 = walletLqtSaveFetchUI.tkK;
            if (bo.isNullOrNil(walletLqtSaveFetchUI.tkK)) {
                com.tencent.mm.kernel.g.RQ();
                str = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_LQT_DEFAULTCARD_STRING_SYNC, (Object) "");
                i = 0;
                for (i2 = 0; i2 < walletLqtSaveFetchUI.tkM.size(); i2++) {
                    Bankcard bankcard = (Bankcard) walletLqtSaveFetchUI.tkM.get(i2);
                    if (!bo.isNullOrNil(bankcard.field_bindSerial) && str.equals(bankcard.field_bindSerial)) {
                        i = i2;
                    }
                }
                dVar.rBl = new n.c() {
                    public final void a(final l lVar) {
                        boolean z;
                        AppMethodBeat.i(45674);
                        int size = WalletLqtSaveFetchUI.this.tkM.size();
                        for (int i = 0; i < size; i++) {
                            String str;
                            CharSequence spannableString;
                            String str2;
                            Bankcard bankcard = (Bankcard) WalletLqtSaveFetchUI.this.tkM.get(i);
                            String str3 = "";
                            com.tencent.mm.plugin.wallet_core.model.e i2 = b.i(WalletLqtSaveFetchUI.this, bankcard.field_bankcardType, bankcard.cPb());
                            if (i2 != null) {
                                str = i2.oRi;
                            } else {
                                str = str3;
                            }
                            Bitmap a = com.tencent.mm.platformtools.x.a(new c(str));
                            com.tencent.mm.platformtools.x.a(new com.tencent.mm.platformtools.x.a() {
                                public final void m(final String str, final Bitmap bitmap) {
                                    AppMethodBeat.i(45673);
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(45672);
                                            ab.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                            if (WalletLqtSaveFetchUI.this.pas.containsKey(str)) {
                                                int intValue = ((Integer) WalletLqtSaveFetchUI.this.pas.get(str)).intValue();
                                                if (lVar.getItem(intValue) != null) {
                                                    lVar.getItem(intValue).setIcon(new BitmapDrawable(d.a(bitmap, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false)));
                                                    dVar.dKX();
                                                }
                                            }
                                            AppMethodBeat.o(45672);
                                        }
                                    });
                                    AppMethodBeat.o(45673);
                                }
                            });
                            Bitmap bitmap = null;
                            CharSequence charSequence = "";
                            if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
                                charSequence = bankcard.field_forbidWord;
                            }
                            if (bo.isNullOrNil(bankcard.field_forbid_title)) {
                                spannableString = new SpannableString(charSequence);
                                str2 = charSequence;
                            } else {
                                str3 = charSequence + " ";
                                spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                                AnonymousClass2 anonymousClass2 = new j(WalletLqtSaveFetchUI.this) {
                                    public final void onClick(View view) {
                                    }
                                };
                                int length = str3.length();
                                int length2 = str3.length() + bankcard.field_forbid_title.length();
                                spannableString.setSpan(new ForegroundColorSpan(WalletLqtSaveFetchUI.this.getResources().getColor(R.color.a50)), length, length2, 33);
                                spannableString.setSpan(anonymousClass2, length, length2, 33);
                                str2 = str3;
                            }
                            str3 = bankcard.field_desc;
                            if (bankcard.cPc()) {
                                ab.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                                lVar.a(i, str3, spannableString, WalletLqtSaveFetchUI.this.getResources().getDrawable(R.drawable.bki), !bo.isNullOrNil(str2));
                            } else {
                                if (a != null) {
                                    bitmap = d.a(a, WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), WalletLqtSaveFetchUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false);
                                }
                                ab.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                                lVar.a(i, str3, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !bo.isNullOrNil(str2));
                            }
                            if (bitmap == null) {
                                WalletLqtSaveFetchUI.this.pas.put(str, Integer.valueOf(i));
                            }
                        }
                        p pVar = p.tfu;
                        if (WalletLqtSaveFetchUI.this.mode == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        pVar.mL(z);
                        azb azb = z ? pVar.tfi : pVar.tfj;
                        if (azb != null) {
                            z = azb.wCP;
                        } else {
                            z = false;
                        }
                        if (z) {
                            ab.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
                            AppMethodBeat.o(45674);
                        } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                            lVar.a(size, WalletLqtSaveFetchUI.this.getString(R.string.fjv), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(R.drawable.bkc), false);
                            AppMethodBeat.o(45674);
                        } else {
                            if (WalletLqtSaveFetchUI.this.mode == 2) {
                                lVar.a(size, WalletLqtSaveFetchUI.this.getString(R.string.fig), "", WalletLqtSaveFetchUI.this.getResources().getDrawable(R.drawable.bkc), false);
                            }
                            AppMethodBeat.o(45674);
                        }
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(45675);
                        if (dVar != null) {
                            dVar.cpE();
                            if (i < WalletLqtSaveFetchUI.this.tkM.size()) {
                                WalletLqtSaveFetchUI.this.tkK = ((Bankcard) WalletLqtSaveFetchUI.this.tkM.get(i)).field_bindSerial;
                                WalletLqtSaveFetchUI.i(WalletLqtSaveFetchUI.this);
                                WalletLqtSaveFetchUI.this.tkp.cey();
                                AppMethodBeat.o(45675);
                                return;
                            } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                                WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this);
                                AppMethodBeat.o(45675);
                                return;
                            } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                                WalletLqtSaveFetchUI.j(WalletLqtSaveFetchUI.this);
                            }
                        }
                        AppMethodBeat.o(45675);
                    }
                };
                inflate = View.inflate(walletLqtSaveFetchUI, R.layout.a_o, null);
                if (walletLqtSaveFetchUI.mode != 1) {
                    ((TextView) inflate.findViewById(R.id.csg)).setText(R.string.fjp);
                    ((TextView) inflate.findViewById(R.id.csh)).setText(R.string.fjo);
                } else {
                    ((TextView) inflate.findViewById(R.id.csg)).setText(R.string.fi9);
                    ((TextView) inflate.findViewById(R.id.csh)).setText(R.string.fi8);
                }
                dVar.pIf = true;
                dVar.zQA = i;
                dVar.zQy = true;
                dVar.F(inflate, false);
                dVar.cpD();
                AppMethodBeat.o(45698);
            }
        }
        str = str2;
        i = 0;
        while (i2 < walletLqtSaveFetchUI.tkM.size()) {
        }
        dVar.rBl = /* anonymous class already generated */;
        dVar.rBm = /* anonymous class already generated */;
        inflate = View.inflate(walletLqtSaveFetchUI, R.layout.a_o, null);
        if (walletLqtSaveFetchUI.mode != 1) {
        }
        dVar.pIf = true;
        dVar.zQA = i;
        dVar.zQy = true;
        dVar.F(inflate, false);
        dVar.cpD();
        AppMethodBeat.o(45698);
    }

    static /* synthetic */ void j(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(45702);
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) walletLqtSaveFetchUI.mBundle.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.czZ = "";
            if (walletLqtSaveFetchUI.mode == 1) {
                if (walletLqtSaveFetchUI.accountType == 0) {
                    parcelable.cIf = 45;
                } else {
                    parcelable.cIf = 52;
                }
            } else if (walletLqtSaveFetchUI.accountType == 0) {
                parcelable.cIf = 51;
            } else {
                parcelable.cIf = 53;
            }
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        if (walletLqtSaveFetchUI.mode == 1) {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 45);
            } else {
                bundle.putInt("key_scene", 52);
            }
            bundle.putInt("key_bind_scene", 16);
        } else {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 51);
            } else {
                bundle.putInt("key_scene", 53);
            }
            bundle.putInt("key_bind_scene", 17);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a((Activity) walletLqtSaveFetchUI, b.class, bundle, new com.tencent.mm.wallet_core.c.a() {
            public final Intent n(int i, Bundle bundle) {
                AppMethodBeat.i(45646);
                ab.i("MicroMsg.WalletLqtSaveFetchUI", "feedbackData: %s", bundle);
                AppMethodBeat.o(45646);
                return null;
            }
        });
        AppMethodBeat.o(45702);
    }

    static /* synthetic */ void b(WalletLqtSaveFetchUI walletLqtSaveFetchUI, String str) {
        AppMethodBeat.i(45705);
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", str);
        long iz = e.iz(String.valueOf(str), "100");
        if (iz <= 0) {
            if (walletLqtSaveFetchUI.mode != 1) {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                walletLqtSaveFetchUI.cNn();
            } else if (walletLqtSaveFetchUI.tgC == null || !walletLqtSaveFetchUI.tgC.cPc()) {
                walletLqtSaveFetchUI.tkt.setText("");
            } else {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
            }
            walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
            walletLqtSaveFetchUI.tkL = false;
            walletLqtSaveFetchUI.mR(false);
        } else if (walletLqtSaveFetchUI.mode == 1) {
            if (walletLqtSaveFetchUI.tgC == null) {
                walletLqtSaveFetchUI.tkL = true;
                walletLqtSaveFetchUI.mR(true);
            } else if (walletLqtSaveFetchUI.tgC.cPc()) {
                if (walletLqtSaveFetchUI.tkF != null && iz > ((long) gH(walletLqtSaveFetchUI.tkF.twS, "100"))) {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(R.string.fjr));
                    walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                    walletLqtSaveFetchUI.tkL = false;
                    walletLqtSaveFetchUI.mR(false);
                } else if (p.tfu.tfs <= 0 || iz <= ((long) p.tfu.tfs) || bo.isNullOrNil(p.tfu.tfp) || bo.isNullOrNil(p.tfu.tfq) || bo.isNullOrNil(p.tfu.tfr)) {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                    walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                    walletLqtSaveFetchUI.tkL = true;
                    walletLqtSaveFetchUI.mR(true);
                } else {
                    o oVar = new o(new o.a() {
                        public final void df(View view) {
                            AppMethodBeat.i(45665);
                            ab.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                            e.a(WalletLqtSaveFetchUI.this.mController.ylL, p.tfu.tfr, true, 1);
                            AppMethodBeat.o(45665);
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append(p.tfu.tfp);
                    spannableStringBuilder.append(p.tfu.tfq);
                    spannableStringBuilder.setSpan(oVar, p.tfu.tfp.length(), spannableStringBuilder.length(), 18);
                    walletLqtSaveFetchUI.tkt.setOnTouchListener(new m(walletLqtSaveFetchUI.mController.ylL));
                    walletLqtSaveFetchUI.tkt.setClickable(true);
                    walletLqtSaveFetchUI.tkt.setText(spannableStringBuilder);
                    walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                    walletLqtSaveFetchUI.tkL = false;
                    walletLqtSaveFetchUI.mR(false);
                }
            } else if (walletLqtSaveFetchUI.tgC.field_dayQuotaKind <= 0.0d || iz <= ((long) gH(walletLqtSaveFetchUI.tgC.field_dayQuotaKind, "100"))) {
                walletLqtSaveFetchUI.tkt.setText("");
                walletLqtSaveFetchUI.tkL = true;
                walletLqtSaveFetchUI.mR(true);
            } else {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(R.string.fjs));
                walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                walletLqtSaveFetchUI.tkL = false;
                walletLqtSaveFetchUI.mR(false);
            }
        } else if (walletLqtSaveFetchUI.mode == 2) {
            int i;
            int i2;
            if (walletLqtSaveFetchUI.tgC == null || !walletLqtSaveFetchUI.tgC.cPc()) {
                bfi bfi = com.tencent.mm.plugin.wallet.balance.a.a.s.cMK().tfI;
                if (bfi == null) {
                    i = 0;
                    i2 = 0;
                } else {
                    i = bfi.wJd;
                    i2 = 0;
                }
            } else {
                i = walletLqtSaveFetchUI.getIntent().getIntExtra("lqt_balance", 0);
                i2 = 1;
            }
            if (i2 != 0) {
                if (iz > ((long) i)) {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(R.string.fia));
                    walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                    walletLqtSaveFetchUI.tkL = false;
                    walletLqtSaveFetchUI.cNn();
                    walletLqtSaveFetchUI.mR(false);
                } else {
                    walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                    walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                    walletLqtSaveFetchUI.tkL = true;
                    walletLqtSaveFetchUI.t(walletLqtSaveFetchUI.tkN, str);
                    walletLqtSaveFetchUI.mR(true);
                }
            } else if (iz > ((long) i)) {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(R.string.fib));
                walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                walletLqtSaveFetchUI.tkL = false;
                walletLqtSaveFetchUI.cNn();
                walletLqtSaveFetchUI.mR(false);
            } else if (walletLqtSaveFetchUI.tgC == null || walletLqtSaveFetchUI.tgC.cPc() || walletLqtSaveFetchUI.tgC.field_dayQuotaKind <= 0.0d || iz <= ((long) gH(walletLqtSaveFetchUI.tgC.field_dayQuotaKind, "100"))) {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.tkE);
                walletLqtSaveFetchUI.tkt.setTextColor(Color.parseColor("#888888"));
                walletLqtSaveFetchUI.tkL = true;
                walletLqtSaveFetchUI.t(walletLqtSaveFetchUI.tkN, str);
                walletLqtSaveFetchUI.mR(true);
            } else {
                walletLqtSaveFetchUI.tkt.setText(walletLqtSaveFetchUI.getString(R.string.fic, new Object[]{Double.valueOf(walletLqtSaveFetchUI.tgC.field_dayQuotaKind)}));
                walletLqtSaveFetchUI.tkt.setTextColor(-65536);
                walletLqtSaveFetchUI.tkL = false;
                walletLqtSaveFetchUI.cNn();
                walletLqtSaveFetchUI.mR(false);
            }
        }
        if (iz <= 0) {
            walletLqtSaveFetchUI.tkN = true;
            AppMethodBeat.o(45705);
            return;
        }
        walletLqtSaveFetchUI.tkN = false;
        AppMethodBeat.o(45705);
    }

    static /* synthetic */ void o(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(45707);
        walletLqtSaveFetchUI.tkB.removeAllViews();
        AppMethodBeat.o(45707);
    }
}
