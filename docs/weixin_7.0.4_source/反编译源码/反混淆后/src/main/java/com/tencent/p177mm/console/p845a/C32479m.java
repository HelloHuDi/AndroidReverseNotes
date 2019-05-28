package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.pluginsdk.C44068p.C30089e;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.console.a.m */
public final class C32479m implements C44041a {
    static {
        AppMethodBeat.m2504i(16149);
        C44042b.m79163a(new C32479m(), "//wear");
        AppMethodBeat.m2505o(16149);
    }

    public static void init() {
    }

    /* JADX WARNING: Missing block: B:12:0x0034, code skipped:
            if (r4.equals("log") != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(16148);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16148);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16148);
            return true;
        } else {
            String str2 = strArr[1];
            switch (str2.hashCode()) {
                case 107332:
                    break;
                case 351608024:
                    if (str2.equals("version")) {
                        z = true;
                        break;
                    }
                case 990157655:
                    if (str2.equals("reconnect")) {
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    C30089e.vaw.cUq();
                    break;
                case true:
                    View textView = new TextView(context);
                    textView.setText(C30089e.vaw.cUp());
                    textView.setGravity(19);
                    textView.setTextSize(1, 10.0f);
                    textView.setLayoutParams(new LayoutParams(-1, -2));
                    textView.setTextColor(-16711936);
                    textView.setTypeface(Typeface.MONOSPACE);
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    C30379h.m48435a(context, null, textView, null);
                    break;
            }
            AppMethodBeat.m2505o(16148);
            return true;
        }
    }
}
