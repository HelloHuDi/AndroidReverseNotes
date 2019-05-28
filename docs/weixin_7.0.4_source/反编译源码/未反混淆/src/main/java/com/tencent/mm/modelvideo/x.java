package com.tencent.mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class x {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );"};
    e bSd;

    public x(h hVar) {
        this.bSd = hVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean uB(String str) {
        Cursor cursor;
        Cursor query;
        Throwable e;
        AppMethodBeat.i(50864);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50864);
            return false;
        }
        cursor = null;
        try {
            query = this.bSd.query("VideoPlayHistory", new String[]{"filename"}, "filename=?", new String[]{bo.vA(str)}, "", "", "");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(50864);
                        return true;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th) {
            e = th;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(50864);
            throw e;
        }
        AppMethodBeat.o(50864);
        return false;
        try {
            ab.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(50864);
            return false;
        } catch (Throwable th2) {
            e = th2;
            cursor = query;
            if (cursor != null) {
            }
            AppMethodBeat.o(50864);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(String str, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable e;
        AppMethodBeat.i(50865);
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.bSd.a("VideoPlayHistory", new String[]{"starttime", "playduration"}, "filename=?", new String[]{bo.vA(str)}, "", "", "", 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        pInt.value = a.getInt(a.getColumnIndex("starttime"));
                        pInt2.value = a.getInt(a.getColumnIndex("playduration"));
                        z = true;
                        if (a != null) {
                            a.close();
                        }
                        ab.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        AppMethodBeat.o(50865);
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
                        if (a != null) {
                            a.close();
                            z = false;
                        } else {
                            z = false;
                        }
                        ab.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        AppMethodBeat.o(50865);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        cursor = a;
                        if (cursor != null) {
                        }
                        AppMethodBeat.o(50865);
                        throw e;
                    }
                }
            }
            z = false;
            if (a != null) {
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(50865);
            throw e;
        }
        ab.i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
        AppMethodBeat.o(50865);
        return z;
    }
}
