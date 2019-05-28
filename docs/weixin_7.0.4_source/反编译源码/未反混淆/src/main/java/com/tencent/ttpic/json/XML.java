package com.tencent.ttpic.json;

import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;

public class XML {
    public static final Character AMP = Character.valueOf('&');
    public static final Character APOS = Character.valueOf('\'');
    public static final Character BANG = Character.valueOf('!');
    public static final Character EQ = Character.valueOf('=');
    public static final Character GT = Character.valueOf('>');
    public static final Character LT = Character.valueOf('<');
    public static final Character QUEST = Character.valueOf('?');
    public static final Character QUOT = Character.valueOf('\"');
    public static final Character SLASH = Character.valueOf(IOUtils.DIR_SEPARATOR_UNIX);

    static {
        AppMethodBeat.i(50222);
        AppMethodBeat.o(50222);
    }

    public static String escape(String str) {
        AppMethodBeat.i(50215);
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuffer.append("&quot;");
                    break;
                case '&':
                    stringBuffer.append("&amp;");
                    break;
                case '\'':
                    stringBuffer.append("&apos;");
                    break;
                case '<':
                    stringBuffer.append("&lt;");
                    break;
                case '>':
                    stringBuffer.append("&gt;");
                    break;
                default:
                    stringBuffer.append(charAt);
                    break;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(50215);
        return stringBuffer2;
    }

