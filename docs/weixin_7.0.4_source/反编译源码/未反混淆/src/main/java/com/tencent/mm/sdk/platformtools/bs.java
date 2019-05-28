package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

@Deprecated
final class bs {
    public static final void a(Map<String, Object> map, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(93593);
        if (map == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(93593);
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Entry entry : map.entrySet()) {
            a(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, "map");
        AppMethodBeat.o(93593);
    }

    private static void a(List<Object> list, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(93594);
        if (list == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(93594);
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "list");
        AppMethodBeat.o(93594);
    }

    private static void a(Set<Object> set, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(93595);
        if (set == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(93595);
            return;
        }
        xmlSerializer.startTag(null, "set");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        for (Object a : set) {
            a(a, null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "set");
        AppMethodBeat.o(93595);
    }

    private static void a(byte[] bArr, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(93596);
        if (bArr == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(93596);
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r2));
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b >> 4;
            stringBuilder.append(i >= 10 ? (i + 97) - 10 : i + 48);
            i = b & 255;
            if (i >= 10) {
                i = (i + 97) - 10;
            } else {
                i += 48;
            }
            stringBuilder.append(i);
        }
        xmlSerializer.text(stringBuilder.toString());
        xmlSerializer.endTag(null, "byte-array");
        AppMethodBeat.o(93596);
    }

    private static void a(int[] iArr, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(93597);
        if (iArr == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(93597);
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, "name", str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(r1));
        for (int num : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, "value", Integer.toString(num));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
        AppMethodBeat.o(93597);
    }

