package com.tencent.p177mm.plugin.wxcredit.p590ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardSelectUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;

/* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI */
public class WalletBindDepositUI extends WalletBaseUI {
    private Button gEZ;
    private boolean nfA = true;
    private WalletFormView tEp;
    private WalletFormView tFS;
    private ElementQuery tvu = new ElementQuery();
    private WalletFormView uYT;

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI$2 */
    class C148192 implements OnClickListener {
        C148192() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48673);
            if (WalletBindDepositUI.m87681e(WalletBindDepositUI.this)) {
                WalletBindDepositUI.this.dOE().mo9366p(WalletBindDepositUI.this.tEp.getText(), WalletBindDepositUI.this.tvu.pbn, WalletBindDepositUI.this.uYT.getText(), WalletBindDepositUI.this.tvu.tyH, Boolean.FALSE);
            }
            AppMethodBeat.m2505o(48673);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI$1 */
    class C357701 implements OnClickListener {
        C357701() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48672);
            if (C5046bo.isNullOrNil(WalletBindDepositUI.this.tEp.getText())) {
                AppMethodBeat.m2505o(48672);
            } else if (WalletBindDepositUI.this.nfA) {
                WalletBindDepositUI.this.dOE().mo38265x(r0);
                WalletBindDepositUI.this.nfA = false;
                AppMethodBeat.m2505o(48672);
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", 1);
                bundle.putString("key_bank_type", WalletBindDepositUI.this.tvu.pbn);
                bundle.putInt("key_bankcard_type", 1);
                C24143a.m37112aE(WalletBindDepositUI.this).mo64562a(WalletBindDepositUI.this, WalletCardSelectUI.class, bundle, 1);
                AppMethodBeat.m2505o(48672);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBindDepositUI() {
        AppMethodBeat.m2504i(48674);
        AppMethodBeat.m2505o(48674);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48675);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(48675);
    }

    public final int getLayoutId() {
        return 2130971038;
    }

    public final void initView() {
        AppMethodBeat.m2504i(48676);
        setMMTitle((int) C25738R.string.f_v);
        this.tEp = (WalletFormView) findViewById(2131828578);
        C30890a.m49294b(this.tEp);
        this.tFS = (WalletFormView) findViewById(2131823369);
        this.uYT = (WalletFormView) findViewById(2131828579);
        C30890a.m49295c(this, this.uYT);
        this.gEZ = (Button) findViewById(2131822846);
        mo39989e(this.tEp, 0, false);
        mo39989e(this.uYT, 0, false);
        this.tFS.setOnClickListener(new C357701());
        this.gEZ.setOnClickListener(new C148192());
        AppMethodBeat.m2505o(48676);
    }

    /* renamed from: cu */
    private void m87679cu() {
        AppMethodBeat.m2504i(48677);
        if (C5046bo.isNullOrNil(this.tvu.nuL)) {
            this.tFS.setText("");
            AppMethodBeat.m2505o(48677);
        } else if (2 == this.tvu.tyE) {
            this.tFS.setText(this.tvu.nuL + " " + getString(C25738R.string.fdu));
            AppMethodBeat.m2505o(48677);
        } else {
            this.tFS.setText(this.tvu.nuL + " " + getString(C25738R.string.fed));
            AppMethodBeat.m2505o(48677);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48678);
        C4990ab.m7416i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(48678);
            return;
        }
        switch (i) {
            case 1:
                ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                if (!elementQuery.cPr()) {
                    C30379h.m48467g(this, C25738R.string.f_t, C25738R.string.f9238tz);
                    break;
                }
                this.tvu = elementQuery;
                m87679cu();
                AppMethodBeat.m2505o(48678);
                return;
        }
        AppMethodBeat.m2505o(48678);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(48679);
        if (i == 0 && i2 == 0 && (c1207m instanceof C14225t)) {
            C14225t c14225t = (C14225t) c1207m;
            if (c14225t.tun != null) {
                if (c14225t.tun.cPr()) {
                    this.tvu = c14225t.tun;
                    m87679cu();
                    if (this.tvu.tyC && this.tvu.isError()) {
                        C30379h.m48467g(this, C25738R.string.f_1, C25738R.string.f9238tz);
                        AppMethodBeat.m2505o(48679);
                        return true;
                    }
                    C40931c aE = C24143a.m37112aE(this);
                    if (aE != null) {
                        int i3 = this.tvu.tuo;
                        if (aE != null) {
                            if (aE.mqu.containsKey("key_support_bankcard")) {
                                int dNE = aE.dNE();
                                if (dNE == 0) {
                                    z = true;
                                } else {
                                    z = Bankcard.m78503gh(dNE, i3);
                                }
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            if (aE.cRY()) {
                                C4990ab.m7420w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                C30379h.m48467g(this, C25738R.string.f89, C25738R.string.f9238tz);
                            } else {
                                C4990ab.m7420w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                C30379h.m48467g(this, C25738R.string.f88, C25738R.string.f9238tz);
                            }
                            this.tEp.cey();
                            AppMethodBeat.m2505o(48679);
                            return true;
                        }
                    }
                    m87679cu();
                    AppMethodBeat.m2505o(48679);
                    return true;
                }
                C30379h.m48467g(this, C25738R.string.f_t, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(48679);
                return true;
            }
        }
        AppMethodBeat.m2505o(48679);
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: e */
    static /* synthetic */ boolean m87681e(WalletBindDepositUI walletBindDepositUI) {
        AppMethodBeat.m2504i(48680);
        if (!walletBindDepositUI.tEp.asa()) {
            C23639t.makeText(walletBindDepositUI, C25738R.string.fb9, 0).show();
            AppMethodBeat.m2505o(48680);
            return false;
        } else if (!walletBindDepositUI.tFS.asa()) {
            C23639t.makeText(walletBindDepositUI, C25738R.string.fai, 0).show();
            AppMethodBeat.m2505o(48680);
            return false;
        } else if (walletBindDepositUI.uYT.asa()) {
            AppMethodBeat.m2505o(48680);
            return true;
        } else {
            C23639t.makeText(walletBindDepositUI, C25738R.string.fbs, 0).show();
            AppMethodBeat.m2505o(48680);
            return false;
        }
    }
}
