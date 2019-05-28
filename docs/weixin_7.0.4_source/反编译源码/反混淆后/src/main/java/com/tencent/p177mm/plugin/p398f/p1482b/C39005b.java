package com.tencent.p177mm.plugin.p398f.p1482b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.f.b.b */
public final class C39005b extends C7563j<C34092a> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) "};
    public static final String[] fnj = new String[]{C7563j.m13217a(C34092a.ccO, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex"};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(18640);
        AppMethodBeat.m2505o(18640);
    }

    public C39005b(C4927e c4927e) {
        super(c4927e, C34092a.ccO, "WxFileIndex2", diI);
        this.bSd = c4927e;
    }

    public final boolean delete() {
        long delete;
        AppMethodBeat.m2504i(18630);
        try {
            delete = (long) this.bSd.delete("WxFileIndex2", null, null);
        } catch (Exception e) {
            delete = 0;
        }
        if (delete > 0) {
            AppMethodBeat.m2505o(18630);
            return true;
        }
        AppMethodBeat.m2505o(18630);
        return false;
    }

    /* renamed from: sK */
    public final long mo61900sK(int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(18631);
        long j = 0;
        try {
            cursor = this.bSd.rawQuery("select sum(size)  from WxFileIndex2  where msgType=".concat(String.valueOf(i)), null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18631);
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18631);
        }
    }

    /* renamed from: sL */
    public final long mo61901sL(int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(18632);
        long j = 0;
        try {
            cursor = this.bSd.rawQuery("select count(*)  from WxFileIndex2  where msgType=" + i + " and size>0", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18632);
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18632);
        }
    }

    public final long aZn() {
        Cursor cursor = null;
        AppMethodBeat.m2504i(18633);
        long j = 0;
        try {
            cursor = this.bSd.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
            if (cursor != null && cursor.moveToFirst()) {
                j = cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18633);
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18633);
        }
    }

    public final Cursor aZo() {
        Cursor cursor = null;
        AppMethodBeat.m2504i(18634);
        try {
            cursor = this.bSd.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(18634);
        return cursor;
    }

    /* renamed from: j */
    public final List<C34092a> mo61898j(String str, long j, long j2) {
        AppMethodBeat.m2504i(18635);
        long yz = C5046bo.m7588yz();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgSubType in (1,20,23,30,32,34 ) and size > 0  order by msgtime DESC,msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    C34092a c34092a = new C34092a();
                    c34092a.mo8995d(cursor);
                    arrayList.add(c34092a);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18635);
        }
        C4990ab.m7417i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(18635);
        return arrayList;
    }

    /* renamed from: k */
    public final List<C34092a> mo61899k(String str, long j, long j2) {
        AppMethodBeat.m2504i(18636);
        long yz = C5046bo.m7588yz();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j + " and msgtime>" + j2 + " and msgType in (43,62,44,3,49,268435505 ) order by msgtime DESC,msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.rawQuery(str2, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    C34092a c34092a = new C34092a();
                    c34092a.mo8995d(cursor);
                    arrayList.add(c34092a);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", str2);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(18636);
        }
        C4990ab.m7417i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(18636);
        return arrayList;
    }

    /* renamed from: S */
    public final List<C34092a> mo61892S(C7620bi c7620bi) {
        List<C34092a> list = null;
        AppMethodBeat.m2504i(18637);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(18637);
            return list;
        }
        String str = "select *, rowid from WxFileIndex2  where msgId=" + c7620bi.field_msgId + " AND username='" + c7620bi.field_talker + "' order by msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = this.bSd.rawQuery(str, null);
            while (rawQuery.moveToNext()) {
                C34092a c34092a = new C34092a();
                c34092a.mo8995d(rawQuery);
                arrayList.add(c34092a);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e) {
            if (list != null) {
                list.close();
            }
        } catch (Throwable th) {
            if (list != null) {
                list.close();
            }
            AppMethodBeat.m2505o(18637);
        }
        AppMethodBeat.m2505o(18637);
        return arrayList;
    }

    /* renamed from: bd */
    public final int mo61895bd(List<C34092a> list) {
        AppMethodBeat.m2504i(18638);
        if (list.isEmpty()) {
            AppMethodBeat.m2505o(18638);
            return 0;
        }
        long yz = C5046bo.m7588yz();
        int i = 0;
        for (C34092a a : list) {
            int i2;
            if (mo16759a((C4925c) a, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        C4990ab.m7411d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(18638);
        return i;
    }

    /* renamed from: be */
    public final int mo61896be(List<C34092a> list) {
        AppMethodBeat.m2504i(18639);
        if (list.isEmpty()) {
            AppMethodBeat.m2505o(18639);
            return 0;
        }
        long yz = C5046bo.m7588yz();
        int i = 0;
        for (C34092a c34092a : list) {
            int i2;
            if (mo16758a(c34092a.xDa, (C4925c) c34092a, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i = i2 + i;
        }
        C4990ab.m7411d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", Integer.valueOf(i), Integer.valueOf(list.size()), Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(18639);
        return i;
    }
}
