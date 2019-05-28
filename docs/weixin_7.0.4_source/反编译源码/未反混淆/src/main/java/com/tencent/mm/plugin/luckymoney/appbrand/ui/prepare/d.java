package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class d implements a, a {
    private String appId = null;
    c nTw;
    bsv nTx;
    boolean nTy;
    final int nTz = (hashCode() & CdnLogic.kBizGeneric);

    public d() {
        AppMethodBeat.i(42091);
        AppMethodBeat.o(42091);
    }

    public final /* synthetic */ void a(Object obj, Intent intent) {
        AppMethodBeat.i(42098);
        c cVar = (c) obj;
        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onCreate ");
        this.appId = intent.getStringExtra("appId");
        this.nTw = cVar;
        AppMethodBeat.o(42098);
    }

    public final void onDestroy() {
        AppMethodBeat.i(42092);
        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "onDestroy ");
        this.nTw = null;
        AppMethodBeat.o(42092);
    }

    public final void c(int i, int i2, String str, int i3) {
        AppMethodBeat.i(42093);
        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareRandomLuckyMoney() called with: moneyTotalAmount = [" + i + "], packageAmount = [" + i2 + "], wishing = [" + str + "], scope = [" + i3 + "]");
        if (this.nTw == null) {
            AppMethodBeat.o(42093);
            return;
        }
        bsu bsu = new bsu();
        bsu.csB = this.appId;
        bsu.nSc = 1;
        bsu.vzO = i2;
        bsu.wKC = (long) i;
        bsu.nSd = str;
        bsu.wUS = i3;
        a(bsu);
        AppMethodBeat.o(42093);
    }

    public final void d(int i, int i2, String str, int i3) {
        AppMethodBeat.i(42094);
        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareFixLuckyMoney() called with: packageMoneyAmount = [" + i + "], packageAmount = [" + i2 + "], wishing = [" + str + "], scope = [" + i3 + "]");
        if (this.nTw == null) {
            AppMethodBeat.o(42094);
            return;
        }
        bsu bsu = new bsu();
        bsu.csB = this.appId;
        bsu.nSc = 0;
        bsu.vzO = i2;
        bsu.wUR = i;
        bsu.nSd = str;
        bsu.wUS = i3;
        a(bsu);
        AppMethodBeat.o(42094);
    }

    private void a(bsu bsu) {
        AppMethodBeat.i(42095);
        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl ");
        if (this.nTy) {
            ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "prepareImpl isRequesting");
            AppMethodBeat.o(42095);
            return;
        }
        this.nTy = true;
        new e(bsu).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bsv>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(42089);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    d.this.nTx = (bsv) aVar.fsy;
                    if (d.this.nTx == null) {
                        d.this.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request resp is nil}}"));
                    } else if (d.this.nTx.wKy != 0 || d.this.nTx.nYX.equalsIgnoreCase("")) {
                        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail.  sendid = [%s] reqkey = [%s] wxahb_status = [%d]", d.this.nTx.wKw, d.this.nTx.nYX, Integer.valueOf(d.this.nTx.wKy));
                        d.this.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errStatus = " + d.this.nTx.wKy + ",errMsg" + d.this.nTx.wKJ + "}}"));
                        AppMethodBeat.o(42089);
                        return null;
                    } else {
                        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB succeed sendid = [%s] reqkey = [%s]", ((bsv) aVar.fsy).wKw, ((bsv) aVar.fsy).nYX);
                        d dVar = d.this;
                        String str = d.this.nTx.nYX;
                        if (dVar.nTw == null) {
                            ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "doWalletPay() called with: ui == null");
                        } else {
                            MMActivity bKU = dVar.nTw.bKU();
                            bKU.ifE = dVar;
                            PayInfo payInfo = new PayInfo();
                            payInfo.czZ = str;
                            payInfo.cIf = 37;
                            payInfo.cIb = 50;
                            h.a(bKU, payInfo, dVar.nTz);
                        }
                        AppMethodBeat.o(42089);
                        return null;
                    }
                }
                ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "CgiRequestWxaHB fail. [%d, %d, %s]", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                d.this.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Request errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
                AppMethodBeat.o(42089);
                return null;
            }
        });
        AppMethodBeat.o(42095);
    }

    /* Access modifiers changed, original: final */
    public final void af(Intent intent) {
        AppMethodBeat.i(42096);
        this.nTy = false;
        if (this.nTw == null) {
            AppMethodBeat.o(42096);
            return;
        }
        this.nTw.c(0, intent);
        AppMethodBeat.o(42096);
    }

    public final void c(int i, int i2, Intent intent) {
        AppMethodBeat.i(42097);
        ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() called with: requestCode = [" + i + "], resultCode = [" + i2 + "], data = [" + intent + "]");
        if (i == this.nTz) {
            if (i2 == -1) {
                this.nTw.a(b.class, new Intent(), new com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a() {
                    public final void d(int i, Intent intent) {
                        AppMethodBeat.i(42090);
                        Intent putExtra = new Intent().putExtra("sendId", d.this.nTx.wKw);
                        if (i == -1) {
                            putExtra.putExtra("result_share_msg", true);
                        } else {
                            putExtra.putExtra("result_share_msg", false);
                        }
                        d dVar = d.this;
                        dVar.nTy = false;
                        if (dVar.nTw != null) {
                            dVar.nTw.c(-1, putExtra);
                        }
                        AppMethodBeat.o(42090);
                    }
                });
                AppMethodBeat.o(42097);
                return;
            }
            ab.i("MicroMsg.WxaPrepareLuckyMoneyLogic", "mmOnActivityResult() REQUEST_CODE_WALLET called cancel ");
            af(new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:pay fail"));
        }
        AppMethodBeat.o(42097);
    }
}
