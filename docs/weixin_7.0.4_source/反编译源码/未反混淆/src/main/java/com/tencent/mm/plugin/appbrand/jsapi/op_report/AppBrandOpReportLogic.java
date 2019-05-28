package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class AppBrandOpReportLogic {

    public static final class a {
        private static boolean bUt = false;

        public static synchronized void b(final h hVar) {
            synchronized (a.class) {
                AppMethodBeat.i(102000);
                if (bUt) {
                    AppMethodBeat.o(102000);
                } else {
                    MMToClientEvent.a(hVar.getAppId(), new c() {
                        public final void bk(Object obj) {
                            AppMethodBeat.i(101999);
                            if (obj instanceof AppBrandOnOpReportStartEvent) {
                                i runtime = hVar.getRuntime();
                                if (runtime != null) {
                                    a.k(runtime.xT());
                                }
                            }
                            AppMethodBeat.o(101999);
                        }
                    });
                    bUt = true;
                    AppMethodBeat.o(102000);
                }
            }
        }
    }

    public static final class b {
        private static final SparseIntArray hST = new SparseIntArray();

        static {
            AppMethodBeat.i(102002);
            AppMethodBeat.o(102002);
        }

        static void bi(String str, int i) {
            AppMethodBeat.i(102001);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(102001);
                return;
            }
            synchronized (hST) {
                try {
                    hST.put(str.hashCode(), i);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(102001);
                }
            }
        }
    }

    public static final class AppBrandOnOpReportStartEvent implements Parcelable {
        public static final Creator<AppBrandOnOpReportStartEvent> CREATOR = new Creator<AppBrandOnOpReportStartEvent>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AppBrandOnOpReportStartEvent[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(101994);
                AppBrandOnOpReportStartEvent appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent(parcel);
                AppMethodBeat.o(101994);
                return appBrandOnOpReportStartEvent;
            }
        };
        String appId;

        public static void BI(String str) {
            AppMethodBeat.i(101995);
            AppBrandOnOpReportStartEvent appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
            appBrandOnOpReportStartEvent.appId = str;
            d.a(str, appBrandOnOpReportStartEvent);
            AppMethodBeat.o(101995);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(101996);
            parcel.writeString(this.appId);
            AppMethodBeat.o(101996);
        }

        AppBrandOnOpReportStartEvent() {
        }

        AppBrandOnOpReportStartEvent(Parcel parcel) {
            AppMethodBeat.i(101997);
            this.appId = parcel.readString();
            AppMethodBeat.o(101997);
        }

        static {
            AppMethodBeat.i(101998);
            AppMethodBeat.o(101998);
        }
    }
}
