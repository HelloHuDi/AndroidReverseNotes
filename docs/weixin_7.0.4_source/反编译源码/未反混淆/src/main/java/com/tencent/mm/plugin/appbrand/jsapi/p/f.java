package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 488;
    public static final String NAME = "enableGyroscope";

    static abstract class b extends com.tencent.mm.plugin.appbrand.jsapi.p.l.a implements SensorEventListener {
        a hVP = new a();
        private j hVu;
        private boolean hVy;

        b(final c cVar) {
            this.hVP.j(cVar);
            this.hVu = new j((long) i.hVW.aEN(), new com.tencent.mm.plugin.appbrand.s.j.a() {
                public final boolean j(Object... objArr) {
                    AppMethodBeat.i(126383);
                    float[] fArr = (float[]) objArr[0];
                    HashMap hashMap = new HashMap();
                    hashMap.put(VideoMaterialUtil.CRAZYFACE_X, Float.valueOf(fArr[0]));
                    hashMap.put(VideoMaterialUtil.CRAZYFACE_Y, Float.valueOf(fArr[1]));
                    hashMap.put("z", Float.valueOf(fArr[2]));
                    b.this.hVP.t(hashMap);
                    boolean a = a.hWd.a(b.this.hVP, cVar);
                    AppMethodBeat.o(126383);
                    return a;
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.hVy && sensorEvent.sensor.getType() == 4) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    ab.w("MicroMsg.JsApiEnableGyroscope", "deviceMotion sensor callback data invalidate.");
                    return;
                }
                boolean l = this.hVu.l(fArr);
                ab.v("MicroMsg.JsApiEnableGyroscope", "try to do frequency limit action(%s).", Boolean.valueOf(l));
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void aEP() {
            this.hVy = true;
        }
    }

    public static final class a extends ah {
        private static final int CTRL_INDEX = 489;
        private static final String NAME = "onGyroscopeChange";
    }

    public final void a(final c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126384);
        final l lVar = new l();
        com.tencent.mm.plugin.appbrand.jsapi.file.f.a a = lVar.a(cVar, jSONObject, new b(cVar) {
            public final void onDestroy() {
                AppMethodBeat.i(126382);
                g.b(cVar.getAppId(), this);
                lVar.a(this);
                AppMethodBeat.o(126382);
            }
        }, "JsApi#SensorGyroscope" + cVar.hashCode(), new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        cVar.M(i, j(a.aIm, a.values));
        AppMethodBeat.o(126384);
    }
}
