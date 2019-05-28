package com.tencent.tmassistantsdk.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import java.util.ArrayList;

public class DBManager {
    protected static DBManager mInstance = null;

    public static synchronized DBManager getInstance() {
        DBManager dBManager;
        synchronized (DBManager.class) {
            AppMethodBeat.m2504i(76160);
            if (mInstance == null) {
                mInstance = new DBManager();
            }
            dBManager = mInstance;
            AppMethodBeat.m2505o(76160);
        }
        return dBManager;
    }

    public ArrayList<DownloadInfo> queryDownloadInfoList() {
        AppMethodBeat.m2504i(76161);
        ArrayList load = DownloadInfoTable.load();
        AppMethodBeat.m2505o(76161);
        return load;
    }

    public void saveDownloadInfoList(ArrayList<DownloadInfo> arrayList) {
        AppMethodBeat.m2504i(76162);
        DownloadInfoTable.save(arrayList);
        AppMethodBeat.m2505o(76162);
    }

    public void addDownloadInfo(DownloadInfo downloadInfo) {
        AppMethodBeat.m2504i(76163);
        DownloadInfoTable.add(downloadInfo);
        AppMethodBeat.m2505o(76163);
    }

    public void deleteDownloadInfo(String str) {
        AppMethodBeat.m2504i(76164);
        DownloadInfoTable.del(str);
        ClientInfoTable.deleteItemsByURL(str);
        AppMethodBeat.m2505o(76164);
    }

    public DownloadInfo queryDownloadInfoByUrl(String str) {
        AppMethodBeat.m2504i(76165);
        DownloadInfo query = DownloadInfoTable.query(str);
        AppMethodBeat.m2505o(76165);
        return query;
    }

    public ArrayList<ServiceDownloadTask> queryWaitingAndDownloadingTaskList() {
        AppMethodBeat.m2504i(76166);
        ArrayList query = DownloadInfoTable.query();
        AppMethodBeat.m2505o(76166);
        return query;
    }

    public void saveClientInfo(String str, String str2) {
        AppMethodBeat.m2504i(76167);
        ClientInfoTable.save(str, str2);
        AppMethodBeat.m2505o(76167);
    }
}
