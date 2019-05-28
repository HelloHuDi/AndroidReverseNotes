package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C6574cu;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.n */
public final class C40114n extends C6574cu {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(46784);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "title";
        c4924a.xDd.put("title", "TEXT PRIMARY KEY ");
        stringBuilder.append(" title TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "title";
        c4924a.columns[1] = "loan_jump_url";
        c4924a.xDd.put("loan_jump_url", "TEXT");
        stringBuilder.append(" loan_jump_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "red_dot_index";
        c4924a.xDd.put("red_dot_index", "INTEGER");
        stringBuilder.append(" red_dot_index INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "is_show_entry";
        c4924a.xDd.put("is_show_entry", "INTEGER");
        stringBuilder.append(" is_show_entry INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "tips";
        c4924a.xDd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "is_overdue";
        c4924a.xDd.put("is_overdue", "INTEGER");
        stringBuilder.append(" is_overdue INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "available_otb";
        c4924a.xDd.put("available_otb", "TEXT");
        stringBuilder.append(" available_otb TEXT");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46784);
    }
}
