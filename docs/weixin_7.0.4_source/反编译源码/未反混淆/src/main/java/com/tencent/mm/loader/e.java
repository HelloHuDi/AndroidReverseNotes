package com.tencent.mm.loader;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.h.a.c;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/loader/LoaderFactory;", "", "()V", "instance", "Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "libimageloader_release"})
public final class e {
    public static final e eOD = new e();

    private e() {
    }

    public static <T extends c> d<T> a(d<T, Bitmap> dVar) {
        j.p(dVar, "configuration");
        return new c(dVar);
    }

    public static a Tb() {
        return new a(new com.tencent.mm.loader.c.c());
    }
}
