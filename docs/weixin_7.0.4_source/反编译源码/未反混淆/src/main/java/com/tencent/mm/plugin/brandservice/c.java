package com.tencent.mm.plugin.brandservice;

import a.a.i;
import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.s;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J$\u0010!\u001a\u00020\u00122\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J$\u0010$\u001a\u00020\u00122\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180#2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J8\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0016J@\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "bizNativeVideoOpen", "", "getBizNativeVideoOpen", "()Ljava/lang/Boolean;", "setBizNativeVideoOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "preloadLimiter", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPreloadLimiter", "()Ljava/util/HashSet;", "addToPreload", "", "url", "itemShowType", "", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "canPreloadIn", "getHardCodeUrl", "isBizNativeVideoOpen", "isBizTimeLineOpen", "isMpUrl", "preCreateWebView", "preloadByIdAndUrls", "items", "", "preloadByInfoIdAndBuffer", "startPreloadWebView", "context", "Landroid/content/Context;", "subScene", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "plugin-brandservice_release"})
public final class c implements com.tencent.mm.plugin.brandservice.a.b {
    private final String TAG = "MicroMsg.BrandServiceImpl";
    private Boolean jKg;
    private final HashSet<String> jKh = new HashSet();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int jKl;
        final /* synthetic */ List jKn;

        b(List list, int i) {
            this.jKn = list;
            this.jKl = i;
        }

        public final void run() {
            AppMethodBeat.i(14763);
            PreloadLogic.i(this.jKn, this.jKl);
            AppMethodBeat.o(14763);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ int jKl = 0;
        final /* synthetic */ List jKn;

        c(List list) {
            this.jKn = list;
        }

        public final void run() {
            AppMethodBeat.i(14764);
            PreloadLogic.j(this.jKn, this.jKl);
            AppMethodBeat.o(14764);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ long jKi;
        final /* synthetic */ String jKj;
        final /* synthetic */ int jKk;
        final /* synthetic */ int jKl;
        final /* synthetic */ Object[] jKm;

        a(long j, String str, int i, int i2, Object[] objArr) {
            this.jKi = j;
            this.jKj = str;
            this.jKk = i;
            this.jKl = i2;
            this.jKm = objArr;
        }

        public final void run() {
            AppMethodBeat.i(14762);
            long j = this.jKi;
            String bc = bo.bc(this.jKj, "");
            j.o(bc, "Util.nullAs(url, \"\")");
            int i = this.jKk;
            int i2 = this.jKl;
            Object[] objArr = this.jKm;
            PreloadLogic.a(j, bc, i, i2, Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.o(14762);
        }
    }

    public c() {
        AppMethodBeat.i(14777);
        AppMethodBeat.o(14777);
    }

    public final boolean FC(String str) {
        AppMethodBeat.i(14765);
        if (str != null) {
            boolean FC = m.FC(str);
            AppMethodBeat.o(14765);
            return FC;
        }
        AppMethodBeat.o(14765);
        return false;
    }

    public final boolean aVO() {
        AppMethodBeat.i(14766);
        boolean aVO = s.aVO();
        AppMethodBeat.o(14766);
        return aVO;
    }

    public final boolean aVP() {
        AppMethodBeat.i(14767);
        if (f.IS_FLAVOR_RED || f.DEBUG) {
            AppMethodBeat.o(14767);
            return true;
        }
        if (this.jKg == null) {
            boolean z;
            if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_open_biz_native_video, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.jKg = Boolean.valueOf(z);
            ab.i(this.TAG, "bizNativeVideoOpen: " + this.jKg);
        }
        Boolean bool = this.jKg;
        if (bool == null) {
            j.dWJ();
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(14767);
        return booleanValue;
    }

    public final void a(String str, int i, int i2, Object... objArr) {
        String str2;
        AppMethodBeat.i(14768);
        j.p(objArr, "vals");
        StringBuilder stringBuilder = new StringBuilder("addToPreload_");
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        stringBuilder = stringBuilder.append(str2).append('_');
        Object M = i.M(objArr);
        if (M == null) {
            M = "";
        }
        str2 = stringBuilder.append(M).toString();
        if (this.jKh.contains(str2)) {
            AppMethodBeat.o(14768);
            return;
        }
        this.jKh.add(str2);
        d.xDG.b(new a(System.currentTimeMillis(), str, i, i2, objArr), "tmplPreload");
        AppMethodBeat.o(14768);
    }

    public final void i(List<? extends List<String>> list, int i) {
        AppMethodBeat.i(14769);
        j.p(list, "items");
        d.xDG.b(new b(list, i), "tmplPreload");
        AppMethodBeat.o(14769);
    }

    public final void aU(List<String[]> list) {
        AppMethodBeat.i(14770);
        j.p(list, "items");
        d.xDG.b(new c(list), "tmplPreload");
        AppMethodBeat.o(14770);
    }

    public final boolean rW(int i) {
        AppMethodBeat.i(14771);
        boolean rW = PreloadLogic.rW(i);
        AppMethodBeat.o(14771);
        return rW;
    }

    public final boolean a(Context context, String str, int i, int i2, int i3, Intent intent) {
        AppMethodBeat.i(14772);
        j.p(context, "context");
        j.p(str, "url");
        j.p(intent, "intent");
        boolean a = PreloadLogic.a(context, str, i, i2, i3, intent, 0, null, az.CTRL_INDEX);
        AppMethodBeat.o(14772);
        return a;
    }

    public final boolean a(Context context, String str, int i, int i2, int i3, com.tencent.mm.plugin.brandservice.a.b.a aVar) {
        AppMethodBeat.i(14773);
        j.p(context, "context");
        j.p(str, "url");
        j.p(aVar, "result");
        boolean a = PreloadLogic.a(context, str, i, i2, 0, null, i3, aVar, 32);
        AppMethodBeat.o(14773);
        return a;
    }

    public final void rX(int i) {
        AppMethodBeat.i(14774);
        PreloadLogic.mg(i);
        AppMethodBeat.o(14774);
    }

    public final String aVQ() {
        AppMethodBeat.i(14775);
        String aXB = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.aXB();
        AppMethodBeat.o(14775);
        return aXB;
    }

    public final void aVR() {
        AppMethodBeat.i(14776);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c.aVR();
        AppMethodBeat.o(14776);
    }
}
