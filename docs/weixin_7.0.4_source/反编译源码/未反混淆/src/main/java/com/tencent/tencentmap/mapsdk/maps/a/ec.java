package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ec implements ek, Runnable {
    private static int a = -1;
    private static ec b = new ec();
    private dq c;
    private boolean d = false;
    private Handler e;
    private Map<String, dy> f = new ConcurrentHashMap();
    private Runnable g = new eg(this);
    private Runnable h = new ei(this);
    private Runnable i = new ej(this);
    private Map<String, a> j = new HashMap();

    class a {
        public long a;
        public int b;

        private a(ec ecVar) {
        }

        /* synthetic */ a(ec ecVar, byte b) {
            this(ecVar);
        }
    }

    static {
        AppMethodBeat.i(98775);
        AppMethodBeat.o(98775);
    }

    private ec() {
        AppMethodBeat.i(98762);
        AppMethodBeat.o(98762);
    }

    private a a(String str) {
        AppMethodBeat.i(98769);
        if (this.j.isEmpty()) {
            try {
                String b = er.b("apnrecords", "", true);
                if (!b.isEmpty()) {
                    JSONObject jSONObject = new JSONObject(b);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        b = (String) keys.next();
                        if (!TextUtils.isEmpty(b)) {
                            JSONObject optJSONObject = jSONObject.optJSONObject(b);
                            if (optJSONObject != null) {
                                a aVar = new a(this, (byte) 0);
                                aVar.b = optJSONObject.optInt("lastCode");
                                aVar.a = optJSONObject.optLong("lastReqTime");
                                this.j.put(b, aVar);
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        a aVar2 = (a) this.j.get(str);
        if (aVar2 == null) {
            aVar2 = new a(this, (byte) 0);
            this.j.put(str, aVar2);
        }
        AppMethodBeat.o(98769);
        return aVar2;
    }

    private static int c(int i) {
        AppMethodBeat.i(98770);
        String str = i == 0 ? "http_platform_update_interval_succ" : (i == -4 || i == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        int i2 = i == 0 ? 1800000 : (i == -4 || i == -3) ? 60000 : 300000;
        i2 = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a(str, 60000, 3600000, i2);
        AppMethodBeat.o(98770);
        return i2;
    }

    public static ec c() {
        return b;
    }

    public final void a() {
        AppMethodBeat.i(98765);
        ((dy) this.f.get("accessscheduler")).a();
        AppMethodBeat.o(98765);
    }

    public final void b() {
        AppMethodBeat.i(98766);
        ((dy) this.f.get("settings")).b();
        AppMethodBeat.o(98766);
    }

    public final dq d() {
        return this.c;
    }

    public final void e() {
        AppMethodBeat.i(98764);
        this.e = com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("HttpPlatformConnection", 10);
        this.e.post(this);
        this.c.c();
        AppMethodBeat.o(98764);
    }

    public final void run() {
        AppMethodBeat.i(98768);
        if (com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("http_platform_start_update_on", 0, 1, 0) == 1) {
            a = 1;
            this.e.post(this.i);
        }
        AppMethodBeat.o(98768);
    }

    public final void a(dq dqVar) {
        AppMethodBeat.i(98763);
        this.c = dqVar;
        eh ehVar = new eh();
        this.f.put(ehVar.c(), ehVar);
        ea eaVar = new ea();
        this.f.put(eaVar.c(), eaVar);
        ed edVar = new ed();
        this.f.put(edVar.c(), edVar);
        AppMethodBeat.o(98763);
    }

    public final void a(int i) {
        AppMethodBeat.i(98767);
        if (i == 1 || i == 2) {
            this.e.removeCallbacks(this.h);
            this.e.post(this.h);
            AppMethodBeat.o(98767);
            return;
        }
        if (i == 3 || i == 4) {
            cm.a().a(this.g, (long) (((new Random().nextInt(com.tencent.tencentmap.mapsdk.maps.a.ce.a.a("detect_platform_update_random_interval", 0, 1440, 10)) * 60) * 1000) + c(0)));
        }
        AppMethodBeat.o(98767);
    }

    static /* synthetic */ void e(ec ecVar) {
        AppMethodBeat.i(98774);
        if (!ecVar.j.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Entry entry : ecVar.j.entrySet()) {
                a aVar = (a) entry.getValue();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("lastCode", aVar.b);
                    jSONObject2.put("lastReqTime", aVar.a);
                    jSONObject.put((String) entry.getKey(), jSONObject2);
                } catch (JSONException e) {
                }
            }
            er.a("apnrecords", jSONObject.toString(), true);
        }
        AppMethodBeat.o(98774);
    }
}
