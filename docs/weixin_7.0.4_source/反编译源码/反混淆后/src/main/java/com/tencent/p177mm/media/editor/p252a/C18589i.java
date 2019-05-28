package com.tencent.p177mm.media.editor.p252a;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.ayv;
import com.tencent.p177mm.protocal.protobuf.cnw;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/media/editor/item/LocationItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "cityName", "", "poiName", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Matrix;)V", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "getPoiName", "setPoiName", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.editor.a.i */
public final class C18589i extends C26382a {
    private Matrix aKk;
    public String eUt;
    public String eUu;

    public /* synthetic */ C18589i(String str, String str2) {
        this(str, str2, new Matrix());
        AppMethodBeat.m2504i(12893);
        AppMethodBeat.m2505o(12893);
    }

    public C18589i(String str, String str2, Matrix matrix) {
        C25052j.m39376p(str, "cityName");
        C25052j.m39376p(str2, "poiName");
        C25052j.m39376p(matrix, "matrix");
        super(C37889e.LOCATION);
        AppMethodBeat.m2504i(12892);
        this.eUt = str;
        this.eUu = str2;
        this.aKk = matrix;
        AppMethodBeat.m2505o(12892);
    }

    /* renamed from: UG */
    public final C1331a mo5316UG() {
        AppMethodBeat.m2504i(12891);
        ayv ayv = new ayv();
        float[] fArr = new float[9];
        cnw cnw = new cnw();
        this.aKk.getValues(fArr);
        for (int i = 0; i < 9; i++) {
            cnw.xls.add(Float.valueOf(fArr[i]));
        }
        ayv.eUt = this.eUt;
        ayv.eUu = this.eUu;
        ayv.wCL = cnw;
        C1331a c1331a = ayv;
        AppMethodBeat.m2505o(12891);
        return c1331a;
    }
}
