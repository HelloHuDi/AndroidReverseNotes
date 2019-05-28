package com.tencent.p177mm.plugin.fts.p419a.p420a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.fts.a.a.b */
public final class C43119b {
    public long mDv;
    public int mDw;
    public String mDx;
    public int type;

    /* renamed from: h */
    public final C43119b mo68630h(Cursor cursor) {
        AppMethodBeat.m2504i(114235);
        this.mDv = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mDw = cursor.getInt(2);
        this.mDx = cursor.getString(3);
        AppMethodBeat.m2505o(114235);
        return this;
    }
}
