package com.google.android.exoplayer2.p111i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.exoplayer2.i.w */
public final class C17677w {
    /* renamed from: b */
    public static boolean m27580b(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.m2504i(95976);
        if (C17677w.m27582c(xmlPullParser) && xmlPullParser.getName().equals(str)) {
            AppMethodBeat.m2505o(95976);
            return true;
        }
        AppMethodBeat.m2505o(95976);
        return false;
    }

    /* renamed from: c */
    private static boolean m27582c(XmlPullParser xmlPullParser) {
        AppMethodBeat.m2504i(95977);
        if (xmlPullParser.getEventType() == 2) {
            AppMethodBeat.m2505o(95977);
            return true;
        }
        AppMethodBeat.m2505o(95977);
        return false;
    }

    /* renamed from: c */
    public static String m27581c(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.m2504i(95978);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                AppMethodBeat.m2505o(95978);
                return attributeValue;
            }
        }
        AppMethodBeat.m2505o(95978);
        return null;
    }
}
