package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.system.OsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public final class a {
    private static String xGs;
    private static String xGt;
    private static File xGu;
    private static long xGv;
    @SuppressLint({"HandlerLeak"})
    private static Handler xGw = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(114794);
            a aVar = (a) message.obj;
            if (a.access$000()) {
                if (!a.mC(a.xGv)) {
                    a.c(aVar);
                    AppMethodBeat.o(114794);
                    return;
                } else if (a.hc(h.xGE)) {
                    if (!a.eB(h.xGE)) {
                        h.drh().m(675, 18, 1);
                    }
                    h.drh().m(675, 17, 1);
                    aVar.dqW();
                } else {
                    h.drh().m(675, 25, 1);
                    aVar.dqV();
                    AppMethodBeat.o(114794);
                    return;
                }
            } else if (!a.dfx()) {
                h.drh().m(675, 15, 1);
                aVar.dqV();
            } else if (a.hc(h.xGE)) {
                h.drh().m(675, 16, 1);
                aVar.cmC();
            } else {
                h.drh().m(675, 26, 1);
                h.drh().m(675, 15, 1);
                aVar.dqV();
            }
            a.xGv = 0;
            AppMethodBeat.o(114794);
        }
    };

    public interface a {
        void cmC();

        void dqV();

        void dqW();
    }

    static /* synthetic */ boolean access$000() {
        AppMethodBeat.i(114807);
        boolean dqS = dqS();
        AppMethodBeat.o(114807);
        return dqS;
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(114810);
        b(aVar);
        AppMethodBeat.o(114810);
    }

    static /* synthetic */ boolean dfx() {
        AppMethodBeat.i(114811);
        boolean dqT = dqT();
        AppMethodBeat.o(114811);
        return dqT;
    }

    static /* synthetic */ boolean eB(Context context) {
        AppMethodBeat.i(114809);
        boolean hf = hf(context);
        AppMethodBeat.o(114809);
        return hf;
    }

    public static void h(Application application) {
        AppMethodBeat.i(114795);
        xGs = new File(application.getFilesDir(), "dexopt_service").getAbsolutePath();
        AppMethodBeat.o(114795);
    }

    public static String dqR() {
        AppMethodBeat.i(114796);
        if (xGs == null) {
            IllegalStateException illegalStateException = new IllegalStateException("data directory should not be null, give one.");
            AppMethodBeat.o(114796);
            throw illegalStateException;
        }
        File file = new File(xGs);
        if (!(file.exists() || file.mkdirs())) {
            h.g("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
        }
        String str = xGs;
        AppMethodBeat.o(114796);
        return str;
    }

    public static boolean hc(Context context) {
        AppMethodBeat.i(114797);
        h.g("WxSplash.DexOpt", "if need dexopt %s", Boolean.valueOf(h.xGH.ba(context)));
        AppMethodBeat.o(114797);
        return h.xGH.ba(context);
    }

    public static void hd(Context context) {
        AppMethodBeat.i(114798);
        if (g.wY) {
            AppMethodBeat.o(114798);
            return;
        }
        boolean aZ;
        h.drh().m(675, 22, 1);
        try {
            aZ = h.xGH.aZ(context);
        } catch (Throwable th) {
            h.a(th, "multidex install failed");
            aZ = false;
        }
        h.g("WxSplash.DexOpt", "install multidex result %s", Boolean.valueOf(aZ));
        if (!aZ) {
            h.g("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
            h.bZk();
        }
        AppMethodBeat.o(114798);
    }

    public static void he(Context context) {
        AppMethodBeat.i(114799);
        h.g("WxSplash.DexOpt", "start dex opt service", new Object[0]);
        String aw = bo.aw(context, Process.myPid());
        aw.replace(':', '_');
        xGt = "DexOpt_Request_".concat(String.valueOf(aw));
        h.drh().m(675, 14, 1);
        try {
            anZ(xGt);
        } catch (Exception e) {
            Exception exception = e;
            if (VERSION.SDK_INT <= 19 && exception.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {
                try {
                    Field field = exception.getClass().getField("errno");
                    field.setAccessible(true);
                    if (((Integer) field.get(exception)).intValue() == OsConstants.ENOSPC) {
                        int i;
                        File file = new File(dqR());
                        if (file.exists()) {
                            h.g("WxSplash.DexOpt", "check dexopt directory size %s.", Integer.valueOf(file.listFiles().length));
                            i = file.listFiles().length < Downloads.MIN_WAIT_FOR_NETWORK ? 1 : 0;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            h.xGH.bb(context);
                        } else {
                            h.g("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
                            file = new File(dqR());
                            if (file.exists()) {
                                e.u(file);
                            }
                        }
                    }
                } catch (Exception e2) {
                    h.g("WxSplash.DexOpt", "%s, %s", e2.getMessage());
                }
            }
            RuntimeException runtimeException = new RuntimeException(exception);
            AppMethodBeat.o(114799);
            throw runtimeException;
        }
        context.startService(new Intent(context, DexOptService.class));
        AppMethodBeat.o(114799);
    }

    private static synchronized void anZ(String str) {
        synchronized (a.class) {
            AppMethodBeat.i(114800);
            String dqR = dqR();
            File file = new File(dqR);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(dqR + "/" + str);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            xGu = file;
            AppMethodBeat.o(114800);
        }
    }

    private static boolean hf(Context context) {
        AppMethodBeat.i(114801);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(BaseClientBuilder.API_PRIORITY_OTHER);
            if (runningServices == null) {
                h.g("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
                AppMethodBeat.o(114801);
                return false;
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if ("com.tencent.mm.splash.DexOptService".equals(runningServiceInfo.service.getClassName())) {
                    AppMethodBeat.o(114801);
                    return true;
                }
            }
        }
        h.g("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
        AppMethodBeat.o(114801);
        return false;
    }

    public static boolean hg(Context context) {
        AppMethodBeat.i(114802);
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        h.g("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
        while (dqS()) {
            j++;
            Thread.sleep(100);
            if (j >= 5) {
                j = 0;
                if (System.currentTimeMillis() - currentTimeMillis > 180000) {
                    h.g("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
                    if (hc(context)) {
                        if (!hf(context)) {
                            h.drh().m(675, 18, 1);
                        }
                        h.drh().m(675, 17, 1);
                        AppMethodBeat.o(114802);
                        return false;
                    }
                    h.drh().m(675, 25, 1);
                    h.drh().m(675, 15, 1);
                    AppMethodBeat.o(114802);
                    return true;
                }
            }
        }
        if (!dqT()) {
            h.drh().m(675, 15, 1);
            AppMethodBeat.o(114802);
            return true;
        } else if (hc(context)) {
            h.drh().m(675, 16, 1);
            AppMethodBeat.o(114802);
            return false;
        } else {
            h.drh().m(675, 26, 1);
            h.drh().m(675, 15, 1);
            AppMethodBeat.o(114802);
            return true;
        }
    }

    public static void a(a aVar) {
        AppMethodBeat.i(114803);
        b(aVar);
        AppMethodBeat.o(114803);
    }

    static {
        AppMethodBeat.i(114812);
        AppMethodBeat.o(114812);
    }

    private static void b(a aVar) {
        AppMethodBeat.i(114804);
        if (xGv == 0) {
            xGv = System.currentTimeMillis();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        xGw.sendMessageDelayed(obtain, 100);
        AppMethodBeat.o(114804);
    }

    private static boolean dqS() {
        AppMethodBeat.i(114805);
        if (xGu == null) {
            IllegalStateException illegalStateException = new IllegalStateException("tmp file field should not be null");
            AppMethodBeat.o(114805);
            throw illegalStateException;
        }
        boolean exists = xGu.exists();
        AppMethodBeat.o(114805);
        return exists;
    }

    private static boolean dqT() {
        AppMethodBeat.i(114806);
        boolean exists = new File(dqR() + "/DexOpt_Failed").exists();
        AppMethodBeat.o(114806);
        return exists;
    }

    static /* synthetic */ boolean mC(long j) {
        AppMethodBeat.i(114808);
        if (System.currentTimeMillis() - j > 180000) {
            AppMethodBeat.o(114808);
            return true;
        }
        AppMethodBeat.o(114808);
        return false;
    }
}
