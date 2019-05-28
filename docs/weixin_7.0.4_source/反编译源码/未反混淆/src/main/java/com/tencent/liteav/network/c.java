package com.tencent.liteav.network;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.liteav.basic.log.TXCLog;
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

class c {
    public b a = null;
    public int b = 5;
    private final String c = "http://tcdns.myqcloud.com/queryip";
    private final String d = "forward_stream";
    private final String e = "forward_num";
    private final String f = "request_type";
    private final String g = "sdk_version";
    private final String h = "51451748-d8f2-4629-9071-db2983aa7251";
    private Thread i = null;

    c() {
    }

    static /* synthetic */ String a(c cVar, String str, int i) {
        AppMethodBeat.i(67458);
        String b = cVar.b(str, i);
        AppMethodBeat.o(67458);
        return b;
    }

    public void a(final String str, final int i) {
        AppMethodBeat.i(67449);
        this.i = new Thread("TXCPushRoute") {
            public void run() {
                AppMethodBeat.i(67619);
                if (c.this.a == null) {
                    AppMethodBeat.o(67619);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < 5) {
                    try {
                        String a = c.a(c.this, str, i);
                        try {
                            JSONObject jSONObject = new JSONObject(a);
                            if (jSONObject.has("use") && jSONObject.getInt("use") == 0) {
                                break;
                            }
                        } catch (Exception e) {
                        }
                        arrayList = c.a(c.this, a);
                        if (arrayList != null && arrayList.size() > 0) {
                            break;
                        }
                        AnonymousClass1.sleep(1000, 0);
                        i++;
                    } catch (Exception e2) {
                    }
                }
                c.this.a.onFetchDone(0, arrayList);
                AppMethodBeat.o(67619);
            }
        };
        this.i.start();
        AppMethodBeat.o(67449);
    }

    private String b(String str, int i) {
        AppMethodBeat.i(67450);
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            InputStream c = c(str, i);
            String str2;
            if (c == null) {
                str2 = "";
                AppMethodBeat.o(67450);
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
            AppMethodBeat.o(67450);
            return str2;
        } catch (IOException e) {
        }
    }

    private InputStream c(String str, int i) {
        InputStream inputStream;
        AppMethodBeat.i(67451);
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
            if (this.b > 0) {
                httpURLConnection.setConnectTimeout(this.b * 1000);
                httpURLConnection.setReadTimeout(this.b * 1000);
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                AppMethodBeat.o(67451);
                return inputStream;
            }
        } catch (Exception e) {
        }
        inputStream = null;
        AppMethodBeat.o(67451);
        return inputStream;
    }

    private ArrayList<a> a(String str) {
        ArrayList<a> arrayList = null;
        int i = 0;
        AppMethodBeat.i(67452);
        ArrayList<a> arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.getInt("state") != 0) {
            AppMethodBeat.o(67452);
        } else {
            JSONArray jSONArray = jSONObject.getJSONObject(b.CONTENT).getJSONArray("list");
            if (jSONArray == null) {
                AppMethodBeat.o(67452);
            } else {
                a a;
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    try {
                        a = a((JSONObject) jSONArray.opt(i2));
                        if (a != null && a.c) {
                            arrayList2.add(a);
                        }
                        i2++;
                    } catch (JSONException e) {
                        arrayList = arrayList2;
                    }
                }
                while (i < jSONArray.length()) {
                    a = a((JSONObject) jSONArray.opt(i));
                    if (!(a == null || a.c)) {
                        arrayList2.add(a);
                    }
                    i++;
                }
                ArrayList arrayList3;
                if (com.tencent.liteav.basic.f.b.a().a("Network", "EnableRouteOptimize") == 1 && i.a().c()) {
                    arrayList3 = a((ArrayList) arrayList2, true);
                    try {
                        a(arrayList3);
                        AppMethodBeat.o(67452);
                    } catch (JSONException e2) {
                        AppMethodBeat.o(67452);
                        return arrayList3;
                    }
                }
                long a2 = com.tencent.liteav.basic.f.b.a().a("Network", "RouteSamplingMaxCount");
                if (a2 >= 1) {
                    long a3 = i.a().a("51451748-d8f2-4629-9071-db2983aa7251");
                    if (a3 <= a2) {
                        arrayList3 = a((ArrayList) arrayList2, false);
                        i.a().a("51451748-d8f2-4629-9071-db2983aa7251", a3 + 1);
                        a(arrayList3);
                        AppMethodBeat.o(67452);
                    }
                }
                arrayList3 = arrayList2;
                a(arrayList3);
                AppMethodBeat.o(67452);
            }
        }
        return arrayList3;
    }

    private a a(JSONObject jSONObject) {
        AppMethodBeat.i(67453);
        a aVar = new a();
        try {
            aVar.a = jSONObject.getString("ip");
            aVar.b = jSONObject.getString("port");
            aVar.e = 0;
            aVar.c = false;
            aVar.d = b(aVar.a);
            if (jSONObject.has("type") && jSONObject.getInt("type") == 2) {
                aVar.c = true;
            }
            AppMethodBeat.o(67453);
            return aVar;
        } catch (JSONException e) {
            AppMethodBeat.o(67453);
            return null;
        }
    }

    private boolean b(String str) {
        AppMethodBeat.i(67454);
        if (str != null) {
            String[] split = str.split("[.]");
            int length = split.length;
            int i = 0;
            while (i < length) {
                if (c(split[i])) {
                    i++;
                } else {
                    AppMethodBeat.o(67454);
                    return true;
                }
            }
        }
        AppMethodBeat.o(67454);
        return false;
    }

    private boolean c(String str) {
        AppMethodBeat.i(67455);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(67455);
        return matches;
    }

    private ArrayList<a> a(ArrayList<a> arrayList, boolean z) {
        AppMethodBeat.i(67456);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(67456);
            return null;
        }
        a aVar;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        Object obj = null;
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.c) {
                arrayList2.add(aVar);
            } else if (aVar.d) {
                obj = aVar;
            } else {
                arrayList3.add(aVar);
            }
        }
        ArrayList<a> arrayList4 = new ArrayList();
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
            aVar = (a) arrayList4.get(size - 1);
            if (!(aVar == null || b(aVar.a) || obj == null)) {
                arrayList4.add(obj);
            }
        }
        AppMethodBeat.o(67456);
        return arrayList4;
    }

    private void a(ArrayList<a> arrayList) {
        AppMethodBeat.i(67457);
        if (arrayList != null && arrayList.size() > 0) {
            String str;
            String str2 = "";
            Iterator it = arrayList.iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                str2 = str + " \n Nearest IP: " + aVar.a + " Port: " + aVar.b + " Q Channel: " + aVar.c;
            }
            TXCLog.e("TXCIntelligentRoute", str);
        }
        AppMethodBeat.o(67457);
    }
}
