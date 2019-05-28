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
            AppMethodBeat.i(76160);
            if (mInstance == null) {
                mInstance = new DBManager();
            }
            dBManager = mInstance;
            AppMethodBeat.o(76160);
        }
        return dBManager;
    }

    public ArrayList<DownloadInfo> queryDownloadInfoList() {
        AppMethodBeat.i(76161);
        ArrayList load = DownloadInfoTable.load();
        AppMethodBeat.o(76161);
        return load;
    }

    public void saveDownloadInfoList(ArrayList<DownloadInfo> arrayList) {
        AppMethodBeat.i(76162);
        DownloadInfoTable.save(arrayList);
        AppMethodBeat.o(76162);
    }

    public void addDownloadInfo(DownloadInfo downloadInfo) {
        AppMethodBeat.i(76163);
        DownloadInfoTable.add(downloadInfo);
        AppMethodBeat.o(76163);
    }

    public void deleteDownloadInfo(String str) {
        AppMethodBeat.i(76164);
        DownloadInfoTable.del(str);
        ClientInfoTable.deleteItemsByURL(str);
        AppMethodBeat.o(76164);
    }

    public DownloadInfo queryDownloadInfoByUrl(String str) {
        AppMethodBeat.i(76165);
        DownloadInfo query = DownloadInfoTable.query(str);
        AppMethodBeat.o(76165);
        return query;
    }

    public ArrayList<ServiceDownloadTask> queryWaitingAndDownloadingTaskList() {
        AppMethodBeat.i(76166);
        ArrayList query = DownloadInfoTable.query();
        AppMethodBeat.o(76166);
        return query;
    }

    public void saveClientInfo(String str, String str2) {
        AppMethodBeat.i(76167);
        ClientInfoTable.save(str, str2);
        AppMethodBeat.o(76167);
    }
}
