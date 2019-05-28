package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class l {
    private SensorManager bCW;
    private Handler mHandler = new Handler(m.aNS().oAl.getLooper());

    public static abstract class a extends c implements SensorEventListener {
        a() {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void aEP() {
        }
    }

    public l() {
        AppMethodBeat.i(126402);
        AppMethodBeat.o(126402);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.jsapi.file.f.a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, a aVar, String str, List<Integer> list) {
        AppMethodBeat.i(126403);
        boolean optBoolean = jSONObject.optBoolean("enable");
        int optInt = jSONObject.optInt("interval", 200);
        if (this.bCW == null) {
            this.bCW = (SensorManager) ah.getContext().getSystemService("sensor");
        }
        com.tencent.mm.plugin.appbrand.jsapi.file.f.a aVar2;
        if (this.bCW == null) {
            ab.i("MicroMsg.UnitSensor", "getSystemService(SENSOR_SERVICE) failed.");
            aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a("fail:null system service", new Object[0]);
            AppMethodBeat.o(126403);
            return aVar2;
        }
        Sensor defaultSensor;
        ArrayList<Sensor> arrayList = new ArrayList();
        for (Integer intValue : list) {
            defaultSensor = this.bCW.getDefaultSensor(intValue.intValue());
            if (defaultSensor == null) {
                ab.i("MicroMsg.UnitSensor", "get sensor failed.");
                aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a("fail:null sensor", new Object[0]);
                AppMethodBeat.o(126403);
                return aVar2;
            }
            arrayList.add(defaultSensor);
        }
        b y;
        if (optBoolean) {
            b nU = v.Zp().nU(str);
            if (nU == null) {
                y = v.Zp().y(str, true);
            } else {
                y = nU;
            }
            if (((a) y.get("sensor_event_listener", null)) != null) {
                ab.w("MicroMsg.UnitSensor", "register failed, sensorEventListener has already registered.");
                aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a("fail, has enable, should stop pre operation", new Object[0]);
                AppMethodBeat.o(126403);
                return aVar2;
            }
            String str2;
            com.tencent.mm.plugin.appbrand.jsapi.file.f.a aVar3;
            g.a(cVar.getAppId(), (c) aVar);
            y.j("sensor_event_listener", aVar);
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
                z = sensorManager.registerListener(aVar, defaultSensor2, i, this.mHandler);
                if (!z) {
                    if (!z) {
                        this.bCW.unregisterListener(aVar);
                        aVar.aEP();
                        g.b(cVar.getAppId(), aVar);
                        y.recycle();
                        v.Zp().nV(str);
                    }
                    ab.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", str, Boolean.valueOf(z));
                    if (z) {
                        str2 = "fail:system error";
                    } else {
                        str2 = "ok";
                    }
                    aVar3 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a(str2, new Object[0]);
                    AppMethodBeat.o(126403);
                    return aVar3;
                }
            }
            if (z) {
            }
            ab.i("MicroMsg.UnitSensor", "register sensor finished(s : %s, r : %s).", str, Boolean.valueOf(z));
            if (z) {
            }
            aVar3 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a(str2, new Object[0]);
            AppMethodBeat.o(126403);
            return aVar3;
        }
        y = v.Zp().nV(str);
        if (y == null) {
            ab.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, keyValueSet do not exist.");
            aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a("fail:fail to disable, not enable?", new Object[0]);
            AppMethodBeat.o(126403);
            return aVar2;
        }
        a aVar4 = (a) y.get("sensor_event_listener", null);
        if (aVar4 == null) {
            ab.i("MicroMsg.UnitSensor", "unregister sensor event listener failed, listener do not exist.");
            aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a("fail:fail to disable, not enable?", new Object[0]);
            AppMethodBeat.o(126403);
            return aVar2;
        }
        this.bCW.unregisterListener(aVar4);
        g.b(cVar.getAppId(), aVar4);
        aVar4.aEP();
        y.recycle();
        ab.i("MicroMsg.UnitSensor", "unregister sensor finished(%s).", str);
        aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.file.f.a("ok", new Object[0]);
        AppMethodBeat.o(126403);
        return aVar2;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(126404);
        this.bCW.unregisterListener(aVar);
        AppMethodBeat.o(126404);
    }
}
