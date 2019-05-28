package com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c;

import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42886a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C16728k;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C2797i;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C42884n;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g.C11384b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g.C33816a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a.C11372a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a.C11373b;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.C42890a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e */
public final class C45809e extends C33815b {
    protected List<C11376a> iJL = new ArrayList();
    public LinearLayoutManager jop;
    C41260d kuY;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e$3 */
    public class C28003 extends C25373h {
        int kvg = C4996ah.getResources().getColor(C25738R.color.f11995ov);
        ColorDrawable kvh = new ColorDrawable(this.kvg);
        int mSize = ((int) C4996ah.getResources().getDimension(C25738R.dimen.f9723do));

        public C28003() {
            AppMethodBeat.m2504i(54348);
            AppMethodBeat.m2505o(54348);
        }

        /* renamed from: a */
        public final void mo6920a(Canvas canvas, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(54349);
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt.getTag() != null) {
                    C11376a ts = C45809e.this.kuY.mo54375ts(((Integer) childAt.getTag()).intValue() + 1);
                    if (ts == null || ts.getType() != 0) {
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        int bottom = layoutParams.bottomMargin + childAt.getBottom();
                        this.kvh.setBounds(paddingLeft, bottom, width, this.mSize + bottom);
                        this.kvh.draw(canvas);
                    }
                }
            }
            AppMethodBeat.m2505o(54349);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e$4 */
    class C28014 implements C11384b {
        C28014() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e$1 */
    class C367501 implements C33816a {

        /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e$1$2 */
        class C367522 implements Runnable {
            C367522() {
            }

            public final void run() {
                AppMethodBeat.m2504i(54344);
                C45809e.this.kuY.aop.notifyChanged();
                AppMethodBeat.m2505o(54344);
            }
        }

        C367501() {
        }

        /* renamed from: a */
        public final void mo23128a(boolean z, final C11376a c11376a, final C41531v c41531v) {
            AppMethodBeat.m2504i(54345);
            if (c11376a == null) {
                C4990ab.m7412e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
                AppMethodBeat.m2505o(54345);
                return;
            }
            C4990ab.m7417i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", Boolean.valueOf(z));
            if (z) {
                c11376a.bfq();
                C45809e.m84729a(C45809e.this).mo68414gX(c11376a.kua.field_msgId);
                C11373b.m19132a(c11376a, new C11372a() {

                    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e$1$1$1 */
                    class C202101 implements Runnable {
                        C202101() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(54338);
                            C45809e.this.kuY.aop.notifyChanged();
                            AppMethodBeat.m2505o(54338);
                        }
                    }

                    /* renamed from: a */
                    public final void mo23103a(MsgFile msgFile) {
                        AppMethodBeat.m2504i(54339);
                        C4990ab.m7417i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", c11376a, msgFile);
                        C45809e.m84729a(C45809e.this).mo68415gY(c11376a.kua.field_msgId);
                        C45809e.m84729a(C45809e.this).mo68408a(c11376a.kua.field_msgId, msgFile);
                        if (C45809e.m84729a(C45809e.this).bfD()) {
                            C5004al.m7441d(new C202101());
                        }
                        C45809e.this.kuT.bfG();
                        c11376a.bfr();
                        C11376a c11376a = (C11376a) ((C42884n) c41531v).kuD.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54339);
                    }

                    public final void bfe() {
                        AppMethodBeat.m2504i(54340);
                        C4990ab.m7413e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", c11376a);
                        C45809e.m84729a(C45809e.this).mo68415gY(c11376a.kua.field_msgId);
                        c11376a.bft();
                        C11376a c11376a = (C11376a) ((C42884n) c41531v).kuD.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54340);
                    }

                    public final void bff() {
                        AppMethodBeat.m2504i(54341);
                        C4990ab.m7417i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", c11376a);
                        C45809e.m84729a(C45809e.this).mo68415gY(c11376a.kua.field_msgId);
                        c11376a.bfu();
                        C11376a c11376a = (C11376a) ((C42884n) c41531v).kuD.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54341);
                    }

                    public final void bfg() {
                        AppMethodBeat.m2504i(54342);
                        C4990ab.m7413e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", c11376a);
                        C45809e.m84729a(C45809e.this).mo68415gY(c11376a.kua.field_msgId);
                        c11376a.bfs();
                        C11376a c11376a = (C11376a) ((C42884n) c41531v).kuD.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54342);
                    }

