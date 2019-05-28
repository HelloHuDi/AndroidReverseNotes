package com.tencent.mm.loader.e.b;

import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
import com.tencent.mm.loader.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ)\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\r\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\u000b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012J \u0010\u0013\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005R*\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "", "Lcom/tencent/mm/loader/model/data/DataItem;", "clean", "", "dispatch", "R", "target", "resource", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;)V", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "Companion", "libimageloader_release"})
public final class d {
    public static final String TAG = TAG;
    public static final a eQA = new a();
    private static final f eQz = i.g(b.eQC);
    public ConcurrentHashMap<c<Object>, Collection<com.tencent.mm.loader.h.a.a<?>>> map;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, dWq = {"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
    public static final class a {
        static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(a.class), "instance", "getInstance()Lcom/tencent/mm/loader/impr/target/TargetCenter;"))};

        public static d TN() {
            return (d) d.eQz.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<d> {
        public static final b eQC = new b();

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            return new d();
        }
    }

    private d() {
        this.map = new ConcurrentHashMap();
    }

    public /* synthetic */ d(byte b) {
        this();
    }

    public final void a(c<Object> cVar) {
        j.p(cVar, "target");
        ab.i(TAG, "unregister ".concat(String.valueOf(cVar)));
        this.map.remove(cVar);
    }

    public final <R> void a(com.tencent.mm.loader.h.a.a<?> aVar, c<R> cVar) {
        j.p(aVar, "data");
        j.p(cVar, "result");
        Map map = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            if (((Collection) entry.getValue()).contains(aVar)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (c cVar2 : linkedHashMap.keySet()) {
            Object obj = cVar.value;
            if (obj != null) {
                ab.i(TAG, "dispatch " + cVar2 + " resource " + obj);
                if (obj == null) {
                    try {
                        throw new a.v("null cannot be cast to non-null type kotlin.Any");
                    } catch (Exception e) {
                        ab.i(TAG, "exception " + e.getMessage());
                    } finally {
                        a(cVar2);
                    }
                } else {
                    cVar2.aP(obj);
                    a(cVar2);
                }
            }
        }
    }
}
