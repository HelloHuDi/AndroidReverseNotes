package com.tencent.recovery.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.provider.Settings.Secure;
import com.tencent.recovery.Recovery;
import com.tencent.recovery.log.RecoveryLog;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Util {
    private static String processName = "";

    public static final boolean isNullOrNil(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: iB */
    public static final int m8736iB(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("recovery-info", 0);
        int i = sharedPreferences.getInt("KeySafeModeUUID", -1);
        if (i != -1) {
            return i;
        }
        String macAddress;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Secure.getString(context.getContentResolver(), "android_id"));
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            macAddress = connectionInfo.getMacAddress();
        } else {
            macAddress = null;
        }
        if (macAddress == null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                macAddress = defaultAdapter.getAddress();
            } else {
                macAddress = null;
            }
        }
        if (macAddress == null) {
            macAddress = UUID.randomUUID().toString();
        }
        stringBuffer.append(macAddress);
        stringBuffer.append(Build.MANUFACTURER + Build.MODEL);
        i = ("A" + m8739x(stringBuffer.toString().getBytes()).substring(0, 15)).hashCode();
        sharedPreferences.edit().putInt("KeySafeModeUUID", i).commit();
        return i;
    }

    /* renamed from: x */
    private static final String m8739x(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: nz */
    public static String m8738nz(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(j));
    }

    /* renamed from: iC */
    public static String m8737iC(Context context) {
        return m8735aw(context, Process.myPid());
    }

    /* renamed from: aw */
    private static String m8735aw(Context context, int i) {
        if (Process.myUid() >= 99000) {
            return "ISOLATE_PROCESS";
        }
        if (!isNullOrNil(processName)) {
            return processName;
        }
        if (context == null) {
            context = Recovery.getContext();
        }
        if (context == null || i <= 0) {
            return processName;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (!(runningAppProcessInfo.pid != i || runningAppProcessInfo.processName == null || runningAppProcessInfo.processName.equals(""))) {
                    processName = runningAppProcessInfo.processName;
                }
            }
        } catch (Exception e) {
            RecoveryLog.printErrStackTrace("Recovery.Util", e, "", new Object[0]);
        }
        return processName;
    }
}
