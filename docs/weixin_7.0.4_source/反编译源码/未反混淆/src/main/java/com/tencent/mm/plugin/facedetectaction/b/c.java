package com.tencent.mm.plugin.facedetectaction.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class c extends com.tencent.mm.sdk.b.c<oo> {
    public c() {
        AppMethodBeat.i(687);
        this.xxI = oo.class.getName().hashCode();
        AppMethodBeat.o(687);
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z;
        AppMethodBeat.i(688);
        oo ooVar = (oo) bVar;
        int i = ooVar.cKR.scene;
        String str = ooVar.cKR.packageName;
        String str2 = ooVar.cKR.cKT;
        String str3 = ooVar.cKR.cKU;
        Activity activity = ooVar.cKR.czX;
        int i2 = ooVar.cKR.requestCode;
        ab.i("MicroMsg.FaceCheckActionEventListener", "receive face check action event, scene: %s, package: %s, sign: %s, title: %s", Integer.valueOf(i), str, str2, str3);
        oo.b bVar2 = ooVar.cKS;
        d dVar = d.mcq;
        ab.i("MicroMsg.FaceCheckActionMgr", "startFaceCheckAction, scene: %s, packageName: %s, packageSign: %s, otherVerifyTitle: %s, requestCode: %s", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2));
        if (activity == null) {
            z = false;
        } else {
            dVar.mcr = new b();
            dVar.scene = i;
            dVar.packageName = str;
            dVar.cKT = str2;
            dVar.cKU = str3;
            dVar.requestCode = i2;
            Intent intent = new Intent(activity, FaceActionUI.class);
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, i2);
            dVar.mcx = d.anM("FaceCheckActionMgr_worker");
            dVar.mcx.start();
            dVar.mcy = new ak(dVar.mcx.getLooper());
            z = true;
        }
        bVar2.cKV = z;
        if (!ooVar.cKS.cKV) {
            ooVar.cKS.extras = new Bundle();
            ooVar.cKS.extras.putInt("err_code", 90001);
            ooVar.cKS.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.o(688);
        return false;
    }
}
