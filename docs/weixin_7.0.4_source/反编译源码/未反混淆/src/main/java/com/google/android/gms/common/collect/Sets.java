package com.google.android.gms.common.collect;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static <E> Set<E> difference(Set<? extends E> set, Set<? extends E> set2) {
        AppMethodBeat.i(89519);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(set2);
        HashSet hashSet = new HashSet();
        for (Object next : set) {
            if (!set2.contains(next)) {
                hashSet.add(next);
            }
        }
        AppMethodBeat.o(89519);
        return hashSet;
    }

    public static <E> Set<E> union(Iterable<Set<E>> iterable) {
        AppMethodBeat.i(89518);
        Preconditions.checkNotNull(iterable);
        HashSet hashSet = new HashSet();
        for (Set addAll : iterable) {
            hashSet.addAll(addAll);
        }
        AppMethodBeat.o(89518);
        return hashSet;
    }

    public static <E> Set<E> union(Set<? extends E> set, Set<? extends E> set2) {
        AppMethodBeat.i(89517);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(set2);
        HashSet hashSet = new HashSet(set);
        hashSet.addAll(set2);
        AppMethodBeat.o(89517);
        return hashSet;
    }
}
