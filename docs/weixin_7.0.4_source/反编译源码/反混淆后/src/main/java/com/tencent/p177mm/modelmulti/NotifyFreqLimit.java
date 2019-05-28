package com.tencent.p177mm.modelmulti;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.modelmulti.NotifyFreqLimit */
public class NotifyFreqLimit extends BroadcastReceiver {
    private static long beginTime = 0;
    private static byte[] eMl = new byte[0];
    private static C18662a fIM = null;
    private static C37943l fIN = null;
    private static int fIO = 0;
    private static long[] fIP = null;
    private static LinkedList<Object> fIQ = new LinkedList();
    private static int fIR = 0;
    private static Boolean fIS = null;
    private static Boolean fIT = null;
    private static long fIU = 0;
    private static PendingIntent fIV = null;

    /* renamed from: com.tencent.mm.modelmulti.NotifyFreqLimit$a */
    public interface C18662a {
    }

    static {
        AppMethodBeat.m2504i(16504);
        AppMethodBeat.m2505o(16504);
    }

    /* JADX WARNING: Missing block: B:43:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(16503);
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(16503);
        try {
            synchronized (eMl) {
                String nullAsNil;
                if (intent != null) {
                    if ("com.tencent.mm.NotifyFreqLimit.AlarmReceiver".equals(intent.getAction())) {
                        long anU = C5046bo.anU() - intent.getLongExtra("hashCode", 0);
                        int intExtra = intent.getIntExtra("pid", 0);
                        long longExtra = intent.getLongExtra("delaySecond", 0) * 1000;
                        int myPid = Process.myPid();
                        long id = Thread.currentThread().getId();
                        C4990ab.m7417i("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                        if (fIV == null) {
                            C7060h.pYm.mo8378a(99, 156, 1, false);
                            C4990ab.m7413e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: SENDER NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                            AppMethodBeat.m2505o(16503);
                            return;
                        }
                        fIV = null;
                        if (myPid != intExtra) {
                            C7060h.pYm.mo8378a(99, 159, 1, false);
                            C4990ab.m7413e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: DIFF PID alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                            AppMethodBeat.m2505o(16503);
                            return;
                        }
                        if (5 * longExtra < anU || 180000 + longExtra < anU) {
                            C4990ab.m7413e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: ALARM DELAY TOO MUCH alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                            fIT = Boolean.FALSE;
                            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("NOTIFY_FREQ_LIMIT_INFO", 0);
                            nullAsNil = C5046bo.nullAsNil(sharedPreferences.getString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", ""));
                            Editor edit = sharedPreferences.edit();
                            edit.putString("NOTIFY_FREQ_LIMIT_CLOSE_BY_ALARM_FAILED_KEY", C5046bo.anU() + "," + nullAsNil);
                            edit.commit();
                            if (C5046bo.isNullOrNil(nullAsNil)) {
                                C7060h.pYm.mo8381e(11098, Integer.valueOf(3103));
                            }
                            C4990ab.m7417i("MicroMsg.NotifyFreqLimit", "setAlarmFailed end isAlarmCanUse:%s shared_pref:%s", fIT, nullAsNil);
                        }
                        if (fIM == null) {
                            C7060h.pYm.mo8378a(99, 157, 1, false);
                            C4990ab.m7413e("MicroMsg.NotifyFreqLimit", "AlarmReceiver(%s) onReceive ERR: FUNC NULL alarmPid:%s my[%s:%s] timediff:%s delay:%s sender:%s func:%s", Long.valueOf(r12), Integer.valueOf(intExtra), Integer.valueOf(myPid), Long.valueOf(id), Long.valueOf(anU), Long.valueOf(longExtra), fIV, fIM);
                        }
                    }
                }
                String str = "MicroMsg.NotifyFreqLimit";
                nullAsNil = "AlarmReceiver onReceive intent:%s";
                Object[] objArr = new Object[1];
                objArr[0] = intent == null ? "intent is null" : intent.getAction();
                C4990ab.m7413e(str, nullAsNil, objArr);
                AppMethodBeat.m2505o(16503);
            }
        } catch (Throwable th) {
            fIV = null;
            C7060h.pYm.mo8378a(99, 151, 1, false);
            C4990ab.m7413e("MicroMsg.NotifyFreqLimit", "AlarmReceiver onReceive e:%s", C5046bo.m7574l(th));
            AppMethodBeat.m2505o(16503);
        }
    }
}
