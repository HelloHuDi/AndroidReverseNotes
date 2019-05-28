package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";

    public static final class a extends ah {
        private static final int CTRL_INDEX = 95;
        private static final String NAME = "onCompassChange";
    }

    static abstract class b extends com.tencent.mm.plugin.appbrand.jsapi.p.l.a implements SensorEventListener {
        private float[] hVA = new float[3];
        private String hVB = "unknow";
        private int hVC = 0;
        a hVD = new a();
        private j hVu;
        private boolean hVy;
        private float[] hVz = new float[3];

        b(final com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
            this.hVD.j(cVar);
            this.hVu = new j((long) i.hVW.aEN(), new com.tencent.mm.plugin.appbrand.s.j.a() {
                public final boolean j(Object... objArr) {
                    AppMethodBeat.i(126373);
                    ab.v("MicroMsg.JsApiEnableCompass", "onAction.");
                    float[] fArr = new float[3];
                    float[] fArr2 = new float[9];
                    SensorManager.getRotationMatrix(fArr2, null, b.this.hVz, b.this.hVA);
                    SensorManager.getOrientation(fArr2, fArr);
                    HashMap hashMap = new HashMap();
                    float toDegrees = (float) Math.toDegrees((double) fArr[0]);
                    if (toDegrees < 0.0f) {
                        toDegrees += 360.0f;
                    }
                    hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(toDegrees));
                    if (b.this.hVB.equalsIgnoreCase("unknow")) {
                        hashMap.put("accuracy", b.this.hVB + "{value:" + b.this.hVC + "}");
                    } else {
                        hashMap.put("accuracy", b.this.hVB);
                    }
                    b.this.hVD.t(hashMap);
                    boolean a = a.hWd.a(b.this.hVD, cVar);
                    AppMethodBeat.o(126373);
                    return a;
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.hVy) {
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    ab.w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
                    return;
                }
                if (sensorEvent.sensor.getType() == 2) {
                    this.hVA = sensorEvent.values;
                    switch (sensorEvent.accuracy) {
                        case -1:
                            this.hVB = "no-contact";
                            break;
                        case 0:
                            this.hVB = "unreliable";
                            break;
                        case 1:
                            this.hVB = "low";
                            break;
                        case 2:
                            this.hVB = com.google.firebase.analytics.FirebaseAnalytics.b.MEDIUM;
                            break;
                        case 3:
                            this.hVB = "high";
                            break;
                        default:
                            this.hVB = "unknow";
                            this.hVC = sensorEvent.accuracy;
                            break;
                    }
                } else if (sensorEvent.sensor.getType() == 1) {
                    this.hVz = sensorEvent.values;
                } else {
                    return;
                }
                boolean l = this.hVu.l(new Object[0]);
                ab.v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", Boolean.valueOf(l));
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void aEP() {
            this.hVy = true;
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126374);
        final l lVar = new l();
        com.tencent.mm.plugin.appbrand.jsapi.file.f.a a = lVar.a(cVar, jSONObject, new b(cVar) {
            public final void onDestroy() {
                AppMethodBeat.i(126372);
                g.b(cVar.getAppId(), this);
                lVar.a(this);
                AppMethodBeat.o(126372);
            }
        }, "JsApi#SensorMagneticField" + cVar.hashCode(), new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1)})));
        cVar.M(i, j(a.aIm, a.values));
        AppMethodBeat.o(126374);
    }
}
