package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.cgu;
import com.tencent.p177mm.protocal.protobuf.cnw;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/media/editor/item/TextItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "text", "", "textColor", "", "textBgColor", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IILandroid/graphics/Matrix;)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "()I", "getTextColor", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.j */
public final class C1772j extends C26382a {
    private Matrix aKk;
    private final int eUv;
    public final CharSequence text;
    private final int textColor;

    public C1772j(CharSequence charSequence, int i, int i2, Matrix matrix) {
        C25052j.m39376p(matrix, "matrix");
        super(C37889e.TEXT);
        AppMethodBeat.m2504i(12895);
        this.text = charSequence;
        this.textColor = i;
        this.eUv = i2;
        this.aKk = matrix;
        AppMethodBeat.m2505o(12895);
    }

    /* renamed from: UG */
    public final C1331a mo5316UG() {
        AppMethodBeat.m2504i(12894);
        cgu cgu = new cgu();
        float[] fArr = new float[9];
        cnw cnw = new cnw();
        this.aKk.getValues(fArr);
        for (int i = 0; i < 9; i++) {
            cnw.xls.add(Float.valueOf(fArr[i]));
        }
        cgu.text = String.valueOf(this.text);
        cgu.wCL = cnw;
        cgu.eUv = this.eUv;
        cgu.textColor = this.textColor;
        C1331a c1331a = cgu;
        AppMethodBeat.m2505o(12894);
        return c1331a;
    }
}
