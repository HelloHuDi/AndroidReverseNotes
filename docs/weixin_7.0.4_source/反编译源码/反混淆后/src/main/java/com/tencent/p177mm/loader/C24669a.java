package com.tencent.p177mm.loader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.p177mm.loader.p1197h.p1198a.C18543b;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p244a.C42151b;
import com.tencent.p177mm.loader.p244a.C44687a;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p861c.C42153d;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0010\u001a\u00020\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u001a\u001a\u00020\u0002¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/loader/DefaultImageLoader;", "Lcom/tencent/mm/loader/Loader;", "", "configuration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "Landroid/graphics/Bitmap;", "(Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "load", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "url", "", "view", "Landroid/widget/ImageView;", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "loadAssert", "assertPath", "loadDrawable", "Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "context", "Landroid/content/Context;", "drawable", "resId", "", "loadLocal", "loadLocalFile", "filePath", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.a */
public final class C24669a extends C18532d<String> {
    public C24669a(C42153d<String, Bitmap> c42153d) {
        C25052j.m39376p(c42153d, "configuration");
        super(c42153d);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo33784a(Object obj, ImageView imageView, C37878e c37878e) {
        String str = (String) obj;
        C25052j.m39376p(str, "url");
        C25052j.m39376p(imageView, "view");
        C25052j.m39376p(c37878e, "options");
        new C44687a(new C42156a(str), this.eOC).mo67691a(c37878e).mo44153d(imageView);
    }

    /* renamed from: aO */
    public final /* synthetic */ C42151b mo33785aO(Object obj) {
        String str = (String) obj;
        C25052j.m39376p(str, "url");
        return new C44687a(new C42156a(str), this.eOC);
    }

    /* renamed from: lR */
    public final C42151b<String, Bitmap> mo41564lR(String str) {
        C25052j.m39376p(str, "filePath");
        C42156a a = C42156a.m74318a(str, C18543b.LOCAL_PATH);
        C25052j.m39375o(a, "DataItem.create(filePath, DataType.LOCAL_PATH)");
        return new C44687a(a, this.eOC);
    }
}
