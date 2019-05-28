package com.tencent.mm.pluginsdk.ui.e;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ai;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.b;

public class f extends b {
    private m vrF;

    public f(NeatTextView neatTextView, m mVar) {
        super(neatTextView.getContext(), neatTextView);
        AppMethodBeat.i(79812);
        this.vrF = mVar;
        AppMethodBeat.o(79812);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean onTouch;
        AppMethodBeat.i(79813);
        ai.d("MMNeatTouchListener", "onTouch", new Object[0]);
        view.setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof NeatTextView) {
            NeatTextView neatTextView = (NeatTextView) view;
            if (!neatTextView.dKA() || neatTextView.AkW) {
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    neatTextView.getWrappedTextView().setPressed(false);
                } else if (motionEvent.getAction() == 0) {
                    neatTextView.getWrappedTextView().setPressed(true);
                }
                onTouch = this.vrF.onTouch(neatTextView.getWrappedTextView(), motionEvent);
                AppMethodBeat.o(79813);
                return onTouch;
            }
        }
        onTouch = super.onTouch(view, motionEvent);
        AppMethodBeat.o(79813);
        return onTouch;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(79814);
        boolean onDown = super.onDown(motionEvent);
        if (this.Alp != null) {
            CharacterStyle characterStyle = this.Alp.AjW;
            if (characterStyle instanceof n) {
                ((n) characterStyle).ozq = true;
            }
            AppMethodBeat.o(79814);
            return true;
        }
        AppMethodBeat.o(79814);
        return onDown;
    }

    public final void cancel(int i) {
        AppMethodBeat.i(79815);
        if (this.Alp != null) {
            CharacterStyle characterStyle = this.Alp.AjW;
            if (characterStyle instanceof n) {
                ((n) characterStyle).ozq = false;
            }
        }
        super.cancel(i);
        AppMethodBeat.o(79815);
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(79816);
        if (!(this.Alp == null || this.mView == null)) {
            this.mView.performLongClick();
        }
        super.onLongPress(motionEvent);
        AppMethodBeat.o(79816);
    }
}
