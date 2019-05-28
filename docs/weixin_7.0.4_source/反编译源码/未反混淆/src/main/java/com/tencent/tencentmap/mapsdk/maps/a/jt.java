package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.v;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class jt {
    private Context a;
    private WeakReference<b> b;

    class a extends AsyncTask<Context, Void, Void> {
        private a() {
        }

        /* synthetic */ a(jt jtVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.i(100105);
            Void a = a((Context[]) objArr);
            AppMethodBeat.o(100105);
            return a;
        }

        /* Access modifiers changed, original: protected|varargs */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x017f  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0184  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01d5  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x018d  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x017f  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0184  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x018d  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01d5  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x017f  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0184  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01d5  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x018d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Void a(Context... contextArr) {
            Throwable th;
            HttpsURLConnection httpsURLConnection;
            int i = 0;
            AppMethodBeat.i(100104);
            int a = jp.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://confinfo.map.qq.com/confinfo?");
            stringBuilder.append("apiKey=");
            if (contextArr != null && contextArr.length > 0) {
                stringBuilder.append(jt.a(jt.this, contextArr[0].getApplicationContext()));
            }
            Closeable inputStream;
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(stringBuilder.toString()).openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    httpsURLConnection2.connect();
                    inputStream = httpsURLConnection2.getInputStream();
                    try {
                        byte[] a2 = v.a((InputStream) inputStream);
                        if (a2 == null || a2.length == 0) {
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (inputStream != null) {
                                v.a(inputStream);
                            }
                            if (a != jp.a()) {
                                i = 1;
                            }
                            if (!(i == 0 || jt.this.a == null)) {
                                jp.a(jt.this.a, a);
                                ll.a(jt.this.a).a(1);
                                if (!(jt.this.b == null || jt.this.b.get() == null)) {
                                    ((b) jt.this.b.get()).b_();
                                }
                            }
                            AppMethodBeat.o(100104);
                            return null;
                        }
                        int a3 = jt.a(jt.this, new String(a2), a);
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (inputStream != null) {
                            v.a(inputStream);
                        }
                        if (a3 != jp.a()) {
                            i = 1;
                        }
                        if (!(i == 0 || jt.this.a == null)) {
                            jp.a(jt.this.a, a3);
                            ll.a(jt.this.a).a(1);
                            if (!(jt.this.b == null || jt.this.b.get() == null)) {
                                ((b) jt.this.b.get()).b_();
                            }
                        }
                        AppMethodBeat.o(100104);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            v.a(inputStream);
                        }
                        if (!((a == jp.a() ? 1 : 0) == 0 || jt.this.a == null)) {
                            jp.a(jt.this.a, a);
                            ll.a(jt.this.a).a(1);
                            if (!(jt.this.b == null || jt.this.b.get() == null)) {
                                ((b) jt.this.b.get()).b_();
                            }
                        }
                        AppMethodBeat.o(100104);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    httpsURLConnection = httpsURLConnection2;
                    if (httpsURLConnection != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (a == jp.a()) {
                    }
                    jp.a(jt.this.a, a);
                    ll.a(jt.this.a).a(1);
                    ((b) jt.this.b.get()).b_();
                    AppMethodBeat.o(100104);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                httpsURLConnection = null;
                if (httpsURLConnection != null) {
                }
                if (inputStream != null) {
                }
                if (a == jp.a()) {
                }
                jp.a(jt.this.a, a);
                ll.a(jt.this.a).a(1);
                ((b) jt.this.b.get()).b_();
                AppMethodBeat.o(100104);
                throw th;
            }
        }
    }

    public interface b {
        void b_();
    }

    static /* synthetic */ int a(jt jtVar, String str, int i) {
        AppMethodBeat.i(100111);
        int a = jtVar.a(str, i);
        AppMethodBeat.o(100111);
        return a;
    }

    public jt(Context context, b bVar) {
        AppMethodBeat.i(100106);
        this.a = context;
        this.b = new WeakReference(bVar);
        AppMethodBeat.o(100106);
    }

    public void a() {
        AppMethodBeat.i(100107);
        new a(this, null).execute(new Context[]{this.a});
        AppMethodBeat.o(100107);
    }

    private int a(String str, int i) {
        AppMethodBeat.i(100108);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt("error", -1) == 0) {
            jSONObject = jSONObject.optJSONObject("info");
            if (jSONObject != null) {
                i = jSONObject.optInt("scenic", i);
            }
        }
        AppMethodBeat.o(100108);
        return i;
    }

    private String a(Context context) {
        AppMethodBeat.i(100109);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(100109);
            return str;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            str = "";
            AppMethodBeat.o(100109);
            return str;
        } else if (applicationInfo.metaData == null) {
            str = "";
            AppMethodBeat.o(100109);
            return str;
        } else {
            str = applicationInfo.metaData.getString(ic.b);
            AppMethodBeat.o(100109);
            return str;
        }
    }
}
