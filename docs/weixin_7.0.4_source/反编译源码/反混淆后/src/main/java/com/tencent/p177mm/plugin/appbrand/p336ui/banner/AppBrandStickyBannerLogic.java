package com.tencent.p177mm.plugin.appbrand.p336ui.banner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic */
public enum AppBrandStickyBannerLogic {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$OperateTask */
    static final class OperateTask extends MainProcessTask {
        public static final Creator<OperateTask> CREATOR = null;
        String hQL;
        boolean iKN;
        int iKO;
        String iKP;
        /* renamed from: op */
        int f1250op;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$OperateTask$1 */
        static class C24821 implements Creator<OperateTask> {
            C24821() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(133299);
                OperateTask operateTask = new OperateTask();
                operateTask.mo6032g(parcel);
                AppMethodBeat.m2505o(133299);
                return operateTask;
            }
        }

        OperateTask() {
            this.f1250op = 0;
        }

        public final void asP() {
            AppMethodBeat.m2504i(133300);
            switch (this.f1250op) {
                case 1:
                    this.iKN = C19771b.aMP();
                    aCb();
                    AppMethodBeat.m2505o(133300);
                    return;
                case 2:
                    C19771b.m30601b(this);
                    break;
                case 3:
                    C19771b.aMR();
                    AppMethodBeat.m2505o(133300);
                    return;
            }
            AppMethodBeat.m2505o(133300);
        }

