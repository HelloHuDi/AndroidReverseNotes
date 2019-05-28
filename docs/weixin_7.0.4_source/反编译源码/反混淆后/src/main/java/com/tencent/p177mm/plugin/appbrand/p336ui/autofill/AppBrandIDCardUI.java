package com.tencent.p177mm.plugin.appbrand.p336ui.autofill;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10445b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C42531a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15343gc;
import com.tencent.p177mm.protocal.protobuf.C46544gd;
import com.tencent.p177mm.protocal.protobuf.bwt;
import com.tencent.p177mm.protocal.protobuf.bwu;
import com.tencent.p177mm.protocal.protobuf.bzn;
import com.tencent.p177mm.protocal.protobuf.bzo;
import com.tencent.p177mm.protocal.protobuf.cfj;
import com.tencent.p177mm.protocal.protobuf.cfk;
import com.tencent.p177mm.protocal.protobuf.cnd;
import com.tencent.p177mm.protocal.protobuf.cne;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI */
public class AppBrandIDCardUI extends MMActivity {
    public static final int iKc = 2131820557;
    private String appId;
    private int flQ;
    private C10825a iJN = new C108151();
    public MMFragment iKd;
    private bzo iKe;
    private C46544gd iKf;
    private LinkedList<Integer> iKg;
    private String iKh;
    private String iKi;
    private C44275p ifC;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1 */
    class C108151 implements C10825a {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$8 */
        class C108148 implements OnClickListener {
            C108148() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$5 */
        class C108165 implements C9557a {
            C108165() {
            }

            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(133219);
                if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                    bwu bwu = (bwu) c7472b.fsH.fsP;
                    if (bwu.wXh != null) {
                        C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", Integer.valueOf(bwu.wXh.cCJ));
                        if (bwu.wXh.cCJ == 0) {
                            AppBrandIDCardUI.this.iKi = bwu.wXi;
                            C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", bwu.wXi);
                            AppMethodBeat.m2505o(133219);
                            return;
                        }
                        C108151.m18515a(C108151.this, AppBrandIDCardUI.this.getString(C25738R.string.f8926jl));
                        AppMethodBeat.m2505o(133219);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
                    C108151.m18515a(C108151.this, AppBrandIDCardUI.this.getString(C25738R.string.f8926jl));
                    AppMethodBeat.m2505o(133219);
                    return;
                }
                C4990ab.m7413e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, c7472b.fsH.fsP);
                Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(C25738R.string.f8920jf), 0).show();
                AppMethodBeat.m2505o(133219);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$4 */
        class C108174 implements C10445b {
            C108174() {
            }

