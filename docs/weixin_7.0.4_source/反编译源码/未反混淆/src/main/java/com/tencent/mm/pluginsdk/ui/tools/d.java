package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.t.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class d implements a {
    public static d vup = null;
    public boolean hasInit = false;
    private SensorEventListener uGJ;
    private float[] vul = new float[3];
    int vum = -10000;
    int vun = -10000;
    private SensorManager vuo;

    public d() {
        AppMethodBeat.i(79918);
        AppMethodBeat.o(79918);
    }

    public final int dlp() {
        AppMethodBeat.i(79919);
        ab.d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.vum);
        int i = this.vum;
        AppMethodBeat.o(79919);
        return i;
    }

    public final int getPitch() {
        AppMethodBeat.i(79920);
        ab.d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.vun);
        int i = this.vun;
        AppMethodBeat.o(79920);
        return i;
    }

    public final void fQ(Context context) {
        AppMethodBeat.i(79921);
        ab.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            ab.e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            AppMethodBeat.o(79921);
            return;
        }
        if (this.vuo == null) {
            this.vuo = (SensorManager) context.getSystemService("sensor");
        }
        if (this.uGJ == null) {
            this.uGJ = new SensorEventListener() {
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    AppMethodBeat.i(79916);
                    if (sensorEvent.sensor.getType() == 3) {
                        d.this.vul[0] = sensorEvent.values[0];
                        d.this.vul[1] = sensorEvent.values[1];
                        d.this.vul[2] = sensorEvent.values[2];
                        if (d.this.vum == -10000) {
                            d.this.vum = (int) d.this.vul[0];
                        } else if (d.this.vul[0] - ((float) d.this.vum) > 300.0f || d.this.vul[0] - ((float) d.this.vum) < -300.0f) {
                            d.this.vum = (int) d.this.vul[0];
                        } else {
                            d.this.vum = (int) ((((double) d.this.vum) * 0.6d) + (((double) d.this.vul[0]) * 0.4d));
                        }
                        if (d.this.vum == 0) {
                            d.this.vum = 1;
                        }
                        if (d.this.vum == 365) {
                            d.this.vum = 364;
                        }
                        if (d.this.vun == -10000) {
                            d.this.vun = (int) d.this.vul[1];
                            AppMethodBeat.o(79916);
                            return;
                        } else if (d.this.vul[1] < -68.0f) {
                            int i = (int) (-68.0d + (((double) (d.this.vul[1] + 68.0f)) / 1.5d));
                            if (i < -89) {
                                i = -89;
                            }
                            d.this.vun = i;
                            AppMethodBeat.o(79916);
                            return;
                        } else if (d.this.vul[1] > 89.0f) {
                            d.this.vun = 89;
                            AppMethodBeat.o(79916);
                            return;
                        } else {
                            d.this.vun = (int) ((((double) d.this.vun) * 0.6d) + (((double) d.this.vul[1]) * 0.4d));
                        }
                    }
                    AppMethodBeat.o(79916);
                }

                public final void onAccuracyChanged(Sensor sensor, int i) {
                    AppMethodBeat.i(79917);
                    ab.i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
                    AppMethodBeat.o(79917);
                }
            };
        }
        boolean registerListener = this.vuo.registerListener(this.uGJ, this.vuo.getDefaultSensor(3), 3);
        this.hasInit = true;
        ab.d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", Boolean.valueOf(registerListener));
        AppMethodBeat.o(79921);
    }

    private void dlq() {
        AppMethodBeat.i(79922);
        ab.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.vuo == null || this.uGJ == null)) {
            ab.d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.vuo.unregisterListener(this.uGJ);
            this.vuo = null;
            this.uGJ = null;
        }
        this.hasInit = false;
        AppMethodBeat.o(79922);
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void dbp() {
        AppMethodBeat.i(79923);
        vup = null;
        dlq();
        AppMethodBeat.o(79923);
    }

    public final void ft(Context context) {
        AppMethodBeat.i(79924);
        fQ(context);
        AppMethodBeat.o(79924);
    }

    public final void dbq() {
        AppMethodBeat.i(79925);
        dlq();
        AppMethodBeat.o(79925);
    }
}
