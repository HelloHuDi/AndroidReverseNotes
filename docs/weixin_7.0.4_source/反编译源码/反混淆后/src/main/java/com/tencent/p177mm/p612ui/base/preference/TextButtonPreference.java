package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5616v;

/* renamed from: com.tencent.mm.ui.base.preference.TextButtonPreference */
public class TextButtonPreference extends Preference {
    public TextButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextButtonPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int getLayoutResource() {
        return 2130970131;
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107296);
        super.onCreateView(viewGroup);
        View inflate = C5616v.m8409hu(this.mContext).inflate(2130970131, viewGroup, false);
        AppMethodBeat.m2505o(107296);
        return inflate;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107297);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setText(getTitle());
            textView.setEnabled(isEnabled());
        }
        AppMethodBeat.m2505o(107297);
    }
}
