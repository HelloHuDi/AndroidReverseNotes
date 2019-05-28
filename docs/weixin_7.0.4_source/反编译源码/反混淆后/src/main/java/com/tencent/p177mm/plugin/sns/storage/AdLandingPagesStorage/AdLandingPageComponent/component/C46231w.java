package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w */
public final class C46231w extends C13437h {
    private ImageView cAw;
    ProgressBar progressBar;
    boolean qWC;
    boolean qZh = true;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w$1 */
    class C219611 implements C3951a {
        C219611() {
        }

        public final void cpu() {
            AppMethodBeat.m2504i(37263);
            C46231w.this.startLoading();
            AppMethodBeat.m2505o(37263);
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37264);
            C46231w.this.progressBar.setVisibility(8);
            AppMethodBeat.m2505o(37264);
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37265);
            try {
                C46231w.this.mo74246Y(BitmapFactory.decodeFile(str));
                AppMethodBeat.m2505o(37265);
            } catch (Exception e) {
                C4990ab.m7412e("AdLandingPagePureImageComponet", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37265);
            }
        }
    }

    public C46231w(Context context, C39780n c39780n, ViewGroup viewGroup) {
        super(context, c39780n, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970728;
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37266);
        this.cAw = (ImageView) this.contentView.findViewById(2131827632);
        this.progressBar = (ProgressBar) this.contentView.findViewById(2131821219);
        AppMethodBeat.m2505o(37266);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37267);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins((int) ((C39780n) this.qZo).qWS, (int) ((C39780n) this.qZo).qWQ, (int) ((C39780n) this.qZo).qWT, (int) ((C39780n) this.qZo).qWR);
            this.contentView.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.m2505o(37267);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37268);
        if (this.contentView == null || this.cAw == null || this.progressBar == null) {
            AppMethodBeat.m2505o(37268);
        } else if (((C39780n) this.qZo) == null) {
            AppMethodBeat.m2505o(37268);
        } else {
            String str = ((C39780n) this.qZo).qWD;
            String str2 = ((C39780n) this.qZo).qWE;
            float f = ((C39780n) this.qZo).height;
            float f2 = ((C39780n) this.qZo).width;
            this.qWC = ((C39780n) this.qZo).qWC;
            if (f != 0.0f && f2 != 0.0f && !this.qWC) {
                int i = (this.ieu - ((int) ((C39780n) this.qZo).qWS)) - ((int) ((C39780n) this.qZo).qWT);
                if (f2 >= ((float) i)) {
                    f2 = (float) i;
                }
                this.cAw.setLayoutParams(new RelativeLayout.LayoutParams((int) f2, (int) ((f2 * ((C39780n) this.qZo).height) / ((C39780n) this.qZo).width)));
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
                C4990ab.m7416i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
                AppMethodBeat.m2505o(37268);
                return;
            }
            Bitmap gm = C13473h.m21628gm("adId", str);
            if (gm == null || !mo74246Y(gm)) {
                this.qZh = false;
                startLoading();
                C13473h.m21619a(str, ((C39780n) this.qZo).qWP, new C219611());
                AppMethodBeat.m2505o(37268);
                return;
            }
            C4990ab.m7416i("AdLandingPagePureImageComponet", "loaded cached image with  ".concat(String.valueOf(str)));
            this.qZh = true;
            AppMethodBeat.m2505o(37268);
        }
    }

    public final void startLoading() {
        AppMethodBeat.m2504i(37269);
        this.progressBar.setVisibility(0);
        AppMethodBeat.m2505o(37269);
    }

    /* renamed from: Y */
    public final boolean mo74246Y(Bitmap bitmap) {
        AppMethodBeat.m2504i(37270);
        if (bitmap == null) {
            C4990ab.m7412e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            AppMethodBeat.m2505o(37270);
            return false;
        } else if (this.cAw == null) {
            C4990ab.m7412e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            AppMethodBeat.m2505o(37270);
            return false;
        } else if (bitmap.getWidth() == 0) {
            C4990ab.m7412e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            AppMethodBeat.m2505o(37270);
            return false;
        } else {
            this.cAw.setImageBitmap(bitmap);
            this.progressBar.setVisibility(8);
            AppMethodBeat.m2505o(37270);
            return true;
        }
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37271);
        if (super.mo15456al(jSONObject)) {
            try {
                if (!this.qZh) {
                    String ck = C4995ag.m7428ck(((C39780n) this.qZo).qWD);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("imgUrlInfo", jSONObject2);
                }
                AppMethodBeat.m2505o(37271);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("AdLandingPagePureImageComponet", e, "", new Object[0]);
                AppMethodBeat.m2505o(37271);
                return false;
            }
        }
        AppMethodBeat.m2505o(37271);
        return false;
    }
}
