package com.tencent.p177mm.plugin.appbrand.game.p291a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44847aa;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p000a.p051k.C16500s;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\r\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.a.c */
public final class C38213c extends C26881g<Float> {
    private static final String TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C38213c.class), "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas()F")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C38213c.class), "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas()F")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C38213c.class), "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio()F"))};
    private static Float hqC;
    private static final C44856f hqD = C17344i.m26854g(C19218b.hqJ);
    private static final C44856f hqE = C17344i.m26854g(C19217a.hqI);
    private static final C44856f hqF = C17344i.m26854g(C19219c.hqK);
    private static MemoryInfo hqG;
    public static final C38213c hqH = new C38213c();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.c$a */
    static final class C19217a extends C25053k implements C31214a<Float> {
        public static final C19217a hqI = new C19217a();

        static {
            AppMethodBeat.m2504i(134607);
            AppMethodBeat.m2505o(134607);
        }

        C19217a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134606);
            float a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54610a(C11745a.clicfg_magicbrush_autogcfactor_max_canvas, 600.0f);
            C38213c c38213c = C38213c.hqH;
            C45124d.m82929i(C38213c.TAG, "clicfg_magicbrush_autogcfactor_max_canvas ".concat(String.valueOf(a)));
            Float valueOf = Float.valueOf(a);
            AppMethodBeat.m2505o(134606);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.c$b */
    static final class C19218b extends C25053k implements C31214a<Float> {
        public static final C19218b hqJ = new C19218b();

        static {
            AppMethodBeat.m2504i(134609);
            AppMethodBeat.m2505o(134609);
        }

        C19218b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134608);
            float a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54610a(C11745a.clicfg_magicbrush_autogcfactor_min_canvas, 100.0f);
            C38213c c38213c = C38213c.hqH;
            C45124d.m82929i(C38213c.TAG, "clicfg_magicbrush_autogcfactor_min_canvas ".concat(String.valueOf(a)));
            Float valueOf = Float.valueOf(a);
            AppMethodBeat.m2505o(134608);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.game.a.c$c */
    static final class C19219c extends C25053k implements C31214a<Float> {
        public static final C19219c hqK = new C19219c();

        static {
            AppMethodBeat.m2504i(134611);
            AppMethodBeat.m2505o(134611);
        }

        C19219c() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134610);
            float a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54610a(C11745a.clicfg_magicbrush_autogcfactor_total_memory_ratio, 0.33f);
            C38213c c38213c = C38213c.hqH;
            C45124d.m82929i(C38213c.TAG, "clicfg_magicbrush_autogcfactor_total_memory_ratio ".concat(String.valueOf(a)));
            Float valueOf = Float.valueOf(a);
            AppMethodBeat.m2505o(134610);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.m2504i(134612);
        StringBuilder stringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
        String processName = C4996ah.getProcessName();
        C25052j.m39375o(processName, "MMApplicationContext.getProcessName()");
        TAG = stringBuilder.append(C6163u.m9838i(processName, "com.tencent.mm", "", false)).toString();
        AppMethodBeat.m2505o(134612);
    }

    private C38213c() {
    }

    /* Access modifiers changed, original: protected|final */
    public final C11745a aAz() {
        return C11745a.clicfg_magicbrush_gcfactor;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aAy() {
        return "gcfactor";
    }

    /* renamed from: cD */
    public final float mo60949cD(Context context) {
        AppMethodBeat.m2504i(134616);
        C25052j.m39376p(context, "context");
        Float f;
        float floatValue;
        if (hqC != null) {
            f = hqC;
            if (f == null) {
                C25052j.dWJ();
            }
            floatValue = f.floatValue();
            AppMethodBeat.m2505o(134616);
            return floatValue;
        }
        floatValue = ((Number) super.mo21639Uw()).floatValue();
        if (floatValue != -1.0f) {
            C45124d.m82929i(TAG, "rawConfig == [" + floatValue + "] != -1, just return");
            hqC = Float.valueOf(floatValue);
            AppMethodBeat.m2505o(134616);
            return floatValue;
        }
        Resources resources = context.getResources();
        C25052j.m39375o(resources, "context.resources");
        floatValue = resources.getDisplayMetrics().density;
        Resources resources2 = context.getResources();
        C25052j.m39375o(resources2, "context.resources");
        float f2 = ((float) resources2.getDisplayMetrics().widthPixels) / floatValue;
        Resources resources3 = context.getResources();
        C25052j.m39375o(resources3, "context.resources");
        f2 = 2.0f * (((((float) resources3.getDisplayMetrics().heightPixels) / floatValue) * f2) * 4.0f);
        Object obj = f2 > 0.0f ? 1 : null;
        if (C44847aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.m2505o(134616);
            throw assertionError;
        }
        if (hqG == null) {
            obj = context.getSystemService("activity");
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.ActivityManager");
                AppMethodBeat.m2505o(134616);
                throw c44941v;
            }
            ActivityManager activityManager = (ActivityManager) obj;
            hqG = new MemoryInfo();
            activityManager.getMemoryInfo(hqG);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("getAvailableMemory avail = [");
            MemoryInfo memoryInfo = hqG;
            if (memoryInfo == null) {
                C25052j.dWJ();
            }
            stringBuilder = stringBuilder.append(memoryInfo.availMem).append("] total = [");
            memoryInfo = hqG;
            if (memoryInfo == null) {
                C25052j.dWJ();
            }
            C45124d.m82929i(str, stringBuilder.append(memoryInfo.totalMem).append(']').toString());
        }
        MemoryInfo memoryInfo2 = hqG;
        if (memoryInfo2 == null) {
            C25052j.dWJ();
        }
        long floatValue2 = (long) (((Number) hqF.getValue()).floatValue() * ((float) memoryInfo2.totalMem));
        floatValue = Math.min(((Number) hqE.getValue()).floatValue(), Math.max(((Number) hqD.getValue()).floatValue(), ((float) floatValue2) / f2));
        float f3 = 6.7108864E7f / (floatValue * f2);
        C45124d.m82929i(TAG, "calculate gc_factor automatically unit = [" + (f2 / 1024.0f) + "]kb limit = [65536]kb system = [" + (floatValue2 / 1024) + "]kb raw = [" + floatValue + ':' + (((float) floatValue2) / f2) + "] actually = [" + f3 + ']');
        f = Float.valueOf(f3);
        hqC = f;
        if (f == null) {
            C25052j.dWJ();
        }
        floatValue = f.floatValue();
        AppMethodBeat.m2505o(134616);
        return floatValue;
    }

    public final /* synthetic */ Object aAB() {
        AppMethodBeat.m2504i(134613);
        Float valueOf = Float.valueOf(0.0f);
        AppMethodBeat.m2505o(134613);
        return valueOf;
    }

    /* renamed from: Ap */
    public final /* synthetic */ Object mo21635Ap(String str) {
        Float f;
        AppMethodBeat.m2504i(134614);
        if (str == null) {
            f = null;
        } else {
            f = C16500s.aww(str);
        }
        if (f != null) {
            float floatValue = f.floatValue();
            if ((floatValue >= 0.0f || floatValue == -1.0f) && floatValue <= 1.0f) {
                Object valueOf = Float.valueOf(floatValue);
                AppMethodBeat.m2505o(134614);
                return valueOf;
            }
            AppMethodBeat.m2505o(134614);
            return null;
        }
        AppMethodBeat.m2505o(134614);
        return null;
    }

    /* renamed from: Uw */
    public final /* synthetic */ Object mo21639Uw() {
        AppMethodBeat.m2504i(134615);
        Throwable illegalStateException = new IllegalStateException("Code should not reach.");
        AppMethodBeat.m2505o(134615);
        throw illegalStateException;
    }
}
