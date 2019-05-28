package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.StaticTextView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.e */
public final class C23305e {
    /* renamed from: ey */
    private static int m35791ey(View view) {
        AppMethodBeat.m2504i(79809);
        int i = 0;
        if (view instanceof TextView) {
            i = ((TextView) view).getLineCount();
        } else if (view instanceof StaticTextView) {
            i = ((StaticTextView) view).getLineCount();
        }
        AppMethodBeat.m2505o(79809);
        return i;
    }

    /* renamed from: ag */
    private static int m35790ag(View view, int i) {
        AppMethodBeat.m2504i(79810);
        int lineEnd;
        if (view instanceof TextView) {
            if (((TextView) view).getLayout() == null) {
                AppMethodBeat.m2505o(79810);
                return 0;
            }
            lineEnd = ((TextView) view).getLayout().getLineEnd(i);
            AppMethodBeat.m2505o(79810);
            return lineEnd;
        } else if (!(view instanceof StaticTextView)) {
            AppMethodBeat.m2505o(79810);
            return 0;
        } else if (((StaticTextView) view).getTvLayout() == null) {
            AppMethodBeat.m2505o(79810);
            return 0;
        } else {
            lineEnd = ((StaticTextView) view).getTvLayout().getLineEnd(i);
            AppMethodBeat.m2505o(79810);
            return lineEnd;
        }
    }

    /* renamed from: a */
    public static boolean m35789a(View view, Spanned spanned) {
        AppMethodBeat.m2504i(79811);
        if (!(view == null || spanned == null || (!(view instanceof TextView) && !(view instanceof StaticTextView)))) {
            int ey = C23305e.m35791ey(view);
            if (ey != 1 || spanned.length() <= 500) {
                for (int i = 1; i < ey; i++) {
                    if (C23305e.m35790ag(view, i) - C23305e.m35790ag(view, i - 1) > 500) {
                        C4990ab.m7412e("MicroMsg.InvalidTextCheck", "error black dot");
                        AppMethodBeat.m2505o(79811);
                        return true;
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.InvalidTextCheck", "error black dot");
                AppMethodBeat.m2505o(79811);
                return true;
            }
        }
        AppMethodBeat.m2505o(79811);
        return false;
    }
}
