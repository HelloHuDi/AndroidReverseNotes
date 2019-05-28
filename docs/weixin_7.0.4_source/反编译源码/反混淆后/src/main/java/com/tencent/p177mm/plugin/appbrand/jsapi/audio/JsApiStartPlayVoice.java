package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p183ai.C17891h.C17889a;
import com.tencent.p177mm.p183ai.C17891h.C17892b;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C38157b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice */
public final class JsApiStartPlayVoice extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";
    public static String hBd = null;
    private StartPlayVoice hBe;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice$StartPlayVoice */
    static class StartPlayVoice extends MainProcessTask {
        public static final Creator<StartPlayVoice> CREATOR = new C103012();
        public String czD;
        public boolean error = false;
        public String filePath;
        private C38492q hwf;
        private int hwi;
        private C45608m hwz;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice$StartPlayVoice$2 */
        static class C103012 implements Creator<StartPlayVoice> {
            C103012() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartPlayVoice[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130774);
                StartPlayVoice startPlayVoice = new StartPlayVoice(parcel);
                AppMethodBeat.m2505o(130774);
                return startPlayVoice;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice$StartPlayVoice$1 */
        class C269201 implements Runnable {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice$StartPlayVoice$1$1 */
            class C246951 implements C17889a {
                C246951() {
                }

                /* renamed from: EA */
                public final void mo17611EA() {
                    AppMethodBeat.m2504i(130771);
                    StartPlayVoice.this.error = false;
                    StartPlayVoice.m50541b(StartPlayVoice.this);
                    AppMethodBeat.m2505o(130771);
                }
            }

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice$StartPlayVoice$1$2 */
            class C269192 implements C17892b {
                C269192() {
                }

                public final void onError() {
                    AppMethodBeat.m2504i(130772);
                    StartPlayVoice.this.error = true;
                    StartPlayVoice.m50542c(StartPlayVoice.this);
                    AppMethodBeat.m2505o(130772);
                }
            }

            C269201() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130773);
                ((C38157b) C1720g.m3528K(C38157b.class)).mo44594a(StartPlayVoice.this.filePath, new C246951(), new C269192());
                AppMethodBeat.m2505o(130773);
            }
        }

        /* renamed from: b */
        static /* synthetic */ boolean m50541b(StartPlayVoice startPlayVoice) {
            AppMethodBeat.m2504i(130780);
            boolean aCb = startPlayVoice.aCb();
            AppMethodBeat.m2505o(130780);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m50542c(StartPlayVoice startPlayVoice) {
            AppMethodBeat.m2504i(130781);
            boolean aCb = startPlayVoice.aCb();
            AppMethodBeat.m2505o(130781);
            return aCb;
        }

        public StartPlayVoice(C45608m c45608m, C38492q c38492q, int i) {
            this.hwz = c45608m;
            this.hwf = c38492q;
            this.hwi = i;
        }

        public StartPlayVoice(Parcel parcel) {
            AppMethodBeat.m2504i(130775);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130775);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130776);
            C5004al.m7441d(new C269201());
            AppMethodBeat.m2505o(130776);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130777);
            HashMap hashMap = new HashMap();
            hashMap.put("localId", this.czD);
            this.hwf.mo6107M(this.hwi, this.hwz.mo73394j(this.error ? "fail" : "ok", hashMap));
            JsApiStartPlayVoice.hBd = null;
            AppMethodBeat.m2505o(130777);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130778);
            this.czD = parcel.readString();
            this.filePath = parcel.readString();
            this.error = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(130778);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130779);
            parcel.writeString(this.czD);
            parcel.writeString(this.filePath);
            parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
            AppMethodBeat.m2505o(130779);
        }

        static {
            AppMethodBeat.m2504i(130782);
            AppMethodBeat.m2505o(130782);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130783);
        C38492q c38492q = (C38492q) c2241c;
        String bc = C5046bo.m7532bc(jSONObject.optString("filePath", null), jSONObject.optString("localId"));
        C4990ab.m7417i("MicroMsg.JsApiStartPlayVoice", "doPlayVoice, appId : %s, localId : %s", c38492q.getAppId(), bc);
        if (C5046bo.isNullOrNil(bc)) {
            c38492q.mo6107M(i, mo73394j("fail_missing arguments", null));
            AppMethodBeat.m2505o(130783);
            return;
        }
        File yg = c38492q.asE().mo34314yg(bc);
        final C44709u currentPageView = c38492q.getCurrentPageView();
        if (yg == null || !yg.exists() || currentPageView == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130783);
            return;
        }
        C32800b y = C37922v.m64076Zp().mo60676y("JsApi@" + currentPageView.hashCode(), true);
        C10379b c10379b = (C10379b) y.get("onBackgroundListener", null);
        if (c10379b == null) {
            c10379b = new C10379b() {
                /* renamed from: wW */
                public final void mo21857wW() {
                    AppMethodBeat.m2504i(130769);
                    JsApiStopPlayVoice.aCx();
                    currentPageView.mo53832b((C10379b) this);
                    AppMethodBeat.m2505o(130769);
                }
            };
            y.mo53356j("onBackgroundListener", c10379b);
        }
        currentPageView.mo53827a(c10379b);
        if (((C10380c) y.get("onDestroyListener", null)) == null) {
            C332412 c332412 = new C10380c() {
                public final void onDestroy() {
                    AppMethodBeat.m2504i(130770);
                    JsApiStopPlayVoice.aCx();
                    currentPageView.mo53833b((C10380c) this);
                    C32800b nV = C37922v.m64076Zp().mo60674nV("JsApi@" + currentPageView.hashCode());
                    if (nV != null) {
                        nV.recycle();
                    }
                    AppMethodBeat.m2505o(130770);
                }
            };
            y.mo53356j("onDestroyListener", c332412);
            currentPageView.mo53828a((C10380c) c332412);
        }
        if (this.hBe == null) {
            this.hBe = new StartPlayVoice(this, c38492q, i);
        }
        if (hBd != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("localId", this.hBe.czD);
            c38492q.mo6107M(this.hBe.hwi, mo73394j("fail", hashMap));
            AppMethodBeat.m2505o(130783);
            return;
        }
        this.hBe.hwz = this;
        this.hBe.hwf = c38492q;
        this.hBe.hwi = i;
        this.hBe.czD = bc;
        this.hBe.filePath = yg.getAbsolutePath();
        AppBrandMainProcessService.m54349a(this.hBe);
        hBd = bc;
        AppMethodBeat.m2505o(130783);
    }
}
