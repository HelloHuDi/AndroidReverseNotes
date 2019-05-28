package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.net.InetAddress;

public final class c {
    private InetAddress geK;
    private int port;
    private int type;

    private c(InetAddress inetAddress, int i, int i2) {
        this.geK = inetAddress;
        this.port = i;
        this.type = i2;
    }

    public final String toString() {
        AppMethodBeat.i(58715);
        String str = "hc";
        if (this.type == 2) {
            str = "dns";
        } else if (this.type == 3) {
            str = "svrdns";
        } else if (this.type == 4) {
            str = "waphc";
        } else if (this.type == 5) {
            str = "newdns";
        } else if (this.type == 6) {
            str = "auth";
        } else if (this.type == 7) {
            str = "debug";
        }
        str = this.geK.getHostAddress() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.port + "(" + str + ")";
        AppMethodBeat.o(58715);
        return str;
    }

    public static c vd(String str) {
        AppMethodBeat.i(58716);
        if (str == null) {
            AppMethodBeat.o(58716);
            return null;
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (split == null || split.length != 3) {
            AppMethodBeat.o(58716);
            return null;
        }
        try {
            c cVar = new c(t.ams(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            AppMethodBeat.o(58716);
            return cVar;
        } catch (Exception e) {
            ab.e("MicroMsg.InAddress", "exception:%s", bo.l(e));
            AppMethodBeat.o(58716);
            return null;
        }
    }
}
