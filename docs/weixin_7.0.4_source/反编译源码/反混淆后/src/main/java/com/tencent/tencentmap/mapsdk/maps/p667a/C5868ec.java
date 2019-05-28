package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ec */
public final class C5868ec implements C31040ek, Runnable {
    /* renamed from: a */
    private static int f1578a = -1;
    /* renamed from: b */
    private static C5868ec f1579b = new C5868ec();
    /* renamed from: c */
    private C31037dq f1580c;
    /* renamed from: d */
    private boolean f1581d = false;
    /* renamed from: e */
    private Handler f1582e;
    /* renamed from: f */
    private Map<String, C16219dy> f1583f = new ConcurrentHashMap();
    /* renamed from: g */
    private Runnable f1584g = new C46779eg(this);
    /* renamed from: h */
    private Runnable f1585h = new C31039ei(this);
    /* renamed from: i */
    private Runnable f1586i = new C16220ej(this);
    /* renamed from: j */
    private Map<String, C5869a> f1587j = new HashMap();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ec$a */
    class C5869a {
        /* renamed from: a */
        public long f1588a;
        /* renamed from: b */
        public int f1589b;

        private C5869a(C5868ec c5868ec) {
        }

        /* synthetic */ C5869a(C5868ec c5868ec, byte b) {
            this(c5868ec);
        }
    }

    static {
        AppMethodBeat.m2504i(98775);
        AppMethodBeat.m2505o(98775);
    }

    private C5868ec() {
        AppMethodBeat.m2504i(98762);
        AppMethodBeat.m2505o(98762);
    }

    /* renamed from: a */
    private C5869a m9038a(String str) {
        AppMethodBeat.m2504i(98769);
        if (this.f1587j.isEmpty()) {
            try {
                String b = C24370er.m37716b("apnrecords", "", true);
                if (!b.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(b);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        b = (String) keys.next();
                        if (!TextUtils.isEmpty(b)) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(b);
                            if (optJSONObject != null) {
                                C5869a c5869a = new C5869a(this, (byte) 0);
                                c5869a.f1589b = optJSONObject.optInt("lastCode");
                                c5869a.f1588a = optJSONObject.optLong("lastReqTime");
                                this.f1587j.put(b, c5869a);
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        C5869a c5869a2 = (C5869a) this.f1587j.get(str);
        if (c5869a2 == null) {
            c5869a2 = new C5869a(this, (byte) 0);
            this.f1587j.put(str, c5869a2);
        }
        AppMethodBeat.m2505o(98769);
        return c5869a2;
    }

    /* renamed from: c */
    private static int m9042c(int i) {
        AppMethodBeat.m2504i(98770);
        String str = i == 0 ? "http_platform_update_interval_succ" : (i == -4 || i == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        int i2 = i == 0 ? 1800000 : (i == -4 || i == -3) ? 60000 : 300000;
        i2 = C24362a.m37665a(str, 60000, 3600000, i2);
        AppMethodBeat.m2505o(98770);
        return i2;
    }

    /* renamed from: c */
    public static C5868ec m9044c() {
        return f1579b;
    }

    /* renamed from: a */
    public final void mo12414a() {
        AppMethodBeat.m2504i(98765);
        ((C16219dy) this.f1583f.get("accessscheduler")).mo12414a();
        AppMethodBeat.m2505o(98765);
    }

    /* renamed from: b */
    public final void mo12421b() {
        AppMethodBeat.m2504i(98766);
        ((C16219dy) this.f1583f.get("settings")).mo12421b();
        AppMethodBeat.m2505o(98766);
    }

    /* renamed from: d */
    public final C31037dq mo12422d() {
        return this.f1580c;
    }

    /* renamed from: e */
    public final void mo12423e() {
        AppMethodBeat.m2504i(98764);
        this.f1582e = C24362a.m37667a("HttpPlatformConnection", 10);
        this.f1582e.post(this);
        this.f1580c.mo29273c();
        AppMethodBeat.m2505o(98764);
    }

    public final void run() {
        AppMethodBeat.m2504i(98768);
        if (C24362a.m37665a("http_platform_start_update_on", 0, 1, 0) == 1) {
            f1578a = 1;
            this.f1582e.post(this.f1586i);
        }
        AppMethodBeat.m2505o(98768);
    }

    /* renamed from: a */
    public final void mo12420a(C31037dq c31037dq) {
        AppMethodBeat.m2504i(98763);
        this.f1580c = c31037dq;
        C41044eh c41044eh = new C41044eh();
        this.f1583f.put(c41044eh.mo12417c(), c41044eh);
        C5866ea c5866ea = new C5866ea();
        this.f1583f.put(c5866ea.mo12417c(), c5866ea);
        C17082ed c17082ed = new C17082ed();
        this.f1583f.put(c17082ed.mo12417c(), c17082ed);
        AppMethodBeat.m2505o(98763);
    }

    /* renamed from: a */
    public final void mo12419a(int i) {
        AppMethodBeat.m2504i(98767);
        if (i == 1 || i == 2) {
            this.f1582e.removeCallbacks(this.f1585h);
            this.f1582e.post(this.f1585h);
            AppMethodBeat.m2505o(98767);
            return;
        }
        if (i == 3 || i == 4) {
            C16215cm.m24715a().mo29266a(this.f1584g, (long) (((new Random().nextInt(C24362a.m37665a("detect_platform_update_random_interval", 0, 1440, 10)) * 60) * 1000) + C5868ec.m9042c(0)));
        }
        AppMethodBeat.m2505o(98767);
    }

    /* renamed from: e */
    static /* synthetic */ void m9046e(C5868ec c5868ec) {
        AppMethodBeat.m2504i(98774);
        if (!c5868ec.f1587j.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Entry entry : c5868ec.f1587j.entrySet()) {
                C5869a c5869a = (C5869a) entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("lastCode", c5869a.f1589b);
                    jSONObject2.put("lastReqTime", c5869a.f1588a);
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                }
            }
            C24370er.m37713a("apnrecords", jSONObject.toString(), true);
        }
        AppMethodBeat.m2505o(98774);
    }
}