            /* renamed from: h */
            public final void mo21961h(boolean z, final String str) {
                AppMethodBeat.m2504i(133218);
                if (z) {
                    C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(4), AppBrandIDCardUI.this.iKe.cxb);
                    C1196a c1196a = new C1196a();
                    c1196a.fsJ = new cfj();
                    c1196a.fsK = new cfk();
                    c1196a.uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
                    c1196a.fsI = 1721;
                    c1196a.fsL = 0;
                    c1196a.fsM = 0;
                    C7472b acD = c1196a.acD();
                    cfj cfj = (cfj) acD.fsG.fsP;
                    cfj.csB = AppBrandIDCardUI.this.appId;
                    cfj.wXf = AppBrandIDCardUI.this.iKg;
                    cfj.wXg = str;
                    cfj.cxb = AppBrandIDCardUI.this.iKe.cxb;
                    AppBrandIDCardUI.this.ifC.show();
                    C42146b.m74301a(acD, new C9557a() {
                        /* renamed from: a */
                        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                            AppMethodBeat.m2504i(133217);
                            if (AppBrandIDCardUI.this.ifC != null && AppBrandIDCardUI.this.ifC.isShowing()) {
                                AppBrandIDCardUI.this.ifC.dismiss();
                            }
                            if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                                cfk cfk = (cfk) c7472b.fsH.fsP;
                                if (cfk.wXh == null) {
                                    C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                                    Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(C25738R.string.f8920jf), 0).show();
                                    AppMethodBeat.m2505o(133217);
                                    return;
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", Integer.valueOf(cfk.vIc));
                                switch (cfk.vIc) {
                                    case 0:
                                        C4990ab.m7411d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", cfk.wcg);
                                        C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(9), AppBrandIDCardUI.this.iKe.cxb);
                                        Intent intent = new Intent();
                                        intent.putExtra("intent_err_code", cfk.wXh.cCJ);
                                        intent.putExtra("intent_auth_token", cfk.wcg);
                                        AppBrandIDCardUI.this.setResult(-1, intent);
                                        AppBrandIDCardUI.this.finish();
                                        AppMethodBeat.m2505o(133217);
                                        return;
                                    case 1:
                                        C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(5), AppBrandIDCardUI.this.iKe.cxb);
                                        AppBrandIDCardUI.this.iKh = str;
                                        AppBrandIDCardUI.this.iKf = cfk.xeO;
                                        AppBrandIDCardUI.m18510h(AppBrandIDCardUI.this);
                                        break;
                                }
                                AppMethodBeat.m2505o(133217);
                                return;
                            }
                            C4990ab.m7413e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, c7472b.fsH.fsP);
                            AppMethodBeat.m2505o(133217);
                        }
                    });
                }
                C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", Boolean.valueOf(z));
                AppMethodBeat.m2505o(133218);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$6 */
        class C108196 implements C9557a {
            C108196() {
            }

            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(133220);
                if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                    cne cne = (cne) c7472b.fsH.fsP;
                    if (cne.wXh != null) {
                        C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", Integer.valueOf(cne.wXh.cCJ), C5046bo.nullAsNil(cne.wXh.cCK));
                        C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(8), AppBrandIDCardUI.this.iKe.cxb);
                        if (cne.wXh.cCJ == 0) {
                            C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(9), AppBrandIDCardUI.this.iKe.cxb);
                            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "verify success");
                            C4990ab.m7411d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", cne.wcg);
                            Intent intent = new Intent();
                            intent.putExtra("intent_err_code", cne.wXh.cCJ);
                            intent.putExtra("intent_auth_token", cne.wcg);
                            AppBrandIDCardUI.this.setResult(-1, intent);
                            AppBrandIDCardUI.this.finish();
                            AppMethodBeat.m2505o(133220);
                            return;
                        } else if (cne.wXh.cCJ == 40013) {
                            C108151.m18515a(C108151.this, AppBrandIDCardUI.this.getString(C25738R.string.f8925jk));
                            AppMethodBeat.m2505o(133220);
                            return;
                        } else {
                            C108151.m18515a(C108151.this, AppBrandIDCardUI.this.getString(C25738R.string.f8924jj));
                            AppMethodBeat.m2505o(133220);
                            return;
                        }
                    }
                    C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
                    AppMethodBeat.m2505o(133220);
                    return;
                }
                C4990ab.m7413e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, c7472b.fsH.fsP);
                Toast.makeText(AppBrandIDCardUI.this, AppBrandIDCardUI.this.getString(C25738R.string.f8920jf), 0).show();
                AppMethodBeat.m2505o(133220);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$7 */
        class C108207 implements OnClickListener {
            C108207() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(133221);
                C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "[showVerifySmsAlert] btn click");
                AppMethodBeat.m2505o(133221);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$1 */
        class C108211 implements C9557a {
            C108211() {
            }

            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(133215);
                if (AppBrandIDCardUI.this.ifC != null && AppBrandIDCardUI.this.ifC.isShowing()) {
                    AppBrandIDCardUI.this.ifC.dismiss();
                }
                Intent intent;
                if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                    bzo bzo = (bzo) c7472b.fsH.fsP;
                    if (bzo.wXh == null) {
                        C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                        intent = new Intent();
                        intent.putExtra("intent_err_code", 40000);
                        intent.putExtra("intent_err_msg", "network err");
                        AppBrandIDCardUI.this.setResult(1, intent);
                        AppBrandIDCardUI.this.finish();
                        AppMethodBeat.m2505o(133215);
                        return;
                    }
                    C4990ab.m7413e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", Integer.valueOf(bzo.wXh.cCJ));
                    C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", Integer.valueOf(bzo.wYA));
                    switch (bzo.wYA) {
                        case 0:
                            if (bzo.wXh.cCJ != 0) {
                                C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                                intent = new Intent();
                                intent.putExtra("intent_err_code", bzo.wXh.cCJ);
                                intent.putExtra("intent_err_msg", bzo.wXh.cCK);
                                AppBrandIDCardUI.this.setResult(1, intent);
                                AppBrandIDCardUI.this.finish();
                                AppMethodBeat.m2505o(133215);
                                return;
                            }
                            AppBrandIDCardUI.this.iKe = bzo;
                            AppBrandIDCardUI.m18507e(AppBrandIDCardUI.this);
                            AppMethodBeat.m2505o(133215);
                            return;
                        case 1:
                            C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", Integer.valueOf(bzo.wXh.cCJ), bzo.wXh.cCK);
                            C108151 c108151 = C108151.this;
                            C30379h.m48453a(AppBrandIDCardUI.this, false, bzo.wYB.desc, bzo.wYB.title, AppBrandIDCardUI.this.getString(C25738R.string.f8921jg), "", new C108232(bzo.wXh.cCJ, bzo.wXh.cCK), new C108223());
                            AppMethodBeat.m2505o(133215);
                            return;
                        default:
                            C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
                            AppMethodBeat.m2505o(133215);
                            return;
                    }
                }
                C4990ab.m7413e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, c7472b.fsH.fsP);
                intent = new Intent();
                intent.putExtra("intent_err_code", 40000);
                intent.putExtra("intent_err_msg", "network err");
                AppBrandIDCardUI.this.setResult(1, intent);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.m2505o(133215);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$3 */
        class C108223 implements OnClickListener {
            C108223() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$1$2 */
        class C108232 implements OnClickListener {
            final /* synthetic */ int crd;
            final /* synthetic */ String ftO;

            C108232(int i, String str) {
                this.crd = i;
                this.ftO = str;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(133216);
                Intent intent = new Intent();
                intent.putExtra("intent_err_code", C5046bo.m7550g(Integer.valueOf(this.crd), 0));
                intent.putExtra("intent_err_msg", C5046bo.nullAsNil(this.ftO));
                AppBrandIDCardUI.this.setResult(1, intent);
                AppBrandIDCardUI.this.finish();
                AppMethodBeat.m2505o(133216);
            }
        }

        C108151() {
        }

        public final void aME() {
            AppMethodBeat.m2504i(133222);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new bzn();
            c1196a.fsK = new bzo();
            c1196a.uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
            c1196a.fsI = 1774;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            bzn bzn = (bzn) acD.fsG.fsP;
            bzn.csB = AppBrandIDCardUI.this.appId;
            bzn.wXf = AppBrandIDCardUI.this.iKg;
            bzn.wYz = AppBrandIDCardUI.this.flQ;
            C42146b.m74301a(acD, new C108211());
            AppMethodBeat.m2505o(133222);
        }

        public final void onSwipeBack() {
            AppMethodBeat.m2504i(133223);
            AppBrandIDCardUI.this.onSwipeBack();
            AppMethodBeat.m2505o(133223);
        }

        public final void back() {
            AppMethodBeat.m2504i(133224);
            AppBrandIDCardUI.m18508f(AppBrandIDCardUI.this);
            AppMethodBeat.m2505o(133224);
        }

        /* renamed from: DW */
        public final void mo22364DW(String str) {
            AppMethodBeat.m2504i(133225);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
            m18514DZ(str);
            AppMethodBeat.m2505o(133225);
        }

        /* renamed from: DX */
        public final void mo22365DX(String str) {
            AppMethodBeat.m2504i(133226);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "urlJump click");
            m18514DZ(str);
            AppMethodBeat.m2505o(133226);
        }

        /* renamed from: DY */
        public final void mo22366DY(String str) {
            AppMethodBeat.m2504i(133227);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
            m18514DZ(str);
            AppMethodBeat.m2505o(133227);
        }

        /* renamed from: DZ */
        private void m18514DZ(String str) {
            AppMethodBeat.m2504i(133228);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "url is null");
                AppMethodBeat.m2505o(133228);
                return;
            }
            C4990ab.m7418v("MicroMsg.AppBrandIDCardUI", "goToWebview url: ".concat(String.valueOf(str)));
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("forceHideShare", true);
            C25985d.m41467b(AppBrandIDCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(133228);
        }

        public final void aMF() {
            AppMethodBeat.m2504i(133229);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
            C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(2), AppBrandIDCardUI.this.iKe.cxb);
            if (AppBrandIDCardUI.this.iKe.wYI == null) {
                C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
                AppMethodBeat.m2505o(133229);
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
                C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(3), AppBrandIDCardUI.this.iKe.cxb);
                C42531a.hTJ.mo67991a(AppBrandIDCardUI.this, jSONObject, new C108174());
                AppMethodBeat.m2505o(133229);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(133229);
            }
        }

        public final void aMG() {
            AppMethodBeat.m2504i(133230);
            C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(6), AppBrandIDCardUI.this.iKe.cxb);
            AppMethodBeat.m2505o(133230);
        }

        /* renamed from: a */
        public final void mo22367a(C15343gc c15343gc) {
            AppMethodBeat.m2504i(133231);
            C7060h.pYm.mo8381e(14943, AppBrandIDCardUI.this.appId, Integer.valueOf(7), AppBrandIDCardUI.this.iKe.cxb);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "sendSms");
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new bwt();
            c1196a.fsK = new bwu();
            c1196a.uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
            c1196a.fsI = 1762;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            bwt bwt = (bwt) acD.fsG.fsP;
            bwt.csB = AppBrandIDCardUI.this.appId;
            bwt.wXf = AppBrandIDCardUI.this.iKg;
            bwt.wXg = AppBrandIDCardUI.this.iKh;
            bwt.vId = c15343gc.vId;
            bwt.pbn = c15343gc.pbn;
            bwt.cxb = AppBrandIDCardUI.this.iKe.cxb;
            C42146b.m74301a(acD, new C108165());
            AppMethodBeat.m2505o(133231);
        }

        /* renamed from: a */
        public final void mo22368a(String str, C15343gc c15343gc) {
            AppMethodBeat.m2504i(133232);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
                AppMethodBeat.m2505o(133232);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "verifySms");
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new cnd();
            c1196a.fsK = new cne();
            c1196a.uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
            c1196a.fsI = 1721;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            cnd cnd = (cnd) acD.fsG.fsP;
            cnd.csB = AppBrandIDCardUI.this.appId;
            cnd.wXf = AppBrandIDCardUI.this.iKg;
            cnd.wXg = AppBrandIDCardUI.this.iKh;
            cnd.vId = c15343gc.vId;
            cnd.cxb = AppBrandIDCardUI.this.iKe.cxb;
            cnd.tCi = str;
            cnd.wXi = AppBrandIDCardUI.this.iKi;
            cnd.pbn = c15343gc.pbn;
            C42146b.m74301a(acD, new C108196());
            AppMethodBeat.m2505o(133232);
        }

        public final bzo aMH() {
            AppMethodBeat.m2504i(133233);
            bzo g = AppBrandIDCardUI.this.iKe;
            AppMethodBeat.m2505o(133233);
            return g;
        }

        public final C46544gd aMI() {
            AppMethodBeat.m2504i(133234);
            C46544gd k = AppBrandIDCardUI.this.iKf;
            AppMethodBeat.m2505o(133234);
            return k;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$2 */
    class C108242 implements OnMenuItemClickListener {
        C108242() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(133236);
            AppBrandIDCardUI.m18508f(AppBrandIDCardUI.this);
            AppMethodBeat.m2505o(133236);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$a */
    public interface C10825a {
        /* renamed from: DW */
        void mo22364DW(String str);

        /* renamed from: DX */
        void mo22365DX(String str);

        /* renamed from: DY */
        void mo22366DY(String str);

        /* renamed from: a */
        void mo22367a(C15343gc c15343gc);

        /* renamed from: a */
        void mo22368a(String str, C15343gc c15343gc);

        void aME();

        void aMF();

        void aMG();

        bzo aMH();

        C46544gd aMI();

        void back();

        void onSwipeBack();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI$3 */
    class C108263 implements OnCancelListener {
        C108263() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(133237);
            AppBrandIDCardUI.this.setResult(0);
            AppBrandIDCardUI.this.finish();
            AppMethodBeat.m2505o(133237);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppBrandIDCardUI() {
        AppMethodBeat.m2504i(133238);
        AppMethodBeat.m2505o(133238);
    }

    /* renamed from: e */
    static /* synthetic */ void m18507e(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.m2504i(133246);
        appBrandIDCardUI.aMD();
        AppMethodBeat.m2505o(133246);
    }

    /* renamed from: f */
    static /* synthetic */ void m18508f(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.m2504i(133247);
        appBrandIDCardUI.back();
        AppMethodBeat.m2505o(133247);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(133239);
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        AppMethodBeat.m2505o(133239);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133240);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "bundle is null, return");
            finish();
            AppMethodBeat.m2505o(133240);
            return;
        }
        this.appId = extras.getString("intent_appid", "");
        if (C5046bo.isNullOrNil(this.appId)) {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "appId is null, return");
            finish();
            AppMethodBeat.m2505o(133240);
            return;
        }
        this.iKg = AppBrandIDCardUI.m18498D(extras);
        if (C5046bo.m7548ek(this.iKg) || this.iKg.size() <= 0) {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardUI", "categoryId is null, return");
            Intent intent = new Intent();
            intent.putExtra("intent_err_code", 40003);
            intent.putExtra("intent_err_msg", "category_id is null");
            setResult(1, intent);
            finish();
            AppMethodBeat.m2505o(133240);
            return;
        }
        this.flQ = extras.getInt("intent_auth_type", 1);
        this.mController.contentView.setBackgroundColor(getResources().getColor(C25738R.color.f12206vy));
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(iKc);
        ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
        setBackBtn(new C108242());
        getString(C25738R.string.f9238tz);
        this.ifC = C30379h.m48458b((Context) this, getString(C25738R.string.cn5), true, new C108263());
        this.ifC.show();
        this.iJN.aME();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.m2505o(133240);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(133241);
        back();
        AppMethodBeat.m2505o(133241);
    }

    private void back() {
        AppMethodBeat.m2504i(133242);
        if (this.iKd instanceof AppBrandIDCardVerifyPwdFrag) {
            aMD();
            AppMethodBeat.m2505o(133242);
            return;
        }
        finish();
        AppMethodBeat.m2505o(133242);
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(133243);
        back();
        AppMethodBeat.m2505o(133243);
    }

    /* renamed from: D */
    private static LinkedList<Integer> m18498D(Bundle bundle) {
        AppMethodBeat.m2504i(133244);
        LinkedList linkedList = new LinkedList();
        try {
            C4990ab.m7417i("MicroMsg.AppBrandIDCardUI", "[processCategoryId] categoryIdStr:%s", bundle.getString("intent_category_id"));
            JSONArray jSONArray = new JSONArray(r1);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(Integer.valueOf(jSONArray.optInt(i)));
            }
            AppMethodBeat.m2505o(133244);
            return linkedList;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(133244);
            return null;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    private void aMD() {
        AppMethodBeat.m2504i(133245);
        C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "switchToShowFragment");
        this.iKd = new AppBrandIDCardShowFrag();
        ((AppBrandIDCardShowFrag) this.iKd).iJN = this.iJN;
        getSupportFragmentManager().beginTransaction().mo556b(iKc, this.iKd).commitAllowingStateLoss();
        AppMethodBeat.m2505o(133245);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: h */
    static /* synthetic */ void m18510h(AppBrandIDCardUI appBrandIDCardUI) {
        AppMethodBeat.m2504i(133248);
        C4990ab.m7416i("MicroMsg.AppBrandIDCardUI", "switchToVerifyFragment");
        appBrandIDCardUI.iKd = new AppBrandIDCardVerifyPwdFrag();
        ((AppBrandIDCardVerifyPwdFrag) appBrandIDCardUI.iKd).iJN = appBrandIDCardUI.iJN;
        appBrandIDCardUI.getSupportFragmentManager().beginTransaction().mo556b(iKc, appBrandIDCardUI.iKd).commitAllowingStateLoss();
        AppMethodBeat.m2505o(133248);
    }
}
