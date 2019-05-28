package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.a.b;
import com.tencent.mm.plugin.luckymoney.appbrand.a.d;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.c.a;
import java.io.IOException;

public final class c implements a {
    private String appId = null;
    String nSX = null;
    b nTK = null;
    byte[] nTL;
    bhk nTM;
    public RealnameGuideHelper nTN;
    int state = -1;

    public final /* synthetic */ void a(Object obj, Intent intent) {
        AppMethodBeat.i(42134);
        b bVar = (b) obj;
        ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate ");
        this.nTK = bVar;
        if (intent == null) {
            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate intent == null");
            af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{intent is null}}"));
            AppMethodBeat.o(42134);
            return;
        }
        this.appId = intent.getStringExtra("appId");
        this.nSX = intent.getStringExtra("sendId");
        if (bo.isNullOrNil(this.appId) || bo.isNullOrNil(this.nSX)) {
            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onCreate appId = [%s] sendId = [%s]", this.appId, this.nSX);
            af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{appid or send is nil}}"));
            AppMethodBeat.o(42134);
            return;
        }
        new d(this.appId, this.nSX).b(new a<Void, com.tencent.mm.ai.a.a<bqb>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(42124);
                Void d = d((com.tencent.mm.ai.a.a) obj);
                AppMethodBeat.o(42124);
                return d;
            }

            private Void d(com.tencent.mm.ai.a.a<bqb> aVar) {
                AppMethodBeat.i(42123);
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed, wxahb_status = [%d],receive_status = [%d],sendId = [%s]", Integer.valueOf(((bqb) aVar.fsy).wKy), Integer.valueOf(((bqb) aVar.fsy).nSb), c.this.nSX);
                    if (!(((bqb) aVar.fsy).wKy == 1 || ((bqb) aVar.fsy).wKx == null)) {
                        c.this.nTL = ((bqb) aVar.fsy).wKx.toByteArray();
                    }
                    c.this.state = ((bqb) aVar.fsy).wKy;
                    c cVar = c.this;
                    bqb bqb = (bqb) aVar.fsy;
                    if (cVar.nTK == null) {
                        ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed but ui == null");
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
                            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onLuckyMoneyReceived shouldSkipToDetailUI");
                            cVar.bLg();
                        } else if (bqb.wKy == 1) {
                            cVar.nTK.a(bqb.wKF, bqb.wKG, bqb.wKy, bqb.wKJ, bqb.wKH == 1, bqb.nSc == 1);
                        } else if (bqb.wKy == 0) {
                            cVar.nTK.a(bqb.wKF, bqb.wKG, bqb.kfM, bqb.nSd, bqb.wKH == 1, bqb.nSc == 1);
                        } else {
                            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "back.resp.wxahb_status is invalid.resp. wxahb_status = [%d] receive_status = [%d] hb_type = [%d]", Integer.valueOf(bqb.wKy), Integer.valueOf(bqb.nSb), Integer.valueOf(bqb.nSc));
                        }
                    }
                    AppMethodBeat.o(42123);
                    return null;
                }
                ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB failed [%d, %d, %s]", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                c.this.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Receive errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
                AppMethodBeat.o(42123);
                return null;
            }
        });
        AppMethodBeat.o(42134);
    }

    public final void onDestroy() {
        AppMethodBeat.i(42129);
        ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
        this.nTK = null;
        this.nTM = null;
        this.nTN = null;
        AppMethodBeat.o(42129);
    }

    public final void bLc() {
        AppMethodBeat.i(42130);
        if (this.nTK == null) {
            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
            AppMethodBeat.o(42130);
            return;
        }
        bLg();
        AppMethodBeat.o(42130);
    }

    public final void bLb() {
        AppMethodBeat.i(42131);
        if (this.state != 0) {
            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", Integer.valueOf(this.state));
            AppMethodBeat.o(42131);
        } else if (this.nTK == null) {
            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
            AppMethodBeat.o(42131);
        } else {
            new b(this.appId, this.nSX, this.nTL).b(new a<Void, com.tencent.mm.ai.a.a<bhk>>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(42126);
                    Void d = d((com.tencent.mm.ai.a.a) obj);
                    AppMethodBeat.o(42126);
                    return d;
                }

                private Void d(com.tencent.mm.ai.a.a<bhk> aVar) {
                    AppMethodBeat.i(42125);
                    if (aVar.errType == 0 && aVar.errCode == 0) {
                        ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
                        if (((bhk) aVar.fsy).wKy != 0) {
                            ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", Integer.valueOf(((bhk) aVar.fsy).wKy), ((bhk) aVar.fsy).wKJ);
                            c cVar = c.this;
                            int i = ((bhk) aVar.fsy).wKy;
                            switch (i) {
                                case 1:
                                    cVar.af(new Intent().putExtra("result_error_code", CdnLogic.kMediaTypeBackupFile).putExtra("result_error_msg", "fail:the red packet is expired"));
                                    break;
                                case 2:
                                    cVar.af(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
                                    break;
                                case 3:
                                    cVar.af(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
                                    break;
                                default:
                                    cVar.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
                                    break;
                            }
                            AppMethodBeat.o(42125);
                        } else {
                            c cVar2 = c.this;
                            bhk bhk = (bhk) aVar.fsy;
                            if (cVar2.nTK == null) {
                                ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
                            } else {
                                cVar2.nTM = bhk;
                                cVar2.nTK.bLd();
                                if (cVar2.nTM.vWf != null) {
                                    cVar2.nTN = new RealnameGuideHelper();
                                    cVar2.nTN.a(String.valueOf(cVar2.nTM.vWf.vAF), cVar2.nTM.vWf.nZa, cVar2.nTM.vWf.nZb, cVar2.nTM.vWf.nZc, cVar2.nTM.vWf.nZd, 1003);
                                    RealnameGuideHelper realnameGuideHelper = cVar2.nTN;
                                    Bundle bundle = new Bundle();
                                    bundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
                                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                                    if (!realnameGuideHelper.b(cVar2.nTK.bKU(), bundle, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.i(42128);
                                            ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "RealnameGuideHelper dialog click cancel");
                                            c.this.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel realname}}"));
                                            AppMethodBeat.o(42128);
                                        }
                                    })) {
                                        cVar2.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
                                    }
                                } else {
                                    cVar2.bLg();
                                }
                            }
                            AppMethodBeat.o(42125);
                        }
                    } else {
                        ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
                        c.this.af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + aVar.errType + ",errCode" + aVar.errCode + "}}"));
                        AppMethodBeat.o(42125);
                    }
                    return null;
                }
            });
            AppMethodBeat.o(42131);
        }
    }

    /* Access modifiers changed, original: final */
    public final void bLg() {
        AppMethodBeat.i(42132);
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
                ab.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", e, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
                af(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
                AppMethodBeat.o(42132);
                return;
            }
        }
        intent.putExtra("key_from", "value_query");
        this.nTK.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, intent, new com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a() {
            public final void d(int i, Intent intent) {
                AppMethodBeat.i(42127);
                if (i == -1) {
                    c cVar = c.this;
                    if (cVar.nTK == null) {
                        ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                        AppMethodBeat.o(42127);
                        return;
                    }
                    cVar.nTK.bKV();
                    cVar.nTK.c(-1, new Intent());
                    AppMethodBeat.o(42127);
                    return;
                }
                c.this.af(intent);
                AppMethodBeat.o(42127);
            }
        });
        AppMethodBeat.o(42132);
    }

    /* Access modifiers changed, original: final */
    public final void af(Intent intent) {
        AppMethodBeat.i(42133);
        if (this.nTK == null) {
            ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
            AppMethodBeat.o(42133);
            return;
        }
        this.nTK.bKV();
        this.nTK.c(0, intent);
        AppMethodBeat.o(42133);
    }
}
