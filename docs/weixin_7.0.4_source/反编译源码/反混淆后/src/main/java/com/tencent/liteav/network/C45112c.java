package com.tencent.liteav.network;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.liteav.network.c */
class C45112c {
    /* renamed from: a */
    public C37370b f17800a = null;
    /* renamed from: b */
    public int f17801b = 5;
    /* renamed from: c */
    private final String f17802c = "http://tcdns.myqcloud.com/queryip";
    /* renamed from: d */
    private final String f17803d = "forward_stream";
    /* renamed from: e */
    private final String f17804e = "forward_num";
    /* renamed from: f */
    private final String f17805f = "request_type";
    /* renamed from: g */
    private final String f17806g = "sdk_version";
    /* renamed from: h */
    private final String f17807h = "51451748-d8f2-4629-9071-db2983aa7251";
    /* renamed from: i */
    private Thread f17808i = null;

    C45112c() {
    }

    /* renamed from: a */
    static /* synthetic */ String m82854a(C45112c c45112c, String str, int i) {
        AppMethodBeat.m2504i(67458);
        String b = c45112c.m82859b(str, i);
        AppMethodBeat.m2505o(67458);
        return b;
    }

    /* renamed from: a */
    public void mo72897a(final String str, final int i) {
        AppMethodBeat.m2504i(67449);
        this.f17808i = new Thread("TXCPushRoute") {
            public void run() {
                AppMethodBeat.m2504i(67619);
                if (C45112c.this.f17800a == null) {
                    AppMethodBeat.m2505o(67619);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < 5) {
                    try {
                        String a = C45112c.m82854a(C45112c.this, str, i);
                        try {
                            JSONObject jSONObject = new JSONObject(a);
                            if (jSONObject.has("use") && jSONObject.getInt("use") == 0) {
                                break;
                            }
                        } catch (Exception e) {
                        }
                        arrayList = C45112c.m82855a(C45112c.this, a);
                        if (arrayList != null && arrayList.size() > 0) {
                            break;
                        }
                        C416961.sleep(1000, 0);
                        i++;
                    } catch (Exception e2) {
                    }
                }
                C45112c.this.f17800a.onFetchDone(0, arrayList);
                AppMethodBeat.m2505o(67619);
            }
        };
        this.f17808i.start();
        AppMethodBeat.m2505o(67449);
    }

