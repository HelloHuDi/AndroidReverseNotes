package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;

public class SettingsAboutMMHeaderPreference extends Preference {
    public String qlS = "";

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(127086);
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.e9o);
        TextView textView = (TextView) view.findViewById(R.id.e9p);
        if (textView != null) {
            textView.getPaint().setFakeBoldText(true);
        }
        ((TextView) view.findViewById(R.id.e9q)).setText(String.format("%s %s", new Object[]{"Version", this.qlS}));
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new OnClickListener() {
                private long qlT = 0;

                public final void onClick(View view) {
                    AppMethodBeat.i(127085);
                    long anU = bo.anU();
                    if (this.qlT > anU || anU - this.qlT > 300) {
                        this.qlT = anU;
                        AppMethodBeat.o(127085);
                        return;
                    }
                    this.qlT = anU;
                    Context context = SettingsAboutMMHeaderPreference.this.mContext;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{g.d(context, d.vxo, true), Integer.valueOf(d.vxo)}));
                    stringBuilder.append(f.aZm());
                    stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(g.cdf)}));
                    stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(aa.HV(0))}));
                    stringBuilder.append(String.format("[l.ver] %d\n", new Object[]{Integer.valueOf(aa.HV(1))}));
                    stringBuilder.append(String.format("[ws.ver] %d\n", new Object[]{Integer.valueOf(r.aLE())}));
                    stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{BuildConfig.CLIENT_VERSION}));
                    View textView = new TextView(context);
                    textView.setText(stringBuilder);
                    textView.setGravity(19);
                    textView.setTextSize(1, 10.0f);
                    textView.setLayoutParams(new LayoutParams(-1, -2));
                    textView.setTextColor(WebView.NIGHT_MODE_COLOR);
                    textView.setTypeface(Typeface.MONOSPACE);
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    h.a(context, null, textView, null);
                    AppMethodBeat.o(127085);
                }
            });
        }
        AppMethodBeat.o(127086);
    }
}
