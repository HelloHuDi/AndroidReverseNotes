package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tencentmap.mapsdk.p666a.C16193dt;
import com.tencent.tencentmap.mapsdk.p666a.C16201o;
import com.tencent.tencentmap.mapsdk.p666a.C31006ds;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jl */
public class C16289jl extends AsyncTask<Object, Void, Void> {
    /* renamed from: a */
    private Handler f3453a;
    /* renamed from: b */
    private String f3454b;
    /* renamed from: c */
    private WeakReference<C16287jk> f3455c;

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(100062);
        Void a = mo29536a(objArr);
        AppMethodBeat.m2505o(100062);
        return a;
    }

    public C16289jl(Handler handler, C16287jk c16287jk, String str, String str2) {
        AppMethodBeat.m2504i(100055);
        this.f3453a = handler;
        this.f3455c = new WeakReference(c16287jk);
        this.f3454b = C36520ic.m60476a(str, str2);
        AppMethodBeat.m2505o(100055);
    }

    /* renamed from: a */
    public void mo29537a() {
        JSONObject jSONObject = null;
        AppMethodBeat.m2504i(100056);
        try {
            C16193dt a = C31006ds.m49791a().mo50281a(this.f3454b);
            if (a == null) {
                AppMethodBeat.m2505o(100056);
                return;
            }
            try {
                try {
                    JSONObject jSONObject2;
                    int i;
                    String string;
                    JSONObject jSONObject3 = new JSONObject(new String(a.f3096a, a.f3097b));
                    try {
                        jSONObject2 = jSONObject3.getJSONObject("detail");
                    } catch (Exception e) {
                        jSONObject2 = jSONObject;
                    }
                    try {
                        m25089a(jSONObject2.getJSONObject("cfg"));
                    } catch (Exception e2) {
                        m25089a(jSONObject);
                    }
                    try {
                        jSONObject = jSONObject3.getJSONObject("info");
                    } catch (Exception e3) {
                    }
                    try {
                        i = jSONObject.getInt("error");
                    } catch (Exception e4) {
                        i = 0;
                    }
                    String str = "";
                    try {
                        string = jSONObject.getString("msg");
                    } catch (JSONException e5) {
                        string = str;
                    }
                    if (i == 0) {
                        C36520ic.f15400e = 0;
                    } else {
                        m25088a(i, string);
                        if (i < -400) {
                            C36520ic.f15400e = -1;
                        } else {
                            C36520ic.f15400e = 1;
                        }
                    }
                    C36520ic.f15401f = Calendar.getInstance().get(1);
                    C36520ic.f15402g = Calendar.getInstance().get(2);
                    C36520ic.f15403h = Calendar.getInstance().get(5);
                    m25091b();
                    AppMethodBeat.m2505o(100056);
                } catch (Exception e6) {
                    AppMethodBeat.m2505o(100056);
                }
            } catch (UnsupportedEncodingException e7) {
                AppMethodBeat.m2505o(100056);
            }
        } catch (Exception e8) {
            AppMethodBeat.m2505o(100056);
        }
    }

    /* renamed from: a */
    private void m25089a(JSONObject jSONObject) {
        AppMethodBeat.m2504i(100057);
        if (jSONObject == null) {
            if (!(this.f3455c == null || this.f3455c.get() == null)) {
                ((C16287jk) this.f3455c.get()).mo29532a(null, null);
            }
            AppMethodBeat.m2505o(100057);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
        C16201o b = m25090b(jSONObject.optJSONObject("indoor_map"));
        if (!(this.f3455c == null || this.f3455c.get() == null)) {
            ((C16287jk) this.f3455c.get()).mo29532a(optJSONArray, b);
        }
        AppMethodBeat.m2505o(100057);
    }

    /* renamed from: b */
    private C16201o m25090b(JSONObject jSONObject) {
        AppMethodBeat.m2504i(100058);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(100058);
            return null;
        }
        int optInt = jSONObject.optInt("enable", -1);
        int optInt2 = jSONObject.optInt("type", -1);
        if (optInt == -1 || optInt2 == -1) {
            AppMethodBeat.m2505o(100058);
            return null;
        }
        C16201o c16201o = new C16201o(optInt, optInt2, jSONObject.optJSONArray("building_list"));
        AppMethodBeat.m2505o(100058);
        return c16201o;
    }

    /* Access modifiers changed, original: protected|varargs */
    /* renamed from: a */
    public Void mo29536a(Object... objArr) {
        AppMethodBeat.m2504i(100059);
        mo29537a();
        AppMethodBeat.m2505o(100059);
        return null;
    }

    /* renamed from: b */
    private void m25091b() {
        AppMethodBeat.m2504i(100060);
        if (this.f3453a != null) {
            C31076li c31076li = new C31076li();
            c31076li.f14311a = 3;
            this.f3453a.sendMessage(this.f3453a.obtainMessage(c31076li.f14311a, c31076li));
        }
        AppMethodBeat.m2505o(100060);
    }

    /* renamed from: a */
    private void m25088a(int i, String str) {
        AppMethodBeat.m2504i(100061);
        ArrayList<String> arrayList = new ArrayList(4);
        arrayList.add("腾讯地图鉴权失败，请访问 lbs.qq.com 检查 key 配置");
        arrayList.add("错误码：".concat(String.valueOf(i)));
        arrayList.add("错误信息：".concat(String.valueOf(str)));
        StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        stringBuilder.append("Auth Fail:\n");
        char[] cArr = new char[81];
        Arrays.fill(cArr, '*');
        cArr[80] = 10;
        stringBuilder.append(cArr);
        for (String append : arrayList) {
            stringBuilder.append(append).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append(cArr);
        AppMethodBeat.m2505o(100061);
    }
}
