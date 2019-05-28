package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.nio.channels.FileLock;

class bv {
    private static bv a;
    private static FileLock e = null;
    private bw b;
    private boolean c;
    private boolean d;

    private bv() {
    }

    public static bv a() {
        AppMethodBeat.i(65041);
        if (a == null) {
            synchronized (bv.class) {
                try {
                    if (a == null) {
                        a = new bv();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65041);
                    }
                }
            }
        }
        bv bvVar = a;
        AppMethodBeat.o(65041);
        return bvVar;
    }

    public bw a(boolean z) {
        AppMethodBeat.i(65042);
        bw bwVar;
        if (z) {
            bwVar = this.b;
            AppMethodBeat.o(65042);
            return bwVar;
        }
        bwVar = c();
        AppMethodBeat.o(65042);
        return bwVar;
    }

    public FileLock a(Context context) {
        AppMethodBeat.i(65044);
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock;
        if (e != null) {
            fileLock = e;
            AppMethodBeat.o(65044);
            return fileLock;
        }
        synchronized (bv.class) {
            try {
                if (e != null) {
                    fileLock = k.e(context);
                    e = fileLock;
                    if (fileLock == null) {
                        TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock failed!");
                    } else {
                        TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock succeeded!");
                    }
                }
            } finally {
                AppMethodBeat.o(65044);
            }
        }
        fileLock = e;
        return fileLock;
    }

    public synchronized void a(Context context, am amVar) {
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            AppMethodBeat.i(65043);
            TbsLog.i("X5CoreEngine", "init #1");
            if (amVar != null) {
                amVar.a("x5_core_engine_init_sync", (byte) 2);
            }
            o a = o.a(true);
            a.a(context, false, false, amVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (amVar != null) {
                amVar.a("init_x5_core", (byte) 1);
            }
            bi a2 = a.a();
            if (!a.b() || a2 == null) {
                this.c = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            } else {
                if (!this.d) {
                    if (amVar != null) {
                        amVar.a = true;
                    }
                    this.b = new bw(a2.b());
                    try {
                        this.c = this.b.a();
                        if (!this.c) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.c = true;
                        obj = null;
                    } catch (Throwable th) {
                        obj = th;
                        this.c = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.c) {
                        CookieManager.getInstance().a(context, true, true);
                        CookieManager.getInstance().a();
                    }
                }
                obj = null;
            }
            TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.c);
            if (this.c) {
                TbsLog.i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + e);
                if (e == null) {
                    a(context);
                }
            } else {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (a.b() && a2 != null && obj == null) {
                    try {
                        DexLoader b = a2.b();
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
                        TbsCoreLoadStat.getInstance().a(context, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (a.b()) {
                    TbsCoreLoadStat.getInstance().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: ".concat(String.valueOf(obj))));
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 410, new Throwable("mCanUseX5=false, available false, reason: ".concat(String.valueOf(obj))));
                }
            }
            this.d = true;
            if (amVar != null) {
                amVar.a("init_x5_core", (byte) 2);
            }
            AppMethodBeat.o(65043);
        }
    }

    public boolean b() {
        return QbSdk.a ? false : this.c;
    }

    public bw c() {
        return QbSdk.a ? null : this.b;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean d() {
        return this.d;
    }
}
