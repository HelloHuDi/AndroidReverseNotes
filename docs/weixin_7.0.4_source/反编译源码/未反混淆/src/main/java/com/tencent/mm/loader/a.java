package com.tencent.mm.loader;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0010\u001a\u00020\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001a\u001a\u00020\u0002¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loadAssert", "assertPath", "loadDrawable", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"})
public final class a extends d<String> {
    public a(d<String, Bitmap> dVar) {
        j.p(dVar, "configuration");
        super(dVar);
    }

    public final /* synthetic */ void a(Object obj, ImageView imageView, e eVar) {
        String str = (String) obj;
        j.p(str, "url");
        j.p(imageView, "view");
        j.p(eVar, "options");
        new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str), this.eOC).a(eVar).d(imageView);
    }

    public final /* synthetic */ b aO(Object obj) {
        String str = (String) obj;
        j.p(str, "url");
        return new com.tencent.mm.loader.a.a(new com.tencent.mm.loader.h.a.a(str), this.eOC);
    }

    public final b<String, Bitmap> lR(String str) {
        j.p(str, "filePath");
        com.tencent.mm.loader.h.a.a a = com.tencent.mm.loader.h.a.a.a(str, com.tencent.mm.loader.h.a.b.LOCAL_PATH);
        j.o(a, "DataItem.create(filePath, DataType.LOCAL_PATH)");
        return new com.tencent.mm.loader.a.a(a, this.eOC);
    }
}
