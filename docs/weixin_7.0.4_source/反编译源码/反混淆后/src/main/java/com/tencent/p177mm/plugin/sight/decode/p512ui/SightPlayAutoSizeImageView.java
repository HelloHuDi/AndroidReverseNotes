package com.tencent.p177mm.plugin.sight.decode.p512ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13304e;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13321g;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b.C13325f;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView */
public class SightPlayAutoSizeImageView extends ImageView implements C34915a {
    private C13303b qyA;

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.SightPlayAutoSizeImageView$a */
    static final class C3849a extends C13303b {
        private WeakReference<SightPlayAutoSizeImageView> qyB;

        public final int ckZ() {
            return C25738R.anim.f8397d8;
        }

        public C3849a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
            super(0, sightPlayAutoSizeImageView);
            AppMethodBeat.m2504i(24956);
            this.qyB = new WeakReference(sightPlayAutoSizeImageView);
            AppMethodBeat.m2505o(24956);
        }

        /* renamed from: dH */
        public final void mo8534dH(int i, int i2) {
        }

        /* renamed from: U */
        public final void mo8532U(Bitmap bitmap) {
            AppMethodBeat.m2504i(24957);
            SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.qyB.get();
            if (sightPlayAutoSizeImageView == null) {
                C4990ab.m7412e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.m2505o(24957);
                return;
            }
            sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
            sightPlayAutoSizeImageView.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(24957);
        }
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(24958);
        this.qyA = new C3849a(this);
        AppMethodBeat.m2505o(24958);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.qyA.ien;
    }

    public final void clear() {
        AppMethodBeat.m2504i(24959);
        this.qyA.clear();
        AppMethodBeat.m2505o(24959);
    }

    /* renamed from: bf */
    public final void mo8509bf(String str, boolean z) {
        AppMethodBeat.m2504i(24960);
        this.qyA.mo25372bf(str, z);
        AppMethodBeat.m2505o(24960);
    }

    public final boolean ckY() {
        AppMethodBeat.m2504i(24961);
        boolean clb = this.qyA.clb();
        AppMethodBeat.m2505o(24961);
        return clb;
    }

    public void setPosition(int i) {
        this.qyA.position = i;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(24962);
        super.onDetachedFromWindow();
        C4990ab.m7417i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qyA.clear();
        C4879a.xxA.mo10053d(this.qyA.cld());
        AppMethodBeat.m2505o(24962);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(24963);
        C4990ab.m7411d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        C4879a.xxA.mo10052c(this.qyA.cld());
        AppMethodBeat.m2505o(24963);
    }

    public void setDrawableWidth(int i) {
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.m2504i(24964);
        setImageBitmap(bitmap);
        AppMethodBeat.m2505o(24964);
    }

    public final void ckX() {
        AppMethodBeat.m2504i(24965);
        setImageBitmap(null);
        setImageResource(C25738R.drawable.ak_);
        AppMethodBeat.m2505o(24965);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.m2504i(24966);
        setTag(obj);
        AppMethodBeat.m2505o(24966);
    }

    public Object getTagObject() {
        AppMethodBeat.m2504i(24967);
        Object tag = getTag();
        AppMethodBeat.m2505o(24967);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.m2504i(24968);
        Context context = getContext();
        AppMethodBeat.m2505o(24968);
        return context;
    }

    /* renamed from: fi */
    public final void mo8513fi(int i, int i2) {
    }

    public void setCanPlay(boolean z) {
        this.qyA.qxI = z;
    }

    public void setOnCompletionListener(C13304e c13304e) {
        this.qyA.qxT = c13304e;
    }

    public void setOnSightCompletionAction(C13321g c13321g) {
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.m2504i(24969);
        this.qyA.setThumbBgView(view);
        AppMethodBeat.m2505o(24969);
    }

    public void setIsWhatsNew(boolean z) {
        this.qyA.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.m2504i(24970);
        this.qyA.setSightInfoView(textView);
        AppMethodBeat.m2505o(24970);
    }

    public void setForceRecordState(boolean z) {
        this.qyA.qxR = z;
    }

    public void setOnDecodeDurationListener(C13325f c13325f) {
        this.qyA.qxU = c13325f;
    }
}
