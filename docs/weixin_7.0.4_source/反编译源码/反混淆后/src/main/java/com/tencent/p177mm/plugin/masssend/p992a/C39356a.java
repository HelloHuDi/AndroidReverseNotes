package com.tencent.p177mm.plugin.masssend.p992a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.masssend.a.a */
public final class C39356a {
    int bJt = -1;
    public int cde = 0;
    public long createTime = 0;
    String fQv = "";
    int fWZ = 0;
    long fXb = 0;
    public String filename = "";
    String fng = "";
    String fnh = "";
    public int msgType = 0;
    String onY = "";
    public String onZ = "";
    public int ooa = 0;
    public int oob = 0;
    int ooc = 0;
    int ood = 0;
    public int ooe = 0;
    int status = 0;
    public int videoSource = 0;

    public C39356a() {
        AppMethodBeat.m2504i(22721);
        AppMethodBeat.m2505o(22721);
    }

    /* renamed from: d */
    public final void mo62252d(Cursor cursor) {
        AppMethodBeat.m2504i(22722);
        this.fQv = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.createTime = cursor.getLong(2);
        this.fXb = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.onY = cursor.getString(5);
        this.onZ = cursor.getString(6);
        this.ooa = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.oob = cursor.getInt(9);
        this.ooc = cursor.getInt(10);
        this.cde = cursor.getInt(11);
        this.fWZ = cursor.getInt(12);
        this.ood = cursor.getInt(13);
        this.videoSource = cursor.getInt(14);
        this.ooe = cursor.getInt(15);
        this.fng = cursor.getString(16);
        this.fnh = cursor.getString(17);
        AppMethodBeat.m2505o(22722);
    }

    public final String bNv() {
        return this.fQv == null ? "" : this.fQv;
    }

    public final String bNw() {
        return this.filename == null ? "" : this.filename;
    }

    public final String bNx() {
        return this.onY == null ? "" : this.onY;
    }

    public final String bNy() {
        return this.onZ == null ? "" : this.onZ;
    }
}
