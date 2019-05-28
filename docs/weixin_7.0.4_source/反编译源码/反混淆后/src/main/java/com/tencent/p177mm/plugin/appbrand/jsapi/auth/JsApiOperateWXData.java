package com.tencent.p177mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.C38263e.C26927a;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.C38263e.C38262b;
import com.tencent.p177mm.plugin.appbrand.p904k.C38409c;
import com.tencent.p177mm.plugin.appbrand.p904k.C38409c.C10566a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33586h.C33585d;
import com.tencent.p177mm.protocal.protobuf.awd;
import com.tencent.p177mm.protocal.protobuf.buj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData */
public final class JsApiOperateWXData extends C33245f {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData$OperateWXDataTask */
    static class OperateWXDataTask extends MainProcessTask {
        public static final Creator<OperateWXDataTask> CREATOR = new C103253();
        public String appId;
        C33245f hBQ;
        C33327h hBR;
        C2227d hBS;
        public String hBU;
        public String hBV;
        public int hBW;
        public String hBX;
        public String hBY;
        public String hBZ;
        public String hCa;
        public String hCb = "";
        public String hCc = "";
        public int hCd;
        public Bundle hCe;
        int hCf;
        public String hCo;
        public String hCp;
        public String hCq;
        public int har;
        public int hwi;
        int hyE;
        public String mAppName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData$OperateWXDataTask$1 */
        class C103231 implements C10326a {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData$OperateWXDataTask$1$1 */
            class C103241 implements C38262b {
                C103241() {
                }

                /* renamed from: AQ */
                public final void mo21759AQ(String str) {
                    AppMethodBeat.m2504i(130875);
                    OperateWXDataTask.this.hCb = str;
                    OperateWXDataTask.m18018d(OperateWXDataTask.this);
                    AppMethodBeat.m2505o(130875);
                }
            }

            C103231() {
            }

            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(130876);
                C4990ab.m7410d("MicroMsg.JsApiOperateWXData", "onSuccess !");
                OperateWXDataTask.this.hCp = str;
                OperateWXDataTask.this.hBV = "ok";
                OperateWXDataTask.m18015a(OperateWXDataTask.this);
                AppMethodBeat.m2505o(130876);
            }

            /* renamed from: lo */
            public final void mo21774lo(String str) {
                AppMethodBeat.m2504i(130877);
                C4990ab.m7412e("MicroMsg.JsApiOperateWXData", "onFailure !");
                OperateWXDataTask.this.hBV = "fail:".concat(String.valueOf(str));
                OperateWXDataTask.m18016b(OperateWXDataTask.this);
                AppMethodBeat.m2505o(130877);
            }

