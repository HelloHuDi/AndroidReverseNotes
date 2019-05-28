package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.storage.bn */
public final class C30297bn extends C7563j<C36001bm> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C36001bm.ccO, "NewTipsInfo")};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(80291);
        boolean f = mo48502f((C36001bm) c4925c);
        AppMethodBeat.m2505o(80291);
        return f;
    }

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(80290);
        boolean a = mo48501a((C36001bm) c4925c, strArr);
        AppMethodBeat.m2505o(80290);
        return a;
    }

    static {
        AppMethodBeat.m2504i(80292);
        AppMethodBeat.m2505o(80292);
    }

    public C30297bn(C4927e c4927e) {
        super(c4927e, C36001bm.ccO, "NewTipsInfo", null);
        this.bSd = c4927e;
    }

    /* renamed from: f */
    public final boolean mo48502f(C36001bm c36001bm) {
        boolean z = false;
        AppMethodBeat.m2504i(80287);
        if (c36001bm == null) {
            C4990ab.m7412e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
            AppMethodBeat.m2505o(80287);
        } else if (c36001bm.field_tipId <= 0) {
            C4990ab.m7413e("MicroMsg.NewTipsInfoStorage", "newTipsId is error, tipsId = %s", Integer.valueOf(c36001bm.field_tipId));
            AppMethodBeat.m2505o(80287);
        } else {
            z = mo16759a((C4925c) c36001bm, false);
            if (z) {
                mo15641b(c36001bm.field_tipId, 2, Integer.valueOf(c36001bm.field_tipId));
            }
            AppMethodBeat.m2505o(80287);
        }
        return z;
    }

    /* renamed from: a */
    public final boolean mo48501a(C36001bm c36001bm, String... strArr) {
        AppMethodBeat.m2504i(80288);
        if (c36001bm == null) {
            C4990ab.m7412e("MicroMsg.NewTipsInfoStorage", "NewTipsInfo is null!");
            AppMethodBeat.m2505o(80288);
            return false;
        }
        boolean b = super.mo16762b(c36001bm, false, strArr);
        if (b) {
            mo15641b(c36001bm.field_tipId, 3, Integer.valueOf(c36001bm.field_tipId));
        }
        C4990ab.m7411d("MicroMsg.NewTipsInfoStorage", "update result[%B]", Boolean.valueOf(b));
        AppMethodBeat.m2505o(80288);
        return b;
    }

    /* renamed from: Ms */
    public final C36001bm mo48500Ms(int i) {
        AppMethodBeat.m2504i(80289);
        if (this.bSd == null) {
            C4990ab.m7412e("MicroMsg.NewTipsInfoStorage", "getByTipsId, but db is null, return");
            AppMethodBeat.m2505o(80289);
            return null;
        }
        Cursor a = this.bSd.mo10105a("NewTipsInfo", null, "tipId=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a.moveToFirst()) {
            C36001bm c36001bm = new C36001bm();
            try {
                c36001bm.mo8995d(a);
                a.close();
                AppMethodBeat.m2505o(80289);
                return c36001bm;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.NewTipsInfoStorage", "getByTipsId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                AppMethodBeat.m2505o(80289);
                return null;
            }
        }
        C4990ab.m7421w("MicroMsg.NewTipsInfoStorage", "getByTipsId:%d, no data", Integer.valueOf(i));
        a.close();
        AppMethodBeat.m2505o(80289);
        return null;
    }
}
