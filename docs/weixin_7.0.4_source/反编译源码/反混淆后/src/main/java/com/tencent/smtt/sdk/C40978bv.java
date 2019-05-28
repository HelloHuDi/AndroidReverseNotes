package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* renamed from: com.tencent.smtt.sdk.bv */
class C40978bv {
    /* renamed from: a */
    private static C40978bv f16297a;
    /* renamed from: e */
    private static FileLock f16298e = null;
    /* renamed from: b */
    private C36438bw f16299b;
    /* renamed from: c */
    private boolean f16300c;
    /* renamed from: d */
    private boolean f16301d;

    private C40978bv() {
    }

    /* renamed from: a */
    public static C40978bv m71073a() {
        AppMethodBeat.m2504i(65041);
        if (f16297a == null) {
            synchronized (C40978bv.class) {
                try {
                    if (f16297a == null) {
                        f16297a = new C40978bv();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(65041);
                    }
                }
            }
        }
        C40978bv c40978bv = f16297a;
        AppMethodBeat.m2505o(65041);
        return c40978bv;
    }

    /* renamed from: a */
    public C36438bw mo64918a(boolean z) {
        AppMethodBeat.m2504i(65042);
        C36438bw c36438bw;
        if (z) {
            c36438bw = this.f16299b;
            AppMethodBeat.m2505o(65042);
            return c36438bw;
        }
        c36438bw = mo64922c();
        AppMethodBeat.m2505o(65042);
        return c36438bw;
    }

    /* renamed from: a */
    public FileLock mo64919a(Context context) {
        AppMethodBeat.m2504i(65044);
        TbsLog.m80434i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock;
        if (f16298e != null) {
            fileLock = f16298e;
            AppMethodBeat.m2505o(65044);
            return fileLock;
        }
        synchronized (C40978bv.class) {
            try {
                if (f16298e != null) {
                    fileLock = C30950k.m49573e(context);
                    f16298e = fileLock;
                    if (fileLock == null) {
                        TbsLog.m80434i("X5CoreEngine", "init -- sTbsCoreLoadFileLock failed!");
                    } else {
                        TbsLog.m80434i("X5CoreEngine", "init -- sTbsCoreLoadFileLock succeeded!");
                    }
                }
            } finally {
                AppMethodBeat.m2505o(65044);
            }
        }
        fileLock = f16298e;
        return fileLock;
    }

    /* renamed from: a */
    public synchronized void mo64920a(Context context, C30943am c30943am) {
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            AppMethodBeat.m2504i(65043);
            TbsLog.m80434i("X5CoreEngine", "init #1");
            if (c30943am != null) {
                c30943am.mo50045a("x5_core_engine_init_sync", (byte) 2);
            }
            C5818o a = C5818o.m8863a(true);
            a.mo12196a(context, false, false, c30943am);
            StringBuilder stringBuilder = new StringBuilder();
            if (c30943am != null) {
                c30943am.mo50045a("init_x5_core", (byte) 1);
            }
            C30947bi a2 = a.mo12195a();
            if (!a.mo12198b() || a2 == null) {
                this.f16300c = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            } else {
                if (!this.f16301d) {
                    if (c30943am != null) {
                        c30943am.f13899a = true;
                    }
                    this.f16299b = new C36438bw(a2.mo50067b());
                    try {
                        this.f16300c = this.f16299b.mo57568a();
                        if (!this.f16300c) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.f16300c = true;
                        obj = null;
                    } catch (Throwable th) {
                        obj = th;
                        this.f16300c = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.f16300c) {
                        CookieManager.getInstance().mo70588a(context, true, true);
                        CookieManager.getInstance().mo70587a();
                    }
                }
                obj = null;
            }
            TbsLog.m80434i("X5CoreEngine", "init  mCanUseX5 is " + this.f16300c);
            if (this.f16300c) {
                TbsLog.m80434i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + f16298e);
                if (f16298e == null) {
                    mo64919a(context);
                }
            } else {
                TbsLog.m80432e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (a.mo12198b() && a2 != null && obj == null) {
                    try {
                        DexLoader b = a2.mo50067b();
                        if (b != null) {
                            obj2 = b.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj2 instanceof Throwable) {
                            Throwable th2 = (Throwable) obj2;
                            stringBuilder.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + th2);
                        }
                        if (obj2 instanceof String) {
                            stringBuilder.append("failure detail:".concat(String.valueOf(obj2)));
                        }
                    } catch (Throwable th3) {
                    }
                    if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                        TbsCoreLoadStat.getInstance().mo64872a(context, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        TbsCoreLoadStat.getInstance().mo64872a(context, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (a.mo12198b()) {
                    TbsCoreLoadStat.getInstance().mo64872a(context, 409, new Throwable("mCanUseX5=false, available true, reason: ".concat(String.valueOf(obj))));
                } else {
                    TbsCoreLoadStat.getInstance().mo64872a(context, 410, new Throwable("mCanUseX5=false, available false, reason: ".concat(String.valueOf(obj))));
                }
            }
            this.f16301d = true;
            if (c30943am != null) {
                c30943am.mo50045a("init_x5_core", (byte) 2);
            }
            AppMethodBeat.m2505o(65043);
        }
    }

    /* renamed from: b */
    public boolean mo64921b() {
        return QbSdk.f16239a ? false : this.f16300c;
    }

    /* renamed from: c */
    public C36438bw mo64922c() {
        return QbSdk.f16239a ? null : this.f16299b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: d */
    public boolean mo64923d() {
        return this.f16301d;
    }
}
