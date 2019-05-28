package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.wav.WavFileHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.xwalk.core.XWalkEnvironment;

public final class c implements com.tencent.mm.plugin.clean.c.a.a.a, Runnable {
    private static final Long clo = Long.valueOf(604800000);
    private static final Long kvU = Long.valueOf(7776000000L);
    private static final int kwg = (com.tencent.mm.model.c.getAccPath().length() - 1);
    private long endTime = 0;
    private ak fbD = new ak(Looper.getMainLooper());
    public boolean isStop;
    private long kvW;
    private long kvX;
    private com.tencent.mm.plugin.clean.c.a.b kwh;
    private g kwi;
    private int kwj = 0;
    private int kwk = 0;
    private ConcurrentHashMap<String, b> kwl = new ConcurrentHashMap();
    private long kwm;
    private long kwn;
    private HashSet<String> kwo = new HashSet();
    private HashSet<String> kwp = new HashSet();
    private boolean kwq = true;
    private int[] kwr = new int[10];
    private long startTime = 0;

    class b extends com.tencent.mm.plugin.clean.c.a.a {
        private String filePath;
        private long fileSize;
        int kwu = 0;

        public b(String str) {
            super(c.this);
            this.filePath = str;
            this.fileSize = 0;
        }

        public final String alb() {
            AppMethodBeat.i(18672);
            String str = "filePath[" + this.filePath + "] scanCount[" + this.kwu + "]" + super.alb();
            AppMethodBeat.o(18672);
            return str;
        }

        public final void execute() {
            String str;
            int[] l;
            AppMethodBeat.i(18673);
            if (HT(this.filePath) && c.this.kwq) {
                ab.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", Boolean.valueOf(c.this.kwq), this.filePath);
                HS(this.filePath);
                com.tencent.mm.vfs.b dMC = new com.tencent.mm.vfs.b(this.filePath).dMC();
                if (dMC.list() == null || dMC.list().length == 0) {
                    dMC.delete();
                }
            } else {
                HU(this.filePath);
            }
            if (c.a(c.this, this.filePath)) {
                c.this.kvX = c.this.kvX + this.fileSize;
            } else {
                str = this.filePath;
                aw.ZK();
                if (str.startsWith(com.tencent.mm.model.c.getAccPath())) {
                    c.this.kvW = c.this.kvW + this.fileSize;
                }
            }
            if (HT(this.filePath)) {
                l = c.this.kwr;
                l[1] = (int) (((long) l[1]) + this.fileSize);
            } else {
                str = this.filePath;
                aw.ZK();
                if (str.startsWith(com.tencent.mm.model.c.getAccPath())) {
                    l = c.this.kwr;
                    l[0] = (int) (((long) l[0]) + this.fileSize);
                } else {
                    l = c.this.kwr;
                    l[2] = (int) (((long) l[2]) + this.fileSize);
                }
            }
            if (this.filePath.endsWith("/image2")) {
                l = c.this.kwr;
                l[3] = (int) (((long) l[3]) + this.fileSize);
            }
            if (this.filePath.endsWith("/image")) {
                l = c.this.kwr;
                l[4] = (int) (((long) l[4]) + this.fileSize);
            }
            if (this.filePath.endsWith("/video")) {
                l = c.this.kwr;
                l[5] = (int) (((long) l[5]) + this.fileSize);
            }
            if (this.filePath.endsWith("/voice2")) {
                l = c.this.kwr;
                l[6] = (int) (((long) l[6]) + this.fileSize);
            }
            if (this.filePath.endsWith("/WeiXin")) {
                l = c.this.kwr;
                l[7] = (int) (((long) l[7]) + this.fileSize);
            }
            if (this.filePath.endsWith("/WeChat")) {
                l = c.this.kwr;
                l[8] = (int) (((long) l[8]) + this.fileSize);
            }
            if (this.filePath.endsWith("/xlog")) {
                l = c.this.kwr;
                l[9] = (int) (((long) l[9]) + this.fileSize);
            }
            AppMethodBeat.o(18673);
        }

