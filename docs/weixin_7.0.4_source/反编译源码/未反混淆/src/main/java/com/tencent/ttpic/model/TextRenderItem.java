package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.opengl.GLES20;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.Random;

public class TextRenderItem {
    private int canvasHeight;
    private int canvasWidth;
    private int itemHeight = 100;
    private int itemWidth = 300;
    private boolean positionInited = false;
    private int positionX;
    private int positionY;
    private float randomDirection;
    private RenderParam renderParam = new RenderParam();
    private int tex;

    public TextRenderItem() {
        AppMethodBeat.i(83532);
        AppMethodBeat.o(83532);
    }

    public void init() {
        AppMethodBeat.i(83533);
        this.randomDirection = (new Random().nextFloat() * 2.0f) - 1.0f;
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.tex = iArr[0];
        this.renderParam.texture = this.tex;
        this.renderParam.texCords = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES;
        AppMethodBeat.o(83533);
    }

    public void setText(String str) {
        AppMethodBeat.i(83534);
        Bitmap createBitmap = Bitmap.createBitmap(this.itemWidth, this.itemHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(60.0f);
        textPaint.setFakeBoldText(true);
        textPaint.setColor(-1);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        canvas.drawText(str, 0, str.length(), (float) ((this.itemWidth / 2) - ((int) (getTextWidth(textPaint, str) / 2.0f))), (((float) (this.itemHeight / 2)) - fontMetrics.descent) + ((fontMetrics.descent - fontMetrics.ascent) / 2.0f), textPaint);
        GlUtil.loadTexture(this.tex, createBitmap);
        createBitmap.recycle();
        AppMethodBeat.o(83534);
    }

    private float getTextWidth(Paint paint, String str) {
        AppMethodBeat.i(83535);
        float[] fArr = new float[str.length()];
        paint.getTextWidths(str, fArr);
        float f = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            f += fArr[i];
        }
        AppMethodBeat.o(83535);
        return f;
    }

    public void update() {
        AppMethodBeat.i(83536);
        this.positionX = (int) (((float) this.positionX) + (5.0f * this.randomDirection));
        this.positionY -= 7;
        float f = (float) (this.positionX - (this.itemWidth / 2));
        float f2 = (float) (this.positionY - (this.itemHeight / 2));
        float f3 = f + ((float) this.itemWidth);
        float f4 = ((float) this.itemHeight) + f2;
        this.renderParam.position = AlgoUtils.calPositionsTriangles(f, f4, f3, f2, this.canvasWidth, this.canvasHeight);
        AppMethodBeat.o(83536);
    }

    public void updatePosition(float f, float f2) {
        AppMethodBeat.i(83537);
        this.positionX = (int) f;
        this.positionY = (int) f2;
        float f3 = (float) (this.positionX - (this.itemWidth / 2));
        float f4 = (float) (this.positionY - (this.itemHeight / 2));
        float f5 = f3 + ((float) this.itemWidth);
        float f6 = ((float) this.itemHeight) + f4;
        this.renderParam.position = AlgoUtils.calPositionsTriangles(f3, f6, f5, f4, this.canvasWidth, this.canvasHeight);
        AppMethodBeat.o(83537);
    }

    public boolean isOutOfCanvas() {
        return this.positionX + (this.itemWidth / 2) < 0 || this.positionX - (this.itemWidth / 2) > this.canvasWidth || this.positionY + (this.itemHeight / 2) < 0 || this.positionY - (this.itemHeight / 2) > this.canvasHeight;
    }

    public RenderParam getRenderParam() {
        return this.renderParam;
    }

    public void updateVideoSize(int i, int i2) {
        this.canvasWidth = i;
        this.canvasHeight = i2;
        if (!this.positionInited) {
            this.positionX = this.canvasWidth / 2;
            this.positionY = this.canvasHeight;
            this.positionInited = true;
        }
    }

    public void clear() {
        AppMethodBeat.i(83538);
        GLES20.glDeleteTextures(1, new int[]{this.tex}, 0);
        AppMethodBeat.o(83538);
    }
}
