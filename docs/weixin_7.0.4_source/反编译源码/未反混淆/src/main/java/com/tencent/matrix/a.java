package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import java.util.HashSet;
import java.util.Iterator;

public class a {
    private static volatile a bUB;
    public final Application application;
    public final HashSet<b> bUC;
    private final c pluginListener;

    public static class a {
        public final Application application;
        public HashSet<b> bUC = new HashSet();
        public c pluginListener;

        public a(Application application) {
            if (application == null) {
                throw new RuntimeException("matrix init, application is null");
            }
            this.application = application;
        }

        public final a a(b bVar) {
            String tag = bVar.getTag();
            Iterator it = this.bUC.iterator();
            while (it.hasNext()) {
                if (tag.equals(((b) it.next()).getTag())) {
                    throw new RuntimeException(String.format("plugin with tag %s is already exist", new Object[]{tag}));
                }
            }
            this.bUC.add(bVar);
            return this;
        }
    }

    public /* synthetic */ a(Application application, c cVar, HashSet hashSet, byte b) {
        this(application, cVar, hashSet);
    }

    private a(Application application, c cVar, HashSet<b> hashSet) {
        this.application = application;
        this.pluginListener = cVar;
        this.bUC = hashSet;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            bVar.init(this.application, this.pluginListener);
            this.pluginListener.b(bVar);
        }
    }

    public static void a(com.tencent.matrix.d.c.a aVar) {
        com.tencent.matrix.d.c.b(aVar);
    }

    public static boolean isInstalled() {
        return bUB != null;
    }

    public static a a(a aVar) {
        synchronized (a.class) {
            if (bUB == null) {
                bUB = aVar;
            } else {
                com.tencent.matrix.d.c.e("Matrix.Matrix", "Matrix instance is already set. this invoking will be ignored", new Object[0]);
            }
        }
        return bUB;
    }

    public static a yK() {
        if (bUB != null) {
            return bUB;
        }
        throw new RuntimeException("you must init Matrix sdk first");
    }

    public final <T extends b> T F(Class<T> cls) {
        String name = cls.getName();
        Iterator it = this.bUC.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.getClass().getName().equals(name)) {
                return bVar;
            }
        }
        return null;
    }
}
