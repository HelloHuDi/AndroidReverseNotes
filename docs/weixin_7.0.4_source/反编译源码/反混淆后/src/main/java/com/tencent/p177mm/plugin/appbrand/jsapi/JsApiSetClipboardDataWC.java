package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C38373i;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.charset.Charset;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC */
public final class JsApiSetClipboardDataWC extends C38373i<C38492q> {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC$ReportClipBoardTask */
    static class ReportClipBoardTask extends MainProcessTask {
        public static final Creator<ReportClipBoardTask> CREATOR = new C332261();
        private String hsV;
        private String mAppId;
        private int mLength;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC$ReportClipBoardTask$1 */
        static class C332261 implements Creator<ReportClipBoardTask> {
            C332261() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportClipBoardTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130567);
                ReportClipBoardTask reportClipBoardTask = new ReportClipBoardTask(parcel);
                AppMethodBeat.m2505o(130567);
                return reportClipBoardTask;
            }
        }

        public ReportClipBoardTask(String str, String str2, int i) {
            this.mAppId = str;
            this.hsV = str2;
            this.mLength = i;
        }

        public final void asP() {
            AppMethodBeat.m2504i(130568);
            C21734a c21734a = C21734a.qjm;
            C21734a.m33273D(this.mLength, this.mAppId, this.hsV);
            AppMethodBeat.m2505o(130568);
        }

        public ReportClipBoardTask(Parcel parcel) {
            AppMethodBeat.m2504i(130569);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130569);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130570);
            this.mAppId = parcel.readString();
            this.hsV = parcel.readString();
            this.mLength = parcel.readInt();
            AppMethodBeat.m2505o(130570);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130571);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.hsV);
            parcel.writeInt(this.mLength);
            AppMethodBeat.m2505o(130571);
        }

        static {
            AppMethodBeat.m2504i(130572);
            AppMethodBeat.m2505o(130572);
        }
    }

    /* renamed from: c */
    public final /* synthetic */ void mo61034c(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(130573);
        C38492q c38492q = (C38492q) c2241c;
        if (!C5046bo.isNullOrNil(str)) {
            String appId = c38492q.getAppId();
            C38470q asV = c38492q.getRuntime().asV();
            if (asV == null || asV.getCurrentPage() == null) {
                AppMethodBeat.m2505o(130573);
                return;
            }
            AppBrandMainProcessService.m54349a(new ReportClipBoardTask(appId, asV.getCurrentPage().getCurrentUrl(), str.getBytes(Charset.forName("UTF-8")).length));
        }
        AppMethodBeat.m2505o(130573);
    }
}