    private static void a(Object obj, String str, XmlSerializer xmlSerializer) {
        AppMethodBeat.i(93598);
        if (obj == null) {
            xmlSerializer.startTag(null, BuildConfig.COMMAND);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.endTag(null, BuildConfig.COMMAND);
            AppMethodBeat.o(93598);
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
            AppMethodBeat.o(93598);
        } else {
            String str2;
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = DownloadSetting.TYPE_BOOLEAN;
            } else if (obj instanceof byte[]) {
                a((byte[]) obj, str, xmlSerializer);
                AppMethodBeat.o(93598);
                return;
            } else if (obj instanceof int[]) {
                a((int[]) obj, str, xmlSerializer);
                AppMethodBeat.o(93598);
                return;
            } else if (obj instanceof Map) {
                a((Map) obj, str, xmlSerializer);
                AppMethodBeat.o(93598);
                return;
            } else if (obj instanceof List) {
                a((List) obj, str, xmlSerializer);
                AppMethodBeat.o(93598);
                return;
            } else if (obj instanceof Set) {
                a((Set) obj, str, xmlSerializer);
                AppMethodBeat.o(93598);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag(null, "string");
                if (str != null) {
                    xmlSerializer.attribute(null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, "string");
                AppMethodBeat.o(93598);
                return;
            } else {
                RuntimeException runtimeException = new RuntimeException("writeValueXml: unable to write value ".concat(String.valueOf(obj)));
                AppMethodBeat.o(93598);
                throw runtimeException;
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, "name", str);
            }
            xmlSerializer.attribute(null, "value", obj.toString());
            xmlSerializer.endTag(null, str2);
            AppMethodBeat.o(93598);
        }
    }

    private static HashMap<String, Object> a(XmlPullParser xmlPullParser, String str, String[] strArr) {
        XmlPullParserException xmlPullParserException;
        AppMethodBeat.i(93599);
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object b = b(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], b);
                } else {
                    xmlPullParserException = new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                    AppMethodBeat.o(93599);
                    throw xmlPullParserException;
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    AppMethodBeat.o(93599);
                    return hashMap;
                }
                xmlPullParserException = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(93599);
                throw xmlPullParserException;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        xmlPullParserException = new XmlPullParserException("Document ended before " + str + " end tag");
        AppMethodBeat.o(93599);
        throw xmlPullParserException;
    }

    private static ArrayList<Object> b(XmlPullParser xmlPullParser, String str, String[] strArr) {
        XmlPullParserException xmlPullParserException;
        AppMethodBeat.i(93600);
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    AppMethodBeat.o(93600);
                    return arrayList;
                }
                xmlPullParserException = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(93600);
                throw xmlPullParserException;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        xmlPullParserException = new XmlPullParserException("Document ended before " + str + " end tag");
        AppMethodBeat.o(93600);
        throw xmlPullParserException;
    }

    private static HashSet<Object> c(XmlPullParser xmlPullParser, String str, String[] strArr) {
        XmlPullParserException xmlPullParserException;
        AppMethodBeat.i(93601);
        HashSet hashSet = new HashSet();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                hashSet.add(b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    AppMethodBeat.o(93601);
                    return hashSet;
                }
                xmlPullParserException = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(93601);
                throw xmlPullParserException;
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        xmlPullParserException = new XmlPullParserException("Document ended before " + str + " end tag");
        AppMethodBeat.o(93601);
        throw xmlPullParserException;
    }

    private static int[] d(XmlPullParser xmlPullParser, String str) {
        XmlPullParserException xmlPullParserException;
        AppMethodBeat.i(93602);
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"))];
            int i = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            iArr[i] = Integer.parseInt(xmlPullParser.getAttributeValue(null, "value"));
                        } catch (NullPointerException e) {
                            xmlPullParserException = new XmlPullParserException("Need value attribute in item");
                            AppMethodBeat.o(93602);
                            throw xmlPullParserException;
                        } catch (NumberFormatException e2) {
                            xmlPullParserException = new XmlPullParserException("Not a number in value attribute in item");
                            AppMethodBeat.o(93602);
                            throw xmlPullParserException;
                        }
                    }
                    xmlPullParserException = new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    AppMethodBeat.o(93602);
                    throw xmlPullParserException;
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        AppMethodBeat.o(93602);
                        return iArr;
                    } else if (xmlPullParser.getName().equals("item")) {
                        i++;
                    } else {
                        xmlPullParserException = new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                        AppMethodBeat.o(93602);
                        throw xmlPullParserException;
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            xmlPullParserException = new XmlPullParserException("Document ended before " + str + " end tag");
            AppMethodBeat.o(93602);
            throw xmlPullParserException;
        } catch (NullPointerException e3) {
            xmlPullParserException = new XmlPullParserException("Need num attribute in byte-array");
            AppMethodBeat.o(93602);
            throw xmlPullParserException;
        } catch (NumberFormatException e4) {
            xmlPullParserException = new XmlPullParserException("Not a number in num attribute in byte-array");
            AppMethodBeat.o(93602);
            throw xmlPullParserException;
        }
    }

    public static final Object a(XmlPullParser xmlPullParser, String[] strArr) {
        AppMethodBeat.i(93603);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            XmlPullParserException xmlPullParserException;
            if (eventType == 3) {
                xmlPullParserException = new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
                AppMethodBeat.o(93603);
                throw xmlPullParserException;
            } else if (eventType == 4) {
                xmlPullParserException = new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
                AppMethodBeat.o(93603);
                throw xmlPullParserException;
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    xmlPullParserException = new XmlPullParserException("Unexpected end of document");
                    AppMethodBeat.o(93603);
                    throw xmlPullParserException;
                }
            }
        }
        Object b = b(xmlPullParser, strArr);
        AppMethodBeat.o(93603);
        return b;
    }

    private static final Object b(XmlPullParser xmlPullParser, String[] strArr) {
        XmlPullParserException xmlPullParserException;
        Object obj = null;
        AppMethodBeat.i(93604);
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals(BuildConfig.COMMAND)) {
            if (name.equals("string")) {
                obj = "";
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1) {
                        xmlPullParserException = new XmlPullParserException("Unexpected end of document in <string>");
                        AppMethodBeat.o(93604);
                        throw xmlPullParserException;
                    } else if (next == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            AppMethodBeat.o(93604);
                            return obj;
                        }
                        xmlPullParserException = new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                        AppMethodBeat.o(93604);
                        throw xmlPullParserException;
                    } else if (next == 4) {
                        obj = obj + xmlPullParser.getText();
                    } else if (next == 2) {
                        xmlPullParserException = new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                        AppMethodBeat.o(93604);
                        throw xmlPullParserException;
                    }
                }
            } else if (name.equals("int")) {
                obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, "value")));
            } else if (name.equals("long")) {
                obj = Long.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("float")) {
                obj = Float.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("double")) {
                obj = Double.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals(DownloadSetting.TYPE_BOOLEAN)) {
                obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, "value"));
            } else if (name.equals("int-array")) {
                xmlPullParser.next();
                obj = d(xmlPullParser, "int-array");
                strArr[0] = attributeValue;
                AppMethodBeat.o(93604);
                return obj;
            } else if (name.equals("map")) {
                xmlPullParser.next();
                obj = a(xmlPullParser, "map", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(93604);
                return obj;
            } else if (name.equals("list")) {
                xmlPullParser.next();
                obj = b(xmlPullParser, "list", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(93604);
                return obj;
            } else if (name.equals("set")) {
                xmlPullParser.next();
                obj = c(xmlPullParser, "set", strArr);
                strArr[0] = attributeValue;
                AppMethodBeat.o(93604);
                return obj;
            } else {
                xmlPullParserException = new XmlPullParserException("Unknown tag: ".concat(String.valueOf(name)));
                AppMethodBeat.o(93604);
                throw xmlPullParserException;
            }
        }
        int next2;
        do {
            next2 = xmlPullParser.next();
            if (next2 == 1) {
                xmlPullParserException = new XmlPullParserException("Unexpected end of document in <" + name + ">");
                AppMethodBeat.o(93604);
                throw xmlPullParserException;
            } else if (next2 == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    AppMethodBeat.o(93604);
                    return obj;
                }
                xmlPullParserException = new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
                AppMethodBeat.o(93604);
                throw xmlPullParserException;
            } else if (next2 == 4) {
                xmlPullParserException = new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
                AppMethodBeat.o(93604);
                throw xmlPullParserException;
            }
        } while (next2 != 2);
        xmlPullParserException = new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
        AppMethodBeat.o(93604);
        throw xmlPullParserException;
    }
}
