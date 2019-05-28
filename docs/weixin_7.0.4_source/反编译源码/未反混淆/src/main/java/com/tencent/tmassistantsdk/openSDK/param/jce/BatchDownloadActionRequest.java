package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class BatchDownloadActionRequest extends JceStruct {
    static ArrayList<IPCDownloadParam> cache_batchData;
    public ArrayList<IPCDownloadParam> batchData = null;
    public int batchRequestType = 0;
    public String uin = "";
    public String uinType = "";
    public String via = "";

    public BatchDownloadActionRequest(int i, ArrayList<IPCDownloadParam> arrayList, String str, String str2, String str3) {
        this.batchRequestType = i;
        this.batchData = arrayList;
        this.uin = str;
        this.uinType = str2;
        this.via = str3;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(75978);
        jceOutputStream.write(this.batchRequestType, 0);
        if (this.batchData != null) {
            jceOutputStream.write(this.batchData, 1);
        }
        if (this.uin != null) {
            jceOutputStream.write(this.uin, 2);
        }
        if (this.uinType != null) {
            jceOutputStream.write(this.uinType, 3);
        }
        if (this.via != null) {
            jceOutputStream.write(this.via, 4);
        }
        AppMethodBeat.o(75978);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(75979);
        this.batchRequestType = jceInputStream.read(this.batchRequestType, 0, true);
        if (cache_batchData == null) {
            cache_batchData = new ArrayList();
            cache_batchData.add(new IPCDownloadParam());
        }
        this.batchData = (ArrayList) jceInputStream.read(cache_batchData, 1, false);
        this.uin = jceInputStream.readString(2, false);
        this.uinType = jceInputStream.readString(3, false);
        this.via = jceInputStream.readString(4, false);
        AppMethodBeat.o(75979);
    }
}
