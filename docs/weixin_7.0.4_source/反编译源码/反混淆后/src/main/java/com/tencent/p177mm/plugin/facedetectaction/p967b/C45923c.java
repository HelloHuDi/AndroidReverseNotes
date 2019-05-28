package com.tencent.p177mm.plugin.facedetectaction.p967b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9431oo;
import com.tencent.p177mm.p230g.p231a.C9431oo.C9433b;
import com.tencent.p177mm.plugin.facedetectaction.p404ui.FaceActionUI;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.facedetectaction.b.c */
public final class C45923c extends C4884c<C9431oo> {
    public C45923c() {
        AppMethodBeat.m2504i(687);
        this.xxI = C9431oo.class.getName().hashCode();
        AppMethodBeat.m2505o(687);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        boolean z;
        AppMethodBeat.m2504i(688);
        C9431oo c9431oo = (C9431oo) c4883b;
        int i = c9431oo.cKR.scene;
        String str = c9431oo.cKR.packageName;
        String str2 = c9431oo.cKR.cKT;
        String str3 = c9431oo.cKR.cKU;
        Activity activity = c9431oo.cKR.czX;
        int i2 = c9431oo.cKR.requestCode;
        C4990ab.m7417i("MicroMsg.FaceCheckActionEventListener", "receive face check action event, scene: %s, package: %s, sign: %s, title: %s", Integer.valueOf(i), str, str2, str3);
        C9433b c9433b = c9431oo.cKS;
        C43048d c43048d = C43048d.mcq;
        C4990ab.m7417i("MicroMsg.FaceCheckActionMgr", "startFaceCheckAction, scene: %s, packageName: %s, packageSign: %s, otherVerifyTitle: %s, requestCode: %s", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2));
        if (activity == null) {
            z = false;
        } else {
            c43048d.mcr = new C39031b();
            c43048d.scene = i;
            c43048d.packageName = str;
            c43048d.cKT = str2;
            c43048d.cKU = str3;
            c43048d.requestCode = i2;
            Intent intent = new Intent(activity, FaceActionUI.class);
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i2);
            c43048d.mcx = C7305d.anM("FaceCheckActionMgr_worker");
            c43048d.mcx.start();
            c43048d.mcy = new C7306ak(c43048d.mcx.getLooper());
            z = true;
        }
        c9433b.cKV = z;
        if (!c9431oo.cKS.cKV) {
            c9431oo.cKS.extras = new Bundle();
            c9431oo.cKS.extras.putInt("err_code", 90001);
            c9431oo.cKS.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.m2505o(688);
        return false;
    }
}
