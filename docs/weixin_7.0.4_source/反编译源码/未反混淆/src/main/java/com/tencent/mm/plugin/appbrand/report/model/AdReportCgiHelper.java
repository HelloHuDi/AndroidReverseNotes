package com.tencent.mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class AdReportCgiHelper {

    public interface a {
        void onDone();
    }

    static final class b implements com.tencent.mm.ipcinvoker.a<AdReportCgiParams, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(132576);
            AdReportCgiParams adReportCgiParams = (AdReportCgiParams) obj;
            ab.i("MicroMsg.AdReportCgiHelper", "report kvId:%d str:%s", Integer.valueOf(adReportCgiParams.eBH), adReportCgiParams.iAG);
            AdReportCgiHelper.ab(adReportCgiParams.eBH, adReportCgiParams.iAG);
            cVar.ao(new IPCVoid());
            AppMethodBeat.o(132576);
        }
    }

    static final class AdReportCgiParams implements Parcelable {
        public static final Creator<AdReportCgiParams> CREATOR = new Creator<AdReportCgiParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AdReportCgiParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132572);
                AdReportCgiParams adReportCgiParams = new AdReportCgiParams(parcel);
                AppMethodBeat.o(132572);
                return adReportCgiParams;
            }
        };
        private int eBH;
        private String iAG;

        AdReportCgiParams() {
        }

        protected AdReportCgiParams(Parcel parcel) {
            AppMethodBeat.i(132573);
            this.eBH = parcel.readInt();
            this.iAG = parcel.readString();
            AppMethodBeat.o(132573);
        }

        static {
            AppMethodBeat.i(132575);
            AppMethodBeat.o(132575);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(132574);
            parcel.writeInt(this.eBH);
            parcel.writeString(this.iAG);
            AppMethodBeat.o(132574);
        }
    }

    public static void a(int i, String str, final a aVar) {
        AppMethodBeat.i(132577);
        if (ah.bqo()) {
            ab(i, str);
            if (aVar != null) {
                aVar.onDone();
                AppMethodBeat.o(132577);
                return;
            }
        }
        AdReportCgiParams adReportCgiParams = new AdReportCgiParams();
        adReportCgiParams.eBH = i;
        adReportCgiParams.iAG = str;
        XIPCInvoker.a("com.tencent.mm", adReportCgiParams, b.class, new c<IPCVoid>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(132571);
                if (aVar != null) {
                    aVar.onDone();
                }
                AppMethodBeat.o(132571);
            }
        });
        AppMethodBeat.o(132577);
    }

    static void ab(int i, String str) {
        AppMethodBeat.i(132578);
        if (g.K(com.tencent.mm.plugin.sns.b.a.class) != null) {
            ((com.tencent.mm.plugin.sns.b.a) g.K(com.tencent.mm.plugin.sns.b.a.class)).i(i, str, (int) bo.anT());
        }
        AppMethodBeat.o(132578);
    }
}
