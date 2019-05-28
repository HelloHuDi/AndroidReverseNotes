package com.tencent.p177mm.plugin.fav.p408b.p970f;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fav.p407a.C34129t;
import com.tencent.p177mm.plugin.fav.p407a.C43057f;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.b.f.c */
public final class C36765c extends C7563j<C43057f> implements C34129t {
    private C4927e bSd;

    /* renamed from: a */
    public final /* synthetic */ boolean mo54694a(C43057f c43057f) {
        AppMethodBeat.m2504i(5430);
        boolean b = super.mo10101b((C4925c) c43057f);
        AppMethodBeat.m2505o(5430);
        return b;
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo54695a(C43057f c43057f, String[] strArr) {
        AppMethodBeat.m2504i(5429);
        boolean c = super.mo10103c(c43057f, strArr);
        AppMethodBeat.m2505o(5429);
        return c;
    }

    public C36765c(C4927e c4927e) {
        super(c4927e, C43057f.ccO, "FavEditInfo", null);
        AppMethodBeat.m2504i(5425);
        this.bSd = c4927e;
        this.bSd.mo10108hY("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
        AppMethodBeat.m2505o(5425);
    }

    /* renamed from: iD */
    public final C43057f mo54697iD(long j) {
        C43057f c43057f = null;
        AppMethodBeat.m2504i(5426);
        Cursor a = this.bSd.mo10104a("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j), AppEventsConstants.EVENT_PARAM_VALUE_NO}, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5426);
        } else {
            if (a.moveToFirst()) {
                c43057f = new C43057f();
                c43057f.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(5426);
        }
        return c43057f;
    }

    /* renamed from: s */
    public final void mo54698s(long j, int i) {
        AppMethodBeat.m2504i(5427);
        this.bSd.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(j), String.valueOf(i)});
        AppMethodBeat.m2505o(5427);
    }

    public final List<C43057f> buQ() {
        AppMethodBeat.m2504i(5428);
        Cursor a = this.bSd.mo10104a("select count(*) from FavEditInfo", null, 2);
        if (a == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
            AppMethodBeat.m2505o(5428);
            return null;
        }
        try {
            if (a.moveToFirst()) {
                C4990ab.m7417i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", Integer.valueOf(a.getInt(0)));
            }
            a.close();
            a = this.bSd.mo10104a("select * from FavEditInfo", null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(5428);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                if (a.moveToFirst()) {
                    do {
                        C43057f c43057f = new C43057f();
                        c43057f.mo8995d(a);
                        arrayList.add(c43057f);
                    } while (a.moveToNext());
                }
                a.close();
                AppMethodBeat.m2505o(5428);
                return arrayList;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e, "", new Object[0]);
                a.close();
                AppMethodBeat.m2505o(5428);
                return null;
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", e2, "", new Object[0]);
            a.close();
            AppMethodBeat.m2505o(5428);
            return null;
        }
    }
}
