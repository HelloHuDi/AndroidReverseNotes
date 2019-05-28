package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public final class u extends j<t> implements k {
    public static final String[] fnj = new String[]{j.a(t.ccO, "snsTagInfo2")};
    private e bSd;

    static {
        AppMethodBeat.i(38016);
        AppMethodBeat.o(38016);
    }

    public u(e eVar) {
        super(eVar, t.ccO, "snsTagInfo2", null);
        this.bSd = eVar;
    }

    public final t kF(long j) {
        AppMethodBeat.i(38005);
        Cursor a = this.bSd.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j)}, 2);
        t tVar = new t();
        if (a.moveToFirst()) {
            tVar.d(a);
        }
        a.close();
        AppMethodBeat.o(38005);
        return tVar;
    }

    public final List<String> jT(long j) {
        AppMethodBeat.i(38006);
        t kF = kF(j);
        if (kF.field_memberList == null || kF.field_memberList.equals("")) {
            List<String> arrayList = new ArrayList();
            AppMethodBeat.o(38006);
            return arrayList;
        }
        ArrayList P = bo.P(kF.field_memberList.split(","));
        AppMethodBeat.o(38006);
        return P;
    }

    public final String jU(long j) {
        AppMethodBeat.i(38007);
        String str = kF(j).field_tagName;
        AppMethodBeat.o(38007);
        return str;
    }

    public final List<Long> cru() {
        AppMethodBeat.i(38008);
        Cursor a = this.bSd.a("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        AppMethodBeat.o(38008);
        return arrayList;
    }

    public final boolean a(t tVar) {
        AppMethodBeat.i(38009);
        if (tVar.field_tagId == 0) {
            AppMethodBeat.o(38009);
            return false;
        }
        long j = tVar.field_tagId;
        Cursor a = this.bSd.a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j)}, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            super.a(tVar);
        } else {
            super.b((c) tVar);
        }
        b(tVar.field_tagId, 0, tVar);
        AppMethodBeat.o(38009);
        return true;
    }

    public final int kG(long j) {
        AppMethodBeat.i(38010);
        int delete = this.bSd.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
        AppMethodBeat.o(38010);
        return delete;
    }

    public final boolean v(long j, String str) {
        AppMethodBeat.i(38011);
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + bo.vA(str) + "\" AND  tagId != " + j;
        ab.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist ".concat(String.valueOf(str2)));
        Cursor a = this.bSd.a(str2, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.o(38011);
        return moveToFirst;
    }

    public final Cursor getCursor() {
        AppMethodBeat.i(38012);
        Cursor rawQuery = this.bSd.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
        AppMethodBeat.o(38012);
        return rawQuery;
    }

    public final boolean UV(String str) {
        AppMethodBeat.i(38013);
        t kF = kF(5);
        if (bo.isNullOrNil(kF.field_memberList)) {
            AppMethodBeat.o(38013);
            return false;
        }
        boolean contains = bo.P(kF.field_memberList.split(",")).contains(str);
        AppMethodBeat.o(38013);
        return contains;
    }

    public final boolean cmo() {
        AppMethodBeat.i(38014);
        if (cru().size() == 0) {
            AppMethodBeat.o(38014);
            return false;
        }
        AppMethodBeat.o(38014);
        return true;
    }
}
