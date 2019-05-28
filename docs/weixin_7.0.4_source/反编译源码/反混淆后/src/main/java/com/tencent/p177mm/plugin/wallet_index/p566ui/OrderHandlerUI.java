package com.tencent.p177mm.plugin.wallet_index.p566ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelpay.PayReq;
import com.tencent.p177mm.opensdk.modelpay.PayReq.Options;
import com.tencent.p177mm.opensdk.modelpay.PayResp;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_index.p564c.C29691k;
import com.tencent.p177mm.plugin.wallet_index.p564c.C46377g;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C46527bio;
import com.tencent.p177mm.protocal.protobuf.csj;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI */
public class OrderHandlerUI extends MMActivity implements C1202f {
    public String TAG = "MicroMsg.OrderHandlerUI";
    private String czZ;
    private String fOs;
    private int gOW = 0;
    private long jEg = 0;
    private Options options;
    private boolean pSQ = false;
    private C4884c piM = new C143531();
    private PayReq tRH;
    private PayResp tRI;
    private boolean tRJ = false;
    private String tRK = "";
    private boolean tRL = false;
    private boolean tRM = false;

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI$1 */
    class C143531 extends C4884c<C32652uv> {
        C143531() {
            AppMethodBeat.m2504i(48229);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(48229);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48230);
            C32652uv c32652uv = (C32652uv) c4883b;
            if (c32652uv instanceof C32652uv) {
                OrderHandlerUI.this.tRJ = true;
                C4990ab.m7413e(OrderHandlerUI.this.TAG, "onPayEnd, isOk = %s notifyPay %s reqKey %s %s, manualresult %s, from %s", Integer.valueOf(c32652uv.cRF.result), Boolean.valueOf(OrderHandlerUI.this.tRL), OrderHandlerUI.this.czZ, c32652uv.cRF.czZ, Integer.valueOf(c32652uv.cRF.cRG), C5046bo.dpG().toString());
                if (OrderHandlerUI.this.tRL) {
                    AppMethodBeat.m2505o(48230);
                } else if (c32652uv.cRF.cRG == 1000) {
                    if (C5046bo.isNullOrNil(c32652uv.cRF.czZ) || !c32652uv.cRF.czZ.equals(OrderHandlerUI.this.czZ)) {
                        AppMethodBeat.m2505o(48230);
                    } else {
                        OrderHandlerUI.this.finish();
                        AppMethodBeat.m2505o(48230);
                    }
                } else if (c32652uv.cRF.cRG == 1001) {
                    AppMethodBeat.m2505o(48230);
                } else if (C5046bo.isNullOrNil(c32652uv.cRF.czZ) || c32652uv.cRF.czZ.equals(OrderHandlerUI.this.czZ)) {
                    if (c32652uv.cRF.result == -1) {
                        OrderHandlerUI.this.tRI.errCode = 0;
                        if (OrderHandlerUI.this.tRM) {
                            OrderHandlerUI.this.tRI.returnKey = OrderHandlerUI.this.tRK;
                        } else {
                            Bundle extras = c32652uv.cRF.intent.getExtras();
                            String string = extras.getString("intent_pay_app_url");
                            OrderHandlerUI.this.tRK = extras.getString("intent_wap_pay_jump_url");
                            C4990ab.m7410d(OrderHandlerUI.this.TAG, "onPayEnd, returnUrl = ".concat(String.valueOf(string)));
                            OrderHandlerUI.this.tRI.returnKey = string;
                        }
                    } else {
                        OrderHandlerUI.this.tRI.errCode = -2;
                    }
                    if (OrderHandlerUI.this.gOW == 1) {
                        OrderHandlerUI.m22538a(OrderHandlerUI.this, OrderHandlerUI.this, OrderHandlerUI.this.tRK);
                    } else {
                        C4488e.m6863a(OrderHandlerUI.this, OrderHandlerUI.this.fOs, OrderHandlerUI.this.tRI, OrderHandlerUI.this.options);
                    }
                    OrderHandlerUI.this.tRL = true;
                    OrderHandlerUI.this.finish();
                    AppMethodBeat.m2505o(48230);
                } else {
                    C4990ab.m7413e(OrderHandlerUI.this.TAG, "pass notify this req1 %s req2 %s", c32652uv.cRF.czZ, OrderHandlerUI.this.czZ);
                    AppMethodBeat.m2505o(48230);
                }
            } else {
                C4990ab.m7414f(OrderHandlerUI.this.TAG, "mismatched event");
                AppMethodBeat.m2505o(48230);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI$2 */
    class C143542 implements OnClickListener {
        C143542() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48231);
            dialogInterface.dismiss();
            OrderHandlerUI.this.finish();
            AppMethodBeat.m2505o(48231);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public OrderHandlerUI() {
        AppMethodBeat.m2504i(48232);
        AppMethodBeat.m2505o(48232);
    }

    /* renamed from: a */
    static /* synthetic */ void m22538a(OrderHandlerUI orderHandlerUI, Context context, String str) {
        AppMethodBeat.m2504i(48243);
        orderHandlerUI.m22542bf(context, str);
        AppMethodBeat.m2505o(48243);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48233);
        super.onCreate(bundle);
        this.TAG = "MicroMsg.OrderHandlerUI@" + hashCode();
        this.jEg = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        mo9439AM(8);
        C36381z.dNW();
        C4879a.xxA.mo10052c(this.piM);
        AppMethodBeat.m2505o(48233);
    }

