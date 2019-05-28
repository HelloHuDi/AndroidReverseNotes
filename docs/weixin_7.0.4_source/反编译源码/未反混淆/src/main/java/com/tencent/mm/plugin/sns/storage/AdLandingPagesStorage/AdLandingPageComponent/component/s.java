package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class s extends k {
    public s(Context context, k kVar, ViewGroup viewGroup) {
        super(context, kVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(Button button) {
        AppMethodBeat.i(37237);
        final k cpI = cpI();
        if (g.u(this.context, cpI.qWm)) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(37235);
                    s.this.cpH();
                    f bT = g.bT(cpI.qWm, true);
                    if (bT == null || TextUtils.isEmpty(bT.field_packageName) || !s.this.v(view.getContext(), bT.field_packageName, g.b(view.getContext(), bT, null))) {
                        s.this.cpJ();
                    }
                    AppMethodBeat.o(37235);
                }
            });
            AppMethodBeat.o(37237);
            return;
        }
        super.e(button);
        AppMethodBeat.o(37237);
    }

    public final boolean v(Context context, String str, final String str2) {
        AppMethodBeat.i(37238);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(37238);
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                if (!(context instanceof Activity)) {
                    context = this.context;
                }
                a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37236);
                        g.b(context, launchIntentForPackage, str2);
                        AppMethodBeat.o(37236);
                    }
                });
                AppMethodBeat.o(37238);
                return true;
            }
        } catch (Exception e) {
            ab.e("AdLandingPageOpenAppBtnComp", bo.l(e));
        }
        AppMethodBeat.o(37238);
        return false;
    }
}
