package com.tencent.p659pb.common.p660b;

import android.text.TextUtils;
import android.widget.Toast;
import com.google.p1368a.p1369a.C25510e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p1102c.C46730f;
import com.tencent.p659pb.common.p1631a.C44437a;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24199v;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24235u;
import com.tencent.p659pb.p1514a.p1515a.C36407a;
import com.tencent.p659pb.talkroom.sdk.C46731e;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.wecall.talkroom.model.C36578h;
import com.tencent.wecall.talkroom.model.C41112a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.pb.common.b.f */
public class C44439f {
    private static C44439f Ama = null;
    private int Amb;
    private LinkedList<C36409a> Amc;
    public C46731e Amd;
    private boolean Ame;
    private boolean Amf;

    /* renamed from: com.tencent.pb.common.b.f$a */
    public class C36409a {
        public String Amg;
        C30911a Amh;
        C30913c Ami;
        int mTaskId;

        private C36409a() {
        }

        /* synthetic */ C36409a(C44439f c44439f, byte b) {
            this();
        }
    }

    private C44439f() {
        this.Amb = 0;
        this.Amc = null;
        this.Amd = null;
        this.Ame = false;
        this.Amf = true;
        this.Amc = new LinkedList();
        this.Amf = true;
    }

    /* renamed from: ci */
    private static C24199v m80378ci(byte[] bArr) {
        try {
            return (C24199v) C25510e.m40292a(new C24199v(), bArr, bArr.length);
        } catch (Exception e) {
            C44443c.m80392w("NETCMD", "Exception genReadPackageData" + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private int m80377a(C30911a c30911a, C30913c c30913c, String str, int i, byte[] bArr, int i2) {
        byte[] bArr2;
        byte[] bArr3 = null;
        int dPw = dPw();
        try {
            if (bArr.length < 200 || bArr == null || bArr.length >= bArr.length) {
            }
            C24235u c24235u = new C24235u();
            c24235u.f4452Cn = i;
            c24235u.AnK = dPw;
            c24235u.userName = C36407a.dPM();
            c24235u.AmC = i2;
            if (bArr == null) {
                C44443c.m80392w("NETCMD", "body null");
            } else {
                C24199v c24199v = new C24199v();
                c24199v.AnM = c24235u;
                c24199v.body = bArr;
                bArr3 = C25510e.m40293b(c24199v);
            }
            bArr2 = bArr3;
        } catch (Exception e) {
            C44443c.m80392w("NetError", "newTaskHelper addTask body null");
            bArr2 = bArr3;
        }
        if (bArr2 == null) {
            C44443c.m80392w("NETCMD", "cmd:" + i + "|body is null");
            return -1;
        } else if (bArr2.length > 61440) {
            C44443c.m80392w("NETCMD", "cmd:" + i + "|body too large");
            return -1;
        } else {
            C36409a c36409a = new C36409a(this, (byte) 0);
            c36409a.mTaskId = dPw;
            c36409a.Amh = c30911a;
            c36409a.Ami = c30913c;
            c36409a.Amg = str;
            synchronized (this.Amc) {
                this.Amc.add(c36409a);
            }
            int i3 = 1933;
            switch (i) {
                case C33333a.CTRL_INDEX /*139*/:
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
            C44443c.m80389d("NETCMD", "CLTSEND|", Integer.valueOf(dPw), Integer.valueOf(i3), str, C36407a.dPM());
            if (this.Amd != null) {
                this.Amd.mo46545d(dPw, i3, bArr2);
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

    /* renamed from: QW */
    public final C36409a mo70369QW(int i) {
        C36409a c36409a;
        synchronized (this.Amc) {
            Iterator it = this.Amc.iterator();
            while (it.hasNext()) {
                c36409a = (C36409a) it.next();
                if (c36409a.mTaskId == i) {
                    break;
                }
            }
            c36409a = null;
        }
        return c36409a;
    }

    public static C44439f dPx() {
        if (Ama == null) {
            synchronized (C44439f.class) {
                if (Ama == null) {
                    Ama = new C44439f();
                }
            }
        }
        return Ama;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo70370a(C30911a c30911a, C30913c c30913c, int i, String str, byte[] bArr, int i2) {
        if (!this.Amf) {
            C44443c.m80392w("NETCMD", "doSendTask mIsInitSucc is false");
            return -1;
        } else if (this.Ame) {
            C44443c.m80392w("NETCMD", "doSendTask fail: isRefreshing, cmd=" + i + ", cmdTag=" + str);
            return -1;
        } else {
            try {
                return m80377a(c30911a, c30913c, str, i, bArr, i2);
            } catch (Throwable th) {
                C44443c.m80392w("NETCMD", "Exception doSendTask", th);
                return -1;
            }
        }
    }

    /* renamed from: a */
    public final int mo70371a(C30911a c30911a, String str, C25510e c25510e) {
        try {
            return mo70370a(c30911a, null, 31, str, C25510e.m40293b(c25510e), 0);
        } catch (Exception e) {
            C44443c.m80392w("NETCMD", "doSendTask exception:", e);
            return -1;
        }
    }

    /* renamed from: cj */
    public static int m80379cj(byte[] bArr) {
        if (bArr == null) {
            C44443c.m80392w("NETCMD", "CLTNOT onNotify1 data == null ", Integer.valueOf(0));
            C36578h.m60647Sq(-1601);
            if (TextUtils.isEmpty(C41112a.dSR().neq) && TextUtils.isEmpty(C41112a.dSR().AJu)) {
                C36578h.m60651a(C41112a.dSR().nCF, C41112a.dSR().sZg, "notify", "datanull");
            } else {
                C41112a.dSR().AJC.mo58376aa("notify", "datanull");
            }
            return -1;
        }
        C44443c.m80389d("NETCMD", "CLTNOT onNotify data len=", Integer.valueOf(bArr.length));
        return C41112a.dSR().mo41161ct(bArr);
    }

    /* renamed from: a */
    public final void mo70372a(C36409a c36409a, int i, byte[] bArr) {
        try {
            if (c36409a.Ami != null) {
                c36409a.Ami.mo40010r(i, bArr);
            }
            if (c36409a.Amh != null) {
                c36409a.Amh.mo49459eM(c36409a.Amg, i);
            }
        } catch (Exception e) {
            C44443c.m80392w("NETCMD", "postRespData", e.getMessage());
        }
        synchronized (this.Amc) {
            this.Amc.remove(c36409a);
        }
    }

    /* renamed from: s */
    public final int mo70373s(int i, byte[] bArr) {
        C36409a QW = mo70369QW(i);
        if (QW != null || -1000 == i) {
            C24199v ci = C44439f.m80378ci(bArr);
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
                C44443c.m80392w(str2, objArr);
                mo70372a(QW, -3, null);
                return -1;
            }
            int i2 = ci.AnM.ret;
            int i3 = ci.AnM.AnL;
            String str3 = ci.AnM.userName;
            if (C44437a.Alq) {
                Toast.makeText(C46729d.sZj, "retCode: " + i2 + " debugCode: " + i3, 0).show();
            }
            if (i2 != 0 && QW != null) {
                C44443c.m80392w("NETCMD", "CLTRCV", Integer.valueOf(i), QW.Amg, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            } else if (QW != null) {
                C44443c.m80389d("NETCMD", "CLTRCV", Integer.valueOf(i), QW.Amg, Integer.valueOf(i2), str3, Integer.valueOf(i3));
            }
            byte[] bArr2 = ci.body;
            if (bArr2 != null) {
                mo70372a(QW, i2, bArr2);
                return 0;
            }
            mo70372a(QW, i2, null);
            return 0;
        }
        C44443c.m80392w("NETCMD", "buf2Resp fail: taskId:" + i + " not found");
        C46730f.m88557C(20007, 3, "-1202");
        return 1;
    }
}
