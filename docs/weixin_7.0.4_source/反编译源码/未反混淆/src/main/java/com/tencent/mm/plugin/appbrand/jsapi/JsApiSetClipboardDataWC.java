package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.q.i;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.charset.Charset;

public final class JsApiSetClipboardDataWC extends i<q> {

    static class ReportClipBoardTask extends MainProcessTask {
        public static final Creator<ReportClipBoardTask> CREATOR = new Creator<ReportClipBoardTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportClipBoardTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130567);
                ReportClipBoardTask reportClipBoardTask = new ReportClipBoardTask(parcel);
                AppMethodBeat.o(130567);
                return reportClipBoardTask;
            }
        };
        private String hsV;
        private String mAppId;
        private int mLength;

        public ReportClipBoardTask(String str, String str2, int i) {
            this.mAppId = str;
            this.hsV = str2;
            this.mLength = i;
        }

        public final void asP() {
            AppMethodBeat.i(130568);
            a aVar = a.qjm;
            a.D(this.mLength, this.mAppId, this.hsV);
            AppMethodBeat.o(130568);
        }

        public ReportClipBoardTask(Parcel parcel) {
            AppMethodBeat.i(130569);
            g(parcel);
            AppMethodBeat.o(130569);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130570);
            this.mAppId = parcel.readString();
            this.hsV = parcel.readString();
            this.mLength = parcel.readInt();
            AppMethodBeat.o(130570);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130571);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.hsV);
            parcel.writeInt(this.mLength);
            AppMethodBeat.o(130571);
        }

        static {
            AppMethodBeat.i(130572);
            AppMethodBeat.o(130572);
        }
    }

    public final /* synthetic */ void c(c cVar, String str) {
        AppMethodBeat.i(130573);
        q qVar = (q) cVar;
        if (!bo.isNullOrNil(str)) {
            String appId = qVar.getAppId();
            com.tencent.mm.plugin.appbrand.page.q asV = qVar.getRuntime().asV();
            if (asV == null || asV.getCurrentPage() == null) {
                AppMethodBeat.o(130573);
                return;
            }
            AppBrandMainProcessService.a(new ReportClipBoardTask(appId, asV.getCurrentPage().getCurrentUrl(), str.getBytes(Charset.forName("UTF-8")).length));
        }
        AppMethodBeat.o(130573);
    }
}
