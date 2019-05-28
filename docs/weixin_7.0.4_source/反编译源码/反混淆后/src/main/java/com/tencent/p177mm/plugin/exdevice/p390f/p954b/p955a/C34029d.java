package com.tencent.p177mm.plugin.exdevice.p390f.p954b.p955a;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C9523ci;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.exdevice.f.b.a.d */
public final class C34029d extends C9523ci {
    public static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.m2504i(19487);
        String str = (("{" + "username: " + this.field_username + " ranknum: " + this.field_ranknum + " score: " + this.field_score) + " likeCount:" + this.field_likecount + " selfLikeState:" + this.field_selfLikeState) + "}";
        AppMethodBeat.m2505o(19487);
        return str;
    }

    static {
        AppMethodBeat.m2504i(19488);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "rankID";
        c4924a.xDd.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "appusername";
        c4924a.xDd.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "ranknum";
        c4924a.xDd.put("ranknum", "INTEGER");
        stringBuilder.append(" ranknum INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = C8741b.SCORE;
        c4924a.xDd.put(C8741b.SCORE, "INTEGER");
        stringBuilder.append(" score INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "likecount";
        c4924a.xDd.put("likecount", "INTEGER default '0' ");
        stringBuilder.append(" likecount INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[6] = "selfLikeState";
        c4924a.xDd.put("selfLikeState", "INTEGER default '3' ");
        stringBuilder.append(" selfLikeState INTEGER default '3' ");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(19488);
    }
}
