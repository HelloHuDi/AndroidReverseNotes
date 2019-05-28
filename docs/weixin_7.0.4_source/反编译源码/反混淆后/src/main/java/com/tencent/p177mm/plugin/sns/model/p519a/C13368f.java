package com.tencent.p177mm.plugin.sns.model.p519a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.p177mm.compatible.p221e.C1422n;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.p519a.C34950c.C34949a;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.model.a.f */
public abstract class C13368f extends C34950c {
    protected boolean qOB = false;
    protected boolean qOC = false;
    protected boolean qOD = false;
    protected boolean qOE = false;

    public C13368f(C34949a c34949a, C46216a c46216a) {
        super(c34949a, c46216a);
    }

    /* renamed from: Yx */
    public final String mo8601Yx(String str) {
        Exception e;
        int i = 2;
        Object obj = null;
        String str2;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int obj4;
            String value = C26373g.m41964Nu().getValue("SnsCloseDownloadWebp");
            if (C5046bo.isNullOrNil(value)) {
                i2 = 0;
            } else {
                i2 = C5046bo.ank(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (C1427q.etn.esF == 2) {
                obj2 = null;
            } else if (C5046bo.isNullOrNil(C1947ae.gjm)) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
            if (!C1422n.m3014LD()) {
                obj3 = null;
            } else if (!C13373af.cnQ()) {
                obj3 = null;
            } else if (C5046bo.isNullOrNil(C1947ae.gjm)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (C1422n.m3014LD() && C13373af.cnP() && C5046bo.isNullOrNil(C1947ae.gjm)) {
                obj4 = 1;
            }
            if (!C5046bo.isNullOrNil(C1947ae.gjl) || !C5046bo.isNullOrNil(C1947ae.gjm)) {
                if (!C5046bo.isNullOrNil(C1947ae.gjl)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(C1947ae.gjl);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
                }
                if (!C5046bo.isNullOrNil(C1947ae.gjm)) {
                    str = C13368f.m21481l(str, "tp=" + C1947ae.gjm);
                    C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(str)));
                }
            } else if (obj3 != null) {
                str = C13368f.m21481l(str, "tp=wxpc");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj4 != null) {
                str = C13368f.m21481l(str, "tp=hevc");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj22 != null) {
                str = C13368f.m21481l(str, "tp=webp");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            }
            if (!(this.qOa == null || this.qOa.qJh.wET == 0)) {
                str = C13368f.m21481l(str, "enc=1");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.qOa.qJh.wEU + " " + this.qOa.qJh.wET + " " + str);
                C21904b.m33474kT(C19395n.CTRL_INDEX);
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
                return C13368f.m21481l(str2, "token=".concat(String.valueOf(charSequence2)), "idx=".concat(String.valueOf(obj4)));
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7412e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    /* renamed from: b */
    public final String mo25482b(String str, bau bau) {
        Exception e;
        int i = 2;
        Object obj = null;
        if (bau == null) {
            C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "appendUrlArg, media is null.");
            return mo8601Yx(str);
        }
        String str2;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int obj4;
            String value = C26373g.m41964Nu().getValue("SnsCloseDownloadWebp");
            if (C5046bo.isNullOrNil(value)) {
                i2 = 0;
            } else {
                i2 = C5046bo.ank(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (C1427q.etn.esF == 2) {
                obj2 = null;
            } else if (C5046bo.isNullOrNil(C1947ae.gjm)) {
                int obj22 = 1;
            } else {
                obj22 = null;
            }
            if (!C1422n.m3014LD()) {
                obj3 = null;
            } else if (!C13373af.cnQ()) {
                obj3 = null;
            } else if (C5046bo.isNullOrNil(C1947ae.gjm)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (C1422n.m3014LD() && C13373af.cnP() && C5046bo.isNullOrNil(C1947ae.gjm)) {
                obj4 = 1;
            }
            if (!C5046bo.isNullOrNil(C1947ae.gjl) || !C5046bo.isNullOrNil(C1947ae.gjm)) {
                if (!C5046bo.isNullOrNil(C1947ae.gjl)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(C1947ae.gjl);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
                }
                if (!C5046bo.isNullOrNil(C1947ae.gjm)) {
                    str = C13368f.m21481l(str, "tp=" + C1947ae.gjm);
                    C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  ".concat(String.valueOf(str)));
                }
            } else if (obj3 != null) {
                str = C13368f.m21481l(str, "tp=wxpc");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj4 != null) {
                str = C13368f.m21481l(str, "tp=hevc");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            } else if (obj22 != null) {
                str = C13368f.m21481l(str, "tp=webp");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "new url  ".concat(String.valueOf(str)));
            }
            if (bau.wET != 0) {
                str = C13368f.m21481l(str, "enc=1");
                C4990ab.m7416i("MicroMsg.SnsDownloadImageBase", "test for enckey " + bau.wEU + " " + bau.wET + " " + str);
                C21904b.m33474kT(C19395n.CTRL_INDEX);
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
                return C13368f.m21481l(str2, "token=".concat(String.valueOf(charSequence2)), "idx=".concat(String.valueOf(obj4)));
            } catch (Exception e2) {
                e = e2;
                C4990ab.m7412e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
        }
    }

    /* renamed from: l */
    private static String m21481l(String str, String... strArr) {
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
