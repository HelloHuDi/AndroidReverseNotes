package com.tencent.mm.plugin.sns.i;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Vector;

public abstract class i {
    private Vector<b> qTq = new Vector();

    public final b b(b bVar) {
        this.qTq.add(bVar);
        return bVar;
    }

    public final boolean c(b bVar) {
        boolean z;
        Iterator it = this.qTq.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.fQi == bVar.fQi) {
                this.qTq.remove(bVar2);
                z = true;
                break;
            }
        }
        z = false;
        this.qTq.add(bVar);
        return z;
    }

    public final b co(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.qTq.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (obj.equals(bVar.fQg)) {
                    this.qTq.remove(bVar);
                    return bVar;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
