package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.balance.a.a.o;
import com.tencent.mm.plugin.wallet.balance.a.a.u;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.bls;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WalletLqtPlanAddUI extends WalletLqtBasePresenterUI {
    private static final int tiO = a.fromDPToPix(ah.getContext(), 48);
    private static final int tiP = a.fromDPToPix(ah.getContext(), 8);
    private int mMode;
    private ScrollView tiQ;
    private WalletFormView tiR;
    private TextView tiS;
    private CdnImageView tiT;
    private TextView tiU;
    private LinearLayout tiV;
    private TextView tiW;
    private LinearLayout tiX;
    private Button tiY;
    private CheckBox tiZ;
    private TextView tja;
    private LinearLayout tjb;
    private u tjc = ((u) V(u.class));
    private List<Bankcard> tjd = new ArrayList();
    private aum tje;
    private bls tjf;
    private boolean tjg;
    private bkm tjh = new bkm();
    private ImageView tji;
    private LinearLayout tjj;
    private long tjk;
    private int tjl;
    private String tjm;
    private String tjn;
    private String[] tjo;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtPlanAddUI() {
        AppMethodBeat.i(45580);
        AppMethodBeat.o(45580);
    }

    static /* synthetic */ void k(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45598);
        walletLqtPlanAddUI.cNj();
        AppMethodBeat.o(45598);
    }

    static /* synthetic */ void m(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45600);
        walletLqtPlanAddUI.cNk();
        AppMethodBeat.o(45600);
    }

    static /* synthetic */ void p(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45602);
        walletLqtPlanAddUI.mN(false);
        AppMethodBeat.o(45602);
    }

    static {
        AppMethodBeat.i(45603);
        AppMethodBeat.o(45603);
    }

    public final void initView() {
        AppMethodBeat.i(45582);
        this.tiQ = (ScrollView) findViewById(R.id.cs3);
        this.tiR = (WalletFormView) findViewById(R.id.cs4);
        this.tiS = (TextView) findViewById(R.id.cs6);
        this.tiT = (CdnImageView) findViewById(R.id.cs9);
        this.tiU = (TextView) findViewById(R.id.cs_);
        this.tiV = (LinearLayout) findViewById(R.id.cs8);
        this.tiW = (TextView) findViewById(R.id.csb);
        this.tiX = (LinearLayout) findViewById(R.id.csa);
        this.tiY = (Button) findViewById(R.id.csc);
        this.tiZ = (CheckBox) findViewById(R.id.cse);
        this.tja = (TextView) findViewById(R.id.csf);
        this.tjb = (LinearLayout) findViewById(R.id.csd);
        this.tji = (ImageView) findViewById(R.id.cs7);
        this.tjj = (LinearLayout) findViewById(R.id.cs5);
        this.tiR.dOP();
        this.tiR.setTitleText(ae.dOd());
        a(this.tiR, 2, false, false, false);
        this.tiY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45558);
                WalletLqtPlanAddUI.this.aoB();
                ab.i("MicroMsg.WalletLqtPlanAddUI", "click btn");
                WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
                if (!WalletLqtPlanAddUI.this.tiY.isEnabled()) {
                    AppMethodBeat.o(45558);
                } else if (WalletLqtPlanAddUI.this.mMode == 1) {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 0);
                    AppMethodBeat.o(45558);
                } else {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, 4);
                    AppMethodBeat.o(45558);
                }
            }
        });
        this.tiZ.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(45569);
                WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(45569);
            }
        });
        this.tiV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45570);
                WalletLqtPlanAddUI.d(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(45570);
            }
        });
        this.tiX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45571);
                WalletLqtPlanAddUI.e(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(45571);
            }
        });
        this.tiR.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(45572);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
                WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(45572);
            }
        });
        int fromDPToPix = a.fromDPToPix(this, 50);
        bo.n(this.tji, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        this.tji.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45573);
                h.a(WalletLqtPlanAddUI.this.mController.ylL, WalletLqtPlanAddUI.this.getString(R.string.fj7), "", WalletLqtPlanAddUI.this.getString(R.string.r4), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(45573);
            }
        });
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(45576);
                if (z) {
                    LayoutParams layoutParams = (LayoutParams) WalletLqtPlanAddUI.this.tiY.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.bottomMargin = WalletLqtPlanAddUI.tiP;
                        WalletLqtPlanAddUI.this.tiY.setLayoutParams(layoutParams);
                    }
                    WalletLqtPlanAddUI.this.tiQ.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(45574);
                            WalletLqtPlanAddUI.this.tiQ.scrollTo(0, WalletLqtPlanAddUI.this.tiR.getTop());
                            AppMethodBeat.o(45574);
                        }
                    });
                    AppMethodBeat.o(45576);
                    return;
                }
                WalletLqtPlanAddUI.this.tiQ.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45575);
                        LayoutParams layoutParams = (LayoutParams) WalletLqtPlanAddUI.this.tiY.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.bottomMargin = WalletLqtPlanAddUI.tiO;
                            WalletLqtPlanAddUI.this.tiY.setLayoutParams(layoutParams);
                        }
                        WalletLqtPlanAddUI.this.tiQ.scrollTo(0, 0);
                        AppMethodBeat.o(45575);
                    }
                });
                AppMethodBeat.o(45576);
            }
        };
        AppMethodBeat.o(45582);
    }

    public void onDestroy() {
        AppMethodBeat.i(45583);
        super.onDestroy();
        AppMethodBeat.o(45583);
    }

    public final int getLayoutId() {
        return R.layout.a_n;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(45584);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        int iy;
        String str;
        String str2;
        String str3;
        int i3;
        final Dialog b;
        if (i == 0) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("encrypt_pwd");
                iy = e.iy(this.tiR.getText(), "100");
                str = this.tjh.pbn;
                str2 = this.tjh.pck;
                str3 = this.tjh.vEQ;
                i3 = this.tjh.ehf;
                int i4 = this.tjh.vES;
                b = g.b(this.mController.ylL, false, null);
                f.a(stringExtra, str, str2, str3, Integer.valueOf(iy), Integer.valueOf(i3), Integer.valueOf(i4)).c(this.tjc.tfM).f(new com.tencent.mm.vending.c.a<Object, ct>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(45560);
                        b.dismiss();
                        Toast.makeText(WalletLqtPlanAddUI.this.mController.ylL, R.string.fje, 1).show();
                        WalletLqtPlanAddUI.this.setResult(-1);
                        WalletLqtPlanAddUI.this.finish();
                        AppMethodBeat.o(45560);
                        return null;
                    }
                }).a((d.a) new d.a() {
                    public final void bi(Object obj) {
                        AppMethodBeat.i(45559);
                        b.dismiss();
                        if (obj instanceof m) {
                            ((m) obj).y(WalletLqtPlanAddUI.this.mController.ylL, false);
                        }
                        AppMethodBeat.o(45559);
                    }
                });
            }
        } else if (i == 4 && i2 == -1) {
            String stringExtra2 = intent.getStringExtra("encrypt_pwd");
            iy = e.iy(this.tiR.getText(), "100");
            int i5 = this.tjh.vES;
            str = this.tjh.pbn;
            str2 = this.tjh.pck;
            str3 = this.tjh.vEQ;
            i3 = this.tjh.ehf;
            b = g.b(this.mController.ylL, false, null);
            f.a(Integer.valueOf(i5), str, str2, str3, Integer.valueOf(iy), Integer.valueOf(i3), stringExtra2).c(this.tjc.tfN).f(new com.tencent.mm.vending.c.a<Object, bdd>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45562);
                    b.dismiss();
                    Toast.makeText(WalletLqtPlanAddUI.this.mController.ylL, R.string.fje, 1).show();
                    WalletLqtPlanAddUI.this.setResult(-1);
                    WalletLqtPlanAddUI.this.finish();
                    AppMethodBeat.o(45562);
                    return null;
                }
            }).a((d.a) new d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(45561);
                    b.dismiss();
                    if (obj instanceof m) {
                        ((m) obj).y(WalletLqtPlanAddUI.this.mController.ylL, false);
                    }
                    AppMethodBeat.o(45561);
                }
            });
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(45584);
    }

    private void mN(final boolean z) {
        int i;
        Dialog dialog = null;
        AppMethodBeat.i(45585);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", Boolean.valueOf(z));
        if (this.mMode != 2 || this.tjh == null) {
            i = 0;
        } else {
            i = this.tjh.vES;
            dialog = g.b(this.mController.ylL, false, null);
        }
        o oVar = new o();
        oVar.b(new com.tencent.mm.plugin.wallet.balance.a.a.h(this.mMode, i));
        oVar.a(new com.tencent.mm.wallet_core.c.a.a<bla>() {
            public final /* synthetic */ void bX(Object obj) {
                AppMethodBeat.i(45578);
                bla bla = (bla) obj;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (bla == null) {
                    m.gi(0, 0).y(WalletLqtPlanAddUI.this.mController.ylL, true);
                    AppMethodBeat.o(45578);
                } else if (bla.kdT == 0) {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, bla, z);
                    AppMethodBeat.o(45578);
                } else {
                    m.a(true, bla.kdT, 0, bla.kdU).y(WalletLqtPlanAddUI.this.mController.ylL, true);
                    AppMethodBeat.o(45578);
                }
            }

            public final /* synthetic */ void bY(Object obj) {
                AppMethodBeat.i(45579);
                bla bla = (bla) obj;
                if (bla != null) {
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, bla, z);
                }
                AppMethodBeat.o(45579);
            }
        });
        AppMethodBeat.o(45585);
    }

    private void cu() {
        AppMethodBeat.i(45586);
        cNi();
        cNj();
        cNk();
        cNl();
        AppMethodBeat.o(45586);
    }

    private void cNi() {
        AppMethodBeat.i(45587);
        if (this.mMode == 2) {
            BigDecimal a = e.a(this.tjh.cSh, "100", 2, RoundingMode.HALF_UP);
            if (((double) a.intValue()) == a.doubleValue()) {
                this.tiR.setText(a.intValue());
                AppMethodBeat.o(45587);
                return;
            }
            this.tiR.setText(a.toString());
        }
        AppMethodBeat.o(45587);
    }

    private void cNj() {
        AppMethodBeat.i(45588);
        final Bankcard acm = acm(this.tjh.vEQ);
        if (acm != null) {
            this.tiU.setText(String.format("%s(%s)", new Object[]{this.tjh.nuL, this.tjh.pck}));
            this.tiT.setTag(this.tjh.vEQ);
            if (acm.cPc()) {
                this.tiT.setImageResource(R.drawable.bki);
                AppMethodBeat.o(45588);
                return;
            }
            String str = "";
            com.tencent.mm.plugin.wallet_core.model.e i = b.i(this, acm.field_bankcardType, acm.cPb());
            if (i != null) {
                str = i.oRi;
            }
            Bitmap a = x.a(new c(str));
            if (a != null) {
                this.tiT.setImageBitmap(a);
            }
            x.a(new x.a() {
                public final void m(String str, final Bitmap bitmap) {
                    AppMethodBeat.i(45566);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(45565);
                            if (!(acm == null || WalletLqtPlanAddUI.this.tiT.getTag() == null || !WalletLqtPlanAddUI.this.tiT.getTag().equals(acm.field_bindSerial))) {
                                WalletLqtPlanAddUI.this.tiT.setImageBitmap(bitmap);
                            }
                            AppMethodBeat.o(45565);
                        }
                    });
                    AppMethodBeat.o(45566);
                }
            });
        }
        AppMethodBeat.o(45588);
    }

    private void cNk() {
        AppMethodBeat.i(45589);
        int i = this.tjh.ehf - 1;
        ab.i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", Integer.valueOf(i));
        if (i >= 0 && i < this.tjo.length) {
            this.tiW.setText(this.tjo[i]);
        }
        AppMethodBeat.o(45589);
    }

    private void cNl() {
        AppMethodBeat.i(45590);
        if (this.tjf == null || bo.isNullOrNil(this.tjf.title)) {
            this.tjb.setVisibility(8);
            AppMethodBeat.o(45590);
            return;
        }
        this.tja.setClickable(true);
        this.tja.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        com.tencent.mm.plugin.wallet_core.ui.o oVar = new com.tencent.mm.plugin.wallet_core.ui.o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
            public final void df(View view) {
                AppMethodBeat.i(45567);
                e.n(WalletLqtPlanAddUI.this.mController.ylL, WalletLqtPlanAddUI.this.tjf.url, true);
                AppMethodBeat.o(45567);
            }
        });
        String string = getString(R.string.fjb);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append(this.tjf.title);
        spannableStringBuilder.setSpan(oVar, string.length(), spannableStringBuilder.length(), 18);
        this.tja.setText(spannableStringBuilder);
        this.tjb.setVisibility(0);
        AppMethodBeat.o(45590);
    }

    private Bankcard acm(String str) {
        AppMethodBeat.i(45591);
        for (Bankcard bankcard : this.tjd) {
            if (bankcard.field_bindSerial.equals(str)) {
                AppMethodBeat.o(45591);
                return bankcard;
            }
        }
        Bankcard bankcard2 = r.cPI().h(str, false, false);
        AppMethodBeat.o(45591);
        return bankcard2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45581);
        this.yll = true;
        super.onCreate(bundle);
        setMMTitle((int) R.string.fjk);
        xE(getResources().getColor(R.color.a69));
        dyb();
        this.mMode = getIntent().getIntExtra("key_mode", 0);
        if (this.mMode == 2) {
            try {
                bkm bkm = new bkm();
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_plan_item");
                if (byteArrayExtra != null) {
                    this.tjh = (bkm) bkm.parseFrom(byteArrayExtra);
                    this.tjk = this.tjh.cSh;
                    this.tjl = this.tjh.ehf;
                    this.tjm = this.tjh.vEQ;
                }
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", e, "", new Object[0]);
            }
        }
        this.tjo = new String[28];
        for (int i = 0; i < 28; i++) {
            this.tjo[i] = getString(R.string.fj3, new Object[]{String.valueOf(i + 1)});
        }
        initView();
        cu();
        mN(true);
        AppMethodBeat.o(45581);
    }

    static /* synthetic */ void a(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45592);
        double d = bo.getDouble(walletLqtPlanAddUI.tiR.getText(), 0.0d);
        Bankcard acm = walletLqtPlanAddUI.acm(walletLqtPlanAddUI.tjh.vEQ);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "mode: %s, money: %s, bankcard: %s, day: %s", Integer.valueOf(walletLqtPlanAddUI.mMode), Double.valueOf(d), walletLqtPlanAddUI.tjh.pbn, Integer.valueOf(walletLqtPlanAddUI.tjh.ehf));
        if (acm == null || walletLqtPlanAddUI.tjh.ehf <= 0 || d <= 0.0d || d > acm.field_onceQuotaKind || (walletLqtPlanAddUI.tjb.getVisibility() == 0 && !walletLqtPlanAddUI.tiZ.isChecked())) {
            walletLqtPlanAddUI.tiY.setEnabled(false);
            AppMethodBeat.o(45592);
        } else if (walletLqtPlanAddUI.mMode == 2 && e.c(String.valueOf(d), "100", RoundingMode.HALF_UP) == ((double) walletLqtPlanAddUI.tjk) && walletLqtPlanAddUI.tjh.ehf == walletLqtPlanAddUI.tjl && walletLqtPlanAddUI.tjh.vEQ.equals(walletLqtPlanAddUI.tjm)) {
            ab.i("MicroMsg.WalletLqtPlanAddUI", "no changed old");
            walletLqtPlanAddUI.tiY.setEnabled(false);
            AppMethodBeat.o(45592);
        } else {
            walletLqtPlanAddUI.tiY.setEnabled(true);
            AppMethodBeat.o(45592);
        }
    }

    static /* synthetic */ void d(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45594);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "show bankcard menu");
        walletLqtPlanAddUI.aoB();
        com.tencent.mm.plugin.wallet_core.ui.h.a(walletLqtPlanAddUI, walletLqtPlanAddUI.tjd, walletLqtPlanAddUI.acm(walletLqtPlanAddUI.tjh.vEQ), walletLqtPlanAddUI.getString(R.string.fiv), "", !walletLqtPlanAddUI.tjg, walletLqtPlanAddUI.getString(R.string.fix), new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(45563);
                if (i < WalletLqtPlanAddUI.this.tjd.size()) {
                    Bankcard bankcard = (Bankcard) WalletLqtPlanAddUI.this.tjd.get(i);
                    WalletLqtPlanAddUI.this.tjh.vEQ = bankcard.field_bindSerial;
                    WalletLqtPlanAddUI.this.tjh.pbn = bankcard.field_bankcardType;
                    WalletLqtPlanAddUI.this.tjh.nuL = bankcard.field_bankName;
                    WalletLqtPlanAddUI.this.tjh.pck = bankcard.field_bankcardTail;
                    WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.f(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
                    AppMethodBeat.o(45563);
                    return;
                }
                WalletLqtPlanAddUI.l(WalletLqtPlanAddUI.this);
                AppMethodBeat.o(45563);
            }
        });
        AppMethodBeat.o(45594);
    }

    static /* synthetic */ void e(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45595);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "show date picker");
        walletLqtPlanAddUI.aoB();
        final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b((Context) walletLqtPlanAddUI, walletLqtPlanAddUI.tjo);
        if (walletLqtPlanAddUI.tjh.ehf - 1 >= 0) {
            bVar.Qq(walletLqtPlanAddUI.tjh.ehf - 1);
        }
        bVar.zSq = new com.tencent.mm.ui.widget.picker.b.a() {
            public final void d(boolean z, Object obj) {
                AppMethodBeat.i(45564);
                bVar.hide();
                if (z) {
                    WalletLqtPlanAddUI.this.tjh.ehf = bVar.dLl() + 1;
                    WalletLqtPlanAddUI.m(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this);
                }
                AppMethodBeat.o(45564);
            }
        };
        bVar.Qp(aj.fromDPToPix(walletLqtPlanAddUI, com.tencent.view.d.MIC_PTU_YOUJIALI));
        bVar.show();
        AppMethodBeat.o(45595);
    }

    static /* synthetic */ void f(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45596);
        double d = bo.getDouble(walletLqtPlanAddUI.tiR.getText(), 0.0d);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "money: %s", Double.valueOf(d));
        Bankcard acm = walletLqtPlanAddUI.acm(walletLqtPlanAddUI.tjh.vEQ);
        if (acm != null && d > acm.field_dayQuotaKind) {
            ab.i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
            walletLqtPlanAddUI.tiS.setText(walletLqtPlanAddUI.tjn);
            walletLqtPlanAddUI.tiS.setTextColor(walletLqtPlanAddUI.getResources().getColor(R.color.y0));
            walletLqtPlanAddUI.tji.setVisibility(8);
            walletLqtPlanAddUI.tjj.setVisibility(0);
            AppMethodBeat.o(45596);
        } else if (d <= 0.0d || walletLqtPlanAddUI.tje == null || bo.getDouble(walletLqtPlanAddUI.tje.wyH, 0.0d) <= 0.0d) {
            walletLqtPlanAddUI.tjj.setVisibility(4);
            AppMethodBeat.o(45596);
        } else {
            String bigDecimal = e.b(walletLqtPlanAddUI.tiR.getText(), e.a(walletLqtPlanAddUI.tje.wyH, "10000", 2, RoundingMode.HALF_UP).toString(), 2, RoundingMode.HALF_UP).toString();
            ab.i("MicroMsg.WalletLqtPlanAddUI", "income: %s", bigDecimal);
            walletLqtPlanAddUI.tiS.setText(walletLqtPlanAddUI.getString(R.string.fj6, new Object[]{walletLqtPlanAddUI.tje.title, bigDecimal}));
            walletLqtPlanAddUI.tiS.setTextColor(walletLqtPlanAddUI.getResources().getColor(R.color.w0));
            walletLqtPlanAddUI.tji.setVisibility(0);
            walletLqtPlanAddUI.tjj.setVisibility(0);
            AppMethodBeat.o(45596);
        }
    }

    static /* synthetic */ void a(WalletLqtPlanAddUI walletLqtPlanAddUI, bla bla, boolean z) {
        Bankcard acm;
        AppMethodBeat.i(45597);
        walletLqtPlanAddUI.tje = bla.wNW;
        walletLqtPlanAddUI.tjf = bla.wNX;
        walletLqtPlanAddUI.tjg = bla.wCP;
        walletLqtPlanAddUI.tjn = bla.wNY;
        if (!(bla.wmz == null || bla.wmz.isEmpty())) {
            ab.i("MicroMsg.WalletLqtPlanAddUI", "array size: %s", bla.wmz);
            walletLqtPlanAddUI.tjd.clear();
            for (Bankcard acm2 : com.tencent.mm.plugin.wallet_core.model.d.dQ(bla.wmz)) {
                if (acm2.field_support_lqt_turn_in == 1) {
                    walletLqtPlanAddUI.tjd.add(acm2);
                } else {
                    ab.i("MicroMsg.WalletLqtPlanAddUI", "not support: %s", acm2.field_bankcardTypeName);
                }
            }
        }
        if (z) {
            acm2 = walletLqtPlanAddUI.acm(bla.wCO);
            if (acm2 != null) {
                walletLqtPlanAddUI.tjh.vEQ = bla.wCO;
                walletLqtPlanAddUI.tjh.pbn = acm2.field_bankcardType;
                walletLqtPlanAddUI.tjh.nuL = acm2.field_bankName;
                walletLqtPlanAddUI.tjh.pck = acm2.field_bankcardTail;
            }
        }
        walletLqtPlanAddUI.tjh.vES = bla.vES;
        if (walletLqtPlanAddUI.mMode == 1 || walletLqtPlanAddUI.mMode == 3) {
            walletLqtPlanAddUI.tjh.ehf = bla.wNZ;
            walletLqtPlanAddUI.tjh.cSh = bla.wOa;
        }
        walletLqtPlanAddUI.cu();
        walletLqtPlanAddUI.tiQ.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(45577);
                WalletLqtPlanAddUI.this.tiQ.scrollTo(0, WalletLqtPlanAddUI.this.tiR.getTop());
                AppMethodBeat.o(45577);
            }
        }, 100);
        AppMethodBeat.o(45597);
    }

    static /* synthetic */ void l(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.i(45599);
        ab.i("MicroMsg.WalletLqtPlanAddUI", "go to bindcard");
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a((Activity) walletLqtPlanAddUI, c.class, bundle, new com.tencent.mm.wallet_core.c.a() {
            public final Intent n(int i, Bundle bundle) {
                AppMethodBeat.i(45568);
                ab.i("MicroMsg.WalletLqtPlanAddUI", "bind card finish: %s", Integer.valueOf(i));
                if (i == -1) {
                    BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
                    if (bindCardOrder != null) {
                        ab.i("MicroMsg.WalletLqtPlanAddUI", "bind card serial: %s", bindCardOrder.txK);
                        Bankcard a = WalletLqtPlanAddUI.a(WalletLqtPlanAddUI.this, bindCardOrder.txK);
                        if (a != null) {
                            WalletLqtPlanAddUI.this.tjh.vEQ = a.field_bindSerial;
                            WalletLqtPlanAddUI.this.tjh.pbn = a.field_bankcardType;
                            WalletLqtPlanAddUI.this.tjh.nuL = a.field_bankName;
                            WalletLqtPlanAddUI.this.tjh.pck = a.field_bankcardTail;
                            WalletLqtPlanAddUI.k(WalletLqtPlanAddUI.this);
                        }
                    }
                    WalletLqtPlanAddUI.p(WalletLqtPlanAddUI.this);
                }
                AppMethodBeat.o(45568);
                return null;
            }
        });
        AppMethodBeat.o(45599);
    }
}
