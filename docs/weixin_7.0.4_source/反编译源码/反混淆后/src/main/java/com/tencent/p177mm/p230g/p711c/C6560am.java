package com.tencent.p177mm.p230g.p711c;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.p177mm.sdk.p603e.C4925c;

/* renamed from: com.tencent.mm.g.c.am */
public abstract class C6560am extends C4925c {
    public static final String[] diI = new String[0];
    private static final int diR = "rowid".hashCode();
    private static final int dsB = "chatroomname".hashCode();
    private static final int dsC = "addtime".hashCode();
    private static final int dsD = "memberlist".hashCode();
    private static final int dsE = "displayname".hashCode();
    private static final int dsF = "chatroomnick".hashCode();
    private static final int dsG = "roomflag".hashCode();
    private static final int dsH = "roomowner".hashCode();
    private static final int dsI = "roomdata".hashCode();
    private static final int dsJ = "isShowname".hashCode();
    private static final int dsK = "selfDisplayName".hashCode();
    private static final int dsL = AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.hashCode();
    private static final int dsM = "chatroomdataflag".hashCode();
    private static final int dsN = "modifytime".hashCode();
    private static final int dsO = "chatroomnotice".hashCode();
    private static final int dsP = "chatroomVersion".hashCode();
    private static final int dsQ = "chatroomnoticeEditor".hashCode();
    private static final int dsR = "chatroomnoticePublishTime".hashCode();
    private static final int dsS = "chatroomLocalVersion".hashCode();
    private static final int dsT = "chatroomStatus".hashCode();
    private static final int dsU = "memberCount".hashCode();
    private boolean dsA = true;
    private boolean dsg = true;
    private boolean dsh = true;
    private boolean dsi = true;
    private boolean dsj = true;
    private boolean dsk = true;
    private boolean dsl = true;
    private boolean dsm = true;
    private boolean dsn = true;
    private boolean dso = true;
    private boolean dsp = true;
    private boolean dsq = true;
    private boolean dsr = true;
    private boolean dss = true;
    private boolean dsu = true;
    private boolean dsv = true;
    private boolean dsw = true;
    private boolean dsx = true;
    private boolean dsy = true;
    private boolean dsz = true;
    public long field_addtime;
    public long field_chatroomLocalVersion;
    public int field_chatroomStatus;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public int field_isShowname;
    public int field_memberCount;
    public String field_memberlist;
    public long field_modifytime;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_selfDisplayName;
    public int field_style;

    /* renamed from: d */
    public final void mo8995d(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (dsB == hashCode) {
                    this.field_chatroomname = cursor.getString(i);
                    this.dsg = true;
                } else if (dsC == hashCode) {
                    this.field_addtime = cursor.getLong(i);
                } else if (dsD == hashCode) {
                    this.field_memberlist = cursor.getString(i);
                } else if (dsE == hashCode) {
                    this.field_displayname = cursor.getString(i);
                } else if (dsF == hashCode) {
                    this.field_chatroomnick = cursor.getString(i);
                } else if (dsG == hashCode) {
                    this.field_roomflag = cursor.getInt(i);
                } else if (dsH == hashCode) {
                    this.field_roomowner = cursor.getString(i);
                } else if (dsI == hashCode) {
                    this.field_roomdata = cursor.getBlob(i);
                } else if (dsJ == hashCode) {
                    this.field_isShowname = cursor.getInt(i);
                } else if (dsK == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i);
                } else if (dsL == hashCode) {
                    this.field_style = cursor.getInt(i);
                } else if (dsM == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i);
                } else if (dsN == hashCode) {
                    this.field_modifytime = cursor.getLong(i);
                } else if (dsO == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i);
                } else if (dsP == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i);
                } else if (dsQ == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i);
                } else if (dsR == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i);
                } else if (dsS == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i);
                } else if (dsT == hashCode) {
                    this.field_chatroomStatus = cursor.getInt(i);
                } else if (dsU == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (diR == hashCode) {
                    this.xDa = cursor.getLong(i);
                }
            }
        }
    }

    /* renamed from: Hl */
    public final ContentValues mo10098Hl() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = "";
        }
        if (this.dsg) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.dsh) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.dsi) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.dsj) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.dsk) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.dsl) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.dsm) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.dsn) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.dso) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.dsp) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.dsq) {
            contentValues.put(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, Integer.valueOf(this.field_style));
        }
        if (this.dsr) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.dss) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.dsu) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.dsv) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.dsw) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.dsx) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.dsy) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.dsz) {
            contentValues.put("chatroomStatus", Integer.valueOf(this.field_chatroomStatus));
        }
        if (this.dsA) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.xDa > 0) {
            contentValues.put("rowid", Long.valueOf(this.xDa));
        }
        return contentValues;
    }
}
