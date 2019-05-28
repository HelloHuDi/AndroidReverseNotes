package com.tencent.p127d.p807b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p1164a.C41659a;
import com.tencent.p127d.p128c.p1450b.C41204d;
import com.tencent.p127d.p128c.p1450b.C45081b;
import com.tencent.p127d.p130d.p131b.C0921d;
import com.tencent.p127d.p130d.p131b.C0921d.C0922a;
import com.tencent.p127d.p130d.p131b.C45082f;
import com.tencent.p127d.p130d.p808a.C17726e;
import com.tencent.p127d.p130d.p808a.C25597d;
import com.tencent.p127d.p130d.p808a.C25598f;
import com.tencent.p127d.p130d.p808a.C32110a;
import com.tencent.p127d.p130d.p808a.C32111b;
import com.tencent.p127d.p130d.p808a.C37316c;
import com.tencent.p127d.p130d.p808a.C8761g;
import com.tencent.p127d.p135f.C25603d;
import com.tencent.p127d.p135f.C41669a;
import com.tencent.p127d.p135f.C45085h;
import com.tencent.p127d.p135f.C8769e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.d.b.a */
public final class C37315a {
    public C25596b ArH;
    public Context mContext = null;

    public C37315a(Context context) {
        AppMethodBeat.m2504i(114469);
        this.mContext = context;
        this.ArH = new C25596b(context);
        AppMethodBeat.m2505o(114469);
    }

    public static C41204d dQj() {
        AppMethodBeat.m2504i(114470);
        C41204d c41204d = new C41204d();
        try {
            int i;
            c41204d.AsX = Build.FINGERPRINT;
            c41204d.AsY = C25603d.dQE();
            c41204d.fwM = Build.BRAND;
            c41204d.model = Build.MODEL;
            c41204d.AsZ = VERSION.SDK_INT;
            c41204d.Ata = Build.CPU_ABI;
            c41204d.platform = C25603d.atU("ro.board.platform");
            if (C25598f.dQn()) {
                i = 2;
            } else {
                Object obj;
                List<C0922a> dQo = C0921d.dQo();
                if (dQo.isEmpty()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    ArrayList<C32111b> arrayList = new ArrayList(3);
                    arrayList.add(new C8761g());
                    arrayList.add(new C25597d());
                    if (C45082f.dQp()) {
                        arrayList.add(new C37316c());
                    }
                    for (C0922a c0922a : dQo) {
                        if (c0922a != null) {
                            for (C32111b a : arrayList) {
                                a.mo19822a(c0922a);
                            }
                        }
                    }
                    for (C32111b dQl : arrayList) {
                        if (dQl.dQl()) {
                            obj = 1;
                            break;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    i = 2;
                } else if (C17726e.dQm()) {
                    i = 1;
                } else {
                    if (!C32110a.atP("/system/bin/debuggerd")) {
                        obj = 1;
                    } else if (!C32110a.atP("/system/bin/debuggerd64")) {
                        i = 1;
                    } else if (!C32110a.atP("/system/bin/ddexe")) {
                        i = 1;
                    } else if (!C32110a.atQ("/system/etc/install-recovery.sh")) {
                        i = 1;
                    } else if (C32110a.atQ("/system/bin/install-recovery.sh")) {
                        C45085h.dQG();
                        obj = null;
                    } else {
                        i = 1;
                    }
                    if (obj != null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
            }
            c41204d.Atb = i;
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(114470);
        return c41204d;
    }

    /* renamed from: a */
    public static C45081b m62717a(Context context, C41659a c41659a, int i) {
        AppMethodBeat.m2504i(114471);
        if (c41659a == null) {
            AppMethodBeat.m2505o(114471);
            return null;
        }
        C45081b c45081b = new C45081b();
        c45081b.Asp = i;
        c45081b.Asq = null;
        c45081b.Asr = c41659a.ceO;
        c45081b.Ass = C8769e.atV(c41659a.ArC);
        List<byte[]> cb = C41669a.m73069cb(context, c41659a.ceO);
        if (cb.size() > 1) {
            c45081b.AsH = new ArrayList();
            for (byte[] add : cb) {
                c45081b.AsH.add(add);
            }
        }
        c45081b.Ast = c41659a.fileSize;
        c45081b.Asu = c41659a.ArB;
        c45081b.Asv = c41659a.versionCode;
        c45081b.Asw = c41659a.versionName;
        c45081b.Asx = 0;
        if (c41659a.egi == 1) {
            c45081b.Asx |= 1;
        }
        c45081b.Asx |= 2;
        if (!(c41659a.ArD.startsWith("/data") || c41659a.ArD.startsWith("/system"))) {
            c45081b.Asx |= 4;
        }
        c45081b.Asy = "";
        c45081b.Asz = 0;
        c45081b.AsA = 0;
        c45081b.AsB = 0;
        c45081b.AsC = null;
        c45081b.AsD = 0;
        c45081b.AsE = false;
        c45081b.AsF = 0;
        c45081b.AsG = 0;
        AppMethodBeat.m2505o(114471);
        return c45081b;
    }
}