                    /* renamed from: dK */
                    public final void mo23107dK(int i, int i2) {
                        AppMethodBeat.m2504i(54343);
                        C4990ab.m7413e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", c11376a, Integer.valueOf(i), Integer.valueOf(i2));
                        c11376a.mo23118dM(i, i2);
                        C11376a c11376a = (C11376a) ((C42884n) c41531v).kuD.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54343);
                    }
                }, C45809e.this.bfA());
            } else {
                c11376a.bfu();
                C45809e.m84729a(C45809e.this).mo68415gY(c11376a.kua.field_msgId);
                C45809e.m84729a(C45809e.this).mo68412gV(c11376a.kua.field_msgId);
                if (C45809e.m84729a(C45809e.this).bfD()) {
                    C5004al.m7441d(new C367522());
                }
                C45809e.this.kuT.bfG();
            }
            c11376a.mo23108T(c41531v);
            AppMethodBeat.m2505o(54345);
        }
    }

    public C45809e(C42890a c42890a) {
        super(c42890a);
        AppMethodBeat.m2504i(54350);
        AppMethodBeat.m2505o(54350);
    }

    public final C41523a bfB() {
        AppMethodBeat.m2504i(54351);
        this.kuY = new C41260d(this.kuT, this.iJL);
        C38788a.kuW = new C28014();
        this.kuY.kuV = new C367501();
        C41260d c41260d = this.kuY;
        AppMethodBeat.m2505o(54351);
        return c41260d;
    }

    /* renamed from: b */
    public final void mo6921b(final boolean z, String str, final String str2) {
        AppMethodBeat.m2504i(54352);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", Boolean.valueOf(z));
        this.kuT.mo61660fO(z);
        if (z) {
            this.iJL.clear();
        }
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.e$2$1 */
            class C27991 implements Runnable {
                C27991() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(54346);
                    if (C45809e.this.kuT != null) {
                        C45809e.this.kuT.mo61664p(z, C45809e.this.iJL.size());
                    }
                    AppMethodBeat.m2505o(54346);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(54347);
                LinkedList linkedList = new LinkedList();
                Cursor cu = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15322cu(C45809e.this.edV, -1);
                if (cu == null) {
                    C4990ab.m7412e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
                    AppMethodBeat.m2505o(54347);
                    return;
                }
                List<String> HJ = C42887b.m76150HJ(str2);
                long j = 0;
                while (cu.moveToNext()) {
                    try {
                        long b;
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.mo8995d(cu);
                        String str = c7620bi.field_content;
                        if (str != null) {
                            C8910b me = C8910b.m16064me(str);
                            if (me != null && me.type == 6) {
                                int i;
                                C16728k c16728k = new C16728k(C45809e.this.kuY, c7620bi, C45809e.this.edV);
                                if (HJ.size() == 0) {
                                    i = 1;
                                } else {
                                    for (String str2 : HJ) {
                                        if (c16728k.getFileName().endsWith(str2)) {
                                            i = 1;
                                            break;
                                        }
                                    }
                                    i = 0;
                                }
                                if (i != 0) {
                                    b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                                    if (j != b) {
                                        linkedList.add(new C2797i(C45809e.this.kuY, c7620bi.field_createTime));
                                    }
                                    linkedList.add(c16728k);
                                    j = b;
                                }
                            }
                        }
                        b = j;
                        j = b;
                    } catch (Throwable th) {
                        cu.close();
                        AppMethodBeat.m2505o(54347);
                    }
                }
                cu.close();
                C45809e.this.iJL.addAll(linkedList);
                linkedList.clear();
                C4990ab.m7417i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", Integer.valueOf(C45809e.this.iJL.size()));
                C5004al.m7441d(new C27991());
                AppMethodBeat.m2505o(54347);
            }
        });
        AppMethodBeat.m2505o(54352);
    }

    /* renamed from: a */
    static /* synthetic */ C42886a m84729a(C45809e c45809e) {
        AppMethodBeat.m2504i(54353);
        C42886a bfn = c45809e.kuT.bfn();
        AppMethodBeat.m2505o(54353);
        return bfn;
    }
}
