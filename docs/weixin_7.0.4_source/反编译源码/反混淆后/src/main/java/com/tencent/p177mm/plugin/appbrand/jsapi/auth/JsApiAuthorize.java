package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.p147g.C37400c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p652z.p1100a.C16113b;
import com.tencent.p177mm.p652z.p1100a.C16113b.C16114a;
import com.tencent.p177mm.p652z.p1100a.C30907a;
import com.tencent.p177mm.p652z.p1100a.C30907a.C30906a;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.C38263e.C26927a;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.C38263e.C38262b;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.permission.C19662m;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h.C33585d;
import com.tencent.p177mm.protocal.protobuf.avv;
import com.tencent.p177mm.protocal.protobuf.avx;
import com.tencent.p177mm.protocal.protobuf.buj;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize */
public final class JsApiAuthorize extends C33245f {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize$AuthorizeTask */
    static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new C103123();
        public String aIm;
        public String appId;
        public String data;
        public int errCode;
        C33245f hBQ;
        C33327h hBR;
        C2227d hBS;
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

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize$AuthorizeTask$a */
        public interface C2224a {
            /* renamed from: P */
            void mo6088P(int i, String str);

            /* renamed from: a */
            void mo6089a(avx avx);

            void onSuccess();
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize$AuthorizeTask$1 */
        class C103081 implements C2224a {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize$AuthorizeTask$1$1 */
            class C103071 implements C38262b {
                C103071() {
                }

                /* renamed from: AQ */
                public final void mo21759AQ(String str) {
                    AppMethodBeat.m2504i(130829);
                    AuthorizeTask.this.hCb = str;
                    C4990ab.m7416i("MicroMsg.JsApiAuthorize", " userHeadIconPath=" + (AuthorizeTask.this.hCb == null ? "" : AuthorizeTask.this.hCb));
                    AuthorizeTask.m17991d(AuthorizeTask.this);
                    AppMethodBeat.m2505o(130829);
                }
            }

            C103081() {
            }

            public final void onSuccess() {
                AppMethodBeat.m2504i(130830);
                C4990ab.m7410d("MicroMsg.JsApiAuthorize", "onSuccess !");
                AuthorizeTask.this.hBV = "ok";
                AuthorizeTask.m17988a(AuthorizeTask.this);
                AppMethodBeat.m2505o(130830);
            }

            /* renamed from: P */
            public final void mo6088P(int i, String str) {
                AppMethodBeat.m2504i(130831);
                C4990ab.m7412e("MicroMsg.JsApiAuthorize", "onFailure !");
                AuthorizeTask.this.hBV = "fail";
                AuthorizeTask.this.errCode = i;
                AuthorizeTask.this.aIm = str;
                AuthorizeTask.m17989b(AuthorizeTask.this);
                AppMethodBeat.m2505o(130831);
            }

