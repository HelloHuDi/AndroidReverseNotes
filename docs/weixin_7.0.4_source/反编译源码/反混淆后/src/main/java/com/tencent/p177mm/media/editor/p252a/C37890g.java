package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.C46599xy;
import com.tencent.p177mm.protocal.protobuf.cnw;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/media/editor/item/EmojiItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "showMatrix", "Landroid/graphics/Matrix;", "editorMatrix", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/graphics/Matrix;Landroid/graphics/Matrix;)V", "getEditorMatrix", "()Landroid/graphics/Matrix;", "setEditorMatrix", "(Landroid/graphics/Matrix;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getShowMatrix", "setShowMatrix", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.g */
public final class C37890g extends C26382a {
    private Matrix eUr;
    private Matrix eUs;
    public final EmojiInfo exP;

    public C37890g(EmojiInfo emojiInfo, Matrix matrix, Matrix matrix2) {
        C25052j.m39376p(matrix, "showMatrix");
        C25052j.m39376p(matrix2, "editorMatrix");
        super(C37889e.EMOJI);
        AppMethodBeat.m2504i(12890);
        this.exP = emojiInfo;
        this.eUr = matrix;
        this.eUs = matrix2;
        AppMethodBeat.m2505o(12890);
    }

    /* JADX WARNING: Missing block: B:9:0x004e, code skipped:
            if (r1 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:14:0x005d, code skipped:
            if (r1 == null) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: UG */
    public final C1331a mo5316UG() {
        String Aq;
        int i = 0;
        AppMethodBeat.m2504i(12889);
        C46599xy c46599xy = new C46599xy();
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
            Aq = emojiInfo.mo20410Aq();
        }
        Aq = "";
        c46599xy.cvZ = Aq;
        emojiInfo = this.exP;
        if (emojiInfo != null) {
            Aq = emojiInfo.getName();
        }
        Aq = "";
        c46599xy.name = Aq;
        c46599xy.wdG = cnw;
        c46599xy.wdH = cnw2;
        C1331a c1331a = c46599xy;
        AppMethodBeat.m2505o(12889);
        return c1331a;
    }
}
