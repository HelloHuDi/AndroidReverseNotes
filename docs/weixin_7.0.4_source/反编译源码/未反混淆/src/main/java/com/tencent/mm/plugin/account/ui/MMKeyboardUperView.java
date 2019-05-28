package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKeyboardUperView extends ScrollView {
    private int defaultHeight = -1;
    private View gDh;
    private Runnable gDi = new Runnable() {
        public final void run() {
            AppMethodBeat.i(125077);
            MMKeyboardUperView.this.fullScroll(130);
            MMKeyboardUperView.this.gDh.setVisibility(4);
            AppMethodBeat.o(125077);
        }
    };
    private Runnable gDj = new Runnable() {
        public final void run() {
            AppMethodBeat.i(125078);
            MMKeyboardUperView.this.gDh.setVisibility(0);
            AppMethodBeat.o(125078);
        }
    };

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(125079);
        AppMethodBeat.o(125079);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(125080);
        AppMethodBeat.o(125080);
    }

    public void setupUperView(View view) {
        this.gDh = view;
        this.defaultHeight = -1;
    }
}