            /* renamed from: a */
            public final void mo6089a(avx avx) {
                AppMethodBeat.m2504i(130832);
                C4990ab.m7410d("MicroMsg.JsApiAuthorize", "onConfirm !");
                LinkedList linkedList = avx.wlE;
                AuthorizeTask.this.hCd = linkedList.size();
                int i = 0;
                while (i < AuthorizeTask.this.hCd) {
                    try {
                        AuthorizeTask.this.hCe.putByteArray(String.valueOf(i), ((buj) linkedList.get(i)).toByteArray());
                        i++;
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.JsApiAuthorize", "IOException %s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                        AuthorizeTask.this.hBV = "fail";
                        AuthorizeTask.m17990c(AuthorizeTask.this);
                        AppMethodBeat.m2505o(130832);
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
                    AuthorizeTask.m17992e(AuthorizeTask.this);
                    AppMethodBeat.m2505o(130832);
                    return;
                }
                String str;
                AuthorizeTask.this.hCc = C1853r.m3820YB();
                String str2 = "MicroMsg.JsApiAuthorize";
                StringBuilder stringBuilder = new StringBuilder("userNickName=");
                if (AuthorizeTask.this.hCc == null) {
                    str = "";
                } else {
                    str = AuthorizeTask.this.hCc;
                }
                C4990ab.m7416i(str2, stringBuilder.append(str).toString());
                str = C1853r.m3846Yz();
                C26927a c26927a = C38263e.hBN;
                C26927a.m42881a(str, new C103071());
                AppMethodBeat.m2505o(130832);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize$AuthorizeTask$3 */
        static class C103123 implements Creator<AuthorizeTask> {
            C103123() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthorizeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130835);
                AuthorizeTask authorizeTask = new AuthorizeTask(parcel);
                AppMethodBeat.m2505o(130835);
                return authorizeTask;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m17988a(AuthorizeTask authorizeTask) {
            AppMethodBeat.m2504i(130844);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.m2505o(130844);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m17989b(AuthorizeTask authorizeTask) {
            AppMethodBeat.m2504i(130845);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.m2505o(130845);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m17990c(AuthorizeTask authorizeTask) {
            AppMethodBeat.m2504i(130846);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.m2505o(130846);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m17991d(AuthorizeTask authorizeTask) {
            AppMethodBeat.m2504i(130847);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.m2505o(130847);
            return aCb;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m17992e(AuthorizeTask authorizeTask) {
            AppMethodBeat.m2504i(130848);
            boolean aCb = authorizeTask.aCb();
            AppMethodBeat.m2505o(130848);
            return aCb;
        }

        public AuthorizeTask(Parcel parcel) {
            AppMethodBeat.m2504i(130838);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130838);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130839);
            final C103081 c103081 = new C103081();
            C1207m c30907a;
            if (this.hBU.equals(JsApiAuthorize.NAME)) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    c30907a = new C30907a(this.appId, linkedList, this.har, this.hyE, new C30906a<C30907a>() {
                        /* renamed from: a */
                        public final /* synthetic */ void mo21762a(int i, int i2, String str, C1207m c1207m) {
                            AppMethodBeat.m2504i(130836);
                            C30907a c30907a = (C30907a) c1207m;
                            C4990ab.m7411d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i == 0 && i2 == 0) {
                                avx Qr = c30907a.mo49442Qr();
                                int i3 = Qr.wzH.cyE;
                                String str2 = Qr.wzH.cyF;
                                C4990ab.m7417i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", Integer.valueOf(i3));
                                if (i3 == -12000) {
                                    c103081.mo6089a(Qr);
                                    AppMethodBeat.m2505o(130836);
                                    return;
                                } else if (i3 == 0) {
                                    c103081.onSuccess();
                                    AppMethodBeat.m2505o(130836);
                                    return;
                                } else {
                                    C4990ab.m7413e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", str2);
                                    c103081.mo6088P(i3, str2);
                                    AppMethodBeat.m2505o(130836);
                                    return;
                                }
                            }
                            c103081.mo6088P(-1, "cgi fail");
                            AppMethodBeat.m2505o(130836);
                        }
                    });
                    if (c30907a.mo49441Qq().wzG == null) {
                        c30907a.mo49441Qq().wzG = new cxh();
                    }
                    c30907a.mo49441Qq().wzG.xsJ = this.hCf;
                    C1720g.m3540Rg().mo14541a(c30907a, 0);
                    AppMethodBeat.m2505o(130839);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.JsApiAuthorize", "Exception %s", e.getMessage());
                    this.hBV = "fail";
                    aCb();
                    AppMethodBeat.m2505o(130839);
                    return;
                }
            }
            if (this.hBU.equals("authorizeConfirm")) {
                String str = this.appId;
                ArrayList arrayList = this.hBT;
                int i2 = this.har;
                final int i3 = this.hBW;
                c30907a = new C16113b(str, C33245f.m54390k(arrayList), i2, i3, this.hyE, new C16114a<C16113b>() {
                    /* renamed from: a */
                    public final /* synthetic */ void mo9731a(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(130837);
                        C16113b c16113b = (C16113b) c1207m;
                        C4990ab.m7411d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        if (i != 0 || i2 != 0) {
                            c103081.mo6088P(-1, "confirm cgi fail");
                            AppMethodBeat.m2505o(130837);
                        } else if (i3 == 2) {
                            C4990ab.m7410d("MicroMsg.JsApiAuthorize", "press reject button");
                            AppMethodBeat.m2505o(130837);
                        } else {
                            avv Qt = c16113b.mo28559Qt();
                            int i3 = Qt.wzH.cyE;
                            String str2 = Qt.wzH.cyF;
                            C4990ab.m7417i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", Integer.valueOf(i3));
                            if (i3 == 0) {
                                c103081.onSuccess();
                                AppMethodBeat.m2505o(130837);
                                return;
                            }
                            C4990ab.m7413e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", str2);
                            c103081.mo6088P(i3, str2);
                            AppMethodBeat.m2505o(130837);
                        }
                    }
                });
                if (c30907a.mo28558Qs().wzG == null) {
                    c30907a.mo28558Qs().wzG = new cxh();
                }
                c30907a.mo28558Qs().wzG.xsJ = this.hCf;
                C1720g.m3540Rg().mo14541a(c30907a, 0);
            }
            AppMethodBeat.m2505o(130839);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130840);
            aBW();
            if (!this.hBR.isRunning()) {
                this.hBS.aCB();
                AppMethodBeat.m2505o(130840);
            } else if (this.hBV.equals("ok")) {
                this.hBQ.mo53782b(this.hBR, this.hwi, "ok");
                this.hBS.aCB();
                AppMethodBeat.m2505o(130840);
            } else if (this.hBV.equals("fail")) {
                String format;
                if (C5046bo.isNullOrNil(this.aIm)) {
                    format = String.format("fail:login error %s", new Object[]{Integer.valueOf(this.errCode)});
                } else {
                    format = String.format("fail:%s", new Object[]{this.aIm});
                }
                this.hBQ.mo53782b(this.hBR, this.hwi, format);
                this.hBS.aCB();
                AppMethodBeat.m2505o(130840);
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
                            C4990ab.m7413e("MicroMsg.JsApiAuthorize", "IOException %s", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                            this.hBQ.mo53782b(this.hBR, this.hwi, "fail:internal error scope error");
                            this.hBS.aCB();
                            AppMethodBeat.m2505o(130840);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        C5004al.m7441d(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize$AuthorizeTask$2$1 */
                            class C103101 implements C33585d {
                                C103101() {
                                }

                                /* renamed from: a */
                                public final void mo21761a(int i, ArrayList<String> arrayList) {
                                    AppMethodBeat.m2504i(130833);
                                    Object obj = C37400c.m63004C(arrayList).size() > 0 ? (String) arrayList.get(0) : "";
                                    ArrayList arrayList2;
                                    switch (i) {
                                        case 1:
                                            arrayList2 = new ArrayList();
                                            arrayList2.add(obj);
                                            AuthorizeTask.m17986a(AuthorizeTask.this, 1, arrayList2);
                                            C4990ab.m7416i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                                            AppMethodBeat.m2505o(130833);
                                            return;
                                        case 2:
                                            arrayList2 = new ArrayList();
                                            arrayList2.add(obj);
                                            AuthorizeTask.m17986a(AuthorizeTask.this, 2, arrayList2);
                                            C4990ab.m7416i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                                            AppMethodBeat.m2505o(130833);
                                            return;
                                        case 3:
                                            AuthorizeTask.m17993f(AuthorizeTask.this);
                                            C4990ab.m7416i("MicroMsg.JsApiAuthorize", "user cancel");
                                            break;
                                    }
                                    AppMethodBeat.m2505o(130833);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(130834);
                                buj buj = (buj) linkedList.get(0);
                                C6750i runtime = AuthorizeTask.this.hBR.getRuntime();
                                boolean a = C19662m.m30459a(buj.vOF, runtime.mo15034ye());
                                C33586h c33586h = new C33586h(runtime.asV().getContext(), new C103101());
                                c33586h.mo54099Ez(runtime.mo15034ye().cwz);
                                c33586h.mo54095EC(AuthorizeTask.this.hBY);
                                c33586h.mo54093EA(buj.Desc);
                                c33586h.mo54096ED(AuthorizeTask.this.hBZ);
                                c33586h.mo54097EE(AuthorizeTask.this.hCa);
                                c33586h.mo54101jl(AuthorizeTask.this.hBX);
                                if ("scope.userInfo".equals(buj.vOF)) {
                                    C26927a c26927a = C38263e.hBN;
                                    C26927a.m42880a(AuthorizeTask.this.hBR.getContext(), C41732d.m73528qi(AuthorizeTask.this.hCb), AuthorizeTask.this.hCc, buj.vOF, c33586h);
                                } else {
                                    c33586h.mo54098EF(buj.vOF);
                                }
                                if (a) {
                                    if (TextUtils.isEmpty(C19662m.m30458a(buj.vOF, runtime))) {
                                        AuthorizeTask.m17987a(AuthorizeTask.this, "fail:require permission desc");
                                        C4990ab.m7416i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                                        AppMethodBeat.m2505o(130834);
                                        return;
                                    }
                                    c33586h.mo54094EB(C19662m.m30458a(buj.vOF, runtime));
                                }
                                C4990ab.m7417i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", buj.vOF, buj.Desc, buj.wze, buj.iyZ);
                                runtime.gNG.mo6468b(c33586h);
                                AppMethodBeat.m2505o(130834);
                            }
                        });
                        AppMethodBeat.m2505o(130840);
                        return;
                    }
                    this.hBQ.mo53782b(this.hBR, this.hwi, "fail:internal error scope empty");
                    this.hBS.aCB();
                }
                AppMethodBeat.m2505o(130840);
            }
        }

