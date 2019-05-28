package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.List;

public final class WxaMenuHelper {
    private final SparseArray<com.tencent.mm.plugin.appbrand.menu.a.a> ing;

    public static class GetCopyPathMenuExpireTimeTask extends MainProcessTask {
        public static final Creator<GetCopyPathMenuExpireTimeTask> CREATOR = new Creator<GetCopyPathMenuExpireTimeTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetCopyPathMenuExpireTimeTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132254);
                GetCopyPathMenuExpireTimeTask getCopyPathMenuExpireTimeTask = new GetCopyPathMenuExpireTimeTask(parcel);
                AppMethodBeat.o(132254);
                return getCopyPathMenuExpireTimeTask;
            }
        };
        private long inh = 0;
        private String mAppId;

        public GetCopyPathMenuExpireTimeTask(String str) {
            this.mAppId = str;
        }

        public GetCopyPathMenuExpireTimeTask(Parcel parcel) {
            AppMethodBeat.i(132255);
            g(parcel);
            AppMethodBeat.o(132255);
        }

        public final void asP() {
            AppMethodBeat.i(132256);
            f fVar = f.inF;
            Long cF = f.cF(this.mAppId, "copypath");
            if (cF == null) {
                this.inh = 0;
                AppMethodBeat.o(132256);
                return;
            }
            this.inh = cF.longValue();
            AppMethodBeat.o(132256);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(132257);
            this.inh = parcel.readLong();
            this.mAppId = parcel.readString();
            AppMethodBeat.o(132257);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(132258);
            parcel.writeLong(this.inh);
            parcel.writeString(this.mAppId);
            AppMethodBeat.o(132258);
        }

        static {
            AppMethodBeat.i(132259);
            AppMethodBeat.o(132259);
        }
    }

    static class a {
        static WxaMenuHelper ini = new WxaMenuHelper();

        static {
            AppMethodBeat.i(132260);
            AppMethodBeat.o(132260);
        }
    }

    /* synthetic */ WxaMenuHelper(byte b) {
        this();
    }

    private WxaMenuHelper() {
        AppMethodBeat.i(132261);
        this.ing = new SparseArray();
        a(new c());
        a(new b());
        a(new i());
        a(new a());
        a(new h());
        a(new d());
        a(new g());
        a(new MenuDelegate_SendToDesktop());
        a(new j());
        a(new l());
        a(new m());
        a(new MenuDelegate_EnableDebug());
        a(new k());
        a(new f());
        a(new e());
        AppMethodBeat.o(132261);
    }

    public static void c(List<n> list, int i, boolean z) {
        AppMethodBeat.i(132262);
        n nVar = new n(i, (com.tencent.mm.plugin.appbrand.menu.a.a) a.ini.ing.get(i));
        nVar.imK = z;
        list.add(nVar);
        AppMethodBeat.o(132262);
    }

    private void a(com.tencent.mm.plugin.appbrand.menu.a.a aVar) {
        AppMethodBeat.i(132263);
        this.ing.put(aVar.inj, aVar);
        AppMethodBeat.o(132263);
    }
}
