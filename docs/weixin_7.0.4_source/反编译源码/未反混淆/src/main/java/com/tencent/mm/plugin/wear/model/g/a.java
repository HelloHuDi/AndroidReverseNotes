package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private PowerManager tXN = ((PowerManager) ah.getContext().getSystemService("power"));
    private KeyguardManager tXO = ((KeyguardManager) ah.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, a> tYO = new LinkedHashMap();

    class a {
        String content;
        String svN;

        public a(String str, String str2) {
            this.svN = str;
            this.content = str2;
        }
    }

    public a() {
        AppMethodBeat.i(26453);
        AppMethodBeat.o(26453);
    }

    public static vk ady(String str) {
        AppMethodBeat.i(26454);
        vk vkVar = new vk();
        vkVar.cSs.cuy = 1;
        vkVar.cSs.username = str;
        com.tencent.mm.sdk.b.a.xxA.m(vkVar);
        AppMethodBeat.o(26454);
        return vkVar;
    }

    public final void cUD() {
        AppMethodBeat.i(26455);
        if (ady(null).cSt.cSu != 0) {
            ab.i("MicroMsg.wear.WearYoLogic", "current show yo");
            AppMethodBeat.o(26455);
            return;
        }
        a aVar;
        synchronized (this.tYO) {
            try {
                Iterator it = this.tYO.entrySet().iterator();
                if (it.hasNext()) {
                    aVar = (a) ((Entry) it.next()).getValue();
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    this.tYO.remove(aVar.svN);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(26455);
                }
            }
        }
        if (aVar != null) {
            int i;
            String str = aVar.content;
            cva cva = new cva();
            Map z = br.z(str, "msg");
            if (z == null) {
                cva.jCt = 0;
            } else {
                cva.jCt = bo.getInt((String) z.get(".msg.yo.$type"), 0);
                cva.jBv = bo.getInt((String) z.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", aVar.svN);
            try {
                intent.putExtra("key_data", cva.toByteArray());
            } catch (IOException e) {
            }
            intent.addFlags(268435456);
            if (this.tXO.inKeyguardRestrictedInputMode() || !this.tXN.isScreenOn()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                intent.setClass(ah.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(ah.getContext(), WearYoNoLockUI.class);
            }
            ah.getContext().startActivity(intent);
        }
        AppMethodBeat.o(26455);
    }
}
