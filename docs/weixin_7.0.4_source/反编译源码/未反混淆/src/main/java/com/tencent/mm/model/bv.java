package com.tencent.mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class bv {
    public static final int fnu;
    public static final int fnv;
    public static final int fnw = (fnu + 2);
    private static bv fnz;
    private long fnx = 0;
    private Map<Integer, a> fny = new HashMap();

    abstract class a {
        public abstract boolean a(bt btVar);

        private a() {
        }

        /* synthetic */ a(bv bvVar, byte b) {
            this();
        }

        public bt d(int i, Object... objArr) {
            int i2 = 1;
            if (objArr != null && objArr.length > 0) {
                i2 = bo.g(objArr[0], 1);
            }
            bt btVar = new bt();
            btVar.key = i;
            btVar.fns = String.valueOf(i2);
            btVar.eRt = 0;
            return btVar;
        }

        public void a(bt btVar, Object... objArr) {
            int i = 1;
            if (objArr != null && objArr.length > 0) {
                i = bo.g(objArr[0], 1);
            }
            btVar.fns = (i + bo.getInt(btVar.fns, 0));
        }
    }

    static {
        AppMethodBeat.i(72649);
        int hashCode = "kv_key_start".hashCode();
        fnu = hashCode;
        fnv = hashCode + 1;
        AppMethodBeat.o(72649);
    }

    private bv() {
        AppMethodBeat.i(72641);
        this.fny.put(Integer.valueOf(fnv), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72617);
                if (System.currentTimeMillis() - btVar.eRt <= 3600000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72617);
                    return false;
                }
                bv.s(23, btVar.fns + "_3");
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72617);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(fnw), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72628);
                if (System.currentTimeMillis() - btVar.eRt <= 3600000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72628);
                    return false;
                }
                bv.s(23, btVar.fns + "_43");
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72628);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(24), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72632);
                if (System.currentTimeMillis() - btVar.eRt <= 3600000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72632);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72632);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(25), new a() {
            public final bt d(int i, Object... objArr) {
                AppMethodBeat.i(72633);
                bt btVar = new bt();
                btVar.key = i;
                if (objArr != null && objArr.length > 0) {
                    btVar.fns = objArr[0];
                }
                btVar.eRt = 0;
                AppMethodBeat.o(72633);
                return btVar;
            }

            public final void a(bt btVar, Object... objArr) {
                AppMethodBeat.i(72634);
                if (objArr != null && objArr.length > 0) {
                    btVar.fns = objArr[0];
                }
                AppMethodBeat.o(72634);
            }

            public final boolean a(bt btVar) {
                AppMethodBeat.i(72635);
                if (System.currentTimeMillis() - btVar.eRt <= 3600000 || btVar.fns.length() <= 0) {
                    AppMethodBeat.o(72635);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = "";
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72635);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(26), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72636);
                if (System.currentTimeMillis() - btVar.eRt <= 3600000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72636);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72636);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10071), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72637);
                if (System.currentTimeMillis() - btVar.eRt <= 86400000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72637);
                    return false;
                }
                bv.s(btVar.key, "1");
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72637);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10076), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72638);
                if (System.currentTimeMillis() - btVar.eRt <= 3600000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72638);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72638);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(19), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72639);
                if (System.currentTimeMillis() - btVar.eRt <= 86400000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72639);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72639);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10112), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72640);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72640);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72640);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10113), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72618);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72618);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72618);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10114), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72619);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72619);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72619);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10115), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72620);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72620);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72620);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10240), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72621);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72621);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72621);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10241), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72622);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72622);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72622);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(15), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72623);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72623);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72623);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(16), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72624);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72624);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72624);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(27), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72625);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72625);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72625);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(38), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72626);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72626);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72626);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10090), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72627);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72627);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72627);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10237), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72629);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72629);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72629);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10238), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72630);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72630);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72630);
                return true;
            }
        });
        this.fny.put(Integer.valueOf(10239), new a() {
            public final boolean a(bt btVar) {
                AppMethodBeat.i(72631);
                if (System.currentTimeMillis() - btVar.eRt <= 1800000 || bo.getInt(btVar.fns, 0) <= 0) {
                    AppMethodBeat.o(72631);
                    return false;
                }
                bv.s(btVar.key, btVar.fns);
                btVar.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                btVar.eRt = System.currentTimeMillis();
                AppMethodBeat.o(72631);
                return true;
            }
        });
        AppMethodBeat.o(72641);
    }

    public static bv aaq() {
        AppMethodBeat.i(72642);
        if (fnz == null) {
            fnz = new bv();
        }
        bv bvVar = fnz;
        AppMethodBeat.o(72642);
        return bvVar;
    }

    public static void s(int i, String str) {
        AppMethodBeat.i(72643);
        LinkedList linkedList = new LinkedList();
        axd axd = new axd();
        axd.pXC = i;
        axd.pXM = str;
        linkedList.add(axd);
        b(linkedList);
        AppMethodBeat.o(72643);
    }

    public static void b(LinkedList<axd> linkedList) {
        AppMethodBeat.i(72644);
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                axe axe = new axe();
                axe.jBw = linkedList;
                axe.jBv = linkedList.size();
                ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(36, axe));
            }
        }
        AppMethodBeat.o(72644);
    }

    public final void c(int i, Object... objArr) {
        AppMethodBeat.i(72645);
        a aVar = (a) this.fny.get(Integer.valueOf(i));
        if (aVar == null) {
            AppMethodBeat.o(72645);
            return;
        }
        bu aas = aas();
        for (bt btVar : aas.fnt) {
            if (btVar.key == i) {
                aVar.a(btVar, objArr);
                break;
            }
        }
        aas.fnt.add(aVar.d(i, objArr));
        a(aas);
        AppMethodBeat.o(72645);
    }

    public final void aar() {
        AppMethodBeat.i(72646);
        if (System.currentTimeMillis() - this.fnx < 60000) {
            AppMethodBeat.o(72646);
            return;
        }
        this.fnx = System.currentTimeMillis();
        try {
            bu aas = aas();
            int i = 0;
            for (bt btVar : aas.fnt) {
                int i2;
                a aVar = (a) this.fny.get(Integer.valueOf(btVar.key));
                if (aVar == null || !aVar.a(btVar)) {
                    i2 = i;
                } else {
                    i2 = 1;
                }
                i = i2;
            }
            if (i != 0) {
                a(aas);
            }
            AppMethodBeat.o(72646);
        } catch (Exception e) {
            ab.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bo.l(e));
            AppMethodBeat.o(72646);
        }
    }

    private static bu aas() {
        bu buVar;
        AppMethodBeat.i(72647);
        if (g.RN().QY()) {
            g.RN();
            if (!(com.tencent.mm.kernel.a.QT() || g.RP().Ry() == null)) {
                byte[] anf = bo.anf((String) g.RP().Ry().get(8215, null));
                if (anf.length <= 0) {
                    buVar = new bu();
                    AppMethodBeat.o(72647);
                    return buVar;
                }
                try {
                    buVar = new bu();
                    buVar.parseFrom(anf);
                    AppMethodBeat.o(72647);
                    return buVar;
                } catch (IOException e) {
                    ab.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bo.l(e));
                }
            }
        }
        buVar = new bu();
        AppMethodBeat.o(72647);
        return buVar;
    }

    private static void a(bu buVar) {
        AppMethodBeat.i(72648);
        if (!(buVar == null || !g.RN().QY() || g.RP().Ry() == null)) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                try {
                    g.RP().Ry().set(8215, bo.cd(buVar.toByteArray()));
                    AppMethodBeat.o(72648);
                    return;
                } catch (IOException e) {
                    ab.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", bo.l(e));
                }
            }
        }
        AppMethodBeat.o(72648);
    }
}
