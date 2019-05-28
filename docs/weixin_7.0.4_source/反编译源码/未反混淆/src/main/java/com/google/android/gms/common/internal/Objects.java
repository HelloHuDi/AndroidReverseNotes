package com.google.android.gms.common.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects {

    public static final class ToStringHelper {
        private final List<String> zzul;
        private final Object zzum;

        private ToStringHelper(Object obj) {
            AppMethodBeat.i(89683);
            this.zzum = Preconditions.checkNotNull(obj);
            this.zzul = new ArrayList();
            AppMethodBeat.o(89683);
        }

        /* synthetic */ ToStringHelper(Object obj, zzj zzj) {
            this(obj);
        }

        public final ToStringHelper add(String str, Object obj) {
            AppMethodBeat.i(89684);
            List list = this.zzul;
            String str2 = (String) Preconditions.checkNotNull(str);
            String valueOf = String.valueOf(obj);
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            AppMethodBeat.o(89684);
            return this;
        }

        public final ToStringHelper addValue(Object obj) {
            AppMethodBeat.i(89685);
            this.zzul.add(String.valueOf(obj));
            AppMethodBeat.o(89685);
            return this;
        }

        public final String toString() {
            AppMethodBeat.i(89686);
            StringBuilder append = new StringBuilder(100).append(this.zzum.getClass().getSimpleName()).append('{');
            int size = this.zzul.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.zzul.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            String stringBuilder = append.append('}').toString();
            AppMethodBeat.o(89686);
            return stringBuilder;
        }
    }

    private Objects() {
        AppMethodBeat.i(89690);
        AssertionError assertionError = new AssertionError("Uninstantiable");
        AppMethodBeat.o(89690);
        throw assertionError;
    }

    public static boolean equal(Object obj, Object obj2) {
        AppMethodBeat.i(89687);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.o(89687);
            return true;
        }
        AppMethodBeat.o(89687);
        return false;
    }

    public static int hashCode(Object... objArr) {
        AppMethodBeat.i(89688);
        int hashCode = Arrays.hashCode(objArr);
        AppMethodBeat.o(89688);
        return hashCode;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        AppMethodBeat.i(89689);
        ToStringHelper toStringHelper = new ToStringHelper(obj, null);
        AppMethodBeat.o(89689);
        return toStringHelper;
    }
}
