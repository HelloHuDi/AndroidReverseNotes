package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27064l.C19468a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C42563k.C38368a;
import com.tencent.p177mm.plugin.appbrand.p329s.C42678j;
import com.tencent.p177mm.plugin.appbrand.p329s.C42678j.C42679a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.c */
public final class C38366c extends C10296a {
    public static final int CTRL_INDEX = 94;
    public static final String NAME = "enableCompass";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.c$a */
    public static final class C2332a extends C42467ah {
        private static final int CTRL_INDEX = 95;
        private static final String NAME = "onCompassChange";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.c$b */
    static abstract class C2333b extends C19468a implements SensorEventListener {
        private float[] hVA = new float[3];
        private String hVB = "unknow";
        private int hVC = 0;
        C2332a hVD = new C2332a();
        private C42678j hVu;
        private boolean hVy;
        private float[] hVz = new float[3];

        C2333b(final C2241c c2241c) {
            this.hVD.mo61032j(c2241c);
            this.hVu = new C42678j((long) C38367i.hVW.aEN(), new C42679a() {
                /* renamed from: j */
                public final boolean mo6217j(Object... objArr) {
                    AppMethodBeat.m2504i(126373);
                    C4990ab.m7418v("MicroMsg.JsApiEnableCompass", "onAction.");
                    float[] fArr = new float[3];
                    float[] fArr2 = new float[9];
                    SensorManager.getRotationMatrix(fArr2, null, C2333b.this.hVz, C2333b.this.hVA);
                    SensorManager.getOrientation(fArr2, fArr);
                    HashMap hashMap = new HashMap();
                    float toDegrees = (float) Math.toDegrees((double) fArr[0]);
                    if (toDegrees < 0.0f) {
                        toDegrees += 360.0f;
                    }
                    hashMap.put(TencentLocation.EXTRA_DIRECTION, Float.valueOf(toDegrees));
                    if (C2333b.this.hVB.equalsIgnoreCase("unknow")) {
                        hashMap.put("accuracy", C2333b.this.hVB + "{value:" + C2333b.this.hVC + "}");
                    } else {
                        hashMap.put("accuracy", C2333b.this.hVB);
                    }
                    C2333b.this.hVD.mo34958t(hashMap);
                    boolean a = C38368a.hWd.mo68007a(C2333b.this.hVD, c2241c);
                    AppMethodBeat.m2505o(126373);
                    return a;
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.hVy) {
                if (sensorEvent.values == null || sensorEvent.values.length < 3) {
                    C4990ab.m7420w("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
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
                            this.hVB = C8741b.MEDIUM;
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
                boolean l = this.hVu.mo68088l(new Object[0]);
                C4990ab.m7419v("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", Boolean.valueOf(l));
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public final void aEP() {
            this.hVy = true;
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126374);
        final C27064l c27064l = new C27064l();
        C10396a a = c27064l.mo44739a(c2241c, jSONObject, new C2333b(c2241c) {
            public final void onDestroy() {
                AppMethodBeat.m2504i(126372);
                C33183g.m54276b(c2241c.getAppId(), this);
                c27064l.mo44740a(this);
                AppMethodBeat.m2505o(126372);
            }
        }, "JsApi#SensorMagneticField" + c2241c.hashCode(), new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1)})));
        c2241c.mo6107M(i, mo73394j(a.aIm, a.values));
        AppMethodBeat.m2505o(126374);
    }
}
