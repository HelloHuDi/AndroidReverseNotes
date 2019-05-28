package com.tencent.p177mm.plugin.clean.p362c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C11387b;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C33819a;
import com.tencent.p177mm.plugin.clean.p362c.p363a.C33819a.C33820a;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.wav.WavFileHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.clean.c.c */
public final class C20227c implements C33820a, Runnable {
    private static final Long clo = Long.valueOf(604800000);
    private static final Long kvU = Long.valueOf(7776000000L);
    private static final int kwg = (C18628c.getAccPath().length() - 1);
    private long endTime = 0;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    public boolean isStop;
    private long kvW;
    private long kvX;
    private C11387b kwh;
    private C33823g kwi;
    private int kwj = 0;
    private int kwk = 0;
    private ConcurrentHashMap<String, C27641b> kwl = new ConcurrentHashMap();
    private long kwm;
    private long kwn;
    private HashSet<String> kwo = new HashSet();
    private HashSet<String> kwp = new HashSet();
    private boolean kwq = true;
    private int[] kwr = new int[10];
    private long startTime = 0;

    /* renamed from: com.tencent.mm.plugin.clean.c.c$2 */
    class C28072 implements Runnable {
        C28072() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18668);
            C20227c.this.kwi.mo45501dO(C20227c.this.kwk, C20227c.this.kwj);
            AppMethodBeat.m2505o(18668);
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.c.c$b */
    class C20228b extends C33819a {
        private String filePath;
        private long fileSize;
        int kwu = 0;

        public C20228b(String str) {
            super(C20227c.this);
            this.filePath = str;
            this.fileSize = 0;
        }

        public final String alb() {
            AppMethodBeat.m2504i(18672);
            String str = "filePath[" + this.filePath + "] scanCount[" + this.kwu + "]" + super.alb();
            AppMethodBeat.m2505o(18672);
            return str;
        }

        public final void execute() {
            String str;
            int[] l;
            AppMethodBeat.m2504i(18673);
            if (C20228b.m31293HT(this.filePath) && C20227c.this.kwq) {
                C4990ab.m7417i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", Boolean.valueOf(C20227c.this.kwq), this.filePath);
                m31292HS(this.filePath);
                C5728b dMC = new C5728b(this.filePath).dMC();
                if (dMC.list() == null || dMC.list().length == 0) {
                    dMC.delete();
                }
            } else {
                m31294HU(this.filePath);
            }
            if (C20227c.m31273a(C20227c.this, this.filePath)) {
                C20227c.this.kvX = C20227c.this.kvX + this.fileSize;
            } else {
                str = this.filePath;
                C9638aw.m17190ZK();
                if (str.startsWith(C18628c.getAccPath())) {
                    C20227c.this.kvW = C20227c.this.kvW + this.fileSize;
                }
            }
            if (C20228b.m31293HT(this.filePath)) {
                l = C20227c.this.kwr;
                l[1] = (int) (((long) l[1]) + this.fileSize);
            } else {
                str = this.filePath;
                C9638aw.m17190ZK();
                if (str.startsWith(C18628c.getAccPath())) {
                    l = C20227c.this.kwr;
                    l[0] = (int) (((long) l[0]) + this.fileSize);
                } else {
                    l = C20227c.this.kwr;
                    l[2] = (int) (((long) l[2]) + this.fileSize);
                }
            }
            if (this.filePath.endsWith("/image2")) {
                l = C20227c.this.kwr;
                l[3] = (int) (((long) l[3]) + this.fileSize);
            }
            if (this.filePath.endsWith("/image")) {
                l = C20227c.this.kwr;
                l[4] = (int) (((long) l[4]) + this.fileSize);
            }
            if (this.filePath.endsWith("/video")) {
                l = C20227c.this.kwr;
                l[5] = (int) (((long) l[5]) + this.fileSize);
            }
            if (this.filePath.endsWith("/voice2")) {
                l = C20227c.this.kwr;
                l[6] = (int) (((long) l[6]) + this.fileSize);
            }
            if (this.filePath.endsWith("/WeiXin")) {
                l = C20227c.this.kwr;
                l[7] = (int) (((long) l[7]) + this.fileSize);
            }
            if (this.filePath.endsWith("/WeChat")) {
                l = C20227c.this.kwr;
                l[8] = (int) (((long) l[8]) + this.fileSize);
            }
            if (this.filePath.endsWith("/xlog")) {
                l = C20227c.this.kwr;
                l[9] = (int) (((long) l[9]) + this.fileSize);
            }
            AppMethodBeat.m2505o(18673);
        }

