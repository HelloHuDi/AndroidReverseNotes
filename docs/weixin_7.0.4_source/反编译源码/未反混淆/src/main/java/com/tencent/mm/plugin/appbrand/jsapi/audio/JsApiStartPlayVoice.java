package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiStartPlayVoice extends a<q> {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String hBd = null;
    private StartPlayVoice hBe;

    static class StartPlayVoice extends MainProcessTask {
        public static final Creator<StartPlayVoice> CREATOR = new Creator<StartPlayVoice>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartPlayVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130774);
                StartPlayVoice startPlayVoice = new StartPlayVoice(parcel);
                AppMethodBeat.o(130774);
                return startPlayVoice;
            }
        };
        public String czD;
        public boolean error = false;
        public String filePath;
        private q hwf;
        private int hwi;
        private m hwz;

        static /* synthetic */ boolean b(StartPlayVoice startPlayVoice) {
            AppMethodBeat.i(130780);
            boolean aCb = startPlayVoice.aCb();
            AppMethodBeat.o(130780);
            return aCb;
        }

        static /* synthetic */ boolean c(StartPlayVoice startPlayVoice) {
            AppMethodBeat.i(130781);
            boolean aCb = startPlayVoice.aCb();
            AppMethodBeat.o(130781);
            return aCb;
        }

        public StartPlayVoice(m mVar, q qVar, int i) {
            this.hwz = mVar;
            this.hwf = qVar;
            this.hwi = i;
        }

        public StartPlayVoice(Parcel parcel) {
            AppMethodBeat.i(130775);
            g(parcel);
            AppMethodBeat.o(130775);
        }

        public final void asP() {
            AppMethodBeat.i(130776);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(130773);
                    ((b) g.K(b.class)).a(StartPlayVoice.this.filePath, new h.a() {
                        public final void EA() {
                            AppMethodBeat.i(130771);
                            StartPlayVoice.this.error = false;
                            StartPlayVoice.b(StartPlayVoice.this);
                            AppMethodBeat.o(130771);
                        }
                    }, new h.b() {
                        public final void onError() {
                            AppMethodBeat.i(130772);
                            StartPlayVoice.this.error = true;
                            StartPlayVoice.c(StartPlayVoice.this);
                            AppMethodBeat.o(130772);
                        }
                    });
                    AppMethodBeat.o(130773);
                }
            });
            AppMethodBeat.o(130776);
        }

        public final void asQ() {
            AppMethodBeat.i(130777);
            HashMap hashMap = new HashMap();
            hashMap.put("localId", this.czD);
            this.hwf.M(this.hwi, this.hwz.j(this.error ? "fail" : "ok", hashMap));
            JsApiStartPlayVoice.hBd = null;
            AppMethodBeat.o(130777);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130778);
            this.czD = parcel.readString();
            this.filePath = parcel.readString();
            this.error = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(130778);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130779);
            parcel.writeString(this.czD);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
            AppMethodBeat.o(130779);
        }

        static {
            AppMethodBeat.i(130782);
            AppMethodBeat.o(130782);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130783);
        q qVar = (q) cVar;
        String bc = bo.bc(jSONObject.optString("filePath", null), jSONObject.optString("localId"));
        ab.i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", qVar.getAppId(), bc);
        if (bo.isNullOrNil(bc)) {
            qVar.M(i, j("fail_missing arguments", null));
            AppMethodBeat.o(130783);
            return;
        }
        File yg = qVar.asE().yg(bc);
        final u currentPageView = qVar.getCurrentPageView();
        if (yg == null || !yg.exists() || currentPageView == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(130783);
            return;
        }
        v.b y = v.Zp().y("JsApi@" + currentPageView.hashCode(), true);
        f.b bVar = (f.b) y.get("onBackgroundListener", null);
        if (bVar == null) {
            bVar = new f.b() {
                public final void wW() {
                    AppMethodBeat.i(130769);
                    JsApiStopPlayVoice.aCx();
                    currentPageView.b((f.b) this);
                    AppMethodBeat.o(130769);
                }
            };
            y.j("onBackgroundListener", bVar);
        }
        currentPageView.a(bVar);
        if (((f.c) y.get("onDestroyListener", null)) == null) {
            AnonymousClass2 anonymousClass2 = new f.c() {
                public final void onDestroy() {
                    AppMethodBeat.i(130770);
                    JsApiStopPlayVoice.aCx();
                    currentPageView.b((f.c) this);
                    v.b nV = v.Zp().nV("JsApi@" + currentPageView.hashCode());
                    if (nV != null) {
                        nV.recycle();
                    }
                    AppMethodBeat.o(130770);
                }
            };
            y.j("onDestroyListener", anonymousClass2);
            currentPageView.a((f.c) anonymousClass2);
        }
        if (this.hBe == null) {
            this.hBe = new StartPlayVoice(this, qVar, i);
        }
        if (hBd != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("localId", this.hBe.czD);
            qVar.M(this.hBe.hwi, j("fail", hashMap));
            AppMethodBeat.o(130783);
            return;
        }
        this.hBe.hwz = this;
        this.hBe.hwf = qVar;
        this.hBe.hwi = i;
        this.hBe.czD = bc;
        this.hBe.filePath = yg.getAbsolutePath();
        AppBrandMainProcessService.a(this.hBe);
        hBd = bc;
        AppMethodBeat.o(130783);
    }
}
