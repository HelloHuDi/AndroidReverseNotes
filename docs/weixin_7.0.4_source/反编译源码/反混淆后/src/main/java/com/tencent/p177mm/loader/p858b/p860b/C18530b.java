package com.tencent.p177mm.loader.p858b.p860b;

import com.tencent.p177mm.loader.p1197h.C42160d;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J/\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fH\u0002J3\u0010\u0010\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCache;", "T", "R", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "Companion", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.b.b.b */
public final class C18530b<T, R> extends C9566c<T, R> {
    private static final String TAG = TAG;
    private static final int ePp = 50;
    public static final C9565a ePq = new C9565a();
    private final C42160d<String, R> ePn = new C42160d(ePp);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/loader/cache/memory/DefaultMemoryCache$Companion;", "", "()V", "MAX_DEFAULT_BITMAP_SIZE", "", "getMAX_DEFAULT_BITMAP_SIZE", "()I", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.b.b.b$a */
    public static final class C9565a {
        private C9565a() {
        }

        public /* synthetic */ C9565a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final C42161e<R> mo20873a(C42156a<T> c42156a, C9569a<R> c9569a) {
        C25052j.m39376p(c42156a, "url");
        Object obj = this.ePn.get(C9566c.m17036b(c42156a, c9569a));
        if (obj != null) {
            return new C42161e(obj);
        }
        return null;
    }

    /* renamed from: a */
    public final void mo20874a(C42156a<T> c42156a, C9569a<R> c9569a, R r) {
        C25052j.m39376p(c42156a, "url");
        this.ePn.put(C9566c.m17036b(c42156a, c9569a), r);
    }
}
