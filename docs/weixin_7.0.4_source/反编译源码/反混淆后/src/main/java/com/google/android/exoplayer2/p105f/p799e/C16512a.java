package com.google.android.exoplayer2.p105f.p799e;

import android.text.Layout.Alignment;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C41607f;
import com.google.android.exoplayer2.p105f.C8672b;
import com.google.android.exoplayer2.p111i.C0871d;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C17677w;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
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

/* renamed from: com.google.android.exoplayer2.f.e.a */
public final class C16512a extends C8672b {
    private static final Pattern bnD = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern bnE = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern bnF = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    private static final Pattern bnG = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final C16513a bnH = new C16513a(30.0f, 1, 1);
    private final XmlPullParserFactory bnI;

    /* renamed from: com.google.android.exoplayer2.f.e.a$a */
    static final class C16513a {
        final float bnJ;
        final int bnK;
        final int tickRate;

        C16513a(float f, int i, int i2) {
            this.bnJ = f;
            this.bnK = i;
            this.tickRate = i2;
        }
    }

    /* renamed from: c */
    public final /* synthetic */ C17659d mo2574c(byte[] bArr, int i, boolean z) {
        AppMethodBeat.m2504i(95678);
        C45032e i2 = m25343i(bArr, i);
        AppMethodBeat.m2505o(95678);
        return i2;
    }

    static {
        AppMethodBeat.m2504i(95679);
        AppMethodBeat.m2505o(95679);
    }

    public C16512a() {
        super("TtmlDecoder");
        AppMethodBeat.m2504i(95670);
        try {
            this.bnI = XmlPullParserFactory.newInstance();
            this.bnI.setNamespaceAware(true);
            AppMethodBeat.m2505o(95670);
        } catch (XmlPullParserException e) {
            RuntimeException runtimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
            AppMethodBeat.m2505o(95670);
            throw runtimeException;
        }
    }

