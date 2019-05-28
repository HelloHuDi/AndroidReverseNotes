package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.dt */
final class C46777dt extends LinkedHashMap<String, String> {
    C46777dt(C44508ds c44508ds, int i, float f, boolean z) {
        super(8, 1.0f, true);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean removeEldestEntry(Entry<String, String> entry) {
        AppMethodBeat.m2504i(98745);
        if (size() > 8) {
            AppMethodBeat.m2505o(98745);
            return true;
        }
        AppMethodBeat.m2505o(98745);
        return false;
    }
}
