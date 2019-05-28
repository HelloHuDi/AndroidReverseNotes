package com.tencent.p177mm.p182ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ah.i */
public final class C17881i extends C7296k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    C7480h fni;
    final C1177f<String, C17880h> frZ = new C7598c(800);

    public C17881i(C7480h c7480h) {
        AppMethodBeat.m2504i(77923);
        this.fni = c7480h;
        AppMethodBeat.m2505o(77923);
    }

    /* renamed from: qo */
    public final C17880h mo33392qo(String str) {
        AppMethodBeat.m2504i(77924);
        C17880h c17880h = (C17880h) this.frZ.mo4404ai(str);
        if (c17880h == null || !c17880h.getUsername().equals(str)) {
            Cursor a = this.fni.mo10104a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + C5046bo.m7586vA(str) + "\"", null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(77924);
                return null;
            }
            if (a.moveToFirst()) {
                c17880h = new C17880h();
                c17880h.mo33386d(a);
            } else {
                c17880h = null;
            }
            a.close();
            this.frZ.mo4412k(str, c17880h);
            AppMethodBeat.m2505o(77924);
            return c17880h;
        }
        AppMethodBeat.m2505o(77924);
        return c17880h;
    }

    /* renamed from: b */
    public final boolean mo33391b(C17880h c17880h) {
        AppMethodBeat.m2504i(77925);
        C4990ab.m7417i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", c17880h.acl(), c17880h.ack());
        boolean c;
        if (mo33392qo(c17880h.getUsername()) == null) {
            this.frZ.mo4412k(c17880h.getUsername(), c17880h);
            c = m28047c(c17880h);
            AppMethodBeat.m2505o(77925);
            return c;
        }
        C4990ab.m7417i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", mo33392qo(c17880h.getUsername()).acl(), mo33392qo(c17880h.getUsername()).ack());
        this.frZ.remove(c17880h.getUsername());
        c = m28048d(c17880h);
        AppMethodBeat.m2505o(77925);
        return c;
    }

    /* renamed from: aa */
    public final boolean mo33390aa(List<C17880h> list) {
        AppMethodBeat.m2504i(77926);
        if (list.size() == 0) {
            AppMethodBeat.m2505o(77926);
            return false;
        }
        boolean z;
        long iV = this.fni.mo15639iV(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                mo33391b((C17880h) list.get(i));
                i++;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.fni.mo15640mB(iV);
        AppMethodBeat.m2505o(77926);
        return z;
    }

    /* renamed from: c */
    private boolean m28047c(C17880h c17880h) {
        boolean z = true;
        AppMethodBeat.m2504i(77927);
        boolean z2 = (c17880h == null || c17880h.getUsername() == null) ? false : true;
        Assert.assertTrue(z2);
        c17880h.frU = (int) (System.currentTimeMillis() / 1000);
        c17880h.acm();
        c17880h.bJt = -1;
        if (((int) this.fni.insert("img_flag", "username", c17880h.acj())) < 0) {
            z = false;
        }
        if (z) {
            mo15641b(c17880h.getUsername(), 2, c17880h.getUsername());
        }
        AppMethodBeat.m2505o(77927);
        return z;
    }

    /* renamed from: d */
    private boolean m28048d(C17880h c17880h) {
        boolean z = true;
        AppMethodBeat.m2504i(77928);
        boolean z2 = (c17880h == null || c17880h.getUsername() == null) ? false : true;
        Assert.assertTrue(z2);
        c17880h.frU = (int) (System.currentTimeMillis() / 1000);
        c17880h.bJt |= 4;
        if (this.fni.update("img_flag", c17880h.acj(), "username=?", new String[]{c17880h.getUsername()}) <= 0) {
            z = false;
        }
        if (z) {
            mo15641b(c17880h.getUsername(), 3, c17880h.getUsername());
        }
        AppMethodBeat.m2505o(77928);
        return z;
    }

    /* renamed from: qp */
    public final void mo33393qp(String str) {
        AppMethodBeat.m2504i(77929);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(77929);
            return;
        }
        this.frZ.remove(str);
        this.fni.delete("img_flag", "username=?", new String[]{String.valueOf(str)});
        AppMethodBeat.m2505o(77929);
    }
}
