package com.tencent.mm.plugin.appbrand.ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Deprecated
public enum AppBrandStickyBannerLogic {
    ;

    static final class OperateTask extends MainProcessTask {
        public static final Creator<OperateTask> CREATOR = null;
        String hQL;
        boolean iKN;
        int iKO;
        String iKP;
        int op;

        OperateTask() {
            this.op = 0;
        }

        public final void asP() {
            AppMethodBeat.i(133300);
            switch (this.op) {
                case 1:
                    this.iKN = b.aMP();
                    aCb();
                    AppMethodBeat.o(133300);
                    return;
                case 2:
                    b.b(this);
                    break;
                case 3:
                    b.aMR();
                    AppMethodBeat.o(133300);
                    return;
            }
            AppMethodBeat.o(133300);
        }

        static OperateTask o(String str, int i, String str2) {
            AppMethodBeat.i(133301);
            OperateTask operateTask = new OperateTask();
            operateTask.op = 2;
            operateTask.hQL = str;
            operateTask.iKO = i;
            operateTask.iKP = str2;
            AppMethodBeat.o(133301);
            return operateTask;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(133302);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.op);
            parcel.writeByte(this.iKN ? (byte) 1 : (byte) 0);
            parcel.writeString(this.hQL);
            parcel.writeInt(this.iKO);
            parcel.writeString(this.iKP);
            AppMethodBeat.o(133302);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(133303);
            this.op = parcel.readInt();
            this.iKN = parcel.readByte() != (byte) 0;
            this.hQL = parcel.readString();
            this.iKO = parcel.readInt();
            this.iKP = parcel.readString();
            AppMethodBeat.o(133303);
        }

