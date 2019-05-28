package com.tencent.mm.plugin.backup.b;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public abstract class d extends a {
    private static String TAG = "MicroMsg.BackupModel";
    private static boolean eIJ = false;
    private static int jqS = 0;
    private static byte[] jqT = "key".getBytes();
    private static SharedPreferences jqV;
    public String jqO = "id";
    public String jqP = "hello";
    public String jqQ = "ok";
    public e jqR;
    public byte[] jqU;

    public abstract void aSv();

    public abstract void aSw();

    public abstract void m(Object... objArr);

    public final e aSu() {
        if (this.jqR == null) {
            this.jqR = new e();
        }
        return this.jqR;
    }

    public static int aSx() {
        return jqS;
    }

    public static void rk(int i) {
        jqS = i;
    }

    public static byte[] aSy() {
        return jqT;
    }

    public static void ao(byte[] bArr) {
        jqT = bArr;
    }

    public static SharedPreferences aSz() {
        if (jqV == null) {
            jqV = ah.getContext().getSharedPreferences("BACKUP_CONFIG", h.Mu());
        }
        return jqV;
    }

    public static void aSA() {
        ab.i(TAG, "holdReset");
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
