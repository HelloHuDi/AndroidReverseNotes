package com.tencent.p177mm.plugin.appbrand.appcache.p881a;

import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35792l;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.a */
public abstract class C10065a extends C35792l {
    public final String appId;
    public final int cBc;
    public volatile boolean gVz = true;
    public final int version;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.a.a$a */
    public interface C10066a {
        String avJ();
    }

    public C10065a(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, String.valueOf(i), "AppBrandWxaPkgDownloader", str3, "GET", 1, 2, 0);
        this.appId = str4;
        this.version = i;
        this.cBc = i2;
        setConnectTimeout((int) TimeUnit.SECONDS.toMillis(15));
        setReadTimeout((int) TimeUnit.SECONDS.toMillis(30));
    }

    public String toShortString() {
        return getClass().getSimpleName() + String.format(Locale.US, "[%s|%d|%d]", new Object[]{this.appId, Integer.valueOf(this.version), Integer.valueOf(this.cBc)});
    }
}
