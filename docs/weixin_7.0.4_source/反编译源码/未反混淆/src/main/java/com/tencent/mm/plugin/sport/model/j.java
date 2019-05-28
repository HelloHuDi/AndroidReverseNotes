package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.y;

public final class j extends y {
    public j(String str) {
        super(str);
    }

    public final synchronized long getLong(int i, long j) {
        AppMethodBeat.i(93685);
        Object obj = get(i);
        if (obj instanceof Long) {
            j = ((Long) obj).longValue();
            AppMethodBeat.o(93685);
        } else if (obj instanceof Integer) {
            j = ((Integer) obj).longValue();
            AppMethodBeat.o(93685);
        } else {
            AppMethodBeat.o(93685);
        }
        return j;
    }

    public final synchronized void setString(int i, String str) {
        AppMethodBeat.i(93686);
        set(i, str);
        AppMethodBeat.o(93686);
    }

    public final synchronized String getString(int i, String str) {
        String str2;
        AppMethodBeat.i(93687);
        Object obj = get(i);
        if (obj instanceof String) {
            str2 = (String) obj;
            AppMethodBeat.o(93687);
        } else {
            AppMethodBeat.o(93687);
            str2 = str;
        }
        return str2;
    }
}
