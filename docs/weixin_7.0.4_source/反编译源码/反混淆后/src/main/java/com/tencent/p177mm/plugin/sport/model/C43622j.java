package com.tencent.p177mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.storage.C5144y;

/* renamed from: com.tencent.mm.plugin.sport.model.j */
public final class C43622j extends C5144y {
    public C43622j(String str) {
        super(str);
    }

    public final synchronized long getLong(int i, long j) {
        AppMethodBeat.m2504i(93685);
        Object obj = get(i);
        if (obj instanceof Long) {
            j = ((Long) obj).longValue();
            AppMethodBeat.m2505o(93685);
        } else if (obj instanceof Integer) {
            j = ((Integer) obj).longValue();
            AppMethodBeat.m2505o(93685);
        } else {
            AppMethodBeat.m2505o(93685);
        }
        return j;
    }

    public final synchronized void setString(int i, String str) {
        AppMethodBeat.m2504i(93686);
        set(i, str);
        AppMethodBeat.m2505o(93686);
    }

    public final synchronized String getString(int i, String str) {
        String str2;
        AppMethodBeat.m2504i(93687);
        Object obj = get(i);
        if (obj instanceof String) {
            str2 = (String) obj;
            AppMethodBeat.m2505o(93687);
        } else {
            AppMethodBeat.m2505o(93687);
            str2 = str;
        }
        return str2;
    }
}
