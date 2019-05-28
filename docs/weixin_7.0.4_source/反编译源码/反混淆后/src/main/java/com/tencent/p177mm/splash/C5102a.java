package com.tencent.p177mm.splash;

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
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/* renamed from: com.tencent.mm.splash.a */
public final class C5102a {
    private static String xGs;
    private static String xGt;
    private static File xGu;
    private static long xGv;
    @SuppressLint({"HandlerLeak"})
    private static Handler xGw = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(114794);
            C5101a c5101a = (C5101a) message.obj;
            if (C5102a.access$000()) {
                if (!C5102a.m7745mC(C5102a.xGv)) {
                    C5102a.m7737c(c5101a);
                    AppMethodBeat.m2505o(114794);
                    return;
                } else if (C5102a.m7740hc(C5115h.xGE)) {
                    if (!C5102a.m7738eB(C5115h.xGE)) {
                        C5115h.drh().mo10503m(675, 18, 1);
                    }
                    C5115h.drh().mo10503m(675, 17, 1);
                    c5101a.dqW();
                } else {
                    C5115h.drh().mo10503m(675, 25, 1);
                    c5101a.dqV();
                    AppMethodBeat.m2505o(114794);
                    return;
                }
            } else if (!C5102a.dfx()) {
                C5115h.drh().mo10503m(675, 15, 1);
                c5101a.dqV();
            } else if (C5102a.m7740hc(C5115h.xGE)) {
                C5115h.drh().mo10503m(675, 16, 1);
                c5101a.cmC();
            } else {
                C5115h.drh().mo10503m(675, 26, 1);
                C5115h.drh().mo10503m(675, 15, 1);
                c5101a.dqV();
            }
            C5102a.xGv = 0;
            AppMethodBeat.m2505o(114794);
        }
    };

    /* renamed from: com.tencent.mm.splash.a$a */
    public interface C5101a {
        void cmC();

        void dqV();

        void dqW();
    }

    static /* synthetic */ boolean access$000() {
        AppMethodBeat.m2504i(114807);
        boolean dqS = C5102a.dqS();
        AppMethodBeat.m2505o(114807);
        return dqS;
    }

    /* renamed from: c */
    static /* synthetic */ void m7737c(C5101a c5101a) {
        AppMethodBeat.m2504i(114810);
        C5102a.m7736b(c5101a);
        AppMethodBeat.m2505o(114810);
    }

    static /* synthetic */ boolean dfx() {
        AppMethodBeat.m2504i(114811);
        boolean dqT = C5102a.dqT();
        AppMethodBeat.m2505o(114811);
        return dqT;
    }

    /* renamed from: eB */
    static /* synthetic */ boolean m7738eB(Context context) {
        AppMethodBeat.m2504i(114809);
        boolean hf = C5102a.m7743hf(context);
        AppMethodBeat.m2505o(114809);
        return hf;
    }

    /* renamed from: h */
    public static void m7739h(Application application) {
        AppMethodBeat.m2504i(114795);
        xGs = new File(application.getFilesDir(), "dexopt_service").getAbsolutePath();
        AppMethodBeat.m2505o(114795);
    }

    public static String dqR() {
        AppMethodBeat.m2504i(114796);
        if (xGs == null) {
            IllegalStateException illegalStateException = new IllegalStateException("data directory should not be null, give one.");
            AppMethodBeat.m2505o(114796);
            throw illegalStateException;
        }
        File file = new File(xGs);
        if (!(file.exists() || file.mkdirs())) {
            C5115h.m7780g("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
        }
        String str = xGs;
        AppMethodBeat.m2505o(114796);
        return str;
    }

    /* renamed from: hc */
    public static boolean m7740hc(Context context) {
        AppMethodBeat.m2504i(114797);
        C5115h.m7780g("WxSplash.DexOpt", "if need dexopt %s", Boolean.valueOf(C5115h.xGH.mo4569ba(context)));
        AppMethodBeat.m2505o(114797);
        return C5115h.xGH.mo4569ba(context);
    }

    /* renamed from: hd */
    public static void m7741hd(Context context) {
        AppMethodBeat.m2504i(114798);
        if (C5108g.f1294wY) {
            AppMethodBeat.m2505o(114798);
            return;
        }
        boolean aZ;
        C5115h.drh().mo10503m(675, 22, 1);
        try {
            aZ = C5115h.xGH.mo4568aZ(context);
        } catch (Throwable th) {
            C5115h.m7773a(th, "multidex install failed");
            aZ = false;
        }
        C5115h.m7780g("WxSplash.DexOpt", "install multidex result %s", Boolean.valueOf(aZ));
        if (!aZ) {
            C5115h.m7780g("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
            C5115h.bZk();
        }
        AppMethodBeat.m2505o(114798);
    }

    /* renamed from: he */
    public static void m7742he(Context context) {
        AppMethodBeat.m2504i(114799);
        C5115h.m7780g("WxSplash.DexOpt", "start dex opt service", new Object[0]);
        String aw = C5046bo.m7524aw(context, Process.myPid());
        aw.replace(':', '_');
        xGt = "DexOpt_Request_".concat(String.valueOf(aw));
        C5115h.drh().mo10503m(675, 14, 1);
        try {
            C5102a.anZ(xGt);
        } catch (Exception e) {
            Exception exception = e;
            if (VERSION.SDK_INT <= 19 && exception.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {
                try {
                    Field field = exception.getClass().getField("errno");
                    field.setAccessible(true);
                    if (((Integer) field.get(exception)).intValue() == OsConstants.ENOSPC) {
                        int i;
                        File file = new File(C5102a.dqR());
                        if (file.exists()) {
                            C5115h.m7780g("WxSplash.DexOpt", "check dexopt directory size %s.", Integer.valueOf(file.listFiles().length));
                            i = file.listFiles().length < Downloads.MIN_WAIT_FOR_NETWORK ? 1 : 0;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            C5115h.xGH.mo4570bb(context);
                        } else {
                            C5115h.m7780g("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
                            file = new File(C5102a.dqR());
                            if (file.exists()) {
                                C1173e.m2576u(file);
                            }
                        }
                    }
                } catch (Exception e2) {
                    C5115h.m7780g("WxSplash.DexOpt", "%s, %s", e2.getMessage());
                }
            }
            RuntimeException runtimeException = new RuntimeException(exception);
            AppMethodBeat.m2505o(114799);
            throw runtimeException;
        }
        context.startService(new Intent(context, DexOptService.class));
        AppMethodBeat.m2505o(114799);
    }

    private static synchronized void anZ(String str) {
        synchronized (C5102a.class) {
            AppMethodBeat.m2504i(114800);
            String dqR = C5102a.dqR();
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
            AppMethodBeat.m2505o(114800);
        }
    }

    /* renamed from: hf */
    private static boolean m7743hf(Context context) {
        AppMethodBeat.m2504i(114801);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(BaseClientBuilder.API_PRIORITY_OTHER);
            if (runningServices == null) {
                C5115h.m7780g("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
                AppMethodBeat.m2505o(114801);
                return false;
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if ("com.tencent.mm.splash.DexOptService".equals(runningServiceInfo.service.getClassName())) {
                    AppMethodBeat.m2505o(114801);
                    return true;
                }
            }
        }
        C5115h.m7780g("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
        AppMethodBeat.m2505o(114801);
        return false;
    }

    /* renamed from: hg */
    public static boolean m7744hg(Context context) {
        AppMethodBeat.m2504i(114802);
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        C5115h.m7780g("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
        while (C5102a.dqS()) {
            j++;
            Thread.sleep(100);
            if (j >= 5) {
                j = 0;
                if (System.currentTimeMillis() - currentTimeMillis > 180000) {
                    C5115h.m7780g("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
                    if (C5102a.m7740hc(context)) {
                        if (!C5102a.m7743hf(context)) {
                            C5115h.drh().mo10503m(675, 18, 1);
                        }
                        C5115h.drh().mo10503m(675, 17, 1);
                        AppMethodBeat.m2505o(114802);
                        return false;
                    }
                    C5115h.drh().mo10503m(675, 25, 1);
                    C5115h.drh().mo10503m(675, 15, 1);
                    AppMethodBeat.m2505o(114802);
                    return true;
                }
            }
        }
        if (!C5102a.dqT()) {
            C5115h.drh().mo10503m(675, 15, 1);
            AppMethodBeat.m2505o(114802);
            return true;
        } else if (C5102a.m7740hc(context)) {
            C5115h.drh().mo10503m(675, 16, 1);
            AppMethodBeat.m2505o(114802);
            return false;
        } else {
            C5115h.drh().mo10503m(675, 26, 1);
            C5115h.drh().mo10503m(675, 15, 1);
            AppMethodBeat.m2505o(114802);
            return true;
        }
    }

    /* renamed from: a */
    public static void m7735a(C5101a c5101a) {
        AppMethodBeat.m2504i(114803);
        C5102a.m7736b(c5101a);
        AppMethodBeat.m2505o(114803);
    }

    static {
        AppMethodBeat.m2504i(114812);
        AppMethodBeat.m2505o(114812);
    }

    /* renamed from: b */
    private static void m7736b(C5101a c5101a) {
        AppMethodBeat.m2504i(114804);
        if (xGv == 0) {
            xGv = System.currentTimeMillis();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = c5101a;
        xGw.sendMessageDelayed(obtain, 100);
        AppMethodBeat.m2505o(114804);
    }

    private static boolean dqS() {
        AppMethodBeat.m2504i(114805);
        if (xGu == null) {
            IllegalStateException illegalStateException = new IllegalStateException("tmp file field should not be null");
            AppMethodBeat.m2505o(114805);
            throw illegalStateException;
        }
        boolean exists = xGu.exists();
        AppMethodBeat.m2505o(114805);
        return exists;
    }

    private static boolean dqT() {
        AppMethodBeat.m2504i(114806);
        boolean exists = new File(C5102a.dqR() + "/DexOpt_Failed").exists();
        AppMethodBeat.m2505o(114806);
        return exists;
    }

    /* renamed from: mC */
    static /* synthetic */ boolean m7745mC(long j) {
        AppMethodBeat.m2504i(114808);
        if (System.currentTimeMillis() - j > 180000) {
            AppMethodBeat.m2505o(114808);
            return true;
        }
        AppMethodBeat.m2505o(114808);
        return false;
    }
}
