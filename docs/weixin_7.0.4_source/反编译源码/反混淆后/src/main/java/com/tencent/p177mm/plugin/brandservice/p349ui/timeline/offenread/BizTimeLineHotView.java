package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C32514ah;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C38689c;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42808a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.chc;
import com.tencent.p177mm.protocal.protobuf.chd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7617ak;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView */
public class BizTimeLineHotView extends LinearLayout implements C1202f, C4937b {
    private int iWJ = 0;
    public C20062e jQg = new C20062e();
    WeakReference<Activity> jQk;
    private BizTimeLineHotListView jQl;
    private boolean jQm = false;
    private List<C42820b> jQn = new ArrayList();
    private C42821c jQo;
    private int jQp = 0;
    public C4884c jQq = new C428182();
    private boolean jQr = true;
    private IdleHandler jQs = new C337367();
    private TextView jao;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView$7 */
    class C337367 implements IdleHandler {
        C337367() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(14312);
            Looper.myQueue().removeIdleHandler(BizTimeLineHotView.this.jQs);
            if (BizTimeLineHotView.this.jQk.get() == null || ((Activity) BizTimeLineHotView.this.jQk.get()).isFinishing()) {
                AppMethodBeat.m2505o(14312);
            } else {
                BizTimeLineHotView.this.jQl.mo45328aZ(BizTimeLineHotView.this.jQn);
                AppMethodBeat.m2505o(14312);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView$6 */
    class C387066 implements Runnable {
        C387066() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14311);
            if (BizTimeLineHotView.this.jQk.get() != null && ((Activity) BizTimeLineHotView.this.jQk.get()).isFinishing()) {
                AppMethodBeat.m2505o(14311);
            } else if (C5046bo.m7548ek(BizTimeLineHotView.this.jQn)) {
                BizTimeLineHotView.this.setVisibility(8);
                AppMethodBeat.m2505o(14311);
            } else {
                if (BizTimeLineHotView.this.getVisibility() != 0) {
                    BizTimeLineHotView.this.setVisibility(0);
                }
                if (BizTimeLineHotView.this.jQr) {
                    BizTimeLineHotView.this.jQr = false;
                    BizTimeLineHotView.this.jQl.mo45328aZ(BizTimeLineHotView.this.jQn);
                    AppMethodBeat.m2505o(14311);
                    return;
                }
                Looper.myQueue().removeIdleHandler(BizTimeLineHotView.this.jQs);
                Looper.myQueue().addIdleHandler(BizTimeLineHotView.this.jQs);
                AppMethodBeat.m2505o(14311);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView$3 */
    class C428153 implements Runnable {
        C428153() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14309);
            BizTimeLineHotView.m75954c(BizTimeLineHotView.this);
            AppMethodBeat.m2505o(14309);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView$2 */
    class C428182 extends C4884c<C32514ah> {
        C428182() {
            AppMethodBeat.m2504i(14307);
            this.xxI = C32514ah.class.getName().hashCode();
            AppMethodBeat.m2505o(14307);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(14308);
            final C32514ah c32514ah = (C32514ah) c4883b;
            if (!(c32514ah == null || c32514ah.ctf == null || C5046bo.isNullOrNil(c32514ah.ctf.userName) || BizTimeLineHotView.this.jQn == null)) {
                C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(14306);
                        for (Object obj : BizTimeLineHotView.this.jQn) {
                            if (c32514ah.ctf.userName.equals(obj.vGE)) {
                                break;
                            }
                        }
                        Object obj2 = null;
                        if (obj2 != null) {
                            BizTimeLineHotView.this.jQn.remove(obj2);
                        }
                        BizTimeLineHotView.m75953b(BizTimeLineHotView.this);
                        AppMethodBeat.m2505o(14306);
                    }
                }, 0);
            }
            AppMethodBeat.m2505o(14308);
            return false;
        }
    }

