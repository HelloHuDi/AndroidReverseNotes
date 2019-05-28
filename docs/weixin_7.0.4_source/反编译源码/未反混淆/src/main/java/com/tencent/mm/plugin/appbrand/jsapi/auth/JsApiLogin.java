package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.a.c;
import com.tencent.mm.z.a.d;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLogin extends f {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";

    static class LoginTask extends MainProcessTask {
        public static final Creator<LoginTask> CREATOR = new Creator<LoginTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoginTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130859);
                LoginTask loginTask = new LoginTask(parcel);
                AppMethodBeat.o(130859);
                return loginTask;
            }
        };
        public String aIm;
        public String appId;
        public String code;
        public String data;
        public int errCode;
        public int gwX;
        f hBQ;
        h hBR;
        d hBS;
        public ArrayList<String> hBT;
        public String hBU;
        public String hBV;
        public int hBW;
        public String hBX;
        public int hCd;
        public Bundle hCe;
        int hCf;
        public int har;
        public int hwi;
        public int hyE;
        public String hzR;
        public String mAppName;

        interface a {
            void P(int i, String str);

            void a(LinkedList<buj> linkedList, String str, String str2, String str3);

            void onSuccess(String str);
        }

        static /* synthetic */ boolean a(LoginTask loginTask) {
            AppMethodBeat.i(130867);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.o(130867);
            return aCb;
        }

        static /* synthetic */ boolean b(LoginTask loginTask) {
            AppMethodBeat.i(130868);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.o(130868);
            return aCb;
        }

        static /* synthetic */ boolean c(LoginTask loginTask) {
            AppMethodBeat.i(130869);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.o(130869);
            return aCb;
        }

        static /* synthetic */ boolean d(LoginTask loginTask) {
            AppMethodBeat.i(130870);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.o(130870);
            return aCb;
        }

        public LoginTask(Parcel parcel) {
            AppMethodBeat.i(130862);
            g(parcel);
            AppMethodBeat.o(130862);
        }

        public final void asP() {
            AppMethodBeat.i(130863);
            final AnonymousClass1 anonymousClass1 = new a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(130854);
                    ab.i("MicroMsg.JsApiLogin", "onSuccess !");
                    LoginTask.this.code = str;
                    LoginTask.this.hBV = "ok";
                    LoginTask.a(LoginTask.this);
                    AppMethodBeat.o(130854);
                }

                public final void P(int i, String str) {
                    AppMethodBeat.i(130855);
                    ab.i("MicroMsg.JsApiLogin", "onFailure !");
                    LoginTask.this.hBV = "fail";
                    LoginTask.this.errCode = i;
                    LoginTask.this.aIm = str;
                    LoginTask.b(LoginTask.this);
                    AppMethodBeat.o(130855);
                }

                public final void a(LinkedList<buj> linkedList, String str, String str2, String str3) {
                    AppMethodBeat.i(130856);
                    ab.i("MicroMsg.JsApiLogin", "onConfirm !");
                    LoginTask.this.hCd = linkedList.size();
                    int i = 0;
                    while (i < LoginTask.this.hCd) {
                        try {
                            LoginTask.this.hCe.putByteArray(String.valueOf(i), ((buj) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (IOException e) {
                            ab.e("MicroMsg.JsApiLogin", "IOException %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                            LoginTask.this.hBV = "fail";
                            LoginTask.c(LoginTask.this);
                            AppMethodBeat.o(130856);
                            return;
                        }
                    }
                    LoginTask.this.hzR = str3;
                    LoginTask.this.mAppName = str;
                    LoginTask.this.hBX = str2;
                    LoginTask.this.hBV = "needConfirm";
                    LoginTask.d(LoginTask.this);
                    AppMethodBeat.o(130856);
                }
            };
            m cVar;
            if (this.hBU.equals("login")) {
                ab.i("MicroMsg.JsApiLogin", "start login");
                LinkedList linkedList = new LinkedList();
                this.gwX = 1;
                this.hzR = "";
                cVar = new c(this.appId, linkedList, this.gwX, "", this.hzR, this.har, this.hyE, new com.tencent.mm.z.a.c.a<c>() {
                    public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(130860);
                        c cVar = (c) mVar;
                        ab.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            awb Qv = cVar.Qv();
                            int i3 = Qv.wzH.cyE;
                            String str2 = Qv.wzH.cyF;
                            String str3 = Qv.wzN;
                            ab.i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                            if (i3 == -12000) {
                                LinkedList linkedList = Qv.wlE;
                                ab.i("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", Qv.ncH, Qv.vDm);
                                anonymousClass1.a(linkedList, str2, r0, str3);
                                AppMethodBeat.o(130860);
                                return;
                            } else if (i3 == 0) {
                                anonymousClass1.onSuccess(Qv.wzO);
                                ab.i("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                                AppMethodBeat.o(130860);
                                return;
                            } else if (i3 == -12001) {
                                anonymousClass1.P(i3, str2);
                                ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", str2);
                                AppMethodBeat.o(130860);
                                return;
                            } else if (i3 == -12002) {
                                anonymousClass1.P(i3, str2);
                                ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", str2);
                                AppMethodBeat.o(130860);
                                return;
                            } else if (i3 == -12003) {
                                anonymousClass1.P(i3, str2);
                                ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", str2);
                                AppMethodBeat.o(130860);
                                return;
                            } else {
                                anonymousClass1.P(i3, str2);
                                ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                                AppMethodBeat.o(130860);
                                return;
                            }
                        }
                        anonymousClass1.P(-1, "cgi fail");
                        AppMethodBeat.o(130860);
                    }
                });
                if (cVar.Qu().wzG == null) {
                    cVar.Qu().wzG = new cxh();
                }
                cVar.Qu().wzG.xsJ = this.hCf;
                g.Rg().a(cVar, 0);
                AppMethodBeat.o(130863);
                return;
            }
            if (this.hBU.equals("loginConfirm")) {
                ab.i("MicroMsg.JsApiLogin", "start loginConfirm");
                String str = this.appId;
                ArrayList arrayList = this.hBT;
                int i = this.gwX;
                String str2 = this.hzR;
                int i2 = this.har;
                final int i3 = this.hBW;
                cVar = new d(str, f.k(arrayList), i, str2, i2, i3, this.hyE, new com.tencent.mm.z.a.d.a<d>() {
                    public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(130861);
                        d dVar = (d) mVar;
                        ab.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i != 0 || i2 != 0) {
                            anonymousClass1.P(-1, "confirm cgi fail");
                            AppMethodBeat.o(130861);
                        } else if (i3 == 2) {
                            ab.i("MicroMsg.JsApiLogin", "press reject button");
                            anonymousClass1.P(i2, "auth deny");
                            AppMethodBeat.o(130861);
                        } else {
                            avz Qx = dVar.Qx();
                            int i3 = Qx.wzH.cyE;
                            String str2 = Qx.wzH.cyF;
                            ab.i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", Integer.valueOf(i3));
                            if (i3 == 0) {
                                anonymousClass1.onSuccess(Qx.wzO);
                                ab.i("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                                AppMethodBeat.o(130861);
                                return;
                            }
                            anonymousClass1.P(i3, str2);
                            ab.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", str2);
                            AppMethodBeat.o(130861);
                        }
                    }
                });
                if (cVar.Qw().wzG == null) {
                    cVar.Qw().wzG = new cxh();
                }
                cVar.Qw().wzG.xsJ = this.hCf;
                g.Rg().a(cVar, 0);
            }
            AppMethodBeat.o(130863);
        }

        public final void asQ() {
            AppMethodBeat.i(130864);
            aBW();
            if (!this.hBR.isRunning()) {
                this.hBS.aCB();
                AppMethodBeat.o(130864);
            } else if (this.hBV.equals("ok")) {
                HashMap hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.code);
                this.hBR.M(this.hwi, this.hBQ.j("ok", hashMap));
                this.hBS.aCB();
                AppMethodBeat.o(130864);
            } else if (this.hBV.equals("fail")) {
                String format;
                if (bo.isNullOrNil(this.aIm)) {
                    format = String.format("fail:login error %s", new Object[]{Integer.valueOf(this.errCode)});
                } else {
                    format = String.format("fail:%s", new Object[]{this.aIm});
                }
                this.hBQ.b(this.hBR, this.hwi, format);
                this.hBS.aCB();
                AppMethodBeat.o(130864);
            } else {
                if (this.hBV.equals("needConfirm")) {
                    final LinkedList linkedList = new LinkedList();
                    int i = 0;
                    while (i < this.hCd) {
                        byte[] byteArray = this.hCe.getByteArray(String.valueOf(i));
                        buj buj = new buj();
                        try {
                            buj.parseFrom(byteArray);
                            linkedList.add(buj);
                            i++;
                        } catch (IOException e) {
                            ab.e("MicroMsg.JsApiLogin", "parse scope info error %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                            this.hBQ.b(this.hBR, this.hwi, "fail:internal error scope error");
                            this.hBS.aCB();
                            AppMethodBeat.o(130864);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130858);
                                LoginTask.this.hBR.asF().b(new com.tencent.mm.plugin.appbrand.widget.b.c(f.a(LoginTask.this.hBR), f.x(linkedList), LoginTask.this.mAppName, LoginTask.this.hBX, new com.tencent.mm.plugin.appbrand.widget.b.c.a() {
                                    public final void b(int i, ArrayList<String> arrayList) {
                                        AppMethodBeat.i(130857);
                                        ab.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                LoginTask.this.hBU = "loginConfirm";
                                                LoginTask.this.hBT = arrayList;
                                                LoginTask.this.hBW = i;
                                                AppBrandMainProcessService.a(LoginTask.this);
                                                if (i == 2) {
                                                    LoginTask.this.hBQ.b(LoginTask.this.hBR, LoginTask.this.hwi, "fail auth deny");
                                                    LoginTask.this.hBS.aCB();
                                                    AppMethodBeat.o(130857);
                                                    return;
                                                }
                                                break;
                                            default:
                                                ab.d("MicroMsg.JsApiLogin", "press back button!");
                                                LoginTask.this.hBQ.b(LoginTask.this.hBR, LoginTask.this.hwi, "fail auth cancel");
                                                LoginTask.this.hBS.aCB();
                                                break;
                                        }
                                        AppMethodBeat.o(130857);
                                    }
                                }));
                                AppMethodBeat.o(130858);
                            }
                        });
                        AppMethodBeat.o(130864);
                        return;
                    }
                    this.hBQ.b(this.hBR, this.hwi, "fail:internal error scope empty");
                    this.hBS.aCB();
                }
                AppMethodBeat.o(130864);
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130865);
            this.data = parcel.readString();
            this.hwi = parcel.readInt();
            this.hBU = parcel.readString();
            this.appId = parcel.readString();
            this.code = parcel.readString();
            this.hBV = parcel.readString();
            this.hzR = parcel.readString();
            this.gwX = parcel.readInt();
            this.mAppName = parcel.readString();
            this.hBX = parcel.readString();
            this.hCd = parcel.readInt();
            this.hCe = parcel.readBundle(JsApiLogin.class.getClassLoader());
            this.hBT = parcel.createStringArrayList();
            this.har = parcel.readInt();
            this.hBW = parcel.readInt();
            this.hyE = parcel.readInt();
            this.hCf = parcel.readInt();
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            AppMethodBeat.o(130865);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130866);
            parcel.writeString(this.data);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.hBU);
            parcel.writeString(this.appId);
            parcel.writeString(this.code);
            parcel.writeString(this.hBV);
            parcel.writeString(this.hzR);
            parcel.writeInt(this.gwX);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.hBX);
            parcel.writeInt(this.hCd);
            parcel.writeBundle(this.hCe);
            parcel.writeStringList(this.hBT);
            parcel.writeInt(this.har);
            parcel.writeInt(this.hBW);
            parcel.writeInt(this.hyE);
            parcel.writeInt(this.hCf);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.aIm);
            AppMethodBeat.o(130866);
        }

        static {
            AppMethodBeat.i(130871);
            AppMethodBeat.o(130871);
        }
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130872);
        try {
            if (!jSONObject.has("requestInQueue")) {
                jSONObject.put("requestInQueue", false);
            }
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", e.getMessage());
        }
        super.a(hVar, jSONObject, i);
        AppMethodBeat.o(130872);
    }

    public final void a(h hVar, JSONObject jSONObject, int i, d dVar) {
        AppMethodBeat.i(130873);
        MainProcessTask loginTask = new LoginTask();
        loginTask.appId = hVar.getAppId();
        loginTask.hBU = "login";
        com.tencent.mm.plugin.appbrand.config.h ye = hVar.getRuntime().ye();
        if (ye != null) {
            loginTask.har = ye.hhd.gVt;
        }
        AppBrandStatObject wK = a.wK(hVar.getAppId());
        if (wK != null) {
            loginTask.hyE = wK.scene;
        }
        String jSONObject2 = jSONObject.toString();
        loginTask.hBQ = this;
        loginTask.hBR = hVar;
        loginTask.data = jSONObject2;
        loginTask.hwi = i;
        loginTask.hBS = dVar;
        loginTask.hCe = new Bundle();
        if (hVar instanceof q) {
            loginTask.hCf = 1;
        } else if (hVar instanceof u) {
            loginTask.hCf = 2;
        }
        loginTask.aBV();
        AppBrandMainProcessService.a(loginTask);
        AppMethodBeat.o(130873);
    }
}
