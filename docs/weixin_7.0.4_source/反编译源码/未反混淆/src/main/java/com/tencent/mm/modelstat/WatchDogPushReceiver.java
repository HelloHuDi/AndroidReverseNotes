package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.a.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public class WatchDogPushReceiver extends BroadcastReceiver {
    private static String className = "";

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(78802);
        if (intent == null) {
            ab.e("MicroMsg.WatchDogPushReceiver", "onReceive intent == null");
            AppMethodBeat.o(78802);
            return;
        }
        int intExtra = intent.getIntExtra("type", 0);
        ab.d("MicroMsg.WatchDogPushReceiver", "onReceive type:".concat(String.valueOf(intExtra)));
        if (intExtra == 1) {
            a aVar = new a();
            aVar.rtType = (long) intent.getIntExtra("rtType", 0);
            aVar.beginTime = intent.getLongExtra("beginTime", 0);
            aVar.endTime = intent.getLongExtra("endTime", 0);
            boolean booleanExtra = intent.getBooleanExtra("isSend", false);
            if (booleanExtra) {
                aVar.geC = intent.getLongExtra("dataLen", 0);
            } else {
                aVar.geD = intent.getLongExtra("dataLen", 0);
            }
            aVar.bZI = intent.getLongExtra("cost", 0);
            aVar.geE = intent.getLongExtra("doSceneCount", 0);
            ab.d("MicroMsg.WatchDogPushReceiver", "onRecv: rtType:" + aVar.rtType + " isSend:" + booleanExtra + " tx:" + aVar.geC + " rx:" + aVar.geD + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
            if (aVar.geE == 0 || aVar.rtType == 0 || aVar.beginTime == 0 || aVar.endTime == 0 || aVar.endTime - aVar.beginTime <= 0) {
                ab.w("MicroMsg.WatchDogPushReceiver", "onRecv: count:" + aVar.geE + " rtType:" + aVar.rtType + " begin:" + aVar.beginTime + " end:" + aVar.endTime);
                AppMethodBeat.o(78802);
                return;
            }
            AppMethodBeat.o(78802);
            return;
        }
        if (!(intExtra == 2 || intExtra == 3 || intExtra == 4)) {
            if (intExtra == 5 && b.dnO()) {
                if (intent.getIntExtra("jni", 1) == 1) {
                    Assert.assertTrue("test errlog push " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                    AppMethodBeat.o(78802);
                    return;
                }
                MMProtocalJni.setClientPackVersion(-1);
                AppMethodBeat.o(78802);
                return;
            } else if (intExtra == 6) {
                ab.dot();
            }
        }
        AppMethodBeat.o(78802);
    }

    private static String getClassName() {
        AppMethodBeat.i(78803);
        if (bo.isNullOrNil(className)) {
            className = ah.getPackageName() + ".modelstat.WatchDogPushReceiver";
        }
        String str = className;
        AppMethodBeat.o(78803);
        return str;
    }

    public static void a(h hVar) {
        AppMethodBeat.i(78804);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
        intent.putExtra("type", 1);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("beginTime", hVar.beginTime);
        intent.putExtra("endTime", hVar.endTime);
        intent.putExtra("rtType", hVar.rtType);
        intent.putExtra("dataLen", hVar.fSW);
        intent.putExtra("isSend", hVar.cRY);
        intent.putExtra("cost", hVar.bZI);
        intent.putExtra("doSceneCount", hVar.fSX);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(78804);
    }

    public static void akt() {
        AppMethodBeat.i(78805);
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.WatchDogPushReceiver");
        intent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
        intent.putExtra("type", 3);
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(78805);
    }

    public static void mj(int i) {
        AppMethodBeat.i(78806);
        if (b.dnO()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
            intent.putExtra("type", 5);
            intent.putExtra("jni", i);
            ah.getContext().sendBroadcast(intent);
            AppMethodBeat.o(78806);
            return;
        }
        AppMethodBeat.o(78806);
    }

    public static void aku() {
        AppMethodBeat.i(78807);
        if (b.dnO()) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.WatchDogPushReceiver");
            intent.setComponent(new ComponentName(ah.getPackageName(), getClassName()));
            intent.putExtra("type", 7);
            ah.getContext().sendBroadcast(intent);
            AppMethodBeat.o(78807);
            return;
        }
        AppMethodBeat.o(78807);
    }
}
