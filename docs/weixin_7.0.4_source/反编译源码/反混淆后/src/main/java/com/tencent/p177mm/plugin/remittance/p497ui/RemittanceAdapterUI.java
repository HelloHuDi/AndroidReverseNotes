package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.remittance.model.C34809w;
import com.tencent.p177mm.plugin.wallet.C40052a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI */
public class RemittanceAdapterUI extends WalletBaseUI {
    public String edV = null;
    protected int gOW;
    protected int obL;
    protected boolean pQP = false;
    protected C40052a pQQ = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44819);
        super.onCreate(bundle);
        mo9439AM(8);
        this.gOW = getIntent().getIntExtra("scene", 0);
        this.edV = getIntent().getStringExtra("receiver_name");
        this.obL = getIntent().getIntExtra("pay_channel", -1);
        this.pQQ = C40052a.m68624at(getIntent());
        if (this.obL == -1) {
            C40931c dOD = dOD();
            if (dOD != null) {
                this.obL = dOD.mqu.getInt("pay_channel", -1);
            }
        }
        if (this.gOW == 1) {
            this.pQP = true;
            cfy();
            AppMethodBeat.m2505o(44819);
        } else if (this.gOW == 3) {
            mo39992nf(580);
            if (getIntent() == null) {
                C4990ab.m7410d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                AppMethodBeat.m2505o(44819);
                return;
            }
            C1207m c22558a = new C22558a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra("url"), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
            c22558a.eHT = "RemittanceProcess";
            mo39970a(c22558a, true, false);
            AppMethodBeat.m2505o(44819);
        } else if (this.gOW == 2) {
            if (C5046bo.isNullOrNil(this.edV)) {
                C4990ab.m7420w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.gOW);
                finish();
                AppMethodBeat.m2505o(44819);
                return;
            }
            mo25089c(this.edV, 31, null);
            AppMethodBeat.m2505o(44819);
        } else if (this.gOW != 5 && this.gOW != 6) {
            mo25089c(null, 31, null);
            AppMethodBeat.m2505o(44819);
        } else if (C5046bo.isNullOrNil(this.edV)) {
            C4990ab.m7420w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.gOW);
            finish();
            AppMethodBeat.m2505o(44819);
        } else {
            String str = this.edV;
            C4990ab.m7416i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.gOW + ", name=" + str);
            Intent intent = new Intent();
            C40052a.m68623a(this.pQQ, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.gOW);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.obL);
            startActivity(intent);
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(44819);
        }
    }

    /* Access modifiers changed, original: protected */
    public void cfy() {
        AppMethodBeat.m2504i(44820);
        C1207m c34809w = new C34809w(this.edV, this.obL);
        c34809w.eHT = "RemittanceProcess";
        mo39970a(c34809w, true, false);
        AppMethodBeat.m2505o(44820);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44821);
        if (this.gOW == 3) {
            mo39993ng(580);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(44821);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(44822);
        if (this.pQP) {
            C4990ab.m7410d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            AppMethodBeat.m2505o(44822);
            return;
        }
        C4990ab.m7410d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
        AppMethodBeat.m2505o(44822);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44823);
        if (c1207m instanceof C34809w) {
            this.pQP = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            C30379h.m48465bQ(this, str);
            finish();
            AppMethodBeat.m2505o(44823);
            return true;
        } else if (c1207m instanceof C34809w) {
            final C34809w c34809w = (C34809w) c1207m;
            String str2 = c34809w.pPZ;
            this.edV = c34809w.username;
            if (C5046bo.isNullOrNil(this.edV) && C5046bo.isNullOrNil(str2)) {
                C4990ab.m7410d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.gOW);
                finish();
                AppMethodBeat.m2505o(44823);
                return true;
            }
            if (this.gOW == 1) {
                if (c34809w.scene == 33) {
                    this.pQQ = C40052a.m68625dq(this.edV, 2);
                    this.pQQ.mo63379bs(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.pQQ = C40052a.m68625dq(this.edV, 3);
                    this.pQQ.mo63379bs(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", c34809w.kCJ);
            intent.putExtra("desc", c34809w.desc);
            intent.putExtra("scan_remittance_id", c34809w.pPQ);
            intent.putExtra("receiver_true_name", C36391e.att(c34809w.pPP));
            intent.putExtra("receiver_true_name_busi", c34809w.pPw);
            intent.putExtra("receiver_tips", c34809w.pPR);
            intent.putExtra("rcvr_new_desc", c34809w.pPS);
            intent.putExtra("payer_desc", c34809w.pPT);
            intent.putExtra("rcvr_open_id", c34809w.pPZ);
            intent.putExtra("mch_name", c34809w.pPW);
            intent.putExtra("mch_info", c34809w.pQc);
            intent.putExtra("mch_photo", c34809w.pPX);
            intent.putExtra("mch_type", c34809w.pQa);
            intent.putExtra("mch_time", c34809w.pPY);
            if (c34809w.pPV == 1) {
                intent.putExtra("busi_type", c34809w.pPV);
                intent.putExtra("rcvr_ticket", c34809w.pPU);
                intent.putExtra("rcvr_open_id", c34809w.pPZ);
                intent.putExtra("get_pay_wifi", c34809w.pQb);
                if (c34809w.pQd != null) {
                    intent.putExtra("BusiRemittanceResp", c34809w.pQd);
                }
            }
            C1720g.m3537RQ();
            C7616ad aoN = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoN(this.edV);
            C41730b.m73489U(this.edV, 3);
            if (aoN != null || this.edV.equals("")) {
                mo25089c(this.edV, c34809w.scene, intent);
            } else {
                C4990ab.m7410d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long anU = C5046bo.anU();
                C26417a.flu.mo20966a(this.edV, "", new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(44818);
                        if (z) {
                            C4990ab.m7418v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (C5046bo.anU() - anU) + " ms");
                            C41730b.m73489U(str, 3);
                            C17884o.acv().mo67495pZ(str);
                        } else {
                            C4990ab.m7420w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                        }
                        RemittanceAdapterUI.this.mo25089c(RemittanceAdapterUI.this.edV, c34809w.scene, intent);
                        AppMethodBeat.m2505o(44818);
                    }
                });
            }
            AppMethodBeat.m2505o(44823);
            return true;
        } else if (c1207m instanceof C22558a) {
            C46512f.akr(((C22558a) c1207m).cOS());
            mo25089c(null, 31, null);
            AppMethodBeat.m2505o(44823);
            return true;
        } else {
            AppMethodBeat.m2505o(44823);
            return false;
        }
    }

    public final int getLayoutId() {
        return -1;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public void mo25089c(String str, int i, Intent intent) {
        Intent intent2;
        AppMethodBeat.m2504i(44824);
        C4990ab.m7416i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.gOW + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        C40052a.m68623a(this.pQQ, intent2);
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
        AppMethodBeat.m2505o(44824);
    }
}
