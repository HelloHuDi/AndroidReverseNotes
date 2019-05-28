package com.tencent.tencentmap.mapsdk.maps.a;

import java.util.ArrayList;

public abstract class ey implements Cloneable {
    ArrayList<Object> a = null;

    /* renamed from: a */
    public ey clone() {
        try {
            ey eyVar = (ey) super.clone();
            if (this.a != null) {
                ArrayList arrayList = this.a;
                eyVar.a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    eyVar.a.add(arrayList.get(i));
                }
            }
            return eyVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
