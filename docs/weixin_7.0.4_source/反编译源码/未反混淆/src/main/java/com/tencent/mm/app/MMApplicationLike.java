package com.tencent.mm.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.util.ArrayMap;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.lang.reflect.Field;

public class MMApplicationLike extends DefaultApplicationLike {
    private static final String TAG = "MicroMsg.MMApplication";
    private static MMApplicationLike sSafeguardInstance = null;
    private static byte[] sSafeguardLock = new byte[0];
    private k mMMApplicationLikeImpl = new k(this);
    private ApplicationLifeCycle wrapper;

    public MMApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
        AppMethodBeat.i(3232);
        AppMethodBeat.o(3232);
    }

    public void onBaseContextAttached(Context context) {
        AppMethodBeat.i(3233);
        if (safeguard()) {
            AppMethodBeat.o(3233);
            return;
        }
        Bundle aY = r.aY(context);
        if (aY == null) {
            ab.e("MicroMsg.SetupBaseBuildInfo", "meta bundle is null!!!!");
        } else {
            a.m(aY);
        }
        f.DEBUG = false;
        f.BUILD_TAG = BuildConfig.BUILD_TAG;
        f.OWNER = BuildConfig.OWNER;
        f.HOSTNAME = BuildConfig.HOSTNAME;
        f.TIME = BuildConfig.TIME;
        f.COMMAND = BuildConfig.COMMAND;
        f.REV = BuildConfig.REV;
        f.SVNPATH = BuildConfig.SVNPATH;
        String str = BuildConfig.CLIENT_VERSION;
        f.CLIENT_VERSION = str;
        f.xxY = Integer.decode(str).intValue();
        f.ENABLE_FPS_ANALYSE = false;
        f.ENABLE_MATRIX = true;
        f.ENABLE_MATRIX_TRACE = false;
        f.EX_DEVICE_LOGIN = false;
        f.PRE_RELEASE = false;
        f.REDESIGN_ENTRANCE = false;
        f.IS_FLAVOR_RED = false;
        f.IS_FLAVOR_PURPLE = false;
        ArrayMap arrayMap = new ArrayMap();
        for (Field field : BuildConfig.class.getFields()) {
            try {
                ab.i("MicroMsg.SetupBaseBuildInfo", "Copy BuildConfig field %s %s", field.getName(), field.get(null));
                arrayMap.put(field.getName(), field.get(null));
            } catch (IllegalAccessException e) {
                ab.printErrStackTrace("MicroMsg.SetupBaseBuildInfo", e, "", new Object[0]);
            }
        }
        s sVar = f.xxZ;
        if (!sVar.xyo) {
            sVar.xyn.putAll(arrayMap);
        }
        f.xxZ.xyo = true;
        b.a(a.cer);
        super.onBaseContextAttached(context);
        k kVar = this.mMMApplicationLikeImpl;
        v.a.cfp.b(k.cdV);
        v.a.cfp.BA();
        ApplicationLike applicationLike = k.cdV;
        if (applicationLike == null || applicationLike.getApplication() == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("tinkerApplication is null");
            AppMethodBeat.o(3233);
            throw tinkerRuntimeException;
        }
        if (ShareTinkerInternals.Sb(applicationLike.getTinkerFlags()) && com.tencent.tinker.lib.e.b.c(k.cdV)) {
            com.tencent.tinker.lib.a.a.a(k.cdV, "armeabi-v7a");
            com.tencent.tinker.lib.a.a.a(k.cdV, "armeabi");
        }
        b.cdW = k.cdV.getApplicationStartMillisTime();
        k.a(k.cdV);
        k.cev += "/" + kVar.hashCode();
        ah.ph(false);
        ah.setContext(k.cdV.getApplication());
        String aw = bo.aw(context, Process.myPid());
        ab.LZ(0);
        b.bWa = aw;
        if (!f.DEBUG) {
            ab.e("MicroMsg.MMApplicationLikeImpl", "befrore initCrash()");
            h.a(k.cdV.getApplication(), aw);
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(com.tencent.mm.loader.j.b.eSj + "NowRev.ini");
        kVar.cew = aVar.getValue("NowRev");
        kVar.cex = f.CLIENT_VERSION;
        long currentTimeMillis2 = System.currentTimeMillis();
        kVar.cey = currentTimeMillis2 - currentTimeMillis;
        kVar.cez = 0;
        if (!kVar.cex.equals(kVar.cew)) {
            ah.xzd = true;
            e.u(k.cdV.getApplication().getDir("lib", 0));
            e.u(k.cdV.getApplication().getDir("dex", 0));
            e.u(k.cdV.getApplication().getDir("cache", 0));
            e.u(k.cdV.getApplication().getDir("recover_lib", 0));
            com.tencent.tinker.lib.e.b.e(k.cdV);
            aVar.hV("NowRev", kVar.cex);
            kVar.cez = System.currentTimeMillis() - currentTimeMillis2;
            ab.w("MicroMsg.MMApplicationLikeImpl", "application hash:%s, %s", k.cev, bo.dpG().toString());
        }
        ab.i("MicroMsg.MMApplicationLikeImpl", "clearOldDirIfNewVersion oldversion:%s, newversion:%s, gettime:%d, settime:%d", kVar.cew, kVar.cex, Long.valueOf(kVar.cey), Long.valueOf(kVar.cez));
        if (f.DEBUG || f.PRE_RELEASE) {
            ab.e("MicroMsg.MMApplicationLikeImpl", "after initCrash()");
            h.a(k.cdV.getApplication(), aw);
        }
        str = b.bWa;
        try {
            this.wrapper = (ApplicationLifeCycle) Class.forName(ah.getPackageName() + ".app.MMApplicationWrapper").getConstructor(new Class[]{ApplicationLike.class, String.class}).newInstance(new Object[]{this, str});
            this.wrapper.onBaseContextAttached(context);
            AppMethodBeat.o(3233);
        } catch (Exception e2) {
            ab.printErrStackTrace(TAG, e2, "failed to create application wrapper class", new Object[0]);
            RuntimeException runtimeException = new RuntimeException("failed to create application wrapper class", e2);
            AppMethodBeat.o(3233);
            throw runtimeException;
        }
    }

    public void onCreate() {
        AppMethodBeat.i(3234);
        if (this.wrapper != null) {
            this.wrapper.onCreate();
        }
        AppMethodBeat.o(3234);
    }

    public void onTerminate() {
        AppMethodBeat.i(3235);
        super.onTerminate();
        if (this.wrapper != null) {
            this.wrapper.onTerminate();
        }
        AppMethodBeat.o(3235);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(3236);
        ab.d(TAG, "configuration changed");
        super.onConfigurationChanged(configuration);
        if (this.wrapper != null) {
            this.wrapper.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(3236);
    }

    public Resources getResources(Resources resources) {
        AppMethodBeat.i(3237);
        if (ah.getResources() == null) {
            AppMethodBeat.o(3237);
            return resources;
        }
        resources = ah.getResources();
        AppMethodBeat.o(3237);
        return resources;
    }

    public void onLowMemory() {
        AppMethodBeat.i(3238);
        super.onLowMemory();
        if (this.wrapper != null) {
            this.wrapper.onLowMemory();
        }
        AppMethodBeat.o(3238);
    }

    public void onTrimMemory(int i) {
        AppMethodBeat.i(3239);
        super.onTrimMemory(i);
        if (this.wrapper != null) {
            this.wrapper.onTrimMemory(i);
        }
        AppMethodBeat.o(3239);
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
