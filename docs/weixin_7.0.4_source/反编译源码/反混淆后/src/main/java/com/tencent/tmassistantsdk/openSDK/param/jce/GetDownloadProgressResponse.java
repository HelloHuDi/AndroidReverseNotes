package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GetDownloadProgressResponse extends JceStruct {
    static IPCBaseParam cache_requestParam;
    public long allTaskTotalLength = 0;
    public long allTaskTotalProgress = 0;
    public long receivedLen = 0;
    public IPCBaseParam requestParam = null;
    public long totalLen = 0;

    public GetDownloadProgressResponse(IPCBaseParam iPCBaseParam, long j, long j2, long j3, long j4) {
        this.requestParam = iPCBaseParam;
        this.receivedLen = j;
        this.totalLen = j2;
        this.allTaskTotalProgress = j3;
        this.allTaskTotalLength = j4;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(75982);
        jceOutputStream.write(this.requestParam, 0);
        jceOutputStream.write(this.receivedLen, 1);
        jceOutputStream.write(this.totalLen, 2);
        jceOutputStream.write(this.allTaskTotalProgress, 3);
        jceOutputStream.write(this.allTaskTotalLength, 4);
        AppMethodBeat.m2505o(75982);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(75983);
        if (cache_requestParam == null) {
            cache_requestParam = new IPCBaseParam();
        }
        this.requestParam = (IPCBaseParam) jceInputStream.read(cache_requestParam, 0, true);
        this.receivedLen = jceInputStream.read(this.receivedLen, 1, false);
        this.totalLen = jceInputStream.read(this.totalLen, 2, false);
        this.allTaskTotalProgress = jceInputStream.read(this.allTaskTotalProgress, 3, false);
        this.allTaskTotalLength = jceInputStream.read(this.allTaskTotalLength, 4, false);
        AppMethodBeat.m2505o(75983);
    }
}
