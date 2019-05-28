package com.tencent.mm.media.editor.c;

import a.a.ab;
import a.f.b.j;
import a.l;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002WXB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u00020K2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010L\u001a\u00020\u0018H\u0002J\b\u0010M\u001a\u00020\u0018H\u0002J\b\u0010N\u001a\u00020\u0018H\u0002J\b\u0010O\u001a\u00020\u0018H\u0002J(\u0010P\u001a\u00020G2\u0006\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u00182\u0006\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u0018H\u0002J\b\u0010U\u001a\u00020KH\u0002J\u0010\u0010V\u001a\u00020K2\u0006\u0010H\u001a\u00020IH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u000e\u0010#\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010-\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u0010\u001cR\u001e\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001201j\b\u0012\u0004\u0012\u00020\u0012`2X\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u001201j\b\u0012\u0004\u0012\u00020\u0012`2X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\b\"\u0004\bB\u0010\nR\u001a\u0010C\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016¨\u0006Y"}, dWq = {"Lcom/tencent/mm/media/editor/touch/TouchTracker;", "", "()V", "TAG", "", "boundArrayDst", "", "getBoundArrayDst", "()[F", "setBoundArrayDst", "([F)V", "boundArrayOut", "getBoundArrayOut", "setBoundArrayOut", "boundArraySrc", "getBoundArraySrc", "setBoundArraySrc", "height", "", "getHeight", "()I", "setHeight", "(I)V", "holdX", "", "getHoldX", "()F", "setHoldX", "(F)V", "holdY", "getHoldY", "setHoldY", "holdingThreshold", "getHoldingThreshold", "setHoldingThreshold", "lastDrag", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "pIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pIndices", "pivotDst", "pivotType", "Lcom/tencent/mm/media/editor/touch/TouchTracker$PivotType;", "safeAreaRect", "Landroid/graphics/Rect;", "getSafeAreaRect", "()Landroid/graphics/Rect;", "setSafeAreaRect", "(Landroid/graphics/Rect;)V", "state", "Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "transStart", "transformBoundArray", "getTransformBoundArray", "setTransformBoundArray", "width", "getWidth", "setWidth", "appendTouchEvent", "", "event", "Landroid/view/MotionEvent;", "findIndices", "", "findMaxBottom", "findMaxRight", "findMinLeft", "findMinTop", "inSafeArea", "newLeft", "newTop", "newRight", "newBottom", "resetHold", "updateState", "PivotType", "TouchState", "plugin-mediaeditor_release"})
public final class c {
    private final String TAG = "TouchTracker";
    public float aJf = 3.0f;
    public float aJg = 0.5f;
    public Matrix aKk = new Matrix();
    private ArrayList<Integer> eUH = new ArrayList();
    private ArrayList<Integer> eUI = new ArrayList();
    private float[] eUJ = new float[2];
    private float[] eUK = new float[4];
    private float[] eUL = new float[2];
    private b eUM = b.NONE;
    public Rect eUN;
    public int eUO;
    private float eUP;
    private float eUQ;
    private float[] eUR = new float[8];
    private float[] eUS = new float[8];
    public float[] eUT = new float[4];
    private float[] eUU = new float[4];
    private a eUV = a.FREE;
    public int height;
    public int width;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, dWq = {"Lcom/tencent/mm/media/editor/touch/TouchTracker$TouchState;", "", "(Ljava/lang/String;I)V", "NONE", "DRAG", "SCALE", "plugin-mediaeditor_release"})
    public enum b {
        NONE,
        DRAG,
        SCALE;

        static {
            AppMethodBeat.o(12910);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/editor/touch/TouchTracker$PivotType;", "", "(Ljava/lang/String;I)V", "FREE", "CENTER", "plugin-mediaeditor_release"})
    public enum a {
        FREE,
        CENTER;

        static {
            AppMethodBeat.o(12907);
        }
    }

    public c() {
        AppMethodBeat.i(12923);
        this.aKk.setScale(1.0f, 1.0f);
        AppMethodBeat.o(12923);
    }

    public final void setMatrix(Matrix matrix) {
        AppMethodBeat.i(12914);
        j.p(matrix, "<set-?>");
        this.aKk = matrix;
        AppMethodBeat.o(12914);
    }

    public final void h(float[] fArr) {
        AppMethodBeat.i(12915);
        j.p(fArr, "<set-?>");
        this.eUR = fArr;
        AppMethodBeat.o(12915);
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u(MotionEvent motionEvent) {
        AppMethodBeat.i(12916);
        j.p(motionEvent, "event");
        float[] fArr;
        Matrix matrix;
        switch (motionEvent.getActionMasked()) {
            case 0:
                fArr = new float[2];
                matrix = new Matrix();
                this.aKk.invert(matrix);
                matrix.mapPoints(fArr, new float[]{motionEvent.getX(), motionEvent.getY()});
                if (fArr[0] >= 0.0f && fArr[0] <= ((float) this.width) && fArr[1] >= 0.0f && fArr[1] <= ((float) this.height)) {
                    this.eUH.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                    this.eUI.add(Integer.valueOf(motionEvent.getActionIndex()));
                    v(motionEvent);
                    break;
                }
                AppMethodBeat.o(12916);
                return false;
                break;
            case 1:
            case 3:
                this.eUM = b.NONE;
                this.eUH.clear();
                this.eUI.clear();
                break;
            case 2:
                w(motionEvent);
                if (motionEvent.getPointerCount() == 1) {
                    this.eUM = b.DRAG;
                }
                Object obj;
                float x;
                float y;
                float f;
                float f2;
                Matrix matrix2;
                switch (d.eQZ[this.eUM.ordinal()]) {
                    case 1:
                        obj = this.eUI.get(0);
                        j.o(obj, "pIndices[0]");
                        x = motionEvent.getX(((Number) obj).intValue());
                        obj = this.eUI.get(0);
                        j.o(obj, "pIndices[0]");
                        y = motionEvent.getY(((Number) obj).intValue());
                        float f3 = x - this.eUJ[0];
                        f = y - this.eUJ[1];
                        this.aKk.postTranslate(f3, f);
                        this.eUJ[0] = x;
                        this.eUJ[1] = y;
                        this.aKk.mapPoints(this.eUS, this.eUR);
                        this.eUT[0] = UK();
                        this.eUT[1] = UL();
                        this.eUT[2] = UM();
                        this.eUT[3] = UN();
                        if (this.eUN != null) {
                            y = this.eUT[0] + f3;
                            x = this.eUT[1] + f;
                            f2 = this.eUT[2] + f3;
                            float f4 = this.eUT[3] + f;
                            Rect rect = this.eUN;
                            if (rect == null) {
                                j.dWJ();
                            }
                            if (y > ((float) rect.left)) {
                                rect = this.eUN;
                                if (rect == null) {
                                    j.dWJ();
                                }
                                if (y < ((float) rect.right)) {
                                    Rect rect2 = this.eUN;
                                    if (rect2 == null) {
                                        j.dWJ();
                                    }
                                    if (x > ((float) rect2.top)) {
                                        rect2 = this.eUN;
                                        if (rect2 == null) {
                                            j.dWJ();
                                        }
                                        if (x < ((float) rect2.bottom)) {
                                            rect2 = this.eUN;
                                            if (rect2 == null) {
                                                j.dWJ();
                                            }
                                            if (f2 > ((float) rect2.left)) {
                                                rect2 = this.eUN;
                                                if (rect2 == null) {
                                                    j.dWJ();
                                                }
                                                if (f2 < ((float) rect2.right)) {
                                                    rect2 = this.eUN;
                                                    if (rect2 == null) {
                                                        j.dWJ();
                                                    }
                                                    if (f4 > ((float) rect2.top)) {
                                                        rect2 = this.eUN;
                                                        if (rect2 == null) {
                                                            j.dWJ();
                                                        }
                                                        if (f4 < ((float) rect2.bottom)) {
                                                            obj = 1;
                                                            if (obj == null) {
                                                                Matrix matrix3;
                                                                Rect rect3;
                                                                y = Math.abs(f3);
                                                                x = Math.abs(f);
                                                                Rect rect4 = this.eUN;
                                                                if (rect4 == null) {
                                                                    j.dWJ();
                                                                }
                                                                if (((float) rect4.left) >= this.eUT[0] && this.eUP <= ((float) this.eUO)) {
                                                                    matrix3 = this.aKk;
                                                                    rect3 = this.eUN;
                                                                    if (rect3 == null) {
                                                                        j.dWJ();
                                                                    }
                                                                    matrix3.postTranslate(((float) rect3.left) - this.eUT[0], 0.0f);
                                                                    this.eUP += y;
                                                                }
                                                                rect4 = this.eUN;
                                                                if (rect4 == null) {
                                                                    j.dWJ();
                                                                }
                                                                if (((float) rect4.top) >= this.eUT[1] && this.eUQ <= ((float) this.eUO)) {
                                                                    matrix3 = this.aKk;
                                                                    Rect rect5 = this.eUN;
                                                                    if (rect5 == null) {
                                                                        j.dWJ();
                                                                    }
                                                                    matrix3.postTranslate(0.0f, ((float) rect5.top) - this.eUT[1]);
                                                                    this.eUQ += x;
                                                                }
                                                                rect4 = this.eUN;
                                                                if (rect4 == null) {
                                                                    j.dWJ();
                                                                }
                                                                if (((float) rect4.right) <= this.eUT[2] && this.eUP <= ((float) this.eUO)) {
                                                                    matrix3 = this.aKk;
                                                                    rect3 = this.eUN;
                                                                    if (rect3 == null) {
                                                                        j.dWJ();
                                                                    }
                                                                    matrix3.postTranslate(((float) rect3.right) - this.eUT[2], 0.0f);
                                                                    this.eUP = y + this.eUP;
                                                                }
                                                                rect2 = this.eUN;
                                                                if (rect2 == null) {
                                                                    j.dWJ();
                                                                }
                                                                if (((float) rect2.bottom) <= this.eUT[3] && this.eUQ <= ((float) this.eUO)) {
                                                                    matrix2 = this.aKk;
                                                                    rect3 = this.eUN;
                                                                    if (rect3 == null) {
                                                                        j.dWJ();
                                                                    }
                                                                    matrix2.postTranslate(0.0f, ((float) rect3.bottom) - this.eUT[3]);
                                                                    this.eUQ += x;
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            obj = null;
                            if (obj == null) {
                            }
                        }
                        this.eUP = 0.0f;
                        this.eUQ = 0.0f;
                        break;
                    case 2:
                        matrix2 = this.aKk;
                        float[] fArr2 = this.eUK;
                        float[] fArr3 = new float[4];
                        Object obj2 = this.eUI.get(0);
                        j.o(obj2, "pIndices[0]");
                        fArr3[0] = motionEvent.getX(((Number) obj2).intValue());
                        obj2 = this.eUI.get(0);
                        j.o(obj2, "pIndices[0]");
                        fArr3[1] = motionEvent.getY(((Number) obj2).intValue());
                        obj2 = this.eUI.get(1);
                        j.o(obj2, "pIndices[1]");
                        fArr3[2] = motionEvent.getX(((Number) obj2).intValue());
                        obj2 = this.eUI.get(1);
                        j.o(obj2, "pIndices[1]");
                        fArr3[3] = motionEvent.getY(((Number) obj2).intValue());
                        matrix2.setPolyToPoly(fArr2, 0, fArr3, 0, 2);
                        if (this.eUV == a.CENTER) {
                            fArr = new float[2];
                            this.aKk.mapPoints(fArr, new float[]{((float) this.width) / 2.0f, ((float) this.height) / 2.0f});
                            this.aKk.postTranslate(this.eUL[0] - fArr[0], this.eUL[1] - fArr[1]);
                        }
                        float[] fArr4 = new float[2];
                        obj = this.eUI.get(0);
                        j.o(obj, "pIndices[0]");
                        f = motionEvent.getX(((Number) obj).intValue());
                        obj = this.eUI.get(1);
                        j.o(obj, "pIndices[1]");
                        fArr4[0] = (motionEvent.getX(((Number) obj).intValue()) + f) / 2.0f;
                        obj = this.eUI.get(0);
                        j.o(obj, "pIndices[0]");
                        f = motionEvent.getY(((Number) obj).intValue());
                        obj = this.eUI.get(1);
                        j.o(obj, "pIndices[1]");
                        fArr4[1] = (motionEvent.getY(((Number) obj).intValue()) + f) / 2.0f;
                        com.tencent.mm.media.editor.c.b.a aVar = b.eUG;
                        Matrix matrix4 = this.aKk;
                        y = this.aJg;
                        x = this.aJf;
                        j.p(matrix4, "matrix");
                        j.p(fArr4, "pivotSrc");
                        j.p(matrix4, "matrix");
                        float[] fArr5 = new float[9];
                        matrix4.getValues(fArr5);
                        double d = (double) fArr5[0];
                        double d2 = (double) fArr5[3];
                        f2 = (float) Math.sqrt((d2 * d2) + (d * d));
                        if (f2 >= y) {
                            if (f2 > x) {
                                y = x;
                            }
                            this.aKk.mapPoints(this.eUS, this.eUR);
                            this.eUT[0] = UK();
                            this.eUT[1] = UL();
                            this.eUT[2] = UM();
                            this.eUT[3] = UN();
                            break;
                        }
                        matrix = new Matrix();
                        matrix4.invert(matrix);
                        fArr5 = new float[2];
                        matrix.mapPoints(fArr5, fArr4);
                        fArr2 = new float[9];
                        matrix4.getValues(fArr2);
                        d = (double) fArr2[0];
                        double d3 = (double) fArr2[3];
                        double d4 = (double) fArr2[4];
                        Math.sqrt((d * d) + (d3 * d3));
                        x = (float) Math.round(Math.atan2(d3, d4) * 57.29577951308232d);
                        matrix4.setTranslate(-fArr5[0], -fArr5[1]);
                        matrix4.postScale(y, y);
                        matrix4.postRotate(x);
                        matrix4.postTranslate(fArr4[0], fArr4[1]);
                        this.aKk.mapPoints(this.eUS, this.eUR);
                        this.eUT[0] = UK();
                        this.eUT[1] = UL();
                        this.eUT[2] = UM();
                        this.eUT[3] = UN();
                }
                break;
            case 5:
                this.eUH.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
                this.eUI.add(Integer.valueOf(motionEvent.getActionIndex()));
                v(motionEvent);
                break;
            case 6:
                w(motionEvent);
                int indexOf = this.eUI.indexOf(Integer.valueOf(motionEvent.getActionIndex()));
                this.eUI.remove(indexOf);
                this.eUH.remove(indexOf);
                v(motionEvent);
                break;
        }
        AppMethodBeat.o(12916);
        return true;
    }

    private final void v(MotionEvent motionEvent) {
        AppMethodBeat.i(12917);
        Object obj;
        if (this.eUH.size() == 1) {
            this.eUM = b.DRAG;
            float[] fArr = this.eUJ;
            obj = this.eUI.get(0);
            j.o(obj, "pIndices[0]");
            fArr[0] = motionEvent.getX(((Number) obj).intValue());
            fArr = this.eUJ;
            obj = this.eUI.get(0);
            j.o(obj, "pIndices[0]");
            fArr[1] = motionEvent.getY(((Number) obj).intValue());
            AppMethodBeat.o(12917);
            return;
        }
        if (this.eUH.size() == 2) {
            this.eUM = b.SCALE;
            if (this.eUV == a.CENTER) {
                this.aKk.mapPoints(this.eUL, new float[]{((float) this.width) / 2.0f, ((float) this.height) / 2.0f});
            }
            Matrix matrix = new Matrix();
            this.aKk.invert(matrix);
            w(motionEvent);
            float[] fArr2 = this.eUK;
            float[] fArr3 = new float[4];
            obj = this.eUI.get(0);
            j.o(obj, "pIndices[0]");
            fArr3[0] = motionEvent.getX(((Number) obj).intValue());
            obj = this.eUI.get(0);
            j.o(obj, "pIndices[0]");
            fArr3[1] = motionEvent.getY(((Number) obj).intValue());
            obj = this.eUI.get(1);
            j.o(obj, "pIndices[1]");
            fArr3[2] = motionEvent.getX(((Number) obj).intValue());
            obj = this.eUI.get(1);
            j.o(obj, "pIndices[1]");
            fArr3[3] = motionEvent.getY(((Number) obj).intValue());
            matrix.mapPoints(fArr2, fArr3);
        }
        AppMethodBeat.o(12917);
    }

    private final void w(MotionEvent motionEvent) {
        AppMethodBeat.i(12918);
        Iterator it = a.a.l.g(this.eUH).iterator();
        while (it.hasNext()) {
            int nextInt = ((ab) it).nextInt();
            ArrayList arrayList = this.eUI;
            Object obj = this.eUH.get(nextInt);
            j.o(obj, "pIds[i]");
            arrayList.set(nextInt, Integer.valueOf(motionEvent.findPointerIndex(((Number) obj).intValue())));
        }
        AppMethodBeat.o(12918);
    }

    private final float UK() {
        AppMethodBeat.i(12919);
        float f = this.eUS[0];
        float[] fArr = this.eUS;
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f2 = fArr[i];
            int i3 = i2 + 1;
            switch (i2) {
                case 2:
                    f = Math.min(f, f2);
                    break;
                case 4:
                    f = Math.min(f, f2);
                    break;
                case 6:
                    f = Math.min(f, f2);
                    break;
                default:
                    break;
            }
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(12919);
        return f;
    }

    private final float UL() {
        AppMethodBeat.i(12920);
        float f = this.eUS[1];
        float[] fArr = this.eUS;
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f2 = fArr[i];
            int i3 = i2 + 1;
            switch (i2) {
                case 3:
                    f = Math.min(f, f2);
                    break;
                case 5:
                    f = Math.min(f, f2);
                    break;
                case 7:
                    f = Math.min(f, f2);
                    break;
                default:
                    break;
            }
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(12920);
        return f;
    }

    private final float UM() {
        AppMethodBeat.i(12921);
        float f = this.eUS[0];
        float[] fArr = this.eUS;
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f2 = fArr[i];
            int i3 = i2 + 1;
            switch (i2) {
                case 2:
                    f = Math.max(f, f2);
                    break;
                case 4:
                    f = Math.max(f, f2);
                    break;
                case 6:
                    f = Math.max(f, f2);
                    break;
                default:
                    break;
            }
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(12921);
        return f;
    }

    private final float UN() {
        AppMethodBeat.i(12922);
        float f = this.eUS[1];
        float[] fArr = this.eUS;
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f2 = fArr[i];
            int i3 = i2 + 1;
            switch (i2) {
                case 3:
                    f = Math.max(f, f2);
                    break;
                case 5:
                    f = Math.max(f, f2);
                    break;
                case 7:
                    f = Math.max(f, f2);
                    break;
                default:
                    break;
            }
            i++;
            i2 = i3;
        }
        AppMethodBeat.o(12922);
        return f;
    }
}
