package com.tencent.mm.pluginsdk.d.a;

import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static final String[] vaM = new String[]{"retCode", "url"};

    public static MatrixCursor Kn(int i) {
        AppMethodBeat.i(27228);
        ab.i("MicroMsg.ExtCommonUtils", "returnMatrix = ".concat(String.valueOf(i)));
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mm.plugin.ext.b.a.lPA);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i)});
        AppMethodBeat.o(27228);
        return matrixCursor;
    }

    public static MatrixCursor aiv(String str) {
        AppMethodBeat.i(27229);
        ab.i("MicroMsg.ExtCommonUtils", "returnMatrix = 4207");
        MatrixCursor matrixCursor = new MatrixCursor(vaM);
        matrixCursor.addRow(new Object[]{Integer.valueOf(4207), str});
        AppMethodBeat.o(27229);
        return matrixCursor;
    }
}
