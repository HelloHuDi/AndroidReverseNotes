package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsPVConfig extends TbsBaseConfig {
    private static TbsPVConfig b;
    public SharedPreferences mPreferences;

    public interface TbsPVConfigKey {
        public static final String KEY_DISABLED_CORE_VERSION = "disabled_core_version";
        public static final String KEY_EMERGENT_CORE_VERSION = "emergent_core_version";
        public static final String KEY_ENABLE_NO_SHARE_GRAY = "enable_no_share_gray";
        public static final String KEY_GET_LOCALCOREVERSION_MORETIMES = "get_localcoreversion_moretimes";
        public static final String KEY_IS_DISABLE_HOST_BACKUP_CORE = "disable_host_backup";
        public static final String KEY_READ_APK = "read_apk";
    }

    private TbsPVConfig() {
    }

    public static synchronized TbsPVConfig getInstance(Context context) {
        TbsPVConfig tbsPVConfig;
        synchronized (TbsPVConfig.class) {
            AppMethodBeat.i(64545);
            if (b == null) {
                tbsPVConfig = new TbsPVConfig();
                b = tbsPVConfig;
                tbsPVConfig.init(context);
            }
            tbsPVConfig = b;
            AppMethodBeat.o(64545);
        }
        return tbsPVConfig;
    }

    public static synchronized void releaseInstance() {
        synchronized (TbsPVConfig.class) {
            b = null;
        }
    }

    public String getConfigFileName() {
        return "tbs_pv_config";
    }

    public synchronized int getDisabledCoreVersion() {
        int parseInt;
        AppMethodBeat.i(64549);
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_DISABLED_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                parseInt = Integer.parseInt(str);
                AppMethodBeat.o(64549);
            }
        } catch (Exception e) {
        }
        parseInt = 0;
        AppMethodBeat.o(64549);
        return parseInt;
    }

    public synchronized int getEmergentCoreVersion() {
        int parseInt;
        AppMethodBeat.i(64547);
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_EMERGENT_CORE_VERSION);
            if (!TextUtils.isEmpty(str)) {
                parseInt = Integer.parseInt(str);
                AppMethodBeat.o(64547);
            }
        } catch (Exception e) {
        }
        parseInt = 0;
        AppMethodBeat.o(64547);
        return parseInt;
    }

    public synchronized int getLocalCoreVersionMoreTimes() {
        int parseInt;
        AppMethodBeat.i(64546);
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_GET_LOCALCOREVERSION_MORETIMES);
            if (!TextUtils.isEmpty(str)) {
                parseInt = Integer.parseInt(str);
                AppMethodBeat.o(64546);
            }
        } catch (Exception e) {
        }
        parseInt = 0;
        AppMethodBeat.o(64546);
        return parseInt;
    }

    public synchronized int getReadApk() {
        int parseInt;
        AppMethodBeat.i(64548);
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_READ_APK);
            if (!TextUtils.isEmpty(str)) {
                parseInt = Integer.parseInt(str);
                AppMethodBeat.o(64548);
            }
        } catch (Exception e) {
        }
        parseInt = 0;
        AppMethodBeat.o(64548);
        return parseInt;
    }

    public synchronized boolean isDisableHostBackupCore() {
        boolean z;
        AppMethodBeat.i(64551);
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_IS_DISABLE_HOST_BACKUP_CORE);
            if (!TextUtils.isEmpty(str) && str.equals("true")) {
                z = true;
                AppMethodBeat.o(64551);
            }
        } catch (Exception e) {
        }
        z = false;
        AppMethodBeat.o(64551);
        return z;
    }

    public synchronized boolean isEnableNoCoreGray() {
        boolean z;
        AppMethodBeat.i(64550);
        try {
            String str = (String) this.a.get(TbsPVConfigKey.KEY_ENABLE_NO_SHARE_GRAY);
            if (!TextUtils.isEmpty(str) && str.equals("true")) {
                z = true;
                AppMethodBeat.o(64550);
            }
        } catch (Exception e) {
        }
        z = false;
        AppMethodBeat.o(64550);
        return z;
    }

    public synchronized void putData(String str, String str2) {
        AppMethodBeat.i(64552);
        this.a.put(str, str2);
        AppMethodBeat.o(64552);
    }
}
