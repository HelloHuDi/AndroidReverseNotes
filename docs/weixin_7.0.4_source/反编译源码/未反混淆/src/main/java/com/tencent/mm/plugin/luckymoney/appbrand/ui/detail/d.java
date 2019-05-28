package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.a.c;
import com.tencent.mm.plugin.luckymoney.appbrand.a.f;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class d implements a {
    private String appId;
    boolean isLoading = false;
    b nSW;
    private String nSX;
    int nSY = 0;
    final List<ash> nSZ = new LinkedList();

    public d() {
        AppMethodBeat.i(42042);
        AppMethodBeat.o(42042);
    }

    public final /* synthetic */ void a(Object obj, Intent intent) {
        AppMethodBeat.i(42047);
        this.nSW = (b) obj;
        this.nSX = intent.getStringExtra("key_sendid");
        this.appId = intent.getStringExtra("key_appid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        String stringExtra = intent.getStringExtra("key_from");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("value_open")) {
            bhk aY = aY(byteArrayExtra);
            if (aY == null) {
                ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parse OpenWxaHBResponse failed.");
            } else {
                this.nSY = aY.wKI;
                this.nSZ.addAll(aY.wKD);
                this.nSW.bKV();
                this.nSW.a(aY);
                AppMethodBeat.o(42047);
                return;
            }
        }
        xK(0);
        AppMethodBeat.o(42047);
    }

    private static bhk aY(byte[] bArr) {
        AppMethodBeat.i(42043);
        if (bArr == null || bArr.length == 0) {
            ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
            AppMethodBeat.o(42043);
            return null;
        }
        bhk bhk = new bhk();
        try {
            bhk.parseFrom(bArr);
            ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
            AppMethodBeat.o(42043);
            return bhk;
        } catch (IOException e) {
            ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", e);
            AppMethodBeat.o(42043);
            return null;
        }
    }

    public final void onDestroy() {
        AppMethodBeat.i(42044);
        ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
        this.nSW = null;
        AppMethodBeat.o(42044);
    }

    public final void xI(int i) {
        AppMethodBeat.i(42045);
        if (this.nSW == null) {
            ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
            AppMethodBeat.o(42045);
        } else if (i < this.nSZ.size()) {
            ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", Integer.valueOf(i), Integer.valueOf(this.nSZ.size()));
            AppMethodBeat.o(42045);
        } else if (this.isLoading) {
            ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
            AppMethodBeat.o(42045);
        } else if (this.nSY == 0) {
            ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
            AppMethodBeat.o(42045);
        } else {
            ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
            this.isLoading = true;
            xK(i);
            AppMethodBeat.o(42045);
        }
    }

    private void xK(final int i) {
        AppMethodBeat.i(42046);
        new c(this.appId, this.nSX, i).b(new f<a<bon>>() {
            public final /* synthetic */ void bW(Object obj) {
                AppMethodBeat.i(42041);
                a aVar = (a) obj;
                d.this.isLoading = false;
                if (d.this.nSW == null) {
                    ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB got its response. but ui is destroyed.");
                    AppMethodBeat.o(42041);
                } else if (aVar.errType != 0 || aVar.errCode != 0) {
                    ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB failed [%d, %d, %s]", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                    d.a(d.this, aVar.aIm, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
                    AppMethodBeat.o(42041);
                } else if (((bon) aVar.fsy).wKy != 0) {
                    ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB error wxahb_status = [%d] errorwording = [%s]", Integer.valueOf(((bon) aVar.fsy).wKy), ((bon) aVar.fsy).wKJ);
                    d.a(d.this, ((bon) aVar.fsy).wKJ, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query red packet fail errStatus = " + ((bon) aVar.fsy).wKy + ",errMsg" + ((bon) aVar.fsy).wKJ + "}}"));
                    AppMethodBeat.o(42041);
                } else {
                    ab.i("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB succeed. hasmore = [%b] rcvd_user_list.size() = [%d], currentlist.size = [%d]", Integer.valueOf(((bon) aVar.fsy).wKI), Integer.valueOf(((bon) aVar.fsy).wKD.size()), Integer.valueOf(d.this.nSZ.size()));
                    d.this.nSY = ((bon) aVar.fsy).wKI;
                    d.this.nSZ.addAll(((bon) aVar.fsy).wKD);
                    d.this.nSW.bKV();
                    if (i == 0) {
                        d.this.nSW.a((bon) aVar.fsy);
                        AppMethodBeat.o(42041);
                        return;
                    }
                    d.this.nSW.cj(d.this.nSZ);
                    AppMethodBeat.o(42041);
                }
            }
        });
        AppMethodBeat.o(42046);
    }

    static /* synthetic */ void a(d dVar, String str, Intent intent) {
        AppMethodBeat.i(42048);
        if (dVar.nSW == null) {
            ab.e("MicroMsg.WxaLuckyMoneyLogicDetail", "fail ui == null");
            AppMethodBeat.o(42048);
            return;
        }
        dVar.nSW.bKV();
        dVar.nSW.Qf(str);
        dVar.nSW.ae(intent);
        AppMethodBeat.o(42048);
    }
}
