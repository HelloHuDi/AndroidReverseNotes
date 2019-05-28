package com.tencent.mm.plugin.sport.model;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c implements SensorEventListener {
    private long rPl = 0;
    private long rPm = 0;
    private boolean rPn;
    private Sensor sensor;
    private SensorManager sensorManager;

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z = false;
        AppMethodBeat.i(93652);
        if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            final long j = (long) sensorEvent.values[0];
            final long j2 = sensorEvent.timestamp;
            ab.v("MicroMsg.Sport.MMSportStepDetector", "onSensorChange %d %d", Long.valueOf(j), Long.valueOf(j2));
            if (Math.abs(j - this.rPl) >= 20 || System.currentTimeMillis() - this.rPm >= 60000) {
                ab.i("MicroMsg.Sport.MMSportStepDetector", "Step change %d, accuracy %s", Long.valueOf(j), Long.valueOf(j2));
                this.rPl = j;
                this.rPm = System.currentTimeMillis();
                d.xDG.b(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(93651);
                        try {
                            ah.getContext().getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.sport"), null, "Key_mmSensorChange", new String[]{String.valueOf(j), String.valueOf(j2)}, null);
                            AppMethodBeat.o(93651);
                        } catch (Exception e) {
                            AppMethodBeat.o(93651);
                        }
                    }
                }, "Sport.onSensorChange");
            }
            AppMethodBeat.o(93652);
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
            ab.e(str, str2, objArr);
            AppMethodBeat.o(93652);
        } else {
            ab.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
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
                ab.e("MicroMsg.Sport.MMSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i2++;
                i = i3;
            }
            AppMethodBeat.o(93652);
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public c() {
        AppMethodBeat.i(93653);
        boolean z = n.eU(ah.getContext()) && n.cvY();
        this.rPn = z;
        ab.i("MicroMsg.Sport.MMSportStepDetector", "isSupportDeviceStep %b", Boolean.valueOf(this.rPn));
        if (this.rPn) {
            cwl();
        }
        AppMethodBeat.o(93653);
    }

    public final boolean cwj() {
        AppMethodBeat.i(93654);
        boolean z = n.eU(ah.getContext()) && n.cvY();
        this.rPn = z;
        if (this.rPn) {
            cwk();
            boolean cwl = cwl();
            AppMethodBeat.o(93654);
            return cwl;
        }
        cwk();
        AppMethodBeat.o(93654);
        return false;
    }

    public final void cwk() {
        AppMethodBeat.i(93655);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) ah.getContext().getSystemService("sensor");
            }
            this.sensorManager.unregisterListener(this);
            ab.i("MicroMsg.Sport.MMSportStepDetector", "unregisterDetector() success!");
            AppMethodBeat.o(93655);
        } catch (Exception e) {
            ab.e("MicroMsg.Sport.MMSportStepDetector", "Exception in unregisterDetector %s", e.getMessage());
            AppMethodBeat.o(93655);
        }
    }

    private boolean cwl() {
        AppMethodBeat.i(93656);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) ah.getContext().getSystemService("sensor");
            }
            if (this.sensorManager == null || !ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                ab.i("MicroMsg.Sport.MMSportStepDetector", "no step sensor");
                AppMethodBeat.o(93656);
                return false;
            }
            this.sensor = this.sensorManager.getDefaultSensor(19);
            if (this.sensor == null) {
                ab.i("MicroMsg.Sport.MMSportStepDetector", " TYPE_STEP_COUNTER sensor null");
                AppMethodBeat.o(93656);
                return false;
            }
            boolean registerListener = this.sensorManager.registerListener(this, this.sensor, h.cwt().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                cwk();
            }
            ab.i("MicroMsg.Sport.MMSportStepDetector", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            AppMethodBeat.o(93656);
            return registerListener;
        } catch (Exception e) {
            ab.e("MicroMsg.Sport.MMSportStepDetector", "Exception in registerDetector %s", e.getMessage());
        }
    }
}
