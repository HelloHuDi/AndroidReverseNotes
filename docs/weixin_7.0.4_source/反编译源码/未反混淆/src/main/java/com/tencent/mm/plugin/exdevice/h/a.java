package com.tencent.mm.plugin.exdevice.h;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    private static void c(SharedPreferences sharedPreferences) {
        int i = 0;
        AppMethodBeat.i(19706);
        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.o(19706);
        } else if (sharedPreferences == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
            AppMethodBeat.o(19706);
        } else {
            String[] strArr = new String[]{"conneted_device", "shut_down_device"};
            while (i < 2) {
                String str = strArr[i];
                try {
                    if (sharedPreferences.getStringSet(str, null) != null) {
                        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", str);
                        if (!sharedPreferences.edit().remove(str).commit()) {
                            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
                        }
                    }
                } catch (Exception e) {
                }
                i++;
            }
            AppMethodBeat.o(19706);
        }
    }

    public static boolean C(String str, long j) {
        AppMethodBeat.i(19707);
        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", str, Long.valueOf(j));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(19707);
            return false;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(19707);
            return false;
        }
        c(sharedPreferences);
        if (b.dX(String.valueOf(j), sharedPreferences.getString(str, new String()))) {
            AppMethodBeat.o(19707);
            return true;
        }
        AppMethodBeat.o(19707);
        return false;
    }

    public static boolean D(String str, long j) {
        AppMethodBeat.i(19708);
        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(19708);
            return false;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(19708);
            return false;
        }
        c(sharedPreferences);
        String dY = b.dY(String.valueOf(j), sharedPreferences.getString(str, new String()));
        if (dY == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
            AppMethodBeat.o(19708);
            return false;
        } else if (sharedPreferences.edit().putString(str, dY).commit()) {
            ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", dY);
            AppMethodBeat.o(19708);
            return true;
        } else {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
            AppMethodBeat.o(19708);
            return false;
        }
    }

    public static boolean E(String str, long j) {
        AppMethodBeat.i(19709);
        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(19709);
            return false;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(19709);
            return false;
        }
        c(sharedPreferences);
        String dZ = b.dZ(String.valueOf(j), sharedPreferences.getString(str, new String()));
        if (dZ == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
            AppMethodBeat.o(19709);
            return false;
        }
        boolean commit;
        if (dZ.length() == 0) {
            commit = sharedPreferences.edit().remove(str).commit();
        } else {
            commit = sharedPreferences.edit().putString(str, dZ).commit();
        }
        if (commit) {
            ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", dZ);
            AppMethodBeat.o(19709);
            return true;
        }
        ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
        AppMethodBeat.o(19709);
        return false;
    }

    public static long[] Kt(String str) {
        Exception e;
        AppMethodBeat.i(19710);
        ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", str);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.o(19710);
            return null;
        }
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.o(19710);
            return null;
        }
        c(sharedPreferences);
        try {
            String[] split = sharedPreferences.getString(str, new String()).split("\\|");
            if (split == null || split.length == 0) {
                ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
                AppMethodBeat.o(19710);
                return null;
            }
            long[] jArr = new long[split.length];
            int i = 0;
            for (String str2 : split) {
                try {
                    ab.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", str2);
                    if (str2.length() != 0) {
                        int i2 = i + 1;
                        try {
                            jArr[i] = bo.getLong(str2, 0);
                            i = i2;
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + e.getMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (i == 0) {
                AppMethodBeat.o(19710);
                return null;
            }
            AppMethodBeat.o(19710);
            return jArr;
        } catch (Exception e4) {
            ab.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", e4.getMessage());
            AppMethodBeat.o(19710);
            return null;
        }
    }
}
