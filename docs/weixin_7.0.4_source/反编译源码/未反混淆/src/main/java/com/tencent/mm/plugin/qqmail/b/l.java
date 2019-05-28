package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.qqmail.b.n.b;
import com.tencent.mm.plugin.qqmail.b.n.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public final class l extends n {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost ptR;

    class a implements HttpEntity {
        private File file;
        private int length;
        private String ptS;
        private String ptT;

        public a(String str, String str2, String str3) {
            AppMethodBeat.i(67944);
            this.ptS = str;
            this.file = new File(str2);
            this.ptT = str3;
            this.length = (str.length() + ((int) this.file.length())) + str3.length();
            AppMethodBeat.o(67944);
        }

        public final boolean isRepeatable() {
            return true;
        }

        public final boolean isChunked() {
            AppMethodBeat.i(67945);
            if (isRepeatable()) {
                AppMethodBeat.o(67945);
                return false;
            }
            AppMethodBeat.o(67945);
            return true;
        }

        public final boolean isStreaming() {
            AppMethodBeat.i(67946);
            if (isRepeatable()) {
                AppMethodBeat.o(67946);
                return false;
            }
            AppMethodBeat.o(67946);
            return true;
        }

        public final long getContentLength() {
            return (long) this.length;
        }

        public final Header getContentType() {
            AppMethodBeat.i(67947);
            BasicHeader basicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + l.BOUNDARY);
            AppMethodBeat.o(67947);
            return basicHeader;
        }

        public final Header getContentEncoding() {
            return null;
        }

        public final InputStream getContent() {
            AppMethodBeat.i(67948);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
            AppMethodBeat.o(67948);
            throw unsupportedOperationException;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeTo(OutputStream outputStream) {
            Throwable th;
            AppMethodBeat.i(67949);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeBytes(this.ptS);
            FileInputStream fileInputStream;
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                fileInputStream = new FileInputStream(this.file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            dataOutputStream.write(bArr, 0, read);
                        } else {
                            dataOutputStream.flush();
                            fileInputStream.close();
                            dataOutputStream.writeBytes(this.ptT);
                            AppMethodBeat.o(67949);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(67949);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.o(67949);
                throw th;
            }
        }

        public final void consumeContent() {
            AppMethodBeat.i(67950);
            if (isStreaming()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
                AppMethodBeat.o(67950);
                throw unsupportedOperationException;
            }
            AppMethodBeat.o(67950);
        }
    }

    static {
        AppMethodBeat.i(67954);
        AppMethodBeat.o(67954);
    }

    public final c a(String str, String str2, b bVar, com.tencent.mm.plugin.qqmail.b.n.a aVar) {
        c cVar;
        int i = 0;
        AppMethodBeat.i(67951);
        ab.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + bVar);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a = a(bVar);
            String str3 = bVar.pue.filePath;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("------" + BOUNDARY + "--\r\n");
            a aVar2 = new a(a, str3, stringBuilder.toString());
            this.ptR = new HttpPost(n.f(str, str2, bVar.puc));
            this.ptR.setHeader("User-Agent", userAgent);
            this.ptR.setHeader("Host", host);
            this.ptR.setHeader("Connection", "Keep-Alive");
            this.ptR.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ptR.setHeader("Cookie", n.W(bVar.pud));
            this.ptR.setEntity(aVar2);
            HttpResponse execute = defaultHttpClient.execute(this.ptR);
            i = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            str3 = execute.getFirstHeader("set-cookie").getValue();
            cVar = new c(i, n.Vh(str3), EntityUtils.toString(entity));
            ab.d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + cVar);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.HttpClientUtil", e, "", new Object[0]);
            if (i == 0) {
                i = ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS;
            }
            cVar = new c(i, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
            AppMethodBeat.o(67951);
        }
        return cVar;
    }

    public final void cancel() {
        AppMethodBeat.i(67952);
        ab.d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (!(this.ptR == null || this.ptR.isAborted())) {
            this.ptR.abort();
        }
        AppMethodBeat.o(67952);
    }

    private static String a(b bVar) {
        String name;
        AppMethodBeat.i(67953);
        StringBuilder stringBuilder = new StringBuilder();
        for (String name2 : bVar.puc.keySet()) {
            stringBuilder.append("------" + BOUNDARY + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("Content-Disposition: form-data; name=\"" + name2 + "\"\r\n");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append((String) bVar.puc.get(name2));
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        File file = new File(bVar.pue.filePath);
        if (file.isFile()) {
            name2 = file.getName();
            stringBuilder.append("------" + BOUNDARY + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("Content-Disposition: form-data; name=\"" + bVar.pue.cBy + "\"; filename=\"" + name2 + "\"\r\n");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            name2 = stringBuilder.toString();
            AppMethodBeat.o(67953);
            return name2;
        }
        InvalidParameterException invalidParameterException = new InvalidParameterException("The path to upload isnot a file.");
        AppMethodBeat.o(67953);
        throw invalidParameterException;
    }
}
