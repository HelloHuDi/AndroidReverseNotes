package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class zza extends Thread {
    private final /* synthetic */ Map zzl;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzl = map;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        String message;
        AppMethodBeat.i(115339);
        zzc zzc = new zzc();
        Map map = this.zzl;
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String message2 : map.keySet()) {
            buildUpon.appendQueryParameter(message2, (String) map.get(message2));
        }
        String uri = buildUpon.build().toString();
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                new StringBuilder(String.valueOf(uri).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(uri);
            }
            httpURLConnection.disconnect();
            AppMethodBeat.o(115339);
        } catch (IndexOutOfBoundsException e) {
            message2 = e.getMessage();
            new StringBuilder((String.valueOf(uri).length() + 32) + String.valueOf(message2).length()).append("Error while parsing ping URL: ").append(uri).append(". ").append(message2);
            AppMethodBeat.o(115339);
        } catch (IOException | RuntimeException e2) {
            message2 = e2.getMessage();
            new StringBuilder((String.valueOf(uri).length() + 27) + String.valueOf(message2).length()).append("Error while pinging URL: ").append(uri).append(". ").append(message2);
            AppMethodBeat.o(115339);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            AppMethodBeat.o(115339);
        }
    }
}
