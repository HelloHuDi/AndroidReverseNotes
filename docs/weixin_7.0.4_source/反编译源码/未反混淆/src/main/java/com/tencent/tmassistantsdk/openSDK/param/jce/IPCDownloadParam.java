package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCDownloadParam extends JceStruct {
    static IPCBaseParam cache_baseParam;
    public String actionFlag = "";
    public IPCBaseParam baseParam = null;
    public String opList = "";
    public String reverse = "";
    public String verifyType = "";

    public IPCDownloadParam(IPCBaseParam iPCBaseParam, String str, String str2, String str3, String str4) {
        this.baseParam = iPCBaseParam;
        this.opList = str;
        this.actionFlag = str2;
        this.verifyType = str3;
        this.reverse = str4;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(75992);
        jceOutputStream.write(this.baseParam, 0);
        if (this.opList != null) {
            jceOutputStream.write(this.opList, 1);
        }
        if (this.actionFlag != null) {
            jceOutputStream.write(this.actionFlag, 2);
        }
        if (this.verifyType != null) {
            jceOutputStream.write(this.verifyType, 3);
        }
        if (this.reverse != null) {
            jceOutputStream.write(this.reverse, 4);
        }
        AppMethodBeat.o(75992);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(75993);
        if (cache_baseParam == null) {
            cache_baseParam = new IPCBaseParam();
        }
        this.baseParam = (IPCBaseParam) jceInputStream.read(cache_baseParam, 0, true);
        this.opList = jceInputStream.readString(1, false);
        this.actionFlag = jceInputStream.readString(2, false);
        this.verifyType = jceInputStream.readString(3, false);
        this.reverse = jceInputStream.readString(4, false);
        AppMethodBeat.o(75993);
    }
}
