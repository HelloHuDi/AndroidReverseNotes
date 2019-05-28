package com.tencent.recovery;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RecoveryLogic {
    public static Field AqY = null;
    public static int AqZ = 17;

    public static void a(Context context, ArrayList<RecoveryHandleItem> arrayList, String str) {
        RecoveryLog.i("Recovery.RecoveryLogic", "startReportService %s", "HandleStatus");
        Intent intent = new Intent(context, RecoveryReportService.class);
        intent.putExtra("KeyReportType", "HandleStatus");
        intent.putExtra("KeyReportUploadClassName", str);
        intent.putParcelableArrayListExtra("KeyReportItem", arrayList);
        context.startService(intent);
    }

    public static boolean a(Context context, CommonOptions commonOptions, RecoveryContext recoveryContext) {
        if (commonOptions.Aro == null) {
            RecoveryLog.i("Recovery.RecoveryLogic", "startRecoveryProcess not set handle service", new Object[0]);
            return false;
        }
        String name;
        String name2;
        RecoveryLog.i("Recovery.RecoveryLogic", "startHandleService %s", Util.iC(context));
        if (Util.isNullOrNil(commonOptions.Arp)) {
            name = RecoveryUploadService.class.getName();
        } else {
            name = commonOptions.Arp;
        }
        if (Util.isNullOrNil(commonOptions.Aro)) {
            name2 = RecoveryHandleService.class.getName();
        } else {
            name2 = commonOptions.Aro;
        }
        RecoveryData recoveryData = new RecoveryData();
        recoveryData.processName = Util.iC(context);
        recoveryData.eCq = commonOptions.eCq;
        recoveryData.Arl = commonOptions.Arl;
        recoveryData.Arm = recoveryContext.AqX;
        recoveryData.clientVersion = commonOptions.clientVersion;
        Intent intent = new Intent();
        intent.setClassName(context, commonOptions.Aro);
        intent.putExtra("KeyReportUploadClassName", name);
        intent.putExtra("KeyReportHandleClassName", name2);
        intent.putExtra("KeyRecoveryData", recoveryData);
        context.startService(intent);
        return true;
    }

    public static int bW(Context context, String str) {
        if (AqZ != 17) {
            return AqZ;
        }
        AqZ = 16;
        if (AqY == null) {
            try {
                AqY = RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Exception e) {
            }
        }
        if (AqY != null) {
            List runningAppProcesses;
            try {
                runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            } catch (Exception e2) {
                runningAppProcesses = null;
            }
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                RecoveryLog.i("Recovery.RecoveryLogic", "can not get running app process", new Object[0]);
            } else {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0) {
                        Integer valueOf;
                        try {
                            valueOf = Integer.valueOf(AqY.getInt(runningAppProcessInfo));
                        } catch (Exception e3) {
                            valueOf = null;
                        }
                        if (valueOf != null && valueOf.intValue() == 2) {
                            break;
                        }
                    }
                }
                RunningAppProcessInfo runningAppProcessInfo2 = null;
                if (runningAppProcessInfo2 != null) {
                    RecoveryLog.i("Recovery.RecoveryLogic", "%s %s", str, runningAppProcessInfo2.processName);
                    if (str.equals(runningAppProcessInfo2.processName)) {
                        AqZ = 1;
                    }
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (RunningAppProcessInfo runningAppProcessInfo22 : runningAppProcesses) {
                        if (runningAppProcessInfo22 != null) {
                            stringBuffer.append(runningAppProcessInfo22.processName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + runningAppProcessInfo22.importance + " ");
                        }
                    }
                    RecoveryLog.i("Recovery.RecoveryLogic", "foregroundInfo is null %s %s", Integer.valueOf(runningAppProcesses.size()), stringBuffer.toString());
                }
            }
        }
        return AqZ;
    }
}
