package com.tencent.p177mm.plugin.wallet.bind.p553ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.appbrand.weishi.C2509f;
import com.tencent.p177mm.plugin.wallet.bind.p1311a.C22519a;
import com.tencent.p177mm.plugin.wallet.bind.p1311a.C29586b;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI */
public class WalletBankcardDetailUI extends WalletBaseUI {
    protected Bankcard thJ;
    protected TextView tlE;
    private TextView tlF;
    private View tlG;
    protected LinearLayout tlH;
    protected LinearLayout tlI;
    protected LinearLayout tlJ;

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$4 */
    class C141554 implements OnClickListener {
        C141554() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45743);
            C24143a.m37116j(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.mBundle);
            AppMethodBeat.m2505o(45743);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$6 */
    class C225216 implements DialogInterface.OnClickListener {
        C225216() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45746);
            ((C40167b) C1720g.m3528K(C40167b.class)).mo38295h(WalletBankcardDetailUI.this, 1);
            C36391e.m59978QS(1);
            AppMethodBeat.m2505o(45746);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$2 */
    class C295872 implements OnClickListener {
        C295872() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45741);
            WalletBankcardDetailUI.this.showDialog(0);
            AppMethodBeat.m2505o(45741);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$3 */
    class C295883 implements OnClickListener {
        C295883() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45742);
            WalletBankcardDetailUI.this.showDialog(0);
            AppMethodBeat.m2505o(45742);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$5 */
    class C295895 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$5$1 */
        class C295901 implements C30391c {
            C295901() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(45744);
                switch (i) {
                    case 0:
                        WalletBankcardDetailUI.m87101a(WalletBankcardDetailUI.this);
                        break;
                }
                AppMethodBeat.m2505o(45744);
            }
        }

        C295895() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45745);
            C46332s.cNC();
            ArrayList cQB = C46332s.cND().cQB();
            if (cQB != null && cQB.size() > 1) {
                C46332s.cNC();
                C46332s.cND();
            }
            ArrayList arrayList = new ArrayList();
            C30379h.m48424a(WalletBankcardDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletBankcardDetailUI.this.getString(C25738R.string.fgf), false, new C295901());
            AppMethodBeat.m2505o(45745);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$1 */
    class C400661 implements OnClickListener {
        C400661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45740);
            C36391e.m60016n(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.thJ.field_repay_url, false);
            AppMethodBeat.m2505o(45740);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$8 */
    class C437638 implements C30391c {
        C437638() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(45748);
            switch (i) {
                case 0:
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletBankcardDetailUI.this.getString(C25738R.string.f_4)).toString()));
                    intent.addFlags(268435456);
                    WalletBankcardDetailUI.this.startActivity(intent);
                    break;
            }
            AppMethodBeat.m2505o(45748);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI$7 */
    class C463457 implements DialogInterface.OnClickListener {
        C463457() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45747);
            WalletBankcardDetailUI.m87102b(WalletBankcardDetailUI.this);
            C36391e.m59978QS(2);
            AppMethodBeat.m2505o(45747);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: b */
    static /* synthetic */ void m87102b(WalletBankcardDetailUI walletBankcardDetailUI) {
        AppMethodBeat.m2504i(45761);
        walletBankcardDetailUI.m87103mU(true);
        AppMethodBeat.m2505o(45761);
    }

    public final int getLayoutId() {
        return 2130971061;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45750);
        super.onCreate(bundle);
        mo39992nf(C2509f.CTRL_INDEX);
        setMMTitle((int) C25738R.string.f_h);
        initView();
        AppMethodBeat.m2505o(45750);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45751);
        super.onResume();
        AppMethodBeat.m2505o(45751);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45752);
        mo39993ng(C2509f.CTRL_INDEX);
        super.onDestroy();
        AppMethodBeat.m2505o(45752);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: mT */
    public final void mo74559mT(boolean z) {
        AppMethodBeat.m2504i(45754);
        if (z) {
            this.tlH.setVisibility(8);
            this.tlI.setVisibility(0);
            ((TextView) findViewById(2131828671)).setOnClickListener(new C295872());
            TextView textView = (TextView) findViewById(2131828666);
            TextView textView2 = (TextView) findViewById(2131828667);
            TextView textView3 = (TextView) findViewById(2131828668);
            ((TextView) findViewById(2131828665)).setText(C36391e.m60006e(this.thJ.field_onceQuotaKind, null));
            textView.setText(C36391e.m60006e(this.thJ.field_onceQuotaVirtual, null));
            textView2.setText(C36391e.m60006e(this.thJ.field_dayQuotaKind, null));
            textView3.setText(C36391e.m60006e(this.thJ.field_dayQuotaVirtual, null));
            if (!C5046bo.isNullOrNil(this.thJ.field_repay_url)) {
                this.tlF.setVisibility(0);
                this.tlG.setVisibility(0);
            }
            AppMethodBeat.m2505o(45754);
            return;
        }
        this.tlH.setVisibility(8);
        this.tlI.setVisibility(8);
        this.tlJ.setVisibility(0);
        AppMethodBeat.m2505o(45754);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cNs() {
        AppMethodBeat.m2504i(45755);
        this.tlH.setVisibility(0);
        this.tlI.setVisibility(8);
        ((TextView) findViewById(2131828675)).setOnClickListener(new C295883());
        ((TextView) findViewById(2131828673)).setOnClickListener(new C141554());
        AppMethodBeat.m2505o(45755);
    }

    private void ceo() {
        AppMethodBeat.m2504i(45756);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C295895());
        AppMethodBeat.m2505o(45756);
    }

    /* renamed from: mU */
    private void m87103mU(boolean z) {
        AppMethodBeat.m2504i(45757);
        if (C1853r.m3831YM() || z || ((C40167b) C1720g.m3528K(C40167b.class)).cTj()) {
            this.mBundle.putBoolean("offline_pay", false);
            C24143a.m37116j(this, this.mBundle);
            AppMethodBeat.m2505o(45757);
            return;
        }
        C36391e.m59978QS(0);
        C30379h.m48429a((Context) this, (int) C25738R.string.f_j, -1, (int) C25738R.string.f_i, (int) C25738R.string.f_k, true, new C225216(), new C463457());
        AppMethodBeat.m2505o(45757);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45759);
        if (i == 0 && i2 == 0) {
            if (!(c1207m instanceof C29586b)) {
                if (c1207m instanceof C22519a) {
                    C22519a c22519a = (C22519a) c1207m;
                    C4990ab.m7412e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + c22519a.tle);
                    switch (c22519a.tle) {
                        case 2:
                        case 3:
                            final int i3 = c22519a.tle;
                            C30379h.m48448a((Context) this, c22519a.tlf, null, false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(45749);
                                    if (i3 == 2) {
                                        WalletBankcardDetailUI.m87102b(WalletBankcardDetailUI.this);
                                    }
                                    dialogInterface.dismiss();
                                    AppMethodBeat.m2505o(45749);
                                }
                            });
                            break;
                        default:
                            m87103mU(false);
                            break;
                    }
                }
            } else if (this.tlE != null) {
                this.tlE.setVisibility(0);
            }
        } else if (c1207m instanceof C22519a) {
            C4990ab.m7412e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            m87103mU(false);
            AppMethodBeat.m2505o(45759);
            return true;
        }
        AppMethodBeat.m2505o(45759);
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(45753);
        this.thJ = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (this.thJ == null) {
            AppMethodBeat.m2505o(45753);
            return;
        }
        this.tlH = (LinearLayout) findViewById(2131828672);
        this.tlI = (LinearLayout) findViewById(2131828663);
        this.tlJ = (LinearLayout) findViewById(2131828676);
        this.tlF = (TextView) findViewById(2131828669);
        this.tlG = findViewById(2131828670);
        this.tlG.setOnClickListener(new C400661());
        if (1 == this.thJ.field_bankcardState) {
            cNs();
            AppMethodBeat.m2505o(45753);
            return;
        }
        if (this.thJ.cPf()) {
            mo74559mT(true);
            this.tlE = (TextView) findViewById(2131828664);
            C46332s.cNC();
            C46332s.cND();
            this.tlE.setVisibility(8);
        } else {
            mo74559mT(false);
            this.tlE = (TextView) findViewById(2131828677);
            C46332s.cNC();
            C46332s.cND();
            this.tlE.setVisibility(8);
        }
        ceo();
        AppMethodBeat.m2505o(45753);
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(45758);
        Dialog a = C30379h.m48422a(this.mController.ylL, getString(C25738R.string.f_5), getResources().getStringArray(C25738R.array.f12640au), "", new C437638());
        AppMethodBeat.m2505o(45758);
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ void m87101a(WalletBankcardDetailUI walletBankcardDetailUI) {
        AppMethodBeat.m2504i(45760);
        walletBankcardDetailUI.mo39970a(new C22519a(walletBankcardDetailUI.thJ.field_bankcardType, walletBankcardDetailUI.thJ.field_bindSerial), true, false);
        AppMethodBeat.m2505o(45760);
    }
}
