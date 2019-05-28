package com.tencent.p177mm.plugin.wallet.pay.p557ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35506p;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35506p.C35504a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35506p.C35505b;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35473w;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI */
public class WalletPayCustomUI extends WalletBaseUI {
    private int gOW = 0;
    private String mTitle = "";
    private chl nrb;
    protected C35506p toZ;
    private String tpa = "";
    private boolean tpb = false;

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI$1 */
    class C248641 implements C35505b {
        C248641() {
        }

        /* renamed from: f */
        public final void mo41714f(String str, boolean z, String str2) {
            AppMethodBeat.m2504i(46009);
            WalletPayCustomUI.this.mo39970a(new C35473w(str, WalletPayCustomUI.this.nrb.xgi, WalletPayCustomUI.this.nrb.xgh, WalletPayCustomUI.this.nrb.sign, WalletPayCustomUI.this.nrb.kmr, WalletPayCustomUI.this.nrb.wmb, z ? 1 : 0, str2, ""), true, false);
            AppMethodBeat.m2505o(46009);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI$2 */
    class C248652 implements OnCancelListener {
        C248652() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(46010);
            WalletPayCustomUI.this.finish();
            AppMethodBeat.m2505o(46010);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.ui.WalletPayCustomUI$3 */
    class C248663 implements C35504a {
        C248663() {
        }

        public final void bXx() {
            AppMethodBeat.m2504i(46011);
            WalletPayCustomUI.this.finish();
            AppMethodBeat.m2505o(46011);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46012);
        super.onCreate(bundle);
        mo9439AM(8);
        this.tpa = getIntent().getStringExtra("INTENT_PAYFEE");
        this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
        this.tpb = getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
        this.nrb = new chl();
        try {
            this.nrb.parseFrom(byteArrayExtra);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletPayCustomUI", e, "", new Object[0]);
        }
        C4990ab.m7417i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", this.nrb.xgh, this.nrb.wmb, this.nrb.sign, Boolean.valueOf(this.tpb), this.tpa, this.mTitle);
        this.toZ = C35506p.m58269a(this, this.mTitle, this.tpa, "", this.tpb, new C248641(), new C248652(), new C248663());
        AppMethodBeat.m2505o(46012);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(46013);
        super.onResume();
        AppMethodBeat.m2505o(46013);
    }

    public void onPause() {
        AppMethodBeat.m2504i(46014);
        super.onPause();
        AppMethodBeat.m2505o(46014);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46015);
        super.onDestroy();
        AppMethodBeat.m2505o(46015);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46016);
        C4990ab.m7417i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (c1207m instanceof C35473w) {
            if (i == 0 && i2 == 0) {
                C35473w c35473w = (C35473w) c1207m;
                Intent intent = new Intent();
                intent.putExtra("INTENT_RESULT_TOKEN", c35473w.tuu);
                intent.putExtras(getIntent());
                setResult(-1, intent);
            }
            finish();
        }
        AppMethodBeat.m2505o(46016);
        return false;
    }
}
