package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class ae implements Iterable<Intent> {
    private static final c Ge;
    public final ArrayList<Intent> Gf = new ArrayList();
    public final Context Gg;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    static class c {
        c() {
        }
    }

    static class b extends c {
        b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            Ge = new b();
        } else {
            Ge = new c();
        }
    }

    private ae(Context context) {
        this.Gg = context;
    }

    public static ae N(Context context) {
        return new ae(context);
    }

    public final ae a(ComponentName componentName) {
        int size = this.Gf.size();
        try {
            Object a = t.a(this.Gg, componentName);
            while (a != null) {
                this.Gf.add(size, a);
                a = t.a(this.Gg, a.getComponent());
            }
            return this;
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.Gf.iterator();
    }
}
