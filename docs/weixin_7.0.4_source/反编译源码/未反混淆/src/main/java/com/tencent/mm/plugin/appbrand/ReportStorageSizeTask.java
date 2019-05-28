package com.tencent.mm.plugin.appbrand;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.report.service.h;

public class ReportStorageSizeTask extends MainProcessTask {
    public static final Creator<ReportStorageSizeTask> CREATOR = new Creator<ReportStorageSizeTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportStorageSizeTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(129144);
            ReportStorageSizeTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.g(parcel);
            AppMethodBeat.o(129144);
            return reportStorageSizeTask;
        }
    };
    public String appId;

    public final void asP() {
        AppMethodBeat.i(129145);
        b xG = f.xG();
        if (xG == null) {
            AppMethodBeat.o(129145);
            return;
        }
        Integer valueOf;
        a aVar = c.gXf;
        if (a.xV(this.appId) != 1) {
            com.tencent.mm.plugin.appbrand.appstorage.f fVar = com.tencent.mm.plugin.appbrand.appstorage.f.gXv;
            valueOf = Integer.valueOf(com.tencent.mm.plugin.appbrand.appstorage.f.xT(this.appId));
        } else {
            valueOf = Integer.valueOf(xG.xT(this.appId));
        }
        h.pYm.e(14073, this.appId, "", "", valueOf, Long.valueOf(AppBrandLocalMediaObjectManager.xW(this.appId)), Long.valueOf(AppBrandLocalMediaObjectManager.xX(this.appId)));
        AppMethodBeat.o(129145);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(129146);
        parcel.writeString(this.appId);
        AppMethodBeat.o(129146);
    }

    public final void g(Parcel parcel) {
        AppMethodBeat.i(129147);
        this.appId = parcel.readString();
        AppMethodBeat.o(129147);
    }

    static {
        AppMethodBeat.i(129148);
        AppMethodBeat.o(129148);
    }
}
