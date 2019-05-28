package com.tencent.p177mm.plugin.topstory.p541ui.video;

import android.support.p057v4.p065f.C0418n;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.view.View;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.topstory.ui.video.e */
public abstract class C4233e extends C41523a<C46927h> {
    protected C0418n<View> sDl = new C0418n();
    protected C0418n<View> sDm = new C0418n();
    public Map<chw, C46927h> sDn = new HashMap();
    public C4232b sDo;

    public C4233e(C4232b c4232b) {
        this.sDo = c4232b;
    }

    public final int getItemCount() {
        return (this.sDo.cGg().cGR() + this.sDl.size()) + this.sDm.size();
    }

    public final int getHeadersCount() {
        return this.sDl.size();
    }

    public final int getFootersCount() {
        return this.sDm.size();
    }

    public final int getItemViewType(int i) {
        if (mo9197FH(i)) {
            return this.sDl.keyAt(i);
        }
        if (mo9198FI(i)) {
            return this.sDm.keyAt((i - this.sDl.size()) - this.sDo.cGg().cGR());
        }
        return mo9196FG(i);
    }

    /* renamed from: FG */
    public int mo9196FG(int i) {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: j */
    public void mo9205j(List<chw> list, boolean z) {
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", Integer.valueOf(list.size()), Boolean.valueOf(z));
    }

    public final void addHeaderView(View view) {
        this.sDl.put(this.sDl.size() + 100000, view);
    }

    /* renamed from: ei */
    public final void mo9202ei(View view) {
        this.sDm.put(this.sDm.size() + 200000, view);
    }

    public final void cGm() {
        this.sDm.clear();
    }

    /* renamed from: b */
    public final C46927h mo9200b(chw chw) {
        if (this.sDn.containsKey(chw)) {
            C46927h c46927h = (C46927h) this.sDn.get(chw);
            if (c46927h != null && c46927h.sAX != null && c46927h.sAX == chw) {
                return c46927h;
            }
            this.sDn.remove(chw);
            C4990ab.m7416i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
        }
        return null;
    }

    /* renamed from: FH */
    public final boolean mo9197FH(int i) {
        return i < this.sDl.size();
    }

    /* renamed from: FI */
    public final boolean mo9198FI(int i) {
        return i >= this.sDl.size() + this.sDo.cGg().cGR();
    }
}
