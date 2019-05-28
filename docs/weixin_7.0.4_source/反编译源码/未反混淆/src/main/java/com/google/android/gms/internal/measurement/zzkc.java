package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzkc extends SSLSocket {
    private final SSLSocket zzarj;

    zzkc(zzkb zzkb, SSLSocket sSLSocket) {
        this.zzarj = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        AppMethodBeat.i(69592);
        this.zzarj.addHandshakeCompletedListener(handshakeCompletedListener);
        AppMethodBeat.o(69592);
    }

    public final void bind(SocketAddress socketAddress) {
        AppMethodBeat.i(69603);
        this.zzarj.bind(socketAddress);
        AppMethodBeat.o(69603);
    }

    public final synchronized void close() {
        AppMethodBeat.i(69604);
        this.zzarj.close();
        AppMethodBeat.o(69604);
    }

    public final void connect(SocketAddress socketAddress) {
        AppMethodBeat.i(69605);
        this.zzarj.connect(socketAddress);
        AppMethodBeat.o(69605);
    }

    public final void connect(SocketAddress socketAddress, int i) {
        AppMethodBeat.i(69606);
        this.zzarj.connect(socketAddress, i);
        AppMethodBeat.o(69606);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(69644);
        boolean equals = this.zzarj.equals(obj);
        AppMethodBeat.o(69644);
        return equals;
    }

    public final SocketChannel getChannel() {
        AppMethodBeat.i(69607);
        SocketChannel channel = this.zzarj.getChannel();
        AppMethodBeat.o(69607);
        return channel;
    }

    public final boolean getEnableSessionCreation() {
        AppMethodBeat.i(69602);
        boolean enableSessionCreation = this.zzarj.getEnableSessionCreation();
        AppMethodBeat.o(69602);
        return enableSessionCreation;
    }

    public final String[] getEnabledCipherSuites() {
        AppMethodBeat.i(69587);
        String[] enabledCipherSuites = this.zzarj.getEnabledCipherSuites();
        AppMethodBeat.o(69587);
        return enabledCipherSuites;
    }

    public final String[] getEnabledProtocols() {
        AppMethodBeat.i(69590);
        String[] enabledProtocols = this.zzarj.getEnabledProtocols();
        AppMethodBeat.o(69590);
        return enabledProtocols;
    }

    public final InetAddress getInetAddress() {
        AppMethodBeat.i(69608);
        InetAddress inetAddress = this.zzarj.getInetAddress();
        AppMethodBeat.o(69608);
        return inetAddress;
    }

    public final InputStream getInputStream() {
        AppMethodBeat.i(69609);
        InputStream inputStream = this.zzarj.getInputStream();
        AppMethodBeat.o(69609);
        return inputStream;
    }

    public final boolean getKeepAlive() {
        AppMethodBeat.i(69610);
        boolean keepAlive = this.zzarj.getKeepAlive();
        AppMethodBeat.o(69610);
        return keepAlive;
    }

    public final InetAddress getLocalAddress() {
        AppMethodBeat.i(69611);
        InetAddress localAddress = this.zzarj.getLocalAddress();
        AppMethodBeat.o(69611);
        return localAddress;
    }

    public final int getLocalPort() {
        AppMethodBeat.i(69612);
        int localPort = this.zzarj.getLocalPort();
        AppMethodBeat.o(69612);
        return localPort;
    }

    public final SocketAddress getLocalSocketAddress() {
        AppMethodBeat.i(69613);
        SocketAddress localSocketAddress = this.zzarj.getLocalSocketAddress();
        AppMethodBeat.o(69613);
        return localSocketAddress;
    }

    public final boolean getNeedClientAuth() {
        AppMethodBeat.i(69599);
        boolean needClientAuth = this.zzarj.getNeedClientAuth();
        AppMethodBeat.o(69599);
        return needClientAuth;
    }

    public final boolean getOOBInline() {
        AppMethodBeat.i(69614);
        boolean oOBInline = this.zzarj.getOOBInline();
        AppMethodBeat.o(69614);
        return oOBInline;
    }

    public final OutputStream getOutputStream() {
        AppMethodBeat.i(69615);
        OutputStream outputStream = this.zzarj.getOutputStream();
        AppMethodBeat.o(69615);
        return outputStream;
    }

    public final int getPort() {
        AppMethodBeat.i(69616);
        int port = this.zzarj.getPort();
        AppMethodBeat.o(69616);
        return port;
    }

    public final synchronized int getReceiveBufferSize() {
        int receiveBufferSize;
        AppMethodBeat.i(69617);
        receiveBufferSize = this.zzarj.getReceiveBufferSize();
        AppMethodBeat.o(69617);
        return receiveBufferSize;
    }

    public final SocketAddress getRemoteSocketAddress() {
        AppMethodBeat.i(69618);
        SocketAddress remoteSocketAddress = this.zzarj.getRemoteSocketAddress();
        AppMethodBeat.o(69618);
        return remoteSocketAddress;
    }

    public final boolean getReuseAddress() {
        AppMethodBeat.i(69619);
        boolean reuseAddress = this.zzarj.getReuseAddress();
        AppMethodBeat.o(69619);
        return reuseAddress;
    }

    public final synchronized int getSendBufferSize() {
        int sendBufferSize;
        AppMethodBeat.i(69620);
        sendBufferSize = this.zzarj.getSendBufferSize();
        AppMethodBeat.o(69620);
        return sendBufferSize;
    }

    public final SSLSession getSession() {
        AppMethodBeat.i(69591);
        SSLSession session = this.zzarj.getSession();
        AppMethodBeat.o(69591);
        return session;
    }

    public final int getSoLinger() {
        AppMethodBeat.i(69621);
        int soLinger = this.zzarj.getSoLinger();
        AppMethodBeat.o(69621);
        return soLinger;
    }

    public final synchronized int getSoTimeout() {
        int soTimeout;
        AppMethodBeat.i(69622);
        soTimeout = this.zzarj.getSoTimeout();
        AppMethodBeat.o(69622);
        return soTimeout;
    }

    public final String[] getSupportedCipherSuites() {
        AppMethodBeat.i(69586);
        String[] supportedCipherSuites = this.zzarj.getSupportedCipherSuites();
        AppMethodBeat.o(69586);
        return supportedCipherSuites;
    }

    public final String[] getSupportedProtocols() {
        AppMethodBeat.i(69589);
        String[] supportedProtocols = this.zzarj.getSupportedProtocols();
        AppMethodBeat.o(69589);
        return supportedProtocols;
    }

    public final boolean getTcpNoDelay() {
        AppMethodBeat.i(69623);
        boolean tcpNoDelay = this.zzarj.getTcpNoDelay();
        AppMethodBeat.o(69623);
        return tcpNoDelay;
    }

    public final int getTrafficClass() {
        AppMethodBeat.i(69624);
        int trafficClass = this.zzarj.getTrafficClass();
        AppMethodBeat.o(69624);
        return trafficClass;
    }

    public final boolean getUseClientMode() {
        AppMethodBeat.i(69596);
        boolean useClientMode = this.zzarj.getUseClientMode();
        AppMethodBeat.o(69596);
        return useClientMode;
    }

    public final boolean getWantClientAuth() {
        AppMethodBeat.i(69600);
        boolean wantClientAuth = this.zzarj.getWantClientAuth();
        AppMethodBeat.o(69600);
        return wantClientAuth;
    }

    public final boolean isBound() {
        AppMethodBeat.i(69625);
        boolean isBound = this.zzarj.isBound();
        AppMethodBeat.o(69625);
        return isBound;
    }

    public final boolean isClosed() {
        AppMethodBeat.i(69626);
        boolean isClosed = this.zzarj.isClosed();
        AppMethodBeat.o(69626);
        return isClosed;
    }

    public final boolean isConnected() {
        AppMethodBeat.i(69627);
        boolean isConnected = this.zzarj.isConnected();
        AppMethodBeat.o(69627);
        return isConnected;
    }

    public final boolean isInputShutdown() {
        AppMethodBeat.i(69628);
        boolean isInputShutdown = this.zzarj.isInputShutdown();
        AppMethodBeat.o(69628);
        return isInputShutdown;
    }

    public final boolean isOutputShutdown() {
        AppMethodBeat.i(69629);
        boolean isOutputShutdown = this.zzarj.isOutputShutdown();
        AppMethodBeat.o(69629);
        return isOutputShutdown;
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        AppMethodBeat.i(69593);
        this.zzarj.removeHandshakeCompletedListener(handshakeCompletedListener);
        AppMethodBeat.o(69593);
    }

    public final void sendUrgentData(int i) {
        AppMethodBeat.i(69630);
        this.zzarj.sendUrgentData(i);
        AppMethodBeat.o(69630);
    }

    public final void setEnableSessionCreation(boolean z) {
        AppMethodBeat.i(69601);
        this.zzarj.setEnableSessionCreation(z);
        AppMethodBeat.o(69601);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        AppMethodBeat.i(69588);
        this.zzarj.setEnabledCipherSuites(strArr);
        AppMethodBeat.o(69588);
    }

    public final void setEnabledProtocols(String[] strArr) {
        AppMethodBeat.i(69585);
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.zzarj.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.zzarj.setEnabledProtocols(strArr);
        AppMethodBeat.o(69585);
    }

    public final void setKeepAlive(boolean z) {
        AppMethodBeat.i(69631);
        this.zzarj.setKeepAlive(z);
        AppMethodBeat.o(69631);
    }

    public final void setNeedClientAuth(boolean z) {
        AppMethodBeat.i(69597);
        this.zzarj.setNeedClientAuth(z);
        AppMethodBeat.o(69597);
    }

    public final void setOOBInline(boolean z) {
        AppMethodBeat.i(69632);
        this.zzarj.setOOBInline(z);
        AppMethodBeat.o(69632);
    }

    public final void setPerformancePreferences(int i, int i2, int i3) {
        AppMethodBeat.i(69633);
        this.zzarj.setPerformancePreferences(i, i2, i3);
        AppMethodBeat.o(69633);
    }

    public final synchronized void setReceiveBufferSize(int i) {
        AppMethodBeat.i(69634);
        this.zzarj.setReceiveBufferSize(i);
        AppMethodBeat.o(69634);
    }

    public final void setReuseAddress(boolean z) {
        AppMethodBeat.i(69635);
        this.zzarj.setReuseAddress(z);
        AppMethodBeat.o(69635);
    }

    public final synchronized void setSendBufferSize(int i) {
        AppMethodBeat.i(69636);
        this.zzarj.setSendBufferSize(i);
        AppMethodBeat.o(69636);
    }

    public final void setSoLinger(boolean z, int i) {
        AppMethodBeat.i(69637);
        this.zzarj.setSoLinger(z, i);
        AppMethodBeat.o(69637);
    }

    public final synchronized void setSoTimeout(int i) {
        AppMethodBeat.i(69638);
        this.zzarj.setSoTimeout(i);
        AppMethodBeat.o(69638);
    }

    public final void setTcpNoDelay(boolean z) {
        AppMethodBeat.i(69639);
        this.zzarj.setTcpNoDelay(z);
        AppMethodBeat.o(69639);
    }

    public final void setTrafficClass(int i) {
        AppMethodBeat.i(69640);
        this.zzarj.setTrafficClass(i);
        AppMethodBeat.o(69640);
    }

    public final void setUseClientMode(boolean z) {
        AppMethodBeat.i(69595);
        this.zzarj.setUseClientMode(z);
        AppMethodBeat.o(69595);
    }

    public final void setWantClientAuth(boolean z) {
        AppMethodBeat.i(69598);
        this.zzarj.setWantClientAuth(z);
        AppMethodBeat.o(69598);
    }

    public final void shutdownInput() {
        AppMethodBeat.i(69641);
        this.zzarj.shutdownInput();
        AppMethodBeat.o(69641);
    }

    public final void shutdownOutput() {
        AppMethodBeat.i(69642);
        this.zzarj.shutdownOutput();
        AppMethodBeat.o(69642);
    }

    public final void startHandshake() {
        AppMethodBeat.i(69594);
        this.zzarj.startHandshake();
        AppMethodBeat.o(69594);
    }

    public final String toString() {
        AppMethodBeat.i(69643);
        String sSLSocket = this.zzarj.toString();
        AppMethodBeat.o(69643);
        return sSLSocket;
    }
}
