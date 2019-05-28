package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkUpdater;

public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;
    private static TbsDownloadConfig b;
    Map<String, Object> a = new HashMap();
    private Context c;
    public SharedPreferences mPreferences;

    public interface TbsConfigKey {
        public static final String KEY_APP_METADATA = "app_metadata";
        public static final String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final String KEY_APP_VERSIONNAME = "app_versionname";
        public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
        public static final String KEY_COUNT_REQUEST_FAIL_IN_24HOURS = "count_request_fail_in_24hours";
        public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
        public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
        public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
        public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
        public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
        public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
        public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final String KEY_FULL_PACKAGE = "request_full_package";
        public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
        public static final String KEY_IS_OVERSEA = "is_oversea";
        public static final String KEY_LAST_CHECK = "last_check";
        public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
        public static final String KEY_LAST_REQUEST_SUCCESS = "last_request_success";
        public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
        public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final String KEY_REQUEST_FAIL = "request_fail";
        public static final String KEY_RESPONSECODE = "tbs_responsecode";
        public static final String KEY_RETRY_INTERVAL = "retry_interval";
        public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
        public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
        public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE = "tbs_core_load_rename_file_lock_enable";
        public static final String KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE = "tbs_core_load_rename_file_lock_wait_enable";
        public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
        public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
        public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
        public static final String KEY_USE_BUGLY = "tbs_use_bugly";
    }

    private TbsDownloadConfig(Context context) {
        AppMethodBeat.i(64320);
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        this.c = context.getApplicationContext();
        if (this.c == null) {
            this.c = context;
        }
        AppMethodBeat.o(64320);
    }

    public static synchronized TbsDownloadConfig getInstance() {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            tbsDownloadConfig = b;
        }
        return tbsDownloadConfig;
    }

    public static synchronized TbsDownloadConfig getInstance(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            AppMethodBeat.i(64321);
            if (b == null) {
                b = new TbsDownloadConfig(context);
            }
            tbsDownloadConfig = b;
            AppMethodBeat.o(64321);
        }
        return tbsDownloadConfig;
    }

    public void clear() {
        AppMethodBeat.i(64337);
        try {
            this.a.clear();
            Editor edit = this.mPreferences.edit();
            edit.clear();
            edit.commit();
            AppMethodBeat.o(64337);
        } catch (Exception e) {
            AppMethodBeat.o(64337);
        }
    }

    public synchronized void commit() {
        AppMethodBeat.i(64336);
        try {
            Editor edit = this.mPreferences.edit();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                }
            }
            edit.commit();
            this.a.clear();
            AppMethodBeat.o(64336);
        } catch (Exception e) {
            AppMethodBeat.o(64336);
        }
        return;
    }

    public synchronized int getDownloadFailedMaxRetrytimes() {
        int i;
        AppMethodBeat.i(64326);
        i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
        if (i == 0) {
            i = 100;
            AppMethodBeat.o(64326);
        } else {
            AppMethodBeat.o(64326);
        }
        return i;
    }

    public synchronized int getDownloadInterruptCode() {
        int i;
        AppMethodBeat.i(64333);
        if (this.mPreferences.contains(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
            i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
            if (i == -119 || i == -121) {
                i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -119);
            }
            if (System.currentTimeMillis() - this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, 0) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                i = !new File(new File(this.c.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD) ? -96 : XWalkUpdater.ERROR_SET_VERNUM;
            } catch (Throwable th) {
                i = -95;
            }
        }
        if (this.c == null || !TbsConfig.APP_QQ.equals(this.c.getApplicationInfo().packageName) || "CN".equals(Locale.getDefault().getCountry())) {
            i = (i * 1000) + this.mPreferences.getInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, -1);
            AppMethodBeat.o(64333);
        } else {
            i = -320;
            AppMethodBeat.o(64333);
        }
        return i;
    }

    public synchronized long getDownloadMaxflow() {
        long j;
        AppMethodBeat.i(64322);
        int i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
        if (i == 0) {
            i = 20;
        }
        j = ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * 1024;
        AppMethodBeat.o(64322);
        return j;
    }

    public synchronized long getDownloadMinFreeSpace() {
        long j;
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(64324);
            int i2 = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
            if (i2 != 0) {
                i = i2;
            }
            j = ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * 1024;
            AppMethodBeat.o(64324);
        }
        return j;
    }

    public synchronized long getDownloadSingleTimeout() {
        long j;
        AppMethodBeat.i(64334);
        j = this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0);
        if (j == 0) {
            j = 1200000;
            AppMethodBeat.o(64334);
        } else {
            AppMethodBeat.o(64334);
        }
        return j;
    }

    public synchronized int getDownloadSuccessMaxRetrytimes() {
        int i;
        AppMethodBeat.i(64325);
        i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
        if (i == 0) {
            i = 3;
            AppMethodBeat.o(64325);
        } else {
            AppMethodBeat.o(64325);
        }
        return i;
    }

    public synchronized long getRetryInterval() {
        long retryIntervalInSeconds;
        AppMethodBeat.i(64323);
        if (TbsDownloader.getRetryIntervalInSeconds() >= 0) {
            retryIntervalInSeconds = TbsDownloader.getRetryIntervalInSeconds();
            AppMethodBeat.o(64323);
        } else {
            retryIntervalInSeconds = this.mPreferences.getLong(TbsConfigKey.KEY_RETRY_INTERVAL, DEFAULT_RETRY_INTERVAL_SEC);
            AppMethodBeat.o(64323);
        }
        return retryIntervalInSeconds;
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockEnable() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(64330);
            try {
                z = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, true);
            } catch (Exception e) {
            }
            AppMethodBeat.o(64330);
        }
        return z;
    }

    public synchronized boolean getTbsCoreLoadRenameFileLockWaitEnable() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(64331);
            try {
                z = this.mPreferences.getBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, true);
            } catch (Exception e) {
            }
            AppMethodBeat.o(64331);
        }
        return z;
    }

    public synchronized boolean isOverSea() {
        boolean z;
        AppMethodBeat.i(64335);
        z = this.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
        AppMethodBeat.o(64335);
        return z;
    }

    public synchronized void setDownloadInterruptCode(int i) {
        AppMethodBeat.i(64327);
        try {
            Editor edit = this.mPreferences.edit();
            edit.putInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, i);
            edit.putLong(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_TIME, System.currentTimeMillis());
            edit.commit();
            AppMethodBeat.o(64327);
        } catch (Exception e) {
            AppMethodBeat.o(64327);
        }
        return;
    }

    public synchronized void setInstallInterruptCode(int i) {
        AppMethodBeat.i(64338);
        Editor edit = this.mPreferences.edit();
        edit.putInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, i);
        edit.commit();
        AppMethodBeat.o(64338);
    }

    public synchronized void setTbsCoreLoadRenameFileLockEnable(boolean z) {
        AppMethodBeat.i(64328);
        try {
            Editor edit = this.mPreferences.edit();
            edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_ENABLE, z);
            edit.commit();
            AppMethodBeat.o(64328);
        } catch (Exception e) {
            AppMethodBeat.o(64328);
        }
        return;
    }

    public synchronized void setTbsCoreLoadRenameFileLockWaitEnable(boolean z) {
        AppMethodBeat.i(64329);
        try {
            Editor edit = this.mPreferences.edit();
            edit.putBoolean(TbsConfigKey.KEY_TBS_CORE_LOAD_RENAME_FILE_LOCK_WAIT_ENABLE, z);
            edit.commit();
            AppMethodBeat.o(64329);
        } catch (Exception e) {
            AppMethodBeat.o(64329);
        }
        return;
    }

    public synchronized void uploadDownloadInterruptCodeIfNeeded(Context context) {
        AppMethodBeat.i(64332);
        if (context != null) {
            try {
                if ("com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                    int i;
                    Object obj = 1;
                    if (this.mPreferences.contains(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE)) {
                        i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE, -99);
                        if ((i > -206 || i < -219) && ((i > -302 || i < -316) && (i > -318 || i < -322))) {
                            obj = null;
                        }
                    } else {
                        try {
                            i = !new File(new File(this.c.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD) ? -96 : XWalkUpdater.ERROR_SET_VERNUM;
                        } catch (Throwable th) {
                            i = -95;
                        }
                    }
                    if (obj != null) {
                        TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                        tbsLogInfo.setErrorCode(128);
                        tbsLogInfo.setFailDetail(" ".concat(String.valueOf(i)));
                        TbsLogReport.getInstance(context).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(64332);
            }
        }
        AppMethodBeat.o(64332);
        return;
    }
}
