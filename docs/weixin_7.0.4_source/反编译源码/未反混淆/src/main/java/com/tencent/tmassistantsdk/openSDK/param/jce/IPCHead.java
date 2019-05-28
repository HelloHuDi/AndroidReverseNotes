package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCHead extends JceStruct {
    public int cmdId = 0;
    public String hostPackageName = "";
    public String hostVersionCode = "";
    public int requestId = 0;

    public IPCHead(int i, int i2, String str, String str2) {
        this.requestId = i;
        this.cmdId = i2;
        this.hostPackageName = str;
        this.hostVersionCode = str2;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(75994);
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.hostPackageName, 2);
        jceOutputStream.write(this.hostVersionCode, 3);
        AppMethodBeat.o(75994);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(75995);
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.hostPackageName = jceInputStream.readString(2, true);
        this.hostVersionCode = jceInputStream.readString(3, true);
        AppMethodBeat.o(75995);
    }
}
