package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportManager {
    private static final Class<?>[] REPORT_MANAGERS = new Class[]{DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class};
    private static final String TAG = "LogReportManager";
    private static LogReportManager mInstance = null;
    private final INetworkChangedObserver mNetworkChangedObserver = new C311001();

    /* renamed from: com.tencent.tmassistantsdk.logreport.LogReportManager$1 */
    class C311001 implements INetworkChangedObserver {
        C311001() {
        }

        public void onNetworkChanged() {
            AppMethodBeat.m2504i(75817);
            TMLog.m60588i(LogReportManager.TAG, "onNetworkChanged,netState:" + DownloadHelper.getNetStatus());
            for (Object obj : LogReportManager.REPORT_MANAGERS) {
                try {
                    if (obj.equals(DownloadReportManager.class)) {
                        DownloadReportManager.getInstance().resetMaxReportCount();
                    } else if (obj.equals(TipsInfoReportManager.class)) {
                        TipsInfoReportManager.getInstance().resetMaxReportCount();
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(LogReportManager.TAG, e, "", new Object[0]);
                }
            }
            if (DownloadHelper.isNetworkConncted()) {
                DownloadHelper.getNetStatus().equalsIgnoreCase("wifi");
            }
            AppMethodBeat.m2505o(75817);
        }
    }

    public static synchronized LogReportManager getInstance() {
        LogReportManager logReportManager;
        synchronized (LogReportManager.class) {
            AppMethodBeat.m2504i(75818);
            if (mInstance == null) {
                mInstance = new LogReportManager();
            }
            logReportManager = mInstance;
            AppMethodBeat.m2505o(75818);
        }
        return logReportManager;
    }

    private LogReportManager() {
        AppMethodBeat.m2504i(75819);
        NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.m2505o(75819);
    }

    public void destory() {
        AppMethodBeat.m2504i(75820);
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().destroy();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().destroy();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.m2505o(75820);
    }

    public void reportLog() {
        AppMethodBeat.m2504i(75821);
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
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75821);
    }

    public void cancleReport() {
        AppMethodBeat.m2504i(75822);
        for (Object obj : REPORT_MANAGERS) {
            try {
                if (obj.equals(DownloadReportManager.class)) {
                    DownloadReportManager.getInstance().cancleRequest();
                } else if (obj.equals(TipsInfoReportManager.class)) {
                    TipsInfoReportManager.getInstance().cancleRequest();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(75822);
    }
}
