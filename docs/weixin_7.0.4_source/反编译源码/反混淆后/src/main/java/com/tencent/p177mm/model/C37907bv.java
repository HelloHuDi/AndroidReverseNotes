package com.tencent.p177mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.axd;
import com.tencent.p177mm.protocal.protobuf.axe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.model.bv */
public final class C37907bv {
    public static final int fnu;
    public static final int fnv;
    public static final int fnw = (fnu + 2);
    private static C37907bv fnz;
    private long fnx = 0;
    private Map<Integer, C1836a> fny = new HashMap();

    /* renamed from: com.tencent.mm.model.bv$a */
    abstract class C1836a {
        /* renamed from: a */
        public abstract boolean mo5412a(C42188bt c42188bt);

        private C1836a() {
        }

        /* synthetic */ C1836a(C37907bv c37907bv, byte b) {
            this();
        }

        /* renamed from: d */
        public C42188bt mo5413d(int i, Object... objArr) {
            int i2 = 1;
            if (objArr != null && objArr.length > 0) {
                i2 = C5046bo.m7550g(objArr[0], 1);
            }
            C42188bt c42188bt = new C42188bt();
            c42188bt.key = i;
            c42188bt.fns = String.valueOf(i2);
            c42188bt.eRt = 0;
            return c42188bt;
        }

        /* renamed from: a */
        public void mo5411a(C42188bt c42188bt, Object... objArr) {
            int i = 1;
            if (objArr != null && objArr.length > 0) {
                i = C5046bo.m7550g(objArr[0], 1);
            }
            c42188bt.fns = (i + C5046bo.getInt(c42188bt.fns, 0));
        }
    }

