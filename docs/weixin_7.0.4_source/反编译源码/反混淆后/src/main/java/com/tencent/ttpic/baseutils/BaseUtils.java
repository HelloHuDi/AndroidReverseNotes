package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class BaseUtils {
    public static boolean isEmpty(Collection collection) {
        AppMethodBeat.m2504i(49591);
        if (collection == null || collection.isEmpty()) {
            AppMethodBeat.m2505o(49591);
            return true;
        }
        AppMethodBeat.m2505o(49591);
        return false;
    }

    public static int size(Collection collection) {
        AppMethodBeat.m2504i(49592);
        if (collection == null) {
            AppMethodBeat.m2505o(49592);
            return 0;
        }
        int size = collection.size();
        AppMethodBeat.m2505o(49592);
        return size;
    }

    public static int size(Object[] objArr) {
        return objArr == null ? 0 : objArr.length;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(49593);
        if (charSequence == null || !charSequence.equals(charSequence2)) {
            AppMethodBeat.m2505o(49593);
            return false;
        }
        AppMethodBeat.m2505o(49593);
        return true;
    }

    public static boolean indexOutOfBounds(Collection collection, int i) {
        AppMethodBeat.m2504i(49594);
        if (collection == null || i < 0 || i >= collection.size()) {
            AppMethodBeat.m2505o(49594);
            return true;
        }
        AppMethodBeat.m2505o(49594);
        return false;
    }
}
