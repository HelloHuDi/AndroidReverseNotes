package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare;

import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.C3362d.C3361a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C28395e;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.bsu;
import com.tencent.p177mm.protocal.protobuf.bsv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d */
public final class C34430d implements C21193a, C5186a {
    private String appId = null;
    C39309c nTw;
    bsv nTx;
    boolean nTy;
    final int nTz = (hashCode() & CdnLogic.kBizGeneric);

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d$1 */
    class C124141 implements C5681a<Void, C37441a<bsv>> {
        C124141() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(42089);
            C37441a c37441a = (C37441a) obj;
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C34430d.this.nTx = (bsv) c37441a.fsy;
                if (C34430d.this.nTx == null) {
                    C34430d.this.mo54962af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request resp is nil}}"));
                } else if (C34430d.this.nTx.wKy != 0 || C34430d.this.nTx.nYX.equalsIgnoreCase("")) {
                    C4990ab.m7417i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail.  sendid = [%s] reqkey = [%s] wxahb_status = [%d]", C34430d.this.nTx.wKw, C34430d.this.nTx.nYX, Integer.valueOf(C34430d.this.nTx.wKy));
                    C34430d.this.mo54962af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errStatus = " + C34430d.this.nTx.wKy + ",errMsg" + C34430d.this.nTx.wKJ + "}}"));
                    AppMethodBeat.m2505o(42089);
                    return null;
                } else {
                    C4990ab.m7417i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB succeed sendid = [%s] reqkey = [%s]", ((bsv) c37441a.fsy).wKw, ((bsv) c37441a.fsy).nYX);
                    C34430d c34430d = C34430d.this;
                    String str = C34430d.this.nTx.nYX;
                    if (c34430d.nTw == null) {
                        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "doWalletPay() called with: ui == null");
                    } else {
                        MMActivity bKU = c34430d.nTw.bKU();
                        bKU.ifE = c34430d;
                        PayInfo payInfo = new PayInfo();
                        payInfo.czZ = str;
                        payInfo.cIf = 37;
                        payInfo.cIb = 50;
                        C35899h.m58853a(bKU, payInfo, c34430d.nTz);
                    }
                    AppMethodBeat.m2505o(42089);
                    return null;
                }
            }
            C4990ab.m7417i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail. [%d, %d, %s]", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            C34430d.this.mo54962af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errType = " + c37441a.errType + ",errCode" + c37441a.errCode + "}}"));
            AppMethodBeat.m2505o(42089);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d$2 */
    class C284032 implements C3361a {
        C284032() {
        }

        /* renamed from: d */
        public final void mo7773d(int i, Intent intent) {
            AppMethodBeat.m2504i(42090);
            Intent putExtra = new Intent().putExtra("sendId", C34430d.this.nTx.wKw);
            if (i == -1) {
                putExtra.putExtra("result_share_msg", true);
            } else {
                putExtra.putExtra("result_share_msg", false);
            }
            C34430d c34430d = C34430d.this;
            c34430d.nTy = false;
            if (c34430d.nTw != null) {
                c34430d.nTw.mo24268c(-1, putExtra);
            }
            AppMethodBeat.m2505o(42090);
        }
    }

    public C34430d() {
        AppMethodBeat.m2504i(42091);
        AppMethodBeat.m2505o(42091);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo24262a(Object obj, Intent intent) {
        AppMethodBeat.m2504i(42098);
        C39309c c39309c = (C39309c) obj;
        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onCreate ");
        this.appId = intent.getStringExtra("appId");
        this.nTw = c39309c;
        AppMethodBeat.m2505o(42098);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(42092);
        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
        this.nTw = null;
        AppMethodBeat.m2505o(42092);
    }

    /* renamed from: c */
    public final void mo36568c(int i, int i2, String str, int i3) {
        AppMethodBeat.m2504i(42093);
        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + i + "], packageAmount = [" + i2 + "], wishing = [" + str + "], scope = [" + i3 + "]");
        if (this.nTw == null) {
            AppMethodBeat.m2505o(42093);
            return;
        }
        bsu bsu = new bsu();
        bsu.csB = this.appId;
        bsu.nSc = 1;
        bsu.vzO = i2;
        bsu.wKC = (long) i;
        bsu.nSd = str;
        bsu.wUS = i3;
        m56422a(bsu);
        AppMethodBeat.m2505o(42093);
    }

    /* renamed from: d */
    public final void mo36569d(int i, int i2, String str, int i3) {
        AppMethodBeat.m2504i(42094);
        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + i + "], packageAmount = [" + i2 + "], wishing = [" + str + "], scope = [" + i3 + "]");
        if (this.nTw == null) {
            AppMethodBeat.m2505o(42094);
            return;
        }
        bsu bsu = new bsu();
        bsu.csB = this.appId;
        bsu.nSc = 0;
        bsu.vzO = i2;
        bsu.wUR = i;
        bsu.nSd = str;
        bsu.wUS = i3;
        m56422a(bsu);
        AppMethodBeat.m2505o(42094);
    }

    /* renamed from: a */
    private void m56422a(bsu bsu) {
        AppMethodBeat.m2504i(42095);
        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
        if (this.nTy) {
            C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
            AppMethodBeat.m2505o(42095);
            return;
        }
        this.nTy = true;
        new C28395e(bsu).mo73978b(new C124141());
        AppMethodBeat.m2505o(42095);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: af */
    public final void mo54962af(Intent intent) {
        AppMethodBeat.m2504i(42096);
        this.nTy = false;
        if (this.nTw == null) {
            AppMethodBeat.m2505o(42096);
            return;
        }
        this.nTw.mo24268c(0, intent);
        AppMethodBeat.m2505o(42096);
    }

    /* renamed from: c */
    public final void mo6069c(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(42097);
        C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + i + "], resultCode = [" + i2 + "], data = [" + intent + "]");
        if (i == this.nTz) {
            if (i2 == -1) {
                this.nTw.mo24265a(C28402b.class, new Intent(), new C284032());
                AppMethodBeat.m2505o(42097);
                return;
            }
            C4990ab.m7416i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
            mo54962af(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
        }
        AppMethodBeat.m2505o(42097);
    }
}
