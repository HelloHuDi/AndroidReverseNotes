package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6576eu;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.bv */
public final class C7575bv extends C6576eu {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public C7575bv(String str) {
        this();
        AppMethodBeat.m2504i(60235);
        this.field_conRemark = "";
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        AppMethodBeat.m2505o(60235);
    }

    public C7575bv(String str, String str2) {
        this();
        AppMethodBeat.m2504i(60236);
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = "";
        }
        this.field_conRemark = str2;
        AppMethodBeat.m2505o(60236);
    }

    public C7575bv() {
        AppMethodBeat.m2504i(60237);
        this.field_encryptUsername = "";
        this.field_conRemark = "";
        AppMethodBeat.m2505o(60237);
    }

    /* renamed from: Hv */
    public final String mo16784Hv() {
        return this.field_encryptUsername;
    }

    /* renamed from: Hr */
    public final String mo16783Hr() {
        return this.field_conRemark;
    }

    /* Access modifiers changed, original: protected|final */
    public final Object clone() {
        AppMethodBeat.m2504i(60238);
        Object clone = super.clone();
        AppMethodBeat.m2505o(60238);
        return clone;
    }

    static {
        AppMethodBeat.m2504i(60239);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[5];
        c4924a.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "encryptUsername";
        c4924a.xDd.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "encryptUsername";
        c4924a.columns[1] = "conRemark";
        c4924a.xDd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[2] = "contactLabels";
        c4924a.xDd.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "conDescription";
        c4924a.xDd.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "conPhone";
        c4924a.xDd.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        c4924a.columns[5] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(60239);
    }
}
