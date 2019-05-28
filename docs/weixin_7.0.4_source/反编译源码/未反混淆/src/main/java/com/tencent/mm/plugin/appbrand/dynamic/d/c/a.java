package com.tencent.mm.plugin.appbrand.dynamic.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a implements com.tencent.mm.z.d.a {
    private static final int hnY = (-bo.getInt(ae.giu, 0));
    private byte[] hnZ;
    private String id;

    static {
        AppMethodBeat.i(10901);
        AppMethodBeat.o(10901);
    }

    public a(String str, byte[] bArr) {
        this.id = str;
        this.hnZ = bArr;
    }

    public final boolean jB(int i) {
        byte b;
        AppMethodBeat.i(10900);
        int i2 = hnY;
        if (i2 == -1) {
            ab.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", this.id, Integer.valueOf(i));
            b = (byte) 1;
        } else if (i2 == -2) {
            ab.d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", this.id, Integer.valueOf(i));
            b = (byte) 0;
        } else {
            b = i == -2 ? (byte) 1 : i == -1 ? (byte) 0 : (this.hnZ == null || i < 0 || i >= this.hnZ.length) ? (byte) 0 : this.hnZ[i];
        }
        if (b == (byte) 1) {
            AppMethodBeat.o(10900);
            return true;
        }
        AppMethodBeat.o(10900);
        return false;
    }
}
