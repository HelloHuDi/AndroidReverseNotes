package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.p1206ui.QPictureView;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3926e;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3927f;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3928g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3929i;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3919b.C3932h;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView */
public class AdlandingSightPlayImageView extends QPictureView {
    public C14981a llE;
    private int qyC;
    private int qyD;
    private int qyE;
    private int qyF;
    public boolean qyG;
    private boolean qyH;
    private boolean qyI;
    C3919b rcz;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayImageView$a */
    static final class C13445a extends C3919b {
        private WeakReference<AdlandingSightPlayImageView> qyB;

        /* Access modifiers changed, original: protected|final */
        public final int ckZ() {
            return C25738R.anim.f8397d8;
        }

        public C13445a(AdlandingSightPlayImageView adlandingSightPlayImageView) {
            super(adlandingSightPlayImageView);
            AppMethodBeat.m2504i(37436);
            this.qyB = new WeakReference(adlandingSightPlayImageView);
            AppMethodBeat.m2505o(37436);
        }

        /* renamed from: dH */
        public final void mo8673dH(int i, int i2) {
            AppMethodBeat.m2504i(37437);
            final AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.qyB.get();
            if (adlandingSightPlayImageView == null) {
                C4990ab.m7412e("MicroMsg.SightPlayImageView", "onGetVideoSizeEnd, imageView is null, do clear");
                clear();
                AppMethodBeat.m2505o(37437);
            } else if (adlandingSightPlayImageView.qyI) {
                AppMethodBeat.m2505o(37437);
            } else {
                adlandingSightPlayImageView.qyE = i;
                adlandingSightPlayImageView.qyF = i2;
                if (adlandingSightPlayImageView.llE != null) {
                    adlandingSightPlayImageView.llE.mo8555dH(i, i2);
                }
                if (adlandingSightPlayImageView.qyH) {
                    if (adlandingSightPlayImageView.qyE >= adlandingSightPlayImageView.qyF) {
                        adlandingSightPlayImageView.qyC = C1338a.fromDPToPix(adlandingSightPlayImageView.getContext(), 150);
                    } else {
                        adlandingSightPlayImageView.qyC = C1338a.fromDPToPix(adlandingSightPlayImageView.getContext(), 85);
                    }
                }
                if (adlandingSightPlayImageView.qyC > 0) {
                    final LayoutParams layoutParams = adlandingSightPlayImageView.getLayoutParams();
                    if (!(layoutParams.width == adlandingSightPlayImageView.qyC && layoutParams.height == (adlandingSightPlayImageView.qyC * i2) / i)) {
                        layoutParams.width = adlandingSightPlayImageView.qyC;
                        layoutParams.height = (adlandingSightPlayImageView.qyC * i2) / i;
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(37435);
                                adlandingSightPlayImageView.setLayoutParams(layoutParams);
                                AppMethodBeat.m2505o(37435);
                            }
                        });
                        adlandingSightPlayImageView.postInvalidate();
                    }
                    C4990ab.m7417i("MicroMsg.SightPlayImageView", "onGetVideoSize::params width %d height %d", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                }
                C4990ab.m7417i("MicroMsg.SightPlayImageView", "onGetVideoSize::DrawWidth %d, video size %d*%d", Integer.valueOf(adlandingSightPlayImageView.qyC), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(37437);
            }
        }

        /* renamed from: U */
        public final void mo8665U(Bitmap bitmap) {
            AppMethodBeat.m2504i(37438);
            AdlandingSightPlayImageView adlandingSightPlayImageView = (AdlandingSightPlayImageView) this.qyB.get();
            if (adlandingSightPlayImageView == null) {
                C4990ab.m7412e("MicroMsg.SightPlayImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.m2505o(37438);
                return;
            }
            adlandingSightPlayImageView.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(37438);
        }
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(37439);
        this.qyG = true;
        this.qyH = false;
        this.qyI = false;
        this.rcz = new C13445a(this);
        C4990ab.m7417i("MicroMsg.SightPlayImageView", "mController %s", C5046bo.dpG().toString());
        AppMethodBeat.m2505o(37439);
    }

