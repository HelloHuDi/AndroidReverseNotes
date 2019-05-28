package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C40490t.C23347a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.d */
public final class C14976d implements C23347a {
    public static C14976d vup = null;
    public boolean hasInit = false;
    private SensorEventListener uGJ;
    private float[] vul = new float[3];
    int vum = -10000;
    int vun = -10000;
    private SensorManager vuo;

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.d$1 */
    class C149771 implements SensorEventListener {
        C149771() {
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.m2504i(79916);
            if (sensorEvent.sensor.getType() == 3) {
                C14976d.this.vul[0] = sensorEvent.values[0];
                C14976d.this.vul[1] = sensorEvent.values[1];
                C14976d.this.vul[2] = sensorEvent.values[2];
                if (C14976d.this.vum == -10000) {
                    C14976d.this.vum = (int) C14976d.this.vul[0];
                } else if (C14976d.this.vul[0] - ((float) C14976d.this.vum) > 300.0f || C14976d.this.vul[0] - ((float) C14976d.this.vum) < -300.0f) {
                    C14976d.this.vum = (int) C14976d.this.vul[0];
                } else {
                    C14976d.this.vum = (int) ((((double) C14976d.this.vum) * 0.6d) + (((double) C14976d.this.vul[0]) * 0.4d));
                }
                if (C14976d.this.vum == 0) {
                    C14976d.this.vum = 1;
                }
                if (C14976d.this.vum == 365) {
                    C14976d.this.vum = 364;
                }
                if (C14976d.this.vun == -10000) {
                    C14976d.this.vun = (int) C14976d.this.vul[1];
                    AppMethodBeat.m2505o(79916);
                    return;
                } else if (C14976d.this.vul[1] < -68.0f) {
                    int i = (int) (-68.0d + (((double) (C14976d.this.vul[1] + 68.0f)) / 1.5d));
                    if (i < -89) {
                        i = -89;
                    }
                    C14976d.this.vun = i;
                    AppMethodBeat.m2505o(79916);
                    return;
                } else if (C14976d.this.vul[1] > 89.0f) {
                    C14976d.this.vun = 89;
                    AppMethodBeat.m2505o(79916);
                    return;
                } else {
                    C14976d.this.vun = (int) ((((double) C14976d.this.vun) * 0.6d) + (((double) C14976d.this.vul[1]) * 0.4d));
                }
            }
            AppMethodBeat.m2505o(79916);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            AppMethodBeat.m2504i(79917);
            C4990ab.m7416i("MicroMsg.HeadingPitchSensorMgr", "onAccuracyChanged");
            AppMethodBeat.m2505o(79917);
        }
    }

    public C14976d() {
        AppMethodBeat.m2504i(79918);
        AppMethodBeat.m2505o(79918);
    }

    public final int dlp() {
        AppMethodBeat.m2504i(79919);
        C4990ab.m7410d("MicroMsg.HeadingPitchSensorMgr", "getHeading() " + this.vum);
        int i = this.vum;
        AppMethodBeat.m2505o(79919);
        return i;
    }

    public final int getPitch() {
        AppMethodBeat.m2504i(79920);
        C4990ab.m7410d("MicroMsg.HeadingPitchSensorMgr", "getPitch() " + this.vun);
        int i = this.vun;
        AppMethodBeat.m2505o(79920);
        return i;
    }

    /* renamed from: fQ */
    public final void mo27350fQ(Context context) {
        AppMethodBeat.m2504i(79921);
        C4990ab.m7410d("MicroMsg.HeadingPitchSensorMgr", "initSensor() ");
        if (context == null) {
            C4990ab.m7412e("MicroMsg.HeadingPitchSensorMgr", "initSensor() context == null");
            AppMethodBeat.m2505o(79921);
            return;
        }
        if (this.vuo == null) {
            this.vuo = (SensorManager) context.getSystemService("sensor");
        }
        if (this.uGJ == null) {
            this.uGJ = new C149771();
        }
        boolean registerListener = this.vuo.registerListener(this.uGJ, this.vuo.getDefaultSensor(3), 3);
        this.hasInit = true;
        C4990ab.m7411d("MicroMsg.HeadingPitchSensorMgr", "initSensor() finish, %s", Boolean.valueOf(registerListener));
        AppMethodBeat.m2505o(79921);
    }

    private void dlq() {
        AppMethodBeat.m2504i(79922);
        C4990ab.m7410d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
        if (!(this.vuo == null || this.uGJ == null)) {
            C4990ab.m7410d("MicroMsg.HeadingPitchSensorMgr", "releaseSensor");
            this.vuo.unregisterListener(this.uGJ);
            this.vuo = null;
            this.uGJ = null;
        }
        this.hasInit = false;
        AppMethodBeat.m2505o(79922);
    }

    public final String getName() {
        return "HeadingPitchSensorMgr";
    }

    public final void dbp() {
        AppMethodBeat.m2504i(79923);
        vup = null;
        dlq();
        AppMethodBeat.m2505o(79923);
    }

    /* renamed from: ft */
    public final void mo27351ft(Context context) {
        AppMethodBeat.m2504i(79924);
        mo27350fQ(context);
        AppMethodBeat.m2505o(79924);
    }

    public final void dbq() {
        AppMethodBeat.m2504i(79925);
        dlq();
        AppMethodBeat.m2505o(79925);
    }
}
