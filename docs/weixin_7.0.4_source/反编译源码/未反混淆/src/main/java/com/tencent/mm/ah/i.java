package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cd.h;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import junit.framework.Assert;

public final class i extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    h fni;
    final f<String, h> frZ = new c(800);

    public i(h hVar) {
        AppMethodBeat.i(77923);
        this.fni = hVar;
        AppMethodBeat.o(77923);
    }

    public final h qo(String str) {
        AppMethodBeat.i(77924);
        h hVar = (h) this.frZ.ai(str);
        if (hVar == null || !hVar.getUsername().equals(str)) {
            Cursor a = this.fni.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bo.vA(str) + "\"", null, 2);
            if (a == null) {
                AppMethodBeat.o(77924);
                return null;
            }
            if (a.moveToFirst()) {
                hVar = new h();
                hVar.d(a);
            } else {
                hVar = null;
            }
            a.close();
            this.frZ.k(str, hVar);
            AppMethodBeat.o(77924);
            return hVar;
        }
        AppMethodBeat.o(77924);
        return hVar;
    }

    public final boolean b(h hVar) {
        AppMethodBeat.i(77925);
        ab.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", hVar.acl(), hVar.ack());
        boolean c;
        if (qo(hVar.getUsername()) == null) {
            this.frZ.k(hVar.getUsername(), hVar);
            c = c(hVar);
            AppMethodBeat.o(77925);
            return c;
        }
        ab.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", qo(hVar.getUsername()).acl(), qo(hVar.getUsername()).ack());
        this.frZ.remove(hVar.getUsername());
        c = d(hVar);
        AppMethodBeat.o(77925);
        return c;
    }

    public final boolean aa(List<h> list) {
        AppMethodBeat.i(77926);
        if (list.size() == 0) {
            AppMethodBeat.o(77926);
            return false;
        }
        boolean z;
        long iV = this.fni.iV(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                b((h) list.get(i));
                i++;
            } catch (Exception e) {
                ab.e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.fni.mB(iV);
        AppMethodBeat.o(77926);
        return z;
    }

    private boolean c(h hVar) {
        boolean z = true;
        AppMethodBeat.i(77927);
        boolean z2 = (hVar == null || hVar.getUsername() == null) ? false : true;
        Assert.assertTrue(z2);
        hVar.frU = (int) (System.currentTimeMillis() / 1000);
        hVar.acm();
        hVar.bJt = -1;
        if (((int) this.fni.insert("img_flag", "username", hVar.acj())) < 0) {
            z = false;
        }
        if (z) {
            b(hVar.getUsername(), 2, hVar.getUsername());
        }
        AppMethodBeat.o(77927);
        return z;
    }

    private boolean d(h hVar) {
        boolean z = true;
        AppMethodBeat.i(77928);
        boolean z2 = (hVar == null || hVar.getUsername() == null) ? false : true;
        Assert.assertTrue(z2);
        hVar.frU = (int) (System.currentTimeMillis() / 1000);
        hVar.bJt |= 4;
        if (this.fni.update("img_flag", hVar.acj(), "username=?", new String[]{hVar.getUsername()}) <= 0) {
            z = false;
        }
        if (z) {
            b(hVar.getUsername(), 3, hVar.getUsername());
        }
        AppMethodBeat.o(77928);
        return z;
    }

    public final void qp(String str) {
        AppMethodBeat.i(77929);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(77929);
            return;
        }
        this.frZ.remove(str);
        this.fni.delete("img_flag", "username=?", new String[]{String.valueOf(str)});
        AppMethodBeat.o(77929);
    }
}
