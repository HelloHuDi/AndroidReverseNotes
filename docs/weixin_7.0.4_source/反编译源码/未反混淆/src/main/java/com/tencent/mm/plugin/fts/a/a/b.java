package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public long mDv;
    public int mDw;
    public String mDx;
    public int type;

    public final b h(Cursor cursor) {
        AppMethodBeat.i(114235);
        this.mDv = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.mDw = cursor.getInt(2);
        this.mDx = cursor.getString(3);
        AppMethodBeat.o(114235);
        return this;
    }
}
