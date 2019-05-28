package com.tencent.mm.media.editor.a;

import a.f.b.j;
import a.l;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.cnw;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/media/editor/item/LocationItem;", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "cityName", "", "poiName", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Matrix;)V", "getCityName", "()Ljava/lang/String;", "setCityName", "(Ljava/lang/String;)V", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "getPoiName", "setPoiName", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "plugin-mediaeditor_release"})
public final class i extends a {
    private Matrix aKk;
    public String eUt;
    public String eUu;

    public /* synthetic */ i(String str, String str2) {
        this(str, str2, new Matrix());
        AppMethodBeat.i(12893);
        AppMethodBeat.o(12893);
    }

    public i(String str, String str2, Matrix matrix) {
        j.p(str, "cityName");
        j.p(str2, "poiName");
        j.p(matrix, "matrix");
        super(e.LOCATION);
        AppMethodBeat.i(12892);
        this.eUt = str;
        this.eUu = str2;
        this.aKk = matrix;
        AppMethodBeat.o(12892);
    }

    public final a UG() {
        AppMethodBeat.i(12891);
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
        a aVar = ayv;
        AppMethodBeat.o(12891);
        return aVar;
    }
}
