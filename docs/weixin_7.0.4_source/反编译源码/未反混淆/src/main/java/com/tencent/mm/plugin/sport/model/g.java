package com.tencent.mm.plugin.sport.model;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Calendar;
import org.json.JSONObject;

public final class g implements SensorEventListener {
    private static long rPA = 0;
    private static long rPB = 0;
    private static long rPC = 0;
    private static long rPD = 0;
    private static long rPw = 0;
    private static long rPx = 0;
    private static long rPy = 0;
    private static long rPz = 0;
    private c<mw> rPE = new c<mw>() {
        {
            AppMethodBeat.i(93666);
            this.xxI = mw.class.getName().hashCode();
            AppMethodBeat.o(93666);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(93667);
            ab.i("MicroMsg.Sport.PushSportStepDetector", "pushKeepAliveEvent %d", Long.valueOf((System.currentTimeMillis() - g.rPB) / 60000));
            if (g.this.rPn && g.cwr()) {
                SportForegroundService.cwz();
            }
            AppMethodBeat.o(93667);
            return false;
        }
    };
    private boolean rPn = false;
    private Sensor sensor;
    private SensorManager sensorManager;

    public static long cwn() {
        return rPx;
    }

    public static long cwo() {
        return rPz;
    }

    public g() {
        AppMethodBeat.i(93668);
        if (d.iW(28)) {
            ab.i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
            this.rPE.dnU();
        }
        boolean z = n.eU(ah.getContext()) && n.cwE();
        this.rPn = z;
        ab.i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", Boolean.valueOf(this.rPn));
        if (this.rPn) {
            cwl();
        }
        rPD = 0;
        try {
            if (e.ct(a.rOX)) {
                j jVar = new j(a.rOX);
                rPz = jVar.getLong(202, 0) * 10000;
                rPx = jVar.getLong(201, 0);
                rPw = jVar.getLong(203, 0);
                rPA = jVar.getLong(204, 0);
                rPC = jVar.getLong(209, 0);
                rPy = rPx;
                rPB = rPA;
                k.ZU(cwp());
                e.deleteFile(a.rOX);
            } else {
                long[] jArr;
                String cwy = k.cwy();
                ab.i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", cwy);
                if (bo.isNullOrNil(cwy)) {
                    jArr = new long[7];
                } else {
                    jArr = n.ZV(cwy);
                }
                rPz = jArr[0];
                rPA = jArr[1];
                rPB = jArr[2];
                rPC = jArr[3];
                rPw = jArr[4];
                rPx = jArr[5];
                rPy = jArr[6];
            }
            ab.i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", Long.valueOf(rPx), n.fQ(rPz));
            AppMethodBeat.o(93668);
        } catch (Exception e) {
            rPz = 0;
            rPA = 0;
            rPB = 0;
            rPC = 0;
            rPw = 0;
            rPx = 0;
            rPy = 0;
            ab.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", e, "PushSportStepDetector constructor", new Object[0]);
            AppMethodBeat.o(93668);
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z = false;
        AppMethodBeat.i(93669);
        ab.v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", Long.valueOf((long) sensorEvent.values[0]), Long.valueOf(sensorEvent.timestamp));
        if (ah.doI() && !SportForegroundService.cwB()) {
            ab.v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
            AppMethodBeat.o(93669);
        } else if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            ab.i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            b((long) sensorEvent.values[0], sensorEvent.timestamp, "PUSH");
            AppMethodBeat.o(93669);
        } else if (sensorEvent == null || sensorEvent.values == null) {
            boolean z2;
            String str = "MicroMsg.Sport.PushSportStepDetector";
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
            AppMethodBeat.o(93669);
        } else {
            ab.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            float[] fArr = sensorEvent.values;
            int length = fArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                float f = fArr[i];
                r10 = new Object[2];
                int i3 = i2 + 1;
                r10[0] = Integer.valueOf(i2);
                r10[1] = Float.valueOf(f);
                ab.e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i++;
                i2 = i3;
            }
            AppMethodBeat.o(93669);
        }
    }

    public final void b(long j, long j2, String str) {
        AppMethodBeat.i(93670);
        JSONObject cwt = h.cwt();
        if (cwt.optInt("deviceStepSwitch") != 1) {
            cwk();
            ab.i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
            AppMethodBeat.o(93670);
            return;
        }
        int optInt = cwt.optInt("stepCounterMaxStep5m", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        long cwC = n.cwC();
        if (j < 0) {
            AppMethodBeat.o(93670);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (rPz != cwC) {
            ab.i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", n.fQ(cwC), n.fQ(rPz));
            rPw = j;
            rPx = 0;
            rPy = 0;
            rPz = cwC;
            rPA = currentTimeMillis;
            rPB = currentTimeMillis;
            rPC = j2;
            k.ZU(cwp());
            AppMethodBeat.o(93670);
            return;
        }
        Object obj;
        boolean z;
        long j3 = 0;
        long j4 = ((currentTimeMillis - rPB) / 300000) + ((long) ((currentTimeMillis - rPB) % 300000 > 0 ? 1 : 0));
        long j5 = (((j2 / 1000000) - (rPC / 1000000)) / 300000) + ((long) (((j2 / 1000000) - (rPC / 1000000)) % 300000 > 0 ? 1 : 0));
        boolean z2 = false;
        String str2 = "";
        if (System.currentTimeMillis() - SystemClock.elapsedRealtime() > rPA) {
            ab.i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), n.fQ(System.currentTimeMillis() - SystemClock.elapsedRealtime()), Long.valueOf(rPA));
            long j6 = j - rPy;
            if (j6 <= 0 || (j6 >= ((long) optInt) * j5 && j6 >= ((long) optInt) * j4)) {
                cwC = 0;
            } else {
                str2 = "rebootIncrease Valid Step diffStep > 0";
                cwC = j6;
            }
            if (j6 < 0 && (j < ((long) optInt) * j5 || j < ((long) optInt) * j4)) {
                str2 = "rebootIncrease Valid Step diffStep < 0";
                cwC = j;
            }
            j3 = cwC;
            obj = str2;
            z = true;
        } else {
            if (j < rPw) {
                ab.i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", Long.valueOf(j), Long.valueOf(rPw), Long.valueOf(rPy));
                rPw = j;
                rPy = j;
                z2 = true;
            }
            String obj2;
            if (j - rPw < j5 * ((long) optInt) || j - rPw < j4 * ((long) optInt)) {
                j3 = j - rPw;
                obj2 = "normalIncrease Valid Step";
                z = z2;
            } else {
                obj2 = str2;
                z = z2;
            }
        }
        ab.i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", str, obj2, Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(rPD), Long.valueOf(rPx), Long.valueOf(rPy));
        rPx += j3;
        rPD += j3;
        if (currentTimeMillis - rPA > ((long) cwt.optInt("stepCounterSaveInterval", 60000)) || j - rPy > ((long) cwt.optInt("stepCounterSaveStep")) || z) {
            rPA = currentTimeMillis;
            rPy = j;
            rPw = j;
            rPB = currentTimeMillis;
            rPC = j2;
            ab.i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", cwp());
            k.ZU(r2);
            if (rPD >= 500) {
                cwq();
                rPD = 0;
            }
            AppMethodBeat.o(93670);
            return;
        }
        rPw = j;
        rPB = currentTimeMillis;
        rPC = j2;
        AppMethodBeat.o(93670);
    }

    private static String cwp() {
        AppMethodBeat.i(93671);
        String format = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[]{Long.valueOf(rPz), Long.valueOf(rPA), Long.valueOf(rPB), Long.valueOf(rPC), Long.valueOf(rPw), Long.valueOf(rPx), Long.valueOf(rPy)});
        AppMethodBeat.o(93671);
        return format;
    }

    private static void cwq() {
        AppMethodBeat.i(93672);
        ab.i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
        Intent intent = new Intent();
        intent.setPackage(ah.getContext().getPackageName());
        intent.setAction("com.tencent.mm.plugin.sport.uploadstep");
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(93672);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean cwl() {
        AppMethodBeat.i(93673);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) ah.getContext().getSystemService("sensor");
            }
            if (this.sensorManager == null || !ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                ab.i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
                AppMethodBeat.o(93673);
                return false;
            }
            this.sensor = this.sensorManager.getDefaultSensor(19);
            if (this.sensor == null) {
                ab.i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
                AppMethodBeat.o(93673);
                return false;
            }
            boolean registerListener = this.sensorManager.registerListener(this, this.sensor, h.cwt().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                cwk();
            }
            ab.i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            AppMethodBeat.o(93673);
            return registerListener;
        } catch (Exception e) {
            ab.e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", e.getMessage());
        }
    }

    private void cwk() {
        AppMethodBeat.i(93674);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) ah.getContext().getSystemService("sensor");
            }
            this.sensorManager.unregisterListener(this);
            ab.i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
            AppMethodBeat.o(93674);
        } catch (Exception e) {
            ab.e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", e.getMessage());
            AppMethodBeat.o(93674);
        }
    }

    public final boolean cwj() {
        AppMethodBeat.i(93675);
        boolean z = n.eU(ah.getContext()) && n.cwE();
        this.rPn = z;
        if (this.rPn) {
            cwk();
            boolean cwl = cwl();
            AppMethodBeat.o(93675);
            return cwl;
        }
        cwk();
        AppMethodBeat.o(93675);
        return false;
    }

    static /* synthetic */ boolean cwr() {
        AppMethodBeat.i(93676);
        if (((PowerManager) ah.getContext().getSystemService("power")).isScreenOn()) {
            ab.i("MicroMsg.Sport.PushSportStepDetector", "Screen On");
        } else {
            Calendar instance = Calendar.getInstance();
            if (instance.get(11) == 21) {
                if (instance.getTimeInMillis() - rPB > 900000) {
                    AppMethodBeat.o(93676);
                    return true;
                }
                AppMethodBeat.o(93676);
                return false;
            } else if (instance.getTimeInMillis() - rPB > 1800000) {
                AppMethodBeat.o(93676);
                return true;
            }
        }
        AppMethodBeat.o(93676);
        return false;
    }
}
