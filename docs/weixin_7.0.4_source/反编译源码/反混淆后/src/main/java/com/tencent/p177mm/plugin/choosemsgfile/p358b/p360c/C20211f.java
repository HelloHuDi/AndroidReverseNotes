package com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Rect;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.GridLayoutManager.C8440b;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9362gs;
import com.tencent.p177mm.p612ui.gridviewheaders.C15894a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42886a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d.C42887b;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C11376a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C33812c;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b.C38787m;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p360c.C33817g.C33816a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a.C11372a;
import com.tencent.p177mm.plugin.choosemsgfile.p358b.p722a.C11373b;
import com.tencent.p177mm.plugin.choosemsgfile.p361ui.C42890a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Date;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f */
public final class C20211f extends C33815b {
    /* renamed from: Lp */
    int f4373Lp = 0;
    public C36749c kvi;
    private C4884c kvj = new C113791();
    private GridLayoutManager kvk;
    int kvl = 0;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$1 */
    class C113791 extends C4884c<C9362gs> {
        C113791() {
            AppMethodBeat.m2504i(54354);
            this.xxI = C9362gs.class.getName().hashCode();
            AppMethodBeat.m2505o(54354);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(54355);
            C9362gs c9362gs = (C9362gs) c4883b;
            C20211f.m31255a(C20211f.this, c9362gs.cBr.cvx, c9362gs);
            AppMethodBeat.m2505o(54355);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$2 */
    class C113812 implements C33816a {

        /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$2$2 */
        class C113802 implements Runnable {
            C113802() {
            }

            public final void run() {
                AppMethodBeat.m2504i(54362);
                C20211f.this.kvi.aop.notifyChanged();
                AppMethodBeat.m2505o(54362);
            }
        }

        C113812() {
        }

        /* renamed from: a */
        public final void mo23128a(boolean z, final C11376a c11376a, final C41531v c41531v) {
            AppMethodBeat.m2504i(54363);
            if (c11376a == null) {
                C4990ab.m7412e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
                AppMethodBeat.m2505o(54363);
                return;
            }
            C4990ab.m7417i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", Boolean.valueOf(z));
            if (z) {
                c11376a.bfq();
                C20211f.m31254a(C20211f.this).mo68414gX(c11376a.kua.field_msgId);
                C11373b.m19132a(c11376a, new C11372a() {

                    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$2$1$1 */
                    class C113831 implements Runnable {
                        C113831() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(54356);
                            C20211f.this.kvi.aop.notifyChanged();
                            AppMethodBeat.m2505o(54356);
                        }
                    }

                    /* renamed from: a */
                    public final void mo23103a(MsgFile msgFile) {
                        AppMethodBeat.m2504i(54357);
                        C4990ab.m7417i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", c11376a, msgFile);
                        C20211f.m31254a(C20211f.this).mo68415gY(c11376a.kua.field_msgId);
                        C20211f.m31254a(C20211f.this).mo68408a(c11376a.kua.field_msgId, msgFile);
                        if (C20211f.m31254a(C20211f.this).bfD()) {
                            C5004al.m7441d(new C113831());
                        }
                        C20211f.this.kuT.bfG();
                        c11376a.bfr();
                        C11376a c11376a = (C11376a) ((C38787m) c41531v).kuG.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54357);
                    }

                    public final void bfe() {
                        AppMethodBeat.m2504i(54358);
                        C4990ab.m7413e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", c11376a);
                        C20211f.m31254a(C20211f.this).mo68415gY(c11376a.kua.field_msgId);
                        c11376a.bft();
                        C11376a c11376a = (C11376a) ((C38787m) c41531v).kuG.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54358);
                    }

                    public final void bff() {
                        AppMethodBeat.m2504i(54359);
                        C4990ab.m7417i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", c11376a);
                        C20211f.m31254a(C20211f.this).mo68415gY(c11376a.kua.field_msgId);
                        c11376a.bfu();
                        C11376a c11376a = (C11376a) ((C38787m) c41531v).kuG.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54359);
                    }

                    public final void bfg() {
                        AppMethodBeat.m2504i(54360);
                        C4990ab.m7413e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", c11376a);
                        C20211f.m31254a(C20211f.this).mo68415gY(c11376a.kua.field_msgId);
                        c11376a.bfs();
                        C11376a c11376a = (C11376a) ((C38787m) c41531v).kuG.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54360);
                    }

                    /* renamed from: dK */
                    public final void mo23107dK(int i, int i2) {
                        AppMethodBeat.m2504i(54361);
                        C4990ab.m7413e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", c11376a, Integer.valueOf(i), Integer.valueOf(i2));
                        c11376a.mo23118dM(i, i2);
                        C11376a c11376a = (C11376a) ((C38787m) c41531v).kuG.getTag();
                        if (c11376a.equals(c11376a)) {
                            c11376a.mo23108T(c41531v);
                        }
                        AppMethodBeat.m2505o(54361);
                    }
                }, C20211f.this.bfA());
            } else {
                c11376a.bfu();
                C20211f.m31254a(C20211f.this).mo68415gY(c11376a.kua.field_msgId);
                C20211f.m31254a(C20211f.this).mo68412gV(c11376a.kua.field_msgId);
                if (C20211f.m31254a(C20211f.this).bfD()) {
                    C5004al.m7441d(new C113802());
                }
                C20211f.this.kuT.bfG();
            }
            c11376a.mo23108T(c41531v);
            AppMethodBeat.m2505o(54363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$3 */
    class C167303 extends C8440b {
        C167303() {
        }

        /* renamed from: bU */
        public final int mo18459bU(int i) {
            AppMethodBeat.m2504i(54364);
            if (((C11376a) C20211f.this.iPr.get(i)).getType() == 0) {
                AppMethodBeat.m2505o(54364);
                return 4;
            }
            AppMethodBeat.m2505o(54364);
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.c.f$4 */
    public class C202124 extends C25373h {
        final /* synthetic */ Context val$context;

        public C202124(Context context) {
            this.val$context = context;
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(54365);
            int dimension = (int) this.val$context.getResources().getDimension(C25738R.dimen.f9981m7);
            rect.bottom = dimension;
            rect.top = dimension;
            rect.left = dimension;
            rect.right = dimension;
            AppMethodBeat.m2505o(54365);
        }
    }

    public C20211f(C42890a c42890a) {
        super(c42890a);
        AppMethodBeat.m2504i(54368);
        AppMethodBeat.m2505o(54368);
    }

    /* renamed from: dx */
    public final void mo35455dx(String str, String str2) {
        AppMethodBeat.m2504i(54369);
        C4990ab.m7416i("MicroMsg.ChooseMsgFileUIController", "onCreate");
        this.kvj.dnU();
        mo6921b(true, str, str2);
        AppMethodBeat.m2505o(54369);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(54370);
        C4990ab.m7416i("MicroMsg.ChooseMsgFileUIController", "onResume");
        this.kvi.aop.notifyChanged();
        AppMethodBeat.m2505o(54370);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(54371);
        C4990ab.m7416i("MicroMsg.ChooseMsgFileUIController", "onPause");
        AppMethodBeat.m2505o(54371);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(54372);
        C4990ab.m7416i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
        this.kvj.dead();
        AppMethodBeat.m2505o(54372);
    }

    public final C41523a bfB() {
        AppMethodBeat.m2504i(54373);
        this.kvi = new C36749c(this.kuT, this.iPr);
        this.kvi.kuV = new C113812();
        C36749c c36749c = this.kvi;
        AppMethodBeat.m2505o(54373);
        return c36749c;
    }

    public final <T extends C17480i> T bfC() {
        AppMethodBeat.m2504i(54374);
        if (this.kvk == null) {
            this.kvk = new GridLayoutManager(4);
            this.kvk.akZ = new C167303();
        }
        GridLayoutManager gridLayoutManager = this.kvk;
        AppMethodBeat.m2505o(54374);
        return gridLayoutManager;
    }

    /* renamed from: b */
    public final void mo6921b(final boolean z, final String str, final String str2) {
        AppMethodBeat.m2504i(54375);
        if (z) {
            this.iPr.clear();
            this.f4373Lp = 0;
        }
        this.kvi.kuX = true;
        this.kuT.mo61660fO(z);
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(54367);
                LinkedList linkedList = new LinkedList();
                Cursor cw = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15324cw(C20211f.this.edV, C20211f.this.f4373Lp);
                if (cw == null) {
                    C4990ab.m7412e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
                    AppMethodBeat.m2505o(54367);
                    return;
                }
                long b;
                long j = 0;
                while (cw.moveToNext()) {
                    try {
                        C20211f.this.f4373Lp = C20211f.this.f4373Lp + 1;
                        C7620bi c7620bi = new C7620bi();
                        c7620bi.mo8995d(cw);
                        C11376a a = C42887b.m76155a(C20211f.this.kvi, c7620bi, C20211f.this.edV, str, str2);
                        if (a != null) {
                            b = C15894a.dJg().mo28138b(new Date(c7620bi.field_createTime));
                            if (j != b) {
                                linkedList.add(new C33812c(C20211f.this.kvi, c7620bi.field_createTime));
                                C20211f.this.kvl = C20211f.this.kvl + 1;
                            }
                            linkedList.add(a);
                        } else {
                            b = j;
                        }
                        j = b;
                    } catch (Throwable th) {
                        cw.close();
                        AppMethodBeat.m2505o(54367);
                    }
                }
                cw.close();
                LinkedList linkedList2 = new LinkedList();
                if (linkedList.size() - C20211f.this.kvl == 200) {
                    long timeStamp = ((C11376a) linkedList.get(0)).getTimeStamp();
                    C15894a.dJg();
                    C4990ab.m7417i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", Integer.valueOf(linkedList.size()), Long.valueOf(C15894a.m24213nv(timeStamp)), Long.valueOf(timeStamp));
                    Cursor q = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15348q(C20211f.this.edV, j, timeStamp);
                    Date date = new Date(timeStamp);
                    b = C15894a.dJg().mo28138b(date);
                    while (q != null) {
                        try {
                            if (!q.moveToNext()) {
                                break;
                            }
                            C20211f.this.f4373Lp = C20211f.this.f4373Lp + 1;
                            C7620bi c7620bi2 = new C7620bi();
                            c7620bi2.mo8995d(q);
                            C11376a a2 = C42887b.m76155a(C20211f.this.kvi, c7620bi2, C20211f.this.edV, str, str2);
                            if (a2 != null) {
                                j = C15894a.dJg().mo28138b(new Date(c7620bi2.field_createTime));
                                if (b != j && C15894a.dJg().mo28138b(date) != j) {
                                    linkedList2.add(new C33812c(C20211f.this.kvi, c7620bi2.field_createTime));
                                    C20211f.this.kvl = C20211f.this.kvl + 1;
                                    b = j;
                                } else if (linkedList.size() > 0 && linkedList2.size() == 0) {
                                    linkedList2.add(0, linkedList.remove(0));
                                }
                                linkedList2.add(a2);
                            }
                        } catch (Throwable th2) {
                            if (q != null) {
                                q.close();
                            }
                            AppMethodBeat.m2505o(54367);
                        }
                    }
                    if (q != null) {
                        q.close();
                    }
                }
                final int size = linkedList.size() + linkedList2.size();
                C20211f.this.iPr.addAll(0, linkedList2);
                C20211f.this.iPr.addAll(linkedList2.size(), linkedList);
                linkedList.clear();
                linkedList2.clear();
                C20211f.this.kvl = 0;
                C4990ab.m7417i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", Integer.valueOf(C20211f.this.iPr.size()));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(54366);
                        C20211f.this.kvi.kuX = false;
                        C20211f.this.kuT.mo61664p(z, size);
                        AppMethodBeat.m2505o(54366);
                    }
                });
                AppMethodBeat.m2505o(54367);
            }
        });
        AppMethodBeat.m2505o(54375);
    }

    /* renamed from: a */
    static /* synthetic */ void m31255a(C20211f c20211f, long j, C9362gs c9362gs) {
        AppMethodBeat.m2504i(54376);
        int gU = c20211f.kvi.mo58598gU(j);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) c20211f.bfC();
        int iQ = gridLayoutManager.mo1780iQ();
        C4990ab.m7417i("MicroMsg.ChooseMsgFileUIController", "[getPhotoInfo] msgId:%s pos:%s [%s:%s]", Long.valueOf(j), Integer.valueOf(gU), Integer.valueOf(iQ), Integer.valueOf(gridLayoutManager.mo1782iS()));
        if (gU >= iQ && gU <= r2) {
            View childAt = c20211f.kuT.getChildAt(gU - iQ);
            if (childAt != null) {
                int[] iArr = new int[2];
                childAt.getLocationInWindow(iArr);
                c9362gs.cBs.ctT = iArr[0];
                c9362gs.cBs.ctU = iArr[1];
                c9362gs.cBs.ctV = childAt.getWidth();
                c9362gs.cBs.ctW = childAt.getHeight();
            }
        }
        AppMethodBeat.m2505o(54376);
    }

    /* renamed from: a */
    static /* synthetic */ C42886a m31254a(C20211f c20211f) {
        AppMethodBeat.m2504i(54377);
        C42886a bfn = c20211f.kuT.bfn();
        AppMethodBeat.m2505o(54377);
        return bfn;
    }
}
