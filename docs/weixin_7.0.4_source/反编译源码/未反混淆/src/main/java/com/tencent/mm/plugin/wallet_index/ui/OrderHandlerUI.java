package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.z;

@a(3)
public class OrderHandlerUI extends MMActivity implements f {
    public String TAG = "MicroMsg.OrderHandlerUI";
    private String czZ;
    private String fOs;
    private int gOW = 0;
    private long jEg = 0;
    private Options options;
    private boolean pSQ = false;
    private c piM = new c<uv>() {
        {
            AppMethodBeat.i(48229);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(48229);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(48230);
            uv uvVar = (uv) bVar;
            if (uvVar instanceof uv) {
                OrderHandlerUI.this.tRJ = true;
                ab.e(OrderHandlerUI.this.TAG, "onPayEnd, isOk = %s notifyPay %s reqKey %s %s, manualresult %s, from %s", Integer.valueOf(uvVar.cRF.result), Boolean.valueOf(OrderHandlerUI.this.tRL), OrderHandlerUI.this.czZ, uvVar.cRF.czZ, Integer.valueOf(uvVar.cRF.cRG), bo.dpG().toString());
                if (OrderHandlerUI.this.tRL) {
                    AppMethodBeat.o(48230);
                } else if (uvVar.cRF.cRG == 1000) {
                    if (bo.isNullOrNil(uvVar.cRF.czZ) || !uvVar.cRF.czZ.equals(OrderHandlerUI.this.czZ)) {
                        AppMethodBeat.o(48230);
                    } else {
                        OrderHandlerUI.this.finish();
                        AppMethodBeat.o(48230);
                    }
                } else if (uvVar.cRF.cRG == 1001) {
                    AppMethodBeat.o(48230);
                } else if (bo.isNullOrNil(uvVar.cRF.czZ) || uvVar.cRF.czZ.equals(OrderHandlerUI.this.czZ)) {
                    if (uvVar.cRF.result == -1) {
                        OrderHandlerUI.this.tRI.errCode = 0;
                        if (OrderHandlerUI.this.tRM) {
                            OrderHandlerUI.this.tRI.returnKey = OrderHandlerUI.this.tRK;
                        } else {
                            Bundle extras = uvVar.cRF.intent.getExtras();
                            String string = extras.getString("intent_pay_app_url");
                            OrderHandlerUI.this.tRK = extras.getString("intent_wap_pay_jump_url");
                            ab.d(OrderHandlerUI.this.TAG, "onPayEnd, returnUrl = ".concat(String.valueOf(string)));
                            OrderHandlerUI.this.tRI.returnKey = string;
                        }
                    } else {
                        OrderHandlerUI.this.tRI.errCode = -2;
                    }
                    if (OrderHandlerUI.this.gOW == 1) {
                        OrderHandlerUI.a(OrderHandlerUI.this, OrderHandlerUI.this, OrderHandlerUI.this.tRK);
                    } else {
                        e.a(OrderHandlerUI.this, OrderHandlerUI.this.fOs, OrderHandlerUI.this.tRI, OrderHandlerUI.this.options);
                    }
                    OrderHandlerUI.this.tRL = true;
                    OrderHandlerUI.this.finish();
                    AppMethodBeat.o(48230);
                } else {
                    ab.e(OrderHandlerUI.this.TAG, "pass notify this req1 %s req2 %s", uvVar.cRF.czZ, OrderHandlerUI.this.czZ);
                    AppMethodBeat.o(48230);
                }
            } else {
                ab.f(OrderHandlerUI.this.TAG, "mismatched event");
                AppMethodBeat.o(48230);
            }
            return false;
        }
    };
    private PayReq tRH;
    private PayResp tRI;
    private boolean tRJ = false;
    private String tRK = "";
    private boolean tRL = false;
    private boolean tRM = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OrderHandlerUI() {
        AppMethodBeat.i(48232);
        AppMethodBeat.o(48232);
    }

