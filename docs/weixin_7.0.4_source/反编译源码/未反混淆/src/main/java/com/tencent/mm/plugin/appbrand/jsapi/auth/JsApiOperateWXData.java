package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.b.h.d;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.buj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public final class JsApiOperateWXData extends f {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    static class OperateWXDataTask extends MainProcessTask {
        public static final Creator<OperateWXDataTask> CREATOR = new Creator<OperateWXDataTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateWXDataTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130881);
                OperateWXDataTask operateWXDataTask = new OperateWXDataTask(parcel);
                AppMethodBeat.o(130881);
                return operateWXDataTask;
            }
        };
        public String appId;
        f hBQ;
        h hBR;
        d hBS;
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

        public interface a {
            void a(LinkedList<buj> linkedList, String str, String str2);

            void lo(String str);

            void onSuccess(String str);
        }

        static /* synthetic */ boolean a(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(130889);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.o(130889);
            return aCb;
        }

        static /* synthetic */ boolean b(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(130890);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.o(130890);
            return aCb;
        }

        static /* synthetic */ boolean c(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(130891);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.o(130891);
            return aCb;
        }

        static /* synthetic */ boolean d(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(130892);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.o(130892);
            return aCb;
        }

        static /* synthetic */ boolean e(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(130893);
            boolean aCb = operateWXDataTask.aCb();
            AppMethodBeat.o(130893);
            return aCb;
        }

        public OperateWXDataTask(Parcel parcel) {
            AppMethodBeat.i(130883);
            g(parcel);
            AppMethodBeat.o(130883);
        }

        public final void asP() {
            AppMethodBeat.i(130884);
            AnonymousClass1 anonymousClass1 = new a() {
                public final void onSuccess(String str) {
                    AppMethodBeat.i(130876);
                    ab.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
                    OperateWXDataTask.this.hCp = str;
                    OperateWXDataTask.this.hBV = "ok";
                    OperateWXDataTask.a(OperateWXDataTask.this);
                    AppMethodBeat.o(130876);
                }

                public final void lo(String str) {
                    AppMethodBeat.i(130877);
                    ab.e("MicroMsg.JsApiOperateWXData", "onFailure !");
                    OperateWXDataTask.this.hBV = "fail:".concat(String.valueOf(str));
                    OperateWXDataTask.b(OperateWXDataTask.this);
                    AppMethodBeat.o(130877);
                }

                public final void a(LinkedList<buj> linkedList, String str, String str2) {
                    AppMethodBeat.i(130878);
                    ab.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
                    OperateWXDataTask.this.hCd = linkedList.size();
                    int i = 0;
                    while (i < OperateWXDataTask.this.hCd) {
                        try {
                            OperateWXDataTask.this.hCe.putByteArray(String.valueOf(i), ((buj) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (IOException e) {
                            ab.e("MicroMsg.JsApiOperateWXData", "IOException %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                            OperateWXDataTask.this.hBV = "fail";
                            OperateWXDataTask.c(OperateWXDataTask.this);
                            AppMethodBeat.o(130878);
                            return;
                        }
                    }
                    OperateWXDataTask.this.mAppName = str;
                    OperateWXDataTask.this.hBX = str2;
                    OperateWXDataTask.this.hBV = "needConfirm";
                    if (linkedList.size() <= 0 || !"scope.userInfo".equals(((buj) linkedList.get(0)).vOF)) {
                        OperateWXDataTask.e(OperateWXDataTask.this);
                        AppMethodBeat.o(130878);
                        return;
                    }
                    OperateWXDataTask.this.hCc = r.YB();
                    ab.i("MicroMsg.JsApiOperateWXData", "userNickName=" + (OperateWXDataTask.this.hCc == null ? "" : OperateWXDataTask.this.hCc));
                    String Yz = r.Yz();
                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a aVar = e.hBN;
                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a.a(Yz, new b() {
                        public final void AQ(String str) {
                            AppMethodBeat.i(130875);
                            OperateWXDataTask.this.hCb = str;
                            OperateWXDataTask.d(OperateWXDataTask.this);
                            AppMethodBeat.o(130875);
                        }
                    });
                    AppMethodBeat.o(130878);
                }
            };
            if (this.hBU.equals(JsApiOperateWXData.NAME)) {
                a(this.appId, this.hCo, "", this.har, this.hBW, anonymousClass1);
                AppMethodBeat.o(130884);
                return;
            }
            if (this.hBU.equals("operateWXDataConfirm")) {
                a(this.appId, this.hCo, this.hCq, this.har, this.hBW, anonymousClass1);
            }
            AppMethodBeat.o(130884);
        }

        public final void asQ() {
            AppMethodBeat.i(130885);
            aBW();
            if (!this.hBR.isRunning()) {
                this.hBS.aCB();
                AppMethodBeat.o(130885);
            } else if (this.hBV.equals("ok")) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", this.hCp);
                this.hBR.M(this.hwi, this.hBQ.j("ok", hashMap));
                this.hBS.aCB();
                AppMethodBeat.o(130885);
            } else if (this.hBV.contains("fail")) {
                this.hBQ.b(this.hBR, this.hwi, this.hBV);
                this.hBS.aCB();
                AppMethodBeat.o(130885);
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
                            ab.e("MicroMsg.JsApiOperateWXData", "IOException %s", e.getMessage());
                            ab.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                            this.hBQ.b(this.hBR, this.hwi, "fail");
                            this.hBS.aCB();
                            AppMethodBeat.o(130885);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130880);
                                buj buj = (buj) linkedList.getFirst();
                                com.tencent.mm.plugin.appbrand.widget.b.h hVar = new com.tencent.mm.plugin.appbrand.widget.b.h(f.a(OperateWXDataTask.this.hBR), new d() {
                                    public final void a(int i, ArrayList<String> arrayList) {
                                        AppMethodBeat.i(130879);
                                        ab.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", Integer.valueOf(i));
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                OperateWXDataTask.this.hBU = "operateWXDataConfirm";
                                                OperateWXDataTask.this.hCq = arrayList.size() > 0 ? (String) arrayList.get(0) : "";
                                                OperateWXDataTask.this.hBW = i;
                                                AppBrandMainProcessService.a(OperateWXDataTask.this);
                                                if (i == 2) {
                                                    OperateWXDataTask.this.hBQ.b(OperateWXDataTask.this.hBR, OperateWXDataTask.this.hwi, "fail auth deny");
                                                    OperateWXDataTask.this.hBS.aCB();
                                                    AppMethodBeat.o(130879);
                                                    return;
                                                }
                                                break;
                                            default:
                                                ab.d("MicroMsg.JsApiOperateWXData", "press back button!");
                                                OperateWXDataTask.this.hBQ.b(OperateWXDataTask.this.hBR, OperateWXDataTask.this.hwi, "fail auth cancel");
                                                OperateWXDataTask.this.hBS.aCB();
                                                break;
                                        }
                                        AppMethodBeat.o(130879);
                                    }
                                });
                                hVar.Ez(OperateWXDataTask.this.mAppName);
                                hVar.EA(buj.Desc);
                                hVar.EC(OperateWXDataTask.this.hBY);
                                hVar.ED(OperateWXDataTask.this.hBZ);
                                hVar.EE(OperateWXDataTask.this.hCa);
                                hVar.jl(OperateWXDataTask.this.hBX);
                                if ("scope.userInfo".equals(buj.vOF)) {
                                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a aVar = e.hBN;
                                    com.tencent.mm.plugin.appbrand.jsapi.auth.e.a.a(OperateWXDataTask.this.hBR.getContext(), com.tencent.mm.ah.d.qi(OperateWXDataTask.this.hCb), OperateWXDataTask.this.hCc, buj.vOF, hVar);
                                } else {
                                    hVar.EF(buj.vOF);
                                }
                                OperateWXDataTask.this.hBR.asF().b(hVar);
                                AppMethodBeat.o(130880);
                            }
                        });
                        AppMethodBeat.o(130885);
                        return;
                    }
                    this.hBQ.b(this.hBR, this.hwi, "fail");
                    this.hBS.aCB();
                }
                AppMethodBeat.o(130885);
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130886);
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
            AppMethodBeat.o(130886);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130887);
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
            AppMethodBeat.o(130887);
        }

        static {
            AppMethodBeat.i(130894);
            AppMethodBeat.o(130894);
        }

        private void a(String str, final String str2, String str3, int i, final int i2, final a aVar) {
            AppMethodBeat.i(130888);
            m cVar = new c(str, str2, str3, i, i2, this.hyE, new com.tencent.mm.plugin.appbrand.k.c.a<c>() {
                public final /* synthetic */ void a(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(130882);
                    c cVar = (c) mVar;
                    ab.d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        aVar.lo("");
                        AppMethodBeat.o(130882);
                    } else if (i2 == 2) {
                        ab.d("MicroMsg.JsApiOperateWXData", "press reject button");
                        AppMethodBeat.o(130882);
                    } else {
                        awd awd;
                        if (cVar.ehh == null) {
                            awd = null;
                        } else {
                            awd = (awd) cVar.ehh.fsH.fsP;
                        }
                        if (awd.wzH == null) {
                            ab.d("MicroMsg.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:" + str2);
                            aVar.lo("internal error");
                            AppMethodBeat.o(130882);
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
                        ab.d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", Integer.valueOf(i3));
                        if (i3 == -12000) {
                            OperateWXDataTask.this.hBY = awd.wzL;
                            OperateWXDataTask.this.hCa = awd.wzK;
                            OperateWXDataTask.this.hBZ = awd.wzJ;
                            aVar.a(linkedList, str3, str4);
                            AppMethodBeat.o(130882);
                        } else if (i3 != 0) {
                            ab.e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", str2);
                            aVar.lo(str2);
                            AppMethodBeat.o(130882);
                        } else if (awd.jBi == null) {
                            ab.d("MicroMsg.JsApiOperateWXData", "Data is null, enterData:" + str2);
                            aVar.lo("internal error");
                            AppMethodBeat.o(130882);
                        } else {
                            ab.d("MicroMsg.JsApiOperateWXData", "resp data %s", awd.jBi.dlY());
                            aVar.onSuccess(r0);
                            AppMethodBeat.o(130882);
                        }
                    }
                }
            });
            cVar.pm(this.hCf);
            g.Rg().a(cVar, 0);
            AppMethodBeat.o(130888);
        }
    }

    public final void a(h hVar, JSONObject jSONObject, int i, d dVar) {
        AppMethodBeat.i(130895);
        try {
            String string = jSONObject.getString("data");
            MainProcessTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = hVar.getAppId();
            operateWXDataTask.hBU = NAME;
            com.tencent.mm.plugin.appbrand.config.h ye = hVar.getRuntime().ye();
            if (ye != null) {
                operateWXDataTask.har = ye.hhd.gVt;
            }
            operateWXDataTask.hBQ = this;
            operateWXDataTask.hBR = hVar;
            operateWXDataTask.hCo = string;
            operateWXDataTask.hwi = i;
            operateWXDataTask.hBS = dVar;
            operateWXDataTask.hCe = new Bundle();
            AppBrandStatObject wK = a.wK(operateWXDataTask.appId);
            if (wK != null) {
                operateWXDataTask.hyE = wK.scene;
            }
            if (hVar instanceof q) {
                operateWXDataTask.hCf = 1;
            } else if (hVar instanceof u) {
                operateWXDataTask.hCf = 2;
            }
            operateWXDataTask.aBV();
            AppBrandMainProcessService.a(operateWXDataTask);
            AppMethodBeat.o(130895);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiOperateWXData", "Exception %s", e.getMessage());
            hVar.M(i, j("fail", null));
            AppMethodBeat.o(130895);
        }
    }
}
