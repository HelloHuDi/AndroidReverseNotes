package com.tencent.p177mm.sdk.p602d;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.sdk.d.c */
public class C7292c implements C4886a {
    protected C7292c() {
    }

    public void enter() {
    }

    public void exit() {
    }

    /* renamed from: k */
    public boolean mo10090k(Message message) {
        return false;
    }

    public String getName() {
        AppMethodBeat.m2504i(52447);
        String name = getClass().getName();
        name = name.substring(name.lastIndexOf(36) + 1);
        AppMethodBeat.m2505o(52447);
        return name;
    }
}
