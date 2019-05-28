package com.tencent.mm.app;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.c;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.e.b;

public final class v {
    ApplicationLike cfk = null;
    volatile boolean cfl = false;
    boolean cfm = false;
    private c cfn = new c() {
        public final void b(String str, Throwable th) {
            AppMethodBeat.i(115036);
            if (!b.c(v.this.cfk)) {
                AppMethodBeat.o(115036);
            } else if (!(th instanceof NoClassDefFoundError) && !(th instanceof VerifyError) && !(th instanceof IncompatibleClassChangeError) && !(th instanceof InternalError)) {
                AppMethodBeat.o(115036);
            } else if (v.this.cfm) {
                SharedPreferences sharedPreferences = v.this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
                synchronized (v.this) {
                    try {
                        if (!v.this.cfl) {
                            int i = sharedPreferences.getInt("tinker_crash_count", 0);
                            if (i > 3) {
                                String str2 = com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_count";
                                sharedPreferences.edit().putInt(str2, sharedPreferences.getInt(str2, 0) + 1).putInt("tinker_crash_count", 0).commit();
                                b.e(v.this.cfk);
                                ab.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] clean patch by ensurance logic!!");
                                ab.dou();
                            } else {
                                sharedPreferences.edit().putInt("tinker_crash_count", i + 1).commit();
                            }
                        }
                    } finally {
                        AppMethodBeat.o(115036);
                    }
                }
            } else {
                AppMethodBeat.o(115036);
            }
        }
    };
    private volatile boolean mInstalled = false;

    public static final class a {
        public static final v cfp = new v();

        static {
            AppMethodBeat.i(115037);
            AppMethodBeat.o(115037);
        }
    }

    public v() {
        AppMethodBeat.i(115038);
        AppMethodBeat.o(115038);
    }

    public final synchronized void b(ApplicationLike applicationLike) {
        AppMethodBeat.i(115039);
        if (this.mInstalled) {
            AppMethodBeat.o(115039);
        } else {
            this.cfk = applicationLike;
            ao.a(this.cfn);
            this.cfm = this.cfk.getApplication().getPackageName().equals(this.cfk.getApplication().getApplicationInfo().processName);
            SharedPreferences sharedPreferences = this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
            String string = sharedPreferences.getString("tinker_last_clientversion", null);
            if (string == null) {
                sharedPreferences.edit().putString("tinker_last_clientversion", com.tencent.mm.loader.j.a.CLIENT_VERSION).commit();
            } else if (!com.tencent.mm.loader.j.a.CLIENT_VERSION.equals(string)) {
                sharedPreferences.edit().remove(string + "_clean_patch_count").putString("tinker_last_clientversion", com.tencent.mm.loader.j.a.CLIENT_VERSION).commit();
            }
            this.mInstalled = true;
            AppMethodBeat.o(115039);
        }
    }

    public final synchronized void BA() {
        this.cfl = false;
    }

    public final synchronized void BB() {
        this.cfl = true;
    }

    public final synchronized boolean BC() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(115040);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_count", 0) <= 3) {
                z = true;
            }
            if (z) {
                ab.i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we can apply patch.");
            } else {
                ab.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we CANNOT apply patch !!");
            }
            AppMethodBeat.o(115040);
        }
        return z;
    }

    private synchronized boolean BD() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(115041);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_count", 0) <= 0) {
                z = false;
            }
            if (z) {
                ab.w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we have cleaned patch by %s times !!", Integer.valueOf(r2));
            } else {
                ab.i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: clean patch logic is not being triggered.");
            }
            AppMethodBeat.o(115041);
        }
        return z;
    }

    private synchronized boolean BE() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(115042);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_reported", 0) != 0) {
                z = true;
                AppMethodBeat.o(115042);
            } else {
                AppMethodBeat.o(115042);
            }
        }
        return z;
    }

    private synchronized boolean BF() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(115043);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_block_apply_patch_reported", 0) != 0) {
                z = true;
                AppMethodBeat.o(115043);
            } else {
                AppMethodBeat.o(115043);
            }
        }
        return z;
    }

    public final synchronized void BG() {
        AppMethodBeat.i(115044);
        SharedPreferences sharedPreferences = this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
        if (!BE() && BD()) {
            e.pXa.a(338, 231, 1, false);
            sharedPreferences.edit().putInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_clean_patch_reported", 1).apply();
        }
        if (!(BF() || BC())) {
            e.pXa.a(338, 232, 1, false);
            sharedPreferences.edit().putInt(com.tencent.mm.loader.j.a.CLIENT_VERSION + "_block_apply_patch_reported", 1).apply();
        }
        AppMethodBeat.o(115044);
    }
}
