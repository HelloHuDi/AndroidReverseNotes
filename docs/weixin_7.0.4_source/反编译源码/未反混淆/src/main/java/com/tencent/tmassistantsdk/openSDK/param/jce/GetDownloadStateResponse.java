package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GetDownloadStateResponse extends JceStruct {
    static IPCBaseParam cache_requestParam;
    public int errorCode = 0;
    public String errorMsg = "";
    public IPCBaseParam requestParam = null;
    public int state = 0;

    public GetDownloadStateResponse(IPCBaseParam iPCBaseParam, int i, int i2, String str) {
        this.requestParam = iPCBaseParam;
        this.state = i;
        this.errorCode = i2;
        this.errorMsg = str;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(75984);
        jceOutputStream.write(this.requestParam, 0);
        jceOutputStream.write(this.state, 1);
        jceOutputStream.write(this.errorCode, 2);
        if (this.errorMsg != null) {
            jceOutputStream.write(this.errorMsg, 3);
        }
        AppMethodBeat.o(75984);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(75985);
        if (cache_requestParam == null) {
            cache_requestParam = new IPCBaseParam();
        }
        this.requestParam = (IPCBaseParam) jceInputStream.read(cache_requestParam, 0, true);
        this.state = jceInputStream.read(this.state, 1, false);
        this.errorCode = jceInputStream.read(this.errorCode, 2, false);
        this.errorMsg = jceInputStream.readString(3, false);
        AppMethodBeat.o(75985);
    }
}
