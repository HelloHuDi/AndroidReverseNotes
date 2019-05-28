package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiRefreshSession extends a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    public static class RefreshSessionTask extends MainProcessTask {
        public static final Creator<RefreshSessionTask> CREATOR = new Creator<RefreshSessionTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RefreshSessionTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130542);
                RefreshSessionTask refreshSessionTask = new RefreshSessionTask(parcel);
                AppMethodBeat.o(130542);
                return refreshSessionTask;
            }
        };
        String appId;
        private String errorMsg;
        private int har;
        int hwi;
        m hwj;
        c hxS;
        private int hyB;
        private int hyC;
        private int hyD;
        int hyE;

        static /* synthetic */ boolean a(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(130548);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.o(130548);
            return aCb;
        }

        static /* synthetic */ boolean b(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(130549);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.o(130549);
            return aCb;
        }

        static /* synthetic */ boolean d(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(130550);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.o(130550);
            return aCb;
        }

        static /* synthetic */ boolean e(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.i(130551);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.o(130551);
            return aCb;
        }

        public RefreshSessionTask(Parcel parcel) {
            AppMethodBeat.i(130543);
            g(parcel);
            AppMethodBeat.o(130543);
        }

        public final void asP() {
            AppMethodBeat.i(130544);
            aBV();
            a aVar = new a();
            aVar.fsJ = new awe();
            aVar.fsK = new awf();
            aVar.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
            aVar.fsI = 1196;
            aVar.fsL = 0;
            aVar.fsM = 0;
            awe awe = new awe();
            awe.fKh = this.appId;
            awe.wzF = this.har;
            aVar.fsJ = awe;
            if (this.hyE > 0) {
                awe.wzG = new cxh();
                awe.wzG.scene = this.hyE;
            }
            ab.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.hyE));
            w.a(aVar.acD(), new w.a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(130541);
                    ab.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        awf awf = (awf) bVar.fsH.fsP;
                        if (awf == null) {
                            RefreshSessionTask.this.hyD = 0;
                            ab.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                            RefreshSessionTask.b(RefreshSessionTask.this);
                        } else {
                            RefreshSessionTask.this.hyC = awf.wzH.cyE;
                            RefreshSessionTask.this.errorMsg = awf.wzH.cyF;
                            if (RefreshSessionTask.this.hyC == 0) {
                                RefreshSessionTask.this.hyB = awf.wzV;
                                RefreshSessionTask.this.hyC = awf.wzH.cyE;
                                RefreshSessionTask.this.hyD = 1;
                                RefreshSessionTask.d(RefreshSessionTask.this);
                            } else {
                                RefreshSessionTask.this.hyC = awf.wzH.cyE;
                                RefreshSessionTask.this.hyD = 2;
                                ab.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", str);
                                RefreshSessionTask.e(RefreshSessionTask.this);
                            }
                        }
                        AppMethodBeat.o(130541);
                    } else {
                        RefreshSessionTask.this.hyD = 0;
                        RefreshSessionTask.this.errorMsg = "cgi fail";
                        RefreshSessionTask.a(RefreshSessionTask.this);
                        AppMethodBeat.o(130541);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.o(130544);
        }

        public final void asQ() {
            AppMethodBeat.i(130545);
            HashMap hashMap = new HashMap();
            String str;
            switch (this.hyD) {
                case 1:
                    hashMap.put("expireIn", this.hyB);
                    hashMap.put("errCode", this.hyC);
                    this.hxS.M(this.hwi, this.hwj.j("ok", hashMap));
                    break;
                case 2:
                    if (bo.isNullOrNil(this.errorMsg)) {
                        str = "fail";
                    } else {
                        str = String.format("fail:%s", new Object[]{this.errorMsg});
                    }
                    hashMap.put("errCode", this.hyC);
                    this.hxS.M(this.hwi, this.hwj.j(str, hashMap));
                    break;
                default:
                    if (bo.isNullOrNil(this.errorMsg)) {
                        str = "fail";
                    } else {
                        str = String.format("fail:%s", new Object[]{this.errorMsg});
                    }
                    hashMap.put("errCode", "-1");
                    this.hxS.M(this.hwi, this.hwj.j(str, hashMap));
                    break;
            }
            aBW();
            AppMethodBeat.o(130545);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130546);
            this.hyB = parcel.readInt();
            this.hyC = parcel.readInt();
            this.hyD = parcel.readInt();
            this.hwi = parcel.readInt();
            this.appId = parcel.readString();
            this.har = parcel.readInt();
            this.hyE = parcel.readInt();
            this.errorMsg = parcel.readString();
            AppMethodBeat.o(130546);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130547);
            parcel.writeInt(this.hyB);
            parcel.writeInt(this.hyC);
            parcel.writeInt(this.hyD);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.appId);
            parcel.writeInt(this.har);
            parcel.writeInt(this.hyE);
            parcel.writeString(this.errorMsg);
            AppMethodBeat.o(130547);
        }

        static {
            AppMethodBeat.i(130552);
            AppMethodBeat.o(130552);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130553);
        MainProcessTask refreshSessionTask = new RefreshSessionTask();
        h hVar = (h) cVar.aa(h.class);
        if (hVar != null) {
            refreshSessionTask.har = hVar.hhd.gVt;
        }
        String appId = cVar.getAppId();
        refreshSessionTask.hwj = this;
        refreshSessionTask.hxS = cVar;
        refreshSessionTask.hwi = i;
        refreshSessionTask.appId = appId;
        AppBrandStatObject wK = com.tencent.mm.plugin.appbrand.a.wK(appId);
        if (wK != null) {
            refreshSessionTask.hyE = wK.scene;
        }
        refreshSessionTask.aBV();
        AppBrandMainProcessService.a(refreshSessionTask);
        AppMethodBeat.o(130553);
    }
}
