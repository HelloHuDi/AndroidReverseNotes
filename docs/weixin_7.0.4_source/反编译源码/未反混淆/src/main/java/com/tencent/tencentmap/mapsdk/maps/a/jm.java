package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.widget.j;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tencentmap.mapsdk.a.w;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class jm extends AsyncTask<Object, Void, Boolean> {
    private static String a;
    private Context b;
    private WeakReference<a> c;

    public interface a {
        void a(boolean z);
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(100070);
        Boolean a = a(objArr);
        AppMethodBeat.o(100070);
        return a;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(100069);
        a((Boolean) obj);
        AppMethodBeat.o(100069);
    }

    public jm(Context context, a aVar) {
        AppMethodBeat.i(100063);
        this.b = context;
        a = "https://overseactrl.map.qq.com/?" + a(context);
        this.c = new WeakReference(aVar);
        AppMethodBeat.o(100063);
    }

    public String a(Context context) {
        AppMethodBeat.i(100064);
        String format = String.format("apikey=%s&ver=%s&ctrlver=%s&uk=%s&frontier=%s&ctrlpf=vector&ctrlmb=and", new Object[]{ic.a, "4.2.2", Integer.valueOf(w.a(context).b("worldMapProtocolVersion")), ic.a(), Integer.valueOf(w.a(context).b("worldMapFrontierVersion"))});
        AppMethodBeat.o(100064);
        return format;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Boolean a(Object... objArr) {
        Boolean valueOf;
        AppMethodBeat.i(100065);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream gZIPInputStream;
                String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                Object obj = (headerField == null || headerField.length() <= 0 || !headerField.toLowerCase().contains("gzip")) ? null : 1;
                if (obj != null) {
                    gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                } else {
                    gZIPInputStream = httpURLConnection.getInputStream();
                }
                valueOf = Boolean.valueOf(b(new String(v.a(gZIPInputStream))));
                AppMethodBeat.o(100065);
                return valueOf;
            }
        } catch (Throwable th) {
        }
        valueOf = Boolean.FALSE;
        AppMethodBeat.o(100065);
        return valueOf;
    }

    /* Access modifiers changed, original: protected */
    public void a(Boolean bool) {
        AppMethodBeat.i(100066);
        super.onPostExecute(bool);
        if (!(this.c == null || this.c.get() == null)) {
            ((a) this.c.get()).a(bool.booleanValue());
        }
        AppMethodBeat.o(100066);
    }

    private boolean b(String str) {
        AppMethodBeat.i(100067);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(100067);
            return false;
        }
        try {
            boolean d;
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("error", j.INVALID_ID) != 0) {
                d = (lq.d() ^ 0) | 0;
                lq.a(false);
                w.a(this.b).a("worldMapEnabled", false);
            } else {
                d = (lq.d() ^ 1) | 0;
                lq.a(true);
                w.a(this.b).a("worldMapEnabled", true);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject == null) {
                AppMethodBeat.o(100067);
                return d;
            }
            int optInt = optJSONObject.optInt("version");
            boolean z = d | (optInt != lq.f() ? 1 : 0);
            if (z) {
                String str2;
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("frontier");
                if (optJSONObject2 != null) {
                    a(optJSONObject2.optString("path"));
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("tilesrc");
                int i = -1;
                int i2 = -1;
                int i3 = -1;
                String str3 = null;
                int[] iArr = new int[0];
                String str4 = "[]";
                if (optJSONObject3 != null) {
                    int optInt2 = optJSONObject3.optInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, 1000);
                    int optInt3 = optJSONObject3.optInt("scene", lr.a);
                    int optInt4 = optJSONObject3.optInt("version", lr.b);
                    str3 = optJSONObject3.optString("url");
                    JSONArray optJSONArray = optJSONObject3.optJSONArray("range");
                    if (!(StringUtil.isEmpty(str3) || optJSONArray == null)) {
                        String jSONArray = optJSONArray.toString();
                        int[] iArr2 = new int[optJSONArray.length()];
                        for (i2 = 0; i2 < iArr2.length; i2++) {
                            iArr2[i2] = optJSONArray.optInt(i2);
                        }
                        str4 = jSONArray;
                        iArr = iArr2;
                    }
                    if (!(optInt4 == lq.c() && optInt2 == lq.a())) {
                        ll.a(this.b).a(0);
                    }
                    str2 = str4;
                    i3 = optInt4;
                    i2 = optInt3;
                    i = optInt2;
                } else {
                    str2 = str4;
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("detail");
                str4 = "";
                if (optJSONArray2 != null) {
                    str4 = optJSONArray2.toString();
                }
                lq.a(i2, i, i3, optInt, str3, iArr, str4);
                w.a(this.b).a("worldMapTileUrlRegex", str3);
                w.a(this.b).a("worldMapTileUrlRangeJson", str2);
                w.a(this.b).a("worldMapVersion", i3);
                w.a(this.b).a("worldMapStyle", i);
                w.a(this.b).a("worldMapScene", i2);
                w.a(this.b).a("worldMapLogoChangeRuleJson", str4);
                w.a(this.b).a("worldMapProtocolVersion", optInt);
                AppMethodBeat.o(100067);
                return z;
            }
            AppMethodBeat.o(100067);
            return z;
        } catch (Exception e) {
            w.a(this.b).a("worldMapProtocolVersion", 0);
            AppMethodBeat.o(100067);
            return false;
        }
    }

    public void a(String str) {
        AppMethodBeat.i(100068);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(100068);
            return;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            if (httpURLConnection.getResponseCode() == 200) {
                String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                if (headerField != null && headerField.length() > 0) {
                    headerField.toLowerCase().contains("gzip");
                }
                String str2 = new String(v.a(new GZIPInputStream(httpURLConnection.getInputStream())));
                w.a(this.b).a("worldMapFrontierVersion", ln.a().b(str2));
                ln.a().a(str2);
            }
            AppMethodBeat.o(100068);
        } catch (Throwable th) {
            AppMethodBeat.o(100068);
        }
    }
}
