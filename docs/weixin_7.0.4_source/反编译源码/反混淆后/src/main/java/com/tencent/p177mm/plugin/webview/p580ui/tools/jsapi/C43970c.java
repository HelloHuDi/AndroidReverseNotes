package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.model.C40266q;
import com.tencent.p177mm.plugin.webview.model.C40267s;
import com.tencent.p177mm.plugin.webview.model.C46425r;
import com.tencent.p177mm.plugin.webview.model.C46426t;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.p177mm.protocal.C15045c;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.protobuf.avf;
import com.tencent.p177mm.protocal.protobuf.avg;
import com.tencent.p177mm.protocal.protobuf.avh;
import com.tencent.p177mm.protocal.protobuf.avo;
import com.tencent.p177mm.protocal.protobuf.avp;
import com.tencent.p177mm.protocal.protobuf.avr;
import com.tencent.p177mm.protocal.protobuf.avs;
import com.tencent.p177mm.protocal.protobuf.awg;
import com.tencent.p177mm.protocal.protobuf.cmu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.c */
public final class C43970c implements C1202f {
    private Context context;
    private final HashMap<String, avf> uFb = new HashMap();
    private final HashMap<String, String> uFc = new HashMap();
    final HashMap<String, C22988d> ujx = new HashMap();
    final int ulX;
    private C40281e umI;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.c$d */
    public static class C22988d {
        public String appId;
        public List<String> uFm;
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.c$b */
    public interface C29934b {
        int cXz();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.c$c */
    public static abstract class C29935c implements C43969a {
        public boolean uFl = true;

        public boolean dcf() {
            return this.uFl;
        }

        /* renamed from: nY */
        public final void mo48182nY(boolean z) {
            this.uFl = z;
        }

