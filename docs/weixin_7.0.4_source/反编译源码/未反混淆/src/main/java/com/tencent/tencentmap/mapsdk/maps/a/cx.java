package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class cx {
    private static int c = 20;
    protected AtomicInteger a = new AtomicInteger(0);
    private long b;
    private Handler d;
    private de e;
    private AtomicInteger f = new AtomicInteger(0);
    private List<String> g = new ArrayList();
    private volatile boolean h = false;
    private volatile boolean i = false;
    private AtomicInteger j = new AtomicInteger(0);
    private int k;
    private int l = 0;
    private long m = 0;
    private AtomicInteger n = new AtomicInteger(0);
    private volatile boolean o = false;
    private com.tencent.tencentmap.mapsdk.maps.a.de.a p = new da(this);
    private final Runnable q = new dc(this);
    private final Runnable r = new dd(this);

    abstract class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(cx cxVar, byte b) {
            this();
        }

        public final void a(boolean z) {
            if (!z) {
                cx.this.d.post(this);
            } else if (!cx.this.d.postAtFrontOfQueue(this)) {
                cx.this.d.post(this);
            }
        }
    }

    final class b extends a {
        private String a;
        private boolean b;
        private boolean c;

        public b(String str, boolean z, boolean z2) {
            super(cx.this, (byte) 0);
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        public final void run() {
            AppMethodBeat.i(98682);
            cx.this.j.decrementAndGet();
            if (TextUtils.isEmpty(this.a)) {
                AppMethodBeat.o(98682);
                return;
            }
            int a = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_new_record_num", 1, 50, 10);
            if (this.b) {
                cx.this.g.add(this.a);
                if (!this.c) {
                    cx.this.a(this.b, this.c);
                } else if (cx.this.g.size() >= a) {
                    cx.this.n.set(1);
                    cx.this.a(this.b, this.c);
                    AppMethodBeat.o(98682);
                    return;
                } else if (cx.this.n.get() == 0) {
                    cx.this.n.set(1);
                    cx.this.b(false, true);
                    AppMethodBeat.o(98682);
                    return;
                }
                AppMethodBeat.o(98682);
            } else if (dh.a(cx.this.b()).b(this.a) != -1) {
                if (cx.this.o) {
                    cx.this.o = false;
                    cx.this.b(false, false);
                }
                if (cx.this.f.incrementAndGet() >= a) {
                    cx.this.a(this.b, this.c);
                }
                AppMethodBeat.o(98682);
            } else {
                er.a("report_missing_event", er.b("report_missing_event", 0, false) + 1, false);
                AppMethodBeat.o(98682);
            }
        }
    }

    final class c extends a {
        private d a;

        public c(d dVar) {
            super(cx.this, (byte) 0);
            this.a = dVar;
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.i(98683);
            cx.this.h = false;
            cx.this.m = SystemClock.elapsedRealtime();
            int i2;
            if (this.a.d) {
                if (cx.this.l > 0) {
                    cx.b(cx.this, 10);
                }
                cx.this.a.addAndGet(this.a.g);
                if (!this.a.b) {
                    int size = this.a.e.size();
                    List arrayList = new ArrayList();
                    for (i2 = 0; i2 < size; i2++) {
                        arrayList.add(Long.valueOf(((com.tencent.tencentmap.mapsdk.maps.a.dh.a) this.a.e.get(i2)).a));
                    }
                    dh.a(cx.this.b()).a(arrayList);
                    if (cx.this.i) {
                        cx.this.i = false;
                        cx.this.a(true, this.a.c);
                        AppMethodBeat.o(98683);
                        return;
                    }
                }
                if (this.a.a) {
                    cx.this.o = true;
                    AppMethodBeat.o(98683);
                    return;
                }
                SystemClock.sleep(200);
                cx.this.a(this.a.b, this.a.c);
                AppMethodBeat.o(98683);
                return;
            }
            if (ce.h()) {
                if (cx.this.l > 0) {
                    if (cx.this.l < com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_interval_forbid_limit", 30, 1440, 60)) {
                        cx.c(cx.this, 2);
                    }
                } else {
                    cx.this.l = 5;
                }
            }
            if (this.a.c && this.a.b) {
                i2 = this.a.e.size();
                while (i < i2) {
                    dh.a(cx.this.b()).b(((com.tencent.tencentmap.mapsdk.maps.a.dh.a) this.a.e.get(i)).b);
                    i++;
                }
            }
            AppMethodBeat.o(98683);
        }
    }

    final class d extends a {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d = false;
        public List<com.tencent.tencentmap.mapsdk.maps.a.dh.a> e;
        private int f;
        private int g;

        public d(boolean z, boolean z2) {
            super(cx.this, (byte) 0);
            this.b = z;
            this.c = z2;
            this.f = 0;
        }

        public final void run() {
            String str;
            List list = null;
            int i = 0;
            AppMethodBeat.i(98684);
            this.a = false;
            cx.c = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_max_report_count", 10, 100, 20);
            if (this.b) {
                int size = cx.this.g.size();
                if (size != 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size && i2 < cx.c; i3++) {
                        str = (String) cx.this.g.get(i3);
                        arrayList2.add(new com.tencent.tencentmap.mapsdk.maps.a.dh.a(0, str));
                        arrayList.add(str);
                        i2++;
                    }
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        cx.this.g.remove(arrayList.get(i4));
                    }
                    if (cx.this.g.size() == 0) {
                        this.a = true;
                    }
                    Object obj = arrayList2;
                }
                this.e = list;
            } else {
                if (!dh.a(cx.this.b()).a(com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_clear_db_num", 1, (int) Downloads.MIN_WAIT_FOR_NETWORK, 1000))) {
                    list = dh.a(cx.this.b()).b(cx.c + 1);
                    if (list.size() <= cx.c) {
                        this.a = true;
                        cx.this.o = true;
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
                this.e = list;
            }
            if (this.e == null || this.e.size() == 0) {
                cx.this.h = false;
                AppMethodBeat.o(98684);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < this.e.size()) {
                stringBuilder.append(((com.tencent.tencentmap.mapsdk.maps.a.dh.a) this.e.get(i)).b).append(IOUtils.LINE_SEPARATOR_UNIX);
                i++;
            }
            str = stringBuilder.toString();
            if (this.b && str.contains("client_report_time")) {
                str = str.replace("client_report_time", eu.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
            }
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            this.g = length;
            byte[] a = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a(bytes);
            cx.a(cx.this, a.length);
            cx.this.e.a(a, length, this.b, this, cx.this.p, this.f);
            AppMethodBeat.o(98684);
        }
    }

    public cx() {
        df.a(bt.a());
        this.d = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("ReportAction", 10);
        this.e = new cy();
        a(true);
        b(true, false);
        this.k = a();
    }

    private void a(boolean z) {
        if (z) {
            this.d.postDelayed(new db(this), 5000);
        } else if (this.b != 0 && SystemClock.elapsedRealtime() - this.b > 1800000) {
            d();
        }
    }

    private synchronized void a(boolean z, boolean z2) {
        a(false);
        if (z && z2) {
            b(false, true);
        } else {
            b(false, false);
        }
        if (!this.h) {
            if (!z) {
                this.f.set(0);
            }
            if (this.m == 0 || SystemClock.elapsedRealtime() - this.m >= ((long) ((this.l * 60) * 1000))) {
                this.h = true;
                try {
                    new d(z, z2).a(true);
                } catch (Throwable th) {
                    this.h = false;
                }
            }
        } else if (z) {
            this.i = true;
        }
        return;
    }

    private void b(boolean z, boolean z2) {
        if (z2) {
            if (this.n.get() > 3) {
                this.n.set(0);
            } else {
                cm.a().a(this.q, (long) (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_real_timer_interval", 1, 60, 5) * 1000));
            }
        } else if (z) {
            cm.a().a(this.r, 10000);
        } else if (!this.o) {
            cm.a().a(this.r, (long) com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_timer_interval", 30000, 600000, 300000));
        }
    }

    private void d() {
        this.b = SystemClock.elapsedRealtime();
        int b = er.b("report_missing_event", 0, false);
        int b2 = er.b("report_using_traffic", 0, false);
        int a = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("report_using_traffic_limit", 1, 10240, 32);
        if (b != 0 || b2 >= (a << 10)) {
            long b3 = er.b("report_traffic_last_time", 0, false);
            if (b3 == 0) {
                er.a("report_traffic_last_time", System.currentTimeMillis(), false);
                return;
            }
            b3 = System.currentTimeMillis() - b3;
            HashMap hashMap = new HashMap();
            hashMap.put("B110", String.valueOf(b2));
            hashMap.put("B112", b3 < 0 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : String.valueOf(b3));
            if (b == 0) {
                bx.a("HLReportEvent", bt.c(), 0, "", hashMap, null, false);
            } else {
                hashMap.put("B111", String.valueOf(b));
                bx.a("HLReportEvent", bt.c(), -500, "", hashMap, null, false);
                er.a("report_missing_event", 0, false);
            }
            er.a("report_using_traffic", 0, false);
        }
    }

    public abstract int a();

    public final void a(String str, boolean z, boolean z2) {
        try {
            if (this.j.getAndIncrement() > this.k) {
                this.j.decrementAndGet();
            } else {
                new b(str, z, z2).a(false);
            }
        } catch (Throwable th) {
        }
    }

    public abstract String b();
}
