package com.tencent.p177mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p1024b.C21875k;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.u */
public final class C35001u extends C7563j<C13479t> implements C21875k {
    public static final String[] fnj = new String[]{C7563j.m13217a(C13479t.ccO, "snsTagInfo2")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(38016);
        AppMethodBeat.m2505o(38016);
    }

    public C35001u(C4927e c4927e) {
        super(c4927e, C13479t.ccO, "snsTagInfo2", null);
        this.bSd = c4927e;
    }

    /* renamed from: kF */
    public final C13479t mo55579kF(long j) {
        AppMethodBeat.m2504i(38005);
        Cursor a = this.bSd.mo10104a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j)}, 2);
        C13479t c13479t = new C13479t();
        if (a.moveToFirst()) {
            c13479t.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(38005);
        return c13479t;
    }

    /* renamed from: jT */
    public final List<String> mo37359jT(long j) {
        AppMethodBeat.m2504i(38006);
        C13479t kF = mo55579kF(j);
        if (kF.field_memberList == null || kF.field_memberList.equals("")) {
            List<String> arrayList = new ArrayList();
            AppMethodBeat.m2505o(38006);
            return arrayList;
        }
        ArrayList P = C5046bo.m7508P(kF.field_memberList.split(","));
        AppMethodBeat.m2505o(38006);
        return P;
    }

    /* renamed from: jU */
    public final String mo37360jU(long j) {
        AppMethodBeat.m2504i(38007);
        String str = mo55579kF(j).field_tagName;
        AppMethodBeat.m2505o(38007);
        return str;
    }

    public final List<Long> cru() {
        AppMethodBeat.m2504i(38008);
        Cursor a = this.bSd.mo10105a("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        AppMethodBeat.m2505o(38008);
        return arrayList;
    }

    /* renamed from: a */
    public final boolean mo55576a(C13479t c13479t) {
        AppMethodBeat.m2504i(38009);
        if (c13479t.field_tagId == 0) {
            AppMethodBeat.m2505o(38009);
            return false;
        }
        long j = c13479t.field_tagId;
        Cursor a = this.bSd.mo10104a("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j)}, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            super.mo10099a(c13479t);
        } else {
            super.mo10101b((C4925c) c13479t);
        }
        mo15641b(c13479t.field_tagId, 0, c13479t);
        AppMethodBeat.m2505o(38009);
        return true;
    }

    /* renamed from: kG */
    public final int mo55580kG(long j) {
        AppMethodBeat.m2504i(38010);
        int delete = this.bSd.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
        AppMethodBeat.m2505o(38010);
        return delete;
    }

    /* renamed from: v */
    public final boolean mo55581v(long j, String str) {
        AppMethodBeat.m2504i(38011);
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + C5046bo.m7586vA(str) + "\" AND  tagId != " + j;
        C4990ab.m7410d("MicroMsg.SnsTagInfoStorage", "isTagNameExist ".concat(String.valueOf(str2)));
        Cursor a = this.bSd.mo10104a(str2, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.m2505o(38011);
        return moveToFirst;
    }

    public final Cursor getCursor() {
        AppMethodBeat.m2504i(38012);
        Cursor rawQuery = this.bSd.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
        AppMethodBeat.m2505o(38012);
        return rawQuery;
    }

    /* renamed from: UV */
    public final boolean mo37357UV(String str) {
        AppMethodBeat.m2504i(38013);
        C13479t kF = mo55579kF(5);
        if (C5046bo.isNullOrNil(kF.field_memberList)) {
            AppMethodBeat.m2505o(38013);
            return false;
        }
        boolean contains = C5046bo.m7508P(kF.field_memberList.split(",")).contains(str);
        AppMethodBeat.m2505o(38013);
        return contains;
    }

    public final boolean cmo() {
        AppMethodBeat.m2504i(38014);
        if (cru().size() == 0) {
            AppMethodBeat.m2505o(38014);
            return false;
        }
        AppMethodBeat.m2505o(38014);
        return true;
    }
}
