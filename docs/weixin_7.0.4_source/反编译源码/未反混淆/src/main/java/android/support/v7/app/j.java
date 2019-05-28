package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class j {
    private static final Class<?>[] VT = new Class[]{Context.class, AttributeSet.class};
    static final int[] VU = new int[]{16843375};
    private static final String[] VV = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> VW = new android.support.v4.f.a();
    private final Object[] VX = new Object[2];

    static class a implements OnClickListener {
        private final View VY;
        private final String VZ;
        private Method Wa;
        private Context Wb;

        public a(View view, String str) {
            this.VY = view;
            this.VZ = str;
        }

        public final void onClick(View view) {
            if (this.Wa == null) {
                String str;
                Context context = this.VY.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted()) {
                            Method method = context.getClass().getMethod(this.VZ, new Class[]{View.class});
                            if (method != null) {
                                this.Wa = method;
                                this.Wb = context;
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
                int id = this.VY.getId();
                if (id == -1) {
                    str = "";
                } else {
                    str = " with id '" + this.VY.getContext().getResources().getResourceEntryName(id) + "'";
                }
                throw new IllegalStateException("Could not find method " + this.VZ + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.VY.getClass() + str);
            }
            try {
                this.Wa.invoke(this.Wb, new Object[]{view});
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.VX[0] = context;
            this.VX[1] = attributeSet;
            View c;
            if (-1 == str.indexOf(46)) {
                for (String c2 : VV) {
                    c = c(context, str, c2);
                    if (c != null) {
                        return c;
                    }
                }
                this.VX[0] = null;
                this.VX[1] = null;
                return null;
            }
            c = c(context, str, null);
            this.VX[0] = null;
            this.VX[1] = null;
            return c;
        } catch (Exception e) {
            return null;
        } finally {
            this.VX[0] = null;
            this.VX[1] = null;
            return null;
        }
    }

    private View c(Context context, String str, String str2) {
        Constructor constructor = (Constructor) VW.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(VT);
                VW.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.VX);
    }
}
