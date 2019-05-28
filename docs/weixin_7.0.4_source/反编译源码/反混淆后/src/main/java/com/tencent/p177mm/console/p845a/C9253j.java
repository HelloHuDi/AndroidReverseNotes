package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

/* renamed from: com.tencent.mm.console.a.j */
public final class C9253j implements C44041a {
    static {
        AppMethodBeat.m2504i(16143);
        C44042b.m79163a(new C9253j(), "//version");
        AppMethodBeat.m2505o(16143);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        int i;
        AppMethodBeat.m2504i(16142);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{C5059g.m7673d(context, C7243d.vxo, true), Integer.valueOf(C7243d.vxo)}));
        stringBuilder.append(C5058f.aZm());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(C5059g.cdf)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(C46400aa.m87305HV(0))}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{BuildConfig.CLIENT_VERSION}));
        if (C5058f.EX_DEVICE_LOGIN) {
            try {
                Map z = C5049br.m7595z(C5046bo.convertStreamToString(context.getAssets().open("merged_features.xml")), "merged");
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
                C4990ab.printErrStackTrace("MicroMsg.Version", e, "", new Object[0]);
            }
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        i = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        textView.setPadding(i, i, i, i);
        C30379h.m48435a(context, null, textView, null);
        AppMethodBeat.m2505o(16142);
        return true;
    }
}
