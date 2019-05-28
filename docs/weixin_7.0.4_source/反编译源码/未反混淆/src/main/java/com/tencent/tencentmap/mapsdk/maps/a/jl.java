package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tencentmap.mapsdk.a.ds;
import com.tencent.tencentmap.mapsdk.a.dt;
import com.tencent.tencentmap.mapsdk.a.o;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jl extends AsyncTask<Object, Void, Void> {
    private Handler a;
    private String b;
    private WeakReference<jk> c;

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(100062);
        Void a = a(objArr);
        AppMethodBeat.o(100062);
        return a;
    }

    public jl(Handler handler, jk jkVar, String str, String str2) {
        AppMethodBeat.i(100055);
        this.a = handler;
        this.c = new WeakReference(jkVar);
        this.b = ic.a(str, str2);
        AppMethodBeat.o(100055);
    }

    public void a() {
        JSONObject jSONObject = null;
        AppMethodBeat.i(100056);
        try {
            dt a = ds.a().a(this.b);
            if (a == null) {
                AppMethodBeat.o(100056);
                return;
            }
            try {
                try {
                    JSONObject jSONObject2;
                    int i;
                    String string;
                    JSONObject jSONObject3 = new JSONObject(new String(a.a, a.b));
                    try {
                        jSONObject2 = jSONObject3.getJSONObject("detail");
                    } catch (Exception e) {
                        jSONObject2 = jSONObject;
                    }
                    try {
                        a(jSONObject2.getJSONObject("cfg"));
                    } catch (Exception e2) {
                        a(jSONObject);
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
                        ic.e = 0;
                    } else {
                        a(i, string);
                        if (i < -400) {
                            ic.e = -1;
                        } else {
                            ic.e = 1;
                        }
                    }
                    ic.f = Calendar.getInstance().get(1);
                    ic.g = Calendar.getInstance().get(2);
                    ic.h = Calendar.getInstance().get(5);
                    b();
                    AppMethodBeat.o(100056);
                } catch (Exception e6) {
                    AppMethodBeat.o(100056);
                }
            } catch (UnsupportedEncodingException e7) {
                AppMethodBeat.o(100056);
            }
        } catch (Exception e8) {
            AppMethodBeat.o(100056);
        }
    }

    private void a(JSONObject jSONObject) {
        AppMethodBeat.i(100057);
        if (jSONObject == null) {
            if (!(this.c == null || this.c.get() == null)) {
                ((jk) this.c.get()).a(null, null);
            }
            AppMethodBeat.o(100057);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
        o b = b(jSONObject.optJSONObject("indoor_map"));
        if (!(this.c == null || this.c.get() == null)) {
            ((jk) this.c.get()).a(optJSONArray, b);
        }
        AppMethodBeat.o(100057);
    }

    private o b(JSONObject jSONObject) {
        AppMethodBeat.i(100058);
        if (jSONObject == null) {
            AppMethodBeat.o(100058);
            return null;
        }
        int optInt = jSONObject.optInt("enable", -1);
        int optInt2 = jSONObject.optInt("type", -1);
        if (optInt == -1 || optInt2 == -1) {
            AppMethodBeat.o(100058);
            return null;
        }
        o oVar = new o(optInt, optInt2, jSONObject.optJSONArray("building_list"));
        AppMethodBeat.o(100058);
        return oVar;
    }

    /* Access modifiers changed, original: protected|varargs */
    public Void a(Object... objArr) {
        AppMethodBeat.i(100059);
        a();
        AppMethodBeat.o(100059);
        return null;
    }

    private void b() {
        AppMethodBeat.i(100060);
        if (this.a != null) {
            li liVar = new li();
            liVar.a = 3;
            this.a.sendMessage(this.a.obtainMessage(liVar.a, liVar));
        }
        AppMethodBeat.o(100060);
    }

    private void a(int i, String str) {
        AppMethodBeat.i(100061);
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
        AppMethodBeat.o(100061);
    }
}
