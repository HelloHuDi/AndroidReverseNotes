package com.tencent.p177mm.plugin.fav.p408b.p970f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C6894q;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.mm.plugin.fav.b.f.a */
public final class C11861a extends C7563j<C45925c> implements C6894q {
    private C4927e bSd;
    private List<C11855p> bkF = new CopyOnWriteArrayList();

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(5419);
        boolean a = mo15158a((C45925c) c4925c, strArr);
        AppMethodBeat.m2505o(5419);
        return a;
    }

    /* renamed from: a */
    public final void mo15157a(C11855p c11855p) {
        AppMethodBeat.m2504i(5402);
        if (c11855p != null) {
            this.bkF.add(c11855p);
        }
        AppMethodBeat.m2505o(5402);
    }

    /* renamed from: b */
    public final void mo15159b(C11855p c11855p) {
        AppMethodBeat.m2504i(5403);
        if (c11855p != null) {
            this.bkF.remove(c11855p);
        }
        AppMethodBeat.m2505o(5403);
    }

    public C11861a(C4927e c4927e) {
        super(c4927e, C45925c.ccO, "FavCdnInfo", null);
        AppMethodBeat.m2504i(5404);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(5404);
    }

    public final void buL() {
        AppMethodBeat.m2504i(5405);
        this.bSd.mo10108hY("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
        AppMethodBeat.m2505o(5405);
    }

    /* renamed from: e */
    public final boolean mo15165e(C45925c c45925c) {
        AppMethodBeat.m2504i(5406);
        if (c45925c == null) {
            AppMethodBeat.m2505o(5406);
            return false;
        } else if (super.mo10101b((C4925c) c45925c)) {
            for (C11855p c11855p : this.bkF) {
                if (c11855p != null) {
                    c11855p.mo23673d(c45925c);
                }
            }
            AppMethodBeat.m2505o(5406);
            return true;
        } else {
            AppMethodBeat.m2505o(5406);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo15158a(C45925c c45925c, String... strArr) {
        AppMethodBeat.m2504i(5407);
        if (super.mo10103c(c45925c, strArr)) {
            for (C11855p c11855p : this.bkF) {
                if (c11855p != null) {
                    c11855p.mo23673d(c45925c);
                }
            }
            AppMethodBeat.m2505o(5407);
            return true;
        }
        AppMethodBeat.m2505o(5407);
        return false;
    }

    /* renamed from: b */
    public final boolean mo15160b(C45925c c45925c, String... strArr) {
        AppMethodBeat.m2504i(5408);
        if (super.mo16760a((C4925c) c45925c, strArr)) {
            for (C11855p c11855p : this.bkF) {
                if (c11855p != null) {
                    c11855p.mo23673d(c45925c);
                }
            }
            AppMethodBeat.m2505o(5408);
            return true;
        }
        AppMethodBeat.m2505o(5408);
        return false;
    }

    /* renamed from: LR */
    public final C45925c mo15156LR(String str) {
        C45925c c45925c = null;
        AppMethodBeat.m2504i(5409);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FavCdnStorage", "md5 null");
            AppMethodBeat.m2505o(5409);
        } else {
            Cursor a = this.bSd.mo10104a("select * from FavCdnInfo where dataId = '" + str + "'", null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(5409);
            } else {
                if (a.moveToFirst()) {
                    c45925c = new C45925c();
                    c45925c.mo8995d(a);
                }
                a.close();
                AppMethodBeat.m2505o(5409);
            }
        }
        return c45925c;
    }

    /* renamed from: x */
    public final void mo15171x(C27966g c27966g) {
        AppMethodBeat.m2504i(5410);
        this.bSd.mo10108hY("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + C5046bo.anU() + " where favLocalId = " + c27966g.field_localId + " and type = 0 and status <> 3");
        AppMethodBeat.m2505o(5410);
    }

    public final LinkedList<C45925c> buM() {
        LinkedList<C45925c> linkedList = null;
        AppMethodBeat.m2504i(5411);
        Cursor a = this.bSd.mo10104a("select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5411);
        } else if (a.moveToFirst()) {
            linkedList = new LinkedList();
            do {
                C45925c c45925c = new C45925c();
                c45925c.mo8995d(a);
                linkedList.add(c45925c);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.m2505o(5411);
        } else {
            a.close();
            AppMethodBeat.m2505o(5411);
        }
        return linkedList;
    }

    /* renamed from: iz */
    public final List<C45925c> mo15169iz(long j) {
        AppMethodBeat.m2504i(5412);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select * from FavCdnInfo where favLocalId = ".concat(String.valueOf(j)), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                C45925c c45925c = new C45925c();
                c45925c.mo8995d(a);
                arrayList.add(c45925c);
            }
            a.close();
        }
        C4990ab.m7419v("MicroMsg.FavCdnStorage", "getInfos size:%d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(5412);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: iA */
    public final List<C45925c> mo15166iA(long j) {
        AppMethodBeat.m2504i(5413);
        LinkedList linkedList = new LinkedList();
        Cursor a = this.bSd.mo10104a("select * from FavCdnInfo where favLocalId = " + j + " and type = 0 and status = 3", null, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            C4990ab.m7419v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", Integer.valueOf(linkedList.size()));
            AppMethodBeat.m2505o(5413);
            return linkedList;
        }
        do {
            C45925c c45925c = new C45925c();
            c45925c.mo8995d(a);
            linkedList.add(c45925c);
        } while (a.moveToNext());
        if (a != null) {
        }
        C4990ab.m7419v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.m2505o(5413);
        return linkedList;
    }

    /* renamed from: iB */
    public final void mo15167iB(long j) {
        AppMethodBeat.m2504i(5414);
        this.bSd.mo10108hY("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", new Object[]{"FavCdnInfo", "favLocalId", Long.valueOf(j), "type", Integer.valueOf(0)}));
        AppMethodBeat.m2505o(5414);
    }

    /* renamed from: r */
    public final int mo15170r(long j, int i) {
        AppMethodBeat.m2504i(5415);
        Cursor a = this.bSd.mo10104a("select status from FavCdnInfo where favLocalId = " + j + " and type = " + i, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5415);
            return 3;
        } else if (a.moveToFirst()) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            do {
                int i5 = a.getInt(0);
                if (i5 == 1) {
                    a.close();
                    AppMethodBeat.m2505o(5415);
                    return 1;
                }
                if (i5 != 4) {
                    i4 = 0;
                }
                if (i5 != 2) {
                    i3 = 0;
                }
                if (i5 != 3) {
                    i2 = 0;
                }
            } while (a.moveToNext());
            a.close();
            if (i3 != 0) {
                AppMethodBeat.m2505o(5415);
                return 2;
            } else if (i4 != 0) {
                AppMethodBeat.m2505o(5415);
                return 4;
            } else if (i2 != 0) {
                AppMethodBeat.m2505o(5415);
                return 3;
            } else {
                AppMethodBeat.m2505o(5415);
                return 0;
            }
        } else {
            a.close();
            AppMethodBeat.m2505o(5415);
            return 3;
        }
    }

    public final Cursor buN() {
        AppMethodBeat.m2504i(5416);
        Cursor rawQuery = this.bSd.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
        AppMethodBeat.m2505o(5416);
        return rawQuery;
    }

    public final Cursor buO() {
        AppMethodBeat.m2504i(5417);
        Cursor rawQuery = this.bSd.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
        AppMethodBeat.m2505o(5417);
        return rawQuery;
    }

    /* renamed from: iC */
    public final boolean mo15168iC(long j) {
        AppMethodBeat.m2504i(5418);
        C45925c c45925c = new C45925c();
        c45925c.field_favLocalId = j;
        boolean b = mo15160b(c45925c, "favLocalId");
        AppMethodBeat.m2505o(5418);
        return b;
    }
}
