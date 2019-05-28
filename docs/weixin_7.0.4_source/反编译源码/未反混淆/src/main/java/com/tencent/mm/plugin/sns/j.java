package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.no;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends c<no> {
    public j() {
        AppMethodBeat.i(35624);
        this.xxI = no.class.getName().hashCode();
        AppMethodBeat.o(35624);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35625);
        no noVar = (no) bVar;
        if (noVar instanceof no) {
            LinkedList linkedList = new LinkedList();
            noVar.cJP.cJQ = null;
            noVar.cJP.cJR = null;
            noVar.cJP.cJS = null;
            noVar.cJP.cJT = null;
            ab.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + noVar.cJO.username);
            if (!bo.isNullOrNil(noVar.cJO.username)) {
                boolean z;
                g.RQ();
                if (noVar.cJO.username.equals((String) g.RP().Ry().get(2, null))) {
                    z = true;
                } else {
                    z = false;
                }
                o cnF = af.cnF();
                String str = noVar.cJO.username;
                String str2 = ("select *,rowid from SnsInfo " + o.bm(str, z)) + " AND type in ( 1 , 15)" + o.rfn + " limit 4";
                ab.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo ".concat(String.valueOf(str2)));
                Cursor rawQuery = cnF.bSd.rawQuery(str2, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            n nVar = new n();
                            nVar.d(rawQuery);
                            if (nVar.field_type != 21) {
                                Iterator it = nVar.cqu().xfI.wbK.iterator();
                                while (it.hasNext()) {
                                    bau bau = (bau) it.next();
                                    if (bau.jCt == 2 || bau.jCt == 6) {
                                        i++;
                                        linkedList.add(bau);
                                        if (i >= 4) {
                                            break;
                                        }
                                    }
                                    i = i;
                                }
                            }
                        } while (rawQuery.moveToNext());
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            noVar.cJP.cJQ = (bau) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            noVar.cJP.cJR = (bau) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            noVar.cJP.cJS = (bau) linkedList.get(2);
                        }
                        if (linkedList.size() > 3) {
                            noVar.cJP.cJT = (bau) linkedList.get(3);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            AppMethodBeat.o(35625);
            return true;
        }
        ab.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        AppMethodBeat.o(35625);
        return false;
    }
}
