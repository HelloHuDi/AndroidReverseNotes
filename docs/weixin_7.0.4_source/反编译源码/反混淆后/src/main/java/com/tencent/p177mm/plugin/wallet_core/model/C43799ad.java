package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C32696fg;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.ad */
public final class C43799ad extends C32696fg {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(46916);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[9];
        c4924a.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "pref_key";
        c4924a.xDd.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "pref_key";
        c4924a.columns[1] = "pref_title";
        c4924a.xDd.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "pref_url";
        c4924a.xDd.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "is_show";
        c4924a.xDd.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[4] = "pref_desc";
        c4924a.xDd.put("pref_desc", "TEXT");
        stringBuilder.append(" pref_desc TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "logo_url";
        c4924a.xDd.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "jump_type";
        c4924a.xDd.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "tinyapp_username";
        c4924a.xDd.put("tinyapp_username", "TEXT");
        stringBuilder.append(" tinyapp_username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "tinyapp_path";
        c4924a.xDd.put("tinyapp_path", "TEXT");
        stringBuilder.append(" tinyapp_path TEXT");
        c4924a.columns[9] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(46916);
    }
}
