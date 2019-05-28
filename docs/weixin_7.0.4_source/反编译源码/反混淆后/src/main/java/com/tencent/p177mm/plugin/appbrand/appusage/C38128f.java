package com.tencent.p177mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.support.p069v7.p075h.C0595c;
import android.support.p069v7.p075h.C0595c.C0601b;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1695b;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10120c.C10122b;
import com.tencent.p177mm.plugin.appbrand.appusage.C10134z.C10133b;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.task.C38519g;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import p000a.C0220l;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002()B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0002J$\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010 \u001a\u00020\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J \u0010!\u001a\u00020\u00152\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u000eH\u0016J\"\u0010$\u001a\u00020\u00152\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "Lcom/tencent/mm/sdk/storage/MStorage;", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "mCalculatingDiff", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "listener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "looper", "Landroid/os/Looper;", "addCollection", "", "username", "", "versionType", "getCount", "getCountLimit", "isCollection", "", "onRegister", "onUnregister", "query", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "count", "order", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandCollectionStorage$ORDER;", "refreshOnPullDownOpen", "remove", "removeCollection", "reorder", "reorderList", "reason", "reorderWithCallback", "", "callback", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Companion", "ReorderCallback", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.f */
public final class C38128f extends C7296k implements C1695b, C10118af {
    private static C38128f gYV;
    public static final C38126a gYW = new C38126a();
    private final AtomicBoolean gYU = new AtomicBoolean(false);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.f$e */
    static final class C10127e implements Runnable {
        final /* synthetic */ C38128f gYX;
        final /* synthetic */ List gYY;
        final /* synthetic */ C38129b gYZ;

        C10127e(C38128f c38128f, List list, C38129b c38129b) {
            this.gYX = c38128f;
            this.gYY = list;
            this.gYZ = c38129b;
        }

