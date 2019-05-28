package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a.e;
import com.tencent.mm.cd.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.e.d;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.OpenIMAddressUI.OpenIMAddressUIFragment;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class t extends a {
    private HashSet<String> zod = new HashSet();
    private String zoe;
    OpenIMAddressUIFragment zof;

    public t(Context context, String str, String str2) {
        super(context, str, null, 2);
        AppMethodBeat.i(33801);
        this.zoe = str2;
        AppMethodBeat.o(33801);
    }

    /* Access modifiers changed, original: protected|final */
    public final Cursor dHv() {
        AppMethodBeat.i(33802);
        long currentTimeMillis = System.currentTimeMillis();
        g.RQ();
        d appIdInfoStg = ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg();
        String str = this.zoe;
        List linkedList = new LinkedList();
        Cursor a = appIdInfoStg.fni.a("select distinct appid from OpenIMAppIdInfo where acctTypeId=? ", new String[]{str}, 2);
        if (a.moveToFirst()) {
            do {
                str = a.getString(0);
                if (!bo.isNullOrNil(str)) {
                    linkedList.add(str);
                }
            } while (a.moveToNext());
        }
        a.close();
        aw.ZK();
        Cursor a2 = c.XM().a(this.elZ, aa.gw(ah.getContext()), linkedList);
        if (a2 instanceof f) {
            a2 = new e(new com.tencent.mm.cd.a.d[]{(com.tencent.mm.cd.a.d) com.tencent.mm.cd.d.dvo(), (f) a2});
        }
        ab.d("OpenIMContactAdapter", "createNewCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(33802);
        return a2;
    }

    /* Access modifiers changed, original: protected|final */
    public final int a(com.tencent.mm.storage.f fVar, int i) {
        AppMethodBeat.i(33803);
        if (fVar == null) {
            ab.e("OpenIMContactAdapter", "contact is null, position:%d", Integer.valueOf(i));
            AppMethodBeat.o(33803);
            return -1;
        } else if (bo.isNullOrNil(fVar.field_descWording)) {
            AppMethodBeat.o(33803);
            return -1;
        } else {
            int hashCode = fVar.field_descWording.hashCode();
            AppMethodBeat.o(33803);
            return hashCode;
        }
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(33806);
        if (obj == null || !(obj instanceof String)) {
            ab.d("OpenIMContactAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(33806);
            return;
        }
        aw.ZK();
        if (nVar == c.XM()) {
            if (ad.aox((String) obj)) {
                this.zof.zks = true;
                AppMethodBeat.o(33806);
                return;
            }
            ab.d("OpenIMContactAdapter", "newcursor is not openim ，return");
        }
        AppMethodBeat.o(33806);
    }

    /* Access modifiers changed, original: protected|final */
    public final String b(com.tencent.mm.storage.f fVar, int i) {
        AppMethodBeat.i(33804);
        String str = fVar.field_descWording;
        if (bo.isNullOrNil(str)) {
            str = "#";
            AppMethodBeat.o(33804);
            return str;
        }
        AppMethodBeat.o(33804);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.mm.storage.f fVar, b bVar) {
        AppMethodBeat.i(33805);
        String str = fVar.field_descWordingId;
        if (this.zod.contains(str)) {
            AppMethodBeat.o(33805);
            return;
        }
        this.zod.add(str);
        ((b) g.K(b.class)).ba(fVar.field_openImAppid, str);
        AppMethodBeat.o(33805);
    }
}
