package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.storage.C7617ak;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask */
class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Creator<JsApiGetContactMessageCountTask> CREATOR = new C103651();
    public int csm;
    public Runnable hww;
    public String username;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask$1 */
    static class C103651 implements Creator<JsApiGetContactMessageCountTask> {
        C103651() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetContactMessageCountTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131012);
            JsApiGetContactMessageCountTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask(parcel);
            AppMethodBeat.m2505o(131012);
            return jsApiGetContactMessageCountTask;
        }
    }

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        AppMethodBeat.m2504i(131013);
        mo6032g(parcel);
        AppMethodBeat.m2505o(131013);
    }

    public final void asP() {
        AppMethodBeat.m2504i(131014);
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(this.username);
        if (aoZ == null) {
            this.csm = -1;
            aCb();
            AppMethodBeat.m2505o(131014);
            return;
        }
        this.csm = aoZ.field_unReadCount;
        aCb();
        AppMethodBeat.m2505o(131014);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(131015);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(131015);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(131016);
        this.username = parcel.readString();
        this.csm = parcel.readInt();
        AppMethodBeat.m2505o(131016);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131017);
        parcel.writeString(this.username);
        parcel.writeInt(this.csm);
        AppMethodBeat.m2505o(131017);
    }

    static {
        AppMethodBeat.m2504i(131018);
        AppMethodBeat.m2505o(131018);
    }
}
