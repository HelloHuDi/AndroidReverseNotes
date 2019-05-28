package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzfk extends zzjq {
    private final SSLSocketFactory zzajg;

    public zzfk(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.i(68904);
        this.zzajg = VERSION.SDK_INT < 19 ? new zzkb() : null;
        AppMethodBeat.o(68904);
    }

    static /* synthetic */ byte[] zza(zzfk zzfk, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(68929);
        byte[] zzb = zzb(httpURLConnection);
        AppMethodBeat.o(68929);
        return zzb;
    }

    private static byte[] zzb(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(68906);
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            AppMethodBeat.o(68906);
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(68920);
        Context context = super.getContext();
        AppMethodBeat.o(68920);
        return context;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(68912);
        super.zzab();
        AppMethodBeat.o(68912);
    }

    /* Access modifiers changed, original: protected|final */
    @VisibleForTesting
    public final HttpURLConnection zzb(URL url) {
        AppMethodBeat.i(68907);
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            if (this.zzajg != null && (openConnection instanceof HttpsURLConnection)) {
                ((HttpsURLConnection) openConnection).setSSLSocketFactory(this.zzajg);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            AppMethodBeat.o(68907);
            return httpURLConnection;
        }
        IOException iOException = new IOException("Failed to obtain HTTP connection");
        AppMethodBeat.o(68907);
        throw iOException;
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(68919);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(68919);
        return zzbt;
    }

    public final boolean zzex() {
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(68905);
        zzch();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            AppMethodBeat.o(68905);
            return false;
        }
        AppMethodBeat.o(68905);
        return true;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(68910);
        super.zzfr();
        AppMethodBeat.o(68910);
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(68911);
        super.zzfs();
        AppMethodBeat.o(68911);
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(68913);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(68913);
        return zzft;
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(68914);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(68914);
        return zzfu;
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(68915);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(68915);
        return zzfv;
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(68916);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(68916);
        return zzfw;
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(68917);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(68917);
        return zzfx;
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(68918);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(68918);
        return zzfy;
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(68921);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(68921);
        return zzfz;
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(68922);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(68922);
        return zzga;
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(68923);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(68923);
        return zzgb;
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(68924);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(68924);
        return zzgc;
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(68925);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(68925);
        return zzgd;
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(68926);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(68926);
        return zzge;
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(68927);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(68927);
        return zzgf;
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(68928);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(68928);
        return zzgg;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zzhf() {
        return false;
    }

    public final /* bridge */ /* synthetic */ zzeb zziw() {
        AppMethodBeat.i(68908);
        zzeb zziw = super.zziw();
        AppMethodBeat.o(68908);
        return zziw;
    }

    public final /* bridge */ /* synthetic */ zzei zzix() {
        AppMethodBeat.i(68909);
        zzei zzix = super.zzix();
        AppMethodBeat.o(68909);
        return zzix;
    }
}
