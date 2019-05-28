package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31035dh.C31036a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41042de.C36497a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cx */
public abstract class C36492cx {
    /* renamed from: c */
    private static int f15295c = 20;
    /* renamed from: a */
    protected AtomicInteger f15296a = new AtomicInteger(0);
    /* renamed from: b */
    private long f15297b;
    /* renamed from: d */
    private Handler f15298d;
    /* renamed from: e */
    private C41042de f15299e;
    /* renamed from: f */
    private AtomicInteger f15300f = new AtomicInteger(0);
    /* renamed from: g */
    private List<String> f15301g = new ArrayList();
    /* renamed from: h */
    private volatile boolean f15302h = false;
    /* renamed from: i */
    private volatile boolean f15303i = false;
    /* renamed from: j */
    private AtomicInteger f15304j = new AtomicInteger(0);
    /* renamed from: k */
    private int f15305k;
    /* renamed from: l */
    private int f15306l = 0;
    /* renamed from: m */
    private long f15307m = 0;
    /* renamed from: n */
    private AtomicInteger f15308n = new AtomicInteger(0);
    /* renamed from: o */
    private volatile boolean f15309o = false;
    /* renamed from: p */
    private C36497a f15310p = new C46776da(this);
    /* renamed from: q */
    private final Runnable f15311q = new C44503dc(this);
    /* renamed from: r */
    private final Runnable f15312r = new C44504dd(this);

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cx$a */
    abstract class C16217a implements Runnable {
        private C16217a() {
        }

