package com.tencent.mm.loader.e.c;

import a.f.b.j;
import a.l;
import com.tencent.mm.loader.e.b.f;
import com.tencent.mm.loader.e.c.b.b;
import com.tencent.mm.loader.h.e;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J@\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "T", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "transcoder", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "source", "when", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "asResourceName", "", "ishasTransCoderWhenDownload", "", "libimageloader_release"})
public final class a<T> extends b<T> {
    public final e<T> a(f<?> fVar, com.tencent.mm.loader.f<?, T> fVar2, e<T> eVar, b bVar) {
        e<T> eVar2;
        e eVar22;
        j.p(fVar, "targetView");
        j.p(fVar2, "reaper");
        j.p(eVar, "source");
        j.p(bVar, "when");
        b bVar2 = this.eQG;
        if (!(bVar2 instanceof b)) {
            bVar2 = null;
        }
        if (bVar2 == null) {
            bVar2 = this.eQG;
        } else {
            do {
                if (bVar2.eQH == com.tencent.mm.loader.e.c.b.a.HIGH && bVar == bVar2.eQI) {
                    if (eVar instanceof e) {
                        eVar22 = eVar;
                    } else {
                        eVar22 = null;
                    }
                    if (eVar22 == null) {
                        j.dWJ();
                    }
                    eVar22 = bVar2.a(fVar, fVar2, eVar22);
                    if (!(eVar22 instanceof e)) {
                        eVar22 = null;
                    }
                    if (eVar22 != null) {
                        eVar = eVar22;
                    }
                }
                bVar2 = bVar2.eQG;
                if (!(bVar2 instanceof b)) {
                    bVar2 = null;
                    continue;
                }
            } while (bVar2 != null);
        }
        bVar2 = this.eQG;
        if (!(bVar2 instanceof b)) {
            bVar2 = null;
        }
        if (bVar2 == null) {
            bVar2 = this.eQG;
        } else {
            do {
                if (bVar2.eQH == com.tencent.mm.loader.e.c.b.a.NORMAL && bVar == bVar2.eQI) {
                    if (eVar instanceof e) {
                        eVar22 = eVar;
                    } else {
                        eVar22 = null;
                    }
                    if (eVar22 == null) {
                        j.dWJ();
                    }
                    eVar22 = bVar2.a(fVar, fVar2, eVar22);
                    if (!(eVar22 instanceof e)) {
                        eVar22 = null;
                    }
                    if (eVar22 != null) {
                        eVar = eVar22;
                    }
                }
                bVar2 = bVar2.eQG;
                if (!(bVar2 instanceof b)) {
                    bVar2 = null;
                    continue;
                }
            } while (bVar2 != null);
        }
        bVar2 = this.eQG;
        if (!(bVar2 instanceof b)) {
            bVar2 = null;
        }
        if (bVar2 == null) {
            return eVar;
        }
        do {
            if (bVar2.eQH == com.tencent.mm.loader.e.c.b.a.LOW && bVar == bVar2.eQI) {
                if (eVar instanceof e) {
                    eVar22 = eVar;
                } else {
                    eVar22 = null;
                }
                if (eVar22 == null) {
                    j.dWJ();
                }
                eVar22 = bVar2.a(fVar, fVar2, eVar22);
                if (!(eVar22 instanceof e)) {
                    eVar22 = null;
                }
                if (eVar22 != null) {
                    eVar = eVar22;
                }
            }
            bVar2 = bVar2.eQG;
            if (!(bVar2 instanceof b)) {
                bVar2 = null;
                continue;
            }
        } while (bVar2 != null);
        return eVar;
    }

    public final e<? extends T> a(f<?> fVar, com.tencent.mm.loader.f<?, T> fVar2, e<T> eVar) {
        j.p(fVar, "targetView");
        j.p(fVar2, "reaper");
        j.p(eVar, "source");
        return eVar;
    }

    public final String lS(String str) {
        j.p(str, "source");
        b bVar = this.eQG;
        if (bVar == null) {
            bVar = this.eQG;
        } else {
            do {
                if (bVar.eQH == com.tencent.mm.loader.e.c.b.a.HIGH && b.DECODED == bVar.eQI) {
                    str = str + bVar.lS(str);
                }
                bVar = bVar.eQG;
            } while (bVar != null);
        }
        bVar = this.eQG;
        if (bVar == null) {
            bVar = this.eQG;
        } else {
            do {
                if (bVar.eQH == com.tencent.mm.loader.e.c.b.a.NORMAL && b.DECODED == bVar.eQI) {
                    str = str + bVar.lS(str);
                }
                bVar = bVar.eQG;
            } while (bVar != null);
        }
        bVar = this.eQG;
        if (bVar == null) {
            return str;
        }
        do {
            if (bVar.eQH == com.tencent.mm.loader.e.c.b.a.LOW && b.DECODED == bVar.eQI) {
                str = str + bVar.lS(str);
            }
            bVar = bVar.eQG;
        } while (bVar != null);
        return str;
    }
}
