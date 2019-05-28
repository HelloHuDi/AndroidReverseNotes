package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private static final a udC = new a();
    public Map<Integer, d> udA = new HashMap();
    private c udB;

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$1 */
    public class AnonymousClass1 implements com.tencent.mm.ui.base.n.a {
        final /* synthetic */ List mhY;

        public AnonymousClass1(List list) {
            this.mhY = list;
        }

        public final void a(ImageView imageView, MenuItem menuItem) {
            AppMethodBeat.i(91473);
            com.tencent.mm.at.a.a.ahv().a(((y) this.mhY.get(menuItem.getItemId())).iconUrl, imageView, a.this.udB);
            AppMethodBeat.o(91473);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$4 */
    public class AnonymousClass4 implements com.tencent.mm.ui.widget.a.d.a {
        final /* synthetic */ x udE;
        final /* synthetic */ int val$id;

        public AnonymousClass4(x xVar, int i) {
            this.udE = xVar;
            this.val$id = i;
        }

        public final void onDismiss() {
            AppMethodBeat.i(91476);
            ab.v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(-1));
            if (this.udE != null) {
                this.udE.go(-1, this.val$id);
            }
            a.this.udA.remove(Integer.valueOf(this.val$id));
            AppMethodBeat.o(91476);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$2 */
    public class AnonymousClass2 implements n.c {
        final /* synthetic */ d gCw;
        final /* synthetic */ List mhY;

        public AnonymousClass2(List list, d dVar) {
            this.mhY = list;
            this.gCw = dVar;
        }

        public final void a(l lVar) {
            AppMethodBeat.i(91474);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mhY.size()) {
                    y yVar = (y) this.mhY.get(i2);
                    lVar.a(i2, yVar.title, yVar.desc);
                    if (yVar.gBF) {
                        this.gCw.zQA = i2;
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(91474);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.widget.view.a$3 */
    public class AnonymousClass3 implements n.d {
        final /* synthetic */ x udE;
        final /* synthetic */ int val$id;

        public AnonymousClass3(x xVar, int i) {
            this.udE = xVar;
            this.val$id = i;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(91475);
            ab.v("FTSSearchActionSheetMgr", "selected pos %d", Integer.valueOf(i));
            if (this.udE != null) {
                this.udE.go(i, this.val$id);
            }
            a.this.udA.remove(Integer.valueOf(this.val$id));
            AppMethodBeat.o(91475);
        }
    }

    static {
        AppMethodBeat.i(91479);
        AppMethodBeat.o(91479);
    }

    public static a cVT() {
        return udC;
    }

    private a() {
        AppMethodBeat.i(91477);
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePH = true;
        aVar.ePG = true;
        this.udB = aVar.ahG();
        AppMethodBeat.o(91477);
    }

    public final void Ip(int i) {
        AppMethodBeat.i(91478);
        d dVar = (d) this.udA.remove(Integer.valueOf(i));
        if (dVar != null) {
            dVar.cpE();
        }
        AppMethodBeat.o(91478);
    }
}
