package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.i.w;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends b {
    private static final Pattern bnD = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern bnE = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern bnF = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern bnG = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final a bnH = new a(30.0f, 1, 1);
    private final XmlPullParserFactory bnI;

    static final class a {
        final float bnJ;
        final int bnK;
        final int tickRate;

        a(float f, int i, int i2) {
            this.bnJ = f;
            this.bnK = i;
            this.tickRate = i2;
        }
    }

    public final /* synthetic */ d c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.i(95678);
        e i2 = i(bArr, i);
        AppMethodBeat.o(95678);
        return i2;
    }

    static {
        AppMethodBeat.i(95679);
        AppMethodBeat.o(95679);
    }

    public a() {
        super("TtmlDecoder");
        AppMethodBeat.i(95670);
        try {
            this.bnI = XmlPullParserFactory.newInstance();
            this.bnI.setNamespaceAware(true);
            AppMethodBeat.o(95670);
        } catch (XmlPullParserException e) {
            RuntimeException runtimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
            AppMethodBeat.o(95670);
            throw runtimeException;
        }
    }

    private e i(byte[] bArr, int i) {
        AppMethodBeat.i(95671);
        try {
            XmlPullParser newPullParser = this.bnI.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new c());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            e eVar = null;
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            a aVar = bnH;
            int i2 = eventType;
            int i3 = 0;
            while (i2 != 1) {
                int parseInt;
                b bVar = (b) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (i2 == 2) {
                        a aVar2;
                        Object obj;
                        if ("tt".equals(name)) {
                            int parseInt2;
                            float parseInt3;
                            int parseInt4;
                            String attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
                            if (attributeValue != null) {
                                parseInt2 = Integer.parseInt(attributeValue);
                            } else {
                                parseInt2 = 30;
                            }
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
                            if (attributeValue != null) {
                                String[] split = attributeValue.split(" ");
                                if (split.length != 2) {
                                    f fVar = new f("frameRateMultiplier doesn't have 2 parts");
                                    AppMethodBeat.o(95671);
                                    throw fVar;
                                }
                                parseInt3 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
                            } else {
                                parseInt3 = 1.0f;
                            }
                            i2 = bnH.bnK;
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
                            if (attributeValue != null) {
                                parseInt = Integer.parseInt(attributeValue);
                            } else {
                                parseInt = i2;
                            }
                            i2 = bnH.tickRate;
                            attributeValue = newPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
                            if (attributeValue != null) {
                                parseInt4 = Integer.parseInt(attributeValue);
                            } else {
                                parseInt4 = i2;
                            }
                            aVar2 = new a(parseInt3 * ((float) parseInt2), parseInt, parseInt4);
                        } else {
                            aVar2 = aVar;
                        }
                        if (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("smpte:image") || name.equals("smpte:data") || name.equals("smpte:information")) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            new StringBuilder("Ignoring unsupported tag: ").append(newPullParser.getName());
                            aVar = aVar2;
                            parseInt = i3 + 1;
                        } else if ("head".equals(name)) {
                            a(newPullParser, hashMap, hashMap2);
                            aVar = aVar2;
                            parseInt = i3;
                        } else {
                            try {
                                b a = a(newPullParser, bVar, hashMap2, aVar2);
                                linkedList.addLast(a);
                                if (bVar != null) {
                                    bVar.a(a);
                                }
                                aVar = aVar2;
                                parseInt = i3;
                            } catch (f e) {
                                aVar = aVar2;
                                parseInt = i3 + 1;
                            }
                        }
                    } else if (i2 == 4) {
                        bVar.a(new b(null, newPullParser.getText().replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX).replaceAll(" *\n *", IOUtils.LINE_SEPARATOR_UNIX).replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, ""));
                        parseInt = i3;
                    } else {
                        e eVar2;
                        if (i2 == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                eVar2 = new e((b) linkedList.getLast(), hashMap, hashMap2);
                            } else {
                                eVar2 = eVar;
                            }
                            linkedList.removeLast();
                        } else {
                            eVar2 = eVar;
                        }
                        parseInt = i3;
                        eVar = eVar2;
                    }
                } else if (i2 == 2) {
                    parseInt = i3 + 1;
                } else if (i2 == 3) {
                    parseInt = i3 - 1;
                } else {
                    parseInt = i3;
                }
                newPullParser.next();
                i2 = newPullParser.getEventType();
                i3 = parseInt;
            }
            AppMethodBeat.o(95671);
            return eVar;
        } catch (XmlPullParserException e2) {
            f fVar2 = new f("Unable to decode source", e2);
            AppMethodBeat.o(95671);
            throw fVar2;
        } catch (IOException e3) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected error when reading input.", e3);
            AppMethodBeat.o(95671);
            throw illegalStateException;
        }
    }

    private static Map<String, d> a(XmlPullParser xmlPullParser, Map<String, d> map, Map<String, c> map2) {
        AppMethodBeat.i(95672);
        Object obj;
        do {
            xmlPullParser.next();
            if (w.b(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                String c = w.c(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                d a = a(xmlPullParser, new d());
                if (c != null) {
                    for (Object obj2 : c.split("\\s+")) {
                        a.b((d) map.get(obj2));
                    }
                }
                if (a.id != null) {
                    map.put(a.id, a);
                }
            } else if (w.b(xmlPullParser, "region")) {
                c b = b(xmlPullParser);
                if (b != null) {
                    map2.put(b.id, b);
                }
            }
            String str = "head";
            if (xmlPullParser.getEventType() == 3) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null || !xmlPullParser.getName().equals(str)) {
                obj2 = null;
                continue;
            } else {
                obj2 = 1;
                continue;
            }
        } while (obj2 == null);
        AppMethodBeat.o(95672);
        return map;
    }

    private static c b(XmlPullParser xmlPullParser) {
        int i = 1;
        c cVar = null;
        AppMethodBeat.i(95673);
        String c = w.c(xmlPullParser, "id");
        if (c == null) {
            AppMethodBeat.o(95673);
            return cVar;
        }
        String c2 = w.c(xmlPullParser, FirebaseAnalytics.b.ORIGIN);
        if (c2 != null) {
            Matcher matcher = bnG.matcher(c2);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String c3 = w.c(xmlPullParser, "extent");
                    if (c3 != null) {
                        Matcher matcher2 = bnG.matcher(c3);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String c4 = w.c(xmlPullParser, "displayAlign");
                                if (c4 != null) {
                                    String aR = v.aR(c4);
                                    int i2 = -1;
                                    switch (aR.hashCode()) {
                                        case -1364013995:
                                            if (aR.equals("center")) {
                                                i2 = 0;
                                                break;
                                            }
                                            break;
                                        case 92734940:
                                            if (aR.equals("after")) {
                                                i2 = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (i2) {
                                        case 0:
                                            parseFloat2 += parseFloat4 / 2.0f;
                                            break;
                                        case 1:
                                            i = 2;
                                            parseFloat2 += parseFloat4;
                                            break;
                                    }
                                }
                                i = 0;
                                cVar = new c(c, parseFloat, parseFloat2, 0, i, parseFloat3);
                                AppMethodBeat.o(95673);
                                return cVar;
                            } catch (NumberFormatException e) {
                                AppMethodBeat.o(95673);
                                return cVar;
                            }
                        }
                        AppMethodBeat.o(95673);
                        return cVar;
                    }
                    AppMethodBeat.o(95673);
                    return cVar;
                } catch (NumberFormatException e2) {
                    AppMethodBeat.o(95673);
                    return cVar;
                }
            }
            AppMethodBeat.o(95673);
            return cVar;
        }
        AppMethodBeat.o(95673);
        return cVar;
    }

    private static d a(XmlPullParser xmlPullParser, d dVar) {
        AppMethodBeat.i(95674);
        int attributeCount = xmlPullParser.getAttributeCount();
        d dVar2 = dVar;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            boolean z = true;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        z = true;
                        break;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        z = true;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        z = true;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals("textDecoration")) {
                        z = true;
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        z = true;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        z = false;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        z = true;
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        z = true;
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        z = true;
                        break;
                    }
                    break;
            }
            d a;
            boolean equalsIgnoreCase;
            int i2;
            switch (z) {
                case false:
                    if (!AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        break;
                    }
                    dVar2 = a(dVar2);
                    dVar2.id = attributeValue;
                    break;
                case true:
                    dVar2 = a(dVar2);
                    try {
                        dVar2.eF(com.google.android.exoplayer2.i.d.aF(attributeValue));
                        break;
                    } catch (IllegalArgumentException e) {
                        break;
                    }
                case true:
                    dVar2 = a(dVar2);
                    try {
                        dVar2.eE(com.google.android.exoplayer2.i.d.aF(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        break;
                    }
                case true:
                    a = a(dVar2);
                    com.google.android.exoplayer2.i.a.checkState(a.bob == null);
                    a.bnS = attributeValue;
                    dVar2 = a;
                    break;
                case true:
                    try {
                        Matcher matcher;
                        dVar2 = a(dVar2);
                        String[] split = attributeValue.split("\\s+");
                        if (split.length == 1) {
                            matcher = bnF.matcher(attributeValue);
                        } else if (split.length == 2) {
                            matcher = bnF.matcher(split[1]);
                        } else {
                            f fVar = new f("Invalid number of entries for fontSize: " + split.length + ".");
                            AppMethodBeat.o(95674);
                            throw fVar;
                        }
                        f fVar2;
                        if (matcher.matches()) {
                            attributeValue = matcher.group(3);
                            z = true;
                            switch (attributeValue.hashCode()) {
                                case g.CTRL_INDEX /*37*/:
                                    if (attributeValue.equals("%")) {
                                        z = true;
                                        break;
                                    }
                                    break;
                                case 3240:
                                    if (attributeValue.equals(UserDataStore.EMAIL)) {
                                        z = true;
                                        break;
                                    }
                                    break;
                                case 3592:
                                    if (attributeValue.equals("px")) {
                                        z = false;
                                        break;
                                    }
                                    break;
                            }
                            switch (z) {
                                case false:
                                    dVar2.boa = 1;
                                    break;
                                case true:
                                    dVar2.boa = 2;
                                    break;
                                case true:
                                    dVar2.boa = 3;
                                    break;
                                default:
                                    fVar2 = new f("Invalid unit for fontSize: '" + attributeValue + "'.");
                                    AppMethodBeat.o(95674);
                                    throw fVar2;
                            }
                            dVar2.fontSize = Float.valueOf(matcher.group(1)).floatValue();
                            break;
                        }
                        fVar2 = new f("Invalid expression for fontSize: '" + attributeValue + "'.");
                        AppMethodBeat.o(95674);
                        throw fVar2;
                    } catch (f e3) {
                        break;
                    }
                case true:
                    a = a(dVar2);
                    equalsIgnoreCase = "bold".equalsIgnoreCase(attributeValue);
                    com.google.android.exoplayer2.i.a.checkState(a.bob == null);
                    if (equalsIgnoreCase) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    a.bnY = i2;
                    dVar2 = a;
                    break;
                case true:
                    a = a(dVar2);
                    equalsIgnoreCase = "italic".equalsIgnoreCase(attributeValue);
                    com.google.android.exoplayer2.i.a.checkState(a.bob == null);
                    if (equalsIgnoreCase) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    a.bnZ = i2;
                    dVar2 = a;
                    break;
                case true:
                    attributeName = v.aR(attributeValue);
                    z = true;
                    switch (attributeName.hashCode()) {
                        case -1364013995:
                            if (attributeName.equals("center")) {
                                z = true;
                                break;
                            }
                            break;
                        case 100571:
                            if (attributeName.equals("end")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3317767:
                            if (attributeName.equals("left")) {
                                z = false;
                                break;
                            }
                            break;
                        case 108511772:
                            if (attributeName.equals("right")) {
                                z = true;
                                break;
                            }
                            break;
                        case 109757538:
                            if (attributeName.equals("start")) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            dVar2 = a(dVar2);
                            dVar2.boc = Alignment.ALIGN_NORMAL;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.boc = Alignment.ALIGN_NORMAL;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.boc = Alignment.ALIGN_OPPOSITE;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.boc = Alignment.ALIGN_OPPOSITE;
                            break;
                        case true:
                            dVar2 = a(dVar2);
                            dVar2.boc = Alignment.ALIGN_CENTER;
                            break;
                        default:
                            break;
                    }
                case true:
                    attributeName = v.aR(attributeValue);
                    z = true;
                    switch (attributeName.hashCode()) {
                        case -1461280213:
                            if (attributeName.equals("nounderline")) {
                                z = true;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (attributeName.equals("underline")) {
                                z = true;
                                break;
                            }
                            break;
                        case 913457136:
                            if (attributeName.equals("nolinethrough")) {
                                z = true;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (attributeName.equals("linethrough")) {
                                z = false;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case false:
                            dVar2 = a(dVar2).aK(true);
                            break;
                        case true:
                            dVar2 = a(dVar2).aK(false);
                            break;
                        case true:
                            dVar2 = a(dVar2).aL(true);
                            break;
                        case true:
                            dVar2 = a(dVar2).aL(false);
                            break;
                        default:
                            break;
                    }
                default:
                    break;
            }
        }
        AppMethodBeat.o(95674);
        return dVar2;
    }

    private static d a(d dVar) {
        AppMethodBeat.i(95675);
        if (dVar == null) {
            dVar = new d();
            AppMethodBeat.o(95675);
            return dVar;
        }
        AppMethodBeat.o(95675);
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static b a(XmlPullParser xmlPullParser, b bVar, Map<String, c> map, a aVar) {
        long j;
        b bVar2;
        AppMethodBeat.i(95676);
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        String str = "";
        String[] strArr = null;
        int attributeCount = xmlPullParser.getAttributeCount();
        d a = a(xmlPullParser, null);
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            Object obj = -1;
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        obj = null;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    j3 = a(attributeValue, aVar);
                    break;
                case 1:
                    j4 = a(attributeValue, aVar);
                    break;
                case 2:
                    j2 = a(attributeValue, aVar);
                    break;
                case 3:
                    String[] split = attributeValue.split("\\s+");
                    if (split.length <= 0) {
                        break;
                    }
                    strArr = split;
                    break;
                case 4:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    }
                    str = attributeValue;
                    break;
                default:
                    break;
            }
        }
        if (!(bVar == null || bVar.bif == -9223372036854775807L)) {
            if (j3 != -9223372036854775807L) {
                j3 += bVar.bif;
            }
            if (j4 != -9223372036854775807L) {
                j = j4 + bVar.bif;
                if (j == -9223372036854775807L) {
                    if (j2 != -9223372036854775807L) {
                        j2 += j3;
                    } else if (!(bVar == null || bVar.big == -9223372036854775807L)) {
                        j2 = bVar.big;
                    }
                    bVar2 = new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
                    AppMethodBeat.o(95676);
                    return bVar2;
                }
                j2 = j;
                bVar2 = new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
                AppMethodBeat.o(95676);
                return bVar2;
            }
        }
        j = j4;
        if (j == -9223372036854775807L) {
        }
        j2 = j;
        bVar2 = new b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
        AppMethodBeat.o(95676);
        return bVar2;
    }

    private static long a(String str, a aVar) {
        double d = 0.0d;
        AppMethodBeat.i(95677);
        Matcher matcher = bnD.matcher(str);
        double parseLong;
        long j;
        if (matcher.matches()) {
            double parseLong2 = ((double) Long.parseLong(matcher.group(3))) + (((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)));
            String group = matcher.group(4);
            parseLong2 += group != null ? Double.parseDouble(group) : 0.0d;
            group = matcher.group(5);
            if (group != null) {
                parseLong = (double) (((float) Long.parseLong(group)) / aVar.bnJ);
            } else {
                parseLong = 0.0d;
            }
            parseLong += parseLong2;
            String group2 = matcher.group(6);
            if (group2 != null) {
                d = (((double) Long.parseLong(group2)) / ((double) aVar.bnK)) / ((double) aVar.bnJ);
            }
            j = (long) ((parseLong + d) * 1000000.0d);
            AppMethodBeat.o(95677);
            return j;
        }
        Matcher matcher2 = bnE.matcher(str);
        if (matcher2.matches()) {
            parseLong = Double.parseDouble(matcher2.group(1));
            String group3 = matcher2.group(2);
            int i = -1;
            switch (group3.hashCode()) {
                case 102:
                    if (group3.equals("f")) {
                        i = 4;
                        break;
                    }
                    break;
                case 104:
                    if (group3.equals("h")) {
                        i = 0;
                        break;
                    }
                    break;
                case 109:
                    if (group3.equals("m")) {
                        i = 1;
                        break;
                    }
                    break;
                case 115:
                    if (group3.equals("s")) {
                        i = 2;
                        break;
                    }
                    break;
                case 116:
                    if (group3.equals("t")) {
                        i = 5;
                        break;
                    }
                    break;
                case 3494:
                    if (group3.equals("ms")) {
                        i = 3;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    parseLong *= 3600.0d;
                    break;
                case 1:
                    parseLong *= 60.0d;
                    break;
                case 3:
                    parseLong /= 1000.0d;
                    break;
                case 4:
                    parseLong /= (double) aVar.bnJ;
                    break;
                case 5:
                    parseLong /= (double) aVar.tickRate;
                    break;
            }
            j = (long) (parseLong * 1000000.0d);
            AppMethodBeat.o(95677);
            return j;
        }
        f fVar = new f("Malformed time expression: ".concat(String.valueOf(str)));
        AppMethodBeat.o(95677);
        throw fVar;
    }
}
