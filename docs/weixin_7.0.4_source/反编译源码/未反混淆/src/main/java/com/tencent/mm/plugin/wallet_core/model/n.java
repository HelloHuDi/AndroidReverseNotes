package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends cu {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(46784);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "title";
        aVar.xDd.put("title", "TEXT PRIMARY KEY ");
        stringBuilder.append(" title TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "title";
        aVar.columns[1] = "loan_jump_url";
        aVar.xDd.put("loan_jump_url", "TEXT");
        stringBuilder.append(" loan_jump_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "red_dot_index";
        aVar.xDd.put("red_dot_index", "INTEGER");
        stringBuilder.append(" red_dot_index INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show_entry";
        aVar.xDd.put("is_show_entry", "INTEGER");
        stringBuilder.append(" is_show_entry INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "tips";
        aVar.xDd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "is_overdue";
        aVar.xDd.put("is_overdue", "INTEGER");
        stringBuilder.append(" is_overdue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "available_otb";
        aVar.xDd.put("available_otb", "TEXT");
        stringBuilder.append(" available_otb TEXT");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46784);
    }
}