    public void onResume() {
        Throwable e;
        C1207m c46377g;
        AppMethodBeat.m2504i(48234);
        super.onResume();
        PayReq payReq = new PayReq();
        payReq.fromBundle(getIntent().getExtras());
        if (this.tRH == null || !(payReq.prepayId == null || payReq.prepayId.equals(this.tRH.prepayId))) {
            this.tRH = payReq;
            this.gOW = getIntent().getIntExtra("key_scene", 0);
            C4990ab.m7416i(this.TAG, "onCreate() mScene is " + this.gOW);
            if (this.gOW == 0) {
                this.fOs = getIntent().getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (this.fOs == null || this.fOs.length() == 0) {
                    C4990ab.m7412e(this.TAG, "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    AppMethodBeat.m2505o(48234);
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
                    C4990ab.m7412e(this.TAG, "onCreate, PayReq checkArgs fail");
                    this.tRI.errCode = -1;
                    this.tRI.errStr = getString(C25738R.string.db7);
                    C4488e.m6863a(this, this.fOs, this.tRI, this.options);
                    finish();
                    AppMethodBeat.m2505o(48234);
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    C4990ab.m7412e(this.TAG, "onCreate, checkAppResult fail");
                    this.tRI.errCode = -1;
                    C4488e.m6863a(this, this.fOs, this.tRI, this.options);
                    finish();
                    AppMethodBeat.m2505o(48234);
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
                    Signature[] bx = C35799p.m58691bx(this, stringExtra);
                    if (bx == null || bx.length == 0) {
                        C4990ab.m7412e("MicroMsg.AppUtil", "signs is null");
                        str3 = null;
                    } else {
                        str3 = C1178g.m2591x(bx[0].toByteArray());
                    }
                    str2 = str4;
                } catch (NameNotFoundException e2) {
                    e = e2;
                    str2 = str4;
                    C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                    C4990ab.m7417i(this.TAG, "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
                    c46377g = new C46377g(payReq, str, stringExtra, str2, str3);
                    c46377g = new C29691k(payReq, str, stringExtra, str2, str3);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14539a(c46377g.getType(), (C1202f) this);
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c46377g, 0);
                    AppMethodBeat.m2505o(48234);
                }
            } catch (NameNotFoundException e3) {
                e = e3;
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                C4990ab.m7417i(this.TAG, "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
                c46377g = new C46377g(payReq, str, stringExtra, str2, str3);
                c46377g = new C29691k(payReq, str, stringExtra, str2, str3);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(c46377g.getType(), (C1202f) this);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c46377g, 0);
                AppMethodBeat.m2505o(48234);
            }
            C4990ab.m7417i(this.TAG, "packagename app %s displayname %s androidSign %s", stringExtra, str2, str3);
            c46377g = new C46377g(payReq, str, stringExtra, str2, str3);
            if (!C5046bo.isNullOrNil(payReq.prepayId) && payReq.prepayId.startsWith("up_")) {
                c46377g = new C29691k(payReq, str, stringExtra, str2, str3);
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(c46377g.getType(), (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c46377g, 0);
        }
        AppMethodBeat.m2505o(48234);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48235);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(397, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2655, (C1202f) this);
        C4879a.xxA.mo10053d(this.piM);
        super.onDestroy();
        AppMethodBeat.m2505o(48235);
    }

    public final int getLayoutId() {
        return 2130970340;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48236);
        if (c1207m.getType() == 397 || c1207m.getType() == 2655) {
            String str2;
            PayInfo payInfo = new PayInfo();
            if (this.gOW == 1) {
                payInfo.cIf = 36;
            } else {
                payInfo.cIf = 2;
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14546b(c1207m.getType(), (C1202f) this);
            C4990ab.m7416i(this.TAG, "onSceneEnd, errType = " + i + ", errCode = " + i2);
            C46377g c46377g = (C46377g) c1207m;
            C46527bio c46527bio = (C46527bio) c46377g.ehh.fsH.fsP;
            if (c46527bio == null) {
                str2 = null;
            } else {
                str2 = c46527bio.wLZ;
            }
            this.tRK = str2;
            int i3;
            if (i == 4 && i2 == -5) {
                C4990ab.m7412e(this.TAG, "onSceneEnd, auth access denied");
                this.tRI.errCode = -1;
                m22541bD(str, true);
                C44422ad.m80307o(payInfo.cIf, this.tRH == null ? "" : this.tRH.prepayId, i2);
                AppMethodBeat.m2505o(48236);
                return;
            } else if (i == 0 && i2 == 0) {
                String str3;
                String str4;
                String str5;
                csj csj;
                c46527bio = (C46527bio) c46377g.ehh.fsH.fsP;
                if (c46527bio == null) {
                    i3 = -1;
                } else {
                    i3 = c46527bio.luT;
                }
                c46527bio = (C46527bio) c46377g.ehh.fsH.fsP;
                if (c46527bio == null) {
                    str3 = null;
                } else {
                    str3 = c46527bio.luU;
                }
                c46527bio = (C46527bio) c46377g.ehh.fsH.fsP;
                if (c46527bio == null) {
                    str4 = null;
                } else {
                    str4 = c46527bio.wlb;
                }
                c46527bio = (C46527bio) c46377g.ehh.fsH.fsP;
                if (c46527bio == null) {
                    str5 = null;
                } else {
                    str5 = c46527bio.wlc;
                }
                c46527bio = (C46527bio) c46377g.ehh.fsH.fsP;
                if (c46527bio == null) {
                    csj = null;
                } else {
                    csj = c46527bio.wlh;
                }
                C4990ab.m7417i(this.TAG, "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", Integer.valueOf(i3), str3, str4, str5);
                if (C5046bo.isNullOrNil(str4)) {
                    C4990ab.m7412e(this.TAG, "onSceneEnd, respPrepayId is null");
                    this.tRI.errCode = -1;
                    m22541bD(str, true);
                    AppMethodBeat.m2505o(48236);
                    return;
                }
                C44422ad.m80307o(payInfo.cIf, str4, i2);
                if (csj == null || C5046bo.isNullOrNil(csj.xpI)) {
                    payInfo.appId = this.tRH.appId;
                    payInfo.czZ = str4;
                    payInfo.partnerId = this.tRH.partnerId;
                    payInfo.tRb = str5;
                    payInfo.vwg = String.valueOf(i3);
                    payInfo.aIm = str3;
                    if (this.jEg > 0) {
                        C7060h.pYm.mo8378a(641, 1, 1, true);
                        C7060h.pYm.mo8378a(641, 2, C5046bo.m7566gb(this.jEg), true);
                        if (payInfo.vwh == null) {
                            payInfo.vwh = new Bundle();
                        }
                        payInfo.vwh.putLong("wallet_pay_key_check_time", this.jEg);
                    }
                    C35899h.m58853a(this, payInfo, 123);
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
                    C25985d.m41472c((Context) this, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
                }
                this.czZ = str4;
                this.tRJ = false;
                AppMethodBeat.m2505o(48236);
                return;
            } else {
                C4990ab.m7412e(this.TAG, "onSceneEnd,  PayAuthApp is failed!");
                this.tRI.errCode = -1;
                m22541bD(str, true);
                i3 = payInfo.cIf;
                if (this.tRH == null) {
                    str2 = "";
                } else {
                    str2 = this.tRH.prepayId;
                }
                C44422ad.m80307o(i3, str2, i2);
                AppMethodBeat.m2505o(48236);
                return;
            }
        }
        AppMethodBeat.m2505o(48236);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48237);
        C4990ab.m7417i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s", this.tRI, Boolean.valueOf(this.tRJ));
        if (intent != null) {
            int intExtra = intent.getIntExtra("key_pay_reslut_type", 0);
            if (intExtra == 1000) {
                C4990ab.m7417i(this.TAG, "onActivityResult resp %s, onPayEndCalled %s payResultType %s", this.tRI, Boolean.valueOf(this.tRJ), Integer.valueOf(intExtra));
                finish();
                AppMethodBeat.m2505o(48237);
                return;
            } else if (intExtra == 1001) {
                AppMethodBeat.m2505o(48237);
                return;
            }
        }
        if (!(this.tRI == null || this.tRJ)) {
            C4990ab.m7412e(this.TAG, "onActivityResult, onPayEnd not called");
            this.tRI.errCode = -2;
            m22541bD("", false);
        }
        AppMethodBeat.m2505o(48237);
    }

    /* renamed from: bD */
    private void m22541bD(String str, boolean z) {
        AppMethodBeat.m2504i(48238);
        if (this.gOW != 1) {
            C4488e.m6863a(this, this.fOs, this.tRI, this.options);
            finish();
            AppMethodBeat.m2505o(48238);
        } else if (TextUtils.isEmpty(this.tRK) && z) {
            mo9439AM(0);
            m22536JN(str);
            AppMethodBeat.m2505o(48238);
        } else {
            m22542bf(this, this.tRK);
            finish();
            AppMethodBeat.m2505o(48238);
        }
    }

    public void finish() {
        AppMethodBeat.m2504i(48239);
        C4990ab.m7417i(this.TAG, "finish hasFinish %s %s", Boolean.valueOf(this.pSQ), C5046bo.dpG().toString());
        if (this.pSQ) {
            AppMethodBeat.m2505o(48239);
            return;
        }
        this.pSQ = true;
        super.finish();
        AppMethodBeat.m2505o(48239);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(48240);
        super.onConfigurationChanged(configuration);
        C4990ab.m7416i(this.TAG, "onConfigurationChanged");
        AppMethodBeat.m2505o(48240);
    }

    /* renamed from: bf */
    private void m22542bf(Context context, String str) {
        AppMethodBeat.m2504i(48241);
        if (context == null) {
            C4990ab.m7412e(this.TAG, "startOuterApp context == null");
            AppMethodBeat.m2505o(48241);
        } else if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e(this.TAG, "startOuterApp callbackUrl is empty");
            AppMethodBeat.m2505o(48241);
        } else {
            C4990ab.m7416i(this.TAG, "startOuterApp callbackUrl is ".concat(String.valueOf(str)));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (C5046bo.m7572k(context, intent)) {
                context.startActivity(intent);
            }
            AppMethodBeat.m2505o(48241);
        }
    }

    /* renamed from: JN */
    private void m22536JN(String str) {
        AppMethodBeat.m2504i(48242);
        if (TextUtils.isEmpty(str)) {
            str = getString(C25738R.string.fu2);
        }
        C30379h.m48448a((Context) this, str, null, false, new C143542());
        AppMethodBeat.m2505o(48242);
    }
}
