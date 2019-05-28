package com.tencent.p177mm.p201az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3463b;
import com.tencent.p177mm.sdk.p603e.C7296k;

/* renamed from: com.tencent.mm.az.i */
public final class C25850i extends C7296k implements C3464j {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    C7480h fni;

    public C25850i(C7480h c7480h) {
        this.fni = c7480h;
    }

    /* renamed from: b */
    public final boolean mo43835b(C3463b c3463b) {
        AppMethodBeat.m2504i(990);
        if (c3463b == null) {
            AppMethodBeat.m2505o(990);
            return true;
        }
        if (this.fni.delete("oplog2", "id= ? AND inserTime= ?", new String[]{c3463b.f1272id, c3463b.fCv}) >= 0) {
            AppMethodBeat.m2505o(990);
            return true;
        }
        AppMethodBeat.m2505o(990);
        return false;
    }
}
