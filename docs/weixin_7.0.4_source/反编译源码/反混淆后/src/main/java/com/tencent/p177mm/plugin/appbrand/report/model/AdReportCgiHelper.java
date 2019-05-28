package com.tencent.p177mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sns.p1024b.C39727a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper */
public final class AdReportCgiHelper {

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper$a */
    public interface C19699a {
        void onDone();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper$b */
    static final class C27282b implements C37866a<AdReportCgiParams, IPCVoid> {
        private C27282b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(132576);
            AdReportCgiParams adReportCgiParams = (AdReportCgiParams) obj;
            C4990ab.m7417i("MicroMsg.AdReportCgiHelper", "report kvId:%d str:%s", Integer.valueOf(adReportCgiParams.eBH), adReportCgiParams.iAG);
            AdReportCgiHelper.m54726ab(adReportCgiParams.eBH, adReportCgiParams.iAG);
            c18507c.mo5960ao(new IPCVoid());
            AppMethodBeat.m2505o(132576);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper$AdReportCgiParams */
    static final class AdReportCgiParams implements Parcelable {
        public static final Creator<AdReportCgiParams> CREATOR = new C107131();
        private int eBH;
        private String iAG;

        /* renamed from: com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper$AdReportCgiParams$1 */
        static class C107131 implements Creator<AdReportCgiParams> {
            C107131() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AdReportCgiParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132572);
                AdReportCgiParams adReportCgiParams = new AdReportCgiParams(parcel);
                AppMethodBeat.m2505o(132572);
                return adReportCgiParams;
            }
        }

        AdReportCgiParams() {
        }

        protected AdReportCgiParams(Parcel parcel) {
            AppMethodBeat.m2504i(132573);
            this.eBH = parcel.readInt();
            this.iAG = parcel.readString();
            AppMethodBeat.m2505o(132573);
        }

        static {
            AppMethodBeat.m2504i(132575);
            AppMethodBeat.m2505o(132575);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(132574);
            parcel.writeInt(this.eBH);
            parcel.writeString(this.iAG);
            AppMethodBeat.m2505o(132574);
        }
    }

    /* renamed from: a */
    public static void m54725a(int i, String str, final C19699a c19699a) {
        AppMethodBeat.m2504i(132577);
        if (C4996ah.bqo()) {
            AdReportCgiHelper.m54726ab(i, str);
            if (c19699a != null) {
                c19699a.onDone();
                AppMethodBeat.m2505o(132577);
                return;
            }
        }
        AdReportCgiParams adReportCgiParams = new AdReportCgiParams();
        adReportCgiParams.eBH = i;
        adReportCgiParams.iAG = str;
        XIPCInvoker.m83629a("com.tencent.mm", adReportCgiParams, C27282b.class, new C18507c<IPCVoid>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(132571);
                if (c19699a != null) {
                    c19699a.onDone();
                }
                AppMethodBeat.m2505o(132571);
            }
        });
        AppMethodBeat.m2505o(132577);
    }

    /* renamed from: ab */
    static void m54726ab(int i, String str) {
        AppMethodBeat.m2504i(132578);
        if (C1720g.m3528K(C39727a.class) != null) {
            ((C39727a) C1720g.m3528K(C39727a.class)).mo47109i(i, str, (int) C5046bo.anT());
        }
        AppMethodBeat.m2505o(132578);
    }
}
