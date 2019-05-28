package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p652z.p1100a.C44435d;
import com.tencent.p177mm.p652z.p1100a.C44435d.C36403a;
import com.tencent.p177mm.p652z.p1100a.C46726c;
import com.tencent.p177mm.p652z.p1100a.C46726c.C44434a;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C7489c;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C7489c.C7493a;
import com.tencent.p177mm.protocal.protobuf.avz;
import com.tencent.p177mm.protocal.protobuf.awb;
import com.tencent.p177mm.protocal.protobuf.buj;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin */
public final class JsApiLogin extends C33245f {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin$LoginTask */
    static class LoginTask extends MainProcessTask {
        public static final Creator<LoginTask> CREATOR = new C103163();
        public String aIm;
        public String appId;
        public String code;
        public String data;
        public int errCode;
        public int gwX;
        C33245f hBQ;
        C33327h hBR;
        C2227d hBS;
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

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin$LoginTask$a */
        interface C10315a {
            /* renamed from: P */
            void mo21766P(int i, String str);

            /* renamed from: a */
            void mo21767a(LinkedList<buj> linkedList, String str, String str2, String str3);

            void onSuccess(String str);
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin$LoginTask$3 */
        static class C103163 implements Creator<LoginTask> {
            C103163() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoginTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130859);
                LoginTask loginTask = new LoginTask(parcel);
                AppMethodBeat.m2505o(130859);
                return loginTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin$LoginTask$1 */
        class C103171 implements C10315a {
            C103171() {
            }

            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(130854);
                C4990ab.m7416i("MicroMsg.JsApiLogin", "onSuccess !");
                LoginTask.this.code = str;
                LoginTask.this.hBV = "ok";
                LoginTask.m18004a(LoginTask.this);
                AppMethodBeat.m2505o(130854);
            }

            /* renamed from: P */
            public final void mo21766P(int i, String str) {
                AppMethodBeat.m2504i(130855);
                C4990ab.m7416i("MicroMsg.JsApiLogin", "onFailure !");
                LoginTask.this.hBV = "fail";
                LoginTask.this.errCode = i;
                LoginTask.this.aIm = str;
                LoginTask.m18005b(LoginTask.this);
                AppMethodBeat.m2505o(130855);
            }

