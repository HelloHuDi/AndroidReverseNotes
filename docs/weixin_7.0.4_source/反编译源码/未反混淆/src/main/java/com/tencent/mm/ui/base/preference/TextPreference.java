package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TextPreference extends Preference {
    protected int Hu;
    private Context context;
    protected CharSequence mText;
    protected TextView sW;

    public TextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107298);
        this.context = context;
        setLayoutResource(R.layout.afn);
        AppMethodBeat.o(107298);
    }

    /* Access modifiers changed, original: protected|final */
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(107299);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(107299);
        return onCreateView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onBindView(View view) {
        AppMethodBeat.i(107300);
        super.onBindView(view);
        this.sW = (TextView) view.findViewById(16908310);
        cu();
        AppMethodBeat.o(107300);
    }

    private void cu() {
        AppMethodBeat.i(107301);
        if (this.sW == null) {
            AppMethodBeat.o(107301);
            return;
        }
        this.sW.setText(this.mText);
        this.sW.setGravity(this.Hu);
        AppMethodBeat.o(107301);
    }

    public final void ae(CharSequence charSequence) {
        AppMethodBeat.i(107302);
        this.mText = charSequence;
        this.Hu = 17;
        cu();
        AppMethodBeat.o(107302);
    }
}
