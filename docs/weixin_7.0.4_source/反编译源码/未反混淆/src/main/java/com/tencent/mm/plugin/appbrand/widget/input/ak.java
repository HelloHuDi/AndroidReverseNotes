package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.e;
import com.tencent.mm.sdk.platformtools.ah;

final class ak extends com.tencent.mm.plugin.appbrand.widget.input.panel.c {
    private static final int jhe = ah.getContext().getResources().getDimensionPixelSize(R.dimen.m5);
    private e jhd = null;

    static final class b extends Drawable {
        private Rect jhg;
        private final TextPaint mPaint;
        private final int mSize;
        private final String mText;

        /* synthetic */ b(String str, int i, byte b) {
            this(str, i);
        }

        private b(String str, int i) {
            AppMethodBeat.i(134289);
            this.mText = str;
            this.mSize = i;
            this.mPaint = new TextPaint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTextAlign(Align.CENTER);
            this.mPaint.setTextSize((float) this.mSize);
            this.jhg = new Rect();
            this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.jhg);
            AppMethodBeat.o(134289);
        }

        public final int getIntrinsicWidth() {
            AppMethodBeat.i(134290);
            int width = this.jhg.width();
            AppMethodBeat.o(134290);
            return width;
        }

        public final int getIntrinsicHeight() {
            AppMethodBeat.i(134291);
            int height = this.jhg.height();
            AppMethodBeat.o(134291);
            return height;
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(134292);
            canvas.drawText(this.mText, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.mPaint.descent() + this.mPaint.ascent()) / 2.0f), this.mPaint);
            AppMethodBeat.o(134292);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.i(134293);
            this.mPaint.setAlpha(i);
            AppMethodBeat.o(134293);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(134294);
            this.mPaint.setColorFilter(colorFilter);
            AppMethodBeat.o(134294);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    static final class c extends ContextWrapper {
        private Resources mResources;

        public c(Context context) {
            super(context);
        }

        public final Resources getResources() {
            AppMethodBeat.i(134295);
            Resources resources;
            if (this.mResources == null || !(this.mResources instanceof d)) {
                resources = super.getResources();
                this.mResources = new d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
                resources = this.mResources;
                AppMethodBeat.o(134295);
                return resources;
            }
            resources = this.mResources;
            AppMethodBeat.o(134295);
            return resources;
        }
    }

    static final class d extends Resources {
        d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
        }

        public final String[] getStringArray(int i) {
            AppMethodBeat.i(134296);
            String[] strArr;
            if (R.array.a2 == i) {
                strArr = new String[0];
                AppMethodBeat.o(134296);
                return strArr;
            } else if (R.array.a3 == i) {
                strArr = new String[0];
                AppMethodBeat.o(134296);
                return strArr;
            } else {
                strArr = super.getStringArray(i);
                AppMethodBeat.o(134296);
                return strArr;
            }
        }
    }

    static final class a extends e {
        private String[] jhf;

        a() {
            super(new c(ah.getContext()));
            AppMethodBeat.i(134284);
            this.jhf = null;
            this.jhf = ah.getContext().getResources().getStringArray(R.array.a4);
            AppMethodBeat.o(134284);
        }

        public final int aRs() {
            return 0;
        }

        public final int aRt() {
            return this.jhf != null ? this.jhf.length : 0;
        }

        public final Drawable qJ(int i) {
            AppMethodBeat.i(134285);
            f.aQv();
            b bVar = new b(qK(i), ak.jhe, (byte) 0);
            AppMethodBeat.o(134285);
            return bVar;
        }

        public final String qK(int i) {
            AppMethodBeat.i(134286);
            String str;
            if (this.jhf == null || i < 0 || i > this.jhf.length - 1) {
                str = "";
                AppMethodBeat.o(134286);
                return str;
            }
            String[] split = this.jhf[i].split(" ");
            char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
            str = toChars + Character.toChars(Integer.decode(split[1]).intValue());
            AppMethodBeat.o(134286);
            return str;
        }

        public final String getText(int i) {
            AppMethodBeat.i(134287);
            String qK = qK(i);
            AppMethodBeat.o(134287);
            return qK;
        }

        public final String qL(int i) {
            AppMethodBeat.i(134288);
            String qK = qK(i);
            AppMethodBeat.o(134288);
            return qK;
        }
    }

    ak() {
    }

    public final e aRr() {
        AppMethodBeat.i(134297);
        if (this.jhd == null) {
            this.jhd = new a();
        }
        e eVar = this.jhd;
        AppMethodBeat.o(134297);
        return eVar;
    }

    static {
        AppMethodBeat.i(134298);
        AppMethodBeat.o(134298);
    }
}
