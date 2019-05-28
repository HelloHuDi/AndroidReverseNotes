package com.tencent.mm.vending.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class c<_Target extends a> implements a, b<_Target> {
    private List<WeakReference<_Target>> a = new ArrayList();
    private boolean b = true;

    public c() {
        AppMethodBeat.i(126111);
        AppMethodBeat.o(126111);
    }

    public final synchronized void keep(_Target _target) {
        AppMethodBeat.i(126112);
        if (this.b) {
            this.a.add(new WeakReference(_target));
            AppMethodBeat.o(126112);
        } else {
            Assert.assertNotNull(_target);
            _target.dead();
            AppMethodBeat.o(126112);
        }
    }

    public final synchronized void dead() {
        AppMethodBeat.i(126113);
        if (this.b) {
            for (WeakReference weakReference : this.a) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.dead();
                }
            }
            this.a.clear();
            this.b = false;
            AppMethodBeat.o(126113);
        } else {
            AppMethodBeat.o(126113);
        }
    }
}
