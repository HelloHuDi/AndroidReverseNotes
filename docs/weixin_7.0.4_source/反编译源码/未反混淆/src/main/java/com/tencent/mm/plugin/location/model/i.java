package com.tencent.mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class i {
    private SensorManager bCW = ((SensorManager) ah.getContext().getSystemService("sensor"));
    private com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113318);
            if (z) {
                if (!(i.this.nJP == -1000.0d || i.this.nJQ == -1000.0d)) {
                    i.this.nJS = f.a(i.this.nJQ, i.this.nJP, (double) f, (double) f2, i, d);
                }
                i.this.nJP = (double) f2;
                i.this.nJQ = (double) f;
                if (i.this.nJO == 900.0d || i.this.nJN == 900.0d) {
                    i iVar = i.this;
                    i iVar2 = i.this;
                    double h = f.h((double) f2, (double) f);
                    iVar2.nJN = h;
                    iVar.nJO = h;
                } else {
                    i.this.nJO = i.this.nJN;
                    i.this.nJN = f.h((double) f2, (double) f);
                }
                ab.d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", Double.valueOf(i.this.nJN), Double.valueOf(i.this.nJO), Boolean.valueOf(i.this.nJS));
                AppMethodBeat.o(113318);
                return true;
            }
            AppMethodBeat.o(113318);
            return false;
        }
    };
    private d fwu;
    private b nJL = new b();
    HashSet<WeakReference<a>> nJM = new HashSet();
    double nJN = 900.0d;
    double nJO = 900.0d;
    double nJP = -1000.0d;
    double nJQ = -1000.0d;
    double nJR = 0.0d;
    boolean nJS = false;

    public interface a {
        void y(double d);
    }

    protected class b implements SensorEventListener {
        private float hOK = 0.0f;
        private long timestamp = 200;

        protected b() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i = 0;
            AppMethodBeat.i(113319);
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float f = sensorEvent.values[0];
                if (f > 0.0f) {
                    f %= 360.0f;
                } else {
                    f = (f + ((float) ((((((int) f) * -1) / v2helper.VOIP_ENC_HEIGHT_LV1) + 1) * v2helper.VOIP_ENC_HEIGHT_LV1))) % 360.0f;
                }
                if (currentTimeMillis > 200 && Math.abs(f - this.hOK) > 3.0f) {
                    i iVar = i.this;
                    float f2 = this.hOK;
                    iVar.nJR = (double) f;
                    String str = "MicroMsg.OrientationSensorMgr";
                    String str2 = "onOrientationChanged %f %f, mListenerList.size = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = Float.valueOf(f2);
                    objArr[1] = Float.valueOf(f);
                    if (iVar.nJM != null) {
                        i = iVar.nJM.size();
                    }
                    objArr[2] = Integer.valueOf(i);
                    ab.d(str, str2, objArr);
                    if (iVar.nJM != null) {
                        Iterator it = iVar.nJM.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((a) weakReference.get()).y(iVar.bJr());
                            }
                        }
                    }
                    this.hOK = f;
                    this.timestamp = System.currentTimeMillis();
                }
            }
            AppMethodBeat.o(113319);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public i() {
        AppMethodBeat.i(113320);
        AppMethodBeat.o(113320);
    }

    public final double bJr() {
        AppMethodBeat.i(113321);
        double d;
        if (this.nJS) {
            ab.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", Double.valueOf(this.nJN));
            d = this.nJN;
            AppMethodBeat.o(113321);
            return d;
        }
        ab.d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", Double.valueOf(this.nJR));
        d = this.nJR;
        AppMethodBeat.o(113321);
        return d;
    }

    private void bJs() {
        AppMethodBeat.i(113322);
        ab.i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.fwu == null) {
            this.fwu = d.agz();
        }
        this.fwu.b(this.ecy, true);
        this.bCW.registerListener(this.nJL, this.bCW.getDefaultSensor(3), 1);
        AppMethodBeat.o(113322);
    }

    /* Access modifiers changed, original: final */
    public final void bJt() {
        AppMethodBeat.i(113323);
        ab.i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.bCW.unregisterListener(this.nJL);
        d.agz().c(this.ecy);
        AppMethodBeat.o(113323);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(113324);
        Iterator it = this.nJM.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                AppMethodBeat.o(113324);
                return;
            }
        }
        this.nJM.add(new WeakReference(aVar));
        ab.i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", Integer.valueOf(this.nJM.size()));
        if (this.nJM.size() == 1) {
            bJs();
        }
        AppMethodBeat.o(113324);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(113325);
        if (this.nJM == null || aVar == null) {
            AppMethodBeat.o(113325);
            return;
        }
        Iterator it = this.nJM.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                this.nJM.remove(weakReference);
                break;
            }
        }
        ab.i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", Integer.valueOf(this.nJM.size()));
        if (this.nJM.size() == 0) {
            bJt();
        }
        AppMethodBeat.o(113325);
    }
}
