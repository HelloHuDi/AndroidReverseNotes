package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.detail;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C21187f;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C28394c;
import com.tencent.p177mm.protocal.protobuf.ash;
import com.tencent.p177mm.protocal.protobuf.bhk;
import com.tencent.p177mm.protocal.protobuf.bon;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.d */
public final class C31372d implements C28396a {
    private String appId;
    boolean isLoading = false;
    C21190b nSW;
    private String nSX;
    int nSY = 0;
    final List<ash> nSZ = new LinkedList();

    public C31372d() {
        AppMethodBeat.m2504i(42042);
        AppMethodBeat.m2505o(42042);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo24262a(Object obj, Intent intent) {
        AppMethodBeat.m2504i(42047);
        this.nSW = (C21190b) obj;
        this.nSX = intent.getStringExtra("key_sendid");
        this.appId = intent.getStringExtra("key_appid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        String stringExtra = intent.getStringExtra("key_from");
        if (stringExtra != null && stringExtra.equalsIgnoreCase("value_open")) {
            bhk aY = C31372d.m50701aY(byteArrayExtra);
            if (aY == null) {
                C4990ab.m7412e("MicroMsg.WxaLuckyMoneyLogicDetail", "parse OpenWxaHBResponse failed.");
            } else {
                this.nSY = aY.wKI;
                this.nSZ.addAll(aY.wKD);
                this.nSW.bKV();
                this.nSW.mo36562a(aY);
                AppMethodBeat.m2505o(42047);
                return;
            }
        }
        m50702xK(0);
        AppMethodBeat.m2505o(42047);
    }

    /* renamed from: aY */
    private static bhk m50701aY(byte[] bArr) {
        AppMethodBeat.m2504i(42043);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7412e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. No data found.");
            AppMethodBeat.m2505o(42043);
            return null;
        }
        bhk bhk = new bhk();
        try {
            bhk.parseFrom(bArr);
            C4990ab.m7416i("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom succeed.");
            AppMethodBeat.m2505o(42043);
            return bhk;
        } catch (IOException e) {
            C4990ab.m7413e("MicroMsg.WxaLuckyMoneyLogicDetail", "parseFrom failed. IOException: %s", e);
            AppMethodBeat.m2505o(42043);
            return null;
        }
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(42044);
        C4990ab.m7416i("MicroMsg.WxaLuckyMoneyLogicDetail", "onDestroy() called");
        this.nSW = null;
        AppMethodBeat.m2505o(42044);
    }

    /* renamed from: xI */
    public final void mo46378xI(int i) {
        AppMethodBeat.m2504i(42045);
        if (this.nSW == null) {
            C4990ab.m7416i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage ui == null");
            AppMethodBeat.m2505o(42045);
        } else if (i < this.nSZ.size()) {
            C4990ab.m7417i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage. offset = [%d], list.size() = [%d], skip load", Integer.valueOf(i), Integer.valueOf(this.nSZ.size()));
            AppMethodBeat.m2505o(42045);
        } else if (this.isLoading) {
            C4990ab.m7416i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. is loading now...");
            AppMethodBeat.m2505o(42045);
        } else if (this.nSY == 0) {
            C4990ab.m7416i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage failed. do not has more...");
            AppMethodBeat.m2505o(42045);
        } else {
            C4990ab.m7416i("MicroMsg.WxaLuckyMoneyLogicDetail", "loadNextPage load");
            this.isLoading = true;
            m50702xK(i);
            AppMethodBeat.m2505o(42045);
        }
    }

    /* renamed from: xK */
    private void m50702xK(final int i) {
        AppMethodBeat.m2504i(42046);
        new C28394c(this.appId, this.nSX, i).mo73978b(new C21187f<C37441a<bon>>() {
            /* renamed from: bW */
            public final /* synthetic */ void mo7774bW(Object obj) {
                AppMethodBeat.m2504i(42041);
                C37441a c37441a = (C37441a) obj;
                C31372d.this.isLoading = false;
                if (C31372d.this.nSW == null) {
                    C4990ab.m7412e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB got its response. but ui is destroyed.");
                    AppMethodBeat.m2505o(42041);
                } else if (c37441a.errType != 0 || c37441a.errCode != 0) {
                    C4990ab.m7413e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB failed [%d, %d, %s]", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
                    C31372d.m50700a(C31372d.this, c37441a.aIm, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query errType = " + c37441a.errType + ",errCode" + c37441a.errCode + "}}"));
                    AppMethodBeat.m2505o(42041);
                } else if (((bon) c37441a.fsy).wKy != 0) {
                    C4990ab.m7413e("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB error wxahb_status = [%d] errorwording = [%s]", Integer.valueOf(((bon) c37441a.fsy).wKy), ((bon) c37441a.fsy).wKJ);
                    C31372d.m50700a(C31372d.this, ((bon) c37441a.fsy).wKJ, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error query red packet fail errStatus = " + ((bon) c37441a.fsy).wKy + ",errMsg" + ((bon) c37441a.fsy).wKJ + "}}"));
                    AppMethodBeat.m2505o(42041);
                } else {
                    C4990ab.m7417i("MicroMsg.WxaLuckyMoneyLogicDetail", "CgiQueryWxaHB succeed. hasmore = [%b] rcvd_user_list.size() = [%d], currentlist.size = [%d]", Integer.valueOf(((bon) c37441a.fsy).wKI), Integer.valueOf(((bon) c37441a.fsy).wKD.size()), Integer.valueOf(C31372d.this.nSZ.size()));
                    C31372d.this.nSY = ((bon) c37441a.fsy).wKI;
                    C31372d.this.nSZ.addAll(((bon) c37441a.fsy).wKD);
                    C31372d.this.nSW.bKV();
                    if (i == 0) {
                        C31372d.this.nSW.mo36563a((bon) c37441a.fsy);
                        AppMethodBeat.m2505o(42041);
                        return;
                    }
                    C31372d.this.nSW.mo36565cj(C31372d.this.nSZ);
                    AppMethodBeat.m2505o(42041);
                }
            }
        });
        AppMethodBeat.m2505o(42046);
    }

    /* renamed from: a */
    static /* synthetic */ void m50700a(C31372d c31372d, String str, Intent intent) {
        AppMethodBeat.m2504i(42048);
        if (c31372d.nSW == null) {
            C4990ab.m7412e("MicroMsg.WxaLuckyMoneyLogicDetail", "fail ui == null");
            AppMethodBeat.m2505o(42048);
            return;
        }
        c31372d.nSW.bKV();
        c31372d.nSW.mo24264Qf(str);
        c31372d.nSW.mo36564ae(intent);
        AppMethodBeat.m2505o(42048);
    }
}
