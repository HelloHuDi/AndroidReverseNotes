package com.tencent.p177mm.plugin.sport.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.sport.model.c */
public final class C43620c implements SensorEventListener {
    private long rPl = 0;
    private long rPm = 0;
    private boolean rPn;
    private Sensor sensor;
    private SensorManager sensorManager;

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(93652);
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            final long j = (long) sensorEvent.values[0];
            final long j2 = sensorEvent.timestamp;
            C4990ab.m7419v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", Long.valueOf(j), Long.valueOf(j2));
            if (Math.abs(j - this.rPl) >= 20 || System.currentTimeMillis() - this.rPm >= 60000) {
                C4990ab.m7417i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", Long.valueOf(j), Long.valueOf(j2));
                this.rPl = j;
                this.rPm = System.currentTimeMillis();
                C7305d.xDG.mo10151b(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(93651);
                        try {
                            C4996ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "Key_mmSensorChange", new String[]{String.valueOf(j), String.valueOf(j2)}, null);
                            AppMethodBeat.m2505o(93651);
                        } catch (Exception e) {
                            AppMethodBeat.m2505o(93651);
                        }
                    }
                }, "Sport.onSensorChange");
            }
            AppMethodBeat.m2505o(93652);
        } else if (sensorEvent == null || sensorEvent.values == null) {
            boolean z2;
            String str = "MicroMsg.Sport.MMSportStepDetector";
            String str2 = "[Willen][Step] SensorEvent Exception. event==null:%s , event.values==null:%s";
            Object[] objArr = new Object[2];
            if (sensorEvent == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (sensorEvent != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(93652);
        } else {
            C4990ab.m7413e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                float f = fArr[i2];
                r10 = new Object[2];
                int i3 = i + 1;
                r10[0] = Integer.valueOf(i);
                r10[1] = Float.valueOf(f);
                C4990ab.m7413e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i2++;
                i = i3;
            }
            AppMethodBeat.m2505o(93652);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public C43620c() {
        AppMethodBeat.m2504i(93653);
        boolean z = C22172n.m33799eU(C4996ah.getContext()) && C22172n.cvY();
        this.rPn = z;
        C4990ab.m7417i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", Boolean.valueOf(this.rPn));
        if (this.rPn) {
            cwl();
        }
        AppMethodBeat.m2505o(93653);
    }

    public final boolean cwj() {
        AppMethodBeat.m2504i(93654);
        boolean z = C22172n.m33799eU(C4996ah.getContext()) && C22172n.cvY();
        this.rPn = z;
        if (this.rPn) {
            cwk();
            boolean cwl = cwl();
            AppMethodBeat.m2505o(93654);
            return cwl;
        }
        cwk();
        AppMethodBeat.m2505o(93654);
        return false;
    }

    public final void cwk() {
        AppMethodBeat.m2504i(93655);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) C4996ah.getContext().getSystemService("sensor");
            }
            this.sensorManager.unregisterListener(this);
            C4990ab.m7416i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
            AppMethodBeat.m2505o(93655);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", e.getMessage());
            AppMethodBeat.m2505o(93655);
        }
    }

    private boolean cwl() {
        AppMethodBeat.m2504i(93656);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) C4996ah.getContext().getSystemService("sensor");
            }
            if (this.sensorManager == null || !C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                C4990ab.m7416i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
                AppMethodBeat.m2505o(93656);
                return false;
            }
            this.sensor = this.sensorManager.getDefaultSensor(19);
            if (this.sensor == null) {
                C4990ab.m7416i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
                AppMethodBeat.m2505o(93656);
                return false;
            }
            boolean registerListener = this.sensorManager.registerListener(this, this.sensor, C22168h.cwt().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                cwk();
            }
            C4990ab.m7417i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            AppMethodBeat.m2505o(93656);
            return registerListener;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", e.getMessage());
        }
    }
}
