package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKAuthorizedInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.TipsInfoLogTable;
import com.tencent.tmassistantsdk.util.TMLog;

public class TipsInfoReportManager extends BaseReportManager {
    protected static final String TAG = "TipsInfoReportManager";
    protected static TipsInfoReportManager mInstance = null;

    private TipsInfoReportManager() {
    }

    public static synchronized TipsInfoReportManager getInstance() {
        TipsInfoReportManager tipsInfoReportManager;
        synchronized (TipsInfoReportManager.class) {
            AppMethodBeat.m2504i(75823);
            if (mInstance == null) {
                mInstance = new TipsInfoReportManager();
            }
            tipsInfoReportManager = mInstance;
            AppMethodBeat.m2505o(75823);
        }
        return tipsInfoReportManager;
    }

    public TipsInfoLog createTipsInfoLog(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.m2504i(75824);
        TMLog.m60588i(TAG, "createTipsInfoLog");
        if (tMOpenSDKAuthorizedInfo == null) {
            AppMethodBeat.m2505o(75824);
            return null;
        }
        TipsInfoLog tipsInfoLog = new TipsInfoLog();
        tipsInfoLog.userId = tMOpenSDKAuthorizedInfo.userId;
        tipsInfoLog.userIdType = tMOpenSDKAuthorizedInfo.userIdType;
        tipsInfoLog.gamePackageName = tMOpenSDKAuthorizedInfo.gamePackageName;
        tipsInfoLog.gameVersionCode = C5046bo.getInt(tMOpenSDKAuthorizedInfo.gameVersionCode, 0);
        tipsInfoLog.gameChannelId = tMOpenSDKAuthorizedInfo.gameChannelId;
        AppMethodBeat.m2505o(75824);
        return tipsInfoLog;
    }

    /* Access modifiers changed, original: protected */
    public BaseLogTable getLogTable() {
        AppMethodBeat.m2504i(75825);
        TipsInfoLogTable instance = TipsInfoLogTable.getInstance();
        AppMethodBeat.m2505o(75825);
        return instance;
    }

    /* Access modifiers changed, original: protected */
    public byte getReportType() {
        return (byte) 1;
    }
}
