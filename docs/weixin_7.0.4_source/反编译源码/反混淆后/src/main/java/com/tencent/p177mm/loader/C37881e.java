package com.tencent.p177mm.loader;

import android.graphics.Bitmap;
import com.tencent.p177mm.loader.p1197h.p1198a.C18544c;
import com.tencent.p177mm.loader.p861c.C42153d;
import com.tencent.p177mm.loader.p861c.C44688c;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/loader/LoaderFactory;", "", "()V", "instance", "Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.e */
public final class C37881e {
    public static final C37881e eOD = new C37881e();

    private C37881e() {
    }

    /* renamed from: a */
    public static <T extends C18544c> C18532d<T> m63943a(C42153d<T, Bitmap> c42153d) {
        C25052j.m39376p(c42153d, "configuration");
        return new C26355c(c42153d);
    }

    /* renamed from: Tb */
    public static C24669a m63942Tb() {
        return new C24669a(new C44688c());
    }
}
