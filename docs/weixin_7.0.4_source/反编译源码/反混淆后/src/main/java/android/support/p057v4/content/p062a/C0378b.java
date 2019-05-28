package android.support.p057v4.content.p062a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.p057v4.content.p062a.C0372a.C0370a;
import android.support.p057v4.p058a.C0289d;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.content.a.b */
public final class C0378b {

    /* renamed from: android.support.v4.content.a.b$a */
    public static abstract class C0377a {
        /* renamed from: b */
        public abstract void mo664b(Typeface typeface);

        /* renamed from: a */
        public final void mo663a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public final void run() {
                    C0377a.this.mo664b(typeface);
                }
            });
        }

        /* renamed from: a */
        public final void mo662a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() {
                public final void run() {
                }
            });
        }
    }

    /* renamed from: b */
    public static Drawable m634b(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    /* renamed from: a */
    public static Typeface m632a(Context context, int i, TypedValue typedValue, int i2, C0377a c0377a) {
        if (context.isRestricted()) {
            return null;
        }
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface a = C0378b.m633a(context, resources, typedValue, i, i2, c0377a);
        if (a != null || c0377a != null) {
            return a;
        }
        throw new NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* renamed from: a */
    private static Typeface m633a(Context context, Resources resources, TypedValue typedValue, int i, int i2, C0377a c0377a) {
        if (typedValue.string == null) {
            throw new NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String charSequence = typedValue.string.toString();
        if (charSequence.startsWith("res/")) {
            Typeface a = C0289d.m499a(resources, i, i2);
            if (a == null) {
                try {
                    if (charSequence.toLowerCase().endsWith(".xml")) {
                        C0370a a2 = C0372a.m623a(resources.getXml(i), resources);
                        if (a2 != null) {
                            return C0289d.m497a(context, a2, resources, i, i2, c0377a);
                        }
                        if (c0377a != null) {
                            c0377a.mo662a(-3, null);
                        }
                        return null;
                    }
                    a = C0289d.m496a(context, resources, i, charSequence, i2);
                    if (c0377a == null) {
                        return a;
                    }
                    if (a != null) {
                        c0377a.mo663a(a, null);
                        return a;
                    }
                    c0377a.mo662a(-3, null);
                    return a;
                } catch (IOException | XmlPullParserException e) {
                    if (c0377a != null) {
                        c0377a.mo662a(-3, null);
                    }
                    return null;
                }
            } else if (c0377a == null) {
                return a;
            } else {
                c0377a.mo663a(a, null);
                return a;
            }
        }
        if (c0377a != null) {
            c0377a.mo662a(-3, null);
        }
        return null;
    }
}