    /* renamed from: i */
    private C45032e m25343i(byte[] bArr, int i) {
        AppMethodBeat.m2504i(95671);
        try {
            XmlPullParser newPullParser = this.bnI.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new C8673c());
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            C45032e c45032e = null;
            LinkedList linkedList = new LinkedList();
            int eventType = newPullParser.getEventType();
            C16513a c16513a = bnH;
            int i2 = eventType;
            int i3 = 0;
            while (i2 != 1) {
                int parseInt;
                C25535b c25535b = (C25535b) linkedList.peekLast();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (i2 == 2) {
                        C16513a c16513a2;
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
                                    C41607f c41607f = new C41607f("frameRateMultiplier doesn't have 2 parts");
                                    AppMethodBeat.m2505o(95671);
                                    throw c41607f;
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
                            c16513a2 = new C16513a(parseInt3 * ((float) parseInt2), parseInt, parseInt4);
                        } else {
                            c16513a2 = c16513a;
                        }
                        if (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("smpte:image") || name.equals("smpte:data") || name.equals("smpte:information")) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            new StringBuilder("Ignoring unsupported tag: ").append(newPullParser.getName());
                            c16513a = c16513a2;
                            parseInt = i3 + 1;
                        } else if ("head".equals(name)) {
                            C16512a.m25341a(newPullParser, hashMap, hashMap2);
                            c16513a = c16513a2;
                            parseInt = i3;
                        } else {
                            try {
                                C25535b a = C16512a.m25338a(newPullParser, c25535b, hashMap2, c16513a2);
                                linkedList.addLast(a);
                                if (c25535b != null) {
                                    c25535b.mo42789a(a);
                                }
                                c16513a = c16513a2;
                                parseInt = i3;
                            } catch (C41607f e) {
                                c16513a = c16513a2;
                                parseInt = i3 + 1;
                            }
                        }
                    } else if (i2 == 4) {
                        c25535b.mo42789a(new C25535b(null, newPullParser.getText().replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX).replaceAll(" *\n *", IOUtils.LINE_SEPARATOR_UNIX).replaceAll(IOUtils.LINE_SEPARATOR_UNIX, " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, ""));
                        parseInt = i3;
                    } else {
                        C45032e c45032e2;
                        if (i2 == 3) {
                            if (newPullParser.getName().equals("tt")) {
                                c45032e2 = new C45032e((C25535b) linkedList.getLast(), hashMap, hashMap2);
                            } else {
                                c45032e2 = c45032e;
                            }
                            linkedList.removeLast();
                        } else {
                            c45032e2 = c45032e;
                        }
                        parseInt = i3;
                        c45032e = c45032e2;
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
            AppMethodBeat.m2505o(95671);
            return c45032e;
        } catch (XmlPullParserException e2) {
            C41607f c41607f2 = new C41607f("Unable to decode source", e2);
            AppMethodBeat.m2505o(95671);
            throw c41607f2;
        } catch (IOException e3) {
            IllegalStateException illegalStateException = new IllegalStateException("Unexpected error when reading input.", e3);
            AppMethodBeat.m2505o(95671);
            throw illegalStateException;
        }
    }

    /* renamed from: a */
    private static Map<String, C8674d> m25341a(XmlPullParser xmlPullParser, Map<String, C8674d> map, Map<String, C8673c> map2) {
        AppMethodBeat.m2504i(95672);
        Object obj;
        do {
            xmlPullParser.next();
            if (C17677w.m27580b(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                String c = C17677w.m27581c(xmlPullParser, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
                C8674d a = C16512a.m25340a(xmlPullParser, new C8674d());
                if (c != null) {
                    for (Object obj2 : c.split("\\s+")) {
                        a.mo19193b((C8674d) map.get(obj2));
                    }
                }
                if (a.f2434id != null) {
                    map.put(a.f2434id, a);
                }
            } else if (C17677w.m27580b(xmlPullParser, "region")) {
                C8673c b = C16512a.m25342b(xmlPullParser);
                if (b != null) {
                    map2.put(b.f2433id, b);
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
        AppMethodBeat.m2505o(95672);
        return map;
    }

    /* renamed from: b */
    private static C8673c m25342b(XmlPullParser xmlPullParser) {
        int i = 1;
        C8673c c8673c = null;
        AppMethodBeat.m2504i(95673);
        String c = C17677w.m27581c(xmlPullParser, "id");
        if (c == null) {
            AppMethodBeat.m2505o(95673);
            return c8673c;
        }
        String c2 = C17677w.m27581c(xmlPullParser, C8741b.ORIGIN);
        if (c2 != null) {
            Matcher matcher = bnG.matcher(c2);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    float parseFloat2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    String c3 = C17677w.m27581c(xmlPullParser, "extent");
                    if (c3 != null) {
                        Matcher matcher2 = bnG.matcher(c3);
                        if (matcher2.matches()) {
                            try {
                                float parseFloat3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                                float parseFloat4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                                String c4 = C17677w.m27581c(xmlPullParser, "displayAlign");
                                if (c4 != null) {
                                    String aR = C17675v.m27560aR(c4);
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
                                c8673c = new C8673c(c, parseFloat, parseFloat2, 0, i, parseFloat3);
                                AppMethodBeat.m2505o(95673);
                                return c8673c;
                            } catch (NumberFormatException e) {
                                AppMethodBeat.m2505o(95673);
                                return c8673c;
                            }
                        }
                        AppMethodBeat.m2505o(95673);
                        return c8673c;
                    }
                    AppMethodBeat.m2505o(95673);
                    return c8673c;
                } catch (NumberFormatException e2) {
                    AppMethodBeat.m2505o(95673);
                    return c8673c;
                }
            }
            AppMethodBeat.m2505o(95673);
            return c8673c;
        }
        AppMethodBeat.m2505o(95673);
        return c8673c;
    }

    /* renamed from: a */
    private static C8674d m25340a(XmlPullParser xmlPullParser, C8674d c8674d) {
        AppMethodBeat.m2504i(95674);
        int attributeCount = xmlPullParser.getAttributeCount();
        C8674d c8674d2 = c8674d;
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
            C8674d a;
            boolean equalsIgnoreCase;
            int i2;
            switch (z) {
                case false:
                    if (!AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(xmlPullParser.getName())) {
                        break;
                    }
                    c8674d2 = C16512a.m25339a(c8674d2);
                    c8674d2.f2434id = attributeValue;
                    break;
                case true:
                    c8674d2 = C16512a.m25339a(c8674d2);
                    try {
                        c8674d2.mo19195eF(C0871d.m1975aF(attributeValue));
                        break;
                    } catch (IllegalArgumentException e) {
                        break;
                    }
                case true:
                    c8674d2 = C16512a.m25339a(c8674d2);
                    try {
                        c8674d2.mo19194eE(C0871d.m1975aF(attributeValue));
                        break;
                    } catch (IllegalArgumentException e2) {
                        break;
                    }
                case true:
                    a = C16512a.m25339a(c8674d2);
                    C45039a.checkState(a.bob == null);
                    a.bnS = attributeValue;
                    c8674d2 = a;
                    break;
                case true:
                    try {
                        Matcher matcher;
                        c8674d2 = C16512a.m25339a(c8674d2);
                        String[] split = attributeValue.split("\\s+");
                        if (split.length == 1) {
                            matcher = bnF.matcher(attributeValue);
                        } else if (split.length == 2) {
                            matcher = bnF.matcher(split[1]);
                        } else {
                            C41607f c41607f = new C41607f("Invalid number of entries for fontSize: " + split.length + ".");
                            AppMethodBeat.m2505o(95674);
                            throw c41607f;
                        }
                        C41607f c41607f2;
                        if (matcher.matches()) {
                            attributeValue = matcher.group(3);
                            z = true;
                            switch (attributeValue.hashCode()) {
                                case C2275g.CTRL_INDEX /*37*/:
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
                                    c8674d2.boa = 1;
                                    break;
                                case true:
                                    c8674d2.boa = 2;
                                    break;
                                case true:
                                    c8674d2.boa = 3;
                                    break;
                                default:
                                    c41607f2 = new C41607f("Invalid unit for fontSize: '" + attributeValue + "'.");
                                    AppMethodBeat.m2505o(95674);
                                    throw c41607f2;
                            }
                            c8674d2.fontSize = Float.valueOf(matcher.group(1)).floatValue();
                            break;
                        }
                        c41607f2 = new C41607f("Invalid expression for fontSize: '" + attributeValue + "'.");
                        AppMethodBeat.m2505o(95674);
                        throw c41607f2;
                    } catch (C41607f e3) {
                        break;
                    }
                case true:
                    a = C16512a.m25339a(c8674d2);
                    equalsIgnoreCase = "bold".equalsIgnoreCase(attributeValue);
                    C45039a.checkState(a.bob == null);
                    if (equalsIgnoreCase) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    a.bnY = i2;
                    c8674d2 = a;
                    break;
                case true:
                    a = C16512a.m25339a(c8674d2);
                    equalsIgnoreCase = "italic".equalsIgnoreCase(attributeValue);
                    C45039a.checkState(a.bob == null);
                    if (equalsIgnoreCase) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    a.bnZ = i2;
                    c8674d2 = a;
                    break;
                case true:
                    attributeName = C17675v.m27560aR(attributeValue);
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
                            c8674d2 = C16512a.m25339a(c8674d2);
                            c8674d2.boc = Alignment.ALIGN_NORMAL;
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2);
                            c8674d2.boc = Alignment.ALIGN_NORMAL;
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2);
                            c8674d2.boc = Alignment.ALIGN_OPPOSITE;
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2);
                            c8674d2.boc = Alignment.ALIGN_OPPOSITE;
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2);
                            c8674d2.boc = Alignment.ALIGN_CENTER;
                            break;
                        default:
                            break;
                    }
                case true:
                    attributeName = C17675v.m27560aR(attributeValue);
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
                            c8674d2 = C16512a.m25339a(c8674d2).mo19191aK(true);
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2).mo19191aK(false);
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2).mo19192aL(true);
                            break;
                        case true:
                            c8674d2 = C16512a.m25339a(c8674d2).mo19192aL(false);
                            break;
                        default:
                            break;
                    }
                default:
                    break;
            }
        }
        AppMethodBeat.m2505o(95674);
        return c8674d2;
    }

    /* renamed from: a */
    private static C8674d m25339a(C8674d c8674d) {
        AppMethodBeat.m2504i(95675);
        if (c8674d == null) {
            c8674d = new C8674d();
            AppMethodBeat.m2505o(95675);
            return c8674d;
        }
        AppMethodBeat.m2505o(95675);
        return c8674d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static C25535b m25338a(XmlPullParser xmlPullParser, C25535b c25535b, Map<String, C8673c> map, C16513a c16513a) {
        long j;
        C25535b c25535b2;
        AppMethodBeat.m2504i(95676);
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        String str = "";
        String[] strArr = null;
        int attributeCount = xmlPullParser.getAttributeCount();
        C8674d a = C16512a.m25340a(xmlPullParser, null);
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
                    j3 = C16512a.m25337a(attributeValue, c16513a);
                    break;
                case 1:
                    j4 = C16512a.m25337a(attributeValue, c16513a);
                    break;
                case 2:
                    j2 = C16512a.m25337a(attributeValue, c16513a);
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
        if (!(c25535b == null || c25535b.bif == -9223372036854775807L)) {
            if (j3 != -9223372036854775807L) {
                j3 += c25535b.bif;
            }
            if (j4 != -9223372036854775807L) {
                j = j4 + c25535b.bif;
                if (j == -9223372036854775807L) {
                    if (j2 != -9223372036854775807L) {
                        j2 += j3;
                    } else if (!(c25535b == null || c25535b.big == -9223372036854775807L)) {
                        j2 = c25535b.big;
                    }
                    c25535b2 = new C25535b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
                    AppMethodBeat.m2505o(95676);
                    return c25535b2;
                }
                j2 = j;
                c25535b2 = new C25535b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
                AppMethodBeat.m2505o(95676);
                return c25535b2;
            }
        }
        j = j4;
        if (j == -9223372036854775807L) {
        }
        j2 = j;
        c25535b2 = new C25535b(xmlPullParser.getName(), null, j3, j2, a, strArr, str);
        AppMethodBeat.m2505o(95676);
        return c25535b2;
    }

    /* renamed from: a */
    private static long m25337a(String str, C16513a c16513a) {
        double d = 0.0d;
        AppMethodBeat.m2504i(95677);
        Matcher matcher = bnD.matcher(str);
        double parseLong;
        long j;
        if (matcher.matches()) {
            double parseLong2 = ((double) Long.parseLong(matcher.group(3))) + (((double) (Long.parseLong(matcher.group(1)) * 3600)) + ((double) (Long.parseLong(matcher.group(2)) * 60)));
            String group = matcher.group(4);
            parseLong2 += group != null ? Double.parseDouble(group) : 0.0d;
            group = matcher.group(5);
            if (group != null) {
                parseLong = (double) (((float) Long.parseLong(group)) / c16513a.bnJ);
            } else {
                parseLong = 0.0d;
            }
            parseLong += parseLong2;
            String group2 = matcher.group(6);
            if (group2 != null) {
                d = (((double) Long.parseLong(group2)) / ((double) c16513a.bnK)) / ((double) c16513a.bnJ);
            }
            j = (long) ((parseLong + d) * 1000000.0d);
            AppMethodBeat.m2505o(95677);
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
                    parseLong /= (double) c16513a.bnJ;
                    break;
                case 5:
                    parseLong /= (double) c16513a.tickRate;
                    break;
            }
            j = (long) (parseLong * 1000000.0d);
            AppMethodBeat.m2505o(95677);
            return j;
        }
        C41607f c41607f = new C41607f("Malformed time expression: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(95677);
        throw c41607f;
    }
}
