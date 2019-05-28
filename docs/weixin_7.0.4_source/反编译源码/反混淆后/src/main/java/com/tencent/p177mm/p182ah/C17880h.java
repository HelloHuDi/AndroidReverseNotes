package com.tencent.p177mm.p182ah;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ah.h */
public final class C17880h {
    public int bJt = -1;
    public int dtR = 0;
    public int frU = 0;
    public String frV = "";
    public String frW = "";
    private int frX = 0;
    int frY = 0;
    public String username = "";

    public C17880h() {
        AppMethodBeat.m2504i(77919);
        AppMethodBeat.m2505o(77919);
    }

    /* renamed from: d */
    public final void mo33386d(Cursor cursor) {
        AppMethodBeat.m2504i(77920);
        this.username = cursor.getString(0);
        this.dtR = cursor.getInt(1);
        this.frU = cursor.getInt(2);
        this.frW = cursor.getString(3);
        this.frV = cursor.getString(4);
        this.frX = cursor.getInt(5);
        this.frY = cursor.getInt(6);
        AppMethodBeat.m2505o(77920);
    }

    public final ContentValues acj() {
        AppMethodBeat.m2504i(77921);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.dtR));
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.frU));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("reserved1", ack());
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("reserved2", acl());
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.frX));
        }
        if ((this.bJt & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.frY));
        }
        AppMethodBeat.m2505o(77921);
        return contentValues;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String ack() {
        return this.frW == null ? "" : this.frW;
    }

    /* renamed from: qn */
    public final void mo33388qn(String str) {
        this.frV = str;
    }

    public final String acl() {
        return this.frV == null ? "" : this.frV;
    }

    /* renamed from: cB */
    public final void mo33385cB(boolean z) {
        this.frX = z ? 1 : 0;
    }

    public final void acm() {
        AppMethodBeat.m2504i(77922);
        this.frY = (int) (C5046bo.anT() / 60);
        this.bJt |= 64;
        AppMethodBeat.m2505o(77922);
    }
}
