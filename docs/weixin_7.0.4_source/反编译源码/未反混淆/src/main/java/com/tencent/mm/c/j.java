package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    public static int getInt(String str, int i) {
        AppMethodBeat.i(125685);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.o(125685);
                    return i;
                }
            } catch (NumberFormatException e) {
                AppMethodBeat.o(125685);
            }
        }
        AppMethodBeat.o(125685);
        return i;
    }
}
