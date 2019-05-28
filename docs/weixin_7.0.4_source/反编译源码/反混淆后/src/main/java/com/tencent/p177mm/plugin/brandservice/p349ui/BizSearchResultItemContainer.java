package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38690a;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38691b;
import com.tencent.p177mm.plugin.brandservice.p926b.C20027h;
import com.tencent.p177mm.plugin.brandservice.p926b.C20028i;
import com.tencent.p177mm.protocal.protobuf.C35934mh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer */
public class BizSearchResultItemContainer extends LinearLayout implements C1202f {
    private int gOW = 0;
    private int jKX;
    private ListView jLm;
    C42811c jLn;
    private TextView jLo;
    C2685c jLp;
    private C11190a jLq;
    C20028i jLr;
    private C11191b jLs;
    private long[] jLt;
    int jLu;
    private boolean jLv;
    private int jLw;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer$c */
    static class C2685c {
        public String ctj;
        public long jKC;
        public boolean jLC;
        public boolean jLD;
        public int jLh;
        public int offset;

        private C2685c() {
            this.jLh = 1;
        }

        /* synthetic */ C2685c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer$a */
    static class C11190a {
        View jLA;
        View jLB;
        View jLz;

        private C11190a() {
        }

        /* synthetic */ C11190a(byte b) {
            this();
        }

        /* renamed from: sd */
        public final void mo22872sd(int i) {
            AppMethodBeat.m2504i(13900);
            switch (i) {
                case 1:
                    m18897w(true, false);
                    AppMethodBeat.m2505o(13900);
                    return;
                case 2:
                    m18897w(false, true);
                    AppMethodBeat.m2505o(13900);
                    return;
                case 3:
                    m18897w(false, false);
                    AppMethodBeat.m2505o(13900);
                    return;
                default:
                    m18897w(false, false);
                    AppMethodBeat.m2505o(13900);
                    return;
            }
        }

