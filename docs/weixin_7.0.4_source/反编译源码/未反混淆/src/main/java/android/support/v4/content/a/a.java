package android.support.v4.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {

    public interface a {
    }

    public static final class c {
        public int GO;
        public boolean GP;
        public int GQ;
        public final String mFileName;

        public c(String str, int i, boolean z, int i2) {
            this.mFileName = str;
            this.GO = i;
            this.GP = z;
            this.GQ = i2;
        }
    }

    public static final class b implements a {
        public final c[] GN;

        public b(c[] cVarArr) {
            this.GN = cVarArr;
        }
    }

    public static final class d implements a {
        public final android.support.v4.d.a GR;
        public final int GS;
        public final int GU;

        public d(android.support.v4.d.a aVar, int i, int i2) {
            this.GR = aVar;
            this.GU = i;
            this.GS = i2;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
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
            return b(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), android.support.a.a.a.FontFamily);
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
                        arrayList.add(c(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new d(new android.support.v4.d.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
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
                        arrayList.add(b(resources.getStringArray(obtainTypedArray.getResourceId(i2, 0))));
                    }
                    list = arrayList;
                } else {
                    arrayList.add(b(resources.getStringArray(i)));
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

    private static List<byte[]> b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static c c(XmlPullParser xmlPullParser, Resources resources) {
        int i = 5;
        boolean z = true;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), android.support.a.a.a.FontFamilyFont);
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
            a(xmlPullParser);
        }
        return new c(string, i2, z, resourceId);
    }

    private static void a(XmlPullParser xmlPullParser) {
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
