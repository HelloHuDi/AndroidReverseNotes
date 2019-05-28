package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class g {
    private static int tYj = 0;
    private HashMap<String, f> tYk = new HashMap();

    public g() {
        AppMethodBeat.i(26332);
        AppMethodBeat.o(26332);
    }

    public final synchronized f adr(String str) {
        f fVar;
        AppMethodBeat.i(26333);
        if (this.tYk.containsKey(str)) {
            fVar = (f) ((f) this.tYk.get(str)).clone();
            AppMethodBeat.o(26333);
        } else {
            tYj++;
            fVar = new f();
            fVar.talker = str;
            fVar.id = tYj;
            fVar.tYd = a.INIT;
            this.tYk.put(str, fVar);
            fVar = (f) fVar.clone();
            AppMethodBeat.o(26333);
        }
        return fVar;
    }

    public final synchronized void ads(String str) {
        AppMethodBeat.i(26334);
        ab.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", str);
        if (this.tYk.containsKey(str)) {
            ((f) this.tYk.get(str)).tYd = a.INIT;
            ((f) this.tYk.get(str)).tYc = 0;
        }
        AppMethodBeat.o(26334);
    }

    public final synchronized void a(f fVar) {
        AppMethodBeat.i(26335);
        ab.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", fVar);
        this.tYk.put(fVar.talker, fVar);
        AppMethodBeat.o(26335);
    }

    public final synchronized void adt(String str) {
        AppMethodBeat.i(26336);
        if (this.tYk.containsKey(str)) {
            f fVar = (f) this.tYk.get(str);
            fVar.tYd = a.REPLY;
            fVar.tYc = 0;
            ab.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", fVar);
        }
        AppMethodBeat.o(26336);
    }

    public final synchronized void dv(String str, int i) {
        AppMethodBeat.i(26337);
        if (this.tYk.containsKey(str)) {
            f fVar = (f) this.tYk.get(str);
            fVar.tYd = a.IGNORE;
            fVar.tYc = i;
            ab.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", fVar);
        }
        AppMethodBeat.o(26337);
    }

    public final synchronized void adu(String str) {
        AppMethodBeat.i(26338);
        if (this.tYk.containsKey(str)) {
            ((f) this.tYk.get(str)).tYd = a.SHOWING;
            ab.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", r0);
        }
        AppMethodBeat.o(26338);
    }
}
