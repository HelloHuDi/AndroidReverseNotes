package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ad extends fg {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(46916);
        a aVar = new a();
        aVar.xDb = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "pref_key";
        aVar.xDd.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "pref_key";
        aVar.columns[1] = "pref_title";
        aVar.xDd.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pref_url";
        aVar.xDd.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show";
        aVar.xDd.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "pref_desc";
        aVar.xDd.put("pref_desc", "TEXT");
        stringBuilder.append(" pref_desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "logo_url";
        aVar.xDd.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "jump_type";
        aVar.xDd.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "tinyapp_username";
        aVar.xDd.put("tinyapp_username", "TEXT");
        stringBuilder.append(" tinyapp_username TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "tinyapp_path";
        aVar.xDd.put("tinyapp_path", "TEXT");
        stringBuilder.append(" tinyapp_path TEXT");
        aVar.columns[9] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(46916);
    }
}
