package com.tencent.p177mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask */
public class GetStorageSizeTask extends MainProcessTask {
    public static final Creator<GetStorageSizeTask> CREATOR = new C105151();
    public String appId;
    public Runnable hww;
    public int size;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.storage.GetStorageSizeTask$1 */
    static class C105151 implements Creator<GetStorageSizeTask> {
        C105151() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GetStorageSizeTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102015);
            GetStorageSizeTask getStorageSizeTask = new GetStorageSizeTask(parcel);
            AppMethodBeat.m2505o(102015);
            return getStorageSizeTask;
        }
    }

    public final void asP() {
        C42362b c42362b;
        AppMethodBeat.m2504i(102016);
        if (C37384e.m62985B(C0997b.class) == null) {
            c42362b = null;
        } else {
            c42362b = ((C0997b) C37384e.m62985B(C0997b.class)).mo3975xG();
        }
        if (c42362b == null) {
            aCb();
            AppMethodBeat.m2505o(102016);
            return;
        }
        this.size = c42362b.mo67877xT(this.appId);
        aCb();
        AppMethodBeat.m2505o(102016);
    }

    public final void asQ() {
        AppMethodBeat.m2504i(102017);
        if (this.hww != null) {
            this.hww.run();
        }
        AppMethodBeat.m2505o(102017);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102018);
        super.writeToParcel(parcel, i);
        parcel.writeString(this.appId);
        parcel.writeInt(this.size);
        AppMethodBeat.m2505o(102018);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(102019);
        this.appId = parcel.readString();
        this.size = parcel.readInt();
        AppMethodBeat.m2505o(102019);
    }

    protected GetStorageSizeTask(Parcel parcel) {
        AppMethodBeat.m2504i(102020);
        mo6032g(parcel);
        AppMethodBeat.m2505o(102020);
    }

    static {
        AppMethodBeat.m2504i(102021);
        AppMethodBeat.m2505o(102021);
    }
}
