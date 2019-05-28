package com.tencent.p177mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.p265a.C9757a.C9758a;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelstat.WatchDogPushReceiver */
public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = "";

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(78802);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            AppMethodBeat.m2505o(78802);
            return;
        }
        int intExtra = intent.getIntExtra("type", 0);
        C4990ab.m7410d("MicroMsg.WatchDogPushReceiver", "onReceive type:".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            C9758a c9758a = new C9758a();
            c9758a.rtType = (long) intent.getIntExtra("rtType", 0);
            c9758a.beginTime = intent.getLongExtra("beginTime", 0);
            c9758a.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (booleanExtra) {
                c9758a.geC = intent.getLongExtra("dataLen", 0);
            } else {
                c9758a.geD = intent.getLongExtra("dataLen", 0);
            }
            c9758a.bZI = intent.getLongExtra("cost", 0);
            c9758a.geE = intent.getLongExtra("doSceneCount", 0);
            C4990ab.m7410d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + c9758a.rtType + " isSend:" + booleanExtra + " tx:" + c9758a.geC + " rx:" + c9758a.geD + " begin:" + c9758a.beginTime + " end:" + c9758a.endTime);
            if (c9758a.geE == 0 || c9758a.rtType == 0 || c9758a.beginTime == 0 || c9758a.endTime == 0 || c9758a.endTime - c9758a.beginTime <= 0) {
                C4990ab.m7420w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + c9758a.geE + " rtType:" + c9758a.rtType + " begin:" + c9758a.beginTime + " end:" + c9758a.endTime);
                AppMethodBeat.m2505o(78802);
                return;
            }
            AppMethodBeat.m2505o(78802);
            return;
        }
        if (!(intExtra == 2 || intExtra == 3 || intExtra == 4)) {
            if (intExtra == 5 && C4872b.dnO()) {
                if (intent.getIntExtra("jni", 1) == 1) {
                    Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                    AppMethodBeat.m2505o(78802);
                    return;
                }
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.m2505o(78802);
                return;
            } else if (intExtra == 6) {
                C4990ab.dot();
            }
        }
        AppMethodBeat.m2505o(78802);
    }

    private static String getClassName() {
        AppMethodBeat.m2504i(78803);
        if (C5046bo.isNullOrNil(className)) {
            className = C4996ah.getPackageName() + ".modelstat.WatchDogPushReceiver";
        }
        String str = className;
        AppMethodBeat.m2505o(78803);
        return str;
    }

    /* renamed from: a */
    public static void m29199a(C42220h c42220h) {
        AppMethodBeat.m2504i(78804);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(C4996ah.getPackageName(), WatchDogPushReceiver.getClassName()));
        intent.putExtra("type", 1);
        intent.putExtra("rtType", c42220h.rtType);
        intent.putExtra("beginTime", c42220h.beginTime);
        intent.putExtra("endTime", c42220h.endTime);
        intent.putExtra("rtType", c42220h.rtType);
        intent.putExtra("dataLen", c42220h.fSW);
        intent.putExtra("isSend", c42220h.cRY);
        intent.putExtra("cost", c42220h.bZI);
        intent.putExtra("doSceneCount", c42220h.fSX);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(78804);
    }

    public static void akt() {
        AppMethodBeat.m2504i(78805);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(C4996ah.getPackageName(), WatchDogPushReceiver.getClassName()));
        intent.putExtra("type", 3);
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(78805);
    }

    /* renamed from: mj */
    public static void m29200mj(int i) {
        AppMethodBeat.m2504i(78806);
        if (C4872b.dnO()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(C4996ah.getPackageName(), WatchDogPushReceiver.getClassName()));
            intent.putExtra("type", 5);
            intent.putExtra("jni", i);
            C4996ah.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(78806);
            return;
        }
        AppMethodBeat.m2505o(78806);
    }

    public static void aku() {
        AppMethodBeat.m2504i(78807);
        if (C4872b.dnO()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(C4996ah.getPackageName(), WatchDogPushReceiver.getClassName()));
            intent.putExtra("type", 7);
            C4996ah.getContext().sendBroadcast(intent);
            AppMethodBeat.m2505o(78807);
            return;
        }
        AppMethodBeat.m2505o(78807);
    }
}
