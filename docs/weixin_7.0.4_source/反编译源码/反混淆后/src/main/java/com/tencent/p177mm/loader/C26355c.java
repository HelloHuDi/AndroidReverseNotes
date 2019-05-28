package com.tencent.p177mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.p177mm.loader.p1197h.p1198a.C18544c;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p244a.C42151b;
import com.tencent.p177mm.loader.p244a.C44687a;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p861c.C42153d;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ%\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/loader/ImageLoader;", "T", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "Lcom/tencent/mm/loader/Loader;", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "url", "(Lcom/tencent/mm/loader/model/data/ILoaderData;)Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "(Lcom/tencent/mm/loader/model/data/ILoaderData;Landroid/widget/ImageView;Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;)V", "loadLocal", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.c */
public final class C26355c<T extends C18544c> extends C18532d<T> {
    public C26355c(C42153d<T, Bitmap> c42153d) {
        C25052j.m39376p(c42153d, "configuration");
        super(c42153d);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo33784a(Object obj, ImageView imageView, C37878e c37878e) {
        C18544c c18544c = (C18544c) obj;
        C25052j.m39376p(c18544c, "url");
        C25052j.m39376p(imageView, "view");
        C25052j.m39376p(c37878e, "options");
        new C44687a(new C42156a(c18544c), this.eOC).mo67691a(c37878e).mo44153d(imageView);
    }

    /* renamed from: aO */
    public final /* synthetic */ C42151b mo33785aO(Object obj) {
        C18544c c18544c = (C18544c) obj;
        C25052j.m39376p(c18544c, "url");
        return new C44687a(new C42156a(c18544c), this.eOC);
    }
}
