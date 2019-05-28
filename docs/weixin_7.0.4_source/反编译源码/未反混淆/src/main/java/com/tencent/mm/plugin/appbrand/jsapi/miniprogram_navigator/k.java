package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ci.f;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.sdk.platformtools.al;

public class k extends h {
    public static final k hRd = new k();

    static {
        AppMethodBeat.i(131360);
        AppMethodBeat.o(131360);
    }

    public boolean a(final d dVar, LaunchParcel launchParcel, final b bVar) {
        AppMethodBeat.i(131358);
        if (c.aaZ()) {
            c.a(dVar.getContext(), a.MINI_PROGRAM, launchParcel.appId, new com.tencent.mm.model.gdpr.b() {
                public final void kL(int i) {
                    AppMethodBeat.i(131355);
                    if (i == 0) {
                        bVar.proceed();
                        AppMethodBeat.o(131355);
                        return;
                    }
                    bVar.cancel();
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(131354);
                            com.tencent.mm.plugin.appbrand.widget.b.b bVar = new com.tencent.mm.plugin.appbrand.widget.b.b(dVar.getContext());
                            bVar.setTitle((int) R.string.vh);
                            bVar.ykW.setVisibility(0);
                            bVar.ykU.setVisibility(0);
                            bVar.ykU.setText(R.string.vg);
                            bVar.setCanceledOnTouchOutside(false);
                            bVar.a((int) R.string.s6, (OnClickListener) new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(131353);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(131353);
                                }
                            });
                            dVar.getRuntime().gNG.b(bVar);
                            AppMethodBeat.o(131354);
                        }
                    });
                    AppMethodBeat.o(131355);
                }
            });
            AppMethodBeat.o(131358);
            return true;
        }
        AppMethodBeat.o(131358);
        return false;
    }

    public final com.tencent.mm.vending.g.c<AppBrandInitConfigLU> a(final d dVar, final LaunchParcel launchParcel) {
        AppMethodBeat.i(131359);
        final String b = g.b(dVar, launchParcel);
        f b2 = com.tencent.mm.ci.g.dOW().b(new com.tencent.mm.vending.c.a<AppBrandInitConfigLU, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(131357);
                final com.tencent.mm.vending.g.b dMo = com.tencent.mm.vending.g.f.dMo();
                MainProcessTask appBrandPreInitTask = new AppBrandPreInitTask(dVar.getContext(), launchParcel, b, new AppBrandPreInitTask.a() {
                    public final void b(AppBrandInitConfigWC appBrandInitConfigWC) {
                        AppMethodBeat.i(131356);
                        launchParcel.c(appBrandInitConfigWC);
                        dMo.B(appBrandInitConfigWC);
                        AppMethodBeat.o(131356);
                    }
                });
                appBrandPreInitTask.aBV();
                AppBrandMainProcessService.a(appBrandPreInitTask);
                AppMethodBeat.o(131357);
                return null;
            }
        });
        AppMethodBeat.o(131359);
        return b2;
    }
}
