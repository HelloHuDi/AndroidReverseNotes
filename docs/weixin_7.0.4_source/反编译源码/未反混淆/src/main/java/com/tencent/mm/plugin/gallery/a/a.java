package com.tencent.mm.plugin.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a {
    public static void swap(List<?> list, int i, int i2) {
        AppMethodBeat.i(21620);
        if (i > i2) {
            while (i > i2) {
                Collections.swap(list, i, i - 1);
                i--;
            }
            AppMethodBeat.o(21620);
            return;
        }
        while (i < i2) {
            Collections.swap(list, i, i + 1);
            i++;
        }
        AppMethodBeat.o(21620);
    }
}
