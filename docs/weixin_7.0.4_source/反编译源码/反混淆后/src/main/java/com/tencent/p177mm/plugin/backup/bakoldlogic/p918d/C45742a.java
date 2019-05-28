package com.tencent.p177mm.plugin.backup.bakoldlogic.p918d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.a */
public final class C45742a {
    C7306ak handler = new C7306ak(Looper.getMainLooper());
    public LinkedList<C45741a> jyk = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.a$2 */
    class C199692 implements Runnable {
        C199692() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17999);
            Iterator it = C45742a.this.jyk.iterator();
            while (it.hasNext()) {
                C45741a c45741a = (C45741a) it.next();
                if (c45741a.type == 2 && c45741a.obj != null && (c45741a.obj instanceof String)) {
                    String str = (String) c45741a.obj;
                    C4990ab.m7410d("MicroMsg.BakOldRecoverDelayData", "getContact:".concat(String.valueOf(str)));
                    C26417a.flu.mo20967ai(str, "");
                } else if (c45741a.type == 1 && c45741a.obj != null && (c45741a.obj instanceof String)) {
                    C14877am.bYI().aiH((String) c45741a.obj);
                }
            }
            C45742a.this.jyk.clear();
            AppMethodBeat.m2505o(17999);
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.d.a$a */
    public class C45741a {
        public Object obj;
        public int type;

        public C45741a(int i, Object obj) {
            this.type = i;
            this.obj = obj;
        }
    }

    public C45742a() {
        AppMethodBeat.m2504i(18000);
        AppMethodBeat.m2505o(18000);
    }

    /* renamed from: g */
    public final boolean mo73539g(final int i, final Object obj) {
        AppMethodBeat.m2504i(18001);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17998);
                C45742a.this.jyk.add(new C45741a(i, obj));
                AppMethodBeat.m2505o(17998);
            }
        });
        AppMethodBeat.m2505o(18001);
        return true;
    }
}
