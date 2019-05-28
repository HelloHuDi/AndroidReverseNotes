package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;

/* renamed from: com.tencent.mm.storage.bq */
public final class C5140bq {
    int bJt;
    public String name;
    int status;
    public C5139a xZV;
    private int xZW;

    /* renamed from: com.tencent.mm.storage.bq$a */
    public static class C5139a {
        private String cIS;
        private String cSx;

        public C5139a(String str) {
            AppMethodBeat.m2504i(60230);
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.cIS = str.substring(0, indexOf);
                this.cSx = str.substring(indexOf);
                AppMethodBeat.m2505o(60230);
                return;
            }
            this.cIS = str;
            this.cSx = "";
            AppMethodBeat.m2505o(60230);
        }

        public final String apT(String str) {
            return this.cSx != null ? this.cSx : str;
        }
    }

    public C5140bq() {
        this.bJt = C44697b.CTRL_INDEX;
        this.name = "";
        this.xZV = null;
        this.xZV = null;
        this.name = "";
        this.status = 0;
        this.xZW = 0;
    }

    public C5140bq(String str, boolean z, int i) {
        AppMethodBeat.m2504i(60231);
        this.bJt = C44697b.CTRL_INDEX;
        this.name = "";
        this.xZV = null;
        this.xZV = new C5139a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.xZW = i;
        AppMethodBeat.m2505o(60231);
    }

    public final void setEnable(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean dum() {
        return (this.status & 2) != 0;
    }

    public final boolean dun() {
        return this.xZW == 1;
    }

    /* renamed from: d */
    public final void mo10557d(Cursor cursor) {
        AppMethodBeat.m2504i(60232);
        if ((this.bJt & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.xZV == null) {
                this.xZV = new C5139a(this.name);
            }
        }
        if ((this.bJt & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.bJt & 128) != 0) {
            this.xZW = cursor.getInt(7);
        }
        AppMethodBeat.m2505o(60232);
    }

    /* renamed from: Hl */
    public final ContentValues mo10556Hl() {
        AppMethodBeat.m2504i(60233);
        ContentValues contentValues = new ContentValues();
        if ((this.bJt & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.bJt & 4) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.bJt & 128) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.xZW));
        }
        AppMethodBeat.m2505o(60233);
        return contentValues;
    }
}
