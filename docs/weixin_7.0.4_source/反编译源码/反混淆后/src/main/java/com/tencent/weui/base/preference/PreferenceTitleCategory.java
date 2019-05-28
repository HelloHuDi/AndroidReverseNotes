package com.tencent.weui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PreferenceTitleCategory extends PreferenceCategory {
    public PreferenceTitleCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceTitleCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(113258);
        if (getLayoutResource() != 2130970187) {
            setLayoutResource(2130970185);
        }
        AppMethodBeat.m2505o(113258);
    }

    /* Access modifiers changed, original: protected */
    public void onBindView(View view) {
        AppMethodBeat.m2504i(113259);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView == null) {
            AppMethodBeat.m2505o(113259);
        } else if (getTitle() == null || getTitle().length() <= 0) {
            textView.setVisibility(8);
            AppMethodBeat.m2505o(113259);
        } else {
            textView.setVisibility(0);
            textView.setText(getTitle());
            AppMethodBeat.m2505o(113259);
        }
    }
}
