package com.tencent.tencentmap.mapsdk.maps.a;

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

class cu extends SSLSocketFactory {
    public boolean a = false;
    private final String b = cu.class.getSimpleName();
    private String c;

    public cu(String str) {
        AppMethodBeat.i(98668);
        this.c = str;
        AppMethodBeat.o(98668);
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
        AppMethodBeat.i(98669);
        if (TextUtils.isEmpty(this.c)) {
            IOException iOException = new IOException("Halley set empty bizHost");
            AppMethodBeat.o(98669);
            throw iOException;
        }
        new StringBuilder("customized createSocket. host: ").append(this.c);
        try {
            if (VERSION.SDK_INT < 17) {
                SSLSocket sSLSocket = (SSLSocket) ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(Downloads.MIN_WAIT_FOR_NETWORK, new SSLSessionCache(bt.a()))).createSocket(socket, this.c, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(sSLSocket, new Object[]{this.c});
                sSLSocket.startHandshake();
                AppMethodBeat.o(98669);
                return sSLSocket;
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(Downloads.MIN_WAIT_FOR_NETWORK, new SSLSessionCache(bt.a()));
            Socket socket2 = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.c, i, z);
            sSLCertificateSocketFactory.setUseSessionTickets(socket2, true);
            socket2.setEnabledProtocols(socket2.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(socket2, this.c);
            socket2.startHandshake();
            AppMethodBeat.o(98669);
            return socket2;
        } catch (Throwable th) {
            this.a = true;
            IOException iOException2 = new IOException("HalleySNI exception: ".concat(String.valueOf(th)));
            AppMethodBeat.o(98669);
        }
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(98670);
        if (TextUtils.isEmpty(this.c) || !(obj instanceof cu)) {
            AppMethodBeat.o(98670);
            return false;
        }
        String str = ((cu) obj).c;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98670);
            return false;
        }
        boolean equals = this.c.equals(str);
        AppMethodBeat.o(98670);
        return equals;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
