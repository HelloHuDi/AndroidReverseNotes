package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.mm.R;
import com.tencent.mm.cb.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class aa extends h {
    TextView exj;
    private Runnable fZM;
    volatile boolean rbQ = false;

    public aa(Context context, u uVar, ViewGroup viewGroup) {
        super(context, uVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.aud;
    }

    public final void coZ() {
        AppMethodBeat.i(37339);
        super.coZ();
        d.xDG.remove(this.fZM);
        this.rbQ = true;
        AppMethodBeat.o(37339);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37340);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(37340);
    }

    @TargetApi(17)
    public final void cpk() {
        AppMethodBeat.i(37342);
        View view = this.contentView;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(R.id.efz).setBackgroundColor(this.backgroundColor);
        view.findViewById(R.id.eg0).setBackgroundColor(this.backgroundColor);
        this.exj = (TextView) view.findViewById(R.id.eg0);
        AppMethodBeat.o(37342);
    }

    public final void cpa() {
        AppMethodBeat.i(37343);
        super.cpa();
        AppMethodBeat.o(37343);
    }

    public final void cpb() {
        AppMethodBeat.i(37344);
        super.cpb();
        AppMethodBeat.o(37344);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37341);
        if (((u) this.qZo).eOg > 0.0f) {
            this.exj.setTextSize(0, ((u) this.qZo).eOg);
        }
        if (((u) this.qZo).cuu == 1) {
            if (!bo.isNullOrNil(((u) this.qZo).qXk)) {
                final String replace = ((u) this.qZo).qXk.trim().replace("<icon", "<img");
                d.xDG.remove(this.fZM);
                this.fZM = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(37338);
                        if (aa.this.rbQ) {
                            AppMethodBeat.o(37338);
                            return;
                        }
                        final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter() {
                            public final Drawable getDrawable(String str) {
                                AppMethodBeat.i(37336);
                                Drawable drawable = null;
                                String gj = h.gj("adId", str);
                                if (bo.isNullOrNil(gj) || !e.ct(gj)) {
                                    h.c("adId", str, false, 0, new a() {
                                        public final void cpu() {
                                        }

                                        public final void cmD() {
                                        }

                                        public final void YJ(String str) {
                                            AppMethodBeat.i(37335);
                                            try {
                                                final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter() {
                                                    public final Drawable getDrawable(String str) {
                                                        AppMethodBeat.i(37333);
                                                        Drawable drawable = null;
                                                        String gj = h.gj("adId", str);
                                                        if (!bo.isNullOrNil(gj) && e.ct(gj)) {
                                                            Drawable createFromPath = Drawable.createFromPath(gj);
                                                            if (createFromPath != null) {
                                                                createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) ((u) aa.this.qZo).eOg)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) ((u) aa.this.qZo).eOg : createFromPath.getIntrinsicHeight());
                                                            }
                                                            drawable = createFromPath;
                                                        }
                                                        AppMethodBeat.o(37333);
                                                        return drawable;
                                                    }
                                                }, null);
                                                al.d(new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.i(37334);
                                                        aa.this.exj.setText(fromHtml);
                                                        AppMethodBeat.o(37334);
                                                    }
                                                });
                                                AppMethodBeat.o(37335);
                                            } catch (Exception e) {
                                                ab.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                                                AppMethodBeat.o(37335);
                                            }
                                        }
                                    });
                                } else {
                                    Drawable createFromPath = Drawable.createFromPath(gj);
                                    if (createFromPath != null) {
                                        int intrinsicWidth;
                                        int i;
                                        if (createFromPath.getIntrinsicHeight() != 0) {
                                            intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) ((u) aa.this.qZo).eOg)) / createFromPath.getIntrinsicHeight();
                                        } else {
                                            intrinsicWidth = createFromPath.getIntrinsicWidth();
                                        }
                                        if (createFromPath.getIntrinsicHeight() != 0) {
                                            i = (int) ((u) aa.this.qZo).eOg;
                                        } else {
                                            i = createFromPath.getIntrinsicHeight();
                                        }
                                        createFromPath.setBounds(0, 0, intrinsicWidth, i);
                                        drawable = createFromPath;
                                    } else {
                                        drawable = createFromPath;
                                    }
                                }
                                AppMethodBeat.o(37336);
                                return drawable;
                            }
                        }, null);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37337);
                                aa.this.exj.setText(g.dqQ().b(fromHtml, aa.this.exj.getTextSize()));
                                AppMethodBeat.o(37337);
                            }
                        });
                        AppMethodBeat.o(37338);
                    }
                };
                d.post(this.fZM, "");
            }
        } else if (!bo.isNullOrNil(((u) this.qZo).qXk)) {
            this.exj.setText(g.dqQ().b(((u) this.qZo).qXk.trim(), this.exj.getTextSize()));
        }
        if (((u) this.qZo).textAlignment == 0) {
            this.exj.setGravity(3);
        } else if (((u) this.qZo).textAlignment == 1) {
            this.exj.setGravity(17);
        } else if (((u) this.qZo).textAlignment == 2) {
            this.exj.setGravity(5);
        }
        if (((u) this.qZo).oxN == null || ((u) this.qZo).oxN.length() <= 0) {
            this.exj.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.exj.setTextColor(Color.parseColor(((u) this.qZo).oxN));
            } catch (Exception e) {
                ab.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((u) this.qZo).oxN);
            }
        }
        if (((u) this.qZo).qXo > 0.0f) {
            this.exj.setLineSpacing(0.0f, ((u) this.qZo).qXo + 1.0f);
        }
        TextPaint paint = this.exj.getPaint();
        if (((u) this.qZo).qXl) {
            paint.setFakeBoldText(true);
        }
        if (((u) this.qZo).qXm) {
            paint.setTextSkewX(-0.25f);
        }
        if (((u) this.qZo).qXn) {
            paint.setUnderlineText(true);
        }
        if (((u) this.qZo).maxLines > 0) {
            this.exj.setMaxLines(((u) this.qZo).maxLines);
        }
        if (((u) this.qZo).qWp == u.qXj) {
            this.exj.setTypeface(ad.eR(this.context));
        }
        AppMethodBeat.o(37341);
    }
}
