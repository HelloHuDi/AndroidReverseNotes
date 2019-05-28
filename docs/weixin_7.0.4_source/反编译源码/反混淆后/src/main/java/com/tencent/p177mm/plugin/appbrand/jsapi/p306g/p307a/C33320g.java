package com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@TargetApi(3)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.g */
public final class C33320g {
    private static Map<String, HashMap<String, C10406b>> hOH = new HashMap();
    private static Set<C10406b> hOI = new HashSet();
    public static C33321a hOJ;
    public static SensorManager sensorManager;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.a.g$a */
    static class C33321a implements SensorEventListener {
        private float hOK = 0.0f;
        private long timestamp = 200;

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.m2504i(93896);
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float ap = C38303f.m64815ap(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(ap - this.hOK) > 3.0f) {
                    synchronized (C33320g.hOH) {
                        try {
                            for (HashMap values : C33320g.hOH.values()) {
                                for (C10406b c10406b : values.values()) {
                                    if (c10406b != null) {
                                        c10406b.mo34547J(this.hOK, ap);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(93896);
                        }
                    }
                    this.hOK = ap;
                    this.timestamp = System.currentTimeMillis();
                }
            }
            AppMethodBeat.m2505o(93896);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    static {
        AppMethodBeat.m2504i(93904);
        AppMethodBeat.m2505o(93904);
    }

    private static synchronized void init() {
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93897);
            C4990ab.m7416i("MicroMsg.AppBrandMapManager", "init");
            if (hOJ == null) {
                hOJ = new C33321a();
                SensorManager sensorManager = (SensorManager) C4996ah.getContext().getSystemService("sensor");
                sensorManager = sensorManager;
                sensorManager.registerListener(hOJ, sensorManager.getDefaultSensor(3), 1);
            }
            AppMethodBeat.m2505o(93897);
        }
    }

    /* renamed from: a */
    public static synchronized void m54491a(C10406b c10406b) {
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93898);
            C4990ab.m7417i("MicroMsg.AppBrandMapManager", "registerListener map:%s", c10406b);
            hOI.add(c10406b);
            if (hOI.size() == 1) {
                C33320g.init();
            }
            AppMethodBeat.m2505o(93898);
        }
    }

    private static synchronized void uninit() {
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93899);
            C4990ab.m7416i("MicroMsg.AppBrandMapManager", "uninit");
            if (!(hOJ == null || sensorManager == null)) {
                C4990ab.m7416i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
                sensorManager.unregisterListener(hOJ);
                sensorManager = null;
                hOJ = null;
            }
            AppMethodBeat.m2505o(93899);
        }
    }

    /* renamed from: b */
    public static synchronized void m54493b(C10406b c10406b) {
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93900);
            C4990ab.m7417i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", c10406b);
            hOI.remove(c10406b);
            if (hOI.size() == 0) {
                C33320g.uninit();
            }
            AppMethodBeat.m2505o(93900);
        }
    }

    /* renamed from: a */
    public static synchronized boolean m54492a(String str, String str2, C10406b c10406b) {
        boolean z;
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93901);
            if ("invalid_map_id".equals(str2)) {
                C4990ab.m7412e("MicroMsg.AppBrandMapManager", "[createMapView]INVALID_MAP_ID");
                AppMethodBeat.m2505o(93901);
                z = false;
            } else {
                HashMap hashMap = (HashMap) hOH.get(str);
                if (hashMap == null) {
                    hashMap = new HashMap();
                    hOH.put(str, hashMap);
                }
                if (hashMap.containsKey(str2)) {
                    C4990ab.m7420w("MicroMsg.AppBrandMapManager", "map is exist, return");
                    AppMethodBeat.m2505o(93901);
                    z = false;
                } else {
                    hashMap.put(str2, c10406b);
                    C4990ab.m7417i("MicroMsg.AppBrandMapManager", "initMapView appId:%s, mapId:%s", str, str2);
                    AppMethodBeat.m2505o(93901);
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: cj */
    public static synchronized C10406b m54494cj(String str, String str2) {
        C10406b c10406b;
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93902);
            if ("invalid_map_id".equals(str2)) {
                C4990ab.m7412e("MicroMsg.AppBrandMapManager", "[getMapView]INVALID_MAP_ID");
                AppMethodBeat.m2505o(93902);
                c10406b = null;
            } else {
                HashMap hashMap = (HashMap) hOH.get(str);
                if (hashMap == null) {
                    AppMethodBeat.m2505o(93902);
                    c10406b = null;
                } else {
                    c10406b = (C10406b) hashMap.get(str2);
                    AppMethodBeat.m2505o(93902);
                }
            }
        }
        return c10406b;
    }

    /* renamed from: ck */
    public static synchronized boolean m54495ck(String str, String str2) {
        boolean z;
        synchronized (C33320g.class) {
            AppMethodBeat.m2504i(93903);
            HashMap hashMap = (HashMap) hOH.get(str);
            if (hashMap == null) {
                AppMethodBeat.m2505o(93903);
                z = false;
            } else {
                C10406b c10406b = (C10406b) hashMap.get(str2);
                if (c10406b == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandMapManager", "[destroyMapView] mapview not exist, err");
                    AppMethodBeat.m2505o(93903);
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.AppBrandMapManager", "destoryMapView map:%s", c10406b);
                    hashMap.remove(str2);
                    C33320g.m54493b(c10406b);
                    if (hashMap.size() <= 0) {
                        hOH.remove(str);
                    }
                    c10406b.onDestroy();
                    C4990ab.m7417i("MicroMsg.AppBrandMapManager", "[destroyMapView]appid:%s, map count:%d", str, Integer.valueOf(hashMap.size()));
                    AppMethodBeat.m2505o(93903);
                    z = true;
                }
            }
        }
        return z;
    }
}
