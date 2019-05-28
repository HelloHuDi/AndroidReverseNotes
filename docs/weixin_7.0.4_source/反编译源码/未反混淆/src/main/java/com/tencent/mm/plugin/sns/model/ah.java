package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah implements g {
    HashMap<String, l> ckP = new HashMap();

    public ah() {
        AppMethodBeat.i(36529);
        AppMethodBeat.o(36529);
    }

    public final l XW(String str) {
        AppMethodBeat.i(36530);
        l lVar = (l) this.ckP.get(str);
        AppMethodBeat.o(36530);
        return lVar;
    }

    public final boolean cnU() {
        AppMethodBeat.i(36531);
        af.cno().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36526);
                if (ah.this.ckP.size() > 50) {
                    ah.a(ah.this, 10);
                }
                AppMethodBeat.o(36526);
            }
        });
        AppMethodBeat.o(36531);
        return true;
    }

    public final boolean cnV() {
        AppMethodBeat.i(36532);
        af.cno().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36527);
                ah.a(ah.this, ah.this.ckP.size());
                AppMethodBeat.o(36527);
            }
        });
        AppMethodBeat.o(36532);
        return true;
    }

    public final boolean a(final l lVar) {
        AppMethodBeat.i(36533);
        if (lVar == null || bo.isNullOrNil(lVar.field_userName)) {
            AppMethodBeat.o(36533);
            return false;
        }
        af.cno().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(36528);
                ah.this.ckP.put(lVar.field_userName, lVar);
                AppMethodBeat.o(36528);
            }
        });
        AppMethodBeat.o(36533);
        return true;
    }

    static /* synthetic */ void a(ah ahVar, int i) {
        AppMethodBeat.i(36534);
        if (ahVar.ckP == null || ahVar.ckP.size() == 0) {
            ab.i("MicroMsg.SnsExtCache", "nothing need to pushto snsext");
            AppMethodBeat.o(36534);
            return;
        }
        long iV;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = null;
        if (af.Ru() != null) {
            obj = 1;
            iV = af.Ru().iV(Thread.currentThread().getId());
        } else {
            iV = 0;
        }
        ab.d("MicroMsg.SnsExtCache", "writeNums " + i + " " + iV);
        LinkedList linkedList = new LinkedList();
        for (String str2 : ahVar.ckP.keySet()) {
            linkedList.add(str2);
            if (linkedList.size() >= i) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (ahVar.ckP.containsKey(str2) && !af.cnn()) {
                af.cnJ().b((l) ahVar.ckP.get(str2));
                ahVar.ckP.remove(str2);
            }
        }
        if (obj != null) {
            af.Ru().mB(iV);
        }
        ab.d("MicroMsg.SnsExtCache", "wirtes times : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(36534);
    }
}
