package com.tencent.p177mm.plugin.appbrand.p321l;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p326n.C2402a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C10730b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.l.d */
public final class C33422d {
    private C2241c hvw;
    private final String ibJ;
    protected final ArrayList<C10570e> ioA = new ArrayList();
    int ioB;
    private SSLContext ios;
    protected final ArrayList<String> iot = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.appbrand.l.d$a */
    public interface C27148a {
        /* renamed from: BA */
        void mo44821BA(String str);

        /* renamed from: a */
        void mo44822a(String str, Object obj, int i, JSONObject jSONObject);

        /* renamed from: p */
        void mo44823p(JSONObject jSONObject);
    }

    public C33422d(C2241c c2241c) {
        AppMethodBeat.m2504i(108149);
        this.hvw = c2241c;
        C38414a c38414a = (C38414a) c2241c.mo5937aa(C38414a.class);
        if (c38414a == null) {
            C4990ab.m7412e("MicroMsg.AppBrandNetworkRequest", "hy: config not found");
            this.ibJ = "";
            AppMethodBeat.m2505o(108149);
            return;
        }
        this.ioB = c38414a.bQw;
        this.ibJ = c38414a.ioo;
        this.ios = C19538j.m30268a(c38414a);
        AppMethodBeat.m2505o(108149);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:287:0x0b83=Splitter:B:287:0x0b83, B:239:0x09a4=Splitter:B:239:0x09a4, B:356:0x0e35=Splitter:B:356:0x0e35, B:310:0x0c69=Splitter:B:310:0x0c69, B:379:0x0f1b=Splitter:B:379:0x0f1b, B:54:0x032e=Splitter:B:54:0x032e, B:216:0x08be=Splitter:B:216:0x08be, B:333:0x0d4f=Splitter:B:333:0x0d4f} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x1191 A:{Splitter:B:78:0x0434, ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException)} */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x1169 A:{Splitter:B:78:0x0434, ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:491:0x1147 A:{Splitter:B:78:0x0434, ExcHandler: FileNotFoundException (e java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x1125 A:{Splitter:B:78:0x0434, ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x1103 A:{Splitter:B:78:0x0434, ExcHandler: ConnectException (e java.net.ConnectException)} */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x10e1 A:{Splitter:B:78:0x0434, ExcHandler: ProtocolException (e java.net.ProtocolException)} */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x10bf A:{Splitter:B:78:0x0434, ExcHandler: ArrayIndexOutOfBoundsException (e java.lang.ArrayIndexOutOfBoundsException)} */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x109d A:{Splitter:B:78:0x0434, ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x1052 A:{Splitter:B:78:0x0434, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03be A:{SYNTHETIC, Splitter:B:61:0x03be} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03c3 A:{SYNTHETIC, Splitter:B:64:0x03c3} */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0928  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x094e A:{SYNTHETIC, Splitter:B:223:0x094e} */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0953 A:{SYNTHETIC, Splitter:B:226:0x0953} */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0a84 A:{SYNTHETIC, Splitter:B:255:0x0a84} */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bd A:{Catch:{ all -> 0x0a9f }} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0a69 A:{SYNTHETIC, Splitter:B:249:0x0a69} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0a6e A:{SYNTHETIC, Splitter:B:252:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0bed  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0c13 A:{SYNTHETIC, Splitter:B:294:0x0c13} */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0c18 A:{SYNTHETIC, Splitter:B:297:0x0c18} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0cf9 A:{SYNTHETIC, Splitter:B:317:0x0cf9} */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0cfe A:{SYNTHETIC, Splitter:B:320:0x0cfe} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0db9  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0ddf A:{SYNTHETIC, Splitter:B:340:0x0ddf} */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0de4 A:{SYNTHETIC, Splitter:B:343:0x0de4} */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0ec5 A:{SYNTHETIC, Splitter:B:363:0x0ec5} */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0eca A:{SYNTHETIC, Splitter:B:366:0x0eca} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0305 A:{SYNTHETIC, Splitter:B:44:0x0305} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x030a A:{SYNTHETIC, Splitter:B:47:0x030a} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03be A:{SYNTHETIC, Splitter:B:61:0x03be} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03c3 A:{SYNTHETIC, Splitter:B:64:0x03c3} */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0928  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x094e A:{SYNTHETIC, Splitter:B:223:0x094e} */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0953 A:{SYNTHETIC, Splitter:B:226:0x0953} */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bd A:{Catch:{ all -> 0x0a9f }} */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0a84 A:{SYNTHETIC, Splitter:B:255:0x0a84} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0a69 A:{SYNTHETIC, Splitter:B:249:0x0a69} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0a6e A:{SYNTHETIC, Splitter:B:252:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0bed  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0c13 A:{SYNTHETIC, Splitter:B:294:0x0c13} */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0c18 A:{SYNTHETIC, Splitter:B:297:0x0c18} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0cf9 A:{SYNTHETIC, Splitter:B:317:0x0cf9} */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0cfe A:{SYNTHETIC, Splitter:B:320:0x0cfe} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0db9  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0ddf A:{SYNTHETIC, Splitter:B:340:0x0ddf} */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0de4 A:{SYNTHETIC, Splitter:B:343:0x0de4} */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0ec5 A:{SYNTHETIC, Splitter:B:363:0x0ec5} */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0eca A:{SYNTHETIC, Splitter:B:366:0x0eca} */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0f93  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0fb9 A:{SYNTHETIC, Splitter:B:386:0x0fb9} */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0fbe A:{SYNTHETIC, Splitter:B:389:0x0fbe} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0305 A:{SYNTHETIC, Splitter:B:44:0x0305} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x030a A:{SYNTHETIC, Splitter:B:47:0x030a} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03be A:{SYNTHETIC, Splitter:B:61:0x03be} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03c3 A:{SYNTHETIC, Splitter:B:64:0x03c3} */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0928  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x094e A:{SYNTHETIC, Splitter:B:223:0x094e} */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0953 A:{SYNTHETIC, Splitter:B:226:0x0953} */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0a84 A:{SYNTHETIC, Splitter:B:255:0x0a84} */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bd A:{Catch:{ all -> 0x0a9f }} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0a69 A:{SYNTHETIC, Splitter:B:249:0x0a69} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0a6e A:{SYNTHETIC, Splitter:B:252:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0bed  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0c13 A:{SYNTHETIC, Splitter:B:294:0x0c13} */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0c18 A:{SYNTHETIC, Splitter:B:297:0x0c18} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0cf9 A:{SYNTHETIC, Splitter:B:317:0x0cf9} */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0cfe A:{SYNTHETIC, Splitter:B:320:0x0cfe} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0db9  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0ddf A:{SYNTHETIC, Splitter:B:340:0x0ddf} */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0de4 A:{SYNTHETIC, Splitter:B:343:0x0de4} */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0ec5 A:{SYNTHETIC, Splitter:B:363:0x0ec5} */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0eca A:{SYNTHETIC, Splitter:B:366:0x0eca} */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0f93  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0fb9 A:{SYNTHETIC, Splitter:B:386:0x0fb9} */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0fbe A:{SYNTHETIC, Splitter:B:389:0x0fbe} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03be A:{SYNTHETIC, Splitter:B:61:0x03be} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03c3 A:{SYNTHETIC, Splitter:B:64:0x03c3} */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0928  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x094e A:{SYNTHETIC, Splitter:B:223:0x094e} */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0953 A:{SYNTHETIC, Splitter:B:226:0x0953} */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bd A:{Catch:{ all -> 0x0a9f }} */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0a84 A:{SYNTHETIC, Splitter:B:255:0x0a84} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0a69 A:{SYNTHETIC, Splitter:B:249:0x0a69} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0a6e A:{SYNTHETIC, Splitter:B:252:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0bed  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0c13 A:{SYNTHETIC, Splitter:B:294:0x0c13} */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0c18 A:{SYNTHETIC, Splitter:B:297:0x0c18} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0cf9 A:{SYNTHETIC, Splitter:B:317:0x0cf9} */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0cfe A:{SYNTHETIC, Splitter:B:320:0x0cfe} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0db9  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0ddf A:{SYNTHETIC, Splitter:B:340:0x0ddf} */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0de4 A:{SYNTHETIC, Splitter:B:343:0x0de4} */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0ec5 A:{SYNTHETIC, Splitter:B:363:0x0ec5} */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0eca A:{SYNTHETIC, Splitter:B:366:0x0eca} */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0f93  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0fb9 A:{SYNTHETIC, Splitter:B:386:0x0fb9} */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0fbe A:{SYNTHETIC, Splitter:B:389:0x0fbe} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03be A:{SYNTHETIC, Splitter:B:61:0x03be} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03c3 A:{SYNTHETIC, Splitter:B:64:0x03c3} */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0928  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x094e A:{SYNTHETIC, Splitter:B:223:0x094e} */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0953 A:{SYNTHETIC, Splitter:B:226:0x0953} */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0a84 A:{SYNTHETIC, Splitter:B:255:0x0a84} */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bd A:{Catch:{ all -> 0x0a9f }} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0a69 A:{SYNTHETIC, Splitter:B:249:0x0a69} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0a6e A:{SYNTHETIC, Splitter:B:252:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0bed  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0c13 A:{SYNTHETIC, Splitter:B:294:0x0c13} */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0c18 A:{SYNTHETIC, Splitter:B:297:0x0c18} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0cf9 A:{SYNTHETIC, Splitter:B:317:0x0cf9} */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0cfe A:{SYNTHETIC, Splitter:B:320:0x0cfe} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0db9  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0ddf A:{SYNTHETIC, Splitter:B:340:0x0ddf} */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0de4 A:{SYNTHETIC, Splitter:B:343:0x0de4} */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0ec5 A:{SYNTHETIC, Splitter:B:363:0x0ec5} */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0eca A:{SYNTHETIC, Splitter:B:366:0x0eca} */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0f93  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0fb9 A:{SYNTHETIC, Splitter:B:386:0x0fb9} */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0fbe A:{SYNTHETIC, Splitter:B:389:0x0fbe} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0305 A:{SYNTHETIC, Splitter:B:44:0x0305} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x030a A:{SYNTHETIC, Splitter:B:47:0x030a} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x03be A:{SYNTHETIC, Splitter:B:61:0x03be} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x03c3 A:{SYNTHETIC, Splitter:B:64:0x03c3} */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0928  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x094e A:{SYNTHETIC, Splitter:B:223:0x094e} */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0953 A:{SYNTHETIC, Splitter:B:226:0x0953} */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x09bd A:{Catch:{ all -> 0x0a9f }} */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0a84 A:{SYNTHETIC, Splitter:B:255:0x0a84} */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0a43  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x0a69 A:{SYNTHETIC, Splitter:B:249:0x0a69} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0a6e A:{SYNTHETIC, Splitter:B:252:0x0a6e} */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0bed  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0c13 A:{SYNTHETIC, Splitter:B:294:0x0c13} */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0c18 A:{SYNTHETIC, Splitter:B:297:0x0c18} */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0cf9 A:{SYNTHETIC, Splitter:B:317:0x0cf9} */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x0cfe A:{SYNTHETIC, Splitter:B:320:0x0cfe} */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x0db9  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0ddf A:{SYNTHETIC, Splitter:B:340:0x0ddf} */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0de4 A:{SYNTHETIC, Splitter:B:343:0x0de4} */
    /* JADX WARNING: Removed duplicated region for block: B:360:0x0e9f  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x0ec5 A:{SYNTHETIC, Splitter:B:363:0x0ec5} */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0eca A:{SYNTHETIC, Splitter:B:366:0x0eca} */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0f93  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0fb9 A:{SYNTHETIC, Splitter:B:386:0x0fb9} */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0fbe A:{SYNTHETIC, Splitter:B:389:0x0fbe} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Removed duplicated region for block: B:514:0x1191 A:{Splitter:B:78:0x0434, ExcHandler: UnsupportedEncodingException (e java.io.UnsupportedEncodingException)} */
    /* JADX WARNING: Removed duplicated region for block: B:502:0x1169 A:{Splitter:B:78:0x0434, ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:491:0x1147 A:{Splitter:B:78:0x0434, ExcHandler: FileNotFoundException (e java.io.FileNotFoundException)} */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x1125 A:{Splitter:B:78:0x0434, ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException)} */
    /* JADX WARNING: Removed duplicated region for block: B:469:0x1103 A:{Splitter:B:78:0x0434, ExcHandler: ConnectException (e java.net.ConnectException)} */
    /* JADX WARNING: Removed duplicated region for block: B:458:0x10e1 A:{Splitter:B:78:0x0434, ExcHandler: ProtocolException (e java.net.ProtocolException)} */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x10bf A:{Splitter:B:78:0x0434, ExcHandler: ArrayIndexOutOfBoundsException (e java.lang.ArrayIndexOutOfBoundsException)} */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x109d A:{Splitter:B:78:0x0434, ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x0f93  */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x0fb9 A:{SYNTHETIC, Splitter:B:386:0x0fb9} */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0fbe A:{SYNTHETIC, Splitter:B:389:0x0fbe} */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x1052 A:{Splitter:B:78:0x0434, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0ad6  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0afc A:{SYNTHETIC, Splitter:B:265:0x0afc} */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0b01 A:{SYNTHETIC, Splitter:B:268:0x0b01} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:0x02df, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:48:?, code skipped:
            r17.close();
     */
    /* JADX WARNING: Missing block: B:58:0x0398, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:65:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:146:0x06d5, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:148:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.AppBrandNetworkRequest", "read input stream failed : %s", r4.toString());
     */
    /* JADX WARNING: Missing block: B:151:0x06f4, code skipped:
            if ("gzip".equals(r18.getContentEncoding()) != false) goto L_0x06f6;
     */
    /* JADX WARNING: Missing block: B:152:0x06f6, code skipped:
            r0 = new java.util.zip.GZIPInputStream(r18.getErrorStream());
     */
    /* JADX WARNING: Missing block: B:153:0x0703, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:155:?, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "read err stream failed", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:156:0x0710, code skipped:
            r22 = null;
     */
    /* JADX WARNING: Missing block: B:158:?, code skipped:
            r22 = r18.getErrorStream();
     */
    /* JADX WARNING: Missing block: B:173:0x0763, code skipped:
            r6.flush();
            r22.close();
            r18.disconnect();
     */
    /* JADX WARNING: Missing block: B:174:0x0777, code skipped:
            if ("arraybuffer".equals(r25.ioP) == false) goto L_0x07fe;
     */
    /* JADX WARNING: Missing block: B:175:0x0779, code skipped:
            r7 = com.tencent.p177mm.plugin.appbrand.p329s.C27295q.m43335al(r6.toByteArray());
     */
    /* JADX WARNING: Missing block: B:176:0x0781, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7419v("MicroMsg.AppBrandNetworkRequest", "url %s : buffer size %d", r25.mUrl, java.lang.Integer.valueOf(r6.size()));
     */
    /* JADX WARNING: Missing block: B:177:0x079f, code skipped:
            r16 = r5;
     */
    /* JADX WARNING: Missing block: B:189:?, code skipped:
            r7 = com.tencent.p177mm.plugin.appbrand.p329s.C19721r.m30532Ei(r6.toString("UTF-8"));
     */
    /* JADX WARNING: Missing block: B:198:0x0843, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:199:0x0844, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:200:0x0852, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:201:0x0853, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:202:0x0861, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:203:0x0862, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:204:0x0870, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:205:0x0871, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:206:0x087f, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:207:0x0880, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:208:0x088e, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:209:0x088f, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:210:0x089d, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:211:0x089e, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:212:0x08ac, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:213:0x08ad, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:220:0x0928, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:224:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:227:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:229:0x0969, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:230:0x096a, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:231:0x0977, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:232:0x0978, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:233:0x0985, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:234:0x0986, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:235:0x0993, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:236:0x0994, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:242:0x09bd, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 6, 1);
     */
    /* JADX WARNING: Missing block: B:246:0x0a43, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:250:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:253:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:257:0x0a8a, code skipped:
            if (r25.ioJ <= 5000) goto L_0x0a8c;
     */
    /* JADX WARNING: Missing block: B:258:0x0a8c, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 7, 1);
     */
    /* JADX WARNING: Missing block: B:274:0x0b1c, code skipped:
            if (r25.ioJ <= com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK) goto L_0x0b1e;
     */
    /* JADX WARNING: Missing block: B:275:0x0b1e, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 8, 1);
     */
    /* JADX WARNING: Missing block: B:276:0x0b31, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 9, 1);
     */
    /* JADX WARNING: Missing block: B:277:0x0b44, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:278:0x0b45, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:279:0x0b53, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:280:0x0b54, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:281:0x0b62, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:282:0x0b63, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:283:0x0b71, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:284:0x0b72, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:291:0x0bed, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:295:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:298:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:300:0x0c2e, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:301:0x0c2f, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:302:0x0c3c, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:303:0x0c3d, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:304:0x0c4a, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:305:0x0c4b, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:306:0x0c58, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:307:0x0c59, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:314:0x0cd3, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:318:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:321:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:323:0x0d14, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:324:0x0d15, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:325:0x0d22, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:326:0x0d23, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:327:0x0d30, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:328:0x0d31, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:329:0x0d3e, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:330:0x0d3f, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:337:0x0db9, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:341:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:344:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:346:0x0dfa, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:347:0x0dfb, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:348:0x0e08, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:349:0x0e09, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:350:0x0e16, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:351:0x0e17, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:352:0x0e24, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:353:0x0e25, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:360:0x0e9f, code skipped:
            ((com.tencent.p177mm.plugin.appbrand.p326n.C2402a) com.tencent.luggage.p1170a.C37384e.m62986C(com.tencent.p177mm.plugin.appbrand.p326n.C2402a.class)).mo6307f(435, 11, 1);
     */
    /* JADX WARNING: Missing block: B:364:?, code skipped:
            r20.close();
     */
    /* JADX WARNING: Missing block: B:367:?, code skipped:
            r21.close();
     */
    /* JADX WARNING: Missing block: B:369:0x0ee0, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:370:0x0ee1, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:371:0x0eee, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:372:0x0eef, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:373:0x0efc, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:374:0x0efd, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:375:0x0f0a, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:376:0x0f0b, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", r4, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:412:0x1052, code skipped:
            r4 = th;
     */
    /* JADX WARNING: Missing block: B:413:0x1053, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:436:0x109d, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:437:0x109e, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:447:0x10bf, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:448:0x10c0, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:458:0x10e1, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:459:0x10e2, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:469:0x1103, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:470:0x1104, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:480:0x1125, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:481:0x1126, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:491:0x1147, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:492:0x1148, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:502:0x1169, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:503:0x116a, code skipped:
            r14 = r8;
     */
    /* JADX WARNING: Missing block: B:514:0x1191, code skipped:
            r4 = e;
     */
    /* JADX WARNING: Missing block: B:515:0x1192, code skipped:
            r14 = r8;
            r12 = 0;
            r17 = r21;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m54620a(C10570e c10570e) {
        DataOutputStream dataOutputStream;
        Throwable e;
        int i;
        DataOutputStream dataOutputStream2;
        C27148a c27148a;
        AppMethodBeat.m2504i(108150);
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        C27148a c27148a2 = c10570e.ioL;
        Map map = c10570e.ioM;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = c10570e.ioN;
        if (arrayList == null || C19538j.m30275c(arrayList, c10570e.mUrl)) {
            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 0, 1);
            C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "prepare to send https request taskid is %s, url is %s, method is %s.", c10570e.hvr, c10570e.mUrl, c10570e.bOr);
            try {
                httpURLConnection = (HttpURLConnection) new URL(c10570e.mUrl).openConnection();
                if (!C5046bo.isNullOrNil(c10570e.hvr)) {
                    c10570e.ioQ = httpURLConnection;
                }
                if (httpURLConnection == null) {
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 16, 1);
                    C4990ab.m7413e("MicroMsg.AppBrandNetworkRequest", "conn == null taskid=%s, url=%s", c10570e.hvr, c10570e.mUrl);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), 0, 0, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 11, 1);
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                }
                JSONObject f;
                int responseCode;
                JSONObject e2;
                InputStream inputStream2;
                Object obj;
                int i4;
                if (httpURLConnection instanceof HttpsURLConnection) {
                    if (this.ios != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.ios.getSocketFactory());
                    }
                    C4990ab.m7416i("MicroMsg.AppBrandNetworkRequest", "DomainList: ".concat(String.valueOf(arrayList)));
                    C19538j.m30269a(httpURLConnection, arrayList);
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "hy: appbrand network request timeout %d", Integer.valueOf(c10570e.ioJ));
                httpURLConnection.setConnectTimeout(c10570e.ioJ);
                httpURLConnection.setReadTimeout(c10570e.ioJ);
                httpURLConnection.setRequestProperty("charset", ProtocolPackage.ServerEncoding);
                httpURLConnection.setInstanceFollowRedirects(false);
                if (VERSION.SDK_INT > 19 || !c10570e.bOr.equalsIgnoreCase("DELETE")) {
                    httpURLConnection.setRequestMethod(c10570e.bOr);
                } else {
                    C4990ab.m7416i("MicroMsg.AppBrandNetworkRequest", "appbrand network request DELETE");
                    httpURLConnection.setRequestProperty("X-HTTP-Method-Override", "DELETE");
                    httpURLConnection.setRequestMethod("POST");
                }
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                if (map != null) {
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "url %s : set header ", c10570e.mUrl);
                    for (Entry entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "url %s : key:%s ,value %s ", c10570e.mUrl, entry.getKey(), entry.getValue());
                    }
                }
                HttpURLConnection httpURLConnection2 = httpURLConnection;
                httpURLConnection2.setRequestProperty("User-Agent", this.ibJ);
                if (C33422d.m54616CK(c10570e.bOr)) {
                    C4990ab.m7416i("MicroMsg.AppBrandNetworkRequest", "set post or put");
                    httpURLConnection.setRequestProperty("Content-Length", Integer.toString(c10570e.ioK.length));
                    httpURLConnection.setDoOutput(true);
                    f = C19538j.m30280f(httpURLConnection);
                    DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        dataOutputStream3.write(c10570e.ioK);
                        dataOutputStream3.flush();
                        dataOutputStream3.close();
                        dataOutputStream = dataOutputStream3;
                    } catch (UnsupportedEncodingException e3) {
                        e = e3;
                        i = 0;
                        dataOutputStream2 = dataOutputStream3;
                        try {
                            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 1, 1);
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "UnsupportedEncodingException: url %s", c10570e.mUrl);
                            c27148a = c27148a2;
                            m54618a(c27148a, "UTF-8 decode error", c10570e.hvr, httpURLConnection);
                            ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i, i3, 2, c10570e.aID());
                            if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                            }
                            C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                            if (inputStream != null) {
                            }
                            if (dataOutputStream2 != null) {
                            }
                            this.iot.remove(c10570e.hvr);
                            AppMethodBeat.m2505o(108150);
                            return;
                        } catch (Throwable th) {
                            e = th;
                            i2 = i;
                            dataOutputStream = dataOutputStream2;
                            ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                            if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 11, 1);
                            }
                            C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e4, "", new Object[0]);
                                } catch (ArrayIndexOutOfBoundsException e5) {
                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e5, "", new Object[0]);
                                } catch (Throwable th2) {
                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", th2, "", new Object[0]);
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e42) {
                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e42, "", new Object[0]);
                                }
                            }
                            this.iot.remove(c10570e.hvr);
                            AppMethodBeat.m2505o(108150);
                            throw e;
                        }
                    } catch (SSLHandshakeException e6) {
                        e = e6;
                        dataOutputStream = dataOutputStream3;
                        try {
                            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 2, 1);
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "SSLHandshakeException: url %s", c10570e.mUrl);
                            c27148a = c27148a2;
                            m54618a(c27148a, "ssl hand shake error", c10570e.hvr, httpURLConnection);
                            ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                            if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                            }
                            C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                            if (inputStream != null) {
                            }
                            if (dataOutputStream != null) {
                            }
                            this.iot.remove(c10570e.hvr);
                            AppMethodBeat.m2505o(108150);
                            return;
                        } catch (Throwable th3) {
                            e = th3;
                            ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                            if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                            }
                            C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                            if (inputStream != null) {
                            }
                            if (dataOutputStream != null) {
                            }
                            this.iot.remove(c10570e.hvr);
                            AppMethodBeat.m2505o(108150);
                            throw e;
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 3, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "FileNotFoundException: url %s", c10570e.mUrl);
                        c27148a = c27148a2;
                        m54618a(c27148a, "file not exist error", c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (SocketTimeoutException e8) {
                        e = e8;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 4, 1);
                        if (c10570e.ioJ <= 1000) {
                        }
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "SocketTimeoutException: url is %s, Timeout: %s", c10570e.mUrl, Integer.valueOf(c10570e.ioJ));
                        m54618a(c27148a2, "socket time out timeout:" + c10570e.ioJ, c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (ConnectException e9) {
                        e = e9;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 10, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "ConnectException: url %s", c10570e.mUrl);
                        c27148a = c27148a2;
                        m54618a(c27148a, "request connect error", c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (ProtocolException e10) {
                        e = e10;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 12, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "ProtocolException: url %s", c10570e.mUrl);
                        c27148a = c27148a2;
                        m54618a(c27148a, "request protocol error", c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (ArrayIndexOutOfBoundsException e11) {
                        e = e11;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 13, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "ArrayIndexOutOfBoundsException: url %s", c10570e.mUrl);
                        c27148a = c27148a2;
                        m54618a(c27148a, "request index out of error", c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (UnknownHostException e12) {
                        e = e12;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 14, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "UnknownHostException: url %s", c10570e.mUrl);
                        c27148a = c27148a2;
                        m54618a(c27148a, "request unknow host error", c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (Exception e13) {
                        e = e13;
                        dataOutputStream = dataOutputStream3;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "Exception: url %s", c10570e.mUrl);
                        m54618a(c27148a2, e.getMessage(), c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (Throwable th4) {
                        e = th4;
                        dataOutputStream = dataOutputStream3;
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        throw e;
                    }
                }
                f = C19538j.m30280f(httpURLConnection);
                dataOutputStream = null;
                try {
                    c27148a2.mo44823p(f);
                    try {
                        responseCode = httpURLConnection.getResponseCode();
                    } catch (IOException e14) {
                        responseCode = httpURLConnection.getResponseCode();
                    }
                    try {
                        int i5;
                        e2 = C19538j.m30278e(httpURLConnection);
                        c27148a2.mo44823p(e2);
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "responseCode = %d, url = %s", Integer.valueOf(responseCode), c10570e.mUrl);
                        if (responseCode != 200) {
                            C4990ab.m7413e("MicroMsg.AppBrandNetworkRequest", "url is %s, failed code: %d", c10570e.mUrl, Integer.valueOf(responseCode));
                            if (C19538j.m30284po(responseCode)) {
                                String c = C19538j.m30274c(httpURLConnection);
                                i5 = c10570e.ioO;
                                if (!TextUtils.isEmpty(c)) {
                                    if (i5 <= 0) {
                                        C4990ab.m7421w("MicroMsg.AppBrandNetworkRequest", "reach the max redirect count(%d)", Integer.valueOf(15));
                                        m54617a(c27148a2, "ok", "reach the max redirect count 15", responseCode, e2, c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), 0, responseCode, 1, c10570e.aID());
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (IOException e15) {
                                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e15, "", new Object[0]);
                                            }
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    }
                                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "redirect(%d) URL(%s) to URL(%s)", Integer.valueOf(i5), c10570e.mUrl, c);
                                    c10570e.mUrl = c;
                                    c10570e.ioO = i5 - 1;
                                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "now redirect count = %d", Integer.valueOf(c10570e.ioO));
                                    m54620a(c10570e);
                                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), 0, responseCode, 2, c10570e.aID());
                                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 11, 1);
                                    }
                                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (IOException e152) {
                                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e152, "", new Object[0]);
                                        }
                                    }
                                    this.iot.remove(c10570e.hvr);
                                    AppMethodBeat.m2505o(108150);
                                    return;
                                }
                            }
                            ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 15, 1);
                        }
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        if ("gzip".equals(httpURLConnection.getContentEncoding())) {
                            InputStream gZIPInputStream = new GZIPInputStream(httpURLConnection.getInputStream());
                        } else {
                            inputStream2 = httpURLConnection.getInputStream();
                        }
                        obj = null;
                        if (inputStream2 != null) {
                            try {
                                long contentLengthLong;
                                if (VERSION.SDK_INT >= 24) {
                                    contentLengthLong = httpURLConnection.getContentLengthLong();
                                } else {
                                    contentLengthLong = (long) httpURLConnection.getContentLength();
                                }
                                C4990ab.m7411d("MicroMsg.AppBrandNetworkRequest", "hy: total length is: %d", Long.valueOf(contentLengthLong));
                                byte[] bArr = new byte[C19538j.m30281g(contentLengthLong, 1)];
                                i5 = 0;
                                while (true) {
                                    try {
                                        int read = inputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else if (C19538j.m30285y(this.hvw)) {
                                            c27148a = c27148a2;
                                            m54618a(c27148a, "interrupted", c10570e.hvr, httpURLConnection);
                                            inputStream2.close();
                                            ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i5, responseCode, 2, c10570e.aID());
                                            if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 11, 1);
                                            }
                                            C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (IOException e1522) {
                                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1522, "", new Object[0]);
                                                } catch (ArrayIndexOutOfBoundsException e16) {
                                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e16, "", new Object[0]);
                                                } catch (Throwable e17) {
                                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "", new Object[0]);
                                                }
                                            }
                                            if (dataOutputStream != null) {
                                                try {
                                                    dataOutputStream.close();
                                                } catch (IOException e15222) {
                                                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e15222, "", new Object[0]);
                                                }
                                            }
                                            this.iot.remove(c10570e.hvr);
                                            AppMethodBeat.m2505o(108150);
                                            return;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, read);
                                            i5 += read;
                                        }
                                    } catch (UnsupportedEncodingException e18) {
                                        e17 = e18;
                                        i3 = responseCode;
                                        i = i5;
                                        dataOutputStream2 = dataOutputStream;
                                        inputStream = inputStream2;
                                    } catch (SSLHandshakeException e19) {
                                        e17 = e19;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 2, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "SSLHandshakeException: url %s", c10570e.mUrl);
                                        c27148a = c27148a2;
                                        m54618a(c27148a, "ssl hand shake error", c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (FileNotFoundException e20) {
                                        e17 = e20;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 3, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "FileNotFoundException: url %s", c10570e.mUrl);
                                        c27148a = c27148a2;
                                        m54618a(c27148a, "file not exist error", c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (SocketTimeoutException e21) {
                                        e17 = e21;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 4, 1);
                                        if (c10570e.ioJ <= 1000) {
                                        }
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "SocketTimeoutException: url is %s, Timeout: %s", c10570e.mUrl, Integer.valueOf(c10570e.ioJ));
                                        m54618a(c27148a2, "socket time out timeout:" + c10570e.ioJ, c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (ConnectException e22) {
                                        e17 = e22;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 10, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ConnectException: url %s", c10570e.mUrl);
                                        c27148a = c27148a2;
                                        m54618a(c27148a, "request connect error", c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (ProtocolException e23) {
                                        e17 = e23;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 12, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ProtocolException: url %s", c10570e.mUrl);
                                        c27148a = c27148a2;
                                        m54618a(c27148a, "request protocol error", c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (ArrayIndexOutOfBoundsException e24) {
                                        e17 = e24;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 13, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ArrayIndexOutOfBoundsException: url %s", c10570e.mUrl);
                                        c27148a = c27148a2;
                                        m54618a(c27148a, "request index out of error", c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (UnknownHostException e25) {
                                        e17 = e25;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 14, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "UnknownHostException: url %s", c10570e.mUrl);
                                        c27148a = c27148a2;
                                        m54618a(c27148a, "request unknow host error", c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (Exception e26) {
                                        e17 = e26;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "Exception: url %s", c10570e.mUrl);
                                        m54618a(c27148a2, e17.getMessage(), c10570e.hvr, httpURLConnection);
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        return;
                                    } catch (Throwable th5) {
                                        e17 = th5;
                                        i3 = responseCode;
                                        i2 = i5;
                                        inputStream = inputStream2;
                                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                        }
                                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream != null) {
                                        }
                                        this.iot.remove(c10570e.hvr);
                                        AppMethodBeat.m2505o(108150);
                                        throw e17;
                                    }
                                }
                            } catch (UnsupportedEncodingException e27) {
                                e17 = e27;
                                i3 = responseCode;
                                i = 0;
                                dataOutputStream2 = dataOutputStream;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 1, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "UnsupportedEncodingException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "UTF-8 decode error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream2 != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (SSLHandshakeException e28) {
                                e17 = e28;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 2, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "SSLHandshakeException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "ssl hand shake error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (FileNotFoundException e29) {
                                e17 = e29;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 3, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "FileNotFoundException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "file not exist error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (SocketTimeoutException e30) {
                                e17 = e30;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 4, 1);
                                if (c10570e.ioJ <= 1000) {
                                }
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "SocketTimeoutException: url is %s, Timeout: %s", c10570e.mUrl, Integer.valueOf(c10570e.ioJ));
                                m54618a(c27148a2, "socket time out timeout:" + c10570e.ioJ, c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (ConnectException e31) {
                                e17 = e31;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 10, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ConnectException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "request connect error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (ProtocolException e32) {
                                e17 = e32;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 12, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ProtocolException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "request protocol error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (ArrayIndexOutOfBoundsException e33) {
                                e17 = e33;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 13, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ArrayIndexOutOfBoundsException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "request index out of error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (UnknownHostException e34) {
                                e17 = e34;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 14, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "UnknownHostException: url %s", c10570e.mUrl);
                                c27148a = c27148a2;
                                m54618a(c27148a, "request unknow host error", c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (Exception e35) {
                                e17 = e35;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "Exception: url %s", c10570e.mUrl);
                                m54618a(c27148a2, e17.getMessage(), c10570e.hvr, httpURLConnection);
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                return;
                            } catch (Throwable th6) {
                                e17 = th6;
                                i3 = responseCode;
                                inputStream = inputStream2;
                                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                                }
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                                if (inputStream != null) {
                                }
                                if (dataOutputStream != null) {
                                }
                                this.iot.remove(c10570e.hvr);
                                AppMethodBeat.m2505o(108150);
                                throw e17;
                            }
                        }
                        i4 = 0;
                    } catch (UnsupportedEncodingException e36) {
                    } catch (SSLHandshakeException e37) {
                    } catch (FileNotFoundException e38) {
                    } catch (SocketTimeoutException e39) {
                    } catch (ConnectException e40) {
                    } catch (ProtocolException e41) {
                    } catch (ArrayIndexOutOfBoundsException e43) {
                    } catch (UnknownHostException e44) {
                    } catch (Exception e45) {
                        e17 = e45;
                        i3 = responseCode;
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                        C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "Exception: url %s", c10570e.mUrl);
                        m54618a(c27148a2, e17.getMessage(), c10570e.hvr, httpURLConnection);
                        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                        if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        }
                        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                        if (inputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        this.iot.remove(c10570e.hvr);
                        AppMethodBeat.m2505o(108150);
                        return;
                    } catch (Throwable th7) {
                    }
                } catch (UnsupportedEncodingException e46) {
                    e17 = e46;
                    i = 0;
                    dataOutputStream2 = dataOutputStream;
                } catch (SSLHandshakeException e47) {
                    e17 = e47;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 2, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "SSLHandshakeException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "ssl hand shake error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (FileNotFoundException e48) {
                    e17 = e48;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 3, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "FileNotFoundException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "file not exist error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (SocketTimeoutException e49) {
                    e17 = e49;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 4, 1);
                    if (c10570e.ioJ <= 1000) {
                    }
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "SocketTimeoutException: url is %s, Timeout: %s", c10570e.mUrl, Integer.valueOf(c10570e.ioJ));
                    m54618a(c27148a2, "socket time out timeout:" + c10570e.ioJ, c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (ConnectException e50) {
                    e17 = e50;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 10, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ConnectException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request connect error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (ProtocolException e51) {
                    e17 = e51;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 12, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ProtocolException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request protocol error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (ArrayIndexOutOfBoundsException e52) {
                    e17 = e52;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 13, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "ArrayIndexOutOfBoundsException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request index out of error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (UnknownHostException e53) {
                    e17 = e53;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 14, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "UnknownHostException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request unknow host error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (Exception e54) {
                    e17 = e54;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e17, "Exception: url %s", c10570e.mUrl);
                    m54618a(c27148a2, e17.getMessage(), c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                        ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 11, 1);
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e152222) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e152222, "", new Object[0]);
                        } catch (ArrayIndexOutOfBoundsException e162) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e162, "", new Object[0]);
                        } catch (Throwable e172) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e172, "", new Object[0]);
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e1522222) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1522222, "", new Object[0]);
                        }
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                }
                try {
                    m54617a(c27148a2, "ok", obj, responseCode, e2, c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i4, responseCode, 1, c10570e.aID());
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e15222222) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e15222222, "", new Object[0]);
                        } catch (ArrayIndexOutOfBoundsException e1622) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1622, "", new Object[0]);
                        } catch (Throwable e1722) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "", new Object[0]);
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e152222222) {
                            C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e152222222, "", new Object[0]);
                        }
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (UnsupportedEncodingException e55) {
                    e1722 = e55;
                    i3 = responseCode;
                    i = i4;
                    dataOutputStream2 = dataOutputStream;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 1, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "UnsupportedEncodingException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "UTF-8 decode error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream2 != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (SSLHandshakeException e56) {
                    e1722 = e56;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 2, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "SSLHandshakeException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "ssl hand shake error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (FileNotFoundException e57) {
                    e1722 = e57;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 3, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "FileNotFoundException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "file not exist error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (SocketTimeoutException e58) {
                    e1722 = e58;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 4, 1);
                    if (c10570e.ioJ <= 1000) {
                    }
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "SocketTimeoutException: url is %s, Timeout: %s", c10570e.mUrl, Integer.valueOf(c10570e.ioJ));
                    m54618a(c27148a2, "socket time out timeout:" + c10570e.ioJ, c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (ConnectException e59) {
                    e1722 = e59;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 10, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "ConnectException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request connect error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (ProtocolException e60) {
                    e1722 = e60;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 12, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "ProtocolException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request protocol error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (ArrayIndexOutOfBoundsException e61) {
                    e1722 = e61;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 13, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "ArrayIndexOutOfBoundsException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request index out of error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (UnknownHostException e62) {
                    e1722 = e62;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 14, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "UnknownHostException: url %s", c10570e.mUrl);
                    c27148a = c27148a2;
                    m54618a(c27148a, "request unknow host error", c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (Exception e63) {
                    e1722 = e63;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "Exception: url %s", c10570e.mUrl);
                    m54618a(c27148a2, e1722.getMessage(), c10570e.hvr, httpURLConnection);
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    return;
                } catch (Throwable th8) {
                    e1722 = th8;
                    i3 = responseCode;
                    i2 = i4;
                    inputStream = inputStream2;
                    ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                    if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                    }
                    C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                    if (inputStream != null) {
                    }
                    if (dataOutputStream != null) {
                    }
                    this.iot.remove(c10570e.hvr);
                    AppMethodBeat.m2505o(108150);
                    throw e1722;
                }
            } catch (UnsupportedEncodingException e64) {
                e1722 = e64;
                i = 0;
                dataOutputStream2 = null;
            } catch (SSLHandshakeException e65) {
                e1722 = e65;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 2, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "SSLHandshakeException: url %s", c10570e.mUrl);
                c27148a = c27148a2;
                m54618a(c27148a, "ssl hand shake error", c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (FileNotFoundException e66) {
                e1722 = e66;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 3, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "FileNotFoundException: url %s", c10570e.mUrl);
                c27148a = c27148a2;
                m54618a(c27148a, "file not exist error", c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (SocketTimeoutException e67) {
                e1722 = e67;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 4, 1);
                if (c10570e.ioJ <= 1000) {
                }
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "SocketTimeoutException: url is %s, Timeout: %s", c10570e.mUrl, Integer.valueOf(c10570e.ioJ));
                m54618a(c27148a2, "socket time out timeout:" + c10570e.ioJ, c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (ConnectException e68) {
                e1722 = e68;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 10, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "ConnectException: url %s", c10570e.mUrl);
                c27148a = c27148a2;
                m54618a(c27148a, "request connect error", c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (ProtocolException e69) {
                e1722 = e69;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 12, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "ProtocolException: url %s", c10570e.mUrl);
                c27148a = c27148a2;
                m54618a(c27148a, "request protocol error", c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (ArrayIndexOutOfBoundsException e70) {
                e1722 = e70;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 13, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "ArrayIndexOutOfBoundsException: url %s", c10570e.mUrl);
                c27148a = c27148a2;
                m54618a(c27148a, "request index out of error", c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (UnknownHostException e71) {
                e1722 = e71;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 14, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "UnknownHostException: url %s", c10570e.mUrl);
                c27148a = c27148a2;
                m54618a(c27148a, "request unknow host error", c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (Exception e72) {
                e1722 = e72;
                dataOutputStream = null;
                ((C2402a) C37384e.m62986C(C2402a.class)).mo6307f(435, 5, 1);
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e1722, "Exception: url %s", c10570e.mUrl);
                m54618a(c27148a2, e1722.getMessage(), c10570e.hvr, httpURLConnection);
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(r4));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                return;
            } catch (Throwable th9) {
                e1722 = th9;
                dataOutputStream = null;
                ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, c10570e.getDataSize(), (long) i2, i3, 2, c10570e.aID());
                if (C5023at.getNetType(C4996ah.getContext()) == -1) {
                }
                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "send https request fail ret:%d", Integer.valueOf(i));
                if (inputStream != null) {
                }
                if (dataOutputStream != null) {
                }
                this.iot.remove(c10570e.hvr);
                AppMethodBeat.m2505o(108150);
                throw e1722;
            }
        }
        c27148a = c27148a2;
        m54618a(c27148a, "url not in domain list", c10570e.hvr, null);
        ((C42602o) C37384e.m62986C(C42602o.class)).mo68037a(this.hvw.getAppId(), c10570e.ioR, c10570e.bOr, c10570e.mUrl, 0, 0, 0, 2, c10570e.aID());
        C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "not in domain url %s", c10570e.mUrl);
        AppMethodBeat.m2505o(108150);
    }

    /* renamed from: a */
    private void m54618a(C27148a c27148a, String str, String str2, HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(138236);
        m54621a(str2, httpURLConnection);
        c27148a.mo44821BA(str);
        AppMethodBeat.m2505o(138236);
    }

    /* renamed from: a */
    private void m54617a(C27148a c27148a, String str, Object obj, int i, JSONObject jSONObject, String str2, HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(138237);
        m54621a(str2, httpURLConnection);
        c27148a.mo44822a(str, obj, i, jSONObject);
        AppMethodBeat.m2505o(138237);
    }

    /* renamed from: b */
    public final void mo53910b(C10570e c10570e) {
        AppMethodBeat.m2504i(108151);
        C4990ab.m7410d("MicroMsg.AppBrandNetworkRequest", "try to abortTask");
        this.iot.add(c10570e.hvr);
        m54621a(c10570e.hvr, c10570e.ioQ);
        AppMethodBeat.m2505o(108151);
    }

    /* renamed from: CH */
    public final boolean mo53907CH(String str) {
        AppMethodBeat.m2504i(108152);
        boolean contains = this.iot.contains(str);
        AppMethodBeat.m2505o(108152);
        return contains;
    }

    /* renamed from: a */
    private void m54621a(String str, HttpURLConnection httpURLConnection) {
        AppMethodBeat.m2504i(108153);
        m54622kP(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                AppMethodBeat.m2505o(108153);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandNetworkRequest", e, "removeTask Exception: id %s", str);
            }
        }
        AppMethodBeat.m2505o(108153);
    }

    /* renamed from: CK */
    static boolean m54616CK(String str) {
        AppMethodBeat.m2504i(108154);
        if (str.equalsIgnoreCase("POST") || str.equalsIgnoreCase("PUT") || str.equalsIgnoreCase("DELETE")) {
            AppMethodBeat.m2505o(108154);
            return true;
        }
        AppMethodBeat.m2505o(108154);
        return false;
    }

    /* renamed from: a */
    public final void mo53909a(C2241c c2241c, int i, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, C27148a c27148a, String str, String str2) {
        AppMethodBeat.m2504i(108155);
        final C2241c c2241c2 = c2241c;
        final JSONObject jSONObject2 = jSONObject;
        final C27148a c27148a2 = c27148a;
        final String str3 = str;
        final int i2 = i;
        final Map<String, String> map2 = map;
        final ArrayList<String> arrayList2 = arrayList;
        final String str4 = str2;
        C7305d.post(new Runnable() {
            /* JADX WARNING: Missing block: B:33:0x00ef, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "request taskId %s, method %s ,url %s timeout %s", r5, r5, r1, java.lang.Integer.valueOf(r6));
            r0 = new com.tencent.p177mm.plugin.appbrand.p321l.C10570e(r1, r2, r6, r4, r5);
            r0.ioM = r7;
            r0.ioN = r8;
            r0.ioR = r9;
            r0.ioP = r3.optString("responseType", "text");
            r1 = r11.ioI.ioA;
     */
            /* JADX WARNING: Missing block: B:34:0x0133, code skipped:
            monitor-enter(r1);
     */
            /* JADX WARNING: Missing block: B:36:?, code skipped:
            r11.ioI.ioA.add(r0);
     */
            /* JADX WARNING: Missing block: B:37:0x013b, code skipped:
            monitor-exit(r1);
     */
            /* JADX WARNING: Missing block: B:38:0x013c, code skipped:
            r0.hvr = r5;
            com.tencent.p177mm.plugin.appbrand.p321l.C33422d.m54619a(r11.ioI, r0);
     */
            /* JADX WARNING: Missing block: B:46:0x0152, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(108148);
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(108148);
                if (C27295q.m43334a(c2241c2.aBx(), jSONObject2, (C27296a) c2241c2.mo5937aa(C27296a.class)) == C10730b.FAIL_SIZE_EXCEED_LIMIT) {
                    c27148a2.mo44821BA("convert native buffer parameter fail. native buffer exceed size limit.");
                    AppMethodBeat.m2505o(108148);
                    return;
                }
                String CS = C19538j.m30261CS(jSONObject2.optString("url"));
                Object opt = jSONObject2.opt("data");
                String optString = jSONObject2.optString(C8741b.METHOD);
                if (C5046bo.isNullOrNil(optString)) {
                    optString = "GET";
                }
                if (TextUtils.isEmpty(CS)) {
                    c27148a2.mo44821BA("url is null");
                    AppMethodBeat.m2505o(108148);
                } else if (URLUtil.isHttpsUrl(CS) || URLUtil.isHttpUrl(CS)) {
                    byte[] bArr = new byte[0];
                    if (opt != null && C33422d.m54616CK(optString)) {
                        if (opt instanceof String) {
                            bArr = ((String) opt).getBytes(Charset.forName("UTF-8"));
                        } else if (opt instanceof ByteBuffer) {
                            bArr = C45672d.m84374q((ByteBuffer) opt);
                        }
                    }
                    synchronized (C33422d.this.ioA) {
                        try {
                            if (C33422d.this.ioA.size() >= C33422d.this.ioB) {
                                c27148a2.mo44821BA("max connected");
                                C4990ab.m7417i("MicroMsg.AppBrandNetworkRequest", "max connected mRequestTaskList.size():%d,mMaxRequestConcurrent:%d", Integer.valueOf(C33422d.this.ioA.size()), Integer.valueOf(C33422d.this.ioB));
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(108148);
                        }
                    }
                } else {
                    c27148a2.mo44821BA("request protocol must be http or https");
                    AppMethodBeat.m2505o(108148);
                }
            }
        }, "appbrand_request_thread");
        AppMethodBeat.m2505o(108155);
    }

    /* renamed from: kP */
    private synchronized void m54622kP(String str) {
        AppMethodBeat.m2504i(108156);
        if (str == null) {
            AppMethodBeat.m2505o(108156);
        } else {
            int hasNext;
            synchronized (this.ioA) {
                try {
                    Iterator it = this.ioA.iterator();
                    while (true) {
                        hasNext = it.hasNext();
                        if (hasNext == 0) {
                            break;
                        }
                        hasNext = (C10570e) it.next();
                        if (str.equals(hasNext.hvr)) {
                            this.ioA.remove(hasNext);
                            break;
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(108156);
                }
            }
            AppMethodBeat.m2505o(hasNext);
        }
    }

    /* renamed from: CL */
    public final C10570e mo53908CL(String str) {
        C10570e c10570e;
        AppMethodBeat.m2504i(108157);
        if (str == null) {
            AppMethodBeat.m2505o(108157);
            return null;
        }
        synchronized (this.ioA) {
            try {
                Iterator it = this.ioA.iterator();
                while (it.hasNext()) {
                    c10570e = (C10570e) it.next();
                    if (str.equals(c10570e.hvr)) {
                    }
                }
                AppMethodBeat.m2505o(108157);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(108157);
            }
        }
        return c10570e;
    }
}