        public void agk(String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a */
    public interface C43969a {

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.c$a$a */
        public enum C29933a {
            RET_OK(0),
            RET_FAIL(-1),
            RET_REJECT(-2),
            RET_ACCESS_DENIED(-3);
            
            private int code;

            static {
                AppMethodBeat.m2505o(8856);
            }

            private C29933a(int i) {
                this.code = i;
            }

            public final int getCode() {
                return this.code;
            }
        }

        /* renamed from: a */
        void mo26895a(C29933a c29933a, String str, LinkedList<cmu> linkedList, int i, int i2);

        void agk(String str);
    }

    public final String agj(String str) {
        AppMethodBeat.m2504i(8857);
        if (str == null) {
            AppMethodBeat.m2505o(8857);
            return null;
        }
        String str2 = (String) this.uFc.get(str);
        if (C5046bo.isNullOrNil(str2)) {
            String aef = C43970c.aef(str);
            C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", str2, str, aef);
            if (!C5046bo.isNullOrNil(aef)) {
                str2 = (String) this.uFc.get(aef);
            }
        }
        AppMethodBeat.m2505o(8857);
        return str2;
    }

    public C43970c(int i) {
        AppMethodBeat.m2504i(8858);
        this.ulX = i;
        AppMethodBeat.m2505o(8858);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo69643a(Context context, C40281e c40281e) {
        this.context = context;
        this.umI = c40281e;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(8859);
        C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(c1207m instanceof C29934b)) {
            C4990ab.m7416i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
            AppMethodBeat.m2505o(8859);
        } else if (((C29934b) c1207m).cXz() != this.ulX) {
            C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", Integer.valueOf(this.ulX), Integer.valueOf(((C29934b) c1207m).cXz()));
            AppMethodBeat.m2505o(8859);
        } else {
            int type = c1207m.getType();
            if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI) {
                C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI, (C1202f) this);
                C46425r c46425r = (C46425r) c1207m;
                if (c46425r == null) {
                    C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "");
                    AppMethodBeat.m2505o(8859);
                } else if (c46425r.ulV == null) {
                    C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                    AppMethodBeat.m2505o(8859);
                } else {
                    int i3 = 0;
                    if (!(c46425r.cXA() == null || c46425r.cXA().wzj == null)) {
                        i3 = c46425r.cXA().wzj.cyE;
                    }
                    if (i == 0 && i2 == 0) {
                        avo avo;
                        avp cXA = c46425r.cXA();
                        if (c46425r.ehh == null) {
                            avo = null;
                        } else {
                            avo = (avo) c46425r.ehh.fsG.fsP;
                        }
                        if (cXA == null || C5046bo.isNullOrNil(c46425r.iCz) || avo == null || C5046bo.isNullOrNil(avo.csB)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(cXA == null);
                            objArr[1] = Boolean.valueOf(C5046bo.isNullOrNil(c46425r.iCz));
                            objArr[2] = Boolean.valueOf(avo == null);
                            C4990ab.m7413e(str2, str3, objArr);
                            c46425r.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
                            AppMethodBeat.m2505o(8859);
                        } else if (cXA.wzj == null) {
                            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            c46425r.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
                            AppMethodBeat.m2505o(8859);
                        } else if (cXA.wzj.cyE != 0) {
                            C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", Integer.valueOf(cXA.wzj.cyE), cXA.wzj.cyF);
                            c46425r.ulV.mo26895a(C29933a.RET_FAIL, cXA.wzj.cyF, null, i2, i3);
                            AppMethodBeat.m2505o(8859);
                        } else {
                            c46425r.ulV.agk(cXA.wzB);
                            this.uFc.put(C43970c.aef(avo.url), avo.csB);
                            C22988d c22988d = new C22988d();
                            c22988d.appId = avo.csB;
                            c22988d.uFm = cXA.wzA;
                            this.ujx.put(C43970c.aef(avo.url), c22988d);
                            c46425r.ulV.mo26895a(C29933a.RET_OK, null, cXA.wzz, i2, i3);
                            C4990ab.m7411d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", avo.url);
                            AppMethodBeat.m2505o(8859);
                        }
                    } else if (i == 4) {
                        c46425r.ulV.mo26895a(C29933a.RET_FAIL, i2 + "_" + str, null, i2, i3);
                        AppMethodBeat.m2505o(8859);
                    } else {
                        c46425r.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
                        AppMethodBeat.m2505o(8859);
                    }
                }
            } else if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG) {
                C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG, (C1202f) this);
                m78909a(i, i2, str, (C40266q) c1207m);
                AppMethodBeat.m2505o(8859);
            } else if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING) {
                C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING, (C1202f) this);
                C40267s c40267s = (C40267s) c1207m;
                if (c40267s == null) {
                    C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    AppMethodBeat.m2505o(8859);
                    return;
                }
                int i4;
                C7060h.pYm.mo8378a(157, 24, 1, false);
                if (c40267s.cXB() == null || c40267s.cXB().wzj == null) {
                    i4 = 0;
                } else {
                    i4 = c40267s.cXB().wzj.cyE;
                }
                if (i == 0 && i2 == 0) {
                    avr cXB = c40267s.cXB();
                    if (cXB == null || cXB.wzj == null) {
                        C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        c40267s.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i4);
                        AppMethodBeat.m2505o(8859);
                        return;
                    } else if (cXB.wzj.cyE != 0) {
                        C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", Integer.valueOf(cXB.wzj.cyE), cXB.wzj.cyF);
                        c40267s.ulV.mo26895a(C29933a.RET_FAIL, cXB.wzj.cyF, null, i2, i4);
                        AppMethodBeat.m2505o(8859);
                        return;
                    } else {
                        cmu cmu = cXB.wzC;
                        if (cmu == null) {
                            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            c40267s.ulV.mo26895a(C29933a.RET_FAIL, "verifyFail", null, i2, i4);
                            AppMethodBeat.m2505o(8859);
                            return;
                        } else if (cmu.xkt != 1) {
                            C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", Integer.valueOf(cmu.xkt));
                            c40267s.ulV.mo26895a(C29933a.RET_FAIL, "verifyFail", null, i2, i4);
                            AppMethodBeat.m2505o(8859);
                            return;
                        } else {
                            c40267s.ulV.mo26895a(C29933a.RET_OK, null, null, i2, i4);
                            AppMethodBeat.m2505o(8859);
                            return;
                        }
                    }
                }
                C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", Integer.valueOf(i), Integer.valueOf(i2));
                C7060h.pYm.mo8378a(157, 25, 1, false);
                if (i == 4) {
                    c40267s.ulV.mo26895a(C29933a.RET_FAIL, i2 + "_" + str, null, i2, i4);
                    AppMethodBeat.m2505o(8859);
                    return;
                }
                c40267s.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i4);
                AppMethodBeat.m2505o(8859);
            } else {
                if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING) {
                    avs avs;
                    C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING, (C1202f) this);
                    C46426t c46426t = (C46426t) c1207m;
                    if (c46426t.ehh == null) {
                        avs = null;
                    } else {
                        avs = (avs) c46426t.ehh.fsG.fsP;
                    }
                    if (avs == null) {
                        C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                        AppMethodBeat.m2505o(8859);
                        return;
                    } else if (i != 0 || i2 != 0) {
                        C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", Integer.valueOf(i), Integer.valueOf(i2), avs.wzd);
                        AppMethodBeat.m2505o(8859);
                        return;
                    } else if (C15045c.akD(C5046bo.nullAsNil(avs.wzd)) == null) {
                        C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", Integer.valueOf(i), Integer.valueOf(i2));
                        AppMethodBeat.m2505o(8859);
                        return;
                    } else {
                        avf avf = ((C46426t) c1207m).ulY;
                        avf.vIc = 1;
                        this.uFb.put(avs.wzd + avs.url, avf);
                    }
                }
                AppMethodBeat.m2505o(8859);
            }
        }
    }

    /* renamed from: a */
    public final void mo69645a(JsapiPermissionWrapper jsapiPermissionWrapper, String str, int i, C29945i c29945i, C43969a c43969a) {
        AppMethodBeat.m2504i(8860);
        String str2 = "";
        if (c29945i != null) {
            str2 = c29945i.uIJ;
        }
        String str3;
        String str4;
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", str);
            c43969a.mo26895a(C29933a.RET_ACCESS_DENIED, null, null, 0, 0);
            AppMethodBeat.m2505o(8860);
        } else if (jsapiPermissionWrapper == null || C5046bo.isNullOrNil(str) || c29945i == null || jsapiPermissionWrapper.vxM == null) {
            str3 = "MicroMsg.webview.JSVerifyHelper";
            str4 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Boolean.valueOf(jsapiPermissionWrapper != null);
            C4990ab.m7413e(str3, str4, objArr);
            c43969a.mo26895a(C29933a.RET_FAIL, "localParameters", null, 0, 0);
            AppMethodBeat.m2505o(8860);
        } else {
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            int Lx = jsapiPermissionWrapper.mo69828Lx(i);
            C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", str2, Integer.valueOf(i), Integer.valueOf(Lx), str);
            String str10 = (String) this.uFc.get(str);
            if (C5046bo.isNullOrNil(str10)) {
                str5 = (String) c29945i.puc.get("verifyAppId");
            } else {
                str5 = str10;
            }
            Map map = c29945i.uII;
            map.put("permissionValue", Integer.valueOf(Lx));
            map.put("appId", str5);
            switch (Lx) {
                case 0:
                    c43969a.mo26895a(C29933a.RET_ACCESS_DENIED, null, null, 0, 0);
                    AppMethodBeat.m2505o(8860);
                    return;
                case 1:
                    c43969a.mo26895a(C29933a.RET_OK, null, null, 0, 0);
                    AppMethodBeat.m2505o(8860);
                    return;
                case 2:
                    if (str2.equals("preVerifyJSAPI")) {
                        c43969a.mo26895a(C29933a.RET_OK, null, null, 0, 0);
                        AppMethodBeat.m2505o(8860);
                        return;
                    }
                    c43969a.mo26895a(C29933a.RET_ACCESS_DENIED, null, null, 0, 0);
                    AppMethodBeat.m2505o(8860);
                    return;
                case 3:
                    break;
                case 4:
                    avf avf = (avf) this.uFb.get(str2 + str);
                    if (avf != null && avf.vIc == 1) {
                        c43969a.mo26895a(C29933a.RET_OK, null, null, 0, 0);
                        AppMethodBeat.m2505o(8860);
                        return;
                    }
            }
            str10 = (String) c29945i.puc.get("verifySignature");
            str3 = (String) c29945i.puc.get("verifyNonceStr");
            str4 = (String) c29945i.puc.get("verifyTimestamp");
            String str11 = (String) c29945i.puc.get("verifySignType");
            String str12 = (String) c29945i.puc.get("scope");
            C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", (String) c29945i.puc.get("addrSign"), str10);
            int i2 = 0;
            if (C5046bo.isNullOrNil(str10) && !C5046bo.isNullOrNil(r4)) {
                i2 = 1;
                str6 = (String) c29945i.puc.get("timeStamp");
                str7 = (String) c29945i.puc.get("nonceStr");
                str11 = (String) c29945i.puc.get("signType");
                str8 = (String) c29945i.puc.get("addrSign");
                str9 = (String) c29945i.puc.get("appId");
            } else if (C5046bo.isNullOrNil(str10)) {
                str6 = str4;
                str7 = str3;
                str8 = str10;
                str9 = str5;
            } else {
                i2 = 2;
                str6 = str4;
                str7 = str3;
                str8 = str10;
                str9 = str5;
            }
            byte[] bArr = null;
            JSONObject ao = C23124a.m35499ao(c29945i.puc);
            if (ao != null) {
                bArr = ao.toString().getBytes();
            }
            C1207m c40266q;
            if (Lx == 4) {
                c40266q = new C40266q(c43969a, str, str9, str2, str6, str7, str8, str11, bArr, i2, str12, this.ulX);
                C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG, (C1202f) this);
                C1720g.m3540Rg().mo14541a(c40266q, 0);
                AppMethodBeat.m2505o(8860);
                return;
            }
            if (Lx == 3) {
                c40266q = new C40267s(c43969a, str, str9, str2, str6, str7, str8, str11, bArr, this.ulX);
                C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING, (C1202f) this);
                C1720g.m3540Rg().mo14541a(c40266q, 0);
                AppMethodBeat.m2505o(8860);
                return;
            }
            c43969a.mo26895a(C29933a.RET_FAIL, "unkonwPermission_".concat(String.valueOf(Lx)), null, 0, 0);
            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
            AppMethodBeat.m2505o(8860);
        }
    }

    /* renamed from: a */
    private void m78909a(int i, final int i2, String str, final C40266q c40266q) {
        AppMethodBeat.m2504i(8861);
        if (c40266q == null) {
            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            AppMethodBeat.m2505o(8861);
            return;
        }
        int i3 = 0;
        if (!(c40266q.cXy() == null || c40266q.cXy().wzj == null)) {
            i3 = c40266q.cXy().wzj.cyE;
        }
        if (i != 0 || i2 != 0) {
            C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 4) {
                c40266q.ulV.mo26895a(C29933a.RET_FAIL, str, null, i2, i3);
                AppMethodBeat.m2505o(8861);
                return;
            }
            c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
            AppMethodBeat.m2505o(8861);
        } else if (C5046bo.isNullOrNil(c40266q.ulW)) {
            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
            AppMethodBeat.m2505o(8861);
        } else {
            avh cXy = c40266q.cXy();
            if (cXy == null || cXy.wzj == null) {
                C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
                AppMethodBeat.m2505o(8861);
            } else if (cXy.wzj.cyE != 0) {
                C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", Integer.valueOf(cXy.wzj.cyE), cXy.wzj.cyF);
                c40266q.ulV.mo26895a(C29933a.RET_FAIL, cXy.wzj.cyF, null, i2, i3);
                AppMethodBeat.m2505o(8861);
            } else {
                C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", Integer.valueOf(c40266q.cXx() == null ? 0 : c40266q.cXx().wzi));
                if ((c40266q.cXx() == null ? 0 : c40266q.cXx().wzi) == 1) {
                    if (cXy.wzm == null) {
                        C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
                        AppMethodBeat.m2505o(8861);
                        return;
                    }
                    Iterator it = cXy.wzm.iterator();
                    while (it.hasNext()) {
                        awg awg = (awg) it.next();
                        if (awg.wzX == null) {
                            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = awg.wzX.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!C5046bo.isNullOrNil(str2)) {
                                    avf avf = new avf();
                                    avf.wzd = str2;
                                    avf.vIc = awg.wzW;
                                    avf.wze = awg.qkh;
                                    this.uFb.put(avf.wzd + c40266q.url, avf);
                                }
                            }
                        }
                    }
                } else if (cXy.wzk == null) {
                    C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    c40266q.ulV.mo26895a(C29933a.RET_FAIL, "nullAuthInfo", null, i2, i3);
                    AppMethodBeat.m2505o(8861);
                    return;
                } else {
                    Iterator it3 = cXy.wzk.iterator();
                    while (it3.hasNext()) {
                        avf avf2 = (avf) it3.next();
                        if (!C5046bo.isNullOrNil(avf2.wzd)) {
                            this.uFb.put(avf2.wzd + c40266q.url, avf2);
                        }
                    }
                }
                final avf avf3 = (avf) this.uFb.get(c40266q.ulW + c40266q.url);
                if (avf3 == null) {
                    C4990ab.m7413e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", c40266q.ulW, c40266q.url);
                    c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i2, i3);
                    AppMethodBeat.m2505o(8861);
                } else if (avf3.vIc == 1) {
                    c40266q.ulV.mo26895a(C29933a.RET_OK, null, null, i2, i3);
                    AppMethodBeat.m2505o(8861);
                } else if (this.context == null) {
                    C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    mo69644a(c40266q, i2, avf3);
                    AppMethodBeat.m2505o(8861);
                } else {
                    WebViewStubTempUI.m69059a(this.context, this.umI, C5046bo.nullAsNil(avf3.wze), "", this.context.getString(C25738R.string.ckc), this.context.getString(C25738R.string.ckb), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(8852);
                            C4990ab.m7416i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
                            C43970c.this.mo69644a(c40266q, i2, avf3);
                            AppMethodBeat.m2505o(8852);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(8853);
                            C4990ab.m7416i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
                            c40266q.ulV.mo26895a(C29933a.RET_REJECT, "cancel", null, i2, c40266q.cXy().wzj.cyE);
                            AppMethodBeat.m2505o(8853);
                        }
                    });
                    AppMethodBeat.m2505o(8861);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo69644a(C40266q c40266q, int i, avf avf) {
        AppMethodBeat.m2504i(8862);
        avg cXx = c40266q.cXx();
        avh cXy = c40266q.cXy();
        if (cXx == null) {
            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i, c40266q.cXy().wzj.cyE);
            AppMethodBeat.m2505o(8862);
        } else if (cXy == null) {
            C4990ab.m7412e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            c40266q.ulV.mo26895a(C29933a.RET_FAIL, null, null, i, c40266q.cXy().wzj.cyE);
            AppMethodBeat.m2505o(8862);
        } else {
            C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING, (C1202f) this);
            LinkedList linkedList = cXy.wzm;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    awg awg = (awg) it.next();
                    if (awg != null) {
                        C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", awg.wzX, awg.scope, awg.qkh, Integer.valueOf(awg.wzW), cXx.wzd);
                        awg.wzW = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((awg) it.next()) != null) {
                        C4990ab.m7417i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", ((awg) it.next()).wzX, ((awg) it.next()).scope, ((awg) it.next()).qkh, Integer.valueOf(((awg) it.next()).wzW), cXx.wzd);
                    }
                }
            }
            C1720g.m3540Rg().mo14541a(new C46426t(avf, cXx.url, cXx.mZr, cXx.wzd, cXx.cvO, cXx.wzf, cXx.signature, cXx.wzg, cXx.wzh, cXx.wzi, linkedList, this.ulX), 0);
            c40266q.ulV.mo26895a(C29933a.RET_OK, null, null, i, c40266q.cXy().wzj.cyE);
            AppMethodBeat.m2505o(8862);
        }
    }

    static String aef(String str) {
        AppMethodBeat.m2504i(8863);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(8863);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.m2505o(8863);
        return str;
    }
}
