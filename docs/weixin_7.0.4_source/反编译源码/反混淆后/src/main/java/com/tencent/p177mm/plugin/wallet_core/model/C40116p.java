package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.p */
public abstract class C40116p<K> {
    Map<String, Integer> tzB = new HashMap();
    List<K> tzC = new LinkedList();
    public Vector<C29637b> tzD = new Vector();
    List<String> tzE = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.p$a */
    public enum C14238a {
        DISABLED,
        CHECKED,
        UNCHECKED;

        static {
            AppMethodBeat.m2505o(46789);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.p$b */
    public class C29637b {
        public K tzK;
        public C14238a tzL;
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.p$1 */
    public static /* synthetic */ class C401151 {
        public static final /* synthetic */ int[] tzF = new int[C14238a.values().length];

        static {
            AppMethodBeat.m2504i(46786);
            try {
                tzF[C14238a.UNCHECKED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                tzF[C14238a.CHECKED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                tzF[C14238a.DISABLED.ordinal()] = 3;
                AppMethodBeat.m2505o(46786);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.m2505o(46786);
            }
        }
    }

    /* renamed from: a */
    public abstract String mo47928a(Vector<C29637b> vector, int i);

    /* renamed from: d */
    public final void mo63449d(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.tzE = list3;
        this.tzC = list2;
        this.tzD.clear();
        this.tzD = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            C29637b c29637b = new C29637b();
            Object obj = list.get(i);
            c29637b.tzK = obj;
            if (this.tzC.contains(obj)) {
                c29637b.tzL = C14238a.CHECKED;
            } else {
                c29637b.tzL = C14238a.DISABLED;
            }
            this.tzD.add(c29637b);
        }
        this.tzB.clear();
        for (i = 0; i < list3.size(); i++) {
            this.tzB.put(list3.get(i), Integer.valueOf(0));
        }
        cPC();
    }

    /* renamed from: a */
    public final void mo63448a(int i, C14238a c14238a) {
        ((C29637b) this.tzD.get(i)).tzL = c14238a;
    }

    private void cPC() {
        for (int i = 0; i < this.tzD.size(); i++) {
            if (((C29637b) this.tzD.get(i)).tzL != C14238a.CHECKED) {
                String a = mo47928a(this.tzD, i);
                if (!this.tzB.containsKey(a)) {
                    Object obj;
                    String[] acV = C22621b.acV(a);
                    for (int i2 = 0; i2 < this.tzE.size(); i2++) {
                        for (CharSequence contains : acV) {
                            if (!((String) this.tzE.get(i2)).contains(contains)) {
                                obj = null;
                                break;
                            }
                        }
                        int obj2 = 1;
                        if (obj2 != null) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        mo63448a(i, C14238a.DISABLED);
                    }
                }
                mo63448a(i, C14238a.UNCHECKED);
            }
        }
    }
}
