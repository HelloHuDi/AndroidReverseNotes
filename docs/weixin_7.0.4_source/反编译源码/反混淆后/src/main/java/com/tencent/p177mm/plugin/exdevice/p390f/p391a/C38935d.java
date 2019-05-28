package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5736j;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.d */
public final class C38935d {
    private static final String lvq = (C6457e.euZ + "uploaded_photos/");
    private static final String lvr = (C6457e.euZ + "temp/");

    static {
        AppMethodBeat.m2504i(19438);
        AppMethodBeat.m2505o(19438);
    }

    public static C5728b bpj() {
        AppMethodBeat.m2504i(19437);
        C5728b c5728b = new C5728b(lvq);
        if (!(c5728b.exists() && c5728b.isDirectory())) {
            c5728b.mkdirs();
        }
        AppMethodBeat.m2505o(19437);
        return c5728b;
    }

    /* renamed from: Km */
    public static String m66101Km(String str) {
        String str2;
        AppMethodBeat.m2504i(19436);
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
        } else {
            str2 = C5736j.m8649w(new C5728b(C38935d.bpj(), C4995ag.m7428ck(str) + "_t").dMD());
        }
        C5056d.m7656c(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        AppMethodBeat.m2505o(19436);
        return str2;
    }
}
