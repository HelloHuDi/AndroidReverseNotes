package com.tencent.p177mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C26347k;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5144y;
import java.io.File;

@C26347k
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
/* renamed from: com.tencent.mm.booter.MountReceiver */
public class MountReceiver extends BroadcastReceiver {
    private String action = "";
    private Context context = null;
    private C7306ak ebW = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.m2504i(15845);
            String str = "MicroMsg.MountReceiver";
            String str2 = "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b";
            Object[] objArr = new Object[4];
            objArr[0] = MountReceiver.this.action;
            objArr[1] = Boolean.valueOf(C9638aw.m17179RK());
            if (MountReceiver.this.context != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(C1445f.m3071Mo());
            C4990ab.m7411d(str, str2, objArr);
            if (MountReceiver.this.context == null) {
                AppMethodBeat.m2505o(15845);
            } else if (C1445f.m3071Mo()) {
                C23639t.m36493hP(MountReceiver.this.context);
                AppMethodBeat.m2505o(15845);
            } else {
                AppMethodBeat.m2505o(15845);
            }
        }
    };

    /* renamed from: com.tencent.mm.booter.MountReceiver$2 */
    class C180962 implements Runnable {
        C180962() {
        }

        public final void run() {
            AppMethodBeat.m2504i(15846);
            C4990ab.m7411d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", MountReceiver.this.action, Boolean.valueOf(C9638aw.m17179RK()));
            if (C9638aw.m17179RK()) {
                C1720g.m3536RP().mo5230RC();
                C9638aw.m17190ZK();
                C18628c.m29066RA();
                MountReceiver.this.ebW.sendEmptyMessage(0);
                AppMethodBeat.m2505o(15846);
                return;
            }
            AppMethodBeat.m2505o(15846);
        }
    }

    /* renamed from: com.tencent.mm.booter.MountReceiver$3 */
    class C180973 implements Runnable {
        C180973() {
        }

        public final void run() {
            AppMethodBeat.m2504i(15847);
            C4990ab.m7411d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", MountReceiver.this.action, Boolean.valueOf(C9638aw.m17179RK()));
            if (C9638aw.m17179RK()) {
                C1720g.m3536RP().mo5230RC();
                C9638aw.m17190ZK();
                C18628c.m29066RA();
                AppMethodBeat.m2505o(15847);
                return;
            }
            AppMethodBeat.m2505o(15847);
        }
    }

    public MountReceiver() {
        AppMethodBeat.m2504i(15848);
        AppMethodBeat.m2505o(15848);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(15849);
        if (context == null || intent == null || C42252ah.isNullOrNil(intent.getAction())) {
            AppMethodBeat.m2505o(15849);
            return;
        }
        this.context = context;
        this.action = intent.getAction();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        C4990ab.m7417i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", this.action, Boolean.valueOf(C9638aw.m17179RK()), C6457e.eSl, absolutePath);
        boolean equals = this.action.equals("android.intent.action.MEDIA_MOUNTED");
        if (equals || this.action.equals("android.intent.action.MEDIA_EJECT") || this.action.equals("android.intent.action.MEDIA_SHARED")) {
            Object obj = !C6457e.eSl.equalsIgnoreCase("/dev/null") ? 1 : null;
            if (obj != null) {
                try {
                    StatFs statFs = new StatFs(C6457e.eSl);
                    C4990ab.m7417i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", C6457e.eSl, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MountReceiver", "CheckSD failed :%s", e.getMessage());
                    obj = null;
                }
            }
            Uri data = intent.getData();
            if (data != null) {
                String path = data.getPath();
                if (!C6457e.eSl.equalsIgnoreCase(path)) {
                    if (equals && obj == null) {
                        C7060h.pYm.mo8378a(340, C6457e.eSl.equalsIgnoreCase("/dev/null") ? 9 : 12, 1, false);
                        if (C42252ah.isNullOrNil(absolutePath) || !absolutePath.equalsIgnoreCase(path)) {
                            AppMethodBeat.m2505o(15849);
                            return;
                        } else if (new File(C5128ac.eSj + "SdcardInfo.cfg").exists()) {
                            C5144y c5144y = new C5144y(C5128ac.eSj + "SdcardInfo.cfg");
                            String str = (String) c5144y.get(1, "");
                            int intValue = ((Integer) c5144y.get(2, Integer.valueOf(0))).intValue();
                            int i = VERSION.SDK_INT;
                            String str2 = C6457e.eSl;
                            c5144y.set(1, absolutePath);
                            c5144y.set(2, Integer.valueOf(i));
                            C6457e.m10679kw(absolutePath);
                            C4990ab.m7421w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", Integer.valueOf(intValue), str, Integer.valueOf(i), absolutePath, str2, C6457e.eSl);
                        } else {
                            C4990ab.m7421w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", C6457e.eSl, absolutePath, Integer.valueOf(VERSION.SDK_INT));
                            C6457e.eSl = absolutePath;
                            C6457e.m10679kw(absolutePath);
                        }
                    } else {
                        AppMethodBeat.m2505o(15849);
                        return;
                    }
                }
            }
            C7060h.pYm.mo8378a(340, equals ? 13 : 14, 1, false);
            if (equals) {
                C9638aw.m17180RS().mo10302aa(new C180962());
                AppMethodBeat.m2505o(15849);
                return;
            }
            C23639t.m36492hO(context);
            C9638aw.m17180RS().mo10302aa(new C180973());
            AppMethodBeat.m2505o(15849);
            return;
        }
        AppMethodBeat.m2505o(15849);
    }
}
