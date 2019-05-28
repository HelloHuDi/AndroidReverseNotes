package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C37834aj;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.card.model.i */
public final class C20149i extends C37834aj {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(87839);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "card_id";
        c4924a.xDd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "card_id";
        c4924a.columns[1] = "lower_bound";
        c4924a.xDd.put("lower_bound", "INTEGER");
        stringBuilder.append(" lower_bound INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[2] = "need_insert_show_timestamp";
        c4924a.xDd.put("need_insert_show_timestamp", "INTEGER default 'false' ");
        stringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
        stringBuilder.append(", ");
        c4924a.columns[3] = "show_timestamp_encrypt_key";
        c4924a.xDd.put("show_timestamp_encrypt_key", "TEXT");
        stringBuilder.append(" show_timestamp_encrypt_key TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "expire_time_interval";
        c4924a.xDd.put("expire_time_interval", "INTEGER");
        stringBuilder.append(" expire_time_interval INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "show_expire_interval";
        c4924a.xDd.put("show_expire_interval", "INTEGER");
        stringBuilder.append(" show_expire_interval INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "fetch_time";
        c4924a.xDd.put("fetch_time", "LONG");
        stringBuilder.append(" fetch_time LONG");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(87839);
    }
}
