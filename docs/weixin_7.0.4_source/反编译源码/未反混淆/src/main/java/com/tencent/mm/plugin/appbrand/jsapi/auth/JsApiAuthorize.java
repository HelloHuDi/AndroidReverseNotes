package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.b.h.d;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends f {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";

    static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new Creator<AuthorizeTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthorizeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130835);
                AuthorizeTask authorizeTask = new AuthorizeTask(parcel);
                AppMethodBeat.o(130835);
                return authorizeTask;
            }
        };
        public String aIm;
        public String appId;
        public String data;
        public int errCode;
        f hBQ;
        h hBR;
        d hBS;
        public ArrayList<String> hBT;
        public String hBU;
        public String hBV;
        public int hBW;
        public String hBX;
        public String hBY;
        public String hBZ;
        public String hCa;
        public String hCb;
        public String hCc;
        public int hCd;
        public Bundle hCe;
        int hCf;
        public int har;
        public int hwi;
        private int hyE;
        public String mAppName;

        public interface a {
            void P(int i, String str);

            void a(avx avx);

            void onSuccess();
        }

        static /* synthetic */ boolean a(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(130844);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.o(130844);
            return aCb;
        }

        static /* synthetic */ boolean b(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(130845);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.o(130845);
            return aCb;
        }

        static /* synthetic */ boolean c(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(130846);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.o(130846);
            return aCb;
        }

        static /* synthetic */ boolean d(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(130847);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.o(130847);
            return aCb;
        }

        static /* synthetic */ boolean e(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(130848);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.o(130848);
            return aCb;
        }

        public AuthorizeTask(Parcel parcel) {
            AppMethodBeat.i(130838);
            g(parcel);
            AppMethodBeat.o(130838);
        }

        public final void asP() {
            AppMethodBeat.i(130839);
            final AnonymousClass1 anonymousClass1 = new a() {
                public final void onSuccess() {
                    AppMethodBeat.i(130830);
                    ab.d("MicroMsg.JsApiAuthorize", "onSuccess !");
                    AuthorizeTask.this.hBV = "ok";
                    AuthorizeTask.a(AuthorizeTask.this);
                    AppMethodBeat.o(130830);
                }

                public final void P(int i, String str) {
                    AppMethodBeat.i(130831);
                    ab.e("MicroMsg.JsApiAuthorize", "onFailure !");
                    AuthorizeTask.this.hBV = "fail";
                    AuthorizeTask.this.errCode = i;
                    AuthorizeTask.this.aIm = str;
                    AuthorizeTask.b(AuthorizeTask.this);
                    AppMethodBeat.o(130831);
                }

                public final void a(avx avx) {
                    AppMethodBeat.i(130832);
                    ab.d("MicroMsg.JsApiAuthorize", "onConfirm !");
                    LinkedList linkedList = avx.wlE;
                    AuthorizeTask.this.hCd = linkedList.size();
                    int i = 0;
                    while (i < AuthorizeTask.this.hCd) {
                        try {
                            AuthorizeTask.this.hCe.putByteArray(String.valueOf(i), ((buj) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (IOException e) {
                            ab.e("MicroMsg.JsApiAuthorize", "IOException %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                            AuthorizeTask.this.hBV = "fail";
                            AuthorizeTask.c(AuthorizeTask.this);
                            AppMethodBeat.o(130832);
                            return;
                        }
                    }
                    AuthorizeTask.this.mAppName = avx.ncH;
                    AuthorizeTask.this.hBX = avx.vDm;
                    AuthorizeTask.this.hBY = avx.wzL;
                    AuthorizeTask.this.hCa = avx.wzK;
                    AuthorizeTask.this.hBZ = avx.wzJ;
                    AuthorizeTask.this.hBV = "needConfirm";
                    if (linkedList.size() <= 0 || !"scope.userInfo".equals(((buj) linkedList.get(0)).vOF)) {
                        AuthorizeTask.e(AuthorizeTask.this);
                        AppMethodBeat.o(130832);
                        return;
                    }
                    String str;
                    AuthorizeTask.this.hCc = r.YB();
                    String str2 = "MicroMsg.JsApiAuthorize";
                    StringBuilder stringBuilder = new StringBuilder("userNickName=");
                    if (AuthorizeTask.this.hCc == null) {
                        str = "";
                    } else {
                        str = AuthorizeTask.this.hCc;
                    }
                    ab.i(str2, stringBuilder.append(str).toString());
                    str = r.Yz();
                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a aVar = e.hBN;
                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a.a(str, new b() {
                        public final void AQ(String str) {
                            AppMethodBeat.i(130829);
                            AuthorizeTask.this.hCb = str;
                            ab.i("MicroMsg.JsApiAuthorize", " userHeadIconPath=" + (AuthorizeTask.this.hCb == null ? "" : AuthorizeTask.this.hCb));
                            AuthorizeTask.d(AuthorizeTask.this);
                            AppMethodBeat.o(130829);
                        }
                    });
                    AppMethodBeat.o(130832);
                }
            };
            m aVar;
            if (this.hBU.equals(JsApiAuthorize.NAME)) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    aVar = new com.tencent.mm.z.a.a(this.appId, linkedList, this.har, this.hyE, new com.tencent.mm.z.a.a.a<com.tencent.mm.z.a.a>() {
                        public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                            AppMethodBeat.i(130836);
                            com.tencent.mm.z.a.a aVar = (com.tencent.mm.z.a.a) mVar;
                            ab.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i == 0 && i2 == 0) {
                                avx Qr = aVar.Qr();
                                int i3 = Qr.wzH.cyE;
                                String str2 = Qr.wzH.cyF;
                                ab.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", Integer.valueOf(i3));
                                if (i3 == -12000) {
                                    anonymousClass1.a(Qr);
                                    AppMethodBeat.o(130836);
                                    return;
                                } else if (i3 == 0) {
                                    anonymousClass1.onSuccess();
                                    AppMethodBeat.o(130836);
                                    return;
                                } else {
                                    ab.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                                    anonymousClass1.P(i3, str2);
                                    AppMethodBeat.o(130836);
                                    return;
                                }
                            }
                            anonymousClass1.P(-1, "cgi fail");
                            AppMethodBeat.o(130836);
                        }
                    });
                    if (aVar.Qq().wzG == null) {
                        aVar.Qq().wzG = new cxh();
                    }
                    aVar.Qq().wzG.xsJ = this.hCf;
                    g.Rg().a(aVar, 0);
                    AppMethodBeat.o(130839);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.JsApiAuthorize", "Exception %s", e.getMessage());
                    this.hBV = "fail";
                    aCb();
                    AppMethodBeat.o(130839);
                    return;
                }
            }
            if (this.hBU.equals("authorizeConfirm")) {
                String str = this.appId;
                ArrayList arrayList = this.hBT;
                int i2 = this.har;
                final int i3 = this.hBW;
                aVar = new com.tencent.mm.z.a.b(str, f.k(arrayList), i2, i3, this.hyE, new com.tencent.mm.z.a.b.a<com.tencent.mm.z.a.b>() {
                    public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(130837);
                        com.tencent.mm.z.a.b bVar = (com.tencent.mm.z.a.b) mVar;
                        ab.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i != 0 || i2 != 0) {
                            anonymousClass1.P(-1, "confirm cgi fail");
                            AppMethodBeat.o(130837);
                        } else if (i3 == 2) {
                            ab.d("MicroMsg.JsApiAuthorize", "press reject button");
                            AppMethodBeat.o(130837);
                        } else {
                            avv Qt = bVar.Qt();
                            int i3 = Qt.wzH.cyE;
                            String str2 = Qt.wzH.cyF;
                            ab.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", Integer.valueOf(i3));
                            if (i3 == 0) {
                                anonymousClass1.onSuccess();
                                AppMethodBeat.o(130837);
                                return;
                            }
                            ab.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", str2);
                            anonymousClass1.P(i3, str2);
                            AppMethodBeat.o(130837);
                        }
                    }
                });
                if (aVar.Qs().wzG == null) {
                    aVar.Qs().wzG = new cxh();
                }
                aVar.Qs().wzG.xsJ = this.hCf;
                g.Rg().a(aVar, 0);
            }
            AppMethodBeat.o(130839);
        }

        public final void asQ() {
            AppMethodBeat.i(130840);
            aBW();
            if (!this.hBR.isRunning()) {
                this.hBS.aCB();
                AppMethodBeat.o(130840);
            } else if (this.hBV.equals("ok")) {
                this.hBQ.b(this.hBR, this.hwi, "ok");
                this.hBS.aCB();
                AppMethodBeat.o(130840);
            } else if (this.hBV.equals("fail")) {
                String format;
                if (bo.isNullOrNil(this.aIm)) {
                    format = String.format("fail:login error %s", new Object[]{Integer.valueOf(this.errCode)});
                } else {
                    format = String.format("fail:%s", new Object[]{this.aIm});
                }
                this.hBQ.b(this.hBR, this.hwi, format);
                this.hBS.aCB();
                AppMethodBeat.o(130840);
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
                            ab.e("MicroMsg.JsApiAuthorize", "IOException %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                            this.hBQ.b(this.hBR, this.hwi, "fail:internal error scope error");
                            this.hBS.aCB();
                            AppMethodBeat.o(130840);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130834);
                                buj buj = (buj) linkedList.get(0);
                                i runtime = AuthorizeTask.this.hBR.getRuntime();
                                boolean a = com.tencent.mm.plugin.appbrand.permission.m.a(buj.vOF, runtime.ye());
                                com.tencent.mm.plugin.appbrand.widget.b.h hVar = new com.tencent.mm.plugin.appbrand.widget.b.h(runtime.asV().getContext(), new d() {
                                    public final void a(int i, ArrayList<String> arrayList) {
                                        AppMethodBeat.i(130833);
                                        Object obj = c.C(arrayList).size() > 0 ? (String) arrayList.get(0) : "";
                                        ArrayList arrayList2;
                                        switch (i) {
                                            case 1:
                                                arrayList2 = new ArrayList();
                                                arrayList2.add(obj);
                                                AuthorizeTask.a(AuthorizeTask.this, 1, arrayList2);
                                                ab.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                                                AppMethodBeat.o(130833);
                                                return;
                                            case 2:
                                                arrayList2 = new ArrayList();
                                                arrayList2.add(obj);
                                                AuthorizeTask.a(AuthorizeTask.this, 2, arrayList2);
                                                ab.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                                                AppMethodBeat.o(130833);
                                                return;
                                            case 3:
                                                AuthorizeTask.f(AuthorizeTask.this);
                                                ab.i("MicroMsg.JsApiAuthorize", "user cancel");
                                                break;
                                        }
                                        AppMethodBeat.o(130833);
                                    }
                                });
                                hVar.Ez(runtime.ye().cwz);
                                hVar.EC(AuthorizeTask.this.hBY);
                                hVar.EA(buj.Desc);
                                hVar.ED(AuthorizeTask.this.hBZ);
                                hVar.EE(AuthorizeTask.this.hCa);
                                hVar.jl(AuthorizeTask.this.hBX);
                                if ("scope.userInfo".equals(buj.vOF)) {
                                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a aVar = e.hBN;
                                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a.a(AuthorizeTask.this.hBR.getContext(), com.tencent.mm.ah.d.qi(AuthorizeTask.this.hCb), AuthorizeTask.this.hCc, buj.vOF, hVar);
                                } else {
                                    hVar.EF(buj.vOF);
                                }
                                if (a) {
                                    if (TextUtils.isEmpty(com.tencent.mm.plugin.appbrand.permission.m.a(buj.vOF, runtime))) {
                                        AuthorizeTask.a(AuthorizeTask.this, "fail:require permission desc");
                                        ab.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                                        AppMethodBeat.o(130834);
                                        return;
                                    }
                                    hVar.EB(com.tencent.mm.plugin.appbrand.permission.m.a(buj.vOF, runtime));
                                }
                                ab.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", buj.vOF, buj.Desc, buj.wze, buj.iyZ);
                                runtime.gNG.b(hVar);
                                AppMethodBeat.o(130834);
                            }
                        });
                        AppMethodBeat.o(130840);
                        return;
                    }
                    this.hBQ.b(this.hBR, this.hwi, "fail:internal error scope empty");
                    this.hBS.aCB();
                }
                AppMethodBeat.o(130840);
            }
        }

        private void AH(String str) {
            AppMethodBeat.i(130841);
            if (TextUtils.isEmpty(str)) {
                this.hBQ.b(this.hBR, this.hwi, "fail auth cancel");
            } else {
                this.hBQ.b(this.hBR, this.hwi, str);
            }
            this.hBS.aCB();
            AppMethodBeat.o(130841);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130842);
            this.data = parcel.readString();
            this.hwi = parcel.readInt();
            this.appId = parcel.readString();
            this.hBV = parcel.readString();
            this.hBU = parcel.readString();
            this.mAppName = parcel.readString();
            this.hBX = parcel.readString();
            this.hCd = parcel.readInt();
            this.hCe = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.hBT = parcel.createStringArrayList();
            this.har = parcel.readInt();
            this.hBW = parcel.readInt();
            this.hyE = parcel.readInt();
            this.hCf = parcel.readInt();
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            this.hCa = parcel.readString();
            this.hBZ = parcel.readString();
            this.hBY = parcel.readString();
            this.hCb = parcel.readString();
            this.hCc = parcel.readString();
            AppMethodBeat.o(130842);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130843);
            parcel.writeString(this.data);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.appId);
            parcel.writeString(this.hBV);
            parcel.writeString(this.hBU);
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
            parcel.writeString(this.hCa);
            parcel.writeString(this.hBZ);
            parcel.writeString(this.hBY);
            parcel.writeString(this.hCb);
            parcel.writeString(this.hCc);
            AppMethodBeat.o(130843);
        }

        static {
            AppMethodBeat.i(130852);
            AppMethodBeat.o(130852);
        }

        static /* synthetic */ void a(AuthorizeTask authorizeTask, int i, ArrayList arrayList) {
            AppMethodBeat.i(130849);
            authorizeTask.hBU = "authorizeConfirm";
            authorizeTask.hBT = arrayList;
            authorizeTask.hBW = i;
            AppBrandMainProcessService.a((MainProcessTask) authorizeTask);
            if (i == 2) {
                authorizeTask.hBQ.b(authorizeTask.hBR, authorizeTask.hwi, "fail auth deny");
                authorizeTask.hBS.aCB();
            }
            AppMethodBeat.o(130849);
        }

        static /* synthetic */ void f(AuthorizeTask authorizeTask) {
            AppMethodBeat.i(130850);
            authorizeTask.AH("");
            AppMethodBeat.o(130850);
        }
    }

    public final void a(h hVar, JSONObject jSONObject, int i, d dVar) {
        AppMethodBeat.i(130853);
        ab.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        MainProcessTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = hVar.getAppId();
        authorizeTask.hBU = NAME;
        com.tencent.mm.plugin.appbrand.config.h ye = hVar.getRuntime().ye();
        if (ye != null) {
            authorizeTask.har = ye.hhd.gVt;
        }
        AppBrandStatObject wK = a.wK(hVar.getAppId());
        if (wK != null) {
            authorizeTask.hyE = wK.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.hBQ = this;
        authorizeTask.hBR = hVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.hwi = i;
        authorizeTask.hBS = dVar;
        authorizeTask.hCe = new Bundle();
        if (hVar instanceof q) {
            authorizeTask.hCf = 1;
        } else if (hVar instanceof u) {
            authorizeTask.hCf = 2;
        }
        authorizeTask.aBV();
        AppBrandMainProcessService.a(authorizeTask);
        AppMethodBeat.o(130853);
    }
}
