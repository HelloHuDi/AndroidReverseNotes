package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26247tx;
import com.tencent.p177mm.p230g.p231a.C26247tx.C18403b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C7108v;
import com.tencent.p177mm.plugin.sns.storage.C13479t;
import com.tencent.p177mm.protocal.protobuf.cbz;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.p */
public final class C21936p extends C4884c<C26247tx> {
    public C21936p() {
        AppMethodBeat.m2504i(35640);
        this.xxI = C26247tx.class.getName().hashCode();
        AppMethodBeat.m2505o(35640);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        int i = 0;
        AppMethodBeat.m2504i(35641);
        C26247tx c26247tx = (C26247tx) c4883b;
        if (c26247tx instanceof C26247tx) {
            if (c26247tx.cPY.cQa instanceof C7108v) {
                C7108v c7108v = (C7108v) c26247tx.cPY.cQa;
                int i2 = c7108v.qJO;
                LinkedList linkedList = c7108v.qJN;
                c26247tx.cPZ.state = i2;
                if (i2 == 2) {
                    if (linkedList != null && linkedList.size() > 0) {
                        C13373af.cnL().mo55580kG(7);
                    }
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            cbz cbz = (cbz) it.next();
                            if (cbz.xbt == 7) {
                                C13479t c13479t = new C13479t();
                                C7108v.m11908a(c13479t, cbz);
                                C13373af.cnL().mo55576a(c13479t);
                            }
                        }
                    }
                }
                if (i2 != 1) {
                    C13479t kF = C13373af.cnL().mo55579kF(7);
                    C18403b c18403b = c26247tx.cPZ;
                    LinkedList linkedList2 = new LinkedList();
                    if (kF.field_memberList != null) {
                        String[] split = kF.field_memberList.split(",");
                        int length = split.length;
                        while (i < length) {
                            linkedList2.add(split[i]);
                            i++;
                        }
                    }
                    c18403b.cQb = linkedList2;
                }
            }
            AppMethodBeat.m2505o(35641);
            return true;
        }
        C4990ab.m7414f("MicroMsg.UpdateSnsTagListListener", "mismatched event");
        AppMethodBeat.m2505o(35641);
        return false;
    }
}
