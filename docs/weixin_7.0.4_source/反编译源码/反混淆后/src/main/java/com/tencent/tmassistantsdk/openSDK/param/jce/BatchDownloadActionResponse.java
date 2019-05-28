package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class BatchDownloadActionResponse extends JceStruct {
    static ArrayList<IPCQueryDownloadInfo> cache_batchData;
    public ArrayList<IPCQueryDownloadInfo> batchData = null;
    public int batchRequestType = 0;

    public BatchDownloadActionResponse(int i, ArrayList<IPCQueryDownloadInfo> arrayList) {
        this.batchRequestType = i;
        this.batchData = arrayList;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(75980);
        jceOutputStream.write(this.batchRequestType, 0);
        if (this.batchData != null) {
            jceOutputStream.write(this.batchData, 1);
        }
        AppMethodBeat.m2505o(75980);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(75981);
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (cache_batchData == null) {
            cache_batchData = new ArrayList();
            cache_batchData.add(new IPCQueryDownloadInfo());
        }
        this.batchData = (ArrayList) jceInputStream.read(cache_batchData, 1, false);
        AppMethodBeat.m2505o(75981);
    }
}
