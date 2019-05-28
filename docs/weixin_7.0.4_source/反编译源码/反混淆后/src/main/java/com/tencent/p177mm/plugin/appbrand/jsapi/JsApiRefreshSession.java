package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.protocal.protobuf.awe;
import com.tencent.p177mm.protocal.protobuf.awf;
import com.tencent.p177mm.protocal.protobuf.cxh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession */
public final class JsApiRefreshSession extends C10296a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession$RefreshSessionTask */
    public static class RefreshSessionTask extends MainProcessTask {
        public static final Creator<RefreshSessionTask> CREATOR = new C192732();
        String appId;
        private String errorMsg;
        private int har;
        int hwi;
        C45608m hwj;
        C2241c hxS;
        private int hyB;
        private int hyC;
        private int hyD;
        int hyE;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession$RefreshSessionTask$1 */
        class C192721 implements C1224a {
            C192721() {
            }

            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(130541);
                C4990ab.m7411d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    awf awf = (awf) c7472b.fsH.fsP;
                    if (awf == null) {
                        RefreshSessionTask.this.hyD = 0;
                        C4990ab.m7412e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
                        RefreshSessionTask.m29936b(RefreshSessionTask.this);
                    } else {
                        RefreshSessionTask.this.hyC = awf.wzH.cyE;
                        RefreshSessionTask.this.errorMsg = awf.wzH.cyF;
                        if (RefreshSessionTask.this.hyC == 0) {
                            RefreshSessionTask.this.hyB = awf.wzV;
                            RefreshSessionTask.this.hyC = awf.wzH.cyE;
                            RefreshSessionTask.this.hyD = 1;
                            RefreshSessionTask.m29940d(RefreshSessionTask.this);
                        } else {
                            RefreshSessionTask.this.hyC = awf.wzH.cyE;
                            RefreshSessionTask.this.hyD = 2;
                            C4990ab.m7413e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", str);
                            RefreshSessionTask.m29941e(RefreshSessionTask.this);
                        }
                    }
                    AppMethodBeat.m2505o(130541);
                } else {
                    RefreshSessionTask.this.hyD = 0;
                    RefreshSessionTask.this.errorMsg = "cgi fail";
                    RefreshSessionTask.m29934a(RefreshSessionTask.this);
                    AppMethodBeat.m2505o(130541);
                }
                return 0;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession$RefreshSessionTask$2 */
        static class C192732 implements Creator<RefreshSessionTask> {
            C192732() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RefreshSessionTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130542);
                RefreshSessionTask refreshSessionTask = new RefreshSessionTask(parcel);
                AppMethodBeat.m2505o(130542);
                return refreshSessionTask;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m29934a(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.m2504i(130548);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.m2505o(130548);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m29936b(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.m2504i(130549);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.m2505o(130549);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m29940d(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.m2504i(130550);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.m2505o(130550);
            return aCb;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m29941e(RefreshSessionTask refreshSessionTask) {
            AppMethodBeat.m2504i(130551);
            boolean aCb = refreshSessionTask.aCb();
            AppMethodBeat.m2505o(130551);
            return aCb;
        }

        public RefreshSessionTask(Parcel parcel) {
            AppMethodBeat.m2504i(130543);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130543);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130544);
            aBV();
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new awe();
            c1196a.fsK = new awf();
            c1196a.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
            c1196a.fsI = 1196;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            awe awe = new awe();
            awe.fKh = this.appId;
            awe.wzF = this.har;
            c1196a.fsJ = awe;
            if (this.hyE > 0) {
                awe.wzG = new cxh();
                awe.wzG.scene = this.hyE;
            }
            C4990ab.m7417i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", this.appId, Integer.valueOf(this.har), Integer.valueOf(this.hyE));
            C1226w.m2655a(c1196a.acD(), new C192721(), true);
            AppMethodBeat.m2505o(130544);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130545);
            HashMap hashMap = new HashMap();
            String str;
            switch (this.hyD) {
                case 1:
                    hashMap.put("expireIn", this.hyB);
                    hashMap.put("errCode", this.hyC);
                    this.hxS.mo6107M(this.hwi, this.hwj.mo73394j("ok", hashMap));
                    break;
                case 2:
                    if (C5046bo.isNullOrNil(this.errorMsg)) {
                        str = "fail";
                    } else {
                        str = String.format("fail:%s", new Object[]{this.errorMsg});
                    }
                    hashMap.put("errCode", this.hyC);
                    this.hxS.mo6107M(this.hwi, this.hwj.mo73394j(str, hashMap));
                    break;
                default:
                    if (C5046bo.isNullOrNil(this.errorMsg)) {
                        str = "fail";
                    } else {
                        str = String.format("fail:%s", new Object[]{this.errorMsg});
                    }
                    hashMap.put("errCode", "-1");
                    this.hxS.mo6107M(this.hwi, this.hwj.mo73394j(str, hashMap));
                    break;
            }
            aBW();
            AppMethodBeat.m2505o(130545);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130546);
            this.hyB = parcel.readInt();
            this.hyC = parcel.readInt();
            this.hyD = parcel.readInt();
            this.hwi = parcel.readInt();
            this.appId = parcel.readString();
            this.har = parcel.readInt();
            this.hyE = parcel.readInt();
            this.errorMsg = parcel.readString();
            AppMethodBeat.m2505o(130546);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130547);
            parcel.writeInt(this.hyB);
            parcel.writeInt(this.hyC);
            parcel.writeInt(this.hyD);
            parcel.writeInt(this.hwi);
            parcel.writeString(this.appId);
            parcel.writeInt(this.har);
            parcel.writeInt(this.hyE);
            parcel.writeString(this.errorMsg);
            AppMethodBeat.m2505o(130547);
        }

        static {
            AppMethodBeat.m2504i(130552);
            AppMethodBeat.m2505o(130552);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130553);
        MainProcessTask refreshSessionTask = new RefreshSessionTask();
        C16597h c16597h = (C16597h) c2241c.mo5937aa(C16597h.class);
        if (c16597h != null) {
            refreshSessionTask.har = c16597h.hhd.gVt;
        }
        String appId = c2241c.getAppId();
        refreshSessionTask.hwj = this;
        refreshSessionTask.hxS = c2241c;
        refreshSessionTask.hwi = i;
        refreshSessionTask.appId = appId;
        AppBrandStatObject wK = C10048a.m17637wK(appId);
        if (wK != null) {
            refreshSessionTask.hyE = wK.scene;
        }
        refreshSessionTask.aBV();
        AppBrandMainProcessService.m54349a(refreshSessionTask);
        AppMethodBeat.m2505o(130553);
    }
}
