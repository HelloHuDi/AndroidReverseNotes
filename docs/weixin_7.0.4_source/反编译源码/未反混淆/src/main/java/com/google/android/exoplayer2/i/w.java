package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public final class w {
    public static boolean b(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.i(95976);
        if (c(xmlPullParser) && xmlPullParser.getName().equals(str)) {
            AppMethodBeat.o(95976);
            return true;
        }
        AppMethodBeat.o(95976);
        return false;
    }

    private static boolean c(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(95977);
        if (xmlPullParser.getEventType() == 2) {
            AppMethodBeat.o(95977);
            return true;
        }
        AppMethodBeat.o(95977);
        return false;
    }

    public static String c(XmlPullParser xmlPullParser, String str) {
        AppMethodBeat.i(95978);
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (str.equals(xmlPullParser.getAttributeName(i))) {
                String attributeValue = xmlPullParser.getAttributeValue(i);
                AppMethodBeat.o(95978);
                return attributeValue;
            }
        }
        AppMethodBeat.o(95978);
        return null;
    }
}
