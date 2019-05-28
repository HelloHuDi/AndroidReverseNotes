package com.tencent.p177mm.kernel.p238a.p715c;

import com.tencent.p177mm.kernel.C1728h;
import com.tencent.p177mm.kernel.p241b.C1677a;

/* renamed from: com.tencent.mm.kernel.a.c.a */
public abstract class C42148a implements C6609b {
    public <T extends C42148a> T after(C1677a c1677a) {
        C1728h.m3566RT().mo5266RM().mo5224Rn().eJE.eKM.mo5122a(C6609b.class, this, c1677a);
        return this;
    }

    public <T extends C42148a> T before(C1677a c1677a) {
        C1728h.m3566RT().mo5266RM().mo5224Rn().eJE.eKM.mo5122a(C6609b.class, c1677a, this);
        return this;
    }

    public void alone() {
        C1728h.m3566RT().mo5266RM().mo5224Rn().eJE.eKM.mo5122a(C6609b.class, this, this);
    }

    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public int hashCode() {
        return name().hashCode();
    }
}
