package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

public final class d {
    private static final String lvq = (e.euZ + "uploaded_photos/");
    private static final String lvr = (e.euZ + "temp/");

    static {
        AppMethodBeat.i(19438);
        AppMethodBeat.o(19438);
    }

    public static b bpj() {
        AppMethodBeat.i(19437);
        b bVar = new b(lvq);
        if (!(bVar.exists() && bVar.isDirectory())) {
            bVar.mkdirs();
        }
        AppMethodBeat.o(19437);
        return bVar;
    }

    public static String Km(String str) {
        String str2;
        AppMethodBeat.i(19436);
        if (bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            str2 = j.w(new b(bpj(), ag.ck(str) + "_t").dMD());
        }
        com.tencent.mm.sdk.platformtools.d.c(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        AppMethodBeat.o(19436);
        return str2;
    }
}
