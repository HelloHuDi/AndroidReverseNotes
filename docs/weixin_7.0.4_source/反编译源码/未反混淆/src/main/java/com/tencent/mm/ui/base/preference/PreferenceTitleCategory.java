package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class PreferenceTitleCategory extends PreferenceCategory {
    public PreferenceTitleCategory(Context context) {
        this(context, null);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107284);
        if (getLayoutResource() != R.layout.afq) {
            setLayoutResource(R.layout.afo);
        }
        AppMethodBeat.o(107284);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107285);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView == null) {
            AppMethodBeat.o(107285);
        } else if (getTitle() == null || getTitle().length() <= 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(107285);
        } else {
            textView.setVisibility(0);
            textView.setText(getTitle());
            AppMethodBeat.o(107285);
        }
    }
}
