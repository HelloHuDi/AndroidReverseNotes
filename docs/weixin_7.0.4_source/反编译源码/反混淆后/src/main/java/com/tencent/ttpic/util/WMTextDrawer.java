package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.util.WMTokenizer.Token;
import com.tencent.util.C16371i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WMTextDrawer {
    protected static final String INT_D = "%d";
    private static final String TAG = WMTextDrawer.class.getSimpleName();
    private static Map<String, Typeface> typefaceCache = new HashMap();
    private AsyncDrawRunnable asyncDrawRunnable;
    private boolean isAsyncDrawFinished = true;
    public String lastDrawText = "";

    public abstract class AsyncDrawRunnable implements Runnable {
        public boolean isTaskCanceled = false;
    }

    class TextVerticalLayout extends TextLayout {
        public TextVerticalLayout(TextWMElement textWMElement, int i, int i2, String str) {
            super(textWMElement, i, i2, str);
        }

        /* Access modifiers changed, original: protected */
        public void drawText(Canvas canvas) {
            AppMethodBeat.m2504i(84281);
            this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
            float fontHeight = (this.mWMTokenizer.getFontHeight() / 2.0f) + ((Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0f);
            canvas.save();
            Iterator it = this.mWMTokenizer.getTokens().iterator();
            while (it.hasNext()) {
                Token token = (Token) it.next();
                float f = token.f14339x;
                float f2 = token.f14340y + fontHeight;
                for (int i = 0; i < token.text.length(); i++) {
                    draw(canvas, String.valueOf(token.text.charAt(i)), f, f2);
                    f2 += this.mWMTokenizer.getFontHeight();
                }
            }
            canvas.restore();
            AppMethodBeat.m2505o(84281);
        }
    }

    class TextHorizontalLayout extends TextLayout {
        public TextHorizontalLayout(TextWMElement textWMElement, int i, int i2, String str) {
            super(textWMElement, i, i2, str);
        }

        /* Access modifiers changed, original: protected */
        public void drawText(Canvas canvas) {
            AppMethodBeat.m2504i(84280);
            this.mWMElement.mTextRect.set(this.mWMTokenizer.getTextRect());
            float fontHeight = (this.mWMTokenizer.getFontHeight() / 2.0f) + ((Math.abs(this.mPaint.ascent()) - this.mPaint.descent()) / 2.0f);
            Iterator it = this.mWMTokenizer.getTokens().iterator();
            while (it.hasNext()) {
                Token token = (Token) it.next();
                float[] fArr = new float[token.text.length()];
                this.mPaint.getTextWidths(token.text, fArr);
                float f = token.f14339x;
                float f2 = token.f14340y + fontHeight;
                for (int i = 0; i < token.text.length(); i++) {
                    draw(canvas, String.valueOf(token.text.charAt(i)), f, f2);
                    f += fArr[i] + ((float) this.mWMElement.kern);
                }
            }
            AppMethodBeat.m2505o(84280);
        }
    }

    public static abstract class TextLayout {
        protected TextPaint mOuterStrokePaint;
        protected TextPaint mPaint = genPaint(this.mWMElement);
        protected TextPaint mStrokePaint;
        protected String mText;
        protected TextWMElement mWMElement;
        protected WMTokenizer mWMTokenizer;

        public abstract void drawText(Canvas canvas);

        protected TextLayout(TextWMElement textWMElement, int i, int i2, String str) {
            boolean z = true;
            this.mText = str;
            this.mWMElement = textWMElement;
            WMTokenizer spacingPlus = WMTokenizer.from(this.mText, this.mPaint).setWidth(i).setHeight(i2).setAlign(this.mWMElement.alignment).setSingleLine(!this.mWMElement.multiRow).setSpacingPlus((float) this.mWMElement.kern);
            if (this.mWMElement.vertical != 1) {
                z = false;
            }
            this.mWMTokenizer = spacingPlus.setVertical(z);
            adjustPaintIfNeed();
            this.mWMTokenizer.tokenizer();
            this.mWMTokenizer.doLayout();
        }

        private TextPaint genPaint(TextWMElement textWMElement) {
            String str;
            TextPaint textPaint = new TextPaint();
            textPaint.setAntiAlias(true);
            if (!TextUtils.isEmpty(textWMElement.fontName)) {
                try {
                    Typeface typeface = (Typeface) WMTextDrawer.typefaceCache.get(textWMElement.fontName);
                    if (typeface == null) {
                        if (textWMElement.fontName.equals("sans_serif")) {
                            if (WMTextDrawer.typefaceCache.containsKey(textWMElement.fontName)) {
                                typeface = (Typeface) WMTextDrawer.typefaceCache.get(textWMElement.fontName);
                            } else {
                                typeface = Typeface.create(Typeface.SANS_SERIF, 0);
                            }
                        } else if (textWMElement.fontName.equals("serif")) {
                            typeface = Typeface.create(Typeface.SERIF, 0);
                        } else if (textWMElement.fontName.equals("monospace")) {
                            typeface = Typeface.create(Typeface.MONOSPACE, 0);
                        } else {
                            if (textWMElement.fontName.contains(".")) {
                                str = "fonts/" + textWMElement.fontName;
                            } else {
                                str = "fonts/" + textWMElement.fontName + ".ttf";
                            }
                            typeface = Typeface.createFromAsset(VideoGlobalContext.getContext().getAssets(), str);
                        }
                    }
                    if (typeface != null) {
                        textPaint.setTypeface(typeface);
                        if (!WMTextDrawer.typefaceCache.containsKey(textWMElement.fontName)) {
                            WMTextDrawer.typefaceCache.put(textWMElement.fontName, typeface);
                        }
                    }
                } catch (Exception e) {
                    C16371i.m25188m(WMTextDrawer.TAG, e.getMessage());
                }
            }
            float f = textWMElement.fontSize > 0.0f ? textWMElement.fontSize : 40.0f;
            if (f < 4.0f) {
                f += 20.0f;
            }
            textPaint.setTextSize(f);
            if (textWMElement.emboss) {
                textPaint.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, -1.0f}, 1.0f, 6.0f, 3.5f));
            }
            if (!TextUtils.isEmpty(textWMElement.shaderBmp)) {
                str = textWMElement.shaderBmp.replace(WMTextDrawer.INT_D, String.valueOf(textWMElement.getFrameIndex()));
                if (!(TextUtils.isEmpty(str) || str.equals(textWMElement.curShaderBmp) || !BitmapUtils.isLegal(VideoMemoryManager.getInstance().loadImage(textWMElement.itemId, str)))) {
                    textWMElement.curShaderBmp = str;
                }
                Bitmap loadImage = VideoMemoryManager.getInstance().loadImage(textWMElement.itemId, textWMElement.curShaderBmp);
                if (BitmapUtils.isLegal(loadImage)) {
                    TileMode tileMode = TileMode.MIRROR;
                    textPaint.setShader(new BitmapShader(loadImage, tileMode, tileMode));
                }
            }
            textPaint.setFakeBoldText(textWMElement.fontBold);
            textPaint.setTextSkewX(textWMElement.fontItalics ? -0.2f : 0.0f);
            if (textWMElement.shadowSize > 0.0f) {
                textPaint.setShadowLayer(textWMElement.shadowSize, textWMElement.shadowDx, textWMElement.shadowDy, Color.parseColor(textWMElement.shadowColor));
            }
            textPaint.setColor(Color.parseColor(textWMElement.color));
            return textPaint;
        }

        private void adjustPaintIfNeed() {
            if (this.mWMElement.fontFit == 1) {
                fontKernCompat();
                this.mWMTokenizer.tokenizer();
                if (this.mWMTokenizer.isFitIn()) {
                    while (this.mWMTokenizer.isFitIn()) {
                        this.mPaint.setTextSize(this.mPaint.getTextSize() + 4.0f);
                        fontKernCompat();
                        this.mWMTokenizer.tokenizer();
                    }
                    this.mPaint.setTextSize(this.mPaint.getTextSize() - 4.0f);
                    fontKernCompat();
                } else {
                    while (!this.mWMTokenizer.isFitIn()) {
                        this.mPaint.setTextSize(this.mPaint.getTextSize() - 4.0f);
                        fontKernCompat();
                        this.mWMTokenizer.tokenizer();
                    }
                    this.mPaint.setTextSize(this.mPaint.getTextSize() + 4.0f);
                    fontKernCompat();
                }
            }
            if (this.mWMElement.strokeSize > 0.0f) {
                this.mStrokePaint = new TextPaint(this.mPaint);
                this.mStrokePaint.setShader(null);
                this.mStrokePaint.setMaskFilter(null);
                this.mStrokePaint.setStyle(Style.STROKE);
                this.mStrokePaint.setColor(Color.parseColor(this.mWMElement.strokeColor));
                this.mStrokePaint.setStrokeWidth((this.mWMElement.strokeSize * (this.mPaint.getTextSize() / 20.0f)) * 1.2f);
            }
            if (this.mWMElement.outerStrokeSize > 0.0f) {
                this.mOuterStrokePaint = new TextPaint(this.mPaint);
                this.mOuterStrokePaint.setShader(null);
                this.mOuterStrokePaint.setMaskFilter(null);
                this.mOuterStrokePaint.setColor(Color.parseColor(this.mWMElement.outerStrokeColor));
            }
        }

        public void fontKernCompat() {
            if ("HYHeiLiZhiTiJ".equals(this.mWMElement.fontName)) {
                this.mWMElement.kern = (int) (((float) this.mWMElement.kern) * (this.mPaint.getTextSize() / 141.0f));
            }
            this.mWMTokenizer.setSpacingPlus((float) this.mWMElement.kern);
        }

        public void draw(Canvas canvas) {
            BenchUtil.benchStart("TextLayout::draw.drawText(canvas)");
            drawText(canvas);
            BenchUtil.benchEnd("TextLayout::draw.drawText(canvas)");
        }

        /* Access modifiers changed, original: protected */
        public void draw(Canvas canvas, String str, float f, float f2) {
            if (this.mStrokePaint != null) {
                canvas.drawText(str, f, f2, this.mStrokePaint);
            }
            if (this.mOuterStrokePaint != null) {
                float f3 = this.mWMElement.outerStrokeSize;
                canvas.drawText(str, f - f3, f2 - f3, this.mOuterStrokePaint);
                canvas.drawText(str, f + f3, f2 - f3, this.mOuterStrokePaint);
                canvas.drawText(str, f + f3, f2 + f3, this.mOuterStrokePaint);
                canvas.drawText(str, f - f3, f3 + f2, this.mOuterStrokePaint);
            }
            canvas.drawText(str, f, f2, this.mPaint);
        }
    }

    static /* synthetic */ void access$100(WMTextDrawer wMTextDrawer, TextWMElement textWMElement, Canvas canvas, int i, int i2, String str) {
        AppMethodBeat.m2504i(84288);
        wMTextDrawer.drawHorizontalText(textWMElement, canvas, i, i2, str);
        AppMethodBeat.m2505o(84288);
    }

    static /* synthetic */ void access$200(WMTextDrawer wMTextDrawer, TextWMElement textWMElement, Canvas canvas, int i, int i2, String str) {
        AppMethodBeat.m2504i(84289);
        wMTextDrawer.drawVerticalText(textWMElement, canvas, i, i2, str);
        AppMethodBeat.m2505o(84289);
    }

    static {
        AppMethodBeat.m2504i(84290);
        AppMethodBeat.m2505o(84290);
    }

    public void drawTextToBitmap(final TextWMElement textWMElement, final String str, final boolean z, boolean z2) {
        AppMethodBeat.m2504i(84282);
        if (!(str == null || TextUtils.isEmpty(str))) {
            this.lastDrawText = str;
        }
        this.isAsyncDrawFinished = false;
        this.asyncDrawRunnable = new AsyncDrawRunnable() {
            public void run() {
                AppMethodBeat.m2504i(84279);
                if (!BitmapUtils.isLegal(textWMElement.getIdleBitmap()) || str == null) {
                    WMTextDrawer.this.isAsyncDrawFinished = true;
                    AppMethodBeat.m2505o(84279);
                    return;
                }
                String str = z ? WMTextDrawer.this.lastDrawText : str;
                textWMElement.getIdleBitmap().eraseColor(0);
                if (str.length() == 0) {
                    WMTextDrawer.this.isAsyncDrawFinished = true;
                    AppMethodBeat.m2505o(84279);
                    return;
                }
                Canvas canvas = new Canvas(textWMElement.getIdleBitmap());
                if (textWMElement.vertical == 0) {
                    WMTextDrawer.access$100(WMTextDrawer.this, textWMElement, canvas, canvas.getWidth(), canvas.getHeight(), str);
                } else {
                    WMTextDrawer.access$200(WMTextDrawer.this, textWMElement, canvas, canvas.getWidth(), canvas.getHeight(), str);
                }
                textWMElement.swapActiveBitmap();
                textWMElement.setContentChanged(true);
                if (this.isTaskCanceled) {
                    textWMElement.setContentChanged(false);
                }
                WMTextDrawer.this.isAsyncDrawFinished = true;
                AppMethodBeat.m2505o(84279);
            }
        };
        if (z2) {
            this.asyncDrawRunnable.run();
            AppMethodBeat.m2505o(84282);
            return;
        }
        AsyncTask.SERIAL_EXECUTOR.execute(this.asyncDrawRunnable);
        AppMethodBeat.m2505o(84282);
    }

    public void cancelAsyncDrawTask() {
        if (!this.isAsyncDrawFinished && this.asyncDrawRunnable != null) {
            this.asyncDrawRunnable.isTaskCanceled = true;
            this.isAsyncDrawFinished = true;
        }
    }

    public boolean isAsyncDrawFinished() {
        return this.isAsyncDrawFinished;
    }

    private void drawHorizontalText(TextWMElement textWMElement, Canvas canvas, int i, int i2, String str) {
        AppMethodBeat.m2504i(84283);
        new TextHorizontalLayout(textWMElement, i, i2, str).draw(canvas);
        AppMethodBeat.m2505o(84283);
    }

    private void drawVerticalText(TextWMElement textWMElement, Canvas canvas, int i, int i2, String str) {
        AppMethodBeat.m2504i(84284);
        if (textWMElement.rotate == 90 || textWMElement.rotate == -90) {
            drawRotatedVerticalText(textWMElement, str);
            AppMethodBeat.m2505o(84284);
            return;
        }
        drawNormalVerticalText(textWMElement, canvas, i, i2, str);
        AppMethodBeat.m2505o(84284);
    }

    private void drawNormalVerticalText(TextWMElement textWMElement, Canvas canvas, int i, int i2, String str) {
        AppMethodBeat.m2504i(84285);
        new TextVerticalLayout(textWMElement, i, i2, str).draw(canvas);
        AppMethodBeat.m2505o(84285);
    }

    private void drawRotatedVerticalText(TextWMElement textWMElement, String str) {
        AppMethodBeat.m2504i(84286);
        Bitmap createBitmap = Bitmap.createBitmap(textWMElement.height, textWMElement.width, Config.ARGB_8888);
        drawHorizontalText(textWMElement, new Canvas(createBitmap), createBitmap.getWidth(), createBitmap.getHeight(), str);
        if (BitmapUtils.isLegal(textWMElement.getIdleBitmap())) {
            textWMElement.getIdleBitmap().recycle();
        }
        textWMElement.setIdleBitmap(rotateBitmap(createBitmap, (float) textWMElement.rotate));
        AppMethodBeat.m2505o(84286);
    }

    private Bitmap rotateBitmap(Bitmap bitmap, float f) {
        AppMethodBeat.m2504i(84287);
        if (bitmap == null) {
            AppMethodBeat.m2505o(84287);
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (createBitmap.equals(bitmap)) {
            AppMethodBeat.m2505o(84287);
            return createBitmap;
        }
        bitmap.recycle();
        AppMethodBeat.m2505o(84287);
        return createBitmap;
    }
}
