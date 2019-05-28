package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SensorController extends BroadcastReceiver implements SensorEventListener {
    private static float xBA = 4.2949673E9f;
    private static float xBC = 0.5f;
    public static boolean xBI = false;
    public static double xBJ = -1.0d;
    public boolean aGA = false;
    private Context context;
    private float qYv = -1.0f;
    private SensorManager sensorManager;
    private float xBB;
    private a xBD;
    private Sensor xBE;
    private final boolean xBF;
    private boolean xBG = false;
    private float xBH = -1.0f;

    public interface a {
        void he(boolean z);
    }

    public SensorController(Context context) {
        AppMethodBeat.i(52265);
        if (context == null) {
            this.xBF = false;
            AppMethodBeat.o(52265);
            return;
        }
        boolean z;
        this.context = context;
        this.sensorManager = (SensorManager) context.getSystemService("sensor");
        this.xBE = this.sensorManager.getDefaultSensor(8);
        if (this.xBE != null) {
            this.qYv = Math.min(10.0f, this.xBE.getMaximumRange());
        }
        if (this.qYv < 0.0f) {
            ab.e("MicroMsg.SensorController", "error, getMaximumRange return %s, set to 1", Float.valueOf(this.qYv));
            this.qYv = 1.0f;
        }
        if (this.xBE != null) {
            z = true;
        } else {
            z = false;
        }
        this.xBF = z;
        this.xBB = xBC + 1.0f;
        AppMethodBeat.o(52265);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(52266);
        ab.i("MicroMsg.SensorController", "sensor callback set, isRegistered:" + this.aGA + ", proximitySensor: " + this.xBE + ", maxValue: " + this.qYv);
        if (!this.aGA) {
            this.xBH = -1.0f;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.context.registerReceiver(this, intentFilter);
            this.sensorManager.registerListener(this, this.xBE, 2);
            this.aGA = true;
        }
        this.xBD = aVar;
        AppMethodBeat.o(52266);
    }

    public final void dps() {
        AppMethodBeat.i(52267);
        ab.i("MicroMsg.SensorController", "sensor callback removed");
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception e) {
            ab.v("MicroMsg.SensorController", "sensor receiver has already unregistered");
        }
        this.sensorManager.unregisterListener(this, this.xBE);
        this.sensorManager.unregisterListener(this);
        this.aGA = false;
        this.xBD = null;
        this.xBH = -1.0f;
        AppMethodBeat.o(52267);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(52268);
        if (sensorEvent == null || sensorEvent.sensor == null || this.xBE == null) {
            AppMethodBeat.o(52268);
        } else if (this.xBG) {
            AppMethodBeat.o(52268);
        } else {
            float f = sensorEvent.values[0];
            double d = 3.0d;
            ab.i("MicroMsg.SensorController", "newValue: %s, maxValue: %s, divideRatio: %s, configNearFarDivideRatio: %s, lastValue: %s, maxRange: %s", Float.valueOf(f), Float.valueOf(this.qYv), Double.valueOf(3.0d), Double.valueOf(xBJ), Float.valueOf(this.xBH), Float.valueOf(this.xBE.getMaximumRange()));
            if (xBJ > 0.0d) {
                d = xBJ;
            }
            float maximumRange = (xBJ > 0.0d || this.qYv < 0.0f) ? this.xBE.getMaximumRange() : this.qYv;
            ab.i("MicroMsg.SensorController", "onSensorChanged, near threshold: %s, max: %s", Float.valueOf(Math.max(0.1f, (float) (((double) maximumRange) / d))), Float.valueOf(maximumRange));
            switch (sensorEvent.sensor.getType()) {
                case 8:
                    if (this.xBD != null) {
                        if (f != this.xBH) {
                            if (f < r0) {
                                ab.i("MicroMsg.SensorController", "sensor near-far event near false");
                                this.xBD.he(false);
                            } else {
                                ab.i("MicroMsg.SensorController", "sensor near-far event far true");
                                this.xBD.he(true);
                            }
                            this.xBH = f;
                            break;
                        }
                        AppMethodBeat.o(52268);
                        return;
                    }
                    AppMethodBeat.o(52268);
                    return;
            }
            AppMethodBeat.o(52268);
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(52269);
        if (intent == null) {
            AppMethodBeat.o(52269);
            return;
        }
        String action = intent.getAction();
        if (action != null && action.equals("android.intent.action.HEADSET_PLUG")) {
            int intExtra = intent.getIntExtra("state", 0);
            if (intExtra == 1) {
                this.xBG = true;
            }
            if (intExtra == 0) {
                this.xBG = false;
            }
        }
        AppMethodBeat.o(52269);
    }
}
