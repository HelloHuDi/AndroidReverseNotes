package com.tencent.p177mm.sdk.platformtools;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.platformtools.s */
public final class C5064s {
    public ArrayMap<String, Object> xyn;
    public boolean xyo;

    public C5064s() {
        AppMethodBeat.m2504i(115188);
        this.xyn = null;
        this.xyo = false;
        this.xyn = new ArrayMap();
        AppMethodBeat.m2505o(115188);
    }

    /* renamed from: a */
    private static void m7681a(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        AppMethodBeat.m2504i(115189);
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
        C4990ab.m7420w("MicroMsg.ImmutableBundle", stringBuilder.toString());
        C4990ab.m7421w("MicroMsg.ImmutableBundle", "Attempt to cast generated internal exception:", classCastException);
        AppMethodBeat.m2505o(115189);
    }

    public final boolean amr(String str) {
        AppMethodBeat.m2504i(115190);
        Object obj = this.xyn.get(str);
        if (obj == null) {
            AppMethodBeat.m2505o(115190);
            return false;
        }
        try {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            AppMethodBeat.m2505o(115190);
            return booleanValue;
        } catch (ClassCastException e) {
            C5064s.m7681a(str, obj, "Boolean", Boolean.FALSE, e);
            AppMethodBeat.m2505o(115190);
            return false;
        }
    }

    public final String getString(String str) {
        AppMethodBeat.m2504i(115191);
        Object obj = this.xyn.get(str);
        try {
            String str2 = (String) obj;
            AppMethodBeat.m2505o(115191);
            return str2;
        } catch (ClassCastException e) {
            C5064s.m7681a(str, obj, "String", "<null>", e);
            AppMethodBeat.m2505o(115191);
            return null;
        }
    }
}
