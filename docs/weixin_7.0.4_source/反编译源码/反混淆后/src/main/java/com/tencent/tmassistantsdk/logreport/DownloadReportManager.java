package com.tencent.tmassistantsdk.logreport;

import android.net.Proxy;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.DownloadLogTable;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class DownloadReportManager extends BaseReportManager {
    protected static final String TAG = "DownloadReportManager";
    protected static DownloadReportManager mInstance = null;

    protected DownloadReportManager() {
    }

    public static synchronized DownloadReportManager getInstance() {
        DownloadReportManager downloadReportManager;
        synchronized (DownloadReportManager.class) {
            AppMethodBeat.m2504i(75808);
            if (mInstance == null) {
                mInstance = new DownloadReportManager();
            }
            downloadReportManager = mInstance;
            AppMethodBeat.m2505o(75808);
        }
        return downloadReportManager;
    }

    public DownloadChunkLogInfo createNewChunkLogInfo(byte b) {
        AppMethodBeat.m2504i(75809);
        TMLog.m60588i(TAG, "createNewChunkLogInfo");
        DownloadChunkLogInfo downloadChunkLogInfo = new DownloadChunkLogInfo();
        downloadChunkLogInfo.type = b;
        downloadChunkLogInfo.networkOperator = GlobalUtil.getInstance().getNetworkOperator();
        downloadChunkLogInfo.networkType = GlobalUtil.getInstance().getNetworkType();
        downloadChunkLogInfo.isWap = (byte) (!TextUtils.isEmpty(Proxy.getDefaultHost()) ? 1 : 0);
        downloadChunkLogInfo.startTime = System.currentTimeMillis();
        AppMethodBeat.m2505o(75809);
        return downloadChunkLogInfo;
    }

    /* Access modifiers changed, original: protected */
    public BaseLogTable getLogTable() {
        AppMethodBeat.m2504i(75810);
        DownloadLogTable instance = DownloadLogTable.getInstance();
        AppMethodBeat.m2505o(75810);
        return instance;
    }

    /* Access modifiers changed, original: protected */
    public byte getReportType() {
        return (byte) 0;
    }
}
