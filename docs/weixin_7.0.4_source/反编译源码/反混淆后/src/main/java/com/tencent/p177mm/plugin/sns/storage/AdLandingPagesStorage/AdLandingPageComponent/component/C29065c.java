package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C44764d;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30129c.C30130a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c */
public final class C29065c extends C21941a {
    int clickCount;
    LinearLayout mpt;
    private ImageView qYZ;
    private ImageView qZa;
    private TextView qZb;
    LinearLayout qZc;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c$1 */
    class C219511 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c$1$1 */
        class C219521 implements OnDismissListener {
            C219521() {
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(37033);
                C29064ad.m46207eQ(C29065c.this.context);
                AppMethodBeat.m2505o(37033);
            }
        }

        C219511() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37034);
            C29065c c29065c = C29065c.this;
            c29065c.clickCount++;
            if (C30130a.vrD == null) {
                AppMethodBeat.m2505o(37034);
            } else if (((C44764d) C29065c.this.qZo).qWc.size() > 1) {
                C30130a.vrD.mo30690a(C29065c.this.context, ((C44764d) C29065c.this.qZo).qWc, new C219521());
                AppMethodBeat.m2505o(37034);
            } else {
                if (((C44764d) C29065c.this.qZo).qWc.size() > 0) {
                    AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) C29065c.this.context, (String) ((C44764d) C29065c.this.qZo).qWc.get(0));
                }
                AppMethodBeat.m2505o(37034);
            }
        }
    }

    public C29065c(Context context, C44764d c44764d, ViewGroup viewGroup) {
        super(context, c44764d, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970724;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37035);
        this.qZb.setText((CharSequence) ((C44764d) this.qZo).qWc.get(0));
        if (((C44764d) this.qZo).qWW) {
            this.qYZ.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.au6));
            this.qZa.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.atl));
            this.qZb.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.qZc.setBackgroundResource(C25738R.drawable.f6341az);
        } else {
            this.qYZ.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.au5));
            this.qZa.setImageDrawable(C1338a.m2864g(this.context, C25738R.drawable.atk));
            this.qZb.setTextColor(-1);
            this.qZc.setBackgroundResource(C25738R.drawable.f6342b0);
        }
        this.qZc.setPadding((int) ((C44764d) this.qZo).qWS, 0, (int) ((C44764d) this.qZo).qWT, 0);
        this.mpt.setPadding(0, (int) ((C44764d) this.qZo).qWQ, 0, (int) ((C44764d) this.qZo).qWR);
        mo37490a(this.qZc);
        this.qZc.setOnClickListener(new C219511());
        AppMethodBeat.m2505o(37035);
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37037);
        if (super.mo15456al(jSONObject)) {
            try {
                jSONObject.put("clickCount", this.clickCount);
                AppMethodBeat.m2505o(37037);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
                AppMethodBeat.m2505o(37037);
                return false;
            }
        }
        AppMethodBeat.m2505o(37037);
        return false;
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37036);
        if (((C44764d) this.qZo).qWc.isEmpty()) {
            AppMethodBeat.m2505o(37036);
            return;
        }
        View view = this.contentView;
        this.qYZ = (ImageView) view.findViewById(2131822736);
        this.qZa = (ImageView) view.findViewById(2131821517);
        this.qZb = (TextView) view.findViewById(2131821095);
        this.mpt = (LinearLayout) view.findViewById(2131821064);
        this.qZc = (LinearLayout) view.findViewById(2131827633);
        AppMethodBeat.m2505o(37036);
    }
}
