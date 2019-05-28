package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.decode.C26076b;
import com.tencent.p177mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, dWq = {"Lcom/tencent/mm/media/editor/item/EmojiEditorItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;)V", "TAG", "", "decoder", "Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "lastValidFrame", "Landroid/graphics/Bitmap;", "consumeTime", "", "lastFrameTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.f */
public final class C45427f extends C9584b {
    private final String TAG = "MicroMsg.EmojiEditorItem";
    private final Matrix aKk;
    private C26076b eUq;
    private EmojiInfo exP;
    private Bitmap exl;

    public C45427f(EmojiInfo emojiInfo, Matrix matrix) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(matrix, "matrix");
        AppMethodBeat.m2504i(12888);
        this.exP = emojiInfo;
        this.aKk = matrix;
        AppMethodBeat.m2505o(12888);
    }

    public final void init() {
        AppMethodBeat.m2504i(12883);
        C4990ab.m7410d(this.TAG, "filepath is " + this.exP.dve());
        this.eUq = MMGIFJNIFactory.Companion.getDecoder(this.exP);
        AppMethodBeat.m2505o(12883);
    }

    public final void draw(Canvas canvas, Paint paint) {
        AppMethodBeat.m2504i(12884);
        C25052j.m39376p(canvas, VideoMaterialUtil.CRAZYFACE_CANVAS);
        C25052j.m39376p(paint, "paint");
        canvas.save();
        canvas.concat(this.aKk);
        if (this.exl != null) {
            Bitmap bitmap = this.exl;
            if (bitmap == null) {
                C25052j.dWJ();
            }
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        }
        canvas.restore();
        AppMethodBeat.m2505o(12884);
    }

    /* renamed from: ff */
    public final long mo20907ff(long j) {
        AppMethodBeat.m2504i(12885);
        C4990ab.m7410d(this.TAG, "request time is " + j + ", curr frame is " + this.eUj);
        long ff = super.mo20907ff(j);
        AppMethodBeat.m2505o(12885);
        return ff;
    }

    /* renamed from: UH */
    public final long mo20904UH() {
        AppMethodBeat.m2504i(12886);
        C26076b c26076b = this.eUq;
        if (c26076b == null) {
            C25052j.avw("decoder");
        }
        c26076b.mo33669Or();
        c26076b = this.eUq;
        if (c26076b == null) {
            C25052j.avw("decoder");
        }
        this.exl = c26076b.mo33670Os();
        c26076b = this.eUq;
        if (c26076b == null) {
            C25052j.avw("decoder");
        }
        long Ot = (long) c26076b.mo33671Ot();
        AppMethodBeat.m2505o(12886);
        return Ot;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(12887);
        C26076b c26076b = this.eUq;
        if (c26076b == null) {
            C25052j.avw("decoder");
        }
        c26076b.destroy();
        AppMethodBeat.m2505o(12887);
    }
}
