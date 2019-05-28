package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C16699a;
import com.tencent.p177mm.plugin.appbrand.widget.p915c.C31332b;
import com.tencent.p177mm.plugin.gif.MMAnimateView;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.l */
public final class C45643l implements C31332b {

    /* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.l$a */
    public class C17095a extends FrameLayout implements C16699a {
        private ImageView ikh;
        private MMAnimateView iki;
        private boolean ikj;

        public C17095a(Context context) {
            super(context);
            AppMethodBeat.m2504i(132104);
            this.iki = new MMAnimateView(context);
            addView(this.iki, new LayoutParams(-1, -1));
            this.iki.setVisibility(8);
            this.ikh = new ImageView(context);
            addView(this.ikh, new LayoutParams(-1, -1));
            this.ikh.setVisibility(8);
            AppMethodBeat.m2505o(132104);
        }

        public final void setImageFilePath(String str) {
            AppMethodBeat.m2504i(132105);
            this.iki.setVisibility(0);
            this.ikh.setVisibility(8);
            this.iki.setImageFilePath(str);
            AppMethodBeat.m2505o(132105);
        }

        public final void setImageByteArray(byte[] bArr) {
            AppMethodBeat.m2504i(132106);
            this.iki.setVisibility(0);
            this.ikh.setVisibility(8);
            this.iki.mo46177f(bArr, "");
            AppMethodBeat.m2505o(132106);
        }

        public final void setImageBitmap(Bitmap bitmap) {
            AppMethodBeat.m2504i(132107);
            this.iki.setVisibility(8);
            this.ikh.setVisibility(0);
            this.ikh.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(132107);
        }

        public final View getView() {
            return this;
        }

        public final void setScaleType(ScaleType scaleType) {
            AppMethodBeat.m2504i(132108);
            this.ikh.setScaleType(scaleType);
            this.iki.setScaleType(scaleType);
            AppMethodBeat.m2505o(132108);
        }

        public final void setInterceptEvent(boolean z) {
            this.ikj = z;
        }

        public final boolean aCH() {
            return this.ikj;
        }
    }

    /* renamed from: cU */
    public final C16699a mo51296cU(Context context) {
        AppMethodBeat.m2504i(132109);
        C17095a c17095a = new C17095a(context);
        AppMethodBeat.m2505o(132109);
        return c17095a;
    }
}
