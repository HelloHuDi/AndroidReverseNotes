package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C44765g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f */
public final class C39766f extends C21941a {
    int clickCount;
    private LinearLayout mpt;
    private ImageView qZa;
    private TextView qZb;
    private LinearLayout qZc;
    C44765g qZj;
    private View qZk;
    private ImageView qZl;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f$1 */
    class C349671 implements OnClickListener {
        C349671() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37057);
            C39766f c39766f = C39766f.this;
            c39766f.clickCount++;
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 1);
            intent.putExtra("kwebmap_slat", C39766f.this.qZj.qWe.nJu);
            intent.putExtra("kwebmap_lng", C39766f.this.qZj.qWe.nJv);
            intent.putExtra("kwebmap_scale", C39766f.this.qZj.qWe.cED);
            intent.putExtra("kPoiName", C39766f.this.qZj.qWe.cIK);
            intent.putExtra("Kwebmap_locaion", C39766f.this.qZj.qWe.nJx);
            C4990ab.m7416i("AdLandingBorderedComp", "locatint to slat " + C39766f.this.qZj.qWe.nJu + ", slong " + C39766f.this.qZj.qWe.nJv + ", " + C39766f.this.qZj.qWe.cIK);
            C25985d.m41468b(C39766f.this.context, C8741b.LOCATION, ".ui.RedirectUI", intent, 2);
            AppMethodBeat.m2505o(37057);
        }
    }

    public C39766f(Context context, C44765g c44765g, ViewGroup viewGroup) {
        super(context, c44765g, viewGroup);
        this.qZj = c44765g;
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37058);
        View view = this.contentView;
        this.qZl = (ImageView) view.findViewById(2131822736);
        this.qZa = (ImageView) view.findViewById(2131821517);
        this.qZb = (TextView) view.findViewById(2131821095);
        this.qZc = (LinearLayout) view.findViewById(2131827633);
        this.mpt = (LinearLayout) view.findViewById(2131821064);
        this.qZk = this.qZc;
        AppMethodBeat.m2505o(37058);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37059);
        this.qZb.setText(this.qZj.qWe.nJx);
        if (this.qZj.qWW) {
            this.qZl.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.atg));
            this.qZa.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.atl));
            this.qZb.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.qZc.setBackgroundResource(C25738R.drawable.f6341az);
        } else {
            this.qZl.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.atf));
            this.qZa.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.atk));
            this.qZb.setTextColor(-1);
            this.qZc.setBackgroundResource(C25738R.drawable.f6342b0);
        }
        this.qZc.setPadding((int) this.qZj.qWS, 0, (int) this.qZj.qWT, 0);
        this.mpt.setPadding(0, (int) this.qZj.qWQ, 0, (int) this.qZj.qWR);
        mo37490a(this.qZc);
        C349671 c349671 = new C349671();
        if (this.qZk != null) {
            this.qZk.setOnClickListener(c349671);
        }
        AppMethodBeat.m2505o(37059);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970724;
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37060);
        if (super.mo15456al(jSONObject)) {
            try {
                jSONObject.put("clickCount", this.clickCount);
                AppMethodBeat.m2505o(37060);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
                AppMethodBeat.m2505o(37060);
                return false;
            }
        }
        AppMethodBeat.m2505o(37060);
        return false;
    }
}
