package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference */
public class SettingsAboutMMHeaderPreference extends Preference {
    public String qlS = "";

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMMHeaderPreference$1 */
    class C132061 implements OnClickListener {
        private long qlT = 0;

        C132061() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127085);
            long anU = C5046bo.anU();
            if (this.qlT > anU || anU - this.qlT > 300) {
                this.qlT = anU;
                AppMethodBeat.m2505o(127085);
                return;
            }
            this.qlT = anU;
            Context context = SettingsAboutMMHeaderPreference.this.mContext;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{C5059g.m7673d(context, C7243d.vxo, true), Integer.valueOf(C7243d.vxo)}));
            stringBuilder.append(C5058f.aZm());
            stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(C5059g.cdf)}));
            stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(C46400aa.m87305HV(0))}));
            stringBuilder.append(String.format("[l.ver] %d\n", new Object[]{Integer.valueOf(C46400aa.m87305HV(1))}));
            stringBuilder.append(String.format("[ws.ver] %d\n", new Object[]{Integer.valueOf(C27278r.aLE())}));
            stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{BuildConfig.CLIENT_VERSION}));
            View textView = new TextView(context);
            textView.setText(stringBuilder);
            textView.setGravity(19);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new LayoutParams(-1, -2));
            textView.setTextColor(WebView.NIGHT_MODE_COLOR);
            textView.setTypeface(Typeface.MONOSPACE);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            C30379h.m48435a(context, null, textView, null);
            AppMethodBeat.m2505o(127085);
        }
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(127086);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131827376);
        TextView textView = (TextView) view.findViewById(2131827377);
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
        ((TextView) view.findViewById(2131827378)).setText(String.format("%s %s", new Object[]{"Version", this.qlS}));
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new C132061());
        }
        AppMethodBeat.m2505o(127086);
    }
}
