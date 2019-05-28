package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.storage.bh */
public final class C7571bh extends C7298n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public C4927e bSd;

    public final boolean apK() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3 A:{Catch:{ Exception -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ef A:{SYNTHETIC, Splitter:B:40:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0185 A:{Splitter:B:30:0x00ca, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:62:0x0185, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:63:0x0186, code skipped:
            r7 = null;
     */
    /* JADX WARNING: Missing block: B:73:0x0199, code skipped:
            r5 = e;
     */
    /* JADX WARNING: Missing block: B:74:0x019a, code skipped:
            r7 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C7571bh(C7480h c7480h) {
        int i;
        Throwable e;
        String str;
        long j;
        Cursor a;
        Throwable e2;
        Cursor cursor = null;
        AppMethodBeat.m2504i(80281);
        this.bSd = c7480h;
        String str2 = "MediaDuplication";
        Cursor a2;
        try {
            a2 = this.bSd.mo10104a("PRAGMA table_info( " + str2 + " )", null, 2);
            try {
                int columnIndex = a2.getColumnIndex("name");
                i = 0;
                int i2 = 0;
                int i3 = 0;
                while (a2.moveToNext()) {
                    if (columnIndex >= 0) {
                        String string = a2.getString(columnIndex);
                        if ("remuxing".equalsIgnoreCase(string)) {
                            i3 = 1;
                        } else if (FFmpegMetadataRetriever.METADATA_KEY_DURATION.equalsIgnoreCase(string)) {
                            i2 = 1;
                        } else if ("status".equalsIgnoreCase(string)) {
                            i = 1;
                        }
                    }
                }
                a2.close();
                long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                if (i3 == 0) {
                    C4990ab.m7416i("MicroMsg.MediaCheckDuplicationStorage", "it had no [remuxing] column, alter table now");
                    this.bSd.mo10108hY(str2, "alter table MediaDuplication add remuxing text ");
                }
                if (i2 == 0) {
                    C4990ab.m7416i("MicroMsg.MediaCheckDuplicationStorage", "it had no [duration] column, alter table now");
                    this.bSd.mo10108hY(str2, "alter table MediaDuplication add duration int ");
                }
                if (i == 0) {
                    C4990ab.m7416i("MicroMsg.MediaCheckDuplicationStorage", "it had no [status] column, alter table now");
                    this.bSd.mo10108hY(str2, "alter table MediaDuplication add status int ");
                }
                if (iV > 0) {
                    C1720g.m3536RP().eJN.mo15640mB(iV);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.MediaCheckDuplicationStorage", "tryAddDBCol error: " + e.toString());
                    if (a2 != null) {
                        a2.close();
                    }
                    str = "MediaDuplication";
                    j = 0;
                    a = this.bSd.mo10104a("SELECT count(*) from ".concat(String.valueOf(str)), null, 2);
                    try {
                        if (a.moveToFirst()) {
                        }
                        a.close();
                        if (i >= 5000) {
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        i = 0;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e2, "", new Object[0]);
                            C4990ab.m7412e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + e2.toString());
                            if (a != null) {
                                a.close();
                            }
                            C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                            AppMethodBeat.m2505o(80281);
                        } catch (Throwable th) {
                            e = th;
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.m2505o(80281);
                            throw e;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                    AppMethodBeat.m2505o(80281);
                } catch (Throwable th2) {
                    e = th2;
                    cursor = a2;
                    if (cursor != null) {
                    }
                    AppMethodBeat.m2505o(80281);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            a2 = null;
        } catch (Throwable th3) {
            e = th3;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(80281);
            throw e;
        }
        str = "MediaDuplication";
        j = 0;
        try {
            a = this.bSd.mo10104a("SELECT count(*) from ".concat(String.valueOf(str)), null, 2);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            try {
                a.close();
                if (i >= 5000) {
                    j = (long) this.bSd.delete(str, null, null);
                }
            } catch (Exception e42) {
                e2 = e42;
                C4990ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e2, "", new Object[0]);
                C4990ab.m7412e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + e2.toString());
                if (a != null) {
                }
                C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                AppMethodBeat.m2505o(80281);
            }
        } catch (Exception e6) {
            e2 = e6;
            i = 0;
            a = null;
        } catch (Throwable th4) {
        }
        C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
        AppMethodBeat.m2505o(80281);
    }

    /* renamed from: y */
    public final boolean mo16779y(String str, int i, String str2) {
        AppMethodBeat.m2504i(80282);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            AppMethodBeat.m2505o(80282);
            return false;
        }
        if (i <= 0) {
            int cs = C1173e.m2560cs(str2);
            if (cs <= 0) {
                C4990ab.m7413e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", Integer.valueOf(i), Integer.valueOf(cs), str2);
                AppMethodBeat.m2505o(80282);
                return false;
            }
            i = cs;
        }
        if (C5046bo.isNullOrNil(str)) {
            str = C1178g.m2587cz(str2);
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7413e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", str2);
                AppMethodBeat.m2505o(80282);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(C5046bo.anU()));
        contentValues.put("status", Integer.valueOf(101));
        C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", Long.valueOf(this.bSd.insert("MediaDuplication", "", contentValues)), Integer.valueOf(i), str, str2);
        if (this.bSd.insert("MediaDuplication", "", contentValues) > 0) {
            AppMethodBeat.m2505o(80282);
            return true;
        }
        AppMethodBeat.m2505o(80282);
        return false;
    }

    /* renamed from: es */
    public final String mo16778es(String str, int i) {
        AppMethodBeat.m2504i(80283);
        String str2;
        if (C5046bo.isNullOrNil(str) || i <= 0) {
            C4990ab.m7413e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", str, Integer.valueOf(i));
            str2 = "";
            AppMethodBeat.m2505o(80283);
            return str2;
        }
        Cursor a = this.bSd.mo10104a("select path from MediaDuplication where md5 = '" + str + "' and  size = " + i + " and status != 100", null, 2);
        if (a == null) {
            C4990ab.m7413e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", str2);
            AppMethodBeat.m2505o(80283);
            return null;
        }
        str2 = "";
        if (a.moveToNext()) {
            str2 = a.getString(0);
        }
        a.close();
        if (!C5046bo.isNullOrNil(str2) && C1173e.m2560cs(str2) <= 0) {
            C4990ab.m7421w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", str2, Integer.valueOf(C1173e.m2560cs(str2)), Integer.valueOf(i));
            this.bSd.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i), "100"});
            str2 = "";
        }
        AppMethodBeat.m2505o(80283);
        return str2;
    }

    /* renamed from: P */
    public final boolean mo16776P(String str, String str2, int i) {
        AppMethodBeat.m2504i(80284);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7421w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", str, str2);
            AppMethodBeat.m2505o(80284);
            return false;
        }
        int cs = C1173e.m2560cs(str);
        int cs2 = C1173e.m2560cs(str2);
        if (cs <= 0 || cs2 <= 0) {
            C4990ab.m7421w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", Integer.valueOf(cs), Integer.valueOf(cs2));
            AppMethodBeat.m2505o(80284);
            return false;
        }
        String cz = C1178g.m2587cz(str);
        if (C5046bo.isNullOrNil(cz)) {
            C4990ab.m7420w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + cs);
            AppMethodBeat.m2505o(80284);
            return false;
        }
        long yz = C5046bo.m7588yz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", cz);
        contentValues.put("size", Integer.valueOf(cs));
        contentValues.put("createtime", Long.valueOf(C5046bo.anU()));
        contentValues.put("remuxing", str2);
        contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
        contentValues.put("status", Integer.valueOf(100));
        C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", Long.valueOf(this.bSd.insert("MediaDuplication", "", contentValues)), Integer.valueOf(cs), cz, str2, str, Integer.valueOf(i), Long.valueOf(C5046bo.m7525az(yz)));
        if (this.bSd.insert("MediaDuplication", "", contentValues) > 0) {
            AppMethodBeat.m2505o(80284);
            return true;
        }
        AppMethodBeat.m2505o(80284);
        return false;
    }

    /* renamed from: a */
    public final boolean mo16777a(String str, PString pString, PInt pInt) {
        AppMethodBeat.m2504i(80285);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            AppMethodBeat.m2505o(80285);
            return false;
        }
        int cs = C1173e.m2560cs(str);
        if (cs <= 0) {
            C4990ab.m7420w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(80285);
            return false;
        }
        String cz = C1178g.m2587cz(str);
        if (C5046bo.isNullOrNil(cz)) {
            C4990ab.m7420w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(80285);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + cz + "' AND  size = " + cs + " AND status = 100";
        long yz = C5046bo.m7588yz();
        Cursor cursor = null;
        try {
            cursor = this.bSd.mo10104a(str2, null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                pString.value = cursor.getString(0);
                pInt.value = cursor.getInt(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
            C4990ab.m7412e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(80285);
        }
        if (C5046bo.isNullOrNil(pString.value)) {
            C4990ab.m7410d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            AppMethodBeat.m2505o(80285);
            return false;
        } else if (C1173e.m2560cs(pString.value) <= 0) {
            C4990ab.m7420w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.bSd.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{cz, String.valueOf(cs), "100"});
            pString.value = null;
            AppMethodBeat.m2505o(80285);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", pString.value, Integer.valueOf(pInt.value), Long.valueOf(C5046bo.m7525az(yz)));
            AppMethodBeat.m2505o(80285);
            return true;
        }
    }
}
