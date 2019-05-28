package com.tencent.p177mm.plugin.account.friend.p272a;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.Utility;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;

/* renamed from: com.tencent.mm.plugin.account.friend.a.g */
public final class C45497g {
    String bCu = "";
    int bJt = -1;
    String dFl = "";
    int dtS = 0;
    public long dtU = 0;
    private String dtV = "";
    int dub = 0;
    String duc = "";
    String dud = "";
    String guG = "";
    String guH = "";
    String gvg = "";
    int gvh = 0;
    String signature = "";
    public int status = 0;
    private int type = 0;
    String username = "";

    public C45497g() {
        AppMethodBeat.m2504i(108331);
        AppMethodBeat.m2505o(108331);
    }

    /* renamed from: d */
    public final void mo73290d(Cursor cursor) {
        AppMethodBeat.m2504i(108332);
        this.dtU = cursor.getLong(0);
        this.gvg = cursor.getString(1);
        this.gvh = cursor.getInt(2);
        this.status = cursor.getInt(3);
        this.username = cursor.getString(4);
        this.bCu = cursor.getString(5);
        this.guG = cursor.getString(6);
        this.guH = cursor.getString(7);
        this.dtS = cursor.getInt(8);
        this.dub = cursor.getInt(9);
        this.duc = cursor.getString(10);
        this.dud = cursor.getString(11);
        this.signature = cursor.getString(12);
        this.dFl = cursor.getString(13);
        this.type = cursor.getInt(14);
        this.dtV = cursor.getString(15);
        AppMethodBeat.m2505o(108332);
    }

    /* renamed from: Hl */
    public final ContentValues mo73287Hl() {
        String str;
        String str2;
        AppMethodBeat.m2504i(108333);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 1) != 0) {
            contentValues.put("fbid", Long.valueOf(this.dtU));
        }
        if ((this.bJt & 2) != 0) {
            contentValues.put("fbname", apL());
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("fbimgkey", Integer.valueOf(this.gvh));
        }
        if ((this.bJt & 8) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bJt & 16) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.bJt & 32) != 0) {
            contentValues.put("nickname", apD());
        }
        if ((this.bJt & 64) != 0) {
            str = "nicknamepyinitial";
            if (this.guG == null) {
                str2 = "";
            } else {
                str2 = this.guG;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 128) != 0) {
            str = "nicknamequanpin";
            if (this.guH == null) {
                str2 = "";
            } else {
                str2 = this.guH;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 256) != 0) {
            contentValues.put("sex", Integer.valueOf(this.dtS));
        }
        if ((this.bJt & 512) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.dub));
        }
        if ((this.bJt & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            str = "province";
            if (this.duc == null) {
                str2 = "";
            } else {
                str2 = this.duc;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 2048) != 0) {
            str = "city";
            if (this.dud == null) {
                str2 = "";
            } else {
                str2 = this.dud;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 4096) != 0) {
            str = "signature";
            if (this.signature == null) {
                str2 = "";
            } else {
                str2 = this.signature;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            str = "alias";
            if (this.dFl == null) {
                str2 = "";
            } else {
                str2 = this.dFl;
            }
            contentValues.put(str, str2);
        }
        if ((this.bJt & 16384) != 0) {
            contentValues.put("type", Integer.valueOf(this.type));
        }
        if ((this.bJt & 32768) != 0) {
            str = Scopes.EMAIL;
            if (this.dtV == null) {
                str2 = "";
            } else {
                str2 = this.dtV;
            }
            contentValues.put(str, str2);
        }
        AppMethodBeat.m2505o(108333);
        return contentValues;
    }

    public final String apL() {
        return this.gvg == null ? "" : this.gvg;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String apD() {
        return this.bCu == null ? "" : this.bCu;
    }
}
