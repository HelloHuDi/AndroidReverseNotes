package com.tencent.p177mm.app;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5011c;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.p679e.C5941b;

/* renamed from: com.tencent.mm.app.v */
public final class C1271v {
    ApplicationLike cfk = null;
    volatile boolean cfl = false;
    boolean cfm = false;
    private C5011c cfn = new C12721();
    private volatile boolean mInstalled = false;

    /* renamed from: com.tencent.mm.app.v$a */
    public static final class C1270a {
        public static final C1271v cfp = new C1271v();

        static {
            AppMethodBeat.m2504i(115037);
            AppMethodBeat.m2505o(115037);
        }
    }

    /* renamed from: com.tencent.mm.app.v$1 */
    class C12721 implements C5011c {
        C12721() {
        }

        /* renamed from: b */
        public final void mo4564b(String str, Throwable th) {
            AppMethodBeat.m2504i(115036);
            if (!C5941b.m9259c(C1271v.this.cfk)) {
                AppMethodBeat.m2505o(115036);
            } else if (!(th instanceof NoClassDefFoundError) && !(th instanceof VerifyError) && !(th instanceof IncompatibleClassChangeError) && !(th instanceof InternalError)) {
                AppMethodBeat.m2505o(115036);
            } else if (C1271v.this.cfm) {
                SharedPreferences sharedPreferences = C1271v.this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
                synchronized (C1271v.this) {
                    try {
                        if (!C1271v.this.cfl) {
                            int i = sharedPreferences.getInt("tinker_crash_count", 0);
                            if (i > 3) {
                                String str2 = C1760a.CLIENT_VERSION + "_clean_patch_count";
                                sharedPreferences.edit().putInt(str2, sharedPreferences.getInt(str2, 0) + 1).putInt("tinker_crash_count", 0).commit();
                                C5941b.m9261e(C1271v.this.cfk);
                                C4990ab.m7420w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] clean patch by ensurance logic!!");
                                C4990ab.dou();
                            } else {
                                sharedPreferences.edit().putInt("tinker_crash_count", i + 1).commit();
                            }
                        }
                    } finally {
                        AppMethodBeat.m2505o(115036);
                    }
                }
            } else {
                AppMethodBeat.m2505o(115036);
            }
        }
    }

    public C1271v() {
        AppMethodBeat.m2504i(115038);
        AppMethodBeat.m2505o(115038);
    }

    /* renamed from: b */
    public final synchronized void mo4563b(ApplicationLike applicationLike) {
        AppMethodBeat.m2504i(115039);
        if (this.mInstalled) {
            AppMethodBeat.m2505o(115039);
        } else {
            this.cfk = applicationLike;
            C5013ao.m7457a(this.cfn);
            this.cfm = this.cfk.getApplication().getPackageName().equals(this.cfk.getApplication().getApplicationInfo().processName);
            SharedPreferences sharedPreferences = this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
            String string = sharedPreferences.getString("tinker_last_clientversion", null);
            if (string == null) {
                sharedPreferences.edit().putString("tinker_last_clientversion", C1760a.CLIENT_VERSION).commit();
            } else if (!C1760a.CLIENT_VERSION.equals(string)) {
                sharedPreferences.edit().remove(string + "_clean_patch_count").putString("tinker_last_clientversion", C1760a.CLIENT_VERSION).commit();
            }
            this.mInstalled = true;
            AppMethodBeat.m2505o(115039);
        }
    }

    /* renamed from: BA */
    public final synchronized void mo4559BA() {
        this.cfl = false;
    }

    /* renamed from: BB */
    public final synchronized void mo4560BB() {
        this.cfl = true;
    }

    /* renamed from: BC */
    public final synchronized boolean mo4561BC() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(115040);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(C1760a.CLIENT_VERSION + "_clean_patch_count", 0) <= 3) {
                z = true;
            }
            if (z) {
                C4990ab.m7416i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we can apply patch.");
            } else {
                C4990ab.m7420w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we CANNOT apply patch !!");
            }
            AppMethodBeat.m2505o(115040);
        }
        return z;
    }

    /* renamed from: BD */
    private synchronized boolean m2729BD() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(115041);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(C1760a.CLIENT_VERSION + "_clean_patch_count", 0) <= 0) {
                z = false;
            }
            if (z) {
                C4990ab.m7421w("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: we have cleaned patch by %s times !!", Integer.valueOf(r2));
            } else {
                C4990ab.m7416i("MicroMsg.TinkerEnsuranceOnFault", "[tomys] ensurance logic says: clean patch logic is not being triggered.");
            }
            AppMethodBeat.m2505o(115041);
        }
        return z;
    }

    /* renamed from: BE */
    private synchronized boolean m2730BE() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(115042);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(C1760a.CLIENT_VERSION + "_clean_patch_reported", 0) != 0) {
                z = true;
                AppMethodBeat.m2505o(115042);
            } else {
                AppMethodBeat.m2505o(115042);
            }
        }
        return z;
    }

    /* renamed from: BF */
    private synchronized boolean m2731BF() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(115043);
            if (this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4).getInt(C1760a.CLIENT_VERSION + "_block_apply_patch_reported", 0) != 0) {
                z = true;
                AppMethodBeat.m2505o(115043);
            } else {
                AppMethodBeat.m2505o(115043);
            }
        }
        return z;
    }

    /* renamed from: BG */
    public final synchronized void mo4562BG() {
        AppMethodBeat.m2504i(115044);
        SharedPreferences sharedPreferences = this.cfk.getApplication().getSharedPreferences("tinker_ensurance_info", 4);
        if (!m2730BE() && m2729BD()) {
            C7053e.pXa.mo8378a(338, 231, 1, false);
            sharedPreferences.edit().putInt(C1760a.CLIENT_VERSION + "_clean_patch_reported", 1).apply();
        }
        if (!(m2731BF() || mo4561BC())) {
            C7053e.pXa.mo8378a(338, 232, 1, false);
            sharedPreferences.edit().putInt(C1760a.CLIENT_VERSION + "_block_apply_patch_reported", 1).apply();
        }
        AppMethodBeat.m2505o(115044);
    }
}
