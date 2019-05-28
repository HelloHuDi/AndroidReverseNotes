package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdNativeLandingPagesUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsAdProxyUI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21967k;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C24829h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29084i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C43567e;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C43568f;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30129c.C30130a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k */
public class C17097k extends C16866j {
    RelativeLayout nMG;
    Button qZB;
    View qZC;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k$3 */
    class C170983 implements OnClickListener {
        C170983() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37088);
            C17097k.this.cpH();
            C17097k.this.cpJ();
            AppMethodBeat.m2505o(37088);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k$5 */
    class C170995 implements OnDismissListener {
        C170995() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(37090);
            C29064ad.m46207eQ(C17097k.this.context);
            AppMethodBeat.m2505o(37090);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k$4 */
    class C171004 implements OnClickListener {
        C171004() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(37089);
            C17097k.this.cpH();
            C17097k.this.cpJ();
            AppMethodBeat.m2505o(37089);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k$1 */
    class C171011 implements C3951a {
        C171011() {
        }

        public final void cpu() {
        }

        public final void cmD() {
        }

        @TargetApi(16)
        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37086);
            try {
                Drawable createFromPath = Drawable.createFromPath(str);
                C17097k.this.qZB.setBackground(createFromPath);
                if (createFromPath != null && C17097k.this.cpI().height > 0.0f && createFromPath.getIntrinsicHeight() > 0) {
                    C17097k.this.qZB.setLayoutParams(new LayoutParams((int) ((C17097k.this.cpI().height * ((float) createFromPath.getIntrinsicWidth())) / ((float) createFromPath.getIntrinsicHeight())), (int) C17097k.this.cpI().height));
                }
                AppMethodBeat.m2505o(37086);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                AppMethodBeat.m2505o(37086);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k$2 */
    class C171022 implements OnLongClickListener {
        C171022() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(37087);
            C17097k.m26476a(C17097k.this);
            AppMethodBeat.m2505o(37087);
            return true;
        }
    }

