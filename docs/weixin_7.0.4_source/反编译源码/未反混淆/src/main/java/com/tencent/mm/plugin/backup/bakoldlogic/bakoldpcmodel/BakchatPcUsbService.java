package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakchatPcUsbService extends MMService implements f {
    private boolean jwC = false;

    public final IBinder Iu() {
        return null;
    }

    public final void onCreate() {
        AppMethodBeat.i(17857);
        ab.i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        aw.Rg().a((int) l.CTRL_INDEX, (f) this);
        b.a(1, (f) this);
        AppMethodBeat.o(17857);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        AppMethodBeat.i(17858);
        ab.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            ab.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
            AppMethodBeat.o(17858);
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (bo.isNullOrNil(stringExtra)) {
                ab.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.o(17858);
            } else {
                this.jwC = intent.getBooleanExtra("isFromWifi", false);
                ab.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.jwC));
                a.aUB().aUD().aar();
                c aUD = a.aUB().aUD();
                if (this.jwC) {
                    i3 = 2;
                }
                aUD.jzj = i3;
                if (aw.ZM()) {
                    aw.Rg().a(new com.tencent.mm.plugin.backup.bakoldlogic.c.f(stringExtra), 0);
                    AppMethodBeat.o(17858);
                } else {
                    ab.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                    AppMethodBeat.o(17858);
                }
            }
        }
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.i(17859);
        aw.Rg().b((int) l.CTRL_INDEX, (f) this);
        b.b(1, this);
        super.onDestroy();
        ab.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
        AppMethodBeat.o(17859);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(17860);
        if (mVar instanceof b) {
            if (mVar.getType() == 1 && i == 0 && i2 == 0) {
                Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                startActivity(className);
            }
            stopSelf();
            AppMethodBeat.o(17860);
            return;
        }
        if (mVar instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.f) {
            if (i == 0 && i2 == 0) {
                ahq aUU = ((com.tencent.mm.plugin.backup.bakoldlogic.c.f) mVar).aUU();
                if (this.jwC) {
                    ab.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
                    a.aUB().aUE().aUF();
                }
                if (this.jwC || aUU.jCt != 1) {
                    a.aUB().jqO = aUU.ID;
                    a.aUB().jqP = aUU.vIW;
                    a.aUB().jqQ = aUU.vIX;
                    a.aUB().aUC().cZ(aUU.vIP, aUU.vIQ);
                    b.a(a.aUB().aUC());
                    b.a(a.aUB().aUE());
                    b.rk(1);
                    a.aUB().aUE().e(aUU.jCt, aUU.vIO);
                    AppMethodBeat.o(17860);
                    return;
                }
                ab.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
                stopSelf();
                AppMethodBeat.o(17860);
                return;
            }
            a.aUB().aUD().jzk = 2;
            a.aUB().aUD().aar();
            if (i == 4 && i2 == -2011) {
                ab.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
                if (this.jwC) {
                }
            } else {
                ab.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
            }
            a.aUB().aUC();
            e.aUL();
            stopSelf();
        }
        AppMethodBeat.o(17860);
    }

    public final String getTag() {
        return "MicroMsg.BakchatPcUsbService";
    }
}
