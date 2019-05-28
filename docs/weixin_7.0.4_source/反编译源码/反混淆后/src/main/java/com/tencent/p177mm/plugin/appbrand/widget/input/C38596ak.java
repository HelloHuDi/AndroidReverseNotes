package com.tencent.p177mm.plugin.appbrand.widget.input;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.plugin.appbrand.widget.input.panel.C27414c;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ak */
final class C38596ak extends C27414c {
    private static final int jhe = C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9980m5);
    private C26003e jhd = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ak$b */
    static final class C19861b extends Drawable {
        private Rect jhg;
        private final TextPaint mPaint;
        private final int mSize;
        private final String mText;

        /* synthetic */ C19861b(String str, int i, byte b) {
            this(str, i);
        }

        private C19861b(String str, int i) {
            AppMethodBeat.m2504i(134289);
            this.mText = str;
            this.mSize = i;
            this.mPaint = new TextPaint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setTextAlign(Align.CENTER);
            this.mPaint.setTextSize((float) this.mSize);
            this.jhg = new Rect();
            this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), this.jhg);
            AppMethodBeat.m2505o(134289);
        }

        public final int getIntrinsicWidth() {
            AppMethodBeat.m2504i(134290);
            int width = this.jhg.width();
            AppMethodBeat.m2505o(134290);
            return width;
        }

        public final int getIntrinsicHeight() {
            AppMethodBeat.m2504i(134291);
            int height = this.jhg.height();
            AppMethodBeat.m2505o(134291);
            return height;
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.m2504i(134292);
            canvas.drawText(this.mText, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.mPaint.descent() + this.mPaint.ascent()) / 2.0f), this.mPaint);
            AppMethodBeat.m2505o(134292);
        }

        public final void setAlpha(int i) {
            AppMethodBeat.m2504i(134293);
            this.mPaint.setAlpha(i);
            AppMethodBeat.m2505o(134293);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.m2504i(134294);
            this.mPaint.setColorFilter(colorFilter);
            AppMethodBeat.m2505o(134294);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ak$c */
    static final class C19862c extends ContextWrapper {
        private Resources mResources;

        public C19862c(Context context) {
            super(context);
        }

        public final Resources getResources() {
            AppMethodBeat.m2504i(134295);
            Resources resources;
            if (this.mResources == null || !(this.mResources instanceof C27402d)) {
                resources = super.getResources();
                this.mResources = new C27402d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
                resources = this.mResources;
                AppMethodBeat.m2505o(134295);
                return resources;
            }
            resources = this.mResources;
            AppMethodBeat.m2505o(134295);
            return resources;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ak$d */
    static final class C27402d extends Resources {
        C27402d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
        }

        public final String[] getStringArray(int i) {
            AppMethodBeat.m2504i(134296);
            String[] strArr;
            if (C25738R.array.f12621a2 == i) {
                strArr = new String[0];
                AppMethodBeat.m2505o(134296);
                return strArr;
            } else if (C25738R.array.f12622a3 == i) {
                strArr = new String[0];
                AppMethodBeat.m2505o(134296);
                return strArr;
            } else {
                strArr = super.getStringArray(i);
                AppMethodBeat.m2505o(134296);
                return strArr;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.ak$a */
    static final class C31334a extends C26003e {
        private String[] jhf;

        C31334a() {
            super(new C19862c(C4996ah.getContext()));
            AppMethodBeat.m2504i(134284);
            this.jhf = null;
            this.jhf = C4996ah.getContext().getResources().getStringArray(C25738R.array.f12623a4);
            AppMethodBeat.m2505o(134284);
        }

        public final int aRs() {
            return 0;
        }

        public final int aRt() {
            return this.jhf != null ? this.jhf.length : 0;
        }

        /* renamed from: qJ */
        public final Drawable mo43876qJ(int i) {
            AppMethodBeat.m2504i(134285);
            C42738f.aQv();
            C19861b c19861b = new C19861b(mo43877qK(i), C38596ak.jhe, (byte) 0);
            AppMethodBeat.m2505o(134285);
            return c19861b;
        }

        /* renamed from: qK */
        public final String mo43877qK(int i) {
            AppMethodBeat.m2504i(134286);
            String str;
            if (this.jhf == null || i < 0 || i > this.jhf.length - 1) {
                str = "";
                AppMethodBeat.m2505o(134286);
                return str;
            }
            String[] split = this.jhf[i].split(" ");
            char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
            str = toChars + Character.toChars(Integer.decode(split[1]).intValue());
            AppMethodBeat.m2505o(134286);
            return str;
        }

        public final String getText(int i) {
            AppMethodBeat.m2504i(134287);
            String qK = mo43877qK(i);
            AppMethodBeat.m2505o(134287);
            return qK;
        }

        /* renamed from: qL */
        public final String mo43878qL(int i) {
            AppMethodBeat.m2504i(134288);
            String qK = mo43877qK(i);
            AppMethodBeat.m2505o(134288);
            return qK;
        }
    }

    C38596ak() {
    }

    public final C26003e aRr() {
        AppMethodBeat.m2504i(134297);
        if (this.jhd == null) {
            this.jhd = new C31334a();
        }
        C26003e c26003e = this.jhd;
        AppMethodBeat.m2505o(134297);
        return c26003e;
    }

    static {
        AppMethodBeat.m2504i(134298);
        AppMethodBeat.m2505o(134298);
    }
}