    public BizTimeLineHotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(14314);
        init(context);
        AppMethodBeat.m2505o(14314);
    }

    public BizTimeLineHotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(14315);
        init(context);
        AppMethodBeat.m2505o(14315);
    }

    /* renamed from: d */
    public final void mo68287d(C46627q c46627q) {
        AppMethodBeat.m2504i(14316);
        if (c46627q != null) {
            C46627q mE = C41747z.aeX().mo64115mE((long) c46627q.field_talkerId);
            if (mE != null && mE.field_msgId == c46627q.field_msgId) {
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().apb(c46627q.field_talker);
                m75946FF(c46627q.field_talker);
            }
        }
        AppMethodBeat.m2505o(14316);
    }

    /* renamed from: FF */
    private void m75946FF(final String str) {
        AppMethodBeat.m2504i(14317);
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(14305);
                if (BizTimeLineHotView.this.jQn == null) {
                    AppMethodBeat.m2505o(14305);
                } else if (str == null || C1855t.m3956ny(str)) {
                    AppMethodBeat.m2505o(14305);
                } else {
                    for (C42820b c42820b : BizTimeLineHotView.this.jQn) {
                        if (str.equals(c42820b.vGE)) {
                            if (BizTimeLineHotView.m75952a(c42820b)) {
                                BizTimeLineHotView.m75949a(BizTimeLineHotView.this, c42820b);
                                AppMethodBeat.m2505o(14305);
                                return;
                            }
                            AppMethodBeat.m2505o(14305);
                        }
                    }
                    AppMethodBeat.m2505o(14305);
                }
            }
        }, 0);
        AppMethodBeat.m2505o(14317);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(14318);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7413e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(14318);
            return;
        }
        m75946FF((String) obj);
        AppMethodBeat.m2505o(14318);
    }

    public int getItemPadding() {
        AppMethodBeat.m2504i(14319);
        int dj = C42819a.m75964dj(getContext());
        AppMethodBeat.m2505o(14319);
        return dj;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(14320);
        C1720g.m3540Rg().mo14539a(2768, (C1202f) this);
        this.jQk = new WeakReference((Activity) context);
        C42819a.init(context);
        this.iWJ = getItemPadding();
        View inflate = C5616v.m8409hu(context).inflate(2130968862, this);
        this.jQl = (BizTimeLineHotListView) inflate.findViewById(2131821819);
        this.jao = (TextView) inflate.findViewById(2131821817);
        this.jQo = new C42821c(this.iWJ);
        this.jQl.mo66346b((C25373h) this.jQo);
        this.jQl.mo45325a(context, this.jQn, this.jQg);
        getLocalOftenReadData();
        getOftenRead();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo10118a(this);
        C4879a.xxA.mo10052c(this.jQq);
        AppMethodBeat.m2505o(14320);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(14321);
        super.onConfigurationChanged(configuration);
        if (this.jQp != configuration.orientation) {
            if (this.jQo != null) {
                this.iWJ = getItemPadding();
                this.jQo.padding = this.iWJ;
            }
            this.jQp = configuration.orientation;
            Looper.myQueue().addIdleHandler(this.jQs);
        }
        AppMethodBeat.m2505o(14321);
    }

    public void setTitlePaddingLeft(int i) {
        AppMethodBeat.m2504i(14322);
        if (this.jao != null) {
            TextView textView = this.jao;
            textView.setPadding(i, textView.getPaddingTop(), this.jao.getPaddingRight(), this.jao.getPaddingBottom());
        }
        AppMethodBeat.m2505o(14322);
    }

    private void getLocalOftenReadData() {
        AppMethodBeat.m2504i(14323);
        if (C5046bo.m7548ek(this.jQn)) {
            m75951a(C42822d.aWL());
            AppMethodBeat.m2505o(14323);
            return;
        }
        AppMethodBeat.m2505o(14323);
    }

    private void getOftenRead() {
        AppMethodBeat.m2504i(14324);
        C33720b.m55105a("BrandServiceWorkerThread", new C428153(), 0);
        AppMethodBeat.m2505o(14324);
    }

    /* renamed from: a */
    private void m75951a(final chc chc) {
        AppMethodBeat.m2504i(14325);
        if (chc != null) {
            C42808a.m75914gP((long) (chc.xfZ * 1000));
            C42808a.m75915gQ((long) chc.xfX);
        }
        if (chc == null || C5046bo.m7548ek(chc.xfW)) {
            if (C5046bo.m7548ek(this.jQn)) {
                setVisibility(8);
            }
            C4990ab.m7416i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
            AppMethodBeat.m2505o(14325);
            return;
        }
        C4990ab.m7417i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", Integer.valueOf(chc.xfW.size()), Integer.valueOf(chc.xfY), Integer.valueOf(chc.xfX));
        if (C42808a.m75916sG(4)) {
            setVisibility(8);
            AppMethodBeat.m2505o(14325);
            return;
        }
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                boolean z = false;
                AppMethodBeat.m2504i(14310);
                BizTimeLineHotView.this.jQn = new ArrayList();
                Iterator it = chc.xfW.iterator();
                int i = 0;
                while (it.hasNext()) {
                    chd chd = (chd) it.next();
                    i++;
                    if (i > 12) {
                        break;
                    }
                    C42820b c42820b = new C42820b();
                    if (C1855t.m3912mY(chd.vGE)) {
                        c42820b.vGE = chd.vGE;
                        BizTimeLineHotView.this.jQn.add(c42820b);
                    }
                }
                BizTimeLineHotView.this.aWK();
                BizTimeLineHotView bizTimeLineHotView = BizTimeLineHotView.this;
                if (chc.xfY == 1) {
                    z = true;
                }
                BizTimeLineHotView.m75950a(bizTimeLineHotView, z);
                BizTimeLineHotView.m75953b(BizTimeLineHotView.this);
                AppMethodBeat.m2505o(14310);
            }
        }, 0);
        AppMethodBeat.m2505o(14325);
    }

    public final void aWK() {
        AppMethodBeat.m2504i(14326);
        if (C5046bo.m7548ek(this.jQn)) {
            AppMethodBeat.m2505o(14326);
            return;
        }
        for (C42820b a : this.jQn) {
            BizTimeLineHotView.m75952a(a);
        }
        AppMethodBeat.m2505o(14326);
    }

    /* renamed from: a */
    public static boolean m75952a(C42820b c42820b) {
        AppMethodBeat.m2504i(14327);
        long aoP = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoP(c42820b.vGE);
        C46627q mE = C41747z.aeX().mo64115mE(aoP);
        if (mE == null) {
            AppMethodBeat.m2505o(14327);
            return false;
        }
        c42820b.jrh = mE.field_createTime;
        C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(c42820b.vGE);
        boolean z = c42820b.jQz;
        c42820b.jQz = false;
        if (aoZ != null && aoZ.field_unReadCount > 0 && System.currentTimeMillis() - c42820b.jrh < C42808a.aYQ() && aoZ.field_unReadCount > C41747z.aeY().mo39197mN(aoP)) {
            c42820b.jQz = true;
        }
        if (z != c42820b.jQz) {
            AppMethodBeat.m2505o(14327);
            return true;
        }
        AppMethodBeat.m2505o(14327);
        return false;
    }

    public final void aWJ() {
        AppMethodBeat.m2504i(14328);
        if (getVisibility() != 0 || C5046bo.m7548ek(this.jQn)) {
            AppMethodBeat.m2505o(14328);
            return;
        }
        this.jQl.aWJ();
        AppMethodBeat.m2505o(14328);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(14329);
        C4990ab.m7417i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C11246g) {
                chc chc = (chc) ((C11246g) c1207m).ehh.fsH.fsP;
                if (this.jQk.get() != null && ((Activity) this.jQk.get()).isFinishing()) {
                    AppMethodBeat.m2505o(14329);
                    return;
                } else if (C38689c.m65625b(chc, C42822d.aWL())) {
                    C4990ab.m7410d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
                    AppMethodBeat.m2505o(14329);
                    return;
                } else {
                    C42822d.jQA = chc;
                    try {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, Base64.encodeToString(chc.toByteArray(), 0));
                    } catch (IOException e) {
                        C4990ab.m7413e("MicroMsg.BizTimeLineOftenReadHelper", "resetOftenRead exp: %s", e.getMessage());
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_BIZ_TIME_LINE_OFTEN_READ_STRING_SYNC, (Object) "");
                    }
                    m75951a(chc);
                }
            }
            AppMethodBeat.m2505o(14329);
            return;
        }
        AppMethodBeat.m2505o(14329);
    }

    /* renamed from: b */
    static /* synthetic */ void m75953b(BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.m2504i(14331);
        C5004al.m7441d(new C387066());
        AppMethodBeat.m2505o(14331);
    }

    /* renamed from: c */
    static /* synthetic */ void m75954c(BizTimeLineHotView bizTimeLineHotView) {
        AppMethodBeat.m2504i(14332);
        if (!bizTimeLineHotView.jQm) {
            bizTimeLineHotView.jQm = true;
            C1720g.m3540Rg().mo14541a(new C11246g(), 0);
        }
        AppMethodBeat.m2505o(14332);
    }
}
