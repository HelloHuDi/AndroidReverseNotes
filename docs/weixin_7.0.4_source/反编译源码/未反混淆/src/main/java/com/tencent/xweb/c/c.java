package com.tencent.xweb.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.m;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c {
    public static HashMap<String, c> APq = new HashMap();
    static String APr = "";
    SharedPreferences APh;
    private String APi;
    private String APj;
    private String APk;
    private long APl;
    private long APm;
    public long APn;
    private String APo;
    boolean APp = false;

    private c(String str, d dVar) {
        AppMethodBeat.i(3971);
        this.APh = d(str, dVar);
        this.APi = "INIT_START_TIME".concat(String.valueOf(str));
        this.APj = "INIT_END_TIME".concat(String.valueOf(str));
        this.APk = "INIT_TRY_COUNT".concat(String.valueOf(str));
        this.APo = str;
        if (this.APh == null) {
            AppMethodBeat.o(3971);
            return;
        }
        this.APl = this.APh.getLong(this.APi, 0);
        this.APm = this.APh.getLong(this.APj, 0);
        this.APn = this.APh.getLong(this.APk, 0);
        AppMethodBeat.o(3971);
    }

    static {
        AppMethodBeat.i(3980);
        AppMethodBeat.o(3980);
    }

    public static synchronized c b(String str, d dVar) {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(3972);
            String c = c(str, dVar);
            cVar = (c) APq.get(c);
            if (cVar == null) {
                cVar = new c(str, dVar);
                APq.put(c, cVar);
            }
            AppMethodBeat.o(3972);
        }
        return cVar;
    }

    public final synchronized void dUx() {
        AppMethodBeat.i(3973);
        if (this.APp) {
            AppMethodBeat.o(3973);
        } else {
            this.APp = true;
            if (this.APh == null) {
                AppMethodBeat.o(3973);
            } else {
                Editor edit = this.APh.edit();
                edit.putLong(this.APk, this.APn + 1);
                long time = new Date().getTime();
                if (nH(time)) {
                    edit.commit();
                    AppMethodBeat.o(3973);
                } else {
                    edit.putLong(this.APi, time);
                    edit.commit();
                    AppMethodBeat.o(3973);
                }
            }
        }
    }

    public final synchronized void dUy() {
        AppMethodBeat.i(3974);
        if (this.APh == null) {
            AppMethodBeat.o(3974);
        } else {
            Editor edit = this.APh.edit();
            edit.putLong(this.APj, new Date().getTime());
            edit.putLong(this.APk, 0);
            edit.commit();
            this.APh = null;
            AppMethodBeat.o(3974);
        }
    }

    public static synchronized boolean c(d dVar) {
        boolean z = false;
        synchronized (c.class) {
            AppMethodBeat.i(3975);
            if (m.dTZ().AMz) {
                AppMethodBeat.o(3975);
            } else if (b("LOAD_CORE", dVar).dUz()) {
                AppMethodBeat.o(3975);
                z = true;
            } else if (new c("CREATE_WEBVIEW", dVar).dUz()) {
                AppMethodBeat.o(3975);
                z = true;
            } else {
                AppMethodBeat.o(3975);
            }
        }
        return z;
    }

    private synchronized boolean nH(long j) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(3976);
            if (0 == this.APl) {
                AppMethodBeat.o(3976);
            } else if (this.APm - this.APl >= 0 || Math.abs(j - this.APl) > 10800000) {
                AppMethodBeat.o(3976);
            } else if (this.APm < this.APl) {
                z = true;
                AppMethodBeat.o(3976);
            } else {
                AppMethodBeat.o(3976);
            }
        }
        return z;
    }

    private synchronized boolean dUz() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(3977);
            if (this.APh == null) {
                AppMethodBeat.o(3977);
            } else {
                long time = new Date().getTime();
                if (!nH(time)) {
                    AppMethodBeat.o(3977);
                } else if (this.APn > 4) {
                    XWalkEnvironment.addXWalkInitializeLog("Scene " + this.APo + " crashed " + ((time - this.APl) / 60000) + " minutes ago, try count = " + this.APn);
                    z = true;
                    AppMethodBeat.o(3977);
                } else {
                    AppMethodBeat.o(3977);
                }
            }
        }
        return z;
    }

    private static String c(String str, d dVar) {
        AppMethodBeat.i(3978);
        String str2 = "INIT_SP_TAG_" + dVar.toString() + str;
        AppMethodBeat.o(3978);
        return str2;
    }

    private static synchronized SharedPreferences d(String str, d dVar) {
        SharedPreferences mMKVSharedTransportOld;
        synchronized (c.class) {
            AppMethodBeat.i(3979);
            if (dVar == d.WV_KIND_CW || dVar == d.WV_KIND_SYS) {
                String c = c(str, dVar);
                APr = c;
                mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld(c);
                AppMethodBeat.o(3979);
            } else {
                mMKVSharedTransportOld = null;
                AppMethodBeat.o(3979);
            }
        }
        return mMKVSharedTransportOld;
    }
}
