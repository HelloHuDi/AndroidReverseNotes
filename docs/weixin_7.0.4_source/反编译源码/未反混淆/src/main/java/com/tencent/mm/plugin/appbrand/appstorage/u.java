package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.p.a;

public final class u extends k implements a {
    public final String gYf;

    public u(String str) {
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
