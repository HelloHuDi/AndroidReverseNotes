package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class dt extends LinkedHashMap<String, String> {
    dt(ds dsVar, int i, float f, boolean z) {
        super(8, 1.0f, true);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean removeEldestEntry(Entry<String, String> entry) {
        AppMethodBeat.i(98745);
        if (size() > 8) {
            AppMethodBeat.o(98745);
            return true;
        }
        AppMethodBeat.o(98745);
        return false;
    }
}
