package com.tencent.p177mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p136e.p137a.C0926b;
import com.tencent.p177mm.app.C1271v.C1270a;
import com.tencent.p177mm.app.C6317i.C1259a;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.p603e.C4894a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5064s;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.lib.p678a.C5940a;
import com.tencent.tinker.lib.p679e.C5941b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.app.MMApplicationLike */
public class MMApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "MicroMsg.MMApplication";
    private static MMApplicationLike sSafeguardInstance = null;
    private static byte[] sSafeguardLock = new byte[0];
    private C1260k mMMApplicationLikeImpl = new C1260k(this);
    private ApplicationLifeCycle wrapper;

    public MMApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
        AppMethodBeat.m2504i(3232);
        AppMethodBeat.m2505o(3232);
    }

    public void onBaseContextAttached(Context context) {
        AppMethodBeat.m2504i(3233);
        if (safeguard()) {
            AppMethodBeat.m2505o(3233);
            return;
        }
        Bundle aY = C1268r.m2726aY(context);
        if (aY == null) {
            C4990ab.m7412e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
        } else {
            C1760a.m3624m(aY);
        }
        C5058f.DEBUG = false;
        C5058f.BUILD_TAG = BuildConfig.BUILD_TAG;
        C5058f.OWNER = BuildConfig.OWNER;
        C5058f.HOSTNAME = BuildConfig.HOSTNAME;
        C5058f.TIME = BuildConfig.TIME;
        C5058f.COMMAND = BuildConfig.COMMAND;
        C5058f.REV = BuildConfig.REV;
        C5058f.SVNPATH = BuildConfig.SVNPATH;
        String str = BuildConfig.CLIENT_VERSION;
        C5058f.CLIENT_VERSION = str;
        C5058f.xxY = Integer.decode(str).intValue();
        C5058f.ENABLE_FPS_ANALYSE = false;
        C5058f.ENABLE_MATRIX = true;
        C5058f.ENABLE_MATRIX_TRACE = false;
        C5058f.EX_DEVICE_LOGIN = false;
        C5058f.PRE_RELEASE = false;
        C5058f.REDESIGN_ENTRANCE = false;
        C5058f.IS_FLAVOR_RED = false;
        C5058f.IS_FLAVOR_PURPLE = false;
        ArrayMap arrayMap = new ArrayMap();
        for (Field field : BuildConfig.class.getFields()) {
            try {
                C4990ab.m7417i("MicroMsg.SetupBaseBuildInfo", "Copy BuildConfig field %s %s", field.getName(), field.get(null));
                arrayMap.put(field.getName(), field.get(null));
            } catch (IllegalAccessException e) {
                C4990ab.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", e, "", new Object[0]);
            }
        }
        C5064s c5064s = C5058f.xxZ;
        if (!c5064s.xyo) {
            c5064s.xyn.putAll(arrayMap);
        }
        C5058f.xxZ.xyo = true;
        C0926b.m2095a(C1259a.cer);
        super.onBaseContextAttached(context);
        C1260k c1260k = this.mMMApplicationLikeImpl;
        C1270a.cfp.mo4563b(C1260k.cdV);
        C1270a.cfp.mo4559BA();
        ApplicationLike applicationLike = C1260k.cdV;
        if (applicationLike == null || applicationLike.getApplication() == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
            AppMethodBeat.m2505o(3233);
            throw tinkerRuntimeException;
        }
        if (ShareTinkerInternals.m9410Sb(applicationLike.getTinkerFlags()) && C5941b.m9259c(C1260k.cdV)) {
            C5940a.m9258a(C1260k.cdV, "armeabi-v7a");
            C5940a.m9258a(C1260k.cdV, "armeabi");
        }
        C1244b.cdW = C1260k.cdV.getApplicationStartMillisTime();
        C1260k.m2699a(C1260k.cdV);
        C1260k.cev += "/" + c1260k.hashCode();
        C4996ah.m7432ph(false);
        C4996ah.setContext(C1260k.cdV.getApplication());
        String aw = C5046bo.m7524aw(context, Process.myPid());
        C4990ab.m7406LZ(0);
        C1244b.bWa = aw;
        if (!C5058f.DEBUG) {
            C4990ab.m7412e("MicroMsg.MMApplicationLikeImpl", "befrore initCrash()");
            C1256h.m2696a(C1260k.cdV.getApplication(), aw);
        }
        long currentTimeMillis = System.currentTimeMillis();
        C4894a c4894a = new C4894a(C1761b.eSj + "NowRev.ini");
        c1260k.cew = c4894a.getValue("NowRev");
        c1260k.cex = C5058f.CLIENT_VERSION;
        long currentTimeMillis2 = System.currentTimeMillis();
        c1260k.cey = currentTimeMillis2 - currentTimeMillis;
        c1260k.cez = 0;
        if (!c1260k.cex.equals(c1260k.cew)) {
            C4996ah.xzd = true;
            C1173e.m2576u(C1260k.cdV.getApplication().getDir("lib", 0));
            C1173e.m2576u(C1260k.cdV.getApplication().getDir("dex", 0));
            C1173e.m2576u(C1260k.cdV.getApplication().getDir("cache", 0));
            C1173e.m2576u(C1260k.cdV.getApplication().getDir("recover_lib", 0));
            C5941b.m9261e(C1260k.cdV);
            c4894a.mo10097hV("NowRev", c1260k.cex);
            c1260k.cez = System.currentTimeMillis() - currentTimeMillis2;
            C4990ab.m7421w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", C1260k.cev, C5046bo.dpG().toString());
        }
        C4990ab.m7417i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", c1260k.cew, c1260k.cex, Long.valueOf(c1260k.cey), Long.valueOf(c1260k.cez));
        if (C5058f.DEBUG || C5058f.PRE_RELEASE) {
            C4990ab.m7412e("MicroMsg.MMApplicationLikeImpl", "after initCrash()");
            C1256h.m2696a(C1260k.cdV.getApplication(), aw);
        }
        str = C1244b.bWa;
        try {
            this.wrapper = (ApplicationLifeCycle) Class.forName(C4996ah.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[]{ApplicationLike.class, String.class}).newInstance(new Object[]{this, str});
            this.wrapper.onBaseContextAttached(context);
            AppMethodBeat.m2505o(3233);
        } catch (Exception e2) {
            C4990ab.printErrStackTrace(TAG, e2, "failed to create application wrapper class", new Object[0]);
            RuntimeException runtimeException = new RuntimeException("failed to create application wrapper class", e2);
            AppMethodBeat.m2505o(3233);
            throw runtimeException;
        }
    }

    public void onCreate() {
        AppMethodBeat.m2504i(3234);
        if (this.wrapper != null) {
            this.wrapper.onCreate();
        }
        AppMethodBeat.m2505o(3234);
    }

    public void onTerminate() {
        AppMethodBeat.m2504i(3235);
        super.onTerminate();
        if (this.wrapper != null) {
            this.wrapper.onTerminate();
        }
        AppMethodBeat.m2505o(3235);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(3236);
        C4990ab.m7410d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        if (this.wrapper != null) {
            this.wrapper.onConfigurationChanged(configuration);
        }
        AppMethodBeat.m2505o(3236);
    }

    public Resources getResources(Resources resources) {
        AppMethodBeat.m2504i(3237);
        if (C4996ah.getResources() == null) {
            AppMethodBeat.m2505o(3237);
            return resources;
        }
        resources = C4996ah.getResources();
        AppMethodBeat.m2505o(3237);
        return resources;
    }

    public void onLowMemory() {
        AppMethodBeat.m2504i(3238);
        super.onLowMemory();
        if (this.wrapper != null) {
            this.wrapper.onLowMemory();
        }
        AppMethodBeat.m2505o(3238);
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.m2504i(3239);
        super.onTrimMemory(i);
        if (this.wrapper != null) {
            this.wrapper.onTrimMemory(i);
        }
        AppMethodBeat.m2505o(3239);
    }

    public boolean safeguard() {
        boolean z;
        synchronized (sSafeguardLock) {
            if (sSafeguardInstance != this) {
                if (sSafeguardInstance == null) {
                    sSafeguardInstance = this;
                } else {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
