package com.tencent.mm.plugin.exdevice.f.b.a;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends ci {
    public static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.i(19487);
        String str = (("{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score) + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState) + "}";
        AppMethodBeat.o(19487);
        return str;
    }

    static {
        AppMethodBeat.i(19488);
        a aVar = new a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "rankID";
        aVar.xDd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appusername";
        aVar.xDd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "ranknum";
        aVar.xDd.put("ranknum", "INTEGER");
        stringBuilder.append(" ranknum INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = b.SCORE;
        aVar.xDd.put(b.SCORE, "INTEGER");
        stringBuilder.append(" score INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "likecount";
        aVar.xDd.put("likecount", "INTEGER default '0' ");
        stringBuilder.append(" likecount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "selfLikeState";
        aVar.xDd.put("selfLikeState", "INTEGER default '3' ");
        stringBuilder.append(" selfLikeState INTEGER default '3' ");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(19488);
    }
}
