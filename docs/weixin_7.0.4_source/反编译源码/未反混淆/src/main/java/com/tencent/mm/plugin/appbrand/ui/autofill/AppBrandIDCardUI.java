package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.bzn;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class AppBrandIDCardUI extends MMActivity {
    public static final int iKc = R.id.n;
    private String appId;
    private int flQ;
    private a iJN = new a() {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$2 */
        class AnonymousClass2 implements OnClickListener {
            final /* synthetic */ int crd;
            final /* synthetic */ String ftO;

            AnonymousClass2(int i, String str) {
                this.crd = i;
                this.ftO = str;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(133216);
                Intent intent = new Intent();
                intent.putExtra("intent_err_code", bo.g(Integer.valueOf(this.crd), 0));
                intent.putExtra("intent_err_msg", bo.nullAsNil(this.ftO));
                AppBrandIDCardUI.this.setResult(1, intent);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(133216);
            }
        }

        public final void aME() {
            AppMethodBeat.i(133222);
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new bzn();
            aVar.fsK = new bzo();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
            aVar.fsI = 1774;
            aVar.fsL = 0;
            aVar.fsM = 0;
            b acD = aVar.acD();
            bzn bzn = (bzn) acD.fsG.fsP;
            bzn.csB = AppBrandIDCardUI.this.appId;
            bzn.wXf = AppBrandIDCardUI.this.iKg;
            bzn.wYz = AppBrandIDCardUI.this.flQ;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    AppMethodBeat.i(133215);
                    if (AppBrandIDCardUI.this.ifC != null && AppBrandIDCardUI.this.ifC.isShowing()) {
                        AppBrandIDCardUI.this.ifC.dismiss();
                    }
                    Intent intent;
                    if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                        bzo bzo = (bzo) bVar.fsH.fsP;
                        if (bzo.wXh == null) {
                            ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                            intent = new Intent();
                            intent.putExtra("intent_err_code", 40000);
                            intent.putExtra("intent_err_msg", "network err");
                            AppBrandIDCardUI.this.setResult(1, intent);
                            AppBrandIDCardUI.this.finish();
                            AppMethodBeat.o(133215);
                            return;
                        }
                        ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", Integer.valueOf(bzo.wXh.cCJ));
                        ab.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", Integer.valueOf(bzo.wYA));
                        switch (bzo.wYA) {
                            case 0:
                                if (bzo.wXh.cCJ != 0) {
                                    ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                                    intent = new Intent();
                                    intent.putExtra("intent_err_code", bzo.wXh.cCJ);
                                    intent.putExtra("intent_err_msg", bzo.wXh.cCK);
                                    AppBrandIDCardUI.this.setResult(1, intent);
                                    AppBrandIDCardUI.this.finish();
                                    AppMethodBeat.o(133215);
                                    return;
                                }
                                AppBrandIDCardUI.this.iKe = bzo;
                                AppBrandIDCardUI.e(AppBrandIDCardUI.this);
                                AppMethodBeat.o(133215);
                                return;
                            case 1:
                                ab.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", Integer.valueOf(bzo.wXh.cCJ), bzo.wXh.cCK);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                h.a(AppBrandIDCardUI.this, false, bzo.wYB.desc, bzo.wYB.title, AppBrandIDCardUI.this.getString(R.string.jg), "", new AnonymousClass2(bzo.wXh.cCJ, bzo.wXh.cCK), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                AppMethodBeat.o(133215);
                                return;
                            default:
                                ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
                                AppMethodBeat.o(133215);
                                return;
                        }
                    }
                    ab.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.fsH.fsP);
                    intent = new Intent();
                    intent.putExtra("intent_err_code", 40000);
                    intent.putExtra("intent_err_msg", "network err");
                    AppBrandIDCardUI.this.setResult(1, intent);
                    AppBrandIDCardUI.this.finish();
                    AppMethodBeat.o(133215);
                }
            });
            AppMethodBeat.o(133222);
        }

        public final void onSwipeBack() {
            AppMethodBeat.i(133223);
            AppBrandIDCardUI.this.onSwipeBack();
            AppMethodBeat.o(133223);
        }

        public final void back() {
            AppMethodBeat.i(133224);
            AppBrandIDCardUI.f(AppBrandIDCardUI.this);
            AppMethodBeat.o(133224);
        }

        public final void DW(String str) {
            AppMethodBeat.i(133225);
            ab.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
            DZ(str);
            AppMethodBeat.o(133225);
        }

        public final void DX(String str) {
            AppMethodBeat.i(133226);
            ab.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
            DZ(str);
            AppMethodBeat.o(133226);
        }

        public final void DY(String str) {
            AppMethodBeat.i(133227);
            ab.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
            DZ(str);
            AppMethodBeat.o(133227);
        }

        private void DZ(String str) {
            AppMethodBeat.i(133228);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.AppBrandIDCardUI", "url is null");
                AppMethodBeat.o(133228);
                return;
            }
            ab.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: ".concat(String.valueOf(str)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("forceHideShare", true);
            d.b(AppBrandIDCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(133228);
        }

        public final void aMF() {
            AppMethodBeat.i(133229);
            ab.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
            com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(2), AppBrandIDCardUI.this.iKe.cxb);
            if (AppBrandIDCardUI.this.iKe.wYI == null) {
                ab.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
                AppMethodBeat.o(133229);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", AppBrandIDCardUI.this.iKe.wYI.csB);
                jSONObject.put("timeStamp", AppBrandIDCardUI.this.iKe.wYI.cvO);
                jSONObject.put("nonceStr", AppBrandIDCardUI.this.iKe.wYI.wzf);
                jSONObject.put("package", AppBrandIDCardUI.this.iKe.wYI.xkV);
                jSONObject.put("signType", AppBrandIDCardUI.this.iKe.wYI.kmr);
                jSONObject.put("paySign", AppBrandIDCardUI.this.iKe.wYI.wys);
                com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(3), AppBrandIDCardUI.this.iKe.cxb);
                com.tencent.mm.plugin.appbrand.jsapi.l.a.hTJ.a(AppBrandIDCardUI.this, jSONObject, new com.tencent.mm.plugin.appbrand.jsapi.l.b.b() {
                    public final void h(boolean z, final String str) {
                        AppMethodBeat.i(133218);
                        if (z) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(4), AppBrandIDCardUI.this.iKe.cxb);
                            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                            aVar.fsJ = new cfj();
                            aVar.fsK = new cfk();
                            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                            aVar.fsI = 1721;
                            aVar.fsL = 0;
                            aVar.fsM = 0;
                            b acD = aVar.acD();
                            cfj cfj = (cfj) acD.fsG.fsP;
                            cfj.csB = AppBrandIDCardUI.this.appId;
                            cfj.wXf = AppBrandIDCardUI.this.iKg;
                            cfj.wXg = str;
                            cfj.cxb = AppBrandIDCardUI.this.iKe.cxb;
                            AppBrandIDCardUI.this.ifC.show();
                            com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                                public final void a(int i, int i2, String str, b bVar) {
                                    AppMethodBeat.i(133217);
                                    if (AppBrandIDCardUI.this.ifC != null && AppBrandIDCardUI.this.ifC.isShowing()) {
                                        AppBrandIDCardUI.this.ifC.dismiss();
                                    }
                                    if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                                        cfk cfk = (cfk) bVar.fsH.fsP;
                                        if (cfk.wXh == null) {
                                            ab.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                                            Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(R.string.jf), 0).show();
                                            AppMethodBeat.o(133217);
                                            return;
                                        }
                                        ab.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", Integer.valueOf(cfk.vIc));
                                        switch (cfk.vIc) {
                                            case 0:
                                                ab.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", cfk.wcg);
                                                com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(9), AppBrandIDCardUI.this.iKe.cxb);
                                                Intent intent = new Intent();
                                                intent.putExtra("intent_err_code", cfk.wXh.cCJ);
                                                intent.putExtra("intent_auth_token", cfk.wcg);
                                                AppBrandIDCardUI.this.setResult(-1, intent);
                                                AppBrandIDCardUI.this.finish();
                                                AppMethodBeat.o(133217);
                                                return;
                                            case 1:
                                                com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(5), AppBrandIDCardUI.this.iKe.cxb);
                                                AppBrandIDCardUI.this.iKh = str;
                                                AppBrandIDCardUI.this.iKf = cfk.xeO;
                                                AppBrandIDCardUI.h(AppBrandIDCardUI.this);
                                                break;
                                        }
                                        AppMethodBeat.o(133217);
                                        return;
                                    }
                                    ab.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.fsH.fsP);
                                    AppMethodBeat.o(133217);
                                }
                            });
                        }
                        ab.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", Boolean.valueOf(z));
                        AppMethodBeat.o(133218);
                    }
                });
                AppMethodBeat.o(133229);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
                AppMethodBeat.o(133229);
            }
        }

        public final void aMG() {
            AppMethodBeat.i(133230);
            com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(6), AppBrandIDCardUI.this.iKe.cxb);
            AppMethodBeat.o(133230);
        }

        public final void a(gc gcVar) {
            AppMethodBeat.i(133231);
            com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(7), AppBrandIDCardUI.this.iKe.cxb);
            ab.i("MicroMsg.AppBrandIDCardUI", "sendSms");
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new bwt();
            aVar.fsK = new bwu();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
            aVar.fsI = 1762;
            aVar.fsL = 0;
            aVar.fsM = 0;
            b acD = aVar.acD();
            bwt bwt = (bwt) acD.fsG.fsP;
            bwt.csB = AppBrandIDCardUI.this.appId;
            bwt.wXf = AppBrandIDCardUI.this.iKg;
            bwt.wXg = AppBrandIDCardUI.this.iKh;
            bwt.vId = gcVar.vId;
            bwt.pbn = gcVar.pbn;
            bwt.cxb = AppBrandIDCardUI.this.iKe.cxb;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    AppMethodBeat.i(133219);
                    if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                        bwu bwu = (bwu) bVar.fsH.fsP;
                        if (bwu.wXh != null) {
                            ab.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", Integer.valueOf(bwu.wXh.cCJ));
                            if (bwu.wXh.cCJ == 0) {
                                AppBrandIDCardUI.this.iKi = bwu.wXi;
                                ab.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", bwu.wXi);
                                AppMethodBeat.o(133219);
                                return;
                            }
                            AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.jl));
                            AppMethodBeat.o(133219);
                            return;
                        }
                        ab.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
                        AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.jl));
                        AppMethodBeat.o(133219);
                        return;
                    }
                    ab.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.fsH.fsP);
                    Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(R.string.jf), 0).show();
                    AppMethodBeat.o(133219);
                }
            });
            AppMethodBeat.o(133231);
        }

        public final void a(String str, gc gcVar) {
            AppMethodBeat.i(133232);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
                AppMethodBeat.o(133232);
                return;
            }
            ab.i("MicroMsg.AppBrandIDCardUI", "verifySms");
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new cnd();
            aVar.fsK = new cne();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
            aVar.fsI = 1721;
            aVar.fsL = 0;
            aVar.fsM = 0;
            b acD = aVar.acD();
            cnd cnd = (cnd) acD.fsG.fsP;
            cnd.csB = AppBrandIDCardUI.this.appId;
            cnd.wXf = AppBrandIDCardUI.this.iKg;
            cnd.wXg = AppBrandIDCardUI.this.iKh;
            cnd.vId = gcVar.vId;
            cnd.cxb = AppBrandIDCardUI.this.iKe.cxb;
            cnd.tCi = str;
            cnd.wXi = AppBrandIDCardUI.this.iKi;
            cnd.pbn = gcVar.pbn;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, b bVar) {
                    AppMethodBeat.i(133220);
                    if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                        cne cne = (cne) bVar.fsH.fsP;
                        if (cne.wXh != null) {
                            ab.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", Integer.valueOf(cne.wXh.cCJ), bo.nullAsNil(cne.wXh.cCK));
                            com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(8), AppBrandIDCardUI.this.iKe.cxb);
                            if (cne.wXh.cCJ == 0) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(9), AppBrandIDCardUI.this.iKe.cxb);
                                ab.i("MicroMsg.AppBrandIDCardUI", "verify success");
                                ab.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", cne.wcg);
                                Intent intent = new Intent();
                                intent.putExtra("intent_err_code", cne.wXh.cCJ);
                                intent.putExtra("intent_auth_token", cne.wcg);
                                AppBrandIDCardUI.this.setResult(-1, intent);
                                AppBrandIDCardUI.this.finish();
                                AppMethodBeat.o(133220);
                                return;
                            } else if (cne.wXh.cCJ == 40013) {
                                AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.jk));
                                AppMethodBeat.o(133220);
                                return;
                            } else {
                                AnonymousClass1.a(AnonymousClass1.this, AppBrandIDCardUI.this.getString(R.string.jj));
                                AppMethodBeat.o(133220);
                                return;
                            }
                        }
                        ab.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
                        AppMethodBeat.o(133220);
                        return;
                    }
                    ab.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.fsH.fsP);
                    Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(R.string.jf), 0).show();
                    AppMethodBeat.o(133220);
                }
            });
            AppMethodBeat.o(133232);
        }

        public final bzo aMH() {
            AppMethodBeat.i(133233);
            bzo g = AppBrandIDCardUI.this.iKe;
            AppMethodBeat.o(133233);
            return g;
        }

        public final gd aMI() {
            AppMethodBeat.i(133234);
            gd k = AppBrandIDCardUI.this.iKf;
            AppMethodBeat.o(133234);
            return k;
        }
    };
    public MMFragment iKd;
    private bzo iKe;
    private gd iKf;
    private LinkedList<Integer> iKg;
    private String iKh;
    private String iKi;
    private p ifC;

    public interface a {
        void DW(String str);

        void DX(String str);

        void DY(String str);

        void a(gc gcVar);

        void a(String str, gc gcVar);

        void aME();

        void aMF();

        void aMG();

        bzo aMH();

        gd aMI();

        void back();

        void onSwipeBack();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppBrandIDCardUI() {
        AppMethodBeat.i(133238);
        AppMethodBeat.o(133238);
    }

    static /* synthetic */ void e(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(133246);
        appBrandIDCardUI.aMD();
        AppMethodBeat.o(133246);
    }

    static /* synthetic */ void f(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(133247);
        appBrandIDCardUI.back();
        AppMethodBeat.o(133247);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(133239);
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        AppMethodBeat.o(133239);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133240);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            ab.e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
            finish();
            AppMethodBeat.o(133240);
            return;
        }
        this.appId = extras.getString("intent_appid", "");
        if (bo.isNullOrNil(this.appId)) {
            ab.e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
            finish();
            AppMethodBeat.o(133240);
            return;
        }
        this.iKg = D(extras);
        if (bo.ek(this.iKg) || this.iKg.size() <= 0) {
            ab.e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
            Intent intent = new Intent();
            intent.putExtra("intent_err_code", 40003);
            intent.putExtra("intent_err_msg", "category_id is null");
            setResult(1, intent);
            finish();
            AppMethodBeat.o(133240);
            return;
        }
        this.flQ = extras.getInt("intent_auth_type", 1);
        this.mController.contentView.setBackgroundColor(getResources().getColor(R.color.vy));
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(iKc);
        ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(133236);
                AppBrandIDCardUI.f(AppBrandIDCardUI.this);
                AppMethodBeat.o(133236);
                return true;
            }
        });
        getString(R.string.tz);
        this.ifC = h.b((Context) this, getString(R.string.cn5), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(133237);
                AppBrandIDCardUI.this.setResult(0);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.o(133237);
            }
        });
        this.ifC.show();
        this.iJN.aME();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(133240);
    }

    public void onBackPressed() {
        AppMethodBeat.i(133241);
        back();
        AppMethodBeat.o(133241);
    }

    private void back() {
        AppMethodBeat.i(133242);
        if (this.iKd instanceof AppBrandIDCardVerifyPwdFrag) {
            aMD();
            AppMethodBeat.o(133242);
            return;
        }
        finish();
        AppMethodBeat.o(133242);
    }

    public void onSwipeBack() {
        AppMethodBeat.i(133243);
        back();
        AppMethodBeat.o(133243);
    }

    private static LinkedList<Integer> D(Bundle bundle) {
        AppMethodBeat.i(133244);
        LinkedList linkedList = new LinkedList();
        try {
            ab.i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", bundle.getString("intent_category_id"));
            JSONArray jSONArray = new JSONArray(r1);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(Integer.valueOf(jSONArray.optInt(i)));
            }
            AppMethodBeat.o(133244);
            return linkedList;
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
            AppMethodBeat.o(133244);
            return null;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    private void aMD() {
        AppMethodBeat.i(133245);
        ab.i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
        this.iKd = new AppBrandIDCardShowFrag();
        ((AppBrandIDCardShowFrag) this.iKd).iJN = this.iJN;
        getSupportFragmentManager().beginTransaction().b(iKc, this.iKd).commitAllowingStateLoss();
        AppMethodBeat.o(133245);
    }

    public final int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void h(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.i(133248);
        ab.i("MicroMsg.AppBrandIDCardUI", "switchToVerifyFragment");
        appBrandIDCardUI.iKd = new AppBrandIDCardVerifyPwdFrag();
        ((AppBrandIDCardVerifyPwdFrag) appBrandIDCardUI.iKd).iJN = appBrandIDCardUI.iJN;
        appBrandIDCardUI.getSupportFragmentManager().beginTransaction().b(iKc, appBrandIDCardUI.iKd).commitAllowingStateLoss();
        AppMethodBeat.o(133248);
    }
}
