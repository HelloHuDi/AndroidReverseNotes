package com.google.android.gms.common.net;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SSLCertificateSocketFactory extends SSLSocketFactory {
    private static final TrustManager[] zzvf = new TrustManager[]{new zza()};
    @VisibleForTesting
    private final Context mContext;
    @VisibleForTesting
    private SSLSocketFactory zzvg = null;
    @VisibleForTesting
    private SSLSocketFactory zzvh = null;
    @VisibleForTesting
    private TrustManager[] zzvi = null;
    @VisibleForTesting
    private KeyManager[] zzvj = null;
    @VisibleForTesting
    private byte[] zzvk = null;
    @VisibleForTesting
    private byte[] zzvl = null;
    @VisibleForTesting
    private PrivateKey zzvm = null;
    @VisibleForTesting
    private final int zzvn;
    @VisibleForTesting
    private final boolean zzvo;
    @VisibleForTesting
    private final boolean zzvp;
    @VisibleForTesting
    private final String zzvq;

    static {
        AppMethodBeat.m2504i(89926);
        AppMethodBeat.m2505o(89926);
    }

    private SSLCertificateSocketFactory(Context context, int i, boolean z, boolean z2, String str) {
        AppMethodBeat.m2504i(89899);
        this.mContext = context.getApplicationContext();
        this.zzvn = i;
        this.zzvo = z;
        this.zzvp = z2;
        this.zzvq = str;
        AppMethodBeat.m2505o(89899);
    }

    public static SocketFactory getDefault(Context context, int i) {
        AppMethodBeat.m2504i(89900);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i, false, true, null);
        AppMethodBeat.m2505o(89900);
        return sSLCertificateSocketFactory;
    }

    public static SSLSocketFactory getDefaultWithCacheDir(int i, Context context, String str) {
        AppMethodBeat.m2504i(89902);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i, true, true, str);
        AppMethodBeat.m2505o(89902);
        return sSLCertificateSocketFactory;
    }

    public static SSLSocketFactory getDefaultWithSessionCache(int i, Context context) {
        AppMethodBeat.m2504i(89901);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i, true, true, null);
        AppMethodBeat.m2505o(89901);
        return sSLCertificateSocketFactory;
    }

    public static SSLSocketFactory getInsecure(Context context, int i, boolean z) {
        AppMethodBeat.m2504i(89903);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i, z, false, null);
        AppMethodBeat.m2505o(89903);
        return sSLCertificateSocketFactory;
    }

    public static void verifyHostname(Socket socket, String str) {
        AppMethodBeat.m2504i(89904);
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            if (session == null) {
                SSLException sSLException = new SSLException("Cannot verify SSL socket without session");
                AppMethodBeat.m2505o(89904);
                throw sSLException;
            } else if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
                AppMethodBeat.m2505o(89904);
                return;
            } else {
                String str2 = "Cannot verify hostname: ";
                String valueOf = String.valueOf(str);
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                AppMethodBeat.m2505o(89904);
                throw sSLPeerUnverifiedException;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempt to verify non-SSL socket");
        AppMethodBeat.m2505o(89904);
        throw illegalArgumentException;
    }

    @VisibleForTesting
    private static void zza(Socket socket, int i) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89924);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setHandshakeTimeout", new Class[]{Integer.TYPE}).invoke(socket, new Object[]{Integer.valueOf(i)});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                cause = invocationTargetException.getCause();
                RuntimeException runtimeException;
                if (cause instanceof RuntimeException) {
                    runtimeException = (RuntimeException) cause;
                    AppMethodBeat.m2505o(89924);
                    throw runtimeException;
                }
                valueOf = String.valueOf(socket.getClass());
                runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Failed to invoke setSocketHandshakeTimeout on ").append(valueOf).toString(), invocationTargetException);
                AppMethodBeat.m2505o(89924);
                throw runtimeException;
            } catch (IllegalAccessException | NoSuchMethodException cause2) {
                valueOf = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 45).append(valueOf).append(" does not implement setSocketHandshakeTimeout").toString(), cause2);
                AppMethodBeat.m2505o(89924);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(89924);
    }

    @VisibleForTesting
    private static void zza(Socket socket, PrivateKey privateKey) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89925);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setChannelIdPrivateKey", new Class[]{PrivateKey.class}).invoke(socket, new Object[]{privateKey});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                cause = invocationTargetException.getCause();
                RuntimeException runtimeException;
                if (cause instanceof RuntimeException) {
                    runtimeException = (RuntimeException) cause;
                    AppMethodBeat.m2505o(89925);
                    throw runtimeException;
                }
                valueOf = String.valueOf(socket.getClass());
                runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to invoke setChannelIdPrivateKey on ").append(valueOf).toString(), invocationTargetException);
                AppMethodBeat.m2505o(89925);
                throw runtimeException;
            } catch (IllegalAccessException | NoSuchMethodException cause2) {
                valueOf = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 42).append(valueOf).append(" does not implement setChannelIdPrivateKey").toString(), cause2);
                AppMethodBeat.m2505o(89925);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(89925);
    }

    @VisibleForTesting
    private static void zza(Socket socket, byte[] bArr) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89922);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setNpnProtocols", new Class[]{byte[].class}).invoke(socket, new Object[]{bArr});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                cause = invocationTargetException.getCause();
                RuntimeException runtimeException;
                if (cause instanceof RuntimeException) {
                    runtimeException = (RuntimeException) cause;
                    AppMethodBeat.m2505o(89922);
                    throw runtimeException;
                }
                valueOf = String.valueOf(socket.getClass());
                runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to invoke setNpnProtocols on ").append(valueOf).toString(), invocationTargetException);
                AppMethodBeat.m2505o(89922);
                throw runtimeException;
            } catch (IllegalAccessException | NoSuchMethodException cause2) {
                valueOf = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 35).append(valueOf).append(" does not implement setNpnProtocols").toString(), cause2);
                AppMethodBeat.m2505o(89922);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(89922);
    }

    private static byte[] zza(byte[]... bArr) {
        AppMethodBeat.m2504i(89908);
        IllegalArgumentException illegalArgumentException;
        if (bArr.length == 0) {
            illegalArgumentException = new IllegalArgumentException("items.length == 0");
            AppMethodBeat.m2505o(89908);
            throw illegalArgumentException;
        }
        int i;
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2.length == 0 || bArr2.length > 255) {
                illegalArgumentException = new IllegalArgumentException("s.length == 0 || s.length > 255: " + bArr2.length);
                AppMethodBeat.m2505o(89908);
                throw illegalArgumentException;
            }
            i2 += bArr2.length + 1;
        }
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        for (byte[] bArr4 : bArr) {
            int i4 = i3 + 1;
            bArr3[i3] = (byte) bArr4.length;
            int length = bArr4.length;
            i = 0;
            i3 = i4;
            while (i < length) {
                i4 = i3 + 1;
                bArr3[i3] = bArr4[i];
                i++;
                i3 = i4;
            }
        }
        AppMethodBeat.m2505o(89908);
        return bArr3;
    }

    @VisibleForTesting
    private static void zzb(Socket socket, byte[] bArr) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89923);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setAlpnProtocols", new Class[]{byte[].class}).invoke(socket, new Object[]{bArr});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                cause = invocationTargetException.getCause();
                RuntimeException runtimeException;
                if (cause instanceof RuntimeException) {
                    runtimeException = (RuntimeException) cause;
                    AppMethodBeat.m2505o(89923);
                    throw runtimeException;
                }
                valueOf = String.valueOf(socket.getClass());
                runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 37).append("Failed to invoke setAlpnProtocols on ").append(valueOf).toString(), invocationTargetException);
                AppMethodBeat.m2505o(89923);
                throw runtimeException;
            } catch (IllegalAccessException | NoSuchMethodException cause2) {
                valueOf = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 36).append(valueOf).append(" does not implement setAlpnProtocols").toString(), cause2);
                AppMethodBeat.m2505o(89923);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.m2505o(89923);
    }

    @VisibleForTesting
    private final synchronized SSLSocketFactory zzcx() {
        SSLSocketFactory sSLSocketFactory;
        AppMethodBeat.m2504i(89905);
        if (this.zzvp) {
            if (this.zzvq != null) {
                if (this.zzvh == null) {
                    this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactoryWithCacheDir(this.mContext, this.zzvj, this.zzvi, this.zzvq);
                }
            } else if (this.zzvh == null) {
                this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, this.zzvi, this.zzvo);
            }
            sSLSocketFactory = this.zzvh;
            AppMethodBeat.m2505o(89905);
        } else {
            if (this.zzvg == null) {
                this.zzvg = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, zzvf, this.zzvo);
            }
            sSLSocketFactory = this.zzvg;
            AppMethodBeat.m2505o(89905);
        }
        return sSLSocketFactory;
    }

    public Socket createSocket() {
        AppMethodBeat.m2504i(89915);
        Socket createSocket = zzcx().createSocket();
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        AppMethodBeat.m2505o(89915);
        return createSocket;
    }

    public Socket createSocket(String str, int i) {
        AppMethodBeat.m2504i(89919);
        Socket createSocket = zzcx().createSocket(str, i);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        AppMethodBeat.m2505o(89919);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        AppMethodBeat.m2504i(89918);
        Socket createSocket = zzcx().createSocket(str, i, inetAddress, i2);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        AppMethodBeat.m2505o(89918);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        AppMethodBeat.m2504i(89917);
        Socket createSocket = zzcx().createSocket(inetAddress, i);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        AppMethodBeat.m2505o(89917);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        AppMethodBeat.m2504i(89916);
        Socket createSocket = zzcx().createSocket(inetAddress, i, inetAddress2, i2);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        AppMethodBeat.m2505o(89916);
        return createSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        AppMethodBeat.m2504i(89914);
        Socket createSocket = zzcx().createSocket(socket, str, i, z);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        AppMethodBeat.m2505o(89914);
        return createSocket;
    }

    public byte[] getAlpnSelectedProtocol(Socket socket) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89910);
        try {
            byte[] bArr = (byte[]) socket.getClass().getMethod("getAlpnSelectedProtocol", new Class[0]).invoke(socket, new Object[0]);
            AppMethodBeat.m2505o(89910);
            return bArr;
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            cause = invocationTargetException.getCause();
            RuntimeException runtimeException;
            if (cause instanceof RuntimeException) {
                runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(89910);
                throw runtimeException;
            }
            valueOf = String.valueOf(socket.getClass());
            runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("Failed to invoke getAlpnSelectedProtocol on ").append(valueOf).toString(), invocationTargetException);
            AppMethodBeat.m2505o(89910);
            throw runtimeException;
        } catch (IllegalAccessException | NoSuchMethodException cause2) {
            valueOf = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 43).append(valueOf).append(" does not implement getAlpnSelectedProtocol").toString(), cause2);
            AppMethodBeat.m2505o(89910);
            throw illegalArgumentException;
        }
    }

    public String[] getDefaultCipherSuites() {
        AppMethodBeat.m2504i(89920);
        String[] defaultCipherSuites = zzcx().getDefaultCipherSuites();
        AppMethodBeat.m2505o(89920);
        return defaultCipherSuites;
    }

    public byte[] getNpnSelectedProtocol(Socket socket) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89909);
        try {
            byte[] bArr = (byte[]) socket.getClass().getMethod("getNpnSelectedProtocol", new Class[0]).invoke(socket, new Object[0]);
            AppMethodBeat.m2505o(89909);
            return bArr;
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            cause = invocationTargetException.getCause();
            RuntimeException runtimeException;
            if (cause instanceof RuntimeException) {
                runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(89909);
                throw runtimeException;
            }
            valueOf = String.valueOf(socket.getClass());
            runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to invoke getNpnSelectedProtocol on ").append(valueOf).toString(), invocationTargetException);
            AppMethodBeat.m2505o(89909);
            throw runtimeException;
        } catch (IllegalAccessException | NoSuchMethodException cause2) {
            valueOf = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 42).append(valueOf).append(" does not implement getNpnSelectedProtocol").toString(), cause2);
            AppMethodBeat.m2505o(89909);
            throw illegalArgumentException;
        }
    }

    public String[] getSupportedCipherSuites() {
        AppMethodBeat.m2504i(89921);
        String[] supportedCipherSuites = zzcx().getSupportedCipherSuites();
        AppMethodBeat.m2505o(89921);
        return supportedCipherSuites;
    }

    public void setAlpnProtocols(byte[][] bArr) {
        AppMethodBeat.m2504i(89907);
        this.zzvl = zza(bArr);
        AppMethodBeat.m2505o(89907);
    }

    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.zzvm = privateKey;
    }

    public void setHostname(Socket socket, String str) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89912);
        try {
            socket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(socket, new Object[]{str});
            AppMethodBeat.m2505o(89912);
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            cause = invocationTargetException.getCause();
            RuntimeException runtimeException;
            if (cause instanceof RuntimeException) {
                runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(89912);
                throw runtimeException;
            }
            valueOf = String.valueOf(socket.getClass());
            runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Failed to invoke setHostname on ").append(valueOf).toString(), invocationTargetException);
            AppMethodBeat.m2505o(89912);
            throw runtimeException;
        } catch (IllegalAccessException | NoSuchMethodException cause2) {
            valueOf = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 31).append(valueOf).append(" does not implement setHostname").toString(), cause2);
            AppMethodBeat.m2505o(89912);
            throw illegalArgumentException;
        }
    }

    public void setKeyManagers(KeyManager[] keyManagerArr) {
        this.zzvj = keyManagerArr;
        this.zzvh = null;
        this.zzvg = null;
    }

    public void setNpnProtocols(byte[][] bArr) {
        AppMethodBeat.m2504i(89906);
        this.zzvk = zza(bArr);
        AppMethodBeat.m2505o(89906);
    }

    public void setSoWriteTimeout(Socket socket, int i) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89913);
        try {
            socket.getClass().getMethod("setSoWriteTimeout", new Class[]{Integer.TYPE}).invoke(socket, new Object[]{Integer.valueOf(i)});
            AppMethodBeat.m2505o(89913);
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            cause = invocationTargetException.getCause();
            RuntimeException runtimeException;
            if (cause instanceof SocketException) {
                SocketException socketException = (SocketException) cause;
                AppMethodBeat.m2505o(89913);
                throw socketException;
            } else if (cause instanceof RuntimeException) {
                runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(89913);
                throw runtimeException;
            } else {
                valueOf = String.valueOf(socket.getClass());
                runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Failed to invoke setSoWriteTimeout on ").append(valueOf).toString(), invocationTargetException);
                AppMethodBeat.m2505o(89913);
                throw runtimeException;
            }
        } catch (IllegalAccessException | NoSuchMethodException cause2) {
            valueOf = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 37).append(valueOf).append(" does not implement setSoWriteTimeout").toString(), cause2);
            AppMethodBeat.m2505o(89913);
            throw illegalArgumentException;
        }
    }

    public void setTrustManagers(TrustManager[] trustManagerArr) {
        this.zzvi = trustManagerArr;
        this.zzvh = null;
    }

    public void setUseSessionTickets(Socket socket, boolean z) {
        Throwable cause;
        String valueOf;
        AppMethodBeat.m2504i(89911);
        try {
            socket.getClass().getMethod("setUseSessionTickets", new Class[]{Boolean.TYPE}).invoke(socket, new Object[]{Boolean.valueOf(z)});
            AppMethodBeat.m2505o(89911);
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            cause = invocationTargetException.getCause();
            RuntimeException runtimeException;
            if (cause instanceof RuntimeException) {
                runtimeException = (RuntimeException) cause;
                AppMethodBeat.m2505o(89911);
                throw runtimeException;
            }
            valueOf = String.valueOf(socket.getClass());
            runtimeException = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to invoke setUseSessionTickets on ").append(valueOf).toString(), invocationTargetException);
            AppMethodBeat.m2505o(89911);
            throw runtimeException;
        } catch (IllegalAccessException | NoSuchMethodException cause2) {
            valueOf = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 40).append(valueOf).append(" does not implement setUseSessionTickets").toString(), cause2);
            AppMethodBeat.m2505o(89911);
            throw illegalArgumentException;
        }
    }
}
