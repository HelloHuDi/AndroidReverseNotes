package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    public String edV = null;
    protected int gOW;
    protected int obL;
    protected boolean pQP = false;
    protected com.tencent.mm.plugin.wallet.a pQQ = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44819);
        super.onCreate(bundle);
        AM(8);
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.edV = getIntent().getStringExtra("receiver_name");
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        this.pQQ = com.tencent.mm.plugin.wallet.a.at(getIntent());
        if (this.obL == -1) {
            c dOD = dOD();
            if (dOD != null) {
                this.obL = dOD.mqu.getInt("pay_channel", -1);
            }
        }
        if (this.gOW == 1) {
            this.pQP = true;
            cfy();
            AppMethodBeat.o(44819);
        } else if (this.gOW == 3) {
            nf(580);
            if (getIntent() == null) {
                ab.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                AppMethodBeat.o(44819);
                return;
            }
            m aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
            aVar.eHT = "RemittanceProcess";
            a(aVar, true, false);
            AppMethodBeat.o(44819);
        } else if (this.gOW == 2) {
            if (bo.isNullOrNil(this.edV)) {
                ab.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.gOW);
                finish();
                AppMethodBeat.o(44819);
                return;
            }
            c(this.edV, 31, null);
            AppMethodBeat.o(44819);
        } else if (this.gOW != 5 && this.gOW != 6) {
            c(null, 31, null);
            AppMethodBeat.o(44819);
        } else if (bo.isNullOrNil(this.edV)) {
            ab.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.gOW);
            finish();
            AppMethodBeat.o(44819);
        } else {
            String str = this.edV;
            ab.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.gOW + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.pQQ, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.gOW);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.obL);
            startActivity(intent);
            setResult(-1);
            finish();
            AppMethodBeat.o(44819);
        }
    }

    /* Access modifiers changed, original: protected */
    public void cfy() {
        AppMethodBeat.i(44820);
        m wVar = new w(this.edV, this.obL);
        wVar.eHT = "RemittanceProcess";
        a(wVar, true, false);
        AppMethodBeat.o(44820);
    }

    public void onDestroy() {
        AppMethodBeat.i(44821);
        if (this.gOW == 3) {
            ng(580);
        }
        super.onDestroy();
        AppMethodBeat.o(44821);
    }

    public void onBackPressed() {
        AppMethodBeat.i(44822);
        if (this.pQP) {
            ab.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            AppMethodBeat.o(44822);
            return;
        }
        ab.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
        AppMethodBeat.o(44822);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44823);
        if (mVar instanceof w) {
            this.pQP = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            h.bQ(this, str);
            finish();
            AppMethodBeat.o(44823);
            return true;
        } else if (mVar instanceof w) {
            final w wVar = (w) mVar;
            String str2 = wVar.pPZ;
            this.edV = wVar.username;
            if (bo.isNullOrNil(this.edV) && bo.isNullOrNil(str2)) {
                ab.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.gOW);
                finish();
                AppMethodBeat.o(44823);
                return true;
            }
            if (this.gOW == 1) {
                if (wVar.scene == 33) {
                    this.pQQ = com.tencent.mm.plugin.wallet.a.dq(this.edV, 2);
                    this.pQQ.bs(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.pQQ = com.tencent.mm.plugin.wallet.a.dq(this.edV, 3);
                    this.pQQ.bs(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", wVar.kCJ);
            intent.putExtra("desc", wVar.desc);
            intent.putExtra("scan_remittance_id", wVar.pPQ);
            intent.putExtra("receiver_true_name", e.att(wVar.pPP));
            intent.putExtra("receiver_true_name_busi", wVar.pPw);
            intent.putExtra("receiver_tips", wVar.pPR);
            intent.putExtra("rcvr_new_desc", wVar.pPS);
            intent.putExtra("payer_desc", wVar.pPT);
            intent.putExtra("rcvr_open_id", wVar.pPZ);
            intent.putExtra("mch_name", wVar.pPW);
            intent.putExtra("mch_info", wVar.pQc);
            intent.putExtra("mch_photo", wVar.pPX);
            intent.putExtra("mch_type", wVar.pQa);
            intent.putExtra("mch_time", wVar.pPY);
            if (wVar.pPV == 1) {
                intent.putExtra("busi_type", wVar.pPV);
                intent.putExtra("rcvr_ticket", wVar.pPU);
                intent.putExtra("rcvr_open_id", wVar.pPZ);
                intent.putExtra("get_pay_wifi", wVar.pQb);
                if (wVar.pQd != null) {
                    intent.putExtra("BusiRemittanceResp", wVar.pQd);
                }
            }
            g.RQ();
            ad aoN = ((j) g.K(j.class)).XM().aoN(this.edV);
            b.U(this.edV, 3);
            if (aoN != null || this.edV.equals("")) {
                c(this.edV, wVar.scene, intent);
            } else {
                ab.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long anU = bo.anU();
                ao.a.flu.a(this.edV, "", new ao.b.a() {
                    public final void o(String str, boolean z) {
                        AppMethodBeat.i(44818);
                        if (z) {
                            ab.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bo.anU() - anU) + " ms");
                            b.U(str, 3);
                            o.acv().pZ(str);
                        } else {
                            ab.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                        }
                        RemittanceAdapterUI.this.c(RemittanceAdapterUI.this.edV, wVar.scene, intent);
                        AppMethodBeat.o(44818);
                    }
                });
            }
            AppMethodBeat.o(44823);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
            c(null, 31, null);
            AppMethodBeat.o(44823);
            return true;
        } else {
            AppMethodBeat.o(44823);
            return false;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    /* Access modifiers changed, original: protected */
    public void c(String str, int i, Intent intent) {
        Intent intent2;
        AppMethodBeat.i(44824);
        ab.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.gOW + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.pQQ, intent2);
        if (intent2.getIntExtra("busi_type", 0) == 1) {
            intent2.setClass(this, RemittanceBusiUI.class);
        } else {
            intent2.setClass(this, RemittanceUI.class);
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.gOW);
        intent2.putExtra("pay_scene", i);
        intent2.putExtra("pay_channel", this.obL);
        startActivity(intent2);
        setResult(-1);
        finish();
        AppMethodBeat.o(44824);
    }
}
