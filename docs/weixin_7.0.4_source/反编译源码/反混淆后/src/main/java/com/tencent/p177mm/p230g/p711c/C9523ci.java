package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.ci */
public abstract class C9523ci extends C4925c {
    private static final int dFC = C8741b.SCORE.hashCode();
    private static final int dFI = "ranknum".hashCode();
    private static final int dFJ = "likecount".hashCode();
    private static final int dFK = "selfLikeState".hashCode();
    private static final int dFy = "rankID".hashCode();
    private static final int dFz = "appusername".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private boolean dFB = true;
    private boolean dFF = true;
    private boolean dFG = true;
    private boolean dFH = true;
    private boolean dFv = true;
    private boolean dFw = true;
    private boolean dlm = true;
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public String field_username;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dFy == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (dFz == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (dFI == hashCode) {
                    this.field_ranknum = cursor.getInt(i);
                } else if (dFC == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (dFJ == hashCode) {
                    this.field_likecount = cursor.getInt(i);
                } else if (dFK == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dFv) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.dFw) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dFF) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.dFB) {
            contentValues.put(C8741b.SCORE, Integer.valueOf(this.field_score));
        }
        if (this.dFG) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.dFH) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
