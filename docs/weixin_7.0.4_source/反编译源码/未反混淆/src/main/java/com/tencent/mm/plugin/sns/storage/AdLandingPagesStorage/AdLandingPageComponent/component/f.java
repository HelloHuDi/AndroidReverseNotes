package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {
    int clickCount;
    private LinearLayout mpt;
    private ImageView qZa;
    private TextView qZb;
    private LinearLayout qZc;
    g qZj;
    private View qZk;
    private ImageView qZl;

    public f(Context context, g gVar, ViewGroup viewGroup) {
        super(context, gVar, viewGroup);
        this.qZj = gVar;
    }

    public final void cpk() {
        AppMethodBeat.i(37058);
        View view = this.contentView;
        this.qZl = (ImageView) view.findViewById(R.id.av9);
        this.qZa = (ImageView) view.findViewById(R.id.z_);
        this.qZb = (TextView) view.findViewById(R.id.o7);
        this.qZc = (LinearLayout) view.findViewById(R.id.efm);
        this.mpt = (LinearLayout) view.findViewById(R.id.nc);
        this.qZk = this.qZc;
        AppMethodBeat.o(37058);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37059);
        this.qZb.setText(this.qZj.qWe.nJx);
        if (this.qZj.qWW) {
            this.qZl.setImageDrawable(a.g(this.context, R.drawable.atg));
            this.qZa.setImageDrawable(a.g(this.context, R.drawable.atl));
            this.qZb.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.qZc.setBackgroundResource(R.drawable.az);
        } else {
            this.qZl.setImageDrawable(a.g(this.context, R.drawable.atf));
            this.qZa.setImageDrawable(a.g(this.context, R.drawable.atk));
            this.qZb.setTextColor(-1);
            this.qZc.setBackgroundResource(R.drawable.b0);
        }
        this.qZc.setPadding((int) this.qZj.qWS, 0, (int) this.qZj.qWT, 0);
        this.mpt.setPadding(0, (int) this.qZj.qWQ, 0, (int) this.qZj.qWR);
        a(this.qZc);
        AnonymousClass1 anonymousClass1 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(37057);
                f fVar = f.this;
                fVar.clickCount++;
                Intent intent = new Intent();
                intent.putExtra("map_view_type", 1);
                intent.putExtra("kwebmap_slat", f.this.qZj.qWe.nJu);
                intent.putExtra("kwebmap_lng", f.this.qZj.qWe.nJv);
                intent.putExtra("kwebmap_scale", f.this.qZj.qWe.cED);
                intent.putExtra("kPoiName", f.this.qZj.qWe.cIK);
                intent.putExtra("Kwebmap_locaion", f.this.qZj.qWe.nJx);
                ab.i("AdLandingBorderedComp", "locatint to slat " + f.this.qZj.qWe.nJu + ", slong " + f.this.qZj.qWe.nJv + ", " + f.this.qZj.qWe.cIK);
                d.b(f.this.context, b.LOCATION, ".ui.RedirectUI", intent, 2);
                AppMethodBeat.o(37057);
            }
        };
        if (this.qZk != null) {
            this.qZk.setOnClickListener(anonymousClass1);
        }
        AppMethodBeat.o(37059);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au8;
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37060);
        if (super.al(jSONObject)) {
            try {
                jSONObject.put("clickCount", this.clickCount);
                AppMethodBeat.o(37060);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
                AppMethodBeat.o(37060);
                return false;
            }
        }
        AppMethodBeat.o(37060);
        return false;
    }
}
