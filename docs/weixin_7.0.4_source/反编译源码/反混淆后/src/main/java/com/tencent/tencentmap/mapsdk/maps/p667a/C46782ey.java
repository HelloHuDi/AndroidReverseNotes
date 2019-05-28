package com.tencent.tencentmap.mapsdk.maps.p667a;

import java.util.ArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ey */
public abstract class C46782ey implements Cloneable {
    /* renamed from: a */
    ArrayList<Object> f18128a = null;

    /* renamed from: a */
    public C46782ey clone() {
        try {
            C46782ey c46782ey = (C46782ey) super.clone();
            if (this.f18128a != null) {
                ArrayList arrayList = this.f18128a;
                c46782ey.f18128a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c46782ey.f18128a.add(arrayList.get(i));
                }
            }
            return c46782ey;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
