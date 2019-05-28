package com.tencent.mm.ui.c;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.c.a.c;

public final class a {
    public static Animation eS(Context context) {
        AppMethodBeat.i(106218);
        if (context == null) {
            ab.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            AppMethodBeat.o(106218);
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.r);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new c());
        AppMethodBeat.o(106218);
        return loadAnimation;
    }
}
