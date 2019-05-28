package com.tencent.p177mm.plugin.appbrand.keepalive;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.plugin.appbrand.keepalive.C33420a.C33421a;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.keepalive.b */
public enum C38410b {
    ;
    
    public String ifv;
    private boolean ifw;

    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.b$b */
    static final class C19535b implements C37866a<IPCString, IPCVoid> {
        private C19535b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(131687);
            IPCString iPCString = (IPCString) obj;
            C33420a c33420a = C33420a.ifp;
            String iPCString2 = iPCString.toString();
            if (c33420a.ifq.containsKey(iPCString2)) {
                try {
                    C4996ah.getContext().unbindService(((C33421a) c33420a.ifq.get(iPCString2)).ifr);
                    AppMethodBeat.m2505o(131687);
                    return;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.KeepAliveServiceConnector", "unbindKeepAliveService exp:%s", e);
                    AppMethodBeat.m2505o(131687);
                    return;
                }
            }
            C4990ab.m7421w("MicroMsg.AppBrandKeepAliveMMSavior", "unbindKeepAliveService not had connector of %s", iPCString2);
            AppMethodBeat.m2505o(131687);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.b$a */
    static final class C27144a implements C37866a<IPCString, IPCVoid> {
        private C27144a() {
        }

        /* JADX WARNING: Missing block: B:6:0x003b, code skipped:
            if (r0.ifs != null) goto L_0x003d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            C33421a c33421a;
            AppMethodBeat.m2504i(131686);
            IPCString iPCString = (IPCString) obj;
            C33420a c33420a = C33420a.ifp;
            String iPCString2 = iPCString.toString();
            if (c33420a.ifq.containsKey(iPCString2)) {
                c33421a = (C33421a) c33420a.ifq.get(iPCString2);
            } else {
                c33421a = new C33421a();
                c33420a.ifq.put(iPCString2, c33421a);
            }
            C4990ab.m7417i("MicroMsg.KeepAliveServiceConnector", "bindKeepAliveService appBrandUIClassName:%s", iPCString2);
            if (c33421a.ifs == null) {
                c33421a.ifs = C45694h.m84413DP(iPCString2);
            }
            Context context = C4996ah.getContext();
            Intent intent = new Intent();
            intent.setClass(context, c33421a.ifs);
            boolean bindService = context.bindService(intent, c33421a.ifr, 1);
            C4990ab.m7417i("MicroMsg.KeepAliveServiceConnector", "bindKeepAliveService service:%s bindRet:%b", c33421a.ifs.getName(), Boolean.valueOf(bindService));
            AppMethodBeat.m2505o(131686);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.b$1 */
    public class C384121 implements C10137a {
        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            AppMethodBeat.m2504i(131684);
            switch (c45524b) {
                case BACKGROUND:
                    C38410b.m64998a(C38410b.this, str);
                    AppMethodBeat.m2505o(131684);
                    return;
                case SUSPEND:
                case FOREGROUND:
                case DESTROYED:
                    C38410b.m64997a(C38410b.this);
                    break;
            }
            AppMethodBeat.m2505o(131684);
        }
    }

    private C38410b(String str) {
        this.ifv = null;
        this.ifw = false;
    }

    static {
        AppMethodBeat.m2505o(131692);
    }
}
