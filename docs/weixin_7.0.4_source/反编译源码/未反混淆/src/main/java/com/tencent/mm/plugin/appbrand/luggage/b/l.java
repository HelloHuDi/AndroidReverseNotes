package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class l implements b {

    public class a extends FrameLayout implements com.tencent.mm.plugin.appbrand.widget.c.a {
        private ImageView ikh;
        private MMAnimateView iki;
        private boolean ikj;

        public a(Context context) {
            super(context);
            AppMethodBeat.i(132104);
            this.iki = new MMAnimateView(context);
            addView(this.iki, new LayoutParams(-1, -1));
            this.iki.setVisibility(8);
            this.ikh = new ImageView(context);
            addView(this.ikh, new LayoutParams(-1, -1));
            this.ikh.setVisibility(8);
            AppMethodBeat.o(132104);
        }

        public final void setImageFilePath(String str) {
            AppMethodBeat.i(132105);
            this.iki.setVisibility(0);
            this.ikh.setVisibility(8);
            this.iki.setImageFilePath(str);
            AppMethodBeat.o(132105);
        }

        public final void setImageByteArray(byte[] bArr) {
            AppMethodBeat.i(132106);
            this.iki.setVisibility(0);
            this.ikh.setVisibility(8);
            this.iki.f(bArr, "");
            AppMethodBeat.o(132106);
        }

        public final void setImageBitmap(Bitmap bitmap) {
            AppMethodBeat.i(132107);
            this.iki.setVisibility(8);
            this.ikh.setVisibility(0);
            this.ikh.setImageBitmap(bitmap);
            AppMethodBeat.o(132107);
        }

        public final View getView() {
            return this;
        }

        public final void setScaleType(ScaleType scaleType) {
            AppMethodBeat.i(132108);
            this.ikh.setScaleType(scaleType);
            this.iki.setScaleType(scaleType);
            AppMethodBeat.o(132108);
        }

        public final void setInterceptEvent(boolean z) {
            this.ikj = z;
        }

        public final boolean aCH() {
            return this.ikj;
        }
    }

    public final com.tencent.mm.plugin.appbrand.widget.c.a cU(Context context) {
        AppMethodBeat.i(132109);
        a aVar = new a(context);
        AppMethodBeat.o(132109);
        return aVar;
    }
}
