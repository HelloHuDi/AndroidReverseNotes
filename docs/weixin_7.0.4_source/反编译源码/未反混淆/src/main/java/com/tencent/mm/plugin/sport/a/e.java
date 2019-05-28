package com.tencent.mm.plugin.sport.a;

import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends eo implements Comparable<e> {
    public static a ccO;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        if (this.field_timestamp > eVar.field_timestamp) {
            return 1;
        }
        if (this.field_timestamp < eVar.field_timestamp) {
            return -1;
        }
        return 0;
    }

    public final a Ag() {
        return ccO;
    }

    static {
        AppMethodBeat.i(55719);
        a aVar = new a();
        aVar.xDb = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "id";
        aVar.xDd.put("id", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "id";
        aVar.columns[1] = FFmpegMetadataRetriever.METADATA_KEY_DATE;
        aVar.xDd.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, "TEXT");
        stringBuilder.append(" date TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "step";
        aVar.xDd.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = Param.TIMESTAMP;
        aVar.xDd.put(Param.TIMESTAMP, "LONG");
        stringBuilder.append(" timestamp LONG");
        aVar.columns[4] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(55719);
    }
}
