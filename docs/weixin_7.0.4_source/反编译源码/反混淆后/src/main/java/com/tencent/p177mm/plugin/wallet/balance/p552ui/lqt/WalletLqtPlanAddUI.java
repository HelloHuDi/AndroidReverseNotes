package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29530h;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35400u;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C46337o;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C29630d;
import com.tencent.p177mm.plugin.wallet_core.model.C29634m;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40127h;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.protocal.protobuf.C15328ct;
import com.tencent.p177mm.protocal.protobuf.aum;
import com.tencent.p177mm.protocal.protobuf.bdd;
import com.tencent.p177mm.protocal.protobuf.bkm;
import com.tencent.p177mm.protocal.protobuf.bla;
import com.tencent.p177mm.protocal.protobuf.bls;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c.C30857a;
import com.tencent.p177mm.wallet_core.p649c.C44421a.C40926a;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI */
public class WalletLqtPlanAddUI extends WalletLqtBasePresenterUI {
    private static final int tiO = C1338a.fromDPToPix(C4996ah.getContext(), 48);
    private static final int tiP = C1338a.fromDPToPix(C4996ah.getContext(), 8);
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
    private C35400u tjc = ((C35400u) mo74555V(C35400u.class));
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

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$10 */
    class C1414510 implements C30857a {
        C1414510() {
        }

