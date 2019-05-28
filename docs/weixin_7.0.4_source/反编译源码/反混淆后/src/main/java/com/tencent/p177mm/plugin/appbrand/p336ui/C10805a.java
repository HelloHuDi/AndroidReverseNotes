package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C6464cc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "checkShouldLogin", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.a */
final class C10805a extends AppBrandProxyUIProcessTask {
    private final String TAG = "MicroMsg.AccountReleasePromptMMTask";

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.a$b */
    public static final class C10806b extends C4884c<C6464cc> {
        final /* synthetic */ C10805a iFz;

        C10806b(C10805a c10805a) {
            this.iFz = c10805a;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(134975);
            C10805a.m18489a(this.iFz, new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.m2505o(134975);
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.a$a */
    public static final class C10807a implements OnClickListener {
        final /* synthetic */ C10805a iFz;

        C10807a(C10805a c10805a) {
            this.iFz = c10805a;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134974);
            if (C10805a.m18490a(this.iFz)) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("Intro_Switch", true);
                C25985d.m41473f(C10805a.m18491b(this.iFz), ".ui.LauncherUI", intent);
            }
            C10805a.m18489a(this.iFz, new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.m2505o(134974);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m18489a(C10805a c10805a, ProcessResult processResult) {
        AppMethodBeat.m2504i(134980);
        c10805a.mo34449a(processResult);
        AppMethodBeat.m2505o(134980);
    }

    /* renamed from: b */
    public static final /* synthetic */ MMActivity m18491b(C10805a c10805a) {
        AppMethodBeat.m2504i(134979);
        MMActivity aBQ = c10805a.aBQ();
        AppMethodBeat.m2505o(134979);
        return aBQ;
    }

    /* renamed from: a */
    public final void mo6047a(ProcessRequest processRequest) {
        AppMethodBeat.m2504i(134976);
        if (aMa()) {
            C30379h.m48447a((Context) aBQ(), AppBrandProxyUIProcessTask.getString(C25738R.string.f8834gb), AppBrandProxyUIProcessTask.getString(C25738R.string.f9238tz), AppBrandProxyUIProcessTask.getString(C25738R.string.f8863hg), false, (OnClickListener) new C10807a(this));
            new C10806b(this).dnU();
            AppMethodBeat.m2505o(134976);
            return;
        }
        mo34449a((ProcessResult) new AccountReleaseProxyUILaunchResult());
        AppMethodBeat.m2505o(134976);
    }

    private final boolean aMa() {
        AppMethodBeat.m2504i(134977);
        if (C1668a.m3393QT()) {
            C4990ab.m7416i(this.TAG, "checkShouldLogin account hold, return true");
            AppMethodBeat.m2505o(134977);
            return true;
        } else if (C1720g.m3537RQ().mo5251RJ() && C1720g.m3534RN().mo5161QY()) {
            C4990ab.m7416i(this.TAG, "checkShouldLogin account initialized, return false");
            AppMethodBeat.m2505o(134977);
            return false;
        } else {
            C4990ab.m7416i(this.TAG, "checkShouldLogin fallback return true");
            AppMethodBeat.m2505o(134977);
            return true;
        }
    }
}
