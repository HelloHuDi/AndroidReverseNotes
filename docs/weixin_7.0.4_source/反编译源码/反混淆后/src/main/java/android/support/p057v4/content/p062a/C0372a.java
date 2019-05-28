package android.support.p057v4.content.p062a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.p053a.C0229a.C0228a;
import android.support.p057v4.p063d.C0385a;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v4.content.a.a */
public final class C0372a {

    /* renamed from: android.support.v4.content.a.a$a */
    public interface C0370a {
    }

    /* renamed from: android.support.v4.content.a.a$c */
    public static final class C0371c {
        /* renamed from: GO */
        public int f417GO;
        /* renamed from: GP */
        public boolean f418GP;
        /* renamed from: GQ */
        public int f419GQ;
        public final String mFileName;

        public C0371c(String str, int i, boolean z, int i2) {
            this.mFileName = str;
            this.f417GO = i;
            this.f418GP = z;
            this.f419GQ = i2;
        }
    }

    /* renamed from: android.support.v4.content.a.a$b */
    public static final class C0373b implements C0370a {
        /* renamed from: GN */
        public final C0371c[] f420GN;

        public C0373b(C0371c[] c0371cArr) {
            this.f420GN = c0371cArr;
        }
    }

    /* renamed from: android.support.v4.content.a.a$d */
    public static final class C0374d implements C0370a {
        /* renamed from: GR */
        public final C0385a f421GR;
        /* renamed from: GS */
        public final int f422GS;
        /* renamed from: GU */
        public final int f423GU;

        public C0374d(C0385a c0385a, int i, int i2) {
            this.f421GR = c0385a;
            this.f423GU = i;
            this.f422GS = i2;
        }
    }

    /* renamed from: a */
    public static C0370a m623a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return C0372a.m626b(xmlPullParser, resources);
        }
        C0372a.m625a(xmlPullParser);
        return null;
    }

    /* renamed from: b */
    private static C0370a m626b(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0228a.FontFamily);
        String string = obtainAttributes.getString(0);
        String string2 = obtainAttributes.getString(1);
        String string3 = obtainAttributes.getString(2);
        int resourceId = obtainAttributes.getResourceId(3, 0);
        int integer = obtainAttributes.getInteger(4, 1);
        int integer2 = obtainAttributes.getInteger(5, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(C0372a.m628c(xmlPullParser, resources));
                    } else {
                        C0372a.m625a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new C0373b((C0371c[]) arrayList.toArray(new C0371c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            C0372a.m625a(xmlPullParser);
        }
        return new C0374d(new C0385a(string, string2, string3, C0372a.m624a(resources, resourceId)), integer, integer2);
    }

    /* renamed from: a */
    public static List<List<byte[]>> m624a(Resources resources, int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                int i2;
                ArrayList arrayList = new ArrayList();
                if (obtainTypedArray.getResourceId(0, 0) != 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i2 != 0) {
                    for (i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        arrayList.add(C0372a.m627b(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                    list = arrayList;
                } else {
                    arrayList.add(C0372a.m627b(resources.getStringArray(i)));
                    Object obj = arrayList;
                }
            }
            obtainTypedArray.recycle();
        }
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    /* renamed from: b */
    private static List<byte[]> m627b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    /* renamed from: c */
    private static C0371c m628c(XmlPullParser xmlPullParser, Resources resources) {
        int i = 5;
        boolean z = true;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0228a.FontFamilyFont);
        if (!obtainAttributes.hasValue(5)) {
            i = 1;
        }
        int i2 = obtainAttributes.getInt(i, 400);
        if (1 != obtainAttributes.getInt(obtainAttributes.hasValue(3) ? 3 : 2, 0)) {
            z = false;
        }
        if (obtainAttributes.hasValue(4)) {
            i = 4;
        } else {
            i = 0;
        }
        int resourceId = obtainAttributes.getResourceId(i, 0);
        String string = obtainAttributes.getString(i);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            C0372a.m625a(xmlPullParser);
        }
        return new C0371c(string, i2, z, resourceId);
    }

    /* renamed from: a */
    private static void m625a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }
}
