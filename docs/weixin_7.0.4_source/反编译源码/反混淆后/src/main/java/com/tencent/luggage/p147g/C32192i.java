package com.tencent.luggage.p147g;

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

/* renamed from: com.tencent.luggage.g.i */
public final class C32192i {
    /* renamed from: p */
    public static String m52511p(Context context, String str) {
        AppMethodBeat.m2504i(90912);
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
        } catch (Exception e) {
            C45124d.m82928e("Util", "openRead file( %s ) failed, exp = %s", str, e);
        }
        String str2;
        if (inputStream == null) {
            str2 = "";
            AppMethodBeat.m2505o(90912);
            return str2;
        }
        str2 = C32192i.convertStreamToString(inputStream);
        AppMethodBeat.m2505o(90912);
        return str2;
    }

    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.m2504i(90913);
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
                    C32192i.m52507b(inputStreamReader);
                    C32192i.m52507b(inputStream);
                    stringWriter2 = stringWriter.toString();
                    AppMethodBeat.m2505o(90913);
                    return stringWriter2;
                }
            } catch (Exception e) {
                C45124d.m82928e("Util", "convertStreamToString: read, %s", e.getMessage());
                stringWriter2 = "";
                return stringWriter2;
            } finally {
                C32192i.m52507b(inputStreamReader);
                C32192i.m52507b(inputStream);
                AppMethodBeat.m2505o(90913);
            }
        }
    }

    /* renamed from: k */
    public static byte[] m52510k(InputStream inputStream) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(90914);
        if (inputStream == null) {
            AppMethodBeat.m2505o(90914);
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
                C45124d.m82927e("Util", "readPkgCertificate: ".concat(String.valueOf(e)));
                return bArr;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    C45124d.m82927e("Util", "close: ".concat(String.valueOf(e2)));
                }
                AppMethodBeat.m2505o(90914);
            }
        }
        byteArrayOutputStream.flush();
        try {
            inputStream.close();
        } catch (Exception e3) {
            C45124d.m82927e("Util", "close: ".concat(String.valueOf(e3)));
        }
        bArr = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(90914);
        return bArr;
    }

    /* renamed from: b */
    public static void m52507b(Closeable closeable) {
        AppMethodBeat.m2504i(90915);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C45124d.printErrStackTrace("Util", e, "qualityClose", new Object[0]);
                AppMethodBeat.m2505o(90915);
                return;
            }
        }
        AppMethodBeat.m2505o(90915);
    }

    /* renamed from: d */
    public static void m52509d(Map map) {
        AppMethodBeat.m2504i(90916);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                C32192i.m52509d((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.m2505o(90916);
    }

    /* renamed from: D */
    public static JSONArray m52506D(List<? extends Object> list) {
        AppMethodBeat.m2504i(90917);
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(90917);
            return jSONArray;
        }
        for (int i = 0; i < list.size(); i++) {
            jSONArray.put(list.get(i));
        }
        AppMethodBeat.m2505o(90917);
        return jSONArray;
    }

    /* renamed from: bQ */
    public static JSONObject m52508bQ(String str) {
        AppMethodBeat.m2504i(90918);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(90918);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppMethodBeat.m2505o(90918);
            return jSONObject;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(90918);
            return null;
        }
    }
}