        /* renamed from: n */
        public final Intent mo7785n(int i, Bundle bundle) {
            AppMethodBeat.m2504i(45568);
            C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "bind card finish: %s", Integer.valueOf(i));
            if (i == -1) {
                BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
                if (bindCardOrder != null) {
                    C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "bind card serial: %s", bindCardOrder.txK);
                    Bankcard a = WalletLqtPlanAddUI.m58097a(WalletLqtPlanAddUI.this, bindCardOrder.txK);
                    if (a != null) {
                        WalletLqtPlanAddUI.this.tjh.vEQ = a.field_bindSerial;
                        WalletLqtPlanAddUI.this.tjh.pbn = a.field_bankcardType;
                        WalletLqtPlanAddUI.this.tjh.nuL = a.field_bankName;
                        WalletLqtPlanAddUI.this.tjh.pck = a.field_bankcardTail;
                        WalletLqtPlanAddUI.m58111k(WalletLqtPlanAddUI.this);
                    }
                }
                WalletLqtPlanAddUI.m58117p(WalletLqtPlanAddUI.this);
            }
            AppMethodBeat.m2505o(45568);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$17 */
    class C2251117 implements Runnable {
        C2251117() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45577);
            WalletLqtPlanAddUI.this.tiQ.scrollTo(0, WalletLqtPlanAddUI.this.tiR.getTop());
            AppMethodBeat.m2505o(45577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$6 */
    class C295756 implements C5279d {
        C295756() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(45563);
            if (i < WalletLqtPlanAddUI.this.tjd.size()) {
                Bankcard bankcard = (Bankcard) WalletLqtPlanAddUI.this.tjd.get(i);
                WalletLqtPlanAddUI.this.tjh.vEQ = bankcard.field_bindSerial;
                WalletLqtPlanAddUI.this.tjh.pbn = bankcard.field_bankcardType;
                WalletLqtPlanAddUI.this.tjh.nuL = bankcard.field_bankName;
                WalletLqtPlanAddUI.this.tjh.pck = bankcard.field_bankcardTail;
                WalletLqtPlanAddUI.m58111k(WalletLqtPlanAddUI.this);
                WalletLqtPlanAddUI.m58106f(WalletLqtPlanAddUI.this);
                WalletLqtPlanAddUI.m58098a(WalletLqtPlanAddUI.this);
                AppMethodBeat.m2505o(45563);
                return;
            }
            WalletLqtPlanAddUI.m58112l(WalletLqtPlanAddUI.this);
            AppMethodBeat.m2505o(45563);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$16 */
    class C3541116 implements C40947a {

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$16$1 */
        class C225091 implements Runnable {
            C225091() {
            }

            public final void run() {
                AppMethodBeat.m2504i(45574);
                WalletLqtPlanAddUI.this.tiQ.scrollTo(0, WalletLqtPlanAddUI.this.tiR.getTop());
                AppMethodBeat.m2505o(45574);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$16$2 */
        class C225102 implements Runnable {
            C225102() {
            }

            public final void run() {
                AppMethodBeat.m2504i(45575);
                LayoutParams layoutParams = (LayoutParams) WalletLqtPlanAddUI.this.tiY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.bottomMargin = WalletLqtPlanAddUI.tiO;
                    WalletLqtPlanAddUI.this.tiY.setLayoutParams(layoutParams);
                }
                WalletLqtPlanAddUI.this.tiQ.scrollTo(0, 0);
                AppMethodBeat.m2505o(45575);
            }
        }

        C3541116() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(45576);
            if (z) {
                LayoutParams layoutParams = (LayoutParams) WalletLqtPlanAddUI.this.tiY.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.bottomMargin = WalletLqtPlanAddUI.tiP;
                    WalletLqtPlanAddUI.this.tiY.setLayoutParams(layoutParams);
                }
                WalletLqtPlanAddUI.this.tiQ.post(new C225091());
                AppMethodBeat.m2505o(45576);
                return;
            }
            WalletLqtPlanAddUI.this.tiQ.post(new C225102());
            AppMethodBeat.m2505o(45576);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$15 */
    class C3541215 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$15$1 */
        class C354131 implements DialogInterface.OnClickListener {
            C354131() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C3541215() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45573);
            C30379h.m48443a(WalletLqtPlanAddUI.this.mController.ylL, WalletLqtPlanAddUI.this.getString(C25738R.string.fj7), "", WalletLqtPlanAddUI.this.getString(C25738R.string.f9151r4), new C354131());
            AppMethodBeat.m2505o(45573);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$9 */
    class C354159 implements C35502a {
        C354159() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(45567);
            C36391e.m60016n(WalletLqtPlanAddUI.this.mController.ylL, WalletLqtPlanAddUI.this.tjf.url, true);
            AppMethodBeat.m2505o(45567);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$12 */
    class C3541612 implements OnClickListener {
        C3541612() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45570);
            WalletLqtPlanAddUI.m58104d(WalletLqtPlanAddUI.this);
            AppMethodBeat.m2505o(45570);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$13 */
    class C3541713 implements OnClickListener {
        C3541713() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45571);
            WalletLqtPlanAddUI.m58105e(WalletLqtPlanAddUI.this);
            AppMethodBeat.m2505o(45571);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$14 */
    class C3541814 implements TextWatcher {
        C3541814() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(45572);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            WalletLqtPlanAddUI.m58106f(WalletLqtPlanAddUI.this);
            WalletLqtPlanAddUI.m58098a(WalletLqtPlanAddUI.this);
            AppMethodBeat.m2505o(45572);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$11 */
    class C3541911 implements OnCheckedChangeListener {
        C3541911() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(45569);
            WalletLqtPlanAddUI.m58098a(WalletLqtPlanAddUI.this);
            AppMethodBeat.m2505o(45569);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI$1 */
    class C354201 implements OnClickListener {
        C354201() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45558);
            WalletLqtPlanAddUI.this.aoB();
            C4990ab.m7416i("MicroMsg.WalletLqtPlanAddUI", "click btn");
            WalletLqtPlanAddUI.m58098a(WalletLqtPlanAddUI.this);
            if (!WalletLqtPlanAddUI.this.tiY.isEnabled()) {
                AppMethodBeat.m2505o(45558);
            } else if (WalletLqtPlanAddUI.this.mMode == 1) {
                WalletLqtPlanAddUI.m58099a(WalletLqtPlanAddUI.this, 0);
                AppMethodBeat.m2505o(45558);
            } else {
                WalletLqtPlanAddUI.m58099a(WalletLqtPlanAddUI.this, 4);
                AppMethodBeat.m2505o(45558);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletLqtPlanAddUI() {
        AppMethodBeat.m2504i(45580);
        AppMethodBeat.m2505o(45580);
    }

    /* renamed from: k */
    static /* synthetic */ void m58111k(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45598);
        walletLqtPlanAddUI.cNj();
        AppMethodBeat.m2505o(45598);
    }

    /* renamed from: m */
    static /* synthetic */ void m58113m(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45600);
        walletLqtPlanAddUI.cNk();
        AppMethodBeat.m2505o(45600);
    }

    /* renamed from: p */
    static /* synthetic */ void m58117p(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45602);
        walletLqtPlanAddUI.m58114mN(false);
        AppMethodBeat.m2505o(45602);
    }

    static {
        AppMethodBeat.m2504i(45603);
        AppMethodBeat.m2505o(45603);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45582);
        this.tiQ = (ScrollView) findViewById(2131825356);
        this.tiR = (WalletFormView) findViewById(2131825357);
        this.tiS = (TextView) findViewById(2131825359);
        this.tiT = (CdnImageView) findViewById(2131825362);
        this.tiU = (TextView) findViewById(2131825363);
        this.tiV = (LinearLayout) findViewById(2131825361);
        this.tiW = (TextView) findViewById(2131825365);
        this.tiX = (LinearLayout) findViewById(2131825364);
        this.tiY = (Button) findViewById(2131825366);
        this.tiZ = (CheckBox) findViewById(2131825368);
        this.tja = (TextView) findViewById(2131825369);
        this.tjb = (LinearLayout) findViewById(2131825367);
        this.tji = (ImageView) findViewById(2131825360);
        this.tjj = (LinearLayout) findViewById(2131825358);
        this.tiR.dOP();
        this.tiR.setTitleText(C44423ae.dOd());
        mo39968a(this.tiR, 2, false, false, false);
        this.tiY.setOnClickListener(new C354201());
        this.tiZ.setOnCheckedChangeListener(new C3541911());
        this.tiV.setOnClickListener(new C3541612());
        this.tiX.setOnClickListener(new C3541713());
        this.tiR.mo64594a(new C3541814());
        int fromDPToPix = C1338a.fromDPToPix(this, 50);
        C5046bo.m7582n(this.tji, fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        this.tji.setOnClickListener(new C3541215());
        this.obM = new C3541116();
        AppMethodBeat.m2505o(45582);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45583);
        super.onDestroy();
        AppMethodBeat.m2505o(45583);
    }

    public final int getLayoutId() {
        return 2130969962;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45584);
        C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "activity result: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        int iy;
        String str;
        String str2;
        String str3;
        int i3;
        final Dialog b;
        if (i == 0) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("encrypt_pwd");
                iy = C36391e.m60012iy(this.tiR.getText(), "100");
                str = this.tjh.pbn;
                str2 = this.tjh.pck;
                str3 = this.tjh.vEQ;
                i3 = this.tjh.ehf;
                int i4 = this.tjh.vES;
                b = C30901g.m49318b(this.mController.ylL, false, null);
                C5698f.m8554a(stringExtra, str, str2, str3, Integer.valueOf(iy), Integer.valueOf(i3), Integer.valueOf(i4)).mo15892c(this.tjc.tfM).mo15896f(new C5681a<Object, C15328ct>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(45560);
                        b.dismiss();
                        Toast.makeText(WalletLqtPlanAddUI.this.mController.ylL, C25738R.string.fje, 1).show();
                        WalletLqtPlanAddUI.this.setResult(-1);
                        WalletLqtPlanAddUI.this.finish();
                        AppMethodBeat.m2505o(45560);
                        return null;
                    }
                }).mo11586a((C5690a) new C5690a() {
                    /* renamed from: bi */
                    public final void mo9345bi(Object obj) {
                        AppMethodBeat.m2504i(45559);
                        b.dismiss();
                        if (obj instanceof C29634m) {
                            ((C29634m) obj).mo47880y(WalletLqtPlanAddUI.this.mController.ylL, false);
                        }
                        AppMethodBeat.m2505o(45559);
                    }
                });
            }
        } else if (i == 4 && i2 == -1) {
            String stringExtra2 = intent.getStringExtra("encrypt_pwd");
            iy = C36391e.m60012iy(this.tiR.getText(), "100");
            int i5 = this.tjh.vES;
            str = this.tjh.pbn;
            str2 = this.tjh.pck;
            str3 = this.tjh.vEQ;
            i3 = this.tjh.ehf;
            b = C30901g.m49318b(this.mController.ylL, false, null);
            C5698f.m8554a(Integer.valueOf(i5), str, str2, str3, Integer.valueOf(iy), Integer.valueOf(i3), stringExtra2).mo15892c(this.tjc.tfN).mo15896f(new C5681a<Object, bdd>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.m2504i(45562);
                    b.dismiss();
                    Toast.makeText(WalletLqtPlanAddUI.this.mController.ylL, C25738R.string.fje, 1).show();
                    WalletLqtPlanAddUI.this.setResult(-1);
                    WalletLqtPlanAddUI.this.finish();
                    AppMethodBeat.m2505o(45562);
                    return null;
                }
            }).mo11586a((C5690a) new C5690a() {
                /* renamed from: bi */
                public final void mo9345bi(Object obj) {
                    AppMethodBeat.m2504i(45561);
                    b.dismiss();
                    if (obj instanceof C29634m) {
                        ((C29634m) obj).mo47880y(WalletLqtPlanAddUI.this.mController.ylL, false);
                    }
                    AppMethodBeat.m2505o(45561);
                }
            });
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(45584);
    }

    /* renamed from: mN */
    private void m58114mN(final boolean z) {
        int i;
        Dialog dialog = null;
        AppMethodBeat.m2504i(45585);
        C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "do pre add plan: %s", Boolean.valueOf(z));
        if (this.mMode != 2 || this.tjh == null) {
            i = 0;
        } else {
            i = this.tjh.vES;
            dialog = C30901g.m49318b(this.mController.ylL, false, null);
        }
        C46337o c46337o = new C46337o();
        c46337o.mo70317b(new C29530h(this.mMode, i));
        c46337o.mo70316a(new C40926a<bla>() {
            /* renamed from: bX */
            public final /* synthetic */ void mo9356bX(Object obj) {
                AppMethodBeat.m2504i(45578);
                bla bla = (bla) obj;
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (bla == null) {
                    C29634m.m47003gi(0, 0).mo47880y(WalletLqtPlanAddUI.this.mController.ylL, true);
                    AppMethodBeat.m2505o(45578);
                } else if (bla.kdT == 0) {
                    WalletLqtPlanAddUI.m58100a(WalletLqtPlanAddUI.this, bla, z);
                    AppMethodBeat.m2505o(45578);
                } else {
                    C29634m.m47002a(true, bla.kdT, 0, bla.kdU).mo47880y(WalletLqtPlanAddUI.this.mController.ylL, true);
                    AppMethodBeat.m2505o(45578);
                }
            }

            /* renamed from: bY */
            public final /* synthetic */ void mo9357bY(Object obj) {
                AppMethodBeat.m2504i(45579);
                bla bla = (bla) obj;
                if (bla != null) {
                    WalletLqtPlanAddUI.m58100a(WalletLqtPlanAddUI.this, bla, z);
                }
                AppMethodBeat.m2505o(45579);
            }
        });
        AppMethodBeat.m2505o(45585);
    }

    /* renamed from: cu */
    private void m58103cu() {
        AppMethodBeat.m2504i(45586);
        cNi();
        cNj();
        cNk();
        cNl();
        AppMethodBeat.m2505o(45586);
    }

    private void cNi() {
        AppMethodBeat.m2504i(45587);
        if (this.mMode == 2) {
            BigDecimal a = C36391e.m59981a(this.tjh.cSh, "100", 2, RoundingMode.HALF_UP);
            if (((double) a.intValue()) == a.doubleValue()) {
                this.tiR.setText(a.intValue());
                AppMethodBeat.m2505o(45587);
                return;
            }
            this.tiR.setText(a.toString());
        }
        AppMethodBeat.m2505o(45587);
    }

    private void cNj() {
        AppMethodBeat.m2504i(45588);
        final Bankcard acm = acm(this.tjh.vEQ);
        if (acm != null) {
            this.tiU.setText(String.format("%s(%s)", new Object[]{this.tjh.nuL, this.tjh.pck}));
            this.tiT.setTag(this.tjh.vEQ);
            if (acm.cPc()) {
                this.tiT.setImageResource(C25738R.drawable.bki);
                AppMethodBeat.m2505o(45588);
                return;
            }
            String str = "";
            C43807e i = C46362b.m87144i(this, acm.field_bankcardType, acm.cPb());
            if (i != null) {
                str = i.oRi;
            }
            Bitmap a = C18764x.m29325a(new C4467c(str));
            if (a != null) {
                this.tiT.setImageBitmap(a);
            }
            C18764x.m29326a(new C18765a() {
                /* renamed from: m */
                public final void mo8136m(String str, final Bitmap bitmap) {
                    AppMethodBeat.m2504i(45566);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(45565);
                            if (!(acm == null || WalletLqtPlanAddUI.this.tiT.getTag() == null || !WalletLqtPlanAddUI.this.tiT.getTag().equals(acm.field_bindSerial))) {
                                WalletLqtPlanAddUI.this.tiT.setImageBitmap(bitmap);
                            }
                            AppMethodBeat.m2505o(45565);
                        }
                    });
                    AppMethodBeat.m2505o(45566);
                }
            });
        }
        AppMethodBeat.m2505o(45588);
    }

    private void cNk() {
        AppMethodBeat.m2504i(45589);
        int i = this.tjh.ehf - 1;
        C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "select day index: %s", Integer.valueOf(i));
        if (i >= 0 && i < this.tjo.length) {
            this.tiW.setText(this.tjo[i]);
        }
        AppMethodBeat.m2505o(45589);
    }

    private void cNl() {
        AppMethodBeat.m2504i(45590);
        if (this.tjf == null || C5046bo.isNullOrNil(this.tjf.title)) {
            this.tjb.setVisibility(8);
            AppMethodBeat.m2505o(45590);
            return;
        }
        this.tja.setClickable(true);
        this.tja.setOnTouchListener(new C30132m(this));
        C35503o c35503o = new C35503o(new C354159());
        String string = getString(C25738R.string.fjb);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append(this.tjf.title);
        spannableStringBuilder.setSpan(c35503o, string.length(), spannableStringBuilder.length(), 18);
        this.tja.setText(spannableStringBuilder);
        this.tjb.setVisibility(0);
        AppMethodBeat.m2505o(45590);
    }

    private Bankcard acm(String str) {
        AppMethodBeat.m2504i(45591);
        for (Bankcard bankcard : this.tjd) {
            if (bankcard.field_bindSerial.equals(str)) {
                AppMethodBeat.m2505o(45591);
                return bankcard;
            }
        }
        Bankcard bankcard2 = C14241r.cPI().mo38170h(str, false, false);
        AppMethodBeat.m2505o(45591);
        return bankcard2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45581);
        this.yll = true;
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fjk);
        mo17446xE(getResources().getColor(C25738R.color.a69));
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
                C4990ab.printErrStackTrace("MicroMsg.WalletLqtPlanAddUI", e, "", new Object[0]);
            }
        }
        this.tjo = new String[28];
        for (int i = 0; i < 28; i++) {
            this.tjo[i] = getString(C25738R.string.fj3, new Object[]{String.valueOf(i + 1)});
        }
        initView();
        m58103cu();
        m58114mN(true);
        AppMethodBeat.m2505o(45581);
    }

    /* renamed from: a */
    static /* synthetic */ void m58098a(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45592);
        double d = C5046bo.getDouble(walletLqtPlanAddUI.tiR.getText(), 0.0d);
        Bankcard acm = walletLqtPlanAddUI.acm(walletLqtPlanAddUI.tjh.vEQ);
        C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "mode: %s, money: %s, bankcard: %s, day: %s", Integer.valueOf(walletLqtPlanAddUI.mMode), Double.valueOf(d), walletLqtPlanAddUI.tjh.pbn, Integer.valueOf(walletLqtPlanAddUI.tjh.ehf));
        if (acm == null || walletLqtPlanAddUI.tjh.ehf <= 0 || d <= 0.0d || d > acm.field_onceQuotaKind || (walletLqtPlanAddUI.tjb.getVisibility() == 0 && !walletLqtPlanAddUI.tiZ.isChecked())) {
            walletLqtPlanAddUI.tiY.setEnabled(false);
            AppMethodBeat.m2505o(45592);
        } else if (walletLqtPlanAddUI.mMode == 2 && C36391e.m60001c(String.valueOf(d), "100", RoundingMode.HALF_UP) == ((double) walletLqtPlanAddUI.tjk) && walletLqtPlanAddUI.tjh.ehf == walletLqtPlanAddUI.tjl && walletLqtPlanAddUI.tjh.vEQ.equals(walletLqtPlanAddUI.tjm)) {
            C4990ab.m7416i("MicroMsg.WalletLqtPlanAddUI", "no changed old");
            walletLqtPlanAddUI.tiY.setEnabled(false);
            AppMethodBeat.m2505o(45592);
        } else {
            walletLqtPlanAddUI.tiY.setEnabled(true);
            AppMethodBeat.m2505o(45592);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m58104d(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45594);
        C4990ab.m7416i("MicroMsg.WalletLqtPlanAddUI", "show bankcard menu");
        walletLqtPlanAddUI.aoB();
        C40127h.m68793a(walletLqtPlanAddUI, walletLqtPlanAddUI.tjd, walletLqtPlanAddUI.acm(walletLqtPlanAddUI.tjh.vEQ), walletLqtPlanAddUI.getString(C25738R.string.fiv), "", !walletLqtPlanAddUI.tjg, walletLqtPlanAddUI.getString(C25738R.string.fix), new C295756());
        AppMethodBeat.m2505o(45594);
    }

    /* renamed from: e */
    static /* synthetic */ void m58105e(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45595);
        C4990ab.m7416i("MicroMsg.WalletLqtPlanAddUI", "show date picker");
        walletLqtPlanAddUI.aoB();
        final C40908b c40908b = new C40908b((Context) walletLqtPlanAddUI, walletLqtPlanAddUI.tjo);
        if (walletLqtPlanAddUI.tjh.ehf - 1 >= 0) {
            c40908b.mo64522Qq(walletLqtPlanAddUI.tjh.ehf - 1);
        }
        c40908b.zSq = new C40907a() {
            /* renamed from: d */
            public final void mo7219d(boolean z, Object obj) {
                AppMethodBeat.m2504i(45564);
                c40908b.hide();
                if (z) {
                    WalletLqtPlanAddUI.this.tjh.ehf = c40908b.dLl() + 1;
                    WalletLqtPlanAddUI.m58113m(WalletLqtPlanAddUI.this);
                    WalletLqtPlanAddUI.m58098a(WalletLqtPlanAddUI.this);
                }
                AppMethodBeat.m2505o(45564);
            }
        };
        c40908b.mo64521Qp(C5229aj.fromDPToPix(walletLqtPlanAddUI, C31128d.MIC_PTU_YOUJIALI));
        c40908b.show();
        AppMethodBeat.m2505o(45595);
    }

    /* renamed from: f */
    static /* synthetic */ void m58106f(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45596);
        double d = C5046bo.getDouble(walletLqtPlanAddUI.tiR.getText(), 0.0d);
        C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "money: %s", Double.valueOf(d));
        Bankcard acm = walletLqtPlanAddUI.acm(walletLqtPlanAddUI.tjh.vEQ);
        if (acm != null && d > acm.field_dayQuotaKind) {
            C4990ab.m7416i("MicroMsg.WalletLqtPlanAddUI", "show over alert");
            walletLqtPlanAddUI.tiS.setText(walletLqtPlanAddUI.tjn);
            walletLqtPlanAddUI.tiS.setTextColor(walletLqtPlanAddUI.getResources().getColor(C25738R.color.f12267y0));
            walletLqtPlanAddUI.tji.setVisibility(8);
            walletLqtPlanAddUI.tjj.setVisibility(0);
            AppMethodBeat.m2505o(45596);
        } else if (d <= 0.0d || walletLqtPlanAddUI.tje == null || C5046bo.getDouble(walletLqtPlanAddUI.tje.wyH, 0.0d) <= 0.0d) {
            walletLqtPlanAddUI.tjj.setVisibility(4);
            AppMethodBeat.m2505o(45596);
        } else {
            String bigDecimal = C36391e.m59997b(walletLqtPlanAddUI.tiR.getText(), C36391e.m59981a(walletLqtPlanAddUI.tje.wyH, "10000", 2, RoundingMode.HALF_UP).toString(), 2, RoundingMode.HALF_UP).toString();
            C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "income: %s", bigDecimal);
            walletLqtPlanAddUI.tiS.setText(walletLqtPlanAddUI.getString(C25738R.string.fj6, new Object[]{walletLqtPlanAddUI.tje.title, bigDecimal}));
            walletLqtPlanAddUI.tiS.setTextColor(walletLqtPlanAddUI.getResources().getColor(C25738R.color.f12208w0));
            walletLqtPlanAddUI.tji.setVisibility(0);
            walletLqtPlanAddUI.tjj.setVisibility(0);
            AppMethodBeat.m2505o(45596);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m58100a(WalletLqtPlanAddUI walletLqtPlanAddUI, bla bla, boolean z) {
        Bankcard acm;
        AppMethodBeat.m2504i(45597);
        walletLqtPlanAddUI.tje = bla.wNW;
        walletLqtPlanAddUI.tjf = bla.wNX;
        walletLqtPlanAddUI.tjg = bla.wCP;
        walletLqtPlanAddUI.tjn = bla.wNY;
        if (!(bla.wmz == null || bla.wmz.isEmpty())) {
            C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "array size: %s", bla.wmz);
            walletLqtPlanAddUI.tjd.clear();
            for (Bankcard acm2 : C29630d.m46996dQ(bla.wmz)) {
                if (acm2.field_support_lqt_turn_in == 1) {
                    walletLqtPlanAddUI.tjd.add(acm2);
                } else {
                    C4990ab.m7417i("MicroMsg.WalletLqtPlanAddUI", "not support: %s", acm2.field_bankcardTypeName);
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
        walletLqtPlanAddUI.m58103cu();
        walletLqtPlanAddUI.tiQ.postDelayed(new C2251117(), 100);
        AppMethodBeat.m2505o(45597);
    }

    /* renamed from: l */
    static /* synthetic */ void m58112l(WalletLqtPlanAddUI walletLqtPlanAddUI) {
        AppMethodBeat.m2504i(45599);
        C4990ab.m7416i("MicroMsg.WalletLqtPlanAddUI", "go to bindcard");
        Bundle bundle = new Bundle();
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putBoolean("key_is_bind_bankcard", true);
        C24143a.m37106a((Activity) walletLqtPlanAddUI, C4350c.class, bundle, new C1414510());
        AppMethodBeat.m2505o(45599);
    }
}
