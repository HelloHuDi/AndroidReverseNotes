package com.tencent.p177mm.loader.p858b.p860b;

import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J/\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fH¦\u0002J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fJ3\u0010\u0010\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fH&¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "T", "R", "", "()V", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getImageKey", "", "uriValue", "put", "key", "value", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;Ljava/lang/Object;)V", "remove", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.b.b.c */
public abstract class C9566c<T, R> {
    /* renamed from: a */
    public abstract C42161e<R> mo20873a(C42156a<T> c42156a, C9569a<R> c9569a);

    /* renamed from: a */
    public abstract void mo20874a(C42156a<T> c42156a, C9569a<R> c9569a, R r);

    /* renamed from: b */
    public static String m17036b(C42156a<T> c42156a, C9569a<R> c9569a) {
        if (c42156a == null || !c42156a.mo67693Ug()) {
            return null;
        }
        String c42156a2;
        if (c9569a != null) {
            c42156a2 = c42156a.toString();
            C25052j.m39375o(c42156a2, "uriValue.toString()");
            c42156a2 = c9569a.mo20891lS(c42156a2);
            if (c42156a2 != null) {
                return c42156a2;
            }
        }
        c42156a2 = c42156a.toString();
        C25052j.m39375o(c42156a2, "uriValue.toString()");
        return c42156a2;
    }
}
