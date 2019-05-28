package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.m.g;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class f extends c {
    protected boolean qOB = false;
    protected boolean qOC = false;
    protected boolean qOD = false;
    protected boolean qOE = false;

    public f(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String Yx(String str) {
        Exception e;
        int i = 2;
        Object obj = null;
        String str2;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int obj4;
            String value = g.Nu().getValue("SnsCloseDownloadWebp");
            if (bo.isNullOrNil(value)) {
                i2 = 0;
            } else {
                i2 = bo.ank(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (q.etn.esF == 2) {
                obj2 = null;
            } else if (bo.isNullOrNil(ae.gjm)) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
            if (!n.LD()) {
                obj3 = null;
            } else if (!af.cnQ()) {
                obj3 = null;
            } else if (bo.isNullOrNil(ae.gjm)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (n.LD() && af.cnP() && bo.isNullOrNil(ae.gjm)) {
                obj4 = 1;
            }
            if (!bo.isNullOrNil(ae.gjl) || !bo.isNullOrNil(ae.gjm)) {
                if (!bo.isNullOrNil(ae.gjl)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(ae.gjl);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
                }
                if (!bo.isNullOrNil(ae.gjm)) {
                    str = l(str, "tp=" + ae.gjm);
                    ab.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(str)));
                }
            } else if (obj3 != null) {
                str = l(str, "tp=wxpc");
                ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj4 != null) {
                str = l(str, "tp=hevc");
                ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj22 != null) {
                str = l(str, "tp=webp");
                ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            }
            if (!(this.qOa == null || this.qOa.qJh.wET == 0)) {
                str = l(str, "enc=1");
                ab.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.qOa.qJh.wEU + " " + this.qOa.qJh.wET + " " + str);
                b.kT(com.tencent.mm.plugin.appbrand.jsapi.g.n.CTRL_INDEX);
                this.qOE = true;
            }
            str2 = str;
            try {
                if (this.qOa == null || this.qOa.qJh == null) {
                    return str2;
                }
                CharSequence charSequence;
                bau bau = this.qOa.qJh;
                if (this.qOa.qNT) {
                    charSequence = bau.wEZ;
                } else {
                    Object charSequence2 = bau.wEW;
                }
                obj4 = this.qOa.qNT ? bau.wFa : bau.wEX;
                if (TextUtils.isEmpty(charSequence2)) {
                    return str2;
                }
                return l(str2, "token=".concat(String.valueOf(charSequence2)), "idx=".concat(String.valueOf(obj4)));
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    public final String b(String str, bau bau) {
        Exception e;
        int i = 2;
        Object obj = null;
        if (bau == null) {
            ab.i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
            return Yx(str);
        }
        String str2;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int obj4;
            String value = g.Nu().getValue("SnsCloseDownloadWebp");
            if (bo.isNullOrNil(value)) {
                i2 = 0;
            } else {
                i2 = bo.ank(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (q.etn.esF == 2) {
                obj2 = null;
            } else if (bo.isNullOrNil(ae.gjm)) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
            if (!n.LD()) {
                obj3 = null;
            } else if (!af.cnQ()) {
                obj3 = null;
            } else if (bo.isNullOrNil(ae.gjm)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (n.LD() && af.cnP() && bo.isNullOrNil(ae.gjm)) {
                obj4 = 1;
            }
            if (!bo.isNullOrNil(ae.gjl) || !bo.isNullOrNil(ae.gjm)) {
                if (!bo.isNullOrNil(ae.gjl)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(ae.gjl);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
                }
                if (!bo.isNullOrNil(ae.gjm)) {
                    str = l(str, "tp=" + ae.gjm);
                    ab.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(str)));
                }
            } else if (obj3 != null) {
                str = l(str, "tp=wxpc");
                ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj4 != null) {
                str = l(str, "tp=hevc");
                ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj22 != null) {
                str = l(str, "tp=webp");
                ab.i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            }
            if (bau.wET != 0) {
                str = l(str, "enc=1");
                ab.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + bau.wEU + " " + bau.wET + " " + str);
                b.kT(com.tencent.mm.plugin.appbrand.jsapi.g.n.CTRL_INDEX);
                this.qOE = true;
            }
            str2 = str;
            try {
                CharSequence charSequence;
                if (this.qOa.qNT) {
                    charSequence = bau.wEZ;
                } else {
                    Object charSequence2 = bau.wEW;
                }
                obj4 = this.qOa.qNT ? bau.wFa : bau.wEX;
                if (TextUtils.isEmpty(charSequence2)) {
                    return str2;
                }
                return l(str2, "token=".concat(String.valueOf(charSequence2)), "idx=".concat(String.valueOf(obj4)));
            } catch (Exception e2) {
                e = e2;
                ab.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    private static String l(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str.contains("?") ? "&" : "?");
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }
}
