package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.Iterator;

public class JSONML {
    /* JADX WARNING: Missing block: B:85:0x0174, code skipped:
            r2 = r9.nextToken();
     */
    /* JADX WARNING: Missing block: B:86:0x017a, code skipped:
            if ((r2 instanceof java.lang.String) != false) goto L_0x0187;
     */
    /* JADX WARNING: Missing block: B:87:0x017c, code skipped:
            r0 = r9.syntaxError("Missing value");
            com.tencent.matrix.trace.core.AppMethodBeat.o(50107);
     */
    /* JADX WARNING: Missing block: B:88:0x0186, code skipped:
            throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object parse(XMLTokener xMLTokener, boolean z, JSONArray jSONArray) {
        JSONException syntaxError;
        AppMethodBeat.i(50107);
        loop0:
        while (xMLTokener.more()) {
            Object nextContent = xMLTokener.nextContent();
            if (nextContent == XML.LT) {
                Character nextToken = xMLTokener.nextToken();
                Character nextMeta;
                if (nextToken instanceof Character) {
                    if (nextToken == XML.SLASH) {
                        nextContent = xMLTokener.nextToken();
                        if (!(nextContent instanceof String)) {
                            JSONException jSONException = new JSONException("Expected a closing name instead of '" + nextContent + "'.");
                            AppMethodBeat.o(50107);
                            throw jSONException;
                        } else if (xMLTokener.nextToken() != XML.GT) {
                            syntaxError = xMLTokener.syntaxError("Misshaped close tag");
                            AppMethodBeat.o(50107);
                            throw syntaxError;
                        } else {
                            AppMethodBeat.o(50107);
                            return nextContent;
                        }
                    } else if (nextToken == XML.BANG) {
                        char next = xMLTokener.next();
                        if (next == '-') {
                            if (xMLTokener.next() == '-') {
                                xMLTokener.skipPast("-->");
                            } else {
                                xMLTokener.back();
                            }
                        } else if (next != '[') {
                            int i = 1;
                            do {
                                nextMeta = xMLTokener.nextMeta();
                                if (nextMeta == null) {
                                    syntaxError = xMLTokener.syntaxError("Missing '>' after '<!'.");
                                    AppMethodBeat.o(50107);
                                    throw syntaxError;
                                } else if (nextMeta == XML.LT) {
                                    i++;
                                    continue;
                                } else if (nextMeta == XML.GT) {
                                    i--;
                                    continue;
                                } else {
                                    continue;
                                }
                            } while (i > 0);
                        } else if (!xMLTokener.nextToken().equals("CDATA") || xMLTokener.next() != '[') {
                            syntaxError = xMLTokener.syntaxError("Expected 'CDATA['");
                            AppMethodBeat.o(50107);
                            throw syntaxError;
                        } else if (jSONArray != null) {
                            jSONArray.put(xMLTokener.nextCDATA());
                        }
                    } else if (nextToken == XML.QUEST) {
                        xMLTokener.skipPast("?>");
                    } else {
                        syntaxError = xMLTokener.syntaxError("Misshaped tag");
                        AppMethodBeat.o(50107);
                        throw syntaxError;
                    }
                } else if (nextToken instanceof String) {
                    nextContent = (String) nextToken;
                    Object jSONArray2 = new JSONArray();
                    Object jSONObject = new JSONObject();
                    if (z) {
                        jSONArray2.put(nextContent);
                        if (jSONArray != null) {
                            jSONArray.put(jSONArray2);
                        }
                    } else {
                        jSONObject.put("tagName", nextContent);
                        if (jSONArray != null) {
                            jSONArray.put(jSONObject);
                        }
                    }
                    while (true) {
                        String str;
                        nextMeta = null;
                        while (true) {
                            if (nextMeta == null) {
                                nextMeta = xMLTokener.nextToken();
                            }
                            if (nextMeta == null) {
                                syntaxError = xMLTokener.syntaxError("Misshaped tag");
                                AppMethodBeat.o(50107);
                                throw syntaxError;
                            } else if (nextMeta instanceof String) {
                                str = (String) nextMeta;
                                if (z || !("tagName".equals(str) || "childNode".equals(str))) {
                                    Character nextToken2 = xMLTokener.nextToken();
                                    if (nextToken2 == XML.EQ) {
                                        break;
                                    }
                                    jSONObject.accumulate(str, "");
                                    nextMeta = nextToken2;
                                }
                            } else {
                                if (z && jSONObject.length() > 0) {
                                    jSONArray2.put(jSONObject);
                                }
                                if (nextMeta == XML.SLASH) {
                                    if (xMLTokener.nextToken() != XML.GT) {
                                        syntaxError = xMLTokener.syntaxError("Misshaped tag");
                                        AppMethodBeat.o(50107);
                                        throw syntaxError;
                                    } else if (jSONArray == null) {
                                        if (z) {
                                            AppMethodBeat.o(50107);
                                            return jSONArray2;
                                        }
                                        AppMethodBeat.o(50107);
                                        return jSONObject;
                                    }
                                } else if (nextMeta != XML.GT) {
                                    syntaxError = xMLTokener.syntaxError("Misshaped tag");
                                    AppMethodBeat.o(50107);
                                    throw syntaxError;
                                } else {
                                    str = (String) parse(xMLTokener, z, jSONArray2);
                                    if (str == null) {
                                        continue;
                                    } else if (str.equals(nextContent)) {
                                        if (!z && jSONArray2.length() > 0) {
                                            jSONObject.put("childNodes", jSONArray2);
                                        }
                                        if (jSONArray == null) {
                                            if (z) {
                                                AppMethodBeat.o(50107);
                                                return jSONArray2;
                                            }
                                            AppMethodBeat.o(50107);
                                            return jSONObject;
                                        }
                                    } else {
                                        syntaxError = xMLTokener.syntaxError("Mismatched '" + nextContent + "' and '" + str + "'");
                                        AppMethodBeat.o(50107);
                                        throw syntaxError;
                                    }
                                }
                            }
                        }
                        jSONObject.accumulate(str, XML.stringToValue((String) r2));
                    }
                    syntaxError = xMLTokener.syntaxError("Reserved attribute.");
                    AppMethodBeat.o(50107);
                    throw syntaxError;
                } else {
                    syntaxError = xMLTokener.syntaxError("Bad tagName '" + nextToken + "'.");
                    AppMethodBeat.o(50107);
                    throw syntaxError;
                }
            } else if (jSONArray != null) {
                if (nextContent instanceof String) {
                    nextContent = XML.stringToValue((String) nextContent);
                }
                jSONArray.put(nextContent);
            }
        }
        syntaxError = xMLTokener.syntaxError("Bad XML");
        AppMethodBeat.o(50107);
        throw syntaxError;
    }

    public static JSONArray toJSONArray(String str) {
        AppMethodBeat.i(50108);
        JSONArray toJSONArray = toJSONArray(new XMLTokener(str));
        AppMethodBeat.o(50108);
        return toJSONArray;
    }

    public static JSONArray toJSONArray(XMLTokener xMLTokener) {
        AppMethodBeat.i(50109);
        JSONArray jSONArray = (JSONArray) parse(xMLTokener, true, null);
        AppMethodBeat.o(50109);
        return jSONArray;
    }

    public static JSONObject toJSONObject(XMLTokener xMLTokener) {
        AppMethodBeat.i(50110);
        JSONObject jSONObject = (JSONObject) parse(xMLTokener, false, null);
        AppMethodBeat.o(50110);
        return jSONObject;
    }

    public static JSONObject toJSONObject(String str) {
        AppMethodBeat.i(50111);
        JSONObject toJSONObject = toJSONObject(new XMLTokener(str));
        AppMethodBeat.o(50111);
        return toJSONObject;
    }

    public static String toString(JSONArray jSONArray) {
        int i;
        AppMethodBeat.i(50112);
        StringBuffer stringBuffer = new StringBuffer();
        String string = jSONArray.getString(0);
        XML.noSpace(string);
        String escape = XML.escape(string);
        stringBuffer.append('<');
        stringBuffer.append(escape);
        Object opt = jSONArray.opt(1);
        if (opt instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) opt;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                XML.noSpace(obj);
                String optString = jSONObject.optString(obj);
                if (optString != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(obj));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(optString));
                    stringBuffer.append('\"');
                }
            }
            i = 2;
        } else {
            i = 1;
        }
        int length = jSONArray.length();
        if (i >= length) {
            stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
            stringBuffer.append('>');
        } else {
            stringBuffer.append('>');
            int i2 = i;
            do {
                opt = jSONArray.get(i2);
                i2++;
                if (opt != null) {
                    if (opt instanceof String) {
                        stringBuffer.append(XML.escape(opt.toString()));
                        continue;
                    } else if (opt instanceof JSONObject) {
                        stringBuffer.append(toString((JSONObject) opt));
                        continue;
                    } else if (opt instanceof JSONArray) {
                        stringBuffer.append(toString((JSONArray) opt));
                        continue;
                    } else {
                        continue;
                    }
                }
            } while (i2 < length);
            stringBuffer.append('<');
            stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
            stringBuffer.append(escape);
            stringBuffer.append('>');
        }
        string = stringBuffer.toString();
        AppMethodBeat.o(50112);
        return string;
    }

    public static String toString(JSONObject jSONObject) {
        AppMethodBeat.i(50113);
        StringBuffer stringBuffer = new StringBuffer();
        String optString = jSONObject.optString("tagName");
        if (optString == null) {
            optString = XML.escape(jSONObject.toString());
            AppMethodBeat.o(50113);
            return optString;
        }
        XML.noSpace(optString);
        String escape = XML.escape(optString);
        stringBuffer.append('<');
        stringBuffer.append(escape);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            if (!("tagName".equals(obj) || "childNodes".equals(obj))) {
                XML.noSpace(obj);
                String optString2 = jSONObject.optString(obj);
                if (optString2 != null) {
                    stringBuffer.append(' ');
                    stringBuffer.append(XML.escape(obj));
                    stringBuffer.append('=');
                    stringBuffer.append('\"');
                    stringBuffer.append(XML.escape(optString2));
                    stringBuffer.append('\"');
                }
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("childNodes");
        if (optJSONArray == null) {
            stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
            stringBuffer.append('>');
        } else {
            stringBuffer.append('>');
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj2 = optJSONArray.get(i);
                if (obj2 != null) {
                    if (obj2 instanceof String) {
                        stringBuffer.append(XML.escape(obj2.toString()));
                    } else if (obj2 instanceof JSONObject) {
                        stringBuffer.append(toString((JSONObject) obj2));
                    } else if (obj2 instanceof JSONArray) {
                        stringBuffer.append(toString((JSONArray) obj2));
                    } else {
                        stringBuffer.append(obj2.toString());
                    }
                }
            }
            stringBuffer.append('<');
            stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
            stringBuffer.append(escape);
            stringBuffer.append('>');
        }
        optString = stringBuffer.toString();
        AppMethodBeat.o(50113);
        return optString;
    }
}
