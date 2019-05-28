package com.tencent.mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ab;

public class CrashUploadAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        ab.d("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
        if (a.dnc() == 0) {
            ExceptionMonitorService.gg(context);
        }
    }
}
