package com.tencent.mm.loader.k;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import com.tencent.mm.loader.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.util.Arrays;

@l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 3*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u000234B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\nJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002J\u001e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0014J\u001e\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0002J$\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/2\u0006\u00100\u001a\u000201H\u0002J,\u00102\u001a\u00020!2\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00065"}, dWq = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask;", "T", "R", "Lcom/tencent/mm/loader/task/LoadTask;", "_url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "isLocalFile", "", "()Z", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "producer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getProducer$libimageloader_release", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setProducer$libimageloader_release", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "batchGet", "", "readNetworkStart", "", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "executeTask", "loadFromDisk", "Lcom/tencent/mm/loader/model/LoadResult;", "producerThenCommitDisk", "Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "whenDataReady", "Companion", "LazyTask", "libimageloader_release"})
public final class a<T, R> extends b<T, R> {
    public static final a eSr = new a();
    private com.tencent.mm.loader.b.b.c<T, R> ePs = this.eSE.eOK;
    private com.tencent.mm.loader.b.a.d<T, R> ePt = this.eSE.eOL;
    private com.tencent.mm.loader.d.d<R> eSq = this.eSE.eOP;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "R", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        public static final e eSC = new e();

        e() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B#\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "R", "", "result", "Lcom/tencent/mm/loader/model/Resource;", "block", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/loader/model/Resource;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getResult", "()Lcom/tencent/mm/loader/model/Resource;", "setResult", "(Lcom/tencent/mm/loader/model/Resource;)V", "commit", "libimageloader_release"})
    public static final class b<R> {
        com.tencent.mm.loader.h.e<R> eSs;
        final a.f.a.a<y> eSt;

