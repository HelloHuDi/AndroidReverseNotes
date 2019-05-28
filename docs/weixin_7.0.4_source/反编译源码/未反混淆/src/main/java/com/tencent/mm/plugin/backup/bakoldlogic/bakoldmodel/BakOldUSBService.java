package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakOldUSBService extends MMService implements f {
    private boolean jwC = false;
    private int jyS = -1;

    public final IBinder Iu() {
        AppMethodBeat.i(17755);
        ab.i("MicroMsg.BakOldUSBService", "onBind()");
        AppMethodBeat.o(17755);
        return null;
    }

    public final void onCreate() {
        AppMethodBeat.i(17756);
        ab.i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        aw.Rg().a((int) l.CTRL_INDEX, (f) this);
        b.a(1, (f) this);
        AppMethodBeat.o(17756);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        AppMethodBeat.i(17757);
        ab.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", Integer.valueOf(this.jyS));
        if (intent == null) {
            ab.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
            AppMethodBeat.o(17757);
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (bo.isNullOrNil(stringExtra)) {
                ab.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.o(17757);
            } else {
                this.jwC = intent.getBooleanExtra("isFromWifi", false);
                ab.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.jwC));
                a.aUB().aUD().aar();
                c aUD = a.aUB().aUD();
                if (this.jwC) {
                    i3 = 2;
                }
                aUD.jzj = i3;
                if (aw.ZM()) {
                    aw.Rg().a(new com.tencent.mm.plugin.backup.bakoldlogic.c.f(stringExtra), 0);
                    AppMethodBeat.o(17757);
                } else {
                    ab.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                    AppMethodBeat.o(17757);
                }
            }
        }
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.i(17758);
        aw.Rg().b((int) l.CTRL_INDEX, (f) this);
        b.b(1, this);
        super.onDestroy();
        ab.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
        AppMethodBeat.o(17758);
    }

    private boolean aUz() {
        return this.jyS == 0 || this.jyS == 1;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(17759);
        String str2 = "MicroMsg.BakOldUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = mVar == null ? "" : mVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.jyS);
        ab.i(str2, str3, objArr);
        if (mVar instanceof b) {
            ab.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", Integer.valueOf(mVar.getType()), Integer.valueOf(this.jyS));
            if (mVar.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                str3 = "newPCBackup";
                if (aUz()) {
                    z = false;
                } else {
                    z = true;
                }
                className.putExtra(str3, z);
                startActivity(className);
            }
            stopSelf();
            AppMethodBeat.o(17759);
            return;
        }
        if (mVar instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f) {
            if (i == 0 && i2 == 0) {
                ahq aUU = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f) mVar).aUU();
                a.aUB().jqO = aUU.ID;
                a.aUB().jqP = aUU.vIW;
                a.aUB().jqQ = aUU.vIX;
                this.jyS = aUU.Scene;
                ab.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", Integer.valueOf(aUU.jCt), Integer.valueOf(aUU.Scene), Boolean.valueOf(this.jwC));
                if (!this.jwC && aUU.jCt == 1) {
                    ab.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    AppMethodBeat.o(17759);
                    return;
                } else if (aUz()) {
                    a.aUB().aUC().cZ(aUU.vIP, aUU.vIQ);
                    b.a(a.aUB().aUC());
                    b.a(a.aUB().aUE());
                    b.rk(1);
                    a.aUB().aUE().e(aUU.jCt, aUU.vIO);
                    AppMethodBeat.o(17759);
                    return;
                } else {
                    ab.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", Integer.valueOf(this.jyS));
                    AppMethodBeat.o(17759);
                    return;
                }
            }
            a.aUB().aUD().jzk = 2;
            a.aUB().aUD().aar();
            if (i == 4 && i2 == -2011) {
                ab.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
            } else {
                ab.i("MicroMsg.BakOldUSBService", "getConnect info other error");
            }
            a.aUB().aUC();
            e.aUL();
            stopSelf();
        }
        AppMethodBeat.o(17759);
    }

    public final String getTag() {
        return "MicroMsg.BakOldUSBService";
    }
}
