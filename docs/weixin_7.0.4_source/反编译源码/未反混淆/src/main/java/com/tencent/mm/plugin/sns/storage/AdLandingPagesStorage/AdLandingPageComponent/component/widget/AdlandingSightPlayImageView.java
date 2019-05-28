package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.memory.ui.QPictureView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public class AdlandingSightPlayImageView extends QPictureView {
    public com.tencent.mm.pluginsdk.ui.tools.e.a llE;
    private int qyC;
    private int qyD;
    private int qyE;
    private int qyF;
    public boolean qyG;
    private boolean qyH;
    private boolean qyI;
    b rcz;

    static final class a extends b {
        private WeakReference<AdlandingSightPlayImageView> qyB;

        /* Access modifiers changed, original: protected|final */
        public final int ckZ() {
            return R.anim.d8;
        }

        public a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
            super(adlandingSightPlayImageView);
            AppMethodBeat.i(37436);
            this.qyB = new WeakReference(adlandingSightPlayImageView);
            AppMethodBeat.o(37436);
        }

        public final void dH(int i, int i2) {
            AppMethodBeat.i(37437);
            final AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.qyB.get();
            if (adlandingSightPlayImageView == null) {
                ab.e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
                AppMethodBeat.o(37437);
            } else if (adlandingSightPlayImageView.qyI) {
                AppMethodBeat.o(37437);
            } else {
                adlandingSightPlayImageView.qyE = i;
                adlandingSightPlayImageView.qyF = i2;
                if (adlandingSightPlayImageView.llE != null) {
                    adlandingSightPlayImageView.llE.dH(i, i2);
                }
                if (adlandingSightPlayImageView.qyH) {
                    if (adlandingSightPlayImageView.qyE >= adlandingSightPlayImageView.qyF) {
                        adlandingSightPlayImageView.qyC = com.tencent.mm.bz.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 150);
                    } else {
                        adlandingSightPlayImageView.qyC = com.tencent.mm.bz.a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85);
                    }
                }
                if (adlandingSightPlayImageView.qyC > 0) {
                    final LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == adlandingSightPlayImageView.qyC && layoutParams.height == (adlandingSightPlayImageView.qyC * i2) / i)) {
                        layoutParams.width = adlandingSightPlayImageView.qyC;
                        layoutParams.height = (adlandingSightPlayImageView.qyC * i2) / i;
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(37435);
                                adlandingSightPlayImageView.setLayoutParams(layoutParams);
                                AppMethodBeat.o(37435);
                            }
                        });
                        adlandingSightPlayImageView.postInvalidate();
                    }
                    ab.i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                ab.i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(adlandingSightPlayImageView.qyC), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.o(37437);
            }
        }

        public final void U(Bitmap bitmap) {
            AppMethodBeat.i(37438);
            AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.qyB.get();
            if (adlandingSightPlayImageView == null) {
                ab.e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.o(37438);
                return;
            }
            adlandingSightPlayImageView.setImageBitmap(bitmap);
            AppMethodBeat.o(37438);
        }
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(37439);
        this.qyG = true;
        this.qyH = false;
        this.qyI = false;
        this.rcz = new a(this);
        ab.i("MicroMsg.SightPlayImageView", "mController %s", bo.dpG().toString());
        AppMethodBeat.o(37439);
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.rcz.ien;
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(37440);
        super.setImageBitmap(bitmap);
        if (this.qyI) {
            AppMethodBeat.o(37440);
            return;
        }
        int height = bitmap == null ? this.qyD == 0 ? 240 : this.qyD : bitmap.getHeight();
        int width = bitmap == null ? this.qyC == 0 ? 320 : this.qyC : bitmap.getWidth();
        LayoutParams layoutParams = getLayoutParams();
        if (((float) layoutParams.height) != ((float) (this.qyC * height)) / ((float) width)) {
            layoutParams.width = this.qyC;
            layoutParams.height = (int) ((((float) height) * ((float) this.qyC)) / ((float) width));
            setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(37440);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(37441);
        super.setImageDrawable(drawable);
        if (this.qyI) {
            AppMethodBeat.o(37441);
            return;
        }
        int intrinsicHeight = drawable == null ? this.qyD == 0 ? 240 : this.qyD : drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable == null ? this.qyC == 0 ? 320 : this.qyC : drawable.getIntrinsicWidth();
        if (!(intrinsicHeight == 0 || intrinsicWidth == 0)) {
            LayoutParams layoutParams = getLayoutParams();
            if (((float) layoutParams.height) != (((float) this.qyC) * ((float) intrinsicHeight)) / ((float) intrinsicWidth)) {
                layoutParams.width = this.qyC;
                layoutParams.height = (int) ((((float) intrinsicHeight) * ((float) this.qyC)) / ((float) intrinsicWidth));
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(37441);
    }

    public final void V(Bitmap bitmap) {
        AppMethodBeat.i(37442);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(37442);
    }

    public final void bf(String str, boolean z) {
        AppMethodBeat.i(37443);
        b bVar = this.rcz;
        ab.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(bVar.hashCode()), str, bVar.ien, Boolean.valueOf(z), Integer.valueOf(bVar.qxo), Boolean.valueOf(bVar.qxR), Boolean.valueOf(bVar.qxI));
        if (bVar.qxR) {
            bVar.kz(false);
            AppMethodBeat.o(37443);
        } else if (bVar.clb()) {
            ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            bVar.clear();
            AppMethodBeat.o(37443);
        } else if (!bVar.qxI) {
            bVar.clear();
            AppMethodBeat.o(37443);
        } else if (z) {
            bVar.qxn = str;
            bVar.kz(false);
            AppMethodBeat.o(37443);
        } else if (bVar.ien.equals(str)) {
            bVar.qxn = "ERROR#PATH";
            bVar.kz(false);
            bVar.restart();
            AppMethodBeat.o(37443);
        } else {
            bVar.clear();
            if (str == null) {
                str = "";
            }
            bVar.ien = str;
            if (bo.isNullOrNil(bVar.ien)) {
                ab.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                bVar.cpV();
                AppMethodBeat.o(37443);
            } else if (b.WS(bVar.ien)) {
                bVar.rci = new h(bVar, (byte) 0);
                o.i(bVar.rci, 0);
                AppMethodBeat.o(37443);
            } else {
                ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                bVar.clear();
                AppMethodBeat.o(37443);
            }
        }
    }

    public void setPosition(int i) {
        this.rcz.position = i;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(37444);
        super.onDetachedFromWindow();
        ab.i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.rcz.clear();
        com.tencent.mm.sdk.b.a.xxA.d(this.rcz.cld());
        AppMethodBeat.o(37444);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(37445);
        ab.d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xxA.c(this.rcz.cld());
        AppMethodBeat.o(37445);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.i(37446);
        this.qyG = false;
        this.qyC = i;
        if (this.qyE > 0 && this.qyF > 0) {
            LayoutParams layoutParams = getLayoutParams();
            this.qyD = (this.qyC * this.qyF) / this.qyE;
            if (!(layoutParams.width == this.qyC && layoutParams.height == this.qyD)) {
                layoutParams.width = this.qyC;
                layoutParams.height = this.qyD;
                setLayoutParams(layoutParams);
            }
        }
        AppMethodBeat.o(37446);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(37447);
        setImageBitmap(bitmap);
        AppMethodBeat.o(37447);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(37448);
        setTag(obj);
        AppMethodBeat.o(37448);
    }

    public Object getTagObject() {
        AppMethodBeat.i(37449);
        Object tag = getTag();
        AppMethodBeat.o(37449);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(37450);
        Context context = getContext();
        AppMethodBeat.o(37450);
        return context;
    }

    public void setCanPlay(boolean z) {
        this.rcz.qxI = z;
    }

    public void setOnCompletionListener(e eVar) {
        this.rcz.rcq = eVar;
    }

    public void setOnSightCompletionAction(g gVar) {
        this.rcz.rcs = gVar;
    }

    public void setOnDecodeDurationListener(f fVar) {
        this.rcz.rcr = fVar;
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(37451);
        this.rcz.qxu = new WeakReference(view);
        AppMethodBeat.o(37451);
    }

    public void setIsWhatsNew(boolean z) {
        this.rcz.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(37452);
        this.rcz.qxv = new WeakReference(textView);
        AppMethodBeat.o(37452);
    }

    public final void kA(boolean z) {
        AppMethodBeat.i(37453);
        b bVar = this.rcz;
        ab.i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (bVar.rck != null) {
                bVar.rck.type = 0;
                o.i(bVar.rck, 0);
            }
            bVar.rck = null;
        } else if (bVar.rck == null) {
            bVar.rck = new i(bVar, (byte) 0);
            AppMethodBeat.o(37453);
            return;
        }
        AppMethodBeat.o(37453);
    }

    public void setForceRecordState(boolean z) {
    }

    public b getController() {
        return this.rcz;
    }

    public int getDuration() {
        AppMethodBeat.i(37454);
        if (this.rcz == null) {
            AppMethodBeat.o(37454);
            return 0;
        }
        double d;
        b bVar = this.rcz;
        if (bVar.qxo == -1) {
            d = 0.0d;
        } else {
            d = SightVideoJNI.getVideoDuration(bVar.qxo);
        }
        int i = (int) d;
        AppMethodBeat.o(37454);
        return i;
    }

    public void setLoopImp(boolean z) {
        if (this.rcz != null) {
            this.rcz.fVc = z;
        }
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(37455);
        super.onDraw(canvas);
        AppMethodBeat.o(37455);
    }
}