        /* synthetic */ C16217a(C36492cx c36492cx, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo29271a(boolean z) {
            if (!z) {
                C36492cx.this.f15298d.post(this);
            } else if (!C36492cx.this.f15298d.postAtFrontOfQueue(this)) {
                C36492cx.this.f15298d.post(this);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cx$b */
    final class C31033b extends C16217a {
        /* renamed from: a */
        private String f14094a;
        /* renamed from: b */
        private boolean f14095b;
        /* renamed from: c */
        private boolean f14096c;

        public C31033b(String str, boolean z, boolean z2) {
            super(C36492cx.this, (byte) 0);
            this.f14094a = str;
            this.f14095b = z;
            this.f14096c = z2;
        }

        public final void run() {
            AppMethodBeat.m2504i(98682);
            C36492cx.this.f15304j.decrementAndGet();
            if (TextUtils.isEmpty(this.f14094a)) {
                AppMethodBeat.m2505o(98682);
                return;
            }
            int a = C24362a.m37665a("report_new_record_num", 1, 50, 10);
            if (this.f14095b) {
                C36492cx.this.f15301g.add(this.f14094a);
                if (!this.f14096c) {
                    C36492cx.this.m60349a(this.f14095b, this.f14096c);
                } else if (C36492cx.this.f15301g.size() >= a) {
                    C36492cx.this.f15308n.set(1);
                    C36492cx.this.m60349a(this.f14095b, this.f14096c);
                    AppMethodBeat.m2505o(98682);
                    return;
                } else if (C36492cx.this.f15308n.get() == 0) {
                    C36492cx.this.f15308n.set(1);
                    C36492cx.this.m60354b(false, true);
                    AppMethodBeat.m2505o(98682);
                    return;
                }
                AppMethodBeat.m2505o(98682);
            } else if (C31035dh.m49871a(C36492cx.this.mo40552b()).mo50360b(this.f14094a) != -1) {
                if (C36492cx.this.f15309o) {
                    C36492cx.this.f15309o = false;
                    C36492cx.this.m60354b(false, false);
                }
                if (C36492cx.this.f15300f.incrementAndGet() >= a) {
                    C36492cx.this.m60349a(this.f14095b, this.f14096c);
                }
                AppMethodBeat.m2505o(98682);
            } else {
                C24370er.m37711a("report_missing_event", C24370er.m37714b("report_missing_event", 0, false) + 1, false);
                AppMethodBeat.m2505o(98682);
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cx$c */
    final class C36493c extends C16217a {
        /* renamed from: a */
        private C36494d f15313a;

        public C36493c(C36494d c36494d) {
            super(C36492cx.this, (byte) 0);
            this.f15313a = c36494d;
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(98683);
            C36492cx.this.f15302h = false;
            C36492cx.this.f15307m = SystemClock.elapsedRealtime();
            int i2;
            if (this.f15313a.f15318d) {
                if (C36492cx.this.f15306l > 0) {
                    C36492cx.m60351b(C36492cx.this, 10);
                }
                C36492cx.this.f15296a.addAndGet(this.f15313a.f15321g);
                if (!this.f15313a.f15316b) {
                    int size = this.f15313a.f15319e.size();
                    List arrayList = new ArrayList();
                    for (i2 = 0; i2 < size; i2++) {
                        arrayList.add(Long.valueOf(((C31036a) this.f15313a.f15319e.get(i2)).f14104a));
                    }
                    C31035dh.m49871a(C36492cx.this.mo40552b()).mo50358a(arrayList);
                    if (C36492cx.this.f15303i) {
                        C36492cx.this.f15303i = false;
                        C36492cx.this.m60349a(true, this.f15313a.f15317c);
                        AppMethodBeat.m2505o(98683);
                        return;
                    }
                }
                if (this.f15313a.f15315a) {
                    C36492cx.this.f15309o = true;
                    AppMethodBeat.m2505o(98683);
                    return;
                }
                SystemClock.sleep(200);
                C36492cx.this.m60349a(this.f15313a.f15316b, this.f15313a.f15317c);
                AppMethodBeat.m2505o(98683);
                return;
            }
            if (C31029ce.m49853h()) {
                if (C36492cx.this.f15306l > 0) {
                    if (C36492cx.this.f15306l < C24362a.m37665a("report_interval_forbid_limit", 30, 1440, 60)) {
                        C36492cx.m60357c(C36492cx.this, 2);
                    }
                } else {
                    C36492cx.this.f15306l = 5;
                }
            }
            if (this.f15313a.f15317c && this.f15313a.f15316b) {
                i2 = this.f15313a.f15319e.size();
                while (i < i2) {
                    C31035dh.m49871a(C36492cx.this.mo40552b()).mo50360b(((C31036a) this.f15313a.f15319e.get(i)).f14105b);
                    i++;
                }
            }
            AppMethodBeat.m2505o(98683);
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cx$d */
    final class C36494d extends C16217a {
        /* renamed from: a */
        public boolean f15315a;
        /* renamed from: b */
        public boolean f15316b;
        /* renamed from: c */
        public boolean f15317c;
        /* renamed from: d */
        public boolean f15318d = false;
        /* renamed from: e */
        public List<C31036a> f15319e;
        /* renamed from: f */
        private int f15320f;
        /* renamed from: g */
        private int f15321g;

        public C36494d(boolean z, boolean z2) {
            super(C36492cx.this, (byte) 0);
            this.f15316b = z;
            this.f15317c = z2;
            this.f15320f = 0;
        }

        public final void run() {
            String str;
            List list = null;
            int i = 0;
            AppMethodBeat.m2504i(98684);
            this.f15315a = false;
            C36492cx.f15295c = C24362a.m37665a("report_max_report_count", 10, 100, 20);
            if (this.f15316b) {
                int size = C36492cx.this.f15301g.size();
                if (size != 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size && i2 < C36492cx.f15295c; i3++) {
                        str = (String) C36492cx.this.f15301g.get(i3);
                        arrayList2.add(new C31036a(0, str));
                        arrayList.add(str);
                        i2++;
                    }
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        C36492cx.this.f15301g.remove(arrayList.get(i4));
                    }
                    if (C36492cx.this.f15301g.size() == 0) {
                        this.f15315a = true;
                    }
                    Object obj = arrayList2;
                }
                this.f15319e = list;
            } else {
                if (!C31035dh.m49871a(C36492cx.this.mo40552b()).mo50359a(C24362a.m37665a("report_clear_db_num", 1, (int) Downloads.MIN_WAIT_FOR_NETWORK, 1000))) {
                    list = C31035dh.m49871a(C36492cx.this.mo40552b()).mo50361b(C36492cx.f15295c + 1);
                    if (list.size() <= C36492cx.f15295c) {
                        this.f15315a = true;
                        C36492cx.this.f15309o = true;
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
                this.f15319e = list;
            }
            if (this.f15319e == null || this.f15319e.size() == 0) {
                C36492cx.this.f15302h = false;
                AppMethodBeat.m2505o(98684);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < this.f15319e.size()) {
                stringBuilder.append(((C31036a) this.f15319e.get(i)).f14105b).append(IOUtils.LINE_SEPARATOR_UNIX);
                i++;
            }
            str = stringBuilder.toString();
            if (this.f15316b && str.contains("client_report_time")) {
                str = str.replace("client_report_time", C24373eu.m37734a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
            }
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            this.f15321g = length;
            byte[] a = C24362a.m37672a(bytes);
            C36492cx.m60346a(C36492cx.this, a.length);
            C36492cx.this.f15299e.mo57717a(a, length, this.f15316b, this, C36492cx.this.f15310p, this.f15320f);
            AppMethodBeat.m2505o(98684);
        }
    }

    public C36492cx() {
        C31034df.m49865a(C46772bt.m88735a());
        this.f15298d = C24362a.m37667a("ReportAction", 10);
        this.f15299e = new C36495cy();
        m60348a(true);
        m60354b(true, false);
        this.f15305k = mo40550a();
    }

    /* renamed from: a */
    private void m60348a(boolean z) {
        if (z) {
            this.f15298d.postDelayed(new C41041db(this), 5000);
        } else if (this.f15297b != 0 && SystemClock.elapsedRealtime() - this.f15297b > 1800000) {
            m60362d();
        }
    }

    /* renamed from: a */
    private synchronized void m60349a(boolean z, boolean z2) {
        m60348a(false);
        if (z && z2) {
            m60354b(false, true);
        } else {
            m60354b(false, false);
        }
        if (!this.f15302h) {
            if (!z) {
                this.f15300f.set(0);
            }
            if (this.f15307m == 0 || SystemClock.elapsedRealtime() - this.f15307m >= ((long) ((this.f15306l * 60) * 1000))) {
                this.f15302h = true;
                try {
                    new C36494d(z, z2).mo29271a(true);
                } catch (Throwable th) {
                    this.f15302h = false;
                }
            }
        } else if (z) {
            this.f15303i = true;
        }
        return;
    }

    /* renamed from: b */
    private void m60354b(boolean z, boolean z2) {
        if (z2) {
            if (this.f15308n.get() > 3) {
                this.f15308n.set(0);
            } else {
                C16215cm.m24715a().mo29266a(this.f15311q, (long) (C24362a.m37665a("report_real_timer_interval", 1, 60, 5) * 1000));
            }
        } else if (z) {
            C16215cm.m24715a().mo29266a(this.f15312r, 10000);
        } else if (!this.f15309o) {
            C16215cm.m24715a().mo29266a(this.f15312r, (long) C24362a.m37665a("report_timer_interval", 30000, 600000, 300000));
        }
    }

    /* renamed from: d */
    private void m60362d() {
        this.f15297b = SystemClock.elapsedRealtime();
        int b = C24370er.m37714b("report_missing_event", 0, false);
        int b2 = C24370er.m37714b("report_using_traffic", 0, false);
        int a = C24362a.m37665a("report_using_traffic_limit", 1, 10240, 32);
        if (b != 0 || b2 >= (a << 10)) {
            long b3 = C24370er.m37715b("report_traffic_last_time", 0, false);
            if (b3 == 0) {
                C24370er.m37712a("report_traffic_last_time", System.currentTimeMillis(), false);
                return;
            }
            b3 = System.currentTimeMillis() - b3;
            HashMap hashMap = new HashMap();
            hashMap.put("B110", String.valueOf(b2));
            hashMap.put("B112", b3 < 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : String.valueOf(b3));
            if (b == 0) {
                C31027bx.m49842a("HLReportEvent", C46772bt.m88739c(), 0, "", hashMap, null, false);
            } else {
                hashMap.put("B111", String.valueOf(b));
                C31027bx.m49842a("HLReportEvent", C46772bt.m88739c(), -500, "", hashMap, null, false);
                C24370er.m37711a("report_missing_event", 0, false);
            }
            C24370er.m37711a("report_using_traffic", 0, false);
        }
    }

    /* renamed from: a */
    public abstract int mo40550a();

    /* renamed from: a */
    public final void mo57714a(String str, boolean z, boolean z2) {
        try {
            if (this.f15304j.getAndIncrement() > this.f15305k) {
                this.f15304j.decrementAndGet();
            } else {
                new C31033b(str, z, z2).mo29271a(false);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    public abstract String mo40552b();
}
