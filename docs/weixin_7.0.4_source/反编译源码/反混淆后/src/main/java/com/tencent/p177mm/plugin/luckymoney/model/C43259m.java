package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.luckymoney.p735b.C6964a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.m */
public final class C43259m extends C4884c<C32519bf> {
    public static final String nXE = (C1761b.eSj + "/luckymoney/");

    public C43259m() {
        AppMethodBeat.m2504i(42327);
        this.xxI = C32519bf.class.getName().hashCode();
        AppMethodBeat.m2505o(42327);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(42330);
        final C32519bf c32519bf = (C32519bf) c4883b;
        if (c32519bf.cus.cut == 58) {
            C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(c32519bf.cus.cut), Integer.valueOf(c32519bf.cus.cuu), c32519bf.cus.filePath);
            C7060h.pYm.mo15419k(991, 0, 1);
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(42326);
                    if (!C5046bo.isNullOrNil(c32519bf.cus.filePath)) {
                        boolean z = true;
                        if (!C43259m.m77003aN(c32519bf.cus.cuu, c32519bf.cus.filePath)) {
                            C7060h.pYm.mo15419k(991, 2, 1);
                            z = false;
                        } else if (C43259m.m77004et(c32519bf.cus.cuu, c32519bf.cus.cuv)) {
                            C4990ab.m7416i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "not retry");
                        } else {
                            C7060h.pYm.mo15419k(991, 1, 1);
                            z = false;
                        }
                        C14845c.veg.mo27152f(c32519bf.cus.cut, c32519bf.cus.cuu, c32519bf.cus.cuv, z);
                    }
                    AppMethodBeat.m2505o(42326);
                }
            }, "lucky_money_envelope_resource_checker");
        }
        AppMethodBeat.m2505o(42330);
        return false;
    }

    static {
        AppMethodBeat.m2504i(42333);
        AppMethodBeat.m2505o(42333);
    }

    /* renamed from: xR */
    public static String m77005xR(int i) {
        AppMethodBeat.m2504i(42329);
        String str = nXE + i + "/";
        AppMethodBeat.m2505o(42329);
        return str;
    }

    public static void bLy() {
        AppMethodBeat.m2504i(42328);
        C14845c.veg;
        C14839b.m23095Ky(58);
        AppMethodBeat.m2505o(42328);
    }

    /* renamed from: aN */
    static /* synthetic */ boolean m77003aN(int i, String str) {
        AppMethodBeat.m2504i(42331);
        String str2 = nXE + i;
        if (C5730e.m8628ct(str2)) {
            C5730e.m8618N(str2, true);
        }
        new C5728b(str2).mkdirs();
        int iu = C5730e.m8636iu(str, str2);
        C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "unzip ret: %s", Integer.valueOf(0));
        if (iu == 0) {
            AppMethodBeat.m2505o(42331);
            return true;
        }
        AppMethodBeat.m2505o(42331);
        return false;
    }

    /* renamed from: et */
    static /* synthetic */ boolean m77004et(int i, int i2) {
        AppMethodBeat.m2504i(42332);
        String str = nXE + i + "/";
        if (C5730e.m8628ct(str)) {
            boolean z;
            C43260n c43260n = new C43260n();
            c43260n.field_subtype = i;
            boolean b = C6964a.bKN().bKM().mo10102b((C4925c) c43260n, new String[0]);
            C5728b[] dMF = new C5728b(str).dMF();
            if (dMF == null || dMF.length <= 0) {
                z = false;
            } else {
                z = false;
                for (C5728b c5728b : dMF) {
                    if (c5728b.isFile()) {
                        String v = C1178g.m2589v(new File(C5736j.m8649w(c5728b.dMD())));
                        if (c5728b.getName().equals("bubble.png")) {
                            c43260n.field_bubbleMd5 = v;
                            z = true;
                        } else if (c5728b.getName().equals("cover.png")) {
                            c43260n.field_coverMd5 = v;
                            z = true;
                        } else if (c5728b.getName().equals("minilogo.png")) {
                            c43260n.field_minilogoMd5 = v;
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                c43260n.field_version = i2;
                C4990ab.m7417i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "insert or update resource: %s, %s, %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b));
                boolean c;
                if (b) {
                    c = C6964a.bKN().bKM().mo10103c(c43260n, new String[0]);
                    AppMethodBeat.m2505o(42332);
                    return c;
                }
                c = C6964a.bKN().bKM().mo10101b((C4925c) c43260n);
                AppMethodBeat.m2505o(42332);
                return c;
            }
            C4990ab.m7420w("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "error file dir");
            AppMethodBeat.m2505o(42332);
            return false;
        }
        AppMethodBeat.m2505o(42332);
        return false;
    }
}
