package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e */
public final class C46228e extends C13437h {
    ImageView cAw;
    ProgressBar progressBar;
    boolean qZh;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e$1 */
    class C134361 implements C3951a {
        C134361() {
        }

        public final void cpu() {
            AppMethodBeat.m2504i(37049);
            C46228e.this.startLoading();
            AppMethodBeat.m2505o(37049);
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37050);
            C46228e.this.stopLoading();
            AppMethodBeat.m2505o(37050);
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37051);
            try {
                C46228e.this.stopLoading();
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                C46228e c46228e = C46228e.this;
                if (decodeFile == null) {
                    C4990ab.m7412e("AdLandingImageComp", "when set image the bmp is null!");
                    AppMethodBeat.m2505o(37051);
                } else if (c46228e.cAw == null) {
                    C4990ab.m7412e("AdLandingImageComp", "when set image the imageView is null!");
                    AppMethodBeat.m2505o(37051);
                } else if (decodeFile.getWidth() == 0) {
                    C4990ab.m7412e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                    AppMethodBeat.m2505o(37051);
                } else {
                    c46228e.cAw.setImageBitmap(decodeFile);
                    c46228e.progressBar.setVisibility(8);
                    AppMethodBeat.m2505o(37051);
                }
            } catch (Exception e) {
                C4990ab.m7412e("AdLandingImageComp", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37051);
            }
        }
    }

    public C46228e(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private C46228e(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.qZh = true;
    }

    public final void cpk() {
        AppMethodBeat.m2504i(37052);
        View view = this.contentView;
        this.cAw = (ImageView) view.findViewById(2131827632);
        this.progressBar = (ProgressBar) view.findViewById(2131821219);
        AppMethodBeat.m2505o(37052);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayout() {
        return 2130970723;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37053);
        if (this.contentView == null || this.cAw == null || this.progressBar == null) {
            AppMethodBeat.m2505o(37053);
        } else if (((C39780n) this.qZo) == null) {
            AppMethodBeat.m2505o(37053);
        } else {
            float f = ((C39780n) this.qZo).qWQ;
            float f2 = ((C39780n) this.qZo).qWR;
            float f3 = ((C39780n) this.qZo).qWS;
            float f4 = ((C39780n) this.qZo).qWT;
            String str = ((C39780n) this.qZo).qWD;
            float f5 = ((C39780n) this.qZo).height;
            LayoutParams layoutParams = (LayoutParams) this.cAw.getLayoutParams();
            layoutParams.width = (int) ((C39780n) this.qZo).width;
            layoutParams.height = (int) f5;
            this.cAw.setLayoutParams(layoutParams);
            this.qZh = false;
            startLoading();
            C13473h.m21619a(str, ((C39780n) this.qZo).qWP, new C134361());
            this.contentView.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            AppMethodBeat.m2505o(37053);
        }
    }

    public final void startLoading() {
        AppMethodBeat.m2504i(37054);
        this.progressBar.setVisibility(0);
        AppMethodBeat.m2505o(37054);
    }

    public final void stopLoading() {
        AppMethodBeat.m2504i(37055);
        this.progressBar.setVisibility(8);
        AppMethodBeat.m2505o(37055);
    }

    /* renamed from: al */
    public final boolean mo15456al(JSONObject jSONObject) {
        AppMethodBeat.m2504i(37056);
        if (super.mo15456al(jSONObject)) {
            try {
                if (!this.qZh) {
                    String ck = C4995ag.m7428ck(((C39780n) this.qZo).qWD);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("urlMd5", ck);
                    jSONObject2.put("needDownload", 1);
                    jSONObject.put("imgUrlInfo", jSONObject2);
                }
                AppMethodBeat.m2505o(37056);
                return true;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("AdLandingImageComp", e, "", new Object[0]);
                AppMethodBeat.m2505o(37056);
                return false;
            }
        }
        AppMethodBeat.m2505o(37056);
        return false;
    }
}
