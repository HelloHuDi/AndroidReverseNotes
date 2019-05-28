package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.view.C7380b;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.p177mm.p612ui.C5227ai;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.f */
public class C23306f extends C7380b {
    private C30132m vrF;

    public C23306f(NeatTextView neatTextView, C30132m c30132m) {
        super(neatTextView.getContext(), neatTextView);
        AppMethodBeat.m2504i(79812);
        this.vrF = c30132m;
        AppMethodBeat.m2505o(79812);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouch;
        AppMethodBeat.m2504i(79813);
        C5227ai.m7971d("MMNeatTouchListener", "onTouch", new Object[0]);
        view.setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof NeatTextView) {
            NeatTextView neatTextView = (NeatTextView) view;
            if (!neatTextView.dKA() || neatTextView.AkW) {
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    neatTextView.getWrappedTextView().setPressed(false);
                } else if (motionEvent.getAction() == 0) {
                    neatTextView.getWrappedTextView().setPressed(true);
                }
                onTouch = this.vrF.onTouch(neatTextView.getWrappedTextView(), motionEvent);
                AppMethodBeat.m2505o(79813);
                return onTouch;
            }
        }
        onTouch = super.onTouch(view, motionEvent);
        AppMethodBeat.m2505o(79813);
        return onTouch;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(79814);
        boolean onDown = super.onDown(motionEvent);
        if (this.Alp != null) {
            CharacterStyle characterStyle = this.Alp.AjW;
            if (characterStyle instanceof C23322n) {
                ((C23322n) characterStyle).ozq = true;
            }
            AppMethodBeat.m2505o(79814);
            return true;
        }
        AppMethodBeat.m2505o(79814);
        return onDown;
    }

    public final void cancel(int i) {
        AppMethodBeat.m2504i(79815);
        if (this.Alp != null) {
            CharacterStyle characterStyle = this.Alp.AjW;
            if (characterStyle instanceof C23322n) {
                ((C23322n) characterStyle).ozq = false;
            }
        }
        super.cancel(i);
        AppMethodBeat.m2505o(79815);
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(79816);
        if (!(this.Alp == null || this.mView == null)) {
            this.mView.performLongClick();
        }
        super.onLongPress(motionEvent);
        AppMethodBeat.m2505o(79816);
    }
}
