package com.tencent.mm.pluginsdk.ui.e;

import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.ab;

public final class e {
    private static int ey(View view) {
        AppMethodBeat.i(79809);
        int i = 0;
        if (view instanceof TextView) {
            i = ((TextView) view).getLineCount();
        } else if (view instanceof StaticTextView) {
            i = ((StaticTextView) view).getLineCount();
        }
        AppMethodBeat.o(79809);
        return i;
    }

    private static int ag(View view, int i) {
        AppMethodBeat.i(79810);
        int lineEnd;
        if (view instanceof TextView) {
            if (((TextView) view).getLayout() == null) {
                AppMethodBeat.o(79810);
                return 0;
            }
            lineEnd = ((TextView) view).getLayout().getLineEnd(i);
            AppMethodBeat.o(79810);
            return lineEnd;
        } else if (!(view instanceof StaticTextView)) {
            AppMethodBeat.o(79810);
            return 0;
        } else if (((StaticTextView) view).getTvLayout() == null) {
            AppMethodBeat.o(79810);
            return 0;
        } else {
            lineEnd = ((StaticTextView) view).getTvLayout().getLineEnd(i);
            AppMethodBeat.o(79810);
            return lineEnd;
        }
    }

    public static boolean a(View view, Spanned spanned) {
        AppMethodBeat.i(79811);
        if (!(view == null || spanned == null || (!(view instanceof TextView) && !(view instanceof StaticTextView)))) {
            int ey = ey(view);
            if (ey != 1 || spanned.length() <= 500) {
                for (int i = 1; i < ey; i++) {
                    if (ag(view, i) - ag(view, i - 1) > 500) {
                        ab.e("MicroMsg.InvalidTextCheck", "error black dot");
                        AppMethodBeat.o(79811);
                        return true;
                    }
                }
            } else {
                ab.e("MicroMsg.InvalidTextCheck", "error black dot");
                AppMethodBeat.o(79811);
                return true;
            }
        }
        AppMethodBeat.o(79811);
        return false;
    }
}
