package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.gdpr.C32791a;
import com.tencent.p177mm.model.gdpr.C32792b;
import com.tencent.p177mm.model.gdpr.C37918c;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C2320c.C2321b;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandPreInitTask.C10574a;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C6789b;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k */
public class C27039k extends C38355h {
    public static final C27039k hRd = new C27039k();

    static {
        AppMethodBeat.m2504i(131360);
        AppMethodBeat.m2505o(131360);
    }

    /* renamed from: a */
    public boolean mo21858a(final C2119d c2119d, LaunchParcel launchParcel, final C2321b c2321b) {
        AppMethodBeat.m2504i(131358);
        if (C37918c.aaZ()) {
            C37918c.m64041a(c2119d.getContext(), C32791a.MINI_PROGRAM, launchParcel.appId, new C32792b() {

                /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k$1$1 */
                class C104911 implements Runnable {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.k$1$1$1 */
                    class C104921 implements OnClickListener {
                        C104921() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(131353);
                            dialogInterface.dismiss();
                            AppMethodBeat.m2505o(131353);
                        }
                    }

                    C104911() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(131354);
                        C6789b c6789b = new C6789b(c2119d.getContext());
                        c6789b.setTitle((int) C25738R.string.f9283vh);
                        c6789b.ykW.setVisibility(0);
                        c6789b.ykU.setVisibility(0);
                        c6789b.ykU.setText(C25738R.string.f9282vg);
                        c6789b.setCanceledOnTouchOutside(false);
                        c6789b.mo11487a((int) C25738R.string.f9187s6, (OnClickListener) new C104921());
                        c2119d.getRuntime().gNG.mo6468b(c6789b);
                        AppMethodBeat.m2505o(131354);
                    }
                }

                /* renamed from: kL */
                public final void mo8219kL(int i) {
                    AppMethodBeat.m2504i(131355);
                    if (i == 0) {
                        c2321b.proceed();
                        AppMethodBeat.m2505o(131355);
                        return;
                    }
                    c2321b.cancel();
                    C5004al.m7441d(new C104911());
                    AppMethodBeat.m2505o(131355);
                }
            });
            AppMethodBeat.m2505o(131358);
            return true;
        }
        AppMethodBeat.m2505o(131358);
        return false;
    }

    /* renamed from: a */
    public final C7361c<AppBrandInitConfigLU> mo44722a(final C2119d c2119d, final LaunchParcel launchParcel) {
        AppMethodBeat.m2504i(131359);
        final String b = C2453g.m4698b(c2119d, launchParcel);
        C37654f b2 = C41930g.dOW().mo60487b(new C5681a<AppBrandInitConfigLU, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(131357);
                final C5688b dMo = C5698f.dMo();
                MainProcessTask appBrandPreInitTask = new AppBrandPreInitTask(c2119d.getContext(), launchParcel, b, new C10574a() {
                    /* renamed from: b */
                    public final void mo15056b(AppBrandInitConfigWC appBrandInitConfigWC) {
                        AppMethodBeat.m2504i(131356);
                        launchParcel.mo34789c(appBrandInitConfigWC);
                        dMo.mo11581B(appBrandInitConfigWC);
                        AppMethodBeat.m2505o(131356);
                    }
                });
                appBrandPreInitTask.aBV();
                AppBrandMainProcessService.m54349a(appBrandPreInitTask);
                AppMethodBeat.m2505o(131357);
                return null;
            }
        });
        AppMethodBeat.m2505o(131359);
        return b2;
    }
}
