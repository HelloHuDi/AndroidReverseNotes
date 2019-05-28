package com.tencent.p177mm.storage.emotion;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18464ca;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.o */
public final class C30305o extends C18464ca {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    public C30305o(String str, byte[] bArr) {
        this.field_reqType = str;
        this.field_cache = bArr;
    }

    public C30305o(Cursor cursor) {
        AppMethodBeat.m2504i(62867);
        if (cursor == null) {
            AppMethodBeat.m2505o(62867);
            return;
        }
        mo8995d(cursor);
        AppMethodBeat.m2505o(62867);
    }

    static {
        AppMethodBeat.m2504i(62868);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "reqType";
        c4924a.xDd.put("reqType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" reqType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "reqType";
        c4924a.columns[1] = "cache";
        c4924a.xDd.put("cache", "BLOB default '' ");
        stringBuilder.append(" cache BLOB default '' ");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62868);
    }
}
