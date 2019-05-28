package com.tencent.mm.plugin.appbrand.appusage;

import a.a.t;
import a.a.v;
import a.f.b.j;
import a.l;
import android.os.Looper;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

@l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002()B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J$\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010 \u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010!\u001a\u00020\u00152\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u000eH\u0016J\"\u0010$\u001a\u00020\u00152\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "onRegister", "onUnregister", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "remove", "removeCollection", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
public final class f extends k implements com.tencent.mm.kernel.c.b, af {
    private static f gYV;
    public static final a gYW = new a();
    private final AtomicBoolean gYU = new AtomicBoolean(false);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ f gYX;
        final /* synthetic */ List gYY;
        final /* synthetic */ b gYZ;

        e(f fVar, List list, b bVar) {
            this.gYX = fVar;
            this.gYY = list;
            this.gYZ = bVar;
        }

        public final void run() {
            AppMethodBeat.i(134514);
            List a = f.a(this.gYX);
            if (a == null) {
                a = v.AUP;
            }
            android.support.v7.h.c.b a2 = android.support.v7.h.c.a(new ab(a, this.gYY), true);
            c cVar = (c) g.K(c.class);
            j.o(a2, "diff");
            List m = t.m(a);
            a = this.gYY;
            if (a == null) {
                j.dWJ();
            }
            boolean a3 = cVar.a(a2, m, t.m(a), this.gYZ);
            ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(a3)));
            if (a3) {
                ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).a(LocalUsageInfo.class, this.gYY, null);
            }
            this.gYX.gYU.set(false);
            ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
            b bVar = this.gYZ;
            if (bVar != null) {
                bVar.axa();
                AppMethodBeat.o(134514);
                return;
            }
            AppMethodBeat.o(134514);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onReorderEnd", "", "plugin-appbrand-integration_release"})
    public static final class d extends b {
        d() {
        }

        public final void axa() {
            AppMethodBeat.i(134513);
            ((c) g.K(c.class)).a(com.tencent.mm.plugin.appbrand.appusage.z.b.Timeout);
            AppMethodBeat.o(134513);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$Companion;", "", "()V", "STORAGE", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "getSTORAGE", "()Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "setSTORAGE", "(Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;)V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onReorderEnd", "", "plugin-appbrand-integration_release"})
    public static final class c extends b {
        c() {
        }

        public final void axa() {
            AppMethodBeat.i(134512);
            ((c) g.K(c.class)).a(com.tencent.mm.plugin.appbrand.appusage.z.b.ClosePullDown);
            AppMethodBeat.o(134512);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
    public static class b implements com.tencent.mm.plugin.appbrand.appusage.c.b {
        public void b(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(134509);
            j.p(localUsageInfo, "info");
            AppMethodBeat.o(134509);
        }

        public final void c(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(134510);
            j.p(localUsageInfo, "info");
            AppMethodBeat.o(134510);
        }

        public void d(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.i(134511);
            j.p(localUsageInfo, "info");
            AppMethodBeat.o(134511);
        }

        public void axa() {
        }
    }

    static {
        AppMethodBeat.i(134529);
        AppMethodBeat.o(134529);
    }

    public f() {
        AppMethodBeat.i(134528);
        AppMethodBeat.o(134528);
    }

    public final void SH() {
        gYV = this;
    }

    public final void SI() {
        gYV = null;
    }

    public final void awX() {
        AppMethodBeat.i(134515);
        if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
            if (this.gYU.get()) {
                ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
                AppMethodBeat.o(134515);
                return;
            }
            ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
            j.axh().a(bo.anU(), true, null, 6, 0);
        }
        h.b(com.tencent.mm.plugin.appbrand.task.g.WASERVICE);
        h.b(com.tencent.mm.plugin.appbrand.task.g.WAGAME);
        AppMethodBeat.o(134515);
    }

    public final boolean aB(String str, int i) {
        Object obj;
        AppMethodBeat.i(134516);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(134516);
            return false;
        }
        s sVar = (s) com.tencent.mm.plugin.appbrand.app.f.E(s.class);
        if (str == null) {
            j.dWJ();
        }
        boolean aF = sVar.aF(str, i);
        AppMethodBeat.o(134516);
        return aF;
    }

    public final int aC(String str, int i) {
        AppMethodBeat.i(134517);
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            AppMethodBeat.o(134517);
            return -1;
        }
        s sVar = (s) com.tencent.mm.plugin.appbrand.app.f.E(s.class);
        if (str == null) {
            j.dWJ();
        }
        int aG = sVar.aG(str, i);
        AppMethodBeat.o(134517);
        return aG;
    }

    public final boolean aD(String str, int i) {
        Object obj;
        AppMethodBeat.i(134518);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(134518);
            return false;
        }
        s sVar = (s) com.tencent.mm.plugin.appbrand.app.f.E(s.class);
        if (str == null) {
            j.dWJ();
        }
        boolean aH = sVar.aH(str, i);
        AppMethodBeat.o(134518);
        return aH;
    }

    public final boolean a(List<? extends LocalUsageInfo> list, b bVar) {
        AppMethodBeat.i(134519);
        if (list == null) {
            if (bp.dpL()) {
                Assert.assertTrue("reorderList is NULL", false);
            } else {
                AppMethodBeat.o(134519);
                return false;
            }
        }
        this.gYU.set(true);
        Runnable eVar = new e(this, list, bVar);
        if (al.isMainThread()) {
            m.aNS().aa(eVar);
        } else {
            eVar.run();
        }
        AppMethodBeat.o(134519);
        return true;
    }

    public final boolean g(List<LocalUsageInfo> list, int i) {
        b dVar;
        AppMethodBeat.i(134521);
        ab.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = ".concat(String.valueOf(i)));
        switch (i) {
            case 0:
                dVar = new d();
                break;
            case 1:
                dVar = new c();
                break;
            default:
                dVar = null;
                break;
        }
        boolean a = a((List) list, dVar);
        AppMethodBeat.o(134521);
        return a;
    }

    public final List<? extends LocalUsageInfo> a(int i, com.tencent.mm.plugin.appbrand.appusage.af.a aVar) {
        AppMethodBeat.i(134522);
        if (i <= 0) {
            AppMethodBeat.o(134522);
            return null;
        }
        List<? extends LocalUsageInfo> b = ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).b(i, aVar);
        AppMethodBeat.o(134522);
        return b;
    }

    public final int getCount() {
        AppMethodBeat.i(134523);
        Object E = com.tencent.mm.plugin.appbrand.app.f.E(s.class);
        j.o(E, "SubCoreAppBrand.getStora…arAppStorage::class.java)");
        int axF = ((s) E).axF();
        AppMethodBeat.o(134523);
        return axF;
    }

    public final int awY() {
        AppMethodBeat.i(134524);
        int axI = t.axI();
        AppMethodBeat.o(134524);
        return axI;
    }

    public final void c(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(134525);
        a(aVar, Looper.getMainLooper());
        AppMethodBeat.o(134525);
    }

    public final void a(com.tencent.mm.sdk.e.k.a aVar, Looper looper) {
        AppMethodBeat.i(134526);
        ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).a(aVar, looper);
        com.tencent.mm.plugin.appbrand.app.f.auO().a(aVar, looper);
        AppMethodBeat.o(134526);
    }

    public final void d(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(134527);
        ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).d(aVar);
        com.tencent.mm.plugin.appbrand.app.f.auO().d(aVar);
        AppMethodBeat.o(134527);
    }

    public static final /* synthetic */ List a(f fVar) {
        AppMethodBeat.i(134530);
        List a = fVar.a((int) BaseClientBuilder.API_PRIORITY_OTHER, com.tencent.mm.plugin.appbrand.appusage.af.a.DESC);
        AppMethodBeat.o(134530);
        return a;
    }
}
