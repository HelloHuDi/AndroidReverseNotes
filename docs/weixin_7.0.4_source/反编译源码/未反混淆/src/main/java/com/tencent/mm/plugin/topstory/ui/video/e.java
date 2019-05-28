package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.f.n;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e extends a<h> {
    protected n<View> sDl = new n();
    protected n<View> sDm = new n();
    public Map<chw, h> sDn = new HashMap();
    public b sDo;

    public e(b bVar) {
        this.sDo = bVar;
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
        if (FH(i)) {
            return this.sDl.keyAt(i);
        }
        if (FI(i)) {
            return this.sDm.keyAt((i - this.sDl.size()) - this.sDo.cGg().cGR());
        }
        return FG(i);
    }

    public int FG(int i) {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public void j(List<chw> list, boolean z) {
        ab.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", Integer.valueOf(list.size()), Boolean.valueOf(z));
    }

    public final void addHeaderView(View view) {
        this.sDl.put(this.sDl.size() + 100000, view);
    }

    public final void ei(View view) {
        this.sDm.put(this.sDm.size() + 200000, view);
    }

    public final void cGm() {
        this.sDm.clear();
    }

    public final h b(chw chw) {
        if (this.sDn.containsKey(chw)) {
            h hVar = (h) this.sDn.get(chw);
            if (hVar != null && hVar.sAX != null && hVar.sAX == chw) {
                return hVar;
            }
            this.sDn.remove(chw);
            ab.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
        }
        return null;
    }

    public final boolean FH(int i) {
        return i < this.sDl.size();
    }

    public final boolean FI(int i) {
        return i >= this.sDl.size() + this.sDo.cGg().cGR();
    }
}
