package com.tencent.mm.plugin.brandservice.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements f {
    private int gOW = 0;
    private int jKX;
    private ListView jLm;
    c jLn;
    private TextView jLo;
    c jLp;
    private a jLq;
    i jLr;
    private b jLs;
    private long[] jLt;
    int jLu;
    private boolean jLv;
    private int jLw;

    static class c {
        public String ctj;
        public long jKC;
        public boolean jLC;
        public boolean jLD;
        public int jLh;
        public int offset;

        private c() {
            this.jLh = 1;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static class a {
        View jLA;
        View jLB;
        View jLz;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void sd(int i) {
            AppMethodBeat.i(13900);
            switch (i) {
                case 1:
                    w(true, false);
                    AppMethodBeat.o(13900);
                    return;
                case 2:
                    w(false, true);
                    AppMethodBeat.o(13900);
                    return;
                case 3:
                    w(false, false);
                    AppMethodBeat.o(13900);
                    return;
                default:
                    w(false, false);
                    AppMethodBeat.o(13900);
                    return;
            }
        }

        private void w(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(13901);
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
            AppMethodBeat.o(13901);
        }
    }

    public interface b {
        void aWc();

        void aWd();
    }

    static /* synthetic */ void a(BizSearchResultItemContainer bizSearchResultItemContainer, String str, int i, long j) {
        AppMethodBeat.i(13914);
        bizSearchResultItemContainer.b(str, i, j);
        AppMethodBeat.o(13914);
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(13902);
        View inflate = View.inflate(getContext(), R.layout.aq6, this);
        this.jLp = new c();
        this.jLq = new a();
        this.jLo = (TextView) inflate.findViewById(R.id.e77);
        this.jLm = (ListView) inflate.findViewById(R.id.e78);
        AppMethodBeat.o(13902);
    }

    public void setAdapter(c cVar) {
        AppMethodBeat.i(13903);
        this.jLn = cVar;
        if (this.jLn != null) {
            this.jLn.setScene(this.gOW);
            ListView listView = this.jLm;
            a aVar = this.jLq;
            View inflate = View.inflate(getContext(), R.layout.a_2, null);
            aVar.jLz = inflate.findViewById(R.id.cpl);
            aVar.jLA = inflate.findViewById(R.id.ai5);
            aVar.jLB = inflate.findViewById(R.id.cpm);
            aVar.jLz.setVisibility(8);
            aVar.jLA.setVisibility(8);
            aVar.jLB.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.jLm.setAdapter(this.jLn);
            this.jLm.setOnScrollListener(new OnScrollListener() {
                boolean jLx = false;

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    AppMethodBeat.i(13898);
                    if (i == 0 && this.jLx && BizSearchResultItemContainer.a(BizSearchResultItemContainer.this)) {
                        BizSearchResultItemContainer.a(BizSearchResultItemContainer.this, BizSearchResultItemContainer.this.jLp.ctj, BizSearchResultItemContainer.this.jLp.offset, BizSearchResultItemContainer.this.jLt[BizSearchResultItemContainer.this.jLt.length - 1]);
                    }
                    AppMethodBeat.o(13898);
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (i + i2 == i3) {
                        this.jLx = true;
                    } else {
                        this.jLx = false;
                    }
                }
            });
            this.jLm.setOnItemClickListener(this.jLn);
            if (this.jLp.jKC == 0) {
                setBusinessTypes(1);
                AppMethodBeat.o(13903);
                return;
            }
        }
        this.jLm.setAdapter(this.jLn);
        AppMethodBeat.o(13903);
    }

    public c getAdapter() {
        return this.jLn;
    }

    private void b(String str, int i, long j) {
        List list;
        AppMethodBeat.i(13904);
        this.jLp.jLC = true;
        g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, (f) this);
        mh mhVar = null;
        a gD = this.jLn.gD(this.jLt[this.jLt.length - 1]);
        if (gD != null) {
            list = gD.jLl;
        } else {
            list = null;
        }
        if (list == null || list.size() == 0) {
            ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", str, Integer.valueOf(i), Long.valueOf(j));
        } else {
            mhVar = (mh) list.get(list.size() - 1);
        }
        ab.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", str, Integer.valueOf(i), Long.valueOf(j), mhVar != null ? mhVar.vQg : "");
        g.Rg().a(new h(str, j, i, this.gOW, r6), 0);
        this.jLq.sd(1);
        AppMethodBeat.o(13904);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 3;
        AppMethodBeat.i(13905);
        ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.jLs != null) {
            this.jLs.aWd();
        }
        if (i == 0 && i2 == 0) {
            this.jLv = false;
            if (mVar == null) {
                ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                AppMethodBeat.o(13905);
                return;
            }
            int i4;
            int i5;
            int i6;
            if (mVar.getType() == FilterEnum4Shaka.MIC_WEISHI_XINXUE) {
                List list;
                ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_XINXUE, (f) this);
                i iVar = (i) mVar;
                if (iVar.jKD == null) {
                    list = null;
                } else {
                    list = iVar.jKD.wWw;
                }
                this.jLn.h(this.jLp.ctj, list);
                a gD = this.jLn.gD(this.jLt[this.jLt.length - 1]);
                if (gD == null || gD.jLk) {
                    i6 = 0;
                } else {
                    i6 = gD.jLh;
                }
                if (i6 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    mh mhVar = (mh) list.get(list.size() - 1);
                    if (mhVar != null) {
                        this.jLp.offset = mhVar.vOq + this.jLu;
                    }
                }
                i4 = i3;
                i5 = i6;
            } else if (mVar.getType() == FilterEnum4Shaka.MIC_WEISHI_LIULI) {
                g.Rg().b((int) FilterEnum4Shaka.MIC_WEISHI_LIULI, (f) this);
                ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                mh aVX = ((h) mVar).aVX();
                if (aVX == null || aVX.naO == null) {
                    ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i6 = aVX == null ? 0 : aVX.vQe;
                if (i6 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.jLn.a(aVX, true);
                if (aVX != null) {
                    ab.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", aVX.vQg);
                    this.jLp.offset = aVX.vOq + this.jLu;
                }
                i5 = i6;
            } else {
                ab.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", Integer.valueOf(mVar.getType()));
                AppMethodBeat.o(13905);
                return;
            }
            if (this.jLn.isEmpty()) {
                new ak(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(13899);
                        BizSearchResultItemContainer.this.jLo.setVisibility(BizSearchResultItemContainer.this.jLn.isEmpty() ? 0 : 8);
                        AppMethodBeat.o(13899);
                    }
                });
            } else {
                this.jLp.jLD = true;
            }
            this.jLp.jLh = i5;
            this.jLq.sd(i4);
            this.jLp.jLC = false;
            ab.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", Integer.valueOf(this.jLp.offset));
            AppMethodBeat.o(13905);
            return;
        }
        this.jLp.jLC = false;
        this.jLv = true;
        Toast.makeText(getContext(), getContext().getString(R.string.byk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        AppMethodBeat.o(13905);
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        AppMethodBeat.i(13906);
        this.jLn.aWb();
        this.jLq.sd(0);
        this.jLp.jLD = false;
        this.jLp.jLC = false;
        this.jLp.offset = 0;
        this.jLp.ctj = null;
        this.jLp.jLh = 1;
        AppMethodBeat.o(13906);
    }

    public void setBusinessTypes(long... jArr) {
        AppMethodBeat.i(13907);
        if (jArr != null && jArr.length > 0) {
            this.jLt = jArr;
            this.jLp.jKC = 0;
            for (long j : jArr) {
                c cVar = this.jLp;
                cVar.jKC |= j;
            }
            this.jLn.c(jArr);
        }
        AppMethodBeat.o(13907);
    }

    public void setReporter(com.tencent.mm.plugin.brandservice.ui.c.b bVar) {
        AppMethodBeat.i(13908);
        if (this.jLn != null) {
            this.jLn.setReporter(bVar);
        }
        AppMethodBeat.o(13908);
    }

    public final void bH(String str, int i) {
        AppMethodBeat.i(13909);
        if (this.jLn.isEmpty()) {
            this.jLo.setVisibility(8);
        }
        if (str == null) {
            AppMethodBeat.o(13909);
            return;
        }
        String trim = str.trim();
        if ("".equals(trim) || (trim.equals(this.jLp.ctj) && !this.jLv)) {
            AppMethodBeat.o(13909);
        } else if (this.jLp.jLC) {
            AppMethodBeat.o(13909);
        } else {
            reset();
            this.jLp.jLC = true;
            this.jLp.ctj = trim;
            this.jLu = i;
            if (this.jLw != 1) {
                g.Rg().a((int) FilterEnum4Shaka.MIC_WEISHI_XINXUE, (f) this);
                this.jLr = new i(this.jLp.ctj, this.jLp.jKC, this.gOW);
                g.Rg().a(this.jLr, 0);
            } else if (this.jLt.length == 0) {
                ab.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                AppMethodBeat.o(13909);
                return;
            } else {
                b(trim, i, this.jLt[0]);
                this.jLq.sd(0);
            }
            if (this.jLs != null) {
                this.jLs.aWc();
            }
            AppMethodBeat.o(13909);
        }
    }

    public b getIOnSearchStateChangedListener() {
        return this.jLs;
    }

    public void setIOnSearchStateChangedListener(b bVar) {
        this.jLs = bVar;
    }

    public void setScene(int i) {
        AppMethodBeat.i(13910);
        this.gOW = i;
        this.jLn.setScene(this.gOW);
        AppMethodBeat.o(13910);
    }

    public void setAddContactScene(int i) {
        AppMethodBeat.i(13911);
        this.jKX = i;
        this.jLn.setAddContactScene(i);
        AppMethodBeat.o(13911);
    }

    public final void setDisplayArgs$25decb5(boolean z) {
        AppMethodBeat.i(13912);
        this.jLn.v(z, false);
        AppMethodBeat.o(13912);
    }

    public void setMode(int i) {
        this.jLw = i;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(13913);
        super.setOnTouchListener(onTouchListener);
        this.jLm.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(13913);
    }

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.jLp.jLD || bizSearchResultItemContainer.jLp.jLh == 0 || bizSearchResultItemContainer.jLp.jLC) ? false : true;
    }
}
