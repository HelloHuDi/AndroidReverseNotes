package com.tencent.p177mm.sdk.p600b;

import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.p177mm.vending.p636b.C7358b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.tencent.mm.sdk.b.c */
public abstract class C4884c<T extends C4883b> {
    final int priority;
    protected int xxI;
    private C7358b<C4884c> xxJ;

    /* renamed from: a */
    public abstract boolean mo4653a(T t);

    public C4884c() {
        this(0);
    }

    public C4884c(int i) {
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
            C4990ab.m7419v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.xxI;
    }

    public final synchronized C7358b<C4884c> dnU() {
        if (this.xxJ == null) {
            ListenerInstanceMonitor.m7382cA(this);
            this.xxJ = C4879a.xxA.mo10051b(this);
        }
        return this.xxJ;
    }

    public final synchronized void dead() {
        if (this.xxJ != null) {
            ListenerInstanceMonitor.m7383cB((C4884c) this.xxJ.f2002d);
            this.xxJ.dead();
            this.xxJ = null;
        }
    }
}
