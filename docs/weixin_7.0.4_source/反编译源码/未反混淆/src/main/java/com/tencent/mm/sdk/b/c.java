package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b> {
    final int priority;
    protected int xxI;
    private b<c> xxJ;

    public abstract boolean a(T t);

    public c() {
        this(0);
    }

    public c(int i) {
        this.xxI = 0;
        this.priority = i;
    }

    /* Access modifiers changed, original: final */
    public final int dnS() {
        if (this.xxI == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            this.xxI = ((Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).getName().hashCode();
            ab.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.xxI;
    }

    public final synchronized b<c> dnU() {
        if (this.xxJ == null) {
            ListenerInstanceMonitor.cA(this);
            this.xxJ = a.xxA.b(this);
        }
        return this.xxJ;
    }

    public final synchronized void dead() {
        if (this.xxJ != null) {
            ListenerInstanceMonitor.cB((c) this.xxJ.d);
            this.xxJ.dead();
            this.xxJ = null;
        }
    }
}
