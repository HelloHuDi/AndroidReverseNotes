package com.tencent.p177mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C18473ei;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.r */
public final class C40628r extends C18473ei {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return null;
    }

    public C40628r(int i, String str) {
        this.field_position = i;
        this.field_key = str;
    }

    public final String toString() {
        AppMethodBeat.m2504i(62887);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index:").append(this.field_position);
        stringBuilder.append("key  :").append(this.field_key);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(62887);
        return stringBuilder2;
    }

    static {
        AppMethodBeat.m2504i(62888);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[2];
        c4924a.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "key";
        c4924a.xDd.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "key";
        c4924a.columns[1] = "position";
        c4924a.xDd.put("position", "INTEGER");
        stringBuilder.append(" position INTEGER");
        c4924a.columns[2] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62888);
    }
}
