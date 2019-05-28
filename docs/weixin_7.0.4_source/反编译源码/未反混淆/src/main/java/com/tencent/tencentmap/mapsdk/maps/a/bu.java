package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class bu {
    public int a = -1;
    public int b = -1;
    private String c = "";
    private int d = -1;
    private byte e;
    private byte f = (byte) 1;
    private String[] g;

    public bu(String str, int i) {
        this.c = str;
        this.d = i;
    }

    public final String a() {
        return this.c;
    }

    public final void a(byte b) {
        this.e = (byte) 3;
    }

    public final boolean a(bu buVar) {
        AppMethodBeat.i(98584);
        if (buVar != null && this.c.equals(buVar.c) && this.d == buVar.d) {
            AppMethodBeat.o(98584);
            return true;
        }
        AppMethodBeat.o(98584);
        return false;
    }

    public final boolean a(String str) {
        AppMethodBeat.i(98582);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98582);
            return false;
        }
        this.g = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (this.g.length != 2) {
            AppMethodBeat.o(98582);
            return false;
        }
        this.c = this.g[0];
        if (eu.d(this.c)) {
            try {
                this.d = Integer.parseInt(this.g[1]);
                if (this.d < 0 || this.d > CdnLogic.kBizGeneric) {
                    AppMethodBeat.o(98582);
                    return false;
                }
                AppMethodBeat.o(98582);
                return true;
            } catch (NumberFormatException e) {
                AppMethodBeat.o(98582);
                return false;
            }
        }
        AppMethodBeat.o(98582);
        return false;
    }

    public final byte b() {
        return this.e;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        AppMethodBeat.i(98581);
        String str = this.c + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.d;
        AppMethodBeat.o(98581);
        return str;
    }

    public final boolean e() {
        return this.e == (byte) 3;
    }

    public final String toString() {
        AppMethodBeat.i(98583);
        String str = this.c + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.d + ",protocalType:" + this.f + ",ipType:" + this.e;
        AppMethodBeat.o(98583);
        return str;
    }
}
