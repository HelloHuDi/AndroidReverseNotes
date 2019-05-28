package android.support.v4.content.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.a.d;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class b {

    public static abstract class a {
        public abstract void b(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public final void run() {
                    a.this.b(typeface);
                }
            });
        }

        public final void a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public final void run() {
                }
            });
        }
    }

    public static Drawable b(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = a(context, resources, typedValue, i, i2, aVar);
        if (a != null || aVar != null) {
            return a;
        }
        throw new NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    private static Typeface a(Context context, Resources resources, TypedValue typedValue, int i, int i2, a aVar) {
        if (typedValue.string == null) {
            throw new NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (charSequence.startsWith("res/")) {
            Typeface a = d.a(resources, i, i2);
            if (a == null) {
                try {
                    if (charSequence.toLowerCase().endsWith(".xml")) {
                        android.support.v4.content.a.a.a a2 = a.a(resources.getXml(i), resources);
                        if (a2 != null) {
                            return d.a(context, a2, resources, i, i2, aVar);
                        }
                        if (aVar != null) {
                            aVar.a(-3, null);
                        }
                        return null;
                    }
                    a = d.a(context, resources, i, charSequence, i2);
                    if (aVar == null) {
                        return a;
                    }
                    if (a != null) {
                        aVar.a(a, null);
                        return a;
                    }
                    aVar.a(-3, null);
                    return a;
                } catch (IOException | XmlPullParserException e) {
                    if (aVar != null) {
                        aVar.a(-3, null);
                    }
                    return null;
                }
            } else if (aVar == null) {
                return a;
            } else {
                aVar.a(a, null);
                return a;
            }
        }
        if (aVar != null) {
            aVar.a(-3, null);
        }
        return null;
    }
}
