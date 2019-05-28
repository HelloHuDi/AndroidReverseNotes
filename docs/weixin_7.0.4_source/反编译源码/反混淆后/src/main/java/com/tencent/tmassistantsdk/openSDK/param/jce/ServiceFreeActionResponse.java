package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ServiceFreeActionResponse extends JceStruct {
    static byte[] cache_revertField;
    public byte[] revertField = null;

    public ServiceFreeActionResponse(byte[] bArr) {
        this.revertField = bArr;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76010);
        if (this.revertField != null) {
            jceOutputStream.write(this.revertField, 0);
        }
        AppMethodBeat.m2505o(76010);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76011);
        if (cache_revertField == null) {
            byte[] bArr = new byte[1];
            cache_revertField = bArr;
            bArr[0] = (byte) 0;
        }
        this.revertField = jceInputStream.read(cache_revertField, 0, false);
        AppMethodBeat.m2505o(76011);
    }
}
