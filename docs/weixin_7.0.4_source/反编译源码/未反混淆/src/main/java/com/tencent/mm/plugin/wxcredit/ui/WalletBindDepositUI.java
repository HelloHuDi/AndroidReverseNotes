package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletBindDepositUI extends WalletBaseUI {
    private Button gEZ;
    private boolean nfA = true;
    private WalletFormView tEp;
    private WalletFormView tFS;
    private ElementQuery tvu = new ElementQuery();
    private WalletFormView uYT;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBindDepositUI() {
        AppMethodBeat.i(48674);
        AppMethodBeat.o(48674);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48675);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(48675);
    }

    public final int getLayoutId() {
        return R.layout.b2m;
    }

    public final void initView() {
        AppMethodBeat.i(48676);
        setMMTitle((int) R.string.f_v);
        this.tEp = (WalletFormView) findViewById(R.id.f56);
        a.b(this.tEp);
        this.tFS = (WalletFormView) findViewById(R.id.bbc);
        this.uYT = (WalletFormView) findViewById(R.id.f57);
        a.c(this, this.uYT);
        this.gEZ = (Button) findViewById(R.id.ay8);
        e(this.tEp, 0, false);
        e(this.uYT, 0, false);
        this.tFS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48672);
                if (bo.isNullOrNil(WalletBindDepositUI.this.tEp.getText())) {
                    AppMethodBeat.o(48672);
                } else if (WalletBindDepositUI.this.nfA) {
                    WalletBindDepositUI.this.dOE().x(r0);
                    WalletBindDepositUI.this.nfA = false;
                    AppMethodBeat.o(48672);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_support_bankcard", 1);
                    bundle.putString("key_bank_type", WalletBindDepositUI.this.tvu.pbn);
                    bundle.putInt("key_bankcard_type", 1);
                    com.tencent.mm.wallet_core.a.aE(WalletBindDepositUI.this).a(WalletBindDepositUI.this, WalletCardSelectUI.class, bundle, 1);
                    AppMethodBeat.o(48672);
                }
            }
        });
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48673);
                if (WalletBindDepositUI.e(WalletBindDepositUI.this)) {
                    WalletBindDepositUI.this.dOE().p(WalletBindDepositUI.this.tEp.getText(), WalletBindDepositUI.this.tvu.pbn, WalletBindDepositUI.this.uYT.getText(), WalletBindDepositUI.this.tvu.tyH, Boolean.FALSE);
                }
                AppMethodBeat.o(48673);
            }
        });
        AppMethodBeat.o(48676);
    }

    private void cu() {
        AppMethodBeat.i(48677);
        if (bo.isNullOrNil(this.tvu.nuL)) {
            this.tFS.setText("");
            AppMethodBeat.o(48677);
        } else if (2 == this.tvu.tyE) {
            this.tFS.setText(this.tvu.nuL + " " + getString(R.string.fdu));
            AppMethodBeat.o(48677);
        } else {
            this.tFS.setText(this.tvu.nuL + " " + getString(R.string.fed));
            AppMethodBeat.o(48677);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48678);
        ab.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(48678);
            return;
        }
        switch (i) {
            case 1:
                ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                if (!elementQuery.cPr()) {
                    h.g(this, R.string.f_t, R.string.tz);
                    break;
                }
                this.tvu = elementQuery;
                cu();
                AppMethodBeat.o(48678);
                return;
        }
        AppMethodBeat.o(48678);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(48679);
        if (i == 0 && i2 == 0 && (mVar instanceof t)) {
            t tVar = (t) mVar;
            if (tVar.tun != null) {
                if (tVar.tun.cPr()) {
                    this.tvu = tVar.tun;
                    cu();
                    if (this.tvu.tyC && this.tvu.isError()) {
                        h.g(this, R.string.f_1, R.string.tz);
                        AppMethodBeat.o(48679);
                        return true;
                    }
                    c aE = com.tencent.mm.wallet_core.a.aE(this);
                    if (aE != null) {
                        int i3 = this.tvu.tuo;
                        if (aE != null) {
                            if (aE.mqu.containsKey("key_support_bankcard")) {
                                int dNE = aE.dNE();
                                if (dNE == 0) {
                                    z = true;
                                } else {
                                    z = Bankcard.gh(dNE, i3);
                                }
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            if (aE.cRY()) {
                                ab.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                h.g(this, R.string.f89, R.string.tz);
                            } else {
                                ab.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                h.g(this, R.string.f88, R.string.tz);
                            }
                            this.tEp.cey();
                            AppMethodBeat.o(48679);
                            return true;
                        }
                    }
                    cu();
                    AppMethodBeat.o(48679);
                    return true;
                }
                h.g(this, R.string.f_t, R.string.tz);
                AppMethodBeat.o(48679);
                return true;
            }
        }
        AppMethodBeat.o(48679);
        return false;
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ boolean e(WalletBindDepositUI walletBindDepositUI) {
        AppMethodBeat.i(48680);
        if (!walletBindDepositUI.tEp.asa()) {
            com.tencent.mm.ui.base.t.makeText(walletBindDepositUI, R.string.fb9, 0).show();
            AppMethodBeat.o(48680);
            return false;
        } else if (!walletBindDepositUI.tFS.asa()) {
            com.tencent.mm.ui.base.t.makeText(walletBindDepositUI, R.string.fai, 0).show();
            AppMethodBeat.o(48680);
            return false;
        } else if (walletBindDepositUI.uYT.asa()) {
            AppMethodBeat.o(48680);
            return true;
        } else {
            com.tencent.mm.ui.base.t.makeText(walletBindDepositUI, R.string.fbs, 0).show();
            AppMethodBeat.o(48680);
            return false;
        }
    }
}
