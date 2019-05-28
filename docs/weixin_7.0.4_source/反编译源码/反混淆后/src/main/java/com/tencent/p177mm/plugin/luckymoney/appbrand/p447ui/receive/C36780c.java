package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.C3362d.C3361a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.detail.C21190b;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C12407d;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C39305b;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.protocal.protobuf.bhk;
import com.tencent.p177mm.protocal.protobuf.bqb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c */
public final class C36780c implements C34431a {
    private String appId = null;
    String nSX = null;
    C34432b nTK = null;
    byte[] nTL;
    bhk nTM;
    public RealnameGuideHelper nTN;
    int state = -1;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c$4 */
    class C284064 implements OnClickListener {
        C284064() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42128);
            C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "RealnameGuideHelper dialog click cancel");
            C36780c.this.mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel realname}}"));
            AppMethodBeat.m2505o(42128);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c$1 */
    class C367811 implements C5681a<Void, C37441a<bqb>> {
        C367811() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(42124);
            Void d = m61072d((C37441a) obj);
            AppMethodBeat.m2505o(42124);
            return d;
        }

        /* renamed from: d */
        private Void m61072d(C37441a<bqb> c37441a) {
            AppMethodBeat.m2504i(42123);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C4990ab.m7417i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed, wxahb_status = [%d],receive_status = [%d],sendId = [%s]", Integer.valueOf(((bqb) c37441a.fsy).wKy), Integer.valueOf(((bqb) c37441a.fsy).nSb), C36780c.this.nSX);
                if (!(((bqb) c37441a.fsy).wKy == 1 || ((bqb) c37441a.fsy).wKx == null)) {
                    C36780c.this.nTL = ((bqb) c37441a.fsy).wKx.toByteArray();
                }
                C36780c.this.state = ((bqb) c37441a.fsy).wKy;
                C36780c c36780c = C36780c.this;
                bqb bqb = (bqb) c37441a.fsy;
                if (c36780c.nTK == null) {
                    C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed but ui == null");
                } else {
                    int i;
                    if (bqb.wKH == 1 && bqb.nSc == 0) {
                        i = 1;
                    } else if (bqb.nSb == 2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onLuckyMoneyReceived shouldSkipToDetailUI");
                        c36780c.bLg();
                    } else if (bqb.wKy == 1) {
                        c36780c.nTK.mo54965a(bqb.wKF, bqb.wKG, bqb.wKy, bqb.wKJ, bqb.wKH == 1, bqb.nSc == 1);
                    } else if (bqb.wKy == 0) {
                        c36780c.nTK.mo54966a(bqb.wKF, bqb.wKG, bqb.kfM, bqb.nSd, bqb.wKH == 1, bqb.nSc == 1);
                    } else {
                        C4990ab.m7417i("MicroMsg.WxaReceiveLuckyMoneyLogic", "back.resp.wxahb_status is invalid.resp. wxahb_status = [%d] receive_status = [%d] hb_type = [%d]", Integer.valueOf(bqb.wKy), Integer.valueOf(bqb.nSb), Integer.valueOf(bqb.nSc));
                    }
                }
                AppMethodBeat.m2505o(42123);
                return null;
            }
            C4990ab.m7413e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB failed [%d, %d, %s]", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            C36780c.this.mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Receive errType = " + c37441a.errType + ",errCode" + c37441a.errCode + "}}"));
            AppMethodBeat.m2505o(42123);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c$3 */
    class C367823 implements C3361a {
        C367823() {
        }

        /* renamed from: d */
        public final void mo7773d(int i, Intent intent) {
            AppMethodBeat.m2504i(42127);
            if (i == -1) {
                C36780c c36780c = C36780c.this;
                if (c36780c.nTK == null) {
                    C4990ab.m7412e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                    AppMethodBeat.m2505o(42127);
                    return;
                }
                c36780c.nTK.bKV();
                c36780c.nTK.mo24268c(-1, new Intent());
                AppMethodBeat.m2505o(42127);
                return;
            }
            C36780c.this.mo58638af(intent);
            AppMethodBeat.m2505o(42127);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c$2 */
    class C367832 implements C5681a<Void, C37441a<bhk>> {
        C367832() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(42126);
            Void d = m61074d((C37441a) obj);
            AppMethodBeat.m2505o(42126);
            return d;
        }

        /* renamed from: d */
        private Void m61074d(C37441a<bhk> c37441a) {
            AppMethodBeat.m2504i(42125);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
                if (((bhk) c37441a.fsy).wKy != 0) {
                    C4990ab.m7413e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", Integer.valueOf(((bhk) c37441a.fsy).wKy), ((bhk) c37441a.fsy).wKJ);
                    C36780c c36780c = C36780c.this;
                    int i = ((bhk) c37441a.fsy).wKy;
                    switch (i) {
                        case 1:
                            c36780c.mo58638af(new Intent().putExtra("result_error_code", CdnLogic.kMediaTypeBackupFile).putExtra("result_error_msg", "fail:the red packet is expired"));
                            break;
                        case 2:
                            c36780c.mo58638af(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
                            break;
                        case 3:
                            c36780c.mo58638af(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
                            break;
                        default:
                            c36780c.mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
                            break;
                    }
                    AppMethodBeat.m2505o(42125);
                } else {
                    C36780c c36780c2 = C36780c.this;
                    bhk bhk = (bhk) c37441a.fsy;
                    if (c36780c2.nTK == null) {
                        C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
                    } else {
                        c36780c2.nTM = bhk;
                        c36780c2.nTK.bLd();
                        if (c36780c2.nTM.vWf != null) {
                            c36780c2.nTN = new RealnameGuideHelper();
                            c36780c2.nTN.mo74571a(String.valueOf(c36780c2.nTM.vWf.vAF), c36780c2.nTM.vWf.nZa, c36780c2.nTM.vWf.nZb, c36780c2.nTM.vWf.nZc, c36780c2.nTM.vWf.nZd, 1003);
                            RealnameGuideHelper realnameGuideHelper = c36780c2.nTN;
                            Bundle bundle = new Bundle();
                            bundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
                            bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                            if (!realnameGuideHelper.mo74574b(c36780c2.nTK.bKU(), bundle, new C284064())) {
                                c36780c2.mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
                            }
                        } else {
                            c36780c2.bLg();
                        }
                    }
                    AppMethodBeat.m2505o(42125);
                }
            } else {
                C4990ab.m7413e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
                C36780c.this.mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + c37441a.errType + ",errCode" + c37441a.errCode + "}}"));
                AppMethodBeat.m2505o(42125);
            }
            return null;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo24262a(Object obj, Intent intent) {
        AppMethodBeat.m2504i(42134);
        C34432b c34432b = (C34432b) obj;
        C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate ");
        this.nTK = c34432b;
        if (intent == null) {
            C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate intent == null");
            mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{intent is null}}"));
            AppMethodBeat.m2505o(42134);
            return;
        }
        this.appId = intent.getStringExtra("appId");
        this.nSX = intent.getStringExtra("sendId");
        if (C5046bo.isNullOrNil(this.appId) || C5046bo.isNullOrNil(this.nSX)) {
            C4990ab.m7417i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate appId = [%s] sendId = [%s]", this.appId, this.nSX);
            mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{appid or send is nil}}"));
            AppMethodBeat.m2505o(42134);
            return;
        }
        new C12407d(this.appId, this.nSX).mo73978b(new C367811());
        AppMethodBeat.m2505o(42134);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(42129);
        C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
        this.nTK = null;
        this.nTM = null;
        this.nTN = null;
        AppMethodBeat.m2505o(42129);
    }

    public final void bLc() {
        AppMethodBeat.m2504i(42130);
        if (this.nTK == null) {
            C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
            AppMethodBeat.m2505o(42130);
            return;
        }
        bLg();
        AppMethodBeat.m2505o(42130);
    }

    public final void bLb() {
        AppMethodBeat.m2504i(42131);
        if (this.state != 0) {
            C4990ab.m7417i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", Integer.valueOf(this.state));
            AppMethodBeat.m2505o(42131);
        } else if (this.nTK == null) {
            C4990ab.m7416i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
            AppMethodBeat.m2505o(42131);
        } else {
            new C39305b(this.appId, this.nSX, this.nTL).mo73978b(new C367832());
            AppMethodBeat.m2505o(42131);
        }
    }

    /* Access modifiers changed, original: final */
    public final void bLg() {
        AppMethodBeat.m2504i(42132);
        Intent intent = new Intent();
        intent.putExtra("key_sendid", this.nSX);
        intent.putExtra("key_appid", this.appId);
        if (this.nTM != null) {
            Bundle bundle = new Bundle();
            try {
                bundle.putByteArray("key_data", this.nTM.toByteArray());
                intent.putExtras(bundle);
                intent.putExtra("key_from", "value_open");
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", e, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
                mo58638af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
                AppMethodBeat.m2505o(42132);
                return;
            }
        }
        intent.putExtra("key_from", "value_query");
        this.nTK.mo24265a(C21190b.class, intent, new C367823());
        AppMethodBeat.m2505o(42132);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: af */
    public final void mo58638af(Intent intent) {
        AppMethodBeat.m2504i(42133);
        if (this.nTK == null) {
            C4990ab.m7412e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
            AppMethodBeat.m2505o(42133);
            return;
        }
        this.nTK.bKV();
        this.nTK.mo24268c(0, intent);
        AppMethodBeat.m2505o(42133);
    }
}
