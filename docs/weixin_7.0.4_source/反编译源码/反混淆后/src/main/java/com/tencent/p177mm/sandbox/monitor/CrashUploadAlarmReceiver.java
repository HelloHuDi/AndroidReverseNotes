package com.tencent.p177mm.sandbox.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.sandbox.monitor.CrashUploadAlarmReceiver */
public class CrashUploadAlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C4990ab.m7410d("MicroMsg.CrashUploadAlarmReceiver", "dkcrash AlarmReceiver.onReceive");
        if (C30270a.dnc() == 0) {
            ExceptionMonitorService.m59182gg(context);
        }
    }
}
