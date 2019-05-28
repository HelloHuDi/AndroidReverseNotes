package com.tencent.mm.plugin.story.a;

import a.f.b.j;
import a.l;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/story/animation/SwingAnimator;", "Lcom/tencent/mm/plugin/story/animation/BaseViewAnimator;", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "prepare", "", "target", "Landroid/view/View;", "plugin-story_release"})
public final class b extends a {
    private final String tag = "MicroMsg.SwingAnimator";

    /* Access modifiers changed, original: protected|final */
    public final void eb(View view) {
        AppMethodBeat.i(108939);
        j.p(view, "target");
        view.setPivotX(((float) view.getWidth()) / 2.0f);
        view.setPivotY((float) view.getHeight());
        this.mDuration = 800;
        AnimatorSet animatorSet = this.rQu;
        if (animatorSet != null) {
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "rotation", new float[]{0.0f, 5.0f, 0.0f, -5.0f, 0.0f, 5.0f, 0.0f, -5.0f, 0.0f})});
            AppMethodBeat.o(108939);
            return;
        }
        AppMethodBeat.o(108939);
    }
}
