package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiCheckIsSupportFaceDetect extends a {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask hCW = null;

    static class GetIsSupportFaceTask extends MainProcessTask {
        public static final Creator<GetIsSupportFaceTask> CREATOR = new Creator<GetIsSupportFaceTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportFaceTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(3193);
                GetIsSupportFaceTask getIsSupportFaceTask = new GetIsSupportFaceTask(parcel);
                AppMethodBeat.o(3193);
                return getIsSupportFaceTask;
            }
        };
        private String aIm = "not returned";
        private int bOs = -1;
        private boolean cOQ = false;
        private int errCode = -1;
        private JsApiCheckIsSupportFaceDetect hCX;
        private int hCY = -1;
        private c hzz = null;

        public final void asQ() {
            AppMethodBeat.i(3194);
            super.asQ();
            ab.d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", Boolean.valueOf(this.cOQ), Integer.valueOf(this.errCode), this.aIm, Integer.valueOf(this.hCY));
            HashMap hashMap = new HashMap(3);
            hashMap.put("errCode", Integer.valueOf(this.errCode));
            hashMap.put("libVersionCode", Integer.valueOf(this.hCY));
            if (this.errCode == 0) {
                this.hzz.M(this.bOs, this.hCX.j("ok", hashMap));
            } else {
                this.hzz.M(this.bOs, this.hCX.j("fail " + this.aIm, hashMap));
            }
            h.at(this);
            AppMethodBeat.o(3194);
        }

        public final void asP() {
            AppMethodBeat.i(3195);
            ht htVar = new ht();
            com.tencent.mm.sdk.b.a.xxA.m(htVar);
            this.cOQ = htVar.cCH.cCI;
            this.errCode = htVar.cCH.cCJ;
            this.aIm = htVar.cCH.cCK;
            this.hCY = htVar.cCH.cCL;
            ab.i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", Boolean.valueOf(this.cOQ), Integer.valueOf(this.errCode), this.aIm, Integer.valueOf(this.hCY));
            aCb();
            AppMethodBeat.o(3195);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(3196);
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.cOQ ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.aIm);
            parcel.writeInt(this.hCY);
            AppMethodBeat.o(3196);
        }

        public GetIsSupportFaceTask(c cVar, int i, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
            this.hzz = cVar;
            this.bOs = i;
            this.hCX = jsApiCheckIsSupportFaceDetect;
        }

        protected GetIsSupportFaceTask(Parcel parcel) {
            AppMethodBeat.i(3197);
            g(parcel);
            AppMethodBeat.o(3197);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(3198);
            super.g(parcel);
            this.cOQ = parcel.readByte() != (byte) 0;
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            this.hCY = parcel.readInt();
            AppMethodBeat.o(3198);
        }

        static {
            AppMethodBeat.i(3199);
            AppMethodBeat.o(3199);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(3200);
        ab.i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.hCW = new GetIsSupportFaceTask(cVar, i, this);
        h.bB(this.hCW);
        AppBrandMainProcessService.a(this.hCW);
        AppMethodBeat.o(3200);
    }
}
