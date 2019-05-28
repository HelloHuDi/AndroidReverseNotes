package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.C19247b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.appbrand.ipc.C26907a;
import com.tencent.p177mm.plugin.appbrand.task.C38520i.C38521a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.apache.commons.p703b.C16470a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "finishHandler", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController$FinishAllHandler;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.h */
public final class C27329h {
    private static final Integer[] iJb = new Integer[]{Integer.valueOf(100), Integer.valueOf(200)};
    public static final C27329h iJc = new C27329h();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"doFinish", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.h$a */
    static final class C2485a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C38521a iJd;
        final /* synthetic */ Activity iJe;

        C2485a(C38521a c38521a, Activity activity) {
            this.iJd = c38521a;
            this.iJe = activity;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134997);
            aDt();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134997);
            return c37091y;
        }

        public final void aDt() {
            AppMethodBeat.m2504i(134998);
            this.iJd.proceed();
            this.iJe.finish();
            AppMethodBeat.m2505o(134998);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.h$b */
    static final class C27330b<R extends ProcessResult> implements C19247b<AccountReleaseProxyUILaunchResult> {
        final /* synthetic */ C2485a iJf;

        C27330b(C2485a c2485a) {
            this.iJf = c2485a;
        }

        /* renamed from: c */
        public final /* synthetic */ void mo6053c(ProcessResult processResult) {
            AppMethodBeat.m2504i(134999);
            this.iJf.aDt();
            AppMethodBeat.m2505o(134999);
        }
    }

    static {
        AppMethodBeat.m2504i(135001);
        AppMethodBeat.m2505o(135001);
    }

    private C27329h() {
    }

    /* renamed from: a */
    public static void m43383a(Activity activity, C38521a c38521a) {
        RunningAppProcessInfo runningAppProcessInfo;
        AppMethodBeat.m2504i(135000);
        C25052j.m39376p(activity, "activity");
        C25052j.m39376p(c38521a, "finishHandler");
        try {
            runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (RemoteException e) {
            runningAppProcessInfo = null;
        }
        C2485a c2485a = new C2485a(c38521a, activity);
        if (runningAppProcessInfo == null || !C16470a.contains(iJb, Integer.valueOf(runningAppProcessInfo.importance))) {
            C4990ab.m7416i("MicroMsg.AppBrandUIAccountReleaseHandler", "finish directly importance[" + (runningAppProcessInfo != null ? runningAppProcessInfo.importance : -1) + ']');
            c2485a.aDt();
            AppMethodBeat.m2505o(135000);
            return;
        }
        C26907a.m42841a(activity, new AccountReleaseProxyUILaunchRequest(), new C27330b(c2485a), new Intent().addFlags(67108864));
        AppMethodBeat.m2505o(135000);
    }
}
