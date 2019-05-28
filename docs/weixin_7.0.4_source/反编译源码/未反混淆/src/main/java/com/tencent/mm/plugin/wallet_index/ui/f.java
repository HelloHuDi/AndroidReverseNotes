package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_index.c.b;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.z;
import java.util.ArrayList;

public final class f implements b {
    private c tRr;
    private final int tSp = (hashCode() & CdnLogic.kBizGeneric);
    private d tSq = null;
    private c tSr;

    public f(c cVar, c cVar2) {
        AppMethodBeat.i(48313);
        this.tRr = cVar;
        this.tSr = cVar2;
        a.xxA.c(this.tSr);
        AppMethodBeat.o(48313);
    }

    public final int cSW() {
        return 2;
    }

    public final int a(MMActivity mMActivity, d dVar) {
        AppMethodBeat.i(48314);
        ab.i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", Boolean.valueOf(this.tRr.tRE), Integer.valueOf(mMActivity.getTaskId()));
        z.dNW();
        this.tSq = dVar;
        if (!this.tRr.tRE) {
            PayInfo payInfo = new PayInfo();
            payInfo.czZ = this.tRr.tRf.wyq;
            payInfo.partnerId = this.tRr.tRf.wyr;
            payInfo.cQF = this.tRr.tRf.wys;
            payInfo.cIf = 5;
            h.a(mMActivity, payInfo, this.tSp);
        } else if (this.tRr.tRf != null) {
            g gVar = new g();
            gVar.appId = this.tRr.tRf.wyt.app_id;
            gVar.timeStamp = this.tRr.tRf.wyt.tyv;
            gVar.nonceStr = this.tRr.tRf.wyt.kmt;
            gVar.packageExt = this.tRr.tRf.wyt.wLu;
            gVar.signType = this.tRr.tRf.wyt.kmr;
            gVar.cId = this.tRr.tRf.wys;
            gVar.cIf = this.tRr.tRf.cIf;
            gVar.vwz = "key_from_scene_appbrandgame";
            h.a(mMActivity, gVar, this.tSp, null);
        } else {
            ab.e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
        }
        ab.e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", Integer.valueOf(this.tSp));
        int i = this.tSp;
        AppMethodBeat.o(48314);
        return i;
    }

    public final boolean a(MMActivity mMActivity, int i, int i2, Intent intent) {
        AppMethodBeat.i(48315);
        String str = "MicroMsg.WeiXinWallet";
        String str2 = "onPayEnd requestCode : %d,payResult : %d, data is null : %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        ab.i(str, str2, objArr);
        if (i == this.tSp && this.tSq != null) {
            b bu;
            if (i2 == -1) {
                if (intent == null || intent.getIntExtra("key_jsapi_pay_err_code", 0) != 0) {
                    bu = b.bu(5, "");
                } else {
                    bu = b.bu(0, "");
                }
            } else if (i2 == 0) {
                bu = b.bu(1, "");
            } else {
                bu = b.bu(6, "");
            }
            ab.i("MicroMsg.WeiXinWallet", "wxpay result : %s", bu);
            this.tSq.a(bu, new com.tencent.mm.plugin.wallet_index.b.a.c(this.tRr.kWz, this.tRr.tRw, this.tRr.tQX, this.tRr.tQY));
            this.tSq = null;
        }
        AppMethodBeat.o(48315);
        return true;
    }

    public final void l(MMActivity mMActivity) {
        AppMethodBeat.i(48316);
        a.xxA.d(this.tSr);
        AppMethodBeat.o(48316);
    }

    public final void b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(48317);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", 0);
        intent.putExtra("key_err_msg", "");
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
        AppMethodBeat.o(48317);
    }

    public final void a(MMActivity mMActivity, ArrayList<String> arrayList, d dVar, boolean z) {
        AppMethodBeat.i(48318);
        if (dVar != null) {
            dVar.a(b.bu(0, ""), new com.tencent.mm.plugin.wallet_index.b.a.c(this.tRr.kWz, this.tRr.tRw, this.tRr.tQX, this.tRr.tQY));
        }
        AppMethodBeat.o(48318);
    }
}