        /* renamed from: w */
        private void m18897w(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            AppMethodBeat.m2504i(13901);
            View view = this.jLz;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.jLA.setVisibility(8);
            View view2 = this.jLB;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            AppMethodBeat.m2505o(13901);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer$b */
    public interface C11191b {
        void aWc();

        void aWd();
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer$1 */
    class C275121 implements OnScrollListener {
        boolean jLx = false;

        C275121() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(13898);
            if (i == 0 && this.jLx && BizSearchResultItemContainer.m65612a(BizSearchResultItemContainer.this)) {
                BizSearchResultItemContainer.m65611a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.this.jLp.ctj, BizSearchResultItemContainer.this.jLp.offset, BizSearchResultItemContainer.this.jLt[BizSearchResultItemContainer.this.jLt.length - 1]);
            }
            AppMethodBeat.m2505o(13898);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 == i3) {
                this.jLx = true;
            } else {
                this.jLx = false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer$2 */
    class C386822 implements Runnable {
        C386822() {
        }

        public final void run() {
            AppMethodBeat.m2504i(13899);
            BizSearchResultItemContainer.this.jLo.setVisibility(BizSearchResultItemContainer.this.jLn.isEmpty() ? 0 : 8);
            AppMethodBeat.m2505o(13899);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m65611a(BizSearchResultItemContainer bizSearchResultItemContainer, String str, int i, long j) {
        AppMethodBeat.m2504i(13914);
        bizSearchResultItemContainer.m65614b(str, i, j);
        AppMethodBeat.m2505o(13914);
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(13902);
        View inflate = View.inflate(getContext(), 2130970574, this);
        this.jLp = new C2685c();
        this.jLq = new C11190a();
        this.jLo = (TextView) inflate.findViewById(2131827284);
        this.jLm = (ListView) inflate.findViewById(2131827285);
        AppMethodBeat.m2505o(13902);
    }

    public void setAdapter(C42811c c42811c) {
        AppMethodBeat.m2504i(13903);
        this.jLn = c42811c;
        if (this.jLn != null) {
            this.jLn.setScene(this.gOW);
            ListView listView = this.jLm;
            C11190a c11190a = this.jLq;
            View inflate = View.inflate(getContext(), 2130969940, null);
            c11190a.jLz = inflate.findViewById(2131825264);
            c11190a.jLA = inflate.findViewById(2131822252);
            c11190a.jLB = inflate.findViewById(2131825265);
            c11190a.jLz.setVisibility(8);
            c11190a.jLA.setVisibility(8);
            c11190a.jLB.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.jLm.setAdapter(this.jLn);
            this.jLm.setOnScrollListener(new C275121());
            this.jLm.setOnItemClickListener(this.jLn);
            if (this.jLp.jKC == 0) {
                setBusinessTypes(1);
                AppMethodBeat.m2505o(13903);
                return;
            }
        }
        this.jLm.setAdapter(this.jLn);
        AppMethodBeat.m2505o(13903);
    }

    public C42811c getAdapter() {
        return this.jLn;
    }

    /* renamed from: b */
    private void m65614b(String str, int i, long j) {
        List list;
        AppMethodBeat.m2504i(13904);
        this.jLp.jLC = true;
        C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, (C1202f) this);
        C35934mh c35934mh = null;
        C38690a gD = this.jLn.mo68270gD(this.jLt[this.jLt.length - 1]);
        if (gD != null) {
            list = gD.jLl;
        } else {
            list = null;
        }
        if (list == null || list.size() == 0) {
            C4990ab.m7417i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", str, Integer.valueOf(i), Long.valueOf(j));
        } else {
            c35934mh = (C35934mh) list.get(list.size() - 1);
        }
        C4990ab.m7411d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", str, Integer.valueOf(i), Long.valueOf(j), c35934mh != null ? c35934mh.vQg : "");
        C1720g.m3540Rg().mo14541a(new C20027h(str, j, i, this.gOW, r6), 0);
        this.jLq.mo22872sd(1);
        AppMethodBeat.m2505o(13904);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 3;
        AppMethodBeat.m2504i(13905);
        C4990ab.m7417i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.jLs != null) {
            this.jLs.aWd();
        }
        if (i == 0 && i2 == 0) {
            this.jLv = false;
            if (c1207m == null) {
                C4990ab.m7412e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                AppMethodBeat.m2505o(13905);
                return;
            }
            int i4;
            int i5;
            int i6;
            if (c1207m.getType() == FilterEnum4Shaka.MIC_WEISHI_XINXUE) {
                List list;
                C4990ab.m7416i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_XINXUE, (C1202f) this);
                C20028i c20028i = (C20028i) c1207m;
                if (c20028i.jKD == null) {
                    list = null;
                } else {
                    list = c20028i.jKD.wWw;
                }
                this.jLn.mo35289h(this.jLp.ctj, list);
                C38690a gD = this.jLn.mo68270gD(this.jLt[this.jLt.length - 1]);
                if (gD == null || gD.jLk) {
                    i6 = 0;
                } else {
                    i6 = gD.jLh;
                }
                if (i6 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    C35934mh c35934mh = (C35934mh) list.get(list.size() - 1);
                    if (c35934mh != null) {
                        this.jLp.offset = c35934mh.vOq + this.jLu;
                    }
                }
                i4 = i3;
                i5 = i6;
            } else if (c1207m.getType() == FilterEnum4Shaka.MIC_WEISHI_LIULI) {
                C1720g.m3540Rg().mo14546b((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, (C1202f) this);
                C4990ab.m7416i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                C35934mh aVX = ((C20027h) c1207m).aVX();
                if (aVX == null || aVX.naO == null) {
                    C4990ab.m7412e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i6 = aVX == null ? 0 : aVX.vQe;
                if (i6 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.jLn.mo35285a(aVX, true);
                if (aVX != null) {
                    C4990ab.m7411d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", aVX.vQg);
                    this.jLp.offset = aVX.vOq + this.jLu;
                }
                i5 = i6;
            } else {
                C4990ab.m7413e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", Integer.valueOf(c1207m.getType()));
                AppMethodBeat.m2505o(13905);
                return;
            }
            if (this.jLn.isEmpty()) {
                new C7306ak(Looper.getMainLooper()).post(new C386822());
            } else {
                this.jLp.jLD = true;
            }
            this.jLp.jLh = i5;
            this.jLq.mo22872sd(i4);
            this.jLp.jLC = false;
            C4990ab.m7419v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", Integer.valueOf(this.jLp.offset));
            AppMethodBeat.m2505o(13905);
            return;
        }
        this.jLp.jLC = false;
        this.jLv = true;
        Toast.makeText(getContext(), getContext().getString(C25738R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.m2505o(13905);
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        AppMethodBeat.m2504i(13906);
        this.jLn.aWb();
        this.jLq.mo22872sd(0);
        this.jLp.jLD = false;
        this.jLp.jLC = false;
        this.jLp.offset = 0;
        this.jLp.ctj = null;
        this.jLp.jLh = 1;
        AppMethodBeat.m2505o(13906);
    }

    public void setBusinessTypes(long... jArr) {
        AppMethodBeat.m2504i(13907);
        if (jArr != null && jArr.length > 0) {
            this.jLt = jArr;
            this.jLp.jKC = 0;
            for (long j : jArr) {
                C2685c c2685c = this.jLp;
                c2685c.jKC |= j;
            }
            this.jLn.mo68269c(jArr);
        }
        AppMethodBeat.m2505o(13907);
    }

    public void setReporter(C38691b c38691b) {
        AppMethodBeat.m2504i(13908);
        if (this.jLn != null) {
            this.jLn.setReporter(c38691b);
        }
        AppMethodBeat.m2505o(13908);
    }

    /* renamed from: bH */
    public final void mo61525bH(String str, int i) {
        AppMethodBeat.m2504i(13909);
        if (this.jLn.isEmpty()) {
            this.jLo.setVisibility(8);
        }
        if (str == null) {
            AppMethodBeat.m2505o(13909);
            return;
        }
        String trim = str.trim();
        if ("".equals(trim) || (trim.equals(this.jLp.ctj) && !this.jLv)) {
            AppMethodBeat.m2505o(13909);
        } else if (this.jLp.jLC) {
            AppMethodBeat.m2505o(13909);
        } else {
            reset();
            this.jLp.jLC = true;
            this.jLp.ctj = trim;
            this.jLu = i;
            if (this.jLw != 1) {
                C1720g.m3540Rg().mo14539a((int) FilterEnum4Shaka.MIC_WEISHI_XINXUE, (C1202f) this);
                this.jLr = new C20028i(this.jLp.ctj, this.jLp.jKC, this.gOW);
                C1720g.m3540Rg().mo14541a(this.jLr, 0);
            } else if (this.jLt.length == 0) {
                C4990ab.m7416i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                AppMethodBeat.m2505o(13909);
                return;
            } else {
                m65614b(trim, i, this.jLt[0]);
                this.jLq.mo22872sd(0);
            }
            if (this.jLs != null) {
                this.jLs.aWc();
            }
            AppMethodBeat.m2505o(13909);
        }
    }

    public C11191b getIOnSearchStateChangedListener() {
        return this.jLs;
    }

    public void setIOnSearchStateChangedListener(C11191b c11191b) {
        this.jLs = c11191b;
    }

    public void setScene(int i) {
        AppMethodBeat.m2504i(13910);
        this.gOW = i;
        this.jLn.setScene(this.gOW);
        AppMethodBeat.m2505o(13910);
    }

    public void setAddContactScene(int i) {
        AppMethodBeat.m2504i(13911);
        this.jKX = i;
        this.jLn.setAddContactScene(i);
        AppMethodBeat.m2505o(13911);
    }

    public final void setDisplayArgs$25decb5(boolean z) {
        AppMethodBeat.m2504i(13912);
        this.jLn.mo68278v(z, false);
        AppMethodBeat.m2505o(13912);
    }

    public void setMode(int i) {
        this.jLw = i;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(13913);
        super.setOnTouchListener(onTouchListener);
        this.jLm.setOnTouchListener(onTouchListener);
        AppMethodBeat.m2505o(13913);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m65612a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.jLp.jLD || bizSearchResultItemContainer.jLp.jLh == 0 || bizSearchResultItemContainer.jLp.jLC) ? false : true;
    }
}
