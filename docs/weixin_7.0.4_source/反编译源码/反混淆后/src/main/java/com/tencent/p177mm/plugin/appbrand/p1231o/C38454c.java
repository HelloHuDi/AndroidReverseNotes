package com.tencent.p177mm.plugin.appbrand.p1231o;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C37743ji;
import com.tencent.p177mm.p230g.p231a.C42006ig;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.o.c */
public final class C38454c {
    public C4884c iDA;
    public C4884c iDB;
    C45660b iDy;
    public C4884c iDz;

    /* renamed from: com.tencent.mm.plugin.appbrand.o.c$1 */
    class C196151 extends C4884c<C32519bf> {
        C196151() {
            AppMethodBeat.m2504i(132713);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(132713);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(132714);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 40 && c32519bf.cus.cuu == 1) {
                File file = new File(c32519bf.cus.filePath);
                if (file.exists()) {
                    C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                    C45661d c45661d = C45661d.iDE;
                    File file2 = new File(C45661d.aLD(), "temp");
                    File file3 = new File(file2, "wxa_fts_template.zip");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    C1173e.m2577y(file.getAbsolutePath(), file3.getAbsolutePath());
                    int hU = C5046bo.m7570hU(file3.getAbsolutePath(), file2.getAbsolutePath());
                    int i = 65900182;
                    if (hU >= 0) {
                        c45661d = C45661d.iDE;
                        i = Integer.valueOf(C45661d.m84314J(new File(file2, "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
                    }
                    C1173e.m2575t(file2);
                    if (i > C38454c.this.iDy.f17886cD) {
                        C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", Integer.valueOf(C38454c.this.iDy.f17886cD), Integer.valueOf(i));
                        if (C38454c.m65052f(file, new File(C38454c.this.iDy.gXQ))) {
                            C38454c.this.refresh();
                        } else {
                            C4990ab.m7412e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", Integer.valueOf(C38454c.this.iDy.f17886cD), Integer.valueOf(i));
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                }
            }
            AppMethodBeat.m2505o(132714);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o.c$2 */
    class C272152 extends C4884c<C42006ig> {
        C272152() {
            AppMethodBeat.m2504i(132715);
            this.xxI = C42006ig.class.getName().hashCode();
            AppMethodBeat.m2505o(132715);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            ((C42006ig) c4883b).cDp.cDq = C38454c.this.iDy.f17886cD;
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o.c$a */
    public static class C33463a {
        public static C38454c iDD = new C38454c();

        static {
            AppMethodBeat.m2504i(132718);
            AppMethodBeat.m2505o(132718);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.o.c$3 */
    class C384533 extends C4884c<C37743ji> {
        C384533() {
            AppMethodBeat.m2504i(132716);
            this.xxI = C37743ji.class.getName().hashCode();
            AppMethodBeat.m2505o(132716);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(132717);
            C37743ji c37743ji = (C37743ji) c4883b;
            if (c37743ji.cEE.cut == 40 && c37743ji.cEE.cuu == 1) {
                File file = new File(c37743ji.cEE.filePath);
                if (file.exists()) {
                    C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                    C45661d c45661d = C45661d.iDE;
                    File file2 = new File(C45661d.aLD(), "temp");
                    File file3 = new File(file2, "wxa_fts_template.zip");
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    C1173e.m2577y(file.getAbsolutePath(), file3.getAbsolutePath());
                    int hU = C5046bo.m7570hU(file3.getAbsolutePath(), file2.getAbsolutePath());
                    int i = 65900182;
                    if (hU >= 0) {
                        c45661d = C45661d.iDE;
                        i = Integer.valueOf(C45661d.m84314J(new File(file2, "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
                    }
                    C1173e.m2575t(file2);
                    C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", Integer.valueOf(C38454c.this.iDy.f17886cD), Integer.valueOf(i));
                    if (C38454c.m65052f(file, new File(C38454c.this.iDy.gXQ))) {
                        C38454c.this.refresh();
                    } else {
                        C4990ab.m7412e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                }
            }
            AppMethodBeat.m2505o(132717);
            return false;
        }
    }

    /* synthetic */ C38454c(byte b) {
        this();
    }

    private C38454c() {
        AppMethodBeat.m2504i(132719);
        this.iDB = new C384533();
        this.iDy = new C45660b();
        this.iDz = new C196151();
        this.iDA = new C272152();
        AppMethodBeat.m2505o(132719);
    }

    public final void prepare() {
        AppMethodBeat.m2504i(132720);
        C4879a.xxA.mo10052c(this.iDz);
        C4879a.xxA.mo10052c(this.iDA);
        this.iDB.dnU();
        refresh();
        File file = new File(this.iDy.gXQ);
        C4990ab.m7411d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", Integer.valueOf(this.iDy.f17886cD), Integer.valueOf(65900182));
        if (this.iDy.f17886cD < 65900182 && C38454c.m65051d(file, "wxa_fts_template.zip")) {
            refresh();
        }
        AppMethodBeat.m2505o(132720);
    }

    /* Access modifiers changed, original: final */
    public final void refresh() {
        AppMethodBeat.m2504i(132721);
        C45660b c45660b = this.iDy;
        C45661d c45661d = C45661d.iDE;
        c45660b.f17886cD = C45661d.aLE();
        c45660b = this.iDy;
        c45661d = C45661d.iDE;
        c45660b.gXQ = C45661d.aLD();
        AppMethodBeat.m2505o(132721);
    }

    /* renamed from: d */
    private static boolean m65051d(File file, String str) {
        AppMethodBeat.m2504i(132722);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(132722);
            return false;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        C45661d c45661d = C45661d.iDE;
        boolean cM = C45661d.m84315cM(absolutePath, str);
        if (cM) {
            if (C5046bo.m7570hU(absolutePath, file3.getParent()) < 0) {
                C4990ab.m7413e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", Integer.valueOf(C5046bo.m7570hU(absolutePath, file3.getParent())), absolutePath, file3.getParent());
                AppMethodBeat.m2505o(132722);
                return false;
            }
            C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", file3.getAbsolutePath());
        } else {
            C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", file3.getAbsolutePath());
        }
        AppMethodBeat.m2505o(132722);
        return cM;
    }

    /* renamed from: f */
    static boolean m65052f(File file, File file2) {
        AppMethodBeat.m2504i(132723);
        C1173e.m2575t(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (C5046bo.m7570hU(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            C4990ab.m7413e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", Integer.valueOf(C5046bo.m7570hU(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath());
            AppMethodBeat.m2505o(132723);
            return false;
        }
        C4990ab.m7417i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", file2.getAbsolutePath());
        AppMethodBeat.m2505o(132723);
        return true;
    }
}
