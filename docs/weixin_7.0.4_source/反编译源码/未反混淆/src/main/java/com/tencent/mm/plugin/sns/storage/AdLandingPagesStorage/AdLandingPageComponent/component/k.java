package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsAdProxyUI;
import com.tencent.mm.pluginsdk.ui.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class k extends j {
    RelativeLayout nMG;
    Button qZB;
    View qZC;

    public k(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k kVar, ViewGroup viewGroup) {
        super(context, kVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k cpI() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo;
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.au4;
    }

    /* Access modifiers changed, original: protected */
    public void e(Button button) {
        AppMethodBeat.i(37092);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(37089);
                k.this.cpH();
                k.this.cpJ();
                AppMethodBeat.o(37089);
            }
        });
        AppMethodBeat.o(37092);
    }

    @TargetApi(17)
    public final void cpk() {
        AppMethodBeat.i(37094);
        View view = this.contentView;
        this.nMG = (RelativeLayout) view.findViewById(R.id.efg);
        this.qZB = (Button) view.findViewById(R.id.efh);
        this.qZC = view.findViewById(R.id.efi);
        AppMethodBeat.o(37094);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(17)
    public final void cpp() {
        AppMethodBeat.i(37091);
        this.clickCount = 0;
        int i = this.ieu;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWU > 0.0f) {
            i = ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWT) + (((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWU) + ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWS));
        }
        this.nMG.setBackgroundColor(this.backgroundColor);
        if (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWs)) {
            int i2;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWr) || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWo <= 0.0f) {
                i2 = 0;
            } else {
                try {
                    i2 = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWr);
                } catch (Exception e) {
                    ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", bo.l(e));
                    i2 = 0;
                }
                gradientDrawable.setStroke((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWo, i2);
                i2 = 1;
            }
            if (!bo.isNullOrNil(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWq)) {
                int parseColor;
                try {
                    parseColor = Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWq);
                } catch (Exception e2) {
                    ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", bo.l(e2));
                    parseColor = 0;
                }
                gradientDrawable.setColor(parseColor);
                i2 = 1;
            }
            if (i2 != 0) {
                this.qZB.setBackgroundDrawable(gradientDrawable);
            }
        } else {
            h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWs, false, 0, new a() {
                public final void cpu() {
                }

                public final void cmD() {
                }

                @TargetApi(16)
                public final void YJ(String str) {
                    AppMethodBeat.i(37086);
                    try {
                        Drawable createFromPath = Drawable.createFromPath(str);
                        k.this.qZB.setBackground(createFromPath);
                        if (createFromPath != null && k.this.cpI().height > 0.0f && createFromPath.getIntrinsicHeight() > 0) {
                            k.this.qZB.setLayoutParams(new LayoutParams((int) ((k.this.cpI().height * ((float) createFromPath.getIntrinsicWidth())) / ((float) createFromPath.getIntrinsicHeight())), (int) k.this.cpI().height));
                        }
                        AppMethodBeat.o(37086);
                    } catch (Exception e) {
                        ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                        AppMethodBeat.o(37086);
                    }
                }
            });
        }
        this.qZB.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).title);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWp == 1) {
            this.qZB.setTypeface(Typeface.defaultFromStyle(1));
        } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWp == 2) {
            this.qZB.setTypeface(Typeface.defaultFromStyle(2));
        }
        e(this.qZB);
        this.qZB.setTextSize(0, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).fontSize);
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWn != null && ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWn.length() > 0) {
            try {
                this.qZB.setTextColor(Color.parseColor(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWn));
            } catch (Exception e3) {
                ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "invalid color! %s", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWn);
            }
        }
        try {
            this.qZB.setTextAlignment(4);
        } catch (Exception e4) {
            ab.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).height > 0.0f) {
            this.qZB.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWS)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWT), (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).height));
        } else {
            this.qZB.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWS)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWT), this.qZB.getLayoutParams().height));
        }
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWt == 1) {
            this.qZC.setLayoutParams(new LayoutParams((i - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWS)) - ((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWT), this.qZC.getLayoutParams().height));
            this.qZC.setVisibility(0);
            this.qZC.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(37087);
                    k.a(k.this);
                    AppMethodBeat.o(37087);
                    return true;
                }
            });
            this.qZC.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(37088);
                    k.this.cpH();
                    k.this.cpJ();
                    AppMethodBeat.o(37088);
                }
            });
            AppMethodBeat.o(37091);
            return;
        }
        this.qZC.setVisibility(8);
        AppMethodBeat.o(37091);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpJ() {
        int intExtra;
        int intExtra2;
        AppMethodBeat.i(37093);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k kVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo;
        long j = 0;
        if (this.context instanceof Activity) {
            j = v.Zm(((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
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
        if (kVar.cuu == 4) {
            e eVar = (e) kVar;
            intent = new Intent();
            intent.putExtra("key_card_id", eVar.kcM);
            if (!bo.isNullOrNil(cpC().YI(eVar.kcM))) {
                eVar.kdB = cpC().YI(eVar.kcM);
            }
            intent.putExtra("key_card_ext", eVar.kdB);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            d.b(this.context, "card", ".ui.CardDetailUI", intent);
            AppMethodBeat.o(37093);
        } else if (kVar.cuu == 8) {
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo) instanceof i) {
                str = "";
                String str4 = "";
                if ((this.context instanceof Activity) && cpC().qXr == 2) {
                    stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                    str4 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                } else {
                    stringExtra = str;
                }
                str = ((i) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo)).qWO;
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                format = String.format("%s:%s:%s:%s:%d:%s:%s:%d", new Object[]{stringExtra, str4, str, valueOf, Integer.valueOf(cpC().qXr), cpC().qPj, Long.valueOf(j), Integer.valueOf(intExtra)});
                i iVar = (i) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo);
                str2 = iVar.cOh;
                r3 = new String[2];
                r3[0] = String.format("gdt_vid=%s", new Object[]{cpC().hcx});
                r3[1] = String.format("weixinadinfo=%s.%s.0.0", new Object[]{cpC().qTL, cpC().hcx});
                str2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(str2, r3);
                Intent intent2 = new Intent();
                intent2.putExtra("username", iVar.username);
                intent2.putExtra("url", str2);
                intent2.putExtra("sceneNote", format);
                intent2.setClass(this.context, SnsAdProxyUI.class);
                this.context.startActivity(intent2);
            }
            AppMethodBeat.o(37093);
        } else if (kVar.cuu == 9) {
            f fVar = (f) kVar;
            intent = new Intent();
            intent.putExtra("map_view_type", 1);
            intent.putExtra("kwebmap_slat", fVar.qWd.nJu);
            intent.putExtra("kwebmap_lng", fVar.qWd.nJv);
            intent.putExtra("kwebmap_scale", fVar.qWd.cED);
            intent.putExtra("kPoiName", fVar.qWd.cIK);
            intent.putExtra("Kwebmap_locaion", fVar.qWd.nJx);
            ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "locatint to slat " + fVar.qWd.nJu + ", slong " + fVar.qWd.nJv + ", " + fVar.qWd.cIK);
            d.b(this.context, b.LOCATION, ".ui.RedirectUI", intent, 2);
            AppMethodBeat.o(37093);
        } else if (kVar.cuu == 10) {
            if (c.a.vrD == null) {
                AppMethodBeat.o(37093);
                return;
            }
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h hVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h) kVar;
            if (hVar.qWc.size() > 1) {
                c.a.vrD.a(this.context, hVar.qWc, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(37090);
                        ad.eQ(k.this.context);
                        AppMethodBeat.o(37090);
                    }
                });
                AppMethodBeat.o(37093);
                return;
            }
            if (hVar.qWc.size() > 0) {
                AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity) this.context, (String) hVar.qWc.get(0));
            }
            AppMethodBeat.o(37093);
        } else if (kVar.cuu == 11) {
            if (this.context instanceof SnsAdNativeLandingPagesUI) {
                boolean z;
                boolean z2;
                SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) this.context;
                r rVar = kVar.qWA;
                str2 = kVar.qWx;
                str3 = kVar.qWy;
                stringExtra = kVar.qWz;
                if (kVar.qWv == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (kVar.qWw == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                snsAdNativeLandingPagesUI.a(rVar, str2, str3, stringExtra, z, z2, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWu == 1);
            }
            AppMethodBeat.o(37093);
        } else {
            Intent intent3 = new Intent();
            stringExtra = kVar.qWl;
            if (!(TextUtils.isEmpty(cpC().hcx) || TextUtils.isEmpty(cpC().qTL))) {
                stringExtra = ad.m(stringExtra, "traceid=" + cpC().hcx + "&aid=" + cpC().qTL);
            }
            ab.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", stringExtra);
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
                if (!bo.isNullOrNil(format)) {
                    str2 = String.valueOf(System.currentTimeMillis() / 1000);
                    str3 = "official_mall_%s_%s_%s_%s";
                    Object[] objArr = new Object[4];
                    if (bo.isNullOrNil(str)) {
                        str = "";
                    }
                    objArr[0] = str;
                    objArr[1] = format;
                    objArr[2] = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) this.qZo).qWO;
                    objArr[3] = str2;
                    str = String.format(str3, objArr);
                    intent3.putExtra("prePublishId", str);
                    intent3.putExtra("KPublisherId", str);
                    intent3.putExtra("pay_channel", 47);
                }
            }
            d.b(this.context, "webview", ".ui.tools.WebViewUI", intent3);
            AppMethodBeat.o(37093);
        }
    }

    static /* synthetic */ void a(k kVar) {
        AppMethodBeat.i(37095);
        if (kVar.context instanceof SnsAdNativeLandingPagesUI) {
            boolean z;
            boolean z2;
            boolean z3;
            SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI) kVar.context;
            r rVar = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWA;
            String str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWx;
            String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWy;
            String str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWz;
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWv == 1) {
                z = true;
            } else {
                z = false;
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWw == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k) kVar.qZo).qWu == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            snsAdNativeLandingPagesUI.a(rVar, str, str2, str3, z, z2, z3);
        }
        kVar.qZC.setPressed(false);
        AppMethodBeat.o(37095);
    }
}