    /* renamed from: b */
    private String m82859b(String str, int i) {
        AppMethodBeat.m2504i(67450);
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            InputStream c = m82861c(str, i);
            String str2;
            if (c == null) {
                str2 = "";
                AppMethodBeat.m2505o(67450);
                return str2;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(c));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            str2 = stringBuffer.toString();
            AppMethodBeat.m2505o(67450);
            return str2;
        } catch (IOException e) {
        }
    }

    /* renamed from: c */
    private InputStream m82861c(String str, int i) {
        InputStream inputStream;
        AppMethodBeat.m2504i(67451);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://tcdns.myqcloud.com/queryip").openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("forward_stream", str);
            httpURLConnection.setRequestProperty("forward_num", "2");
            httpURLConnection.setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
            if (i == 1) {
                httpURLConnection.setRequestProperty("request_type", "1");
            } else if (i == 2) {
                httpURLConnection.setRequestProperty("request_type", "2");
            } else {
                httpURLConnection.setRequestProperty("request_type", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
            if (this.f17801b > 0) {
                httpURLConnection.setConnectTimeout(this.f17801b * 1000);
                httpURLConnection.setReadTimeout(this.f17801b * 1000);
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                AppMethodBeat.m2505o(67451);
                return inputStream;
            }
        } catch (Exception e) {
        }
        inputStream = null;
        AppMethodBeat.m2505o(67451);
        return inputStream;
    }

    /* renamed from: a */
    private ArrayList<C41695a> m82856a(String str) {
        ArrayList<C41695a> arrayList = null;
        int i = 0;
        AppMethodBeat.m2504i(67452);
        ArrayList<C41695a> arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("state") != 0) {
            AppMethodBeat.m2505o(67452);
        } else {
            JSONArray jSONArray = jSONObject.getJSONObject(C8741b.CONTENT).getJSONArray("list");
            if (jSONArray == null) {
                AppMethodBeat.m2505o(67452);
            } else {
                C41695a a;
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    try {
                        a = m82853a((JSONObject) jSONArray.opt(i2));
                        if (a != null && a.f17065c) {
                            arrayList2.add(a);
                        }
                        i2++;
                    } catch (JSONException e) {
                        arrayList = arrayList2;
                    }
                }
                while (i < jSONArray.length()) {
                    a = m82853a((JSONObject) jSONArray.opt(i));
                    if (!(a == null || a.f17065c)) {
                        arrayList2.add(a);
                    }
                    i++;
                }
                ArrayList arrayList3;
                if (C45104b.m82752a().mo72874a("Network", "EnableRouteOptimize") == 1 && C17801i.m27844a().mo32957c()) {
                    arrayList3 = m82857a((ArrayList) arrayList2, true);
                    try {
                        m82858a(arrayList3);
                        AppMethodBeat.m2505o(67452);
                    } catch (JSONException e2) {
                        AppMethodBeat.m2505o(67452);
                        return arrayList3;
                    }
                }
                long a2 = C45104b.m82752a().mo72874a("Network", "RouteSamplingMaxCount");
                if (a2 >= 1) {
                    long a3 = C17801i.m27844a().mo32952a("51451748-d8f2-4629-9071-db2983aa7251");
                    if (a3 <= a2) {
                        arrayList3 = m82857a((ArrayList) arrayList2, false);
                        C17801i.m27844a().mo32954a("51451748-d8f2-4629-9071-db2983aa7251", a3 + 1);
                        m82858a(arrayList3);
                        AppMethodBeat.m2505o(67452);
                    }
                }
                arrayList3 = arrayList2;
                m82858a(arrayList3);
                AppMethodBeat.m2505o(67452);
            }
        }
        return arrayList3;
    }

    /* renamed from: a */
    private C41695a m82853a(JSONObject jSONObject) {
        AppMethodBeat.m2504i(67453);
        C41695a c41695a = new C41695a();
        try {
            c41695a.f17063a = jSONObject.getString("ip");
            c41695a.f17064b = jSONObject.getString("port");
            c41695a.f17067e = 0;
            c41695a.f17065c = false;
            c41695a.f17066d = m82860b(c41695a.f17063a);
            if (jSONObject.has("type") && jSONObject.getInt("type") == 2) {
                c41695a.f17065c = true;
            }
            AppMethodBeat.m2505o(67453);
            return c41695a;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(67453);
            return null;
        }
    }

    /* renamed from: b */
    private boolean m82860b(String str) {
        AppMethodBeat.m2504i(67454);
        if (str != null) {
            String[] split = str.split("[.]");
            int length = split.length;
            int i = 0;
            while (i < length) {
                if (m82862c(split[i])) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(67454);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(67454);
        return false;
    }

    /* renamed from: c */
    private boolean m82862c(String str) {
        AppMethodBeat.m2504i(67455);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.m2505o(67455);
        return matches;
    }

    /* renamed from: a */
    private ArrayList<C41695a> m82857a(ArrayList<C41695a> arrayList, boolean z) {
        AppMethodBeat.m2504i(67456);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.m2505o(67456);
            return null;
        }
        C41695a c41695a;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        Object obj = null;
        while (it.hasNext()) {
            c41695a = (C41695a) it.next();
            if (c41695a.f17065c) {
                arrayList2.add(c41695a);
            } else if (c41695a.f17066d) {
                obj = c41695a;
            } else {
                arrayList3.add(c41695a);
            }
        }
        ArrayList<C41695a> arrayList4 = new ArrayList();
        while (true) {
            if (arrayList2.size() <= 0 && arrayList3.size() <= 0) {
                break;
            }
            if (z) {
                if (obj != null) {
                    arrayList4.add(obj);
                }
                if (arrayList2.size() > 0) {
                    arrayList4.add(arrayList2.get(0));
                    arrayList2.remove(0);
                }
            } else {
                if (arrayList2.size() > 0) {
                    arrayList4.add(arrayList2.get(0));
                    arrayList2.remove(0);
                }
                if (obj != null) {
                    arrayList4.add(obj);
                }
            }
            if (arrayList3.size() > 0) {
                arrayList4.add(arrayList3.get(0));
                arrayList3.remove(0);
            }
        }
        int size = arrayList4.size();
        if (size > 0) {
            c41695a = (C41695a) arrayList4.get(size - 1);
            if (!(c41695a == null || m82860b(c41695a.f17063a) || obj == null)) {
                arrayList4.add(obj);
            }
        }
        AppMethodBeat.m2505o(67456);
        return arrayList4;
    }

    /* renamed from: a */
    private void m82858a(ArrayList<C41695a> arrayList) {
        AppMethodBeat.m2504i(67457);
        if (arrayList != null && arrayList.size() > 0) {
            String str;
            String str2 = "";
            Iterator it = arrayList.iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                C41695a c41695a = (C41695a) it.next();
                str2 = str + " \n Nearest IP: " + c41695a.f17063a + " Port: " + c41695a.f17064b + " Q Channel: " + c41695a.f17065c;
            }
            TXCLog.m15676e("TXCIntelligentRoute", str);
        }
        AppMethodBeat.m2505o(67457);
    }
}
