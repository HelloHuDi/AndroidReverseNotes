package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.b;

public abstract class a<_Struct> extends Vending<_Struct, Class<?>, Void> {

    public interface a extends b {
    }

    /* renamed from: aH */
    public abstract _Struct resolveAsynchronous(Class<?> cls);

    /* Access modifiers changed, original: protected|bridge|synthetic */
    public /* bridge */ /* synthetic */ void applyChangeSynchronized(Object obj) {
    }

    /* Access modifiers changed, original: protected|bridge|synthetic */
    public /* bridge */ /* synthetic */ Object prepareVendingDataAsynchronous() {
        return null;
    }

    public void notifyVendingDataChange() {
    }

    public void notifyVendingDataChangeSynchronize() {
    }

    /* Access modifiers changed, original: protected */
    public void destroyAsynchronous() {
    }
}