        private void HS(String str) {
            AppMethodBeat.i(18674);
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (bVar.isDirectory()) {
                String[] list = bVar.list();
                if (list != null) {
                    for (String str2 : list) {
                        HS(str + "/" + str2);
                    }
                }
                ab.v("MicroMsg.CleanController", "delete file rootFile: %s", str);
                bVar.delete();
                AppMethodBeat.o(18674);
                return;
            }
            ab.v("MicroMsg.CleanController", "delete file rootFile: %s", str);
            c.this.kwm = c.this.kwm + bVar.length();
            bVar.delete();
            AppMethodBeat.o(18674);
        }

        private static boolean HT(String str) {
            AppMethodBeat.i(18675);
            if (str.length() <= c.kwg || str.substring(c.kwg).indexOf("temp") != 0) {
                AppMethodBeat.o(18675);
                return false;
            }
            AppMethodBeat.o(18675);
            return true;
        }

        private void HU(String str) {
            int i = 0;
            AppMethodBeat.i(18676);
            this.kwu++;
            if (str.endsWith("/sns")) {
                ab.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", str);
                HV(str);
                AppMethodBeat.o(18676);
            } else if (str.endsWith("/music")) {
                ab.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", str);
                HW(str);
                AppMethodBeat.o(18676);
            } else {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
                if (bVar.isDirectory()) {
                    String[] list = bVar.list();
                    if (list != null) {
                        int length = list.length;
                        while (i < length) {
                            HU(str + "/" + list[i]);
                            i++;
                        }
                    }
                    AppMethodBeat.o(18676);
                    return;
                }
                long asZ = e.asZ(str);
                c.d(c.this, asZ);
                this.fileSize = asZ + this.fileSize;
                AppMethodBeat.o(18676);
            }
        }

