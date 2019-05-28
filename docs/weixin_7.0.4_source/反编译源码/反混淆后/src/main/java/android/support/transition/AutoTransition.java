package android.support.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        init();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        mo42275ao(1);
        mo42282d((Transition) new Fade(2)).mo42282d(new ChangeBounds()).mo42282d(new Fade(1));
    }
}
