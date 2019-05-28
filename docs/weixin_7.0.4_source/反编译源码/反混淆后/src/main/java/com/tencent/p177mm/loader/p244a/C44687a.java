package com.tencent.p177mm.loader.p244a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.C45421f.C45419b;
import com.tencent.p177mm.loader.p1197h.C42158c;
import com.tencent.p177mm.loader.p1197h.C42158c.C42159a;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p1200k.C18555b;
import com.tencent.p177mm.loader.p1200k.C32736a;
import com.tencent.p177mm.loader.p1201l.C18558b;
import com.tencent.p177mm.loader.p246e.p247b.C1751b;
import com.tencent.p177mm.loader.p246e.p247b.C1752c;
import com.tencent.p177mm.loader.p246e.p247b.C1754d;
import com.tencent.p177mm.loader.p246e.p247b.C1754d.C1755a;
import com.tencent.p177mm.loader.p246e.p247b.C32731f;
import com.tencent.p177mm.loader.p246e.p247b.C6626a;
import com.tencent.p177mm.loader.p246e.p862c.C31269b.C26361b;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p861c.C42153d;
import com.tencent.p177mm.loader.p864g.C26365c;
import com.tencent.p177mm.loader.p864g.C26366d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C41381u.C31596c;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000e\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u000b\u001a\u0002H\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.a.a */
public final class C44687a<T> extends C42151b<T, Bitmap> {
    public C44687a(C42156a<T> c42156a, C42153d<T, Bitmap> c42153d) {
        C25052j.m39376p(c42156a, "reqValue");
        C25052j.m39376p(c42153d, "mImageLoaderConfiguration");
        super(c42156a, c42153d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Missing block: B:23:0x00c4, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil((java.lang.String) r0) != false) goto L_0x00c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public final void mo44153d(ImageView imageView) {
        C25052j.m39376p(imageView, "imageView");
        this.eOZ = new C1751b(new C32731f(imageView));
        C45421f c45421f = new C45421f(this, this.ePg);
        c45421f.eOY = c45421f.ePb.ePf;
        C1752c c1752c = c45421f.ePb.eOZ;
        if (c1752c == null) {
            c1752c = new C6626a();
        }
        c45421f.eOZ = c1752c;
        C1755a c1755a = C1754d.eQA;
        C1754d TN = C1755a.m3619TN();
        C1752c c1752c2 = c45421f.eOZ;
        if (c1752c2 == null) {
            C25052j.avw("target");
        }
        if (c1752c2 == null) {
            throw new C44941v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        Object putIfAbsent;
        int i;
        C42156a c42156a;
        C42156a c42156a2 = c45421f.eOY;
        C25052j.m39376p(c1752c2, "target");
        C25052j.m39376p(c42156a2, "data");
        C4990ab.m7416i(C1754d.TAG, "register " + c1752c2 + " data " + c42156a2);
        ConcurrentMap concurrentMap = TN.map;
        Object obj = concurrentMap.get(c1752c2);
        if (obj == null) {
            Set linkedHashSet = new LinkedHashSet();
            putIfAbsent = concurrentMap.putIfAbsent(c1752c2, linkedHashSet);
            if (putIfAbsent == null) {
                putIfAbsent = linkedHashSet;
            }
        } else {
            putIfAbsent = obj;
        }
        ((Collection) putIfAbsent).add(c42156a2);
        C42156a c42156a3 = c45421f.eOY;
        if (c45421f.eOY.mo67693Ug()) {
            if (c45421f.eOY.value() instanceof String) {
                putIfAbsent = c45421f.eOY.value();
                if (putIfAbsent == null) {
                    throw new C44941v("null cannot be cast to non-null type kotlin.String");
                }
            }
            i = 0;
            if (i == 0) {
                c42156a = c42156a3;
            } else {
                c42156a = null;
            }
            C1752c c1752c3;
            if (c42156a == null) {
                c1755a = C1754d.eQA;
                TN = C1755a.m3619TN();
                c1752c3 = c45421f.eOZ;
                if (c1752c3 == null) {
                    C25052j.avw("target");
                }
                if (c1752c3 == null) {
                    throw new C44941v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
                }
                Object[] TG;
                TN.mo5289a(c1752c3);
                C37878e c37878e = c45421f.eOF;
                if (c37878e != null) {
                    TG = c37878e.mo60618TG();
                } else {
                    TG = null;
                }
                Arrays.copyOf(TG, TG.length);
                return;
            }
            C31596c c31596c = new C31596c();
            c31596c.AVE = c45421f.eOF.mo60620Ts() ? c45421f.eOK.mo20873a(c45421f.eOY, c45421f.eOQ) : null;
            boolean booleanValue = ((Boolean) new C45419b(c45421f, c31596c).invoke()).booleanValue();
            C42161e c42161e = (C42161e) c31596c.AVE;
            if (c42161e != null) {
                if (!c42161e.isValid()) {
                    c42161e = null;
                }
                if (c42161e != null) {
                    putIfAbsent = c42161e.getValue();
                    if (putIfAbsent != null) {
                        C4990ab.m7411d(C45421f.TAG, "[ImageLoader] load from cache. not need to url: %s", c45421f.eOY);
                        C42161e c42161e2 = new C42161e(putIfAbsent);
                        C9569a c9569a = c45421f.eOQ;
                        if (c9569a != null) {
                            C1752c c1752c4 = c45421f.eOZ;
                            if (c1752c4 == null) {
                                C25052j.avw("target");
                            }
                            c9569a.mo20890a(c1752c4.eQw, c45421f, c42161e2, C26361b.LOADED);
                        }
                        c1752c3 = c45421f.eOZ;
                        if (c1752c3 == null) {
                            C25052j.avw("target");
                        }
                        c1752c3.mo5287aP(putIfAbsent);
                        if (c45421f.eOI != null) {
                            C42159a c42159a = C42158c.eRS;
                            int TY = C42158c.STATUS_OK;
                            C42159a c42159a2 = C42158c.eRS;
                            C42158c c42158c = new C42158c(TY, C42158c.eRP, putIfAbsent);
                        }
                        c1755a = C1754d.eQA;
                        TN = C1755a.m3619TN();
                        c1752c3 = c45421f.eOZ;
                        if (c1752c3 == null) {
                            C25052j.avw("target");
                        }
                        if (c1752c3 == null) {
                            throw new C44941v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
                        }
                        TN.mo5289a(c1752c3);
                        if (!booleanValue) {
                            return;
                        }
                    }
                }
            }
            c42156a3 = c45421f.eOY;
            C1752c c1752c5 = c45421f.eOZ;
            if (c1752c5 == null) {
                C25052j.avw("target");
            }
            C32736a c32736a = new C32736a(c42156a3, c1752c5, c45421f);
            if (C37878e.DEBUG) {
                String c5007an = C5046bo.dpG().toString();
                C25052j.m39375o(c5007an, "Util.getStack().toString()");
                c32736a.ePa = c5007an;
                c45421f.ePa = c5007an;
            }
            C4990ab.m7411d(C45421f.TAG, "[ImageLoader] load from task:%s", c45421f.eOY);
            c1752c3 = c45421f.eOZ;
            if (c1752c3 == null) {
                C25052j.avw("target");
            }
            c1752c5 = c45421f.eOZ;
            if (c1752c5 == null) {
                C25052j.avw("target");
            }
            c1752c3.mo5285a(c1752c5.eQw, c45421f);
            C18555b c18555b = c32736a;
            boolean Tu = c45421f.eOF.mo60622Tu();
            c45421f.mo73212Td();
            C26366d c26366d = c45421f.eOT;
            if (c26366d != null) {
                c26366d.mo44158a((C26365c) c18555b);
            }
            if (Tu) {
                C18558b.m28880Us();
                return;
            }
            return;
        }
        i = 1;
        if (i == 0) {
        }
        if (c42156a == null) {
        }
    }
}
