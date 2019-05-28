package com.tencent.p177mm.plugin.sns.p520ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.previewimageview.a */
public abstract class C35140a extends BaseAdapter implements C13706d {
    private int rKI = 0;
    HashMap<Object, Integer> rKJ = new HashMap();

    public final boolean hasStableIds() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cq */
    public final void mo55765cq(Object obj) {
        HashMap hashMap = this.rKJ;
        int i = this.rKI;
        this.rKI = i + 1;
        hashMap.put(obj, Integer.valueOf(i));
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: dx */
    public final void mo55766dx(List<?> list) {
        for (Object cq : list) {
            mo55765cq(cq);
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.rKJ.size()) {
            return -1;
        }
        return (long) ((Integer) this.rKJ.get(getItem(i))).intValue();
    }
}
