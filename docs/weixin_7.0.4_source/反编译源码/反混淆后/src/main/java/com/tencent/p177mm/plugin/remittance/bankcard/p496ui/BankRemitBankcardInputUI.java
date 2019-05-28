package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.p069v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Filter.FilterListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.p177mm.plugin.remittance.bankcard.model.C39586c;
import com.tencent.p177mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.p177mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C28858d;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C3715m;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C39583a;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C39584g;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C46917k;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI */
public class BankRemitBankcardInputUI extends BankRemitBaseUI {
    private String few = "";
    private Button gHn;
    private Dialog ohk = null;
    private TransferRecordParcel pMA;
    private boolean pMB = true;
    private boolean pMC = false;
    private boolean pMD = false;
    private boolean pME = false;
    private C39584g pMF = null;
    private boolean pMG = false;
    private boolean pMH = false;
    private boolean pMI = true;
    private boolean pMJ = false;
    private boolean pMK = false;
    private boolean pML = false;
    private String pMM;
    private String pMN;
    private CdnImageView pMa;
    private WalletFormView pMh;
    private WalletFormView pMi;
    private WalletFormView pMj;
    private WalletFormView pMk;
    private C36356d pMl;
    private ListPopupWindow pMm;
    private C39586c pMn;
    private FilterListener pMo;
    private ArrayList<TransferRecordParcel> pMp;
    private ArrayList<TransferRecordParcel> pMq;
    private int pMr;
    private String pMs;
    private String pMt;
    private String pMu;
    private String pMv;
    private String pMw;
    private String pMx;
    private EnterTimeParcel pMy;
    private BankcardElemParcel pMz;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$14 */
    class C1302614 implements C40929a {
        C1302614() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44528);
            C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", c1207m);
            BankRemitBankcardInputUI.this.pMK = false;
            BankRemitBankcardInputUI.this.pML = false;
            AppMethodBeat.m2505o(44528);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$27 */
    class C1302927 extends C24019s {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$27$1 */
        class C37171 implements OnCancelListener {
            C37171() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(44543);
                C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
                BankRemitBankcardInputUI.this.pML = false;
                BankRemitBankcardInputUI.this.pMK = false;
                if (BankRemitBankcardInputUI.this.ohk != null && BankRemitBankcardInputUI.this.ohk.isShowing()) {
                    BankRemitBankcardInputUI.this.ohk.dismiss();
                }
                if (BankRemitBankcardInputUI.this.mController.contentView.getVisibility() == 8 || BankRemitBankcardInputUI.this.mController.contentView.getVisibility() == 4) {
                    C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                    BankRemitBankcardInputUI.this.finish();
                }
                BankRemitBankcardInputUI.m86212F(BankRemitBankcardInputUI.this);
                AppMethodBeat.m2505o(44543);
            }
        }

