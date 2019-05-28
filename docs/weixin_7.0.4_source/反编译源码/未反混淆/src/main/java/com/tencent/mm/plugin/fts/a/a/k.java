package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public long fob = 0;
    public int mDw = 0;
    public String mDx = "";
    public long mEA = 0;
    public long mEB = 0;
    public String mEC = "";
    public long mEz = 0;
    public String query = "";
    public long timestamp = 0;
    public int type = 0;

    public final void d(Cursor cursor) {
        AppMethodBeat.i(114274);
        this.mEz = cursor.getLong(0);
        this.query = cursor.getString(1);
        this.mEA = cursor.getLong(2);
        this.fob = cursor.getLong(3);
        this.mDx = cursor.getString(4);
        this.mEB = cursor.getLong(5);
        this.type = cursor.getInt(6);
        this.mDw = cursor.getInt(7);
        this.timestamp = cursor.getLong(8);
        this.mEC = cursor.getString(9);
        AppMethodBeat.o(114274);
    }
}
