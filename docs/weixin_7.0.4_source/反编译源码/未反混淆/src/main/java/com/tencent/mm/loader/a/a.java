package com.tencent.mm.loader.a;

import a.f.b.j;
import a.f.b.u;
import a.l;
import a.v;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.e.b.b;
import com.tencent.mm.loader.e.b.c;
import com.tencent.mm.loader.e.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000e\"\u0004\b\u0001\u0010\u000f2\u0006\u0010\u000b\u001a\u0002H\u000fH\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
public final class a<T> extends b<T, Bitmap> {
    public a(com.tencent.mm.loader.h.a.a<T> aVar, d<T, Bitmap> dVar) {
        j.p(aVar, "reqValue");
        j.p(dVar, "mImageLoaderConfiguration");
        super(aVar, dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Missing block: B:23:0x00c4, code skipped:
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil((java.lang.String) r0) != false) goto L_0x00c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(ImageView imageView) {
        j.p(imageView, "imageView");
        this.eOZ = new b(new f(imageView));
        com.tencent.mm.loader.f fVar = new com.tencent.mm.loader.f(this, this.ePg);
        fVar.eOY = fVar.ePb.ePf;
        c cVar = fVar.ePb.eOZ;
        if (cVar == null) {
            cVar = new com.tencent.mm.loader.e.b.a();
        }
        fVar.eOZ = cVar;
        com.tencent.mm.loader.e.b.d.a aVar = com.tencent.mm.loader.e.b.d.eQA;
        com.tencent.mm.loader.e.b.d TN = com.tencent.mm.loader.e.b.d.a.TN();
        c cVar2 = fVar.eOZ;
        if (cVar2 == null) {
            j.avw("target");
        }
        if (cVar2 == null) {
            throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
        }
        Object putIfAbsent;
        int i;
        com.tencent.mm.loader.h.a.a aVar2;
        com.tencent.mm.loader.h.a.a aVar3 = fVar.eOY;
        j.p(cVar2, "target");
        j.p(aVar3, "data");
        ab.i(com.tencent.mm.loader.e.b.d.TAG, "register " + cVar2 + " data " + aVar3);
        ConcurrentMap concurrentMap = TN.map;
        Object obj = concurrentMap.get(cVar2);
        if (obj == null) {
            Set linkedHashSet = new LinkedHashSet();
            putIfAbsent = concurrentMap.putIfAbsent(cVar2, linkedHashSet);
            if (putIfAbsent == null) {
                putIfAbsent = linkedHashSet;
            }
        } else {
            putIfAbsent = obj;
        }
        ((Collection) putIfAbsent).add(aVar3);
        com.tencent.mm.loader.h.a.a aVar4 = fVar.eOY;
        if (fVar.eOY.Ug()) {
            if (fVar.eOY.value() instanceof String) {
                putIfAbsent = fVar.eOY.value();
                if (putIfAbsent == null) {
                    throw new v("null cannot be cast to non-null type kotlin.String");
                }
            }
            i = 0;
            if (i == 0) {
                aVar2 = aVar4;
            } else {
                aVar2 = null;
            }
            c cVar3;
            if (aVar2 == null) {
                aVar = com.tencent.mm.loader.e.b.d.eQA;
                TN = com.tencent.mm.loader.e.b.d.a.TN();
                cVar3 = fVar.eOZ;
                if (cVar3 == null) {
                    j.avw("target");
                }
                if (cVar3 == null) {
                    throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
                }
                Object[] TG;
                TN.a(cVar3);
                e eVar = fVar.eOF;
                if (eVar != null) {
                    TG = eVar.TG();
                } else {
                    TG = null;
                }
                Arrays.copyOf(TG, TG.length);
                return;
            }
            u.c cVar4 = new u.c();
            cVar4.AVE = fVar.eOF.Ts() ? fVar.eOK.a(fVar.eOY, fVar.eOQ) : null;
            boolean booleanValue = ((Boolean) new com.tencent.mm.loader.f.b(fVar, cVar4).invoke()).booleanValue();
            com.tencent.mm.loader.h.e eVar2 = (com.tencent.mm.loader.h.e) cVar4.AVE;
            if (eVar2 != null) {
                if (!eVar2.isValid()) {
                    eVar2 = null;
                }
                if (eVar2 != null) {
                    putIfAbsent = eVar2.getValue();
                    if (putIfAbsent != null) {
                        ab.d(com.tencent.mm.loader.f.TAG, "[ImageLoader] load from cache. not need to url: %s", fVar.eOY);
                        com.tencent.mm.loader.h.e eVar3 = new com.tencent.mm.loader.h.e(putIfAbsent);
                        com.tencent.mm.loader.e.c.a aVar5 = fVar.eOQ;
                        if (aVar5 != null) {
                            c cVar5 = fVar.eOZ;
                            if (cVar5 == null) {
                                j.avw("target");
                            }
                            aVar5.a(cVar5.eQw, fVar, eVar3, com.tencent.mm.loader.e.c.b.b.LOADED);
                        }
                        cVar3 = fVar.eOZ;
                        if (cVar3 == null) {
                            j.avw("target");
                        }
                        cVar3.aP(putIfAbsent);
                        if (fVar.eOI != null) {
                            com.tencent.mm.loader.h.c.a aVar6 = com.tencent.mm.loader.h.c.eRS;
                            int TY = com.tencent.mm.loader.h.c.STATUS_OK;
                            com.tencent.mm.loader.h.c.a aVar7 = com.tencent.mm.loader.h.c.eRS;
                            com.tencent.mm.loader.h.c cVar6 = new com.tencent.mm.loader.h.c(TY, com.tencent.mm.loader.h.c.eRP, putIfAbsent);
                        }
                        aVar = com.tencent.mm.loader.e.b.d.eQA;
                        TN = com.tencent.mm.loader.e.b.d.a.TN();
                        cVar3 = fVar.eOZ;
                        if (cVar3 == null) {
                            j.avw("target");
                        }
                        if (cVar3 == null) {
                            throw new v("null cannot be cast to non-null type com.tencent.mm.loader.impr.target.ResourceShowTarget<kotlin.Any>");
                        }
                        TN.a(cVar3);
                        if (!booleanValue) {
                            return;
                        }
                    }
                }
            }
            aVar4 = fVar.eOY;
            c cVar7 = fVar.eOZ;
            if (cVar7 == null) {
                j.avw("target");
            }
            com.tencent.mm.loader.k.a aVar8 = new com.tencent.mm.loader.k.a(aVar4, cVar7, fVar);
            if (e.DEBUG) {
                String anVar = bo.dpG().toString();
                j.o(anVar, "Util.getStack().toString()");
                aVar8.ePa = anVar;
                fVar.ePa = anVar;
            }
            ab.d(com.tencent.mm.loader.f.TAG, "[ImageLoader] load from task:%s", fVar.eOY);
            cVar3 = fVar.eOZ;
            if (cVar3 == null) {
                j.avw("target");
            }
            cVar7 = fVar.eOZ;
            if (cVar7 == null) {
                j.avw("target");
            }
            cVar3.a(cVar7.eQw, fVar);
            com.tencent.mm.loader.k.b bVar = aVar8;
            boolean Tu = fVar.eOF.Tu();
            fVar.Td();
            com.tencent.mm.loader.g.d dVar = fVar.eOT;
            if (dVar != null) {
                dVar.a((com.tencent.mm.loader.g.c) bVar);
            }
            if (Tu) {
                com.tencent.mm.loader.l.b.Us();
                return;
            }
            return;
        }
        i = 1;
        if (i == 0) {
        }
        if (aVar2 == null) {
        }
    }
}
