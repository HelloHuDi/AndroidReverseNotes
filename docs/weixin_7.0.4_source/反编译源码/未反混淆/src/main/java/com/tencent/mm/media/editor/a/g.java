package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/editor/item/EmojiItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "getEditorMatrix", "()Landroid/graphics/Matrix;", "setEditorMatrix", "(Landroid/graphics/Matrix;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "setShowMatrix", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class g extends a {
    private Matrix eUr;
    private Matrix eUs;
    public final EmojiInfo exP;

    public g(EmojiInfo emojiInfo, Matrix matrix, Matrix matrix2) {
        j.p(matrix, "showMatrix");
        j.p(matrix2, "editorMatrix");
        super(e.EMOJI);
        AppMethodBeat.i(12890);
        this.exP = emojiInfo;
        this.eUr = matrix;
        this.eUs = matrix2;
        AppMethodBeat.o(12890);
    }

    /* JADX WARNING: Missing block: B:9:0x004e, code skipped:
            if (r1 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:14:0x005d, code skipped:
            if (r1 == null) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final a UG() {
        String Aq;
        int i = 0;
        AppMethodBeat.i(12889);
        xy xyVar = new xy();
        float[] fArr = new float[9];
        cnw cnw = new cnw();
        this.eUs.getValues(fArr);
        for (int i2 = 0; i2 < 9; i2++) {
            cnw.xls.add(Float.valueOf(fArr[i2]));
        }
        cnw cnw2 = new cnw();
        fArr = new float[9];
        this.eUr.getValues(fArr);
        while (i < 9) {
            cnw2.xls.add(Float.valueOf(fArr[i]));
            i++;
        }
        EmojiInfo emojiInfo = this.exP;
        if (emojiInfo != null) {
            Aq = emojiInfo.Aq();
        }
        Aq = "";
        xyVar.cvZ = Aq;
        emojiInfo = this.exP;
        if (emojiInfo != null) {
            Aq = emojiInfo.getName();
        }
        Aq = "";
        xyVar.name = Aq;
        xyVar.wdG = cnw;
        xyVar.wdH = cnw2;
        a aVar = xyVar;
        AppMethodBeat.o(12889);
        return aVar;
    }
}
