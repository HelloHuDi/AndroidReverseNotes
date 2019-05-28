package com.tencent.p177mm.plugin.backup.p342b;

import android.content.SharedPreferences;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.backup.b.d */
public abstract class C38634d extends C33660a {
    private static String TAG = "MicroMsg.BackupModel";
    private static boolean eIJ = false;
    private static int jqS = 0;
    private static byte[] jqT = "key".getBytes();
    private static SharedPreferences jqV;
    public String jqO = "id";
    public String jqP = "hello";
    public String jqQ = "ok";
    public C42758e jqR;
    public byte[] jqU;

    public abstract void aSv();

    public abstract void aSw();

    /* renamed from: m */
    public abstract void mo61481m(Object... objArr);

    public final C42758e aSu() {
        if (this.jqR == null) {
            this.jqR = new C42758e();
        }
        return this.jqR;
    }

    public static int aSx() {
        return jqS;
    }

    /* renamed from: rk */
    public static void m65498rk(int i) {
        jqS = i;
    }

    public static byte[] aSy() {
        return jqT;
    }

    /* renamed from: ao */
    public static void m65497ao(byte[] bArr) {
        jqT = bArr;
    }

    public static SharedPreferences aSz() {
        if (jqV == null) {
            jqV = C4996ah.getContext().getSharedPreferences("BACKUP_CONFIG", C1448h.m3078Mu());
        }
        return jqV;
    }

    public static void aSA() {
        C4990ab.m7416i(TAG, "holdReset");
        eIJ = true;
    }

    public static boolean aSB() {
        return eIJ;
    }

    public static void aSC() {
        jqT = "key".getBytes();
        jqS = 0;
        jqV = null;
        eIJ = false;
    }
}
