package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39781u;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa */
public final class C39765aa extends C13437h {
    TextView exj;
    private Runnable fZM;
    volatile boolean rbQ = false;

    public C39765aa(Context context, C39781u c39781u, ViewGroup viewGroup) {
        super(context, c39781u, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970730;
    }

    public final void coZ() {
        AppMethodBeat.m2504i(37339);
        super.coZ();
        C7305d.xDG.remove(this.fZM);
        this.rbQ = true;
        AppMethodBeat.m2505o(37339);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37340);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(37340);
    }

    @TargetApi(17)
    public final void cpk() {
        AppMethodBeat.m2504i(37342);
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(2131827646).setBackgroundColor(this.backgroundColor);
        view.findViewById(2131827647).setBackgroundColor(this.backgroundColor);
        this.exj = (TextView) view.findViewById(2131827647);
        AppMethodBeat.m2505o(37342);
    }

    public final void cpa() {
        AppMethodBeat.m2504i(37343);
        super.cpa();
        AppMethodBeat.m2505o(37343);
    }

    public final void cpb() {
        AppMethodBeat.m2504i(37344);
        super.cpb();
        AppMethodBeat.m2505o(37344);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37341);
        if (((C39781u) this.qZo).eOg > 0.0f) {
            this.exj.setTextSize(0, ((C39781u) this.qZo).eOg);
        }
        if (((C39781u) this.qZo).cuu == 1) {
            if (!C5046bo.isNullOrNil(((C39781u) this.qZo).qXk)) {
                final String replace = ((C39781u) this.qZo).qXk.trim().replace("<icon", "<img");
                C7305d.xDG.remove(this.fZM);
                this.fZM = new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa$1$1 */
                    class C219431 implements ImageGetter {

                        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa$1$1$1 */
                        class C38951 implements C3951a {

                            /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa$1$1$1$1 */
                            class C38961 implements ImageGetter {
                                C38961() {
                                }

                                public final Drawable getDrawable(String str) {
                                    AppMethodBeat.m2504i(37333);
                                    Drawable drawable = null;
                                    String gj = C13473h.m21625gj("adId", str);
                                    if (!C5046bo.isNullOrNil(gj) && C5730e.m8628ct(gj)) {
                                        Drawable createFromPath = Drawable.createFromPath(gj);
                                        if (createFromPath != null) {
                                            createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) ((C39781u) C39765aa.this.qZo).eOg)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) ((C39781u) C39765aa.this.qZo).eOg : createFromPath.getIntrinsicHeight());
                                        }
                                        drawable = createFromPath;
                                    }
                                    AppMethodBeat.m2505o(37333);
                                    return drawable;
                                }
                            }

                            C38951() {
                            }

                            public final void cpu() {
                            }

                            public final void cmD() {
                            }

                            /* renamed from: YJ */
                            public final void mo8627YJ(String str) {
                                AppMethodBeat.m2504i(37335);
                                try {
                                    final Spanned fromHtml = Html.fromHtml(replace, new C38961(), null);
                                    C5004al.m7441d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.m2504i(37334);
                                            C39765aa.this.exj.setText(fromHtml);
                                            AppMethodBeat.m2505o(37334);
                                        }
                                    });
                                    AppMethodBeat.m2505o(37335);
                                } catch (Exception e) {
                                    C4990ab.m7412e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                                    AppMethodBeat.m2505o(37335);
                                }
                            }
                        }

                        C219431() {
                        }

                        public final Drawable getDrawable(String str) {
                            AppMethodBeat.m2504i(37336);
                            Drawable drawable = null;
                            String gj = C13473h.m21625gj("adId", str);
                            if (C5046bo.isNullOrNil(gj) || !C5730e.m8628ct(gj)) {
                                C13473h.m21623c("adId", str, false, 0, new C38951());
                            } else {
                                Drawable createFromPath = Drawable.createFromPath(gj);
                                if (createFromPath != null) {
                                    int intrinsicWidth;
                                    int i;
                                    if (createFromPath.getIntrinsicHeight() != 0) {
                                        intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) ((C39781u) C39765aa.this.qZo).eOg)) / createFromPath.getIntrinsicHeight();
                                    } else {
                                        intrinsicWidth = createFromPath.getIntrinsicWidth();
                                    }
                                    if (createFromPath.getIntrinsicHeight() != 0) {
                                        i = (int) ((C39781u) C39765aa.this.qZo).eOg;
                                    } else {
                                        i = createFromPath.getIntrinsicHeight();
                                    }
                                    createFromPath.setBounds(0, 0, intrinsicWidth, i);
                                    drawable = createFromPath;
                                } else {
                                    drawable = createFromPath;
                                }
                            }
                            AppMethodBeat.m2505o(37336);
                            return drawable;
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(37338);
                        if (C39765aa.this.rbQ) {
                            AppMethodBeat.m2505o(37338);
                            return;
                        }
                        final Spanned fromHtml = Html.fromHtml(replace, new C219431(), null);
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(37337);
                                C39765aa.this.exj.setText(C9212g.dqQ().mo20622b(fromHtml, C39765aa.this.exj.getTextSize()));
                                AppMethodBeat.m2505o(37337);
                            }
                        });
                        AppMethodBeat.m2505o(37338);
                    }
                };
                C7305d.post(this.fZM, "");
            }
        } else if (!C5046bo.isNullOrNil(((C39781u) this.qZo).qXk)) {
            this.exj.setText(C9212g.dqQ().mo20622b(((C39781u) this.qZo).qXk.trim(), this.exj.getTextSize()));
        }
        if (((C39781u) this.qZo).textAlignment == 0) {
            this.exj.setGravity(3);
        } else if (((C39781u) this.qZo).textAlignment == 1) {
            this.exj.setGravity(17);
        } else if (((C39781u) this.qZo).textAlignment == 2) {
            this.exj.setGravity(5);
        }
        if (((C39781u) this.qZo).oxN == null || ((C39781u) this.qZo).oxN.length() <= 0) {
            this.exj.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.exj.setTextColor(Color.parseColor(((C39781u) this.qZo).oxN));
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((C39781u) this.qZo).oxN);
            }
        }
        if (((C39781u) this.qZo).qXo > 0.0f) {
            this.exj.setLineSpacing(0.0f, ((C39781u) this.qZo).qXo + 1.0f);
        }
        TextPaint paint = this.exj.getPaint();
        if (((C39781u) this.qZo).qXl) {
            paint.setFakeBoldText(true);
        }
        if (((C39781u) this.qZo).qXm) {
            paint.setTextSkewX(-0.25f);
        }
        if (((C39781u) this.qZo).qXn) {
            paint.setUnderlineText(true);
        }
        if (((C39781u) this.qZo).maxLines > 0) {
            this.exj.setMaxLines(((C39781u) this.qZo).maxLines);
        }
        if (((C39781u) this.qZo).qWp == C39781u.qXj) {
            this.exj.setTypeface(C29064ad.m46208eR(this.context));
        }
        AppMethodBeat.m2505o(37341);
    }
}
