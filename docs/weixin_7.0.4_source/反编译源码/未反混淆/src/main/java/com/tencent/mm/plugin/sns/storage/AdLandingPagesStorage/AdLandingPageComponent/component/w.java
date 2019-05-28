package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class w extends h {
    private ImageView cAw;
    ProgressBar progressBar;
    boolean qWC;
    boolean qZh = true;

    public w(Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return R.layout.aub;
    }

    public final void cpk() {
        AppMethodBeat.i(37266);
        this.cAw = (ImageView) this.contentView.findViewById(R.id.efl);
        this.progressBar = (ProgressBar) this.contentView.findViewById(R.id.rj);
        AppMethodBeat.o(37266);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37267);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins((int) ((n) this.qZo).qWS, (int) ((n) this.qZo).qWQ, (int) ((n) this.qZo).qWT, (int) ((n) this.qZo).qWR);
            this.contentView.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(37267);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37268);
        if (this.contentView == null || this.cAw == null || this.progressBar == null) {
            AppMethodBeat.o(37268);
        } else if (((n) this.qZo) == null) {
            AppMethodBeat.o(37268);
        } else {
            String str = ((n) this.qZo).qWD;
            String str2 = ((n) this.qZo).qWE;
            float f = ((n) this.qZo).height;
            float f2 = ((n) this.qZo).width;
            this.qWC = ((n) this.qZo).qWC;
            if (f != 0.0f && f2 != 0.0f && !this.qWC) {
                int i = (this.ieu - ((int) ((n) this.qZo).qWS)) - ((int) ((n) this.qZo).qWT);
                if (f2 >= ((float) i)) {
                    f2 = (float) i;
                }
                this.cAw.setLayoutParams(new RelativeLayout.LayoutParams((int) f2, (int) ((f2 * ((n) this.qZo).height) / ((n) this.qZo).width)));
            } else if (!this.qWC || f == 0.0f || f2 == 0.0f) {
                this.cAw.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
            } else {
                this.cAw.setLayoutParams(new RelativeLayout.LayoutParams(this.ieu, this.iev));
            }
            if (str2 != null && str2.length() > 0) {
                try {
                    this.cAw.setBackgroundColor(Color.parseColor(str2));
                } catch (Exception e) {
                }
            }
            if (str == null || str.length() <= 0) {
                ab.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
                AppMethodBeat.o(37268);
                return;
            }
            Bitmap gm = h.gm("adId", str);
            if (gm == null || !Y(gm)) {
                this.qZh = false;
                startLoading();
                h.a(str, ((n) this.qZo).qWP, new a() {
                    public final void cpu() {
                        AppMethodBeat.i(37263);
                        w.this.startLoading();
                        AppMethodBeat.o(37263);
                    }

                    public final void cmD() {
                        AppMethodBeat.i(37264);
                        w.this.progressBar.setVisibility(8);
                        AppMethodBeat.o(37264);
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(37265);
                        try {
                            w.this.Y(BitmapFactory.decodeFile(str));
                            AppMethodBeat.o(37265);
                        } catch (Exception e) {
                            ab.e("AdLandingPagePureImageComponet", "%s" + bo.l(e));
                            AppMethodBeat.o(37265);
                        }
                    }
                });
                AppMethodBeat.o(37268);
                return;
            }
            ab.i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
            this.qZh = true;
            AppMethodBeat.o(37268);
        }
    }

    public final void startLoading() {
        AppMethodBeat.i(37269);
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(37269);
    }

    public final boolean Y(Bitmap bitmap) {
        AppMethodBeat.i(37270);
        if (bitmap == null) {
            ab.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            AppMethodBeat.o(37270);
            return false;
        } else if (this.cAw == null) {
            ab.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            AppMethodBeat.o(37270);
            return false;
        } else if (bitmap.getWidth() == 0) {
            ab.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            AppMethodBeat.o(37270);
            return false;
        } else {
            this.cAw.setImageBitmap(bitmap);
            this.progressBar.setVisibility(8);
            AppMethodBeat.o(37270);
            return true;
        }
    }

    public final boolean al(JSONObject jSONObject) {
        AppMethodBeat.i(37271);
        if (super.al(jSONObject)) {
            try {
                if (!this.qZh) {
                    String ck = ag.ck(((n) this.qZo).qWD);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("imgUrlInfo", jSONObject2);
                }
                AppMethodBeat.o(37271);
                return true;
            } catch (JSONException e) {
                ab.printErrStackTrace("AdLandingPagePureImageComponet", e, "", new Object[0]);
                AppMethodBeat.o(37271);
                return false;
            }
        }
        AppMethodBeat.o(37271);
        return false;
    }
}
