package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21967k;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s */
public final class C17106s extends C17097k {
    public C17106s(Context context, C21967k c21967k, ViewGroup viewGroup) {
        super(context, c21967k, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final void mo31177e(Button button) {
        AppMethodBeat.m2504i(37237);
        final C21967k cpI = cpI();
        if (C46494g.m87757u(this.context, cpI.qWm)) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(37235);
                    C17106s.this.cpH();
                    C40439f bT = C46494g.m87739bT(cpI.qWm, true);
                    if (bT == null || TextUtils.isEmpty(bT.field_packageName) || !C17106s.this.mo31183v(view.getContext(), bT.field_packageName, C46494g.m87733b(view.getContext(), bT, null))) {
                        C17106s.this.cpJ();
                    }
                    AppMethodBeat.m2505o(37235);
                }
            });
            AppMethodBeat.m2505o(37237);
            return;
        }
        super.mo31177e(button);
        AppMethodBeat.m2505o(37237);
    }

    /* renamed from: v */
    public final boolean mo31183v(Context context, String str, final String str2) {
        AppMethodBeat.m2504i(37238);
        if (context == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(37238);
            return false;
        }
        try {
            final Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                if (!(context instanceof Activity)) {
                    context = this.context;
                }
                C26006a.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(37236);
                        C46494g.m87736b(context, launchIntentForPackage, str2);
                        AppMethodBeat.m2505o(37236);
                    }
                });
                AppMethodBeat.m2505o(37238);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7412e("AdLandingPageOpenAppBtnComp", C5046bo.m7574l(e));
        }
        AppMethodBeat.m2505o(37238);
        return false;
    }
}
