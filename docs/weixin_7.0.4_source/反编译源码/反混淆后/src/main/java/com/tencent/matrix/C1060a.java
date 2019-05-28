package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.p155b.C1061c;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.p157d.C1070c.C1069a;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.matrix.a */
public class C1060a {
    private static volatile C1060a bUB;
    public final Application application;
    public final HashSet<C6283b> bUC;
    private final C1061c pluginListener;

    /* renamed from: com.tencent.matrix.a$a */
    public static class C1023a {
        public final Application application;
        public HashSet<C6283b> bUC = new HashSet();
        public C1061c pluginListener;

        public C1023a(Application application) {
            if (application == null) {
                throw new RuntimeException("matrix init, application is null");
            }
            this.application = application;
        }

        /* renamed from: a */
        public final C1023a mo4159a(C6283b c6283b) {
            String tag = c6283b.getTag();
            Iterator it = this.bUC.iterator();
            while (it.hasNext()) {
                if (tag.equals(((C6283b) it.next()).getTag())) {
                    throw new RuntimeException(String.format("plugin with tag %s is already exist", new Object[]{tag}));
                }
            }
            this.bUC.add(c6283b);
            return this;
        }
    }

    public /* synthetic */ C1060a(Application application, C1061c c1061c, HashSet hashSet, byte b) {
        this(application, c1061c, hashSet);
    }

    private C1060a(Application application, C1061c c1061c, HashSet<C6283b> hashSet) {
        this.application = application;
        this.pluginListener = c1061c;
        this.bUC = hashSet;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            C6283b c6283b = (C6283b) it.next();
            c6283b.init(this.application, this.pluginListener);
            this.pluginListener.mo4194b(c6283b);
        }
    }

    /* renamed from: a */
    public static void m2338a(C1069a c1069a) {
        C1070c.m2365b(c1069a);
    }

    public static boolean isInstalled() {
        return bUB != null;
    }

    /* renamed from: a */
    public static C1060a m2337a(C1060a c1060a) {
        synchronized (C1060a.class) {
            if (bUB == null) {
                bUB = c1060a;
            } else {
                C1070c.m2367e("Matrix.Matrix", "Matrix instance is already set. this invoking will be ignored", new Object[0]);
            }
        }
        return bUB;
    }

    /* renamed from: yK */
    public static C1060a m2339yK() {
        if (bUB != null) {
            return bUB;
        }
        throw new RuntimeException("you must init Matrix sdk first");
    }

    /* renamed from: F */
    public final <T extends C6283b> T mo4192F(Class<T> cls) {
        String name = cls.getName();
        Iterator it = this.bUC.iterator();
        while (it.hasNext()) {
            C6283b c6283b = (C6283b) it.next();
            if (c6283b.getClass().getName().equals(name)) {
                return c6283b;
            }
        }
        return null;
    }
}
