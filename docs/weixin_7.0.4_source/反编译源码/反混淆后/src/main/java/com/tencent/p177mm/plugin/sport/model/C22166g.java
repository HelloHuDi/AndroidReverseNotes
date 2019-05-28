package com.tencent.p177mm.plugin.sport.model;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p230g.p231a.C18335mw;
import com.tencent.p177mm.plugin.sport.p1302a.C39857a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Calendar;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sport.model.g */
public final class C22166g implements SensorEventListener {
    private static long rPA = 0;
    private static long rPB = 0;
    private static long rPC = 0;
    private static long rPD = 0;
    private static long rPw = 0;
    private static long rPx = 0;
    private static long rPy = 0;
    private static long rPz = 0;
    private C4884c<C18335mw> rPE = new C221671();
    private boolean rPn = false;
    private Sensor sensor;
    private SensorManager sensorManager;

    /* renamed from: com.tencent.mm.plugin.sport.model.g$1 */
    class C221671 extends C4884c<C18335mw> {
        C221671() {
            AppMethodBeat.m2504i(93666);
            this.xxI = C18335mw.class.getName().hashCode();
            AppMethodBeat.m2505o(93666);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(93667);
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "pushKeepAliveEvent %d", Long.valueOf((System.currentTimeMillis() - C22166g.rPB) / 60000));
            if (C22166g.this.rPn && C22166g.cwr()) {
                SportForegroundService.cwz();
            }
            AppMethodBeat.m2505o(93667);
            return false;
        }
    }

    public static long cwn() {
        return rPx;
    }

    public static long cwo() {
        return rPz;
    }

    public C22166g() {
        AppMethodBeat.m2504i(93668);
        if (C1443d.m3068iW(28)) {
            C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", "register push keep alive event");
            this.rPE.dnU();
        }
        boolean z = C22172n.m33799eU(C4996ah.getContext()) && C22172n.cwE();
        this.rPn = z;
        C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "isSupportDeviceStep %b", Boolean.valueOf(this.rPn));
        if (this.rPn) {
            cwl();
        }
        rPD = 0;
        try {
            if (C5730e.m8628ct(C39857a.rOX)) {
                C43622j c43622j = new C43622j(C39857a.rOX);
                rPz = c43622j.getLong(202, 0) * 10000;
                rPx = c43622j.getLong(201, 0);
                rPw = c43622j.getLong(203, 0);
                rPA = c43622j.getLong(204, 0);
                rPC = c43622j.getLong(209, 0);
                rPy = rPx;
                rPB = rPA;
                C43623k.m78064ZU(C22166g.cwp());
                C5730e.deleteFile(C39857a.rOX);
            } else {
                long[] jArr;
                String cwy = C43623k.cwy();
                C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "Read Info From Push Config %s", cwy);
                if (C5046bo.isNullOrNil(cwy)) {
                    jArr = new long[7];
                } else {
                    jArr = C22172n.m33797ZV(cwy);
                }
                rPz = jArr[0];
                rPA = jArr[1];
                rPB = jArr[2];
                rPC = jArr[3];
                rPw = jArr[4];
                rPx = jArr[5];
                rPy = jArr[6];
            }
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "Init PushSportStepDetector currentTodayStep: %d saveTodayBeginTime: %s", Long.valueOf(rPx), C22172n.m33800fQ(rPz));
            AppMethodBeat.m2505o(93668);
        } catch (Exception e) {
            rPz = 0;
            rPA = 0;
            rPB = 0;
            rPC = 0;
            rPw = 0;
            rPx = 0;
            rPy = 0;
            C4990ab.printErrStackTrace("MicroMsg.Sport.PushSportStepDetector", e, "PushSportStepDetector constructor", new Object[0]);
            AppMethodBeat.m2505o(93668);
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(93669);
        C4990ab.m7419v("MicroMsg.Sport.PushSportStepDetector", "onSensorChange %d %d", Long.valueOf((long) sensorEvent.values[0]), Long.valueOf(sensorEvent.timestamp));
        if (C4996ah.doI() && !SportForegroundService.cwB()) {
            C4990ab.m7418v("MicroMsg.Sport.PushSportStepDetector", "SportForegroundService Not Running");
            AppMethodBeat.m2505o(93669);
        } else if (sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0) {
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "Step change %f, accuracy %s, %s", Float.valueOf(sensorEvent.values[0]), Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
            mo37726b((long) sensorEvent.values[0], sensorEvent.timestamp, "PUSH");
            AppMethodBeat.m2505o(93669);
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
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(93669);
        } else {
            C4990ab.m7413e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception accuracy: %d, timestamp: %s", Integer.valueOf(sensorEvent.accuracy), Long.valueOf(sensorEvent.timestamp));
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
                C4990ab.m7413e("MicroMsg.Sport.PushSportStepDetector", "[Willen][Step] SensorEvent Exception event[%d]: %f", r10);
                i++;
                i2 = i3;
            }
            AppMethodBeat.m2505o(93669);
        }
    }

    /* renamed from: b */
    public final void mo37726b(long j, long j2, String str) {
        AppMethodBeat.m2504i(93670);
        JSONObject cwt = C22168h.cwt();
        if (cwt.optInt("deviceStepSwitch") != 1) {
            cwk();
            C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", "device step switch off");
            AppMethodBeat.m2505o(93670);
            return;
        }
        int optInt = cwt.optInt("stepCounterMaxStep5m", AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        long cwC = C22172n.cwC();
        if (j < 0) {
            AppMethodBeat.m2505o(93670);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (rPz != cwC) {
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "new day beginOfToday: %s saveTodayBeginTime: %s, ", C22172n.m33800fQ(cwC), C22172n.m33800fQ(rPz));
            rPw = j;
            rPx = 0;
            rPy = 0;
            rPz = cwC;
            rPA = currentTimeMillis;
            rPB = currentTimeMillis;
            rPC = j2;
            C43623k.m78064ZU(C22166g.cwp());
            AppMethodBeat.m2505o(93670);
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
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "reboot %d %s lastSaveStepTime %d", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()), C22172n.m33800fQ(System.currentTimeMillis() - SystemClock.elapsedRealtime()), Long.valueOf(rPA));
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
                C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "invalid currentSensorStep %d preSensorStep %d lastSaveSensorStep %d", Long.valueOf(j), Long.valueOf(rPw), Long.valueOf(rPy));
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
        C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "%s increase step %s %d %b %d todayStep:%d %d", str, obj2, Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(rPD), Long.valueOf(rPx), Long.valueOf(rPy));
        rPx += j3;
        rPD += j3;
        if (currentTimeMillis - rPA > ((long) cwt.optInt("stepCounterSaveInterval", 60000)) || j - rPy > ((long) cwt.optInt("stepCounterSaveStep")) || z) {
            rPA = currentTimeMillis;
            rPy = j;
            rPw = j;
            rPB = currentTimeMillis;
            rPC = j2;
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "save to [file] detailInfo %s", C22166g.cwp());
            C43623k.m78064ZU(r2);
            if (rPD >= 500) {
                C22166g.cwq();
                rPD = 0;
            }
            AppMethodBeat.m2505o(93670);
            return;
        }
        rPw = j;
        rPB = currentTimeMillis;
        rPC = j2;
        AppMethodBeat.m2505o(93670);
    }

    private static String cwp() {
        AppMethodBeat.m2504i(93671);
        String format = String.format("%d,%d,%d,%d,%d,%d,%d", new Object[]{Long.valueOf(rPz), Long.valueOf(rPA), Long.valueOf(rPB), Long.valueOf(rPC), Long.valueOf(rPw), Long.valueOf(rPx), Long.valueOf(rPy)});
        AppMethodBeat.m2505o(93671);
        return format;
    }

    private static void cwq() {
        AppMethodBeat.m2504i(93672);
        C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", "notifyUploadStep");
        Intent intent = new Intent();
        intent.setPackage(C4996ah.getContext().getPackageName());
        intent.setAction("com.tencent.mm.plugin.sport.uploadstep");
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(93672);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    private boolean cwl() {
        AppMethodBeat.m2504i(93673);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) C4996ah.getContext().getSystemService("sensor");
            }
            if (this.sensorManager == null || !C4996ah.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", "no step sensor");
                AppMethodBeat.m2505o(93673);
                return false;
            }
            this.sensor = this.sensorManager.getDefaultSensor(19);
            if (this.sensor == null) {
                C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", " TYPE_STEP_COUNTER sensor null");
                AppMethodBeat.m2505o(93673);
                return false;
            }
            boolean registerListener = this.sensorManager.registerListener(this, this.sensor, C22168h.cwt().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                cwk();
            }
            C4990ab.m7417i("MicroMsg.Sport.PushSportStepDetector", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            AppMethodBeat.m2505o(93673);
            return registerListener;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Sport.PushSportStepDetector", "Exception in registerDetector %s", e.getMessage());
        }
    }

    private void cwk() {
        AppMethodBeat.m2504i(93674);
        try {
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) C4996ah.getContext().getSystemService("sensor");
            }
            this.sensorManager.unregisterListener(this);
            C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", "unregisterDetector() success!");
            AppMethodBeat.m2505o(93674);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Sport.PushSportStepDetector", "Exception in unregisterDetector %s", e.getMessage());
            AppMethodBeat.m2505o(93674);
        }
    }

    public final boolean cwj() {
        AppMethodBeat.m2504i(93675);
        boolean z = C22172n.m33799eU(C4996ah.getContext()) && C22172n.cwE();
        this.rPn = z;
        if (this.rPn) {
            cwk();
            boolean cwl = cwl();
            AppMethodBeat.m2505o(93675);
            return cwl;
        }
        cwk();
        AppMethodBeat.m2505o(93675);
        return false;
    }

    static /* synthetic */ boolean cwr() {
        AppMethodBeat.m2504i(93676);
        if (((PowerManager) C4996ah.getContext().getSystemService("power")).isScreenOn()) {
            C4990ab.m7416i("MicroMsg.Sport.PushSportStepDetector", "Screen On");
        } else {
            Calendar instance = Calendar.getInstance();
            if (instance.get(11) == 21) {
                if (instance.getTimeInMillis() - rPB > 900000) {
                    AppMethodBeat.m2505o(93676);
                    return true;
                }
                AppMethodBeat.m2505o(93676);
                return false;
            } else if (instance.getTimeInMillis() - rPB > 1800000) {
                AppMethodBeat.m2505o(93676);
                return true;
            }
        }
        AppMethodBeat.m2505o(93676);
        return false;
    }
}
