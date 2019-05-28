package com.tencent.p177mm.loader.p246e.p247b;

import com.tencent.p177mm.loader.p1197h.C42158c;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ)\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\u000b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012J \u0010\u0013\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005R*\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "", "Lcom/tencent/mm/loader/model/data/DataItem;", "clean", "", "dispatch", "R", "target", "resource", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;)V", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "Companion", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.e.b.d */
public final class C1754d {
    public static final String TAG = TAG;
    public static final C1755a eQA = new C1755a();
    private static final C44856f eQz = C17344i.m26854g(C1756b.eQC);
    public ConcurrentHashMap<C1752c<Object>, Collection<C42156a<?>>> map;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, dWq = {"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.e.b.d$a */
    public static final class C1755a {
        static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C1755a.class), "instance", "getInstance()Lcom/tencent/mm/loader/impr/target/TargetCenter;"))};

        /* renamed from: TN */
        public static C1754d m3619TN() {
            return (C1754d) C1754d.eQz.getValue();
        }

        private C1755a() {
        }

        public /* synthetic */ C1755a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
    /* renamed from: com.tencent.mm.loader.e.b.d$b */
    static final class C1756b extends C25053k implements C31214a<C1754d> {
        public static final C1756b eQC = new C1756b();

        C1756b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            return new C1754d();
        }
    }

    private C1754d() {
        this.map = new ConcurrentHashMap();
    }

    public /* synthetic */ C1754d(byte b) {
        this();
    }

    /* renamed from: a */
    public final void mo5289a(C1752c<Object> c1752c) {
        C25052j.m39376p(c1752c, "target");
        C4990ab.m7416i(TAG, "unregister ".concat(String.valueOf(c1752c)));
        this.map.remove(c1752c);
    }

    /* renamed from: a */
    public final <R> void mo5290a(C42156a<?> c42156a, C42158c<R> c42158c) {
        C25052j.m39376p(c42156a, "data");
        C25052j.m39376p(c42158c, "result");
        Map map = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            if (((Collection) entry.getValue()).contains(c42156a)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (C1752c c1752c : linkedHashMap.keySet()) {
            Object obj = c42158c.value;
            if (obj != null) {
                C4990ab.m7416i(TAG, "dispatch " + c1752c + " resource " + obj);
                if (obj == null) {
                    try {
                        throw new C44941v("null cannot be cast to non-null type kotlin.Any");
                    } catch (Exception e) {
                        C4990ab.m7416i(TAG, "exception " + e.getMessage());
                    } finally {
                        mo5289a(c1752c);
                    }
                } else {
                    c1752c.mo5287aP(obj);
                    mo5289a(c1752c);
                }
            }
        }
    }
}
