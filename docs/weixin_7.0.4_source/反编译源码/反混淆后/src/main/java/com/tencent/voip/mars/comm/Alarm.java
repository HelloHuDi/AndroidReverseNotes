package com.tencent.voip.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.voip.mars.xlog.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Alarm extends BroadcastReceiver {
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final String TAG = "MicroMsg.Alarm";
    private static TreeSet<Object[]> alarm_waiting_set = new TreeSet(new ComparatorAlarm());
    private static Alarm bc_alarm = null;
    private static WakerLock wakerlock = null;

    static class ComparatorAlarm implements Comparator<Object[]> {
        private ComparatorAlarm() {
        }

        public int compare(Object[] objArr, Object[] objArr2) {
            AppMethodBeat.m2504i(92739);
            int longValue = (int) (((Long) objArr[TSetData.ID.ordinal()]).longValue() - ((Long) objArr2[TSetData.ID.ordinal()]).longValue());
            AppMethodBeat.m2505o(92739);
            return longValue;
        }
    }

    enum TSetData {
        ID,
        WAITTIME,
        PENDINGINTENT;

        static {
            AppMethodBeat.m2505o(92743);
        }
    }

    private native void onAlarm(long j);

    static {
        AppMethodBeat.m2504i(92763);
        AppMethodBeat.m2505o(92763);
    }

    public static void resetAlarm(Context context) {
        AppMethodBeat.m2504i(92757);
        synchronized (alarm_waiting_set) {
            try {
                Iterator it = alarm_waiting_set.iterator();
                while (it.hasNext()) {
                    cancelAlarmMgr(context, (PendingIntent) ((Object[]) it.next())[TSetData.PENDINGINTENT.ordinal()]);
                }
                alarm_waiting_set.clear();
                if (bc_alarm != null) {
                    context.unregisterReceiver(bc_alarm);
                    bc_alarm = null;
                }
            } finally {
                AppMethodBeat.m2505o(92757);
            }
        }
    }

    public static boolean start(long j, int i, Context context) {
        AppMethodBeat.m2504i(92758);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i < 0) {
            Log.m25194e(TAG, "id:%d, after:%d", Long.valueOf(j), Integer.valueOf(i));
            AppMethodBeat.m2505o(92758);
            return false;
        } else if (context == null) {
            Log.m25194e(TAG, "null==context, id:%d, after:%d", Long.valueOf(j), Integer.valueOf(i));
            AppMethodBeat.m2505o(92758);
            return false;
        } else {
            synchronized (alarm_waiting_set) {
                try {
                    if (wakerlock == null) {
                        wakerlock = new WakerLock(context);
                        Log.m25197i(TAG, "start new wakerlock");
                    }
                    if (bc_alarm == null) {
                        bc_alarm = new Alarm();
                        context.registerReceiver(bc_alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
                    }
                    Iterator it = alarm_waiting_set.iterator();
                    while (it.hasNext()) {
                        if (((Long) ((Object[]) it.next())[TSetData.ID.ordinal()]).longValue() == j) {
                            Log.m25194e(TAG, "id exist=%d", Long.valueOf(j));
                        }
                    }
                    if (i >= 0) {
                        elapsedRealtime += (long) i;
                    }
                    if (setAlarmMgr(j, elapsedRealtime, context) == null) {
                        AppMethodBeat.m2505o(92758);
                        return false;
                    }
                    alarm_waiting_set.add(new Object[]{Long.valueOf(j), Long.valueOf(elapsedRealtime), r0});
                    AppMethodBeat.m2505o(92758);
                    return true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(92758);
                }
            }
        }
        return false;
    }

    public static boolean stop(long j, Context context) {
        AppMethodBeat.m2504i(92759);
        if (context == null) {
            Log.m25193e(TAG, "context==null");
            AppMethodBeat.m2505o(92759);
            return false;
        }
        synchronized (alarm_waiting_set) {
            try {
                if (wakerlock == null) {
                    wakerlock = new WakerLock(context);
                    Log.m25197i(TAG, "stop new wakerlock");
                }
                if (bc_alarm == null) {
                    bc_alarm = new Alarm();
                    context.registerReceiver(bc_alarm, new IntentFilter());
                    Log.m25197i(TAG, "stop new Alarm");
                }
                Iterator it = alarm_waiting_set.iterator();
                while (it.hasNext()) {
                    Object[] objArr = (Object[]) it.next();
                    if (((Long) objArr[TSetData.ID.ordinal()]).longValue() == j) {
                        cancelAlarmMgr(context, (PendingIntent) objArr[TSetData.PENDINGINTENT.ordinal()]);
                        it.remove();
                    }
                }
                AppMethodBeat.m2505o(92759);
                return false;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(92759);
            }
        }
        return true;
    }

    private static PendingIntent setAlarmMgr(long j, long j2, Context context) {
        AppMethodBeat.m2504i(92760);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.m25193e(TAG, "am == null");
            AppMethodBeat.m2505o(92760);
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
        intent.putExtra(KEXTRA_ID, j);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, (int) j, intent, 268435456);
        if (VERSION.SDK_INT < 19) {
            alarmManager.set(2, j2, broadcast);
        } else {
            alarmManager.setExact(2, j2, broadcast);
        }
        AppMethodBeat.m2505o(92760);
        return broadcast;
    }

    private static boolean cancelAlarmMgr(Context context, PendingIntent pendingIntent) {
        AppMethodBeat.m2504i(92761);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.m25193e(TAG, "am == null");
            AppMethodBeat.m2505o(92761);
            return false;
        } else if (pendingIntent == null) {
            Log.m25193e(TAG, "pendingIntent == null");
            AppMethodBeat.m2505o(92761);
            return false;
        } else {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
            AppMethodBeat.m2505o(92761);
            return true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(92762);
        if (context == null || intent == null) {
            AppMethodBeat.m2505o(92762);
            return;
        }
        Long valueOf = Long.valueOf(intent.getLongExtra(KEXTRA_ID, 0));
        Integer valueOf2 = Integer.valueOf(intent.getIntExtra(KEXTRA_PID, 0));
        if (0 == valueOf.longValue() || valueOf2.intValue() == 0) {
            AppMethodBeat.m2505o(92762);
        } else if (valueOf2.intValue() != Process.myPid()) {
            Log.m25202w(TAG, "onReceive id:%d, pid:%d, mypid:%d", valueOf, valueOf2, Integer.valueOf(Process.myPid()));
            AppMethodBeat.m2505o(92762);
        } else {
            Object obj;
            synchronized (alarm_waiting_set) {
                try {
                    Iterator it = alarm_waiting_set.iterator();
                    while (it.hasNext()) {
                        Log.m25198i(TAG, "onReceive id=%d, curId=%d", valueOf, (Long) ((Object[]) it.next())[TSetData.ID.ordinal()]);
                        if (((Long) ((Object[]) it.next())[TSetData.ID.ordinal()]).equals(valueOf)) {
                            Log.m25198i(TAG, "onReceive find alarm id:%d, pid:%d, delta miss time:%d", valueOf, valueOf2, Long.valueOf(SystemClock.elapsedRealtime() - ((Long) r2[TSetData.WAITTIME.ordinal()]).longValue()));
                            it.remove();
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        Log.m25194e(TAG, "onReceive not found id:%d, pid:%d, alarm_waiting_set.size:%d", valueOf, valueOf2, Integer.valueOf(alarm_waiting_set.size()));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92762);
                    }
                }
            }
            if (wakerlock != null) {
                wakerlock.lock(200);
            }
            if (obj != null) {
                onAlarm(valueOf.longValue());
            }
            AppMethodBeat.m2505o(92762);
        }
    }
}
