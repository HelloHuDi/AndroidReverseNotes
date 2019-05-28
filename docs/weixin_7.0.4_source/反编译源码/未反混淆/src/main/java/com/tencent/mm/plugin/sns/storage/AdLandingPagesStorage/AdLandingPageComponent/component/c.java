package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    int clickCount;
    LinearLayout mpt;
    private ImageView qYZ;
    private ImageView qZa;
    private TextView qZb;
    LinearLayout qZc;

    public c(Context context, d dVar, ViewGroup viewGroup) {
        super(context, dVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au8;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37035);
        this.qZb.setText((CharSequence) ((d) this.qZo).qWc.get(0));
        if (((d) this.qZo).qWW) {
            this.qYZ.setImageDrawable(a.g(this.context, R.drawable.au6));
            this.qZa.setImageDrawable(a.g(this.context, R.drawable.atl));
            this.qZb.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.qZc.setBackgroundResource(R.drawable.az);
        } else {
            this.qYZ.setImageDrawable(a.g(this.context, R.drawable.au5));
            this.qZa.setImageDrawable(a.g(this.context, R.drawable.atk));
            this.qZb.setTextColor(-1);
            this.qZc.setBackgroundResource(R.drawable.b0);
        }
        this.qZc.setPadding((int) ((d) this.qZo).qWS, 0, (int) ((d) this.qZo).qWT, 0);
        this.mpt.setPadding(0, (int) ((d) this.qZo).qWQ, 0, (int) ((d) this.qZo).qWR);
        a(this.qZc);
        this.qZc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(37034);
                c cVar = c.this;
                cVar.clickCount++;
                if (com.tencent.mm.pluginsdk.ui.e.c.a.vrD == null) {
                    AppMethodBeat.o(37034);
                } else if (((d) c.this.qZo).qWc.size() > 1) {
                    com.tencent.mm.pluginsdk.ui.e.c.a.vrD.a(c.this.context, ((d) c.this.qZo).qWc, new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(37033);
                            ad.eQ(c.this.context);
                            AppMethodBeat.o(37033);
                        }
                    });
                    AppMethodBeat.o(37034);
                } else {
                    if (((d) c.this.qZo).qWc.size() > 0) {
                        AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) c.this.context, (String) ((d) c.this.qZo).qWc.get(0));
                    }
                    AppMethodBeat.o(37034);
                }
            }
        });
        AppMethodBeat.o(37035);
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37037);
        if (super.al(jSONObject)) {
            try {
                jSONObject.put("clickCount", this.clickCount);
                AppMethodBeat.o(37037);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
                AppMethodBeat.o(37037);
                return false;
            }
        }
        AppMethodBeat.o(37037);
        return false;
    }

    public final void cpk() {
        AppMethodBeat.i(37036);
        if (((d) this.qZo).qWc.isEmpty()) {
            AppMethodBeat.o(37036);
            return;
        }
        View view = this.contentView;
        this.qYZ = (ImageView) view.findViewById(R.id.av9);
        this.qZa = (ImageView) view.findViewById(R.id.z_);
        this.qZb = (TextView) view.findViewById(R.id.o7);
        this.mpt = (LinearLayout) view.findViewById(R.id.nc);
        this.qZc = (LinearLayout) view.findViewById(R.id.efm);
        AppMethodBeat.o(37036);
    }
}
