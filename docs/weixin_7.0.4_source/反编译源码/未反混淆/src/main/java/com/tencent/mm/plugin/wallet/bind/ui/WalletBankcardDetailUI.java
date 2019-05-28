package com.tencent.mm.plugin.wallet.bind.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.weishi.f;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public class WalletBankcardDetailUI extends WalletBaseUI {
    protected Bankcard thJ;
    protected TextView tlE;
    private TextView tlF;
    private View tlG;
    protected LinearLayout tlH;
    protected LinearLayout tlI;
    protected LinearLayout tlJ;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(WalletBankcardDetailUI walletBankcardDetailUI) {
        AppMethodBeat.i(45761);
        walletBankcardDetailUI.mU(true);
        AppMethodBeat.o(45761);
    }

    public final int getLayoutId() {
        return R.layout.b39;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45750);
        super.onCreate(bundle);
        nf(f.CTRL_INDEX);
        setMMTitle((int) R.string.f_h);
        initView();
        AppMethodBeat.o(45750);
    }

    public void onResume() {
        AppMethodBeat.i(45751);
        super.onResume();
        AppMethodBeat.o(45751);
    }

    public void onDestroy() {
        AppMethodBeat.i(45752);
        ng(f.CTRL_INDEX);
        super.onDestroy();
        AppMethodBeat.o(45752);
    }

    /* Access modifiers changed, original: protected|final */
    public final void mT(boolean z) {
        AppMethodBeat.i(45754);
        if (z) {
            this.tlH.setVisibility(8);
            this.tlI.setVisibility(0);
            ((TextView) findViewById(R.id.f7o)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45741);
                    WalletBankcardDetailUI.this.showDialog(0);
                    AppMethodBeat.o(45741);
                }
            });
            TextView textView = (TextView) findViewById(R.id.f7j);
            TextView textView2 = (TextView) findViewById(R.id.f7k);
            TextView textView3 = (TextView) findViewById(R.id.f7l);
            ((TextView) findViewById(R.id.f7i)).setText(e.e(this.thJ.field_onceQuotaKind, null));
            textView.setText(e.e(this.thJ.field_onceQuotaVirtual, null));
            textView2.setText(e.e(this.thJ.field_dayQuotaKind, null));
            textView3.setText(e.e(this.thJ.field_dayQuotaVirtual, null));
            if (!bo.isNullOrNil(this.thJ.field_repay_url)) {
                this.tlF.setVisibility(0);
                this.tlG.setVisibility(0);
            }
            AppMethodBeat.o(45754);
            return;
        }
        this.tlH.setVisibility(8);
        this.tlI.setVisibility(8);
        this.tlJ.setVisibility(0);
        AppMethodBeat.o(45754);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cNs() {
        AppMethodBeat.i(45755);
        this.tlH.setVisibility(0);
        this.tlI.setVisibility(8);
        ((TextView) findViewById(R.id.f7s)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45742);
                WalletBankcardDetailUI.this.showDialog(0);
                AppMethodBeat.o(45742);
            }
        });
        ((TextView) findViewById(R.id.f7q)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45743);
                a.j(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.mBundle);
                AppMethodBeat.o(45743);
            }
        });
        AppMethodBeat.o(45755);
    }

    private void ceo() {
        AppMethodBeat.i(45756);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45745);
                s.cNC();
                ArrayList cQB = s.cND().cQB();
                if (cQB != null && cQB.size() > 1) {
                    s.cNC();
                    s.cND();
                }
                ArrayList arrayList = new ArrayList();
                h.a(WalletBankcardDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletBankcardDetailUI.this.getString(R.string.fgf), false, new c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(45744);
                        switch (i) {
                            case 0:
                                WalletBankcardDetailUI.a(WalletBankcardDetailUI.this);
                                break;
                        }
                        AppMethodBeat.o(45744);
                    }
                });
                AppMethodBeat.o(45745);
                return true;
            }
        });
        AppMethodBeat.o(45756);
    }

    private void mU(boolean z) {
        AppMethodBeat.i(45757);
        if (r.YM() || z || ((b) g.K(b.class)).cTj()) {
            this.mBundle.putBoolean("offline_pay", false);
            a.j(this, this.mBundle);
            AppMethodBeat.o(45757);
            return;
        }
        e.QS(0);
        h.a((Context) this, (int) R.string.f_j, -1, (int) R.string.f_i, (int) R.string.f_k, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45746);
                ((b) g.K(b.class)).h(WalletBankcardDetailUI.this, 1);
                e.QS(1);
                AppMethodBeat.o(45746);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(45747);
                WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
                e.QS(2);
                AppMethodBeat.o(45747);
            }
        });
        AppMethodBeat.o(45757);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45759);
        if (i == 0 && i2 == 0) {
            if (!(mVar instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
                if (mVar instanceof com.tencent.mm.plugin.wallet.bind.a.a) {
                    com.tencent.mm.plugin.wallet.bind.a.a aVar = (com.tencent.mm.plugin.wallet.bind.a.a) mVar;
                    ab.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + aVar.tle);
                    switch (aVar.tle) {
                        case 2:
                        case 3:
                            final int i3 = aVar.tle;
                            h.a((Context) this, aVar.tlf, null, false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(45749);
                                    if (i3 == 2) {
                                        WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
                                    }
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(45749);
                                }
                            });
                            break;
                        default:
                            mU(false);
                            break;
                    }
                }
            } else if (this.tlE != null) {
                this.tlE.setVisibility(0);
            }
        } else if (mVar instanceof com.tencent.mm.plugin.wallet.bind.a.a) {
            ab.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
            mU(false);
            AppMethodBeat.o(45759);
            return true;
        }
        AppMethodBeat.o(45759);
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(45753);
        this.thJ = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (this.thJ == null) {
            AppMethodBeat.o(45753);
            return;
        }
        this.tlH = (LinearLayout) findViewById(R.id.f7p);
        this.tlI = (LinearLayout) findViewById(R.id.f7g);
        this.tlJ = (LinearLayout) findViewById(R.id.f7t);
        this.tlF = (TextView) findViewById(R.id.f7m);
        this.tlG = findViewById(R.id.f7n);
        this.tlG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45740);
                e.n(WalletBankcardDetailUI.this, WalletBankcardDetailUI.this.thJ.field_repay_url, false);
                AppMethodBeat.o(45740);
            }
        });
        if (1 == this.thJ.field_bankcardState) {
            cNs();
            AppMethodBeat.o(45753);
            return;
        }
        if (this.thJ.cPf()) {
            mT(true);
            this.tlE = (TextView) findViewById(R.id.f7h);
            s.cNC();
            s.cND();
            this.tlE.setVisibility(8);
        } else {
            mT(false);
            this.tlE = (TextView) findViewById(R.id.f7u);
            s.cNC();
            s.cND();
            this.tlE.setVisibility(8);
        }
        ceo();
        AppMethodBeat.o(45753);
    }

    @Deprecated
    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(45758);
        Dialog a = h.a(this.mController.ylL, getString(R.string.f_5), getResources().getStringArray(R.array.au), "", new c() {
            public final void iE(int i) {
                AppMethodBeat.i(45748);
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletBankcardDetailUI.this.getString(R.string.f_4)).toString()));
                        intent.addFlags(268435456);
                        WalletBankcardDetailUI.this.startActivity(intent);
                        break;
                }
                AppMethodBeat.o(45748);
            }
        });
        AppMethodBeat.o(45758);
        return a;
    }

    static /* synthetic */ void a(WalletBankcardDetailUI walletBankcardDetailUI) {
        AppMethodBeat.i(45760);
        walletBankcardDetailUI.a(new com.tencent.mm.plugin.wallet.bind.a.a(walletBankcardDetailUI.thJ.field_bankcardType, walletBankcardDetailUI.thJ.field_bindSerial), true, false);
        AppMethodBeat.o(45760);
    }
}
