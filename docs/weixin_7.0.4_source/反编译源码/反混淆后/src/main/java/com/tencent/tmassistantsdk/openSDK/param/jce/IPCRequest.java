package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCRequest extends JceStruct {
    static byte[] cache_body;
    static IPCHead cache_head;
    public byte[] body = null;
    public IPCHead head = null;

    public IPCRequest(IPCHead iPCHead, byte[] bArr) {
        this.head = iPCHead;
        this.body = bArr;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(75998);
        jceOutputStream.write(this.head, 0);
        if (this.body != null) {
            jceOutputStream.write(this.body, 1);
        }
        AppMethodBeat.m2505o(75998);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(75999);
        if (cache_head == null) {
            cache_head = new IPCHead();
        }
        this.head = (IPCHead) jceInputStream.read(cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = (byte) 0;
        }
        this.body = jceInputStream.read(cache_body, 1, false);
        AppMethodBeat.m2505o(75999);
    }
}
