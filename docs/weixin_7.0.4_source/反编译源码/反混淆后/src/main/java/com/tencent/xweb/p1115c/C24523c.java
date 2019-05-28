package com.tencent.xweb.p1115c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C31146m;
import com.tencent.xweb.WebView.C44570d;
import java.util.Date;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.c.c */
public final class C24523c {
    public static HashMap<String, C24523c> APq = new HashMap();
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

    private C24523c(String str, C44570d c44570d) {
        AppMethodBeat.m2504i(3971);
        this.APh = C24523c.m38152d(str, c44570d);
        this.APi = "INIT_START_TIME".concat(String.valueOf(str));
        this.APj = "INIT_END_TIME".concat(String.valueOf(str));
        this.APk = "INIT_TRY_COUNT".concat(String.valueOf(str));
        this.APo = str;
        if (this.APh == null) {
            AppMethodBeat.m2505o(3971);
            return;
        }
        this.APl = this.APh.getLong(this.APi, 0);
        this.APm = this.APh.getLong(this.APj, 0);
        this.APn = this.APh.getLong(this.APk, 0);
        AppMethodBeat.m2505o(3971);
    }

    static {
        AppMethodBeat.m2504i(3980);
        AppMethodBeat.m2505o(3980);
    }

    /* renamed from: b */
    public static synchronized C24523c m38149b(String str, C44570d c44570d) {
        C24523c c24523c;
        synchronized (C24523c.class) {
            AppMethodBeat.m2504i(3972);
            String c = C24523c.m38150c(str, c44570d);
            c24523c = (C24523c) APq.get(c);
            if (c24523c == null) {
                c24523c = new C24523c(str, c44570d);
                APq.put(c, c24523c);
            }
            AppMethodBeat.m2505o(3972);
        }
        return c24523c;
    }

    public final synchronized void dUx() {
        AppMethodBeat.m2504i(3973);
        if (this.APp) {
            AppMethodBeat.m2505o(3973);
        } else {
            this.APp = true;
            if (this.APh == null) {
                AppMethodBeat.m2505o(3973);
            } else {
                Editor edit = this.APh.edit();
                edit.putLong(this.APk, this.APn + 1);
                long time = new Date().getTime();
                if (m38153nH(time)) {
                    edit.commit();
                    AppMethodBeat.m2505o(3973);
                } else {
                    edit.putLong(this.APi, time);
                    edit.commit();
                    AppMethodBeat.m2505o(3973);
                }
            }
        }
    }

    public final synchronized void dUy() {
        AppMethodBeat.m2504i(3974);
        if (this.APh == null) {
            AppMethodBeat.m2505o(3974);
        } else {
            Editor edit = this.APh.edit();
            edit.putLong(this.APj, new Date().getTime());
            edit.putLong(this.APk, 0);
            edit.commit();
            this.APh = null;
            AppMethodBeat.m2505o(3974);
        }
    }

    /* renamed from: c */
    public static synchronized boolean m38151c(C44570d c44570d) {
        boolean z = false;
        synchronized (C24523c.class) {
            AppMethodBeat.m2504i(3975);
            if (C31146m.dTZ().AMz) {
                AppMethodBeat.m2505o(3975);
            } else if (C24523c.m38149b("LOAD_CORE", c44570d).dUz()) {
                AppMethodBeat.m2505o(3975);
                z = true;
            } else if (new C24523c("CREATE_WEBVIEW", c44570d).dUz()) {
                AppMethodBeat.m2505o(3975);
                z = true;
            } else {
                AppMethodBeat.m2505o(3975);
            }
        }
        return z;
    }

    /* renamed from: nH */
    private synchronized boolean m38153nH(long j) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(3976);
            if (0 == this.APl) {
                AppMethodBeat.m2505o(3976);
            } else if (this.APm - this.APl >= 0 || Math.abs(j - this.APl) > 10800000) {
                AppMethodBeat.m2505o(3976);
            } else if (this.APm < this.APl) {
                z = true;
                AppMethodBeat.m2505o(3976);
            } else {
                AppMethodBeat.m2505o(3976);
            }
        }
        return z;
    }

    private synchronized boolean dUz() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(3977);
            if (this.APh == null) {
                AppMethodBeat.m2505o(3977);
            } else {
                long time = new Date().getTime();
                if (!m38153nH(time)) {
                    AppMethodBeat.m2505o(3977);
                } else if (this.APn > 4) {
                    XWalkEnvironment.addXWalkInitializeLog("Scene " + this.APo + " crashed " + ((time - this.APl) / 60000) + " minutes ago, try count = " + this.APn);
                    z = true;
                    AppMethodBeat.m2505o(3977);
                } else {
                    AppMethodBeat.m2505o(3977);
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    private static String m38150c(String str, C44570d c44570d) {
        AppMethodBeat.m2504i(3978);
        String str2 = "INIT_SP_TAG_" + c44570d.toString() + str;
        AppMethodBeat.m2505o(3978);
        return str2;
    }

    /* renamed from: d */
    private static synchronized SharedPreferences m38152d(String str, C44570d c44570d) {
        SharedPreferences mMKVSharedTransportOld;
        synchronized (C24523c.class) {
            AppMethodBeat.m2504i(3979);
            if (c44570d == C44570d.WV_KIND_CW || c44570d == C44570d.WV_KIND_SYS) {
                String c = C24523c.m38150c(str, c44570d);
                APr = c;
                mMKVSharedTransportOld = XWalkEnvironment.getMMKVSharedTransportOld(c);
                AppMethodBeat.m2505o(3979);
            } else {
                mMKVSharedTransportOld = null;
                AppMethodBeat.m2505o(3979);
            }
        }
        return mMKVSharedTransportOld;
    }
}
