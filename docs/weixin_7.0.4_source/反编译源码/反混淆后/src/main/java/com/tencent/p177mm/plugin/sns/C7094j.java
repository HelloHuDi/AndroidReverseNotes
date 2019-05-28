package com.tencent.p177mm.plugin.sns;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C37772no;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.storage.C39789o;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.j */
public final class C7094j extends C4884c<C37772no> {
    public C7094j() {
        AppMethodBeat.m2504i(35624);
        this.xxI = C37772no.class.getName().hashCode();
        AppMethodBeat.m2505o(35624);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35625);
        C37772no c37772no = (C37772no) c4883b;
        if (c37772no instanceof C37772no) {
            LinkedList linkedList = new LinkedList();
            c37772no.cJP.cJQ = null;
            c37772no.cJP.cJR = null;
            c37772no.cJP.cJS = null;
            c37772no.cJP.cJT = null;
            C4990ab.m7416i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + c37772no.cJO.username);
            if (!C5046bo.isNullOrNil(c37772no.cJO.username)) {
                boolean z;
                C1720g.m3537RQ();
                if (c37772no.cJO.username.equals((String) C1720g.m3536RP().mo5239Ry().get(2, null))) {
                    z = true;
                } else {
                    z = false;
                }
                C39789o cnF = C13373af.cnF();
                String str = c37772no.cJO.username;
                String str2 = ("select *,rowid from SnsInfo " + C39789o.m68083bm(str, z)) + " AND type in ( 1 , 15)" + C39789o.rfn + " limit 4";
                C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getUserNewerInfo ".concat(String.valueOf(str2)));
                Cursor rawQuery = cnF.bSd.rawQuery(str2, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            C46236n c46236n = new C46236n();
                            c46236n.mo8995d(rawQuery);
                            if (c46236n.field_type != 21) {
                                Iterator it = c46236n.cqu().xfI.wbK.iterator();
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
                            c37772no.cJP.cJQ = (bau) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            c37772no.cJP.cJR = (bau) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            c37772no.cJP.cJS = (bau) linkedList.get(2);
                        }
                        if (linkedList.size() > 3) {
                            c37772no.cJP.cJT = (bau) linkedList.get(3);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            AppMethodBeat.m2505o(35625);
            return true;
        }
        C4990ab.m7414f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        AppMethodBeat.m2505o(35625);
        return false;
    }
}
