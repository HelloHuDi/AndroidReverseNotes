package com.tencent.p177mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.base.C40671n.C36072a;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.plugin.websearch.api.C14427x;
import com.tencent.p177mm.plugin.websearch.api.C29743y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.websearch.widget.view.a */
public final class C43855a {
    private static final C43855a udC = new C43855a();
    public Map<Integer, C36356d> udA = new HashMap();
    private C25814c udB;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$1 */
    public class C144421 implements C36072a {
        final /* synthetic */ List mhY;

        public C144421(List list) {
            this.mhY = list;
        }

        /* renamed from: a */
        public final void mo5750a(ImageView imageView, MenuItem menuItem) {
            AppMethodBeat.m2504i(91473);
            C25815a.ahv().mo43766a(((C29743y) this.mhY.get(menuItem.getItemId())).iconUrl, imageView, C43855a.this.udB);
            AppMethodBeat.m2505o(91473);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$4 */
    public class C169234 implements C15994a {
        final /* synthetic */ C14427x udE;
        final /* synthetic */ int val$id;

        public C169234(C14427x c14427x, int i) {
            this.udE = c14427x;
            this.val$id = i;
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(91476);
            C4990ab.m7419v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(-1));
            if (this.udE != null) {
                this.udE.mo9690go(-1, this.val$id);
            }
            C43855a.this.udA.remove(Integer.valueOf(this.val$id));
            AppMethodBeat.m2505o(91476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$2 */
    public class C297612 implements C36073c {
        final /* synthetic */ C36356d gCw;
        final /* synthetic */ List mhY;

        public C297612(List list, C36356d c36356d) {
            this.mhY = list;
            this.gCw = c36356d;
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(91474);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mhY.size()) {
                    C29743y c29743y = (C29743y) this.mhY.get(i2);
                    c44273l.mo70052a(i2, c29743y.title, c29743y.desc);
                    if (c29743y.gBF) {
                        this.gCw.zQA = i2;
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(91474);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$3 */
    public class C297623 implements C5279d {
        final /* synthetic */ C14427x udE;
        final /* synthetic */ int val$id;

        public C297623(C14427x c14427x, int i) {
            this.udE = c14427x;
            this.val$id = i;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(91475);
            C4990ab.m7419v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(i));
            if (this.udE != null) {
                this.udE.mo9690go(i, this.val$id);
            }
            C43855a.this.udA.remove(Integer.valueOf(this.val$id));
            AppMethodBeat.m2505o(91475);
        }
    }

    static {
        AppMethodBeat.m2504i(91479);
        AppMethodBeat.m2505o(91479);
    }

    public static C43855a cVT() {
        return udC;
    }

    private C43855a() {
        AppMethodBeat.m2504i(91477);
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePG = true;
        this.udB = c17927a.ahG();
        AppMethodBeat.m2505o(91477);
    }

    /* renamed from: Ip */
    public final void mo69534Ip(int i) {
        AppMethodBeat.m2504i(91478);
        C36356d c36356d = (C36356d) this.udA.remove(Integer.valueOf(i));
        if (c36356d != null) {
            c36356d.cpE();
        }
        AppMethodBeat.m2505o(91478);
    }
}
