package com.tencent.mm.loader;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ%\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/loader/ImageLoader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "Lcom/tencent/mm/loader/Loader;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "url", "(Lcom/tencent/mm/loader/model/data/ILoaderData;)Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Lcom/tencent/mm/loader/model/data/ILoaderData;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "loadLocal", "libimageloader_release"})
public final class c<T extends com.tencent.mm.loader.h.a.c> extends d<T> {
    public c(d<T, Bitmap> dVar) {
        j.p(dVar, "configuration");
        super(dVar);
    }

    public final /* synthetic */ void a(Object obj, ImageView imageView, e eVar) {
        com.tencent.mm.loader.h.a.c cVar = (com.tencent.mm.loader.h.a.c) obj;
        j.p(cVar, "url");
        j.p(imageView, "view");
        j.p(eVar, "options");
        new a(new com.tencent.mm.loader.h.a.a(cVar), this.eOC).a(eVar).d(imageView);
    }

    public final /* synthetic */ b aO(Object obj) {
        com.tencent.mm.loader.h.a.c cVar = (com.tencent.mm.loader.h.a.c) obj;
        j.p(cVar, "url");
        return new a(new com.tencent.mm.loader.h.a.a(cVar), this.eOC);
    }
}
