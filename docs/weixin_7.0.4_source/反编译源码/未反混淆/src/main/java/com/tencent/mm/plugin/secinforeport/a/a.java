package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public enum a {
    ;
    
    private static b qjn;

    private a(String str) {
    }

    static {
        qjn = new b() {
            public final void a(int i, String str, int i2, byte[] bArr) {
                AppMethodBeat.i(126171);
                ab.i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
                AppMethodBeat.o(126171);
            }
        };
        AppMethodBeat.o(126177);
    }

    public static void a(b bVar) {
        if (bVar != null) {
            qjn = bVar;
        }
    }

    public static void h(int i, String str, int i2) {
        AppMethodBeat.i(126174);
        ab.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", Integer.valueOf(i), str, Integer.valueOf(i2));
        qjn.a(i, str, i2, null);
        AppMethodBeat.o(126174);
    }

    public static void i(String str, int i, int i2, String str2) {
        AppMethodBeat.i(126175);
        ab.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d, %d, %s", Integer.valueOf(3), str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        cvl cvl = new cvl();
        cvl.wDR = i2;
        cvl.xrw = str2;
        byte[] bArr = null;
        try {
            bArr = cvl.toByteArray();
        } catch (IOException e) {
            ab.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e.getMessage());
        }
        qjn.a(3, str, i, bArr);
        AppMethodBeat.o(126175);
    }

    public static void D(int i, String str, String str2) {
        AppMethodBeat.i(126176);
        ab.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", Integer.valueOf(5), Integer.valueOf(i), str, str2);
        bbi bbi = new bbi();
        bbi.csB = str;
        bbi.pQw = str2;
        byte[] bArr = null;
        try {
            bArr = bbi.toByteArray();
        } catch (IOException e) {
            ab.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e.getMessage());
        }
        qjn.a(5, "", i, bArr);
        AppMethodBeat.o(126176);
    }
}
