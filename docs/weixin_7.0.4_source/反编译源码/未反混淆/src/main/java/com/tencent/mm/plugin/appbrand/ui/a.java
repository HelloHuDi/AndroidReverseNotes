package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "TAG", "", "checkShouldLogin", "", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
final class a extends AppBrandProxyUIProcessTask {
    private final String TAG = "MicroMsg.AccountReleasePromptMMTask";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
    public static final class b extends c<cc> {
        final /* synthetic */ a iFz;

        b(a aVar) {
            this.iFz = aVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(134975);
            a.a(this.iFz, new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.o(134975);
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/AccountReleasePromptMMTask$handleRequest$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "plugin-appbrand-integration_release"})
    public static final class a implements OnClickListener {
        final /* synthetic */ a iFz;

        a(a aVar) {
            this.iFz = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134974);
            if (a.a(this.iFz)) {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtra("Intro_Switch", true);
                d.f(a.b(this.iFz), ".ui.LauncherUI", intent);
            }
            a.a(this.iFz, new AccountReleaseProxyUILaunchResult());
            AppMethodBeat.o(134974);
        }
    }

    public static final /* synthetic */ void a(a aVar, ProcessResult processResult) {
        AppMethodBeat.i(134980);
        aVar.a(processResult);
        AppMethodBeat.o(134980);
    }

    public static final /* synthetic */ MMActivity b(a aVar) {
        AppMethodBeat.i(134979);
        MMActivity aBQ = aVar.aBQ();
        AppMethodBeat.o(134979);
        return aBQ;
    }

    public final void a(ProcessRequest processRequest) {
        AppMethodBeat.i(134976);
        if (aMa()) {
            h.a((Context) aBQ(), AppBrandProxyUIProcessTask.getString(R.string.gb), AppBrandProxyUIProcessTask.getString(R.string.tz), AppBrandProxyUIProcessTask.getString(R.string.hg), false, (OnClickListener) new a(this));
            new b(this).dnU();
            AppMethodBeat.o(134976);
            return;
        }
        a((ProcessResult) new AccountReleaseProxyUILaunchResult());
        AppMethodBeat.o(134976);
    }

    private final boolean aMa() {
        AppMethodBeat.i(134977);
        if (com.tencent.mm.kernel.a.QT()) {
            ab.i(this.TAG, "checkShouldLogin account hold, return true");
            AppMethodBeat.o(134977);
            return true;
        } else if (g.RQ().RJ() && g.RN().QY()) {
            ab.i(this.TAG, "checkShouldLogin account initialized, return false");
            AppMethodBeat.o(134977);
            return false;
        } else {
            ab.i(this.TAG, "checkShouldLogin fallback return true");
            AppMethodBeat.o(134977);
            return true;
        }
    }
}
