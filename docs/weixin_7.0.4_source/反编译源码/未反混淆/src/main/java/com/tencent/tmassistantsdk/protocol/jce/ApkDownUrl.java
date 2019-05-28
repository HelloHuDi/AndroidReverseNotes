package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class ApkDownUrl extends JceStruct {
    static ArrayList<String> cache_urlList;
    public byte type = (byte) 0;
    public ArrayList<String> urlList = null;

    public ApkDownUrl(byte b, ArrayList<String> arrayList) {
        this.type = b;
        this.urlList = arrayList;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76028);
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.urlList, 1);
        AppMethodBeat.o(76028);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76029);
        this.type = jceInputStream.read(this.type, 0, true);
        if (cache_urlList == null) {
            cache_urlList = new ArrayList();
            cache_urlList.add("");
        }
        this.urlList = (ArrayList) jceInputStream.read(cache_urlList, 1, true);
        AppMethodBeat.o(76029);
    }
}
