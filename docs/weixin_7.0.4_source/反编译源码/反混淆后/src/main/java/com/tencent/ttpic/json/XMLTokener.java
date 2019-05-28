package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.HashMap;

public class XMLTokener extends JSONTokener {
    public static final HashMap entity;

    static {
        AppMethodBeat.m2504i(50229);
        HashMap hashMap = new HashMap(8);
        entity = hashMap;
        hashMap.put("amp", XML.AMP);
        entity.put("apos", XML.APOS);
        entity.put("gt", XML.f14329GT);
        entity.put("lt", XML.f14330LT);
        entity.put("quot", XML.QUOT);
        AppMethodBeat.m2505o(50229);
    }

    public XMLTokener(String str) {
        super(str);
    }

    public String nextCDATA() {
        AppMethodBeat.m2504i(50223);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            if (end()) {
                JSONException syntaxError = syntaxError("Unclosed CDATA");
                AppMethodBeat.m2505o(50223);
                throw syntaxError;
            }
            stringBuffer.append(next);
            int length = stringBuffer.length() - 3;
            if (length >= 0 && stringBuffer.charAt(length) == ']' && stringBuffer.charAt(length + 1) == ']' && stringBuffer.charAt(length + 2) == '>') {
                stringBuffer.setLength(length);
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.m2505o(50223);
                return stringBuffer2;
            }
        }
    }

    public Object nextContent() {
        char next;
        AppMethodBeat.m2504i(50224);
        do {
            next = next();
        } while (Character.isWhitespace(next));
        Object obj;
        if (next == 0) {
            AppMethodBeat.m2505o(50224);
            return null;
        } else if (next == '<') {
            obj = XML.f14330LT;
            AppMethodBeat.m2505o(50224);
            return obj;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            while (next != '<' && next != 0) {
                if (next == '&') {
                    stringBuffer.append(nextEntity(next));
                } else {
                    stringBuffer.append(next);
                }
                next = next();
            }
            back();
            obj = stringBuffer.toString().trim();
            AppMethodBeat.m2505o(50224);
            return obj;
        }
    }

    public Object nextEntity(char c) {
        char next;
        AppMethodBeat.m2504i(50225);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (!Character.isLetterOrDigit(next) && next != '#') {
                break;
            }
            stringBuffer.append(Character.toLowerCase(next));
        }
        if (next != ';') {
            JSONException syntaxError = syntaxError("Missing ';' in XML entity: &".concat(String.valueOf(stringBuffer)));
            AppMethodBeat.m2505o(50225);
            throw syntaxError;
        }
        String stringBuffer2 = stringBuffer.toString();
        Object obj = entity.get(stringBuffer2);
        if (obj != null) {
            AppMethodBeat.m2505o(50225);
            return obj;
        }
        obj = c + stringBuffer2 + ";";
        AppMethodBeat.m2505o(50225);
        return obj;
    }

    /* JADX WARNING: Missing block: B:4:0x0013, code skipped:
            r0 = next();
     */
    /* JADX WARNING: Missing block: B:5:0x001b, code skipped:
            if (java.lang.Character.isWhitespace(r0) == false) goto L_0x006b;
     */
    /* JADX WARNING: Missing block: B:6:0x001d, code skipped:
            r0 = java.lang.Boolean.TRUE;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(50226);
     */
    /* JADX WARNING: Missing block: B:15:0x0052, code skipped:
            r1 = next();
     */
    /* JADX WARNING: Missing block: B:16:0x0056, code skipped:
            if (r1 != 0) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:17:0x0058, code skipped:
            r0 = syntaxError("Unterminated string");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(50226);
     */
    /* JADX WARNING: Missing block: B:18:0x0062, code skipped:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:19:0x0063, code skipped:
            if (r1 != r0) goto L_0x0052;
     */
    /* JADX WARNING: Missing block: B:20:0x0065, code skipped:
            r0 = java.lang.Boolean.TRUE;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(50226);
     */
    /* JADX WARNING: Missing block: B:21:0x006b, code skipped:
            switch(r0) {
                case 0: goto L_0x006f;
                case 33: goto L_0x006f;
                case 34: goto L_0x006f;
                case 39: goto L_0x006f;
                case com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer.CTRL_INDEX :int: goto L_0x006f;
                case 60: goto L_0x006f;
                case com.tencent.qqmusic.mediaplayer.PlayerException.EXCEPTION_TYPE_INITLIB :int: goto L_0x006f;
                case 62: goto L_0x006f;
                case 63: goto L_0x006f;
                default: goto L_0x006e;
            };
     */
    /* JADX WARNING: Missing block: B:23:0x006f, code skipped:
            back();
            r0 = java.lang.Boolean.TRUE;
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(50226);
     */
    /* JADX WARNING: Missing block: B:29:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:36:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object nextMeta() {
        char next;
        AppMethodBeat.m2504i(50226);
        do {
            next = next();
        } while (Character.isWhitespace(next));
        Object obj;
        switch (next) {
            case 0:
                JSONException syntaxError = syntaxError("Misshaped meta tag");
                AppMethodBeat.m2505o(50226);
                throw syntaxError;
            case '!':
                obj = XML.BANG;
                AppMethodBeat.m2505o(50226);
                return obj;
            case '\"':
            case '\'':
                break;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                obj = XML.SLASH;
                AppMethodBeat.m2505o(50226);
                return obj;
            case '<':
                obj = XML.f14330LT;
                AppMethodBeat.m2505o(50226);
                return obj;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                obj = XML.f14328EQ;
                AppMethodBeat.m2505o(50226);
                return obj;
            case '>':
                obj = XML.f14329GT;
                AppMethodBeat.m2505o(50226);
                return obj;
            case '?':
                obj = XML.QUEST;
                AppMethodBeat.m2505o(50226);
                return obj;
        }
    }

    public Object nextToken() {
        char next;
        AppMethodBeat.m2504i(50227);
        do {
            next = next();
        } while (Character.isWhitespace(next));
        JSONException syntaxError;
        Object obj;
        StringBuffer stringBuffer;
        switch (next) {
            case 0:
                syntaxError = syntaxError("Misshaped element");
                AppMethodBeat.m2505o(50227);
                throw syntaxError;
            case '!':
                obj = XML.BANG;
                AppMethodBeat.m2505o(50227);
                return obj;
            case '\"':
            case '\'':
                stringBuffer = new StringBuffer();
                while (true) {
                    char next2 = next();
                    if (next2 == 0) {
                        syntaxError = syntaxError("Unterminated string");
                        AppMethodBeat.m2505o(50227);
                        throw syntaxError;
                    } else if (next2 == next) {
                        obj = stringBuffer.toString();
                        AppMethodBeat.m2505o(50227);
                        return obj;
                    } else if (next2 == '&') {
                        stringBuffer.append(nextEntity(next2));
                    } else {
                        stringBuffer.append(next2);
                    }
                }
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                obj = XML.SLASH;
                AppMethodBeat.m2505o(50227);
                return obj;
            case '<':
                syntaxError = syntaxError("Misplaced '<'");
                AppMethodBeat.m2505o(50227);
                throw syntaxError;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                obj = XML.f14328EQ;
                AppMethodBeat.m2505o(50227);
                return obj;
            case '>':
                obj = XML.f14329GT;
                AppMethodBeat.m2505o(50227);
                return obj;
            case '?':
                obj = XML.QUEST;
                AppMethodBeat.m2505o(50227);
                return obj;
            default:
                stringBuffer = new StringBuffer();
                while (true) {
                    stringBuffer.append(next);
                    next = next();
                    if (Character.isWhitespace(next)) {
                        String stringBuffer2 = stringBuffer.toString();
                        AppMethodBeat.m2505o(50227);
                        return stringBuffer2;
                    }
                    switch (next) {
                        case 0:
                            obj = stringBuffer.toString();
                            AppMethodBeat.m2505o(50227);
                            return obj;
                        case '!':
                        case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                        case '>':
                        case '?':
                        case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                        case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                            back();
                            obj = stringBuffer.toString();
                            AppMethodBeat.m2505o(50227);
                            return obj;
                        case '\"':
                        case '\'':
                        case '<':
                            syntaxError = syntaxError("Bad character in a name");
                            AppMethodBeat.m2505o(50227);
                            throw syntaxError;
                        default:
                    }
                }
        }
    }

    public boolean skipPast(String str) {
        int i;
        char next;
        AppMethodBeat.m2504i(50228);
        int length = str.length();
        char[] cArr = new char[length];
        for (i = 0; i < length; i++) {
            next = next();
            if (next == 0) {
                AppMethodBeat.m2505o(50228);
                return false;
            }
            cArr[i] = next;
        }
        i = 0;
        while (true) {
            boolean z;
            int i2 = i;
            for (int i3 = 0; i3 < length; i3++) {
                if (cArr[i2] != str.charAt(i3)) {
                    z = false;
                    break;
                }
                i2++;
                if (i2 >= length) {
                    i2 -= length;
                }
            }
            z = true;
            if (z) {
                AppMethodBeat.m2505o(50228);
                return true;
            }
            next = next();
            if (next == 0) {
                AppMethodBeat.m2505o(50228);
                return false;
            }
            cArr[i] = next;
            i++;
            if (i >= length) {
                i -= length;
            }
        }
    }
}