            /* renamed from: a */
            public final void mo21767a(LinkedList<buj> linkedList, String str, String str2, String str3) {
                AppMethodBeat.m2504i(130856);
                C4990ab.m7416i("MicroMsg.JsApiLogin", "onConfirm !");
                LoginTask.this.hCd = linkedList.size();
                int i = 0;
                while (i < LoginTask.this.hCd) {
                    try {
                        LoginTask.this.hCe.putByteArray(String.valueOf(i), ((buj) linkedList.get(i)).toByteArray());
                        i++;
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.JsApiLogin", "IOException %s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                        LoginTask.this.hBV = "fail";
                        LoginTask.m18006c(LoginTask.this);
                        AppMethodBeat.m2505o(130856);
                        return;
                    }
                }
                LoginTask.this.hzR = str3;
                LoginTask.this.mAppName = str;
                LoginTask.this.hBX = str2;
                LoginTask.this.hBV = "needConfirm";
                LoginTask.m18007d(LoginTask.this);
                AppMethodBeat.m2505o(130856);
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m18004a(LoginTask loginTask) {
            AppMethodBeat.m2504i(130867);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.m2505o(130867);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m18005b(LoginTask loginTask) {
            AppMethodBeat.m2504i(130868);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.m2505o(130868);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m18006c(LoginTask loginTask) {
            AppMethodBeat.m2504i(130869);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.m2505o(130869);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m18007d(LoginTask loginTask) {
            AppMethodBeat.m2504i(130870);
            boolean aCb = loginTask.aCb();
            AppMethodBeat.m2505o(130870);
            return aCb;
        }

        public LoginTask(Parcel parcel) {
            AppMethodBeat.m2504i(130862);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130862);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130863);
            final C103171 c103171 = new C103171();
            C1207m c46726c;
            if (this.hBU.equals("login")) {
                C4990ab.m7416i("MicroMsg.JsApiLogin", "start login");
                LinkedList linkedList = new LinkedList();
                this.gwX = 1;
                this.hzR = "";
                c46726c = new C46726c(this.appId, linkedList, this.gwX, "", this.hzR, this.har, this.hyE, new C44434a<C46726c>() {
                    /* renamed from: a */
                    public final /* synthetic */ void mo9736a(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(130860);
                        C46726c c46726c = (C46726c) c1207m;
                        C4990ab.m7417i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            awb Qv = c46726c.mo75144Qv();
                            int i3 = Qv.wzH.cyE;
                            String str2 = Qv.wzH.cyF;
                            String str3 = Qv.wzN;
                            C4990ab.m7417i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", Integer.valueOf(i3));
                            if (i3 == -12000) {
                                LinkedList linkedList = Qv.wlE;
                                C4990ab.m7417i("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", Qv.ncH, Qv.vDm);
                                c103171.mo21767a(linkedList, str2, r0, str3);
                                AppMethodBeat.m2505o(130860);
                                return;
                            } else if (i3 == 0) {
                                c103171.onSuccess(Qv.wzO);
                                C4990ab.m7417i("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                                AppMethodBeat.m2505o(130860);
                                return;
                            } else if (i3 == -12001) {
                                c103171.mo21766P(i3, str2);
                                C4990ab.m7413e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", str2);
                                AppMethodBeat.m2505o(130860);
                                return;
                            } else if (i3 == -12002) {
                                c103171.mo21766P(i3, str2);
                                C4990ab.m7413e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", str2);
                                AppMethodBeat.m2505o(130860);
                                return;
                            } else if (i3 == -12003) {
                                c103171.mo21766P(i3, str2);
                                C4990ab.m7413e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", str2);
                                AppMethodBeat.m2505o(130860);
                                return;
                            } else {
                                c103171.mo21766P(i3, str2);
                                C4990ab.m7413e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", str2);
                                AppMethodBeat.m2505o(130860);
                                return;
                            }
                        }
                        c103171.mo21766P(-1, "cgi fail");
                        AppMethodBeat.m2505o(130860);
                    }
                });
                if (c46726c.mo75143Qu().wzG == null) {
                    c46726c.mo75143Qu().wzG = new cxh();
                }
                c46726c.mo75143Qu().wzG.xsJ = this.hCf;
                C1720g.m3540Rg().mo14541a(c46726c, 0);
                AppMethodBeat.m2505o(130863);
                return;
            }
            if (this.hBU.equals("loginConfirm")) {
                C4990ab.m7416i("MicroMsg.JsApiLogin", "start loginConfirm");
                String str = this.appId;
                ArrayList arrayList = this.hBT;
                int i = this.gwX;
                String str2 = this.hzR;
                int i2 = this.har;
                final int i3 = this.hBW;
                c46726c = new C44435d(str, C33245f.m54390k(arrayList), i, str2, i2, i3, this.hyE, new C36403a<C44435d>() {
                    /* renamed from: a */
                    public final /* synthetic */ void mo9735a(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(130861);
                        C44435d c44435d = (C44435d) c1207m;
                        C4990ab.m7417i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i != 0 || i2 != 0) {
                            c103171.mo21766P(-1, "confirm cgi fail");
                            AppMethodBeat.m2505o(130861);
                        } else if (i3 == 2) {
                            C4990ab.m7416i("MicroMsg.JsApiLogin", "press reject button");
                            c103171.mo21766P(i2, "auth deny");
                            AppMethodBeat.m2505o(130861);
                        } else {
                            avz Qx = c44435d.mo70366Qx();
                            int i3 = Qx.wzH.cyE;
                            String str2 = Qx.wzH.cyF;
                            C4990ab.m7417i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", Integer.valueOf(i3));
                            if (i3 == 0) {
                                c103171.onSuccess(Qx.wzO);
                                C4990ab.m7417i("MicroMsg.JsApiLogin", "resp data code [%s]", r0);
                                AppMethodBeat.m2505o(130861);
                                return;
                            }
                            c103171.mo21766P(i3, str2);
                            C4990ab.m7413e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", str2);
                            AppMethodBeat.m2505o(130861);
                        }
                    }
                });
                if (c46726c.mo70365Qw().wzG == null) {
                    c46726c.mo70365Qw().wzG = new cxh();
                }
                c46726c.mo70365Qw().wzG.xsJ = this.hCf;
                C1720g.m3540Rg().mo14541a(c46726c, 0);
            }
            AppMethodBeat.m2505o(130863);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130864);
            aBW();
            if (!this.hBR.isRunning()) {
                this.hBS.aCB();
                AppMethodBeat.m2505o(130864);
            } else if (this.hBV.equals("ok")) {
                HashMap hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.code);
                this.hBR.mo6107M(this.hwi, this.hBQ.mo73394j("ok", hashMap));
                this.hBS.aCB();
                AppMethodBeat.m2505o(130864);
            } else if (this.hBV.equals("fail")) {
                String format;
                if (C5046bo.isNullOrNil(this.aIm)) {
                    format = String.format("fail:login error %s", new Object[]{Integer.valueOf(this.errCode)});
                } else {
                    format = String.format("fail:%s", new Object[]{this.aIm});
                }
                this.hBQ.mo53782b(this.hBR, this.hwi, format);
                this.hBS.aCB();
                AppMethodBeat.m2505o(130864);
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
                            C4990ab.m7413e("MicroMsg.JsApiLogin", "parse scope info error %s", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                            this.hBQ.mo53782b(this.hBR, this.hwi, "fail:internal error scope error");
                            this.hBS.aCB();
                            AppMethodBeat.m2505o(130864);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        C5004al.m7441d(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin$LoginTask$2$1 */
                            class C103141 implements C7493a {
                                C103141() {
                                }

                                /* renamed from: b */
                                public final void mo16722b(int i, ArrayList<String> arrayList) {
                                    AppMethodBeat.m2504i(130857);
                                    C4990ab.m7417i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            LoginTask.this.hBU = "loginConfirm";
                                            LoginTask.this.hBT = arrayList;
                                            LoginTask.this.hBW = i;
                                            AppBrandMainProcessService.m54349a(LoginTask.this);
                                            if (i == 2) {
                                                LoginTask.this.hBQ.mo53782b(LoginTask.this.hBR, LoginTask.this.hwi, "fail auth deny");
                                                LoginTask.this.hBS.aCB();
                                                AppMethodBeat.m2505o(130857);
                                                return;
                                            }
                                            break;
                                        default:
                                            C4990ab.m7410d("MicroMsg.JsApiLogin", "press back button!");
                                            LoginTask.this.hBQ.mo53782b(LoginTask.this.hBR, LoginTask.this.hwi, "fail auth cancel");
                                            LoginTask.this.hBS.aCB();
                                            break;
                                    }
                                    AppMethodBeat.m2505o(130857);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(130858);
                                LoginTask.this.hBR.asF().mo6468b(new C7489c(C33245f.m54389a(LoginTask.this.hBR), C33245f.m54391x(linkedList), LoginTask.this.mAppName, LoginTask.this.hBX, new C103141()));
                                AppMethodBeat.m2505o(130858);
                            }
                        });
                        AppMethodBeat.m2505o(130864);
                        return;
                    }
                    this.hBQ.mo53782b(this.hBR, this.hwi, "fail:internal error scope empty");
                    this.hBS.aCB();
                }
                AppMethodBeat.m2505o(130864);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130865);
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
            AppMethodBeat.m2505o(130865);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130866);
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
            AppMethodBeat.m2505o(130866);
        }

        static {
            AppMethodBeat.m2504i(130871);
            AppMethodBeat.m2505o(130871);
        }
    }

    /* renamed from: a */
    public final void mo44670a(C33327h c33327h, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130872);
        try {
            if (!jSONObject.has("requestInQueue")) {
                jSONObject.put("requestInQueue", false);
            }
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", e.getMessage());
        }
        super.mo5994a(c33327h, jSONObject, i);
        AppMethodBeat.m2505o(130872);
    }

    /* renamed from: a */
    public final void mo21765a(C33327h c33327h, JSONObject jSONObject, int i, C2227d c2227d) {
        AppMethodBeat.m2504i(130873);
        MainProcessTask loginTask = new LoginTask();
        loginTask.appId = c33327h.getAppId();
        loginTask.hBU = "login";
        C16597h ye = c33327h.getRuntime().mo15034ye();
        if (ye != null) {
            loginTask.har = ye.hhd.gVt;
        }
        AppBrandStatObject wK = C10048a.m17637wK(c33327h.getAppId());
        if (wK != null) {
            loginTask.hyE = wK.scene;
        }
        String jSONObject2 = jSONObject.toString();
        loginTask.hBQ = this;
        loginTask.hBR = c33327h;
        loginTask.data = jSONObject2;
        loginTask.hwi = i;
        loginTask.hBS = c2227d;
        loginTask.hCe = new Bundle();
        if (c33327h instanceof C38492q) {
            loginTask.hCf = 1;
        } else if (c33327h instanceof C44709u) {
            loginTask.hCf = 2;
        }
        loginTask.aBV();
        AppBrandMainProcessService.m54349a(loginTask);
        AppMethodBeat.m2505o(130873);
    }
}
