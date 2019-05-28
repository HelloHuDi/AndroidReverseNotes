package com.tencent.p177mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C45354os;
import com.tencent.p177mm.p230g.p231a.C45354os.C9438b;
import com.tencent.p177mm.plugin.facedetect.p403ui.SettingsFacePrintManagerUI;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.model.o */
public final class C20641o extends C4884c<C45354os> {
    public C20641o() {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
        this.xxI = C45354os.class.getName().hashCode();
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        boolean z = false;
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        C45354os c45354os = (C45354os) c4883b;
        if (c45354os == null) {
            C4990ab.m7412e("MicroMsg.FaceStartManageListener", "hy: event is null");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
            return false;
        }
        Context context = c45354os.cLf.context;
        C9438b c9438b = c45354os.cLg;
        C11810f c11810f = C11810f.lTL;
        C4990ab.m7416i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
        } else if (C11810f.m19662ha(true)) {
            context.startActivity(new Intent(context, SettingsFacePrintManagerUI.class));
            z = true;
        } else {
            C4990ab.m7420w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
        }
        c9438b.cKV = z;
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW);
        return true;
    }
}
