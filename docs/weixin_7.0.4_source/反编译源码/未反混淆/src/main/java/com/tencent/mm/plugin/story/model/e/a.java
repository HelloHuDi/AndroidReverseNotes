package com.tencent.mm.plugin.story.model.e;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ(\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010#\u001a\u00020$J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010'\u001a\u00020$R\u0014\u0010\u000e\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/story/model/mix/StoryFrameRetriever;", "Lcom/tencent/mm/media/mix/FrameRetriever;", "drawingRect", "", "editorItems", "", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "width", "", "height", "videoWidth", "videoHeight", "rotate", "([FLjava/util/List;IIIII)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "centerCropScale", "", "drawer", "Lcom/tencent/mm/media/mix/EditorFrameDrawer;", "drawingMatrix", "Landroid/graphics/Matrix;", "getEditorItems", "()Ljava/util/List;", "paint", "Landroid/graphics/Paint;", "calcCenterCropScale", "drawingWidth", "drawingHeight", "destroy", "", "requestNextFrame", "Lcom/tencent/mm/media/mix/FrameInfo;", "start", "plugin-story_release"})
public final class a implements d {
    private final String TAG = "MicroMsg.StoryFrameRetriever";
    private final Paint aFY = new Paint();
    private final Bitmap bitmap;
    private final Canvas bmG;
    private final List<b> eWG;
    private final com.tencent.mm.media.f.b lim;
    private final Matrix rWr;
    private float rWs;
    private final int rotate;

    public a(float[] fArr, List<b> list, int i, int i2, int i3, int i4, int i5) {
        float max;
        j.p(fArr, "drawingRect");
        j.p(list, "editorItems");
        AppMethodBeat.i(109330);
        this.eWG = list;
        this.rotate = i5;
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        j.o(createBitmap, "Bitmap.createBitmap(widt… Bitmap.Config.ARGB_8888)");
        this.bitmap = createBitmap;
        this.bmG = new Canvas(this.bitmap);
        this.lim = new com.tencent.mm.media.f.b(this.eWG);
        this.rWr = new Matrix();
        ab.i(this.TAG, "create StoryFrameRetriever, drawRect:" + Arrays.toString(fArr) + ", width:" + i + ", height:" + i2 + ", videoWidth:" + i3 + ", videoHeight:" + i4);
        this.aFY.setAntiAlias(true);
        this.aFY.setFilterBitmap(true);
        this.rWr.postTranslate((-fArr[2]) / 2.0f, (-fArr[3]) / 2.0f);
        this.rWr.postRotate(-((float) this.rotate));
        switch (this.rotate) {
            case 90:
            case 270:
                max = Math.max(((float) i2) / fArr[2], ((float) i) / fArr[3]);
                break;
            default:
                max = Math.max(((float) i) / fArr[2], ((float) i2) / fArr[3]);
                break;
        }
        ab.i(this.TAG, "scale:".concat(String.valueOf(max)));
        this.rWr.postScale(max, max);
        if (i3 > 0 && i4 > 0) {
            int i6;
            int i7;
            float f;
            float f2 = fArr[2];
            float f3 = fArr[3];
            int min = Math.min(i3, i4);
            int max2 = Math.max(i3, i4);
            if ((((float) min) >= f2 || ((float) max2) >= f3) && (((float) min) <= f2 || ((float) max2) <= f3)) {
                i6 = max2;
                i7 = min;
            } else {
                max = ((float) min) / ((float) max2);
                min = (int) f2;
                i6 = (int) (((float) min) / max);
                i7 = min;
            }
            float f4 = ((float) i7) / ((float) i6);
            if (f2 > f3) {
                max = f2 / f4;
                if (max < f3) {
                    f = f3 * f4;
                    max = f3;
                } else {
                    f = f2;
                }
            } else {
                f = f3 * f4;
                if (f < f2) {
                    max = f2 / f4;
                    f = f2;
                } else {
                    max = f3;
                }
            }
            f4 = ((float) i7) / f;
            float f5 = ((float) i6) / max;
            float min2 = Math.min(f4, f5);
            ab.i(this.TAG, "calcCenterCropScale, drawingSize:[" + f2 + ',' + f3 + "], bitmapSize:[" + i7 + ',' + i6 + "], scaleSize:[" + f + ',' + max + "], centerCropScale:" + min2 + ", scaleX:" + f4 + ", scaleY:" + f5);
            this.rWs = min2;
            this.rWr.postScale(this.rWs, this.rWs);
        }
        this.rWr.postTranslate(((float) i) / 2.0f, ((float) i2) / 2.0f);
        AppMethodBeat.o(109330);
    }

    public final c UX() {
        AppMethodBeat.i(109327);
        if (this.eWG.size() == 0) {
            AppMethodBeat.o(109327);
            return null;
        }
        long a;
        int save = this.bmG.save();
        this.bmG.drawColor(0, Mode.MULTIPLY);
        this.bmG.concat(this.rWr);
        try {
            a = this.lim.a(this.bmG, this.aFY);
        } catch (Exception e) {
            a = Long.MAX_VALUE;
        }
        this.bmG.restoreToCount(save);
        c cVar = new c(this.bitmap, a);
        AppMethodBeat.o(109327);
        return cVar;
    }

    public final void start() {
        AppMethodBeat.i(109328);
        try {
            for (b init : this.eWG) {
                init.init();
            }
            AppMethodBeat.o(109328);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "start error", new Object[0]);
            AppMethodBeat.o(109328);
        }
    }

    public final void destroy() {
        AppMethodBeat.i(109329);
        try {
            for (b destroy : this.eWG) {
                destroy.destroy();
            }
            AppMethodBeat.o(109329);
        } catch (Exception e) {
            ab.printErrStackTrace(this.TAG, e, "destroy error", new Object[0]);
            AppMethodBeat.o(109329);
        }
    }
}
