package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.plugin.remittance.bankcard.a.g;
import com.tencent.mm.plugin.remittance.bankcard.a.k;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.EnterTimeParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BankRemitBankcardInputUI extends BankRemitBaseUI {
    private String few = "";
    private Button gHn;
    private Dialog ohk = null;
    private TransferRecordParcel pMA;
    private boolean pMB = true;
    private boolean pMC = false;
    private boolean pMD = false;
    private boolean pME = false;
    private g pMF = null;
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
    private d pMl;
    private ListPopupWindow pMm;
    private c pMn;
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void F(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44576);
        bankRemitBankcardInputUI.bLz();
        AppMethodBeat.o(44576);
    }

    static /* synthetic */ void G(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44577);
        bankRemitBankcardInputUI.cfa();
        AppMethodBeat.o(44577);
    }

    static /* synthetic */ void H(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44578);
        bankRemitBankcardInputUI.cff();
        AppMethodBeat.o(44578);
    }

    static /* synthetic */ void I(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44579);
        bankRemitBankcardInputUI.cfj();
        AppMethodBeat.o(44579);
    }

    static /* synthetic */ void J(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44580);
        bankRemitBankcardInputUI.cfg();
        AppMethodBeat.o(44580);
    }

    static /* synthetic */ void K(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44581);
        bankRemitBankcardInputUI.cfh();
        AppMethodBeat.o(44581);
    }

    static /* synthetic */ void R(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44584);
        bankRemitBankcardInputUI.cfe();
        AppMethodBeat.o(44584);
    }

    static /* synthetic */ void V(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44586);
        bankRemitBankcardInputUI.kf(true);
        AppMethodBeat.o(44586);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3) {
        AppMethodBeat.i(44585);
        bankRemitBankcardInputUI.Y(str, str2, str3);
        AppMethodBeat.o(44585);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(44575);
        bankRemitBankcardInputUI.s(str, str2, str3, str4);
        AppMethodBeat.o(44575);
    }

    static /* synthetic */ void k(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44569);
        bankRemitBankcardInputUI.cfi();
        AppMethodBeat.o(44569);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44546);
        super.onCreate(bundle);
        dyb();
        initView();
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "12";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(44513);
                if (!bo.isNullOrNil(uoVar.cQK.cQM)) {
                    e.a((TextView) BankRemitBankcardInputUI.this.findViewById(R.id.a2f), uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                }
                AppMethodBeat.o(44513);
            }
        };
        a.xxA.m(uoVar);
        nf(1348);
        nf(1542);
        nf(1378);
        nf(1349);
        nf(ActUtil.HEIGHT);
        this.pMx = (String) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC, (Object) "");
        kf(false);
        cfa();
        setMMTitle((int) R.string.a59);
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44526);
                ab.d("MicroMsg.BankRemitBankcardInputUI", "help click");
                BankRemitBankcardInputUI.this.pMl = new d(BankRemitBankcardInputUI.this.mController.ylL, 1, false);
                BankRemitBankcardInputUI.this.pMl.rBl = new n.c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(44524);
                        lVar.add(0, 0, 0, BankRemitBankcardInputUI.this.getString(R.string.a4k));
                        lVar.add(0, 1, 0, BankRemitBankcardInputUI.this.getString(R.string.a4i));
                        AppMethodBeat.o(44524);
                    }
                };
                BankRemitBankcardInputUI.this.pMl.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(44525);
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (bo.isNullOrNil(BankRemitBankcardInputUI.this.pMx)) {
                                    ab.w("MicroMsg.BankRemitBankcardInputUI", "paylist url is null");
                                } else {
                                    e.n(BankRemitBankcardInputUI.this.mController.ylL, BankRemitBankcardInputUI.this.pMx, false);
                                }
                                h.pYm.e(14673, Integer.valueOf(6));
                                AppMethodBeat.o(44525);
                                return;
                            case 1:
                                e.n(BankRemitBankcardInputUI.this.mController.ylL, "https://kf.qq.com/touch/scene_product.html?scene_id=kf4568", true);
                                break;
                        }
                        AppMethodBeat.o(44525);
                    }
                };
                BankRemitBankcardInputUI.this.aoB();
                BankRemitBankcardInputUI.this.pMl.cpD();
                h.pYm.e(14673, Integer.valueOf(2));
                AppMethodBeat.o(44526);
                return false;
            }
        });
        h.pYm.e(14673, Integer.valueOf(1));
        AppMethodBeat.o(44546);
    }

    public final void initView() {
        AppMethodBeat.i(44547);
        this.pMh = (WalletFormView) findViewById(R.id.a2g);
        this.pMi = (WalletFormView) findViewById(R.id.a2h);
        this.pMj = (WalletFormView) findViewById(R.id.a2i);
        this.pMa = (CdnImageView) this.pMj.findViewById(R.id.a2e);
        this.pMk = (WalletFormView) findViewById(R.id.a2j);
        this.gHn = (Button) findViewById(R.id.a2k);
        this.pMh.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        this.pMh.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(44536);
                BankRemitBankcardInputUI.c(BankRemitBankcardInputUI.this);
                BankRemitBankcardInputUI.d(BankRemitBankcardInputUI.this);
                if (!BankRemitBankcardInputUI.this.pMB || BankRemitBankcardInputUI.this.pMm == null) {
                    BankRemitBankcardInputUI.this.pMB = true;
                } else {
                    BankRemitBankcardInputUI.this.pMn.getFilter().filter(editable.toString(), BankRemitBankcardInputUI.this.pMo);
                }
                if (BankRemitBankcardInputUI.this.pMC) {
                    BankRemitBankcardInputUI.j(BankRemitBankcardInputUI.this);
                }
                BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                BankRemitBankcardInputUI.this.pMC = false;
                if (BankRemitBankcardInputUI.this.pMJ && BankRemitBankcardInputUI.this.pMh.getInputLength() <= BankRemitBankcardInputUI.this.pMr) {
                    BankRemitBankcardInputUI.this.pMh.setMaxInputLength(BankRemitBankcardInputUI.this.pMr);
                    BankRemitBankcardInputUI.this.pMh.setFilters(new InputFilter[]{new LengthFilter(BankRemitBankcardInputUI.this.pMr)});
                }
                AppMethodBeat.o(44536);
            }
        });
        this.pMh.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                AppMethodBeat.i(44538);
                if (i == 5) {
                    BankRemitBankcardInputUI.this.aqX();
                    if (!BankRemitBankcardInputUI.this.pMD) {
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(44537);
                                BankRemitBankcardInputUI.this.dOC();
                                AppMethodBeat.o(44537);
                            }
                        }, 200);
                    }
                }
                AppMethodBeat.o(44538);
                return false;
            }
        });
        this.pMh.dOS();
        com.tencent.mm.wallet_core.ui.formview.a.b(this.pMi);
        a((View) this.pMi, 2, false, true);
        this.pMi.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(44540);
                BankRemitBankcardInputUI.this.pMI = true;
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44539);
                        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(44539);
                    }
                }, 200);
                AppMethodBeat.o(44540);
            }
        });
        this.pMj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44541);
                BankRemitBankcardInputUI.this.aqX();
                String text = BankRemitBankcardInputUI.this.pMi.getText();
                if (!BankRemitBankcardInputUI.this.pMI || bo.isNullOrNil(text)) {
                    BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(44541);
                    return;
                }
                BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, text, BankRemitBankcardInputUI.this.pMi.getMD5Value());
                AppMethodBeat.o(44541);
            }
        });
        this.pMk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44542);
                ab.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
                BankRemitBankcardInputUI.this.aqX();
                BankRemitBankcardInputUI.this.pMi.cex();
                if (!BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this)) {
                    Intent intent = new Intent(BankRemitBankcardInputUI.this.mController.ylL, BankRemitSelectArriveTimeUI.class);
                    if (!(BankRemitBankcardInputUI.this.pMz == null || BankRemitBankcardInputUI.this.pMz.pLN == null)) {
                        intent.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.this.pMz.pLN);
                    }
                    if (BankRemitBankcardInputUI.this.pMy != null) {
                        intent.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.this.pMy.pLQ);
                    }
                    BankRemitBankcardInputUI.this.startActivityForResult(intent, 3);
                }
                AppMethodBeat.o(44542);
            }
        });
        this.gHn.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(44544);
                ab.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
                BankRemitBankcardInputUI.this.aqX();
                BankRemitBankcardInputUI.this.aoB();
                if (BankRemitBankcardInputUI.u(BankRemitBankcardInputUI.this)) {
                    AppMethodBeat.o(44544);
                    return;
                }
                String text = BankRemitBankcardInputUI.this.pMh.getText();
                String text2 = BankRemitBankcardInputUI.this.pMi.getText();
                if (bo.isNullOrNil(text) || text.trim().isEmpty() || bo.isNullOrNil(text2) || text2.trim().isEmpty() || BankRemitBankcardInputUI.this.pMz == null) {
                    ab.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", text, text2, BankRemitBankcardInputUI.this.pMz);
                    AppMethodBeat.o(44544);
                    return;
                }
                ab.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", Boolean.valueOf(BankRemitBankcardInputUI.this.pMJ), Boolean.valueOf(BankRemitBankcardInputUI.this.pMK), Boolean.valueOf(BankRemitBankcardInputUI.this.pML));
                if (!BankRemitBankcardInputUI.this.pMJ) {
                    BankRemitBankcardInputUI.this.pML = true;
                    BankRemitBankcardInputUI.this.pMM = text;
                    BankRemitBankcardInputUI.this.pMN = text2;
                    if (BankRemitBankcardInputUI.this.ohk != null) {
                        BankRemitBankcardInputUI.this.ohk.show();
                    } else {
                        BankRemitBankcardInputUI bankRemitBankcardInputUI = BankRemitBankcardInputUI.this;
                        Context context = BankRemitBankcardInputUI.this;
                        BankRemitBankcardInputUI.this.getString(R.string.pl);
                        bankRemitBankcardInputUI.ohk = com.tencent.mm.ui.base.h.b(context, BankRemitBankcardInputUI.this.getString(R.string.fop), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(44543);
                                ab.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
                                BankRemitBankcardInputUI.this.pML = false;
                                BankRemitBankcardInputUI.this.pMK = false;
                                if (BankRemitBankcardInputUI.this.ohk != null && BankRemitBankcardInputUI.this.ohk.isShowing()) {
                                    BankRemitBankcardInputUI.this.ohk.dismiss();
                                }
                                if (BankRemitBankcardInputUI.this.mController.contentView.getVisibility() == 8 || BankRemitBankcardInputUI.this.mController.contentView.getVisibility() == 4) {
                                    ab.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
                                    BankRemitBankcardInputUI.this.finish();
                                }
                                BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.this);
                                AppMethodBeat.o(44543);
                            }
                        });
                    }
                    if (!BankRemitBankcardInputUI.this.pMK) {
                        BankRemitBankcardInputUI.G(BankRemitBankcardInputUI.this);
                    }
                } else if (BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this)) {
                    if (BankRemitBankcardInputUI.this.pMC) {
                        ab.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
                        BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(44544);
                        return;
                    }
                    BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, text, text2, BankRemitBankcardInputUI.this.pMz.nuL, BankRemitBankcardInputUI.this.pMz.pbn);
                    AppMethodBeat.o(44544);
                    return;
                }
                AppMethodBeat.o(44544);
            }
        });
        cfb();
        cfi();
        AppMethodBeat.o(44547);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44548);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + mVar.getType());
        if (mVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.a) {
            final com.tencent.mm.plugin.remittance.bankcard.a.a aVar = (com.tencent.mm.plugin.remittance.bankcard.a.a) mVar;
            if (aVar.pLt.equals(this.pMA.pMd)) {
                aVar.a(new p.a() {
                    public final void e(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(44515);
                        BankRemitBankcardInputUI.this.pMs = aVar.pLs.vHu;
                        BankRemitBankcardInputUI.this.pMz = new BankcardElemParcel(aVar.pLs.vHt);
                        String str2 = "MicroMsg.BankRemitBankcardInputUI";
                        String str3 = "response bank: %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = BankRemitBankcardInputUI.this.pMz != null ? BankRemitBankcardInputUI.this.pMz.nuL : "";
                        ab.i(str2, str3, objArr);
                        BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(44515);
                    }
                }).b(new p.a() {
                    public final void e(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(44514);
                        ab.e("MicroMsg.BankRemitBankcardInputUI", "appoint reponse error: %s, msg: %s", Integer.valueOf(aVar.pLs.kCl), aVar.pLs.kCm);
                        if (!bo.isNullOrNil(aVar.pLs.kCm)) {
                            Toast.makeText(BankRemitBankcardInputUI.this, aVar.pLs.kCm, 1).show();
                        }
                        AppMethodBeat.o(44514);
                    }
                }).c(new p.a() {
                    public final void e(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(44545);
                        ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", mVar);
                        AppMethodBeat.o(44545);
                    }
                });
            } else {
                ab.i("MicroMsg.BankRemitBankcardInputUI", "outdated request: %s, %s", aVar.pLt, this.pMu);
                AppMethodBeat.o(44548);
                return true;
            }
        } else if (mVar instanceof g) {
            final g gVar = (g) mVar;
            if (gVar == this.pMF) {
                ab.i("MicroMsg.BankRemitBankcardInputUI", "reset pending scene");
                this.pMF = null;
            }
            if (gVar.cvZ.equals(this.pMi.getMD5Value())) {
                gVar.a(new p.a() {
                    public final void e(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(44518);
                        if (gVar.pLy.vHt == null) {
                            ab.w("MicroMsg.BankRemitBankcardInputUI", "bank_elem is null");
                            BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
                            AppMethodBeat.o(44518);
                            return;
                        }
                        BankRemitBankcardInputUI.this.pMz = new BankcardElemParcel(gVar.pLy.vHt);
                        BankRemitBankcardInputUI.H(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.I(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.J(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.K(BankRemitBankcardInputUI.this);
                        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(44518);
                    }
                }).b(new p.a() {
                    public final void e(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(44517);
                        ab.e("MicroMsg.BankRemitBankcardInputUI", "bank info reponse error: %s, msg: %s", Integer.valueOf(gVar.pLy.kCl), gVar.pLy.kCm);
                        BankRemitBankcardInputUI.t(BankRemitBankcardInputUI.this);
                        AppMethodBeat.o(44517);
                    }
                }).c(new p.a() {
                    public final void e(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(44516);
                        ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", mVar);
                        AppMethodBeat.o(44516);
                    }
                });
            } else {
                ab.i("MicroMsg.BankRemitBankcardInputUI", "outdated card request: %s, %s", gVar.cvZ, this.pMi.getMD5Value());
                AppMethodBeat.o(44548);
                return true;
            }
        } else if (mVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.m) {
            final com.tencent.mm.plugin.remittance.bankcard.a.m mVar2 = (com.tencent.mm.plugin.remittance.bankcard.a.m) mVar;
            this.pMH = true;
            mVar2.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44521);
                    BankRemitBankcardInputUI.this.pMG = false;
                    BankRemitBankcardInputUI.this.pMt = mVar2.pLE.vHs;
                    ab.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", BankRemitBankcardInputUI.this.pMt);
                    BankRemitBankcardInputUI.this.pMp = TransferRecordParcel.cO(mVar2.pLE.wRg);
                    BankRemitBankcardInputUI.this.pMq = TransferRecordParcel.cO(mVar2.pLE.wRf);
                    ab.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", Integer.valueOf(BankRemitBankcardInputUI.this.pMp.size()), Integer.valueOf(BankRemitBankcardInputUI.this.pMq.size()));
                    BankRemitBankcardInputUI.O(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(44521);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44520);
                    ab.e("MicroMsg.BankRemitBankcardInputUI", "records response error: %s, %s", Integer.valueOf(mVar2.pLE.kCl), mVar2.pLE.kCm);
                    if (!bo.isNullOrNil(mVar2.pLE.kCm)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, mVar2.pLE.kCm, 1).show();
                    }
                    BankRemitBankcardInputUI.this.pMG = true;
                    AppMethodBeat.o(44520);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44519);
                    ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", mVar);
                    BankRemitBankcardInputUI.this.pMG = true;
                    AppMethodBeat.o(44519);
                }
            });
        } else if (mVar instanceof com.tencent.mm.plugin.remittance.bankcard.a.d) {
            final com.tencent.mm.plugin.remittance.bankcard.a.d dVar = (com.tencent.mm.plugin.remittance.bankcard.a.d) mVar;
            dVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44527);
                    BankRemitBankcardInputUI.this.pMs = dVar.pLv.vHu;
                    BankRemitBankcardInputUI.this.pMw = dVar.pLv.pMf;
                    BankRemitBankcardInputUI.this.pMu = dVar.pLv.pMd;
                    BankRemitBankcardInputUI.this.pMv = dVar.pLv.pMe;
                    BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                    AppMethodBeat.o(44527);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44523);
                    ab.e("MicroMsg.BankRemitBankcardInputUI", "check response error: %s, %s", Integer.valueOf(dVar.pLv.kCl), dVar.pLv.kCm);
                    if (!bo.isNullOrNil(dVar.pLv.kCm)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, dVar.pLv.kCm, 1).show();
                    }
                    AppMethodBeat.o(44523);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44522);
                    ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", mVar);
                    AppMethodBeat.o(44522);
                }
            });
        } else if (mVar instanceof k) {
            final k kVar = (k) mVar;
            kVar.a(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44530);
                    if (BankRemitBankcardInputUI.this.ohk != null && BankRemitBankcardInputUI.this.ohk.isShowing()) {
                        BankRemitBankcardInputUI.this.ohk.dismiss();
                    }
                    BankRemitBankcardInputUI.this.pMJ = true;
                    BankRemitBankcardInputUI.this.pMK = false;
                    BankRemitBankcardInputUI.this.pMx = kVar.pLC.wKP;
                    BankRemitBankcardInputUI.this.few = kVar.pLC.wKQ;
                    ab.i("MicroMsg.BankRemitBankcardInputUI", "set uniqueId:%s", BankRemitBankcardInputUI.this.few);
                    BankRemitBankcardInputUI.this.pMr = kVar.pLC.wKR;
                    ab.d("MicroMsg.BankRemitBankcardInputUI", "set nameLenLimit:%s", Integer.valueOf(BankRemitBankcardInputUI.this.pMr));
                    if (!BankRemitBankcardInputUI.z(BankRemitBankcardInputUI.this)) {
                        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.this);
                    } else if (BankRemitBankcardInputUI.this.pML) {
                        if (BankRemitBankcardInputUI.this.pMC) {
                            ab.i("MicroMsg.BankRemitBankcardInputUI", "NetSceneBankRemitOperation: from record goto next direct");
                            BankRemitBankcardInputUI.A(BankRemitBankcardInputUI.this);
                        } else {
                            BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.this.pMz.nuL, BankRemitBankcardInputUI.this.pMz.pbn);
                        }
                        BankRemitBankcardInputUI.this.pML = false;
                        AppMethodBeat.o(44530);
                        return;
                    }
                    AppMethodBeat.o(44530);
                }
            }).b(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44529);
                    ab.e("MicroMsg.BankRemitBankcardInputUI", "operation response error: %s, %s", Integer.valueOf(kVar.pLC.kCl), kVar.pLC.kCm);
                    if (!bo.isNullOrNil(kVar.pLC.kCm)) {
                        Toast.makeText(BankRemitBankcardInputUI.this, kVar.pLC.kCm, 1).show();
                    }
                    BankRemitBankcardInputUI.this.finish();
                    AppMethodBeat.o(44529);
                }
            }).c(new p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(44528);
                    ab.e("MicroMsg.BankRemitBankcardInputUI", "net error: %s", mVar);
                    BankRemitBankcardInputUI.this.pMK = false;
                    BankRemitBankcardInputUI.this.pML = false;
                    AppMethodBeat.o(44528);
                }
            });
        }
        AppMethodBeat.o(44548);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.fp;
    }

    public void onDestroy() {
        AppMethodBeat.i(44549);
        super.onDestroy();
        ng(1348);
        ng(1542);
        ng(1378);
        ng(1349);
        ng(ActUtil.HEIGHT);
        AppMethodBeat.o(44549);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44550);
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
                    Y(this.pMA.pMd, this.pMt, this.pMA.pbn);
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44531);
                        BankRemitBankcardInputUI.this.pMh.cex();
                        AppMethodBeat.o(44531);
                    }
                }, 50);
            }
            ab.i("MicroMsg.BankRemitBankcardInputUI", "resultCode: %s", Integer.valueOf(i2));
            if (intent != null) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_delete_seq_no_list");
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_modified_record_list");
                if (stringArrayListExtra != null) {
                    it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        p(str2, this.pMp);
                        p(str2, this.pMq);
                    }
                }
                if (parcelableArrayListExtra != null) {
                    Iterator it2 = parcelableArrayListExtra.iterator();
                    while (it2.hasNext()) {
                        transferRecordParcel = (TransferRecordParcel) it2.next();
                        a(transferRecordParcel, this.pMp);
                        a(transferRecordParcel, this.pMq);
                    }
                }
                AppMethodBeat.o(44550);
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
                ab.w("MicroMsg.BankRemitBankcardInputUI", "can't find the right enter scene: %d", Integer.valueOf(intExtra));
                cfg();
                cfi();
                AppMethodBeat.o(44550);
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
            AppMethodBeat.o(44550);
            return;
        }
        AppMethodBeat.o(44550);
    }

    private static void a(TransferRecordParcel transferRecordParcel, List<TransferRecordParcel> list) {
        AppMethodBeat.i(44551);
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel2 = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel2.pMd.equals(transferRecordParcel.pMd)) {
                    transferRecordParcel2.pMg = transferRecordParcel.pMg;
                    AppMethodBeat.o(44551);
                    return;
                }
            }
        }
        AppMethodBeat.o(44551);
    }

    private static void p(String str, List<TransferRecordParcel> list) {
        AppMethodBeat.i(44552);
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TransferRecordParcel transferRecordParcel = (TransferRecordParcel) list.get(size);
                if (transferRecordParcel.pMd.equals(str)) {
                    list.remove(transferRecordParcel);
                    AppMethodBeat.o(44552);
                    return;
                }
            }
        }
        AppMethodBeat.o(44552);
    }

    private void Y(String str, String str2, String str3) {
        AppMethodBeat.i(44553);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by seq: %s", str);
        a(new com.tencent.mm.plugin.remittance.bankcard.a.a(str, str2, str3), false, false);
        AppMethodBeat.o(44553);
    }

    private void kf(boolean z) {
        AppMethodBeat.i(44554);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "do fetch transfer record: %s", Boolean.valueOf(z));
        if (z) {
            a(new com.tencent.mm.plugin.remittance.bankcard.a.m(), true, false);
            AppMethodBeat.o(44554);
            return;
        }
        a(new com.tencent.mm.plugin.remittance.bankcard.a.m(), false, false);
        AppMethodBeat.o(44554);
    }

    private void s(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(44555);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "do check bank bind: %s %s", str3, str4);
        ab.d("MicroMsg.BankRemitBankcardInputUI", "payeeName: %s, bankCardNo: %s", str, str2);
        a(new com.tencent.mm.plugin.remittance.bankcard.a.d(str, str2, str3, str4), true, true);
        AppMethodBeat.o(44555);
    }

    private void cfa() {
        AppMethodBeat.i(44556);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "do operation");
        this.pMK = true;
        a(new k(), false, false);
        AppMethodBeat.o(44556);
    }

    private void cfb() {
        AppMethodBeat.i(44557);
        this.pMh.getInfoIv().setVisibility(0);
        this.pMh.getInfoIv().setClickable(true);
        this.pMh.getInfoIv().setEnabled(true);
        this.pMh.getInfoIv().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44535);
                ab.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
                if (BankRemitBankcardInputUI.this.pMG || !BankRemitBankcardInputUI.this.pMH) {
                    BankRemitBankcardInputUI.V(BankRemitBankcardInputUI.this);
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
                h.pYm.e(14673, Integer.valueOf(3));
                AppMethodBeat.o(44535);
            }
        });
        AppMethodBeat.o(44557);
    }

    private void cfc() {
        AppMethodBeat.i(44558);
        this.pMi.cex();
        this.pMi.setContentEnabled(false);
        this.pMD = true;
        AppMethodBeat.o(44558);
    }

    private void cfd() {
        AppMethodBeat.i(44559);
        this.pMj.setClickable(false);
        this.pME = true;
        AppMethodBeat.o(44559);
    }

    private void cfe() {
        AppMethodBeat.i(44560);
        if (this.pMA != null) {
            this.pMh.setText(this.pMA.pMf);
            this.pMC = true;
            this.pMi.setText(getString(R.string.a3y, new Object[]{this.pMA.pMe}));
            this.pMj.setText(this.pMA.nuL);
            this.pMa.setUrl(this.pMA.pLH);
            cfc();
            cfd();
        }
        AppMethodBeat.o(44560);
    }

    private void cff() {
        AppMethodBeat.i(44561);
        if (this.pMz != null) {
            this.pMj.setText(this.pMz.nuL);
            this.pMa.setUrl(this.pMz.pLH);
        }
        AppMethodBeat.o(44561);
    }

    private void cfg() {
        AppMethodBeat.i(44562);
        if (this.pMy != null) {
            if (bo.isNullOrNil(this.pMy.color)) {
                this.pMk.setContentTextColorRes(R.color.h4);
            } else {
                this.pMk.setContentTextColor(Color.parseColor(this.pMy.color));
            }
            this.pMk.setText(this.pMy.pLR);
            this.pMk.setVisibility(0);
            AppMethodBeat.o(44562);
        } else if (this.pMz == null || bo.isNullOrNil(this.pMz.pLK)) {
            this.pMk.setVisibility(8);
            AppMethodBeat.o(44562);
        } else {
            this.pMk.setText(this.pMz.pLK);
            if (bo.isNullOrNil(this.pMz.pLL)) {
                this.pMk.setContentTextColorRes(R.color.h4);
            } else {
                this.pMk.setContentTextColor(Color.parseColor(this.pMz.pLL));
            }
            this.pMk.setVisibility(0);
            AppMethodBeat.o(44562);
        }
    }

    private void cfh() {
        AppMethodBeat.i(44563);
        if (this.pMk.getVisibility() == 0) {
            this.pMj.setBackground(getResources().getDrawable(R.drawable.a5h));
            AppMethodBeat.o(44563);
            return;
        }
        this.pMj.setBackground(getResources().getDrawable(R.drawable.d8));
        AppMethodBeat.o(44563);
    }

    private void cfi() {
        AppMethodBeat.i(44564);
        if (bo.isNullOrNil(this.pMh.getText()) || this.pMh.getText().trim().isEmpty() || bo.isNullOrNil(this.pMi.getText()) || !this.pMh.asa() || this.pMi.getText().trim().isEmpty() || !this.pMi.asa() || bo.isNullOrNil(this.pMj.getText()) || this.pMk.getVisibility() != 0 || bo.isNullOrNil(this.pMk.getText()) || this.pMz == null || !bo.isNullOrNil(this.pMz.pLM)) {
            this.gHn.setEnabled(false);
            AppMethodBeat.o(44564);
            return;
        }
        this.gHn.setEnabled(true);
        AppMethodBeat.o(44564);
    }

    private void cfj() {
        AppMethodBeat.i(44565);
        if (this.pMz == null || bo.isNullOrNil(this.pMz.pLK)) {
            if (!(this.pMz == null || this.pMz.pLN == null)) {
                Iterator it = this.pMz.pLN.iterator();
                while (it.hasNext()) {
                    EnterTimeParcel enterTimeParcel = (EnterTimeParcel) it.next();
                    if (enterTimeParcel.pLT > 0) {
                        this.pMy = enterTimeParcel;
                        AppMethodBeat.o(44565);
                        return;
                    }
                }
            }
            AppMethodBeat.o(44565);
            return;
        }
        this.pMy = null;
        AppMethodBeat.o(44565);
    }

    static /* synthetic */ void c(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44566);
        bankRemitBankcardInputUI.pMi.setContentEnabled(true);
        bankRemitBankcardInputUI.pMD = false;
        AppMethodBeat.o(44566);
    }

    static /* synthetic */ void d(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44567);
        bankRemitBankcardInputUI.pMj.setClickable(true);
        bankRemitBankcardInputUI.pME = false;
        AppMethodBeat.o(44567);
    }

    static /* synthetic */ void j(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44568);
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
        AppMethodBeat.o(44568);
    }

    static /* synthetic */ void a(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        m mVar;
        AppMethodBeat.i(44570);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "do query bankinfo by cardNo");
        if (bankRemitBankcardInputUI.pMF != null) {
            ab.i("MicroMsg.BankRemitBankcardInputUI", "cancel pre scene");
            mVar = bankRemitBankcardInputUI.pMF;
            i iVar = bankRemitBankcardInputUI.Ahr;
            ab.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", iVar, mVar);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.c(mVar);
            iVar.gIH.remove(mVar);
            iVar.gIG.remove(mVar);
            if (iVar.gIH.isEmpty() && iVar.gIG.isEmpty() && iVar.gII != null && iVar.gII.isShowing()) {
                iVar.gII.dismiss();
            }
        }
        bankRemitBankcardInputUI.pMI = false;
        mVar = new g(str, str2);
        bankRemitBankcardInputUI.pMF = mVar;
        bankRemitBankcardInputUI.a(mVar, true, false);
        AppMethodBeat.o(44570);
    }

    static /* synthetic */ void t(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44571);
        bankRemitBankcardInputUI.startActivityForResult(new Intent(bankRemitBankcardInputUI.mController.ylL, BankRemitSelectBankUI.class), 2);
        AppMethodBeat.o(44571);
    }

    static /* synthetic */ boolean u(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44572);
        if (bankRemitBankcardInputUI.pMz == null) {
            AppMethodBeat.o(44572);
            return false;
        } else if (bo.isNullOrNil(bankRemitBankcardInputUI.pMz.pLM)) {
            AppMethodBeat.o(44572);
            return false;
        } else {
            ab.i("MicroMsg.BankRemitBankcardInputUI", "show alert text: %s", bankRemitBankcardInputUI.pMz.pLM);
            com.tencent.mm.ui.base.h.a((Context) bankRemitBankcardInputUI, bankRemitBankcardInputUI.pMz.pLM, "", false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(44572);
            return true;
        }
    }

    static /* synthetic */ boolean z(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44573);
        if (bankRemitBankcardInputUI.pMr <= 0 || bankRemitBankcardInputUI.pMr >= bankRemitBankcardInputUI.pMh.getInputLength()) {
            AppMethodBeat.o(44573);
            return true;
        }
        Toast.makeText(bankRemitBankcardInputUI, bankRemitBankcardInputUI.getString(R.string.g5m, new Object[]{bankRemitBankcardInputUI.pMr}), 1).show();
        AppMethodBeat.o(44573);
        return false;
    }

    static /* synthetic */ void A(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44574);
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
        intent.putExtra("key_unique_id", bo.nullAsNil(bankRemitBankcardInputUI.few));
        intent.putExtra("key_enter_time_scene", bankRemitBankcardInputUI.pMy.pLQ);
        intent.putExtra("key_encrypt_data", bankRemitBankcardInputUI.pMs);
        intent.putExtra("key_bank_card_elem_parcel", bankRemitBankcardInputUI.pMz);
        bankRemitBankcardInputUI.startActivity(intent);
        AppMethodBeat.o(44574);
    }

    static /* synthetic */ void O(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        AppMethodBeat.i(44582);
        ab.d("MicroMsg.BankRemitBankcardInputUI", "init popup window");
        bankRemitBankcardInputUI.pMm = new ListPopupWindow(bankRemitBankcardInputUI);
        bankRemitBankcardInputUI.pMm.age = com.tencent.mm.bz.a.gd(bankRemitBankcardInputUI) - com.tencent.mm.bz.a.fromDPToPix(bankRemitBankcardInputUI, 30);
        bankRemitBankcardInputUI.pMm.setHeight(com.tencent.mm.bz.a.fromDPToPix(bankRemitBankcardInputUI, com.tencent.mm.plugin.appbrand.jsapi.g.n.CTRL_INDEX));
        bankRemitBankcardInputUI.pMm.setBackgroundDrawable(new ColorDrawable(0));
        bankRemitBankcardInputUI.pMm.setVerticalOffset(1);
        bankRemitBankcardInputUI.pMm.setAnimationStyle(R.style.h8);
        bankRemitBankcardInputUI.pMm.amx = bankRemitBankcardInputUI.pMh;
        bankRemitBankcardInputUI.pMm.setModal(false);
        bankRemitBankcardInputUI.pMm.amz = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(44533);
                ab.i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", Integer.valueOf(i));
                BankRemitBankcardInputUI.this.pMB = false;
                BankRemitBankcardInputUI.this.pMA = (TransferRecordParcel) adapterView.getAdapter().getItem(i);
                BankRemitBankcardInputUI.R(BankRemitBankcardInputUI.this);
                BankRemitBankcardInputUI.a(BankRemitBankcardInputUI.this, BankRemitBankcardInputUI.this.pMA.pMd, BankRemitBankcardInputUI.this.pMt, BankRemitBankcardInputUI.this.pMA.pbn);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44532);
                        BankRemitBankcardInputUI.this.pMh.cex();
                        AppMethodBeat.o(44532);
                    }
                }, 500);
                BankRemitBankcardInputUI.this.pMm.dismiss();
                BankRemitBankcardInputUI.this.aqX();
                AppMethodBeat.o(44533);
            }
        };
        bankRemitBankcardInputUI.pMo = new FilterListener() {
            public final void onFilterComplete(int i) {
                AppMethodBeat.i(44534);
                ab.i("MicroMsg.BankRemitBankcardInputUI", "filter complete: %d", Integer.valueOf(i));
                if (BankRemitBankcardInputUI.this.pMm != null) {
                    if (i > 0) {
                        if (i == 1) {
                            BankRemitBankcardInputUI.this.pMm.setHeight(com.tencent.mm.bz.a.fromDPToPix(BankRemitBankcardInputUI.this.mController.ylL, 68));
                        } else {
                            BankRemitBankcardInputUI.this.pMm.setHeight(com.tencent.mm.bz.a.fromDPToPix(BankRemitBankcardInputUI.this.mController.ylL, com.tencent.mm.plugin.appbrand.jsapi.g.n.CTRL_INDEX));
                        }
                        BankRemitBankcardInputUI.this.pMm.show();
                        AppMethodBeat.o(44534);
                        return;
                    } else if (i <= 0 && BankRemitBankcardInputUI.this.pMm.amH.isShowing()) {
                        BankRemitBankcardInputUI.this.pMm.dismiss();
                    }
                }
                AppMethodBeat.o(44534);
            }
        };
        ArrayList arrayList = new ArrayList();
        if (bankRemitBankcardInputUI.pMp != null) {
            arrayList.addAll(bankRemitBankcardInputUI.pMp);
        }
        if (bankRemitBankcardInputUI.pMq != null) {
            arrayList.addAll(bankRemitBankcardInputUI.pMq);
        }
        bankRemitBankcardInputUI.pMn = new c(bankRemitBankcardInputUI, arrayList);
        bankRemitBankcardInputUI.pMm.setAdapter(bankRemitBankcardInputUI.pMn);
        AppMethodBeat.o(44582);
    }

    static /* synthetic */ void b(BankRemitBankcardInputUI bankRemitBankcardInputUI, String str, String str2) {
        AppMethodBeat.i(44583);
        ab.i("MicroMsg.BankRemitBankcardInputUI", "doCheckBankBind()");
        bankRemitBankcardInputUI.s(bankRemitBankcardInputUI.pMM, bankRemitBankcardInputUI.pMN, str, str2);
        AppMethodBeat.o(44583);
    }
}
