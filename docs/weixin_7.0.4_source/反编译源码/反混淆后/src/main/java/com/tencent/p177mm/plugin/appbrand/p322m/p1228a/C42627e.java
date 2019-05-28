package com.tencent.p177mm.plugin.appbrand.p322m.p1228a;

import com.tencent.p177mm.plugin.appbrand.C38492q;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.m.a.e */
public abstract class C42627e {
    public final C38492q gMN;
    private final C38438a iqa;
    private Set<Integer> iqb = new HashSet();

    /* renamed from: com.tencent.mm.plugin.appbrand.m.a.e$a */
    public interface C38438a {
        /* renamed from: d */
        void mo61135d(int i, Map<String, Object> map);
    }

    public abstract void aIV();

    public abstract int getType();

    public abstract void removeListener();

    public C42627e(C38438a c38438a, C38492q c38492q) {
        this.iqa = c38438a;
        this.gMN = c38492q;
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

    /* renamed from: D */
    public final void mo68067D(Map<String, Object> map) {
        for (Integer intValue : this.iqb) {
            this.iqa.mo61135d(intValue.intValue(), map);
        }
    }
}
