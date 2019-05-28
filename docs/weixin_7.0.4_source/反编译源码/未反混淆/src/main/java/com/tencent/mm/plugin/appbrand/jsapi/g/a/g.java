package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@TargetApi(3)
public final class g {
    private static Map<String, HashMap<String, b>> hOH = new HashMap();
    private static Set<b> hOI = new HashSet();
    public static a hOJ;
    public static SensorManager sensorManager;

    static class a implements SensorEventListener {
        private float hOK = 0.0f;
        private long timestamp = 200;

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(93896);
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float ap = f.ap(sensorEvent.values[0]);
                if (currentTimeMillis > 200 && Math.abs(ap - this.hOK) > 3.0f) {
                    synchronized (g.hOH) {
                        try {
                            for (HashMap values : g.hOH.values()) {
                                for (b bVar : values.values()) {
                                    if (bVar != null) {
                                        bVar.J(this.hOK, ap);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(93896);
                        }
                    }
                    this.hOK = ap;
                    this.timestamp = System.currentTimeMillis();
                }
            }
            AppMethodBeat.o(93896);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    static {
        AppMethodBeat.i(93904);
        AppMethodBeat.o(93904);
    }

    private static synchronized void init() {
        synchronized (g.class) {
            AppMethodBeat.i(93897);
            ab.i("MicroMsg.AppBrandMapManager", "init");
            if (hOJ == null) {
                hOJ = new a();
                SensorManager sensorManager = (SensorManager) ah.getContext().getSystemService("sensor");
                sensorManager = sensorManager;
                sensorManager.registerListener(hOJ, sensorManager.getDefaultSensor(3), 1);
            }
            AppMethodBeat.o(93897);
        }
    }

    public static synchronized void a(b bVar) {
        synchronized (g.class) {
            AppMethodBeat.i(93898);
            ab.i("MicroMsg.AppBrandMapManager", "registerListener map:%s", bVar);
            hOI.add(bVar);
            if (hOI.size() == 1) {
                init();
            }
            AppMethodBeat.o(93898);
        }
    }

    private static synchronized void uninit() {
        synchronized (g.class) {
            AppMethodBeat.i(93899);
            ab.i("MicroMsg.AppBrandMapManager", "uninit");
            if (!(hOJ == null || sensorManager == null)) {
                ab.i("MicroMsg.AppBrandMapManager", "sensorListener uninit");
                sensorManager.unregisterListener(hOJ);
                sensorManager = null;
                hOJ = null;
            }
            AppMethodBeat.o(93899);
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (g.class) {
            AppMethodBeat.i(93900);
            ab.i("MicroMsg.AppBrandMapManager", "unregisterListener map:%s", bVar);
            hOI.remove(bVar);
            if (hOI.size() == 0) {
                uninit();
            }
            AppMethodBeat.o(93900);
        }
    }

    public static synchronized boolean a(String str, String str2, b bVar) {
        boolean z;
        synchronized (g.class) {
            AppMethodBeat.i(93901);
            if ("invalid_map_id".equals(str2)) {
                ab.e("MicroMsg.AppBrandMapManager", "[createMapView]INVALID_MAP_ID");
                AppMethodBeat.o(93901);
                z = false;
            } else {
                HashMap hashMap = (HashMap) hOH.get(str);
                if (hashMap == null) {
                    hashMap = new HashMap();
                    hOH.put(str, hashMap);
                }
                if (hashMap.containsKey(str2)) {
                    ab.w("MicroMsg.AppBrandMapManager", "map is exist, return");
                    AppMethodBeat.o(93901);
                    z = false;
                } else {
                    hashMap.put(str2, bVar);
                    ab.i("MicroMsg.AppBrandMapManager", "initMapView appId:%s, mapId:%s", str, str2);
                    AppMethodBeat.o(93901);
                    z = true;
                }
            }
        }
        return z;
    }

    public static synchronized b cj(String str, String str2) {
        b bVar;
        synchronized (g.class) {
            AppMethodBeat.i(93902);
            if ("invalid_map_id".equals(str2)) {
                ab.e("MicroMsg.AppBrandMapManager", "[getMapView]INVALID_MAP_ID");
                AppMethodBeat.o(93902);
                bVar = null;
            } else {
                HashMap hashMap = (HashMap) hOH.get(str);
                if (hashMap == null) {
                    AppMethodBeat.o(93902);
                    bVar = null;
                } else {
                    bVar = (b) hashMap.get(str2);
                    AppMethodBeat.o(93902);
                }
            }
        }
        return bVar;
    }

    public static synchronized boolean ck(String str, String str2) {
        boolean z;
        synchronized (g.class) {
            AppMethodBeat.i(93903);
            HashMap hashMap = (HashMap) hOH.get(str);
            if (hashMap == null) {
                AppMethodBeat.o(93903);
                z = false;
            } else {
                b bVar = (b) hashMap.get(str2);
                if (bVar == null) {
                    ab.e("MicroMsg.AppBrandMapManager", "[destroyMapView] mapview not exist, err");
                    AppMethodBeat.o(93903);
                    z = false;
                } else {
                    ab.i("MicroMsg.AppBrandMapManager", "destoryMapView map:%s", bVar);
                    hashMap.remove(str2);
                    b(bVar);
                    if (hashMap.size() <= 0) {
                        hOH.remove(str);
                    }
                    bVar.onDestroy();
                    ab.i("MicroMsg.AppBrandMapManager", "[destroyMapView]appid:%s, map count:%d", str, Integer.valueOf(hashMap.size()));
                    AppMethodBeat.o(93903);
                    z = true;
                }
            }
        }
        return z;
    }
}
