package com.tencent.mm.plugin.appbrand.b;

abstract class h extends com.tencent.mm.plugin.appbrand.report.h {
    private final i gXa;

    h(i iVar) {
        this.gXa = iVar;
    }

    public void enter() {
        super.enter();
        this.gXa.a(this);
    }
}
