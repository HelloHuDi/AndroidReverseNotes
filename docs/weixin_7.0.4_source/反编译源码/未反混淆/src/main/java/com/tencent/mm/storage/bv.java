package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bv extends eu {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public bv(String str) {
        this();
        AppMethodBeat.i(60235);
        this.field_conRemark = "";
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        AppMethodBeat.o(60235);
    }

    public bv(String str, String str2) {
        this();
        AppMethodBeat.i(60236);
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = "";
        }
        this.field_conRemark = str2;
        AppMethodBeat.o(60236);
    }

    public bv() {
        AppMethodBeat.i(60237);
        this.field_encryptUsername = "";
        this.field_conRemark = "";
        AppMethodBeat.o(60237);
    }

    public final String Hv() {
        return this.field_encryptUsername;
    }

    public final String Hr() {
        return this.field_conRemark;
    }

    /* Access modifiers changed, original: protected|final */
    public final Object clone() {
        AppMethodBeat.i(60238);
        Object clone = super.clone();
        AppMethodBeat.o(60238);
        return clone;
    }

    static {
        AppMethodBeat.i(60239);
        a aVar = new a();
        aVar.xDb = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "encryptUsername";
        aVar.xDd.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "encryptUsername";
        aVar.columns[1] = "conRemark";
        aVar.xDd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactLabels";
        aVar.xDd.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "conDescription";
        aVar.xDd.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "conPhone";
        aVar.xDd.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(60239);
    }
}
