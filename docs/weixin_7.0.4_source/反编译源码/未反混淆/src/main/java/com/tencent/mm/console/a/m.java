package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.pluginsdk.p.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public final class m implements a {
    static {
        AppMethodBeat.i(16149);
        b.a(new m(), "//wear");
        AppMethodBeat.o(16149);
    }

    public static void init() {
    }

    /* JADX WARNING: Missing block: B:12:0x0034, code skipped:
            if (r4.equals("log") != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z = false;
        AppMethodBeat.i(16148);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16148);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16148);
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
                    e.vaw.cUq();
                    break;
                case true:
                    View textView = new TextView(context);
                    textView.setText(e.vaw.cUp());
                    textView.setGravity(19);
                    textView.setTextSize(1, 10.0f);
                    textView.setLayoutParams(new LayoutParams(-1, -2));
                    textView.setTextColor(-16711936);
                    textView.setTypeface(Typeface.MONOSPACE);
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    h.a(context, null, textView, null);
                    break;
            }
            AppMethodBeat.o(16148);
            return true;
        }
    }
}
