package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.os;
import com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public final class o extends c<os> {
    public o() {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
        this.xxI = os.class.getName().hashCode();
        AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        os osVar = (os) bVar;
        if (osVar == null) {
            ab.e("MicroMsg.FaceStartManageListener", "hy: event is null");
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
            return false;
        }
        Context context = osVar.cLf.context;
        os.b bVar2 = osVar.cLg;
        f fVar = f.lTL;
        ab.i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            ab.e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
        } else if (f.ha(true)) {
            context.startActivity(new Intent(context, SettingsFacePrintManagerUI.class));
            z = true;
        } else {
            ab.w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
        }
        bVar2.cKV = z;
        AppMethodBeat.o(d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        return true;
    }
}
