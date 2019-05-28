package com.tencent.mm.plugin.boots.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class a extends j<com.tencent.mm.plugin.boots.a.a> implements com.tencent.mm.cd.g.a {
    public static final String[] fnj = new String[]{j.a(com.tencent.mm.plugin.boots.a.a.ccO, "ActiveInfo")};
    private e bSd;

    static {
        AppMethodBeat.i(90537);
        AppMethodBeat.o(90537);
    }

    public a(e eVar) {
        super(eVar, com.tencent.mm.plugin.boots.a.a.ccO, "ActiveInfo", null);
        this.bSd = eVar;
    }

    public final int a(g gVar) {
        this.bSd = gVar;
        return 0;
    }

    public final String getTableName() {
        return "ActiveInfo";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int rU(int i) {
        Object obj;
        int i2;
        String str;
        String[] strArr;
        long insert;
        Throwable e;
        Throwable th;
        AppMethodBeat.i(90534);
        String str2 = "key=?";
        String[] strArr2 = new String[]{String.valueOf(i)};
        com.tencent.mm.plugin.boots.a.a aVar = new com.tencent.mm.plugin.boots.a.a();
        Cursor query;
        try {
            query = this.bSd.query("ActiveInfo", null, str2, strArr2, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar.d(query);
                        obj = null;
                        if (query != null) {
                            query.close();
                        }
                        i2 = (aVar.field_useTime >= bo.dpC() - 86400000 || aVar.field_useTime > bo.dpC()) ? aVar.field_useTime >= bo.dpC() - 86400000 ? aVar.field_dau > 0 ? aVar.field_dau : 1 : 1 : aVar.field_dau + 1;
                        aVar.field_useTime = System.currentTimeMillis();
                        aVar.field_dau = i2;
                        aVar.field_mau = 1;
                        str = "key=?";
                        strArr = new String[]{String.valueOf(i)};
                        if (obj != null) {
                            insert = this.bSd.insert("ActiveInfo", "key", aVar.Hl());
                        } else {
                            insert = (long) this.bSd.update("ActiveInfo", aVar.Hl(), str, strArr);
                        }
                        if (insert < 0) {
                            ab.w("MicroMsg.Tinker.ActiveInfoStorage", "update tinker info failed");
                        }
                        AppMethodBeat.o(90534);
                        return i2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    obj = null;
                    try {
                        ab.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "touch active key failed.", new Object[0]);
                        if (query != null) {
                            query.close();
                        }
                        if (aVar.field_useTime >= bo.dpC() - 86400000) {
                        }
                        if (aVar.field_useTime >= bo.dpC() - 86400000) {
                        }
                        aVar.field_useTime = System.currentTimeMillis();
                        aVar.field_dau = i2;
                        aVar.field_mau = 1;
                        str = "key=?";
                        strArr = new String[]{String.valueOf(i)};
                        if (obj != null) {
                        }
                        if (insert < 0) {
                        }
                        AppMethodBeat.o(90534);
                        return i2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(90534);
                        throw th;
                    }
                }
            }
            obj = 1;
            try {
                aVar.field_key = i;
                if (query != null) {
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
            obj = null;
            query = null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(90534);
            throw th;
        }
        if (aVar.field_useTime >= bo.dpC() - 86400000) {
        }
        if (aVar.field_useTime >= bo.dpC() - 86400000) {
        }
        aVar.field_useTime = System.currentTimeMillis();
        aVar.field_dau = i2;
        aVar.field_mau = 1;
        str = "key=?";
        strArr = new String[]{String.valueOf(i)};
        if (obj != null) {
        }
        if (insert < 0) {
        }
        AppMethodBeat.o(90534);
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.boots.a.a rV(int i) {
        Throwable e;
        AppMethodBeat.i(90535);
        com.tencent.mm.plugin.boots.a.a aVar = new com.tencent.mm.plugin.boots.a.a();
        Cursor query;
        try {
            query = this.bSd.query("ActiveInfo", null, "key =?", new String[]{String.valueOf(i)}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar.d(query);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "getActiveInfoByKey %s failed.", Integer.toHexString(i));
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(90535);
                        return aVar;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(90535);
                        throw e;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(90535);
            throw e;
        }
        AppMethodBeat.o(90535);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<com.tencent.mm.plugin.boots.a.a> aVJ() {
        AppMethodBeat.i(90536);
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.bSd.a("select * from ActiveInfo where useTime >= ?", new String[]{String.valueOf(bo.dpC() - 86400000)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(90536);
                return arrayList;
            }
            do {
                com.tencent.mm.plugin.boots.a.a aVar = new com.tencent.mm.plugin.boots.a.a();
                aVar.d(cursor);
                arrayList.add(aVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
            }
            AppMethodBeat.o(90536);
            return arrayList;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Tinker.ActiveInfoStorage", e, "getDayActiveFeature failed.", new Object[0]);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(90536);
        }
    }
}
