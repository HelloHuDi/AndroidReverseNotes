package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.os.AsyncTask;
import android.support.p057v4.widget.C8415j;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jm */
public class C16290jm extends AsyncTask<Object, Void, Boolean> {
    /* renamed from: a */
    private static String f3456a;
    /* renamed from: b */
    private Context f3457b;
    /* renamed from: c */
    private WeakReference<C16291a> f3458c;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jm$a */
    public interface C16291a {
        /* renamed from: a */
        void mo29533a(boolean z);
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(100070);
        Boolean a = mo29539a(objArr);
        AppMethodBeat.m2505o(100070);
        return a;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(100069);
        mo29541a((Boolean) obj);
        AppMethodBeat.m2505o(100069);
    }

    public C16290jm(Context context, C16291a c16291a) {
        AppMethodBeat.m2504i(100063);
        this.f3457b = context;
        f3456a = "https://overseactrl.map.qq.com/?" + mo29540a(context);
        this.f3458c = new WeakReference(c16291a);
        AppMethodBeat.m2505o(100063);
    }

    /* renamed from: a */
    public String mo29540a(Context context) {
        AppMethodBeat.m2504i(100064);
        String format = String.format("apikey=%s&ver=%s&ctrlver=%s&uk=%s&frontier=%s&ctrlpf=vector&ctrlmb=and", new Object[]{C36520ic.f15396a, "4.2.2", Integer.valueOf(C31016w.m49806a(context).mo65087b("worldMapProtocolVersion")), C36520ic.m60473a(), Integer.valueOf(C31016w.m49806a(context).mo65087b("worldMapFrontierVersion"))});
        AppMethodBeat.m2505o(100064);
        return format;
    }

    /* Access modifiers changed, original: protected|varargs */
    /* renamed from: a */
    public Boolean mo29539a(Object... objArr) {
        Boolean valueOf;
        AppMethodBeat.m2504i(100065);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(f3456a).openConnection();
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
                valueOf = Boolean.valueOf(m25094b(new String(C31015v.m49803a(gZIPInputStream))));
                AppMethodBeat.m2505o(100065);
                return valueOf;
            }
        } catch (Throwable th) {
        }
        valueOf = Boolean.FALSE;
        AppMethodBeat.m2505o(100065);
        return valueOf;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29541a(Boolean bool) {
        AppMethodBeat.m2504i(100066);
        super.onPostExecute(bool);
        if (!(this.f3458c == null || this.f3458c.get() == null)) {
            ((C16291a) this.f3458c.get()).mo29533a(bool.booleanValue());
        }
        AppMethodBeat.m2505o(100066);
    }

    /* renamed from: b */
    private boolean m25094b(String str) {
        AppMethodBeat.m2504i(100067);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(100067);
            return false;
        }
        try {
            boolean d;
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("error", C8415j.INVALID_ID) != 0) {
                d = (C24414lq.m37993d() ^ 0) | 0;
                C24414lq.m37990a(false);
                C31016w.m49806a(this.f3457b).mo65085a("worldMapEnabled", false);
            } else {
                d = (C24414lq.m37993d() ^ 1) | 0;
                C24414lq.m37990a(true);
                C31016w.m49806a(this.f3457b).mo65085a("worldMapEnabled", true);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("info");
            if (optJSONObject == null) {
                AppMethodBeat.m2505o(100067);
                return d;
            }
            int optInt = optJSONObject.optInt("version");
            boolean z = d | (optInt != C24414lq.m37995f() ? 1 : 0);
            if (z) {
                String str2;
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("frontier");
                if (optJSONObject2 != null) {
                    mo29542a(optJSONObject2.optString("path"));
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
                    int optInt3 = optJSONObject3.optInt("scene", C36532lr.f15447a);
                    int optInt4 = optJSONObject3.optInt("version", C36532lr.f15448b);
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
                    if (!(optInt4 == C24414lq.m37992c() && optInt2 == C24414lq.m37987a())) {
                        C41073ll.m71458a(this.f3457b).mo65168a(0);
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
                C24414lq.m37988a(i2, i, i3, optInt, str3, iArr, str4);
                C31016w.m49806a(this.f3457b).mo65084a("worldMapTileUrlRegex", str3);
                C31016w.m49806a(this.f3457b).mo65084a("worldMapTileUrlRangeJson", str2);
                C31016w.m49806a(this.f3457b).mo65082a("worldMapVersion", i3);
                C31016w.m49806a(this.f3457b).mo65082a("worldMapStyle", i);
                C31016w.m49806a(this.f3457b).mo65082a("worldMapScene", i2);
                C31016w.m49806a(this.f3457b).mo65084a("worldMapLogoChangeRuleJson", str4);
                C31016w.m49806a(this.f3457b).mo65082a("worldMapProtocolVersion", optInt);
                AppMethodBeat.m2505o(100067);
                return z;
            }
            AppMethodBeat.m2505o(100067);
            return z;
        } catch (Exception e) {
            C31016w.m49806a(this.f3457b).mo65082a("worldMapProtocolVersion", 0);
            AppMethodBeat.m2505o(100067);
            return false;
        }
    }

    /* renamed from: a */
    public void mo29542a(String str) {
        AppMethodBeat.m2504i(100068);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(100068);
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
                String str2 = new String(C31015v.m49803a(new GZIPInputStream(httpURLConnection.getInputStream())));
                C31016w.m49806a(this.f3457b).mo65082a("worldMapFrontierVersion", C46801ln.m88998a().mo75518b(str2));
                C46801ln.m88998a().mo75517a(str2);
            }
            AppMethodBeat.m2505o(100068);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(100068);
        }
    }
}
