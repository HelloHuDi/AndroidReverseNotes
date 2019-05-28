package com.tencent.mm.sdk.platformtools;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s {
    public ArrayMap<String, Object> xyn;
    public boolean xyo;

    public s() {
        AppMethodBeat.i(115188);
        this.xyn = null;
        this.xyo = false;
        this.xyn = new ArrayMap();
        AppMethodBeat.o(115188);
    }

    private static void a(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        AppMethodBeat.i(115189);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key ");
        stringBuilder.append(str);
        stringBuilder.append(" expected ");
        stringBuilder.append(str2);
        stringBuilder.append(" but value was a ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(".  The default value ");
        stringBuilder.append(obj2);
        stringBuilder.append(" was returned.");
        ab.w("MicroMsg.ImmutableBundle", stringBuilder.toString());
        ab.w("MicroMsg.ImmutableBundle", "Attempt to cast generated internal exception:", classCastException);
        AppMethodBeat.o(115189);
    }

    public final boolean amr(String str) {
        AppMethodBeat.i(115190);
        Object obj = this.xyn.get(str);
        if (obj == null) {
            AppMethodBeat.o(115190);
            return false;
        }
        try {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            AppMethodBeat.o(115190);
            return booleanValue;
        } catch (ClassCastException e) {
            a(str, obj, "Boolean", Boolean.FALSE, e);
            AppMethodBeat.o(115190);
            return false;
        }
    }

    public final String getString(String str) {
        AppMethodBeat.i(115191);
        Object obj = this.xyn.get(str);
        try {
            String str2 = (String) obj;
            AppMethodBeat.o(115191);
            return str2;
        } catch (ClassCastException e) {
            a(str, obj, "String", "<null>", e);
            AppMethodBeat.o(115191);
            return null;
        }
    }
}
