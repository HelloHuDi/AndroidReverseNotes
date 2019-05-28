package com.tencent.p177mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a.C11501b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView */
public class DownloadSearchListView extends MRecyclerView {
    List<C42924b> kPA;
    private C11501b kPB = new C339401();
    C20344a kPy;
    List<C42924b> kPz;
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView$1 */
    class C339401 implements C11501b {
        C339401() {
        }

        /* renamed from: E */
        public final void mo23220E(int i, long j) {
            AppMethodBeat.m2504i(136173);
            if (i == 9) {
                C42911a hv = C2895c.m5147hv(j);
                if (hv != null) {
                    C20344a a = DownloadSearchListView.this.kPy;
                    String str = hv.field_appId;
                    if (!(C5046bo.m7548ek(a.iPr) || C5046bo.isNullOrNil(str))) {
                        Iterator it = a.iPr.iterator();
                        while (it.hasNext()) {
                            C42924b c42924b = (C42924b) it.next();
                            if (c42924b.appId != null && c42924b.appId.equals(str)) {
                                c42924b.state = 2;
                            }
                        }
                        a.aop.notifyChanged();
                    }
                }
            }
            AppMethodBeat.m2505o(136173);
        }
    }

    public DownloadSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(136174);
        this.mContext = context;
        AppMethodBeat.m2505o(136174);
    }

    public DownloadSearchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(136175);
        this.mContext = context;
        AppMethodBeat.m2505o(136175);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(136176);
        C4990ab.m7416i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
        super.onAttachedToWindow();
        C33903a.m55476a(this.kPB);
        AppMethodBeat.m2505o(136176);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(136177);
        C4990ab.m7416i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        C33903a.m55477b(this.kPB);
        AppMethodBeat.m2505o(136177);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(136178);
        super.onFinishInflate();
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.kPy = new C20344a(this.mContext, this);
        setAdapter(this.kPy);
        mo66330a(new C45840c(getResources()));
        this.kPz = C42924b.m76229dD(this.mContext);
        this.kPA = new ArrayList();
        AppMethodBeat.m2505o(136178);
    }

    /* renamed from: IN */
    public final void mo54482IN(String str) {
        AppMethodBeat.m2504i(136179);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136179);
            return;
        }
        C42924b.m76227al(this.mContext, str);
        this.kPz = C42924b.m76229dD(this.mContext);
        AppMethodBeat.m2505o(136179);
    }

    /* Access modifiers changed, original: 0000 */
    public void setData(List<C42924b> list) {
        AppMethodBeat.m2504i(136180);
        C20344a c20344a = this.kPy;
        c20344a.iPr.clear();
        if (!C5046bo.m7548ek(list)) {
            c20344a.iPr.addAll(list);
        }
        c20344a.aop.notifyChanged();
        AppMethodBeat.m2505o(136180);
    }
}
