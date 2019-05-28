package com.tencent.mm.plugin.appbrand.m.a;

import com.tencent.mm.plugin.appbrand.q;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class e {
    public final q gMN;
    private final a iqa;
    private Set<Integer> iqb = new HashSet();

    public interface a {
        void d(int i, Map<String, Object> map);
    }

    public abstract void aIV();

    public abstract int getType();

    public abstract void removeListener();

    public e(a aVar, q qVar) {
        this.iqa = aVar;
        this.gMN = qVar;
    }

    public final void listen(int i) {
        Object obj;
        synchronized (this) {
            obj = !this.iqb.isEmpty() ? 1 : null;
            this.iqb.add(Integer.valueOf(i));
        }
        if (obj == null) {
            aIV();
        }
    }

    public final void unListen(int i) {
        synchronized (this) {
            if (this.iqb.contains(Integer.valueOf(i))) {
                this.iqb.remove(Integer.valueOf(i));
            }
            if (this.iqb.isEmpty()) {
                removeListener();
                return;
            }
        }
    }

    public final void D(Map<String, Object> map) {
        for (Integer intValue : this.iqb) {
            this.iqa.d(intValue.intValue(), map);
        }
    }
}
