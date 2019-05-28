package com.eclipsesource.p097v8.debug;

import com.eclipsesource.p097v8.C45010V8;
import com.eclipsesource.p097v8.JavaVoidCallback;
import com.eclipsesource.p097v8.Releasable;
import com.eclipsesource.p097v8.V8Array;
import com.eclipsesource.p097v8.V8Function;
import com.eclipsesource.p097v8.V8Object;
import com.eclipsesource.p097v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.eclipsesource.v8.debug.V8DebugServer */
public class V8DebugServer {
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String HEADER_EMBEDDING_HOST = "Embedding-Host: ";
    private static final String HEADER_PROTOCOL_VERSION = "Protocol-Version: ";
    private static final String HEADER_TYPE = "Type: ";
    private static final String HEADER_V8_VERSION = "V8-Version: ";
    private static final String J2V8_VERSION = "4.0.0";
    private static final String MAKE_BREAK_EVENT = "__j2v8_MakeBreakEvent";
    private static final String MAKE_COMPILE_EVENT = "__j2v8_MakeCompileEvent";
    private static final int PROTOCOL_BUFFER_SIZE = 4096;
    private static final Charset PROTOCOL_CHARSET = Charset.forName("UTF-8");
    private static final byte[] PROTOCOL_CONTENT_LENGTH_BYTES = PROTOCOL_CONTENT_LENGTH_HEADER.getBytes(PROTOCOL_CHARSET);
    private static final String PROTOCOL_CONTENT_LENGTH_HEADER = "Content-Length:";
    private static final String PROTOCOL_EOL = "\r\n";
    private static final byte[] PROTOCOL_EOL_BYTES = "\r\n".getBytes(PROTOCOL_CHARSET);
    private static final String PROTOCOL_VERSION = "1";
    private static final String SET_LISTENER = "setListener";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private static final String V8_VERSION = "4.10.253";
    private Socket client;
    private Object clientLock = new Object();
    private V8Object debugObject;
    private List<String> requests = new LinkedList();
    private V8Object runningStateDcp;
    private C45010V8 runtime;
    private ServerSocket server;
    private V8Object stoppedStateDcp;
    private boolean traceCommunication = false;
    private boolean waitForConnection;

    /* renamed from: com.eclipsesource.v8.debug.V8DebugServer$ClientLoop */
    class ClientLoop implements Runnable {
        private int from;

        private ClientLoop() {
        }

        /* synthetic */ ClientLoop(V8DebugServer v8DebugServer, C450111 c450111) {
            this();
        }

        public void run() {
            AppMethodBeat.m2504i(74921);
            while (true) {
                try {
                    Socket accept = V8DebugServer.this.server.accept();
                    accept.setTcpNoDelay(true);
                    synchronized (V8DebugServer.this.clientLock) {
                        V8DebugServer.this.client = accept;
                        V8DebugServer.this.waitForConnection = false;
                        V8DebugServer.this.clientLock.notifyAll();
                    }
                    startHandshake();
                    processClientRequests();
                } catch (Exception e) {
                    synchronized (V8DebugServer.this.clientLock) {
                        if (V8DebugServer.this.client != null) {
                            try {
                                V8DebugServer.this.client.close();
                            } catch (IOException e2) {
                            }
                            V8DebugServer.this.client = null;
                        }
                        V8DebugServer.this.logError(e);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(74921);
                    }
                }
            }
        }

        private void startHandshake() {
            AppMethodBeat.m2504i(74922);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(V8DebugServer.HEADER_V8_VERSION);
            stringBuilder.append(V8DebugServer.V8_VERSION);
            stringBuilder.append("\r\n");
            stringBuilder.append(V8DebugServer.HEADER_PROTOCOL_VERSION);
            stringBuilder.append("1");
            stringBuilder.append("\r\n");
            stringBuilder.append(V8DebugServer.HEADER_EMBEDDING_HOST);
            stringBuilder.append("j2v8 ");
            stringBuilder.append(V8DebugServer.J2V8_VERSION);
            stringBuilder.append("\r\n");
            stringBuilder.append(V8DebugServer.HEADER_TYPE);
            stringBuilder.append("connect");
            stringBuilder.append("\r\n");
            V8DebugServer.access$1000(V8DebugServer.this, stringBuilder.toString(), "");
            AppMethodBeat.m2505o(74922);
        }

