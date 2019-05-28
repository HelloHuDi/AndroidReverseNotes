package com.tencent.p177mm.plugin.sport.p1302a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42117eo;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.sport.a.e */
public final class C29259e extends C42117eo implements Comparable<C29259e> {
    public static C4924a ccO;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C29259e c29259e = (C29259e) obj;
        if (this.field_timestamp > c29259e.field_timestamp) {
            return 1;
        }
        if (this.field_timestamp < c29259e.field_timestamp) {
            return -1;
        }
        return 0;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.m2504i(55719);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[4];
        c4924a.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "id";
        c4924a.xDd.put("id", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "id";
        c4924a.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        c4924a.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        stringBuilder.append(" date TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "step";
        c4924a.xDd.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = Param.TIMESTAMP;
        c4924a.xDd.put(Param.TIMESTAMP, "LONG");
        stringBuilder.append(" timestamp LONG");
        c4924a.columns[4] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(55719);
    }
}