            /* renamed from: a */
            public final void mo21773a(LinkedList<buj> linkedList, String str, String str2) {
                AppMethodBeat.m2504i(130878);
                C4990ab.m7410d("MicroMsg.JsApiOperateWXData", "onConfirm !");
                OperateWXDataTask.this.hCd = linkedList.size();
                int i = 0;
                while (i < OperateWXDataTask.this.hCd) {
                    try {
                        OperateWXDataTask.this.hCe.putByteArray(String.valueOf(i), ((buj) linkedList.get(i)).toByteArray());
                        i++;
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.JsApiOperateWXData", "IOException %s", e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                        OperateWXDataTask.this.hBV = "fail";
                        OperateWXDataTask.m18017c(OperateWXDataTask.this);
                        AppMethodBeat.m2505o(130878);
                        return;
                    }
                }
                OperateWXDataTask.this.mAppName = str;
                OperateWXDataTask.this.hBX = str2;
                OperateWXDataTask.this.hBV = "needConfirm";
                if (linkedList.size() <= 0 || !"scope.userInfo".equals(((buj) linkedList.get(0)).vOF)) {
                    OperateWXDataTask.m18019e(OperateWXDataTask.this);
                    AppMethodBeat.m2505o(130878);
                    return;
                }
                OperateWXDataTask.this.hCc = C1853r.m3820YB();
                C4990ab.m7416i("MicroMsg.JsApiOperateWXData", "userNickName=" + (OperateWXDataTask.this.hCc == null ? "" : OperateWXDataTask.this.hCc));
                String Yz = C1853r.m3846Yz();
                C26927a c26927a = C38263e.hBN;
                C26927a.m42881a(Yz, new C103241());
                AppMethodBeat.m2505o(130878);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData$OperateWXDataTask$3 */
        static class C103253 implements Creator<OperateWXDataTask> {
            C103253() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateWXDataTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130881);
                OperateWXDataTask operateWXDataTask = new OperateWXDataTask(parcel);
                AppMethodBeat.m2505o(130881);
                return operateWXDataTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData$OperateWXDataTask$a */
        public interface C10326a {
            /* renamed from: a */
            void mo21773a(LinkedList<buj> linkedList, String str, String str2);

            /* renamed from: lo */
            void mo21774lo(String str);

            void onSuccess(String str);
        }

        /* renamed from: a */
        static /* synthetic */ boolean m18015a(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.m2504i(130889);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.m2505o(130889);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m18016b(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.m2504i(130890);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.m2505o(130890);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m18017c(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.m2504i(130891);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.m2505o(130891);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m18018d(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.m2504i(130892);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.m2505o(130892);
            return aCb;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m18019e(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.m2504i(130893);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.m2505o(130893);
            return aCb;
        }

        public OperateWXDataTask(Parcel parcel) {
            AppMethodBeat.m2504i(130883);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130883);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130884);
            C103231 c103231 = new C103231();
            if (this.hBU.equals(JsApiOperateWXData.NAME)) {
                m18014a(this.appId, this.hCo, "", this.har, this.hBW, c103231);
                AppMethodBeat.m2505o(130884);
                return;
            }
            if (this.hBU.equals("operateWXDataConfirm")) {
                m18014a(this.appId, this.hCo, this.hCq, this.har, this.hBW, c103231);
            }
            AppMethodBeat.m2505o(130884);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130885);
            aBW();
            if (!this.hBR.isRunning()) {
                this.hBS.aCB();
                AppMethodBeat.m2505o(130885);
            } else if (this.hBV.equals("ok")) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", this.hCp);
                this.hBR.mo6107M(this.hwi, this.hBQ.mo73394j("ok", hashMap));
                this.hBS.aCB();
                AppMethodBeat.m2505o(130885);
            } else if (this.hBV.contains("fail")) {
                this.hBQ.mo53782b(this.hBR, this.hwi, this.hBV);
                this.hBS.aCB();
                AppMethodBeat.m2505o(130885);
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
                            C4990ab.m7413e("MicroMsg.JsApiOperateWXData", "IOException %s", e.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                            this.hBQ.mo53782b(this.hBR, this.hwi, "fail");
                            this.hBS.aCB();
                            AppMethodBeat.m2505o(130885);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        C5004al.m7441d(new Runnable() {

                            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData$OperateWXDataTask$2$1 */
                            class C103221 implements C33585d {
                                C103221() {
                                }

                                /* renamed from: a */
                                public final void mo21761a(int i, ArrayList<String> arrayList) {
                                    AppMethodBeat.m2504i(130879);
                                    C4990ab.m7417i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            OperateWXDataTask.this.hBU = "operateWXDataConfirm";
                                            OperateWXDataTask.this.hCq = arrayList.size() > 0 ? (String) arrayList.get(0) : "";
                                            OperateWXDataTask.this.hBW = i;
                                            AppBrandMainProcessService.m54349a(OperateWXDataTask.this);
                                            if (i == 2) {
                                                OperateWXDataTask.this.hBQ.mo53782b(OperateWXDataTask.this.hBR, OperateWXDataTask.this.hwi, "fail auth deny");
                                                OperateWXDataTask.this.hBS.aCB();
                                                AppMethodBeat.m2505o(130879);
                                                return;
                                            }
                                            break;
                                        default:
                                            C4990ab.m7410d("MicroMsg.JsApiOperateWXData", "press back button!");
                                            OperateWXDataTask.this.hBQ.mo53782b(OperateWXDataTask.this.hBR, OperateWXDataTask.this.hwi, "fail auth cancel");
                                            OperateWXDataTask.this.hBS.aCB();
                                            break;
                                    }
                                    AppMethodBeat.m2505o(130879);
                                }
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(130880);
                                buj buj = (buj) linkedList.getFirst();
                                C33586h c33586h = new C33586h(C33245f.m54389a(OperateWXDataTask.this.hBR), new C103221());
                                c33586h.mo54099Ez(OperateWXDataTask.this.mAppName);
                                c33586h.mo54093EA(buj.Desc);
                                c33586h.mo54095EC(OperateWXDataTask.this.hBY);
                                c33586h.mo54096ED(OperateWXDataTask.this.hBZ);
                                c33586h.mo54097EE(OperateWXDataTask.this.hCa);
                                c33586h.mo54101jl(OperateWXDataTask.this.hBX);
                                if ("scope.userInfo".equals(buj.vOF)) {
                                    C26927a c26927a = C38263e.hBN;
                                    C26927a.m42880a(OperateWXDataTask.this.hBR.getContext(), C41732d.m73528qi(OperateWXDataTask.this.hCb), OperateWXDataTask.this.hCc, buj.vOF, c33586h);
                                } else {
                                    c33586h.mo54098EF(buj.vOF);
                                }
                                OperateWXDataTask.this.hBR.asF().mo6468b(c33586h);
                                AppMethodBeat.m2505o(130880);
                            }
                        });
                        AppMethodBeat.m2505o(130885);
                        return;
                    }
                    this.hBQ.mo53782b(this.hBR, this.hwi, "fail");
                    this.hBS.aCB();
                }
                AppMethodBeat.m2505o(130885);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130886);
            this.appId = parcel.readString();
            this.hBV = parcel.readString();
            this.mAppName = parcel.readString();
            this.hBX = parcel.readString();
            this.hCo = parcel.readString();
            this.hCp = parcel.readString();
            this.hwi = parcel.readInt();
            this.hBU = parcel.readString();
            this.hCq = parcel.readString();
            this.hCd = parcel.readInt();
            this.hCe = parcel.readBundle(JsApiOperateWXData.class.getClassLoader());
            this.har = parcel.readInt();
            this.hBW = parcel.readInt();
            this.hyE = parcel.readInt();
            this.hCf = parcel.readInt();
            this.hCc = parcel.readString();
            this.hCb = parcel.readString();
            this.hCa = parcel.readString();
            this.hBZ = parcel.readString();
            this.hBY = parcel.readString();
            AppMethodBeat.m2505o(130886);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130887);
            parcel.writeString(this.appId);
            parcel.writeString(this.hBV);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.hBX);
            parcel.writeString(this.hCo);
            parcel.writeString(this.hCp);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.hBU);
            parcel.writeString(this.hCq);
            parcel.writeInt(this.hCd);
            parcel.writeBundle(this.hCe);
            parcel.writeInt(this.har);
            parcel.writeInt(this.hBW);
            parcel.writeInt(this.hyE);
            parcel.writeInt(this.hCf);
            parcel.writeString(this.hCc);
            parcel.writeString(this.hCb);
            parcel.writeString(this.hCa);
            parcel.writeString(this.hBZ);
            parcel.writeString(this.hBY);
            AppMethodBeat.m2505o(130887);
        }

        static {
            AppMethodBeat.m2504i(130894);
            AppMethodBeat.m2505o(130894);
        }

        /* renamed from: a */
        private void m18014a(String str, final String str2, String str3, int i, final int i2, final C10326a c10326a) {
            AppMethodBeat.m2504i(130888);
            C1207m c38409c = new C38409c(str, str2, str3, i, i2, this.hyE, new C10566a<C38409c>() {
                /* renamed from: a */
                public final /* synthetic */ void mo21778a(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(130882);
                    C38409c c38409c = (C38409c) c1207m;
                    C4990ab.m7411d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        c10326a.mo21774lo("");
                        AppMethodBeat.m2505o(130882);
                    } else if (i2 == 2) {
                        C4990ab.m7410d("MicroMsg.JsApiOperateWXData", "press reject button");
                        AppMethodBeat.m2505o(130882);
                    } else {
                        awd awd;
                        if (c38409c.ehh == null) {
                            awd = null;
                        } else {
                            awd = (awd) c38409c.ehh.fsH.fsP;
                        }
                        if (awd.wzH == null) {
                            C4990ab.m7410d("MicroMsg.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:" + str2);
                            c10326a.mo21774lo("internal error");
                            AppMethodBeat.m2505o(130882);
                            return;
                        }
                        int i3 = awd.wzH.cyE;
                        String str2 = awd.wzH.cyF;
                        buj buj = awd.wzS;
                        LinkedList linkedList = new LinkedList();
                        if (buj != null) {
                            linkedList.add(buj);
                        }
                        String str3 = awd.ncH;
                        String str4 = awd.vDm;
                        C4990ab.m7411d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", Integer.valueOf(i3));
                        if (i3 == -12000) {
                            OperateWXDataTask.this.hBY = awd.wzL;
                            OperateWXDataTask.this.hCa = awd.wzK;
                            OperateWXDataTask.this.hBZ = awd.wzJ;
                            c10326a.mo21773a(linkedList, str3, str4);
                            AppMethodBeat.m2505o(130882);
                        } else if (i3 != 0) {
                            C4990ab.m7413e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", str2);
                            c10326a.mo21774lo(str2);
                            AppMethodBeat.m2505o(130882);
                        } else if (awd.jBi == null) {
                            C4990ab.m7410d("MicroMsg.JsApiOperateWXData", "Data is null, enterData:" + str2);
                            c10326a.mo21774lo("internal error");
                            AppMethodBeat.m2505o(130882);
                        } else {
                            C4990ab.m7411d("MicroMsg.JsApiOperateWXData", "resp data %s", awd.jBi.dlY());
                            c10326a.onSuccess(r0);
                            AppMethodBeat.m2505o(130882);
                        }
                    }
                }
            });
            c38409c.mo61119pm(this.hCf);
            C1720g.m3540Rg().mo14541a(c38409c, 0);
            AppMethodBeat.m2505o(130888);
        }
    }

    /* renamed from: a */
    public final void mo21765a(C33327h c33327h, JSONObject jSONObject, int i, C2227d c2227d) {
        AppMethodBeat.m2504i(130895);
        try {
            String string = jSONObject.getString("data");
            MainProcessTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = c33327h.getAppId();
            operateWXDataTask.hBU = NAME;
            C16597h ye = c33327h.getRuntime().mo15034ye();
            if (ye != null) {
                operateWXDataTask.har = ye.hhd.gVt;
            }
            operateWXDataTask.hBQ = this;
            operateWXDataTask.hBR = c33327h;
            operateWXDataTask.hCo = string;
            operateWXDataTask.hwi = i;
            operateWXDataTask.hBS = c2227d;
            operateWXDataTask.hCe = new Bundle();
            AppBrandStatObject wK = C10048a.m17637wK(operateWXDataTask.appId);
            if (wK != null) {
                operateWXDataTask.hyE = wK.scene;
            }
            if (c33327h instanceof C38492q) {
                operateWXDataTask.hCf = 1;
            } else if (c33327h instanceof C44709u) {
                operateWXDataTask.hCf = 2;
            }
            operateWXDataTask.aBV();
            AppBrandMainProcessService.m54349a(operateWXDataTask);
            AppMethodBeat.m2505o(130895);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiOperateWXData", "Exception %s", e.getMessage());
            c33327h.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130895);
        }
    }
}
