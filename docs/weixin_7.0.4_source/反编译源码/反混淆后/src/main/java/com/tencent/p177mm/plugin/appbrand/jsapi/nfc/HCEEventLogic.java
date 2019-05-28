package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.C2326b;
import com.tencent.p177mm.plugin.appbrand.p328r.C19680h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic */
public class HCEEventLogic {
    private static String hRT = null;
    private static boolean hRU = true;
    private static C33186c hRV = new C23251();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic$1 */
    static class C23251 extends C33186c {
        C23251() {
        }

        public final void onCreate() {
            AppMethodBeat.m2504i(137844);
            C4990ab.m7416i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onCreate");
            super.onCreate();
            HCEEventLogic.m75350a(HCEEventLogic.hRT, 21, null);
            AppMethodBeat.m2505o(137844);
        }

        public final void onResume() {
            AppMethodBeat.m2504i(137845);
            C4990ab.m7416i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onResume");
            super.onResume();
            HCEEventLogic.m75350a(HCEEventLogic.hRT, 22, null);
            AppMethodBeat.m2505o(137845);
        }

        /* renamed from: a */
        public final void mo6074a(C33184d c33184d) {
            AppMethodBeat.m2504i(137846);
            C4990ab.m7416i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onPause");
            super.mo6074a(c33184d);
            HCEEventLogic.m75350a(HCEEventLogic.hRT, 23, null);
            AppMethodBeat.m2505o(137846);
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(137847);
            C4990ab.m7416i("MicroMsg.HCEEventLogic", "alvinluo AppBrandLifeCycle mHCELifeCycleListener onDestroy");
            super.onDestroy();
            HCEEventLogic.m75350a(HCEEventLogic.hRT, 24, null);
            AppMethodBeat.m2505o(137847);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic$SendHCEEventToMMTask */
    static class SendHCEEventToMMTask extends MainProcessTask {
        public static final Creator<SendHCEEventToMMTask> CREATOR = new C104961();
        private String appId;
        private int hRW;
        private Bundle hRX;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic$SendHCEEventToMMTask$1 */
        static class C104961 implements Creator<SendHCEEventToMMTask> {
            C104961() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendHCEEventToMMTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137848);
                SendHCEEventToMMTask sendHCEEventToMMTask = new SendHCEEventToMMTask(parcel);
                AppMethodBeat.m2505o(137848);
                return sendHCEEventToMMTask;
            }
        }

        /* synthetic */ SendHCEEventToMMTask(String str, int i, Bundle bundle, byte b) {
            this(str, i, bundle);
        }

        private SendHCEEventToMMTask(String str, int i, Bundle bundle) {
            this.hRW = i;
            this.appId = str;
            this.hRX = bundle;
        }

        protected SendHCEEventToMMTask(Parcel parcel) {
            AppMethodBeat.m2504i(137849);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137849);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137850);
            C4990ab.m7416i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic SendHCEEventToMMTask runInMainProcess");
            C2326b.hSG.mo6199a(this.hRW, this.appId, this.hRX);
            aCb();
            AppMethodBeat.m2505o(137850);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(137851);
            super.asQ();
            C19680h.m30478at(this);
            AppMethodBeat.m2505o(137851);
        }

        public int describeContents() {
            return 0;
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(137852);
            super.mo6032g(parcel);
            this.hRW = parcel.readInt();
            this.appId = parcel.readString();
            this.hRX = parcel.readBundle();
            AppMethodBeat.m2505o(137852);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137853);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hRW);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.hRX);
            AppMethodBeat.m2505o(137853);
        }

        static {
            AppMethodBeat.m2504i(137854);
            AppMethodBeat.m2505o(137854);
        }
    }

    static {
        AppMethodBeat.m2504i(137858);
        AppMethodBeat.m2505o(137858);
    }

    /* renamed from: BE */
    public static void m75348BE(String str) {
        AppMethodBeat.m2504i(137855);
        if (!(hRT == null || hRV == null)) {
            C4990ab.m7417i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", hRT);
            C33183g.m54276b(hRT, hRV);
        }
        hRT = str;
        C33183g.m54274a(str, hRV);
        AppMethodBeat.m2505o(137855);
    }

    /* renamed from: BF */
    public static void m75349BF(String str) {
        AppMethodBeat.m2504i(137856);
        if (str != null) {
            C33183g.m54276b(str, hRV);
        }
        AppMethodBeat.m2505o(137856);
    }

    /* renamed from: eo */
    public static void m75351eo(boolean z) {
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

    /* renamed from: a */
    public static void m75350a(String str, int i, Bundle bundle) {
        AppMethodBeat.m2504i(137857);
        if (bundle == null) {
            bundle = new Bundle();
        }
        C4990ab.m7417i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", str, Integer.valueOf(i));
        MainProcessTask sendHCEEventToMMTask = new SendHCEEventToMMTask(str, i, bundle, (byte) 0);
        C19680h.m30479bB(sendHCEEventToMMTask);
        AppBrandMainProcessService.m54349a(sendHCEEventToMMTask);
        AppMethodBeat.m2505o(137857);
    }
}
