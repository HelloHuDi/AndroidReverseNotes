package com.google.firebase.components;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k {
    public final m bvb;
    public final Context mContext;

    public k(Context context) {
        this(context, new l());
        AppMethodBeat.i(10615);
        AppMethodBeat.o(10615);
    }

    private k(Context context, m mVar) {
        this.mContext = context;
        this.bvb = mVar;
    }

    public static List<e> A(List<String> list) {
        AppMethodBeat.i(10616);
        ArrayList arrayList = new ArrayList();
        for (String cls : list) {
            try {
                Class cls2 = Class.forName(cls);
                if (e.class.isAssignableFrom(cls2)) {
                    arrayList.add((e) cls2.newInstance());
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
        AppMethodBeat.o(10616);
        return arrayList;
    }
}
