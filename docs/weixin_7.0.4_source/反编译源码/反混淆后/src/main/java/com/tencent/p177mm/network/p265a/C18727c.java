package com.tencent.p177mm.network.p265a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5065t;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.net.InetAddress;

/* renamed from: com.tencent.mm.network.a.c */
public final class C18727c {
    private InetAddress geK;
    private int port;
    private int type;

    private C18727c(InetAddress inetAddress, int i, int i2) {
        this.geK = inetAddress;
        this.port = i;
        this.type = i2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(58715);
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
        AppMethodBeat.m2505o(58715);
        return str;
    }

    /* renamed from: vd */
    public static C18727c m29288vd(String str) {
        AppMethodBeat.m2504i(58716);
        if (str == null) {
            AppMethodBeat.m2505o(58716);
            return null;
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (split == null || split.length != 3) {
            AppMethodBeat.m2505o(58716);
            return null;
        }
        try {
            C18727c c18727c = new C18727c(C5065t.ams(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            AppMethodBeat.m2505o(58716);
            return c18727c;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.InAddress", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58716);
            return null;
        }
    }
}
