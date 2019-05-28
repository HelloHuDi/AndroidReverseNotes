package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.plugin.sns.storage.C43572g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.model.ah */
public final class C39750ah implements C43572g {
    HashMap<String, C29097l> ckP = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.model.ah$1 */
    class C134071 implements Runnable {
        C134071() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36526);
            if (C39750ah.this.ckP.size() > 50) {
                C39750ah.m67987a(C39750ah.this, 10);
            }
            AppMethodBeat.m2505o(36526);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.ah$2 */
    class C397512 implements Runnable {
        C397512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36527);
            C39750ah.m67987a(C39750ah.this, C39750ah.this.ckP.size());
            AppMethodBeat.m2505o(36527);
        }
    }

    public C39750ah() {
        AppMethodBeat.m2504i(36529);
        AppMethodBeat.m2505o(36529);
    }

    /* renamed from: XW */
    public final C29097l mo62844XW(String str) {
        AppMethodBeat.m2504i(36530);
        C29097l c29097l = (C29097l) this.ckP.get(str);
        AppMethodBeat.m2505o(36530);
        return c29097l;
    }

    public final boolean cnU() {
        AppMethodBeat.m2504i(36531);
        C13373af.cno().post(new C134071());
        AppMethodBeat.m2505o(36531);
        return true;
    }

    public final boolean cnV() {
        AppMethodBeat.m2504i(36532);
        C13373af.cno().post(new C397512());
        AppMethodBeat.m2505o(36532);
        return true;
    }

    /* renamed from: a */
    public final boolean mo62845a(final C29097l c29097l) {
        AppMethodBeat.m2504i(36533);
        if (c29097l == null || C5046bo.isNullOrNil(c29097l.field_userName)) {
            AppMethodBeat.m2505o(36533);
            return false;
        }
        C13373af.cno().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(36528);
                C39750ah.this.ckP.put(c29097l.field_userName, c29097l);
                AppMethodBeat.m2505o(36528);
            }
        });
        AppMethodBeat.m2505o(36533);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m67987a(C39750ah c39750ah, int i) {
        AppMethodBeat.m2504i(36534);
        if (c39750ah.ckP == null || c39750ah.ckP.size() == 0) {
            C4990ab.m7416i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            AppMethodBeat.m2505o(36534);
            return;
        }
        long iV;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        if (C13373af.m21489Ru() != null) {
            obj = 1;
            iV = C13373af.m21489Ru().mo15639iV(Thread.currentThread().getId());
        } else {
            iV = 0;
        }
        C4990ab.m7410d("MicroMsg.SnsExtCache", "writeNums " + i + " " + iV);
        LinkedList linkedList = new LinkedList();
        for (String str2 : c39750ah.ckP.keySet()) {
            linkedList.add(str2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (c39750ah.ckP.containsKey(str2) && !C13373af.cnn()) {
                C13373af.cnJ().mo69181b((C29097l) c39750ah.ckP.get(str2));
                c39750ah.ckP.remove(str2);
            }
        }
        if (obj != null) {
            C13373af.m21489Ru().mo15640mB(iV);
        }
        C4990ab.m7410d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(36534);
    }
}
