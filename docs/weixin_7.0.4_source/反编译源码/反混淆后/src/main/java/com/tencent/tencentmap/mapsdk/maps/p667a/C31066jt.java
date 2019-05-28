package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jt */
public class C31066jt {
    /* renamed from: a */
    private Context f14296a;
    /* renamed from: b */
    private WeakReference<C31067b> f14297b;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jt$a */
    class C31065a extends AsyncTask<Context, Void, Void> {
        private C31065a() {
        }

        /* synthetic */ C31065a(C31066jt c31066jt, C310681 c310681) {
            this();
        }

        /* Access modifiers changed, original: protected|synthetic */
        public /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(100105);
            Void a = mo50493a((Context[]) objArr);
            AppMethodBeat.m2505o(100105);
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
        /* renamed from: a */
        public Void mo50493a(Context... contextArr) {
            Throwable th;
            HttpsURLConnection httpsURLConnection;
            int i = 0;
            AppMethodBeat.m2504i(100104);
            int a = C46796jp.m88979a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://confinfo.map.qq.com/confinfo?");
            stringBuilder.append("apiKey=");
            if (contextArr != null && contextArr.length > 0) {
                stringBuilder.append(C31066jt.m50079a(C31066jt.this, contextArr[0].getApplicationContext()));
            }
            Closeable inputStream;
            try {
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(stringBuilder.toString()).openConnection();
                try {
                    httpsURLConnection2.setConnectTimeout(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    httpsURLConnection2.connect();
                    inputStream = httpsURLConnection2.getInputStream();
                    try {
                        byte[] a2 = C31015v.m49803a((InputStream) inputStream);
                        if (a2 == null || a2.length == 0) {
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection2.disconnect();
                            }
                            if (inputStream != null) {
                                C31015v.m49801a(inputStream);
                            }
                            if (a != C46796jp.m88979a()) {
                                i = 1;
                            }
                            if (!(i == 0 || C31066jt.this.f14296a == null)) {
                                C46796jp.m88981a(C31066jt.this.f14296a, a);
                                C41073ll.m71458a(C31066jt.this.f14296a).mo65168a(1);
                                if (!(C31066jt.this.f14297b == null || C31066jt.this.f14297b.get() == null)) {
                                    ((C31067b) C31066jt.this.f14297b.get()).mo50490b_();
                                }
                            }
                            AppMethodBeat.m2505o(100104);
                            return null;
                        }
                        int a3 = C31066jt.m50075a(C31066jt.this, new String(a2), a);
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (inputStream != null) {
                            C31015v.m49801a(inputStream);
                        }
                        if (a3 != C46796jp.m88979a()) {
                            i = 1;
                        }
                        if (!(i == 0 || C31066jt.this.f14296a == null)) {
                            C46796jp.m88981a(C31066jt.this.f14296a, a3);
                            C41073ll.m71458a(C31066jt.this.f14296a).mo65168a(1);
                            if (!(C31066jt.this.f14297b == null || C31066jt.this.f14297b.get() == null)) {
                                ((C31067b) C31066jt.this.f14297b.get()).mo50490b_();
                            }
                        }
                        AppMethodBeat.m2505o(100104);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection = httpsURLConnection2;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (inputStream != null) {
                            C31015v.m49801a(inputStream);
                        }
                        if (!((a == C46796jp.m88979a() ? 1 : 0) == 0 || C31066jt.this.f14296a == null)) {
                            C46796jp.m88981a(C31066jt.this.f14296a, a);
                            C41073ll.m71458a(C31066jt.this.f14296a).mo65168a(1);
                            if (!(C31066jt.this.f14297b == null || C31066jt.this.f14297b.get() == null)) {
                                ((C31067b) C31066jt.this.f14297b.get()).mo50490b_();
                            }
                        }
                        AppMethodBeat.m2505o(100104);
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
                    if (a == C46796jp.m88979a()) {
                    }
                    C46796jp.m88981a(C31066jt.this.f14296a, a);
                    C41073ll.m71458a(C31066jt.this.f14296a).mo65168a(1);
                    ((C31067b) C31066jt.this.f14297b.get()).mo50490b_();
                    AppMethodBeat.m2505o(100104);
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
                if (a == C46796jp.m88979a()) {
                }
                C46796jp.m88981a(C31066jt.this.f14296a, a);
                C41073ll.m71458a(C31066jt.this.f14296a).mo65168a(1);
                ((C31067b) C31066jt.this.f14297b.get()).mo50490b_();
                AppMethodBeat.m2505o(100104);
                throw th;
            }
        }
    }

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.jt$b */
    public interface C31067b {
        /* renamed from: b_ */
        void mo50490b_();
    }

    /* renamed from: a */
    static /* synthetic */ int m50075a(C31066jt c31066jt, String str, int i) {
        AppMethodBeat.m2504i(100111);
        int a = c31066jt.m50076a(str, i);
        AppMethodBeat.m2505o(100111);
        return a;
    }

    public C31066jt(Context context, C31067b c31067b) {
        AppMethodBeat.m2504i(100106);
        this.f14296a = context;
        this.f14297b = new WeakReference(c31067b);
        AppMethodBeat.m2505o(100106);
    }

    /* renamed from: a */
    public void mo50495a() {
        AppMethodBeat.m2504i(100107);
        new C31065a(this, null).execute(new Context[]{this.f14296a});
        AppMethodBeat.m2505o(100107);
    }

    /* renamed from: a */
    private int m50076a(String str, int i) {
        AppMethodBeat.m2504i(100108);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt("error", -1) == 0) {
            jSONObject = jSONObject.optJSONObject("info");
            if (jSONObject != null) {
                i = jSONObject.optInt("scenic", i);
            }
        }
        AppMethodBeat.m2505o(100108);
        return i;
    }

    /* renamed from: a */
    private String m50078a(Context context) {
        AppMethodBeat.m2504i(100109);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(100109);
            return str;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            str = "";
            AppMethodBeat.m2505o(100109);
            return str;
        } else if (applicationInfo.metaData == null) {
            str = "";
            AppMethodBeat.m2505o(100109);
            return str;
        } else {
            str = applicationInfo.metaData.getString(C36520ic.f15397b);
            AppMethodBeat.m2505o(100109);
            return str;
        }
    }
}
