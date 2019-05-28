package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzgk {
    private static Map<String, CapabilityInfo> zza(List<zzah> list) {
        AppMethodBeat.i(71371);
        HashMap hashMap = new HashMap();
        if (list != null) {
            for (zzah zzah : list) {
                hashMap.put(zzah.getName(), new zzw(zzah));
            }
        }
        AppMethodBeat.o(71371);
        return hashMap;
    }

    static /* synthetic */ Map zzb(List list) {
        AppMethodBeat.i(71372);
        Map zza = zza(list);
        AppMethodBeat.o(71372);
        return zza;
    }
}
