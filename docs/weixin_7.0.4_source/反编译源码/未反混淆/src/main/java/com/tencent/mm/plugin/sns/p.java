package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends c<tx> {
    public p() {
        AppMethodBeat.i(35640);
        this.xxI = tx.class.getName().hashCode();
        AppMethodBeat.o(35640);
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        AppMethodBeat.i(35641);
        tx txVar = (tx) bVar;
        if (txVar instanceof tx) {
            if (txVar.cPY.cQa instanceof v) {
                v vVar = (v) txVar.cPY.cQa;
                int i2 = vVar.qJO;
                LinkedList linkedList = vVar.qJN;
                txVar.cPZ.state = i2;
                if (i2 == 2) {
                    if (linkedList != null && linkedList.size() > 0) {
                        af.cnL().kG(7);
                    }
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            cbz cbz = (cbz) it.next();
                            if (cbz.xbt == 7) {
                                t tVar = new t();
                                v.a(tVar, cbz);
                                af.cnL().a(tVar);
                            }
                        }
                    }
                }
                if (i2 != 1) {
                    t kF = af.cnL().kF(7);
                    tx.b bVar2 = txVar.cPZ;
                    LinkedList linkedList2 = new LinkedList();
                    if (kF.field_memberList != null) {
                        String[] split = kF.field_memberList.split(",");
                        int length = split.length;
                        while (i < length) {
                            linkedList2.add(split[i]);
                            i++;
                        }
                    }
                    bVar2.cQb = linkedList2;
                }
            }
            AppMethodBeat.o(35641);
            return true;
        }
        ab.f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
        AppMethodBeat.o(35641);
        return false;
    }
}
