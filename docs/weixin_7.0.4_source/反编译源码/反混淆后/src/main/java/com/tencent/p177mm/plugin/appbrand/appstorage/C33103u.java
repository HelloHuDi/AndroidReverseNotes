package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p.C19093a;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.u */
public final class C33103u extends C42366k implements C19093a {
    public final String gYf;

    public C33103u(String str) {
        this.gYf = str;
    }

    public final String getFileName() {
        return this.gYf;
    }

    public final long awL() {
        return this.st_size;
    }

    public final long lastModified() {
        return this.st_mtime;
    }
}
