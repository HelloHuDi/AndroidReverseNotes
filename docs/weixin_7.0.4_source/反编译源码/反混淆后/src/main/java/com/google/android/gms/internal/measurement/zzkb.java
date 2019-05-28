package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzkb extends SSLSocketFactory {
    private final SSLSocketFactory zzari;

    zzkb() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
        AppMethodBeat.m2504i(69575);
        AppMethodBeat.m2505o(69575);
    }

    private zzkb(SSLSocketFactory sSLSocketFactory) {
        this.zzari = sSLSocketFactory;
    }

    private final SSLSocket zza(SSLSocket sSLSocket) {
        AppMethodBeat.m2504i(69584);
        zzkc zzkc = new zzkc(this, sSLSocket);
        AppMethodBeat.m2505o(69584);
        return zzkc;
    }

    public final Socket createSocket() {
        AppMethodBeat.m2504i(69583);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket());
        AppMethodBeat.m2505o(69583);
        return zza;
    }

    public final Socket createSocket(String str, int i) {
        AppMethodBeat.m2504i(69579);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(str, i));
        AppMethodBeat.m2505o(69579);
        return zza;
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        AppMethodBeat.m2504i(69581);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(str, i, inetAddress, i2));
        AppMethodBeat.m2505o(69581);
        return zza;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) {
        AppMethodBeat.m2504i(69580);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(inetAddress, i));
        AppMethodBeat.m2505o(69580);
        return zza;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        AppMethodBeat.m2504i(69582);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(inetAddress, i, inetAddress2, i2));
        AppMethodBeat.m2505o(69582);
        return zza;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        AppMethodBeat.m2504i(69576);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(socket, str, i, z));
        AppMethodBeat.m2505o(69576);
        return zza;
    }

    public final String[] getDefaultCipherSuites() {
        AppMethodBeat.m2504i(69577);
        String[] defaultCipherSuites = this.zzari.getDefaultCipherSuites();
        AppMethodBeat.m2505o(69577);
        return defaultCipherSuites;
    }

    public final String[] getSupportedCipherSuites() {
        AppMethodBeat.m2504i(69578);
        String[] supportedCipherSuites = this.zzari.getSupportedCipherSuites();
        AppMethodBeat.m2505o(69578);
        return supportedCipherSuites;
    }
}