        /* renamed from: AH */
        private void m17984AH(String str) {
            AppMethodBeat.m2504i(130841);
            if (TextUtils.isEmpty(str)) {
                this.hBQ.mo53782b(this.hBR, this.hwi, "fail auth cancel");
            } else {
                this.hBQ.mo53782b(this.hBR, this.hwi, str);
            }
            this.hBS.aCB();
            AppMethodBeat.m2505o(130841);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130842);
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
            AppMethodBeat.m2505o(130842);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130843);
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
            AppMethodBeat.m2505o(130843);
        }

        static {
            AppMethodBeat.m2504i(130852);
            AppMethodBeat.m2505o(130852);
        }

        /* renamed from: a */
        static /* synthetic */ void m17986a(AuthorizeTask authorizeTask, int i, ArrayList arrayList) {
            AppMethodBeat.m2504i(130849);
            authorizeTask.hBU = "authorizeConfirm";
            authorizeTask.hBT = arrayList;
            authorizeTask.hBW = i;
            AppBrandMainProcessService.m54349a((MainProcessTask) authorizeTask);
            if (i == 2) {
                authorizeTask.hBQ.mo53782b(authorizeTask.hBR, authorizeTask.hwi, "fail auth deny");
                authorizeTask.hBS.aCB();
            }
            AppMethodBeat.m2505o(130849);
        }

        /* renamed from: f */
        static /* synthetic */ void m17993f(AuthorizeTask authorizeTask) {
            AppMethodBeat.m2504i(130850);
            authorizeTask.m17984AH("");
            AppMethodBeat.m2505o(130850);
        }
    }

    /* renamed from: a */
    public final void mo21765a(C33327h c33327h, JSONObject jSONObject, int i, C2227d c2227d) {
        AppMethodBeat.m2504i(130853);
        C4990ab.m7410d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        MainProcessTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = c33327h.getAppId();
        authorizeTask.hBU = NAME;
        C16597h ye = c33327h.getRuntime().mo15034ye();
        if (ye != null) {
            authorizeTask.har = ye.hhd.gVt;
        }
        AppBrandStatObject wK = C10048a.m17637wK(c33327h.getAppId());
        if (wK != null) {
            authorizeTask.hyE = wK.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.hBQ = this;
        authorizeTask.hBR = c33327h;
        authorizeTask.data = jSONObject2;
        authorizeTask.hwi = i;
        authorizeTask.hBS = c2227d;
        authorizeTask.hCe = new Bundle();
        if (c33327h instanceof C38492q) {
            authorizeTask.hCf = 1;
        } else if (c33327h instanceof C44709u) {
            authorizeTask.hCf = 2;
        }
        authorizeTask.aBV();
        AppBrandMainProcessService.m54349a(authorizeTask);
        AppMethodBeat.m2505o(130853);
    }
}
