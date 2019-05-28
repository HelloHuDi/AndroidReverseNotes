package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.file.C19377f.C10396a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.l */
public final class C27064l {
    private SensorManager bCW;
    private Handler mHandler = new Handler(C45673m.aNS().oAl.getLooper());

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.l$a */
    public static abstract class C19468a extends C33186c implements SensorEventListener {
        C19468a() {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void aEP() {
        }
    }

    public C27064l() {
        AppMethodBeat.m2504i(126402);
        AppMethodBeat.m2505o(126402);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C10396a mo44739a(C2241c c2241c, JSONObject jSONObject, C19468a c19468a, String str, List<Integer> list) {
        AppMethodBeat.m2504i(126403);
        boolean optBoolean = jSONObject.optBoolean("enable");
        int optInt = jSONObject.optInt("interval", 200);
        if (this.bCW == null) {
            this.bCW = (SensorManager) C4996ah.getContext().getSystemService("sensor");
        }
        C10396a c10396a;
        if (this.bCW == null) {
            C4990ab.m7416i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
            c10396a = new C10396a("fail:null system service", new Object[0]);
            AppMethodBeat.m2505o(126403);
            return c10396a;
        }
        Sensor defaultSensor;
        ArrayList<Sensor> arrayList = new ArrayList();
        for (Integer intValue : list) {
            defaultSensor = this.bCW.getDefaultSensor(intValue.intValue());
            if (defaultSensor == null) {
                C4990ab.m7416i("MicroMsg.UnitSensor", "get sensor failed.");
                c10396a = new C10396a("fail:null sensor", new Object[0]);
                AppMethodBeat.m2505o(126403);
                return c10396a;
            }
            arrayList.add(defaultSensor);
        }
        C32800b y;
        if (optBoolean) {
            C32800b nU = C37922v.m64076Zp().mo60673nU(str);
            if (nU == null) {
                y = C37922v.m64076Zp().mo60676y(str, true);
            } else {
                y = nU;
            }
            if (((C19468a) y.get("sensor_event_listener", null)) != null) {
                C4990ab.m7420w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
                c10396a = new C10396a("fail, has enable, should stop pre operation", new Object[0]);
                AppMethodBeat.m2505o(126403);
                return c10396a;
            }
            String str2;
            C10396a c10396a2;
            C33183g.m54274a(c2241c.getAppId(), (C33186c) c19468a);
            y.mo53356j("sensor_event_listener", c19468a);
            boolean z = false;
            for (Sensor defaultSensor2 : arrayList) {
                int i;
                SensorManager sensorManager = this.bCW;
                switch (optInt) {
                    case 0:
                        i = 0;
                        break;
                    case 20:
                        i = 1;
                        break;
                    case 60:
                        i = 2;
                        break;
                    case 200:
                        i = 3;
                        break;
                    default:
                        i = 3;
                        break;
                }
                z = sensorManager.registerListener(c19468a, defaultSensor2, i, this.mHandler);
                if (!z) {
                    if (!z) {
                        this.bCW.unregisterListener(c19468a);
                        c19468a.aEP();
                        C33183g.m54276b(c2241c.getAppId(), c19468a);
                        y.recycle();
                        C37922v.m64076Zp().mo60674nV(str);
                    }
                    C4990ab.m7417i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", str, Boolean.valueOf(z));
                    if (z) {
                        str2 = "fail:system error";
                    } else {
                        str2 = "ok";
                    }
                    c10396a2 = new C10396a(str2, new Object[0]);
                    AppMethodBeat.m2505o(126403);
                    return c10396a2;
                }
            }
            if (z) {
            }
            C4990ab.m7417i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", str, Boolean.valueOf(z));
            if (z) {
            }
            c10396a2 = new C10396a(str2, new Object[0]);
            AppMethodBeat.m2505o(126403);
            return c10396a2;
        }
        y = C37922v.m64076Zp().mo60674nV(str);
        if (y == null) {
            C4990ab.m7416i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
            c10396a = new C10396a("fail:fail to disable, not enable?", new Object[0]);
            AppMethodBeat.m2505o(126403);
            return c10396a;
        }
        C19468a c19468a2 = (C19468a) y.get("sensor_event_listener", null);
        if (c19468a2 == null) {
            C4990ab.m7416i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
            c10396a = new C10396a("fail:fail to disable, not enable?", new Object[0]);
            AppMethodBeat.m2505o(126403);
            return c10396a;
        }
        this.bCW.unregisterListener(c19468a2);
        C33183g.m54276b(c2241c.getAppId(), c19468a2);
        c19468a2.aEP();
        y.recycle();
        C4990ab.m7417i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", str);
        c10396a = new C10396a("ok", new Object[0]);
        AppMethodBeat.m2505o(126403);
        return c10396a;
    }

    /* renamed from: a */
    public final void mo44740a(C19468a c19468a) {
        AppMethodBeat.m2504i(126404);
        this.bCW.unregisterListener(c19468a);
        AppMethodBeat.m2505o(126404);
    }
}
