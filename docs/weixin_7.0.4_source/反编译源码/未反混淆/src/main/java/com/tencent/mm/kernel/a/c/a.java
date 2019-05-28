package com.tencent.mm.kernel.a.c;

import com.tencent.mm.kernel.h;

public abstract class a implements b {
    public <T extends a> T after(com.tencent.mm.kernel.b.a aVar) {
        h.RT().RM().Rn().eJE.eKM.a(b.class, this, aVar);
        return this;
    }

    public <T extends a> T before(com.tencent.mm.kernel.b.a aVar) {
        h.RT().RM().Rn().eJE.eKM.a(b.class, aVar, this);
        return this;
    }

    public void alone() {
        h.RT().RM().Rn().eJE.eKM.a(b.class, this, this);
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
