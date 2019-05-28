package com.tencent.p177mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19085f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42364c;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42364c.C42363a;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.report.service.C7060h;

/* renamed from: com.tencent.mm.plugin.appbrand.ReportStorageSizeTask */
public class ReportStorageSizeTask extends MainProcessTask {
    public static final Creator<ReportStorageSizeTask> CREATOR = new C100471();
    public String appId;

    /* renamed from: com.tencent.mm.plugin.appbrand.ReportStorageSizeTask$1 */
    static class C100471 implements Creator<ReportStorageSizeTask> {
        C100471() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportStorageSizeTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(129144);
            ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.mo6032g(parcel);
            AppMethodBeat.m2505o(129144);
            return reportStorageSizeTask;
        }
    }

    public final void asP() {
        AppMethodBeat.m2504i(129145);
        C42362b xG = C42340f.m74879xG();
        if (xG == null) {
            AppMethodBeat.m2505o(129145);
            return;
        }
        Integer valueOf;
        C42363a c42363a = C42364c.gXf;
        if (C42363a.m74934xV(this.appId) != 1) {
            C19085f c19085f = C19085f.gXv;
            valueOf = Integer.valueOf(C19085f.m29671xT(this.appId));
        } else {
            valueOf = Integer.valueOf(xG.mo67877xT(this.appId));
        }
        C7060h.pYm.mo8381e(14073, this.appId, "", "", valueOf, Long.valueOf(AppBrandLocalMediaObjectManager.m29652xW(this.appId)), Long.valueOf(AppBrandLocalMediaObjectManager.m29653xX(this.appId)));
        AppMethodBeat.m2505o(129145);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(129146);
        parcel.writeString(this.appId);
        AppMethodBeat.m2505o(129146);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        AppMethodBeat.m2504i(129147);
        this.appId = parcel.readString();
        AppMethodBeat.m2505o(129147);
    }

    static {
        AppMethodBeat.m2504i(129148);
        AppMethodBeat.m2505o(129148);
    }
}