    static /* synthetic */ void a(OrderHandlerUI orderHandlerUI, Context context, String str) {
        AppMethodBeat.i(48243);
        orderHandlerUI.bf(context, str);
        AppMethodBeat.o(48243);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48233);
        super.onCreate(bundle);
        this.TAG = "MicroMsg.OrderHandlerUI@" + hashCode();
        this.jEg = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        AM(8);
        z.dNW();
        com.tencent.mm.sdk.b.a.xxA.c(this.piM);
        AppMethodBeat.o(48233);
    }

    public void onResume() {
        Throwable e;
        m gVar;
        AppMethodBeat.i(48234);
        super.onResume();
        PayReq payReq = new PayReq();
        payReq.fromBundle(getIntent().getExtras());
        if (this.tRH == null || !(payReq.prepayId == null || payReq.prepayId.equals(this.tRH.prepayId))) {
            this.tRH = payReq;
            this.gOW = getIntent().getIntExtra("key_scene", 0);
            ab.i(this.TAG, "onCreate() mScene is " + this.gOW);
            if (this.gOW == 0) {
                this.fOs = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (this.fOs == null || this.fOs.length() == 0) {
                    ab.e(this.TAG, "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    AppMethodBeat.o(48234);
                    return;
                }
            }
            this.options = new Options();
            this.options.fromBundle(getIntent().getExtras());
            this.tRI = new PayResp();
            this.tRI.prepayId = payReq.prepayId;
            this.tRI.extData = payReq.extData;
            String str = "";
            if (this.gOW == 0) {
                if (!payReq.checkArgs()) {
                    ab.e(this.TAG, "onCreate, PayReq checkArgs fail");
                    this.tRI.errCode = -1;
                    this.tRI.errStr = getString(R.string.db7);
                    e.a(this, this.fOs, this.tRI, this.options);
                    finish();
                    AppMethodBeat.o(48234);
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    ab.e(this.TAG, "onCreate, checkAppResult fail");
                    this.tRI.errCode = -1;
                    e.a(this, this.fOs, this.tRI, this.options);
                    finish();
                    AppMethodBeat.o(48234);
                    return;
                }
            } else if (this.gOW == 1) {
                str = "WAP";
            }
            String stringExtra = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
            String str2 = "";
            String str3 = "";
            try {
                getPackageManager().getPackageInfo(stringExtra, 0);
                String str4 = (String) getPackageManager().getPackageInfo(stringExtra, 0).applicationInfo.loadLabel(getPackageManager());
                try {
                    Signature[] bx = p.bx(this, stringExtra);
                    if (bx == null || bx.length == 0) {
                        ab.e("MicroMsg.AppUtil", "signs is null");
                        str3 = null;
                    } else {
                        str3 = g.x(bx[0].toByteArray());
                    }
                    str2 = str4;
                } catch (NameNotFoundException e2) {
                    e = e2;
                    str2 = str4;
                    ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                    ab.i(this.TAG, "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
                    gVar = new com.tencent.mm.plugin.wallet_index.c.g(payReq, str, stringExtra, str2, str3);
                    gVar = new k(payReq, str, stringExtra, str2, str3);
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.a(gVar.getType(), (f) this);
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.a(gVar, 0);
                    AppMethodBeat.o(48234);
                }
            } catch (NameNotFoundException e3) {
                e = e3;
                ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                ab.i(this.TAG, "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
                gVar = new com.tencent.mm.plugin.wallet_index.c.g(payReq, str, stringExtra, str2, str3);
                gVar = new k(payReq, str, stringExtra, str2, str3);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(gVar.getType(), (f) this);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(gVar, 0);
                AppMethodBeat.o(48234);
            }
            ab.i(this.TAG, "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
            gVar = new com.tencent.mm.plugin.wallet_index.c.g(payReq, str, stringExtra, str2, str3);
            if (!bo.isNullOrNil(payReq.prepayId) && payReq.prepayId.startsWith("up_")) {
                gVar = new k(payReq, str, stringExtra, str2, str3);
            }
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(gVar.getType(), (f) this);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.a(gVar, 0);
        }
        AppMethodBeat.o(48234);
    }

    public void onDestroy() {
        AppMethodBeat.i(48235);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(397, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(2655, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.piM);
        super.onDestroy();
        AppMethodBeat.o(48235);
    }

    public final int getLayoutId() {
        return R.layout.aju;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48236);
        if (mVar.getType() == 397 || mVar.getType() == 2655) {
            String str2;
            PayInfo payInfo = new PayInfo();
            if (this.gOW == 1) {
                payInfo.cIf = 36;
            } else {
                payInfo.cIf = 2;
            }
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RO().eJo.b(mVar.getType(), (f) this);
            ab.i(this.TAG, "onSceneEnd, errType = " + i + ", errCode = " + i2);
            com.tencent.mm.plugin.wallet_index.c.g gVar = (com.tencent.mm.plugin.wallet_index.c.g) mVar;
            bio bio = (bio) gVar.ehh.fsH.fsP;
            if (bio == null) {
                str2 = null;
            } else {
                str2 = bio.wLZ;
            }
            this.tRK = str2;
            int i3;
            if (i == 4 && i2 == -5) {
                ab.e(this.TAG, "onSceneEnd, auth access denied");
                this.tRI.errCode = -1;
                bD(str, true);
                ad.o(payInfo.cIf, this.tRH == null ? "" : this.tRH.prepayId, i2);
                AppMethodBeat.o(48236);
                return;
            } else if (i == 0 && i2 == 0) {
                String str3;
                String str4;
                String str5;
                csj csj;
                bio = (bio) gVar.ehh.fsH.fsP;
                if (bio == null) {
                    i3 = -1;
                } else {
                    i3 = bio.luT;
                }
                bio = (bio) gVar.ehh.fsH.fsP;
                if (bio == null) {
                    str3 = null;
                } else {
                    str3 = bio.luU;
                }
                bio = (bio) gVar.ehh.fsH.fsP;
                if (bio == null) {
                    str4 = null;
                } else {
                    str4 = bio.wlb;
                }
                bio = (bio) gVar.ehh.fsH.fsP;
                if (bio == null) {
                    str5 = null;
                } else {
                    str5 = bio.wlc;
                }
                bio = (bio) gVar.ehh.fsH.fsP;
                if (bio == null) {
                    csj = null;
                } else {
                    csj = bio.wlh;
                }
                ab.i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", Integer.valueOf(i3), str3, str4, str5);
                if (bo.isNullOrNil(str4)) {
                    ab.e(this.TAG, "onSceneEnd, respPrepayId is null");
                    this.tRI.errCode = -1;
                    bD(str, true);
                    AppMethodBeat.o(48236);
                    return;
                }
                ad.o(payInfo.cIf, str4, i2);
                if (csj == null || bo.isNullOrNil(csj.xpI)) {
                    payInfo.appId = this.tRH.appId;
                    payInfo.czZ = str4;
                    payInfo.partnerId = this.tRH.partnerId;
                    payInfo.tRb = str5;
                    payInfo.vwg = String.valueOf(i3);
                    payInfo.aIm = str3;
                    if (this.jEg > 0) {
                        h.pYm.a(641, 1, 1, true);
                        h.pYm.a(641, 2, bo.gb(this.jEg), true);
                        if (payInfo.vwh == null) {
                            payInfo.vwh = new Bundle();
                        }
                        payInfo.vwh.putLong("wallet_pay_key_check_time", this.jEg);
                    }
                    com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 123);
                } else {
                    this.tRM = true;
                    Intent intent = new Intent();
                    intent.putExtra("prepayId", str4);
                    intent.putExtra("is_jsapi_offline_pay", false);
                    intent.putExtra("pay_gate_url", csj.xpI);
                    intent.putExtra("need_dialog", csj.xpK);
                    intent.putExtra("dialog_text", csj.xpL);
                    intent.putExtra("max_count", csj.xpJ.vRG);
                    intent.putExtra("inteval_time", csj.xpJ.vRF);
                    intent.putExtra("default_wording", csj.xpJ.vRH);
                    d.c((Context) this, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                }
                this.czZ = str4;
                this.tRJ = false;
                AppMethodBeat.o(48236);
                return;
            } else {
                ab.e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
                this.tRI.errCode = -1;
                bD(str, true);
                i3 = payInfo.cIf;
                if (this.tRH == null) {
                    str2 = "";
                } else {
                    str2 = this.tRH.prepayId;
                }
                ad.o(i3, str2, i2);
                AppMethodBeat.o(48236);
                return;
            }
        }
        AppMethodBeat.o(48236);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48237);
        ab.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", this.tRI, Boolean.valueOf(this.tRJ));
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pay_reslut_type", 0);
            if (intExtra == 1000) {
                ab.i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", this.tRI, Boolean.valueOf(this.tRJ), Integer.valueOf(intExtra));
                finish();
                AppMethodBeat.o(48237);
                return;
            } else if (intExtra == 1001) {
                AppMethodBeat.o(48237);
                return;
            }
        }
        if (!(this.tRI == null || this.tRJ)) {
            ab.e(this.TAG, "onActivityResult, onPayEnd not called");
            this.tRI.errCode = -2;
            bD("", false);
        }
        AppMethodBeat.o(48237);
    }

    private void bD(String str, boolean z) {
        AppMethodBeat.i(48238);
        if (this.gOW != 1) {
            e.a(this, this.fOs, this.tRI, this.options);
            finish();
            AppMethodBeat.o(48238);
        } else if (TextUtils.isEmpty(this.tRK) && z) {
            AM(0);
            JN(str);
            AppMethodBeat.o(48238);
        } else {
            bf(this, this.tRK);
            finish();
            AppMethodBeat.o(48238);
        }
    }

    public void finish() {
        AppMethodBeat.i(48239);
        ab.i(this.TAG, "finish hasFinish %s %s", Boolean.valueOf(this.pSQ), bo.dpG().toString());
        if (this.pSQ) {
            AppMethodBeat.o(48239);
            return;
        }
        this.pSQ = true;
        super.finish();
        AppMethodBeat.o(48239);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(48240);
        super.onConfigurationChanged(configuration);
        ab.i(this.TAG, "onConfigurationChanged");
        AppMethodBeat.o(48240);
    }

    private void bf(Context context, String str) {
        AppMethodBeat.i(48241);
        if (context == null) {
            ab.e(this.TAG, "startOuterApp context == null");
            AppMethodBeat.o(48241);
        } else if (TextUtils.isEmpty(str)) {
            ab.e(this.TAG, "startOuterApp callbackUrl is empty");
            AppMethodBeat.o(48241);
        } else {
            ab.i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(str)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (bo.k(context, intent)) {
                context.startActivity(intent);
            }
            AppMethodBeat.o(48241);
        }
    }

    private void JN(String str) {
        AppMethodBeat.i(48242);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.fu2);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(48231);
                dialogInterface.dismiss();
                OrderHandlerUI.this.finish();
                AppMethodBeat.o(48231);
            }
        });
        AppMethodBeat.o(48242);
    }
}