        /* renamed from: HS */
        private void m31292HS(String str) {
            AppMethodBeat.m2504i(18674);
            C5728b c5728b = new C5728b(str);
            if (c5728b.isDirectory()) {
                String[] list = c5728b.list();
                if (list != null) {
                    for (String str2 : list) {
                        m31292HS(str + "/" + str2);
                    }
                }
                C4990ab.m7419v("MicroMsg.CleanController", "delete file rootFile: %s", str);
                c5728b.delete();
                AppMethodBeat.m2505o(18674);
                return;
            }
            C4990ab.m7419v("MicroMsg.CleanController", "delete file rootFile: %s", str);
            C20227c.this.kwm = C20227c.this.kwm + c5728b.length();
            c5728b.delete();
            AppMethodBeat.m2505o(18674);
        }

        /* renamed from: HT */
        private static boolean m31293HT(String str) {
            AppMethodBeat.m2504i(18675);
            if (str.length() <= C20227c.kwg || str.substring(C20227c.kwg).indexOf("temp") != 0) {
                AppMethodBeat.m2505o(18675);
                return false;
            }
            AppMethodBeat.m2505o(18675);
            return true;
        }

        /* renamed from: HU */
        private void m31294HU(String str) {
            int i = 0;
            AppMethodBeat.m2504i(18676);
            this.kwu++;
            if (str.endsWith("/sns")) {
                C4990ab.m7417i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", str);
                m31295HV(str);
                AppMethodBeat.m2505o(18676);
            } else if (str.endsWith("/music")) {
                C4990ab.m7417i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", str);
                m31296HW(str);
                AppMethodBeat.m2505o(18676);
            } else {
                C5728b c5728b = new C5728b(str);
                if (c5728b.isDirectory()) {
                    String[] list = c5728b.list();
                    if (list != null) {
                        int length = list.length;
                        while (i < length) {
                            m31294HU(str + "/" + list[i]);
                            i++;
                        }
                    }
                    AppMethodBeat.m2505o(18676);
                    return;
                }
                long asZ = C5730e.asZ(str);
                C20227c.m31281d(C20227c.this, asZ);
                this.fileSize = asZ + this.fileSize;
                AppMethodBeat.m2505o(18676);
            }
        }

