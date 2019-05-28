package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hi */
public class C44520hi<E> {
    /* renamed from: a */
    private int f17431a;
    /* renamed from: b */
    private volatile Object[] f17432b;
    /* renamed from: c */
    private volatile int f17433c = 0;
    /* renamed from: d */
    private volatile int f17434d = 0;

    public C44520hi(int i) {
        AppMethodBeat.m2504i(99539);
        this.f17431a = i;
        this.f17432b = new Object[i];
        AppMethodBeat.m2505o(99539);
    }

    /* renamed from: e */
    private void m80780e() {
        this.f17434d = 0;
        this.f17433c = 0;
    }

    /* renamed from: a */
    public boolean mo70901a(E e) {
        AppMethodBeat.m2504i(99540);
        if (mo70903c()) {
            AppMethodBeat.m2505o(99540);
            return false;
        }
        this.f17434d %= this.f17431a;
        Object[] objArr = this.f17432b;
        int i = this.f17434d;
        this.f17434d = i + 1;
        objArr[i] = e;
        AppMethodBeat.m2505o(99540);
        return true;
    }

    /* renamed from: a */
    public E mo70900a() {
        AppMethodBeat.m2504i(99541);
        if (mo70904d()) {
            AppMethodBeat.m2505o(99541);
            return null;
        }
        this.f17433c %= this.f17431a;
        E e = this.f17432b[this.f17433c];
        this.f17432b[this.f17433c] = null;
        this.f17433c++;
        AppMethodBeat.m2505o(99541);
        return e;
    }

    /* renamed from: b */
    public void mo70902b() {
        AppMethodBeat.m2504i(99542);
        m80780e();
        for (int i = 0; i < this.f17432b.length; i++) {
            this.f17432b[i] = null;
        }
        AppMethodBeat.m2505o(99542);
    }

    /* renamed from: c */
    public boolean mo70903c() {
        return (this.f17434d + 1) % this.f17431a == this.f17433c;
    }

    /* renamed from: d */
    public boolean mo70904d() {
        return this.f17434d == this.f17433c;
    }
}
