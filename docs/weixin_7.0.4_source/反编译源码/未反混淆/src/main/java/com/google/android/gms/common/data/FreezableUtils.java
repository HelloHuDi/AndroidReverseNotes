package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        AppMethodBeat.i(61136);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((Freezable) arrayList.get(i)).freeze());
        }
        AppMethodBeat.o(61136);
        return arrayList2;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        AppMethodBeat.i(61137);
        ArrayList arrayList = new ArrayList(eArr.length);
        for (Freezable freeze : eArr) {
            arrayList.add(freeze.freeze());
        }
        AppMethodBeat.o(61137);
        return arrayList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        AppMethodBeat.i(61138);
        ArrayList arrayList = new ArrayList();
        for (E freeze : iterable) {
            arrayList.add(freeze.freeze());
        }
        AppMethodBeat.o(61138);
        return arrayList;
    }
}
