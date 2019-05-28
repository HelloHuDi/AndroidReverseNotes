package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;

public abstract class a extends BaseAdapter implements d {
    private int rKI = 0;
    HashMap<Object, Integer> rKJ = new HashMap();

    public final boolean hasStableIds() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cq(Object obj) {
        HashMap hashMap = this.rKJ;
        int i = this.rKI;
        this.rKI = i + 1;
        hashMap.put(obj, Integer.valueOf(i));
    }

    /* Access modifiers changed, original: protected|final */
    public final void dx(List<?> list) {
        for (Object cq : list) {
            cq(cq);
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.rKJ.size()) {
            return -1;
        }
        return (long) ((Integer) this.rKJ.get(getItem(i))).intValue();
    }
}
