package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.e;
import com.tencent.mm.ui.f.a.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    private c gyN;
    a gyO;
    ak handler;

    public interface a {
        void onError(int i, String str);

        void p(Bundle bundle);
    }

    public h(c cVar, a aVar) {
        this.gyN = cVar;
        this.gyO = aVar;
    }

    public final void apm() {
        AppMethodBeat.i(124693);
        this.handler = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(124688);
                switch (message.what) {
                    case 1:
                        if (h.this.gyO != null) {
                            h.this.gyO.onError(message.arg1, (String) message.obj);
                            AppMethodBeat.o(124688);
                            return;
                        }
                        break;
                    case 2:
                        if (h.this.gyO != null) {
                            h.this.gyO.p(message.getData());
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(124688);
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("client_id", ah.getContext().getString(R.string.g7d));
        bundle.putString("client_secret", ah.getContext().getString(R.string.g7e));
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.gyN.gqE);
        d.post(new com.tencent.mm.ui.f.a.a.AnonymousClass1("oauth/access_token", bundle, "GET", new com.tencent.mm.ui.f.a.a.a() {
            public final void wo(String str) {
                AppMethodBeat.i(124689);
                if (str == null || str.length() == 0) {
                    ab.e("MicroMsg.RefreshTokenRunner", "response is null or nil");
                    h.a(h.this, 1, "response is null or nil");
                    AppMethodBeat.o(124689);
                } else if (!str.contains("access_token") || str.length() <= 12) {
                    try {
                        f.asb(str);
                    } catch (Exception e) {
                        ab.e("MicroMsg.RefreshTokenRunner", "parseJson exception : " + e.getMessage());
                        ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", e, "", new Object[0]);
                    } catch (e e2) {
                        String str2 = "errCode = " + e2.mErrorCode + ", errType = " + e2.zxP + ", errMsg = " + e2.getMessage();
                        ab.e("MicroMsg.RefreshTokenRunner", "parseJson facebookerror, ".concat(String.valueOf(str2)));
                        ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", e2, "", new Object[0]);
                        h.a(h.this, 3, str2);
                        AppMethodBeat.o(124689);
                        return;
                    }
                    h.a(h.this, 2, "parseJson error");
                    AppMethodBeat.o(124689);
                } else {
                    try {
                        JSONObject asb = f.asb(str);
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
                            h hVar = h.this;
                            Message obtain = Message.obtain();
                            obtain.what = 2;
                            obtain.setData(bundle);
                            hVar.handler.sendMessage(obtain);
                            AppMethodBeat.o(124689);
                            return;
                        }
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.RefreshTokenRunner", th, "", new Object[0]);
                    }
                    h.a(h.this, 2, "decodeUrl fail");
                    AppMethodBeat.o(124689);
                }
            }

            public final void b(IOException iOException) {
                AppMethodBeat.i(124690);
                ab.e("MicroMsg.RefreshTokenRunner", "onIOException");
                h.a(h.this, 2, iOException.getMessage());
                AppMethodBeat.o(124690);
            }

            public final void a(FileNotFoundException fileNotFoundException) {
                AppMethodBeat.i(124691);
                ab.e("MicroMsg.RefreshTokenRunner", "onFileNotFoundException");
                h.a(h.this, 2, fileNotFoundException.getMessage());
                AppMethodBeat.o(124691);
            }

            public final void a(MalformedURLException malformedURLException) {
                AppMethodBeat.i(124692);
                ab.e("MicroMsg.RefreshTokenRunner", "onMalformedURLException");
                h.a(h.this, 2, malformedURLException.getMessage());
                AppMethodBeat.o(124692);
            }
        }), "AsyncFacebookRunner_request");
        AppMethodBeat.o(124693);
    }

    static /* synthetic */ void a(h hVar, int i, String str) {
        AppMethodBeat.i(124694);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = str;
        hVar.handler.sendMessage(obtain);
        AppMethodBeat.o(124694);
    }
}
