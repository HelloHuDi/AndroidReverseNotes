package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ListUtils {
    private ListUtils() {
    }

    public static <T> ArrayList<T> copyAndRemoveElementFromListIfPresent(List<T> list, T t) {
        AppMethodBeat.i(90247);
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (t == null || !t.equals(obj)) {
                arrayList.add(obj);
            }
        }
        AppMethodBeat.o(90247);
        return arrayList;
    }

    public static <T> ArrayList<T> copyAndRemoveElementsFromListIfPresent(List<T> list, Collection<T> collection) {
        AppMethodBeat.i(90248);
        Preconditions.checkNotNull(collection);
        ArrayList arrayList = new ArrayList(list.size());
        for (Object next : list) {
            if (!collection.contains(next)) {
                arrayList.add(next);
            }
        }
        AppMethodBeat.o(90248);
        return arrayList;
    }
}
