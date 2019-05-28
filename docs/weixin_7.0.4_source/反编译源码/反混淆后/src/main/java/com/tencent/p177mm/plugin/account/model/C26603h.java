package com.tencent.p177mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.p629f.p630a.C15883a.C15882a;
import com.tencent.p177mm.p612ui.p629f.p630a.C15883a.C158841;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.p612ui.p629f.p630a.C44373f;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.account.model.h */
public final class C26603h {
    private C30704c gyN;
    C26604a gyO;
    C7306ak handler;

    /* renamed from: com.tencent.mm.plugin.account.model.h$2 */
    class C165712 implements C15882a {
        C165712() {
        }

        /* renamed from: wo */
        public final void mo28120wo(String str) {
            AppMethodBeat.m2504i(124689);
            if (str == null || str.length() == 0) {
                C4990ab.m7412e("MicroMsg.RefreshTokenRunner", "response is null or nil");
                C26603h.m42464a(C26603h.this, 1, "response is null or nil");
                AppMethodBeat.m2505o(124689);
            } else if (!str.contains("access_token") || str.length() <= 12) {
                try {
                    C44373f.asb(str);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", e, "", new Object[0]);
                } catch (C30706e e2) {
                    String str2 = "errCode = " + e2.mErrorCode + ", errType = " + e2.zxP + ", errMsg = " + e2.getMessage();
                    C4990ab.m7412e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, ".concat(String.valueOf(str2)));
                    C4990ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", e2, "", new Object[0]);
                    C26603h.m42464a(C26603h.this, 3, str2);
                    AppMethodBeat.m2505o(124689);
                    return;
                }
                C26603h.m42464a(C26603h.this, 2, "parseJson error");
                AppMethodBeat.m2505o(124689);
            } else {
                try {
                    JSONObject asb = C44373f.asb(str);
                    if (asb.has("access_token")) {
                        Bundle bundle = new Bundle();
                        Iterator keys = asb.keys();
                        while (keys.hasNext()) {
                            String str3 = (String) keys.next();
                            JSONArray optJSONArray = asb.optJSONArray(str3);
                            Double valueOf = Double.valueOf(asb.optDouble(str3));
                            String optString = asb.optString(str3);
                            if (optJSONArray == null || optJSONArray.length() > 0) {
                                int i;
                                if (optJSONArray != null) {
                                    if (!Double.isNaN(optJSONArray.optDouble(0))) {
                                        double[] dArr = new double[optJSONArray.length()];
                                        for (i = 0; i < optJSONArray.length(); i++) {
                                            dArr[i] = optJSONArray.optDouble(i);
                                        }
                                        bundle.putDoubleArray(str3, dArr);
                                    }
                                }
                                if (optJSONArray != null && optJSONArray.optString(0) != null) {
                                    String[] strArr = new String[optJSONArray.length()];
                                    for (i = 0; i < optJSONArray.length(); i++) {
                                        strArr[i] = optJSONArray.optString(i);
                                    }
                                    bundle.putStringArray(str3, strArr);
                                } else if (!valueOf.isNaN()) {
                                    bundle.putDouble(str3, valueOf.doubleValue());
                                } else if (optString != null) {
                                    bundle.putString(str3, optString);
                                } else {
                                    System.err.println("unable to transform json to bundle ".concat(String.valueOf(str3)));
                                }
                            } else {
                                bundle.putStringArray(str3, new String[0]);
                            }
                        }
                        C26603h c26603h = C26603h.this;
                        Message obtain = Message.obtain();
                        obtain.what = 2;
                        obtain.setData(bundle);
                        c26603h.handler.sendMessage(obtain);
                        AppMethodBeat.m2505o(124689);
                        return;
                    }
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", th, "", new Object[0]);
                }
                C26603h.m42464a(C26603h.this, 2, "decodeUrl fail");
                AppMethodBeat.m2505o(124689);
            }
        }

        /* renamed from: b */
        public final void mo28119b(IOException iOException) {
            AppMethodBeat.m2504i(124690);
            C4990ab.m7412e("MicroMsg.RefreshTokenRunner", "onIOException");
            C26603h.m42464a(C26603h.this, 2, iOException.getMessage());
            AppMethodBeat.m2505o(124690);
        }

        /* renamed from: a */
        public final void mo28117a(FileNotFoundException fileNotFoundException) {
            AppMethodBeat.m2504i(124691);
            C4990ab.m7412e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
            C26603h.m42464a(C26603h.this, 2, fileNotFoundException.getMessage());
            AppMethodBeat.m2505o(124691);
        }

        /* renamed from: a */
        public final void mo28118a(MalformedURLException malformedURLException) {
            AppMethodBeat.m2504i(124692);
            C4990ab.m7412e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
            C26603h.m42464a(C26603h.this, 2, malformedURLException.getMessage());
            AppMethodBeat.m2505o(124692);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.h$a */
    public interface C26604a {
        void onError(int i, String str);

        /* renamed from: p */
        void mo21265p(Bundle bundle);
    }

    /* renamed from: com.tencent.mm.plugin.account.model.h$1 */
    class C266051 extends C7306ak {
        C266051() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(124688);
            switch (message.what) {
                case 1:
                    if (C26603h.this.gyO != null) {
                        C26603h.this.gyO.onError(message.arg1, (String) message.obj);
                        AppMethodBeat.m2505o(124688);
                        return;
                    }
                    break;
                case 2:
                    if (C26603h.this.gyO != null) {
                        C26603h.this.gyO.mo21265p(message.getData());
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(124688);
        }
    }

    public C26603h(C30704c c30704c, C26604a c26604a) {
        this.gyN = c30704c;
        this.gyO = c26604a;
    }

    public final void apm() {
        AppMethodBeat.m2504i(124693);
        this.handler = new C266051();
        Bundle bundle = new Bundle();
        bundle.putString("client_id", C4996ah.getContext().getString(C25738R.string.g7d));
        bundle.putString("client_secret", C4996ah.getContext().getString(C25738R.string.g7e));
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.gyN.gqE);
        C7305d.post(new C158841("oauth/access_token", bundle, "GET", new C165712()), "AsyncFacebookRunner_request");
        AppMethodBeat.m2505o(124693);
    }

    /* renamed from: a */
    static /* synthetic */ void m42464a(C26603h c26603h, int i, String str) {
        AppMethodBeat.m2504i(124694);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = str;
        c26603h.handler.sendMessage(obtain);
        AppMethodBeat.m2505o(124694);
    }
}