        public b(com.tencent.mm.loader.h.e<R> eVar, a.f.a.a<y> aVar) {
            j.p(aVar, "block");
            this.eSs = eVar;
            this.eSt = aVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b¸\u0006\t"}, dWq = {"com/tencent/mm/loader/task/ImageLoadWorkTask$executeTask$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$also$lambda$1"})
    public static final class c implements com.tencent.mm.loader.d.b.a {
        final /* synthetic */ f eSu;
        final /* synthetic */ long eSv;
        final /* synthetic */ a eSw;
        final /* synthetic */ com.tencent.mm.loader.c.e.b eSx;
        final /* synthetic */ com.tencent.mm.loader.k.b.a eSy;

        c(f fVar, long j, a aVar, com.tencent.mm.loader.c.e.b bVar, com.tencent.mm.loader.k.b.a aVar2) {
            this.eSu = fVar;
            this.eSv = j;
            this.eSw = aVar;
            this.eSx = bVar;
            this.eSy = aVar2;
        }

        public final void a(com.tencent.mm.loader.h.f<?> fVar) {
            j.p(fVar, "resp");
            this.eSw.a((com.tencent.mm.loader.h.f) fVar, this.eSy);
        }

        public final void onError() {
            this.eSw.a(null, this.eSy);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, dWq = {"<anonymous>", "", "T", "R", "invoke", "com/tencent/mm/loader/task/ImageLoadWorkTask$producerThenCommitDisk$1$1$2", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$let$lambda$1"})
    static final class d extends k implements a.f.a.a<y> {
        final /* synthetic */ com.tencent.mm.loader.h.b.a eSA;
        final /* synthetic */ com.tencent.mm.loader.h.f eSB;
        final /* synthetic */ f eSu;
        final /* synthetic */ a eSw;
        final /* synthetic */ com.tencent.mm.loader.h.e eSz;

        d(com.tencent.mm.loader.h.e eVar, f fVar, a aVar, com.tencent.mm.loader.h.b.a aVar2, com.tencent.mm.loader.h.f fVar2) {
            this.eSz = eVar;
            this.eSu = fVar;
            this.eSw = aVar;
            this.eSA = aVar2;
            this.eSB = fVar2;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            this.eSw.a(this.eSB, this.eSz, null, this.eSw);
            return y.AUy;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.e.b.c<R> cVar, f<T, R> fVar) {
        j.p(aVar, "_url");
        j.p(cVar, "target");
        j.p(fVar, "reaper");
        super(aVar, cVar, fVar);
    }

    /* JADX WARNING: Missing block: B:18:0x006d, code skipped:
            if (r3 == null) goto L_0x006f;
     */
    /* JADX WARNING: Missing block: B:24:0x0082, code skipped:
            if (r2 == null) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tencent.mm.loader.h.c<R> Uo() {
        Closeable closeable;
        Throwable th;
        Throwable th2 = null;
        com.tencent.mm.loader.h.c cVar = new com.tencent.mm.loader.h.c();
        com.tencent.mm.loader.h.c.a aVar = com.tencent.mm.loader.h.c.eRS;
        cVar.from = com.tencent.mm.loader.h.c.eRQ;
        try {
            f fVar = this.eSE;
            com.tencent.mm.loader.b.a.d dVar = this.ePt;
            if (dVar != null) {
                com.tencent.mm.loader.h.a.a aVar2 = this.eQE;
                com.tencent.mm.loader.c.e eVar = fVar.eOF;
                j.p(aVar2, "url");
                j.p(eVar, "opts");
                j.p(fVar, "reaper");
                j.p(aVar2, "url");
                j.p(eVar, "opts");
                j.p(fVar, "reaper");
                com.tencent.mm.loader.h.b.a c = dVar.c(aVar2, eVar, fVar);
                if (c != null) {
                    closeable = c;
                    try {
                        com.tencent.mm.loader.h.e a;
                        com.tencent.mm.loader.h.b.a aVar3 = (com.tencent.mm.loader.h.b.a) closeable;
                        com.tencent.mm.loader.d.d dVar2 = this.eSq;
                        com.tencent.mm.loader.h.e a2 = dVar2 != null ? dVar2.a(fVar.Tc().eQw, fVar, aVar3) : null;
                        if (!(a2 instanceof com.tencent.mm.loader.h.e)) {
                            a2 = null;
                        }
                        if (a2 != null) {
                            com.tencent.mm.loader.e.c.a aVar4 = fVar.eOR;
                            if (aVar4 != null) {
                                a = aVar4.a(fVar.Tc().eQw, fVar, a2, com.tencent.mm.loader.e.c.b.b.DECODED);
                            } else {
                                a = null;
                            }
                        }
                        a = a2;
                        if (a != null) {
                            com.tencent.mm.loader.e.c.a aVar5 = fVar.eOQ;
                            if (aVar5 != null) {
                                a2 = aVar5.a(fVar.Tc().eQw, fVar, a, com.tencent.mm.loader.e.c.b.b.DECODED);
                            } else {
                                a2 = null;
                            }
                        }
                        a2 = a;
                        if (a2 != null) {
                            if (!a2.isValid()) {
                                a2 = null;
                            }
                            if (a2 != null) {
                                com.tencent.mm.loader.b.b.c cVar2 = this.ePs;
                                if (cVar2 != null) {
                                    cVar2.a(fVar.eOY, fVar.eOQ, a2.getValue());
                                }
                                cVar.value = a2.getValue();
                            }
                        }
                        a.e.b.a(closeable, null);
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                    }
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e, "[ImageLoader READ] run error %s [debug info %s]", this.eQE, this.ePa);
        }
        return cVar;
        a.e.b.a(closeable, th2);
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0151 A:{LOOP_START, LOOP:2: B:85:0x0151->B:93:0x0165, PHI: r0 } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0139 A:{LOOP_START, LOOP:1: B:76:0x0139->B:84:0x014d, PHI: r0 } */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.tencent.mm.loader.h.f<?> fVar, com.tencent.mm.loader.k.b.a<R> aVar) {
        com.tencent.mm.loader.c.e eVar;
        Object[] objArr = null;
        com.tencent.mm.loader.h.c cVar = new com.tencent.mm.loader.h.c();
        com.tencent.mm.loader.h.c.a aVar2 = com.tencent.mm.loader.h.c.eRS;
        cVar.from = com.tencent.mm.loader.h.c.eRR;
        f fVar2 = this.eSE;
        if (fVar != null) {
            com.tencent.mm.loader.h.f<?> fVar3;
            if ((fVar.value() != null ? 1 : 0) != 0) {
                fVar3 = fVar;
            } else {
                fVar3 = null;
            }
            if (fVar3 != null) {
                com.tencent.mm.loader.h.b.a TW = fVar.TW();
                if (TW != null) {
                    com.tencent.mm.loader.h.e eVar2;
                    b bVar;
                    System.currentTimeMillis();
                    f fVar4 = this.eSE;
                    com.tencent.mm.loader.d.d dVar = this.eSq;
                    com.tencent.mm.loader.h.e a = dVar != null ? dVar.a(fVar4.Tc().eQw, this.eSE, TW) : null;
                    if (a instanceof com.tencent.mm.loader.h.e) {
                        eVar2 = a;
                    } else {
                        eVar2 = null;
                    }
                    if (eVar2 != null) {
                        com.tencent.mm.loader.e.c.a aVar3 = fVar4.eOQ;
                        if (aVar3 != null) {
                            int i;
                            com.tencent.mm.loader.e.c.b.b bVar2 = com.tencent.mm.loader.e.c.b.b.DOWNLOADED;
                            j.p(bVar2, "when");
                            com.tencent.mm.loader.e.c.b bVar3 = aVar3.eQG;
                            if (!(bVar3 instanceof com.tencent.mm.loader.e.c.b)) {
                                bVar3 = null;
                            }
                            if (bVar3 == null) {
                                bVar3 = aVar3.eQG;
                                if (!(bVar3 instanceof com.tencent.mm.loader.e.c.b)) {
                                    bVar3 = null;
                                }
                                if (bVar3 != null) {
                                    bVar3 = aVar3.eQG;
                                    if (!(bVar3 instanceof com.tencent.mm.loader.e.c.b)) {
                                        bVar3 = null;
                                    }
                                    if (bVar3 != null) {
                                        i = 0;
                                    } else {
                                        do {
                                            if (bVar3.eQH == com.tencent.mm.loader.e.c.b.a.LOW && bVar2 == bVar3.eQI) {
                                                i = 1;
                                                break;
                                            }
                                            bVar3 = bVar3.eQG;
                                            if (!(bVar3 instanceof com.tencent.mm.loader.e.c.b)) {
                                                bVar3 = null;
                                                continue;
                                            }
                                        } while (bVar3 != null);
                                        i = 0;
                                    }
                                } else {
                                    do {
                                        if (bVar3.eQH == com.tencent.mm.loader.e.c.b.a.NORMAL && bVar2 == bVar3.eQI) {
                                            i = 1;
                                            break;
                                        }
                                        bVar3 = bVar3.eQG;
                                        if (!(bVar3 instanceof com.tencent.mm.loader.e.c.b)) {
                                            bVar3 = null;
                                            continue;
                                        }
                                    } while (bVar3 != null);
                                    bVar3 = aVar3.eQG;
                                    if (bVar3 instanceof com.tencent.mm.loader.e.c.b) {
                                    }
                                    if (bVar3 != null) {
                                    }
                                }
                            } else {
                                do {
                                    if (bVar3.eQH == com.tencent.mm.loader.e.c.b.a.HIGH && bVar2 == bVar3.eQI) {
                                        i = 1;
                                        break;
                                    }
                                    bVar3 = bVar3.eQG;
                                    if (!(bVar3 instanceof com.tencent.mm.loader.e.c.b)) {
                                        bVar3 = null;
                                        continue;
                                    }
                                } while (bVar3 != null);
                                bVar3 = aVar3.eQG;
                                if (bVar3 instanceof com.tencent.mm.loader.e.c.b) {
                                }
                                if (bVar3 != null) {
                                }
                            }
                            if (i == 1) {
                                com.tencent.mm.loader.e.c.a aVar4 = fVar4.eOQ;
                                if (aVar4 != null) {
                                    com.tencent.mm.loader.h.e a2 = aVar4.a(fVar4.Tc().eQw, fVar4, eVar2, com.tencent.mm.loader.e.c.b.b.DOWNLOADED);
                                    if (a2 != null) {
                                        a(fVar, eVar2, a2, this);
                                        bVar = new b(a2, e.eSC);
                                        if (bVar != null) {
                                            y yVar;
                                            eVar2 = bVar.eSs;
                                            if (eVar2 != null) {
                                                com.tencent.mm.ab.a aVar5 = new com.tencent.mm.ab.a("Transcoder");
                                                aVar4 = fVar2.eOR;
                                                if (aVar4 != null) {
                                                    a = aVar4.a(fVar2.Tc().eQw, fVar2, eVar2, com.tencent.mm.loader.e.c.b.b.DECODED);
                                                } else {
                                                    a = null;
                                                }
                                                if (a == null) {
                                                    a = eVar2;
                                                }
                                                com.tencent.mm.loader.e.c.a aVar6 = fVar2.eOQ;
                                                if (aVar6 != null) {
                                                    a2 = aVar6.a(fVar2.Tc().eQw, fVar2, a, com.tencent.mm.loader.e.c.b.b.DECODED);
                                                } else {
                                                    a2 = null;
                                                }
                                                if (a2 != null) {
                                                    a = a2;
                                                }
                                                aVar6 = fVar2.eOQ;
                                                if (aVar6 != null) {
                                                    aVar6.a(fVar2.Tc().eQw, fVar2, a, com.tencent.mm.loader.e.c.b.b.LOADED);
                                                }
                                                yVar = y.AUy;
                                                aVar5.SW();
                                                Object value = eVar2.getValue();
                                                cVar.value = value;
                                                aVar.a(cVar);
                                                if (value != null) {
                                                    com.tencent.mm.loader.b.b.c cVar2 = this.ePs;
                                                    if (cVar2 != null) {
                                                        cVar2.a(fVar2.eOY, fVar2.eOQ, value);
                                                    }
                                                }
                                            }
                                            com.tencent.mm.ab.a aVar7 = new com.tencent.mm.ab.a("lazytask commit");
                                            bVar.eSt.invoke();
                                            yVar = y.AUy;
                                            aVar7.SW();
                                            if (fVar2.eOS != null) {
                                                eVar = this.eSE.eOF;
                                                if (eVar != null) {
                                                    objArr = eVar.TG();
                                                }
                                                Arrays.copyOf(objArr, objArr.length);
                                                return;
                                            }
                                            return;
                                        }
                                        aVar2 = com.tencent.mm.loader.h.c.eRS;
                                        cVar.status = com.tencent.mm.loader.h.c.eRN;
                                        if (fVar2.eOS != null) {
                                            eVar = this.eSE.eOF;
                                            if (eVar != null) {
                                                objArr = eVar.TG();
                                            }
                                            Arrays.copyOf(objArr, objArr.length);
                                        }
                                        aVar.Uq();
                                        return;
                                    }
                                }
                            }
                        }
                        bVar = new b(eVar2, new d(eVar2, fVar4, this, TW, fVar));
                        if (bVar != null) {
                        }
                    }
                    bVar = null;
                    if (bVar != null) {
                    }
                }
            }
        }
        aVar2 = com.tencent.mm.loader.h.c.eRS;
        cVar.status = com.tencent.mm.loader.h.c.eRL;
        if (com.tencent.mm.loader.c.e.DEBUG) {
            ab.i("MicroMsg.Loader.ImageLoadWorkTask", "httpRespone value is null %s %s", this.eQE, bo.dpG().toString());
        }
        if (fVar2.eOS != null) {
            eVar = this.eSE.eOF;
            if (eVar != null) {
                objArr = eVar.TG();
            }
            Arrays.copyOf(objArr, objArr.length);
        }
        aVar.Uq();
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ce A:{Catch:{ Exception -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00b6 A:{Catch:{ Exception -> 0x0192 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.loader.c.e.b bVar, com.tencent.mm.loader.k.b.a<R> aVar) {
        boolean z = true;
        j.p(bVar, "fileType");
        j.p(aVar, "taskListener");
        try {
            boolean z2;
            System.currentTimeMillis();
            ab.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. key:" + this.eQE + " fileType " + bVar + " [width:" + this.eOZ + ".weakHolder.viewWidth height:" + this.eOZ + ".weakHolder.viewHeight] diskCache " + this.ePt + " producer " + this.eSq);
            com.tencent.mm.loader.h.c Uo = Uo();
            if (this.eQE != null) {
                if (com.tencent.mm.loader.l.a.d(this.eQE)) {
                    z2 = true;
                } else if (this.eSE.eOF.Ty() == com.tencent.mm.loader.c.e.b.FILE) {
                    z2 = true;
                }
                if (z2 || Uo.value != null) {
                    z = false;
                }
                ab.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + Uo + " bitmap " + Uo.value + " isNeedDownload " + z);
                if (z) {
                    aVar.b(Uo);
                    return;
                }
                f fVar = this.eSE;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    ab.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from memory failed.now try to get from network. " + this.eQE + " fileType: " + bVar);
                    if (fVar.eOI != null) {
                        fVar.Tc();
                    }
                    com.tencent.mm.loader.d.b bVar2 = fVar.eOJ;
                    if (!fVar.eOO.a(this.eQE)) {
                        bVar2 = null;
                    }
                    if (bVar2 == null) {
                        a(null, (com.tencent.mm.loader.k.b.a) aVar);
                        ab.i("MicroMsg.Loader.ImageLoadWorkTask", "can not download image, over limit " + this.eQE);
                        return;
                    }
                    com.tencent.mm.loader.d.b bVar3 = fVar.eOJ;
                    com.tencent.mm.loader.h.a.a aVar2 = this.eQE;
                    com.tencent.mm.loader.f.f fVar2 = fVar.eOV;
                    com.tencent.mm.loader.g.b bVar4 = this.eQR;
                    if (bVar4 == null) {
                        j.avw("loader");
                    }
                    com.tencent.mm.loader.d.b.a cVar = new c(fVar, currentTimeMillis, this, bVar, aVar);
                    j.p(aVar2, "url");
                    j.p(fVar2, "fileNameCreator");
                    j.p(bVar4, "loader");
                    j.p(cVar, "callback");
                    bVar4.u(new com.tencent.mm.loader.d.b.c(bVar3, bVar4, aVar2, fVar2, cVar));
                    return;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e, "[ImageLoader DownLoadException] run error %s [debug info %s]", this.eQE, fVar.ePa);
                    y yVar = y.AUy;
                    return;
                }
            }
            z2 = false;
            z = false;
            ab.d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + Uo + " bitmap " + Uo.value + " isNeedDownload " + z);
            if (z) {
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e2, "[ImageLoader execute] " + e2.getMessage() + " run error " + this.eQE + " [debug info " + this.ePa + ']', new Object[0]);
            aVar.Uq();
        }
    }
}