        private void processClientRequests() {
            InputStream inputStream;
            AppMethodBeat.m2504i(74923);
            byte[] bArr = new byte[0];
            byte[] bArr2 = new byte[4096];
            synchronized (V8DebugServer.this.clientLock) {
                try {
                    inputStream = V8DebugServer.this.client.getInputStream();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(74923);
                }
            }
            int i = -1;
            byte[] bArr3 = bArr;
            boolean z = false;
            int i2 = 0;
            while (true) {
                int read = inputStream.read(bArr2, i2, 4096 - i2);
                if (read <= 0) {
                    break;
                }
                i2 += read;
                this.from = 0;
                do {
                    if (i < 0) {
                        i = readContentLength(bArr2, i2);
                        if (i < 0) {
                            break;
                        }
                    }
                    if (!z) {
                        z = skipToolInfo(bArr2, i2);
                        if (!z) {
                            break;
                        }
                    }
                    read = Math.min(i - bArr3.length, i2 - this.from);
                    bArr3 = join(bArr3, bArr2, this.from, read);
                    this.from = read + this.from;
                    if (bArr3.length == i) {
                        String str = new String(bArr3, V8DebugServer.PROTOCOL_CHARSET);
                        synchronized (V8DebugServer.this.requests) {
                            try {
                                V8DebugServer.this.requests.add(str);
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.m2505o(74923);
                                }
                            }
                        }
                        i = -1;
                        bArr3 = bArr;
                        z = false;
                    }
                } while (this.from < i2);
                if (this.from < i2) {
                    System.arraycopy(bArr2, this.from, bArr2, 0, i2 - this.from);
                    i2 -= this.from;
                } else {
                    i2 = 0;
                }
            }
        }