        /* renamed from: HV */
        private void m31295HV(String str) {
            int i = 0;
            AppMethodBeat.m2504i(18677);
            C5728b c5728b = new C5728b(str);
            if (c5728b.isDirectory()) {
                String[] list = c5728b.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        m31295HV(str + "/" + list[i]);
                        i++;
                    }
                }
                AppMethodBeat.m2505o(18677);
            } else if (System.currentTimeMillis() - c5728b.lastModified() <= C20227c.clo.longValue() || !C20227c.this.kwq) {
                long asZ = C5730e.asZ(str);
                C20227c.m31281d(C20227c.this, asZ);
                this.fileSize = asZ + this.fileSize;
                AppMethodBeat.m2505o(18677);
            } else {
                C4990ab.m7419v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", str);
                c5728b.delete();
                AppMethodBeat.m2505o(18677);
            }
        }

        /* renamed from: HW */
        private void m31296HW(String str) {
            int i = 0;
            AppMethodBeat.m2504i(18678);
            C5728b c5728b = new C5728b(str);
            if (c5728b.isDirectory()) {
                String[] list = c5728b.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        m31296HW(str + "/" + list[i]);
                        i++;
                    }
                }
                AppMethodBeat.m2505o(18678);
            } else if (System.currentTimeMillis() - c5728b.lastModified() <= C20227c.kvU.longValue() || !C20227c.this.kwq) {
                long asZ = C5730e.asZ(str);
                C20227c.m31281d(C20227c.this, asZ);
                this.fileSize = asZ + this.fileSize;
                AppMethodBeat.m2505o(18678);
            } else {
                C4990ab.m7419v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", str);
                c5728b.delete();
                AppMethodBeat.m2505o(18678);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.clean.c.c$a */
    public class C20229a extends C33819a {
        private String username;

        public C20229a(String str) {
            super(C20227c.this);
            this.username = str;
        }

        public final String alb() {
            AppMethodBeat.m2504i(18669);
            String str = "username[" + this.username + "]" + super.alb();
            AppMethodBeat.m2505o(18669);
            return str;
        }

        public final void execute() {
            AppMethodBeat.m2504i(18670);
            C9638aw.m17190ZK();
            int Rq = C18628c.m29080XO().mo15263Rq(this.username);
            if (Rq <= 0) {
                C4990ab.m7417i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", this.username, Integer.valueOf(Rq));
                AppMethodBeat.m2505o(18670);
                return;
            }
            C27641b c27641b = new C27641b();
            c27641b.username = this.username;
            c27641b.kwf = new ArrayList();
            c27641b.jrb = 0;
            Cursor cursor = null;
            int i = 0;
            while (i < Rq) {
                try {
                    C9638aw.m17190ZK();
                    cursor = C18628c.m29080XO().mo15296ab(this.username, i, 50);
                    if (cursor == null) {
                        break;
                    }
                    int a = m31297a(cursor, c27641b);
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    if (a <= 0) {
                        break;
                    }
                    i += a;
                    if (C20227c.this.isStop) {
                        break;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.CleanController", e, "execute analyse Task error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.m2505o(18670);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (c27641b.kwf.size() > 0) {
                C20227c.this.kwl.put(this.username, c27641b);
            }
            C4990ab.m7417i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", this.username, Integer.valueOf(Rq), Integer.valueOf(i), Boolean.valueOf(C20227c.this.isStop));
            AppMethodBeat.m2505o(18670);
        }

        /* renamed from: a */
        private int m31297a(Cursor cursor, C27641b c27641b) {
            int i = 0;
            AppMethodBeat.m2504i(18671);
            if (cursor.moveToFirst()) {
                Object obj = null;
                while (!cursor.isAfterLast()) {
                    i++;
                    C7620bi c7620bi = new C7620bi();
                    c7620bi.mo8995d(cursor);
                    switch (C4733l.m7082Kx(c7620bi.getType())) {
                        case 3:
                            obj = C20227c.m31276b(c7620bi, this.username);
                            break;
                        case 43:
                        case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        case 62:
                            obj = C20227c.m31279c(c7620bi, this.username);
                            break;
                        case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                            obj = C20227c.m31272a(c7620bi, this.username);
                            break;
                    }
                    if (obj != null) {
                        c27641b.kwf.add(obj);
                        c27641b.jrb += obj.size;
                        obj = null;
                    }
                    if (cursor.moveToNext()) {
                        if (C20227c.this.isStop) {
                        }
                    }
                    cursor.close();
                    AppMethodBeat.m2505o(18671);
                }
                cursor.close();
                AppMethodBeat.m2505o(18671);
            } else {
                C4990ab.m7411d("MicroMsg.CleanController", "Message count of user:%s is empty", this.username);
                cursor.close();
                AppMethodBeat.m2505o(18671);
            }
            return i;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m31281d(C20227c c20227c, long j) {
        AppMethodBeat.m2504i(18692);
        c20227c.m31286hc(j);
        AppMethodBeat.m2505o(18692);
    }

    static {
        AppMethodBeat.m2504i(18693);
        C9638aw.m17190ZK();
        AppMethodBeat.m2505o(18693);
    }

    public C20227c(C11387b c11387b, C33823g c33823g) {
        AppMethodBeat.m2504i(18679);
        this.kwi = c33823g;
        this.kwh = c11387b;
        AppMethodBeat.m2505o(18679);
    }

    public final void run() {
        int i;
        String str;
        AppMethodBeat.m2504i(18680);
        C4990ab.m7416i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        long yz = C5046bo.m7588yz();
        String str2 = C6457e.eSn;
        C4990ab.m7419v("MicroMsg.CleanController", "root path: %s", str2);
        StringBuilder stringBuilder = new StringBuilder("mm");
        C1720g.m3537RQ();
        C1720g.m3534RN();
        String x = C1178g.m2591x(stringBuilder.append(C1668a.m3383QF()).toString().getBytes());
        ArrayList arrayList = new ArrayList();
        C5728b c5728b = new C5728b(str2);
        if (c5728b.isDirectory()) {
            String[] list = c5728b.list();
            if (list != null) {
                for (String str3 : list) {
                    String str4 = str2 + str3;
                    if (str3.length() >= 32) {
                        C4990ab.m7419v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", str3, x);
                        ArrayList HR = C20227c.m31269HR(str4);
                        if (arrayList.size() > 0) {
                            if (!x.equals(str3)) {
                                C4990ab.m7417i("MicroMsg.CleanController", "add other acc tmp path %s", str3);
                                this.kwo.add(str3);
                            }
                            arrayList.addAll(0, HR);
                        } else {
                            arrayList.addAll(HR);
                        }
                    } else {
                        C4990ab.m7419v("MicroMsg.CleanController", "subfile: %s", str3);
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str4);
                        } else {
                            arrayList.add(str4);
                        }
                    }
                }
            }
        } else {
            m31286hc(C5730e.asZ(str2));
        }
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= arrayList.size()) {
                break;
            }
            str = (String) arrayList.get(i);
            if (str.contains("image2")) {
                i2 = i;
            }
            if (str.contains("voice2")) {
                i3 = i;
            }
            i4 = i + 1;
        }
        if (i3 != -1) {
            arrayList.add(0, (String) arrayList.remove(i3));
        }
        if (i2 != -1) {
            arrayList.add(0, (String) arrayList.remove(i2));
        }
        C4990ab.m7411d("MicroMsg.CleanController", "scan is finish [%s]", Long.valueOf(C5046bo.m7525az(yz)));
        long yz2 = C5046bo.m7588yz();
        ArrayList bfN = C20227c.bfN();
        C4990ab.m7411d("MicroMsg.CleanController", "user is finish [%s]", Long.valueOf(C5046bo.m7525az(yz2)));
        this.kwj = arrayList.size() + bfN.size();
        if (this.kwj == 0) {
            C4990ab.m7416i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            bfJ();
            AppMethodBeat.m2505o(18680);
            return;
        }
        C4990ab.m7417i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", Integer.valueOf(this.kwj));
        i4 = 0;
        while (true) {
            i = i4;
            if (this.isStop || i >= arrayList.size()) {
                i4 = 0;
            } else {
                C4990ab.m7411d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", Integer.valueOf(i), (String) arrayList.get(i));
                C20228b c20228b = new C20228b(str);
                while (!this.kwh.mo23131b(c20228b)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e) {
                    }
                }
                C4990ab.m7411d("MicroMsg.CleanController", "Start task： filePath＝%s", str);
                i4 = i + 1;
            }
        }
        i4 = 0;
        while (true) {
            i = i4;
            if (this.isStop || i >= bfN.size()) {
                AppMethodBeat.m2505o(18680);
            } else {
                C4990ab.m7411d("MicroMsg.CleanController", "while loop index=%d | username=%s", Integer.valueOf(i), (String) bfN.get(i));
                C20229a c20229a = new C20229a(str);
                while (!this.kwh.mo23131b(c20229a)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e2) {
                    }
                }
                C4990ab.m7411d("MicroMsg.CleanController", "Start task： user＝%s", str);
                i4 = i + 1;
            }
        }
        AppMethodBeat.m2505o(18680);
    }

    /* renamed from: a */
    public final void mo35472a(C33819a c33819a) {
        AppMethodBeat.m2504i(18681);
        if (c33819a instanceof C20229a) {
            C4990ab.m7411d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", Integer.valueOf(c33819a.hashCode()), c33819a.alb());
        } else {
            C4990ab.m7411d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", Integer.valueOf(c33819a.hashCode()), c33819a.alb());
        }
        C7305d.xDG.remove((Runnable) this);
        this.isStop = true;
        this.kwk++;
        if (!(this.kwi == null || this.isStop)) {
            this.fbD.post(new C28072());
        }
        if (this.kwk == this.kwj) {
            bfJ();
        }
        AppMethodBeat.m2505o(18681);
    }

    private void bfJ() {
        AppMethodBeat.m2504i(18682);
        this.endTime = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.CleanController", "totalUserTime:%d", Long.valueOf(bfK()));
        if (!(this.kwi == null || this.isStop)) {
            final ArrayList arrayList = new ArrayList();
            for (C27641b add : this.kwl.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(18667);
                    C20227c.this.kwi.mo45500a(C20227c.this.kwm, C20227c.this.kwn, C20227c.this.kvW, arrayList, C20227c.this.kvX, C20227c.this.kwo);
                    AppMethodBeat.m2505o(18667);
                }
            });
        }
        AppMethodBeat.m2505o(18682);
    }

    private long bfK() {
        return this.endTime - this.startTime;
    }

    public static long bfL() {
        long blockSize;
        AppMethodBeat.m2504i(18683);
        try {
            StatFs statFs = new StatFs(C6457e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.m2505o(18683);
            return 1;
        }
        AppMethodBeat.m2505o(18683);
        return blockSize;
    }

    public static long bfM() {
        long blockSize;
        AppMethodBeat.m2504i(18684);
        try {
            StatFs statFs = new StatFs(C6457e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.m2505o(18684);
            return 1;
        }
        AppMethodBeat.m2505o(18684);
        return blockSize;
    }

    private static ArrayList<String> bfN() {
        AppMethodBeat.m2504i(18685);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (Object add : C1855t.fkY) {
            linkedList.add(add);
        }
        C9638aw.m17190ZK();
        Cursor c = C18628c.m29083XR().mo15804c(C1855t.fkP, linkedList, "*");
        if (c.moveToFirst()) {
            do {
                C7617ak c7617ak = new C7617ak();
                c7617ak.mo8995d(c);
                if (!C5046bo.isNullOrNil(c7617ak.field_username)) {
                    C9638aw.m17190ZK();
                    if (!C7616ad.m13547Mn(C18628c.m29078XM().aoO(c7617ak.field_username).field_verifyFlag)) {
                        arrayList.add(c7617ak.field_username);
                    }
                }
                if (!c.moveToNext()) {
                    break;
                }
            } while (!c.isAfterLast());
        }
        c.close();
        AppMethodBeat.m2505o(18685);
        return arrayList;
    }

    /* renamed from: HR */
    private static ArrayList<String> m31269HR(String str) {
        AppMethodBeat.m2504i(18686);
        ArrayList arrayList = new ArrayList();
        C5728b c5728b = new C5728b(str);
        if (c5728b.isDirectory()) {
            String[] list = c5728b.list();
            if (list == null || list.length <= 0) {
                arrayList.add(str);
            } else {
                for (String str2 : list) {
                    arrayList.add(str + "/" + str2);
                }
            }
        } else {
            arrayList.add(str);
        }
        AppMethodBeat.m2505o(18686);
        return arrayList;
    }

    /* renamed from: hc */
    private synchronized void m31286hc(long j) {
        AppMethodBeat.m2504i(18687);
        if (j < 0) {
            C4990ab.m7421w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", Long.valueOf(j));
            this.kwn += 60;
            AppMethodBeat.m2505o(18687);
        } else {
            this.kwn += j;
            AppMethodBeat.m2505o(18687);
        }
    }
}
