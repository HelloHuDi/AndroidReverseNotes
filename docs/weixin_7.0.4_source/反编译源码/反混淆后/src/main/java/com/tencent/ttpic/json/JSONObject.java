package com.tencent.ttpic.json;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

public class JSONObject {
    public static final Object NULL = new Null();
    private final Map map;

    static final class Null {
        private Null() {
        }

        /* Access modifiers changed, original: protected|final */
        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return BuildConfig.COMMAND;
        }
    }

    static {
        AppMethodBeat.m2504i(50180);
        AppMethodBeat.m2505o(50180);
    }

    public JSONObject() {
        AppMethodBeat.m2504i(50114);
        this.map = new HashMap();
        AppMethodBeat.m2505o(50114);
    }

    public JSONObject(JSONObject jSONObject, String[] strArr) {
        this();
        AppMethodBeat.m2504i(50115);
        for (int i = 0; i < strArr.length; i++) {
            try {
                putOnce(strArr[i], jSONObject.opt(strArr[i]));
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(50115);
    }

    public JSONObject(JSONTokener jSONTokener) {
        this();
        AppMethodBeat.m2504i(50116);
        JSONException syntaxError;
        if (jSONTokener.nextClean() != '{') {
            syntaxError = jSONTokener.syntaxError("A JSONObject text must begin with '{'");
            AppMethodBeat.m2505o(50116);
            throw syntaxError;
        }
        while (true) {
            switch (jSONTokener.nextClean()) {
                case 0:
                    syntaxError = jSONTokener.syntaxError("A JSONObject text must end with '}'");
                    AppMethodBeat.m2505o(50116);
                    throw syntaxError;
                case '}':
                    AppMethodBeat.m2505o(50116);
                    return;
                default:
                    jSONTokener.back();
                    String obj = jSONTokener.nextValue().toString();
                    if (jSONTokener.nextClean() != ':') {
                        syntaxError = jSONTokener.syntaxError("Expected a ':' after a key");
                        AppMethodBeat.m2505o(50116);
                        throw syntaxError;
                    }
                    putOnce(obj, jSONTokener.nextValue());
                    switch (jSONTokener.nextClean()) {
                        case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        case C2206au.CTRL_INDEX /*59*/:
                            if (jSONTokener.nextClean() == '}') {
                                AppMethodBeat.m2505o(50116);
                                return;
                            }
                            jSONTokener.back();
                        case '}':
                            AppMethodBeat.m2505o(50116);
                            return;
                        default:
                            syntaxError = jSONTokener.syntaxError("Expected a ',' or '}'");
                            AppMethodBeat.m2505o(50116);
                            throw syntaxError;
                    }
            }
        }
    }

    public JSONObject(Map map) {
        AppMethodBeat.m2504i(50117);
        this.map = new HashMap();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    this.map.put(entry.getKey(), wrap(value));
                }
            }
        }
        AppMethodBeat.m2505o(50117);
    }

    public JSONObject(Object obj) {
        this();
        AppMethodBeat.m2504i(50118);
        populateMap(obj);
        AppMethodBeat.m2505o(50118);
    }

    public JSONObject(Object obj, String[] strArr) {
        this();
        AppMethodBeat.m2504i(50119);
        Class cls = obj.getClass();
        for (String str : strArr) {
            try {
                putOpt(str, cls.getField(str).get(obj));
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(50119);
    }

    public JSONObject(String str) {
        this(new JSONTokener(str));
        AppMethodBeat.m2504i(50120);
        AppMethodBeat.m2505o(50120);
    }

    public JSONObject(String str, Locale locale) {
        this();
        AppMethodBeat.m2504i(50121);
        ResourceBundle bundle = ResourceBundle.getBundle(str, locale, Thread.currentThread().getContextClassLoader());
        Enumeration keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            if (nextElement instanceof String) {
                String[] split = ((String) nextElement).split("\\.");
                int length = split.length - 1;
                int i = 0;
                JSONObject jSONObject = this;
                while (i < length) {
                    String str2 = split[i];
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        jSONObject.put(str2, (Object) optJSONObject);
                    }
                    i++;
                    jSONObject = optJSONObject;
                }
                jSONObject.put(split[length], bundle.getString((String) nextElement));
            }
        }
        AppMethodBeat.m2505o(50121);
    }

    public JSONObject accumulate(String str, Object obj) {
        AppMethodBeat.m2504i(50122);
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            if (obj instanceof JSONArray) {
                obj = new JSONArray().put(obj);
            }
            put(str, obj);
        } else if (opt instanceof JSONArray) {
            ((JSONArray) opt).put(obj);
        } else {
            put(str, new JSONArray().put(opt).put(obj));
        }
        AppMethodBeat.m2505o(50122);
        return this;
    }

    public JSONObject append(String str, Object obj) {
        AppMethodBeat.m2504i(50123);
        testValidity(obj);
        Object opt = opt(str);
        if (opt == null) {
            put(str, new JSONArray().put(obj));
        } else if (opt instanceof JSONArray) {
            put(str, ((JSONArray) opt).put(obj));
        } else {
            JSONException jSONException = new JSONException("JSONObject[" + str + "] is not a JSONArray.");
            AppMethodBeat.m2505o(50123);
            throw jSONException;
        }
        AppMethodBeat.m2505o(50123);
        return this;
    }

    public static String doubleToString(double d) {
        AppMethodBeat.m2504i(50124);
        String str;
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(50124);
            return str;
        }
        str = Double.toString(d);
        if (str.indexOf(46) > 0 && str.indexOf(101) < 0 && str.indexOf(69) < 0) {
            while (str.endsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        AppMethodBeat.m2505o(50124);
        return str;
    }

    public Object get(String str) {
        AppMethodBeat.m2504i(50125);
        JSONException jSONException;
        if (str == null) {
            jSONException = new JSONException("Null key.");
            AppMethodBeat.m2505o(50125);
            throw jSONException;
        }
        Object opt = opt(str);
        if (opt == null) {
            jSONException = new JSONException("JSONObject[" + quote(str) + "] not found.");
            AppMethodBeat.m2505o(50125);
            throw jSONException;
        }
        AppMethodBeat.m2505o(50125);
        return opt;
    }

    public boolean getBoolean(String str) {
        AppMethodBeat.m2504i(50126);
        Object obj = get(str);
        if (obj.equals(Boolean.FALSE) || ((obj instanceof String) && ((String) obj).equalsIgnoreCase("false"))) {
            AppMethodBeat.m2505o(50126);
            return false;
        } else if (obj.equals(Boolean.TRUE) || ((obj instanceof String) && ((String) obj).equalsIgnoreCase("true"))) {
            AppMethodBeat.m2505o(50126);
            return true;
        } else {
            JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] is not a Boolean.");
            AppMethodBeat.m2505o(50126);
            throw jSONException;
        }
    }

    public double getDouble(String str) {
        AppMethodBeat.m2504i(50127);
        Object obj = get(str);
        try {
            double doubleValue;
            if (obj instanceof Number) {
                doubleValue = ((Number) obj).doubleValue();
                AppMethodBeat.m2505o(50127);
                return doubleValue;
            }
            doubleValue = Double.parseDouble((String) obj);
            AppMethodBeat.m2505o(50127);
            return doubleValue;
        } catch (Exception e) {
            JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] is not a number.");
            AppMethodBeat.m2505o(50127);
            throw jSONException;
        }
    }

    public int getInt(String str) {
        AppMethodBeat.m2504i(50128);
        Object obj = get(str);
        try {
            int intValue;
            if (obj instanceof Number) {
                intValue = ((Number) obj).intValue();
                AppMethodBeat.m2505o(50128);
                return intValue;
            }
            intValue = Integer.parseInt((String) obj);
            AppMethodBeat.m2505o(50128);
            return intValue;
        } catch (Exception e) {
            JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] is not an int.");
            AppMethodBeat.m2505o(50128);
            throw jSONException;
        }
    }

    public JSONArray getJSONArray(String str) {
        AppMethodBeat.m2504i(50129);
        Object obj = get(str);
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            AppMethodBeat.m2505o(50129);
            return jSONArray;
        }
        JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] is not a JSONArray.");
        AppMethodBeat.m2505o(50129);
        throw jSONException;
    }

    public JSONObject getJSONObject(String str) {
        AppMethodBeat.m2504i(50130);
        Object obj = get(str);
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            AppMethodBeat.m2505o(50130);
            return jSONObject;
        }
        JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] is not a JSONObject.");
        AppMethodBeat.m2505o(50130);
        throw jSONException;
    }

    public long getLong(String str) {
        AppMethodBeat.m2504i(50131);
        Object obj = get(str);
        try {
            long longValue;
            if (obj instanceof Number) {
                longValue = ((Number) obj).longValue();
                AppMethodBeat.m2505o(50131);
                return longValue;
            }
            longValue = Long.parseLong((String) obj);
            AppMethodBeat.m2505o(50131);
            return longValue;
        } catch (Exception e) {
            JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] is not a long.");
            AppMethodBeat.m2505o(50131);
            throw jSONException;
        }
    }

    public static String[] getNames(JSONObject jSONObject) {
        AppMethodBeat.m2504i(50132);
        int length = jSONObject.length();
        if (length == 0) {
            AppMethodBeat.m2505o(50132);
            return null;
        }
        Iterator keys = jSONObject.keys();
        String[] strArr = new String[length];
        length = 0;
        while (true) {
            int i = length;
            if (keys.hasNext()) {
                strArr[i] = (String) keys.next();
                length = i + 1;
            } else {
                AppMethodBeat.m2505o(50132);
                return strArr;
            }
        }
    }

    public static String[] getNames(Object obj) {
        String[] strArr = null;
        AppMethodBeat.m2504i(50133);
        if (obj == null) {
            AppMethodBeat.m2505o(50133);
        } else {
            Field[] fields = obj.getClass().getFields();
            int length = fields.length;
            if (length == 0) {
                AppMethodBeat.m2505o(50133);
            } else {
                strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = fields[i].getName();
                }
                AppMethodBeat.m2505o(50133);
            }
        }
        return strArr;
    }

    public String getString(String str) {
        AppMethodBeat.m2504i(50134);
        Object obj = get(str);
        if (obj instanceof String) {
            String str2 = (String) obj;
            AppMethodBeat.m2505o(50134);
            return str2;
        }
        JSONException jSONException = new JSONException("JSONObject[" + quote(str) + "] not a string.");
        AppMethodBeat.m2505o(50134);
        throw jSONException;
    }

    public boolean has(String str) {
        AppMethodBeat.m2504i(50135);
        boolean containsKey = this.map.containsKey(str);
        AppMethodBeat.m2505o(50135);
        return containsKey;
    }

    public JSONObject increment(String str) {
        AppMethodBeat.m2504i(50136);
        Object opt = opt(str);
        if (opt == null) {
            put(str, 1);
        } else if (opt instanceof Integer) {
            put(str, ((Integer) opt).intValue() + 1);
        } else if (opt instanceof Long) {
            put(str, ((Long) opt).longValue() + 1);
        } else if (opt instanceof Double) {
            put(str, ((Double) opt).doubleValue() + 1.0d);
        } else if (opt instanceof Float) {
            put(str, (double) (((Float) opt).floatValue() + 1.0f));
        } else {
            JSONException jSONException = new JSONException("Unable to increment [" + quote(str) + "].");
            AppMethodBeat.m2505o(50136);
            throw jSONException;
        }
        AppMethodBeat.m2505o(50136);
        return this;
    }

    public boolean isNull(String str) {
        AppMethodBeat.m2504i(50137);
        boolean equals = NULL.equals(opt(str));
        AppMethodBeat.m2505o(50137);
        return equals;
    }

    public Iterator keys() {
        AppMethodBeat.m2504i(50138);
        Iterator it = keySet().iterator();
        AppMethodBeat.m2505o(50138);
        return it;
    }

    public Set keySet() {
        AppMethodBeat.m2504i(50139);
        Set keySet = this.map.keySet();
        AppMethodBeat.m2505o(50139);
        return keySet;
    }

    public int length() {
        AppMethodBeat.m2504i(50140);
        int size = this.map.size();
        AppMethodBeat.m2505o(50140);
        return size;
    }

    public JSONArray names() {
        AppMethodBeat.m2504i(50141);
        JSONArray jSONArray = new JSONArray();
        Iterator keys = keys();
        while (keys.hasNext()) {
            jSONArray.put(keys.next());
        }
        if (jSONArray.length() == 0) {
            AppMethodBeat.m2505o(50141);
            return null;
        }
        AppMethodBeat.m2505o(50141);
        return jSONArray;
    }

    public static String numberToString(Number number) {
        AppMethodBeat.m2504i(50142);
        if (number == null) {
            JSONException jSONException = new JSONException("Null pointer");
            AppMethodBeat.m2505o(50142);
            throw jSONException;
        }
        testValidity(number);
        String obj = number.toString();
        if (obj.indexOf(46) > 0 && obj.indexOf(101) < 0 && obj.indexOf(69) < 0) {
            while (obj.endsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                obj = obj.substring(0, obj.length() - 1);
            }
            if (obj.endsWith(".")) {
                obj = obj.substring(0, obj.length() - 1);
            }
        }
        AppMethodBeat.m2505o(50142);
        return obj;
    }

    public Object opt(String str) {
        AppMethodBeat.m2504i(50143);
        if (str == null) {
            AppMethodBeat.m2505o(50143);
            return null;
        }
        Object obj = this.map.get(str);
        AppMethodBeat.m2505o(50143);
        return obj;
    }

    public boolean optBoolean(String str) {
        AppMethodBeat.m2504i(50144);
        boolean optBoolean = optBoolean(str, false);
        AppMethodBeat.m2505o(50144);
        return optBoolean;
    }

    public boolean optBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(50145);
        try {
            z = getBoolean(str);
            AppMethodBeat.m2505o(50145);
        } catch (Exception e) {
            AppMethodBeat.m2505o(50145);
        }
        return z;
    }

    public double optDouble(String str) {
        AppMethodBeat.m2504i(50146);
        double optDouble = optDouble(str, Double.NaN);
        AppMethodBeat.m2505o(50146);
        return optDouble;
    }

    public double optDouble(String str, double d) {
        AppMethodBeat.m2504i(50147);
        try {
            d = getDouble(str);
            AppMethodBeat.m2505o(50147);
        } catch (Exception e) {
            AppMethodBeat.m2505o(50147);
        }
        return d;
    }

    public int optInt(String str) {
        AppMethodBeat.m2504i(50148);
        int optInt = optInt(str, 0);
        AppMethodBeat.m2505o(50148);
        return optInt;
    }

    public int optInt(String str, int i) {
        AppMethodBeat.m2504i(50149);
        try {
            i = getInt(str);
            AppMethodBeat.m2505o(50149);
        } catch (Exception e) {
            AppMethodBeat.m2505o(50149);
        }
        return i;
    }

    public JSONArray optJSONArray(String str) {
        AppMethodBeat.m2504i(50150);
        Object opt = opt(str);
        if (opt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) opt;
            AppMethodBeat.m2505o(50150);
            return jSONArray;
        }
        AppMethodBeat.m2505o(50150);
        return null;
    }

    public JSONObject optJSONObject(String str) {
        AppMethodBeat.m2504i(50151);
        Object opt = opt(str);
        if (opt instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) opt;
            AppMethodBeat.m2505o(50151);
            return jSONObject;
        }
        AppMethodBeat.m2505o(50151);
        return null;
    }

    public long optLong(String str) {
        AppMethodBeat.m2504i(50152);
        long optLong = optLong(str, 0);
        AppMethodBeat.m2505o(50152);
        return optLong;
    }

    public long optLong(String str, long j) {
        AppMethodBeat.m2504i(50153);
        try {
            j = getLong(str);
            AppMethodBeat.m2505o(50153);
        } catch (Exception e) {
            AppMethodBeat.m2505o(50153);
        }
        return j;
    }

    public String optString(String str) {
        AppMethodBeat.m2504i(50154);
        String optString = optString(str, "");
        AppMethodBeat.m2505o(50154);
        return optString;
    }

    public String optString(String str, String str2) {
        AppMethodBeat.m2504i(50155);
        Object opt = opt(str);
        if (NULL.equals(opt)) {
            AppMethodBeat.m2505o(50155);
            return str2;
        }
        str2 = opt.toString();
        AppMethodBeat.m2505o(50155);
        return str2;
    }

    private void populateMap(Object obj) {
        int i;
        Method[] methods;
        int i2 = 0;
        AppMethodBeat.m2504i(50156);
        Class cls = obj.getClass();
        if (cls.getClassLoader() != null) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            methods = cls.getMethods();
        } else {
            methods = cls.getDeclaredMethods();
        }
        while (i2 < methods.length) {
            try {
                Method method = methods[i2];
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    Object obj2 = "";
                    if (name.startsWith("get")) {
                        if ("getClass".equals(name) || "getDeclaringClass".equals(name)) {
                            obj2 = "";
                        } else {
                            obj2 = name.substring(3);
                        }
                    } else if (name.startsWith("is")) {
                        obj2 = name.substring(2);
                    }
                    if (obj2.length() > 0 && Character.isUpperCase(obj2.charAt(0)) && method.getParameterTypes().length == 0) {
                        if (obj2.length() == 1) {
                            obj2 = obj2.toLowerCase();
                        } else if (!Character.isUpperCase(obj2.charAt(1))) {
                            obj2 = obj2.substring(0, 1).toLowerCase() + obj2.substring(1);
                        }
                        Object invoke = method.invoke(obj, null);
                        if (invoke != null) {
                            this.map.put(obj2, wrap(invoke));
                        }
                    }
                }
            } catch (Exception e) {
            }
            i2++;
        }
        AppMethodBeat.m2505o(50156);
    }

    public JSONObject put(String str, boolean z) {
        AppMethodBeat.m2504i(50157);
        put(str, z ? Boolean.TRUE : Boolean.FALSE);
        AppMethodBeat.m2505o(50157);
        return this;
    }

    public JSONObject put(String str, Collection collection) {
        AppMethodBeat.m2504i(50158);
        put(str, new JSONArray(collection));
        AppMethodBeat.m2505o(50158);
        return this;
    }

    public JSONObject put(String str, double d) {
        AppMethodBeat.m2504i(50159);
        put(str, Double.valueOf(d));
        AppMethodBeat.m2505o(50159);
        return this;
    }

    public JSONObject put(String str, int i) {
        AppMethodBeat.m2504i(50160);
        put(str, Integer.valueOf(i));
        AppMethodBeat.m2505o(50160);
        return this;
    }

    public JSONObject put(String str, long j) {
        AppMethodBeat.m2504i(50161);
        put(str, new Long(j));
        AppMethodBeat.m2505o(50161);
        return this;
    }

    public JSONObject put(String str, Map map) {
        AppMethodBeat.m2504i(50162);
        put(str, new JSONObject(map));
        AppMethodBeat.m2505o(50162);
        return this;
    }

    public JSONObject put(String str, Object obj) {
        AppMethodBeat.m2504i(50163);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("Null key.");
            AppMethodBeat.m2505o(50163);
            throw nullPointerException;
        }
        if (obj != null) {
            testValidity(obj);
            this.map.put(str, obj);
        } else {
            remove(str);
        }
        AppMethodBeat.m2505o(50163);
        return this;
    }

    public JSONObject putOnce(String str, Object obj) {
        AppMethodBeat.m2504i(50164);
        if (!(str == null || obj == null)) {
            if (opt(str) != null) {
                JSONException jSONException = new JSONException("Duplicate key \"" + str + "\"");
                AppMethodBeat.m2505o(50164);
                throw jSONException;
            }
            put(str, obj);
        }
        AppMethodBeat.m2505o(50164);
        return this;
    }

    public JSONObject putOpt(String str, Object obj) {
        AppMethodBeat.m2504i(50165);
        if (!(str == null || obj == null)) {
            put(str, obj);
        }
        AppMethodBeat.m2505o(50165);
        return this;
    }

    public static String quote(String str) {
        String obj;
        AppMethodBeat.m2504i(50166);
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                obj = quote(str, stringWriter).toString();
            } catch (IOException e) {
                obj = "";
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(50166);
            }
        }
        return obj;
    }

    public static Writer quote(String str, Writer writer) {
        AppMethodBeat.m2504i(50167);
        if (str == null || str.length() == 0) {
            writer.write("\"\"");
            AppMethodBeat.m2505o(50167);
        } else {
            int length = str.length();
            writer.write(34);
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case 8:
                        writer.write("\\b");
                        continue;
                    case 9:
                        writer.write("\\t");
                        continue;
                    case 10:
                        writer.write("\\n");
                        continue;
                    case 12:
                        writer.write("\\f");
                        continue;
                    case 13:
                        writer.write("\\r");
                        continue;
                    case '\"':
                    case '\\':
                        writer.write(92);
                        break;
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                        if (i2 == 60) {
                            writer.write(92);
                        }
                        writer.write(charAt);
                        continue;
                    default:
                        if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                            writer.write("\\u");
                            String toHexString = Integer.toHexString(charAt);
                            writer.write("0000", 0, 4 - toHexString.length());
                            writer.write(toHexString);
                            continue;
                        }
                }
                writer.write(charAt);
                i++;
                char i22 = charAt;
            }
            writer.write(34);
            AppMethodBeat.m2505o(50167);
        }
        return writer;
    }

    public Object remove(String str) {
        AppMethodBeat.m2504i(50168);
        Object remove = this.map.remove(str);
        AppMethodBeat.m2505o(50168);
        return remove;
    }

    public static Object stringToValue(String str) {
        AppMethodBeat.m2504i(50169);
        Object obj;
        if (str.equals("")) {
            AppMethodBeat.m2505o(50169);
            return str;
        } else if (str.equalsIgnoreCase("true")) {
            obj = Boolean.TRUE;
            AppMethodBeat.m2505o(50169);
            return obj;
        } else if (str.equalsIgnoreCase("false")) {
            obj = Boolean.FALSE;
            AppMethodBeat.m2505o(50169);
            return obj;
        } else if (str.equalsIgnoreCase(BuildConfig.COMMAND)) {
            obj = NULL;
            AppMethodBeat.m2505o(50169);
            return obj;
        } else {
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                try {
                    if (str.indexOf(46) >= 0 || str.indexOf(101) >= 0 || str.indexOf(69) >= 0) {
                        Double valueOf = Double.valueOf(str);
                        if (!(valueOf.isInfinite() || valueOf.isNaN())) {
                            AppMethodBeat.m2505o(50169);
                            return valueOf;
                        }
                    }
                    Long l = new Long(str);
                    if (str.equals(l.toString())) {
                        if (l.longValue() == ((long) l.intValue())) {
                            Integer num = new Integer(l.intValue());
                            AppMethodBeat.m2505o(50169);
                            return num;
                        }
                        AppMethodBeat.m2505o(50169);
                        return l;
                    }
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(50169);
            return str;
        }
    }

    public static void testValidity(Object obj) {
        AppMethodBeat.m2504i(50170);
        if (obj != null) {
            JSONException jSONException;
            if (obj instanceof Double) {
                if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                    jSONException = new JSONException("JSON does not allow non-finite numbers.");
                    AppMethodBeat.m2505o(50170);
                    throw jSONException;
                }
            } else if ((obj instanceof Float) && (((Float) obj).isInfinite() || ((Float) obj).isNaN())) {
                jSONException = new JSONException("JSON does not allow non-finite numbers.");
                AppMethodBeat.m2505o(50170);
                throw jSONException;
            }
        }
        AppMethodBeat.m2505o(50170);
    }

    public JSONArray toJSONArray(JSONArray jSONArray) {
        AppMethodBeat.m2504i(50171);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(50171);
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONArray2.put(opt(jSONArray.getString(i)));
        }
        AppMethodBeat.m2505o(50171);
        return jSONArray2;
    }

    public String toString() {
        AppMethodBeat.m2504i(50172);
        try {
            String jSONObject = toString(0);
            AppMethodBeat.m2505o(50172);
            return jSONObject;
        } catch (Exception e) {
            AppMethodBeat.m2505o(50172);
            return null;
        }
    }

    public String toString(int i) {
        String obj;
        AppMethodBeat.m2504i(50173);
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            try {
                obj = write(stringWriter, i, 0).toString();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(50173);
            }
        }
        return obj;
    }

    public static String valueToString(Object obj) {
        AppMethodBeat.m2504i(50174);
        String str;
        if (obj == null || obj.equals(null)) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(50174);
            return str;
        } else if (obj instanceof JSONString) {
            JSONException jSONException;
            try {
                str = ((JSONString) obj).toJSONString();
                if (str instanceof String) {
                    str = str;
                    AppMethodBeat.m2505o(50174);
                    return str;
                }
                jSONException = new JSONException("Bad value from toJSONString: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(50174);
                throw jSONException;
            } catch (Exception e) {
                jSONException = new JSONException(e);
                AppMethodBeat.m2505o(50174);
                throw jSONException;
            }
        } else if (obj instanceof Number) {
            str = numberToString((Number) obj);
            AppMethodBeat.m2505o(50174);
            return str;
        } else if ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            str = obj.toString();
            AppMethodBeat.m2505o(50174);
            return str;
        } else if (obj instanceof Map) {
            str = new JSONObject((Map) obj).toString();
            AppMethodBeat.m2505o(50174);
            return str;
        } else if (obj instanceof Collection) {
            str = new JSONArray((Collection) obj).toString();
            AppMethodBeat.m2505o(50174);
            return str;
        } else if (obj.getClass().isArray()) {
            str = new JSONArray(obj).toString();
            AppMethodBeat.m2505o(50174);
            return str;
        } else {
            str = quote(obj.toString());
            AppMethodBeat.m2505o(50174);
            return str;
        }
    }

    public static Object wrap(Object obj) {
        AppMethodBeat.m2504i(50175);
        JSONArray jSONArray;
        JSONObject jSONObject;
        if (obj == null) {
            try {
                obj = NULL;
                AppMethodBeat.m2505o(50175);
                return obj;
            } catch (Exception e) {
                AppMethodBeat.m2505o(50175);
                return null;
            }
        } else if ((obj instanceof JSONObject) || (obj instanceof JSONArray) || NULL.equals(obj) || (obj instanceof JSONString) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String)) {
            AppMethodBeat.m2505o(50175);
            return obj;
        } else if (obj instanceof Collection) {
            jSONArray = new JSONArray((Collection) obj);
            AppMethodBeat.m2505o(50175);
            return jSONArray;
        } else if (obj.getClass().isArray()) {
            jSONArray = new JSONArray(obj);
            AppMethodBeat.m2505o(50175);
            return jSONArray;
        } else if (obj instanceof Map) {
            jSONObject = new JSONObject((Map) obj);
            AppMethodBeat.m2505o(50175);
            return jSONObject;
        } else {
            Package packageR = obj.getClass().getPackage();
            String name = packageR != null ? packageR.getName() : "";
            if (name.startsWith("java.") || name.startsWith("javax.") || obj.getClass().getClassLoader() == null) {
                obj = obj.toString();
                AppMethodBeat.m2505o(50175);
                return obj;
            }
            jSONObject = new JSONObject(obj);
            AppMethodBeat.m2505o(50175);
            return jSONObject;
        }
    }

    public Writer write(Writer writer) {
        AppMethodBeat.m2504i(50176);
        Writer write = write(writer, 0, 0);
        AppMethodBeat.m2505o(50176);
        return write;
    }

    static final Writer writeValue(Writer writer, Object obj, int i, int i2) {
        AppMethodBeat.m2504i(50177);
        if (obj == null || obj.equals(null)) {
            writer.write(BuildConfig.COMMAND);
        } else if (obj instanceof JSONObject) {
            ((JSONObject) obj).write(writer, i, i2);
        } else if (obj instanceof JSONArray) {
            ((JSONArray) obj).write(writer, i, i2);
        } else if (obj instanceof Map) {
            new JSONObject((Map) obj).write(writer, i, i2);
        } else if (obj instanceof Collection) {
            new JSONArray((Collection) obj).write(writer, i, i2);
        } else if (obj.getClass().isArray()) {
            new JSONArray(obj).write(writer, i, i2);
        } else if (obj instanceof Number) {
            writer.write(numberToString((Number) obj));
        } else if (obj instanceof Boolean) {
            writer.write(obj.toString());
        } else if (obj instanceof JSONString) {
            try {
                String toJSONString = ((JSONString) obj).toJSONString();
                writer.write(toJSONString != null ? toJSONString.toString() : quote(obj.toString()));
            } catch (Exception e) {
                JSONException jSONException = new JSONException(e);
                AppMethodBeat.m2505o(50177);
                throw jSONException;
            }
        } else {
            quote(obj.toString(), writer);
        }
        AppMethodBeat.m2505o(50177);
        return writer;
    }

    static final void indent(Writer writer, int i) {
        AppMethodBeat.m2504i(50178);
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(32);
        }
        AppMethodBeat.m2505o(50178);
    }

    /* Access modifiers changed, original: 0000 */
    public Writer write(Writer writer, int i, int i2) {
        AppMethodBeat.m2504i(50179);
        Object obj = null;
        try {
            int length = length();
            Iterator keys = keys();
            writer.write(123);
            if (length == 1) {
                obj = keys.next();
                writer.write(quote(obj.toString()));
                writer.write(58);
                if (i > 0) {
                    writer.write(32);
                }
                writeValue(writer, this.map.get(obj), i, i2);
            } else if (length != 0) {
                length = i2 + i;
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (obj != null) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    indent(writer, length);
                    writer.write(quote(next.toString()));
                    writer.write(58);
                    if (i > 0) {
                        writer.write(32);
                    }
                    writeValue(writer, this.map.get(next), i, length);
                    int obj2 = 1;
                }
                if (i > 0) {
                    writer.write(10);
                }
                indent(writer, i2);
            }
            writer.write(125);
            AppMethodBeat.m2505o(50179);
            return writer;
        } catch (IOException e) {
            JSONException jSONException = new JSONException(e);
            AppMethodBeat.m2505o(50179);
            throw jSONException;
        }
    }
}
