package com.tencent.p177mm.p612ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.base.preference.TextPreference */
public class TextPreference extends Preference {
    /* renamed from: Hu */
    protected int f15084Hu;
    private Context context;
    protected CharSequence mText;
    /* renamed from: sW */
    protected TextView f15085sW;

    public TextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107298);
        this.context = context;
        setLayoutResource(2130970184);
        AppMethodBeat.m2505o(107298);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(107299);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.m2505o(107299);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.m2504i(107300);
        super.onBindView(view);
        this.f15085sW = (TextView) view.findViewById(16908310);
        m59376cu();
        AppMethodBeat.m2505o(107300);
    }

    /* renamed from: cu */
    private void m59376cu() {
        AppMethodBeat.m2504i(107301);
        if (this.f15085sW == null) {
            AppMethodBeat.m2505o(107301);
            return;
        }
        this.f15085sW.setText(this.mText);
        this.f15085sW.setGravity(this.f15084Hu);
        AppMethodBeat.m2505o(107301);
    }

    /* renamed from: ae */
    public final void mo56922ae(CharSequence charSequence) {
        AppMethodBeat.m2504i(107302);
        this.mText = charSequence;
        this.f15084Hu = 17;
        m59376cu();
        AppMethodBeat.m2505o(107302);
    }
}
