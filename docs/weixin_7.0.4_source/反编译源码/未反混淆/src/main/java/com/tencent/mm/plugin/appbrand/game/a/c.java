package com.tencent.mm.plugin.appbrand.game.a;

import a.aa;
import a.f;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.k.s;
import a.k.u;
import a.l;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ah;

@l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\r\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class c extends g<Float> {
    private static final String TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(c.class), "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas()F")), v.a(new t(v.aN(c.class), "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas()F")), v.a(new t(v.aN(c.class), "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio()F"))};
    private static Float hqC;
    private static final f hqD = i.g(b.hqJ);
    private static final f hqE = i.g(a.hqI);
    private static final f hqF = i.g(c.hqK);
    private static MemoryInfo hqG;
    public static final c hqH = new c();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<Float> {
        public static final a hqI = new a();

        static {
            AppMethodBeat.i(134607);
            AppMethodBeat.o(134607);
        }

        a() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134606);
            float a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_magicbrush_autogcfactor_max_canvas, 600.0f);
            c cVar = c.hqH;
            d.i(c.TAG, "clicfg_magicbrush_autogcfactor_max_canvas ".concat(String.valueOf(a)));
            Float valueOf = Float.valueOf(a);
            AppMethodBeat.o(134606);
            return valueOf;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class b extends a.f.b.k implements a.f.a.a<Float> {
        public static final b hqJ = new b();

        static {
            AppMethodBeat.i(134609);
            AppMethodBeat.o(134609);
        }

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134608);
            float a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_magicbrush_autogcfactor_min_canvas, 100.0f);
            c cVar = c.hqH;
            d.i(c.TAG, "clicfg_magicbrush_autogcfactor_min_canvas ".concat(String.valueOf(a)));
            Float valueOf = Float.valueOf(a);
            AppMethodBeat.o(134608);
            return valueOf;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<Float> {
        public static final c hqK = new c();

        static {
            AppMethodBeat.i(134611);
            AppMethodBeat.o(134611);
        }

        c() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134610);
            float a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_magicbrush_autogcfactor_total_memory_ratio, 0.33f);
            c cVar = c.hqH;
            d.i(c.TAG, "clicfg_magicbrush_autogcfactor_total_memory_ratio ".concat(String.valueOf(a)));
            Float valueOf = Float.valueOf(a);
            AppMethodBeat.o(134610);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(134612);
        StringBuilder stringBuilder = new StringBuilder("MicroMsg.WAGameGcFactor");
        String processName = ah.getProcessName();
        j.o(processName, "MMApplicationContext.getProcessName()");
        TAG = stringBuilder.append(u.i(processName, "com.tencent.mm", "", false)).toString();
        AppMethodBeat.o(134612);
    }

    private c() {
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.expt.a.a.a aAz() {
        return com.tencent.mm.plugin.expt.a.a.a.clicfg_magicbrush_gcfactor;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aAy() {
        return "gcfactor";
    }

    public final float cD(Context context) {
        AppMethodBeat.i(134616);
        j.p(context, "context");
        Float f;
        float floatValue;
        if (hqC != null) {
            f = hqC;
            if (f == null) {
                j.dWJ();
            }
            floatValue = f.floatValue();
            AppMethodBeat.o(134616);
            return floatValue;
        }
        floatValue = ((Number) super.Uw()).floatValue();
        if (floatValue != -1.0f) {
            d.i(TAG, "rawConfig == [" + floatValue + "] != -1, just return");
            hqC = Float.valueOf(floatValue);
            AppMethodBeat.o(134616);
            return floatValue;
        }
        Resources resources = context.getResources();
        j.o(resources, "context.resources");
        floatValue = resources.getDisplayMetrics().density;
        Resources resources2 = context.getResources();
        j.o(resources2, "context.resources");
        float f2 = ((float) resources2.getDisplayMetrics().widthPixels) / floatValue;
        Resources resources3 = context.getResources();
        j.o(resources3, "context.resources");
        f2 = 2.0f * (((((float) resources3.getDisplayMetrics().heightPixels) / floatValue) * f2) * 4.0f);
        Object obj = f2 > 0.0f ? 1 : null;
        if (aa.AUz && obj == null) {
            Throwable assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(134616);
            throw assertionError;
        }
        if (hqG == null) {
            obj = context.getSystemService("activity");
            if (obj == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type android.app.ActivityManager");
                AppMethodBeat.o(134616);
                throw vVar;
            }
            ActivityManager activityManager = (ActivityManager) obj;
            hqG = new MemoryInfo();
            activityManager.getMemoryInfo(hqG);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("getAvailableMemory avail = [");
            MemoryInfo memoryInfo = hqG;
            if (memoryInfo == null) {
                j.dWJ();
            }
            stringBuilder = stringBuilder.append(memoryInfo.availMem).append("] total = [");
            memoryInfo = hqG;
            if (memoryInfo == null) {
                j.dWJ();
            }
            d.i(str, stringBuilder.append(memoryInfo.totalMem).append(']').toString());
        }
        MemoryInfo memoryInfo2 = hqG;
        if (memoryInfo2 == null) {
            j.dWJ();
        }
        long floatValue2 = (long) (((Number) hqF.getValue()).floatValue() * ((float) memoryInfo2.totalMem));
        floatValue = Math.min(((Number) hqE.getValue()).floatValue(), Math.max(((Number) hqD.getValue()).floatValue(), ((float) floatValue2) / f2));
        float f3 = 6.7108864E7f / (floatValue * f2);
        d.i(TAG, "calculate gc_factor automatically unit = [" + (f2 / 1024.0f) + "]kb limit = [65536]kb system = [" + (floatValue2 / 1024) + "]kb raw = [" + floatValue + ':' + (((float) floatValue2) / f2) + "] actually = [" + f3 + ']');
        f = Float.valueOf(f3);
        hqC = f;
        if (f == null) {
            j.dWJ();
        }
        floatValue = f.floatValue();
        AppMethodBeat.o(134616);
        return floatValue;
    }

    public final /* synthetic */ Object aAB() {
        AppMethodBeat.i(134613);
        Float valueOf = Float.valueOf(0.0f);
        AppMethodBeat.o(134613);
        return valueOf;
    }

    public final /* synthetic */ Object Ap(String str) {
        Float f;
        AppMethodBeat.i(134614);
        if (str == null) {
            f = null;
        } else {
            f = s.aww(str);
        }
        if (f != null) {
            float floatValue = f.floatValue();
            if ((floatValue >= 0.0f || floatValue == -1.0f) && floatValue <= 1.0f) {
                Object valueOf = Float.valueOf(floatValue);
                AppMethodBeat.o(134614);
                return valueOf;
            }
            AppMethodBeat.o(134614);
            return null;
        }
        AppMethodBeat.o(134614);
        return null;
    }

    public final /* synthetic */ Object Uw() {
        AppMethodBeat.i(134615);
        Throwable illegalStateException = new IllegalStateException("Code should not reach.");
        AppMethodBeat.o(134615);
        throw illegalStateException;
    }
}
