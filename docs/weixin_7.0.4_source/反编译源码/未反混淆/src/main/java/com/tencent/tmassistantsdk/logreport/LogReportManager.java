package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportManager {
    private static final Class<?>[] REPORT_MANAGERS = new Class[]{DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class};
    private static final String TAG = "LogReportManager";
    private static LogReportManager mInstance = null;
    private final INetworkChangedObserver mNetworkChangedObserver = new INetworkChangedObserver() {
        public void onNetworkChanged() {
            AppMethodBeat.i(75817);
            TMLog.i(LogReportManager.TAG, "onNetworkChanged,netState:" + DownloadHelper.getNetStatus());
            for (Object obj : LogReportManager.REPORT_MANAGERS) {
                try {
                    if (obj.equals(DownloadReportManager.class)) {
                        DownloadReportManager.getInstance().resetMaxReportCount();
                    } else if (obj.equals(TipsInfoReportManager.class)) {
                        TipsInfoReportManager.getInstance().resetMaxReportCount();
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace(LogReportManager.TAG, e, "", new Object[0]);
                }
            }
            if (DownloadHelper.isNetworkConncted()) {
                DownloadHelper.getNetStatus().equalsIgnoreCase("wifi");
            }
            AppMethodBeat.o(75817);
        }
    };

    public static synchronized LogReportManager getInstance() {
        LogReportManager logReportManager;
        synchronized (LogReportManager.class) {
            AppMethodBeat.i(75818);
            if (mInstance == null) {
                mInstance = new LogReportManager();
            }
            logReportManager = mInstance;
            AppMethodBeat.o(75818);
        }
        return logReportManager;
    }

    private LogReportManager() {
        AppMethodBeat.i(75819);
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.o(75819);
    }

    public void destory() {
        AppMethodBeat.i(75820);
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().destroy();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().destroy();
                }
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.o(75820);
    }

    public void reportLog() {
        AppMethodBeat.i(75821);
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().reportLogData();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().reportLogData();
                } else if (obj.equals(UpdateInfoReportManager.class)) {
                    UpdateInfoReportManager.getInstance().reportLogData();
                }
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(75821);
    }

    public void cancleReport() {
        AppMethodBeat.i(75822);
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().cancleRequest();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().cancleRequest();
                }
            } catch (Exception e) {
                ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(75822);
    }
}
