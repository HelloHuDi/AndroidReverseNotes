package com.tencent.p177mm.plugin.location.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.location.model.i */
public final class C28360i {
    private SensorManager bCW = ((SensorManager) C4996ah.getContext().getSystemService("sensor"));
    private C42206a ecy = new C211711();
    private C26443d fwu;
    private C28362b nJL = new C28362b();
    HashSet<WeakReference<C28361a>> nJM = new HashSet();
    double nJN = 900.0d;
    double nJO = 900.0d;
    double nJP = -1000.0d;
    double nJQ = -1000.0d;
    double nJR = 0.0d;
    boolean nJS = false;

    /* renamed from: com.tencent.mm.plugin.location.model.i$1 */
    class C211711 implements C42206a {
        C211711() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113318);
            if (z) {
                if (!(C28360i.this.nJP == -1000.0d || C28360i.this.nJQ == -1000.0d)) {
                    C28360i.this.nJS = C28358f.m44995a(C28360i.this.nJQ, C28360i.this.nJP, (double) f, (double) f2, i, d);
                }
                C28360i.this.nJP = (double) f2;
                C28360i.this.nJQ = (double) f;
                if (C28360i.this.nJO == 900.0d || C28360i.this.nJN == 900.0d) {
                    C28360i c28360i = C28360i.this;
                    C28360i c28360i2 = C28360i.this;
                    double h = C28358f.m44996h((double) f2, (double) f);
                    c28360i2.nJN = h;
                    c28360i.nJO = h;
                } else {
                    C28360i.this.nJO = C28360i.this.nJN;
                    C28360i.this.nJN = C28358f.m44996h((double) f2, (double) f);
                }
                C4990ab.m7411d("MicroMsg.OrientationSensorMgr", "onGetLocation, update headding, mCurrentHeading = %f, mPreviousHeading = %f mIsMove = %b", Double.valueOf(C28360i.this.nJN), Double.valueOf(C28360i.this.nJO), Boolean.valueOf(C28360i.this.nJS));
                AppMethodBeat.m2505o(113318);
                return true;
            }
            AppMethodBeat.m2505o(113318);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.i$a */
    public interface C28361a {
        /* renamed from: y */
        void mo24250y(double d);
    }

    /* renamed from: com.tencent.mm.plugin.location.model.i$b */
    protected class C28362b implements SensorEventListener {
        private float hOK = 0.0f;
        private long timestamp = 200;

        protected C28362b() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            int i = 0;
            AppMethodBeat.m2504i(113319);
            if (sensorEvent.sensor.getType() == 3) {
                long currentTimeMillis = System.currentTimeMillis() - this.timestamp;
                float f = sensorEvent.values[0];
                if (f > 0.0f) {
                    f %= 360.0f;
                } else {
                    f = (f + ((float) ((((((int) f) * -1) / v2helper.VOIP_ENC_HEIGHT_LV1) + 1) * v2helper.VOIP_ENC_HEIGHT_LV1))) % 360.0f;
                }
                if (currentTimeMillis > 200 && Math.abs(f - this.hOK) > 3.0f) {
                    C28360i c28360i = C28360i.this;
                    float f2 = this.hOK;
                    c28360i.nJR = (double) f;
                    String str = "MicroMsg.OrientationSensorMgr";
                    String str2 = "onOrientationChanged %f %f, mListenerList.size = %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = Float.valueOf(f2);
                    objArr[1] = Float.valueOf(f);
                    if (c28360i.nJM != null) {
                        i = c28360i.nJM.size();
                    }
                    objArr[2] = Integer.valueOf(i);
                    C4990ab.m7411d(str, str2, objArr);
                    if (c28360i.nJM != null) {
                        Iterator it = c28360i.nJM.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((C28361a) weakReference.get()).mo24250y(c28360i.bJr());
                            }
                        }
                    }
                    this.hOK = f;
                    this.timestamp = System.currentTimeMillis();
                }
            }
            AppMethodBeat.m2505o(113319);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public C28360i() {
        AppMethodBeat.m2504i(113320);
        AppMethodBeat.m2505o(113320);
    }

    public final double bJr() {
        AppMethodBeat.m2504i(113321);
        double d;
        if (this.nJS) {
            C4990ab.m7411d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = true, result = %f", Double.valueOf(this.nJN));
            d = this.nJN;
            AppMethodBeat.m2505o(113321);
            return d;
        }
        C4990ab.m7411d("MicroMsg.OrientationSensorMgr", "getHeading, mIsMove = false, result = %f", Double.valueOf(this.nJR));
        d = this.nJR;
        AppMethodBeat.m2505o(113321);
        return d;
    }

    private void bJs() {
        AppMethodBeat.m2504i(113322);
        C4990ab.m7416i("MicroMsg.OrientationSensorMgr", "registerSensor ");
        if (this.fwu == null) {
            this.fwu = C26443d.agz();
        }
        this.fwu.mo44207b(this.ecy, true);
        this.bCW.registerListener(this.nJL, this.bCW.getDefaultSensor(3), 1);
        AppMethodBeat.m2505o(113322);
    }

    /* Access modifiers changed, original: final */
    public final void bJt() {
        AppMethodBeat.m2504i(113323);
        C4990ab.m7416i("MicroMsg.OrientationSensorMgr", "unregisterSensor ");
        this.bCW.unregisterListener(this.nJL);
        C26443d.agz().mo44208c(this.ecy);
        AppMethodBeat.m2505o(113323);
    }

    /* renamed from: a */
    public final void mo46315a(C28361a c28361a) {
        AppMethodBeat.m2504i(113324);
        Iterator it = this.nJM.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C28361a) weakReference.get()).equals(c28361a)) {
                AppMethodBeat.m2505o(113324);
                return;
            }
        }
        this.nJM.add(new WeakReference(c28361a));
        C4990ab.m7417i("MicroMsg.OrientationSensorMgr", "registerSensorListener %d", Integer.valueOf(this.nJM.size()));
        if (this.nJM.size() == 1) {
            bJs();
        }
        AppMethodBeat.m2505o(113324);
    }

    /* renamed from: b */
    public final void mo46316b(C28361a c28361a) {
        AppMethodBeat.m2504i(113325);
        if (this.nJM == null || c28361a == null) {
            AppMethodBeat.m2505o(113325);
            return;
        }
        Iterator it = this.nJM.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((C28361a) weakReference.get()).equals(c28361a)) {
                this.nJM.remove(weakReference);
                break;
            }
        }
        C4990ab.m7417i("MicroMsg.OrientationSensorMgr", "unregisterSensorListener %d", Integer.valueOf(this.nJM.size()));
        if (this.nJM.size() == 0) {
            bJt();
        }
        AppMethodBeat.m2505o(113325);
    }
}
