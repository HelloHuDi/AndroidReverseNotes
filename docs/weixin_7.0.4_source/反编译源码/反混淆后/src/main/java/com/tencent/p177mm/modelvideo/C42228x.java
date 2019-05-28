package com.tencent.p177mm.modelvideo;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelvideo.x */
public final class C42228x {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS VideoPlayHistory ( filename text PRIMARY KEY, starttime int, playduration int, downloadway int );"};
    C4927e bSd;

    public C42228x(C7480h c7480h) {
        this.bSd = c7480h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: uB */
    public final boolean mo67755uB(String str) {
        Cursor cursor;
        Cursor query;
        Throwable e;
        AppMethodBeat.m2504i(50864);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50864);
            return false;
        }
        cursor = null;
        try {
            query = this.bSd.query("VideoPlayHistory", new String[]{"filename"}, "filename=?", new String[]{C5046bo.m7586vA(str)}, "", "", "");
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(50864);
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
            AppMethodBeat.m2505o(50864);
            throw e;
        }
        AppMethodBeat.m2505o(50864);
        return false;
        try {
            C4990ab.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(50864);
            return false;
        } catch (Throwable th2) {
            e = th2;
            cursor = query;
            if (cursor != null) {
            }
            AppMethodBeat.m2505o(50864);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final boolean mo67754b(String str, PInt pInt, PInt pInt2) {
        boolean z;
        Throwable e;
        AppMethodBeat.m2504i(50865);
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.bSd.mo10105a("VideoPlayHistory", new String[]{"starttime", "playduration"}, "filename=?", new String[]{C5046bo.m7586vA(str)}, "", "", "", 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        pInt.value = a.getInt(a.getColumnIndex("starttime"));
                        pInt2.value = a.getInt(a.getColumnIndex("playduration"));
                        z = true;
                        if (a != null) {
                            a.close();
                        }
                        C4990ab.m7416i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        AppMethodBeat.m2505o(50865);
                        return z;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.VideoPlayHistoryStorage", e, "", new Object[0]);
                        if (a != null) {
                            a.close();
                            z = false;
                        } else {
                            z = false;
                        }
                        C4990ab.m7416i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
                        AppMethodBeat.m2505o(50865);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                        cursor = a;
                        if (cursor != null) {
                        }
                        AppMethodBeat.m2505o(50865);
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
            AppMethodBeat.m2505o(50865);
            throw e;
        }
        C4990ab.m7416i("MicroMsg.VideoPlayHistoryStorage", "getPlayDuration ret : " + z + " starttime : " + pInt.value + " playduration : " + pInt2.value);
        AppMethodBeat.m2505o(50865);
        return z;
    }
}
