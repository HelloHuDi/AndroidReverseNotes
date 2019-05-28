package com.tencent.p177mm.plugin.wear.model.p1322g;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42077vk;
import com.tencent.p177mm.plugin.wear.p1061ui.WearYoLockUI;
import com.tencent.p177mm.plugin.wear.p1061ui.WearYoNoLockUI;
import com.tencent.p177mm.protocal.protobuf.cva;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.wear.model.g.a */
public final class C35562a {
    private PowerManager tXN = ((PowerManager) C4996ah.getContext().getSystemService("power"));
    private KeyguardManager tXO = ((KeyguardManager) C4996ah.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, C35563a> tYO = new LinkedHashMap();

    /* renamed from: com.tencent.mm.plugin.wear.model.g.a$a */
    class C35563a {
        String content;
        String svN;

        public C35563a(String str, String str2) {
            this.svN = str;
            this.content = str2;
        }
    }

    public C35562a() {
        AppMethodBeat.m2504i(26453);
        AppMethodBeat.m2505o(26453);
    }

    public static C42077vk ady(String str) {
        AppMethodBeat.m2504i(26454);
        C42077vk c42077vk = new C42077vk();
        c42077vk.cSs.cuy = 1;
        c42077vk.cSs.username = str;
        C4879a.xxA.mo10055m(c42077vk);
        AppMethodBeat.m2505o(26454);
        return c42077vk;
    }

    public final void cUD() {
        AppMethodBeat.m2504i(26455);
        if (C35562a.ady(null).cSt.cSu != 0) {
            C4990ab.m7416i("MicroMsg.wear.WearYoLogic", "current show yo");
            AppMethodBeat.m2505o(26455);
            return;
        }
        C35563a c35563a;
        synchronized (this.tYO) {
            try {
                Iterator it = this.tYO.entrySet().iterator();
                if (it.hasNext()) {
                    c35563a = (C35563a) ((Entry) it.next()).getValue();
                } else {
                    c35563a = null;
                }
                if (c35563a != null) {
                    this.tYO.remove(c35563a.svN);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(26455);
                }
            }
        }
        if (c35563a != null) {
            int i;
            String str = c35563a.content;
            cva cva = new cva();
            Map z = C5049br.m7595z(str, "msg");
            if (z == null) {
                cva.jCt = 0;
            } else {
                cva.jCt = C5046bo.getInt((String) z.get(".msg.yo.$type"), 0);
                cva.jBv = C5046bo.getInt((String) z.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", c35563a.svN);
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
                intent.setClass(C4996ah.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(C4996ah.getContext(), WearYoNoLockUI.class);
            }
            C4996ah.getContext().startActivity(intent);
        }
        AppMethodBeat.m2505o(26455);
    }
}
