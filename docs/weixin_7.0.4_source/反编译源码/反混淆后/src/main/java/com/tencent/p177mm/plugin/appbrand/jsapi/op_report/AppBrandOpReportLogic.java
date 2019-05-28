package com.tencent.p177mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.ipc.C10276d;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.p177mm.plugin.appbrand.ipc.MMToClientEvent.C38244c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic */
public final class AppBrandOpReportLogic {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic$a */
    public static final class C27050a {
        private static boolean bUt = false;

        /* renamed from: b */
        public static synchronized void m42997b(final C33327h c33327h) {
            synchronized (C27050a.class) {
                AppMethodBeat.m2504i(102000);
                if (bUt) {
                    AppMethodBeat.m2505o(102000);
                } else {
                    MMToClientEvent.m75199a(c33327h.getAppId(), new C38244c() {
                        /* renamed from: bk */
                        public final void mo22088bk(Object obj) {
                            AppMethodBeat.m2504i(101999);
                            if (obj instanceof AppBrandOnOpReportStartEvent) {
                                C6750i runtime = c33327h.getRuntime();
                                if (runtime != null) {
                                    C42561a.m75358k(runtime.mo15032xT());
                                }
                            }
                            AppMethodBeat.m2505o(101999);
                        }
                    });
                    bUt = true;
                    AppMethodBeat.m2505o(102000);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic$b */
    public static final class C27052b {
        private static final SparseIntArray hST = new SparseIntArray();

        static {
            AppMethodBeat.m2504i(102002);
            AppMethodBeat.m2505o(102002);
        }

        /* renamed from: bi */
        static void m42999bi(String str, int i) {
            AppMethodBeat.m2504i(102001);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(102001);
                return;
            }
            synchronized (hST) {
                try {
                    hST.put(str.hashCode(), i);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(102001);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic$AppBrandOnOpReportStartEvent */
    public static final class AppBrandOnOpReportStartEvent implements Parcelable {
        public static final Creator<AppBrandOnOpReportStartEvent> CREATOR = new C104991();
        String appId;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic$AppBrandOnOpReportStartEvent$1 */
        static class C104991 implements Creator<AppBrandOnOpReportStartEvent> {
            C104991() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AppBrandOnOpReportStartEvent[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(101994);
                AppBrandOnOpReportStartEvent appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent(parcel);
                AppMethodBeat.m2505o(101994);
                return appBrandOnOpReportStartEvent;
            }
        }

        /* renamed from: BI */
        public static void m43000BI(String str) {
            AppMethodBeat.m2504i(101995);
            AppBrandOnOpReportStartEvent appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
            appBrandOnOpReportStartEvent.appId = str;
            C10276d.m17931a(str, appBrandOnOpReportStartEvent);
            AppMethodBeat.m2505o(101995);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(101996);
            parcel.writeString(this.appId);
            AppMethodBeat.m2505o(101996);
        }

        AppBrandOnOpReportStartEvent() {
        }

        AppBrandOnOpReportStartEvent(Parcel parcel) {
            AppMethodBeat.m2504i(101997);
            this.appId = parcel.readString();
            AppMethodBeat.m2505o(101997);
        }

        static {
            AppMethodBeat.m2504i(101998);
            AppMethodBeat.m2505o(101998);
        }
    }
}
