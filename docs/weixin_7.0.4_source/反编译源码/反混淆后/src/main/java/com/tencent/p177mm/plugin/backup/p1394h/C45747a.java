package com.tencent.p177mm.plugin.backup.p1394h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.h.a */
public final class C45747a {
    public C7306ak handler = new C7306ak(Looper.getMainLooper());
    LinkedList<C27491a> jyk = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.backup.h.a$a */
    class C27491a {
        public Object obj;
        public int type;

        public C27491a(int i, Object obj) {
            this.type = i;
            this.obj = obj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.h.a$2 */
    public class C386562 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(17684);
            Iterator it = C45747a.this.jyk.iterator();
            while (it.hasNext()) {
                C27491a c27491a = (C27491a) it.next();
                if (c27491a.type == 2 && c27491a.obj != null && (c27491a.obj instanceof String)) {
                    String str = (String) c27491a.obj;
                    C4990ab.m7410d("MicroMsg.BackupRecoverDelayData", "getContact:".concat(String.valueOf(str)));
                    C26417a.flu.mo20967ai(str, "");
                } else if (c27491a.type == 1 && c27491a.obj != null && (c27491a.obj instanceof String)) {
                    C14877am.bYI().aiH((String) c27491a.obj);
                }
            }
            C45747a.this.jyk.clear();
            AppMethodBeat.m2505o(17684);
        }
    }

    public C45747a() {
        AppMethodBeat.m2504i(17685);
        AppMethodBeat.m2505o(17685);
    }

    /* renamed from: g */
    public final boolean mo73547g(final int i, final Object obj) {
        AppMethodBeat.m2504i(17686);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17683);
                C45747a.this.jyk.add(new C27491a(i, obj));
                AppMethodBeat.m2505o(17683);
            }
        });
        AppMethodBeat.m2505o(17686);
        return true;
    }
}
