package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class URIActionRequest extends JceStruct {
    public String uri = "";

    public URIActionRequest(String str) {
        this.uri = str;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76012);
        jceOutputStream.write(this.uri, 0);
        AppMethodBeat.m2505o(76012);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76013);
        this.uri = jceInputStream.readString(0, true);
        AppMethodBeat.m2505o(76013);
    }
}
