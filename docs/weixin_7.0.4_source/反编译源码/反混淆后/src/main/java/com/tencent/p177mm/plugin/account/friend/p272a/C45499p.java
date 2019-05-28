package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.account.friend.a.p */
public final class C45499p {
    int bJt = -1;
    private int fCx = 0;
    private int fne = 0;
    private String fng = "";
    private String fnh = "";
    public int fvK = 0;
    public int gvE = 0;
    public String username = "";

    public C45499p() {
        AppMethodBeat.m2504i(108400);
        AppMethodBeat.m2505o(108400);
    }

    /* renamed from: Hl */
    public final ContentValues mo73293Hl() {
        String str;
        String str2;
        AppMethodBeat.m2504i(108401);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("friendtype", Integer.valueOf(this.gvE));
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("updatetime", Integer.valueOf(this.fvK));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.fne));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.fCx));
        }
        if ((this.bJt & 32) != 0) {
            str = "reserved3";
            if (this.fng == null) {
                str2 = "";
            } else {
                str2 = this.fng;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 64) != 0) {
            str = "reserved4";
            if (this.fnh == null) {
                str2 = "";
            } else {
                str2 = this.fnh;
            }
            contentValues.put(str, str2);
        }
        AppMethodBeat.m2505o(108401);
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
