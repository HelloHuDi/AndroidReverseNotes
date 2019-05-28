package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.protocal.protobuf.cli;
import com.tencent.p177mm.protocal.protobuf.clj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData */
public class JsApiUploadWeRunData extends C10296a {
    public static final int CTRL_INDEX = 323;
    public static final String NAME = "uploadWeRunData";
    private UploadMiniAppStepTask hzu;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData$UploadMiniAppStepTask */
    static class UploadMiniAppStepTask extends MainProcessTask {
        public static final Creator<UploadMiniAppStepTask> CREATOR = new C102932();
        private String appId;
        private boolean cwB;
        private int hwi;
        private C45608m hwz;
        private C2241c hxS;
        private int hzv;
        private boolean hzw;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData$UploadMiniAppStepTask$1 */
        class C102921 implements C1224a {
            C102921() {
            }

            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(130621);
                if (c1207m.getType() != 1949) {
                    AppMethodBeat.m2505o(130621);
                } else {
                    if (i == 0 && i2 == 0) {
                        UploadMiniAppStepTask.this.cwB = true;
                        C4990ab.m7410d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
                    } else {
                        UploadMiniAppStepTask.this.cwB = false;
                        C4990ab.m7417i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    }
                    UploadMiniAppStepTask.m17957a(UploadMiniAppStepTask.this);
                    AppMethodBeat.m2505o(130621);
                }
                return 0;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData$UploadMiniAppStepTask$2 */
        static class C102932 implements Creator<UploadMiniAppStepTask> {
            C102932() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMiniAppStepTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130622);
                UploadMiniAppStepTask uploadMiniAppStepTask = new UploadMiniAppStepTask(parcel);
                AppMethodBeat.m2505o(130622);
                return uploadMiniAppStepTask;
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m17957a(UploadMiniAppStepTask uploadMiniAppStepTask) {
            AppMethodBeat.m2504i(130629);
            boolean aCb = uploadMiniAppStepTask.aCb();
            AppMethodBeat.m2505o(130629);
            return aCb;
        }

        public UploadMiniAppStepTask(C45608m c45608m, C2241c c2241c, int i, int i2, boolean z) {
            AppMethodBeat.m2504i(130623);
            C4990ab.m7410d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
            this.hzv = i2;
            this.hzw = z;
            this.appId = c2241c.getAppId();
            AppMethodBeat.m2505o(130623);
        }

        public UploadMiniAppStepTask(Parcel parcel) {
            AppMethodBeat.m2504i(130624);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130624);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130625);
            long aaD = C1839cb.aaD();
            C4990ab.m7411d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", Long.valueOf(aaD / 1000));
            if (aaD == 0) {
                aaD = System.currentTimeMillis();
            }
            C1196a c1196a = new C1196a();
            cli cli = new cli();
            c1196a.fsJ = cli;
            c1196a.fsK = new clj();
            c1196a.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
            c1196a.fsI = 1949;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            cli.fKh = this.appId;
            cli.jCs = this.hzv;
            cli.xiZ = this.hzw;
            cli.nbj = (int) (aaD / 1000);
            C1226w.m2655a(c1196a.acD(), new C102921(), true);
            AppMethodBeat.m2505o(130625);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(130626);
            if (this.cwB) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
            } else {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail", null));
            }
            aBW();
            AppMethodBeat.m2505o(130626);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(130627);
            this.hzv = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.hzw = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.cwB = z2;
            this.appId = parcel.readString();
            AppMethodBeat.m2505o(130627);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.m2504i(130628);
            parcel.writeInt(this.hzv);
            if (this.hzw) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.cwB) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            parcel.writeString(this.appId);
            AppMethodBeat.m2505o(130628);
        }

        static {
            AppMethodBeat.m2504i(130630);
            AppMethodBeat.m2505o(130630);
        }
    }

    /* renamed from: a */
    public void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130631);
        C4990ab.m7410d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiUploadWeRunData", "data is null");
            AppMethodBeat.m2505o(130631);
            return;
        }
        mo60986a(this, c2241c, i, jSONObject.optInt("step"), false);
        AppMethodBeat.m2505o(130631);
    }

    /* renamed from: a */
    public final void mo60986a(C45608m c45608m, C2241c c2241c, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(130632);
        if (i2 <= 0) {
            c2241c.mo6107M(i, c45608m.mo73394j("fail:step invalid", null));
            AppMethodBeat.m2505o(130632);
            return;
        }
        this.hzu = new UploadMiniAppStepTask(c45608m, c2241c, i, i2, z);
        this.hzu.aBV();
        AppBrandMainProcessService.m54349a(this.hzu);
        AppMethodBeat.m2505o(130632);
    }
}
