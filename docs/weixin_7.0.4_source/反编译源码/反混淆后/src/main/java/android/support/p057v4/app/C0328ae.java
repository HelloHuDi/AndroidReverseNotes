package android.support.p057v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.app.ae */
public final class C0328ae implements Iterable<Intent> {
    /* renamed from: Ge */
    private static final C0327c f282Ge;
    /* renamed from: Gf */
    public final ArrayList<Intent> f283Gf = new ArrayList();
    /* renamed from: Gg */
    public final Context f284Gg;

    /* renamed from: android.support.v4.app.ae$a */
    public interface C0326a {
        Intent getSupportParentActivityIntent();
    }

    /* renamed from: android.support.v4.app.ae$c */
    static class C0327c {
        C0327c() {
        }
    }

    /* renamed from: android.support.v4.app.ae$b */
    static class C0329b extends C0327c {
        C0329b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f282Ge = new C0329b();
        } else {
            f282Ge = new C0327c();
        }
    }

    private C0328ae(Context context) {
        this.f284Gg = context;
    }

    /* renamed from: N */
    public static C0328ae m518N(Context context) {
        return new C0328ae(context);
    }

    /* renamed from: a */
    public final C0328ae mo519a(ComponentName componentName) {
        int size = this.f283Gf.size();
        try {
            Object a = C0355t.m582a(this.f284Gg, componentName);
            while (a != null) {
                this.f283Gf.add(size, a);
                a = C0355t.m582a(this.f284Gg, a.getComponent());
            }
            return this;
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f283Gf.iterator();
    }
}
