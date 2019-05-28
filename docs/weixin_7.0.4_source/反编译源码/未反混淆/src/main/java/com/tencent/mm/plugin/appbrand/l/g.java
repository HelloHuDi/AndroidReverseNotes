package com.tencent.mm.plugin.appbrand.l;

import android.webkit.URLUtil;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

public final class g {
    c hvw;
    final String ibJ;
    private int ioT;
    public final ArrayList<h> ioU = new ArrayList();
    SSLContext ios;
    protected final ArrayList<String> iot = new ArrayList();

    public interface a {
        void BC(String str);

        void g(int i, String str, int i2);

        void h(int i, long j, long j2);

        void p(JSONObject jSONObject);
    }

    public class b implements Runnable {
        private h ioV;

        public b(h hVar) {
            this.ioV = hVar;
        }

        public final void run() {
            AppMethodBeat.i(108167);
            b(this.ioV);
            AppMethodBeat.o(108167);
        }

        private static String bZ(String str, String str2) {
            AppMethodBeat.i(108168);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(108168);
                return str2;
            }
            AppMethodBeat.o(108168);
            return str;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:314:0x0df1=Splitter:B:314:0x0df1, B:89:0x04f2=Splitter:B:89:0x04f2, B:286:0x0ccd=Splitter:B:286:0x0ccd, B:63:0x037f=Splitter:B:63:0x037f} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:367:0x1005 A:{Splitter:B:16:0x0187, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:456:0x114e A:{Splitter:B:152:0x07bd, ExcHandler: UnsupportedEncodingException (r3_165 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:440:0x1104 A:{Splitter:B:152:0x07bd, ExcHandler: FileNotFoundException (r3_164 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:424:0x10c7 A:{Splitter:B:152:0x07bd, ExcHandler: SSLHandshakeException (r3_163 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:408:0x108a A:{Splitter:B:152:0x07bd, ExcHandler: SocketTimeoutException (r3_162 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:374:0x1018 A:{Splitter:B:152:0x07bd, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:456:0x114e A:{Splitter:B:152:0x07bd, ExcHandler: UnsupportedEncodingException (r3_165 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:440:0x1104 A:{Splitter:B:152:0x07bd, ExcHandler: FileNotFoundException (r3_164 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:424:0x10c7 A:{Splitter:B:152:0x07bd, ExcHandler: SSLHandshakeException (r3_163 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:408:0x108a A:{Splitter:B:152:0x07bd, ExcHandler: SocketTimeoutException (r3_162 'e' java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:374:0x1018 A:{Splitter:B:152:0x07bd, ExcHandler: all (th java.lang.Throwable)} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x031b  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0346 A:{SYNTHETIC, Splitter:B:49:0x0346} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x034b A:{SYNTHETIC, Splitter:B:52:0x034b} */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0350 A:{SYNTHETIC, Splitter:B:55:0x0350} */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03ea  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0415 A:{SYNTHETIC, Splitter:B:70:0x0415} */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x041a A:{SYNTHETIC, Splitter:B:73:0x041a} */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x041f A:{SYNTHETIC, Splitter:B:76:0x041f} */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x055d  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0588 A:{SYNTHETIC, Splitter:B:96:0x0588} */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x058d A:{SYNTHETIC, Splitter:B:99:0x058d} */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x0592 A:{SYNTHETIC, Splitter:B:102:0x0592} */
        /* JADX WARNING: Removed duplicated region for block: B:290:0x0d38  */
        /* JADX WARNING: Removed duplicated region for block: B:293:0x0d63 A:{SYNTHETIC, Splitter:B:293:0x0d63} */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x0d68 A:{SYNTHETIC, Splitter:B:296:0x0d68} */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x0d6d A:{SYNTHETIC, Splitter:B:299:0x0d6d} */
        /* JADX WARNING: Removed duplicated region for block: B:318:0x0e6a  */
        /* JADX WARNING: Removed duplicated region for block: B:321:0x0e95 A:{SYNTHETIC, Splitter:B:321:0x0e95} */
        /* JADX WARNING: Removed duplicated region for block: B:324:0x0e9a A:{SYNTHETIC, Splitter:B:324:0x0e9a} */
        /* JADX WARNING: Removed duplicated region for block: B:327:0x0e9f A:{SYNTHETIC, Splitter:B:327:0x0e9f} */
        /* JADX WARNING: Removed duplicated region for block: B:344:0x0f55  */
        /* JADX WARNING: Removed duplicated region for block: B:347:0x0f80 A:{SYNTHETIC, Splitter:B:347:0x0f80} */
        /* JADX WARNING: Removed duplicated region for block: B:350:0x0f85 A:{SYNTHETIC, Splitter:B:350:0x0f85} */
        /* JADX WARNING: Removed duplicated region for block: B:353:0x0f8a A:{SYNTHETIC, Splitter:B:353:0x0f8a} */
        /* JADX WARNING: Removed duplicated region for block: B:232:0x0a88 A:{SYNTHETIC, Splitter:B:232:0x0a88} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:151:?, code skipped:
            r0.write(r14);
            r0.flush();
            r14 = r16.getResponseCode();
     */
        /* JADX WARNING: Missing block: B:153:?, code skipped:
            r2.p(com.tencent.mm.plugin.appbrand.l.j.e(r16));
     */
        /* JADX WARNING: Missing block: B:154:0x07c6, code skipped:
            if (200 == r14) goto L_0x0965;
     */
        /* JADX WARNING: Missing block: B:155:0x07c8, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrandNetworkUpload", "code %d  url is %s filepath %s ", java.lang.Integer.valueOf(r14), r30, r31);
     */
        /* JADX WARNING: Missing block: B:156:0x07e5, code skipped:
            if (com.tencent.mm.plugin.appbrand.l.j.po(r14) == false) goto L_0x0965;
     */
        /* JADX WARNING: Missing block: B:157:0x07e7, code skipped:
            r3 = com.tencent.mm.plugin.appbrand.l.j.c(r16);
            r4 = r36.ioO;
     */
        /* JADX WARNING: Missing block: B:158:0x07f3, code skipped:
            if (android.text.TextUtils.isEmpty(r3) != false) goto L_0x0965;
     */
        /* JADX WARNING: Missing block: B:159:0x07f5, code skipped:
            if (r4 > 0) goto L_0x0894;
     */
        /* JADX WARNING: Missing block: B:160:0x07f7, code skipped:
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.AppBrandNetworkUpload", "reach the max redirect count(%d)", java.lang.Integer.valueOf(15));
            com.tencent.mm.plugin.appbrand.l.g.a(r35.ioW, r2, 0, "reach the max redirect count 15", r14, r36.hvr, r16);
     */
        /* JADX WARNING: Missing block: B:161:0x081c, code skipped:
            ((com.tencent.mm.plugin.appbrand.l.o) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.l.o.class)).a(r35.ioW.hvw.getAppId(), r36.ioR, "POST", r36.mUrl, r8, 0, r14, 1, r36.aID());
            r36.isRunning = false;
     */
        /* JADX WARNING: Missing block: B:163:?, code skipped:
            r0.close();
     */
        /* JADX WARNING: Missing block: B:167:0x086c, code skipped:
            r2 = move-exception;
     */
        /* JADX WARNING: Missing block: B:168:0x086d, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r2, "Exception: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:172:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkUpload", "redirect(%d) URL(%s) to URL(%s)", java.lang.Integer.valueOf(r4), r36.mUrl, r3);
            r36.mUrl = r3;
            r36.ioO = r4 - 1;
            b(r36);
     */
        /* JADX WARNING: Missing block: B:173:0x08be, code skipped:
            ((com.tencent.mm.plugin.appbrand.l.o) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.l.o.class)).a(r35.ioW.hvw.getAppId(), r36.ioR, "POST", r36.mUrl, r8, 0, r14, 2, r36.aID());
     */
        /* JADX WARNING: Missing block: B:174:0x08f7, code skipped:
            if (com.tencent.mm.sdk.platformtools.at.getNetType(com.tencent.mm.sdk.platformtools.ah.getContext()) != -1) goto L_0x090a;
     */
        /* JADX WARNING: Missing block: B:175:0x08f9, code skipped:
            ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
     */
        /* JADX WARNING: Missing block: B:176:0x090a, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", java.lang.Integer.valueOf(r2));
            r36.isRunning = false;
     */
        /* JADX WARNING: Missing block: B:178:?, code skipped:
            r0.close();
     */
        /* JADX WARNING: Missing block: B:182:0x093d, code skipped:
            r2 = move-exception;
     */
        /* JADX WARNING: Missing block: B:183:0x093e, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r2, "Exception: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:187:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkUpload", "url %s ,start to read response ", r30);
     */
        /* JADX WARNING: Missing block: B:190:0x097f, code skipped:
            if ("gzip".equals(r16.getContentEncoding()) == false) goto L_0x09bc;
     */
        /* JADX WARNING: Missing block: B:191:0x0981, code skipped:
            r0 = new java.util.zip.GZIPInputStream(r16.getInputStream());
     */
        /* JADX WARNING: Missing block: B:204:?, code skipped:
            r28 = r16.getInputStream();
     */
        /* JADX WARNING: Missing block: B:205:0x09c1, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:207:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "getInputStream error", new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:210:0x09d9, code skipped:
            if ("gzip".equals(r16.getContentEncoding()) != false) goto L_0x09db;
     */
        /* JADX WARNING: Missing block: B:211:0x09db, code skipped:
            r0 = new java.util.zip.GZIPInputStream(r16.getErrorStream());
     */
        /* JADX WARNING: Missing block: B:214:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "read err stream failed", new java.lang.Object[0]);
     */
        /* JADX WARNING: Missing block: B:215:0x09f4, code skipped:
            r28 = null;
     */
        /* JADX WARNING: Missing block: B:217:?, code skipped:
            r28 = r16.getErrorStream();
     */
        /* JADX WARNING: Missing block: B:219:?, code skipped:
            r13 = r4.toString();
            r4 = r13.getBytes(java.nio.charset.Charset.forName("UTF-8")).length;
     */
        /* JADX WARNING: Missing block: B:221:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkUpload", "upload for url : %s, result = %s, statecode = %s", r0, r13, java.lang.Integer.valueOf(r14));
     */
        /* JADX WARNING: Missing block: B:344:0x0f55, code skipped:
            ((com.tencent.mm.plugin.appbrand.n.a) com.tencent.luggage.a.e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
     */
        /* JADX WARNING: Missing block: B:348:?, code skipped:
            r27.close();
     */
        /* JADX WARNING: Missing block: B:351:?, code skipped:
            r17.close();
     */
        /* JADX WARNING: Missing block: B:354:?, code skipped:
            r29.close();
     */
        /* JADX WARNING: Missing block: B:357:0x0fa1, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:358:0x0fa2, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "Exception: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:359:0x0fb5, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:360:0x0fb6, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "IOException: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:361:0x0fc9, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:362:0x0fca, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:363:0x0fdd, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:364:0x0fde, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "Throwable: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:365:0x0ff1, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:366:0x0ff2, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", r3, "IOException: url is %s filepath %s ", r30, r31);
     */
        /* JADX WARNING: Missing block: B:367:0x1005, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:368:0x1006, code skipped:
            r29 = null;
            r8 = 0;
     */
        /* JADX WARNING: Missing block: B:374:0x1018, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:375:0x1019, code skipped:
            r12 = r14;
     */
        /* JADX WARNING: Missing block: B:378:0x1022, code skipped:
            r2 = th;
     */
        /* JADX WARNING: Missing block: B:379:0x1023, code skipped:
            r17 = r28;
            r12 = r14;
            r19 = r4;
     */
        /* JADX WARNING: Missing block: B:382:0x1033, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:383:0x1034, code skipped:
            r10 = r3;
            r29 = null;
            r16 = null;
     */
        /* JADX WARNING: Missing block: B:392:0x1051, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:393:0x1052, code skipped:
            r10 = r3;
            r20 = r8;
            r12 = r14;
     */
        /* JADX WARNING: Missing block: B:396:0x1061, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:397:0x1062, code skipped:
            r10 = r3;
            r17 = r28;
            r20 = r8;
            r12 = r14;
            r19 = r4;
     */
        /* JADX WARNING: Missing block: B:398:0x106c, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:399:0x106d, code skipped:
            r10 = r3;
            r29 = null;
            r16 = null;
     */
        /* JADX WARNING: Missing block: B:408:0x108a, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:409:0x108b, code skipped:
            r10 = r3;
            r20 = r8;
            r12 = r14;
     */
        /* JADX WARNING: Missing block: B:412:0x109a, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:413:0x109b, code skipped:
            r10 = r3;
            r17 = r28;
            r20 = r8;
            r12 = r14;
            r19 = r4;
     */
        /* JADX WARNING: Missing block: B:416:0x10af, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:417:0x10b0, code skipped:
            r10 = r3;
            r29 = null;
            r16 = null;
     */
        /* JADX WARNING: Missing block: B:424:0x10c7, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:425:0x10c8, code skipped:
            r10 = r3;
            r20 = r8;
            r12 = r14;
     */
        /* JADX WARNING: Missing block: B:428:0x10d7, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:429:0x10d8, code skipped:
            r10 = r3;
            r17 = r28;
            r20 = r8;
            r12 = r14;
            r19 = r4;
     */
        /* JADX WARNING: Missing block: B:432:0x10ec, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:433:0x10ed, code skipped:
            r10 = r3;
            r29 = null;
            r16 = null;
     */
        /* JADX WARNING: Missing block: B:440:0x1104, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:441:0x1105, code skipped:
            r10 = r3;
            r20 = r8;
            r12 = r14;
     */
        /* JADX WARNING: Missing block: B:444:0x1114, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:445:0x1115, code skipped:
            r10 = r3;
            r17 = r28;
            r20 = r8;
            r12 = r14;
            r19 = r4;
     */
        /* JADX WARNING: Missing block: B:448:0x1128, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:449:0x1129, code skipped:
            r10 = r3;
            r15 = r0;
            r18 = null;
            r16 = null;
     */
        /* JADX WARNING: Missing block: B:456:0x114e, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:457:0x114f, code skipped:
            r10 = r3;
            r15 = r0;
            r18 = r0;
            r20 = r8;
            r12 = r14;
     */
        /* JADX WARNING: Missing block: B:458:0x1159, code skipped:
            r3 = move-exception;
     */
        /* JADX WARNING: Missing block: B:459:0x115a, code skipped:
            r10 = r3;
            r15 = r0;
            r17 = r28;
            r18 = r0;
            r20 = r8;
            r12 = r14;
            r19 = r4;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(h hVar) {
            InputStream inputStream;
            String str;
            FileInputStream fileInputStream;
            HttpURLConnection httpURLConnection;
            DataOutputStream dataOutputStream;
            long j;
            Throwable th;
            FileInputStream fileInputStream2;
            DataOutputStream dataOutputStream2;
            Throwable th2;
            FileInputStream fileInputStream3;
            DataOutputStream dataOutputStream3;
            AppMethodBeat.i(108169);
            String str2 = hVar.mUrl;
            String str3 = hVar.mFilepath;
            String str4 = hVar.mName;
            String bZ = bZ(hVar.mMimeType, "application/octet-stream");
            ab.v("MicroMsg.AppBrandNetworkUpload", "uploadFile filename %s", hVar.mFileName);
            Map map = hVar.ioX;
            Map map2 = hVar.ioM;
            int i = 0;
            int i2 = 0;
            long j2 = 0;
            a aVar = hVar.ioY;
            ArrayList arrayList = hVar.ioN;
            if (arrayList == null || j.c(arrayList, str2)) {
                inputStream = null;
                if (!hVar.isRunning) {
                    g.a(g.this, aVar, "force_stop!", hVar.hvr, null);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, 0, 0, 0, 2, hVar.aID());
                    ab.e("MicroMsg.AppBrandNetworkUpload", "force stop!");
                    AppMethodBeat.o(108169);
                    return;
                } else if (URLUtil.isHttpsUrl(hVar.mUrl) || URLUtil.isHttpUrl(hVar.mUrl)) {
                    String str5 = "--";
                    String l = Long.toString(System.currentTimeMillis());
                    String str6 = IOUtils.LINE_SEPARATOR_WINDOWS;
                    str = "";
                    try {
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 0, 1);
                        File file = new File(str3);
                        fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr;
                            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                            if (!bo.isNullOrNil(hVar.hvr)) {
                                hVar.ioQ = httpURLConnection;
                            }
                            if ((httpURLConnection instanceof HttpsURLConnection) && g.this.ios != null) {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(g.this.ios.getSocketFactory());
                                j.a(httpURLConnection, arrayList);
                            }
                            httpURLConnection.setDoInput(true);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setUseCaches(false);
                            httpURLConnection.setConnectTimeout(hVar.ioJ);
                            httpURLConnection.setReadTimeout(hVar.ioJ);
                            httpURLConnection.setRequestMethod("POST");
                            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                            ab.i("MicroMsg.AppBrandNetworkUpload", "file path = %s, length = %d", file.getAbsolutePath(), Long.valueOf(file.length()));
                            httpURLConnection.setInstanceFollowRedirects(false);
                            if (map2 != null) {
                                ab.i("MicroMsg.AppBrandNetworkUpload", "url %s : set header ", str2);
                                for (Entry entry : map2.entrySet()) {
                                    ab.i("MicroMsg.AppBrandNetworkUpload", "set header for : url %s : key:%s ,value %s ", str2, entry.getKey(), entry.getValue());
                                    if (!(bo.isNullOrNil((String) entry.getKey()) || bo.isNullOrNil((String) entry.getValue()))) {
                                        if (((String) entry.getKey()).toLowerCase().contains("content-length")) {
                                            ab.e("MicroMsg.AppBrandNetworkUpload", "not allow to set Content-Length");
                                        } else {
                                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                        }
                                    }
                                }
                            }
                            httpURLConnection.setRequestProperty("User-Agent", g.this.ibJ);
                            long length = file.length();
                            StringBuilder stringBuilder = new StringBuilder();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            if (map != null) {
                                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=".concat(String.valueOf(l)));
                                for (String str7 : map.keySet()) {
                                    ab.i("MicroMsg.AppBrandNetworkUpload", "append form data: key = %s, value = %s", str7, (String) map.get(str7));
                                    stringBuilder.append(str5 + l + str6);
                                    stringBuilder.append("Content-Disposition: form-data; name=\"" + str7 + "\"");
                                    stringBuilder.append(str6);
                                    stringBuilder.append(str6);
                                    stringBuilder.append(r4);
                                    stringBuilder.append(str6);
                                }
                                stringBuilder.append(str5 + l + str6);
                                stringBuilder.append("Content-Disposition: form-data; name=\"" + str4 + "\"; filename=\"" + r23 + "\"" + str6);
                                stringBuilder.append("Content-Type: ".concat(String.valueOf(bZ)));
                                stringBuilder.append(str6);
                                stringBuilder.append(str6);
                                stringBuilder2.append(str6 + str5 + l + str5 + str6);
                            }
                            byte[] bytes = stringBuilder.toString().getBytes("UTF-8");
                            byte[] bytes2 = stringBuilder2.toString().getBytes("UTF-8");
                            if (bytes == null) {
                                bytes = new byte[0];
                            }
                            if (bytes2 == null) {
                                bArr = new byte[0];
                            } else {
                                bArr = bytes2;
                            }
                            length = (length + ((long) bytes.length)) + ((long) bArr.length);
                            ab.i("MicroMsg.AppBrandNetworkUpload", "contentLenght = %d", Long.valueOf(length));
                            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
                            aVar.p(j.f(httpURLConnection));
                            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            try {
                                dataOutputStream.write(bytes);
                                byte[] bArr2 = new byte[j.gr(length)];
                                length = file.length();
                                int i3 = -1;
                                j = 0;
                                while (true) {
                                    try {
                                        int read = fileInputStream.read(bArr2);
                                        if (read == -1 || !hVar.isRunning) {
                                            break;
                                        } else if (j.y(g.this.hvw)) {
                                            g.a(g.this, aVar, "interrupted", hVar.hvr, httpURLConnection);
                                            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, 0, 0, 2, hVar.aID());
                                            if (at.getNetType(ah.getContext()) == -1) {
                                                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                                            }
                                            ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                            hVar.isRunning = false;
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e) {
                                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e, "Exception: url is %s filepath %s ", str2, str3);
                                            }
                                            try {
                                                dataOutputStream.close();
                                            } catch (IOException e2) {
                                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e2, "IOException: url is %s filepath %s ", str2, str3);
                                            }
                                            g.this.iot.remove(hVar.hvr);
                                            AppMethodBeat.o(108169);
                                            return;
                                        } else {
                                            dataOutputStream.write(bArr2, 0, read);
                                            long j3 = ((long) read) + j;
                                            if (length > 0) {
                                                try {
                                                    if (hVar.isRunning) {
                                                        read = (int) ((100 * j3) / length);
                                                        if (i3 != read) {
                                                            aVar.h(read, j3, length);
                                                            i3 = read;
                                                        }
                                                        ab.v("MicroMsg.AppBrandNetworkUpload", "uploadSize %d, totalSize %d, percent = %d", Long.valueOf(j3), Long.valueOf(length), Integer.valueOf(read));
                                                        j = j3;
                                                    }
                                                } catch (UnsupportedEncodingException e3) {
                                                    th = e3;
                                                    fileInputStream2 = fileInputStream;
                                                    dataOutputStream2 = dataOutputStream;
                                                    j2 = j3;
                                                    try {
                                                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 1, 1);
                                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "UnsupportedEncodingException: url is %s filepath %s ", str2, str3);
                                                        g.a(g.this, aVar, -1, "unsupported encoding", i2, hVar.hvr, httpURLConnection);
                                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                                        if (at.getNetType(ah.getContext()) == -1) {
                                                        }
                                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                                        hVar.isRunning = false;
                                                        if (fileInputStream2 != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (dataOutputStream2 != null) {
                                                        }
                                                        g.this.iot.remove(hVar.hvr);
                                                        AppMethodBeat.o(108169);
                                                        return;
                                                    } catch (Throwable th3) {
                                                        th2 = th3;
                                                        fileInputStream3 = fileInputStream2;
                                                        dataOutputStream3 = dataOutputStream2;
                                                        j = j2;
                                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i, i2, 2, hVar.aID());
                                                        if (at.getNetType(ah.getContext()) == -1) {
                                                        }
                                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r10));
                                                        hVar.isRunning = false;
                                                        if (fileInputStream3 != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (dataOutputStream3 != null) {
                                                        }
                                                        g.this.iot.remove(hVar.hvr);
                                                        AppMethodBeat.o(108169);
                                                        throw th2;
                                                    }
                                                } catch (FileNotFoundException e32) {
                                                    th = e32;
                                                    j2 = j3;
                                                    try {
                                                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 3, 1);
                                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "FileNotFoundException: url is %s filepath %s ", str2, str3);
                                                        g.a(g.this, aVar, -1, "file not exist", i2, hVar.hvr, httpURLConnection);
                                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                                        if (at.getNetType(ah.getContext()) == -1) {
                                                        }
                                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                                        hVar.isRunning = false;
                                                        if (fileInputStream3 != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (dataOutputStream3 != null) {
                                                        }
                                                        g.this.iot.remove(hVar.hvr);
                                                        AppMethodBeat.o(108169);
                                                        return;
                                                    } catch (Throwable th4) {
                                                        th2 = th4;
                                                        j = j2;
                                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i, i2, 2, hVar.aID());
                                                        if (at.getNetType(ah.getContext()) == -1) {
                                                        }
                                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r10));
                                                        hVar.isRunning = false;
                                                        if (fileInputStream3 != null) {
                                                        }
                                                        if (inputStream != null) {
                                                        }
                                                        if (dataOutputStream3 != null) {
                                                        }
                                                        g.this.iot.remove(hVar.hvr);
                                                        AppMethodBeat.o(108169);
                                                        throw th2;
                                                    }
                                                } catch (SSLHandshakeException e322) {
                                                    th = e322;
                                                    j2 = j3;
                                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 2, 1);
                                                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SSLHandshakeException: url is %s filepath %s ", str2, str3);
                                                    g.a(g.this, aVar, -1, "ssl hand shake error", i2, hVar.hvr, httpURLConnection);
                                                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                                    if (at.getNetType(ah.getContext()) == -1) {
                                                    }
                                                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                                    hVar.isRunning = false;
                                                    if (fileInputStream3 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                    }
                                                    g.this.iot.remove(hVar.hvr);
                                                    AppMethodBeat.o(108169);
                                                    return;
                                                } catch (SocketTimeoutException e3222) {
                                                    th = e3222;
                                                    j2 = j3;
                                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 4, 1);
                                                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SocketTimeoutException: url is %s filepath %s ", str2, str3);
                                                    g.a(g.this, aVar, -1, "socket timeout error", i2, hVar.hvr, httpURLConnection);
                                                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                                    if (at.getNetType(ah.getContext()) == -1) {
                                                    }
                                                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                                    hVar.isRunning = false;
                                                    if (fileInputStream3 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                    }
                                                    g.this.iot.remove(hVar.hvr);
                                                    AppMethodBeat.o(108169);
                                                    return;
                                                } catch (Exception e32222) {
                                                    th = e32222;
                                                    j2 = j3;
                                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 5, 1);
                                                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "Exception: url is %s filepath %s ", str2, str3);
                                                    g.a(g.this, aVar, -1, th.getMessage(), i2, hVar.hvr, httpURLConnection);
                                                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                                    if (at.getNetType(ah.getContext()) == -1) {
                                                    }
                                                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                                    hVar.isRunning = false;
                                                    if (fileInputStream3 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                    }
                                                    g.this.iot.remove(hVar.hvr);
                                                    AppMethodBeat.o(108169);
                                                    return;
                                                } catch (Throwable th5) {
                                                    th2 = th5;
                                                    j = j3;
                                                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i, i2, 2, hVar.aID());
                                                    if (at.getNetType(ah.getContext()) == -1) {
                                                    }
                                                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r10));
                                                    hVar.isRunning = false;
                                                    if (fileInputStream3 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (dataOutputStream3 != null) {
                                                    }
                                                    g.this.iot.remove(hVar.hvr);
                                                    AppMethodBeat.o(108169);
                                                    throw th2;
                                                }
                                            }
                                            j = j3;
                                        }
                                    } catch (UnsupportedEncodingException e322222) {
                                        th = e322222;
                                        fileInputStream2 = fileInputStream;
                                        dataOutputStream2 = dataOutputStream;
                                        j2 = j;
                                    } catch (FileNotFoundException e3222222) {
                                        th = e3222222;
                                        j2 = j;
                                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 3, 1);
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "FileNotFoundException: url is %s filepath %s ", str2, str3);
                                        g.a(g.this, aVar, -1, "file not exist", i2, hVar.hvr, httpURLConnection);
                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                        if (at.getNetType(ah.getContext()) == -1) {
                                        }
                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                        hVar.isRunning = false;
                                        if (fileInputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream3 != null) {
                                        }
                                        g.this.iot.remove(hVar.hvr);
                                        AppMethodBeat.o(108169);
                                        return;
                                    } catch (SSLHandshakeException e32222222) {
                                        th = e32222222;
                                        j2 = j;
                                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 2, 1);
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SSLHandshakeException: url is %s filepath %s ", str2, str3);
                                        g.a(g.this, aVar, -1, "ssl hand shake error", i2, hVar.hvr, httpURLConnection);
                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                        if (at.getNetType(ah.getContext()) == -1) {
                                        }
                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                        hVar.isRunning = false;
                                        if (fileInputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream3 != null) {
                                        }
                                        g.this.iot.remove(hVar.hvr);
                                        AppMethodBeat.o(108169);
                                        return;
                                    } catch (SocketTimeoutException e322222222) {
                                        th = e322222222;
                                        j2 = j;
                                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 4, 1);
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SocketTimeoutException: url is %s filepath %s ", str2, str3);
                                        g.a(g.this, aVar, -1, "socket timeout error", i2, hVar.hvr, httpURLConnection);
                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                        if (at.getNetType(ah.getContext()) == -1) {
                                        }
                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                        hVar.isRunning = false;
                                        if (fileInputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream3 != null) {
                                        }
                                        g.this.iot.remove(hVar.hvr);
                                        AppMethodBeat.o(108169);
                                        return;
                                    } catch (Exception e3222222222) {
                                        th = e3222222222;
                                        j2 = j;
                                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 5, 1);
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "Exception: url is %s filepath %s ", str2, str3);
                                        g.a(g.this, aVar, -1, th.getMessage(), i2, hVar.hvr, httpURLConnection);
                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                        if (at.getNetType(ah.getContext()) == -1) {
                                        }
                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                        hVar.isRunning = false;
                                        if (fileInputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream3 != null) {
                                        }
                                        g.this.iot.remove(hVar.hvr);
                                        AppMethodBeat.o(108169);
                                        return;
                                    } catch (Throwable th6) {
                                        th2 = th6;
                                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i, i2, 2, hVar.aID());
                                        if (at.getNetType(ah.getContext()) == -1) {
                                        }
                                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r10));
                                        hVar.isRunning = false;
                                        if (fileInputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (dataOutputStream3 != null) {
                                        }
                                        g.this.iot.remove(hVar.hvr);
                                        AppMethodBeat.o(108169);
                                        throw th2;
                                    }
                                }
                            } catch (UnsupportedEncodingException e32222222222) {
                                th = e32222222222;
                                fileInputStream2 = fileInputStream;
                                dataOutputStream2 = dataOutputStream;
                                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 1, 1);
                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "UnsupportedEncodingException: url is %s filepath %s ", str2, str3);
                                g.a(g.this, aVar, -1, "unsupported encoding", i2, hVar.hvr, httpURLConnection);
                                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                hVar.isRunning = false;
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (Exception e4) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e4, "Exception: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e22) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e22, "IOException: url is %s filepath %s ", str2, str3);
                                    } catch (ArrayIndexOutOfBoundsException e5) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e5, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", str2, str3);
                                    } catch (Throwable th22) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th22, "Throwable: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e222, "IOException: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                g.this.iot.remove(hVar.hvr);
                                AppMethodBeat.o(108169);
                                return;
                            } catch (FileNotFoundException e322222222222) {
                                th = e322222222222;
                                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 3, 1);
                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "FileNotFoundException: url is %s filepath %s ", str2, str3);
                                g.a(g.this, aVar, -1, "file not exist", i2, hVar.hvr, httpURLConnection);
                                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                hVar.isRunning = false;
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                    } catch (Exception e42) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e42, "Exception: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e2222, "IOException: url is %s filepath %s ", str2, str3);
                                    } catch (ArrayIndexOutOfBoundsException e52) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e52, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", str2, str3);
                                    } catch (Throwable th222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th222, "Throwable: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (IOException e22222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e22222, "IOException: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                g.this.iot.remove(hVar.hvr);
                                AppMethodBeat.o(108169);
                                return;
                            } catch (SSLHandshakeException e3222222222222) {
                                th = e3222222222222;
                                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 2, 1);
                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SSLHandshakeException: url is %s filepath %s ", str2, str3);
                                g.a(g.this, aVar, -1, "ssl hand shake error", i2, hVar.hvr, httpURLConnection);
                                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                hVar.isRunning = false;
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                    } catch (Exception e422) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e422, "Exception: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e222222, "IOException: url is %s filepath %s ", str2, str3);
                                    } catch (ArrayIndexOutOfBoundsException e522) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e522, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", str2, str3);
                                    } catch (Throwable th2222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th2222, "Throwable: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (IOException e2222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e2222222, "IOException: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                g.this.iot.remove(hVar.hvr);
                                AppMethodBeat.o(108169);
                                return;
                            } catch (SocketTimeoutException e32222222222222) {
                                th = e32222222222222;
                                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 4, 1);
                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SocketTimeoutException: url is %s filepath %s ", str2, str3);
                                g.a(g.this, aVar, -1, "socket timeout error", i2, hVar.hvr, httpURLConnection);
                                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                hVar.isRunning = false;
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                    } catch (Exception e4222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e4222, "Exception: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e22222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e22222222, "IOException: url is %s filepath %s ", str2, str3);
                                    } catch (ArrayIndexOutOfBoundsException e5222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e5222, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", str2, str3);
                                    } catch (Throwable th22222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th22222, "Throwable: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (IOException e222222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e222222222, "IOException: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                g.this.iot.remove(hVar.hvr);
                                AppMethodBeat.o(108169);
                                return;
                            } catch (Exception e322222222222222) {
                                th = e322222222222222;
                                ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 5, 1);
                                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "Exception: url is %s filepath %s ", str2, str3);
                                g.a(g.this, aVar, -1, th.getMessage(), i2, hVar.hvr, httpURLConnection);
                                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                                if (at.getNetType(ah.getContext()) == -1) {
                                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                                }
                                ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                                hVar.isRunning = false;
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                    } catch (Exception e42222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e42222, "Exception: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2222222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e2222222222, "IOException: url is %s filepath %s ", str2, str3);
                                    } catch (ArrayIndexOutOfBoundsException e52222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e52222, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", str2, str3);
                                    } catch (Throwable th222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th222222, "Throwable: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                if (dataOutputStream3 != null) {
                                    try {
                                        dataOutputStream3.close();
                                    } catch (IOException e22222222222) {
                                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e22222222222, "IOException: url is %s filepath %s ", str2, str3);
                                    }
                                }
                                g.this.iot.remove(hVar.hvr);
                                AppMethodBeat.o(108169);
                                return;
                            }
                        } catch (UnsupportedEncodingException e3222222222222222) {
                            th = e3222222222222222;
                            fileInputStream2 = fileInputStream;
                            dataOutputStream2 = null;
                            ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 1, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "UnsupportedEncodingException: url is %s filepath %s ", str2, str3);
                            g.a(g.this, aVar, -1, "unsupported encoding", i2, hVar.hvr, httpURLConnection);
                            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                            if (at.getNetType(ah.getContext()) == -1) {
                            }
                            ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                            hVar.isRunning = false;
                            if (fileInputStream2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (dataOutputStream2 != null) {
                            }
                            g.this.iot.remove(hVar.hvr);
                            AppMethodBeat.o(108169);
                            return;
                        } catch (FileNotFoundException e32222222222222222) {
                            th = e32222222222222222;
                            dataOutputStream3 = null;
                            ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 3, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "FileNotFoundException: url is %s filepath %s ", str2, str3);
                            g.a(g.this, aVar, -1, "file not exist", i2, hVar.hvr, httpURLConnection);
                            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                            if (at.getNetType(ah.getContext()) == -1) {
                            }
                            ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                            hVar.isRunning = false;
                            if (fileInputStream3 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (dataOutputStream3 != null) {
                            }
                            g.this.iot.remove(hVar.hvr);
                            AppMethodBeat.o(108169);
                            return;
                        } catch (SSLHandshakeException e322222222222222222) {
                            th = e322222222222222222;
                            dataOutputStream3 = null;
                            ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 2, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SSLHandshakeException: url is %s filepath %s ", str2, str3);
                            g.a(g.this, aVar, -1, "ssl hand shake error", i2, hVar.hvr, httpURLConnection);
                            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                            if (at.getNetType(ah.getContext()) == -1) {
                            }
                            ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                            hVar.isRunning = false;
                            if (fileInputStream3 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (dataOutputStream3 != null) {
                            }
                            g.this.iot.remove(hVar.hvr);
                            AppMethodBeat.o(108169);
                            return;
                        } catch (SocketTimeoutException e3222222222222222222) {
                            th = e3222222222222222222;
                            dataOutputStream3 = null;
                            ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 4, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SocketTimeoutException: url is %s filepath %s ", str2, str3);
                            g.a(g.this, aVar, -1, "socket timeout error", i2, hVar.hvr, httpURLConnection);
                            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                            if (at.getNetType(ah.getContext()) == -1) {
                            }
                            ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                            hVar.isRunning = false;
                            if (fileInputStream3 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (dataOutputStream3 != null) {
                            }
                            g.this.iot.remove(hVar.hvr);
                            AppMethodBeat.o(108169);
                            return;
                        } catch (Exception e32222222222222222222) {
                            th = e32222222222222222222;
                            dataOutputStream3 = null;
                            ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 5, 1);
                            ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "Exception: url is %s filepath %s ", str2, str3);
                            g.a(g.this, aVar, -1, th.getMessage(), i2, hVar.hvr, httpURLConnection);
                            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                            if (at.getNetType(ah.getContext()) == -1) {
                            }
                            ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                            hVar.isRunning = false;
                            if (fileInputStream3 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (dataOutputStream3 != null) {
                            }
                            g.this.iot.remove(hVar.hvr);
                            AppMethodBeat.o(108169);
                            return;
                        } catch (Throwable th7) {
                        }
                    } catch (UnsupportedEncodingException e322222222222222222222) {
                        th = e322222222222222222222;
                        fileInputStream2 = null;
                        dataOutputStream2 = null;
                        httpURLConnection = null;
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 1, 1);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "UnsupportedEncodingException: url is %s filepath %s ", str2, str3);
                        g.a(g.this, aVar, -1, "unsupported encoding", i2, hVar.hvr, httpURLConnection);
                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                        if (at.getNetType(ah.getContext()) == -1) {
                        }
                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                        hVar.isRunning = false;
                        if (fileInputStream2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (dataOutputStream2 != null) {
                        }
                        g.this.iot.remove(hVar.hvr);
                        AppMethodBeat.o(108169);
                        return;
                    } catch (FileNotFoundException e3222222222222222222222) {
                        th = e3222222222222222222222;
                        fileInputStream3 = null;
                        dataOutputStream3 = null;
                        httpURLConnection = null;
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 3, 1);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "FileNotFoundException: url is %s filepath %s ", str2, str3);
                        g.a(g.this, aVar, -1, "file not exist", i2, hVar.hvr, httpURLConnection);
                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                        if (at.getNetType(ah.getContext()) == -1) {
                        }
                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                        hVar.isRunning = false;
                        if (fileInputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        g.this.iot.remove(hVar.hvr);
                        AppMethodBeat.o(108169);
                        return;
                    } catch (SSLHandshakeException e32222222222222222222222) {
                        th = e32222222222222222222222;
                        fileInputStream3 = null;
                        dataOutputStream3 = null;
                        httpURLConnection = null;
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 2, 1);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SSLHandshakeException: url is %s filepath %s ", str2, str3);
                        g.a(g.this, aVar, -1, "ssl hand shake error", i2, hVar.hvr, httpURLConnection);
                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                        if (at.getNetType(ah.getContext()) == -1) {
                        }
                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                        hVar.isRunning = false;
                        if (fileInputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        g.this.iot.remove(hVar.hvr);
                        AppMethodBeat.o(108169);
                        return;
                    } catch (SocketTimeoutException e322222222222222222222222) {
                        th = e322222222222222222222222;
                        fileInputStream3 = null;
                        dataOutputStream3 = null;
                        httpURLConnection = null;
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 4, 1);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SocketTimeoutException: url is %s filepath %s ", str2, str3);
                        g.a(g.this, aVar, -1, "socket timeout error", i2, hVar.hvr, httpURLConnection);
                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                        if (at.getNetType(ah.getContext()) == -1) {
                        }
                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                        hVar.isRunning = false;
                        if (fileInputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        g.this.iot.remove(hVar.hvr);
                        AppMethodBeat.o(108169);
                        return;
                    } catch (Exception e3222222222222222222222222) {
                        th = e3222222222222222222222222;
                        fileInputStream3 = null;
                        dataOutputStream3 = null;
                        httpURLConnection = null;
                        ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 5, 1);
                        ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "Exception: url is %s filepath %s ", str2, str3);
                        g.a(g.this, aVar, -1, th.getMessage(), i2, hVar.hvr, httpURLConnection);
                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                        if (at.getNetType(ah.getContext()) == -1) {
                        }
                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                        hVar.isRunning = false;
                        if (fileInputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        g.this.iot.remove(hVar.hvr);
                        AppMethodBeat.o(108169);
                        return;
                    } catch (Throwable th8) {
                        th222222 = th8;
                        fileInputStream3 = null;
                        dataOutputStream3 = null;
                        j = 0;
                        ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i, i2, 2, hVar.aID());
                        if (at.getNetType(ah.getContext()) == -1) {
                        }
                        ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r10));
                        hVar.isRunning = false;
                        if (fileInputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (dataOutputStream3 != null) {
                        }
                        g.this.iot.remove(hVar.hvr);
                        AppMethodBeat.o(108169);
                        throw th222222;
                    }
                } else {
                    g.a(g.this, aVar, "uploadFile protocol must be http or https", hVar.hvr, null);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, 0, 0, 0, 2, hVar.aID());
                    AppMethodBeat.o(108169);
                    return;
                }
            }
            g.a(g.this, aVar, "fail:url not in domain list", hVar.hvr, null);
            ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, 0, 0, 0, 2, hVar.aID());
            ab.i("MicroMsg.AppBrandNetworkUpload", "not in domain url %s", str2);
            AppMethodBeat.o(108169);
            return;
            if (r28 != null) {
                try {
                    r28.close();
                } catch (IOException e222222222222) {
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e222222222222, "IOException: url is %s filepath %s ", str2, str3);
                } catch (ArrayIndexOutOfBoundsException e522222) {
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e522222, "ArrayIndexOutOfBoundsException: url is %s filepath %s ", str2, str3);
                } catch (Throwable th2222222) {
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th2222222, "Throwable: url is %s filepath %s ", str2, str3);
                }
            }
            try {
                dataOutputStream.close();
            } catch (IOException e2222222222222) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e2222222222222, "IOException: url is %s filepath %s ", str2, str3);
            }
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            return;
            dataOutputStream.close();
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            return;
            String str8;
            int i4;
            Object obj;
            if (r28 != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(r28));
                    StringBuilder stringBuilder3 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || !hVar.isRunning) {
                            break;
                        }
                        stringBuilder3.append(readLine);
                    }
                } catch (UnsupportedEncodingException e32222222222222222222222222) {
                    th = e32222222222222222222222222;
                    fileInputStream2 = fileInputStream;
                    inputStream = r28;
                    dataOutputStream2 = dataOutputStream;
                    j2 = j;
                    i2 = r14;
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 1, 1);
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "UnsupportedEncodingException: url is %s filepath %s ", str2, str3);
                    g.a(g.this, aVar, -1, "unsupported encoding", i2, hVar.hvr, httpURLConnection);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                    if (at.getNetType(ah.getContext()) == -1) {
                    }
                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                    hVar.isRunning = false;
                    if (fileInputStream2 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (dataOutputStream2 != null) {
                    }
                    g.this.iot.remove(hVar.hvr);
                    AppMethodBeat.o(108169);
                    return;
                } catch (FileNotFoundException e322222222222222222222222222) {
                    th = e322222222222222222222222222;
                    inputStream = r28;
                    j2 = j;
                    i2 = r14;
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 3, 1);
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "FileNotFoundException: url is %s filepath %s ", str2, str3);
                    g.a(g.this, aVar, -1, "file not exist", i2, hVar.hvr, httpURLConnection);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                    if (at.getNetType(ah.getContext()) == -1) {
                    }
                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                    hVar.isRunning = false;
                    if (fileInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (dataOutputStream3 != null) {
                    }
                    g.this.iot.remove(hVar.hvr);
                    AppMethodBeat.o(108169);
                    return;
                } catch (SSLHandshakeException e3222222222222222222222222222) {
                    th = e3222222222222222222222222222;
                    inputStream = r28;
                    j2 = j;
                    i2 = r14;
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 2, 1);
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SSLHandshakeException: url is %s filepath %s ", str2, str3);
                    g.a(g.this, aVar, -1, "ssl hand shake error", i2, hVar.hvr, httpURLConnection);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                    if (at.getNetType(ah.getContext()) == -1) {
                    }
                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                    hVar.isRunning = false;
                    if (fileInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (dataOutputStream3 != null) {
                    }
                    g.this.iot.remove(hVar.hvr);
                    AppMethodBeat.o(108169);
                    return;
                } catch (SocketTimeoutException e32222222222222222222222222222) {
                    th = e32222222222222222222222222222;
                    inputStream = r28;
                    j2 = j;
                    i2 = r14;
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 4, 1);
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "SocketTimeoutException: url is %s filepath %s ", str2, str3);
                    g.a(g.this, aVar, -1, "socket timeout error", i2, hVar.hvr, httpURLConnection);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                    if (at.getNetType(ah.getContext()) == -1) {
                    }
                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                    hVar.isRunning = false;
                    if (fileInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (dataOutputStream3 != null) {
                    }
                    g.this.iot.remove(hVar.hvr);
                    AppMethodBeat.o(108169);
                    return;
                } catch (Exception e322222222222222222222222222222) {
                    th = e322222222222222222222222222222;
                    inputStream = r28;
                    j2 = j;
                    i2 = r14;
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 5, 1);
                    ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", th, "Exception: url is %s filepath %s ", str2, str3);
                    g.a(g.this, aVar, -1, th.getMessage(), i2, hVar.hvr, httpURLConnection);
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j2, (long) i, i2, 2, hVar.aID());
                    if (at.getNetType(ah.getContext()) == -1) {
                    }
                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
                    hVar.isRunning = false;
                    if (fileInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (dataOutputStream3 != null) {
                    }
                    g.this.iot.remove(hVar.hvr);
                    AppMethodBeat.o(108169);
                    return;
                } catch (Throwable th9) {
                    th2222222 = th9;
                    inputStream = r28;
                    i2 = r14;
                    ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i, i2, 2, hVar.aID());
                    if (at.getNetType(ah.getContext()) == -1) {
                    }
                    ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r10));
                    hVar.isRunning = false;
                    if (fileInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (dataOutputStream3 != null) {
                    }
                    g.this.iot.remove(hVar.hvr);
                    AppMethodBeat.o(108169);
                    throw th2222222;
                }
            }
            str8 = str;
            i4 = 0;
            if (hVar.isRunning) {
                g.a(g.this, aVar, 0, str8, r14, hVar.hvr, httpURLConnection);
                ab.i("MicroMsg.AppBrandNetworkUpload", "success : url = %s, filePath = %s", str2, str3);
                obj = 1;
            } else {
                g.a(g.this, aVar, -1, "force_stop!", r14, hVar.hvr, httpURLConnection);
                ab.e("MicroMsg.AppBrandNetworkUpload", "force stop!");
                obj = null;
            }
            if (obj != null) {
                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i4, r14, 1, hVar.aID());
            } else {
                ((o) e.C(o.class)).a(g.this.hvw.getAppId(), hVar.ioR, "POST", hVar.mUrl, j, (long) i4, r14, 2, hVar.aID());
                if (at.getNetType(ah.getContext()) == -1) {
                    ((com.tencent.mm.plugin.appbrand.n.a) e.C(com.tencent.mm.plugin.appbrand.n.a.class)).f(436, 7, 1);
                }
                ab.i("MicroMsg.AppBrandNetworkUpload", "uploadFile fail ret:%d", Integer.valueOf(r2));
            }
            hVar.isRunning = false;
            try {
                fileInputStream.close();
            } catch (Exception e422222) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e422222, "Exception: url is %s filepath %s ", str2, str3);
            }
            if (r28 != null) {
            }
            dataOutputStream.close();
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            return;
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            return;
            try {
                dataOutputStream.close();
            } catch (IOException e22222222222222) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e22222222222222, "IOException: url is %s filepath %s ", str2, str3);
            }
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            return;
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            return;
            try {
                dataOutputStream.close();
            } catch (IOException e222222222222222) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e222222222222222, "IOException: url is %s filepath %s ", str2, str3);
            }
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
            g.this.iot.remove(hVar.hvr);
            AppMethodBeat.o(108169);
        }
    }

    public g(c cVar) {
        AppMethodBeat.i(108170);
        this.hvw = cVar;
        a aVar = (a) cVar.aa(a.class);
        this.ioT = aVar.bQx;
        this.ibJ = aVar.ioo;
        this.ios = j.a(aVar);
        AppMethodBeat.o(108170);
    }

    /* JADX WARNING: Missing block: B:10:0x0060, code skipped:
            if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0083;
     */
    /* JADX WARNING: Missing block: B:11:0x0062, code skipped:
            r17.BC("fileName error");
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
            com.tencent.matrix.trace.core.AppMethodBeat.o(108171);
     */
    /* JADX WARNING: Missing block: B:16:0x0083, code skipped:
            r1 = new com.tencent.mm.plugin.appbrand.l.h(r13, r3, r4, r20, r11, r12, r17);
            r1.ioX = r9;
            r1.ioM = r15;
            r1.ioN = r16;
            r1.isRunning = true;
            r1.hvr = r18;
            r1.ioR = r19;
            r2 = r10.ioU;
     */
    /* JADX WARNING: Missing block: B:17:0x00a4, code skipped:
            monitor-enter(r2);
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r10.ioU.add(r1);
     */
    /* JADX WARNING: Missing block: B:20:0x00aa, code skipped:
            monitor-exit(r2);
     */
    /* JADX WARNING: Missing block: B:21:0x00ab, code skipped:
            r2 = new com.tencent.mm.plugin.appbrand.l.g.b(r10, r1);
            r1 = "appbrand_upload_thread";
            com.tencent.mm.sdk.g.d.post(r2, r1);
     */
    /* JADX WARNING: Missing block: B:25:0x00bf, code skipped:
            r2 = r1;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:34:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(108171);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, String str, String str2, JSONObject jSONObject, Map<String, String> map, ArrayList<String> arrayList, a aVar, String str3, String str4, String str5) {
        AppMethodBeat.i(108171);
        String CS = j.CS(jSONObject.optString("url"));
        String optString = jSONObject.optString("name");
        Map F = j.F(jSONObject);
        synchronized (this.ioU) {
            try {
                if (this.ioU.size() >= this.ioT) {
                    aVar.BC("tasked refused max connected");
                    ab.i("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", Integer.valueOf(this.ioU.size()), Integer.valueOf(this.ioT));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108171);
            }
        }
    }

    private void kP(String str) {
        AppMethodBeat.i(108172);
        if (str == null) {
            AppMethodBeat.o(108172);
            return;
        }
        synchronized (this.ioU) {
            try {
                Iterator it = this.ioU.iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (str.equals(hVar.hvr)) {
                        this.ioU.remove(hVar);
                        break;
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108172);
            }
        }
    }

    public final h CN(String str) {
        h hVar;
        AppMethodBeat.i(108173);
        if (str == null) {
            AppMethodBeat.o(108173);
            return null;
        }
        synchronized (this.ioU) {
            try {
                Iterator it = this.ioU.iterator();
                while (it.hasNext()) {
                    hVar = (h) it.next();
                    if (str.equals(hVar.hvr)) {
                    }
                }
                AppMethodBeat.o(108173);
                return null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(108173);
            }
        }
        return hVar;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(108174);
        if (hVar == null) {
            AppMethodBeat.o(108174);
            return;
        }
        this.iot.add(hVar.hvr);
        hVar.isRunning = false;
        a(hVar.hvr, hVar.ioQ);
        AppMethodBeat.o(108174);
    }

    public final boolean CH(String str) {
        AppMethodBeat.i(108175);
        boolean contains = this.iot.contains(str);
        AppMethodBeat.o(108175);
        return contains;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(108176);
        kP(str);
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                AppMethodBeat.o(108176);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", e, "removeTask Exception: id %s", str);
            }
        }
        AppMethodBeat.o(108176);
    }

    static /* synthetic */ void a(g gVar, a aVar, String str, String str2, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(138238);
        gVar.a(str2, httpURLConnection);
        aVar.BC(str);
        AppMethodBeat.o(138238);
    }

    static /* synthetic */ void a(g gVar, a aVar, int i, String str, int i2, String str2, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(138239);
        gVar.a(str2, httpURLConnection);
        aVar.g(i, str, i2);
        AppMethodBeat.o(138239);
    }
}