    public AdlandingSightPlayImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.rcz.ien;
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(37440);
        super.setImageBitmap(bitmap);
        if (this.qyI) {
            AppMethodBeat.m2505o(37440);
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
        AppMethodBeat.m2505o(37440);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(37441);
        super.setImageDrawable(drawable);
        if (this.qyI) {
            AppMethodBeat.m2505o(37441);
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
        AppMethodBeat.m2505o(37441);
    }

    /* renamed from: V */
    public final void mo62870V(Bitmap bitmap) {
        AppMethodBeat.m2504i(37442);
        super.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(37442);
    }

    /* renamed from: bf */
    public final void mo62871bf(String str, boolean z) {
        AppMethodBeat.m2504i(37443);
        C3919b c3919b = this.rcz;
        C4990ab.m7417i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(c3919b.hashCode()), str, c3919b.ien, Boolean.valueOf(z), Integer.valueOf(c3919b.qxo), Boolean.valueOf(c3919b.qxR), Boolean.valueOf(c3919b.qxI));
        if (c3919b.qxR) {
            c3919b.mo8674kz(false);
            AppMethodBeat.m2505o(37443);
        } else if (c3919b.clb()) {
            C4990ab.m7412e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            c3919b.clear();
            AppMethodBeat.m2505o(37443);
        } else if (!c3919b.qxI) {
            c3919b.clear();
            AppMethodBeat.m2505o(37443);
        } else if (z) {
            c3919b.qxn = str;
            c3919b.mo8674kz(false);
            AppMethodBeat.m2505o(37443);
        } else if (c3919b.ien.equals(str)) {
            c3919b.qxn = "ERROR#PATH";
            c3919b.mo8674kz(false);
            c3919b.restart();
            AppMethodBeat.m2505o(37443);
        } else {
            c3919b.clear();
            if (str == null) {
                str = "";
            }
            c3919b.ien = str;
            if (C5046bo.isNullOrNil(c3919b.ien)) {
                C4990ab.m7420w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                c3919b.cpV();
                AppMethodBeat.m2505o(37443);
            } else if (C3919b.m6212WS(c3919b.ien)) {
                c3919b.rci = new C3932h(c3919b, (byte) 0);
                C37961o.m64222i(c3919b.rci, 0);
                AppMethodBeat.m2505o(37443);
            } else {
                C4990ab.m7420w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                c3919b.clear();
                AppMethodBeat.m2505o(37443);
            }
        }
    }

    public void setPosition(int i) {
        this.rcz.position = i;
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(37444);
        super.onDetachedFromWindow();
        C4990ab.m7417i("MicroMsg.SightPlayImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.rcz.clear();
        C4879a.xxA.mo10053d(this.rcz.cld());
        AppMethodBeat.m2505o(37444);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(37445);
        C4990ab.m7411d("MicroMsg.SightPlayImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        C4879a.xxA.mo10052c(this.rcz.cld());
        AppMethodBeat.m2505o(37445);
    }

    public void setDrawableWidth(int i) {
        AppMethodBeat.m2504i(37446);
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
        AppMethodBeat.m2505o(37446);
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.m2504i(37447);
        setImageBitmap(bitmap);
        AppMethodBeat.m2505o(37447);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.m2504i(37448);
        setTag(obj);
        AppMethodBeat.m2505o(37448);
    }

    public Object getTagObject() {
        AppMethodBeat.m2504i(37449);
        Object tag = getTag();
        AppMethodBeat.m2505o(37449);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.m2504i(37450);
        Context context = getContext();
        AppMethodBeat.m2505o(37450);
        return context;
    }

    public void setCanPlay(boolean z) {
        this.rcz.qxI = z;
    }

    public void setOnCompletionListener(C3926e c3926e) {
        this.rcz.rcq = c3926e;
    }

    public void setOnSightCompletionAction(C3928g c3928g) {
        this.rcz.rcs = c3928g;
    }

    public void setOnDecodeDurationListener(C3927f c3927f) {
        this.rcz.rcr = c3927f;
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.m2504i(37451);
        this.rcz.qxu = new WeakReference(view);
        AppMethodBeat.m2505o(37451);
    }

    public void setIsWhatsNew(boolean z) {
        this.rcz.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.m2504i(37452);
        this.rcz.qxv = new WeakReference(textView);
        AppMethodBeat.m2505o(37452);
    }

    /* renamed from: kA */
    public final void mo62876kA(boolean z) {
        AppMethodBeat.m2504i(37453);
        C3919b c3919b = this.rcz;
        C4990ab.m7417i("MicroMsg.SightPlayController", "configure: need sound %B", Boolean.valueOf(z));
        if (!z) {
            if (c3919b.rck != null) {
                c3919b.rck.type = 0;
                C37961o.m64222i(c3919b.rck, 0);
            }
            c3919b.rck = null;
        } else if (c3919b.rck == null) {
            c3919b.rck = new C3929i(c3919b, (byte) 0);
            AppMethodBeat.m2505o(37453);
            return;
        }
        AppMethodBeat.m2505o(37453);
    }

    public void setForceRecordState(boolean z) {
    }

    public C3919b getController() {
        return this.rcz;
    }

    public int getDuration() {
        AppMethodBeat.m2504i(37454);
        if (this.rcz == null) {
            AppMethodBeat.m2505o(37454);
            return 0;
        }
        double d;
        C3919b c3919b = this.rcz;
        if (c3919b.qxo == -1) {
            d = 0.0d;
        } else {
            d = SightVideoJNI.getVideoDuration(c3919b.qxo);
        }
        int i = (int) d;
        AppMethodBeat.m2505o(37454);
        return i;
    }

    public void setLoopImp(boolean z) {
        if (this.rcz != null) {
            this.rcz.fVc = z;
        }
    }

    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(37455);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(37455);
    }
}
