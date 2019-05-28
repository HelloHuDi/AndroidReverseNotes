package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l extends h {
    CircularImageView qZE;

    public l(Context context, n nVar, ViewGroup viewGroup) {
        super(context, nVar, viewGroup);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpq() {
        AppMethodBeat.i(37097);
        LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins((int) this.qZo.qWS, (int) this.qZo.qWQ, (int) this.qZo.qWT, (int) this.qZo.qWR);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(37097);
    }

    /* Access modifiers changed, original: protected|final */
    public final View cpr() {
        AppMethodBeat.i(37098);
        CircularImageView circularImageView = new CircularImageView(this.context);
        AppMethodBeat.o(37098);
        return circularImageView;
    }

    public final void cpk() {
        this.qZE = (CircularImageView) this.contentView;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cpp() {
        AppMethodBeat.i(37099);
        if (this.contentView == null || this.qZE == null) {
            AppMethodBeat.o(37099);
            return;
        }
        n nVar = (n) this.qZo;
        if (nVar == null) {
            AppMethodBeat.o(37099);
            return;
        }
        h.a(nVar.qWD, nVar.qWP, new a() {
            public final void cpu() {
            }

            public final void cmD() {
            }

            public final void YJ(String str) {
                AppMethodBeat.i(37096);
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    l lVar = l.this;
                    if (decodeFile == null) {
                        ab.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                        AppMethodBeat.o(37096);
                    } else if (lVar.qZE == null) {
                        ab.e("AdLandingPageCircleImgComp", "when set image the img is null!");
                        AppMethodBeat.o(37096);
                    } else if (decodeFile.getWidth() == 0) {
                        ab.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                        AppMethodBeat.o(37096);
                    } else {
                        lVar.qZE.setImageBitmap(decodeFile);
                        AppMethodBeat.o(37096);
                    }
                } catch (Exception e) {
                    ab.e("AdLandingPageCircleImgComp", "%s" + bo.l(e));
                    AppMethodBeat.o(37096);
                }
            }
        });
        AppMethodBeat.o(37099);
    }
}
