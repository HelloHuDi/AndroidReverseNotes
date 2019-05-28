package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_index.p1052b.p1053a.C22688c;
import com.tencent.p177mm.plugin.wallet_index.p564c.C35525b;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_index.ui.f */
public final class C46380f implements C4486b {
    private C14357c tRr;
    private final int tSp = (hashCode() & CdnLogic.kBizGeneric);
    private C4487d tSq = null;
    private C4884c tSr;

    public C46380f(C14357c c14357c, C4884c c4884c) {
        AppMethodBeat.m2504i(48313);
        this.tRr = c14357c;
        this.tSr = c4884c;
        C4879a.xxA.mo10052c(this.tSr);
        AppMethodBeat.m2505o(48313);
    }

    public final int cSW() {
        return 2;
    }

    /* renamed from: a */
    public final int mo9547a(MMActivity mMActivity, C4487d c4487d) {
        AppMethodBeat.m2504i(48314);
        C4990ab.m7417i("MicroMsg.WeiXinWallet", "[alex] WeiXinWallet launchPay MiniProgram:%b,taskid:%d", Boolean.valueOf(this.tRr.tRE), Integer.valueOf(mMActivity.getTaskId()));
        C36381z.dNW();
        this.tSq = c4487d;
        if (!this.tRr.tRE) {
            PayInfo payInfo = new PayInfo();
            payInfo.czZ = this.tRr.tRf.wyq;
            payInfo.partnerId = this.tRr.tRf.wyr;
            payInfo.cQF = this.tRr.tRf.wys;
            payInfo.cIf = 5;
            C35899h.m58853a(mMActivity, payInfo, this.tSp);
        } else if (this.tRr.tRf != null) {
            C40493g c40493g = new C40493g();
            c40493g.appId = this.tRr.tRf.wyt.app_id;
            c40493g.timeStamp = this.tRr.tRf.wyt.tyv;
            c40493g.nonceStr = this.tRr.tRf.wyt.kmt;
            c40493g.packageExt = this.tRr.tRf.wyt.wLu;
            c40493g.signType = this.tRr.tRf.wyt.kmr;
            c40493g.cId = this.tRr.tRf.wys;
            c40493g.cIf = this.tRr.tRf.cIf;
            c40493g.vwz = "key_from_scene_appbrandgame";
            C35899h.m58859a(mMActivity, c40493g, this.tSp, null);
        } else {
            C4990ab.m7412e("MicroMsg.WeiXinWallet", "[alex] mIapData.iapWxPayData is null");
        }
        C4990ab.m7413e("MicroMsg.WeiXinWallet", "launchPay return SIMPLE_PAY:%d", Integer.valueOf(this.tSp));
        int i = this.tSp;
        AppMethodBeat.m2505o(48314);
        return i;
    }

    /* renamed from: a */
    public final boolean mo9549a(MMActivity mMActivity, int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48315);
        String str = "MicroMsg.WeiXinWallet";
        String str2 = "onPayEnd requestCode : %d,payResult : %d, data is null : %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        C4990ab.m7417i(str, str2, objArr);
        if (i == this.tSp && this.tSq != null) {
            C35525b bu;
            if (i2 == -1) {
                if (intent == null || intent.getIntExtra("key_jsapi_pay_err_code", 0) != 0) {
                    bu = C35525b.m58303bu(5, "");
                } else {
                    bu = C35525b.m58303bu(0, "");
                }
            } else if (i2 == 0) {
                bu = C35525b.m58303bu(1, "");
            } else {
                bu = C35525b.m58303bu(6, "");
            }
            C4990ab.m7417i("MicroMsg.WeiXinWallet", "wxpay result : %s", bu);
            this.tSq.mo9553a(bu, new C22688c(this.tRr.kWz, this.tRr.tRw, this.tRr.tQX, this.tRr.tQY));
            this.tSq = null;
        }
        AppMethodBeat.m2505o(48315);
        return true;
    }

    /* renamed from: l */
    public final void mo9552l(MMActivity mMActivity) {
        AppMethodBeat.m2504i(48316);
        C4879a.xxA.mo10053d(this.tSr);
        AppMethodBeat.m2505o(48316);
    }

    /* renamed from: b */
    public final void mo9550b(MMActivity mMActivity, boolean z) {
        AppMethodBeat.m2504i(48317);
        Intent intent = new Intent();
        intent.putExtra("key_err_code", 0);
        intent.putExtra("key_err_msg", "");
        mMActivity.setResult(-1, intent);
        mMActivity.finish();
        AppMethodBeat.m2505o(48317);
    }

    /* renamed from: a */
    public final void mo9548a(MMActivity mMActivity, ArrayList<String> arrayList, C4487d c4487d, boolean z) {
        AppMethodBeat.m2504i(48318);
        if (c4487d != null) {
            c4487d.mo9553a(C35525b.m58303bu(0, ""), new C22688c(this.tRr.kWz, this.tRr.tRw, this.tRr.tQX, this.tRr.tQY));
        }
        AppMethodBeat.m2505o(48318);
    }
}
