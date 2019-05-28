package com.tencent.p177mm.pluginsdk.p1568d.p1569a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.ext.p962b.C27903a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.d.a.a */
public final class C40420a {
    public static final String[] vaM = new String[]{"retCode", "url"};

    /* renamed from: Kn */
    public static MatrixCursor m69330Kn(int i) {
        AppMethodBeat.m2504i(27228);
        C4990ab.m7416i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(i)));
        MatrixCursor matrixCursor = new MatrixCursor(C27903a.lPA);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i)});
        AppMethodBeat.m2505o(27228);
        return matrixCursor;
    }

    public static MatrixCursor aiv(String str) {
        AppMethodBeat.m2504i(27229);
        C4990ab.m7416i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
        MatrixCursor matrixCursor = new MatrixCursor(vaM);
        matrixCursor.addRow(new Object[]{Integer.valueOf(4207), str});
        AppMethodBeat.m2505o(27229);
        return matrixCursor;
    }
}
