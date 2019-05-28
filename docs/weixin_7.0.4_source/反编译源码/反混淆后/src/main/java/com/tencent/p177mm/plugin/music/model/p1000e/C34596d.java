package com.tencent.p177mm.plugin.music.model.p1000e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.music.model.e.d */
public final class C34596d extends C7563j<C28576c> {
    public C4927e bSd;
    public C1177f<String, C28576c> oNq = new C7598c(20);

    public C34596d(C4927e c4927e) {
        super(c4927e, C28576c.ccO, "PieceMusicInfo", null);
        AppMethodBeat.m2504i(105041);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(105041);
    }

    /* renamed from: Tq */
    public final C28576c mo55153Tq(String str) {
        AppMethodBeat.m2504i(105042);
        C28576c c28576c;
        if (this.oNq.get(str) != null) {
            c28576c = (C28576c) this.oNq.get(str);
            AppMethodBeat.m2505o(105042);
            return c28576c;
        }
        String format = String.format("Select * From PieceMusicInfo Where musicId=?", new Object[0]);
        Cursor a = this.bSd.mo10104a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(105042);
            return null;
        }
        c28576c = new C28576c();
        c28576c.mo8995d(a);
        a.close();
        this.oNq.put(str, c28576c);
        AppMethodBeat.m2505o(105042);
        return c28576c;
    }
}
