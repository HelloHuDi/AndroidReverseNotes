package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.d */
public final class C27057d extends C10296a {
    public static final int CTRL_INDEX = 491;
    public static final String NAME = "enableDeviceMotionChangeListening";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.d$a */
    public static final class C10500a extends C42467ah {
        private static final int CTRL_INDEX = 490;
        private static final String NAME = "onDeviceMotionChange";
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.d$b */
    static abstract class C10501b extends C19468a implements SensorEventListener {
        C10500a hVG = new C10500a();
        private C42678j hVu;
        private boolean hVy;

        C10501b(final C2241c c2241c) {
            this.hVG.mo61032j(c2241c);
            this.hVu = new C42678j((long) C38367i.hVW.aEN(), new C42679a() {
                /* renamed from: j */
                public final boolean mo6217j(Object... objArr) {
                    AppMethodBeat.m2504i(126376);
                    float[] fArr = (float[]) objArr[0];
                    HashMap hashMap = new HashMap();
                    hashMap.put("alpha", Float.valueOf(fArr[0]));
                    hashMap.put("beta", Float.valueOf(fArr[1]));
                    hashMap.put("gamma", Float.valueOf(fArr[2]));
                    C10501b.this.hVG.mo34958t(hashMap);
                    boolean a = C38368a.hWd.mo68007a(C10501b.this.hVG, c2241c);
                    AppMethodBeat.m2505o(126376);
                    return a;
                }
            });
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (!this.hVy && sensorEvent.sensor.getType() == 3) {
                float[] fArr = sensorEvent.values;
                if (fArr == null || fArr.length < 3) {
                    C4990ab.m7420w("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
                    return;
                }
                boolean l = this.hVu.mo68088l(fArr);
                C4990ab.m7419v("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", Boolean.valueOf(l));
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
        AppMethodBeat.m2504i(126377);
        final C27064l c27064l = new C27064l();
        C10396a a = c27064l.mo44739a(c2241c, jSONObject, new C10501b(c2241c) {
            public final void onDestroy() {
                AppMethodBeat.m2504i(126375);
                C33183g.m54276b(c2241c.getAppId(), this);
                c27064l.mo44740a(this);
                AppMethodBeat.m2505o(126375);
            }
        }, "JsApi#SensorDeviceMotion" + c2241c.hashCode(), new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(3)})));
        c2241c.mo6107M(i, mo73394j(a.aIm, a.values));
        AppMethodBeat.m2505o(126377);
    }
}
