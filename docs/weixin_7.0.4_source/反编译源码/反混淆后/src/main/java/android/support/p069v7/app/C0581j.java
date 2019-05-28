package android.support.p069v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.p057v4.p065f.C6197a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: android.support.v7.app.j */
public class C0581j {
    /* renamed from: VT */
    private static final Class<?>[] f878VT = new Class[]{Context.class, AttributeSet.class};
    /* renamed from: VU */
    static final int[] f879VU = new int[]{16843375};
    /* renamed from: VV */
    private static final String[] f880VV = new String[]{"android.widget.", "android.view.", "android.webkit."};
    /* renamed from: VW */
    private static final Map<String, Constructor<? extends View>> f881VW = new C6197a();
    /* renamed from: VX */
    private final Object[] f882VX = new Object[2];

    /* renamed from: android.support.v7.app.j$a */
    static class C0580a implements OnClickListener {
        /* renamed from: VY */
        private final View f874VY;
        /* renamed from: VZ */
        private final String f875VZ;
        /* renamed from: Wa */
        private Method f876Wa;
        /* renamed from: Wb */
        private Context f877Wb;

        public C0580a(View view, String str) {
            this.f874VY = view;
            this.f875VZ = str;
        }

        public final void onClick(View view) {
            if (this.f876Wa == null) {
                String str;
                Context context = this.f874VY.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted()) {
                            Method method = context.getClass().getMethod(this.f875VZ, new Class[]{View.class});
                            if (method != null) {
                                this.f876Wa = method;
                                this.f877Wb = context;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                    }
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        context = null;
                    }
                }
                int id = this.f874VY.getId();
                if (id == -1) {
                    str = "";
                } else {
                    str = " with id '" + this.f874VY.getContext().getResources().getResourceEntryName(id) + "'";
                }
                throw new IllegalStateException("Could not find method " + this.f875VZ + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f874VY.getClass() + str);
            }
            try {
                this.f876Wa.invoke(this.f877Wb, new Object[]{view});
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final View mo1424a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f882VX[0] = context;
            this.f882VX[1] = attributeSet;
            View c;
            if (-1 == str.indexOf(46)) {
                for (String c2 : f880VV) {
                    c = m1260c(context, str, c2);
                    if (c != null) {
                        return c;
                    }
                }
                this.f882VX[0] = null;
                this.f882VX[1] = null;
                return null;
            }
            c = m1260c(context, str, null);
            this.f882VX[0] = null;
            this.f882VX[1] = null;
            return c;
        } catch (Exception e) {
            return null;
        } finally {
            this.f882VX[0] = null;
            this.f882VX[1] = null;
            return null;
        }
    }

    /* renamed from: c */
    private View m1260c(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f881VW.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f878VT);
                f881VW.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f882VX);
    }
}
