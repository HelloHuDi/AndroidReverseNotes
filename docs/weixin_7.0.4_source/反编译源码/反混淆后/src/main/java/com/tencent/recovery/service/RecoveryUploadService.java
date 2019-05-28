package com.tencent.recovery.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.recovery.log.RecoveryFileLog;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class RecoveryUploadService extends IntentService {
    private static final String TAG = "Recovery.RecoveryUploadService";

    public RecoveryUploadService() {
        super(RecoveryUploadService.class.getName());
    }

    public static synchronized void startAlarm(Context context, String str) {
        synchronized (RecoveryUploadService.class) {
            if (!Util.isNullOrNil(str)) {
                CommonOptions iz = OptionFactory.m8722iz(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences("recovery-info", 0);
                long j = sharedPreferences.getLong("KeyLastUploadTime", 0);
                long currentTimeMillis = System.currentTimeMillis();
                RecoveryLog.m8712i(TAG, "startAlarm %s lastUploadTime %s", str, Util.m8738nz(j));
                Intent intent = new Intent();
                intent.setClassName(context, str);
                intent.putExtra("KeyReportUploadClassName", str);
                PendingIntent service = PendingIntent.getService(context, 1000001, intent, 536870912);
                if (service == null || currentTimeMillis - j > iz.Arr) {
                    if (service != null) {
                        service.cancel();
                        RecoveryLog.m8712i(TAG, "startAlarm cancel preIntent", new Object[0]);
                    }
                    sharedPreferences.edit().putLong("KeyLastUploadTime", currentTimeMillis).commit();
                    try {
                        ((AlarmManager) context.getSystemService("alarm")).set(0, (iz.Arr + currentTimeMillis) - FaceGestureDetGLThread.BRIGHTNESS_DURATION, PendingIntent.getService(context, 1000001, intent, 134217728));
                    } catch (Exception e) {
                        RecoveryLog.printErrStackTrace(TAG, e, "alarmManager.setAlarm", new Object[0]);
                    }
                    RecoveryLog.m8712i(TAG, "startAlarm pendingIntent success: %d will report %s", Integer.valueOf(r2.hashCode()), Util.m8738nz(j));
                } else {
                    RecoveryLog.m8712i(TAG, "already set alarm", new Object[0]);
                }
            }
        }
    }

    public static void cancelAlarm(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context, str);
        intent.putExtra("KeyReportUploadClassName", str);
        PendingIntent service = PendingIntent.getService(context, 1000001, intent, 536870912);
        if (service != null) {
            service.cancel();
        }
    }

    public static void startAlarmAfter(Context context, String str, long j) {
        if (!Util.isNullOrNil(str)) {
            RecoveryLog.m8712i(TAG, "startAlarmAfter %s %d", str, Long.valueOf(j));
            Intent intent = new Intent();
            intent.setClassName(context, str);
            intent.putExtra("KeyReportUploadClassName", str);
            PendingIntent service = PendingIntent.getService(context, 1000001, intent, 536870912);
            if (service != null) {
                service.cancel();
            }
            try {
                ((AlarmManager) context.getSystemService("alarm")).set(0, (System.currentTimeMillis() + j) - FaceGestureDetGLThread.BRIGHTNESS_DURATION, PendingIntent.getService(context, 1000001, intent, 134217728));
            } catch (Exception e) {
                RecoveryLog.printErrStackTrace(TAG, e, "alarmManager.setAlarm", new Object[0]);
            }
            RecoveryLog.m8712i(TAG, "startAlarmAfter pendingIntent:%d %s", Integer.valueOf(service.hashCode()), Util.m8738nz(r2));
        }
    }

    /* Access modifiers changed, original: protected */
    public void onHandleIntent(Intent intent) {
        RecoveryLog.m8712i(TAG, "RecoveryUploadReceiver.onHandleIntent", new Object[0]);
        boolean tryToUploadData = tryToUploadData();
        String stringExtra = intent.getStringExtra("KeyReportUploadClassName");
        if (Util.isNullOrNil(stringExtra)) {
            stringExtra = getClass().getName();
        }
        cancelAlarm(this, stringExtra);
        if (!tryToUploadData) {
            startAlarmAfter(this, stringExtra, OptionFactory.m8722iz(this).Arr);
        }
        RecoveryLog.m8712i(TAG, "RecoveryUploadReceiver.uploadDataResult %b", Boolean.valueOf(tryToUploadData));
        if (RecoveryLog.dQe() instanceof RecoveryFileLog) {
            RecoveryLog.m8712i(TAG, "send broadcast action", new Object[0]);
            RecoveryLog.dQd();
            Intent intent2 = new Intent();
            intent2.setPackage(getPackageName());
            intent2.setAction("com.tecent.recovery.intent.action.LOG");
            sendBroadcast(intent2);
        }
        stopSelf();
    }

    /* Access modifiers changed, original: protected */
    public boolean tryToUploadData() {
        return true;
    }
}
