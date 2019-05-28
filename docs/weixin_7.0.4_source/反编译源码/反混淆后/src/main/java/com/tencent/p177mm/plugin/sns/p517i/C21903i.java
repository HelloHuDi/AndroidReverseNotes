package com.tencent.p177mm.plugin.sns.p517i;

import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.sns.i.i */
public abstract class C21903i {
    private Vector<C37952b> qTq = new Vector();

    /* renamed from: b */
    public final C37952b mo37378b(C37952b c37952b) {
        this.qTq.add(c37952b);
        return c37952b;
    }

    /* renamed from: c */
    public final boolean mo37379c(C37952b c37952b) {
        boolean z;
        Iterator it = this.qTq.iterator();
        while (it.hasNext()) {
            C37952b c37952b2 = (C37952b) it.next();
            if (c37952b2.fQi == c37952b.fQi) {
                this.qTq.remove(c37952b2);
                z = true;
                break;
            }
        }
        z = false;
        this.qTq.add(c37952b);
        return z;
    }

    /* renamed from: co */
    public final C37952b mo37380co(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.qTq.iterator();
            while (it.hasNext()) {
                C37952b c37952b = (C37952b) it.next();
                if (obj.equals(c37952b.fQg)) {
                    this.qTq.remove(c37952b);
                    return c37952b;
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
