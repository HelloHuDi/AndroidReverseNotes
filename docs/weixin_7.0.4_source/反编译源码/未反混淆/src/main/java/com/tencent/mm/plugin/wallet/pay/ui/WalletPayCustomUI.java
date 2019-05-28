package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.ui.p;
import com.tencent.mm.plugin.wallet_core.ui.p.b;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class WalletPayCustomUI extends WalletBaseUI {
    private int gOW = 0;
    private String mTitle = "";
    private chl nrb;
    protected p toZ;
    private String tpa = "";
    private boolean tpb = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46012);
        super.onCreate(bundle);
        AM(8);
        this.tpa = getIntent().getStringExtra("INTENT_PAYFEE");
        this.mTitle = getIntent().getStringExtra("INTENT_TITLE");
        this.tpb = getIntent().getIntExtra("INTENT_CAN_TOUCH", 0) == 1;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_TOKENMESS");
        this.nrb = new chl();
        try {
            this.nrb.parseFrom(byteArrayExtra);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletPayCustomUI", e, "", new Object[0]);
        }
        ab.i("MicroMsg.WalletPayCustomUI", "mTokeMess packageex:%s busi_id:%s sign:%s can_use_touch %s mPayFee %s mTitle %s", this.nrb.xgh, this.nrb.wmb, this.nrb.sign, Boolean.valueOf(this.tpb), this.tpa, this.mTitle);
        this.toZ = p.a(this, this.mTitle, this.tpa, "", this.tpb, new b() {
            public final void f(String str, boolean z, String str2) {
                AppMethodBeat.i(46009);
                WalletPayCustomUI.this.a(new w(str, WalletPayCustomUI.this.nrb.xgi, WalletPayCustomUI.this.nrb.xgh, WalletPayCustomUI.this.nrb.sign, WalletPayCustomUI.this.nrb.kmr, WalletPayCustomUI.this.nrb.wmb, z ? 1 : 0, str2, ""), true, false);
                AppMethodBeat.o(46009);
            }
        }, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(46010);
                WalletPayCustomUI.this.finish();
                AppMethodBeat.o(46010);
            }
        }, new p.a() {
            public final void bXx() {
                AppMethodBeat.i(46011);
                WalletPayCustomUI.this.finish();
                AppMethodBeat.o(46011);
            }
        });
        AppMethodBeat.o(46012);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        AppMethodBeat.i(46013);
        super.onResume();
        AppMethodBeat.o(46013);
    }

    public void onPause() {
        AppMethodBeat.i(46014);
        super.onPause();
        AppMethodBeat.o(46014);
    }

    public void onDestroy() {
        AppMethodBeat.i(46015);
        super.onDestroy();
        AppMethodBeat.o(46015);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46016);
        ab.i("MicroMsg.WalletPayCustomUI", "errorType %s errCode %s, errmsg %s, scene %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (mVar instanceof w) {
            if (i == 0 && i2 == 0) {
                w wVar = (w) mVar;
                Intent intent = new Intent();
                intent.putExtra("INTENT_RESULT_TOKEN", wVar.tuu);
                intent.putExtras(getIntent());
                setResult(-1, intent);
            }
            finish();
        }
        AppMethodBeat.o(46016);
        return false;
    }
}
