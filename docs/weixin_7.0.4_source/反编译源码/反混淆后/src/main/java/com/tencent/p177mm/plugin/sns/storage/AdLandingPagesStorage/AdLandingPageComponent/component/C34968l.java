package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C39780n;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l */
public final class C34968l extends C13437h {
    CircularImageView qZE;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l$1 */
    class C349691 implements C3951a {
        C349691() {
        }

        public final void cpu() {
        }

        public final void cmD() {
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37096);
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                C34968l c34968l = C34968l.this;
                if (decodeFile == null) {
                    C4990ab.m7412e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                    AppMethodBeat.m2505o(37096);
                } else if (c34968l.qZE == null) {
                    C4990ab.m7412e("AdLandingPageCircleImgComp", "when set image the img is null!");
                    AppMethodBeat.m2505o(37096);
                } else if (decodeFile.getWidth() == 0) {
                    C4990ab.m7412e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                    AppMethodBeat.m2505o(37096);
                } else {
                    c34968l.qZE.setImageBitmap(decodeFile);
                    AppMethodBeat.m2505o(37096);
                }
            } catch (Exception e) {
                C4990ab.m7412e("AdLandingPageCircleImgComp", "%s" + C5046bo.m7574l(e));
                AppMethodBeat.m2505o(37096);
            }
        }
    }

    public C34968l(Context context, C39780n c39780n, ViewGroup viewGroup) {
        super(context, c39780n, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.m2504i(37097);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(37097);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.m2504i(37098);
        CircularImageView circularImageView = new CircularImageView(this.context);
        AppMethodBeat.m2505o(37098);
        return circularImageView;
    }

    public final void cpk() {
        this.qZE = (CircularImageView) this.contentView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.m2504i(37099);
        if (this.contentView == null || this.qZE == null) {
            AppMethodBeat.m2505o(37099);
            return;
        }
        C39780n c39780n = (C39780n) this.qZo;
        if (c39780n == null) {
            AppMethodBeat.m2505o(37099);
            return;
        }
        C13473h.m21619a(c39780n.qWD, c39780n.qWP, new C349691());
        AppMethodBeat.m2505o(37099);
    }
}