        /* renamed from: o */
        static OperateTask m4714o(String str, int i, String str2) {
            AppMethodBeat.m2504i(133301);
            OperateTask operateTask = new OperateTask();
            operateTask.f1250op = 2;
            operateTask.hQL = str;
            operateTask.iKO = i;
            operateTask.iKP = str2;
            AppMethodBeat.m2505o(133301);
            return operateTask;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(133302);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1250op);
            parcel.writeByte(this.iKN ? (byte) 1 : (byte) 0);
            parcel.writeString(this.hQL);
            parcel.writeInt(this.iKO);
            parcel.writeString(this.iKP);
            AppMethodBeat.m2505o(133302);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(133303);
            this.f1250op = parcel.readInt();
            this.iKN = parcel.readByte() != (byte) 0;
            this.hQL = parcel.readString();
            this.iKO = parcel.readInt();
            this.iKP = parcel.readString();
            AppMethodBeat.m2505o(133303);
        }

        static {
            AppMethodBeat.m2504i(133304);
            CREATOR = new C24821();
            AppMethodBeat.m2505o(133304);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$Watcher */
    static final class Watcher extends MainProcessTask {
        public static final Creator<Watcher> CREATOR = null;
        private static final transient Map<String, C10835f> iKT = null;
        String iKQ;
        String iKR;
        int iKS;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$Watcher$2 */
        static class C24832 implements Creator<Watcher> {
            C24832() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Watcher[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(133306);
                Watcher watcher = new Watcher();
                watcher.mo6032g(parcel);
                AppMethodBeat.m2505o(133306);
                return watcher;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$Watcher$1 */
        class C197701 implements C10835f {
            C197701() {
            }

            /* renamed from: bg */
            public final void mo6073bg(String str, int i) {
                AppMethodBeat.m2504i(133305);
                Watcher.this.iKR = str;
                Watcher.this.iKS = i;
                Watcher.m30597a(Watcher.this);
                AppMethodBeat.m2505o(133305);
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m30597a(Watcher watcher) {
            AppMethodBeat.m2504i(133311);
            boolean aCb = watcher.aCb();
            AppMethodBeat.m2505o(133311);
            return aCb;
        }

        static {
            AppMethodBeat.m2504i(133312);
            iKT = new HashMap();
            CREATOR = new C24832();
            AppMethodBeat.m2505o(133312);
        }

        public final void asP() {
            AppMethodBeat.m2504i(133307);
            if (C5046bo.isNullOrNil(this.iKQ)) {
                AppMethodBeat.m2505o(133307);
                return;
            }
            synchronized (iKT) {
                try {
                    if (iKT.containsKey(this.iKQ)) {
                        C19771b.m30602c((C10835f) iKT.get(this.iKQ));
                    }
                    C197701 c197701 = new C197701();
                    C19771b.m30603d(c197701);
                    iKT.put(this.iKQ, c197701);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133307);
                }
            }
        }

        public final void asQ() {
            AppMethodBeat.m2504i(133308);
            C19773a.m30605bw(this.iKR, this.iKS);
            AppMethodBeat.m2505o(133308);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(133309);
            parcel.writeString(this.iKQ);
            parcel.writeString(this.iKR);
            parcel.writeInt(this.iKS);
            AppMethodBeat.m2505o(133309);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(133310);
            this.iKQ = parcel.readString();
            this.iKR = parcel.readString();
            this.iKS = parcel.readInt();
            AppMethodBeat.m2505o(133310);
        }

        Watcher() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$b */
    public static final class C19771b {
        static final Set<C10835f> epg = null;

        static /* synthetic */ void access$100() {
            AppMethodBeat.m2504i(133297);
            C19771b.aMQ();
            AppMethodBeat.m2505o(133297);
        }

        static {
            AppMethodBeat.m2504i(133298);
            epg = new HashSet();
            AppMethodBeat.m2505o(133298);
        }

        /* renamed from: M */
        public static void m30600M(final Intent intent) {
            AppMethodBeat.m2504i(133289);
            if (intent == null || !C1720g.m3531RK()) {
                AppMethodBeat.m2505o(133289);
                return;
            }
            C1720g.m3539RS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133288);
                    if (C45697b.m84445L(intent)) {
                        C19771b.access$100();
                    }
                    AppMethodBeat.m2505o(133288);
                }
            });
            AppMethodBeat.m2505o(133289);
        }

        /* renamed from: b */
        static void m30601b(OperateTask operateTask) {
            AppMethodBeat.m2504i(133290);
            if (C45697b.m84448a(operateTask)) {
                C19771b.aMQ();
            }
            AppMethodBeat.m2505o(133290);
        }

        static void aMK() {
            AppMethodBeat.m2504i(133291);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.m2505o(133291);
        }

        private static void aMQ() {
            AppMethodBeat.m2504i(133292);
            BannerModel aMS = BannerModel.aMS();
            String str = aMS == null ? null : aMS.appId;
            int i = aMS == null ? -1 : aMS.har;
            synchronized (epg) {
                try {
                    for (C10835f bg : epg) {
                        bg.mo6073bg(str, i);
                    }
                } finally {
                    AppMethodBeat.m2505o(133292);
                }
            }
        }

        /* renamed from: d */
        public static void m30603d(C10835f c10835f) {
            AppMethodBeat.m2504i(133293);
            if (c10835f != null) {
                synchronized (epg) {
                    try {
                        epg.add(c10835f);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(133293);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(133293);
        }

        /* renamed from: c */
        public static void m30602c(C10835f c10835f) {
            AppMethodBeat.m2504i(133294);
            if (c10835f != null) {
                synchronized (epg) {
                    try {
                        epg.remove(c10835f);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(133294);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(133294);
        }

        public static boolean aMP() {
            AppMethodBeat.m2504i(133295);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.m2505o(133295);
            return false;
        }

        public static void aMR() {
            AppMethodBeat.m2504i(133296);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.m2505o(133296);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic$a */
    public static final class C19773a {
        private static final Watcher iKH = null;
        private static final Set<C10835f> iKI = null;
        private static final HashMap<String, Boolean> iKJ = null;
        private static final HashMap<String, C10835f> iKK = null;
        private static final C19775c iKL = null;
        private static final Map<String, String> iKM = null;

        static {
            AppMethodBeat.m2504i(133287);
            iKH = new Watcher();
            iKI = new HashSet();
            iKJ = new HashMap();
            iKK = new HashMap();
            iKL = new C19775c();
            iKM = new HashMap();
            AppMethodBeat.m2505o(133287);
        }

        /* renamed from: bw */
        static void m30605bw(String str, int i) {
            AppMethodBeat.m2504i(133280);
            synchronized (iKI) {
                try {
                    for (C10835f bg : iKI) {
                        bg.mo6073bg(str, i);
                    }
                } finally {
                    AppMethodBeat.m2505o(133280);
                }
            }
        }

        /* renamed from: a */
        public static void m30604a(Context context, String str, int i, String str2, String str3) {
            AppMethodBeat.m2504i(133281);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(133281);
                return;
            }
            Context context2;
            String str4;
            if (context == null) {
                context2 = C4996ah.getContext();
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
                    AppMethodBeat.m2505o(133281);
                }
            }
            C45697b.m84446a(addFlags, str, i, str2, str3, C5046bo.nullAsNil(str4));
            context2.startActivity(addFlags);
            if (context2 instanceof Activity) {
                try {
                    ((Activity) context2).moveTaskToBack(false);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrandStickyBannerLogic.ClientLogic", "stickOnChatting e = %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(133281);
        }

        public static boolean aMP() {
            AppMethodBeat.m2504i(133282);
            AppBrandStickyBannerLogic.access$200();
            AppMethodBeat.m2505o(133282);
            return false;
        }

        /* renamed from: c */
        public static void m30606c(C10835f c10835f) {
            AppMethodBeat.m2504i(133283);
            if (c10835f != null) {
                synchronized (iKI) {
                    try {
                        iKI.remove(c10835f);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(133283);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(133283);
        }

        /* renamed from: d */
        public static void m30608d(C10835f c10835f) {
            AppMethodBeat.m2504i(133284);
            iKH.iKQ = C4996ah.getProcessName();
            AppBrandMainProcessService.m54349a(iKH);
            if (c10835f != null) {
                synchronized (iKI) {
                    try {
                        iKI.add(c10835f);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(133284);
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(133284);
        }

        public static void release(String str) {
            AppMethodBeat.m2504i(133285);
            iKJ.remove(str);
            C4990ab.m7417i("MicroMsg.AppBrandStickyBannerLogic", "release(%s)", str);
            AppMethodBeat.m2505o(133285);
        }

        /* renamed from: cQ */
        public static void m30607cQ(String str, String str2) {
            AppMethodBeat.m2504i(133286);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(133286);
                return;
            }
            synchronized (iKM) {
                try {
                    iKM.put(str, C5046bo.nullAsNil(str2));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133286);
                }
            }
            AppBrandSysConfigWC wJ = C10048a.m17636wJ(str);
            if (wJ != null) {
                AppBrandMainProcessService.m54349a(OperateTask.m4714o(str, wJ.hhd.gVt, str2));
                AppMethodBeat.m2505o(133286);
            }
        }
    }
}