        public final void run() {
            AppMethodBeat.m2504i(134514);
            List a = C38128f.m64506a(this.gYX);
            if (a == null) {
                a = C17115v.AUP;
            }
            C0601b a2 = C0595c.m1289a(new C33107ab(a, this.gYY), true);
            C10120c c10120c = (C10120c) C1720g.m3528K(C10120c.class);
            C25052j.m39375o(a2, "diff");
            List m = C25035t.m39352m(a);
            a = this.gYY;
            if (a == null) {
                C25052j.dWJ();
            }
            boolean a3 = c10120c.mo21480a(a2, m, C25035t.m39352m(a), this.gYZ);
            C4990ab.m7416i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, changed = ".concat(String.valueOf(a3)));
            if (a3) {
                ((C26779s) C42340f.m74878E(C26779s.class)).mo44550a(LocalUsageInfo.class, this.gYY, null);
            }
            this.gYX.gYU.set(false);
            C4990ab.m7416i("MicroMsg.AppBrandCollectionStorageExport[collection]", "[collection] reorderWithCallback, before run callback");
            C38129b c38129b = this.gYZ;
            if (c38129b != null) {
                c38129b.axa();
                AppMethodBeat.m2505o(134514);
                return;
            }
            AppMethodBeat.m2505o(134514);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$2", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onReorderEnd", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.f$d */
    public static final class C33109d extends C38129b {
        C33109d() {
        }

        public final void axa() {
            AppMethodBeat.m2504i(134513);
            ((C10120c) C1720g.m3528K(C10120c.class)).mo21478a(C10133b.Timeout);
            AppMethodBeat.m2505o(134513);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$Companion;", "", "()V", "STORAGE", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "getSTORAGE", "()Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;", "setSTORAGE", "(Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport;)V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.f$a */
    public static final class C38126a {
        private C38126a() {
        }

        public /* synthetic */ C38126a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$reorder$callback$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onReorderEnd", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.f$c */
    public static final class C38127c extends C38129b {
        C38127c() {
        }

        public final void axa() {
            AppMethodBeat.m2504i(134512);
            ((C10120c) C1720g.m3528K(C10120c.class)).mo21478a(C10133b.ClosePullDown);
            AppMethodBeat.m2505o(134512);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionModifyQueue$OnModifiedCallback;", "()V", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onMoved", "prev", "next", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.f$b */
    public static class C38129b implements C10122b {
        /* renamed from: b */
        public void mo21481b(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.m2504i(134509);
            C25052j.m39376p(localUsageInfo, "info");
            AppMethodBeat.m2505o(134509);
        }

        /* renamed from: c */
        public final void mo21482c(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.m2504i(134510);
            C25052j.m39376p(localUsageInfo, "info");
            AppMethodBeat.m2505o(134510);
        }

        /* renamed from: d */
        public void mo21483d(LocalUsageInfo localUsageInfo) {
            AppMethodBeat.m2504i(134511);
            C25052j.m39376p(localUsageInfo, "info");
            AppMethodBeat.m2505o(134511);
        }

        public void axa() {
        }
    }

    static {
        AppMethodBeat.m2504i(134529);
        AppMethodBeat.m2505o(134529);
    }

    public C38128f() {
        AppMethodBeat.m2504i(134528);
        AppMethodBeat.m2505o(134528);
    }

    /* renamed from: SH */
    public final void mo5202SH() {
        gYV = this;
    }

    /* renamed from: SI */
    public final void mo5203SI() {
        gYV = null;
    }

    public final void awX() {
        AppMethodBeat.m2504i(134515);
        if (C5058f.IS_FLAVOR_RED) {
            if (this.gYU.get()) {
                C4990ab.m7416i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
                AppMethodBeat.m2505o(134515);
                return;
            }
            C4990ab.m7416i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
            C26769j.axh().mo44541a(C5046bo.anU(), true, null, 6, 0);
        }
        C45694h.m84420b(C38519g.WASERVICE);
        C45694h.m84420b(C38519g.WAGAME);
        AppMethodBeat.m2505o(134515);
    }

    /* renamed from: aB */
    public final boolean mo21471aB(String str, int i) {
        Object obj;
        AppMethodBeat.m2504i(134516);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(134516);
            return false;
        }
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        if (str == null) {
            C25052j.dWJ();
        }
        boolean aF = c26779s.mo44551aF(str, i);
        AppMethodBeat.m2505o(134516);
        return aF;
    }

    /* renamed from: aC */
    public final int mo21472aC(String str, int i) {
        AppMethodBeat.m2504i(134517);
        CharSequence charSequence = str;
        Object obj = (charSequence == null || charSequence.length() == 0) ? 1 : null;
        if (obj != null) {
            AppMethodBeat.m2505o(134517);
            return -1;
        }
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        if (str == null) {
            C25052j.dWJ();
        }
        int aG = c26779s.mo44552aG(str, i);
        AppMethodBeat.m2505o(134517);
        return aG;
    }

    /* renamed from: aD */
    public final boolean mo21473aD(String str, int i) {
        Object obj;
        AppMethodBeat.m2504i(134518);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(134518);
            return false;
        }
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        if (str == null) {
            C25052j.dWJ();
        }
        boolean aH = c26779s.mo44553aH(str, i);
        AppMethodBeat.m2505o(134518);
        return aH;
    }

    /* renamed from: a */
    public final boolean mo60875a(List<? extends LocalUsageInfo> list, C38129b c38129b) {
        AppMethodBeat.m2504i(134519);
        if (list == null) {
            if (C5047bp.dpL()) {
                Assert.assertTrue("reorderList is NULL", false);
            } else {
                AppMethodBeat.m2505o(134519);
                return false;
            }
        }
        this.gYU.set(true);
        Runnable c10127e = new C10127e(this, list, c38129b);
        if (C5004al.isMainThread()) {
            C45673m.aNS().mo10302aa(c10127e);
        } else {
            c10127e.run();
        }
        AppMethodBeat.m2505o(134519);
        return true;
    }

    /* renamed from: g */
    public final boolean mo21476g(List<LocalUsageInfo> list, int i) {
        C38129b c33109d;
        AppMethodBeat.m2504i(134521);
        C4990ab.m7416i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = ".concat(String.valueOf(i)));
        switch (i) {
            case 0:
                c33109d = new C33109d();
                break;
            case 1:
                c33109d = new C38127c();
                break;
            default:
                c33109d = null;
                break;
        }
        boolean a = mo60875a((List) list, c33109d);
        AppMethodBeat.m2505o(134521);
        return a;
    }

    /* renamed from: a */
    public final List<? extends LocalUsageInfo> mo21470a(int i, C10117a c10117a) {
        AppMethodBeat.m2504i(134522);
        if (i <= 0) {
            AppMethodBeat.m2505o(134522);
            return null;
        }
        List<? extends LocalUsageInfo> b = ((C26779s) C42340f.m74878E(C26779s.class)).mo44555b(i, c10117a);
        AppMethodBeat.m2505o(134522);
        return b;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(134523);
        Object E = C42340f.m74878E(C26779s.class);
        C25052j.m39375o(E, "SubCoreAppBrand.getStora…arAppStorage::class.java)");
        int axF = ((C26779s) E).axF();
        AppMethodBeat.m2505o(134523);
        return axF;
    }

    public final int awY() {
        AppMethodBeat.m2504i(134524);
        int axI = C26783t.axI();
        AppMethodBeat.m2505o(134524);
        return axI;
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(134525);
        mo10114a(c4931a, Looper.getMainLooper());
        AppMethodBeat.m2505o(134525);
    }

    /* renamed from: a */
    public final void mo10114a(C4931a c4931a, Looper looper) {
        AppMethodBeat.m2504i(134526);
        ((C26779s) C42340f.m74878E(C26779s.class)).mo10114a(c4931a, looper);
        C42340f.auO().mo10114a(c4931a, looper);
        AppMethodBeat.m2505o(134526);
    }

    /* renamed from: d */
    public final void mo10117d(C4931a c4931a) {
        AppMethodBeat.m2504i(134527);
        ((C26779s) C42340f.m74878E(C26779s.class)).mo10117d(c4931a);
        C42340f.auO().mo10117d(c4931a);
        AppMethodBeat.m2505o(134527);
    }

    /* renamed from: a */
    public static final /* synthetic */ List m64506a(C38128f c38128f) {
        AppMethodBeat.m2504i(134530);
        List a = c38128f.mo21470a((int) BaseClientBuilder.API_PRIORITY_OTHER, C10117a.DESC);
        AppMethodBeat.m2505o(134530);
        return a;
    }
}
