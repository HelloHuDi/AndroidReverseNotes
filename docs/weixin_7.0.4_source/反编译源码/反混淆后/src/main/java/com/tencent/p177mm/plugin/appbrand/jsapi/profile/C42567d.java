package com.tencent.p177mm.plugin.appbrand.jsapi.profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p230g.p231a.C42041qh;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "()V", "handleRequest", "", "request", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.profile.d */
public final class C42567d extends AppBrandProxyUIProcessTask {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.profile.d$a */
    static final class C2335a implements C9636a {
        final /* synthetic */ int hUJ;
        final /* synthetic */ C42567d hUP;
        final /* synthetic */ ProfileResult hUQ;
        final /* synthetic */ C44275p hUR;

        C2335a(C42567d c42567d, ProfileResult profileResult, C44275p c44275p, int i) {
            this.hUP = c42567d;
            this.hUQ = profileResult;
            this.hUR = c44275p;
            this.hUJ = i;
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(134706);
            if (C42567d.m75364a(this.hUP) == null) {
                C4990ab.m7420w("ProfileTask", "handleRequest, getNow callback, context has already been detached!");
                this.hUQ.bFZ = 0;
                C42567d.m75365a(this.hUP, this.hUQ);
                AppMethodBeat.m2505o(134706);
                return;
            }
            C44275p c44275p = this.hUR;
            if (c44275p != null) {
                c44275p.dismiss();
            }
            C1694a K = C1720g.m3528K(C6982j.class);
            C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
            C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
            if (aoO == null || aoO.mo16705Oh() <= 0) {
                K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                ((C6982j) K).mo15369XM().aoK(str);
                z = false;
            } else {
                str = aoO.getUsername();
            }
            if (z) {
                C41730b.m73489U(str, 3);
                C17884o.acv().mo67495pZ(str);
                if (aoO == null) {
                    C25052j.dWJ();
                }
                if (aoO.dsf()) {
                    C7060h.pYm.mo8374X(10298, aoO.getUsername() + "," + this.hUJ);
                    this.hUQ.hUO |= 1;
                }
                if (aoO.mo16693NX()) {
                    this.hUQ.hUO |= 2;
                }
                this.hUQ.bFZ = 1;
                C42567d.m75365a(this.hUP, this.hUQ);
                AppMethodBeat.m2505o(134706);
                return;
            }
            C4990ab.m7420w("ProfileTask", "handleRequest, getNow callback fail");
            this.hUQ.bFZ = 0;
            C42567d.m75365a(this.hUP, this.hUQ);
            AppMethodBeat.m2505o(134706);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.profile.d$b */
    static final class C10507b implements OnCancelListener {
        final /* synthetic */ String hBP;
        final /* synthetic */ C42567d hUP;
        final /* synthetic */ ProfileResult hUQ;

        C10507b(C42567d c42567d, String str, ProfileResult profileResult) {
            this.hUP = c42567d;
            this.hBP = str;
            this.hUQ = profileResult;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(134707);
            C26417a.m42064Zu().mo20969or(this.hBP);
            this.hUQ.bFZ = 2;
            C42567d.m75365a(this.hUP, this.hUQ);
            AppMethodBeat.m2505o(134707);
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m75365a(C42567d c42567d, ProcessResult processResult) {
        AppMethodBeat.m2504i(134709);
        c42567d.mo34449a(processResult);
        AppMethodBeat.m2505o(134709);
    }

    /* renamed from: a */
    public final void mo6047a(ProcessRequest processRequest) {
        AppMethodBeat.m2504i(134708);
        C25052j.m39376p(processRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        ProfileResult profileResult = new ProfileResult();
        if (processRequest instanceof ProfileRequest) {
            C1720g.m3534RN();
            if (C1668a.m3395QX()) {
                int i = ((ProfileRequest) processRequest).scene;
                String str = ((ProfileRequest) processRequest).username;
                C1694a K = C1720g.m3528K(C6982j.class);
                C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                C7616ad aoO = ((C6982j) K).mo15369XM().aoO(str);
                if (aoO == null || aoO.mo16705Oh() <= 0) {
                    K = C1720g.m3528K(C6982j.class);
                    C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
                    aoO = ((C6982j) K).mo15369XM().aoK(str);
                }
                if (aoO == null || aoO.mo16705Oh() <= 0) {
                    C4990ab.m7416i("ProfileTask", "handleRequest, request contact info");
                    Context aBQ = aBQ();
                    aBQ().getString(C25738R.string.f9238tz);
                    C26417a.m42064Zu().mo20966a(str, "", new C2335a(this, profileResult, C30379h.m48458b(aBQ, aBQ().getString(C25738R.string.f9260un), true, (OnCancelListener) new C10507b(this, str, profileResult)), i));
                    AppMethodBeat.m2505o(134708);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                profileResult.username = aoO.getUsername();
                if (aoO.dsf()) {
                    C7060h.pYm.mo8374X(10298, aoO.getUsername() + "," + i);
                    profileResult.hUO |= 1;
                    intent.putExtra("Contact_Scene", i);
                }
                if (aoO.mo16693NX()) {
                    profileResult.hUO |= 2;
                    C42041qh c42041qh = new C42041qh();
                    c42041qh.cMw.intent = intent;
                    c42041qh.cMw.username = str;
                    C4879a.xxA.mo10055m(c42041qh);
                }
                profileResult.bFZ = 1;
                mo34449a((ProcessResult) profileResult);
                AppMethodBeat.m2505o(134708);
                return;
            }
            C4990ab.m7412e("ProfileTask", "handleRequest, MMKernel.account().hasLogin() is false");
            profileResult.bFZ = 0;
            mo34449a((ProcessResult) profileResult);
            AppMethodBeat.m2505o(134708);
            return;
        }
        C4990ab.m7420w("ProfileTask", "handleRequest, request not instance of ProfileRequest");
        profileResult.bFZ = 0;
        mo34449a((ProcessResult) profileResult);
        AppMethodBeat.m2505o(134708);
    }
}
