package com.tencent.p177mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b.C20024a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.C27540m;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.PreloadLogic;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p351b.C20082b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload.p928ui.C45765c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C30309s;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J;\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J$\u0010!\u001a\u00020\u00122\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040#0#2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J$\u0010$\u001a\u00020\u00122\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180#2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J8\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0016J@\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006/"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/BrandServiceImpl;", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "()V", "TAG", "", "bizNativeVideoOpen", "", "getBizNativeVideoOpen", "()Ljava/lang/Boolean;", "setBizNativeVideoOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "preloadLimiter", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPreloadLimiter", "()Ljava/util/HashSet;", "addToPreload", "", "url", "itemShowType", "", "openScene", "vals", "", "", "(Ljava/lang/String;II[Ljava/lang/Object;)V", "canPreloadIn", "getHardCodeUrl", "isBizNativeVideoOpen", "isBizTimeLineOpen", "isMpUrl", "preCreateWebView", "preloadByIdAndUrls", "items", "", "preloadByInfoIdAndBuffer", "startPreloadWebView", "context", "Landroid/content/Context;", "subScene", "intent", "Landroid/content/Intent;", "openType", "result", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService$PreloadWebViewResult;", "tryPreloadTmplWebview", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.c */
public final class C2681c implements C20023b {
    private final String TAG = "MicroMsg.BrandServiceImpl";
    private Boolean jKg;
    private final HashSet<String> jKh = new HashSet();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.c$b */
    static final class C2682b implements Runnable {
        final /* synthetic */ int jKl;
        final /* synthetic */ List jKn;

        C2682b(List list, int i) {
            this.jKn = list;
            this.jKl = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(14763);
            PreloadLogic.m31030i(this.jKn, this.jKl);
            AppMethodBeat.m2505o(14763);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.c$c */
    static final class C2683c implements Runnable {
        final /* synthetic */ int jKl = 0;
        final /* synthetic */ List jKn;

        C2683c(List list) {
            this.jKn = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(14764);
            PreloadLogic.m31031j(this.jKn, this.jKl);
            AppMethodBeat.m2505o(14764);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.brandservice.c$a */
    static final class C2684a implements Runnable {
        final /* synthetic */ long jKi;
        final /* synthetic */ String jKj;
        final /* synthetic */ int jKk;
        final /* synthetic */ int jKl;
        final /* synthetic */ Object[] jKm;

        C2684a(long j, String str, int i, int i2, Object[] objArr) {
            this.jKi = j;
            this.jKj = str;
            this.jKk = i;
            this.jKl = i2;
            this.jKm = objArr;
        }

        public final void run() {
            AppMethodBeat.m2504i(14762);
            long j = this.jKi;
            String bc = C5046bo.m7532bc(this.jKj, "");
            C25052j.m39375o(bc, "Util.nullAs(url, \"\")");
            int i = this.jKk;
            int i2 = this.jKl;
            Object[] objArr = this.jKm;
            PreloadLogic.m31012a(j, bc, i, i2, Arrays.copyOf(objArr, objArr.length));
            AppMethodBeat.m2505o(14762);
        }
    }

    public C2681c() {
        AppMethodBeat.m2504i(14777);
        AppMethodBeat.m2505o(14777);
    }

    /* renamed from: FC */
    public final boolean mo6748FC(String str) {
        AppMethodBeat.m2504i(14765);
        if (str != null) {
            boolean FC = C27540m.m43703FC(str);
            AppMethodBeat.m2505o(14765);
            return FC;
        }
        AppMethodBeat.m2505o(14765);
        return false;
    }

    public final boolean aVO() {
        AppMethodBeat.m2504i(14766);
        boolean aVO = C30309s.aVO();
        AppMethodBeat.m2505o(14766);
        return aVO;
    }

    public final boolean aVP() {
        AppMethodBeat.m2504i(14767);
        if (C5058f.IS_FLAVOR_RED || C5058f.DEBUG) {
            AppMethodBeat.m2505o(14767);
            return true;
        }
        if (this.jKg == null) {
            boolean z;
            if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_open_biz_native_video, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            this.jKg = Boolean.valueOf(z);
            C4990ab.m7416i(this.TAG, "bizNativeVideoOpen: " + this.jKg);
        }
        Boolean bool = this.jKg;
        if (bool == null) {
            C25052j.dWJ();
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(14767);
        return booleanValue;
    }

    /* renamed from: a */
    public final void mo6749a(String str, int i, int i2, Object... objArr) {
        String str2;
        AppMethodBeat.m2504i(14768);
        C25052j.m39376p(objArr, "vals");
        StringBuilder stringBuilder = new StringBuilder("addToPreload_");
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        stringBuilder = stringBuilder.append(str2).append('_');
        Object M = C36913i.m61680M(objArr);
        if (M == null) {
            M = "";
        }
        str2 = stringBuilder.append(M).toString();
        if (this.jKh.contains(str2)) {
            AppMethodBeat.m2505o(14768);
            return;
        }
        this.jKh.add(str2);
        C7305d.xDG.mo10151b(new C2684a(System.currentTimeMillis(), str, i, i2, objArr), "tmplPreload");
        AppMethodBeat.m2505o(14768);
    }

    /* renamed from: i */
    public final void mo6757i(List<? extends List<String>> list, int i) {
        AppMethodBeat.m2504i(14769);
        C25052j.m39376p(list, "items");
        C7305d.xDG.mo10151b(new C2682b(list, i), "tmplPreload");
        AppMethodBeat.m2505o(14769);
    }

    /* renamed from: aU */
    public final void mo6752aU(List<String[]> list) {
        AppMethodBeat.m2504i(14770);
        C25052j.m39376p(list, "items");
        C7305d.xDG.mo10151b(new C2683c(list), "tmplPreload");
        AppMethodBeat.m2505o(14770);
    }

    /* renamed from: rW */
    public final boolean mo6758rW(int i) {
        AppMethodBeat.m2504i(14771);
        boolean rW = PreloadLogic.m31033rW(i);
        AppMethodBeat.m2505o(14771);
        return rW;
    }

    /* renamed from: a */
    public final boolean mo6750a(Context context, String str, int i, int i2, int i3, Intent intent) {
        AppMethodBeat.m2504i(14772);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "url");
        C25052j.m39376p(intent, "intent");
        boolean a = PreloadLogic.m31022a(context, str, i, i2, i3, intent, 0, null, C33250az.CTRL_INDEX);
        AppMethodBeat.m2505o(14772);
        return a;
    }

    /* renamed from: a */
    public final boolean mo6751a(Context context, String str, int i, int i2, int i3, C20024a c20024a) {
        AppMethodBeat.m2504i(14773);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(str, "url");
        C25052j.m39376p(c20024a, "result");
        boolean a = PreloadLogic.m31022a(context, str, i, i2, 0, null, i3, c20024a, 32);
        AppMethodBeat.m2505o(14773);
        return a;
    }

    /* renamed from: rX */
    public final void mo6759rX(int i) {
        AppMethodBeat.m2504i(14774);
        PreloadLogic.m31032mg(i);
        AppMethodBeat.m2505o(14774);
    }

    public final String aVQ() {
        AppMethodBeat.m2504i(14775);
        String aXB = C20082b.aXB();
        AppMethodBeat.m2505o(14775);
        return aXB;
    }

    public final void aVR() {
        AppMethodBeat.m2504i(14776);
        C45765c.aVR();
        AppMethodBeat.m2505o(14776);
    }
}
