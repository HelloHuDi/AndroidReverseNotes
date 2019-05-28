package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C11123f;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.protocal.protobuf.ahq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.MMService;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService */
public class BakchatPcUsbService extends MMService implements C1202f {
    private boolean jwC = false;

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        return null;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(17857);
        C4990ab.m7416i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        C9638aw.m17182Rg().mo14539a((int) C19320l.CTRL_INDEX, (C1202f) this);
        C19978b.m30879a(1, (C1202f) this);
        AppMethodBeat.m2505o(17857);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        AppMethodBeat.m2504i(17858);
        C4990ab.m7416i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            C4990ab.m7420w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
            AppMethodBeat.m2505o(17858);
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7412e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.m2505o(17858);
            } else {
                this.jwC = intent.getBooleanExtra("isFromWifi", false);
                C4990ab.m7417i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.jwC));
                C41257a.aUB().aUD().aar();
                C38643c aUD = C41257a.aUB().aUD();
                if (this.jwC) {
                    i3 = 2;
                }
                aUD.jzj = i3;
                if (C9638aw.m17192ZM()) {
                    C9638aw.m17182Rg().mo14541a(new C11123f(stringExtra), 0);
                    AppMethodBeat.m2505o(17858);
                } else {
                    C4990ab.m7412e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                    AppMethodBeat.m2505o(17858);
                }
            }
        }
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(17859);
        C9638aw.m17182Rg().mo14546b((int) C19320l.CTRL_INDEX, (C1202f) this);
        C19978b.m30886b(1, this);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
        AppMethodBeat.m2505o(17859);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(17860);
        if (c1207m instanceof C19978b) {
            if (c1207m.getType() == 1 && i == 0 && i2 == 0) {
                Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                startActivity(className);
            }
            stopSelf();
            AppMethodBeat.m2505o(17860);
            return;
        }
        if (c1207m instanceof C11123f) {
            if (i == 0 && i2 == 0) {
                ahq aUU = ((C11123f) c1207m).aUU();
                if (this.jwC) {
                    C4990ab.m7416i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
                    C41257a.aUB().aUE().aUF();
                }
                if (this.jwC || aUU.jCt != 1) {
                    C41257a.aUB().jqO = aUU.f2976ID;
                    C41257a.aUB().jqP = aUU.vIW;
                    C41257a.aUB().jqQ = aUU.vIX;
                    C41257a.aUB().aUC().mo45245cZ(aUU.vIP, aUU.vIQ);
                    C19978b.m30883a(C41257a.aUB().aUC());
                    C19978b.m30880a(C41257a.aUB().aUE());
                    C19978b.m30890rk(1);
                    C41257a.aUB().aUE().mo73538e(aUU.jCt, aUU.vIO);
                    AppMethodBeat.m2505o(17860);
                    return;
                }
                C4990ab.m7412e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
                stopSelf();
                AppMethodBeat.m2505o(17860);
                return;
            }
            C41257a.aUB().aUD().jzk = 2;
            C41257a.aUB().aUD().aar();
            if (i == 4 && i2 == -2011) {
                C4990ab.m7416i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
                if (this.jwC) {
                }
            } else {
                C4990ab.m7416i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
            }
            C41257a.aUB().aUC();
            C27460e.aUL();
            stopSelf();
        }
        AppMethodBeat.m2505o(17860);
    }

    public final String getTag() {
        return "MicroMsg.BakchatPcUsbService";
    }
}
