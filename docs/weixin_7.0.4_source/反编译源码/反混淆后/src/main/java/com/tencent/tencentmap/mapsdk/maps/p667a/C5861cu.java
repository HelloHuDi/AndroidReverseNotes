package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cu */
class C5861cu extends SSLSocketFactory {
    /* renamed from: a */
    public boolean f1537a = false;
    /* renamed from: b */
    private final String f1538b = C5861cu.class.getSimpleName();
    /* renamed from: c */
    private String f1539c;

    public C5861cu(String str) {
        AppMethodBeat.m2504i(98668);
        this.f1539c = str;
        AppMethodBeat.m2505o(98668);
    }

    public Socket createSocket() {
        return null;
    }

    public Socket createSocket(String str, int i) {
        return null;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        AppMethodBeat.m2504i(98669);
        if (TextUtils.isEmpty(this.f1539c)) {
            IOException iOException = new IOException("Halley set empty bizHost");
            AppMethodBeat.m2505o(98669);
            throw iOException;
        }
        new StringBuilder("customized createSocket. host: ").append(this.f1539c);
        try {
            if (VERSION.SDK_INT < 17) {
                SSLSocket sSLSocket = (SSLSocket) ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(Downloads.MIN_WAIT_FOR_NETWORK, new SSLSessionCache(C46772bt.m88735a()))).createSocket(socket, this.f1539c, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(sSLSocket, new Object[]{this.f1539c});
                sSLSocket.startHandshake();
                AppMethodBeat.m2505o(98669);
                return sSLSocket;
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(Downloads.MIN_WAIT_FOR_NETWORK, new SSLSessionCache(C46772bt.m88735a()));
            Socket socket2 = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f1539c, i, z);
            sSLCertificateSocketFactory.setUseSessionTickets(socket2, true);
            socket2.setEnabledProtocols(socket2.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(socket2, this.f1539c);
            socket2.startHandshake();
            AppMethodBeat.m2505o(98669);
            return socket2;
        } catch (Throwable th) {
            this.f1537a = true;
            IOException iOException2 = new IOException("HalleySNI exception: ".concat(String.valueOf(th)));
            AppMethodBeat.m2505o(98669);
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(98670);
        if (TextUtils.isEmpty(this.f1539c) || !(obj instanceof C5861cu)) {
            AppMethodBeat.m2505o(98670);
            return false;
        }
        String str = ((C5861cu) obj).f1539c;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(98670);
            return false;
        }
        boolean equals = this.f1539c.equals(str);
        AppMethodBeat.m2505o(98670);
        return equals;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