        static {
            AppMethodBeat.i(133304);
            CREATOR = new Creator<OperateTask>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new OperateTask[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(133299);
                    OperateTask operateTask = new OperateTask();
                    operateTask.g(parcel);
                    AppMethodBeat.o(133299);
                    return operateTask;
                }
            };
            AppMethodBeat.o(133304);
        }
    }

    static final class Watcher extends MainProcessTask {
        public static final Creator<Watcher> CREATOR = null;
        private static final transient Map<String, f> iKT = null;
        String iKQ;
        String iKR;
        int iKS;

        static /* synthetic */ boolean a(Watcher watcher) {
            AppMethodBeat.i(133311);
            boolean aCb = watcher.aCb();
            AppMethodBeat.o(133311);
            return aCb;
        }

        static {
            AppMethodBeat.i(133312);
            iKT = new HashMap();
            CREATOR = new Creator<Watcher>() {
                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new Watcher[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(133306);
                    Watcher watcher = new Watcher();
                    watcher.g(parcel);
                    AppMethodBeat.o(133306);
                    return watcher;
                }
            };
            AppMethodBeat.o(133312);
        }

        public final void asP() {
            AppMethodBeat.i(133307);
            if (bo.isNullOrNil(this.iKQ)) {
                AppMethodBeat.o(133307);
                return;
            }
            synchronized (iKT) {
                try {
                    if (iKT.containsKey(this.iKQ)) {
                        b.c((f) iKT.get(this.iKQ));
                    }
                    AnonymousClass1 anonymousClass1 = new f() {
                        public final void bg(String str, int i) {
                            AppMethodBeat.i(133305);
                            Watcher.this.iKR = str;
                            Watcher.this.iKS = i;
                            Watcher.a(Watcher.this);
                            AppMethodBeat.o(133305);
                        }
                    };
                    b.d(anonymousClass1);
                    iKT.put(this.iKQ, anonymousClass1);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133307);
                }
            }
        }

        public final void asQ() {
            AppMethodBeat.i(133308);
            a.bw(this.iKR, this.iKS);
            AppMethodBeat.o(133308);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(133309);
            parcel.writeString(this.iKQ);
            parcel.writeString(this.iKR);
            parcel.writeInt(this.iKS);
            AppMethodBeat.o(133309);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(133310);
            this.iKQ = parcel.readString();
            this.iKR = parcel.readString();
            this.iKS = parcel.readInt();
            AppMethodBeat.o(133310);
        }

        Watcher() {
        }
    }

    public static final class b {
        static final Set<f> epg = null;

        static /* synthetic */ void access$100() {
            AppMethodBeat.i(133297);
            aMQ();
            AppMethodBeat.o(133297);
        }

        static {
            AppMethodBeat.i(133298);
            epg = new HashSet();
            AppMethodBeat.o(133298);
        }

        public static void M(final Intent intent) {
            AppMethodBeat.i(133289);
            if (intent == null || !g.RK()) {
                AppMethodBeat.o(133289);
                return;
            }
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133288);
                    if (b.L(intent)) {
                        b.access$100();
                    }
                    AppMethodBeat.o(133288);
                }
            });
            AppMethodBeat.o(133289);
        }

        static void b(OperateTask operateTask) {
            AppMethodBeat.i(133290);
            if (b.a(operateTask)) {
                aMQ();
            }
            AppMethodBeat.o(133290);
        }

        static void aMK() {
            AppMethodBeat.i(133291);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(133291);
        }

        private static void aMQ() {
            AppMethodBeat.i(133292);
            BannerModel aMS = BannerModel.aMS();
            String str = aMS == null ? null : aMS.appId;
            int i = aMS == null ? -1 : aMS.har;
            synchronized (epg) {
                try {
                    for (f bg : epg) {
                        bg.bg(str, i);
                    }
                } finally {
                    AppMethodBeat.o(133292);
                }
            }
        }

        public static void d(f fVar) {
            AppMethodBeat.i(133293);
            if (fVar != null) {
                synchronized (epg) {
                    try {
                        epg.add(fVar);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(133293);
                    }
                }
                return;
            }
            AppMethodBeat.o(133293);
        }

        public static void c(f fVar) {
            AppMethodBeat.i(133294);
            if (fVar != null) {
                synchronized (epg) {
                    try {
                        epg.remove(fVar);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(133294);
                    }
                }
                return;
            }
            AppMethodBeat.o(133294);
        }

        public static boolean aMP() {
            AppMethodBeat.i(133295);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(133295);
            return false;
        }

        public static void aMR() {
            AppMethodBeat.i(133296);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(133296);
        }
    }

    public static final class a {
        private static final Watcher iKH = null;
        private static final Set<f> iKI = null;
        private static final HashMap<String, Boolean> iKJ = null;
        private static final HashMap<String, f> iKK = null;
        private static final c iKL = null;
        private static final Map<String, String> iKM = null;

        static {
            AppMethodBeat.i(133287);
            iKH = new Watcher();
            iKI = new HashSet();
            iKJ = new HashMap();
            iKK = new HashMap();
            iKL = new c();
            iKM = new HashMap();
            AppMethodBeat.o(133287);
        }

        static void bw(String str, int i) {
            AppMethodBeat.i(133280);
            synchronized (iKI) {
                try {
                    for (f bg : iKI) {
                        bg.bg(str, i);
                    }
                } finally {
                    AppMethodBeat.o(133280);
                }
            }
        }

        public static void a(Context context, String str, int i, String str2, String str3) {
            AppMethodBeat.i(133281);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(133281);
                return;
            }
            Context context2;
            String str4;
            if (context == null) {
                context2 = ah.getContext();
            } else {
                context2 = context;
            }
            Intent addFlags = new Intent().setClassName(context2, "com.tencent.mm.ui.LauncherUI").addFlags(268435456).addFlags(67108864).addFlags(536870912);
            synchronized (iKM) {
                try {
                    str4 = (String) iKM.get(str);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133281);
                }
            }
            b.a(addFlags, str, i, str2, str3, bo.nullAsNil(str4));
            context2.startActivity(addFlags);
            if (context2 instanceof Activity) {
                try {
                    ((Activity) context2).moveTaskToBack(false);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", e.getMessage());
                }
            }
            AppMethodBeat.o(133281);
        }

        public static boolean aMP() {
            AppMethodBeat.i(133282);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.o(133282);
            return false;
        }

        public static void c(f fVar) {
            AppMethodBeat.i(133283);
            if (fVar != null) {
                synchronized (iKI) {
                    try {
                        iKI.remove(fVar);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(133283);
                    }
                }
                return;
            }
            AppMethodBeat.o(133283);
        }

        public static void d(f fVar) {
            AppMethodBeat.i(133284);
            iKH.iKQ = ah.getProcessName();
            AppBrandMainProcessService.a(iKH);
            if (fVar != null) {
                synchronized (iKI) {
                    try {
                        iKI.add(fVar);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(133284);
                    }
                }
                return;
            }
            AppMethodBeat.o(133284);
        }

        public static void release(String str) {
            AppMethodBeat.i(133285);
            iKJ.remove(str);
            ab.i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", str);
            AppMethodBeat.o(133285);
        }

        public static void cQ(String str, String str2) {
            AppMethodBeat.i(133286);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(133286);
                return;
            }
            synchronized (iKM) {
                try {
                    iKM.put(str, bo.nullAsNil(str2));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133286);
                }
            }
            AppBrandSysConfigWC wJ = com.tencent.mm.plugin.appbrand.a.wJ(str);
            if (wJ != null) {
                AppBrandMainProcessService.a(OperateTask.o(str, wJ.hhd.gVt, str2));
                AppMethodBeat.o(133286);
            }
        }
    }
}
