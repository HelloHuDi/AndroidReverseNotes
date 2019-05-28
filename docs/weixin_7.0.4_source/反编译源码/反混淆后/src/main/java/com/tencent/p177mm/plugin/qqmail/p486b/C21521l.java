package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C28742a;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C39538b;
import com.tencent.p177mm.plugin.qqmail.p486b.C43403n.C43402c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
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

/* renamed from: com.tencent.mm.plugin.qqmail.b.l */
public final class C21521l extends C43403n {
    private static final String BOUNDARY = ("WEIXIN" + System.currentTimeMillis());
    private HttpPost ptR;

    /* renamed from: com.tencent.mm.plugin.qqmail.b.l$a */
    class C3647a implements HttpEntity {
        private File file;
        private int length;
        private String ptS;
        private String ptT;

        public C3647a(String str, String str2, String str3) {
            AppMethodBeat.m2504i(67944);
            this.ptS = str;
            this.file = new File(str2);
            this.ptT = str3;
            this.length = (str.length() + ((int) this.file.length())) + str3.length();
            AppMethodBeat.m2505o(67944);
        }

        public final boolean isRepeatable() {
            return true;
        }

        public final boolean isChunked() {
            AppMethodBeat.m2504i(67945);
            if (isRepeatable()) {
                AppMethodBeat.m2505o(67945);
                return false;
            }
            AppMethodBeat.m2505o(67945);
            return true;
        }

        public final boolean isStreaming() {
            AppMethodBeat.m2504i(67946);
            if (isRepeatable()) {
                AppMethodBeat.m2505o(67946);
                return false;
            }
            AppMethodBeat.m2505o(67946);
            return true;
        }

        public final long getContentLength() {
            return (long) this.length;
        }

        public final Header getContentType() {
            AppMethodBeat.m2504i(67947);
            BasicHeader basicHeader = new BasicHeader("Content-Type", "multipart/form-data; boundary=----" + C21521l.BOUNDARY);
            AppMethodBeat.m2505o(67947);
            return basicHeader;
        }

        public final Header getContentEncoding() {
            return null;
        }

        public final InputStream getContent() {
            AppMethodBeat.m2504i(67948);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
            AppMethodBeat.m2505o(67948);
            throw unsupportedOperationException;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeTo(OutputStream outputStream) {
            Throwable th;
            AppMethodBeat.m2504i(67949);
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
                            AppMethodBeat.m2505o(67949);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(67949);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                AppMethodBeat.m2505o(67949);
                throw th;
            }
        }

        public final void consumeContent() {
            AppMethodBeat.m2504i(67950);
            if (isStreaming()) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
                AppMethodBeat.m2505o(67950);
                throw unsupportedOperationException;
            }
            AppMethodBeat.m2505o(67950);
        }
    }

    static {
        AppMethodBeat.m2504i(67954);
        AppMethodBeat.m2505o(67954);
    }

    /* renamed from: a */
    public final C43402c mo36997a(String str, String str2, C39538b c39538b, C28742a c28742a) {
        C43402c c43402c;
        int i = 0;
        AppMethodBeat.m2504i(67951);
        C4990ab.m7410d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + c39538b);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        try {
            String a = C21521l.m32976a(c39538b);
            String str3 = c39538b.pue.filePath;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("------" + BOUNDARY + "--\r\n");
            C3647a c3647a = new C3647a(a, str3, stringBuilder.toString());
            this.ptR = new HttpPost(C43403n.m77463f(str, str2, c39538b.puc));
            this.ptR.setHeader("User-Agent", userAgent);
            this.ptR.setHeader("Host", host);
            this.ptR.setHeader("Connection", "Keep-Alive");
            this.ptR.setHeader("Accept-Charset", ProtocolPackage.ServerEncoding);
            this.ptR.setHeader("Cookie", C43403n.m77462W(c39538b.pud));
            this.ptR.setEntity(c3647a);
            HttpResponse execute = defaultHttpClient.execute(this.ptR);
            i = execute.getStatusLine().getStatusCode();
            HttpEntity entity = execute.getEntity();
            str3 = execute.getFirstHeader("set-cookie").getValue();
            c43402c = new C43402c(i, C43403n.m77461Vh(str3), EntityUtils.toString(entity));
            C4990ab.m7410d("MicroMsg.HttpClientUtil", "uri=" + str2 + ", " + c43402c);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.HttpClientUtil", e, "", new Object[0]);
            if (i == 0) {
                i = ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS;
            }
            c43402c = new C43402c(i, null, null);
        } finally {
            defaultHttpClient.getConnectionManager().shutdown();
            AppMethodBeat.m2505o(67951);
        }
        return c43402c;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(67952);
        C4990ab.m7410d("MicroMsg.HttpClientUtil", "cancel conection.");
        if (!(this.ptR == null || this.ptR.isAborted())) {
            this.ptR.abort();
        }
        AppMethodBeat.m2505o(67952);
    }

    /* renamed from: a */
    private static String m32976a(C39538b c39538b) {
        String name;
        AppMethodBeat.m2504i(67953);
        StringBuilder stringBuilder = new StringBuilder();
        for (String name2 : c39538b.puc.keySet()) {
            stringBuilder.append("------" + BOUNDARY + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("Content-Disposition: form-data; name=\"" + name2 + "\"\r\n");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append((String) c39538b.puc.get(name2));
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        File file = new File(c39538b.pue.filePath);
        if (file.isFile()) {
            name2 = file.getName();
            stringBuilder.append("------" + BOUNDARY + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("Content-Disposition: form-data; name=\"" + c39538b.pue.cBy + "\"; filename=\"" + name2 + "\"\r\n");
            stringBuilder.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            name2 = stringBuilder.toString();
            AppMethodBeat.m2505o(67953);
            return name2;
        }
        InvalidParameterException invalidParameterException = new InvalidParameterException("The path to upload isnot a file.");
        AppMethodBeat.m2505o(67953);
        throw invalidParameterException;
    }
}
