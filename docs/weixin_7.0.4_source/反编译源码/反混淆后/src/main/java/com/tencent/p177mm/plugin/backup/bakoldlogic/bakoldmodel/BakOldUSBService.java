package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C27460e;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C38643c;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel.C41257a;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p343c.C11123f;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.protocal.protobuf.ahq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.MMService;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService */
public class BakOldUSBService extends MMService implements C1202f {
    private boolean jwC = false;
    private int jyS = -1;

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        AppMethodBeat.m2504i(17755);
        C4990ab.m7416i("MicroMsg.BakOldUSBService", "onBind()");
        AppMethodBeat.m2505o(17755);
        return null;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(17756);
        C4990ab.m7416i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        C9638aw.m17182Rg().mo14539a((int) C19320l.CTRL_INDEX, (C1202f) this);
        C19978b.m30879a(1, (C1202f) this);
        AppMethodBeat.m2505o(17756);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        AppMethodBeat.m2504i(17757);
        C4990ab.m7417i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", Integer.valueOf(this.jyS));
        if (intent == null) {
            C4990ab.m7420w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
            AppMethodBeat.m2505o(17757);
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7412e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.m2505o(17757);
            } else {
                this.jwC = intent.getBooleanExtra("isFromWifi", false);
                C4990ab.m7417i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.jwC));
                C41257a.aUB().aUD().aar();
                C38643c aUD = C41257a.aUB().aUD();
                if (this.jwC) {
                    i3 = 2;
                }
                aUD.jzj = i3;
                if (C9638aw.m17192ZM()) {
                    C9638aw.m17182Rg().mo14541a(new C11123f(stringExtra), 0);
                    AppMethodBeat.m2505o(17757);
                } else {
                    C4990ab.m7412e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                    AppMethodBeat.m2505o(17757);
                }
            }
        }
        return 2;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(17758);
        C9638aw.m17182Rg().mo14546b((int) C19320l.CTRL_INDEX, (C1202f) this);
        C19978b.m30886b(1, this);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
        AppMethodBeat.m2505o(17758);
    }

    private boolean aUz() {
        return this.jyS == 0 || this.jyS == 1;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(17759);
        String str2 = "MicroMsg.BakOldUSBService";
        String str3 = "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = c1207m == null ? "" : c1207m.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.jyS);
        C4990ab.m7417i(str2, str3, objArr);
        if (c1207m instanceof C19978b) {
            C4990ab.m7411d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", Integer.valueOf(c1207m.getType()), Integer.valueOf(this.jyS));
            if (c1207m.getType() == 1 && i == 0 && i2 == 0) {
                boolean z;
                Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
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
            AppMethodBeat.m2505o(17759);
            return;
        }
        if (c1207m instanceof C11123f) {
            if (i == 0 && i2 == 0) {
                ahq aUU = ((C11123f) c1207m).aUU();
                C41257a.aUB().jqO = aUU.f2976ID;
                C41257a.aUB().jqP = aUU.vIW;
                C41257a.aUB().jqQ = aUU.vIX;
                this.jyS = aUU.Scene;
                C4990ab.m7411d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", Integer.valueOf(aUU.jCt), Integer.valueOf(aUU.Scene), Boolean.valueOf(this.jwC));
                if (!this.jwC && aUU.jCt == 1) {
                    C4990ab.m7412e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    AppMethodBeat.m2505o(17759);
                    return;
                } else if (aUz()) {
                    C41257a.aUB().aUC().mo45245cZ(aUU.vIP, aUU.vIQ);
                    C19978b.m30883a(C41257a.aUB().aUC());
                    C19978b.m30880a(C41257a.aUB().aUE());
                    C19978b.m30890rk(1);
                    C41257a.aUB().aUE().mo73538e(aUU.jCt, aUU.vIO);
                    AppMethodBeat.m2505o(17759);
                    return;
                } else {
                    C4990ab.m7411d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", Integer.valueOf(this.jyS));
                    AppMethodBeat.m2505o(17759);
                    return;
                }
            }
            C41257a.aUB().aUD().jzk = 2;
            C41257a.aUB().aUD().aar();
            if (i == 4 && i2 == -2011) {
                C4990ab.m7416i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
            } else {
                C4990ab.m7416i("MicroMsg.BakOldUSBService", "getConnect info other error");
            }
            C41257a.aUB().aUC();
            C27460e.aUL();
            stopSelf();
        }
        AppMethodBeat.m2505o(17759);
    }

    public final String getTag() {
        return "MicroMsg.BakOldUSBService";
    }
}
