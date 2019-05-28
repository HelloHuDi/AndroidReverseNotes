package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.clj;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class JsApiUploadWeRunData extends a {
    public static final int CTRL_INDEX = 323;
    public static final String NAME = "uploadWeRunData";
    private UploadMiniAppStepTask hzu;

    static class UploadMiniAppStepTask extends MainProcessTask {
        public static final Creator<UploadMiniAppStepTask> CREATOR = new Creator<UploadMiniAppStepTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UploadMiniAppStepTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130622);
                UploadMiniAppStepTask uploadMiniAppStepTask = new UploadMiniAppStepTask(parcel);
                AppMethodBeat.o(130622);
                return uploadMiniAppStepTask;
            }
        };
        private String appId;
        private boolean cwB;
        private int hwi;
        private m hwz;
        private c hxS;
        private int hzv;
        private boolean hzw;

        static /* synthetic */ boolean a(UploadMiniAppStepTask uploadMiniAppStepTask) {
            AppMethodBeat.i(130629);
            boolean aCb = uploadMiniAppStepTask.aCb();
            AppMethodBeat.o(130629);
            return aCb;
        }

        public UploadMiniAppStepTask(m mVar, c cVar, int i, int i2, boolean z) {
            AppMethodBeat.i(130623);
            ab.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
            this.hzv = i2;
            this.hzw = z;
            this.appId = cVar.getAppId();
            AppMethodBeat.o(130623);
        }

        public UploadMiniAppStepTask(Parcel parcel) {
            AppMethodBeat.i(130624);
            g(parcel);
            AppMethodBeat.o(130624);
        }

        public final void asP() {
            AppMethodBeat.i(130625);
            long aaD = cb.aaD();
            ab.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", Long.valueOf(aaD / 1000));
            if (aaD == 0) {
                aaD = System.currentTimeMillis();
            }
            a aVar = new a();
            cli cli = new cli();
            aVar.fsJ = cli;
            aVar.fsK = new clj();
            aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
            aVar.fsI = 1949;
            aVar.fsL = 0;
            aVar.fsM = 0;
            cli.fKh = this.appId;
            cli.jCs = this.hzv;
            cli.xiZ = this.hzw;
            cli.nbj = (int) (aaD / 1000);
            w.a(aVar.acD(), new w.a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(130621);
                    if (mVar.getType() != 1949) {
                        AppMethodBeat.o(130621);
                    } else {
                        if (i == 0 && i2 == 0) {
                            UploadMiniAppStepTask.this.cwB = true;
                            ab.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
                        } else {
                            UploadMiniAppStepTask.this.cwB = false;
                            ab.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                        }
                        UploadMiniAppStepTask.a(UploadMiniAppStepTask.this);
                        AppMethodBeat.o(130621);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.o(130625);
        }

        public final void asQ() {
            AppMethodBeat.i(130626);
            if (this.cwB) {
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
            } else {
                this.hxS.M(this.hwi, this.hwz.j("fail", null));
            }
            aBW();
            AppMethodBeat.o(130626);
        }

        public final void g(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(130627);
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
            AppMethodBeat.o(130627);
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            AppMethodBeat.i(130628);
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
            AppMethodBeat.o(130628);
        }

        static {
            AppMethodBeat.i(130630);
            AppMethodBeat.o(130630);
        }
    }

    public void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130631);
        ab.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiUploadWeRunData", "data is null");
            AppMethodBeat.o(130631);
            return;
        }
        a(this, cVar, i, jSONObject.optInt("step"), false);
        AppMethodBeat.o(130631);
    }

    public final void a(m mVar, c cVar, int i, int i2, boolean z) {
        AppMethodBeat.i(130632);
        if (i2 <= 0) {
            cVar.M(i, mVar.j("fail:step invalid", null));
            AppMethodBeat.o(130632);
            return;
        }
        this.hzu = new UploadMiniAppStepTask(mVar, cVar, i, i2, z);
        this.hzu.aBV();
        AppBrandMainProcessService.a(this.hzu);
        AppMethodBeat.o(130632);
    }
}
