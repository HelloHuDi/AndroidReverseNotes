package com.tencent.mm.plugin.offline;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T> {
    protected List<WeakReference<T>> oWP = new ArrayList();

    public final void cl(T t) {
        if (this.oWP != null) {
            this.oWP = new ArrayList();
        }
        this.oWP.add(new WeakReference(t));
    }

    public final void cm(T t) {
        if (this.oWP != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.oWP.size()) {
                    WeakReference weakReference = (WeakReference) this.oWP.get(i2);
                    if (weakReference != null) {
                        Object obj = weakReference.get();
                        if (obj != null && obj.equals(t)) {
                            weakReference.clear();
                            this.oWP.remove(weakReference);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
