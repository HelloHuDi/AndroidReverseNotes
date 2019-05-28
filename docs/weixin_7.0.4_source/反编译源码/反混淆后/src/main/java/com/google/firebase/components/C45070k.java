package com.google.firebase.components;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.firebase.components.k */
public final class C45070k {
    public final C45071m bvb;
    public final Context mContext;

    public C45070k(Context context) {
        this(context, new C37302l());
        AppMethodBeat.m2504i(10615);
        AppMethodBeat.m2505o(10615);
    }

    private C45070k(Context context, C45071m c45071m) {
        this.mContext = context;
        this.bvb = c45071m;
    }

    /* renamed from: A */
    public static List<C41648e> m82695A(List<String> list) {
        AppMethodBeat.m2504i(10616);
        ArrayList arrayList = new ArrayList();
        for (String cls : list) {
            try {
                Class cls2 = Class.forName(cls);
                if (C41648e.class.isAssignableFrom(cls2)) {
                    arrayList.add((C41648e) cls2.newInstance());
                } else {
                    String.format("Class %s is not an instance of %s", new Object[]{cls, "com.google.firebase.components.ComponentRegistrar"});
                }
            } catch (ClassNotFoundException e) {
                String.format("Class %s is not an found.", new Object[]{cls});
            } catch (IllegalAccessException e2) {
                String.format("Could not instantiate %s.", new Object[]{cls});
            } catch (InstantiationException e3) {
                String.format("Could not instantiate %s.", new Object[]{cls});
            }
        }
        AppMethodBeat.m2505o(10616);
        return arrayList;
    }
}
