package com.tencent.p177mm.plugin.fts.p419a.p420a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.fts.a.a.k */
public final class C39128k {
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

    /* renamed from: d */
    public final void mo62027d(Cursor cursor) {
        AppMethodBeat.m2504i(114274);
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
        AppMethodBeat.m2505o(114274);
    }
}
