package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class QueryLoginInfoRequest extends JceStruct {
    public String addtion = "";

    public QueryLoginInfoRequest(String str) {
        this.addtion = str;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76008);
        if (this.addtion != null) {
            jceOutputStream.write(this.addtion, 0);
        }
        AppMethodBeat.m2505o(76008);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76009);
        this.addtion = jceInputStream.readString(0, false);
        AppMethodBeat.m2505o(76009);
    }
}
