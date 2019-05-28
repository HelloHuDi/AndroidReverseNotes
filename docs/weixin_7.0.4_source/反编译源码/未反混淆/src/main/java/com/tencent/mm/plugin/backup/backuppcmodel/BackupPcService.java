package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;
import com.tencent.mm.storage.ac.a;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupPcService extends MMService {
    private boolean hOy = false;
    private boolean jwC = false;

    public final void onCreate() {
        AppMethodBeat.i(17564);
        ab.i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
        AppMethodBeat.o(17564);
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        AppMethodBeat.i(17565);
        ab.i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            ab.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
            AppMethodBeat.o(17565);
        } else {
            final String stringExtra = intent.getStringExtra("url");
            if (bo.isNullOrNil(stringExtra)) {
                ab.e("MicroMsg.BackupPcService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.o(17565);
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                ab.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
                d.aH(new Intent(ah.getContext(), BakOldUSBService.class).putExtra("url", intent.getStringExtra("url")).putExtra("isFromWifi", true));
                stopSelf();
                AppMethodBeat.o(17565);
            } else {
                this.jwC = intent.getBooleanExtra("isFromWifi", false);
                this.hOy = intent.getBooleanExtra("isMove", false);
                ab.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", stringExtra, Boolean.valueOf(this.jwC), Boolean.valueOf(this.hOy));
                if (this.hOy || aw.ZM()) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(17563);
                            c aTE = b.aTD().aTE();
                            ab.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", stringExtra);
                            com.tencent.mm.plugin.backup.b.d.rk(1);
                            b.aTZ();
                            aw.ZK();
                            aTE.jwg = ((Integer) c.Ry().get(a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, Integer.valueOf(0))).intValue();
                            b.aTD();
                            Editor edit = com.tencent.mm.plugin.backup.b.d.aSz().edit();
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
                            edit.commit();
                            aTE.jwh = true;
                            aw.Rg().a((int) l.CTRL_INDEX, aTE.jtG);
                            aw.Rg().a(new e(r2), 0);
                            AppMethodBeat.o(17563);
                        }
                    });
                    AppMethodBeat.o(17565);
                } else {
                    ab.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(ah.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    startActivity(className);
                    AppMethodBeat.o(17565);
                }
            }
        }
        return 2;
    }

    public final IBinder Iu() {
        return null;
    }

    public final void onDestroy() {
        AppMethodBeat.i(17566);
        super.onDestroy();
        ab.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
        AppMethodBeat.o(17566);
    }

    public final String getTag() {
        return "MicroMsg.BackupPcService";
    }
}
