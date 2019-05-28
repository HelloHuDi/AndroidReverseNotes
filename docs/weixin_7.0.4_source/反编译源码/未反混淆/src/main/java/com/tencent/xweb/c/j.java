package com.tencent.xweb.c;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.a;
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

public final class j {
    static j APz = null;
    int APs = 0;
    int APt = 0;
    long APu = 0;
    ArrayList<Long> APv = new ArrayList();
    d APw;
    long APx = 0;
    boolean APy = false;

    public static synchronized j dUB() {
        j jVar;
        synchronized (j.class) {
            AppMethodBeat.i(3981);
            if (APz == null) {
                d curWebType = WebView.getCurWebType();
                WebView.getCurStrModule();
                APz = new j(curWebType);
            }
            jVar = APz;
            AppMethodBeat.o(3981);
        }
        return jVar;
    }

    public static synchronized void d(d dVar) {
        synchronized (j.class) {
            AppMethodBeat.i(3982);
            APz = new j(dVar);
            AppMethodBeat.o(3982);
        }
    }

    private j(d dVar) {
        boolean z = false;
        AppMethodBeat.i(3983);
        this.APw = dVar;
        if (this.APw == d.WV_KIND_SYS || !("tools".equals(WebView.getCurStrModule()) || "toolsmp".equals(WebView.getCurStrModule()))) {
            this.APy = false;
        } else {
            String iG = a.iG("enable_err_watchdog", "tools");
            if (iG != null && iG.trim().toLowerCase().equals("true")) {
                z = true;
            }
            this.APy = z;
            this.APx = e(this.APw).getLong("SP_KEY_NEED_SWITCH_TIME", 0);
            if (Math.abs(System.currentTimeMillis() - this.APx) < 43200000) {
                this.APs = 3;
                AppMethodBeat.o(3983);
                return;
            }
        }
        AppMethodBeat.o(3983);
    }

    public final synchronized void dUx() {
        AppMethodBeat.i(3984);
        this.APu = System.currentTimeMillis();
        AppMethodBeat.o(3984);
    }

    public final synchronized void dUC() {
        AppMethodBeat.i(3985);
        if (this.APy) {
            if (NetworkUtil.isNetworkAvailable()) {
                this.APv.add(Long.valueOf(System.currentTimeMillis()));
            }
            if (this.APv.size() >= 3) {
                if (Math.abs(System.currentTimeMillis() - ((Long) this.APv.get(this.APv.size() - 3)).longValue()) < 120000) {
                    this.APs = 1;
                    if (this.APw == d.WV_KIND_CW) {
                        f.nI(220);
                        AppMethodBeat.o(3985);
                    } else if (this.APw == d.WV_KIND_X5) {
                        f.nI(226);
                    }
                }
            }
            AppMethodBeat.o(3985);
        } else {
            AppMethodBeat.o(3985);
        }
    }

    private synchronized int dUD() {
        return this.APs;
    }

    public final synchronized boolean dUE() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(3986);
            if (dUD() == 3 || dUD() == 2) {
                if (this.APw == d.WV_KIND_CW) {
                    f.nI(222);
                } else if (this.APw == d.WV_KIND_X5) {
                    f.nI(228);
                }
            }
            if (dUD() == 1 || dUD() == 3 || dUD() == 2) {
                AppMethodBeat.o(3986);
            } else {
                z = false;
                AppMethodBeat.o(3986);
            }
        }
        return z;
    }

    public final synchronized boolean dUF() {
        boolean z;
        AppMethodBeat.i(3987);
        if (dUD() == 2) {
            z = true;
            AppMethodBeat.o(3987);
        } else {
            z = false;
            AppMethodBeat.o(3987);
        }
        return z;
    }

    public final synchronized boolean dUG() {
        boolean z;
        AppMethodBeat.i(3988);
        if (dUD() == 3) {
            z = true;
            AppMethodBeat.o(3988);
        } else {
            z = false;
            AppMethodBeat.o(3988);
        }
        return z;
    }

    public final synchronized void dUy() {
        AppMethodBeat.i(3989);
        if (this.APy) {
            this.APu = 0;
            this.APv.clear();
            this.APx = 0;
            this.APs = 0;
            AppMethodBeat.o(3989);
        } else {
            AppMethodBeat.o(3989);
        }
    }

    public final synchronized void dUH() {
        AppMethodBeat.i(3990);
        if (!this.APy) {
            AppMethodBeat.o(3990);
        } else if (1 != this.APs) {
            AppMethodBeat.o(3990);
        } else {
            if (this.APv.size() > 0) {
                if (Math.abs(System.currentTimeMillis() - ((Long) this.APv.get(this.APv.size() - 1)).longValue()) < 60000) {
                    if (this.APw == d.WV_KIND_CW) {
                        f.nI(221);
                    } else if (this.APw == d.WV_KIND_X5) {
                        f.nI(227);
                    }
                    this.APu = 0;
                    this.APv.clear();
                    this.APs = 2;
                    this.APx = System.currentTimeMillis();
                    e(this.APw).edit().putLong("SP_KEY_NEED_SWITCH_TIME", this.APx).commit();
                    AppMethodBeat.o(3990);
                }
            }
            this.APs = 0;
            AppMethodBeat.o(3990);
        }
    }

    public final synchronized void dUI() {
        AppMethodBeat.i(3991);
        if (!this.APy) {
            AppMethodBeat.o(3991);
        } else if (1 != this.APs) {
            AppMethodBeat.o(3991);
        } else {
            this.APu = 0;
            this.APv.clear();
            this.APs = 0;
            AppMethodBeat.o(3991);
        }
    }

    private static synchronized SharedPreferences e(d dVar) {
        SharedPreferences processSafePreferences;
        synchronized (j.class) {
            AppMethodBeat.i(3992);
            processSafePreferences = XWalkEnvironment.getProcessSafePreferences(XWalkEnvironment.getProcessName() + "_LOAD_URL_" + dVar, 4);
            AppMethodBeat.o(3992);
        }
        return processSafePreferences;
    }
}
