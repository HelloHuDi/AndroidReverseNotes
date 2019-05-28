package com.tencent.mm.plugin.appbrand.keepalive;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public enum b {
    ;
    
    public String ifv;
    private boolean ifw;

    static final class b implements com.tencent.mm.ipcinvoker.a<IPCString, IPCVoid> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(131687);
            IPCString iPCString = (IPCString) obj;
            a aVar = a.ifp;
            String iPCString2 = iPCString.toString();
            if (aVar.ifq.containsKey(iPCString2)) {
                try {
                    ah.getContext().unbindService(((a) aVar.ifq.get(iPCString2)).ifr);
                    AppMethodBeat.o(131687);
                    return;
                } catch (Exception e) {
                    ab.e("MicroMsg.KeepAliveServiceConnector", "unbindKeepAliveService exp:%s", e);
                    AppMethodBeat.o(131687);
                    return;
                }
            }
            ab.w("MicroMsg.AppBrandKeepAliveMMSavior", "unbindKeepAliveService not had connector of %s", iPCString2);
            AppMethodBeat.o(131687);
        }
    }

    static final class a implements com.tencent.mm.ipcinvoker.a<IPCString, IPCVoid> {
        private a() {
        }

        /* JADX WARNING: Missing block: B:6:0x003b, code skipped:
            if (r0.ifs != null) goto L_0x003d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void a(Object obj, c cVar) {
            a aVar;
            AppMethodBeat.i(131686);
            IPCString iPCString = (IPCString) obj;
            a aVar2 = a.ifp;
            String iPCString2 = iPCString.toString();
            if (aVar2.ifq.containsKey(iPCString2)) {
                aVar = (a) aVar2.ifq.get(iPCString2);
            } else {
                aVar = new a();
                aVar2.ifq.put(iPCString2, aVar);
            }
            ab.i("MicroMsg.KeepAliveServiceConnector", "bindKeepAliveService appBrandUIClassName:%s", iPCString2);
            if (aVar.ifs == null) {
                aVar.ifs = h.DP(iPCString2);
            }
            Context context = ah.getContext();
            Intent intent = new Intent();
            intent.setClass(context, aVar.ifs);
            boolean bindService = context.bindService(intent, aVar.ifr, 1);
            ab.i("MicroMsg.KeepAliveServiceConnector", "bindKeepAliveService service:%s bindRet:%b", aVar.ifs.getName(), Boolean.valueOf(bindService));
            AppMethodBeat.o(131686);
        }
    }

    private b(String str) {
        this.ifv = null;
        this.ifw = false;
    }

    static {
        AppMethodBeat.o(131692);
    }
}