        private void HV(String str) {
            int i = 0;
            AppMethodBeat.i(18677);
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (bVar.isDirectory()) {
                String[] list = bVar.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        HV(str + "/" + list[i]);
                        i++;
                    }
                }
                AppMethodBeat.o(18677);
            } else if (System.currentTimeMillis() - bVar.lastModified() <= c.clo.longValue() || !c.this.kwq) {
                long asZ = e.asZ(str);
                c.d(c.this, asZ);
                this.fileSize = asZ + this.fileSize;
                AppMethodBeat.o(18677);
            } else {
                ab.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", str);
                bVar.delete();
                AppMethodBeat.o(18677);
            }
        }

        private void HW(String str) {
            int i = 0;
            AppMethodBeat.i(18678);
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (bVar.isDirectory()) {
                String[] list = bVar.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        HW(str + "/" + list[i]);
                        i++;
                    }
                }
                AppMethodBeat.o(18678);
            } else if (System.currentTimeMillis() - bVar.lastModified() <= c.kvU.longValue() || !c.this.kwq) {
                long asZ = e.asZ(str);
                c.d(c.this, asZ);
                this.fileSize = asZ + this.fileSize;
                AppMethodBeat.o(18678);
            } else {
                ab.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", str);
                bVar.delete();
                AppMethodBeat.o(18678);
            }
        }
    }

    public class a extends com.tencent.mm.plugin.clean.c.a.a {
        private String username;

        public a(String str) {
            super(c.this);
            this.username = str;
        }

        public final String alb() {
            AppMethodBeat.i(18669);
            String str = "username[" + this.username + "]" + super.alb();
            AppMethodBeat.o(18669);
            return str;
        }

        public final void execute() {
            AppMethodBeat.i(18670);
            aw.ZK();
            int Rq = com.tencent.mm.model.c.XO().Rq(this.username);
            if (Rq <= 0) {
                ab.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", this.username, Integer.valueOf(Rq));
                AppMethodBeat.o(18670);
                return;
            }
            b bVar = new b();
            bVar.username = this.username;
            bVar.kwf = new ArrayList();
            bVar.jrb = 0;
            Cursor cursor = null;
            int i = 0;
            while (i < Rq) {
                try {
                    aw.ZK();
                    cursor = com.tencent.mm.model.c.XO().ab(this.username, i, 50);
                    if (cursor == null) {
                        break;
                    }
                    int a = a(cursor, bVar);
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    if (a <= 0) {
                        break;
                    }
                    i += a;
                    if (c.this.isStop) {
                        break;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.CleanController", e, "execute analyse Task error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.o(18670);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (bVar.kwf.size() > 0) {
                c.this.kwl.put(this.username, bVar);
            }
            ab.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", this.username, Integer.valueOf(Rq), Integer.valueOf(i), Boolean.valueOf(c.this.isStop));
            AppMethodBeat.o(18670);
        }

        private int a(Cursor cursor, b bVar) {
            int i = 0;
            AppMethodBeat.i(18671);
            if (cursor.moveToFirst()) {
                Object obj = null;
                while (!cursor.isAfterLast()) {
                    i++;
                    bi biVar = new bi();
                    biVar.d(cursor);
                    switch (l.Kx(biVar.getType())) {
                        case 3:
                            obj = c.b(biVar, this.username);
                            break;
                        case 43:
                        case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        case 62:
                            obj = c.c(biVar, this.username);
                            break;
                        case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                            obj = c.a(biVar, this.username);
                            break;
                    }
                    if (obj != null) {
                        bVar.kwf.add(obj);
                        bVar.jrb += obj.size;
                        obj = null;
                    }
                    if (cursor.moveToNext()) {
                        if (c.this.isStop) {
                        }
                    }
                    cursor.close();
                    AppMethodBeat.o(18671);
                }
                cursor.close();
                AppMethodBeat.o(18671);
            } else {
                ab.d("MicroMsg.CleanController", "Message count of user:%s is empty", this.username);
                cursor.close();
                AppMethodBeat.o(18671);
            }
            return i;
        }
    }

    static /* synthetic */ void d(c cVar, long j) {
        AppMethodBeat.i(18692);
        cVar.hc(j);
        AppMethodBeat.o(18692);
    }

    static {
        AppMethodBeat.i(18693);
        aw.ZK();
        AppMethodBeat.o(18693);
    }

    public c(com.tencent.mm.plugin.clean.c.a.b bVar, g gVar) {
        AppMethodBeat.i(18679);
        this.kwi = gVar;
        this.kwh = bVar;
        AppMethodBeat.o(18679);
    }

    public final void run() {
        int i;
        String str;
        AppMethodBeat.i(18680);
        ab.i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        long yz = bo.yz();
        String str2 = com.tencent.mm.compatible.util.e.eSn;
        ab.v("MicroMsg.CleanController", "root path: %s", str2);
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.RQ();
        g.RN();
        String x = com.tencent.mm.a.g.x(stringBuilder.append(com.tencent.mm.kernel.a.QF()).toString().getBytes());
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
        if (bVar.isDirectory()) {
            String[] list = bVar.list();
            if (list != null) {
                for (String str3 : list) {
                    String str4 = str2 + str3;
                    if (str3.length() >= 32) {
                        ab.v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", str3, x);
                        ArrayList HR = HR(str4);
                        if (arrayList.size() > 0) {
                            if (!x.equals(str3)) {
                                ab.i("MicroMsg.CleanController", "add other acc tmp path %s", str3);
                                this.kwo.add(str3);
                            }
                            arrayList.addAll(0, HR);
                        } else {
                            arrayList.addAll(HR);
                        }
                    } else {
                        ab.v("MicroMsg.CleanController", "subfile: %s", str3);
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str4);
                        } else {
                            arrayList.add(str4);
                        }
                    }
                }
            }
        } else {
            hc(e.asZ(str2));
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
        ab.d("MicroMsg.CleanController", "scan is finish [%s]", Long.valueOf(bo.az(yz)));
        long yz2 = bo.yz();
        ArrayList bfN = bfN();
        ab.d("MicroMsg.CleanController", "user is finish [%s]", Long.valueOf(bo.az(yz2)));
        this.kwj = arrayList.size() + bfN.size();
        if (this.kwj == 0) {
            ab.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            bfJ();
            AppMethodBeat.o(18680);
            return;
        }
        ab.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", Integer.valueOf(this.kwj));
        i4 = 0;
        while (true) {
            i = i4;
            if (this.isStop || i >= arrayList.size()) {
                i4 = 0;
            } else {
                ab.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", Integer.valueOf(i), (String) arrayList.get(i));
                b bVar2 = new b(str);
                while (!this.kwh.b(bVar2)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e) {
                    }
                }
                ab.d("MicroMsg.CleanController", "Start task： filePath＝%s", str);
                i4 = i + 1;
            }
        }
        i4 = 0;
        while (true) {
            i = i4;
            if (this.isStop || i >= bfN.size()) {
                AppMethodBeat.o(18680);
            } else {
                ab.d("MicroMsg.CleanController", "while loop index=%d | username=%s", Integer.valueOf(i), (String) bfN.get(i));
                a aVar = new a(str);
                while (!this.kwh.b(aVar)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e2) {
                    }
                }
                ab.d("MicroMsg.CleanController", "Start task： user＝%s", str);
                i4 = i + 1;
            }
        }
        AppMethodBeat.o(18680);
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        AppMethodBeat.i(18681);
        if (aVar instanceof a) {
            ab.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", Integer.valueOf(aVar.hashCode()), aVar.alb());
        } else {
            ab.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", Integer.valueOf(aVar.hashCode()), aVar.alb());
        }
        d.xDG.remove((Runnable) this);
        this.isStop = true;
        this.kwk++;
        if (!(this.kwi == null || this.isStop)) {
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18668);
                    c.this.kwi.dO(c.this.kwk, c.this.kwj);
                    AppMethodBeat.o(18668);
                }
            });
        }
        if (this.kwk == this.kwj) {
            bfJ();
        }
        AppMethodBeat.o(18681);
    }

    private void bfJ() {
        AppMethodBeat.i(18682);
        this.endTime = System.currentTimeMillis();
        ab.i("MicroMsg.CleanController", "totalUserTime:%d", Long.valueOf(bfK()));
        if (!(this.kwi == null || this.isStop)) {
            final ArrayList arrayList = new ArrayList();
            for (b add : this.kwl.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.fbD.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(18667);
                    c.this.kwi.a(c.this.kwm, c.this.kwn, c.this.kvW, arrayList, c.this.kvX, c.this.kwo);
                    AppMethodBeat.o(18667);
                }
            });
        }
        AppMethodBeat.o(18682);
    }

    private long bfK() {
        return this.endTime - this.startTime;
    }

    public static long bfL() {
        long blockSize;
        AppMethodBeat.i(18683);
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.o(18683);
            return 1;
        }
        AppMethodBeat.o(18683);
        return blockSize;
    }

    public static long bfM() {
        long blockSize;
        AppMethodBeat.i(18684);
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.eSl);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        if (blockSize <= 0) {
            AppMethodBeat.o(18684);
            return 1;
        }
        AppMethodBeat.o(18684);
        return blockSize;
    }

    private static ArrayList<String> bfN() {
        AppMethodBeat.i(18685);
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        for (Object add : t.fkY) {
            linkedList.add(add);
        }
        aw.ZK();
        Cursor c = com.tencent.mm.model.c.XR().c(t.fkP, linkedList, "*");
        if (c.moveToFirst()) {
            do {
                com.tencent.mm.storage.ak akVar = new com.tencent.mm.storage.ak();
                akVar.d(c);
                if (!bo.isNullOrNil(akVar.field_username)) {
                    aw.ZK();
                    if (!ad.Mn(com.tencent.mm.model.c.XM().aoO(akVar.field_username).field_verifyFlag)) {
                        arrayList.add(akVar.field_username);
                    }
                }
                if (!c.moveToNext()) {
                    break;
                }
            } while (!c.isAfterLast());
        }
        c.close();
        AppMethodBeat.o(18685);
        return arrayList;
    }

    private static ArrayList<String> HR(String str) {
        AppMethodBeat.i(18686);
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.isDirectory()) {
            String[] list = bVar.list();
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
        AppMethodBeat.o(18686);
        return arrayList;
    }

    private synchronized void hc(long j) {
        AppMethodBeat.i(18687);
        if (j < 0) {
            ab.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", Long.valueOf(j));
            this.kwn += 60;
            AppMethodBeat.o(18687);
        } else {
            this.kwn += j;
            AppMethodBeat.o(18687);
        }
    }
}