    /* renamed from: com.tencent.mm.model.bv$5 */
    class C66705 extends C1836a {
        C66705() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72621);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72621);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72621);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$6 */
    class C66716 extends C1836a {
        C66716() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72622);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72622);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72622);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$8 */
    class C66728 extends C1836a {
        C66728() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72624);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72624);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72624);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$14 */
    class C965214 extends C1836a {
        C965214() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72630);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72630);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72630);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$7 */
    class C96537 extends C1836a {
        C96537() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72623);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72623);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72623);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$12 */
    class C1861912 extends C1836a {
        C1861912() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72628);
            if (System.currentTimeMillis() - c42188bt.eRt <= 3600000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72628);
                return false;
            }
            C37907bv.m64020s(23, c42188bt.fns + "_43");
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72628);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$15 */
    class C2641915 extends C1836a {
        C2641915() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72631);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72631);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72631);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$20 */
    class C2642020 extends C1836a {
        C2642020() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72638);
            if (System.currentTimeMillis() - c42188bt.eRt <= 3600000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72638);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72638);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$13 */
    class C3278313 extends C1836a {
        C3278313() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72629);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72629);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72629);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$1 */
    class C327841 extends C1836a {
        C327841() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72617);
            if (System.currentTimeMillis() - c42188bt.eRt <= 3600000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72617);
                return false;
            }
            C37907bv.m64020s(23, c42188bt.fns + "_3");
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72617);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$2 */
    class C327852 extends C1836a {
        C327852() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72618);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72618);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72618);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$3 */
    class C327863 extends C1836a {
        C327863() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72619);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72619);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72619);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$4 */
    class C327874 extends C1836a {
        C327874() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72620);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72620);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72620);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$9 */
    class C327889 extends C1836a {
        C327889() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72625);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72625);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72625);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$16 */
    class C3790516 extends C1836a {
        C3790516() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72632);
            if (System.currentTimeMillis() - c42188bt.eRt <= 3600000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72632);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72632);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$19 */
    class C3790619 extends C1836a {
        C3790619() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72637);
            if (System.currentTimeMillis() - c42188bt.eRt <= 86400000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72637);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, "1");
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72637);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$10 */
    class C3790810 extends C1836a {
        C3790810() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72626);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72626);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72626);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$11 */
    class C3790911 extends C1836a {
        C3790911() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72627);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72627);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72627);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$17 */
    class C3791017 extends C1836a {
        C3791017() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: d */
        public final C42188bt mo5413d(int i, Object... objArr) {
            AppMethodBeat.m2504i(72633);
            C42188bt c42188bt = new C42188bt();
            c42188bt.key = i;
            if (objArr != null && objArr.length > 0) {
                c42188bt.fns = objArr[0];
            }
            c42188bt.eRt = 0;
            AppMethodBeat.m2505o(72633);
            return c42188bt;
        }

        /* renamed from: a */
        public final void mo5411a(C42188bt c42188bt, Object... objArr) {
            AppMethodBeat.m2504i(72634);
            if (objArr != null && objArr.length > 0) {
                c42188bt.fns = objArr[0];
            }
            AppMethodBeat.m2505o(72634);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72635);
            if (System.currentTimeMillis() - c42188bt.eRt <= 3600000 || c42188bt.fns.length() <= 0) {
                AppMethodBeat.m2505o(72635);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = "";
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72635);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$21 */
    class C3791121 extends C1836a {
        C3791121() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72639);
            if (System.currentTimeMillis() - c42188bt.eRt <= 86400000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72639);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72639);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$22 */
    class C3791222 extends C1836a {
        C3791222() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72640);
            if (System.currentTimeMillis() - c42188bt.eRt <= 1800000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72640);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72640);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.model.bv$18 */
    class C3791318 extends C1836a {
        C3791318() {
            super(C37907bv.this, (byte) 0);
        }

        /* renamed from: a */
        public final boolean mo5412a(C42188bt c42188bt) {
            AppMethodBeat.m2504i(72636);
            if (System.currentTimeMillis() - c42188bt.eRt <= 3600000 || C5046bo.getInt(c42188bt.fns, 0) <= 0) {
                AppMethodBeat.m2505o(72636);
                return false;
            }
            C37907bv.m64020s(c42188bt.key, c42188bt.fns);
            c42188bt.fns = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            c42188bt.eRt = System.currentTimeMillis();
            AppMethodBeat.m2505o(72636);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(72649);
        int hashCode = "kv_key_start".hashCode();
        fnu = hashCode;
        fnv = hashCode + 1;
        AppMethodBeat.m2505o(72649);
    }

    private C37907bv() {
        AppMethodBeat.m2504i(72641);
        this.fny.put(Integer.valueOf(fnv), new C327841());
        this.fny.put(Integer.valueOf(fnw), new C1861912());
        this.fny.put(Integer.valueOf(24), new C3790516());
        this.fny.put(Integer.valueOf(25), new C3791017());
        this.fny.put(Integer.valueOf(26), new C3791318());
        this.fny.put(Integer.valueOf(10071), new C3790619());
        this.fny.put(Integer.valueOf(10076), new C2642020());
        this.fny.put(Integer.valueOf(19), new C3791121());
        this.fny.put(Integer.valueOf(10112), new C3791222());
        this.fny.put(Integer.valueOf(10113), new C327852());
        this.fny.put(Integer.valueOf(10114), new C327863());
        this.fny.put(Integer.valueOf(10115), new C327874());
        this.fny.put(Integer.valueOf(10240), new C66705());
        this.fny.put(Integer.valueOf(10241), new C66716());
        this.fny.put(Integer.valueOf(15), new C96537());
        this.fny.put(Integer.valueOf(16), new C66728());
        this.fny.put(Integer.valueOf(27), new C327889());
        this.fny.put(Integer.valueOf(38), new C3790810());
        this.fny.put(Integer.valueOf(10090), new C3790911());
        this.fny.put(Integer.valueOf(10237), new C3278313());
        this.fny.put(Integer.valueOf(10238), new C965214());
        this.fny.put(Integer.valueOf(10239), new C2641915());
        AppMethodBeat.m2505o(72641);
    }

    public static C37907bv aaq() {
        AppMethodBeat.m2504i(72642);
        if (fnz == null) {
            fnz = new C37907bv();
        }
        C37907bv c37907bv = fnz;
        AppMethodBeat.m2505o(72642);
        return c37907bv;
    }

    /* renamed from: s */
    public static void m64020s(int i, String str) {
        AppMethodBeat.m2504i(72643);
        LinkedList linkedList = new LinkedList();
        axd axd = new axd();
        axd.pXC = i;
        axd.pXM = str;
        linkedList.add(axd);
        C37907bv.m64019b(linkedList);
        AppMethodBeat.m2505o(72643);
    }

    /* renamed from: b */
    public static void m64019b(LinkedList<axd> linkedList) {
        AppMethodBeat.m2504i(72644);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                axe axe = new axe();
                axe.jBw = linkedList;
                axe.jBv = linkedList.size();
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(36, axe));
            }
        }
        AppMethodBeat.m2505o(72644);
    }

    /* renamed from: c */
    public final void mo60662c(int i, Object... objArr) {
        AppMethodBeat.m2504i(72645);
        C1836a c1836a = (C1836a) this.fny.get(Integer.valueOf(i));
        if (c1836a == null) {
            AppMethodBeat.m2505o(72645);
            return;
        }
        C42189bu aas = C37907bv.aas();
        for (C42188bt c42188bt : aas.fnt) {
            if (c42188bt.key == i) {
                c1836a.mo5411a(c42188bt, objArr);
                break;
            }
        }
        aas.fnt.add(c1836a.mo5413d(i, objArr));
        C37907bv.m64018a(aas);
        AppMethodBeat.m2505o(72645);
    }

    public final void aar() {
        AppMethodBeat.m2504i(72646);
        if (System.currentTimeMillis() - this.fnx < 60000) {
            AppMethodBeat.m2505o(72646);
            return;
        }
        this.fnx = System.currentTimeMillis();
        try {
            C42189bu aas = C37907bv.aas();
            int i = 0;
            for (C42188bt c42188bt : aas.fnt) {
                int i2;
                C1836a c1836a = (C1836a) this.fny.get(Integer.valueOf(c42188bt.key));
                if (c1836a == null || !c1836a.mo5412a(c42188bt)) {
                    i2 = i;
                } else {
                    i2 = 1;
                }
                i = i2;
            }
            if (i != 0) {
                C37907bv.m64018a(aas);
            }
            AppMethodBeat.m2505o(72646);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.StatisticsKVReportLogic", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(72646);
        }
    }

    private static C42189bu aas() {
        C42189bu c42189bu;
        AppMethodBeat.m2504i(72647);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!(C1668a.m3393QT() || C1720g.m3536RP().mo5239Ry() == null)) {
                byte[] anf = C5046bo.anf((String) C1720g.m3536RP().mo5239Ry().get(8215, null));
                if (anf.length <= 0) {
                    c42189bu = new C42189bu();
                    AppMethodBeat.m2505o(72647);
                    return c42189bu;
                }
                try {
                    c42189bu = new C42189bu();
                    c42189bu.parseFrom(anf);
                    AppMethodBeat.m2505o(72647);
                    return c42189bu;
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.StatisticsKVReportLogic", "exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        c42189bu = new C42189bu();
        AppMethodBeat.m2505o(72647);
        return c42189bu;
    }

    /* renamed from: a */
    private static void m64018a(C42189bu c42189bu) {
        AppMethodBeat.m2504i(72648);
        if (!(c42189bu == null || !C1720g.m3534RN().mo5161QY() || C1720g.m3536RP().mo5239Ry() == null)) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                try {
                    C1720g.m3536RP().mo5239Ry().set(8215, C5046bo.m7543cd(c42189bu.toByteArray()));
                    AppMethodBeat.m2505o(72648);
                    return;
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.StatisticsKVReportLogic", "exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        AppMethodBeat.m2505o(72648);
    }
}
