package com.tencent.mm.ab;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/kt/CodeMan;", "", "taskName", "", "(Ljava/lang/String;)V", "testTime", "Lcom/tencent/mm/compatible/util/CodeInfo$TestTime;", "begin", "", "diff", "getdiff", "", "mark", "toString", "libktcomm_release"})
public final class a {
    public com.tencent.mm.compatible.util.g.a eOm = new com.tencent.mm.compatible.util.g.a();
    private final String eOn;

    public a(String str) {
        j.p(str, "taskName");
        AppMethodBeat.i(114168);
        this.eOn = str;
        this.eOm.reset();
        AppMethodBeat.o(114168);
    }

    public final void SW() {
        AppMethodBeat.i(114166);
        ab.i("MicroMsg.CodeUtil", toString());
        AppMethodBeat.o(114166);
    }

    public final String toString() {
        AppMethodBeat.i(114167);
        String str = "CodeMan task " + this.eOn + " cost : " + this.eOm.Mr();
        AppMethodBeat.o(114167);
        return str;
    }
}
