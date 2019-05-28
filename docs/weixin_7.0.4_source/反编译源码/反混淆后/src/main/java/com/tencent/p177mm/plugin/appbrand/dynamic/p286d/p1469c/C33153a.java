package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p1469c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p654d.C5759a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.c.a */
public final class C33153a implements C5759a {
    private static final int hnY = (-C5046bo.getInt(C1947ae.giu, 0));
    private byte[] hnZ;
    /* renamed from: id */
    private String f15029id;

    static {
        AppMethodBeat.m2504i(10901);
        AppMethodBeat.m2505o(10901);
    }

    public C33153a(String str, byte[] bArr) {
        this.f15029id = str;
        this.hnZ = bArr;
    }

    /* renamed from: jB */
    public final boolean mo11735jB(int i) {
        byte b;
        AppMethodBeat.m2504i(10900);
        int i2 = hnY;
        if (i2 == -1) {
            C4990ab.m7411d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", this.f15029id, Integer.valueOf(i));
            b = (byte) 1;
        } else if (i2 == -2) {
            C4990ab.m7411d("MicroMsg.DefaultPermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", this.f15029id, Integer.valueOf(i));
            b = (byte) 0;
        } else {
            b = i == -2 ? (byte) 1 : i == -1 ? (byte) 0 : (this.hnZ == null || i < 0 || i >= this.hnZ.length) ? (byte) 0 : this.hnZ[i];
        }
        if (b == (byte) 1) {
            AppMethodBeat.m2505o(10900);
            return true;
        }
        AppMethodBeat.m2505o(10900);
        return false;
    }
}
