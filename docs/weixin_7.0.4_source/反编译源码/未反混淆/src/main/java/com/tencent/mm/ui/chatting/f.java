package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {
    private static int yHo = 1;
    private static int yHp = 2;
    private static int yHq = 3;

    public static class a {
        public int vzW = 3;
        public int yHr;
        public int yHs = -1;
        public int yHt = -1;
        public long yHu = -1;

        public a(int i, int i2, int i3) {
            this.yHr = i;
            this.yHs = i2;
            this.yHt = i3;
        }

        public a(int i, long j) {
            this.yHr = i;
            this.yHu = j;
        }
    }

    public static a e(b bVar) {
        a aVar;
        AppMethodBeat.i(30457);
        String Yz = r.Yz();
        if (bVar.fii == 2 || bVar.fii == 3) {
            String[] split;
            if (!bo.ek(bVar.fim)) {
                for (String split2 : bVar.fim) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(Yz)) {
                        aVar = new a(bo.getInt(split[1], -1), bo.getInt(split[2], -1), bo.getInt(split[3], -1));
                        AppMethodBeat.o(30457);
                        return aVar;
                    }
                }
            }
            if (!bo.ek(bVar.fio)) {
                for (String split22 : bVar.fio) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(Yz)) {
                        aVar = new a(bo.getInt(split[2], -1), bo.getLong(split[1], -1));
                        AppMethodBeat.o(30457);
                        return aVar;
                    }
                }
            }
        }
        aVar = new a();
        AppMethodBeat.o(30457);
        return aVar;
    }

    public static int a(b bVar, boolean z) {
        AppMethodBeat.i(30458);
        a e = e(bVar);
        switch (bVar.fii) {
            case 2:
            case 3:
                if (z || e.vzW == 1) {
                    if (e.yHr > 0 && e.yHs >= 0 && e.yHt >= 0) {
                        switch (e.yHr) {
                            case 1:
                            case 2:
                                AppMethodBeat.o(30458);
                                return R.raw.c2c_aa_icon_default;
                            case 3:
                                AppMethodBeat.o(30458);
                                return R.raw.c2c_aa_icon_check;
                            case 4:
                                AppMethodBeat.o(30458);
                                return R.raw.c2c_aa_icon_close;
                        }
                    }
                } else if (e.vzW != 2) {
                    AppMethodBeat.o(30458);
                    return R.raw.c2c_aa_icon_check;
                } else if (e.yHr > 0 && e.yHu >= 0) {
                    switch (e.yHr) {
                        case 1:
                            AppMethodBeat.o(30458);
                            return R.raw.c2c_aa_icon_default;
                        case 2:
                        case 3:
                            AppMethodBeat.o(30458);
                            return R.raw.c2c_aa_icon_check;
                        case 4:
                            AppMethodBeat.o(30458);
                            return R.raw.c2c_aa_icon_close;
                    }
                }
                break;
        }
        AppMethodBeat.o(30458);
        return R.raw.c2c_aa_icon_check;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String b(b bVar, boolean z) {
        AppMethodBeat.i(30459);
        try {
            String Yz = r.Yz();
            String str;
            if (bVar.fii > 0) {
                int i;
                Object obj = null;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                Object obj2 = null;
                long j = -1;
                str = bVar.fih;
                uz uzVar = new uz();
                uzVar.cRN.cRP = str;
                com.tencent.mm.sdk.b.a.xxA.m(uzVar);
                if (bVar.fii == 2 || bVar.fii == 3) {
                    String[] split;
                    if (!bo.ek(bVar.fim)) {
                        for (String str2 : bVar.fim) {
                            split = str2.split(",");
                            if (split.length == 4 && split[0].equals(Yz)) {
                                i2 = bo.getInt(split[1], -1);
                                i3 = bo.getInt(split[2], -1);
                                i4 = bo.getInt(split[3], -1);
                                obj = 1;
                                break;
                            }
                        }
                    }
                    if (!bo.ek(bVar.fio)) {
                        for (String str22 : bVar.fio) {
                            split = str22.split(",");
                            if (split.length == 3 && split[0].equals(Yz)) {
                                j = bo.getLong(split[1], -1);
                                i = bo.getInt(split[2], -1);
                                obj2 = 1;
                                break;
                            }
                        }
                    }
                }
                i = -1;
                if (uzVar.cRO.status == yHq) {
                    str22 = ah.getContext().getString(R.string.bj);
                    AppMethodBeat.o(30459);
                    return str22;
                } else if (uzVar.cRO.status == yHp) {
                    str22 = ah.getContext().getString(R.string.bc);
                    AppMethodBeat.o(30459);
                    return str22;
                } else {
                    switch (bVar.fii) {
                        case 1:
                            if (z) {
                                str22 = bVar.fhU;
                                AppMethodBeat.o(30459);
                                return str22;
                            }
                            str22 = bVar.fhV;
                            AppMethodBeat.o(30459);
                            return str22;
                        case 2:
                        case 3:
                            if (Yz.equals(bVar.fir) || z || obj != null) {
                                if (i2 > 0 && i3 >= 0 && i4 >= 0) {
                                    switch (i2) {
                                        case 1:
                                            str22 = ah.getContext().getString(R.string.bk);
                                            AppMethodBeat.o(30459);
                                            return str22;
                                        case 2:
                                            str22 = ah.getContext().getString(R.string.bi, new Object[]{Integer.valueOf(i3 - i4)});
                                            AppMethodBeat.o(30459);
                                            return str22;
                                        case 3:
                                            str22 = ah.getContext().getString(R.string.bh);
                                            AppMethodBeat.o(30459);
                                            return str22;
                                        case 4:
                                            str22 = ah.getContext().getString(R.string.bj);
                                            AppMethodBeat.o(30459);
                                            return str22;
                                        default:
                                            break;
                                    }
                                }
                            } else if (obj2 == null) {
                                str22 = ah.getContext().getString(R.string.bf);
                                AppMethodBeat.o(30459);
                                return str22;
                            } else if (i > 0 && j >= 0) {
                                switch (i) {
                                    case 1:
                                        str22 = ah.getContext().getString(R.string.be, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                        AppMethodBeat.o(30459);
                                        return str22;
                                    case 2:
                                        str22 = ah.getContext().getString(R.string.bd, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                        AppMethodBeat.o(30459);
                                        return str22;
                                    case 3:
                                        str22 = ah.getContext().getString(R.string.bg, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                        AppMethodBeat.o(30459);
                                        return str22;
                                    case 4:
                                        str22 = ah.getContext().getString(R.string.bf);
                                        AppMethodBeat.o(30459);
                                        return str22;
                                }
                            }
                            break;
                    }
                    if (z) {
                        str22 = bVar.fhU;
                        AppMethodBeat.o(30459);
                        return str22;
                    }
                    str22 = bVar.fhV;
                    AppMethodBeat.o(30459);
                    return str22;
                }
            } else if (z) {
                str22 = bVar.fhU;
                AppMethodBeat.o(30459);
                return str22;
            } else {
                str22 = bVar.fhV;
                AppMethodBeat.o(30459);
                return str22;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", e.getMessage());
        }
    }

    public static String a(int i, int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(30460);
        Context context = ah.getContext();
        ab.d("MicroMsg.C2CAppMsgUtil", "getC2CLuckyMoneyDescByHbStatus() hbType:%s hbStatus:%s receiveStatus:%s isGroupChat:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2));
        String string;
        if (i2 == 5) {
            string = context.getString(R.string.cq7);
            AppMethodBeat.o(30460);
            return string;
        }
        if (i == 1) {
            if (i2 == 4) {
                if (i3 == 2) {
                    string = context.getString(R.string.cq8);
                    AppMethodBeat.o(30460);
                    return string;
                }
                string = context.getString(R.string.cq6);
                AppMethodBeat.o(30460);
                return string;
            } else if (i2 == 3) {
                if (i3 == 2) {
                    string = context.getString(R.string.cq8);
                    AppMethodBeat.o(30460);
                    return string;
                }
                string = "";
                AppMethodBeat.o(30460);
                return string;
            }
        } else if (i == 0) {
            if (i2 == 4) {
                if (z) {
                    string = context.getString(R.string.cq6);
                    AppMethodBeat.o(30460);
                    return string;
                } else if (!z2) {
                    string = context.getString(R.string.cq8);
                    AppMethodBeat.o(30460);
                    return string;
                } else if (i3 == 2) {
                    string = context.getString(R.string.cq8);
                    AppMethodBeat.o(30460);
                    return string;
                } else {
                    string = context.getString(R.string.cq6);
                    AppMethodBeat.o(30460);
                    return string;
                }
            } else if (i2 == 3) {
                if (z) {
                    string = "";
                    AppMethodBeat.o(30460);
                    return string;
                } else if (i3 == 2) {
                    string = context.getString(R.string.cq8);
                    AppMethodBeat.o(30460);
                    return string;
                } else {
                    string = "";
                    AppMethodBeat.o(30460);
                    return string;
                }
            }
        } else if (i2 == 4) {
            if (!z2 || (z && i3 == 2)) {
                string = context.getString(R.string.cq8);
                AppMethodBeat.o(30460);
                return string;
            }
            string = context.getString(R.string.cq6);
            AppMethodBeat.o(30460);
            return string;
        } else if (i2 == 3) {
            if (i3 != 2) {
                string = "";
                AppMethodBeat.o(30460);
                return string;
            } else if (z) {
                string = "";
                AppMethodBeat.o(30460);
                return string;
            } else {
                string = context.getString(R.string.cq8);
                AppMethodBeat.o(30460);
                return string;
            }
        }
        string = "";
        AppMethodBeat.o(30460);
        return string;
    }

    public static int v(int i, int i2, boolean z) {
        return i == 5 ? z ? R.drawable.g2 : R.drawable.g0 : i == 4 ? !z ? R.drawable.g0 : R.drawable.g2 : i == 3 ? i2 == 2 ? !z ? R.drawable.g0 : R.drawable.g2 : z ? R.drawable.g1 : R.drawable.fz : z ? R.drawable.g1 : R.drawable.fz;
    }

    public static int w(int i, int i2, boolean z) {
        if (i == 5 || i == 4) {
            return R.drawable.bac;
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
        return R.drawable.bac;
    }

    public static int x(int i, int i2, boolean z) {
        return i == 5 ? z ? R.drawable.sz : R.drawable.sa : i == 4 ? !z ? R.drawable.sa : R.drawable.sz : i == 3 ? i2 == 2 ? !z ? R.drawable.sa : R.drawable.sz : z ? R.drawable.sy : R.drawable.s_ : z ? R.drawable.sy : R.drawable.s_;
    }

    public static int c(b bVar, boolean z) {
        AppMethodBeat.i(30461);
        if (bVar != null) {
            String str = bVar.fih;
            uz uzVar = new uz();
            uzVar.cRN.cRP = str;
            com.tencent.mm.sdk.b.a.xxA.m(uzVar);
            if (uzVar.cRO.status != yHq && uzVar.cRO.status != yHp) {
                a e = e(bVar);
                switch (bVar.fii) {
                    case 2:
                    case 3:
                        if (z || e.vzW == 1) {
                            if (e.yHr > 0 && e.yHs >= 0 && e.yHt >= 0) {
                                switch (e.yHr) {
                                    case 1:
                                    case 2:
                                        if (z) {
                                            AppMethodBeat.o(30461);
                                            return R.drawable.e;
                                        }
                                        AppMethodBeat.o(30461);
                                        return R.drawable.c;
                                    case 3:
                                    case 4:
                                        if (z) {
                                            AppMethodBeat.o(30461);
                                            return R.drawable.f;
                                        }
                                        AppMethodBeat.o(30461);
                                        return R.drawable.d;
                                }
                            }
                        } else if (e.vzW == 2) {
                            if (e.yHr > 0 && e.yHu >= 0) {
                                switch (e.yHr) {
                                    case 1:
                                        if (z) {
                                            AppMethodBeat.o(30461);
                                            return R.drawable.e;
                                        }
                                        AppMethodBeat.o(30461);
                                        return R.drawable.c;
                                    case 2:
                                    case 3:
                                    case 4:
                                        if (z) {
                                            AppMethodBeat.o(30461);
                                            return R.drawable.f;
                                        }
                                        AppMethodBeat.o(30461);
                                        return R.drawable.d;
                                }
                            }
                        } else if (z) {
                            AppMethodBeat.o(30461);
                            return R.drawable.e;
                        } else {
                            AppMethodBeat.o(30461);
                            return R.drawable.c;
                        }
                        break;
                }
                if (z) {
                    AppMethodBeat.o(30461);
                    return R.drawable.e;
                }
                AppMethodBeat.o(30461);
                return R.drawable.c;
            } else if (z) {
                AppMethodBeat.o(30461);
                return R.drawable.f;
            } else {
                AppMethodBeat.o(30461);
                return R.drawable.d;
            }
        } else if (z) {
            AppMethodBeat.o(30461);
            return R.drawable.e;
        } else {
            AppMethodBeat.o(30461);
            return R.drawable.c;
        }
    }

    public static int d(b bVar, boolean z) {
        AppMethodBeat.i(30462);
        if (bVar == null) {
            AppMethodBeat.o(30462);
            return -12479656;
        }
        String str = bVar.fih;
        uz uzVar = new uz();
        uzVar.cRN.cRP = str;
        com.tencent.mm.sdk.b.a.xxA.m(uzVar);
        if (uzVar.cRO.status == yHq || uzVar.cRO.status == yHp) {
            AppMethodBeat.o(30462);
            return -8868722;
        }
        a e = e(bVar);
        switch (bVar.fii) {
            case 2:
            case 3:
                if (z || e.vzW == 1) {
                    if (e.yHr > 0 && e.yHs >= 0 && e.yHt >= 0) {
                        switch (e.yHr) {
                            case 1:
                            case 2:
                                AppMethodBeat.o(30462);
                                return -12479656;
                            case 3:
                            case 4:
                                AppMethodBeat.o(30462);
                                return -8868722;
                        }
                    }
                } else if (e.vzW != 2) {
                    AppMethodBeat.o(30462);
                    return -12479656;
                } else if (e.yHr > 0 && e.yHu >= 0) {
                    switch (e.yHr) {
                        case 1:
                            AppMethodBeat.o(30462);
                            return -12479656;
                        case 2:
                        case 3:
                        case 4:
                            AppMethodBeat.o(30462);
                            return -8868722;
                    }
                }
                break;
        }
        AppMethodBeat.o(30462);
        return -12479656;
    }
}
