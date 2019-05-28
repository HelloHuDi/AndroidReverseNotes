package com.tencent.tmassistantsdk.logreport;

import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.network.PostHttpRequest;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogRequest;
import com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable.DataWrapper;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportHttpRequest extends PostHttpRequest {
    protected ILogReportHttpListener mListener = null;

    public boolean sendLogDataToServer(byte b, DataWrapper dataWrapper) {
        AppMethodBeat.m2504i(75815);
        if (dataWrapper == null) {
            AppMethodBeat.m2505o(75815);
            return false;
        }
        boolean sendRequest = super.sendRequest((ReportLogRequest) ProtocolPackage.buildReportRequest(b, dataWrapper.dataList, GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext()), GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()), ""));
        AppMethodBeat.m2505o(75815);
        return sendRequest;
    }

    public void setmListener(ILogReportHttpListener iLogReportHttpListener) {
        this.mListener = iLogReportHttpListener;
    }

    public void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i) {
        AppMethodBeat.m2504i(75816);
        if (jceStruct2 == null) {
            AppMethodBeat.m2505o(75816);
        } else if (this.mListener == null || i != 0) {
            TMLog.m60588i("LogReportHttpRequest", "mListener is null !");
            AppMethodBeat.m2505o(75816);
        } else if (!(jceStruct2 instanceof ReportLogResponse)) {
            TMLog.m60588i("LogReportHttpRequest", "response isn't instanceof ReportLogResponse !");
            AppMethodBeat.m2505o(75816);
        } else if (((ReportLogResponse) jceStruct2).ret == 0) {
            this.mListener.onLogReprotHttpRequestFinish(this, true);
            AppMethodBeat.m2505o(75816);
        } else {
            this.mListener.onLogReprotHttpRequestFinish(this, false);
            AppMethodBeat.m2505o(75816);
        }
    }
}
