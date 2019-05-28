package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.model.C13050r;
import com.tencent.p177mm.plugin.remittance.model.C13051y;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect */
public class RemittanceOSRedirect extends WalletBaseUI {
    public String edV = "";
    private int gOW;

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect$2 */
    class C348222 implements OnClickListener {
        C348222() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45086);
            RemittanceOSRedirect.this.finish();
            AppMethodBeat.m2505o(45086);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceOSRedirect$3 */
    class C348233 implements OnClickListener {
        C348233() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45087);
            RemittanceOSRedirect.this.finish();
            AppMethodBeat.m2505o(45087);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45088);
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.edV = getIntent().getStringExtra("receiver_name");
        if (this.gOW == 0) {
            C4990ab.m7413e("MicroMsg.RemittanceOSRedirect", "error scene: %s", Integer.valueOf(this.gOW));
            finish();
            AppMethodBeat.m2505o(45088);
        } else if (this.gOW == 5) {
            this.Ahr.mo49372nf(1574);
            mo39970a(new C13051y(C1853r.m3825YG()), true, true);
            AppMethodBeat.m2505o(45088);
        } else {
            if (this.gOW == 6) {
                this.Ahr.mo49372nf(1301);
                mo39970a(new C13050r(this.edV), true, false);
            }
            AppMethodBeat.m2505o(45088);
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return true;
    }

    /* renamed from: b */
    public final void mo24300b(int i, int i2, String str, C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(45089);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C13051y) {
                C13051y c13051y = (C13051y) c1207m;
                C4990ab.m7417i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", c13051y.pQy);
                Intent intent = getIntent();
                if (c13051y.kCv == 1) {
                    C35899h.m58851a((Context) this, 2, this.edV, 11, null);
                } else {
                    intent.setClass(this, RemittanceOSUI.class);
                    intent.putExtra("os_currency", c13051y.kCv);
                    intent.putExtra("os_currencyuint", c13051y.pQy);
                    intent.putExtra("os_currencywording", c13051y.pQz);
                    intent.putExtra("os_notice", c13051y.kCx);
                    intent.putExtra("os_notice_url", c13051y.kCy);
                    startActivity(intent);
                }
                finish();
                AppMethodBeat.m2505o(45089);
                return;
            } else if (c1207m instanceof C13050r) {
                C13050r c13050r = (C13050r) c1207m;
                final Intent intent2 = new Intent();
                intent2.setClass(this, RemittanceHKUI.class);
                this.edV = c13050r.pPg;
                if (C5046bo.isNullOrNil(this.edV)) {
                    C4990ab.m7412e("MicroMsg.RemittanceOSRedirect", "empty username");
                    finish();
                }
                intent2.putExtra("scene", this.gOW);
                intent2.putExtra("fee", ((double) c13050r.cSh) / 100.0d);
                intent2.putExtra("desc", c13050r.desc);
                intent2.putExtra("scan_remittance_id", c13050r.pPi);
                intent2.putExtra("receiver_name", c13050r.pPg);
                intent2.putExtra("receiver_true_name", c13050r.kCz);
                intent2.putExtra("receiver_nick_name", c13050r.pPh);
                intent2.putExtra("hk_currency", c13050r.kCv);
                intent2.putExtra("hk_currencyuint", c13050r.kCw);
                intent2.putExtra("hk_notice", c13050r.kCx);
                intent2.putExtra("hk_notice_url", c13050r.kCy);
                int i3 = 32;
                C4990ab.m7417i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", Integer.valueOf(c13050r.kCA));
                if (c13050r.kCA == 1) {
                    i3 = 33;
                }
                intent2.putExtra("pay_scene", i3);
                C1720g.m3537RQ();
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(this.edV) != null) {
                    startActivity(intent2);
                    finish();
                    AppMethodBeat.m2505o(45089);
                    return;
                }
                C4990ab.m7410d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
                final long anU = C5046bo.anU();
                C26417a.flu.mo20966a(this.edV, "", new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(45085);
                        if (z) {
                            C4990ab.m7418v("MicroMsg.RemittanceOSRedirect", "getContact suc; cost=" + (C5046bo.anU() - anU) + " ms");
                            C41730b.m73489U(str, 3);
                            C17884o.acv().mo67495pZ(str);
                        } else {
                            C4990ab.m7420w("MicroMsg.RemittanceOSRedirect", "getContact failed");
                        }
                        RemittanceOSRedirect.this.startActivity(intent2);
                        RemittanceOSRedirect.this.finish();
                        AppMethodBeat.m2505o(45085);
                    }
                });
                AppMethodBeat.m2505o(45089);
                return;
            }
        } else if (c1207m instanceof C13051y) {
            C4990ab.m7417i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", str);
            C30379h.m48438a((Context) this, str, "", new C348222());
            AppMethodBeat.m2505o(45089);
            return;
        } else if (c1207m instanceof C13050r) {
            C30379h.m48438a((Context) this, str, "", new C348233());
        }
        AppMethodBeat.m2505o(45089);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45090);
        super.onDestroy();
        if (this.gOW == 5) {
            mo39993ng(1574);
            AppMethodBeat.m2505o(45090);
            return;
        }
        if (this.gOW == 6) {
            mo39993ng(1301);
        }
        AppMethodBeat.m2505o(45090);
    }

    public final int getLayoutId() {
        return -1;
    }
}
