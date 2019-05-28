package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends d {
    private static final int huq = R.id.a3;

    public static a cV(View view) {
        AppMethodBeat.i(126684);
        a aVar = (a) view.getRootView().findViewById(huq);
        AppMethodBeat.o(126684);
        return aVar;
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(126685);
        super.setId(huq);
        setBackgroundResource(R.color.rr);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126683);
                a.this.hide();
                AppMethodBeat.o(126683);
            }
        });
        AppMethodBeat.o(126685);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(126686);
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                du(i, MeasureSpec.makeMeasureSpec(i3, ErrorDialogData.SUPPRESSED));
                AppMethodBeat.o(126686);
                return;
            }
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(126686);
    }

    public final void setId(int i) {
    }

    public final void show() {
        AppMethodBeat.i(126687);
        super.show();
        AppMethodBeat.o(126687);
    }

    public final void hide() {
        AppMethodBeat.i(126688);
        super.hide();
        AppMethodBeat.o(126688);
    }
}
