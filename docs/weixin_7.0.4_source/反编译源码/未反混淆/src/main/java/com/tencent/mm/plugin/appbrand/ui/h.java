package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "finishHandler", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController$FinishAllHandler;", "plugin-appbrand-integration_release"})
public final class h {
    private static final Integer[] iJb = new Integer[]{Integer.valueOf(100), Integer.valueOf(200)};
    public static final h iJc = new h();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"doFinish", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.task.i.a iJd;
        final /* synthetic */ Activity iJe;

        a(com.tencent.mm.plugin.appbrand.task.i.a aVar, Activity activity) {
            this.iJd = aVar;
            this.iJe = activity;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134997);
            aDt();
            y yVar = y.AUy;
            AppMethodBeat.o(134997);
            return yVar;
        }

        public final void aDt() {
            AppMethodBeat.i(134998);
            this.iJd.proceed();
            this.iJe.finish();
            AppMethodBeat.o(134998);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
    static final class b<R extends ProcessResult> implements com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b<AccountReleaseProxyUILaunchResult> {
        final /* synthetic */ a iJf;

        b(a aVar) {
            this.iJf = aVar;
        }

        public final /* synthetic */ void c(ProcessResult processResult) {
            AppMethodBeat.i(134999);
            this.iJf.aDt();
            AppMethodBeat.o(134999);
        }
    }

    static {
        AppMethodBeat.i(135001);
        AppMethodBeat.o(135001);
    }

    private h() {
    }

    public static void a(Activity activity, com.tencent.mm.plugin.appbrand.task.i.a aVar) {
        RunningAppProcessInfo runningAppProcessInfo;
        AppMethodBeat.i(135000);
        j.p(activity, "activity");
        j.p(aVar, "finishHandler");
        try {
            runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (RemoteException e) {
            runningAppProcessInfo = null;
        }
        a aVar2 = new a(aVar, activity);
        if (runningAppProcessInfo == null || !org.apache.commons.b.a.contains(iJb, Integer.valueOf(runningAppProcessInfo.importance))) {
            ab.i("MicroMsg.AppBrandUIAccountReleaseHandler", "finish directly importance[" + (runningAppProcessInfo != null ? runningAppProcessInfo.importance : -1) + ']');
            aVar2.aDt();
            AppMethodBeat.o(135000);
            return;
        }
        com.tencent.mm.plugin.appbrand.ipc.a.a(activity, new AccountReleaseProxyUILaunchRequest(), new b(aVar2), new Intent().addFlags(67108864));
        AppMethodBeat.o(135000);
    }
}
