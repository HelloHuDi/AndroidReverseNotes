package android.support.p057v4.content.p062a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.content.a.c */
public final class C0379c {
    /* renamed from: a */
    public static boolean m641a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: a */
    public static float m635a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0379c.m641a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* renamed from: a */
    public static boolean m640a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0379c.m641a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static int m637a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0379c.m641a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: b */
    public static int m642b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0379c.m641a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: a */
    public static int m636a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (C0379c.m641a(xmlPullParser, str)) {
            return typedArray.getResourceId(i, 0);
        }
        return 0;
    }

    /* renamed from: b */
    public static String m643b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (C0379c.m641a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* renamed from: a */
    public static TypedValue m639a(TypedArray typedArray, XmlPullParser xmlPullParser, String str) {
        if (C0379c.m641a(xmlPullParser, str)) {
            return typedArray.peekValue(0);
        }
        return null;
    }

    /* renamed from: a */
    public static TypedArray m638a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
