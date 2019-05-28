package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceOSRedirect extends WalletBaseUI {
    public String edV = "";
    private int gOW;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45088);
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.edV = getIntent().getStringExtra("receiver_name");
        if (this.gOW == 0) {
            ab.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", Integer.valueOf(this.gOW));
            finish();
            AppMethodBeat.o(45088);
        } else if (this.gOW == 5) {
            this.Ahr.nf(1574);
            a(new y(r.YG()), true, true);
            AppMethodBeat.o(45088);
        } else {
            if (this.gOW == 6) {
                this.Ahr.nf(1301);
                a(new com.tencent.mm.plugin.remittance.model.r(this.edV), true, false);
            }
            AppMethodBeat.o(45088);
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return true;
    }

    public final void b(int i, int i2, String str, m mVar, boolean z) {
        AppMethodBeat.i(45089);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof y) {
                y yVar = (y) mVar;
                ab.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", yVar.pQy);
                Intent intent = getIntent();
                if (yVar.kCv == 1) {
                    h.a((Context) this, 2, this.edV, 11, null);
                } else {
                    intent.setClass(this, RemittanceOSUI.class);
                    intent.putExtra("os_currency", yVar.kCv);
                    intent.putExtra("os_currencyuint", yVar.pQy);
                    intent.putExtra("os_currencywording", yVar.pQz);
                    intent.putExtra("os_notice", yVar.kCx);
                    intent.putExtra("os_notice_url", yVar.kCy);
                    startActivity(intent);
                }
                finish();
                AppMethodBeat.o(45089);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.remittance.model.r) {
                com.tencent.mm.plugin.remittance.model.r rVar = (com.tencent.mm.plugin.remittance.model.r) mVar;
                final Intent intent2 = new Intent();
                intent2.setClass(this, RemittanceHKUI.class);
                this.edV = rVar.pPg;
                if (bo.isNullOrNil(this.edV)) {
                    ab.e("MicroMsg.RemittanceOSRedirect", "empty username");
                    finish();
                }
                intent2.putExtra("scene", this.gOW);
                intent2.putExtra("fee", ((double) rVar.cSh) / 100.0d);
                intent2.putExtra("desc", rVar.desc);
                intent2.putExtra("scan_remittance_id", rVar.pPi);
                intent2.putExtra("receiver_name", rVar.pPg);
                intent2.putExtra("receiver_true_name", rVar.kCz);
                intent2.putExtra("receiver_nick_name", rVar.pPh);
                intent2.putExtra("hk_currency", rVar.kCv);
                intent2.putExtra("hk_currencyuint", rVar.kCw);
                intent2.putExtra("hk_notice", rVar.kCx);
                intent2.putExtra("hk_notice_url", rVar.kCy);
                int i3 = 32;
                ab.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", Integer.valueOf(rVar.kCA));
                if (rVar.kCA == 1) {
                    i3 = 33;
                }
                intent2.putExtra("pay_scene", i3);
                g.RQ();
                if (((j) g.K(j.class)).XM().aoN(this.edV) != null) {
                    startActivity(intent2);
                    finish();
                    AppMethodBeat.o(45089);
                    return;
                }
                ab.d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
                final long anU = bo.anU();
                ao.a.flu.a(this.edV, "", new b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(45085);
                        if (z) {
                            ab.v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (bo.anU() - anU) + " ms");
                            com.tencent.mm.ah.b.U(str, 3);
                            o.acv().pZ(str);
                        } else {
                            ab.w("MicroMsg.RemittanceOSRedirect", "getContact failed");
                        }
                        RemittanceOSRedirect.this.startActivity(intent2);
                        RemittanceOSRedirect.this.finish();
                        AppMethodBeat.o(45085);
                    }
                });
                AppMethodBeat.o(45089);
                return;
            }
        } else if (mVar instanceof y) {
            ab.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", str);
            com.tencent.mm.ui.base.h.a((Context) this, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45086);
                    RemittanceOSRedirect.this.finish();
                    AppMethodBeat.o(45086);
                }
            });
            AppMethodBeat.o(45089);
            return;
        } else if (mVar instanceof com.tencent.mm.plugin.remittance.model.r) {
            com.tencent.mm.ui.base.h.a((Context) this, str, "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(45087);
                    RemittanceOSRedirect.this.finish();
                    AppMethodBeat.o(45087);
                }
            });
        }
        AppMethodBeat.o(45089);
    }

    public void onDestroy() {
        AppMethodBeat.i(45090);
        super.onDestroy();
        if (this.gOW == 5) {
            ng(1574);
            AppMethodBeat.o(45090);
            return;
        }
        if (this.gOW == 6) {
            ng(1301);
        }
        AppMethodBeat.o(45090);
    }

    public final int getLayoutId() {
        return -1;
    }
}
