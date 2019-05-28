package com.tencent.xweb.p1115c;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.util.C24532f;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.c.j */
public final class C44579j {
    static C44579j APz = null;
    int APs = 0;
    int APt = 0;
    long APu = 0;
    ArrayList<Long> APv = new ArrayList();
    C44570d APw;
    long APx = 0;
    boolean APy = false;

    public static synchronized C44579j dUB() {
        C44579j c44579j;
        synchronized (C44579j.class) {
            AppMethodBeat.m2504i(3981);
            if (APz == null) {
                C44570d curWebType = WebView.getCurWebType();
                WebView.getCurStrModule();
                APz = new C44579j(curWebType);
            }
            c44579j = APz;
            AppMethodBeat.m2505o(3981);
        }
        return c44579j;
    }

    /* renamed from: d */
    public static synchronized void m80965d(C44570d c44570d) {
        synchronized (C44579j.class) {
            AppMethodBeat.m2504i(3982);
            APz = new C44579j(c44570d);
            AppMethodBeat.m2505o(3982);
        }
    }

    private C44579j(C44570d c44570d) {
        boolean z = false;
        AppMethodBeat.m2504i(3983);
        this.APw = c44570d;
        if (this.APw == C44570d.WV_KIND_SYS || !("tools".equals(WebView.getCurStrModule()) || "toolsmp".equals(WebView.getCurStrModule()))) {
            this.APy = false;
        } else {
            String iG = C44572a.m80959iG("enable_err_watchdog", "tools");
            if (iG != null && iG.trim().toLowerCase().equals("true")) {
                z = true;
            }
            this.APy = z;
            this.APx = C44579j.m80966e(this.APw).getLong("SP_KEY_NEED_SWITCH_TIME", 0);
            if (Math.abs(System.currentTimeMillis() - this.APx) < 43200000) {
                this.APs = 3;
                AppMethodBeat.m2505o(3983);
                return;
            }
        }
        AppMethodBeat.m2505o(3983);
    }

    public final synchronized void dUx() {
        AppMethodBeat.m2504i(3984);
        this.APu = System.currentTimeMillis();
        AppMethodBeat.m2505o(3984);
    }

    public final synchronized void dUC() {
        AppMethodBeat.m2504i(3985);
        if (this.APy) {
            if (NetworkUtil.isNetworkAvailable()) {
                this.APv.add(Long.valueOf(System.currentTimeMillis()));
            }
            if (this.APv.size() >= 3) {
                if (Math.abs(System.currentTimeMillis() - ((Long) this.APv.get(this.APv.size() - 3)).longValue()) < 120000) {
                    this.APs = 1;
                    if (this.APw == C44570d.WV_KIND_CW) {
                        C24532f.m38181nI(220);
                        AppMethodBeat.m2505o(3985);
                    } else if (this.APw == C44570d.WV_KIND_X5) {
                        C24532f.m38181nI(226);
                    }
                }
            }
            AppMethodBeat.m2505o(3985);
        } else {
            AppMethodBeat.m2505o(3985);
        }
    }

    private synchronized int dUD() {
        return this.APs;
    }

    public final synchronized boolean dUE() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(3986);
            if (dUD() == 3 || dUD() == 2) {
                if (this.APw == C44570d.WV_KIND_CW) {
                    C24532f.m38181nI(222);
                } else if (this.APw == C44570d.WV_KIND_X5) {
                    C24532f.m38181nI(228);
                }
            }
            if (dUD() == 1 || dUD() == 3 || dUD() == 2) {
                AppMethodBeat.m2505o(3986);
            } else {
                z = false;
                AppMethodBeat.m2505o(3986);
            }
        }
        return z;
    }

    public final synchronized boolean dUF() {
        boolean z;
        AppMethodBeat.m2504i(3987);
        if (dUD() == 2) {
            z = true;
            AppMethodBeat.m2505o(3987);
        } else {
            z = false;
            AppMethodBeat.m2505o(3987);
        }
        return z;
    }

    public final synchronized boolean dUG() {
        boolean z;
        AppMethodBeat.m2504i(3988);
        if (dUD() == 3) {
            z = true;
            AppMethodBeat.m2505o(3988);
        } else {
            z = false;
            AppMethodBeat.m2505o(3988);
        }
        return z;
    }

    public final synchronized void dUy() {
        AppMethodBeat.m2504i(3989);
        if (this.APy) {
            this.APu = 0;
            this.APv.clear();
            this.APx = 0;
            this.APs = 0;
            AppMethodBeat.m2505o(3989);
        } else {
            AppMethodBeat.m2505o(3989);
        }
    }

    public final synchronized void dUH() {
        AppMethodBeat.m2504i(3990);
        if (!this.APy) {
            AppMethodBeat.m2505o(3990);
        } else if (1 != this.APs) {
            AppMethodBeat.m2505o(3990);
        } else {
            if (this.APv.size() > 0) {
                if (Math.abs(System.currentTimeMillis() - ((Long) this.APv.get(this.APv.size() - 1)).longValue()) < 60000) {
                    if (this.APw == C44570d.WV_KIND_CW) {
                        C24532f.m38181nI(221);
                    } else if (this.APw == C44570d.WV_KIND_X5) {
                        C24532f.m38181nI(227);
                    }
                    this.APu = 0;
                    this.APv.clear();
                    this.APs = 2;
                    this.APx = System.currentTimeMillis();
                    C44579j.m80966e(this.APw).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.APx).commit();
                    AppMethodBeat.m2505o(3990);
                }
            }
            this.APs = 0;
            AppMethodBeat.m2505o(3990);
        }
    }

    public final synchronized void dUI() {
        AppMethodBeat.m2504i(3991);
        if (!this.APy) {
            AppMethodBeat.m2505o(3991);
        } else if (1 != this.APs) {
            AppMethodBeat.m2505o(3991);
        } else {
            this.APu = 0;
            this.APv.clear();
            this.APs = 0;
            AppMethodBeat.m2505o(3991);
        }
    }

    /* renamed from: e */
    private static synchronized SharedPreferences m80966e(C44570d c44570d) {
        SharedPreferences processSafePreferences;
        synchronized (C44579j.class) {
            AppMethodBeat.m2504i(3992);
            processSafePreferences = XWalkEnvironment.getProcessSafePreferences(XWalkEnvironment.getProcessName() + "_LOAD_URL_" + c44570d, 4);
            AppMethodBeat.m2505o(3992);
        }
        return processSafePreferences;
    }
}
