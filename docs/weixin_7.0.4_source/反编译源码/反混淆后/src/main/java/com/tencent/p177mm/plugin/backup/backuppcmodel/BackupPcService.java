package com.tencent.p177mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C42773e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.MMService;
import com.tencent.p177mm.storage.C5128ac.C5127a;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
/* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService */
public class BackupPcService extends MMService {
    private boolean hOy = false;
    private boolean jwC = false;

    public final void onCreate() {
        AppMethodBeat.m2504i(17564);
        C4990ab.m7416i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
        AppMethodBeat.m2505o(17564);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.m2504i(17565);
        C4990ab.m7416i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            C4990ab.m7420w("MicroMsg.BackupPcService", "onStartCommand intent is null");
            AppMethodBeat.m2505o(17565);
        } else {
            final String stringExtra = intent.getStringExtra("url");
            if (C5046bo.isNullOrNil(stringExtra)) {
                C4990ab.m7412e("MicroMsg.BackupPcService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.m2505o(17565);
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                C4990ab.m7416i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
                C25985d.m41463aH(new Intent(C4996ah.getContext(), BakOldUSBService.class).putExtra("url", intent.getStringExtra("url")).putExtra("isFromWifi", true));
                stopSelf();
                AppMethodBeat.m2505o(17565);
            } else {
                this.jwC = intent.getBooleanExtra("isFromWifi", false);
                this.hOy = intent.getBooleanExtra("isMove", false);
                C4990ab.m7417i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", stringExtra, Boolean.valueOf(this.jwC), Boolean.valueOf(this.hOy));
                if (this.hOy || C9638aw.m17192ZM()) {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(17563);
                            C45736c aTE = C42759b.aTD().aTE();
                            C4990ab.m7421w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", stringExtra);
                            C38634d.m65498rk(1);
                            C19978b.aTZ();
                            C9638aw.m17190ZK();
                            aTE.jwg = ((Integer) C18628c.m29072Ry().get(C5127a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(0))).intValue();
                            C42759b.aTD();
                            Editor edit = C38634d.aSz().edit();
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
                            edit.commit();
                            aTE.jwh = true;
                            C9638aw.m17182Rg().mo14539a((int) C19320l.CTRL_INDEX, aTE.jtG);
                            C9638aw.m17182Rg().mo14541a(new C42773e(r2), 0);
                            AppMethodBeat.m2505o(17563);
                        }
                    });
                    AppMethodBeat.m2505o(17565);
                } else {
                    C4990ab.m7412e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(C4996ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                    AppMethodBeat.m2505o(17565);
                }
            }
        }
        return 2;
    }

    /* renamed from: Iu */
    public final IBinder mo10421Iu() {
        return null;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(17566);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
        AppMethodBeat.m2505o(17566);
    }

    public final String getTag() {
        return "MicroMsg.BackupPcService";
    }
}
