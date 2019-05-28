package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class g extends Preference {
    private View mView = null;

    public g(Context context) {
        super(context);
        AppMethodBeat.i(81040);
        setLayoutResource(R.layout.aky);
        AppMethodBeat.o(81040);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(81041);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        super.onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(81041);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(139050);
        super.onBindView(view);
        AppMethodBeat.o(139050);
    }
}
