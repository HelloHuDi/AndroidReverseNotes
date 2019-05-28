package com.tencent.p177mm.plugin.appbrand.jsapi.bio.face;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32571ht;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19680h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect */
public final class JsApiCheckIsSupportFaceDetect extends C10296a {
    public static final int CTRL_INDEX = 214;
    public static final String NAME = "checkIsSupportFacialRecognition";
    private GetIsSupportFaceTask hCW = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask */
    static class GetIsSupportFaceTask extends MainProcessTask {
        public static final Creator<GetIsSupportFaceTask> CREATOR = new C103351();
        private String aIm = "not returned";
        private int bOs = -1;
        private boolean cOQ = false;
        private int errCode = -1;
        private JsApiCheckIsSupportFaceDetect hCX;
        private int hCY = -1;
        private C2241c hzz = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect$GetIsSupportFaceTask$1 */
        static class C103351 implements Creator<GetIsSupportFaceTask> {
            C103351() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetIsSupportFaceTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(3193);
                GetIsSupportFaceTask getIsSupportFaceTask = new GetIsSupportFaceTask(parcel);
                AppMethodBeat.m2505o(3193);
                return getIsSupportFaceTask;
            }
        }

        public final void asQ() {
            AppMethodBeat.m2504i(3194);
            super.asQ();
            C4990ab.m7411d("MicroMsg.GetIsSupportFaceTask", "hy: callback. isSupport: %b, errCode: %d, errMsg: %s, libVersion: %d", Boolean.valueOf(this.cOQ), Integer.valueOf(this.errCode), this.aIm, Integer.valueOf(this.hCY));
            HashMap hashMap = new HashMap(3);
            hashMap.put("errCode", Integer.valueOf(this.errCode));
            hashMap.put("libVersionCode", Integer.valueOf(this.hCY));
            if (this.errCode == 0) {
                this.hzz.mo6107M(this.bOs, this.hCX.mo73394j("ok", hashMap));
            } else {
                this.hzz.mo6107M(this.bOs, this.hCX.mo73394j("fail " + this.aIm, hashMap));
            }
            C19680h.m30478at(this);
            AppMethodBeat.m2505o(3194);
        }

        public final void asP() {
            AppMethodBeat.m2504i(3195);
            C32571ht c32571ht = new C32571ht();
            C4879a.xxA.mo10055m(c32571ht);
            this.cOQ = c32571ht.cCH.cCI;
            this.errCode = c32571ht.cCH.cCJ;
            this.aIm = c32571ht.cCH.cCK;
            this.hCY = c32571ht.cCH.cCL;
            C4990ab.m7417i("MicroMsg.GetIsSupportFaceTask", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", Boolean.valueOf(this.cOQ), Integer.valueOf(this.errCode), this.aIm, Integer.valueOf(this.hCY));
            aCb();
            AppMethodBeat.m2505o(3195);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(3196);
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.cOQ ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.aIm);
            parcel.writeInt(this.hCY);
            AppMethodBeat.m2505o(3196);
        }

        public GetIsSupportFaceTask(C2241c c2241c, int i, JsApiCheckIsSupportFaceDetect jsApiCheckIsSupportFaceDetect) {
            this.hzz = c2241c;
            this.bOs = i;
            this.hCX = jsApiCheckIsSupportFaceDetect;
        }

        protected GetIsSupportFaceTask(Parcel parcel) {
            AppMethodBeat.m2504i(3197);
            mo6032g(parcel);
            AppMethodBeat.m2505o(3197);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(3198);
            super.mo6032g(parcel);
            this.cOQ = parcel.readByte() != (byte) 0;
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            this.hCY = parcel.readInt();
            AppMethodBeat.m2505o(3198);
        }

        static {
            AppMethodBeat.m2504i(3199);
            AppMethodBeat.m2505o(3199);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(3200);
        C4990ab.m7416i("MicroMsg.JsApiCheckIsSupportFaceDetect", "hy: subapp start do check is support face detect");
        this.hCW = new GetIsSupportFaceTask(c2241c, i, this);
        C19680h.m30479bB(this.hCW);
        AppBrandMainProcessService.m54349a(this.hCW);
        AppMethodBeat.m2505o(3200);
    }
}
