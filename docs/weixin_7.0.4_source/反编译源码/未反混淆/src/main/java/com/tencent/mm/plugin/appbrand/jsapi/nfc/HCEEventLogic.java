package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.ab;

public class HCEEventLogic {
    private static String hRT = null;
    private static boolean hRU = true;
    private static c hRV = new c() {
        public final void onCreate() {
            AppMethodBeat.i(137844);
            ab.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
            super.onCreate();
            HCEEventLogic.a(HCEEventLogic.hRT, 21, null);
            AppMethodBeat.o(137844);
        }

        public final void onResume() {
            AppMethodBeat.i(137845);
            ab.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
            super.onResume();
            HCEEventLogic.a(HCEEventLogic.hRT, 22, null);
            AppMethodBeat.o(137845);
        }

        public final void a(d dVar) {
            AppMethodBeat.i(137846);
            ab.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
            super.a(dVar);
            HCEEventLogic.a(HCEEventLogic.hRT, 23, null);
            AppMethodBeat.o(137846);
        }

        public final void onDestroy() {
            AppMethodBeat.i(137847);
            ab.i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
            super.onDestroy();
            HCEEventLogic.a(HCEEventLogic.hRT, 24, null);
            AppMethodBeat.o(137847);
        }
    };

    static class SendHCEEventToMMTask extends MainProcessTask {
        public static final Creator<SendHCEEventToMMTask> CREATOR = new Creator<SendHCEEventToMMTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendHCEEventToMMTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137848);
                SendHCEEventToMMTask sendHCEEventToMMTask = new SendHCEEventToMMTask(parcel);
                AppMethodBeat.o(137848);
                return sendHCEEventToMMTask;
            }
        };
        private String appId;
        private int hRW;
        private Bundle hRX;

        /* synthetic */ SendHCEEventToMMTask(String str, int i, Bundle bundle, byte b) {
            this(str, i, bundle);
        }

        private SendHCEEventToMMTask(String str, int i, Bundle bundle) {
            this.hRW = i;
            this.appId = str;
            this.hRX = bundle;
        }

        protected SendHCEEventToMMTask(Parcel parcel) {
            AppMethodBeat.i(137849);
            g(parcel);
            AppMethodBeat.o(137849);
        }

        public final void asP() {
            AppMethodBeat.i(137850);
            ab.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
            b.hSG.a(this.hRW, this.appId, this.hRX);
            aCb();
            AppMethodBeat.o(137850);
        }

        public final void asQ() {
            AppMethodBeat.i(137851);
            super.asQ();
            h.at(this);
            AppMethodBeat.o(137851);
        }

        public int describeContents() {
            return 0;
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(137852);
            super.g(parcel);
            this.hRW = parcel.readInt();
            this.appId = parcel.readString();
            this.hRX = parcel.readBundle();
            AppMethodBeat.o(137852);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137853);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hRW);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.hRX);
            AppMethodBeat.o(137853);
        }

        static {
            AppMethodBeat.i(137854);
            AppMethodBeat.o(137854);
        }
    }

    static {
        AppMethodBeat.i(137858);
        AppMethodBeat.o(137858);
    }

    public static void BE(String str) {
        AppMethodBeat.i(137855);
        if (!(hRT == null || hRV == null)) {
            ab.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", hRT);
            g.b(hRT, hRV);
        }
        hRT = str;
        g.a(str, hRV);
        AppMethodBeat.o(137855);
    }

    public static void BF(String str) {
        AppMethodBeat.i(137856);
        if (str != null) {
            g.b(str, hRV);
        }
        AppMethodBeat.o(137856);
    }

    public static void eo(boolean z) {
        synchronized (HCEEventLogic.class) {
            hRU = z;
        }
    }

    public static boolean aEt() {
        boolean z;
        synchronized (HCEEventLogic.class) {
            z = hRU;
        }
        return z;
    }

    public static void a(String str, int i, Bundle bundle) {
        AppMethodBeat.i(137857);
        if (bundle == null) {
            bundle = new Bundle();
        }
        ab.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", str, Integer.valueOf(i));
        MainProcessTask sendHCEEventToMMTask = new SendHCEEventToMMTask(str, i, bundle, (byte) 0);
        h.bB(sendHCEEventToMMTask);
        AppBrandMainProcessService.a(sendHCEEventToMMTask);
        AppMethodBeat.o(137857);
    }
}
