package com.tencent.mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class NotifyFreqLimit extends BroadcastReceiver {
    private static long beginTime = 0;
    private static byte[] eMl = new byte[0];
    private static a fIM = null;
    private static l fIN = null;
    private static int fIO = 0;
    private static long[] fIP = null;
    private static LinkedList<Object> fIQ = new LinkedList();
    private static int fIR = 0;
    private static Boolean fIS = null;
    private static Boolean fIT = null;
    private static long fIU = 0;
    private static PendingIntent fIV = null;

    public interface a {
    }

    static {
        AppMethodBeat.i(16504);
        AppMethodBeat.o(16504);
    }

    /* JADX WARNING: Missing block: B:43:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(16503);
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(16503);
        try {
            synchronized (eMl) {
                String nullAsNil;
                if (intent != null) {
                    if ("com.tencent.mm.NotifyFreqLimit.AlarmReceiver".equals(intent.getAction())) {
                        long anU = bo.anU() - intent.getLongExtra("hashCode", 0);
                        int intExtra = intent.getIntExtra("pid", 0);
                        long longExtra = intent.getLongExtra("delaySecond", 0) * 1000;
                        int myPid = Process.myPid();
                        long id = Thread.currentThread().getId();
                        ab.i("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                        if (fIV == null) {
                            h.pYm.a(99, 156, 1, false);
                            ab.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: SENDER NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                            AppMethodBeat.o(16503);
                            return;
                        }
                        fIV = null;
                        if (myPid != intExtra) {
                            h.pYm.a(99, 159, 1, false);
                            ab.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: DIFF PID alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                            AppMethodBeat.o(16503);
                            return;
                        }
                        if (5 * longExtra < anU || 180000 + longExtra < anU) {
                            ab.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: ALARM DELAY TOO MUCH alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                            fIT = Boolean.FALSE;
                            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("NOTIFY_FREQ_LIMIT_INFO", 0);
                            nullAsNil = bo.nullAsNil(sharedPreferences.getString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", ""));
                            Editor edit = sharedPreferences.edit();
                            edit.putString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", bo.anU() + "," + nullAsNil);
                            edit.commit();
                            if (bo.isNullOrNil(nullAsNil)) {
                                h.pYm.e(11098, Integer.valueOf(3103));
                            }
                            ab.i("MicroMsg.NotifyFreqLimit", "setAlarmFailed end isAlarmCanUse:%s shared_pref:%s", fIT, nullAsNil);
                        }
                        if (fIM == null) {
                            h.pYm.a(99, 157, 1, false);
                            ab.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: FUNC NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                        }
                    }
                }
                String str = "MicroMsg.NotifyFreqLimit";
                nullAsNil = "AlarmReceiver onReceive intent:%s";
                Object[] objArr = new Object[1];
                objArr[0] = intent == null ? "intent is null" : intent.getAction();
                ab.e(str, nullAsNil, objArr);
                AppMethodBeat.o(16503);
            }
        } catch (Throwable th) {
            fIV = null;
            h.pYm.a(99, 151, 1, false);
            ab.e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive e:%s", bo.l(th));
            AppMethodBeat.o(16503);
        }
    }
}
