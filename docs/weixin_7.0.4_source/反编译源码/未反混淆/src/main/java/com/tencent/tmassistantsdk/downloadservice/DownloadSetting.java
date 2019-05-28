package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.HashMap;

public class DownloadSetting {
    public static final String ISDOWNLOADWIFIONLY = "isDownloadWifiOnly";
    public static final String ISTASKAUTORESUME = "isTaskAutoResume";
    public static final String MAXTASKNUM = "maxTaskNum";
    private static final String TAG = "DownloadSetting";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_INTEGER = "Integer";
    protected static DownloadSetting mInstance = null;
    protected boolean isDownloadWifiOnly = false;
    protected boolean isTaskAutoResume = true;
    protected int maxTaskNum = 5;

    public DownloadSetting() {
        AppMethodBeat.i(75734);
        loadFromDB();
        AppMethodBeat.o(75734);
    }

    public static synchronized DownloadSetting getInstance() {
        DownloadSetting downloadSetting;
        synchronized (DownloadSetting.class) {
            AppMethodBeat.i(75735);
            if (mInstance == null) {
                mInstance = new DownloadSetting();
            }
            downloadSetting = mInstance;
            AppMethodBeat.o(75735);
        }
        return downloadSetting;
    }

    static int getSplitSizeInBytes(String str) {
        AppMethodBeat.i(75736);
        if (str.equalsIgnoreCase("WIFI")) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Split is not allowed in current version. netType: ".concat(String.valueOf(str)));
            AppMethodBeat.o(75736);
            throw unsupportedOperationException;
        } else if (str.contains("net")) {
            AppMethodBeat.o(75736);
            return Downloads.SPLIT_RANGE_SIZE_NET;
        } else if (str.contains("wap")) {
            AppMethodBeat.o(75736);
            return Downloads.SPLIT_RANGE_SIZE_WAP;
        } else {
            AppMethodBeat.o(75736);
            return Downloads.SPLIT_RANGE_SIZE_NET;
        }
    }

    public void setIsTaskAutoResume(boolean z) {
        AppMethodBeat.i(75737);
        if (mInstance.isTaskAutoResume == z) {
            AppMethodBeat.o(75737);
            return;
        }
        mInstance.isTaskAutoResume = z;
        DownloadSettingTable.save(ISTASKAUTORESUME, String.valueOf(z), TYPE_BOOLEAN);
        AppMethodBeat.o(75737);
    }

    public void setIsDownloadWifiOnly(boolean z) {
        AppMethodBeat.i(75738);
        if (mInstance.isDownloadWifiOnly == z) {
            AppMethodBeat.o(75738);
            return;
        }
        mInstance.isDownloadWifiOnly = z;
        DownloadSettingTable.save(ISDOWNLOADWIFIONLY, String.valueOf(z), TYPE_BOOLEAN);
        AppMethodBeat.o(75738);
    }

    public void setMaxTaskNum(int i) {
        AppMethodBeat.i(75739);
        if (mInstance.maxTaskNum == i) {
            AppMethodBeat.o(75739);
            return;
        }
        mInstance.maxTaskNum = i;
        DownloadSettingTable.save(MAXTASKNUM, String.valueOf(i), TYPE_INTEGER);
        AppMethodBeat.o(75739);
    }

    private void loadFromDB() {
        boolean z = false;
        AppMethodBeat.i(75740);
        HashMap query = DownloadSettingTable.query();
        String str = (String) query.get(ISTASKAUTORESUME);
        if (str != null && str.length() > 0) {
            this.isTaskAutoResume = !str.equals("false");
        }
        str = (String) query.get(ISDOWNLOADWIFIONLY);
        if (str != null && str.length() > 0) {
            if (!str.equals("false")) {
                z = true;
            }
            this.isDownloadWifiOnly = z;
        }
        str = (String) query.get(MAXTASKNUM);
        if (str != null && str.length() > 0) {
            this.maxTaskNum = Integer.valueOf(str).intValue();
        }
        AppMethodBeat.o(75740);
    }

    public boolean getIsTaskAutoResume() {
        return this.isTaskAutoResume;
    }

    public boolean getIsDownloadWifiOnly() {
        return this.isDownloadWifiOnly;
    }

    public int getMaxTaskNum() {
        return this.maxTaskNum;
    }

    public boolean isAutoDownload() {
        AppMethodBeat.i(75741);
        if (this.isTaskAutoResume) {
            String netStatus = DownloadHelper.getNetStatus();
            if (netStatus.contains("wifi") || netStatus.contains("net")) {
                AppMethodBeat.o(75741);
                return true;
            }
        }
        AppMethodBeat.o(75741);
        return false;
    }

    public boolean isAutoDownload(String str, String str2) {
        AppMethodBeat.i(75742);
        TMLog.i(TAG, "downloadInfoNetType = ".concat(String.valueOf(str)));
        TMLog.i(TAG, "currentNetType = ".concat(String.valueOf(str2)));
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(75742);
            return false;
        } else if (str2.equalsIgnoreCase("WIFI")) {
            AppMethodBeat.o(75742);
            return true;
        } else if (!str2.contains("net") || str.equalsIgnoreCase("WIFI")) {
            AppMethodBeat.o(75742);
            return false;
        } else {
            AppMethodBeat.o(75742);
            return true;
        }
    }
}
