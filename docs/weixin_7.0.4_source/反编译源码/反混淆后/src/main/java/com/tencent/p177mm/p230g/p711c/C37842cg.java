package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.cg */
public abstract class C37842cg extends C4925c {
    private static final int dFC = C8741b.SCORE.hashCode();
    private static final int dFz = "appusername".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dnA = "title".hashCode();
    private boolean dFB;
    private boolean dFw;
    private boolean dnx;
    public String field_appusername;
    public int field_score;
    public String field_title;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dFz == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (dnA == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (dFC == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dFw) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.dnx) {
            contentValues.put("title", this.field_title);
        }
        if (this.dFB) {
            contentValues.put(C8741b.SCORE, Integer.valueOf(this.field_score));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
