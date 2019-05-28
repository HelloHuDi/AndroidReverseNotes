package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class zzb implements Comparator<Integer> {
    private final /* synthetic */ Comparator zzom;
    private final /* synthetic */ SortedDataBuffer zzon;

    zzb(SortedDataBuffer sortedDataBuffer, Comparator comparator) {
        this.zzon = sortedDataBuffer;
        this.zzom = comparator;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(61199);
        int compare = this.zzom.compare(this.zzon.zzok.get(((Integer) obj).intValue()), this.zzon.zzok.get(((Integer) obj2).intValue()));
        AppMethodBeat.o(61199);
        return compare;
    }
}
