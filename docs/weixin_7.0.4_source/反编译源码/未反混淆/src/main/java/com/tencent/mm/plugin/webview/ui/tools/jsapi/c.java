package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.plugin.webview.model.s;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c implements f {
    private Context context;
    private final HashMap<String, avf> uFb = new HashMap();
    private final HashMap<String, String> uFc = new HashMap();
    final HashMap<String, d> ujx = new HashMap();
    final int ulX;
    private e umI;

    public static class d {
        public String appId;
        public List<String> uFm;
    }

    public interface b {
        int cXz();
    }

    public static abstract class c implements a {
        public boolean uFl = true;

        public boolean dcf() {
            return this.uFl;
        }

        public final void nY(boolean z) {
            this.uFl = z;
        }

        public void agk(String str) {
        }
    }

    public interface a {

        public enum a {
            RET_OK(0),
            RET_FAIL(-1),
            RET_REJECT(-2),
            RET_ACCESS_DENIED(-3);
            
            private int code;

            static {
                AppMethodBeat.o(8856);
            }

            private a(int i) {
                this.code = i;
            }

            public final int getCode() {
                return this.code;
            }
        }

        void a(a aVar, String str, LinkedList<cmu> linkedList, int i, int i2);

        void agk(String str);
    }

    public final String agj(String str) {
        AppMethodBeat.i(8857);
        if (str == null) {
            AppMethodBeat.o(8857);
            return null;
        }
        String str2 = (String) this.uFc.get(str);
        if (bo.isNullOrNil(str2)) {
            String aef = aef(str);
            ab.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", str2, str, aef);
            if (!bo.isNullOrNil(aef)) {
                str2 = (String) this.uFc.get(aef);
            }
        }
        AppMethodBeat.o(8857);
        return str2;
    }

    public c(int i) {
        AppMethodBeat.i(8858);
        this.ulX = i;
        AppMethodBeat.o(8858);
    }

    /* Access modifiers changed, original: final */
    public final void a(Context context, e eVar) {
        this.context = context;
        this.umI = eVar;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(8859);
        ab.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (!(mVar instanceof b)) {
            ab.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
            AppMethodBeat.o(8859);
        } else if (((b) mVar).cXz() != this.ulX) {
            ab.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", Integer.valueOf(this.ulX), Integer.valueOf(((b) mVar).cXz()));
            AppMethodBeat.o(8859);
        } else {
            int type = mVar.getType();
            if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI) {
                g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_HEIBAI, (f) this);
                r rVar = (r) mVar;
                if (rVar == null) {
                    ab.e("MicroMsg.webview.JSVerifyHelper", "");
                    AppMethodBeat.o(8859);
                } else if (rVar.ulV == null) {
                    ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
                    AppMethodBeat.o(8859);
                } else {
                    int i3 = 0;
                    if (!(rVar.cXA() == null || rVar.cXA().wzj == null)) {
                        i3 = rVar.cXA().wzj.cyE;
                    }
                    if (i == 0 && i2 == 0) {
                        avo avo;
                        avp cXA = rVar.cXA();
                        if (rVar.ehh == null) {
                            avo = null;
                        } else {
                            avo = (avo) rVar.ehh.fsG.fsP;
                        }
                        if (cXA == null || bo.isNullOrNil(rVar.iCz) || avo == null || bo.isNullOrNil(avo.csB)) {
                            String str2 = "MicroMsg.webview.JSVerifyHelper";
                            String str3 = "something null %b, %b, %b";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(cXA == null);
                            objArr[1] = Boolean.valueOf(bo.isNullOrNil(rVar.iCz));
                            objArr[2] = Boolean.valueOf(avo == null);
                            ab.e(str2, str3, objArr);
                            rVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
                            AppMethodBeat.o(8859);
                        } else if (cXA.wzj == null) {
                            ab.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
                            rVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
                            AppMethodBeat.o(8859);
                        } else if (cXA.wzj.cyE != 0) {
                            ab.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", Integer.valueOf(cXA.wzj.cyE), cXA.wzj.cyF);
                            rVar.ulV.a(a.RET_FAIL, cXA.wzj.cyF, null, i2, i3);
                            AppMethodBeat.o(8859);
                        } else {
                            rVar.ulV.agk(cXA.wzB);
                            this.uFc.put(aef(avo.url), avo.csB);
                            d dVar = new d();
                            dVar.appId = avo.csB;
                            dVar.uFm = cXA.wzA;
                            this.ujx.put(aef(avo.url), dVar);
                            rVar.ulV.a(a.RET_OK, null, cXA.wzz, i2, i3);
                            ab.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", avo.url);
                            AppMethodBeat.o(8859);
                        }
                    } else if (i == 4) {
                        rVar.ulV.a(a.RET_FAIL, i2 + "_" + str, null, i2, i3);
                        AppMethodBeat.o(8859);
                    } else {
                        rVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
                        AppMethodBeat.o(8859);
                    }
                }
            } else if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG) {
                g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG, (f) this);
                a(i, i2, str, (q) mVar);
                AppMethodBeat.o(8859);
            } else if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING) {
                g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING, (f) this);
                s sVar = (s) mVar;
                if (sVar == null) {
                    ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
                    AppMethodBeat.o(8859);
                    return;
                }
                int i4;
                h.pYm.a(157, 24, 1, false);
                if (sVar.cXB() == null || sVar.cXB().wzj == null) {
                    i4 = 0;
                } else {
                    i4 = sVar.cXB().wzj.cyE;
                }
                if (i == 0 && i2 == 0) {
                    avr cXB = sVar.cXB();
                    if (cXB == null || cXB.wzj == null) {
                        ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
                        sVar.ulV.a(a.RET_FAIL, null, null, i2, i4);
                        AppMethodBeat.o(8859);
                        return;
                    } else if (cXB.wzj.cyE != 0) {
                        ab.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", Integer.valueOf(cXB.wzj.cyE), cXB.wzj.cyF);
                        sVar.ulV.a(a.RET_FAIL, cXB.wzj.cyF, null, i2, i4);
                        AppMethodBeat.o(8859);
                        return;
                    } else {
                        cmu cmu = cXB.wzC;
                        if (cmu == null) {
                            ab.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
                            sVar.ulV.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            AppMethodBeat.o(8859);
                            return;
                        } else if (cmu.xkt != 1) {
                            ab.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", Integer.valueOf(cmu.xkt));
                            sVar.ulV.a(a.RET_FAIL, "verifyFail", null, i2, i4);
                            AppMethodBeat.o(8859);
                            return;
                        } else {
                            sVar.ulV.a(a.RET_OK, null, null, i2, i4);
                            AppMethodBeat.o(8859);
                            return;
                        }
                    }
                }
                ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", Integer.valueOf(i), Integer.valueOf(i2));
                h.pYm.a(157, 25, 1, false);
                if (i == 4) {
                    sVar.ulV.a(a.RET_FAIL, i2 + "_" + str, null, i2, i4);
                    AppMethodBeat.o(8859);
                    return;
                }
                sVar.ulV.a(a.RET_FAIL, null, null, i2, i4);
                AppMethodBeat.o(8859);
            } else {
                if (type == FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING) {
                    avs avs;
                    g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING, (f) this);
                    t tVar = (t) mVar;
                    if (tVar.ehh == null) {
                        avs = null;
                    } else {
                        avs = (avs) tVar.ehh.fsG.fsP;
                    }
                    if (avs == null) {
                        ab.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
                        AppMethodBeat.o(8859);
                        return;
                    } else if (i != 0 || i2 != 0) {
                        ab.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", Integer.valueOf(i), Integer.valueOf(i2), avs.wzd);
                        AppMethodBeat.o(8859);
                        return;
                    } else if (com.tencent.mm.protocal.c.akD(bo.nullAsNil(avs.wzd)) == null) {
                        ab.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", Integer.valueOf(i), Integer.valueOf(i2));
                        AppMethodBeat.o(8859);
                        return;
                    } else {
                        avf avf = ((t) mVar).ulY;
                        avf.vIc = 1;
                        this.uFb.put(avs.wzd + avs.url, avf);
                    }
                }
                AppMethodBeat.o(8859);
            }
        }
    }

    public final void a(JsapiPermissionWrapper jsapiPermissionWrapper, String str, int i, i iVar, a aVar) {
        AppMethodBeat.i(8860);
        String str2 = "";
        if (iVar != null) {
            str2 = iVar.uIJ;
        }
        String str3;
        String str4;
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", str);
            aVar.a(a.RET_ACCESS_DENIED, null, null, 0, 0);
            AppMethodBeat.o(8860);
        } else if (jsapiPermissionWrapper == null || bo.isNullOrNil(str) || iVar == null || jsapiPermissionWrapper.vxM == null) {
            str3 = "MicroMsg.webview.JSVerifyHelper";
            str4 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Boolean.valueOf(jsapiPermissionWrapper != null);
            ab.e(str3, str4, objArr);
            aVar.a(a.RET_FAIL, "localParameters", null, 0, 0);
            AppMethodBeat.o(8860);
        } else {
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            int Lx = jsapiPermissionWrapper.Lx(i);
            ab.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", str2, Integer.valueOf(i), Integer.valueOf(Lx), str);
            String str10 = (String) this.uFc.get(str);
            if (bo.isNullOrNil(str10)) {
                str5 = (String) iVar.puc.get("verifyAppId");
            } else {
                str5 = str10;
            }
            Map map = iVar.uII;
            map.put("permissionValue", Integer.valueOf(Lx));
            map.put("appId", str5);
            switch (Lx) {
                case 0:
                    aVar.a(a.RET_ACCESS_DENIED, null, null, 0, 0);
                    AppMethodBeat.o(8860);
                    return;
                case 1:
                    aVar.a(a.RET_OK, null, null, 0, 0);
                    AppMethodBeat.o(8860);
                    return;
                case 2:
                    if (str2.equals("preVerifyJSAPI")) {
                        aVar.a(a.RET_OK, null, null, 0, 0);
                        AppMethodBeat.o(8860);
                        return;
                    }
                    aVar.a(a.RET_ACCESS_DENIED, null, null, 0, 0);
                    AppMethodBeat.o(8860);
                    return;
                case 3:
                    break;
                case 4:
                    avf avf = (avf) this.uFb.get(str2 + str);
                    if (avf != null && avf.vIc == 1) {
                        aVar.a(a.RET_OK, null, null, 0, 0);
                        AppMethodBeat.o(8860);
                        return;
                    }
            }
            str10 = (String) iVar.puc.get("verifySignature");
            str3 = (String) iVar.puc.get("verifyNonceStr");
            str4 = (String) iVar.puc.get("verifyTimestamp");
            String str11 = (String) iVar.puc.get("verifySignType");
            String str12 = (String) iVar.puc.get("scope");
            ab.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", (String) iVar.puc.get("addrSign"), str10);
            int i2 = 0;
            if (bo.isNullOrNil(str10) && !bo.isNullOrNil(r4)) {
                i2 = 1;
                str6 = (String) iVar.puc.get("timeStamp");
                str7 = (String) iVar.puc.get("nonceStr");
                str11 = (String) iVar.puc.get("signType");
                str8 = (String) iVar.puc.get("addrSign");
                str9 = (String) iVar.puc.get("appId");
            } else if (bo.isNullOrNil(str10)) {
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
            JSONObject ao = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.ao(iVar.puc);
            if (ao != null) {
                bArr = ao.toString().getBytes();
            }
            m qVar;
            if (Lx == 4) {
                qVar = new q(aVar, str, str9, str2, str6, str7, str8, str11, bArr, i2, str12, this.ulX);
                g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LIANKONG, (f) this);
                g.Rg().a(qVar, 0);
                AppMethodBeat.o(8860);
                return;
            }
            if (Lx == 3) {
                qVar = new s(aVar, str, str9, str2, str6, str7, str8, str11, bArr, this.ulX);
                g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_CHENGJING, (f) this);
                g.Rg().a(qVar, 0);
                AppMethodBeat.o(8860);
                return;
            }
            aVar.a(a.RET_FAIL, "unkonwPermission_".concat(String.valueOf(Lx)), null, 0, 0);
            ab.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
            AppMethodBeat.o(8860);
        }
    }

    private void a(int i, final int i2, String str, final q qVar) {
        AppMethodBeat.i(8861);
        if (qVar == null) {
            ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
            AppMethodBeat.o(8861);
            return;
        }
        int i3 = 0;
        if (!(qVar.cXy() == null || qVar.cXy().wzj == null)) {
            i3 = qVar.cXy().wzj.cyE;
        }
        if (i != 0 || i2 != 0) {
            ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 4) {
                qVar.ulV.a(a.RET_FAIL, str, null, i2, i3);
                AppMethodBeat.o(8861);
                return;
            }
            qVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
            AppMethodBeat.o(8861);
        } else if (bo.isNullOrNil(qVar.ulW)) {
            ab.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
            qVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
            AppMethodBeat.o(8861);
        } else {
            avh cXy = qVar.cXy();
            if (cXy == null || cXy.wzj == null) {
                ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
                qVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
                AppMethodBeat.o(8861);
            } else if (cXy.wzj.cyE != 0) {
                ab.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", Integer.valueOf(cXy.wzj.cyE), cXy.wzj.cyF);
                qVar.ulV.a(a.RET_FAIL, cXy.wzj.cyF, null, i2, i3);
                AppMethodBeat.o(8861);
            } else {
                ab.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", Integer.valueOf(qVar.cXx() == null ? 0 : qVar.cXx().wzi));
                if ((qVar.cXx() == null ? 0 : qVar.cXx().wzi) == 1) {
                    if (cXy.wzm == null) {
                        ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
                        qVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
                        AppMethodBeat.o(8861);
                        return;
                    }
                    Iterator it = cXy.wzm.iterator();
                    while (it.hasNext()) {
                        awg awg = (awg) it.next();
                        if (awg.wzX == null) {
                            ab.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
                        } else {
                            Iterator it2 = awg.wzX.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                if (!bo.isNullOrNil(str2)) {
                                    avf avf = new avf();
                                    avf.wzd = str2;
                                    avf.vIc = awg.wzW;
                                    avf.wze = awg.qkh;
                                    this.uFb.put(avf.wzd + qVar.url, avf);
                                }
                            }
                        }
                    }
                } else if (cXy.wzk == null) {
                    ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
                    qVar.ulV.a(a.RET_FAIL, "nullAuthInfo", null, i2, i3);
                    AppMethodBeat.o(8861);
                    return;
                } else {
                    Iterator it3 = cXy.wzk.iterator();
                    while (it3.hasNext()) {
                        avf avf2 = (avf) it3.next();
                        if (!bo.isNullOrNil(avf2.wzd)) {
                            this.uFb.put(avf2.wzd + qVar.url, avf2);
                        }
                    }
                }
                final avf avf3 = (avf) this.uFb.get(qVar.ulW + qVar.url);
                if (avf3 == null) {
                    ab.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", qVar.ulW, qVar.url);
                    qVar.ulV.a(a.RET_FAIL, null, null, i2, i3);
                    AppMethodBeat.o(8861);
                } else if (avf3.vIc == 1) {
                    qVar.ulV.a(a.RET_OK, null, null, i2, i3);
                    AppMethodBeat.o(8861);
                } else if (this.context == null) {
                    ab.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
                    a(qVar, i2, avf3);
                    AppMethodBeat.o(8861);
                } else {
                    WebViewStubTempUI.a(this.context, this.umI, bo.nullAsNil(avf3.wze), "", this.context.getString(R.string.ckc), this.context.getString(R.string.ckb), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(8852);
                            ab.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
                            c.this.a(qVar, i2, avf3);
                            AppMethodBeat.o(8852);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(8853);
                            ab.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
                            qVar.ulV.a(a.RET_REJECT, "cancel", null, i2, qVar.cXy().wzj.cyE);
                            AppMethodBeat.o(8853);
                        }
                    });
                    AppMethodBeat.o(8861);
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(q qVar, int i, avf avf) {
        AppMethodBeat.i(8862);
        avg cXx = qVar.cXx();
        avh cXy = qVar.cXy();
        if (cXx == null) {
            ab.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
            qVar.ulV.a(a.RET_FAIL, null, null, i, qVar.cXy().wzj.cyE);
            AppMethodBeat.o(8862);
        } else if (cXy == null) {
            ab.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
            qVar.ulV.a(a.RET_FAIL, null, null, i, qVar.cXy().wzj.cyE);
            AppMethodBeat.o(8862);
        } else {
            g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_v4_4_LAODIANYING, (f) this);
            LinkedList linkedList = cXy.wzm;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    awg awg = (awg) it.next();
                    if (awg != null) {
                        ab.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", awg.wzX, awg.scope, awg.qkh, Integer.valueOf(awg.wzW), cXx.wzd);
                        awg.wzW = 1;
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    if (((awg) it.next()) != null) {
                        ab.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", ((awg) it.next()).wzX, ((awg) it.next()).scope, ((awg) it.next()).qkh, Integer.valueOf(((awg) it.next()).wzW), cXx.wzd);
                    }
                }
            }
            g.Rg().a(new t(avf, cXx.url, cXx.mZr, cXx.wzd, cXx.cvO, cXx.wzf, cXx.signature, cXx.wzg, cXx.wzh, cXx.wzi, linkedList, this.ulX), 0);
            qVar.ulV.a(a.RET_OK, null, null, i, qVar.cXy().wzj.cyE);
            AppMethodBeat.o(8862);
        }
    }

    static String aef(String str) {
        AppMethodBeat.i(8863);
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(8863);
            return str;
        }
        str = str.substring(0, indexOf);
        AppMethodBeat.o(8863);
        return str;
    }
}
