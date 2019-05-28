package com.tencent.p177mm.p612ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C18421uz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.chatting.f */
public final class C15642f {
    private static int yHo = 1;
    private static int yHp = 2;
    private static int yHq = 3;

    /* renamed from: com.tencent.mm.ui.chatting.f$a */
    public static class C15643a {
        public int vzW = 3;
        public int yHr;
        public int yHs = -1;
        public int yHt = -1;
        public long yHu = -1;

        public C15643a(int i, int i2, int i3) {
            this.yHr = i;
            this.yHs = i2;
            this.yHt = i3;
        }

        public C15643a(int i, long j) {
            this.yHr = i;
            this.yHu = j;
        }
    }

    /* renamed from: e */
    public static C15643a m23933e(C8910b c8910b) {
        C15643a c15643a;
        AppMethodBeat.m2504i(30457);
        String Yz = C1853r.m3846Yz();
        if (c8910b.fii == 2 || c8910b.fii == 3) {
            String[] split;
            if (!C5046bo.m7548ek(c8910b.fim)) {
                for (String split2 : c8910b.fim) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(Yz)) {
                        c15643a = new C15643a(C5046bo.getInt(split[1], -1), C5046bo.getInt(split[2], -1), C5046bo.getInt(split[3], -1));
                        AppMethodBeat.m2505o(30457);
                        return c15643a;
                    }
                }
            }
            if (!C5046bo.m7548ek(c8910b.fio)) {
                for (String split22 : c8910b.fio) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(Yz)) {
                        c15643a = new C15643a(C5046bo.getInt(split[2], -1), C5046bo.getLong(split[1], -1));
                        AppMethodBeat.m2505o(30457);
                        return c15643a;
                    }
                }
            }
        }
        c15643a = new C15643a();
        AppMethodBeat.m2505o(30457);
        return c15643a;
    }

    /* renamed from: a */
    public static int m23928a(C8910b c8910b, boolean z) {
        AppMethodBeat.m2504i(30458);
        C15643a e = C15642f.m23933e(c8910b);
        switch (c8910b.fii) {
            case 2:
            case 3:
                if (z || e.vzW == 1) {
                    if (e.yHr > 0 && e.yHs >= 0 && e.yHt >= 0) {
                        switch (e.yHr) {
                            case 1:
                            case 2:
                                AppMethodBeat.m2505o(30458);
                                return C1318a.c2c_aa_icon_default;
                            case 3:
                                AppMethodBeat.m2505o(30458);
                                return C1318a.c2c_aa_icon_check;
                            case 4:
                                AppMethodBeat.m2505o(30458);
                                return C1318a.c2c_aa_icon_close;
                        }
                    }
                } else if (e.vzW != 2) {
                    AppMethodBeat.m2505o(30458);
                    return C1318a.c2c_aa_icon_check;
                } else if (e.yHr > 0 && e.yHu >= 0) {
                    switch (e.yHr) {
                        case 1:
                            AppMethodBeat.m2505o(30458);
                            return C1318a.c2c_aa_icon_default;
                        case 2:
                        case 3:
                            AppMethodBeat.m2505o(30458);
                            return C1318a.c2c_aa_icon_check;
                        case 4:
                            AppMethodBeat.m2505o(30458);
                            return C1318a.c2c_aa_icon_close;
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(30458);
        return C1318a.c2c_aa_icon_check;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public static String m23930b(C8910b c8910b, boolean z) {
        AppMethodBeat.m2504i(30459);
        try {
            String Yz = C1853r.m3846Yz();
            String str;
            if (c8910b.fii > 0) {
                int i;
                Object obj = null;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                Object obj2 = null;
                long j = -1;
                str = c8910b.fih;
                C18421uz c18421uz = new C18421uz();
                c18421uz.cRN.cRP = str;
                C4879a.xxA.mo10055m(c18421uz);
                if (c8910b.fii == 2 || c8910b.fii == 3) {
                    String[] split;
                    if (!C5046bo.m7548ek(c8910b.fim)) {
                        for (String str2 : c8910b.fim) {
                            split = str2.split(",");
                            if (split.length == 4 && split[0].equals(Yz)) {
                                i2 = C5046bo.getInt(split[1], -1);
                                i3 = C5046bo.getInt(split[2], -1);
                                i4 = C5046bo.getInt(split[3], -1);
                                obj = 1;
                                break;
                            }
                        }
                    }
                    if (!C5046bo.m7548ek(c8910b.fio)) {
                        for (String str22 : c8910b.fio) {
                            split = str22.split(",");
                            if (split.length == 3 && split[0].equals(Yz)) {
                                j = C5046bo.getLong(split[1], -1);
                                i = C5046bo.getInt(split[2], -1);
                                obj2 = 1;
                                break;
                            }
                        }
                    }
                }
                i = -1;
                if (c18421uz.cRO.status == yHq) {
                    str22 = C4996ah.getContext().getString(C25738R.string.f8669bj);
                    AppMethodBeat.m2505o(30459);
                    return str22;
                } else if (c18421uz.cRO.status == yHp) {
                    str22 = C4996ah.getContext().getString(C25738R.string.f8662bc);
                    AppMethodBeat.m2505o(30459);
                    return str22;
                } else {
                    switch (c8910b.fii) {
                        case 1:
                            if (z) {
                                str22 = c8910b.fhU;
                                AppMethodBeat.m2505o(30459);
                                return str22;
                            }
                            str22 = c8910b.fhV;
                            AppMethodBeat.m2505o(30459);
                            return str22;
                        case 2:
                        case 3:
                            if (Yz.equals(c8910b.fir) || z || obj != null) {
                                if (i2 > 0 && i3 >= 0 && i4 >= 0) {
                                    switch (i2) {
                                        case 1:
                                            str22 = C4996ah.getContext().getString(C25738R.string.f8670bk);
                                            AppMethodBeat.m2505o(30459);
                                            return str22;
                                        case 2:
                                            str22 = C4996ah.getContext().getString(C25738R.string.f8668bi, new Object[]{Integer.valueOf(i3 - i4)});
                                            AppMethodBeat.m2505o(30459);
                                            return str22;
                                        case 3:
                                            str22 = C4996ah.getContext().getString(C25738R.string.f8667bh);
                                            AppMethodBeat.m2505o(30459);
                                            return str22;
                                        case 4:
                                            str22 = C4996ah.getContext().getString(C25738R.string.f8669bj);
                                            AppMethodBeat.m2505o(30459);
                                            return str22;
                                        default:
                                            break;
                                    }
                                }
                            } else if (obj2 == null) {
                                str22 = C4996ah.getContext().getString(C25738R.string.f8665bf);
                                AppMethodBeat.m2505o(30459);
                                return str22;
                            } else if (i > 0 && j >= 0) {
                                switch (i) {
                                    case 1:
                                        str22 = C4996ah.getContext().getString(C25738R.string.f8664be, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                        AppMethodBeat.m2505o(30459);
                                        return str22;
                                    case 2:
                                        str22 = C4996ah.getContext().getString(C25738R.string.f8663bd, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                        AppMethodBeat.m2505o(30459);
                                        return str22;
                                    case 3:
                                        str22 = C4996ah.getContext().getString(C25738R.string.f8666bg, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                        AppMethodBeat.m2505o(30459);
                                        return str22;
                                    case 4:
                                        str22 = C4996ah.getContext().getString(C25738R.string.f8665bf);
                                        AppMethodBeat.m2505o(30459);
                                        return str22;
                                }
                            }
                            break;
                    }
                    if (z) {
                        str22 = c8910b.fhU;
                        AppMethodBeat.m2505o(30459);
                        return str22;
                    }
                    str22 = c8910b.fhV;
                    AppMethodBeat.m2505o(30459);
                    return str22;
                }
            } else if (z) {
                str22 = c8910b.fhU;
                AppMethodBeat.m2505o(30459);
                return str22;
            } else {
                str22 = c8910b.fhV;
                AppMethodBeat.m2505o(30459);
                return str22;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", e.getMessage());
        }
    }

    /* renamed from: a */
    public static String m23929a(int i, int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.m2504i(30460);
        Context context = C4996ah.getContext();
        C4990ab.m7411d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2));
        String string;
        if (i2 == 5) {
            string = context.getString(C25738R.string.cq7);
            AppMethodBeat.m2505o(30460);
            return string;
        }
        if (i == 1) {
            if (i2 == 4) {
                if (i3 == 2) {
                    string = context.getString(C25738R.string.cq8);
                    AppMethodBeat.m2505o(30460);
                    return string;
                }
                string = context.getString(C25738R.string.cq6);
                AppMethodBeat.m2505o(30460);
                return string;
            } else if (i2 == 3) {
                if (i3 == 2) {
                    string = context.getString(C25738R.string.cq8);
                    AppMethodBeat.m2505o(30460);
                    return string;
                }
                string = "";
                AppMethodBeat.m2505o(30460);
                return string;
            }
        } else if (i == 0) {
            if (i2 == 4) {
                if (z) {
                    string = context.getString(C25738R.string.cq6);
                    AppMethodBeat.m2505o(30460);
                    return string;
                } else if (!z2) {
                    string = context.getString(C25738R.string.cq8);
                    AppMethodBeat.m2505o(30460);
                    return string;
                } else if (i3 == 2) {
                    string = context.getString(C25738R.string.cq8);
                    AppMethodBeat.m2505o(30460);
                    return string;
                } else {
                    string = context.getString(C25738R.string.cq6);
                    AppMethodBeat.m2505o(30460);
                    return string;
                }
            } else if (i2 == 3) {
                if (z) {
                    string = "";
                    AppMethodBeat.m2505o(30460);
                    return string;
                } else if (i3 == 2) {
                    string = context.getString(C25738R.string.cq8);
                    AppMethodBeat.m2505o(30460);
                    return string;
                } else {
                    string = "";
                    AppMethodBeat.m2505o(30460);
                    return string;
                }
            }
        } else if (i2 == 4) {
            if (!z2 || (z && i3 == 2)) {
                string = context.getString(C25738R.string.cq8);
                AppMethodBeat.m2505o(30460);
                return string;
            }
            string = context.getString(C25738R.string.cq6);
            AppMethodBeat.m2505o(30460);
            return string;
        } else if (i2 == 3) {
            if (i3 != 2) {
                string = "";
                AppMethodBeat.m2505o(30460);
                return string;
            } else if (z) {
                string = "";
                AppMethodBeat.m2505o(30460);
                return string;
            } else {
                string = context.getString(C25738R.string.cq8);
                AppMethodBeat.m2505o(30460);
                return string;
            }
        }
        string = "";
        AppMethodBeat.m2505o(30460);
        return string;
    }

    /* renamed from: v */
    public static int m23934v(int i, int i2, boolean z) {
        return i == 5 ? z ? C25738R.drawable.f6496g2 : C25738R.drawable.f6494g0 : i == 4 ? !z ? C25738R.drawable.f6494g0 : C25738R.drawable.f6496g2 : i == 3 ? i2 == 2 ? !z ? C25738R.drawable.f6494g0 : C25738R.drawable.f6496g2 : z ? C25738R.drawable.f6495g1 : C25738R.drawable.f6493fz : z ? C25738R.drawable.f6495g1 : C25738R.drawable.f6493fz;
    }

    /* renamed from: w */
    public static int m23935w(int i, int i2, boolean z) {
        if (i == 5 || i == 4) {
            return C25738R.drawable.bac;
        }
        if (i != 3) {
            return -1;
        }
        if (i2 != 2) {
            return -1;
        }
        if (z) {
            return -1;
        }
        return C25738R.drawable.bac;
    }

    /* renamed from: x */
    public static int m23936x(int i, int i2, boolean z) {
        return i == 5 ? z ? C25738R.drawable.f6848sz : C25738R.drawable.f6833sa : i == 4 ? !z ? C25738R.drawable.f6833sa : C25738R.drawable.f6848sz : i == 3 ? i2 == 2 ? !z ? C25738R.drawable.f6833sa : C25738R.drawable.f6848sz : z ? C25738R.drawable.f6847sy : C25738R.drawable.f6832s_ : z ? C25738R.drawable.f6847sy : C25738R.drawable.f6832s_;
    }

    /* renamed from: c */
    public static int m23931c(C8910b c8910b, boolean z) {
        AppMethodBeat.m2504i(30461);
        if (c8910b != null) {
            String str = c8910b.fih;
            C18421uz c18421uz = new C18421uz();
            c18421uz.cRN.cRP = str;
            C4879a.xxA.mo10055m(c18421uz);
            if (c18421uz.cRO.status != yHq && c18421uz.cRO.status != yHp) {
                C15643a e = C15642f.m23933e(c8910b);
                switch (c8910b.fii) {
                    case 2:
                    case 3:
                        if (z || e.vzW == 1) {
                            if (e.yHr > 0 && e.yHs >= 0 && e.yHt >= 0) {
                                switch (e.yHr) {
                                    case 1:
                                    case 2:
                                        if (z) {
                                            AppMethodBeat.m2505o(30461);
                                            return C25738R.drawable.f6291e;
                                        }
                                        AppMethodBeat.m2505o(30461);
                                        return C25738R.drawable.f6289c;
                                    case 3:
                                    case 4:
                                        if (z) {
                                            AppMethodBeat.m2505o(30461);
                                            return C25738R.drawable.f6292f;
                                        }
                                        AppMethodBeat.m2505o(30461);
                                        return C25738R.drawable.f6290d;
                                }
                            }
                        } else if (e.vzW == 2) {
                            if (e.yHr > 0 && e.yHu >= 0) {
                                switch (e.yHr) {
                                    case 1:
                                        if (z) {
                                            AppMethodBeat.m2505o(30461);
                                            return C25738R.drawable.f6291e;
                                        }
                                        AppMethodBeat.m2505o(30461);
                                        return C25738R.drawable.f6289c;
                                    case 2:
                                    case 3:
                                    case 4:
                                        if (z) {
                                            AppMethodBeat.m2505o(30461);
                                            return C25738R.drawable.f6292f;
                                        }
                                        AppMethodBeat.m2505o(30461);
                                        return C25738R.drawable.f6290d;
                                }
                            }
                        } else if (z) {
                            AppMethodBeat.m2505o(30461);
                            return C25738R.drawable.f6291e;
                        } else {
                            AppMethodBeat.m2505o(30461);
                            return C25738R.drawable.f6289c;
                        }
                        break;
                }
                if (z) {
                    AppMethodBeat.m2505o(30461);
                    return C25738R.drawable.f6291e;
                }
                AppMethodBeat.m2505o(30461);
                return C25738R.drawable.f6289c;
            } else if (z) {
                AppMethodBeat.m2505o(30461);
                return C25738R.drawable.f6292f;
            } else {
                AppMethodBeat.m2505o(30461);
                return C25738R.drawable.f6290d;
            }
        } else if (z) {
            AppMethodBeat.m2505o(30461);
            return C25738R.drawable.f6291e;
        } else {
            AppMethodBeat.m2505o(30461);
            return C25738R.drawable.f6289c;
        }
    }

    /* renamed from: d */
    public static int m23932d(C8910b c8910b, boolean z) {
        AppMethodBeat.m2504i(30462);
        if (c8910b == null) {
            AppMethodBeat.m2505o(30462);
            return -12479656;
        }
        String str = c8910b.fih;
        C18421uz c18421uz = new C18421uz();
        c18421uz.cRN.cRP = str;
        C4879a.xxA.mo10055m(c18421uz);
        if (c18421uz.cRO.status == yHq || c18421uz.cRO.status == yHp) {
            AppMethodBeat.m2505o(30462);
            return -8868722;
        }
        C15643a e = C15642f.m23933e(c8910b);
        switch (c8910b.fii) {
            case 2:
            case 3:
                if (z || e.vzW == 1) {
                    if (e.yHr > 0 && e.yHs >= 0 && e.yHt >= 0) {
                        switch (e.yHr) {
                            case 1:
                            case 2:
                                AppMethodBeat.m2505o(30462);
                                return -12479656;
                            case 3:
                            case 4:
                                AppMethodBeat.m2505o(30462);
                                return -8868722;
                        }
                    }
                } else if (e.vzW != 2) {
                    AppMethodBeat.m2505o(30462);
                    return -12479656;
                } else if (e.yHr > 0 && e.yHu >= 0) {
                    switch (e.yHr) {
                        case 1:
                            AppMethodBeat.m2505o(30462);
                            return -12479656;
                        case 2:
                        case 3:
                        case 4:
                            AppMethodBeat.m2505o(30462);
                            return -8868722;
                    }
                }
                break;
        }
        AppMethodBeat.m2505o(30462);
        return -12479656;
    }
}