        private int readContentLength(byte[] bArr, int i) {
            int i2 = -1;
            AppMethodBeat.m2504i(74924);
            int indexOf = indexOf(V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES, bArr, this.from, i);
            if (indexOf < 0) {
                AppMethodBeat.m2505o(74924);
            } else {
                indexOf += V8DebugServer.PROTOCOL_CONTENT_LENGTH_BYTES.length;
                int indexOf2 = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, indexOf, i);
                if (indexOf2 < 0) {
                    AppMethodBeat.m2505o(74924);
                } else {
                    String str = new String(bArr, indexOf, indexOf2 - indexOf, V8DebugServer.PROTOCOL_CHARSET);
                    try {
                        i2 = Integer.parseInt(str.trim());
                        this.from = V8DebugServer.PROTOCOL_EOL_BYTES.length + indexOf2;
                        AppMethodBeat.m2505o(74924);
                    } catch (Exception e) {
                        IOException iOException = new IOException("Invalid content length header: '" + str + "' in message" + new String(bArr, V8DebugServer.PROTOCOL_CHARSET));
                        AppMethodBeat.m2505o(74924);
                        throw iOException;
                    }
                }
            }
            return i2;
        }

        private boolean skipToolInfo(byte[] bArr, int i) {
            AppMethodBeat.m2504i(74925);
            int indexOf = indexOf(V8DebugServer.PROTOCOL_EOL_BYTES, bArr, this.from, i);
            if (indexOf < 0) {
                AppMethodBeat.m2505o(74925);
                return false;
            }
            this.from = indexOf + V8DebugServer.PROTOCOL_EOL_BYTES.length;
            AppMethodBeat.m2505o(74925);
            return true;
        }

        private int indexOf(byte[] bArr, byte[] bArr2, int i, int i2) {
            int length = bArr.length;
            int i3 = i;
            while (i3 < i2) {
                int i4 = 0;
                while (i4 <= length) {
                    if (i4 != length) {
                        if (i3 + i4 >= i2 || bArr2[i3 + i4] != bArr[i4]) {
                            break;
                        }
                        i4++;
                    } else {
                        return i3;
                    }
                }
                i3++;
            }
            return -1;
        }

        private byte[] join(byte[] bArr, byte[] bArr2, int i, int i2) {
            AppMethodBeat.m2504i(74926);
            byte[] bArr3 = new byte[(bArr.length + i2)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, i, bArr3, bArr.length, i2);
            AppMethodBeat.m2505o(74926);
            return bArr3;
        }
    }

    /* renamed from: com.eclipsesource.v8.debug.V8DebugServer$EventHandler */
    class EventHandler implements JavaVoidCallback {
        private EventHandler() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            Throwable e;
            AppMethodBeat.m2504i(74927);
            if (v8Array == null || v8Array.isUndefined()) {
                AppMethodBeat.m2505o(74927);
                return;
            }
            Releasable object;
            Releasable object2;
            try {
                int integer = v8Array.getInteger(0);
                object = v8Array.getObject(1);
                try {
                    object2 = v8Array.getObject(2);
                    try {
                        if (V8DebugServer.this.traceCommunication) {
                            Object obj = "unknown";
                            switch (integer) {
                                case 1:
                                    obj = "Break";
                                    break;
                                case 2:
                                    obj = "Exception";
                                    break;
                                case 3:
                                    obj = "NewFunction";
                                    break;
                                case 4:
                                    obj = "BeforeCompile";
                                    break;
                                case 5:
                                    obj = "AfterCompile";
                                    break;
                                case 6:
                                    obj = "CompileError";
                                    break;
                                case 7:
                                    obj = "PromiseEvent";
                                    break;
                                case 8:
                                    obj = "AsyncTaskEvent";
                                    break;
                            }
                            System.out.println("V8 has emmitted an event of type ".concat(String.valueOf(obj)));
                        }
                        if (V8DebugServer.access$300(V8DebugServer.this)) {
                            switch (integer) {
                                case 1:
                                    V8DebugServer.access$400(V8DebugServer.this, object, object2);
                                    break;
                                case 5:
                                case 6:
                                    V8DebugServer.access$500(V8DebugServer.this, object2);
                                    break;
                            }
                            safeRelease(object);
                            safeRelease(object2);
                            AppMethodBeat.m2505o(74927);
                            return;
                        }
                        safeRelease(object);
                        safeRelease(object2);
                        AppMethodBeat.m2505o(74927);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    object2 = null;
                } catch (Throwable th) {
                    e = th;
                    object2 = null;
                    safeRelease(object);
                    safeRelease(object2);
                    AppMethodBeat.m2505o(74927);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                object2 = null;
                object = null;
                try {
                    V8DebugServer.this.logError(e);
                    safeRelease(object);
                    safeRelease(object2);
                    AppMethodBeat.m2505o(74927);
                } catch (Throwable th2) {
                    e = th2;
                    safeRelease(object);
                    safeRelease(object2);
                    AppMethodBeat.m2505o(74927);
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                object2 = null;
                object = null;
                safeRelease(object);
                safeRelease(object2);
                AppMethodBeat.m2505o(74927);
                throw e;
            }
        }

        private void safeRelease(Releasable releasable) {
            AppMethodBeat.m2504i(74928);
            if (releasable != null) {
                releasable.release();
            }
            AppMethodBeat.m2505o(74928);
        }
    }

    static /* synthetic */ void access$1000(V8DebugServer v8DebugServer, String str, String str2) {
        AppMethodBeat.m2504i(74945);
        v8DebugServer.sendMessage(str, str2);
        AppMethodBeat.m2505o(74945);
    }

    static /* synthetic */ boolean access$300(V8DebugServer v8DebugServer) {
        AppMethodBeat.m2504i(74942);
        boolean isConnected = v8DebugServer.isConnected();
        AppMethodBeat.m2505o(74942);
        return isConnected;
    }

    static /* synthetic */ void access$400(V8DebugServer v8DebugServer, V8Object v8Object, V8Object v8Object2) {
        AppMethodBeat.m2504i(74943);
        v8DebugServer.enterBreakLoop(v8Object, v8Object2);
        AppMethodBeat.m2505o(74943);
    }

    static /* synthetic */ void access$500(V8DebugServer v8DebugServer, V8Object v8Object) {
        AppMethodBeat.m2504i(74944);
        v8DebugServer.sendCompileEvent(v8Object);
        AppMethodBeat.m2505o(74944);
    }

    static {
        AppMethodBeat.m2504i(74946);
        AppMethodBeat.m2505o(74946);
    }

    public static void configureV8ForDebugging() {
        AppMethodBeat.m2504i(74929);
        try {
            C45010V8.setFlags("-expose-debug-as=" + DEBUG_OBJECT_NAME);
            AppMethodBeat.m2505o(74929);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(74929);
        }
    }

    public V8DebugServer(C45010V8 c45010v8, int i, boolean z) {
        AppMethodBeat.m2504i(74930);
        this.runtime = c45010v8;
        this.waitForConnection = z;
        V8Object object = c45010v8.getObject(DEBUG_OBJECT_NAME);
        if (object == null) {
            System.err.println("Cannot initialize debugger server - global debug object not found.");
            AppMethodBeat.m2505o(74930);
            return;
        }
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
            object.release();
            c45010v8.executeVoidScript("(function() {\n " + DEBUG_OBJECT_NAME + ".Debug. __j2v8_MakeBreakEvent = function (break_id,breakpoints_hit) {\n  return new " + DEBUG_OBJECT_NAME + ".BreakEvent(break_id,breakpoints_hit);\n }\n " + DEBUG_OBJECT_NAME + ".Debug. __j2v8_MakeCompileEvent = function(script,type) {\n  var scripts = " + DEBUG_OBJECT_NAME + ".Debug.scripts()\n  for (var i in scripts) {\n   if (scripts[i].id == script.id()) {\n     return new " + DEBUG_OBJECT_NAME + ".CompileEvent(scripts[i], type);\n   }\n  }\n  return {toJSONProtocol: function() {return ''}}\n }\n})()");
            try {
                this.server = new ServerSocket(i);
                AppMethodBeat.m2505o(74930);
            } catch (Exception e) {
                logError(e);
                AppMethodBeat.m2505o(74930);
            }
        } catch (Throwable th) {
            object.release();
            AppMethodBeat.m2505o(74930);
        }
    }

    public int getPort() {
        AppMethodBeat.m2504i(74931);
        if (this.server == null || !this.server.isBound()) {
            AppMethodBeat.m2505o(74931);
            return -1;
        }
        int localPort = this.server.getLocalPort();
        AppMethodBeat.m2505o(74931);
        return localPort;
    }

    public void setTraceCommunication(boolean z) {
        this.traceCommunication = z;
    }

    public void start() {
        AppMethodBeat.m2504i(74932);
        if (this.server == null) {
            AppMethodBeat.m2505o(74932);
            return;
        }
        boolean z = this.waitForConnection;
        Thread thread = new Thread(new ClientLoop(this, null), "J2V8 Debugger Server");
        thread.setDaemon(true);
        thread.start();
        setupEventHandler();
        this.runningStateDcp = this.runtime.executeObjectScript("(function() {return new " + DEBUG_OBJECT_NAME + ".DebugCommandProcessor(null, true)})()");
        if (z) {
            synchronized (this.clientLock) {
                while (this.waitForConnection) {
                    try {
                        try {
                            this.clientLock.wait();
                        } catch (InterruptedException e) {
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(74932);
                    }
                }
            }
            try {
                processRequests(100);
                return;
            } catch (InterruptedException e2) {
            }
        }
        AppMethodBeat.m2505o(74932);
    }

    public void stop() {
        AppMethodBeat.m2504i(74933);
        try {
            this.server.close();
            synchronized (this.clientLock) {
                if (this.client != null) {
                    this.client.close();
                    this.client = null;
                }
            }
        } catch (IOException e) {
            logError(e);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(74933);
            }
        }
        if (this.runningStateDcp != null) {
            this.runningStateDcp.release();
            this.runningStateDcp = null;
        }
        if (this.debugObject != null) {
            this.debugObject.release();
            this.debugObject = null;
        }
        if (this.stoppedStateDcp != null) {
            this.stoppedStateDcp.release();
            this.stoppedStateDcp = null;
        }
        AppMethodBeat.m2505o(74933);
    }

    private void sendJson(String str) {
        AppMethodBeat.m2504i(74934);
        sendMessage("", str.replace("\\/", "/"));
        AppMethodBeat.m2505o(74934);
    }

    /* Access modifiers changed, original: protected */
    public void logError(Throwable th) {
    }

    private void sendMessage(String str, String str2) {
        AppMethodBeat.m2504i(74935);
        synchronized (this.clientLock) {
            try {
                if (isConnected()) {
                    byte[] bytes = str2.getBytes(PROTOCOL_CHARSET);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(PROTOCOL_CONTENT_LENGTH_HEADER);
                    stringBuilder.append(Integer.toString(bytes.length));
                    stringBuilder.append("\r\n");
                    stringBuilder.append("\r\n");
                    this.client.getOutputStream().write(stringBuilder.toString().getBytes(PROTOCOL_CHARSET));
                    if (bytes.length > 0) {
                        this.client.getOutputStream().write(bytes);
                    }
                } else {
                    Object iOException = new IOException("There is no connected client.");
                    throw iOException;
                }
            } finally {
                AppMethodBeat.m2505o(74935);
            }
        }
        AppMethodBeat.m2505o(74935);
    }

    private boolean isConnected() {
        boolean z;
        AppMethodBeat.m2504i(74936);
        synchronized (this.clientLock) {
            try {
                z = (this.server == null || this.client == null || !this.client.isConnected()) ? false : true;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(74936);
            }
        }
        return z;
    }

    public void processRequests(long j) {
        AppMethodBeat.m2504i(74937);
        if (this.server == null) {
            AppMethodBeat.m2505o(74937);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            String[] strArr;
            synchronized (this.requests) {
                try {
                    strArr = (String[]) this.requests.toArray(new String[this.requests.size()]);
                    this.requests.clear();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(74937);
                    }
                }
            }
            for (String processRequest : strArr) {
                try {
                    processRequest(processRequest);
                } catch (Exception e) {
                    logError(e);
                }
            }
            if (strArr.length <= 0) {
                if (j > 0) {
                    Thread.sleep(10);
                }
                if (j <= 0 || currentTimeMillis + j <= System.currentTimeMillis()) {
                    AppMethodBeat.m2505o(74937);
                }
            }
        }
        AppMethodBeat.m2505o(74937);
    }

    private void processRequest(String str) {
        AppMethodBeat.m2504i(74938);
        if (this.traceCommunication) {
            System.out.println("Got message: \n" + str.substring(0, Math.min(str.length(), 1000)));
        }
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        V8Object v8Object = this.stoppedStateDcp != null ? this.stoppedStateDcp : this.runningStateDcp;
        String obj = v8Object.executeFunction("processDebugJSONRequest", v8Array).toString();
        if (this.stoppedStateDcp == null && obj.contains("\"running\":false")) {
            obj = obj.replace("\"running\":false", "\"running\":true").replace("\"success\":true", "\"success\":false").replace("{\"", "{\"message\":\"Client requested suspension is not supported on J2V8.\",\"");
            v8Object.add("running_", true);
        }
        String str2 = obj;
        if (this.traceCommunication) {
            System.out.println("Returning response: \n" + str2.substring(0, Math.min(str2.length(), 1000)));
        }
        sendJson(str2);
        AppMethodBeat.m2505o(74938);
    }

    private void setupEventHandler() {
        Throwable th;
        V8Value v8Value;
        V8Function v8Value2;
        AppMethodBeat.m2504i(74939);
        this.debugObject.registerJavaMethod(new EventHandler(), DEBUG_BREAK_HANDLER);
        V8Array push;
        try {
            V8Value v8Value3 = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                push = new V8Array(this.runtime).push(v8Value3);
            } catch (Throwable th2) {
                th = th2;
                push = null;
                v8Value2 = v8Value3;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, push);
                if (!(v8Value3 == null || v8Value3.isReleased())) {
                    v8Value3.release();
                }
                if (push == null || push.isReleased()) {
                    AppMethodBeat.m2505o(74939);
                    return;
                }
                push.release();
                AppMethodBeat.m2505o(74939);
            } catch (Throwable th3) {
                th = th3;
                v8Value2 = v8Value3;
                if (!(v8Value2 == null || v8Value2.isReleased())) {
                    v8Value2.release();
                }
                if (!(push == null || push.isReleased())) {
                    push.release();
                }
                AppMethodBeat.m2505o(74939);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            push = null;
            v8Value2 = null;
            v8Value2.release();
            push.release();
            AppMethodBeat.m2505o(74939);
            throw th;
        }
    }

    private void enterBreakLoop(V8Object v8Object, V8Object v8Object2) {
        Throwable th;
        AppMethodBeat.m2504i(74940);
        V8Array v8Array;
        try {
            v8Array = new V8Array(this.runtime);
            v8Array.push(false);
            this.stoppedStateDcp = v8Object.executeObjectFunction("debugCommandProcessor", v8Array);
            v8Array.release();
            int integer = v8Object.getInteger("break_id");
            V8Value array = v8Object2.getArray("break_points_hit_");
            V8Array v8Array2 = new V8Array(this.runtime);
            V8Object executeObjectFunction;
            try {
                v8Array2.push(integer);
                v8Array2.push(array);
                executeObjectFunction = this.debugObject.executeObjectFunction(MAKE_BREAK_EVENT, v8Array2);
                try {
                    String executeStringFunction = executeObjectFunction.executeStringFunction("toJSONProtocol", null);
                    if (this.traceCommunication) {
                        System.out.println("Sending event (Break):\n".concat(String.valueOf(executeStringFunction)));
                    }
                    sendJson(executeStringFunction);
                    v8Array2.release();
                    array.release();
                    if (executeObjectFunction != null) {
                        executeObjectFunction.release();
                    }
                    while (isConnected() && !this.stoppedStateDcp.executeBooleanFunction("isRunning", null)) {
                        try {
                            processRequests(10);
                        } catch (InterruptedException e) {
                        }
                    }
                    this.stoppedStateDcp.release();
                    this.stoppedStateDcp = null;
                    AppMethodBeat.m2505o(74940);
                } catch (Throwable th2) {
                    th = th2;
                    v8Array2.release();
                    array.release();
                    if (executeObjectFunction != null) {
                        executeObjectFunction.release();
                    }
                    AppMethodBeat.m2505o(74940);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                executeObjectFunction = null;
            }
        } catch (Throwable th4) {
            this.stoppedStateDcp.release();
            this.stoppedStateDcp = null;
            AppMethodBeat.m2505o(74940);
        }
    }

    private void sendCompileEvent(V8Object v8Object) {
        V8Object v8Object2 = null;
        AppMethodBeat.m2504i(74941);
        if (isConnected()) {
            int integer = v8Object.getInteger("type_");
            V8Value object = v8Object.getObject("script_");
            V8Array v8Array = new V8Array(this.runtime);
            try {
                v8Array.push(object);
                v8Array.push(integer);
                v8Object2 = this.debugObject.executeObjectFunction(MAKE_COMPILE_EVENT, v8Array);
                String executeStringFunction = v8Object2.executeStringFunction("toJSONProtocol", null);
                if (this.traceCommunication) {
                    System.out.println("Sending event (CompileEvent):\n" + executeStringFunction.substring(0, Math.min(executeStringFunction.length(), 1000)));
                }
                if (executeStringFunction.length() > 0) {
                    sendJson(executeStringFunction);
                }
                v8Array.release();
                object.release();
                if (v8Object2 != null) {
                    v8Object2.release();
                    AppMethodBeat.m2505o(74941);
                    return;
                }
                AppMethodBeat.m2505o(74941);
            } catch (Throwable th) {
                v8Array.release();
                object.release();
                if (v8Object2 != null) {
                    v8Object2.release();
                }
                AppMethodBeat.m2505o(74941);
            }
        } else {
            AppMethodBeat.m2505o(74941);
        }
    }
}
