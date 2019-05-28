package com.tencent.luggage.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static String p(Context context, String str) {
        AppMethodBeat.i(90912);
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
        } catch (Exception e) {
            d.e("Util", "openRead file( %s ) failed, exp = %s", str, e);
        }
        String str2;
        if (inputStream == null) {
            str2 = "";
            AppMethodBeat.o(90912);
            return str2;
        }
        str2 = convertStreamToString(inputStream);
        AppMethodBeat.o(90912);
        return str2;
    }

    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(90913);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            String stringWriter2;
            try {
                int read = inputStreamReader.read(cArr);
                if (-1 != read) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    b(inputStreamReader);
                    b(inputStream);
                    stringWriter2 = stringWriter.toString();
                    AppMethodBeat.o(90913);
                    return stringWriter2;
                }
            } catch (Exception e) {
                d.e("Util", "convertStreamToString: read, %s", e.getMessage());
                stringWriter2 = "";
                return stringWriter2;
            } finally {
                b(inputStreamReader);
                b(inputStream);
                AppMethodBeat.o(90913);
            }
        }
    }

    public static byte[] k(InputStream inputStream) {
        byte[] bArr = null;
        AppMethodBeat.i(90914);
        if (inputStream == null) {
            AppMethodBeat.o(90914);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr2, 0, 4096);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception e) {
                d.e("Util", "readPkgCertificate: ".concat(String.valueOf(e)));
                return bArr;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    d.e("Util", "close: ".concat(String.valueOf(e2)));
                }
                AppMethodBeat.o(90914);
            }
        }
        byteArrayOutputStream.flush();
        try {
            inputStream.close();
        } catch (Exception e3) {
            d.e("Util", "close: ".concat(String.valueOf(e3)));
        }
        bArr = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(90914);
        return bArr;
    }

    public static void b(Closeable closeable) {
        AppMethodBeat.i(90915);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                d.printErrStackTrace("Util", e, "qualityClose", new Object[0]);
                AppMethodBeat.o(90915);
                return;
            }
        }
        AppMethodBeat.o(90915);
    }

    public static void d(Map map) {
        AppMethodBeat.i(90916);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                d((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.o(90916);
    }

    public static JSONArray D(List<? extends Object> list) {
        AppMethodBeat.i(90917);
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(90917);
            return jSONArray;
        }
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i));
        }
        AppMethodBeat.o(90917);
        return jSONArray;
    }

    public static JSONObject bQ(String str) {
        AppMethodBeat.i(90918);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(90918);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.o(90918);
            return jSONObject;
        } catch (JSONException e) {
            AppMethodBeat.o(90918);
            return null;
        }
    }
}
