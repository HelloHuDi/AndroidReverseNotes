package com.tencent.p177mm.plugin.appbrand.config.p283a;

import android.app.Activity;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.SparseArray;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C33131d;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C38165h;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C38162b.C33132a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.config.a.a */
public final class C26835a {
    public static final SparseArray<C26835a> hiz = new SparseArray();
    public C26837d hiA;
    public C26837d hiB;
    private WeakReference<Activity> hiC;
    public ContentObserver hiD = null;
    public C26839b hiE = null;
    private boolean hiF;
    public int hiG;
    public C38162b hiH = null;
    public boolean mFinished = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$1 */
    public class C21131 extends ContentObserver {
        public C21131(Handler handler) {
            super(handler);
        }

        public final void onChange(boolean z) {
            AppMethodBeat.m2504i(86904);
            super.onChange(z);
            C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
            if (!(C26835a.this.hiE == null || C26835a.this.hiC.get() == null)) {
                C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
                C26835a.this.mo44609a(C26835a.m42711b(C26835a.this.hiE), null);
                C26835a.this.hiB = null;
            }
            AppMethodBeat.m2505o(86904);
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$a */
    public interface C26836a {
        /* renamed from: a */
        void mo3966a(C26839b c26839b, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$d */
    class C26837d {
        C26836a hiS;
        C26839b hiT;

        /* synthetic */ C26837d(C26835a c26835a, C26839b c26839b, C26836a c26836a, byte b) {
            this(c26839b, c26836a);
        }

        private C26837d(C26839b c26839b, C26836a c26836a) {
            this.hiT = c26839b;
            this.hiS = c26836a;
        }

        public final String toString() {
            AppMethodBeat.m2504i(86911);
            String str = "Req{" + this.hiT + ", " + this.hiS + "}";
            AppMethodBeat.m2505o(86911);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$c */
    static class C26838c {
        C26836a hiS;
        C26839b hiT;
        String name;
        boolean success;

        /* synthetic */ C26838c(C26836a c26836a, C26839b c26839b, boolean z, String str, byte b) {
            this(c26836a, c26839b, z, str);
        }

        private C26838c(C26836a c26836a, C26839b c26839b, boolean z, String str) {
            this.hiS = c26836a;
            this.hiT = c26839b;
            this.success = z;
            this.name = str;
        }

        /* Access modifiers changed, original: final */
        public final void execute() {
            AppMethodBeat.m2504i(86910);
            C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "Notify Listener[%s]", this.name);
            if (this.hiS == null) {
                C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "PendingNotify: Listener is null when execute.");
                AppMethodBeat.m2505o(86910);
                return;
            }
            this.hiS.mo3966a(this.hiT, this.success);
            AppMethodBeat.m2505o(86910);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.config.a.a$b */
    public enum C26839b {
        PORTRAIT(1),
        UNSPECIFIED(-1),
        LANDSCAPE_SENSOR(6),
        LANDSCAPE_LOCKED(0),
        LANDSCAPE_LEFT(8),
        LANDSCAPE_RIGHT(0);
        
        public final int hiQ;

        static {
            AppMethodBeat.m2505o(86909);
        }

        /* renamed from: c */
        public final boolean mo44613c(C26839b c26839b) {
            return this == c26839b || ((this == LANDSCAPE_SENSOR && c26839b == LANDSCAPE_LOCKED) || (this == LANDSCAPE_LOCKED && c26839b == LANDSCAPE_SENSOR));
        }

        private C26839b(int i) {
            this.hiQ = i;
        }
    }

    static {
        AppMethodBeat.m2504i(86929);
        AppMethodBeat.m2505o(86929);
    }

    /* renamed from: t */
    public static C26835a m42717t(Activity activity) {
        C26835a c26835a;
        AppMethodBeat.m2504i(86912);
        synchronized (hiz) {
            try {
                c26835a = (C26835a) hiz.get(activity.hashCode());
                if (c26835a == null) {
                    c26835a = new C26835a(activity);
                    hiz.put(activity.hashCode(), c26835a);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86912);
            }
        }
        return c26835a;
    }

    private C26835a(Activity activity) {
        AppMethodBeat.m2504i(86913);
        C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationHandler construct");
        this.hiG = activity.getResources().getConfiguration().orientation;
        this.hiC = new WeakReference(activity);
        this.hiF = C26835a.ayQ();
        activity.setRequestedOrientation(mo44610dI(this.hiF).hiQ);
        AppMethodBeat.m2505o(86913);
    }

    /* JADX WARNING: Missing block: B:21:0x00a3, code skipped:
            if (r0 == null) goto L_0x00b3;
     */
    /* JADX WARNING: Missing block: B:22:0x00a5, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "dismissRequest not null");
            com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.m42708a(r0.hiS, r1, false);
     */
    /* JADX WARNING: Missing block: B:23:0x00b3, code skipped:
            r10.hiE = r11;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(86914);
     */
    /* JADX WARNING: Missing block: B:35:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo44609a(C26839b c26839b, C26836a c26836a) {
        AppMethodBeat.m2504i(86914);
        Activity activity = (Activity) this.hiC.get();
        C26839b dI = mo44610dI(this.hiF);
        C4990ab.m7409c("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation reqOrientation = [%s], listener = [%s] currentOrientation = [%s], latestOrientation = [%s]", c26839b, c26836a, dI, this.hiE);
        if (activity == null) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", new RuntimeException(), "No Activity found when request device orientation", new Object[0]);
            C26835a.m42708a(c26836a, dI, false);
            this.hiE = c26839b;
            AppMethodBeat.m2505o(86914);
        } else if (c26839b == null) {
            C4990ab.m7420w("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation null");
            C26835a.m42708a(c26836a, dI, false);
            this.hiE = c26839b;
            AppMethodBeat.m2505o(86914);
        } else if (c26839b != dI || this.hiE == C26839b.UNSPECIFIED) {
            C26837d c26837d = null;
            synchronized (this) {
                try {
                    if (this.mFinished) {
                        C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation mFinished = true");
                        this.hiE = c26839b;
                    } else if (this.hiA == null) {
                        this.hiA = new C26837d(this, c26839b, c26836a, (byte) 0);
                        m42710a(this.hiA);
                    } else {
                        if (this.hiB != null) {
                            c26837d = this.hiB;
                        }
                        this.hiB = new C26837d(this, c26839b, c26836a, (byte) 0);
                    }
                } finally {
                    AppMethodBeat.m2505o(86914);
                }
            }
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "requestDeviceOrientation currentOrientation hit. [%s]", c26839b);
            C26835a.m42708a(c26836a, c26839b, true);
            this.hiE = c26839b;
            AppMethodBeat.m2505o(86914);
        }
    }

    public static boolean ayQ() {
        AppMethodBeat.m2504i(86915);
        C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: systenm orientation %d", Integer.valueOf(System.getInt(C4996ah.getContext().getContentResolver(), "accelerometer_rotation", 0)));
        if (System.getInt(C4996ah.getContext().getContentResolver(), "accelerometer_rotation", 0) == 1) {
            AppMethodBeat.m2505o(86915);
            return false;
        }
        AppMethodBeat.m2505o(86915);
        return true;
    }

    /* renamed from: a */
    private void m42710a(final C26837d c26837d) {
        AppMethodBeat.m2504i(86916);
        C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "AppBrandDeviceOrientationConfig.requestDeviceOrientationImpl setRequestOrientation [%s]", c26837d);
        final Activity activity = (Activity) this.hiC.get();
        if (activity == null) {
            C4990ab.m7420w("MicroMsg.AppBrandDeviceOrientationHandler", "hy: ui already released!");
            if (c26837d.hiS != null) {
                c26837d.hiS.mo3966a(c26837d.hiT, false);
            }
            AppMethodBeat.m2505o(86916);
            return;
        }
        activity.setRequestedOrientation(c26837d.hiT.hiQ);
        this.hiF = C26835a.ayQ();
        if (m42714b(c26837d)) {
            mo44608a(c26837d.hiT);
            AppMethodBeat.m2505o(86916);
            return;
        }
        if (this.hiH == null) {
            this.hiH = new C38162b();
        }
        this.hiH.mo60901a(new C33132a() {
            public final void ayR() {
                AppMethodBeat.m2504i(86905);
                C4990ab.m7412e("MicroMsg.AppBrandDeviceOrientationHandler", "hy: activity not turn to correct orientation for long time");
                if (c26837d.hiS != null) {
                    c26837d.hiS.mo3966a(c26837d.hiT, false);
                }
                AppMethodBeat.m2505o(86905);
            }

            public final void ayS() {
                AppMethodBeat.m2504i(86906);
                C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: trigger retry");
                if (!activity.isDestroyed()) {
                    C26835a.m42713b(activity, c26837d.hiT.hiQ);
                }
                AppMethodBeat.m2505o(86906);
            }
        });
        AppMethodBeat.m2505o(86916);
    }

    /* renamed from: b */
    private boolean m42714b(C26837d c26837d) {
        AppMethodBeat.m2504i(86917);
        C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "current orientation=" + this.hiG + "  request orientation=" + c26837d.hiT);
        if (this.hiG == 2 && (c26837d.hiT.mo44613c(C26839b.LANDSCAPE_SENSOR) || c26837d.hiT.mo44613c(C26839b.LANDSCAPE_LEFT) || c26837d.hiT.mo44613c(C26839b.LANDSCAPE_RIGHT))) {
            C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same landscape");
            AppMethodBeat.m2505o(86917);
            return true;
        } else if (this.hiG == 1 && c26837d.hiT.mo44613c(C26839b.PORTRAIT)) {
            C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: same portrait");
            AppMethodBeat.m2505o(86917);
            return true;
        } else if (this.hiG == 0) {
            C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: former is undefined, always return immediately");
            AppMethodBeat.m2505o(86917);
            return true;
        } else if (c26837d.hiT == C26839b.UNSPECIFIED) {
            C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: request is UNSPECIFIED, return true");
            AppMethodBeat.m2505o(86917);
            return true;
        } else {
            AppMethodBeat.m2505o(86917);
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
            ((com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26838c) r1.next()).execute();
     */
    /* JADX WARNING: Missing block: B:49:0x00c7, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(86918);
     */
    /* JADX WARNING: Missing block: B:53:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo44608a(C26839b c26839b) {
        String str;
        boolean z = false;
        AppMethodBeat.m2504i(86918);
        Activity activity = (Activity) this.hiC.get();
        if (activity == null || c26839b == null) {
            str = "MicroMsg.AppBrandDeviceOrientationHandler";
            RuntimeException runtimeException = new RuntimeException();
            String str2 = "onConfigurationChanged activity[isNull ? %b] newConfig[isNull ? %b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(activity == null);
            objArr[1] = Boolean.valueOf(c26839b == null);
            C4990ab.printErrStackTrace(str, runtimeException, str2, objArr);
        }
        List linkedList = new LinkedList();
        synchronized (this) {
            try {
                if (this.mFinished) {
                    C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged Finished = true");
                } else if (this.hiA == null) {
                    C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "No current request..., dismiss");
                    AppMethodBeat.m2505o(86918);
                } else {
                    str = "MicroMsg.AppBrandDeviceOrientationHandler";
                    String str3 = "AppBrandDeviceOrientationConfig.onConfigurationChanged [%s]";
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = c26839b == null ? BuildConfig.COMMAND : c26839b.name();
                    C4990ab.m7417i(str, str3, objArr2);
                    if (this.hiA.hiS != null) {
                        C26836a c26836a = this.hiA.hiS;
                        if (c26839b != null && c26839b.mo44613c(this.hiA.hiT)) {
                            z = true;
                        }
                        linkedList.add(new C26838c(c26836a, c26839b, z, "CurrentRequest.listener result received", (byte) 0));
                    }
                    this.hiA = null;
                    if (this.hiB != null) {
                        m42709a(c26839b, linkedList);
                    }
                }
            } finally {
                AppMethodBeat.m2505o(86918);
            }
        }
    }

    /* renamed from: a */
    private void m42709a(C26839b c26839b, List<C26838c> list) {
        AppMethodBeat.m2504i(86919);
        if (c26839b == this.hiB.hiT) {
            if (this.hiB.hiS != null) {
                list.add(new C26838c(this.hiB.hiS, c26839b, true, "PendingRequest.Listener orientation equal direct", (byte) 0));
            }
            this.hiB = null;
            AppMethodBeat.m2505o(86919);
        } else if (((Activity) this.hiC.get()) == null) {
            C4990ab.m7412e("MicroMsg.AppBrandDeviceOrientationHandler", "No Activity when handle pending request");
            if (this.hiB.hiS != null) {
                list.add(new C26838c(this.hiB.hiS, c26839b, false, "PendingRequest.Listener activity == null", (byte) 0));
            }
            AppMethodBeat.m2505o(86919);
        } else {
            this.hiA = this.hiB;
            this.hiB = null;
            m42710a(this.hiA);
            AppMethodBeat.m2505o(86919);
        }
    }

    /* renamed from: dI */
    public final C26839b mo44610dI(boolean z) {
        AppMethodBeat.m2504i(86920);
        C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "getCurrentOrientation");
        C26839b G = mo44607G(this.hiG, z);
        AppMethodBeat.m2505o(86920);
        return G;
    }

    /* renamed from: a */
    private static void m42708a(C26836a c26836a, C26839b c26839b, boolean z) {
        AppMethodBeat.m2504i(86921);
        if (c26836a == null) {
            AppMethodBeat.m2505o(86921);
            return;
        }
        c26836a.mo3966a(c26839b, z);
        AppMethodBeat.m2505o(86921);
    }

    /* renamed from: yV */
    public static C26839b m42719yV(String str) {
        AppMethodBeat.m2504i(86922);
        C26839b c26839b;
        if ("landscape".equals(str)) {
            c26839b = C26839b.LANDSCAPE_SENSOR;
            AppMethodBeat.m2505o(86922);
            return c26839b;
        } else if ("portrait".equals(str)) {
            c26839b = C26839b.PORTRAIT;
            AppMethodBeat.m2505o(86922);
            return c26839b;
        } else if ("landscapeLeft".equals(str)) {
            c26839b = C26839b.LANDSCAPE_LEFT;
            AppMethodBeat.m2505o(86922);
            return c26839b;
        } else if ("landscapeRight".equals(str)) {
            c26839b = C26839b.LANDSCAPE_RIGHT;
            AppMethodBeat.m2505o(86922);
            return c26839b;
        } else if ("auto".equals(str)) {
            c26839b = C26839b.UNSPECIFIED;
            AppMethodBeat.m2505o(86922);
            return c26839b;
        } else {
            AppMethodBeat.m2505o(86922);
            return null;
        }
    }

    /* renamed from: g */
    public static C26839b m42716g(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(86923);
        C26839b c26839b = null;
        if (appBrandInitConfig != null) {
            c26839b = C26835a.m42719yV(appBrandInitConfig.hfh);
        }
        if (c26839b == null) {
            c26839b = C26839b.PORTRAIT;
        }
        AppMethodBeat.m2505o(86923);
        return c26839b;
    }

    /* renamed from: a */
    public static C26839b m42707a(C38163a c38163a, C33131d c33131d) {
        AppMethodBeat.m2504i(86924);
        C26839b c26839b = null;
        if (c33131d != null) {
            c26839b = C38165h.m64599yV(c33131d.hfD);
        }
        if (c26839b == null && c38163a != null) {
            c26839b = C26835a.m42719yV(c38163a.heX.hfh);
        }
        if (c26839b == null) {
            c26839b = C26839b.PORTRAIT;
        }
        AppMethodBeat.m2505o(86924);
        return c26839b;
    }

    /* renamed from: G */
    public final C26839b mo44607G(int i, boolean z) {
        AppMethodBeat.m2504i(86926);
        C26839b c26839b;
        if (i == 2) {
            C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == landscape ");
            if (z) {
                C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "hy: parseConfiguration configuration == landscape but screen locked");
                c26839b = C26839b.LANDSCAPE_LOCKED;
                AppMethodBeat.m2505o(86926);
                return c26839b;
            } else if (this.hiE == C26839b.LANDSCAPE_LEFT) {
                c26839b = C26839b.LANDSCAPE_LEFT;
                AppMethodBeat.m2505o(86926);
                return c26839b;
            } else if (this.hiE == C26839b.LANDSCAPE_RIGHT) {
                c26839b = C26839b.LANDSCAPE_RIGHT;
                AppMethodBeat.m2505o(86926);
                return c26839b;
            } else {
                c26839b = C26839b.LANDSCAPE_SENSOR;
                AppMethodBeat.m2505o(86926);
                return c26839b;
            }
        } else if (i == 1) {
            C4990ab.m7410d("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == portrait ");
            c26839b = C26839b.PORTRAIT;
            AppMethodBeat.m2505o(86926);
            return c26839b;
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "parseConfiguration configuration == %d", Integer.valueOf(i));
            AppMethodBeat.m2505o(86926);
            return null;
        }
    }

    /* renamed from: t */
    public static boolean m42718t(C6750i c6750i) {
        boolean z;
        boolean z2;
        AppMethodBeat.m2504i(86925);
        switch (((WindowManager) C4996ah.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
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
        if (C26835a.m42707a(c6750i.getAppConfig(), null) == C26839b.PORTRAIT) {
            z2 = true;
        } else {
            z2 = false;
        }
        C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "[alex] isCurrentPortrait %b, isGameShouldPortrait %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z == z2) {
            AppMethodBeat.m2505o(86925);
            return true;
        }
        AppMethodBeat.m2505o(86925);
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ void m42713b(Activity activity, int i) {
        AppMethodBeat.m2504i(86928);
        activity.setRequestedOrientation(i);
        AppMethodBeat.m2505o(86928);
    }
}
