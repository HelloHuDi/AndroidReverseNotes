package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.a.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public class SightPlayAutoSizeImageView extends ImageView implements com.tencent.mm.plugin.sight.decode.a.a {
    private b qyA;

    static final class a extends b {
        private WeakReference<SightPlayAutoSizeImageView> qyB;

        public final int ckZ() {
            return R.anim.d8;
        }

        public a(SightPlayAutoSizeImageView sightPlayAutoSizeImageView) {
            super(0, sightPlayAutoSizeImageView);
            AppMethodBeat.i(24956);
            this.qyB = new WeakReference(sightPlayAutoSizeImageView);
            AppMethodBeat.o(24956);
        }

        public final void dH(int i, int i2) {
        }

        public final void U(Bitmap bitmap) {
            AppMethodBeat.i(24957);
            SightPlayAutoSizeImageView sightPlayAutoSizeImageView = (SightPlayAutoSizeImageView) this.qyB.get();
            if (sightPlayAutoSizeImageView == null) {
                ab.e("MicroMsg.SightPlayAutoSizeImageView", "onGetFrameBmp, imageView is null, do clear");
                clear();
                AppMethodBeat.o(24957);
                return;
            }
            sightPlayAutoSizeImageView.setScaleType(ScaleType.CENTER_CROP);
            sightPlayAutoSizeImageView.setImageBitmap(bitmap);
            AppMethodBeat.o(24957);
        }
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(24958);
        this.qyA = new a(this);
        AppMethodBeat.o(24958);
    }

    public SightPlayAutoSizeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public String getVideoPath() {
        return this.qyA.ien;
    }

    public final void clear() {
        AppMethodBeat.i(24959);
        this.qyA.clear();
        AppMethodBeat.o(24959);
    }

    public final void bf(String str, boolean z) {
        AppMethodBeat.i(24960);
        this.qyA.bf(str, z);
        AppMethodBeat.o(24960);
    }

    public final boolean ckY() {
        AppMethodBeat.i(24961);
        boolean clb = this.qyA.clb();
        AppMethodBeat.o(24961);
        return clb;
    }

    public void setPosition(int i) {
        this.qyA.position = i;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(24962);
        super.onDetachedFromWindow();
        ab.i("MicroMsg.SightPlayAutoSizeImageView", "#0x%x clear, on deattached to window", Integer.valueOf(hashCode()));
        this.qyA.clear();
        com.tencent.mm.sdk.b.a.xxA.d(this.qyA.cld());
        AppMethodBeat.o(24962);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(24963);
        ab.d("MicroMsg.SightPlayAutoSizeImageView", "#0x%x on attached from window", Integer.valueOf(hashCode()));
        super.onAttachedToWindow();
        com.tencent.mm.sdk.b.a.xxA.c(this.qyA.cld());
        AppMethodBeat.o(24963);
    }

    public void setDrawableWidth(int i) {
    }

    public void setThumbBmp(Bitmap bitmap) {
        AppMethodBeat.i(24964);
        setImageBitmap(bitmap);
        AppMethodBeat.o(24964);
    }

    public final void ckX() {
        AppMethodBeat.i(24965);
        setImageBitmap(null);
        setImageResource(R.drawable.ak_);
        AppMethodBeat.o(24965);
    }

    public void setMaskID(int i) {
    }

    public void setTagObject(Object obj) {
        AppMethodBeat.i(24966);
        setTag(obj);
        AppMethodBeat.o(24966);
    }

    public Object getTagObject() {
        AppMethodBeat.i(24967);
        Object tag = getTag();
        AppMethodBeat.o(24967);
        return tag;
    }

    public Context getUIContext() {
        AppMethodBeat.i(24968);
        Context context = getContext();
        AppMethodBeat.o(24968);
        return context;
    }

    public final void fi(int i, int i2) {
    }

    public void setCanPlay(boolean z) {
        this.qyA.qxI = z;
    }

    public void setOnCompletionListener(e eVar) {
        this.qyA.qxT = eVar;
    }

    public void setOnSightCompletionAction(g gVar) {
    }

    public void setThumbBgView(View view) {
        AppMethodBeat.i(24969);
        this.qyA.setThumbBgView(view);
        AppMethodBeat.o(24969);
    }

    public void setIsWhatsNew(boolean z) {
        this.qyA.qxL = z;
    }

    public void setSightInfoView(TextView textView) {
        AppMethodBeat.i(24970);
        this.qyA.setSightInfoView(textView);
        AppMethodBeat.o(24970);
    }

    public void setForceRecordState(boolean z) {
        this.qyA.qxR = z;
    }

    public void setOnDecodeDurationListener(f fVar) {
        this.qyA.qxU = fVar;
    }
}
