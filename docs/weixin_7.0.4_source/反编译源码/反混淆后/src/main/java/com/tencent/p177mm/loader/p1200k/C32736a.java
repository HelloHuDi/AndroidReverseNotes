package com.tencent.p177mm.loader.p1200k;

import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p1197h.C42158c;
import com.tencent.p177mm.loader.p1197h.C42158c.C42159a;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p1197h.C42162f;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p1197h.p1199b.C18545a;
import com.tencent.p177mm.loader.p1200k.C18555b.C18557a;
import com.tencent.p177mm.loader.p1201l.C26372a;
import com.tencent.p177mm.loader.p245d.C32725b;
import com.tencent.p177mm.loader.p245d.C32725b.C26356a;
import com.tencent.p177mm.loader.p245d.C32725b.C32726c;
import com.tencent.p177mm.loader.p245d.C32728d;
import com.tencent.p177mm.loader.p246e.p247b.C1752c;
import com.tencent.p177mm.loader.p246e.p862c.C31269b;
import com.tencent.p177mm.loader.p246e.p862c.C31269b.C26361b;
import com.tencent.p177mm.loader.p246e.p862c.C31269b.C9570a;
import com.tencent.p177mm.loader.p246e.p862c.C9569a;
import com.tencent.p177mm.loader.p858b.p859a.C26352d;
import com.tencent.p177mm.loader.p858b.p860b.C9566c;
import com.tencent.p177mm.loader.p861c.C37878e;
import com.tencent.p177mm.loader.p861c.C37878e.C37879b;
import com.tencent.p177mm.loader.p863f.C32733f;
import com.tencent.p177mm.loader.p864g.C9576b;
import com.tencent.p177mm.p823ab.C8901a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Closeable;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000x\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 3*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u000234B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\nJ\u001e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002J\u001e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0014J\u001e\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0002J$\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/2\u0006\u00100\u001a\u000201H\u0002J,\u00102\u001a\u00020!2\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%H\u0002R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00065"}, dWq = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask;", "T", "R", "Lcom/tencent/mm/loader/task/LoadTask;", "_url", "Lcom/tencent/mm/loader/model/data/DataItem;", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Lcom/tencent/mm/loader/Reaper;)V", "diskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getDiskCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setDiskCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "isLocalFile", "", "()Z", "memoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMemoryCache$libimageloader_release", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMemoryCache$libimageloader_release", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "producer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getProducer$libimageloader_release", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setProducer$libimageloader_release", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "batchGet", "", "readNetworkStart", "", "taskListener", "Lcom/tencent/mm/loader/task/LoadTask$ITask;", "execute", "fileType", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions$LoadFrom;", "executeTask", "loadFromDisk", "Lcom/tencent/mm/loader/model/LoadResult;", "producerThenCommitDisk", "Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "whenDataReady", "Companion", "LazyTask", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.k.a */
public final class C32736a<T, R> extends C18555b<T, R> {
    public static final C32740a eSr = new C32740a();
    private C9566c<T, R> ePs = this.eSE.eOK;
    private C26352d<T, R> ePt = this.eSE.eOL;
    private C32728d<R> eSq = this.eSE.eOP;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "T", "R", "invoke"})
    /* renamed from: com.tencent.mm.loader.k.a$e */
    static final class C18554e extends C25053k implements C31214a<C37091y> {
        public static final C18554e eSC = new C18554e();

        C18554e() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B#\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, dWq = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$LazyTask;", "R", "", "result", "Lcom/tencent/mm/loader/model/Resource;", "block", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/loader/model/Resource;Lkotlin/jvm/functions/Function0;)V", "getBlock", "()Lkotlin/jvm/functions/Function0;", "getResult", "()Lcom/tencent/mm/loader/model/Resource;", "setResult", "(Lcom/tencent/mm/loader/model/Resource;)V", "commit", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.k.a$b */
    public static final class C32737b<R> {
        C42161e<R> eSs;
        final C31214a<C37091y> eSt;

        public C32737b(C42161e<R> c42161e, C31214a<C37091y> c31214a) {
            C25052j.m39376p(c31214a, "block");
            this.eSs = c42161e;
            this.eSt = c31214a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b¸\u0006\t"}, dWq = {"com/tencent/mm/loader/task/ImageLoadWorkTask$executeTask$1$1$1", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$also$lambda$1"})
    /* renamed from: com.tencent.mm.loader.k.a$c */
    public static final class C32738c implements C26356a {
        final /* synthetic */ C45421f eSu;
        final /* synthetic */ long eSv;
        final /* synthetic */ C32736a eSw;
        final /* synthetic */ C37879b eSx;
        final /* synthetic */ C18557a eSy;

        C32738c(C45421f c45421f, long j, C32736a c32736a, C37879b c37879b, C18557a c18557a) {
            this.eSu = c45421f;
            this.eSv = j;
            this.eSw = c32736a;
            this.eSx = c37879b;
            this.eSy = c18557a;
        }

        /* renamed from: a */
        public final void mo44154a(C42162f<?> c42162f) {
            C25052j.m39376p(c42162f, "resp");
            this.eSw.m53420a((C42162f) c42162f, this.eSy);
        }

        public final void onError() {
            this.eSw.m53420a(null, this.eSy);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, dWq = {"<anonymous>", "", "T", "R", "invoke", "com/tencent/mm/loader/task/ImageLoadWorkTask$producerThenCommitDisk$1$1$2", "com/tencent/mm/loader/task/ImageLoadWorkTask$$special$$inlined$let$lambda$1"})
    /* renamed from: com.tencent.mm.loader.k.a$d */
    static final class C32739d extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C18545a eSA;
        final /* synthetic */ C42162f eSB;
        final /* synthetic */ C45421f eSu;
        final /* synthetic */ C32736a eSw;
        final /* synthetic */ C42161e eSz;

        C32739d(C42161e c42161e, C45421f c45421f, C32736a c32736a, C18545a c18545a, C42162f c42162f) {
            this.eSz = c42161e;
            this.eSu = c45421f;
            this.eSw = c32736a;
            this.eSA = c18545a;
            this.eSB = c42162f;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            this.eSw.mo33805a(this.eSB, this.eSz, null, this.eSw);
            return C37091y.AUy;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/loader/task/ImageLoadWorkTask$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.k.a$a */
    public static final class C32740a {
        private C32740a() {
        }

        public /* synthetic */ C32740a(byte b) {
            this();
        }
    }

    public C32736a(C42156a<T> c42156a, C1752c<R> c1752c, C45421f<T, R> c45421f) {
        C25052j.m39376p(c42156a, "_url");
        C25052j.m39376p(c1752c, "target");
        C25052j.m39376p(c45421f, "reaper");
        super(c42156a, c1752c, c45421f);
    }

    /* JADX WARNING: Missing block: B:18:0x006d, code skipped:
            if (r3 == null) goto L_0x006f;
     */
    /* JADX WARNING: Missing block: B:24:0x0082, code skipped:
            if (r2 == null) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Uo */
    private final C42158c<R> m53419Uo() {
        Closeable closeable;
        Throwable th;
        Throwable th2 = null;
        C42158c c42158c = new C42158c();
        C42159a c42159a = C42158c.eRS;
        c42158c.from = C42158c.eRQ;
        try {
            C45421f c45421f = this.eSE;
            C26352d c26352d = this.ePt;
            if (c26352d != null) {
                C42156a c42156a = this.eQE;
                C37878e c37878e = c45421f.eOF;
                C25052j.m39376p(c42156a, "url");
                C25052j.m39376p(c37878e, "opts");
                C25052j.m39376p(c45421f, "reaper");
                C25052j.m39376p(c42156a, "url");
                C25052j.m39376p(c37878e, "opts");
                C25052j.m39376p(c45421f, "reaper");
                C18545a c = c26352d.mo37769c(c42156a, c37878e, c45421f);
                if (c != null) {
                    closeable = c;
                    try {
                        C42161e a;
                        C18545a c18545a = (C18545a) closeable;
                        C32728d c32728d = this.eSq;
                        C42161e a2 = c32728d != null ? c32728d.mo33786a(c45421f.mo73211Tc().eQw, c45421f, c18545a) : null;
                        if (!(a2 instanceof C42161e)) {
                            a2 = null;
                        }
                        if (a2 != null) {
                            C9569a c9569a = c45421f.eOR;
                            if (c9569a != null) {
                                a = c9569a.mo20890a(c45421f.mo73211Tc().eQw, c45421f, a2, C26361b.DECODED);
                            } else {
                                a = null;
                            }
                        }
                        a = a2;
                        if (a != null) {
                            C9569a c9569a2 = c45421f.eOQ;
                            if (c9569a2 != null) {
                                a2 = c9569a2.mo20890a(c45421f.mo73211Tc().eQw, c45421f, a, C26361b.DECODED);
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
                                C9566c c9566c = this.ePs;
                                if (c9566c != null) {
                                    c9566c.mo20874a(c45421f.eOY, c45421f.eOQ, a2.getValue());
                                }
                                c42158c.value = a2.getValue();
                            }
                        }
                        C41372b.m72155a(closeable, null);
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e, "[ImageLoader READ] run error %s [debug info %s]", this.eQE, this.ePa);
        }
        return c42158c;
        C41372b.m72155a(closeable, th2);
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0151 A:{LOOP_START, PHI: r0 , LOOP:2: B:85:0x0151->B:93:0x0165} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0139 A:{LOOP_START, PHI: r0 , LOOP:1: B:76:0x0139->B:84:0x014d} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m53420a(C42162f<?> c42162f, C18557a<R> c18557a) {
        C37878e c37878e;
        Object[] objArr = null;
        C42158c c42158c = new C42158c();
        C42159a c42159a = C42158c.eRS;
        c42158c.from = C42158c.eRR;
        C45421f c45421f = this.eSE;
        if (c42162f != null) {
            C42162f<?> c42162f2;
            if ((c42162f.value() != null ? 1 : 0) != 0) {
                c42162f2 = c42162f;
            } else {
                c42162f2 = null;
            }
            if (c42162f2 != null) {
                C18545a TW = c42162f.mo33800TW();
                if (TW != null) {
                    C42161e c42161e;
                    C32737b c32737b;
                    System.currentTimeMillis();
                    C45421f c45421f2 = this.eSE;
                    C32728d c32728d = this.eSq;
                    C42161e a = c32728d != null ? c32728d.mo33786a(c45421f2.mo73211Tc().eQw, this.eSE, TW) : null;
                    if (a instanceof C42161e) {
                        c42161e = a;
                    } else {
                        c42161e = null;
                    }
                    if (c42161e != null) {
                        C9569a c9569a = c45421f2.eOQ;
                        if (c9569a != null) {
                            int i;
                            C26361b c26361b = C26361b.DOWNLOADED;
                            C25052j.m39376p(c26361b, "when");
                            C31269b c31269b = c9569a.eQG;
                            if (!(c31269b instanceof C31269b)) {
                                c31269b = null;
                            }
                            if (c31269b == null) {
                                c31269b = c9569a.eQG;
                                if (!(c31269b instanceof C31269b)) {
                                    c31269b = null;
                                }
                                if (c31269b != null) {
                                    c31269b = c9569a.eQG;
                                    if (!(c31269b instanceof C31269b)) {
                                        c31269b = null;
                                    }
                                    if (c31269b != null) {
                                        i = 0;
                                    } else {
                                        do {
                                            if (c31269b.eQH == C9570a.LOW && c26361b == c31269b.eQI) {
                                                i = 1;
                                                break;
                                            }
                                            c31269b = c31269b.eQG;
                                            if (!(c31269b instanceof C31269b)) {
                                                c31269b = null;
                                                continue;
                                            }
                                        } while (c31269b != null);
                                        i = 0;
                                    }
                                } else {
                                    do {
                                        if (c31269b.eQH == C9570a.NORMAL && c26361b == c31269b.eQI) {
                                            i = 1;
                                            break;
                                        }
                                        c31269b = c31269b.eQG;
                                        if (!(c31269b instanceof C31269b)) {
                                            c31269b = null;
                                            continue;
                                        }
                                    } while (c31269b != null);
                                    c31269b = c9569a.eQG;
                                    if (c31269b instanceof C31269b) {
                                    }
                                    if (c31269b != null) {
                                    }
                                }
                            } else {
                                do {
                                    if (c31269b.eQH == C9570a.HIGH && c26361b == c31269b.eQI) {
                                        i = 1;
                                        break;
                                    }
                                    c31269b = c31269b.eQG;
                                    if (!(c31269b instanceof C31269b)) {
                                        c31269b = null;
                                        continue;
                                    }
                                } while (c31269b != null);
                                c31269b = c9569a.eQG;
                                if (c31269b instanceof C31269b) {
                                }
                                if (c31269b != null) {
                                }
                            }
                            if (i == 1) {
                                C9569a c9569a2 = c45421f2.eOQ;
                                if (c9569a2 != null) {
                                    C42161e a2 = c9569a2.mo20890a(c45421f2.mo73211Tc().eQw, c45421f2, c42161e, C26361b.DOWNLOADED);
                                    if (a2 != null) {
                                        mo33805a(c42162f, c42161e, a2, this);
                                        c32737b = new C32737b(a2, C18554e.eSC);
                                        if (c32737b != null) {
                                            C37091y c37091y;
                                            c42161e = c32737b.eSs;
                                            if (c42161e != null) {
                                                C8901a c8901a = new C8901a("Transcoder");
                                                c9569a2 = c45421f.eOR;
                                                if (c9569a2 != null) {
                                                    a = c9569a2.mo20890a(c45421f.mo73211Tc().eQw, c45421f, c42161e, C26361b.DECODED);
                                                } else {
                                                    a = null;
                                                }
                                                if (a == null) {
                                                    a = c42161e;
                                                }
                                                C9569a c9569a3 = c45421f.eOQ;
                                                if (c9569a3 != null) {
                                                    a2 = c9569a3.mo20890a(c45421f.mo73211Tc().eQw, c45421f, a, C26361b.DECODED);
                                                } else {
                                                    a2 = null;
                                                }
                                                if (a2 != null) {
                                                    a = a2;
                                                }
                                                c9569a3 = c45421f.eOQ;
                                                if (c9569a3 != null) {
                                                    c9569a3.mo20890a(c45421f.mo73211Tc().eQw, c45421f, a, C26361b.LOADED);
                                                }
                                                c37091y = C37091y.AUy;
                                                c8901a.mo20314SW();
                                                Object value = c42161e.getValue();
                                                c42158c.value = value;
                                                c18557a.mo33808a(c42158c);
                                                if (value != null) {
                                                    C9566c c9566c = this.ePs;
                                                    if (c9566c != null) {
                                                        c9566c.mo20874a(c45421f.eOY, c45421f.eOQ, value);
                                                    }
                                                }
                                            }
                                            C8901a c8901a2 = new C8901a("lazytask commit");
                                            c32737b.eSt.invoke();
                                            c37091y = C37091y.AUy;
                                            c8901a2.mo20314SW();
                                            if (c45421f.eOS != null) {
                                                c37878e = this.eSE.eOF;
                                                if (c37878e != null) {
                                                    objArr = c37878e.mo60618TG();
                                                }
                                                Arrays.copyOf(objArr, objArr.length);
                                                return;
                                            }
                                            return;
                                        }
                                        c42159a = C42158c.eRS;
                                        c42158c.status = C42158c.eRN;
                                        if (c45421f.eOS != null) {
                                            c37878e = this.eSE.eOF;
                                            if (c37878e != null) {
                                                objArr = c37878e.mo60618TG();
                                            }
                                            Arrays.copyOf(objArr, objArr.length);
                                        }
                                        c18557a.mo33807Uq();
                                        return;
                                    }
                                }
                            }
                        }
                        c32737b = new C32737b(c42161e, new C32739d(c42161e, c45421f2, this, TW, c42162f));
                        if (c32737b != null) {
                        }
                    }
                    c32737b = null;
                    if (c32737b != null) {
                    }
                }
            }
        }
        c42159a = C42158c.eRS;
        c42158c.status = C42158c.eRL;
        if (C37878e.DEBUG) {
            C4990ab.m7417i("MicroMsg.Loader.ImageLoadWorkTask", "httpRespone value is null %s %s", this.eQE, C5046bo.dpG().toString());
        }
        if (c45421f.eOS != null) {
            c37878e = this.eSE.eOF;
            if (c37878e != null) {
                objArr = c37878e.mo60618TG();
            }
            Arrays.copyOf(objArr, objArr.length);
        }
        c18557a.mo33807Uq();
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ce A:{Catch:{ Exception -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00b6 A:{Catch:{ Exception -> 0x0192 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo33804a(C37879b c37879b, C18557a<R> c18557a) {
        boolean z = true;
        C25052j.m39376p(c37879b, "fileType");
        C25052j.m39376p(c18557a, "taskListener");
        try {
            boolean z2;
            System.currentTimeMillis();
            C4990ab.m7410d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. key:" + this.eQE + " fileType " + c37879b + " [width:" + this.eOZ + ".weakHolder.viewWidth height:" + this.eOZ + ".weakHolder.viewHeight] diskCache " + this.ePt + " producer " + this.eSq);
            C42158c Uo = m53419Uo();
            if (this.eQE != null) {
                if (C26372a.m41963d(this.eQE)) {
                    z2 = true;
                } else if (this.eSE.eOF.mo60626Ty() == C37879b.FILE) {
                    z2 = true;
                }
                if (z2 || Uo.value != null) {
                    z = false;
                }
                C4990ab.m7410d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + Uo + " bitmap " + Uo.value + " isNeedDownload " + z);
                if (z) {
                    c18557a.mo33809b(Uo);
                    return;
                }
                C45421f c45421f = this.eSE;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    C4990ab.m7410d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from memory failed.now try to get from network. " + this.eQE + " fileType: " + c37879b);
                    if (c45421f.eOI != null) {
                        c45421f.mo73211Tc();
                    }
                    C32725b c32725b = c45421f.eOJ;
                    if (!c45421f.eOO.mo5291a(this.eQE)) {
                        c32725b = null;
                    }
                    if (c32725b == null) {
                        m53420a(null, (C18557a) c18557a);
                        C4990ab.m7416i("MicroMsg.Loader.ImageLoadWorkTask", "can not download image, over limit " + this.eQE);
                        return;
                    }
                    C32725b c32725b2 = c45421f.eOJ;
                    C42156a c42156a = this.eQE;
                    C32733f c32733f = c45421f.eOV;
                    C9576b c9576b = this.eQR;
                    if (c9576b == null) {
                        C25052j.avw("loader");
                    }
                    C26356a c32738c = new C32738c(c45421f, currentTimeMillis, this, c37879b, c18557a);
                    C25052j.m39376p(c42156a, "url");
                    C25052j.m39376p(c32733f, "fileNameCreator");
                    C25052j.m39376p(c9576b, "loader");
                    C25052j.m39376p(c32738c, "callback");
                    c9576b.mo20894u(new C32726c(c32725b2, c9576b, c42156a, c32733f, c32738c));
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e, "[ImageLoader DownLoadException] run error %s [debug info %s]", this.eQE, c45421f.ePa);
                    C37091y c37091y = C37091y.AUy;
                    return;
                }
            }
            z2 = false;
            z = false;
            C4990ab.m7410d("MicroMsg.Loader.ImageLoadWorkTask", "[ImageLoader] run. get bitmap from disk. done result resultData " + Uo + " bitmap " + Uo.value + " isNeedDownload " + z);
            if (z) {
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Loader.ImageLoadWorkTask", e2, "[ImageLoader execute] " + e2.getMessage() + " run error " + this.eQE + " [debug info " + this.ePa + ']', new Object[0]);
            c18557a.mo33807Uq();
        }
    }
}
