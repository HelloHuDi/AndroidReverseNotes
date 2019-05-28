package com.tencent.mm.plugin.appbrand.game.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class c extends j<b> {
    public static final String[] fjY = new String[]{j.a(b.ccO, "WxagGameInfo")};
    private final boolean hrm;

    static {
        AppMethodBeat.i(130120);
        AppMethodBeat.o(130120);
    }

    public c(e eVar) {
        super(eVar, b.ccO, "WxagGameInfo", null);
        AppMethodBeat.i(130109);
        this.hrm = eVar != null;
        if (!this.hrm) {
            ab.e("MicroMsg.MiniGameInfoStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(130109);
    }

    public final List<b> aAH() {
        List<b> list = null;
        AppMethodBeat.i(130110);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select * from %s", new Object[]{"WxagGameInfo"}), new String[0]);
            ab.i("MicroMsg.MiniGameInfoStorage", "getMiniGameList queryStr:%s", r1);
            if (rawQuery == null) {
                ab.i("MicroMsg.MiniGameInfoStorage", "cursor is null");
                AppMethodBeat.o(130110);
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    b bVar = new b();
                    bVar.d(rawQuery);
                    list.add(bVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                ab.i("MicroMsg.MiniGameInfoStorage", "record list size:%s", Integer.valueOf(list.size()));
                AppMethodBeat.o(130110);
            } else {
                rawQuery.close();
                ab.i("MicroMsg.MiniGameInfoStorage", "no record");
                AppMethodBeat.o(130110);
            }
        } else {
            AppMethodBeat.o(130110);
        }
        return list;
    }

    public final b As(String str) {
        AppMethodBeat.i(130111);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(130111);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WxagGameInfo", "RecordId"}), str);
        if (rawQuery.moveToFirst()) {
            b bVar = new b();
            bVar.d(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(130111);
            return bVar;
        }
        ab.i("MicroMsg.MiniGameInfoStorage", "getMiniGame recordId:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.o(130111);
        return null;
    }

    public final void c(a aVar) {
        AppMethodBeat.i(130112);
        a(aVar, com.tencent.mm.plugin.appbrand.s.e.aNS().oAl.getLooper());
        AppMethodBeat.o(130112);
    }

    public final boolean b(List<a> list, boolean z) {
        AppMethodBeat.i(130113);
        if (!this.hrm || bo.ek(list)) {
            AppMethodBeat.o(130113);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            a(aVar, false);
            arrayList.add(aVar.euD);
        }
        if (z) {
            b("batch", 2, arrayList);
        }
        ab.i("MicroMsg.MiniGameInfoStorage", "insert miniGame size:%d,   isSync:%b", Integer.valueOf(list.size()), Boolean.FALSE);
        AppMethodBeat.o(130113);
        return true;
    }

    public final boolean ae(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(130114);
        if (!this.hrm || bo.isNullOrNil(str)) {
            AppMethodBeat.o(130114);
        } else {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_RecordId = str;
            z2 = super.a(bVar, new String[0]);
            if (z2 && z) {
                b("single", 5, str);
            }
            AppMethodBeat.o(130114);
        }
        return z2;
    }

    public final boolean aH(List<String> list) {
        AppMethodBeat.i(130115);
        if (!this.hrm || bo.ek(list)) {
            AppMethodBeat.o(130115);
            return false;
        }
        for (String ae : list) {
            ae(ae, false);
        }
        b("batch", 5, list);
        AppMethodBeat.o(130115);
        return true;
    }

    public final boolean a(a aVar, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(130116);
        if (!this.hrm || aVar == null) {
            AppMethodBeat.o(130116);
        } else {
            boolean z3;
            b bd = bd(aVar.fKh, aVar.gVs);
            if (bd == null || !bd.field_isSync) {
                z3 = true;
            } else {
                z3 = false;
            }
            ab.i("MicroMsg.MiniGameInfoStorage", "needUpdate:%b", Boolean.valueOf(z3));
            if (z3) {
                a(bd);
                b bVar = new b();
                if (bo.isNullOrNil(aVar.euD)) {
                    aVar.euD = be(aVar.jBB, aVar.gVs);
                }
                bVar.field_RecordId = aVar.euD;
                bVar.field_AppId = aVar.fKh;
                bVar.field_AppName = aVar.ncH;
                bVar.field_UserName = aVar.jBB;
                bVar.field_IconUrl = aVar.IconUrl;
                bVar.field_BriefIntro = aVar.nay;
                bVar.field_isSync = false;
                bVar.field_createTime = System.currentTimeMillis();
                z2 = b((com.tencent.mm.sdk.e.c) bVar);
                if (z2 && z) {
                    b("single", 2, bVar.field_RecordId);
                }
                AppMethodBeat.o(130116);
            } else {
                AppMethodBeat.o(130116);
            }
        }
        return z2;
    }

    private boolean a(b bVar) {
        AppMethodBeat.i(130117);
        if (!this.hrm || bVar == null) {
            AppMethodBeat.o(130117);
            return false;
        }
        boolean a = super.a((com.tencent.mm.sdk.e.c) bVar, new String[0]);
        AppMethodBeat.o(130117);
        return a;
    }

    private b bd(String str, int i) {
        AppMethodBeat.i(130118);
        if (this.hrm) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=?", new Object[]{"WxagGameInfo", "AppId", "debugType"}), str, String.valueOf(i));
            if (rawQuery.moveToFirst()) {
                b bVar = new b();
                bVar.d(rawQuery);
                rawQuery.close();
                AppMethodBeat.o(130118);
                return bVar;
            }
            rawQuery.close();
            AppMethodBeat.o(130118);
            return null;
        }
        AppMethodBeat.o(130118);
        return null;
    }

    private static String be(String str, int i) {
        AppMethodBeat.i(130119);
        String valueOf = String.valueOf(String.format(Locale.US, "%s|%d", new Object[]{str, Integer.valueOf(i)}).hashCode());
        AppMethodBeat.o(130119);
        return valueOf;
    }
}
