package com.tencent.mm.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatSVGRenderC2Java {
    public static Bitmap checkForImageDataURL(String str) {
        return null;
    }

    public static void invert(Matrix matrix, Matrix matrix2) {
        AppMethodBeat.i(70064);
        matrix.invert(matrix2);
        AppMethodBeat.o(70064);
    }

    public static void doNonScalingStroke(Canvas canvas, Path path, Paint paint) {
        AppMethodBeat.i(70065);
        Matrix matrix = canvas.getMatrix();
        Path path2 = new Path();
        path.transform(matrix, path2);
        canvas.setMatrix(new Matrix());
        Shader shader = paint.getShader();
        Matrix matrix2 = new Matrix();
        if (shader != null) {
            shader.getLocalMatrix(matrix2);
            Matrix matrix3 = new Matrix(matrix2);
            matrix3.postConcat(matrix);
            shader.setLocalMatrix(matrix3);
        }
        canvas.drawPath(path2, paint);
        canvas.setMatrix(matrix);
        if (shader != null) {
            shader.setLocalMatrix(matrix2);
        }
        AppMethodBeat.o(70065);
    }

    public static void setRadialGradient(Paint paint, float f, float f2, float f3, int[] iArr, float[] fArr, Matrix matrix, int i) {
        AppMethodBeat.i(70066);
        TileMode tileMode = TileMode.CLAMP;
        if (i != 0) {
            if (i == 2) {
                tileMode = TileMode.MIRROR;
            } else if (i == 3) {
                tileMode = TileMode.REPEAT;
            }
        }
        RadialGradient radialGradient = new RadialGradient(f, f2, f3, iArr, fArr, tileMode);
        radialGradient.setLocalMatrix(matrix);
        paint.setShader(radialGradient);
        AppMethodBeat.o(70066);
    }

    public static void setLinearGradient(Paint paint, float f, float f2, float f3, float f4, int[] iArr, float[] fArr, Matrix matrix, int i) {
        AppMethodBeat.i(70067);
        TileMode tileMode = TileMode.CLAMP;
        if (i != 0) {
            if (i == 2) {
                tileMode = TileMode.MIRROR;
            } else if (i == 3) {
                tileMode = TileMode.REPEAT;
            }
        }
        LinearGradient linearGradient = new LinearGradient(f, f2, f3, f4, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
        AppMethodBeat.o(70067);
    }

    public static void addPath(Path path, Matrix matrix, Path path2, boolean z) {
        AppMethodBeat.i(70068);
        if (z) {
            path.setFillType(path2.getFillType());
        }
        path.addPath(path2, matrix);
        AppMethodBeat.o(70068);
    }

    public static float getPathMeasureLength(Path path, Matrix matrix) {
        AppMethodBeat.i(70069);
        if (matrix != null) {
            path.transform(matrix);
        }
        float length = new PathMeasure(path, false).getLength();
        AppMethodBeat.o(70069);
        return length;
    }

    public static void setFillType(Path path, int i) {
        AppMethodBeat.i(70070);
        switch (i) {
            case 0:
            case 1:
                path.setFillType(FillType.WINDING);
                AppMethodBeat.o(70070);
                return;
            case 2:
                path.setFillType(FillType.EVEN_ODD);
                break;
        }
        AppMethodBeat.o(70070);
    }

    public static void addTextPath(Paint paint, Path path, String str, float f, float f2) {
        AppMethodBeat.i(70071);
        Path path2 = new Path();
        paint.getTextPath(str, 0, str.length(), f, f2, path2);
        path.addPath(path2);
        AppMethodBeat.o(70071);
    }

    public static float[] computePathBound(Path path, Matrix matrix) {
        AppMethodBeat.i(70072);
        if (matrix != null) {
            path.transform(matrix);
        }
        path.computeBounds(new RectF(), true);
        float[] fArr = new float[]{r0.left, r0.top, r0.right, r0.bottom};
        AppMethodBeat.o(70072);
        return fArr;
    }

    public static float[] getTextBounds(Paint paint, String str) {
        AppMethodBeat.i(70073);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        RectF rectF = new RectF(rect);
        float[] fArr = new float[]{rectF.left, rectF.top, rectF.right, rectF.bottom};
        AppMethodBeat.o(70073);
        return fArr;
    }
}
