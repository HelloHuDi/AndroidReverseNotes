package com.tencent.p177mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.C1326d;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C6624h.C66192;
import com.tencent.p177mm.kernel.p241b.C6624h.C66203;
import com.tencent.p177mm.kernel.p241b.C6624h.C66214;
import com.tencent.p177mm.kernel.p241b.C6624h.C66225;
import com.tencent.p177mm.p179ac.C1189c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.splash.C5102a;
import com.tencent.p177mm.splash.C5122m;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.p177mm.xlog.app.C5754a;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

/* renamed from: com.tencent.mm.app.MMApplicationWrapper */
public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final ApplicationLike lifeCycle;
    private final long processInitTimestamp = System.currentTimeMillis();
    private C6624h profile = null;
    private String thisProcess;

    public MMApplicationWrapper(ApplicationLike applicationLike, String str) {
        AppMethodBeat.m2504i(137959);
        C1311a.m2808q(applicationLike.getApplicationStartMillisTime(), applicationLike.getApplicationStartElapsedTime());
        this.app = applicationLike.getApplication();
        this.lifeCycle = applicationLike;
        this.thisProcess = str;
        AppMethodBeat.m2505o(137959);
    }

    public void onBaseContextAttached(Context context) {
        AppMethodBeat.m2504i(137960);
        C1651a.eKP = SystemClock.elapsedRealtime();
        C1651a.eKO = System.currentTimeMillis();
        this.profile = new C6624h(this.thisProcess, this.app, this.lifeCycle);
        this.profile.eMp.eMq = this.processInitTimestamp;
        FileSystemManager.setContext(this.profile.f1233cc);
        C1261p.m2700By();
        C1449k.m3079a("stlport_shared", context.getClassLoader());
        C1449k.m3079a("c++_shared", context.getClassLoader());
        C1449k.m3079a(C5754a.Aiz, context.getClassLoader());
        this.profile.ecL = C1326d.m2839bo(this.profile.f1233cc);
        setupXLogDebugger(this.profile);
        C5102a.m7739h(this.app);
        C4990ab.m7419v("PreventAccessModification", "profile %s", C1273w.cfw);
        if (C1261p.m2701cX(this.thisProcess)) {
            C4990ab.m7416i(TAG, "is plain process. load nothing");
            C1273w.m2739a(this.profile, null);
        } else {
            C1273w.m2739a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
        }
        C1266q.m2720G(C1318a.class);
        C1266q.m2722cY("com.tencent.mm.boot");
        AppMethodBeat.m2505o(137960);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(137962);
        C1189c.m2614c(this.app);
        C5122m.drr();
        AppMethodBeat.m2505o(137962);
    }

    public void onTerminate() {
        AppMethodBeat.m2504i(137963);
        if (this.profile != null) {
            C6624h c6624h = this.profile;
            c6624h.eMA.mo14669a(new C66214());
        }
        AppMethodBeat.m2505o(137963);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(137964);
        if (this.profile != null) {
            C6624h c6624h = this.profile;
            c6624h.eMA.mo14669a(new C66225(configuration));
        }
        AppMethodBeat.m2505o(137964);
    }

    public void onLowMemory() {
        AppMethodBeat.m2504i(137965);
        if (this.profile != null) {
            C6624h c6624h = this.profile;
            c6624h.eMA.mo14669a(new C66192());
        }
        AppMethodBeat.m2505o(137965);
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.m2504i(137966);
        if (this.profile != null) {
            C6624h c6624h = this.profile;
            c6624h.eMA.mo14669a(new C66203(i));
        }
        AppMethodBeat.m2505o(137966);
    }

    private void setupXLogDebugger(C6624h c6624h) {
        AppMethodBeat.m2504i(137961);
        C1326d c1326d = c6624h.ecL;
        if (c6624h.mo5181SG()) {
            c1326d.mo4656jE("MM");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":push")) {
            c1326d.mo4656jE("PUSH");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":tools")) {
            c1326d.mo4656jE("TOOL");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":toolsmp")) {
            c1326d.mo4656jE("TOOLSMP");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":sandbox")) {
            c1326d.mo4656jE("SANDBOX");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":exdevice")) {
            c1326d.mo4656jE("EXDEVICE");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":patch")) {
            c1326d.mo4656jE("PATCH");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":appbrand0")) {
            c1326d.mo4656jE("APPBRAND0");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":appbrand1")) {
            c1326d.mo4656jE("APPBRAND1");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":appbrand2")) {
            c1326d.mo4656jE("APPBRAND2");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":appbrand3")) {
            c1326d.mo4656jE("APPBRAND3");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":appbrand4")) {
            c1326d.mo4656jE("APPBRAND4");
            AppMethodBeat.m2505o(137961);
        } else if (c6624h.mo5183lQ(":TMAssistantDownloadSDKService")) {
            c1326d.mo4656jE("TMSDK");
            AppMethodBeat.m2505o(137961);
        } else {
            if (c6624h.mo5183lQ(":dexopt")) {
                c1326d.mo4656jE("DEXOPT");
            }
            AppMethodBeat.m2505o(137961);
        }
    }
}
