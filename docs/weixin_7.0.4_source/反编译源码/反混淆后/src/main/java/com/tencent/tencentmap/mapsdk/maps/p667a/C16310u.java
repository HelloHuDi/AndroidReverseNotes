package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41003a;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.u */
public final class C16310u implements Runnable {
    /* renamed from: a */
    private static long f3487a = 0;
    /* renamed from: b */
    private Context f3488b = null;

    public C16310u(Context context) {
        this.f3488b = context;
    }

    /* renamed from: a */
    private static synchronized long m25136a() {
        long j;
        synchronized (C16310u.class) {
            j = f3487a;
        }
        return j;
    }

    /* renamed from: a */
    public static synchronized void m25137a(long j) {
        synchronized (C16310u.class) {
            f3487a = j;
        }
    }

    public final void run() {
        C24421s[] i;
        int i2;
        AppMethodBeat.m2504i(100559);
        C44544y h = C24349e.m37616h(this.f3488b);
        if (!(h == null || h.mo70965b() != 101 || h.mo70966c() == null)) {
            try {
                C46770bd f = C36541t.m60530a(this.f3488b).mo57790f();
                if (f != null) {
                    f.mo75357a(101, h.mo70966c(), false);
                    C16205ag.m24688e("common strategy setted by local db", new Object[0]);
                }
            } catch (Throwable th) {
                C16205ag.m24684a(th);
            }
        }
        C36541t a = C36541t.m60530a(this.f3488b);
        if (a.mo57794j() == 0) {
            C16205ag.m24688e("stepCheckApp", new Object[0]);
            a.mo57779a(1);
            C16205ag.m24688e("isAppFirstRun : %b", Boolean.valueOf(C41003a.m71123c(this.f3488b)));
            if (C41003a.m71123c(this.f3488b)) {
                C16205ag.m24688e("clear all ao: %d", Integer.valueOf(C44539p.m80849a(this.f3488b, null)));
                synchronized (a) {
                    try {
                        C16205ag.m24688e("appfirstRun", new Object[0]);
                        i = a.mo57793i();
                        a.mo57792h();
                    } catch (Throwable th2) {
                        AppMethodBeat.m2505o(100559);
                    }
                }
                if (i != null) {
                    C16205ag.m24688e("notify listener first run", new Object[0]);
                    for (C24421s c : i) {
                        c.mo40751c();
                    }
                }
            } else {
                long a2 = C16310u.m25136a();
                if (a2 > 0) {
                    C16205ag.m24688e("sleep: %d", Long.valueOf(a2));
                    try {
                        Thread.sleep(a2);
                    } catch (InterruptedException e) {
                        C16205ag.m24684a(e);
                    }
                }
            }
        }
        synchronized (a) {
            try {
                C16205ag.m24688e("stepStartQuery", new Object[0]);
                i = a.mo57793i();
                a.mo57779a(2);
            } finally {
                AppMethodBeat.m2505o(100559);
            }
        }
        if (i != null) {
            C16205ag.m24688e("notify listener query start", new Object[0]);
            for (C24421s c2 : i) {
                c2.mo40749a();
            }
        }
        if (!C44540v.m80860a().mo70944g()) {
            C41033be c3 = C36541t.m60531c();
            i2 = 0;
            while (c3 == null) {
                i2++;
                if (i2 >= 5) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                    C16205ag.m24684a(e2);
                }
                c3 = C36541t.m60531c();
            }
            if (c3 == null) {
                C16205ag.m24691h("no uphandler ,no upload!", new Object[0]);
            } else if (C16310u.m25138a(this.f3488b)) {
                C16205ag.m24686c("startQuery: query times arrive max, return!", new Object[0]);
                C36541t.m60530a(this.f3488b).mo57787b();
            } else {
                c3.mo65113a(new C31024bb(this.f3488b));
            }
        }
        C16205ag.m24691h("common query end!", new Object[0]);
        synchronized (a) {
            try {
                i = a.mo57793i();
                a.mo57779a(3);
            } finally {
                AppMethodBeat.m2505o(100559);
            }
        }
        if (i != null) {
            C16205ag.m24688e("notify listener query end", new Object[0]);
            for (C24421s b : i) {
                b.mo40750b();
            }
        }
        C44540v e3 = C36541t.m60530a(this.f3488b).mo57789e();
        if (e3 == null) {
            C16205ag.m24687d("magic should never null ? comStrategy", new Object[0]);
            return;
        }
        long c4 = (long) (e3.mo70940c() * 60000);
        if (c4 > 0) {
            C46752b.m88622a().mo12299a(this, c4);
            C16205ag.m24691h("next time: %d", Long.valueOf(c4));
            C36541t.m60530a(this.f3488b).mo57779a(4);
            return;
        }
        C16205ag.m24691h("stop loop query", new Object[0]);
        AppMethodBeat.m2505o(100559);
    }

    /* renamed from: a */
    private static boolean m25138a(Context context) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(100560);
        try {
            int parseInt = Integer.parseInt(C41003a.m71119b(context, "querytimes", AppEventsConstants.EVENT_PARAM_VALUE_NO));
            if (!C24349e.m37613g().equals(C41003a.m71119b(context, "initsdkdate", ""))) {
                C41003a.m71120b(context, C24349e.m37613g());
                parseInt = 0;
            }
            if (parseInt <= C44540v.m80860a().mo70943f()) {
                C41003a.m71115a(context, String.valueOf(parseInt + 1));
            } else {
                z = true;
                try {
                    C16205ag.m24688e(" sdk init max times", new Object[0]);
                    z2 = true;
                } catch (Exception e) {
                    C16205ag.m24686c(" set init times failed! ", new Object[0]);
                    z2 = z;
                    AppMethodBeat.m2505o(100560);
                    return z2;
                }
            }
        } catch (Exception e2) {
            z = false;
            C16205ag.m24686c(" set init times failed! ", new Object[0]);
            z2 = z;
            AppMethodBeat.m2505o(100560);
            return z2;
        }
        AppMethodBeat.m2505o(100560);
        return z2;
    }
}
