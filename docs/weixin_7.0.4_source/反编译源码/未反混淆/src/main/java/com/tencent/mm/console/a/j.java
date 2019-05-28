package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class j implements a {
    static {
        AppMethodBeat.i(16143);
        b.a(new j(), "//version");
        AppMethodBeat.o(16143);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        int i;
        AppMethodBeat.i(16142);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{g.d(context, d.vxo, true), Integer.valueOf(d.vxo)}));
        stringBuilder.append(f.aZm());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(g.cdf)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(aa.HV(0))}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{BuildConfig.CLIENT_VERSION}));
        if (f.EX_DEVICE_LOGIN) {
            try {
                Map z = br.z(bo.convertStreamToString(context.getAssets().open("merged_features.xml")), "merged");
                if (z != null) {
                    i = 0;
                    while (true) {
                        if (((String) z.get(".merged.feature" + (i > 0 ? String.valueOf(i) : ""))) == null) {
                            break;
                        }
                        stringBuilder.append(String.format("[feature#%02d] %s\n", new Object[]{Integer.valueOf(i), (String) z.get(".merged.feature" + (i > 0 ? String.valueOf(i) : ""))}));
                        i++;
                    }
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Version", e, "", new Object[0]);
            }
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        i = context.getResources().getDimensionPixelSize(R.dimen.l5);
        textView.setPadding(i, i, i, i);
        h.a(context, null, textView, null);
        AppMethodBeat.o(16142);
        return true;
    }
}
