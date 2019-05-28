package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/media/editor/item/EmojiEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
public final class f extends b {
    private final String TAG = "MicroMsg.EmojiEditorItem";
    private final Matrix aKk;
    private b eUq;
    private EmojiInfo exP;
    private Bitmap exl;

    public f(EmojiInfo emojiInfo, Matrix matrix) {
        j.p(emojiInfo, "emojiInfo");
        j.p(matrix, "matrix");
        AppMethodBeat.i(12888);
        this.exP = emojiInfo;
        this.aKk = matrix;
        AppMethodBeat.o(12888);
    }

    public final void init() {
        AppMethodBeat.i(12883);
        ab.d(this.TAG, "filepath is " + this.exP.dve());
        this.eUq = MMGIFJNIFactory.Companion.getDecoder(this.exP);
        AppMethodBeat.o(12883);
    }

    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.i(12884);
        j.p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        j.p(paint, "paint");
        canvas.save();
        canvas.concat(this.aKk);
        if (this.exl != null) {
            Bitmap bitmap = this.exl;
            if (bitmap == null) {
                j.dWJ();
            }
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        }
        canvas.restore();
        AppMethodBeat.o(12884);
    }

    public final long ff(long j) {
        AppMethodBeat.i(12885);
        ab.d(this.TAG, "request time is " + j + ", curr frame is " + this.eUj);
        long ff = super.ff(j);
        AppMethodBeat.o(12885);
        return ff;
    }

    public final long UH() {
        AppMethodBeat.i(12886);
        b bVar = this.eUq;
        if (bVar == null) {
            j.avw("decoder");
        }
        bVar.Or();
        bVar = this.eUq;
        if (bVar == null) {
            j.avw("decoder");
        }
        this.exl = bVar.Os();
        bVar = this.eUq;
        if (bVar == null) {
            j.avw("decoder");
        }
        long Ot = (long) bVar.Ot();
        AppMethodBeat.o(12886);
        return Ot;
    }

    public final void destroy() {
        AppMethodBeat.i(12887);
        b bVar = this.eUq;
        if (bVar == null) {
            j.avw("decoder");
        }
        bVar.destroy();
        AppMethodBeat.o(12887);
    }
}
