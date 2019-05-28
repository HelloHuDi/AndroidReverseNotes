package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.blink.a;
import com.tencent.mm.booter.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.b.h.AnonymousClass3;
import com.tencent.mm.kernel.b.h.AnonymousClass5;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.splash.m;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public class MMApplicationWrapper implements ApplicationLifeCycle {
    private static final String TAG = "MicroMsg.MMApplicationWrapper";
    public Application app;
    private final ApplicationLike lifeCycle;
    private final long processInitTimestamp = System.currentTimeMillis();
    private h profile = null;
    private String thisProcess;

    public MMApplicationWrapper(ApplicationLike applicationLike, String str) {
        AppMethodBeat.i(137959);
        a.q(applicationLike.getApplicationStartMillisTime(), applicationLike.getApplicationStartElapsedTime());
        this.app = applicationLike.getApplication();
        this.lifeCycle = applicationLike;
        this.thisProcess = str;
        AppMethodBeat.o(137959);
    }

    public void onBaseContextAttached(Context context) {
        AppMethodBeat.i(137960);
        com.tencent.mm.kernel.a.a.eKP = SystemClock.elapsedRealtime();
        com.tencent.mm.kernel.a.a.eKO = System.currentTimeMillis();
        this.profile = new h(this.thisProcess, this.app, this.lifeCycle);
        this.profile.eMp.eMq = this.processInitTimestamp;
        FileSystemManager.setContext(this.profile.cc);
        p.By();
        k.a("stlport_shared", context.getClassLoader());
        k.a("c++_shared", context.getClassLoader());
        k.a(com.tencent.mm.xlog.app.a.Aiz, context.getClassLoader());
        this.profile.ecL = d.bo(this.profile.cc);
        setupXLogDebugger(this.profile);
        com.tencent.mm.splash.a.h(this.app);
        ab.v("PreventAccessModification", "profile %s", w.cfw);
        if (p.cX(this.thisProcess)) {
            ab.i(TAG, "is plain process. load nothing");
            w.a(this.profile, null);
        } else {
            w.a(this.profile, "com.tencent.mm.app.WeChatSplashStartup");
        }
        q.G(com.tencent.mm.boot.a.a.class);
        q.cY("com.tencent.mm.boot");
        AppMethodBeat.o(137960);
    }

    public void onCreate() {
        AppMethodBeat.i(137962);
        c.c(this.app);
        m.drr();
        AppMethodBeat.o(137962);
    }

    public void onTerminate() {
        AppMethodBeat.i(137963);
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.eMA.a(new com.tencent.mm.ci.a.a<ApplicationLifeCycle>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58077);
                    ((ApplicationLifeCycle) obj).onTerminate();
                    AppMethodBeat.o(58077);
                }
            });
        }
        AppMethodBeat.o(137963);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(137964);
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.eMA.a(new AnonymousClass5(configuration));
        }
        AppMethodBeat.o(137964);
    }

    public void onLowMemory() {
        AppMethodBeat.i(137965);
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.eMA.a(new com.tencent.mm.ci.a.a<ApplicationLifeCycle>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(58075);
                    ((ApplicationLifeCycle) obj).onLowMemory();
                    AppMethodBeat.o(58075);
                }
            });
        }
        AppMethodBeat.o(137965);
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.i(137966);
        if (this.profile != null) {
            h hVar = this.profile;
            hVar.eMA.a(new AnonymousClass3(i));
        }
        AppMethodBeat.o(137966);
    }

    private void setupXLogDebugger(h hVar) {
        AppMethodBeat.i(137961);
        d dVar = hVar.ecL;
        if (hVar.SG()) {
            dVar.jE("MM");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":push")) {
            dVar.jE("PUSH");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":tools")) {
            dVar.jE("TOOL");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":toolsmp")) {
            dVar.jE("TOOLSMP");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":sandbox")) {
            dVar.jE("SANDBOX");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":exdevice")) {
            dVar.jE("EXDEVICE");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":patch")) {
            dVar.jE("PATCH");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":appbrand0")) {
            dVar.jE("APPBRAND0");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":appbrand1")) {
            dVar.jE("APPBRAND1");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":appbrand2")) {
            dVar.jE("APPBRAND2");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":appbrand3")) {
            dVar.jE("APPBRAND3");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":appbrand4")) {
            dVar.jE("APPBRAND4");
            AppMethodBeat.o(137961);
        } else if (hVar.lQ(":TMAssistantDownloadSDKService")) {
            dVar.jE("TMSDK");
            AppMethodBeat.o(137961);
        } else {
            if (hVar.lQ(":dexopt")) {
                dVar.jE("DEXOPT");
            }
            AppMethodBeat.o(137961);
        }
    }
}
