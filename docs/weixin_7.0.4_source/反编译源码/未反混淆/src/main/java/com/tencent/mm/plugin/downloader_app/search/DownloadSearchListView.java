package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadSearchListView extends MRecyclerView {
    List<b> kPA;
    private b kPB = new b() {
        public final void E(int i, long j) {
            AppMethodBeat.i(136173);
            if (i == 9) {
                a hv = c.hv(j);
                if (hv != null) {
                    a a = DownloadSearchListView.this.kPy;
                    String str = hv.field_appId;
                    if (!(bo.ek(a.iPr) || bo.isNullOrNil(str))) {
                        Iterator it = a.iPr.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            if (bVar.appId != null && bVar.appId.equals(str)) {
                                bVar.state = 2;
                            }
                        }
                        a.aop.notifyChanged();
                    }
                }
            }
            AppMethodBeat.o(136173);
        }
    };
    a kPy;
    List<b> kPz;
    Context mContext;

    public DownloadSearchListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(136174);
        this.mContext = context;
        AppMethodBeat.o(136174);
    }

    public DownloadSearchListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(136175);
        this.mContext = context;
        AppMethodBeat.o(136175);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(136176);
        ab.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
        super.onAttachedToWindow();
        com.tencent.mm.plugin.downloader.b.a.a(this.kPB);
        AppMethodBeat.o(136176);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(136177);
        ab.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
        super.onDetachedFromWindow();
        com.tencent.mm.plugin.downloader.b.a.b(this.kPB);
        AppMethodBeat.o(136177);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(136178);
        super.onFinishInflate();
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.kPy = new a(this.mContext, this);
        setAdapter(this.kPy);
        a(new c(getResources()));
        this.kPz = b.dD(this.mContext);
        this.kPA = new ArrayList();
        AppMethodBeat.o(136178);
    }

    public final void IN(String str) {
        AppMethodBeat.i(136179);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136179);
            return;
        }
        b.al(this.mContext, str);
        this.kPz = b.dD(this.mContext);
        AppMethodBeat.o(136179);
    }

    /* Access modifiers changed, original: 0000 */
    public void setData(List<b> list) {
        AppMethodBeat.i(136180);
        a aVar = this.kPy;
        aVar.iPr.clear();
        if (!bo.ek(list)) {
            aVar.iPr.addAll(list);
        }
        aVar.aop.notifyChanged();
        AppMethodBeat.o(136180);
    }
}
