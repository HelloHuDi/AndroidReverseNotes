package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.base.t;
import java.io.File;

@k
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MountReceiver extends BroadcastReceiver {
    private String action = "";
    private Context context = null;
    private ak ebW = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(15845);
            String str = "MicroMsg.MountReceiver";
            String str2 = "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b";
            Object[] objArr = new Object[4];
            objArr[0] = MountReceiver.this.action;
            objArr[1] = Boolean.valueOf(aw.RK());
            if (MountReceiver.this.context != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(f.Mo());
            ab.d(str, str2, objArr);
            if (MountReceiver.this.context == null) {
                AppMethodBeat.o(15845);
            } else if (f.Mo()) {
                t.hP(MountReceiver.this.context);
                AppMethodBeat.o(15845);
            } else {
                AppMethodBeat.o(15845);
            }
        }
    };

    public MountReceiver() {
        AppMethodBeat.i(15848);
        AppMethodBeat.o(15848);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(15849);
        if (context == null || intent == null || ah.isNullOrNil(intent.getAction())) {
            AppMethodBeat.o(15849);
            return;
        }
        this.context = context;
        this.action = intent.getAction();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        ab.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", this.action, Boolean.valueOf(aw.RK()), e.eSl, absolutePath);
        boolean equals = this.action.equals("android.intent.action.MEDIA_MOUNTED");
        if (equals || this.action.equals("android.intent.action.MEDIA_EJECT") || this.action.equals("android.intent.action.MEDIA_SHARED")) {
            Object obj = !e.eSl.equalsIgnoreCase("/dev/null") ? 1 : null;
            if (obj != null) {
                try {
                    StatFs statFs = new StatFs(e.eSl);
                    ab.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", e.eSl, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
                } catch (Exception e) {
                    ab.e("MicroMsg.MountReceiver", "CheckSD failed :%s", e.getMessage());
                    obj = null;
                }
            }
            Uri data = intent.getData();
            if (data != null) {
                String path = data.getPath();
                if (!e.eSl.equalsIgnoreCase(path)) {
                    if (equals && obj == null) {
                        h.pYm.a(340, e.eSl.equalsIgnoreCase("/dev/null") ? 9 : 12, 1, false);
                        if (ah.isNullOrNil(absolutePath) || !absolutePath.equalsIgnoreCase(path)) {
                            AppMethodBeat.o(15849);
                            return;
                        } else if (new File(ac.eSj + "SdcardInfo.cfg").exists()) {
                            y yVar = new y(ac.eSj + "SdcardInfo.cfg");
                            String str = (String) yVar.get(1, "");
                            int intValue = ((Integer) yVar.get(2, Integer.valueOf(0))).intValue();
                            int i = VERSION.SDK_INT;
                            String str2 = e.eSl;
                            yVar.set(1, absolutePath);
                            yVar.set(2, Integer.valueOf(i));
                            e.kw(absolutePath);
                            ab.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", Integer.valueOf(intValue), str, Integer.valueOf(i), absolutePath, str2, e.eSl);
                        } else {
                            ab.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", e.eSl, absolutePath, Integer.valueOf(VERSION.SDK_INT));
                            e.eSl = absolutePath;
                            e.kw(absolutePath);
                        }
                    } else {
                        AppMethodBeat.o(15849);
                        return;
                    }
                }
            }
            h.pYm.a(340, equals ? 13 : 14, 1, false);
            if (equals) {
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(15846);
                        ab.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", MountReceiver.this.action, Boolean.valueOf(aw.RK()));
                        if (aw.RK()) {
                            g.RP().RC();
                            aw.ZK();
                            c.RA();
                            MountReceiver.this.ebW.sendEmptyMessage(0);
                            AppMethodBeat.o(15846);
                            return;
                        }
                        AppMethodBeat.o(15846);
                    }
                });
                AppMethodBeat.o(15849);
                return;
            }
            t.hO(context);
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(15847);
                    ab.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", MountReceiver.this.action, Boolean.valueOf(aw.RK()));
                    if (aw.RK()) {
                        g.RP().RC();
                        aw.ZK();
                        c.RA();
                        AppMethodBeat.o(15847);
                        return;
                    }
                    AppMethodBeat.o(15847);
                }
            });
            AppMethodBeat.o(15849);
            return;
        }
        AppMethodBeat.o(15849);
    }
}
