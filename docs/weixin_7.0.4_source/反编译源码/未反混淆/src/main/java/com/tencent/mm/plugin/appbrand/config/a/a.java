package com.tencent.mm.plugin.appbrand.config.a;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.SparseArray;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final SparseArray<a> hiz = new SparseArray();
    public d hiA;
    public d hiB;
    private WeakReference<Activity> hiC;
    public ContentObserver hiD = null;
    public b hiE = null;
    private boolean hiF;
    public int hiG;
    public b hiH = null;
    public boolean mFinished = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$1 */
    public class AnonymousClass1 extends ContentObserver {
        public AnonymousClass1(Handler handler) {
            super(handler);
        }

        public final void onChange(boolean z) {
            AppMethodBeat.i(86904);
            super.onChange(z);
            ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
            if (!(a.this.hiE == null || a.this.hiC.get() == null)) {
                ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
                a.this.a(a.b(a.this.hiE), null);
                a.this.hiB = null;
            }
            AppMethodBeat.o(86904);
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }
    }

    public interface a {
        void a(b bVar, boolean z);
    }

    class d {
        a hiS;
        b hiT;

        /* synthetic */ d(a aVar, b bVar, a aVar2, byte b) {
            this(bVar, aVar2);
        }

        private d(b bVar, a aVar) {
            this.hiT = bVar;
            this.hiS = aVar;
        }

        public final String toString() {
            AppMethodBeat.i(86911);
            String str = "Req{" + this.hiT + ", " + this.hiS + "}";
            AppMethodBeat.o(86911);
            return str;
        }
    }

    static class c {
        a hiS;
        b hiT;
        String name;
        boolean success;

        /* synthetic */ c(a aVar, b bVar, boolean z, String str, byte b) {
            this(aVar, bVar, z, str);
        }

        private c(a aVar, b bVar, boolean z, String str) {
            this.hiS = aVar;
            this.hiT = bVar;
            this.success = z;
            this.name = str;
        }

        /* Access modifiers changed, original: final */
        public final void execute() {
            AppMethodBeat.i(86910);
            ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", this.name);
            if (this.hiS == null) {
                ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
                AppMethodBeat.o(86910);
                return;
            }
            this.hiS.a(this.hiT, this.success);
            AppMethodBeat.o(86910);
        }
    }

    public enum b {
        PORTRAIT(1),
        UNSPECIFIED(-1),
        LANDSCAPE_SENSOR(6),
        LANDSCAPE_LOCKED(0),
        LANDSCAPE_LEFT(8),
        LANDSCAPE_RIGHT(0);
        
        public final int hiQ;

        static {
            AppMethodBeat.o(86909);
        }

        public final boolean c(b bVar) {
            return this == bVar || ((this == LANDSCAPE_SENSOR && bVar == LANDSCAPE_LOCKED) || (this == LANDSCAPE_LOCKED && bVar == LANDSCAPE_SENSOR));
        }

        private b(int i) {
            this.hiQ = i;
        }
    }

    static {
        AppMethodBeat.i(86929);
        AppMethodBeat.o(86929);
    }

    public static a t(Activity activity) {
        a aVar;
        AppMethodBeat.i(86912);
        synchronized (hiz) {
            try {
                aVar = (a) hiz.get(activity.hashCode());
                if (aVar == null) {
                    aVar = new a(activity);
                    hiz.put(activity.hashCode(), aVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86912);
            }
        }
        return aVar;
    }

    private a(Activity activity) {
        AppMethodBeat.i(86913);
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
        this.hiG = activity.getResources().getConfiguration().orientation;
        this.hiC = new WeakReference(activity);
        this.hiF = ayQ();
        activity.setRequestedOrientation(dI(this.hiF).hiQ);
        AppMethodBeat.o(86913);
    }

    /* JADX WARNING: Missing block: B:21:0x00a3, code skipped:
            if (r0 == null) goto L_0x00b3;
     */
    /* JADX WARNING: Missing block: B:22:0x00a5, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            a(r0.hiS, r1, false);
     */
    /* JADX WARNING: Missing block: B:23:0x00b3, code skipped:
            r10.hiE = r11;
            com.tencent.matrix.trace.core.AppMethodBeat.o(86914);
     */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b bVar, a aVar) {
        AppMethodBeat.i(86914);
        Activity activity = (Activity) this.hiC.get();
        b dI = dI(this.hiF);
        ab.c("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", bVar, aVar, dI, this.hiE);
        if (activity == null) {
            ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
            a(aVar, dI, false);
            this.hiE = bVar;
            AppMethodBeat.o(86914);
        } else if (bVar == null) {
            ab.w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
            a(aVar, dI, false);
            this.hiE = bVar;
            AppMethodBeat.o(86914);
        } else if (bVar != dI || this.hiE == b.UNSPECIFIED) {
            d dVar = null;
            synchronized (this) {
                try {
                    if (this.mFinished) {
                        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
                        this.hiE = bVar;
                    } else if (this.hiA == null) {
                        this.hiA = new d(this, bVar, aVar, (byte) 0);
                        a(this.hiA);
                    } else {
                        if (this.hiB != null) {
                            dVar = this.hiB;
                        }
                        this.hiB = new d(this, bVar, aVar, (byte) 0);
                    }
                } finally {
                    AppMethodBeat.o(86914);
                }
            }
        } else {
            ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", bVar);
            a(aVar, bVar, true);
            this.hiE = bVar;
            AppMethodBeat.o(86914);
        }
    }

    public static boolean ayQ() {
        AppMethodBeat.i(86915);
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", Integer.valueOf(System.getInt(ah.getContext().getContentResolver(), "accelerometer_rotation", 0)));
        if (System.getInt(ah.getContext().getContentResolver(), "accelerometer_rotation", 0) == 1) {
            AppMethodBeat.o(86915);
            return false;
        }
        AppMethodBeat.o(86915);
        return true;
    }

    private void a(final d dVar) {
        AppMethodBeat.i(86916);
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", dVar);
        final Activity activity = (Activity) this.hiC.get();
        if (activity == null) {
            ab.w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
            if (dVar.hiS != null) {
                dVar.hiS.a(dVar.hiT, false);
            }
            AppMethodBeat.o(86916);
            return;
        }
        activity.setRequestedOrientation(dVar.hiT.hiQ);
        this.hiF = ayQ();
        if (b(dVar)) {
            a(dVar.hiT);
            AppMethodBeat.o(86916);
            return;
        }
        if (this.hiH == null) {
            this.hiH = new b();
        }
        this.hiH.a(new a() {
            public final void ayR() {
                AppMethodBeat.i(86905);
                ab.e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time");
                if (dVar.hiS != null) {
                    dVar.hiS.a(dVar.hiT, false);
                }
                AppMethodBeat.o(86905);
            }

            public final void ayS() {
                AppMethodBeat.i(86906);
                ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry");
                if (!activity.isDestroyed()) {
                    a.b(activity, dVar.hiT.hiQ);
                }
                AppMethodBeat.o(86906);
            }
        });
        AppMethodBeat.o(86916);
    }

    private boolean b(d dVar) {
        AppMethodBeat.i(86917);
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.hiG + "  request orientation=" + dVar.hiT);
        if (this.hiG == 2 && (dVar.hiT.c(b.LANDSCAPE_SENSOR) || dVar.hiT.c(b.LANDSCAPE_LEFT) || dVar.hiT.c(b.LANDSCAPE_RIGHT))) {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
            AppMethodBeat.o(86917);
            return true;
        } else if (this.hiG == 1 && dVar.hiT.c(b.PORTRAIT)) {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
            AppMethodBeat.o(86917);
            return true;
        } else if (this.hiG == 0) {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
            AppMethodBeat.o(86917);
            return true;
        } else if (dVar.hiT == b.UNSPECIFIED) {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
            AppMethodBeat.o(86917);
            return true;
        } else {
            AppMethodBeat.o(86917);
            return false;
        }
    }

    /* JADX WARNING: Missing block: B:41:0x00a8, code skipped:
            r1 = r6.iterator();
     */
    /* JADX WARNING: Missing block: B:43:0x00b0, code skipped:
            if (r1.hasNext() == false) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:44:0x00b2, code skipped:
            ((com.tencent.mm.plugin.appbrand.config.a.a.c) r1.next()).execute();
     */
    /* JADX WARNING: Missing block: B:49:0x00c7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(86918);
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(b bVar) {
        String str;
        boolean z = false;
        AppMethodBeat.i(86918);
        Activity activity = (Activity) this.hiC.get();
        if (activity == null || bVar == null) {
            str = "MicroMsg.AppBrandDeviceOrientationHandler";
            RuntimeException runtimeException = new RuntimeException();
            String str2 = "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(activity == null);
            objArr[1] = Boolean.valueOf(bVar == null);
            ab.printErrStackTrace(str, runtimeException, str2, objArr);
        }
        List linkedList = new LinkedList();
        synchronized (this) {
            try {
                if (this.mFinished) {
                    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
                } else if (this.hiA == null) {
                    ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
                    AppMethodBeat.o(86918);
                } else {
                    str = "MicroMsg.AppBrandDeviceOrientationHandler";
                    String str3 = "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = bVar == null ? BuildConfig.COMMAND : bVar.name();
                    ab.i(str, str3, objArr2);
                    if (this.hiA.hiS != null) {
                        a aVar = this.hiA.hiS;
                        if (bVar != null && bVar.c(this.hiA.hiT)) {
                            z = true;
                        }
                        linkedList.add(new c(aVar, bVar, z, "CurrentRequest.listener result received", (byte) 0));
                    }
                    this.hiA = null;
                    if (this.hiB != null) {
                        a(bVar, linkedList);
                    }
                }
            } finally {
                AppMethodBeat.o(86918);
            }
        }
    }

    private void a(b bVar, List<c> list) {
        AppMethodBeat.i(86919);
        if (bVar == this.hiB.hiT) {
            if (this.hiB.hiS != null) {
                list.add(new c(this.hiB.hiS, bVar, true, "PendingRequest.Listener orientation equal direct", (byte) 0));
            }
            this.hiB = null;
            AppMethodBeat.o(86919);
        } else if (((Activity) this.hiC.get()) == null) {
            ab.e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
            if (this.hiB.hiS != null) {
                list.add(new c(this.hiB.hiS, bVar, false, "PendingRequest.Listener activity == null", (byte) 0));
            }
            AppMethodBeat.o(86919);
        } else {
            this.hiA = this.hiB;
            this.hiB = null;
            a(this.hiA);
            AppMethodBeat.o(86919);
        }
    }

    public final b dI(boolean z) {
        AppMethodBeat.i(86920);
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        b G = G(this.hiG, z);
        AppMethodBeat.o(86920);
        return G;
    }

    private static void a(a aVar, b bVar, boolean z) {
        AppMethodBeat.i(86921);
        if (aVar == null) {
            AppMethodBeat.o(86921);
            return;
        }
        aVar.a(bVar, z);
        AppMethodBeat.o(86921);
    }

    public static b yV(String str) {
        AppMethodBeat.i(86922);
        b bVar;
        if ("landscape".equals(str)) {
            bVar = b.LANDSCAPE_SENSOR;
            AppMethodBeat.o(86922);
            return bVar;
        } else if ("portrait".equals(str)) {
            bVar = b.PORTRAIT;
            AppMethodBeat.o(86922);
            return bVar;
        } else if ("landscapeLeft".equals(str)) {
            bVar = b.LANDSCAPE_LEFT;
            AppMethodBeat.o(86922);
            return bVar;
        } else if ("landscapeRight".equals(str)) {
            bVar = b.LANDSCAPE_RIGHT;
            AppMethodBeat.o(86922);
            return bVar;
        } else if ("auto".equals(str)) {
            bVar = b.UNSPECIFIED;
            AppMethodBeat.o(86922);
            return bVar;
        } else {
            AppMethodBeat.o(86922);
            return null;
        }
    }

    public static b g(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(86923);
        b bVar = null;
        if (appBrandInitConfig != null) {
            bVar = yV(appBrandInitConfig.hfh);
        }
        if (bVar == null) {
            bVar = b.PORTRAIT;
        }
        AppMethodBeat.o(86923);
        return bVar;
    }

    public static b a(com.tencent.mm.plugin.appbrand.config.a aVar, com.tencent.mm.plugin.appbrand.config.a.d dVar) {
        AppMethodBeat.i(86924);
        b bVar = null;
        if (dVar != null) {
            bVar = h.yV(dVar.hfD);
        }
        if (bVar == null && aVar != null) {
            bVar = yV(aVar.heX.hfh);
        }
        if (bVar == null) {
            bVar = b.PORTRAIT;
        }
        AppMethodBeat.o(86924);
        return bVar;
    }

    public final b G(int i, boolean z) {
        AppMethodBeat.i(86926);
        b bVar;
        if (i == 2) {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
            if (z) {
                ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
                bVar = b.LANDSCAPE_LOCKED;
                AppMethodBeat.o(86926);
                return bVar;
            } else if (this.hiE == b.LANDSCAPE_LEFT) {
                bVar = b.LANDSCAPE_LEFT;
                AppMethodBeat.o(86926);
                return bVar;
            } else if (this.hiE == b.LANDSCAPE_RIGHT) {
                bVar = b.LANDSCAPE_RIGHT;
                AppMethodBeat.o(86926);
                return bVar;
            } else {
                bVar = b.LANDSCAPE_SENSOR;
                AppMethodBeat.o(86926);
                return bVar;
            }
        } else if (i == 1) {
            ab.d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
            bVar = b.PORTRAIT;
            AppMethodBeat.o(86926);
            return bVar;
        } else {
            ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(i));
            AppMethodBeat.o(86926);
            return null;
        }
    }

    public static boolean t(i iVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(86925);
        switch (((WindowManager) ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
            case 0:
                z = true;
                break;
            case 1:
                z = false;
                break;
            case 2:
                z = true;
                break;
            case 3:
                z = false;
                break;
            default:
                z = true;
                break;
        }
        if (a(iVar.getAppConfig(), null) == b.PORTRAIT) {
            z2 = true;
        } else {
            z2 = false;
        }
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex] isCurrentPortrait %b, isGameShouldPortrait %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z == z2) {
            AppMethodBeat.o(86925);
            return true;
        }
        AppMethodBeat.o(86925);
        return false;
    }

    static /* synthetic */ void b(Activity activity, int i) {
        AppMethodBeat.i(86928);
        activity.setRequestedOrientation(i);
        AppMethodBeat.o(86928);
    }
}
