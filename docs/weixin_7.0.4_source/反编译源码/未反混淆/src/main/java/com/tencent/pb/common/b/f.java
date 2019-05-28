package com.tencent.pb.common.b;

import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.pb.common.b.a.a.u;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wecall.talkroom.model.h;
import java.util.Iterator;
import java.util.LinkedList;

public class f {
    private static f Ama = null;
    private int Amb;
    private LinkedList<a> Amc;
    public e Amd;
    private boolean Ame;
    private boolean Amf;

    public class a {
        public String Amg;
        a Amh;
        c Ami;
        int mTaskId;

        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }
    }

    private f() {
        this.Amb = 0;
        this.Amc = null;
        this.Amd = null;
        this.Ame = false;
        this.Amf = true;
        this.Amc = new LinkedList();
        this.Amf = true;
    }

    private static v ci(byte[] bArr) {
        try {
            return (v) com.google.a.a.e.a(new v(), bArr, bArr.length);
        } catch (Exception e) {
            c.w("NETCMD", "Exception genReadPackageData" + e.getMessage());
            return null;
        }
    }

    private int a(a aVar, c cVar, String str, int i, byte[] bArr, int i2) {
        byte[] bArr2;
        byte[] bArr3 = null;
        int dPw = dPw();
        try {
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
            }
            u uVar = new u();
            uVar.Cn = i;
            uVar.AnK = dPw;
            uVar.userName = com.tencent.pb.a.a.a.dPM();
            uVar.AmC = i2;
            if (bArr == null) {
                c.w("NETCMD", "body null");
            } else {
                v vVar = new v();
                vVar.AnM = uVar;
                vVar.body = bArr;
                bArr3 = com.google.a.a.e.b(vVar);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            c.w("NetError", "newTaskHelper addTask body null");
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            c.w("NETCMD", "cmd:" + i + "|body is null");
            return -1;
        } else if (bArr2.length > 61440) {
            c.w("NETCMD", "cmd:" + i + "|body too large");
            return -1;
        } else {
            a aVar2 = new a(this, (byte) 0);
            aVar2.mTaskId = dPw;
            aVar2.Amh = aVar;
            aVar2.Ami = cVar;
            aVar2.Amg = str;
            synchronized (this.Amc) {
                this.Amc.add(aVar2);
            }
            int i3 = 1933;
            switch (i) {
                case com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX /*139*/:
                    i3 = 1918;
                    break;
                case 141:
                    i3 = 1919;
                    break;
                case ErrorCode.NEEDDOWNLOAD_4 /*143*/:
                    i3 = 1927;
                    break;
                case 145:
                    i3 = 1931;
                    break;
                case ErrorCode.NEEDDOWNLOAD_8 /*147*/:
                    i3 = 1932;
                    break;
                case 181:
                    i3 = 1929;
                    break;
                case 183:
                    i3 = 1928;
                    break;
                case 189:
                    i3 = 1935;
                    break;
                case 211:
                    i3 = 1937;
                    break;
                case 221:
                    i3 = 1938;
                    break;
                case 223:
                    i3 = 1939;
                    break;
            }
            c.d("NETCMD", "CLTSEND|", Integer.valueOf(dPw), Integer.valueOf(i3), str, com.tencent.pb.a.a.a.dPM());
            if (this.Amd != null) {
                this.Amd.d(dPw, i3, bArr2);
            }
            return dPw;
        }
    }

    private int dPw() {
        int i;
        synchronized (this.Amc) {
            this.Amb++;
            i = this.Amb;
        }
        return i;
    }

    public final a QW(int i) {
        a aVar;
        synchronized (this.Amc) {
            Iterator it = this.Amc.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.mTaskId == i) {
                    break;
                }
            }
            aVar = null;
        }
        return aVar;
    }

    public static f dPx() {
        if (Ama == null) {
            synchronized (f.class) {
                if (Ama == null) {
                    Ama = new f();
                }
            }
        }
        return Ama;
    }

    /* Access modifiers changed, original: final */
    public final int a(a aVar, c cVar, int i, String str, byte[] bArr, int i2) {
        if (!this.Amf) {
            c.w("NETCMD", "doSendTask mIsInitSucc is false");
            return -1;
        } else if (this.Ame) {
            c.w("NETCMD", "doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str);
            return -1;
        } else {
            try {
                return a(aVar, cVar, str, i, bArr, i2);
            } catch (Throwable th) {
                c.w("NETCMD", "Exception doSendTask", th);
                return -1;
            }
        }
    }

    public final int a(a aVar, String str, com.google.a.a.e eVar) {
        try {
            return a(aVar, null, 31, str, com.google.a.a.e.b(eVar), 0);
        } catch (Exception e) {
            c.w("NETCMD", "doSendTask exception:", e);
            return -1;
        }
    }

    public static int cj(byte[] bArr) {
        if (bArr == null) {
            c.w("NETCMD", "CLTNOT onNotify1 data == null ", Integer.valueOf(0));
            h.Sq(-1601);
            if (TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.dSR().neq) && TextUtils.isEmpty(com.tencent.wecall.talkroom.model.a.dSR().AJu)) {
                h.a(com.tencent.wecall.talkroom.model.a.dSR().nCF, com.tencent.wecall.talkroom.model.a.dSR().sZg, "notify", "datanull");
            } else {
                com.tencent.wecall.talkroom.model.a.dSR().AJC.aa("notify", "datanull");
            }
            return -1;
        }
        c.d("NETCMD", "CLTNOT onNotify data len=", Integer.valueOf(bArr.length));
        return com.tencent.wecall.talkroom.model.a.dSR().ct(bArr);
    }

    public final void a(a aVar, int i, byte[] bArr) {
        try {
            if (aVar.Ami != null) {
                aVar.Ami.r(i, bArr);
            }
            if (aVar.Amh != null) {
                aVar.Amh.eM(aVar.Amg, i);
            }
        } catch (Exception e) {
            c.w("NETCMD", "postRespData", e.getMessage());
        }
        synchronized (this.Amc) {
            this.Amc.remove(aVar);
        }
    }

    public final int s(int i, byte[] bArr) {
        a QW = QW(i);
        if (QW != null || -1000 == i) {
            v ci = ci(bArr);
            if (ci == null || ci.AnM == null) {
                String str;
                String str2 = "NETCMD";
                Object[] objArr = new Object[2];
                objArr[0] = " pack.head: ";
                if (ci == null) {
                    str = " pack is null ";
                } else {
                    str = " head is " + ci.AnM;
                }
                objArr[1] = str;
                c.w(str2, objArr);
                a(QW, -3, null);
                return -1;
            }
            int i2 = ci.AnM.ret;
            int i3 = ci.AnM.AnL;
            String str3 = ci.AnM.userName;
            if (com.tencent.pb.common.a.a.Alq) {
                Toast.makeText(d.sZj, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && QW != null) {
                c.w("NETCMD", "CLTRCV", Integer.valueOf(i), QW.Amg, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            } else if (QW != null) {
                c.d("NETCMD", "CLTRCV", Integer.valueOf(i), QW.Amg, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            }
            byte[] bArr2 = ci.body;
            if (bArr2 != null) {
                a(QW, i2, bArr2);
                return 0;
            }
            a(QW, i2, null);
            return 0;
        }
        c.w("NETCMD", "buf2Resp fail: taskId:" + i + " not found");
        com.tencent.pb.common.c.f.C(20007, 3, "-1202");
        return 1;
    }
}
