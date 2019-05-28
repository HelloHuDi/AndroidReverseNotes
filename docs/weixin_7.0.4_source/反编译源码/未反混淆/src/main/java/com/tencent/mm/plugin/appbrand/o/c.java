package com.tencent.mm.plugin.appbrand.o;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;

public final class c {
    public com.tencent.mm.sdk.b.c iDA;
    public com.tencent.mm.sdk.b.c iDB;
    b iDy;
    public com.tencent.mm.sdk.b.c iDz;

    public static class a {
        public static c iDD = new c();

        static {
            AppMethodBeat.i(132718);
            AppMethodBeat.o(132718);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        AppMethodBeat.i(132719);
        this.iDB = new com.tencent.mm.sdk.b.c<ji>() {
            {
                AppMethodBeat.i(132716);
                this.xxI = ji.class.getName().hashCode();
                AppMethodBeat.o(132716);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(132717);
                ji jiVar = (ji) bVar;
                if (jiVar.cEE.cut == 40 && jiVar.cEE.cuu == 1) {
                    File file = new File(jiVar.cEE.filePath);
                    if (file.exists()) {
                        ab.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                        d dVar = d.iDE;
                        File file2 = new File(d.aLD(), "temp");
                        File file3 = new File(file2, "wxa_fts_template.zip");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        e.y(file.getAbsolutePath(), file3.getAbsolutePath());
                        int hU = bo.hU(file3.getAbsolutePath(), file2.getAbsolutePath());
                        int i = 65900182;
                        if (hU >= 0) {
                            dVar = d.iDE;
                            i = Integer.valueOf(d.J(new File(file2, "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
                        }
                        e.t(file2);
                        ab.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", Integer.valueOf(c.this.iDy.cD), Integer.valueOf(i));
                        if (c.f(file, new File(c.this.iDy.gXQ))) {
                            c.this.refresh();
                        } else {
                            ab.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                        }
                    } else {
                        ab.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                    }
                }
                AppMethodBeat.o(132717);
                return false;
            }
        };
        this.iDy = new b();
        this.iDz = new com.tencent.mm.sdk.b.c<bf>() {
            {
                AppMethodBeat.i(132713);
                this.xxI = bf.class.getName().hashCode();
                AppMethodBeat.o(132713);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(132714);
                bf bfVar = (bf) bVar;
                if (bfVar.cus.cut == 40 && bfVar.cus.cuu == 1) {
                    File file = new File(bfVar.cus.filePath);
                    if (file.exists()) {
                        ab.i("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                        d dVar = d.iDE;
                        File file2 = new File(d.aLD(), "temp");
                        File file3 = new File(file2, "wxa_fts_template.zip");
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        e.y(file.getAbsolutePath(), file3.getAbsolutePath());
                        int hU = bo.hU(file3.getAbsolutePath(), file2.getAbsolutePath());
                        int i = 65900182;
                        if (hU >= 0) {
                            dVar = d.iDE;
                            i = Integer.valueOf(d.J(new File(file2, "config.conf")).getProperty("version", AppEventsConstants.EVENT_PARAM_VALUE_NO)).intValue();
                        }
                        e.t(file2);
                        if (i > c.this.iDy.cD) {
                            ab.i("MicroMsg.WxaFTSSearchCore", "res update template currentVersion : %d resVersion : %d", Integer.valueOf(c.this.iDy.cD), Integer.valueOf(i));
                            if (c.f(file, new File(c.this.iDy.gXQ))) {
                                c.this.refresh();
                            } else {
                                ab.e("MicroMsg.WxaFTSSearchCore", "unzip template from res downloader failed.");
                            }
                        } else {
                            ab.i("MicroMsg.WxaFTSSearchCore", "res no need update template currentVersion : %d resVersion : %d", Integer.valueOf(c.this.iDy.cD), Integer.valueOf(i));
                        }
                    } else {
                        ab.e("MicroMsg.WxaFTSSearchCore", "checkResUpdateListener file not exist");
                    }
                }
                AppMethodBeat.o(132714);
                return false;
            }
        };
        this.iDA = new com.tencent.mm.sdk.b.c<ig>() {
            {
                AppMethodBeat.i(132715);
                this.xxI = ig.class.getName().hashCode();
                AppMethodBeat.o(132715);
            }

            public final /* bridge */ /* synthetic */ boolean a(b bVar) {
                ((ig) bVar).cDp.cDq = c.this.iDy.cD;
                return true;
            }
        };
        AppMethodBeat.o(132719);
    }

    public final void prepare() {
        AppMethodBeat.i(132720);
        com.tencent.mm.sdk.b.a.xxA.c(this.iDz);
        com.tencent.mm.sdk.b.a.xxA.c(this.iDA);
        this.iDB.dnU();
        refresh();
        File file = new File(this.iDy.gXQ);
        ab.d("MicroMsg.WxaFTSSearchCore", "prepare(cv : %s, bv : %s)", Integer.valueOf(this.iDy.cD), Integer.valueOf(65900182));
        if (this.iDy.cD < 65900182 && d(file, "wxa_fts_template.zip")) {
            refresh();
        }
        AppMethodBeat.o(132720);
    }

    /* Access modifiers changed, original: final */
    public final void refresh() {
        AppMethodBeat.i(132721);
        b bVar = this.iDy;
        d dVar = d.iDE;
        bVar.cD = d.aLE();
        bVar = this.iDy;
        dVar = d.iDE;
        bVar.gXQ = d.aLD();
        AppMethodBeat.o(132721);
    }

    private static boolean d(File file, String str) {
        AppMethodBeat.i(132722);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(132722);
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
                ab.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        File file3 = new File(file, str);
        String absolutePath = file3.getAbsolutePath();
        d dVar = d.iDE;
        boolean cM = d.cM(absolutePath, str);
        if (cM) {
            if (bo.hU(absolutePath, file3.getParent()) < 0) {
                ab.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = %s", Integer.valueOf(bo.hU(absolutePath, file3.getParent())), absolutePath, file3.getParent());
                AppMethodBeat.o(132722);
                return false;
            }
            ab.i("MicroMsg.WxaFTSSearchCore", "unzip template files into dir(%s) successfully.", file3.getAbsolutePath());
        } else {
            ab.i("MicroMsg.WxaFTSSearchCore", "copy template file from asset fail %s", file3.getAbsolutePath());
        }
        AppMethodBeat.o(132722);
        return cM;
    }

    static boolean f(File file, File file2) {
        AppMethodBeat.i(132723);
        e.t(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.WxaFTSSearchCore", e, "create nomedia file error", new Object[0]);
            }
        }
        if (bo.hU(file.getAbsolutePath(), file2.getAbsolutePath()) < 0) {
            ab.e("MicroMsg.WxaFTSSearchCore", "unzip fail, ret = %s, zipFilePath = %s, unzipPath = ", Integer.valueOf(bo.hU(file.getAbsolutePath(), file2.getAbsolutePath())), file.getAbsolutePath(), file2.getAbsolutePath());
            AppMethodBeat.o(132723);
            return false;
        }
        ab.i("MicroMsg.WxaFTSSearchCore", "Unzip Path : %s.", file2.getAbsolutePath());
        AppMethodBeat.o(132723);
        return true;
    }
}
