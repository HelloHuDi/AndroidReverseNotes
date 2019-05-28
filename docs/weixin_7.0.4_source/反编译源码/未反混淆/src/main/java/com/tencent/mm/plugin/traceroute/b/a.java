package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
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

public final class a {
    public static String sIs;
    public static c sIt;
    private final String TAG = "MicroMsg.MMTraceRoute";
    public c sIA;
    public b sIB;
    private final int sIu = 64;
    private boolean sIv = false;
    f sIw = new f(this, (byte) 0);
    public Map<String, Set<Integer>> sIx = new HashMap();
    public e sIy;
    public d sIz;
    String userName;

    public interface c {
        void cHy();
    }

    public interface d {
        void arL();
    }

    public interface e {
        void cHz();
    }

    public class j implements Runnable {
        private j() {
        }

        public /* synthetic */ j(a aVar, byte b) {
            this();
        }

        public final void run() {
            long anU;
            AppMethodBeat.i(25978);
            a.this.mf(false);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long anU2 = bo.anU();
            ab.i("MicroMsg.MMTraceRoute", "mmtraceroute start time " + simpleDateFormat.format(new Date(anU2)));
            for (Entry entry : a.this.sIx.entrySet()) {
                i iVar = new i((String) entry.getKey());
                if (a.sIt != null) {
                    a.sIt.execute(iVar);
                }
                a aVar = new a((String) entry.getKey(), (Set) entry.getValue());
                if (a.sIt != null) {
                    a.sIt.execute(aVar);
                }
            }
            while (!a.this.cHu() && a.sIt.getActiveCount() > 0) {
                ab.d("MicroMsg.MMTraceRoute", "task count: " + String.valueOf(a.sIt.getActiveCount()));
                anU = bo.anU();
                if (anU - anU2 >= 120000) {
                    ab.i("MicroMsg.MMTraceRoute", "traceroute timeout: " + ((anU - anU2) / 1000));
                    a.this.mf(true);
                    a.this.stop();
                    if (a.this.sIy != null) {
                        a.this.sIy.cHz();
                    }
                    AppMethodBeat.o(25978);
                    return;
                }
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    ab.e("MicroMsg.MMTraceRoute", "wait for command end err: " + e.getMessage());
                    ab.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                }
            }
            anU = bo.anU();
            ab.i("MicroMsg.MMTraceRoute", "mmtraceroute end time " + simpleDateFormat.format(new java.util.Date(anU)));
            ab.i("MicroMsg.MMTraceRoute", "mmtraceroute total time " + ((anU - anU2) / 1000));
            if (!(a.this.sIz == null || a.this.cHu())) {
                a.this.sIz.arL();
            }
            AppMethodBeat.o(25978);
        }
    }

    public interface b {
        void cHx();
    }

    class a implements Runnable {
        private String ip;
        private Set<Integer> sIC;

        public a(String str, Set<Integer> set) {
            this.ip = str;
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
            AppMethodBeat.i(25972);
            a.this.a(this.ip, String.format("connect %s: ", new Object[]{this.ip}), Integer.valueOf(1));
            for (Integer num : this.sIC) {
                a aVar = a.this;
                String str = this.ip;
                int intValue = num.intValue();
                Socket socket;
                try {
                    socket = new Socket();
                    try {
                        socket.setSoTimeout(5000);
                        long anU = bo.anU();
                        socket.connect(new InetSocketAddress(str, intValue));
                        long anU2 = bo.anU();
                        ab.i("MicroMsg.MMTraceRoute", "connect success" + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + intValue);
                        aVar.a(str, String.format("port = %d, time = %dms ", new Object[]{Integer.valueOf(intValue), Long.valueOf(anU2 - anU)}), Integer.valueOf(1));
                        try {
                            socket.close();
                        } catch (IOException e4) {
                            ab.e("MicroMsg.MMTraceRoute", "close err: " + e4.getMessage());
                            ab.printErrStackTrace("MicroMsg.MMTraceRoute", e4, "", new Object[0]);
                        }
                    } catch (UnknownHostException e5) {
                        e2 = e5;
                        try {
                            aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                            ab.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                            ab.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                            if (socket == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (socket != null) {
                                try {
                                    socket.close();
                                } catch (IOException e6) {
                                    ab.e("MicroMsg.MMTraceRoute", "close err: " + e6.getMessage());
                                    ab.printErrStackTrace("MicroMsg.MMTraceRoute", e6, "", new Object[0]);
                                }
                            }
                            AppMethodBeat.o(25972);
                            throw th;
                        }
                    } catch (IOException e7) {
                        e4 = e7;
                        aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e4.toString()}), Integer.valueOf(1));
                        ab.e("MicroMsg.MMTraceRoute", "connect err:" + e4.getMessage());
                        ab.printErrStackTrace("MicroMsg.MMTraceRoute", e4, "", new Object[0]);
                        if (socket == null) {
                        }
                    } catch (Exception e8) {
                        e3 = e8;
                        aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e3.toString()}), Integer.valueOf(1));
                        ab.e("MicroMsg.MMTraceRoute", "connect err:" + e3.toString());
                        ab.printErrStackTrace("MicroMsg.MMTraceRoute", e3, "", new Object[0]);
                        if (socket == null) {
                        }
                    }
                } catch (UnknownHostException e9) {
                    e2 = e9;
                    socket = null;
                    aVar.a(str, String.format("connect err; UnknownHostException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e2.toString()}), Integer.valueOf(1));
                    ab.e("MicroMsg.MMTraceRoute", "connect err: " + e2.getMessage());
                    ab.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                    if (socket == null) {
                        try {
                            socket.close();
                        } catch (IOException e42) {
                            ab.e("MicroMsg.MMTraceRoute", "close err: " + e42.getMessage());
                            ab.printErrStackTrace("MicroMsg.MMTraceRoute", e42, "", new Object[0]);
                        }
                    }
                } catch (IOException e10) {
                    e42 = e10;
                    socket = null;
                    aVar.a(str, String.format("connect err; IOException: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e42.toString()}), Integer.valueOf(1));
                    ab.e("MicroMsg.MMTraceRoute", "connect err:" + e42.getMessage());
                    ab.printErrStackTrace("MicroMsg.MMTraceRoute", e42, "", new Object[0]);
                    if (socket == null) {
                        try {
                            socket.close();
                        } catch (IOException e422) {
                            ab.e("MicroMsg.MMTraceRoute", "close err: " + e422.getMessage());
                            ab.printErrStackTrace("MicroMsg.MMTraceRoute", e422, "", new Object[0]);
                        }
                    }
                } catch (Exception e11) {
                    e3 = e11;
                    socket = null;
                    aVar.a(str, String.format("connect err; Exception: port = %d, errmsg: %s", new Object[]{Integer.valueOf(intValue), e3.toString()}), Integer.valueOf(1));
                    ab.e("MicroMsg.MMTraceRoute", "connect err:" + e3.toString());
                    ab.printErrStackTrace("MicroMsg.MMTraceRoute", e3, "", new Object[0]);
                    if (socket == null) {
                        try {
                            socket.close();
                        } catch (IOException e4222) {
                            ab.e("MicroMsg.MMTraceRoute", "close err: " + e4222.getMessage());
                            ab.printErrStackTrace("MicroMsg.MMTraceRoute", e4222, "", new Object[0]);
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    socket = null;
                    if (socket != null) {
                    }
                    AppMethodBeat.o(25972);
                    throw th;
                }
            }
            a.this.a(this.ip, IOUtils.LINE_SEPARATOR_UNIX, Integer.valueOf(1));
            AppMethodBeat.o(25972);
        }
    }

    class f extends ConcurrentHashMap<String, ConcurrentHashMap<Integer, StringBuilder>> {

        /* renamed from: com.tencent.mm.plugin.traceroute.b.a$f$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ int sIE;
            final /* synthetic */ String sIF;
            final /* synthetic */ PByteArray sIG;

            AnonymousClass1(int i, String str, PByteArray pByteArray) {
                this.sIE = i;
                this.sIF = str;
                this.sIG = pByteArray;
            }

            public final void run() {
                AppMethodBeat.i(25973);
                String str = "http://" + ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str + "/cgi-bin/mmsupport-bin/stackreport?version=");
                stringBuffer.append(Integer.toHexString(com.tencent.mm.protocal.d.vxo));
                stringBuffer.append("&devicetype=");
                stringBuffer.append(com.tencent.mm.protocal.d.eSg);
                stringBuffer.append("&filelength=");
                stringBuffer.append(this.sIE);
                stringBuffer.append("&sum=");
                stringBuffer.append(this.sIF);
                stringBuffer.append("&reporttype=");
                stringBuffer.append(4);
                if (!(a.this.userName == null || a.this.userName.equals(""))) {
                    stringBuffer.append("&username=");
                    stringBuffer.append(a.this.userName);
                }
                ab.d("MicroMsg.MMTraceRoute", "traceroute report url:" + stringBuffer.toString());
                f.a(f.this, stringBuffer.toString(), this.sIG.value);
                AppMethodBeat.o(25973);
            }
        }

        private f() {
        }

        /* synthetic */ f(a aVar, byte b) {
            this();
        }

        static /* synthetic */ void a(f fVar, String str, byte[] bArr) {
            AppMethodBeat.i(25974);
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
                        ab.i("MicroMsg.MMTraceRoute", "http pose returnContent : ".concat(String.valueOf(bo.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()))));
                        a aVar = a.this;
                        if (aVar.sIA != null) {
                            aVar.sIA.cHy();
                        }
                        AppMethodBeat.o(25974);
                        return;
                    } catch (IllegalStateException e) {
                        ab.e("MicroMsg.MMTraceRoute", "http post IllegalStateException: " + e.getMessage());
                        ab.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                        i = i2;
                    } catch (IOException e2) {
                        ab.e("MicroMsg.MMTraceRoute", "http post IOException: " + e2.getMessage());
                        ab.printErrStackTrace("MicroMsg.MMTraceRoute", e2, "", new Object[0]);
                        i = i2;
                    }
                } else {
                    a.this.cHw();
                    AppMethodBeat.o(25974);
                    return;
                }
            }
        }
    }

    class g implements Runnable {
        private String sII;
        private boolean sIJ;
        private Integer sIK;
        private String serverIP;

        public g(String str, String str2, boolean z, Integer num) {
            this.sII = str;
            this.serverIP = str2;
            this.sIJ = z;
            this.sIK = num;
        }

        public final void run() {
            AppMethodBeat.i(25975);
            a aVar = a.this;
            String str = this.sII;
            String str2 = this.serverIP;
            Integer num = this.sIK;
            for (int i = 1; i <= 3; i++) {
                List J = b.J(new String[]{"ping", "-c 1", "-t 64", str});
                if (J.size() == 2) {
                    String str3 = (String) J.get(0);
                    if (bo.isNullOrNil(str3)) {
                        ab.e("MicroMsg.MMTraceRoute", "runcommand err ".concat(String.valueOf(str)));
                        aVar.a(str2, "run command err ", num);
                    } else {
                        String obj = J.get(1).toString();
                        if (b.abP(str3) > 0) {
                            if (!bo.isNullOrNil(b.abO(str3))) {
                                str3 = String.format(" %sms ", new Object[]{b.abO(str3)});
                            } else if (bo.isNullOrNil(obj)) {
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
                        aVar.a(str2, str3, num);
                    }
                } else if (i == 3) {
                    aVar.a(str2, " router no response\n", num);
                } else {
                    aVar.a(str2, " router no response", num);
                }
            }
            AppMethodBeat.o(25975);
        }
    }

    class h implements Runnable {
        private String ip;
        private int sIL;

        public h(String str, int i) {
            this.ip = str;
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
            AppMethodBeat.i(25976);
            ab.i("MicroMsg.MMTraceRoute", "ttl= " + this.sIL);
            a aVar = a.this;
            String str = this.ip;
            int i2 = this.sIL;
            List J = b.J(new String[]{"ping", "-c 1", "-t " + String.valueOf(i2), str});
            if (J.size() != 2) {
                aVar.a(str, String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i2)}), Integer.valueOf(i2 + 1));
            } else {
                String str2 = (String) J.get(0);
                if (str2.length() == 0) {
                    ab.e("MicroMsg.MMTraceRoute", "runcommand err");
                } else {
                    String str3;
                    int indexOf = str2.indexOf("From ");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf("from ");
                        if (indexOf < 0) {
                            str3 = null;
                            if (bo.isNullOrNil(str3)) {
                                if (b.abP(str2) <= 0) {
                                    str2 = String.format("%d : can not get roupter ip\n", new Object[]{Integer.valueOf(i2)});
                                    ab.e("MicroMsg.MMTraceRoute", "can not get route ip and ttl".concat(String.valueOf(str)));
                                    aVar.a(str, str2, Integer.valueOf(i2 + 1));
                                }
                                if (i != 0) {
                                    AppMethodBeat.o(25976);
                                    return;
                                } else {
                                    AppMethodBeat.o(25976);
                                    return;
                                }
                            }
                            if (str.equals(str3)) {
                                aVar.a(str, String.format("%d : FIN %s\n\n", new Object[]{Integer.valueOf(i2), str3}), Integer.valueOf(i2 + 1));
                            } else if (b.abP(str2) > 0) {
                                aVar.a(str, String.format("%d : FIN %s\n\n ", new Object[]{Integer.valueOf(i2), str3}), Integer.valueOf(i2 + 1));
                                if (a.sIt != null) {
                                    a.sIt.execute(new g(str3, str, true, Integer.valueOf(i2 + 1)));
                                }
                            } else {
                                aVar.a(str, String.format("%d : %s", new Object[]{Integer.valueOf(i2), str3}), Integer.valueOf(i2 + 1));
                                if (a.sIt != null) {
                                    a.sIt.execute(new g(str3, str, false, Integer.valueOf(i2 + 1)));
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
                            if (bo.isNullOrNil(str3)) {
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
                    if (bo.isNullOrNil(str3)) {
                    }
                }
            }
            i = 0;
            if (i != 0) {
            }
        }
    }

    class i implements Runnable {
        private String ip;

        public i(String str) {
            this.ip = str;
        }

        public final void run() {
            int i = 1;
            AppMethodBeat.i(25977);
            List J = b.J(new String[]{"ping", "-c 1", "-t 64", this.ip});
            if (J.size() != 2) {
                a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                AppMethodBeat.o(25977);
                return;
            }
            String str = (String) J.get(0);
            if (bo.isNullOrNil(str)) {
                a.this.a(this.ip, "failed to ping: \n" + this.ip, Integer.valueOf(0));
                ab.e("MicroMsg.MMTraceRoute", "runcommand err");
                AppMethodBeat.o(25977);
                return;
            }
            int abP = b.abP(str);
            if (abP <= 0) {
                ab.e("MicroMsg.MMTraceRoute", "failed to touch server:" + this.ip);
                a.this.a(this.ip, "failed to touch server: " + this.ip + IOUtils.LINE_SEPARATOR_UNIX, Integer.valueOf(0));
                AppMethodBeat.o(25977);
                return;
            }
            String obj = J.get(1).toString();
            if (!bo.isNullOrNil(b.abO(str))) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(abP), b.abO(str)});
            } else if (bo.isNullOrNil(obj)) {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(abP), "unknown"});
            } else {
                str = String.format("server: %s, TTL: %d, Time = %sms", new Object[]{this.ip, Integer.valueOf(abP), obj});
            }
            a.this.a(this.ip, str + IOUtils.LINE_SEPARATOR_UNIX, Integer.valueOf(0));
            int i2 = (64 - abP) + 5;
            if (i2 < 0) {
                i2 = 64;
            }
            while (i < i2 && !a.this.cHu()) {
                h hVar = new h(this.ip, i);
                if (a.sIt != null) {
                    a.sIt.execute(hVar);
                }
                i++;
            }
            AppMethodBeat.o(25977);
        }
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized boolean cHu() {
        return this.sIv;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void mf(boolean z) {
        this.sIv = z;
    }

    public a(String str) {
        AppMethodBeat.i(25979);
        this.userName = str;
        sIs = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()).toString() + ".log";
        AppMethodBeat.o(25979);
    }

    public final void stop() {
        AppMethodBeat.i(25980);
        mf(true);
        if (sIt != null) {
            try {
                sIt.shutdownNow();
                AppMethodBeat.o(25980);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
        AppMethodBeat.o(25980);
    }

    public final void c(String[] strArr, boolean z) {
        AppMethodBeat.i(25981);
        if (strArr == null || strArr.length == 0) {
            ab.e("MicroMsg.MMTraceRoute", "no ip contains");
            AppMethodBeat.o(25981);
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
                ab.e("MicroMsg.MMTraceRoute", "err ip ".concat(String.valueOf(str)));
                str = str2;
            } else if (this.sIx.containsKey(split[0])) {
                ((Set) this.sIx.get(split[0])).add(Integer.valueOf(bo.getInt(split[1], 0)));
                str = str2;
            } else {
                HashSet hashSet = new HashSet();
                hashSet.add(Integer.valueOf(bo.getInt(split[1], 0)));
                this.sIx.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        com.tencent.mm.a.e.e(sIs, (str2 + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
        AppMethodBeat.o(25981);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(String str, String str2, Integer num) {
        AppMethodBeat.i(25982);
        if (str == null || str2 == null || num.intValue() < 0) {
            AppMethodBeat.o(25982);
        } else if (!this.sIw.containsKey(str)) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.put(num, new StringBuilder(str2));
            this.sIw.put(str, concurrentHashMap);
            AppMethodBeat.o(25982);
        } else if (((ConcurrentHashMap) this.sIw.get(str)).containsKey(num)) {
            ((StringBuilder) ((ConcurrentHashMap) this.sIw.get(str)).get(num)).append(str2);
            AppMethodBeat.o(25982);
        } else {
            new ConcurrentHashMap().put(num, new StringBuilder(str2));
            ((ConcurrentHashMap) this.sIw.get(str)).put(num, new StringBuilder(str2));
            AppMethodBeat.o(25982);
        }
    }

    public final synchronized void cHv() {
        AppMethodBeat.i(25983);
        if (this.sIw != null) {
            String str;
            f fVar = this.sIw;
            File file = new File(sIs);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    com.tencent.mm.a.e.e(sIs, (a.this.userName + IOUtils.LINE_SEPARATOR_UNIX).getBytes());
                } catch (IOException e) {
                    ab.e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    ab.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    a.this.cHw();
                    AppMethodBeat.o(25983);
                }
            }
            for (Entry key : a.this.sIw.entrySet()) {
                String str2 = (String) key.getKey();
                if (!bo.isNullOrNil(str2) && a.this.sIw.containsKey(str2)) {
                    Map map = (Map) a.this.sIw.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!bo.isNullOrNil(stringBuilder)) {
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
                            ab.i("MicroMsg.MMTraceRoute", str2 + str3);
                            com.tencent.mm.a.e.e(sIs, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] e2 = com.tencent.mm.a.e.e(sIs, 0, -1);
            if (bo.cb(e2)) {
                ab.e("MicroMsg.MMTraceRoute", "read log failed");
                a.this.cHw();
                AppMethodBeat.o(25983);
            } else {
                str = com.tencent.mm.a.g.x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vxo), Integer.valueOf(e2.length)}).getBytes()).toLowerCase();
                e2 = r.compress(e2);
                PByteArray pByteArray = new PByteArray();
                com.tencent.mm.a.c.a(pByteArray, e2, str.getBytes());
                com.tencent.mm.sdk.g.d.post(new AnonymousClass1(r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        AppMethodBeat.o(25983);
        return;
    }

    /* Access modifiers changed, original: final */
    public final void cHw() {
        AppMethodBeat.i(25984);
        if (this.sIB != null) {
            this.sIB.cHx();
        }
        AppMethodBeat.o(25984);
    }
}
