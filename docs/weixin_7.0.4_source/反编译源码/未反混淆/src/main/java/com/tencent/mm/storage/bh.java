package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class bh extends n {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public e bSd;

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
    public bh(h hVar) {
        int i;
        Throwable e;
        String str;
        long j;
        Cursor a;
        Throwable e2;
        Cursor cursor = null;
        AppMethodBeat.i(80281);
        this.bSd = hVar;
        String str2 = "MediaDuplication";
        Cursor a2;
        try {
            a2 = this.bSd.a("PRAGMA table_info( " + str2 + " )", null, 2);
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
                long iV = g.RP().eJN.iV(Thread.currentThread().getId());
                if (i3 == 0) {
                    ab.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [remuxing] column, alter table now");
                    this.bSd.hY(str2, "alter table MediaDuplication add remuxing text ");
                }
                if (i2 == 0) {
                    ab.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [duration] column, alter table now");
                    this.bSd.hY(str2, "alter table MediaDuplication add duration int ");
                }
                if (i == 0) {
                    ab.i("MicroMsg.MediaCheckDuplicationStorage", "it had no [status] column, alter table now");
                    this.bSd.hY(str2, "alter table MediaDuplication add status int ");
                }
                if (iV > 0) {
                    g.RP().eJN.mB(iV);
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
                    ab.e("MicroMsg.MediaCheckDuplicationStorage", "tryAddDBCol error: " + e.toString());
                    if (a2 != null) {
                        a2.close();
                    }
                    str = "MediaDuplication";
                    j = 0;
                    a = this.bSd.a("SELECT count(*) from ".concat(String.valueOf(str)), null, 2);
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
                            ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e2, "", new Object[0]);
                            ab.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + e2.toString());
                            if (a != null) {
                                a.close();
                            }
                            ab.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                            AppMethodBeat.o(80281);
                        } catch (Throwable th) {
                            e = th;
                            if (a != null) {
                                a.close();
                            }
                            AppMethodBeat.o(80281);
                            throw e;
                        }
                    }
                    ab.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                    AppMethodBeat.o(80281);
                } catch (Throwable th2) {
                    e = th2;
                    cursor = a2;
                    if (cursor != null) {
                    }
                    AppMethodBeat.o(80281);
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
            AppMethodBeat.o(80281);
            throw e;
        }
        str = "MediaDuplication";
        j = 0;
        try {
            a = this.bSd.a("SELECT count(*) from ".concat(String.valueOf(str)), null, 2);
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
                ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e2, "", new Object[0]);
                ab.e("MicroMsg.MediaCheckDuplicationStorage", "check to delete MediaDuplication. error : " + e2.toString());
                if (a != null) {
                }
                ab.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
                AppMethodBeat.o(80281);
            }
        } catch (Exception e6) {
            e2 = e6;
            i = 0;
            a = null;
        } catch (Throwable th4) {
        }
        ab.i("MicroMsg.MediaCheckDuplicationStorage", "MediaDuplication record[%d], max record[%d], deleteRecord[%d]", Integer.valueOf(i), Integer.valueOf(5000), Long.valueOf(j));
        AppMethodBeat.o(80281);
    }

    public final boolean y(String str, int i, String str2) {
        AppMethodBeat.i(80282);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            AppMethodBeat.o(80282);
            return false;
        }
        if (i <= 0) {
            int cs = com.tencent.mm.a.e.cs(str2);
            if (cs <= 0) {
                ab.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", Integer.valueOf(i), Integer.valueOf(cs), str2);
                AppMethodBeat.o(80282);
                return false;
            }
            i = cs;
        }
        if (bo.isNullOrNil(str)) {
            str = com.tencent.mm.a.g.cz(str2);
            if (bo.isNullOrNil(str)) {
                ab.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", str2);
                AppMethodBeat.o(80282);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(bo.anU()));
        contentValues.put("status", Integer.valueOf(101));
        ab.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", Long.valueOf(this.bSd.insert("MediaDuplication", "", contentValues)), Integer.valueOf(i), str, str2);
        if (this.bSd.insert("MediaDuplication", "", contentValues) > 0) {
            AppMethodBeat.o(80282);
            return true;
        }
        AppMethodBeat.o(80282);
        return false;
    }

    public final String es(String str, int i) {
        AppMethodBeat.i(80283);
        String str2;
        if (bo.isNullOrNil(str) || i <= 0) {
            ab.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", str, Integer.valueOf(i));
            str2 = "";
            AppMethodBeat.o(80283);
            return str2;
        }
        Cursor a = this.bSd.a("select path from MediaDuplication where md5 = '" + str + "' and  size = " + i + " and status != 100", null, 2);
        if (a == null) {
            ab.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", str2);
            AppMethodBeat.o(80283);
            return null;
        }
        str2 = "";
        if (a.moveToNext()) {
            str2 = a.getString(0);
        }
        a.close();
        if (!bo.isNullOrNil(str2) && com.tencent.mm.a.e.cs(str2) <= 0) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", str2, Integer.valueOf(com.tencent.mm.a.e.cs(str2)), Integer.valueOf(i));
            this.bSd.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i), "100"});
            str2 = "";
        }
        AppMethodBeat.o(80283);
        return str2;
    }

    public final boolean P(String str, String str2, int i) {
        AppMethodBeat.i(80284);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", str, str2);
            AppMethodBeat.o(80284);
            return false;
        }
        int cs = com.tencent.mm.a.e.cs(str);
        int cs2 = com.tencent.mm.a.e.cs(str2);
        if (cs <= 0 || cs2 <= 0) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", Integer.valueOf(cs), Integer.valueOf(cs2));
            AppMethodBeat.o(80284);
            return false;
        }
        String cz = com.tencent.mm.a.g.cz(str);
        if (bo.isNullOrNil(cz)) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + cs);
            AppMethodBeat.o(80284);
            return false;
        }
        long yz = bo.yz();
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", cz);
        contentValues.put("size", Integer.valueOf(cs));
        contentValues.put("createtime", Long.valueOf(bo.anU()));
        contentValues.put("remuxing", str2);
        contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
        contentValues.put("status", Integer.valueOf(100));
        ab.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", Long.valueOf(this.bSd.insert("MediaDuplication", "", contentValues)), Integer.valueOf(cs), cz, str2, str, Integer.valueOf(i), Long.valueOf(bo.az(yz)));
        if (this.bSd.insert("MediaDuplication", "", contentValues) > 0) {
            AppMethodBeat.o(80284);
            return true;
        }
        AppMethodBeat.o(80284);
        return false;
    }

    public final boolean a(String str, PString pString, PInt pInt) {
        AppMethodBeat.i(80285);
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            AppMethodBeat.o(80285);
            return false;
        }
        int cs = com.tencent.mm.a.e.cs(str);
        if (cs <= 0) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : ".concat(String.valueOf(str)));
            AppMethodBeat.o(80285);
            return false;
        }
        String cz = com.tencent.mm.a.g.cz(str);
        if (bo.isNullOrNil(cz)) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : ".concat(String.valueOf(str)));
            AppMethodBeat.o(80285);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + cz + "' AND  size = " + cs + " AND status = 100";
        long yz = bo.yz();
        Cursor cursor = null;
        try {
            cursor = this.bSd.a(str2, null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                pString.value = cursor.getString(0);
                pInt.value = cursor.getInt(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
            ab.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(80285);
        }
        if (bo.isNullOrNil(pString.value)) {
            ab.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            AppMethodBeat.o(80285);
            return false;
        } else if (com.tencent.mm.a.e.cs(pString.value) <= 0) {
            ab.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.bSd.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{cz, String.valueOf(cs), "100"});
            pString.value = null;
            AppMethodBeat.o(80285);
            return false;
        } else {
            ab.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", pString.value, Integer.valueOf(pInt.value), Long.valueOf(bo.az(yz)));
            AppMethodBeat.o(80285);
            return true;
        }
    }
}
