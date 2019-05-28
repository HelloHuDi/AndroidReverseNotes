package com.tencent.p177mm.vending.p639e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.vending.e.c */
public final class C7359c<_Target extends C5684a> implements C5684a, C5685b<_Target> {
    /* renamed from: a */
    private List<WeakReference<_Target>> f2004a = new ArrayList();
    /* renamed from: b */
    private boolean f2005b = true;

    public C7359c() {
        AppMethodBeat.m2504i(126111);
        AppMethodBeat.m2505o(126111);
    }

    public final synchronized void keep(_Target _target) {
        AppMethodBeat.m2504i(126112);
        if (this.f2005b) {
            this.f2004a.add(new WeakReference(_target));
            AppMethodBeat.m2505o(126112);
        } else {
            Assert.assertNotNull(_target);
            _target.dead();
            AppMethodBeat.m2505o(126112);
        }
    }

    public final synchronized void dead() {
        AppMethodBeat.m2504i(126113);
        if (this.f2005b) {
            for (WeakReference weakReference : this.f2004a) {
                C5684a c5684a = (C5684a) weakReference.get();
                if (c5684a != null) {
                    c5684a.dead();
                }
            }
            this.f2004a.clear();
            this.f2005b = false;
            AppMethodBeat.m2505o(126113);
        } else {
            AppMethodBeat.m2505o(126113);
        }
    }
}
