package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.p;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
public final class d extends AppBrandProxyUIProcessTask {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class a implements com.tencent.mm.model.ao.b.a {
        final /* synthetic */ int hUJ;
        final /* synthetic */ d hUP;
        final /* synthetic */ ProfileResult hUQ;
        final /* synthetic */ p hUR;

        a(d dVar, ProfileResult profileResult, p pVar, int i) {
            this.hUP = dVar;
            this.hUQ = profileResult;
            this.hUR = pVar;
            this.hUJ = i;
        }

        public final void o(String str, boolean z) {
            AppMethodBeat.i(134706);
            if (d.a(this.hUP) == null) {
                ab.w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
                this.hUQ.bFZ = 0;
                d.a(this.hUP, this.hUQ);
                AppMethodBeat.o(134706);
                return;
            }
            p pVar = this.hUR;
            if (pVar != null) {
                pVar.dismiss();
            }
            com.tencent.mm.kernel.c.a K = g.K(j.class);
            a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
            ad aoO = ((j) K).XM().aoO(str);
            if (aoO == null || aoO.Oh() <= 0) {
                K = g.K(j.class);
                a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ((j) K).XM().aoK(str);
                z = false;
            } else {
                str = aoO.getUsername();
            }
            if (z) {
                com.tencent.mm.ah.b.U(str, 3);
                o.acv().pZ(str);
                if (aoO == null) {
                    a.f.b.j.dWJ();
                }
                if (aoO.dsf()) {
                    h.pYm.X(10298, aoO.getUsername() + "," + this.hUJ);
                    this.hUQ.hUO |= 1;
                }
                if (aoO.NX()) {
                    this.hUQ.hUO |= 2;
                }
                this.hUQ.bFZ = 1;
                d.a(this.hUP, this.hUQ);
                AppMethodBeat.o(134706);
                return;
            }
            ab.w("ProfileTask", "handleRequest, getNow callback fail");
            this.hUQ.bFZ = 0;
            d.a(this.hUP, this.hUQ);
            AppMethodBeat.o(134706);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class b implements OnCancelListener {
        final /* synthetic */ String hBP;
        final /* synthetic */ d hUP;
        final /* synthetic */ ProfileResult hUQ;

        b(d dVar, String str, ProfileResult profileResult) {
            this.hUP = dVar;
            this.hBP = str;
            this.hUQ = profileResult;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(134707);
            com.tencent.mm.model.ao.a.Zu().or(this.hBP);
            this.hUQ.bFZ = 2;
            d.a(this.hUP, this.hUQ);
            AppMethodBeat.o(134707);
        }
    }

    public static final /* synthetic */ void a(d dVar, ProcessResult processResult) {
        AppMethodBeat.i(134709);
        dVar.a(processResult);
        AppMethodBeat.o(134709);
    }

    public final void a(ProcessRequest processRequest) {
        AppMethodBeat.i(134708);
        a.f.b.j.p(processRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        ProfileResult profileResult = new ProfileResult();
        if (processRequest instanceof ProfileRequest) {
            g.RN();
            if (com.tencent.mm.kernel.a.QX()) {
                int i = ((ProfileRequest) processRequest).scene;
                String str = ((ProfileRequest) processRequest).username;
                com.tencent.mm.kernel.c.a K = g.K(j.class);
                a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ad aoO = ((j) K).XM().aoO(str);
                if (aoO == null || aoO.Oh() <= 0) {
                    K = g.K(j.class);
                    a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
                    aoO = ((j) K).XM().aoK(str);
                }
                if (aoO == null || aoO.Oh() <= 0) {
                    ab.i("ProfileTask", "handleRequest, request contact info");
                    Context aBQ = aBQ();
                    aBQ().getString(R.string.tz);
                    com.tencent.mm.model.ao.a.Zu().a(str, "", new a(this, profileResult, com.tencent.mm.ui.base.h.b(aBQ, aBQ().getString(R.string.un), true, (OnCancelListener) new b(this, str, profileResult)), i));
                    AppMethodBeat.o(134708);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                profileResult.username = aoO.getUsername();
                if (aoO.dsf()) {
                    h.pYm.X(10298, aoO.getUsername() + "," + i);
                    profileResult.hUO |= 1;
                    intent.putExtra("Contact_Scene", i);
                }
                if (aoO.NX()) {
                    profileResult.hUO |= 2;
                    qh qhVar = new qh();
                    qhVar.cMw.intent = intent;
                    qhVar.cMw.username = str;
                    com.tencent.mm.sdk.b.a.xxA.m(qhVar);
                }
                profileResult.bFZ = 1;
                a((ProcessResult) profileResult);
                AppMethodBeat.o(134708);
                return;
            }
            ab.e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
            profileResult.bFZ = 0;
            a((ProcessResult) profileResult);
            AppMethodBeat.o(134708);
            return;
        }
        ab.w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
        profileResult.bFZ = 0;
        a((ProcessResult) profileResult);
        AppMethodBeat.o(134708);
    }
}
