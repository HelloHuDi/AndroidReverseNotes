package com.tencent.p177mm.plugin.traceroute.p1043b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p178a.C1171c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/* renamed from: com.tencent.mm.plugin.traceroute.b.a */
public final class C43709a {
    public static String sIs;
    public static C46314c sIt;
    private final String TAG = "MicroMsg.MMTraceRoute";
    public C22428c sIA;
    public C29465b sIB;
    private final int sIu = 64;
    private boolean sIv = false;
    C43705f sIw = new C43705f(this, (byte) 0);
    public Map<String, Set<Integer>> sIx = new HashMap();
    public C22430e sIy;
    public C22429d sIz;
    String userName;

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$c */
    public interface C22428c {
        void cHy();
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$d */
    public interface C22429d {
        void arL();
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$e */
    public interface C22430e {
        void cHz();
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$j */
    public class C22431j implements Runnable {
        private C22431j() {
        }

        public /* synthetic */ C22431j(C43709a c43709a, byte b) {
            this();
        }

        public final void run() {
            long anU;
            AppMethodBeat.m2504i(25978);
            C43709a.this.mo69396mf(false);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long anU2 = C5046bo.anU();
            C4990ab.m7416i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(anU2)));
            for (Entry entry : C43709a.this.sIx.entrySet()) {
                C43708i c43708i = new C43708i((String) entry.getKey());
                if (C43709a.sIt != null) {
                    C43709a.sIt.execute(c43708i);
                }
                C40005a c40005a = new C40005a((String) entry.getKey(), (Set) entry.getValue());
                if (C43709a.sIt != null) {
                    C43709a.sIt.execute(c40005a);
                }
            }
            while (!C43709a.this.cHu() && C43709a.sIt.getActiveCount() > 0) {
                C4990ab.m7410d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(C43709a.sIt.getActiveCount()));
                anU = C5046bo.anU();
                if (anU - anU2 >= 120000) {
                    C4990ab.m7416i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((anU - anU2) / 1000));
                    C43709a.this.mo69396mf(true);
                    C43709a.this.stop();
                    if (C43709a.this.sIy != null) {
                        C43709a.this.sIy.cHz();
                    }
                    AppMethodBeat.m2505o(25978);
                    return;
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                }
            }
            anU = C5046bo.anU();
            C4990ab.m7416i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(anU)));
            C4990ab.m7416i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((anU - anU2) / 1000));
            if (!(C43709a.this.sIz == null || C43709a.this.cHu())) {
                C43709a.this.sIz.arL();
            }
            AppMethodBeat.m2505o(25978);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$b */
    public interface C29465b {
        void cHx();
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$a */
    class C40005a implements Runnable {
        /* renamed from: ip */
        private String f16188ip;
        private Set<Integer> sIC;

        public C40005a(String str, Set<Integer> set) {
            this.f16188ip = str;
            this.sIC = set;
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x0231 A:{SYNTHETIC, Splitter:B:47:0x0231} */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0026 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x010f A:{SYNTHETIC, Splitter:B:19:0x010f} */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x0026 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0187 A:{SYNTHETIC, Splitter:B:29:0x0187} */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0026 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x01ff A:{SYNTHETIC, Splitter:B:39:0x01ff} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            IOException e;
            UnknownHostException e2;
            Throwable th;
            Exception e3;
            AppMethodBeat.m2504i(25972);
            C43709a.this.mo69391a(this.f16188ip, String.format("connect %s: ", new Object[]{this.f16188ip}), Integer.valueOf(1));
            for (Integer num : this.sIC) {
                C43709a c43709a = C43709a.this;
                String str = this.f16188ip;
                int intValue = num.intValue();
                Socket socket;
                try {
                    socket = new Socket();
                    try {
                        socket.setSoTimeout(5000);
                        long anU = C5046bo.anU();
                        socket.connect(new InetSocketAddress(str, intValue));
                        long anU2 = C5046bo.anU();
                        C4990ab.m7416i("MicroMsg.MMTraceRoute", "connect success" + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + intValue);
                        c43709a.mo69391a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(anU2 - anU)}), Integer.valueOf(1));
                        try {
                            socket.close();
                        } catch (IOException e4) {
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "close err: " + e4.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e4, "", new Object[0]);
                        }
                    } catch (UnknownHostException e5) {
                        e2 = e5;
                        try {
                            c43709a.mo69391a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                            if (socket == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (IOException e6) {
                                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "close err: " + e6.getMessage());
                                    C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e6, "", new Object[0]);
                                }
                            }
                            AppMethodBeat.m2505o(25972);
                            throw th;
                        }
                    } catch (IOException e7) {
                        e4 = e7;
                        c43709a.mo69391a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e4.toString()}), Integer.valueOf(1));
                        C4990ab.m7412e("MicroMsg.MMTraceRoute", "connect err:" + e4.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e4, "", new Object[0]);
                        if (socket == null) {
                        }
                    } catch (Exception e8) {
                        e3 = e8;
                        c43709a.mo69391a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e3.toString()}), Integer.valueOf(1));
                        C4990ab.m7412e("MicroMsg.MMTraceRoute", "connect err:" + e3.toString());
                        C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e3, "", new Object[0]);
                        if (socket == null) {
                        }
                    }
                } catch (UnknownHostException e9) {
                    e2 = e9;
                    socket = null;
                    c43709a.mo69391a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    if (socket == null) {
                        try {
                            socket.close();
                        } catch (IOException e42) {
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "close err: " + e42.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e42, "", new Object[0]);
                        }
                    }
                } catch (IOException e10) {
                    e42 = e10;
                    socket = null;
                    c43709a.mo69391a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e42.toString()}), Integer.valueOf(1));
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "connect err:" + e42.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e42, "", new Object[0]);
                    if (socket == null) {
                        try {
                            socket.close();
                        } catch (IOException e422) {
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "close err: " + e422.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e422, "", new Object[0]);
                        }
                    }
                } catch (Exception e11) {
                    e3 = e11;
                    socket = null;
                    c43709a.mo69391a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e3.toString()}), Integer.valueOf(1));
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "connect err:" + e3.toString());
                    C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e3, "", new Object[0]);
                    if (socket == null) {
                        try {
                            socket.close();
                        } catch (IOException e4222) {
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "close err: " + e4222.getMessage());
                            C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e4222, "", new Object[0]);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    socket = null;
                    if (socket != null) {
                    }
                    AppMethodBeat.m2505o(25972);
                    throw th;
                }
            }
            C43709a.this.mo69391a(this.f16188ip, IOUtils.LINE_SEPARATOR_UNIX, Integer.valueOf(1));
            AppMethodBeat.m2505o(25972);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$f */
    class C43705f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {

        /* renamed from: com.tencent.mm.plugin.traceroute.b.a$f$1 */
        class C400061 implements Runnable {
            final /* synthetic */ int sIE;
            final /* synthetic */ String sIF;
            final /* synthetic */ PByteArray sIG;

            C400061(int i, String str, PByteArray pByteArray) {
                this.sIE = i;
                this.sIF = str;
                this.sIG = pByteArray;
            }

            public final void run() {
                AppMethodBeat.m2504i(25973);
                String str = "http://" + C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
                stringBuffer.append(Integer.toHexString(C7243d.vxo));
                stringBuffer.append("&devicetype=");
                stringBuffer.append(C7243d.eSg);
                stringBuffer.append("&filelength=");
                stringBuffer.append(this.sIE);
                stringBuffer.append("&sum=");
                stringBuffer.append(this.sIF);
                stringBuffer.append("&reporttype=");
                stringBuffer.append(4);
                if (!(C43709a.this.userName == null || C43709a.this.userName.equals(""))) {
                    stringBuffer.append("&username=");
                    stringBuffer.append(C43709a.this.userName);
                }
                C4990ab.m7410d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
                C43705f.m78315a(C43705f.this, stringBuffer.toString(), this.sIG.value);
                AppMethodBeat.m2505o(25973);
            }
        }

        private C43705f() {
        }

        /* synthetic */ C43705f(C43709a c43709a, byte b) {
            this();
        }

        /* renamed from: a */
        static /* synthetic */ void m78315a(C43705f c43705f, String str, byte[] bArr) {
            AppMethodBeat.m2504i(25974);
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(str);
                    try {
                        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(bArr);
                        byteArrayEntity.setContentType("binary/octet-stream");
                        httpPost.setEntity(byteArrayEntity);
                        C4990ab.m7416i("MicroMsg.MMTraceRoute", "http pose returnContent : ".concat(String.valueOf(C5046bo.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()))));
                        C43709a c43709a = C43709a.this;
                        if (c43709a.sIA != null) {
                            c43709a.sIA.cHy();
                        }
                        AppMethodBeat.m2505o(25974);
                        return;
                    } catch (IllegalStateException e) {
                        C4990ab.m7412e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                        i = i2;
                    } catch (IOException e2) {
                        C4990ab.m7412e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                        C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        i = i2;
                    }
                } else {
                    C43709a.this.cHw();
                    AppMethodBeat.m2505o(25974);
                    return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$g */
    class C43706g implements Runnable {
        private String sII;
        private boolean sIJ;
        private Integer sIK;
        private String serverIP;

        public C43706g(String str, String str2, boolean z, Integer num) {
            this.sII = str;
            this.serverIP = str2;
            this.sIJ = z;
            this.sIK = num;
        }

        public final void run() {
            AppMethodBeat.m2504i(25975);
            C43709a c43709a = C43709a.this;
            String str = this.sII;
            String str2 = this.serverIP;
            Integer num = this.sIK;
            for (int i = 1; i <= 3; i++) {
                List J = C40007b.m68509J(new String[]{"ping", "-c 1", "-t 64", str});
                if (J.size() == 2) {
                    String str3 = (String) J.get(0);
                    if (C5046bo.isNullOrNil(str3)) {
                        C4990ab.m7412e("MicroMsg.MMTraceRoute", "runcommand err ".concat(String.valueOf(str)));
                        c43709a.mo69391a(str2, "run command err ", num);
                    } else {
                        String obj = J.get(1).toString();
                        if (C40007b.abP(str3) > 0) {
                            if (!C5046bo.isNullOrNil(C40007b.abO(str3))) {
                                str3 = String.format(" %sms ", new Object[]{C40007b.abO(str3)});
                            } else if (C5046bo.isNullOrNil(obj)) {
                                str3 = String.format("unable to get time", new Object[0]);
                            } else {
                                str3 = String.format(" %sms ", new Object[]{obj});
                            }
                        } else {
                            str3 = String.format(" router no response ", new Object[0]);
                        }
                        if (i == 3) {
                            str3 = str3 + IOUtils.LINE_SEPARATOR_UNIX;
                        }
                        c43709a.mo69391a(str2, str3, num);
                    }
                } else if (i == 3) {
                    c43709a.mo69391a(str2, " router no response\n", num);
                } else {
                    c43709a.mo69391a(str2, " router no response", num);
                }
            }
            AppMethodBeat.m2505o(25975);
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$h */
    class C43707h implements Runnable {
        /* renamed from: ip */
        private String f17220ip;
        private int sIL;

        public C43707h(String str, int i) {
            this.f17220ip = str;
            this.sIL = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x018f  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x018f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            int i = 1;
            AppMethodBeat.m2504i(25976);
            C4990ab.m7416i("MicroMsg.MMTraceRoute", "ttl= " + this.sIL);
            C43709a c43709a = C43709a.this;
            String str = this.f17220ip;
            int i2 = this.sIL;
            List J = C40007b.m68509J(new String[]{"ping", "-c 1", "-t " + String.valueOf(i2), str});
            if (J.size() != 2) {
                c43709a.mo69391a(str, String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i2)}), Integer.valueOf(i2 + 1));
            } else {
                String str2 = (String) J.get(0);
                if (str2.length() == 0) {
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "runcommand err");
                } else {
                    String str3;
                    int indexOf = str2.indexOf("From ");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("from ");
                        if (indexOf < 0) {
                            str3 = null;
                            if (C5046bo.isNullOrNil(str3)) {
                                if (C40007b.abP(str2) <= 0) {
                                    str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i2)});
                                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "can not get route ip and ttl".concat(String.valueOf(str)));
                                    c43709a.mo69391a(str, str2, Integer.valueOf(i2 + 1));
                                }
                                if (i != 0) {
                                    AppMethodBeat.m2505o(25976);
                                    return;
                                } else {
                                    AppMethodBeat.m2505o(25976);
                                    return;
                                }
                            }
                            if (str.equals(str3)) {
                                c43709a.mo69391a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i2), str3}), Integer.valueOf(i2 + 1));
                            } else if (C40007b.abP(str2) > 0) {
                                c43709a.mo69391a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i2), str3}), Integer.valueOf(i2 + 1));
                                if (C43709a.sIt != null) {
                                    C43709a.sIt.execute(new C43706g(str3, str, true, Integer.valueOf(i2 + 1)));
                                }
                            } else {
                                c43709a.mo69391a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i2), str3}), Integer.valueOf(i2 + 1));
                                if (C43709a.sIt != null) {
                                    C43709a.sIt.execute(new C43706g(str3, str, false, Integer.valueOf(i2 + 1)));
                                }
                            }
                            if (i != 0) {
                            }
                        }
                    }
                    int indexOf2 = str2.indexOf(" ", indexOf);
                    if (indexOf2 < 0) {
                        indexOf = str2.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, indexOf);
                        if (indexOf < 0) {
                            str3 = null;
                            if (C5046bo.isNullOrNil(str3)) {
                            }
                        }
                    } else {
                        indexOf = indexOf2;
                    }
                    indexOf++;
                    indexOf2 = str2.indexOf(" ", indexOf);
                    if (indexOf2 < 0) {
                        str3 = null;
                    } else {
                        str3 = str2.substring(indexOf, indexOf2).replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "");
                    }
                    if (C5046bo.isNullOrNil(str3)) {
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.traceroute.b.a$i */
    class C43708i implements Runnable {
        /* renamed from: ip */
        private String f17221ip;

        public C43708i(String str) {
            this.f17221ip = str;
        }

        public final void run() {
            int i = 1;
            AppMethodBeat.m2504i(25977);
            List J = C40007b.m68509J(new String[]{"ping", "-c 1", "-t 64", this.f17221ip});
            if (J.size() != 2) {
                C43709a.this.mo69391a(this.f17221ip, "failed to ping: \n" + this.f17221ip, Integer.valueOf(0));
                AppMethodBeat.m2505o(25977);
                return;
            }
            String str = (String) J.get(0);
            if (C5046bo.isNullOrNil(str)) {
                C43709a.this.mo69391a(this.f17221ip, "failed to ping: \n" + this.f17221ip, Integer.valueOf(0));
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "runcommand err");
                AppMethodBeat.m2505o(25977);
                return;
            }
            int abP = C40007b.abP(str);
            if (abP <= 0) {
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.f17221ip);
                C43709a.this.mo69391a(this.f17221ip, "failed to touch server: " + this.f17221ip + IOUtils.LINE_SEPARATOR_UNIX, Integer.valueOf(0));
                AppMethodBeat.m2505o(25977);
                return;
            }
            String obj = J.get(1).toString();
            if (!C5046bo.isNullOrNil(C40007b.abO(str))) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.f17221ip, Integer.valueOf(abP), C40007b.abO(str)});
            } else if (C5046bo.isNullOrNil(obj)) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.f17221ip, Integer.valueOf(abP), "unknown"});
            } else {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.f17221ip, Integer.valueOf(abP), obj});
            }
            C43709a.this.mo69391a(this.f17221ip, str + IOUtils.LINE_SEPARATOR_UNIX, Integer.valueOf(0));
            int i2 = (64 - abP) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            while (i < i2 && !C43709a.this.cHu()) {
                C43707h c43707h = new C43707h(this.f17221ip, i);
                if (C43709a.sIt != null) {
                    C43709a.sIt.execute(c43707h);
                }
                i++;
            }
            AppMethodBeat.m2505o(25977);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean cHu() {
        return this.sIv;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: mf */
    public final synchronized void mo69396mf(boolean z) {
        this.sIv = z;
    }

    public C43709a(String str) {
        AppMethodBeat.m2504i(25979);
        this.userName = str;
        sIs = C1448h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
        AppMethodBeat.m2505o(25979);
    }

    public final void stop() {
        AppMethodBeat.m2504i(25980);
        mo69396mf(true);
        if (sIt != null) {
            try {
                sIt.shutdownNow();
                AppMethodBeat.m2505o(25980);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(25980);
    }

    /* renamed from: c */
    public final void mo69392c(String[] strArr, boolean z) {
        AppMethodBeat.m2504i(25981);
        if (strArr == null || strArr.length == 0) {
            C4990ab.m7412e("MicroMsg.MMTraceRoute", "no ip contains");
            AppMethodBeat.m2505o(25981);
            return;
        }
        String str = "";
        if (z) {
            str = str + "long: ";
        } else {
            str = str + "short: ";
        }
        int length = strArr.length;
        int i = 0;
        String str2 = str;
        while (i < length) {
            str = strArr[i];
            String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            if (split == null || split.length != 3) {
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "err ip ".concat(String.valueOf(str)));
                str = str2;
            } else if (this.sIx.containsKey(split[0])) {
                ((Set) this.sIx.get(split[0])).add(Integer.valueOf(C5046bo.getInt(split[1], 0)));
                str = str2;
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(Integer.valueOf(C5046bo.getInt(split[1], 0)));
                this.sIx.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        C1173e.m2568e(sIs, (str2 + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
        AppMethodBeat.m2505o(25981);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo69391a(String str, String str2, Integer num) {
        AppMethodBeat.m2504i(25982);
        if (str == null || str2 == null || num.intValue() < 0) {
            AppMethodBeat.m2505o(25982);
        } else if (!this.sIw.containsKey(str)) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(num, new StringBuilder(str2));
            this.sIw.put(str, concurrentHashMap);
            AppMethodBeat.m2505o(25982);
        } else if (((ConcurrentHashMap) this.sIw.get(str)).containsKey(num)) {
            ((StringBuilder) ((ConcurrentHashMap) this.sIw.get(str)).get(num)).append(str2);
            AppMethodBeat.m2505o(25982);
        } else {
            new ConcurrentHashMap().put(num, new StringBuilder(str2));
            ((ConcurrentHashMap) this.sIw.get(str)).put(num, new StringBuilder(str2));
            AppMethodBeat.m2505o(25982);
        }
    }

    public final synchronized void cHv() {
        AppMethodBeat.m2504i(25983);
        if (this.sIw != null) {
            String str;
            C43705f c43705f = this.sIw;
            File file = new File(sIs);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    C1173e.m2568e(sIs, (C43709a.this.userName + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                } catch (IOException e) {
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    C43709a.this.cHw();
                    AppMethodBeat.m2505o(25983);
                }
            }
            for (Entry key : C43709a.this.sIw.entrySet()) {
                String str2 = (String) key.getKey();
                if (!C5046bo.isNullOrNil(str2) && C43709a.this.sIw.containsKey(str2)) {
                    Map map = (Map) C43709a.this.sIw.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!C5046bo.isNullOrNil(stringBuilder)) {
                                        str = str3 + stringBuilder;
                                        if (stringBuilder.contains("FIN")) {
                                            obj = 1;
                                        }
                                        i++;
                                        str3 = str;
                                    }
                                }
                                str = str3;
                                i++;
                                str3 = str;
                            }
                        } else {
                            str3 = str3 + ((StringBuilder) map.get(Integer.valueOf(1))).toString();
                        }
                        if (str3.length() > 0) {
                            C4990ab.m7416i("MicroMsg.MMTraceRoute", str2 + str3);
                            C1173e.m2568e(sIs, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] e2 = C1173e.m2569e(sIs, 0, -1);
            if (C5046bo.m7540cb(e2)) {
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "read log failed");
                C43709a.this.cHw();
                AppMethodBeat.m2505o(25983);
            } else {
                str = C1178g.m2591x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(C7243d.vxo), Integer.valueOf(e2.length)}).getBytes()).toLowerCase();
                e2 = C1184r.compress(e2);
                PByteArray pByteArray = new PByteArray();
                C1171c.m2554a(pByteArray, e2, str.getBytes());
                C7305d.post(new C400061(r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        AppMethodBeat.m2505o(25983);
        return;
    }

    /* Access modifiers changed, original: final */
    public final void cHw() {
        AppMethodBeat.m2504i(25984);
        if (this.sIB != null) {
            this.sIB.cHx();
        }
        AppMethodBeat.m2505o(25984);
    }
}
