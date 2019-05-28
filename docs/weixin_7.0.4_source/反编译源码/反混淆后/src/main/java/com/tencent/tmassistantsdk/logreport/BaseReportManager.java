package com.tencent.tmassistantsdk.logreport;

import com.p123qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable;
import com.tencent.tmassistantsdk.storage.table.BaseLogTable.DataWrapper;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseReportManager implements ILogReportHttpListener {
    public static final int MAX_READ_COUNT = 1000;
    protected static final String TAG = "BaseReportManager";
    protected final List<Long> idLists = new ArrayList();
    protected int maxReportCount = 0;
    protected LogReportHttpRequest reportRequest = null;

    public abstract BaseLogTable getLogTable();

    public abstract byte getReportType();

    public void destroy() {
        this.reportRequest = null;
        this.idLists.clear();
    }

    public void cancleRequest() {
        if (this.reportRequest != null) {
            this.reportRequest.cancleRequest();
            this.reportRequest = null;
        }
    }

    public synchronized void addLogData(JceStruct jceStruct) {
        TMLog.m60588i(TAG, "addLogData,loginfo");
        if (jceStruct != null) {
            getLogTable().save(ProtocolPackage.jceStructToUTF8Byte(jceStruct));
        }
    }

    public synchronized void reportLogData() {
        boolean z = false;
        synchronized (this) {
            if (GlobalUtil.getInstance().canReportValue()) {
                TMLog.m60588i(TAG, "reportLogData,request:" + this.reportRequest);
                if (this.reportRequest == null) {
                    this.reportRequest = new LogReportHttpRequest();
                    this.reportRequest.setmListener(this);
                    DataWrapper datas = getLogTable().getDatas(1000);
                    TMLog.m60588i(TAG, "readLogDataAndSendToServer,wrappterCount:" + datas.dataList.size());
                    if (datas != null && datas.dataList.size() > 0) {
                        this.idLists.addAll(datas.idList);
                        z = this.reportRequest.sendLogDataToServer(getReportType(), datas);
                    }
                    if (!z) {
                        this.maxReportCount = 0;
                        this.reportRequest = null;
                    }
                }
            }
        }
    }

    public void onLogReprotHttpRequestFinish(LogReportHttpRequest logReportHttpRequest, boolean z) {
        TMLog.m60588i(TAG, "onLogReprotHttpRequestFinish,result:".concat(String.valueOf(z)));
        if (z && this.idLists != null && this.idLists.size() > 0) {
            getLogTable().delete(this.idLists);
        }
        this.reportRequest = null;
        this.idLists.clear();
        if (z && this.maxReportCount < 5) {
            TMLog.m60588i(TAG, "onLogReprotHttpRequestFinish wifi is true reportlog go on,result:" + z + " count:" + this.maxReportCount);
            reportLogData();
            this.maxReportCount++;
        }
    }

    public void resetMaxReportCount() {
        this.maxReportCount = 0;
    }
}