        C1302927() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(44544);
            C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
            BankRemitBankcardInputUI.this.aqX();
            BankRemitBankcardInputUI.this.aoB();
            if (BankRemitBankcardInputUI.m86277u(BankRemitBankcardInputUI.this)) {
                AppMethodBeat.m2505o(44544);
                return;
            }
            String text = BankRemitBankcardInputUI.this.pMh.getText();
            String text2 = BankRemitBankcardInputUI.this.pMi.getText();
            if (C5046bo.isNullOrNil(text) || text.trim().isEmpty() || C5046bo.isNullOrNil(text2) || text2.trim().isEmpty() || BankRemitBankcardInputUI.this.pMz == null) {
                C4990ab.m7421w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", text, text2, BankRemitBankcardInputUI.this.pMz);
                AppMethodBeat.m2505o(44544);
                return;
            }
            C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", Boolean.valueOf(BankRemitBankcardInputUI.this.pMJ), Boolean.valueOf(BankRemitBankcardInputUI.this.pMK), Boolean.valueOf(BankRemitBankcardInputUI.this.pML));
            if (!BankRemitBankcardInputUI.this.pMJ) {
                BankRemitBankcardInputUI.this.pML = true;
                BankRemitBankcardInputUI.this.pMM = text;
                BankRemitBankcardInputUI.this.pMN = text2;
                if (BankRemitBankcardInputUI.this.ohk != null) {
                    BankRemitBankcardInputUI.this.ohk.show();
                } else {
                    BankRemitBankcardInputUI bankRemitBankcardInputUI = BankRemitBankcardInputUI.this;
                    Context context = BankRemitBankcardInputUI.this;
                    BankRemitBankcardInputUI.this.getString(C25738R.string.f9104pl);
                    bankRemitBankcardInputUI.ohk = C30379h.m48458b(context, BankRemitBankcardInputUI.this.getString(C25738R.string.fop), true, new C37171());
                }
                if (!BankRemitBankcardInputUI.this.pMK) {
                    BankRemitBankcardInputUI.m86213G(BankRemitBankcardInputUI.this);
                }
            } else if (BankRemitBankcardInputUI.m86282z(BankRemitBankcardInputUI.this)) {
                if (BankRemitBankcardInputUI.this.pMC) {
                    C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
                    BankRemitBankcardInputUI.m86207A(BankRemitBankcardInputUI.this);
                    AppMethodBeat.m2505o(44544);
                    return;
                }
                BankRemitBankcardInputUI.m86241a(BankRemitBankcardInputUI.this, text, text2, BankRemitBankcardInputUI.this.pMz.nuL, BankRemitBankcardInputUI.this.pMz.pbn);
                AppMethodBeat.m2505o(44544);
                return;
            }
            AppMethodBeat.m2505o(44544);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$4 */
    class C130304 implements C40929a {
        C130304() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44516);
            C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$20 */
    class C2162620 implements OnClickListener {
        C2162620() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44535);
            C4990ab.m7410d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
            if (BankRemitBankcardInputUI.this.pMG || !BankRemitBankcardInputUI.this.pMH) {
                BankRemitBankcardInputUI.m86228V(BankRemitBankcardInputUI.this);
            } else {
                Intent intent = new Intent(BankRemitBankcardInputUI.this.mController.ylL, BankRemitSelectPayeeUI.class);
                if (BankRemitBankcardInputUI.this.pMp != null) {
                    intent.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.this.pMp);
                }
                if (BankRemitBankcardInputUI.this.pMq != null) {
                    intent.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.this.pMq);
                }
                BankRemitBankcardInputUI.this.startActivityForResult(intent, 1);
            }
            C7060h.pYm.mo8381e(14673, Integer.valueOf(3));
            AppMethodBeat.m2505o(44535);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$21 */
    class C2162721 implements DialogInterface.OnClickListener {
        C2162721() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$22 */
    class C2162822 implements TextWatcher {
        C2162822() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(44536);
            BankRemitBankcardInputUI.m86249c(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.m86252d(BankRemitBankcardInputUI.this);
            if (!BankRemitBankcardInputUI.this.pMB || BankRemitBankcardInputUI.this.pMm == null) {
                BankRemitBankcardInputUI.this.pMB = true;
            } else {
                BankRemitBankcardInputUI.this.pMn.getFilter().filter(editable.toString(), BankRemitBankcardInputUI.this.pMo);
            }
            if (BankRemitBankcardInputUI.this.pMC) {
                BankRemitBankcardInputUI.m86263j(BankRemitBankcardInputUI.this);
            }
            BankRemitBankcardInputUI.m86264k(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.this.pMC = false;
            if (BankRemitBankcardInputUI.this.pMJ && BankRemitBankcardInputUI.this.pMh.getInputLength() <= BankRemitBankcardInputUI.this.pMr) {
                BankRemitBankcardInputUI.this.pMh.setMaxInputLength(BankRemitBankcardInputUI.this.pMr);
                BankRemitBankcardInputUI.this.pMh.setFilters(new InputFilter[]{new LengthFilter(BankRemitBankcardInputUI.this.pMr)});
            }
            AppMethodBeat.m2505o(44536);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$17 */
    class C2886017 implements Runnable {
        C2886017() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44531);
            BankRemitBankcardInputUI.this.pMh.cex();
            AppMethodBeat.m2505o(44531);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$28 */
    class C2886228 implements C40929a {
        C2886228() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44545);
            C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44545);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$7 */
    class C413037 implements C40929a {
        C413037() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44519);
            C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", c1207m);
            BankRemitBankcardInputUI.this.pMG = true;
            AppMethodBeat.m2505o(44519);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$12 */
    class C4344012 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$12$2 */
        class C395892 implements C5279d {
            C395892() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(44525);
                switch (menuItem.getItemId()) {
                    case 0:
                        if (C5046bo.isNullOrNil(BankRemitBankcardInputUI.this.pMx)) {
                            C4990ab.m7420w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
                        } else {
                            C36391e.m60016n(BankRemitBankcardInputUI.this.mController.ylL, BankRemitBankcardInputUI.this.pMx, false);
                        }
                        C7060h.pYm.mo8381e(14673, Integer.valueOf(6));
                        AppMethodBeat.m2505o(44525);
                        return;
                    case 1:
                        C36391e.m60016n(BankRemitBankcardInputUI.this.mController.ylL, "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
                        break;
                }
                AppMethodBeat.m2505o(44525);
            }
        }

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$12$1 */
        class C434411 implements C36073c {
            C434411() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(44524);
                c44273l.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(C25738R.string.a4k));
                c44273l.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(C25738R.string.a4i));
                AppMethodBeat.m2505o(44524);
            }
        }

        C4344012() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44526);
            C4990ab.m7410d("MicroMsg.BankRemitBankcardInputUI", "help click");
            BankRemitBankcardInputUI.this.pMl = new C36356d(BankRemitBankcardInputUI.this.mController.ylL, 1, false);
            BankRemitBankcardInputUI.this.pMl.rBl = new C434411();
            BankRemitBankcardInputUI.this.pMl.rBm = new C395892();
            BankRemitBankcardInputUI.this.aoB();
            BankRemitBankcardInputUI.this.pMl.cpD();
            C7060h.pYm.mo8381e(14673, Integer.valueOf(2));
            AppMethodBeat.m2505o(44526);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$18 */
    class C4344218 implements OnItemClickListener {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$18$1 */
        class C434431 implements Runnable {
            C434431() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44532);
                BankRemitBankcardInputUI.this.pMh.cex();
                AppMethodBeat.m2505o(44532);
            }
        }

        C4344218() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44533);
            C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", Integer.valueOf(i));
            BankRemitBankcardInputUI.this.pMB = false;
            BankRemitBankcardInputUI.this.pMA = (TransferRecordParcel) adapterView.getAdapter().getItem(i);
            BankRemitBankcardInputUI.m86224R(BankRemitBankcardInputUI.this);
            BankRemitBankcardInputUI.m86240a(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.this.pMA.pMd, BankRemitBankcardInputUI.this.pMt, BankRemitBankcardInputUI.this.pMA.pbn);
            C5004al.m7442n(new C434431(), 500);
            BankRemitBankcardInputUI.this.pMm.dismiss();
            BankRemitBankcardInputUI.this.aqX();
            AppMethodBeat.m2505o(44533);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$23 */
    class C4344423 implements OnEditorActionListener {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$23$1 */
        class C216291 implements Runnable {
            C216291() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44537);
                BankRemitBankcardInputUI.this.dOC();
                AppMethodBeat.m2505o(44537);
            }
        }

        C4344423() {
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(44538);
            if (i == 5) {
                BankRemitBankcardInputUI.this.aqX();
                if (!BankRemitBankcardInputUI.this.pMD) {
                    C5004al.m7442n(new C216291(), 200);
                }
            }
            AppMethodBeat.m2505o(44538);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$24 */
    class C4344624 implements TextWatcher {

        /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$24$1 */
        class C434451 implements Runnable {
            C434451() {
            }

            public final void run() {
                AppMethodBeat.m2504i(44539);
                BankRemitBankcardInputUI.m86264k(BankRemitBankcardInputUI.this);
                AppMethodBeat.m2505o(44539);
            }
        }

        C4344624() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(44540);
            BankRemitBankcardInputUI.this.pMI = true;
            C5004al.m7442n(new C434451(), 200);
            AppMethodBeat.m2505o(44540);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$25 */
    class C4344725 implements OnClickListener {
        C4344725() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44541);
            BankRemitBankcardInputUI.this.aqX();
            String text = BankRemitBankcardInputUI.this.pMi.getText();
            if (!BankRemitBankcardInputUI.this.pMI || C5046bo.isNullOrNil(text)) {
                BankRemitBankcardInputUI.m86276t(BankRemitBankcardInputUI.this);
                AppMethodBeat.m2505o(44541);
                return;
            }
            BankRemitBankcardInputUI.m86239a(BankRemitBankcardInputUI.this, text, BankRemitBankcardInputUI.this.pMi.getMD5Value());
            AppMethodBeat.m2505o(44541);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$26 */
    class C4344826 implements OnClickListener {
        C4344826() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44542);
            C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
            BankRemitBankcardInputUI.this.aqX();
            BankRemitBankcardInputUI.this.pMi.cex();
            if (!BankRemitBankcardInputUI.m86277u(BankRemitBankcardInputUI.this)) {
                Intent intent = new Intent(BankRemitBankcardInputUI.this.mController.ylL, BankRemitSelectArriveTimeUI.class);
                if (!(BankRemitBankcardInputUI.this.pMz == null || BankRemitBankcardInputUI.this.pMz.pLN == null)) {
                    intent.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.this.pMz.pLN);
                }
                if (BankRemitBankcardInputUI.this.pMy != null) {
                    intent.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.this.pMy.pLQ);
                }
                BankRemitBankcardInputUI.this.startActivityForResult(intent, 3);
            }
            AppMethodBeat.m2505o(44542);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$10 */
    class C4617010 implements C40929a {
        C4617010() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44522);
            C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44522);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI$19 */
    class C4617119 implements FilterListener {
        C4617119() {
        }

        public final void onFilterComplete(int i) {
            AppMethodBeat.m2504i(44534);
            C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", Integer.valueOf(i));
            if (BankRemitBankcardInputUI.this.pMm != null) {
                if (i > 0) {
                    if (i == 1) {
                        BankRemitBankcardInputUI.this.pMm.setHeight(C1338a.fromDPToPix(BankRemitBankcardInputUI.this.mController.ylL, 68));
                    } else {
                        BankRemitBankcardInputUI.this.pMm.setHeight(C1338a.fromDPToPix(BankRemitBankcardInputUI.this.mController.ylL, C19395n.CTRL_INDEX));
                    }
                    BankRemitBankcardInputUI.this.pMm.show();
                    AppMethodBeat.m2505o(44534);
                    return;
                } else if (i <= 0 && BankRemitBankcardInputUI.this.pMm.amH.isShowing()) {
                    BankRemitBankcardInputUI.this.pMm.dismiss();
                }
            }
            AppMethodBeat.m2505o(44534);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: F */
    static /* synthetic */ void m86212F(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44576);
        bankRemitBankcardInputUI.bLz();
        AppMethodBeat.m2505o(44576);
    }

    /* renamed from: G */
    static /* synthetic */ void m86213G(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44577);
        bankRemitBankcardInputUI.cfa();
        AppMethodBeat.m2505o(44577);
    }

    /* renamed from: H */
    static /* synthetic */ void m86214H(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44578);
        bankRemitBankcardInputUI.cff();
        AppMethodBeat.m2505o(44578);
    }

    /* renamed from: I */
    static /* synthetic */ void m86215I(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44579);
        bankRemitBankcardInputUI.cfj();
        AppMethodBeat.m2505o(44579);
    }

    /* renamed from: J */
    static /* synthetic */ void m86216J(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44580);
        bankRemitBankcardInputUI.cfg();
        AppMethodBeat.m2505o(44580);
    }

    /* renamed from: K */
    static /* synthetic */ void m86217K(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44581);
        bankRemitBankcardInputUI.cfh();
        AppMethodBeat.m2505o(44581);
    }

    /* renamed from: R */
    static /* synthetic */ void m86224R(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44584);
        bankRemitBankcardInputUI.cfe();
        AppMethodBeat.m2505o(44584);
    }

    /* renamed from: V */
    static /* synthetic */ void m86228V(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44586);
        bankRemitBankcardInputUI.m86265kf(true);
        AppMethodBeat.m2505o(44586);
    }

    /* renamed from: a */
    static /* synthetic */ void m86240a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3) {
        AppMethodBeat.m2504i(44585);
        bankRemitBankcardInputUI.m86229Y(str, str2, str3);
        AppMethodBeat.m2505o(44585);
    }

    /* renamed from: a */
    static /* synthetic */ void m86241a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(44575);
        bankRemitBankcardInputUI.m86274s(str, str2, str3, str4);
        AppMethodBeat.m2505o(44575);
    }

    /* renamed from: k */
    static /* synthetic */ void m86264k(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44569);
        bankRemitBankcardInputUI.cfi();
        AppMethodBeat.m2505o(44569);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44546);
        super.onCreate(bundle);
        dyb();
        initView();
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "12";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(44513);
                if (!C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C36391e.m59985a((TextView) BankRemitBankcardInputUI.this.findViewById(2131821634), c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                }
                AppMethodBeat.m2505o(44513);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        mo39992nf(1348);
        mo39992nf(1542);
        mo39992nf(1378);
        mo39992nf(1349);
        mo39992nf(ActUtil.HEIGHT);
        this.pMx = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC, (Object) "");
        m86265kf(false);
        cfa();
        setMMTitle((int) C25738R.string.a59);
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C4344012());
        C7060h.pYm.mo8381e(14673, Integer.valueOf(1));
        AppMethodBeat.m2505o(44546);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44547);
        this.pMh = (WalletFormView) findViewById(2131821635);
        this.pMi = (WalletFormView) findViewById(2131821636);
        this.pMj = (WalletFormView) findViewById(2131821637);
        this.pMa = (CdnImageView) this.pMj.findViewById(2131821633);
        this.pMk = (WalletFormView) findViewById(2131821638);
        this.gHn = (Button) findViewById(2131821639);
        this.pMh.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        this.pMh.mo64594a(new C2162822());
        this.pMh.setOnEditorActionListener(new C4344423());
        this.pMh.dOS();
        C30890a.m49294b(this.pMi);
        mo21157a((View) this.pMi, 2, false, true);
        this.pMi.mo64594a(new C4344624());
        this.pMj.setOnClickListener(new C4344725());
        this.pMk.setOnClickListener(new C4344826());
        this.gHn.setOnClickListener(new C1302927());
        cfb();
        cfi();
        AppMethodBeat.m2505o(44547);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44548);
        C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + c1207m.getType());
        if (c1207m instanceof C39583a) {
            final C39583a c39583a = (C39583a) c1207m;
            if (c39583a.pLt.equals(this.pMA.pMd)) {
                c39583a.mo70318a(new C40929a() {
                    /* renamed from: e */
                    public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(44515);
                        BankRemitBankcardInputUI.this.pMs = c39583a.pLs.vHu;
                        BankRemitBankcardInputUI.this.pMz = new BankcardElemParcel(c39583a.pLs.vHt);
                        String str2 = "MicroMsg.BankRemitBankcardInputUI";
                        String str3 = "response bank: %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = BankRemitBankcardInputUI.this.pMz != null ? BankRemitBankcardInputUI.this.pMz.nuL : "";
                        C4990ab.m7417i(str2, str3, objArr);
                        BankRemitBankcardInputUI.m86214H(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86215I(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86216J(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86217K(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86264k(BankRemitBankcardInputUI.this);
                        AppMethodBeat.m2505o(44515);
                    }
                }).mo70319b(new C40929a() {
                    /* renamed from: e */
                    public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(44514);
                        C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", Integer.valueOf(c39583a.pLs.kCl), c39583a.pLs.kCm);
                        if (!C5046bo.isNullOrNil(c39583a.pLs.kCm)) {
                            Toast.makeText(BankRemitBankcardInputUI.this, c39583a.pLs.kCm, 1).show();
                        }
                        AppMethodBeat.m2505o(44514);
                    }
                }).mo70320c(new C2886228());
            } else {
                C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", c39583a.pLt, this.pMu);
                AppMethodBeat.m2505o(44548);
                return true;
            }
        } else if (c1207m instanceof C39584g) {
            final C39584g c39584g = (C39584g) c1207m;
            if (c39584g == this.pMF) {
                C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
                this.pMF = null;
            }
            if (c39584g.cvZ.equals(this.pMi.getMD5Value())) {
                c39584g.mo70318a(new C40929a() {
                    /* renamed from: e */
                    public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(44518);
                        if (c39584g.pLy.vHt == null) {
                            C4990ab.m7420w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
                            BankRemitBankcardInputUI.m86276t(BankRemitBankcardInputUI.this);
                            AppMethodBeat.m2505o(44518);
                            return;
                        }
                        BankRemitBankcardInputUI.this.pMz = new BankcardElemParcel(c39584g.pLy.vHt);
                        BankRemitBankcardInputUI.m86214H(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86215I(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86216J(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86217K(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.m86264k(BankRemitBankcardInputUI.this);
                        AppMethodBeat.m2505o(44518);
                    }
                }).mo70319b(new C40929a() {
                    /* renamed from: e */
                    public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(44517);
                        C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", Integer.valueOf(c39584g.pLy.kCl), c39584g.pLy.kCm);
                        BankRemitBankcardInputUI.m86276t(BankRemitBankcardInputUI.this);
                        AppMethodBeat.m2505o(44517);
                    }
                }).mo70320c(new C130304());
            } else {
                C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", c39584g.cvZ, this.pMi.getMD5Value());
                AppMethodBeat.m2505o(44548);
                return true;
            }
        } else if (c1207m instanceof C3715m) {
            final C3715m c3715m = (C3715m) c1207m;
            this.pMH = true;
            c3715m.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44521);
                    BankRemitBankcardInputUI.this.pMG = false;
                    BankRemitBankcardInputUI.this.pMt = c3715m.pLE.vHs;
                    C4990ab.m7411d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", BankRemitBankcardInputUI.this.pMt);
                    BankRemitBankcardInputUI.this.pMp = TransferRecordParcel.m86204cO(c3715m.pLE.wRg);
                    BankRemitBankcardInputUI.this.pMq = TransferRecordParcel.m86204cO(c3715m.pLE.wRf);
                    C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", Integer.valueOf(BankRemitBankcardInputUI.this.pMp.size()), Integer.valueOf(BankRemitBankcardInputUI.this.pMq.size()));
                    BankRemitBankcardInputUI.m86221O(BankRemitBankcardInputUI.this);
                    AppMethodBeat.m2505o(44521);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44520);
                    C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", Integer.valueOf(c3715m.pLE.kCl), c3715m.pLE.kCm);
                    if (!C5046bo.isNullOrNil(c3715m.pLE.kCm)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, c3715m.pLE.kCm, 1).show();
                    }
                    BankRemitBankcardInputUI.this.pMG = true;
                    AppMethodBeat.m2505o(44520);
                }
            }).mo70320c(new C413037());
        } else if (c1207m instanceof C28858d) {
            final C28858d c28858d = (C28858d) c1207m;
            c28858d.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44527);
                    BankRemitBankcardInputUI.this.pMs = c28858d.pLv.vHu;
                    BankRemitBankcardInputUI.this.pMw = c28858d.pLv.pMf;
                    BankRemitBankcardInputUI.this.pMu = c28858d.pLv.pMd;
                    BankRemitBankcardInputUI.this.pMv = c28858d.pLv.pMe;
                    BankRemitBankcardInputUI.m86207A(BankRemitBankcardInputUI.this);
                    AppMethodBeat.m2505o(44527);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44523);
                    C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", Integer.valueOf(c28858d.pLv.kCl), c28858d.pLv.kCm);
                    if (!C5046bo.isNullOrNil(c28858d.pLv.kCm)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, c28858d.pLv.kCm, 1).show();
                    }
                    AppMethodBeat.m2505o(44523);
                }
            }).mo70320c(new C4617010());
        } else if (c1207m instanceof C46917k) {
            final C46917k c46917k = (C46917k) c1207m;
            c46917k.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44530);
                    if (BankRemitBankcardInputUI.this.ohk != null && BankRemitBankcardInputUI.this.ohk.isShowing()) {
                        BankRemitBankcardInputUI.this.ohk.dismiss();
                    }
                    BankRemitBankcardInputUI.this.pMJ = true;
                    BankRemitBankcardInputUI.this.pMK = false;
                    BankRemitBankcardInputUI.this.pMx = c46917k.pLC.wKP;
                    BankRemitBankcardInputUI.this.few = c46917k.pLC.wKQ;
                    C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", BankRemitBankcardInputUI.this.few);
                    BankRemitBankcardInputUI.this.pMr = c46917k.pLC.wKR;
                    C4990ab.m7411d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", Integer.valueOf(BankRemitBankcardInputUI.this.pMr));
                    if (!BankRemitBankcardInputUI.m86282z(BankRemitBankcardInputUI.this)) {
                        BankRemitBankcardInputUI.m86264k(BankRemitBankcardInputUI.this);
                    } else if (BankRemitBankcardInputUI.this.pML) {
                        if (BankRemitBankcardInputUI.this.pMC) {
                            C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                            BankRemitBankcardInputUI.m86207A(BankRemitBankcardInputUI.this);
                        } else {
                            BankRemitBankcardInputUI.m86246b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.this.pMz.nuL, BankRemitBankcardInputUI.this.pMz.pbn);
                        }
                        BankRemitBankcardInputUI.this.pML = false;
                        AppMethodBeat.m2505o(44530);
                        return;
                    }
                    AppMethodBeat.m2505o(44530);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44529);
                    C4990ab.m7413e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", Integer.valueOf(c46917k.pLC.kCl), c46917k.pLC.kCm);
                    if (!C5046bo.isNullOrNil(c46917k.pLC.kCm)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, c46917k.pLC.kCm, 1).show();
                    }
                    BankRemitBankcardInputUI.this.finish();
                    AppMethodBeat.m2505o(44529);
                }
            }).mo70320c(new C1302614());
        }
        AppMethodBeat.m2505o(44548);
        return false;
    }

    public final int getLayoutId() {
        return 2130968813;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44549);
        super.onDestroy();
        mo39993ng(1348);
        mo39993ng(1542);
        mo39993ng(1378);
        mo39993ng(1349);
        mo39993ng(ActUtil.HEIGHT);
        AppMethodBeat.m2505o(44549);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44550);
        Iterator it;
        if (i == 1) {
            TransferRecordParcel transferRecordParcel;
            if (i2 == -1) {
                this.pMB = false;
                this.pMu = intent.getStringExtra("key_bank_card_seqno");
                String str = this.pMu;
                if (this.pMp != null) {
                    it = this.pMp.iterator();
                    while (it.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it.next();
                        if (transferRecordParcel.pMd.equals(str)) {
                            break;
                        }
                    }
                }
                if (this.pMq != null) {
                    it = this.pMq.iterator();
                    while (it.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it.next();
                        if (transferRecordParcel.pMd.equals(str)) {
                            break;
                        }
                    }
                }
                transferRecordParcel = null;
                this.pMA = transferRecordParcel;
                cfe();
                cfi();
                if (this.pMA != null) {
                    m86229Y(this.pMA.pMd, this.pMt, this.pMA.pbn);
                }
                C5004al.m7442n(new C2886017(), 50);
            }
            C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", Integer.valueOf(i2));
            if (intent != null) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_delete_seq_no_list");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_modified_record_list");
                if (stringArrayListExtra != null) {
                    it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        BankRemitBankcardInputUI.m86270p(str2, this.pMp);
                        BankRemitBankcardInputUI.m86270p(str2, this.pMq);
                    }
                }
                if (parcelableArrayListExtra != null) {
                    Iterator it2 = parcelableArrayListExtra.iterator();
                    while (it2.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it2.next();
                        BankRemitBankcardInputUI.m86238a(transferRecordParcel, this.pMp);
                        BankRemitBankcardInputUI.m86238a(transferRecordParcel, this.pMq);
                    }
                }
                AppMethodBeat.m2505o(44550);
                return;
            }
        } else if (i == 3) {
            if (i2 == -1) {
                int intExtra = intent.getIntExtra("key_enter_time_scene", -1);
                if (!(this.pMz == null || this.pMz.pLN == null)) {
                    it = this.pMz.pLN.iterator();
                    while (it.hasNext()) {
                        EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                        if (enterTimeParcel.pLQ == intExtra) {
                            this.pMy = enterTimeParcel;
                            break;
                        }
                    }
                }
                C4990ab.m7421w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", Integer.valueOf(intExtra));
                cfg();
                cfi();
                AppMethodBeat.m2505o(44550);
                return;
            }
        } else if (i != 2) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            this.pMz = (BankcardElemParcel) intent.getParcelableExtra("key_bank_card_elem_parcel");
            cff();
            cfj();
            cfg();
            cfh();
            cfi();
            AppMethodBeat.m2505o(44550);
            return;
        }
        AppMethodBeat.m2505o(44550);
    }

    /* renamed from: a */
    private static void m86238a(TransferRecordParcel transferRecordParcel, List<TransferRecordParcel> list) {
        AppMethodBeat.m2504i(44551);
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel2 = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel2.pMd.equals(transferRecordParcel.pMd)) {
                    transferRecordParcel2.pMg = transferRecordParcel.pMg;
                    AppMethodBeat.m2505o(44551);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(44551);
    }

    /* renamed from: p */
    private static void m86270p(String str, List<TransferRecordParcel> list) {
        AppMethodBeat.m2504i(44552);
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel.pMd.equals(str)) {
                    list.remove(transferRecordParcel);
                    AppMethodBeat.m2505o(44552);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(44552);
    }

    /* renamed from: Y */
    private void m86229Y(String str, String str2, String str3) {
        AppMethodBeat.m2504i(44553);
        C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", str);
        mo39970a(new C39583a(str, str2, str3), false, false);
        AppMethodBeat.m2505o(44553);
    }

    /* renamed from: kf */
    private void m86265kf(boolean z) {
        AppMethodBeat.m2504i(44554);
        C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", Boolean.valueOf(z));
        if (z) {
            mo39970a(new C3715m(), true, false);
            AppMethodBeat.m2505o(44554);
            return;
        }
        mo39970a(new C3715m(), false, false);
        AppMethodBeat.m2505o(44554);
    }

    /* renamed from: s */
    private void m86274s(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(44555);
        C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", str3, str4);
        C4990ab.m7411d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", str, str2);
        mo39970a(new C28858d(str, str2, str3, str4), true, true);
        AppMethodBeat.m2505o(44555);
    }

    private void cfa() {
        AppMethodBeat.m2504i(44556);
        C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "do operation");
        this.pMK = true;
        mo39970a(new C46917k(), false, false);
        AppMethodBeat.m2505o(44556);
    }

    private void cfb() {
        AppMethodBeat.m2504i(44557);
        this.pMh.getInfoIv().setVisibility(0);
        this.pMh.getInfoIv().setClickable(true);
        this.pMh.getInfoIv().setEnabled(true);
        this.pMh.getInfoIv().setOnClickListener(new C2162620());
        AppMethodBeat.m2505o(44557);
    }

    private void cfc() {
        AppMethodBeat.m2504i(44558);
        this.pMi.cex();
        this.pMi.setContentEnabled(false);
        this.pMD = true;
        AppMethodBeat.m2505o(44558);
    }

    private void cfd() {
        AppMethodBeat.m2504i(44559);
        this.pMj.setClickable(false);
        this.pME = true;
        AppMethodBeat.m2505o(44559);
    }

    private void cfe() {
        AppMethodBeat.m2504i(44560);
        if (this.pMA != null) {
            this.pMh.setText(this.pMA.pMf);
            this.pMC = true;
            this.pMi.setText(getString(C25738R.string.a3y, new Object[]{this.pMA.pMe}));
            this.pMj.setText(this.pMA.nuL);
            this.pMa.setUrl(this.pMA.pLH);
            cfc();
            cfd();
        }
        AppMethodBeat.m2505o(44560);
    }

    private void cff() {
        AppMethodBeat.m2504i(44561);
        if (this.pMz != null) {
            this.pMj.setText(this.pMz.nuL);
            this.pMa.setUrl(this.pMz.pLH);
        }
        AppMethodBeat.m2505o(44561);
    }

    private void cfg() {
        AppMethodBeat.m2504i(44562);
        if (this.pMy != null) {
            if (C5046bo.isNullOrNil(this.pMy.color)) {
                this.pMk.setContentTextColorRes(C25738R.color.f11782h4);
            } else {
                this.pMk.setContentTextColor(Color.parseColor(this.pMy.color));
            }
            this.pMk.setText(this.pMy.pLR);
            this.pMk.setVisibility(0);
            AppMethodBeat.m2505o(44562);
        } else if (this.pMz == null || C5046bo.isNullOrNil(this.pMz.pLK)) {
            this.pMk.setVisibility(8);
            AppMethodBeat.m2505o(44562);
        } else {
            this.pMk.setText(this.pMz.pLK);
            if (C5046bo.isNullOrNil(this.pMz.pLL)) {
                this.pMk.setContentTextColorRes(C25738R.color.f11782h4);
            } else {
                this.pMk.setContentTextColor(Color.parseColor(this.pMz.pLL));
            }
            this.pMk.setVisibility(0);
            AppMethodBeat.m2505o(44562);
        }
    }

    private void cfh() {
        AppMethodBeat.m2504i(44563);
        if (this.pMk.getVisibility() == 0) {
            this.pMj.setBackground(getResources().getDrawable(C25738R.drawable.a5h));
            AppMethodBeat.m2505o(44563);
            return;
        }
        this.pMj.setBackground(getResources().getDrawable(C25738R.drawable.f6409d8));
        AppMethodBeat.m2505o(44563);
    }

    private void cfi() {
        AppMethodBeat.m2504i(44564);
        if (C5046bo.isNullOrNil(this.pMh.getText()) || this.pMh.getText().trim().isEmpty() || C5046bo.isNullOrNil(this.pMi.getText()) || !this.pMh.asa() || this.pMi.getText().trim().isEmpty() || !this.pMi.asa() || C5046bo.isNullOrNil(this.pMj.getText()) || this.pMk.getVisibility() != 0 || C5046bo.isNullOrNil(this.pMk.getText()) || this.pMz == null || !C5046bo.isNullOrNil(this.pMz.pLM)) {
            this.gHn.setEnabled(false);
            AppMethodBeat.m2505o(44564);
            return;
        }
        this.gHn.setEnabled(true);
        AppMethodBeat.m2505o(44564);
    }

    private void cfj() {
        AppMethodBeat.m2504i(44565);
        if (this.pMz == null || C5046bo.isNullOrNil(this.pMz.pLK)) {
            if (!(this.pMz == null || this.pMz.pLN == null)) {
                Iterator it = this.pMz.pLN.iterator();
                while (it.hasNext()) {
                    EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                    if (enterTimeParcel.pLT > 0) {
                        this.pMy = enterTimeParcel;
                        AppMethodBeat.m2505o(44565);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(44565);
            return;
        }
        this.pMy = null;
        AppMethodBeat.m2505o(44565);
    }

    /* renamed from: c */
    static /* synthetic */ void m86249c(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44566);
        bankRemitBankcardInputUI.pMi.setContentEnabled(true);
        bankRemitBankcardInputUI.pMD = false;
        AppMethodBeat.m2505o(44566);
    }

    /* renamed from: d */
    static /* synthetic */ void m86252d(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44567);
        bankRemitBankcardInputUI.pMj.setClickable(true);
        bankRemitBankcardInputUI.pME = false;
        AppMethodBeat.m2505o(44567);
    }

    /* renamed from: j */
    static /* synthetic */ void m86263j(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44568);
        bankRemitBankcardInputUI.pMi.cey();
        bankRemitBankcardInputUI.pMj.cey();
        bankRemitBankcardInputUI.pMa.setImageBitmap(null);
        bankRemitBankcardInputUI.pMk.cey();
        bankRemitBankcardInputUI.pMk.setVisibility(8);
        bankRemitBankcardInputUI.cfh();
        bankRemitBankcardInputUI.pMu = "";
        bankRemitBankcardInputUI.pMv = "";
        bankRemitBankcardInputUI.pMs = "";
        bankRemitBankcardInputUI.pMz = null;
        bankRemitBankcardInputUI.pMy = null;
        AppMethodBeat.m2505o(44568);
    }

    /* renamed from: a */
    static /* synthetic */ void m86239a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        C1207m c1207m;
        AppMethodBeat.m2504i(44570);
        C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by cardNo");
        if (bankRemitBankcardInputUI.pMF != null) {
            C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "cancel pre scene");
            c1207m = bankRemitBankcardInputUI.pMF;
            C30868i c30868i = bankRemitBankcardInputUI.Ahr;
            C4990ab.m7417i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", c30868i, c1207m);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c(c1207m);
            c30868i.gIH.remove(c1207m);
            c30868i.gIG.remove(c1207m);
            if (c30868i.gIH.isEmpty() && c30868i.gIG.isEmpty() && c30868i.gII != null && c30868i.gII.isShowing()) {
                c30868i.gII.dismiss();
            }
        }
        bankRemitBankcardInputUI.pMI = false;
        c1207m = new C39584g(str, str2);
        bankRemitBankcardInputUI.pMF = c1207m;
        bankRemitBankcardInputUI.mo39970a(c1207m, true, false);
        AppMethodBeat.m2505o(44570);
    }

    /* renamed from: t */
    static /* synthetic */ void m86276t(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44571);
        bankRemitBankcardInputUI.startActivityForResult(new Intent(bankRemitBankcardInputUI.mController.ylL, BankRemitSelectBankUI.class), 2);
        AppMethodBeat.m2505o(44571);
    }

    /* renamed from: u */
    static /* synthetic */ boolean m86277u(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44572);
        if (bankRemitBankcardInputUI.pMz == null) {
            AppMethodBeat.m2505o(44572);
            return false;
        } else if (C5046bo.isNullOrNil(bankRemitBankcardInputUI.pMz.pLM)) {
            AppMethodBeat.m2505o(44572);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.BankRemitBankcardInputUI", "show alert text: %s", bankRemitBankcardInputUI.pMz.pLM);
            C30379h.m48448a((Context) bankRemitBankcardInputUI, bankRemitBankcardInputUI.pMz.pLM, "", false, new C2162721());
            AppMethodBeat.m2505o(44572);
            return true;
        }
    }

    /* renamed from: z */
    static /* synthetic */ boolean m86282z(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44573);
        if (bankRemitBankcardInputUI.pMr <= 0 || bankRemitBankcardInputUI.pMr >= bankRemitBankcardInputUI.pMh.getInputLength()) {
            AppMethodBeat.m2505o(44573);
            return true;
        }
        Toast.makeText(bankRemitBankcardInputUI, bankRemitBankcardInputUI.getString(C25738R.string.g5m, new Object[]{bankRemitBankcardInputUI.pMr}), 1).show();
        AppMethodBeat.m2505o(44573);
        return false;
    }

    /* renamed from: A */
    static /* synthetic */ void m86207A(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44574);
        Intent intent = new Intent(bankRemitBankcardInputUI.mController.ylL, BankRemitMoneyInputUI.class);
        if (bankRemitBankcardInputUI.pMC) {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.pMA.pMd);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.pMA.pMe);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.pMA.pMf);
            intent.putExtra("key_input_type", 1);
        } else {
            intent.putExtra("key_bank_card_seqno", bankRemitBankcardInputUI.pMu);
            intent.putExtra("key_bank_card_tailno", bankRemitBankcardInputUI.pMv);
            intent.putExtra("key_payee_name", bankRemitBankcardInputUI.pMw);
            intent.putExtra("key_input_type", 0);
        }
        intent.putExtra("key_unique_id", C5046bo.nullAsNil(bankRemitBankcardInputUI.few));
        intent.putExtra("key_enter_time_scene", bankRemitBankcardInputUI.pMy.pLQ);
        intent.putExtra("key_encrypt_data", bankRemitBankcardInputUI.pMs);
        intent.putExtra("key_bank_card_elem_parcel", bankRemitBankcardInputUI.pMz);
        bankRemitBankcardInputUI.startActivity(intent);
        AppMethodBeat.m2505o(44574);
    }

    /* renamed from: O */
    static /* synthetic */ void m86221O(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.m2504i(44582);
        C4990ab.m7410d("MicroMsg.BankRemitBankcardInputUI", "init popup window");
        bankRemitBankcardInputUI.pMm = new ListPopupWindow(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.pMm.age = C1338a.m2868gd(bankRemitBankcardInputUI) - C1338a.fromDPToPix(bankRemitBankcardInputUI, 30);
        bankRemitBankcardInputUI.pMm.setHeight(C1338a.fromDPToPix(bankRemitBankcardInputUI, C19395n.CTRL_INDEX));
        bankRemitBankcardInputUI.pMm.setBackgroundDrawable(new ColorDrawable(0));
        bankRemitBankcardInputUI.pMm.setVerticalOffset(1);
        bankRemitBankcardInputUI.pMm.setAnimationStyle(C25738R.style.f10875h8);
        bankRemitBankcardInputUI.pMm.amx = bankRemitBankcardInputUI.pMh;
        bankRemitBankcardInputUI.pMm.setModal(false);
        bankRemitBankcardInputUI.pMm.amz = new C4344218();
        bankRemitBankcardInputUI.pMo = new C4617119();
        ArrayList arrayList = new ArrayList();
        if (bankRemitBankcardInputUI.pMp != null) {
            arrayList.addAll(bankRemitBankcardInputUI.pMp);
        }
        if (bankRemitBankcardInputUI.pMq != null) {
            arrayList.addAll(bankRemitBankcardInputUI.pMq);
        }
        bankRemitBankcardInputUI.pMn = new C39586c(bankRemitBankcardInputUI, arrayList);
        bankRemitBankcardInputUI.pMm.setAdapter(bankRemitBankcardInputUI.pMn);
        AppMethodBeat.m2505o(44582);
    }

    /* renamed from: b */
    static /* synthetic */ void m86246b(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        AppMethodBeat.m2504i(44583);
        C4990ab.m7416i("MicroMsg.BankRemitBankcardInputUI", "doCheckBankBind()");
        bankRemitBankcardInputUI.m86274s(bankRemitBankcardInputUI.pMM, bankRemitBankcardInputUI.pMN, str, str2);
        AppMethodBeat.m2505o(44583);
    }
}
