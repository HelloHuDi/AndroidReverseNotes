package com.tencent.p177mm.p612ui.p615c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.p615c.p1344a.C23651c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.c.a */
public final class C5300a {
    /* renamed from: eS */
    public static Animation m8068eS(Context context) {
        AppMethodBeat.m2504i(106218);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            AppMethodBeat.m2505o(106218);
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, C25738R.anim.f8292r);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new C23651c());
        AppMethodBeat.m2505o(106218);
        return loadAnimation;
    }
}