    public static void noSpace(String str) {
        AppMethodBeat.i(50216);
        int length = str.length();
        JSONException jSONException;
        if (length == 0) {
            jSONException = new JSONException("Empty string.");
            AppMethodBeat.o(50216);
            throw jSONException;
        }
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                jSONException = new JSONException("'" + str + "' contains a space character.");
                AppMethodBeat.o(50216);
                throw jSONException;
            }
        }
        AppMethodBeat.o(50216);
    }

    private static boolean parse(XMLTokener xMLTokener, JSONObject jSONObject, String str) {
        AppMethodBeat.i(50217);
        Character nextToken = xMLTokener.nextToken();
        String nextCDATA;
        JSONException syntaxError;
        Character nextMeta;
        if (nextToken == BANG) {
            char next = xMLTokener.next();
            if (next == '-') {
                if (xMLTokener.next() == '-') {
                    xMLTokener.skipPast("-->");
                    AppMethodBeat.o(50217);
                    return false;
                }
                xMLTokener.back();
            } else if (next == '[') {
                if ("CDATA".equals(xMLTokener.nextToken()) && xMLTokener.next() == '[') {
                    nextCDATA = xMLTokener.nextCDATA();
                    if (nextCDATA.length() > 0) {
                        jSONObject.accumulate(b.CONTENT, nextCDATA);
                    }
                    AppMethodBeat.o(50217);
                    return false;
                }
                syntaxError = xMLTokener.syntaxError("Expected 'CDATA['");
                AppMethodBeat.o(50217);
                throw syntaxError;
            }
            int i = 1;
            do {
                nextMeta = xMLTokener.nextMeta();
                if (nextMeta == null) {
                    syntaxError = xMLTokener.syntaxError("Missing '>' after '<!'.");
                    AppMethodBeat.o(50217);
                    throw syntaxError;
                } else if (nextMeta == LT) {
                    i++;
                    continue;
                } else if (nextMeta == GT) {
                    i--;
                    continue;
                } else {
                    continue;
                }
            } while (i > 0);
            AppMethodBeat.o(50217);
            return false;
        } else if (nextToken == QUEST) {
            xMLTokener.skipPast("?>");
            AppMethodBeat.o(50217);
            return false;
        } else if (nextToken == SLASH) {
            Object nextToken2 = xMLTokener.nextToken();
            if (str == null) {
                syntaxError = xMLTokener.syntaxError("Mismatched close tag ".concat(String.valueOf(nextToken2)));
                AppMethodBeat.o(50217);
                throw syntaxError;
            } else if (!nextToken2.equals(str)) {
                syntaxError = xMLTokener.syntaxError("Mismatched " + str + " and " + nextToken2);
                AppMethodBeat.o(50217);
                throw syntaxError;
            } else if (xMLTokener.nextToken() != GT) {
                syntaxError = xMLTokener.syntaxError("Misshaped close tag");
                AppMethodBeat.o(50217);
                throw syntaxError;
            } else {
                AppMethodBeat.o(50217);
                return true;
            }
        } else if (nextToken instanceof Character) {
            syntaxError = xMLTokener.syntaxError("Misshaped tag");
            AppMethodBeat.o(50217);
            throw syntaxError;
        } else {
            nextCDATA = (String) nextToken;
            nextMeta = null;
            JSONObject jSONObject2 = new JSONObject();
            while (true) {
                if (nextMeta == null) {
                    nextMeta = xMLTokener.nextToken();
                }
                String str2;
                if (nextMeta instanceof String) {
                    str2 = (String) nextMeta;
                    Character nextToken3 = xMLTokener.nextToken();
                    if (nextToken3 == EQ) {
                        Object nextToken4 = xMLTokener.nextToken();
                        if (nextToken4 instanceof String) {
                            jSONObject2.accumulate(str2, stringToValue((String) nextToken4));
                            nextMeta = null;
                        } else {
                            syntaxError = xMLTokener.syntaxError("Missing value");
                            AppMethodBeat.o(50217);
                            throw syntaxError;
                        }
                    }
                    jSONObject2.accumulate(str2, "");
                    nextMeta = nextToken3;
                } else if (nextMeta == SLASH) {
                    if (xMLTokener.nextToken() != GT) {
                        syntaxError = xMLTokener.syntaxError("Misshaped tag");
                        AppMethodBeat.o(50217);
                        throw syntaxError;
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.accumulate(nextCDATA, jSONObject2);
                    } else {
                        jSONObject.accumulate(nextCDATA, "");
                    }
                    AppMethodBeat.o(50217);
                    return false;
                } else if (nextMeta == GT) {
                    while (true) {
                        nextMeta = xMLTokener.nextContent();
                        if (nextMeta == null) {
                            if (nextCDATA != null) {
                                syntaxError = xMLTokener.syntaxError("Unclosed tag ".concat(String.valueOf(nextCDATA)));
                                AppMethodBeat.o(50217);
                                throw syntaxError;
                            }
                            AppMethodBeat.o(50217);
                            return false;
                        } else if (nextMeta instanceof String) {
                            str2 = (String) nextMeta;
                            if (str2.length() > 0) {
                                jSONObject2.accumulate(b.CONTENT, stringToValue(str2));
                            }
                        } else if (nextMeta == LT && parse(xMLTokener, jSONObject2, nextCDATA)) {
                            if (jSONObject2.length() == 0) {
                                jSONObject.accumulate(nextCDATA, "");
                            } else if (jSONObject2.length() != 1 || jSONObject2.opt(b.CONTENT) == null) {
                                jSONObject.accumulate(nextCDATA, jSONObject2);
                            } else {
                                jSONObject.accumulate(nextCDATA, jSONObject2.opt(b.CONTENT));
                            }
                            AppMethodBeat.o(50217);
                            return false;
                        }
                    }
                } else {
                    syntaxError = xMLTokener.syntaxError("Misshaped tag");
                    AppMethodBeat.o(50217);
                    throw syntaxError;
                }
            }
        }
    }

    public static Object stringToValue(String str) {
        int i = 1;
        int i2 = 0;
        AppMethodBeat.i(50218);
        Object obj;
        if ("".equals(str)) {
            AppMethodBeat.o(50218);
            return str;
        } else if ("true".equalsIgnoreCase(str)) {
            obj = Boolean.TRUE;
            AppMethodBeat.o(50218);
            return obj;
        } else if ("false".equalsIgnoreCase(str)) {
            obj = Boolean.FALSE;
            AppMethodBeat.o(50218);
            return obj;
        } else if (BuildConfig.COMMAND.equalsIgnoreCase(str)) {
            obj = JSONObject.NULL;
            AppMethodBeat.o(50218);
            return obj;
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            obj = Integer.valueOf(0);
            AppMethodBeat.o(50218);
            return obj;
        } else {
            try {
                char charAt = str.charAt(0);
                if (charAt == '-') {
                    charAt = str.charAt(1);
                    i2 = 1;
                }
                if (charAt == '0') {
                    if (i2 != 0) {
                        i = 2;
                    }
                    if (str.charAt(i) == '0') {
                        AppMethodBeat.o(50218);
                        return str;
                    }
                }
                if (charAt >= '0' && charAt <= '9') {
                    if (str.indexOf(46) >= 0) {
                        str = Double.valueOf(str);
                        AppMethodBeat.o(50218);
                        return str;
                    } else if (str.indexOf(101) < 0 && str.indexOf(69) < 0) {
                        Long l = new Long(str);
                        if (l.longValue() == ((long) l.intValue())) {
                            Integer num = new Integer(l.intValue());
                            AppMethodBeat.o(50218);
                            return num;
                        }
                        AppMethodBeat.o(50218);
                        return l;
                    }
                }
            } catch (Exception e) {
            }
            AppMethodBeat.o(50218);
            return str;
        }
    }

    public static JSONObject toJSONObject(String str) {
        AppMethodBeat.i(50219);
        JSONObject jSONObject = new JSONObject();
        XMLTokener xMLTokener = new XMLTokener(str);
        while (xMLTokener.more() && xMLTokener.skipPast("<")) {
            parse(xMLTokener, jSONObject, null);
        }
        AppMethodBeat.o(50219);
        return jSONObject;
    }

    public static String toString(Object obj) {
        AppMethodBeat.i(50220);
        String xml = toString(obj, null);
        AppMethodBeat.o(50220);
        return xml;
    }

    public static String toString(Object obj, String str) {
        AppMethodBeat.i(50221);
        StringBuffer stringBuffer = new StringBuffer();
        Object opt;
        JSONArray jSONArray;
        int i;
        String stringBuffer2;
        if (obj instanceof JSONObject) {
            if (str != null) {
                stringBuffer.append('<');
                stringBuffer.append(str);
                stringBuffer.append('>');
            }
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj2 = keys.next().toString();
                opt = jSONObject.opt(obj2);
                if (opt == null) {
                    opt = "";
                }
                if (b.CONTENT.equals(obj2)) {
                    if (opt instanceof JSONArray) {
                        jSONArray = (JSONArray) opt;
                        int length = jSONArray.length();
                        for (i = 0; i < length; i++) {
                            if (i > 0) {
                                stringBuffer.append(10);
                            }
                            stringBuffer.append(escape(jSONArray.get(i).toString()));
                        }
                    } else {
                        stringBuffer.append(escape(opt.toString()));
                    }
                } else if (opt instanceof JSONArray) {
                    jSONArray = (JSONArray) opt;
                    int length2 = jSONArray.length();
                    for (i = 0; i < length2; i++) {
                        Object obj3 = jSONArray.get(i);
                        if (obj3 instanceof JSONArray) {
                            stringBuffer.append('<');
                            stringBuffer.append(obj2);
                            stringBuffer.append('>');
                            stringBuffer.append(toString(obj3));
                            stringBuffer.append("</");
                            stringBuffer.append(obj2);
                            stringBuffer.append('>');
                        } else {
                            stringBuffer.append(toString(obj3, obj2));
                        }
                    }
                } else if ("".equals(opt)) {
                    stringBuffer.append('<');
                    stringBuffer.append(obj2);
                    stringBuffer.append("/>");
                } else {
                    stringBuffer.append(toString(opt, obj2));
                }
            }
            if (str != null) {
                stringBuffer.append("</");
                stringBuffer.append(str);
                stringBuffer.append('>');
            }
            stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(50221);
            return stringBuffer2;
        }
        if (obj.getClass().isArray()) {
            opt = new JSONArray(obj);
        } else {
            opt = obj;
        }
        if (opt instanceof JSONArray) {
            jSONArray = (JSONArray) opt;
            int length3 = jSONArray.length();
            for (i = 0; i < length3; i++) {
                String str2;
                Object opt2 = jSONArray.opt(i);
                if (str == null) {
                    str2 = "array";
                } else {
                    str2 = str;
                }
                stringBuffer.append(toString(opt2, str2));
            }
            stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(50221);
            return stringBuffer2;
        }
        stringBuffer2 = opt == null ? BuildConfig.COMMAND : escape(opt.toString());
        if (str == null) {
            stringBuffer2 = "\"" + stringBuffer2 + "\"";
            AppMethodBeat.o(50221);
            return stringBuffer2;
        } else if (stringBuffer2.length() == 0) {
            stringBuffer2 = "<" + str + "/>";
            AppMethodBeat.o(50221);
            return stringBuffer2;
        } else {
            stringBuffer2 = "<" + str + ">" + stringBuffer2 + "</" + str + ">";
            AppMethodBeat.o(50221);
            return stringBuffer2;
        }
    }
}
