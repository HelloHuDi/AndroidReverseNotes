package com.tencent.p177mm.plugin.exdevice.p956h;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.exdevice.h.a */
public final class C27836a {
    /* renamed from: c */
    private static void m44246c(SharedPreferences sharedPreferences) {
        int i = 0;
        AppMethodBeat.m2504i(19706);
        C4990ab.m7416i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "tryToClearDirtyData");
        if (VERSION.SDK_INT < 11) {
            AppMethodBeat.m2505o(19706);
        } else if (sharedPreferences == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == aSP");
            AppMethodBeat.m2505o(19706);
        } else {
            String[] strArr = new String[]{"conneted_device", "shut_down_device"};
            while (i < 2) {
                String str = strArr[i];
                try {
                    if (sharedPreferences.getStringSet(str, null) != null) {
                        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "find dirty data, remove it, key = %s", str);
                        if (!sharedPreferences.edit().remove(str).commit()) {
                            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove dirty data failed!!!");
                        }
                    }
                } catch (Exception e) {
                }
                i++;
            }
            AppMethodBeat.m2505o(19706);
        }
    }

    /* renamed from: C */
    public static boolean m44242C(String str, long j) {
        AppMethodBeat.m2504i(19707);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "isItemInSharedPreferences, key = %s, device id = %d", str, Long.valueOf(j));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.m2505o(19707);
            return false;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.m2505o(19707);
            return false;
        }
        C27836a.m44246c(sharedPreferences);
        if (C42992b.m76355dX(String.valueOf(j), sharedPreferences.getString(str, new String()))) {
            AppMethodBeat.m2505o(19707);
            return true;
        }
        AppMethodBeat.m2505o(19707);
        return false;
    }

    /* renamed from: D */
    public static boolean m44243D(String str, long j) {
        AppMethodBeat.m2504i(19708);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addToSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.m2505o(19708);
            return false;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.m2505o(19708);
            return false;
        }
        C27836a.m44246c(sharedPreferences);
        String dY = C42992b.m76356dY(String.valueOf(j), sharedPreferences.getString(str, new String()));
        if (dY == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "addDeviceToDeviceList failed!!!");
            AppMethodBeat.m2505o(19708);
            return false;
        } else if (sharedPreferences.edit().putString(str, dY).commit()) {
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "add to sharepreference successful, new device list is %s", dY);
            AppMethodBeat.m2505o(19708);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit() Failed!!!");
            AppMethodBeat.m2505o(19708);
            return false;
        }
    }

    /* renamed from: E */
    public static boolean m44244E(String str, long j) {
        AppMethodBeat.m2504i(19709);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "removeFromSharedPreferences, key = %s, deviceId = %d", str, Long.valueOf(j));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.m2505o(19709);
            return false;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.m2505o(19709);
            return false;
        }
        C27836a.m44246c(sharedPreferences);
        String dZ = C42992b.m76357dZ(String.valueOf(j), sharedPreferences.getString(str, new String()));
        if (dZ == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove device from device list failed!!!");
            AppMethodBeat.m2505o(19709);
            return false;
        }
        boolean commit;
        if (dZ.length() == 0) {
            commit = sharedPreferences.edit().remove(str).commit();
        } else {
            commit = sharedPreferences.edit().putString(str, dZ).commit();
        }
        if (commit) {
            C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "remove from sharepreference successful, new device list is %s", dZ);
            AppMethodBeat.m2505o(19709);
            return true;
        }
        C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().putString().commit()");
        AppMethodBeat.m2505o(19709);
        return false;
    }

    /* renamed from: Kt */
    public static long[] m44245Kt(String str) {
        Exception e;
        AppMethodBeat.m2504i(19710);
        C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "getListFromSharedPreferences, key = %s", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "key is null or nil");
            AppMethodBeat.m2505o(19710);
            return null;
        }
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
            AppMethodBeat.m2505o(19710);
            return null;
        }
        C27836a.m44246c(sharedPreferences);
        try {
            String[] split = sharedPreferences.getString(str, new String()).split("\\|");
            if (split == null || split.length == 0) {
                C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == strDeviceList || 0 == strDeviceList.length");
                AppMethodBeat.m2505o(19710);
                return null;
            }
            long[] jArr = new long[split.length];
            int i = 0;
            for (String str2 : split) {
                try {
                    C4990ab.m7417i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "parse %s to long", str2);
                    if (str2.length() != 0) {
                        int i2 = i + 1;
                        try {
                            jArr[i] = C5046bo.getLong(str2, 0);
                            i = i2;
                        } catch (Exception e2) {
                            e = e2;
                            i = i2;
                            C4990ab.m7412e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "try pase string device id to long failed : " + e.getMessage());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            if (i == 0) {
                AppMethodBeat.m2505o(19710);
                return null;
            }
            AppMethodBeat.m2505o(19710);
            return jArr;
        } catch (Exception e4) {
            C4990ab.m7413e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "split failed!!!, %s", e4.getMessage());
            AppMethodBeat.m2505o(19710);
            return null;
        }
    }
}
