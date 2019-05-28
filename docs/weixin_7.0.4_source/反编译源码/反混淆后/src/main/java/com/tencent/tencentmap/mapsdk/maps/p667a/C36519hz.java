package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.tencentmap.mapsdk.p666a.C24341cx;
import com.tencent.tencentmap.mapsdk.p666a.C30993az;
import com.tencent.tencentmap.mapsdk.p666a.C31000cw;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hz */
public abstract class C36519hz extends C30993az implements C24390io {
    /* renamed from: a */
    private static AtomicInteger f15387a = new AtomicInteger(1);
    /* renamed from: I */
    protected boolean f15388I = false;
    /* renamed from: J */
    protected C24341cx f15389J;
    /* renamed from: b */
    private final String f15390b = String.valueOf(f15387a.incrementAndGet());

    /* renamed from: d */
    public abstract void mo29450d();

    /* renamed from: z */
    public void mo29507z() {
    }

    /* renamed from: r */
    public boolean mo57761r() {
        return false;
    }

    /* renamed from: A */
    public final String mo57757A() {
        return this.f15390b;
    }

    /* renamed from: B */
    public C24341cx mo57758B() {
        return this.f15389J;
    }

    /* renamed from: a */
    public void mo57760a(C31000cw c31000cw) {
        if (this.f15389J != null) {
            this.f15388I = this.f15389J.toString().equals(c31000cw.toString());
        }
        mo29449c();
    }

    /* renamed from: C */
    public void mo57759C() {
        if (this.f15389J != null) {
            this.f15388I = false;
        }
        mo29449c();
    }

    /* renamed from: y */
    public boolean mo57762y() {
        return false;
    }
}