    public C17097k(Context context, C21967k c21967k, ViewGroup viewGroup) {
        super(context, c21967k, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final C21967k cpI() {
        return (C21967k) this.qZo;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970720;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public void mo31177e(Button button) {
        AppMethodBeat.m2504i(37092);
        button.setOnClickListener(new C171004());
        AppMethodBeat.m2505o(37092);
    }

    @TargetApi(17)
    public final void cpk() {
        AppMethodBeat.m2504i(37094);
        View view = this.contentView;
        this.nMG = (RelativeLayout) view.findViewById(2131827627);
        this.qZB = (Button) view.findViewById(2131827628);
        this.qZC = view.findViewById(2131827629);
        AppMethodBeat.m2505o(37094);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(17)
    public final void cpp() {
        AppMethodBeat.m2504i(37091);
        this.clickCount = 0;
        int i = this.ieu;
        if (((C21967k) this.qZo).qWU > 0.0f) {
            i = ((int) ((C21967k) this.qZo).qWT) + (((int) ((C21967k) this.qZo).qWU) + ((int) ((C21967k) this.qZo).qWS));
        }
        this.nMG.setBackgroundColor(this.backgroundColor);
        if (C5046bo.isNullOrNil(((C21967k) this.qZo).qWs)) {
            int i2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (C5046bo.isNullOrNil(((C21967k) this.qZo).qWr) || ((C21967k) this.qZo).qWo <= 0.0f) {
                i2 = 0;
            } else {
                try {
                    i2 = Color.parseColor(((C21967k) this.qZo).qWr);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.Sns.AdLandingPageBtnComponent", C5046bo.m7574l(e));
                    i2 = 0;
                }
                gradientDrawable.setStroke((int) ((C21967k) this.qZo).qWo, i2);
                i2 = 1;
            }
            if (!C5046bo.isNullOrNil(((C21967k) this.qZo).qWq)) {
                int parseColor;
                try {
                    parseColor = Color.parseColor(((C21967k) this.qZo).qWq);
                } catch (Exception e2) {
                    C4990ab.m7412e("MicroMsg.Sns.AdLandingPageBtnComponent", C5046bo.m7574l(e2));
                    parseColor = 0;
                }
                gradientDrawable.setColor(parseColor);
                i2 = 1;
            }
            if (i2 != 0) {
                this.qZB.setBackgroundDrawable(gradientDrawable);
            }
        } else {
            C13473h.m21623c("adId", ((C21967k) this.qZo).qWs, false, 0, new C171011());
        }
        this.qZB.setText(((C21967k) this.qZo).title);
        if (((C21967k) this.qZo).qWp == 1) {
            this.qZB.setTypeface(Typeface.defaultFromStyle(1));
        } else if (((C21967k) this.qZo).qWp == 2) {
            this.qZB.setTypeface(Typeface.defaultFromStyle(2));
        }
        mo31177e(this.qZB);
        this.qZB.setTextSize(0, ((C21967k) this.qZo).fontSize);
        if (((C21967k) this.qZo).qWn != null && ((C21967k) this.qZo).qWn.length() > 0) {
            try {
                this.qZB.setTextColor(Color.parseColor(((C21967k) this.qZo).qWn));
            } catch (Exception e3) {
                C4990ab.m7413e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", ((C21967k) this.qZo).qWn);
            }
        }
        try {
            this.qZB.setTextAlignment(4);
        } catch (Exception e4) {
            C4990ab.m7412e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        if (((C21967k) this.qZo).height > 0.0f) {
            this.qZB.setLayoutParams(new LayoutParams((i - ((int) ((C21967k) this.qZo).qWS)) - ((int) ((C21967k) this.qZo).qWT), (int) ((C21967k) this.qZo).height));
        } else {
            this.qZB.setLayoutParams(new LayoutParams((i - ((int) ((C21967k) this.qZo).qWS)) - ((int) ((C21967k) this.qZo).qWT), this.qZB.getLayoutParams().height));
        }
        if (((C21967k) this.qZo).qWt == 1) {
            this.qZC.setLayoutParams(new LayoutParams((i - ((int) ((C21967k) this.qZo).qWS)) - ((int) ((C21967k) this.qZo).qWT), this.qZC.getLayoutParams().height));
            this.qZC.setVisibility(0);
            this.qZC.setOnLongClickListener(new C171022());
            this.qZC.setOnClickListener(new C170983());
            AppMethodBeat.m2505o(37091);
            return;
        }
        this.qZC.setVisibility(8);
        AppMethodBeat.m2505o(37091);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpJ() {
        int intExtra;
        int intExtra2;
        AppMethodBeat.m2504i(37093);
        C21967k c21967k = (C21967k) this.qZo;
        long j = 0;
        if (this.context instanceof Activity) {
            j = C35002v.m57483Zm(((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
            intExtra = ((Activity) this.context).getIntent().getIntExtra("sns_landig_pages_from_source", 0);
            intExtra2 = ((Activity) this.context).getIntent().getIntExtra("sns_landing_pages_adType", 0);
        } else {
            intExtra = 0;
            intExtra2 = 0;
        }
        Intent intent;
        String str;
        String stringExtra;
        String format;
        String str2;
        String str3;
        if (c21967k.cuu == 4) {
            C43567e c43567e = (C43567e) c21967k;
            intent = new Intent();
            intent.putExtra("key_card_id", c43567e.kcM);
            if (!C5046bo.isNullOrNil(cpC().mo74248YI(c43567e.kcM))) {
                c43567e.kdB = cpC().mo74248YI(c43567e.kcM);
            }
            intent.putExtra("key_card_ext", c43567e.kdB);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            C25985d.m41467b(this.context, "card", ".ui.CardDetailUI", intent);
            AppMethodBeat.m2505o(37093);
        } else if (c21967k.cuu == 8) {
            if (((C21967k) this.qZo) instanceof C29084i) {
                str = "";
                String str4 = "";
                if ((this.context instanceof Activity) && cpC().qXr == 2) {
                    stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                    str4 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                } else {
                    stringExtra = str;
                }
                str = ((C29084i) ((C21967k) this.qZo)).qWO;
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                format = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[]{stringExtra, str4, str, valueOf, Integer.valueOf(cpC().qXr), cpC().qPj, Long.valueOf(j), Integer.valueOf(intExtra)});
                C29084i c29084i = (C29084i) ((C21967k) this.qZo);
                str2 = c29084i.cOh;
                r3 = new String[2];
                r3[0] = String.format("gdt_vid=%s", new Object[]{cpC().hcx});
                r3[1] = String.format("weixinadinfo=%s.%s.0.0", new Object[]{cpC().qTL, cpC().hcx});
                str2 = C3953i.m6307n(str2, r3);
                Intent intent2 = new Intent();
                intent2.putExtra("username", c29084i.username);
                intent2.putExtra("url", str2);
                intent2.putExtra("sceneNote", format);
                intent2.setClass(this.context, SnsAdProxyUI.class);
                this.context.startActivity(intent2);
            }
            AppMethodBeat.m2505o(37093);
        } else if (c21967k.cuu == 9) {
            C43568f c43568f = (C43568f) c21967k;
            intent = new Intent();
            intent.putExtra("map_view_type", 1);
            intent.putExtra("kwebmap_slat", c43568f.qWd.nJu);
            intent.putExtra("kwebmap_lng", c43568f.qWd.nJv);
            intent.putExtra("kwebmap_scale", c43568f.qWd.cED);
            intent.putExtra("kPoiName", c43568f.qWd.cIK);
            intent.putExtra("Kwebmap_locaion", c43568f.qWd.nJx);
            C4990ab.m7416i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + c43568f.qWd.nJu + ", slong " + c43568f.qWd.nJv + ", " + c43568f.qWd.cIK);
            C25985d.m41468b(this.context, C8741b.LOCATION, ".ui.RedirectUI", intent, 2);
            AppMethodBeat.m2505o(37093);
        } else if (c21967k.cuu == 10) {
            if (C30130a.vrD == null) {
                AppMethodBeat.m2505o(37093);
                return;
            }
            C24829h c24829h = (C24829h) c21967k;
            if (c24829h.qWc.size() > 1) {
                C30130a.vrD.mo30690a(this.context, c24829h.qWc, new C170995());
                AppMethodBeat.m2505o(37093);
                return;
            }
            if (c24829h.qWc.size() > 0) {
                AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.context, (String) c24829h.qWc.get(0));
            }
            AppMethodBeat.m2505o(37093);
        } else if (c21967k.cuu == 11) {
            if (this.context instanceof SnsAdNativeLandingPagesUI) {
                boolean z;
                boolean z2;
                SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                C29086r c29086r = c21967k.qWA;
                str2 = c21967k.qWx;
                str3 = c21967k.qWy;
                stringExtra = c21967k.qWz;
                if (c21967k.qWv == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (c21967k.qWw == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                snsAdNativeLandingPagesUI.mo25673a(c29086r, str2, str3, stringExtra, z, z2, ((C21967k) this.qZo).qWu == 1);
            }
            AppMethodBeat.m2505o(37093);
        } else {
            Intent intent3 = new Intent();
            stringExtra = c21967k.qWl;
            if (!(TextUtils.isEmpty(cpC().hcx) || TextUtils.isEmpty(cpC().qTL))) {
                stringExtra = C29064ad.m46209m(stringExtra, "traceid=" + cpC().hcx + "&aid=" + cpC().qTL);
            }
            C4990ab.m7417i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", stringExtra);
            intent3.putExtra("rawUrl", stringExtra);
            intent3.putExtra("useJs", true);
            intent3.putExtra("type", -255);
            intent3.putExtra("geta8key_scene", 2);
            if (cpC().qXr == 0) {
                SnsAdClick snsAdClick = new SnsAdClick(intExtra, j, intExtra2);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                intent3.putExtra("jsapiargs", bundle);
            }
            if ((this.context instanceof Activity) && cpC().qXr == 2) {
                format = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                str = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                if (!C5046bo.isNullOrNil(format)) {
                    str2 = String.valueOf(System.currentTimeMillis() / 1000);
                    str3 = "official_mall_%s_%s_%s_%s";
                    Object[] objArr = new Object[4];
                    if (C5046bo.isNullOrNil(str)) {
                        str = "";
                    }
                    objArr[0] = str;
                    objArr[1] = format;
                    objArr[2] = ((C21967k) this.qZo).qWO;
                    objArr[3] = str2;
                    str = String.format(str3, objArr);
                    intent3.putExtra("prePublishId", str);
                    intent3.putExtra("KPublisherId", str);
                    intent3.putExtra("pay_channel", 47);
                }
            }
            C25985d.m41467b(this.context, "webview", ".ui.tools.WebViewUI", intent3);
            AppMethodBeat.m2505o(37093);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26476a(C17097k c17097k) {
        AppMethodBeat.m2504i(37095);
        if (c17097k.context instanceof SnsAdNativeLandingPagesUI) {
            boolean z;
            boolean z2;
            boolean z3;
            SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) c17097k.context;
            C29086r c29086r = ((C21967k) c17097k.qZo).qWA;
            String str = ((C21967k) c17097k.qZo).qWx;
            String str2 = ((C21967k) c17097k.qZo).qWy;
            String str3 = ((C21967k) c17097k.qZo).qWz;
            if (((C21967k) c17097k.qZo).qWv == 1) {
                z = true;
            } else {
                z = false;
            }
            if (((C21967k) c17097k.qZo).qWw == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (((C21967k) c17097k.qZo).qWu == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            snsAdNativeLandingPagesUI.mo25673a(c29086r, str, str2, str3, z, z2, z3);
        }
        c17097k.qZC.setPressed(false);
        AppMethodBeat.m2505o(37095);
    }
}
