package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ds extends c {
    private static final int dNj = "originalArticleCount".hashCode();
    private static final int dNk = "friendSubscribeCount".hashCode();
    private static final int dNl = "allArticleWording".hashCode();
    private static final int dNm = "historyArticlesUrl".hashCode();
    private static final int dNn = "userRole".hashCode();
    private static final int dNo = "banReason".hashCode();
    private static final int dNp = "showRecommendArticle".hashCode();
    private static final int dNq = "showService".hashCode();
    private static final int dNr = "messageListStr".hashCode();
    private static final int dNs = "serviceInfoListStr".hashCode();
    private static final int dNt = "bizAccountListStr".hashCode();
    private static final int dNu = "cacheTime".hashCode();
    private static final int dNv = "decryptUserName".hashCode();
    private static final int dNw = "hiddenAvatar".hashCode();
    private static final int dNx = "hiddenButtonBeforeFocus".hashCode();
    private static final int dNy = "newBanReason".hashCode();
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dlo = "username".hashCode();
    private boolean dMT = true;
    private boolean dMU = true;
    private boolean dMV = true;
    private boolean dMW = true;
    private boolean dMX = true;
    private boolean dMY = true;
    private boolean dMZ = true;
    private boolean dNa = true;
    private boolean dNb = true;
    private boolean dNc = true;
    private boolean dNd = true;
    private boolean dNe = true;
    private boolean dNf = true;
    private boolean dNg = true;
    private boolean dNh = true;
    private boolean dNi = true;
    private boolean dlm = true;
    public String field_allArticleWording;
    public String field_banReason;
    public String field_bizAccountListStr;
    public long field_cacheTime;
    public String field_decryptUserName;
    public int field_friendSubscribeCount;
    public int field_hiddenAvatar;
    public int field_hiddenButtonBeforeFocus;
    public String field_historyArticlesUrl;
    public String field_messageListStr;
    public String field_newBanReason;
    public int field_originalArticleCount;
    public String field_serviceInfoListStr;
    public int field_showRecommendArticle;
    public int field_showService;
    public int field_userRole;
    public String field_username;

    public final void d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dlo == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.dlm = true;
                } else if (dNj == hashCode) {
                    this.field_originalArticleCount = cursor.getInt(i);
                } else if (dNk == hashCode) {
                    this.field_friendSubscribeCount = cursor.getInt(i);
                } else if (dNl == hashCode) {
                    this.field_allArticleWording = cursor.getString(i);
                } else if (dNm == hashCode) {
                    this.field_historyArticlesUrl = cursor.getString(i);
                } else if (dNn == hashCode) {
                    this.field_userRole = cursor.getInt(i);
                } else if (dNo == hashCode) {
                    this.field_banReason = cursor.getString(i);
                } else if (dNp == hashCode) {
                    this.field_showRecommendArticle = cursor.getInt(i);
                } else if (dNq == hashCode) {
                    this.field_showService = cursor.getInt(i);
                } else if (dNr == hashCode) {
                    this.field_messageListStr = cursor.getString(i);
                } else if (dNs == hashCode) {
                    this.field_serviceInfoListStr = cursor.getString(i);
                } else if (dNt == hashCode) {
                    this.field_bizAccountListStr = cursor.getString(i);
                } else if (dNu == hashCode) {
                    this.field_cacheTime = cursor.getLong(i);
                } else if (dNv == hashCode) {
                    this.field_decryptUserName = cursor.getString(i);
                } else if (dNw == hashCode) {
                    this.field_hiddenAvatar = cursor.getInt(i);
                } else if (dNx == hashCode) {
                    this.field_hiddenButtonBeforeFocus = cursor.getInt(i);
                } else if (dNy == hashCode) {
                    this.field_newBanReason = cursor.getString(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.dlm) {
            contentValues.put("username", this.field_username);
        }
        if (this.dMT) {
            contentValues.put("originalArticleCount", Integer.valueOf(this.field_originalArticleCount));
        }
        if (this.dMU) {
            contentValues.put("friendSubscribeCount", Integer.valueOf(this.field_friendSubscribeCount));
        }
        if (this.dMV) {
            contentValues.put("allArticleWording", this.field_allArticleWording);
        }
        if (this.dMW) {
            contentValues.put("historyArticlesUrl", this.field_historyArticlesUrl);
        }
        if (this.dMX) {
            contentValues.put("userRole", Integer.valueOf(this.field_userRole));
        }
        if (this.dMY) {
            contentValues.put("banReason", this.field_banReason);
        }
        if (this.dMZ) {
            contentValues.put("showRecommendArticle", Integer.valueOf(this.field_showRecommendArticle));
        }
        if (this.dNa) {
            contentValues.put("showService", Integer.valueOf(this.field_showService));
        }
        if (this.dNb) {
            contentValues.put("messageListStr", this.field_messageListStr);
        }
        if (this.dNc) {
            contentValues.put("serviceInfoListStr", this.field_serviceInfoListStr);
        }
        if (this.dNd) {
            contentValues.put("bizAccountListStr", this.field_bizAccountListStr);
        }
        if (this.dNe) {
            contentValues.put("cacheTime", Long.valueOf(this.field_cacheTime));
        }
        if (this.field_decryptUserName == null) {
            this.field_decryptUserName = "";
        }
        if (this.dNf) {
            contentValues.put("decryptUserName", this.field_decryptUserName);
        }
        if (this.dNg) {
            contentValues.put("hiddenAvatar", Integer.valueOf(this.field_hiddenAvatar));
        }
        if (this.dNh) {
            contentValues.put("hiddenButtonBeforeFocus", Integer.valueOf(this.field_hiddenButtonBeforeFocus));
        }
        if (this.dNi) {
            contentValues.put("newBanReason", this.field_newBanReason);
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
