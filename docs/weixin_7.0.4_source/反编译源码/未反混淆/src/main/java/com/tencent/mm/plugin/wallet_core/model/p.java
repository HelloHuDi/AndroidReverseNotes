package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class p<K> {
    Map<String, Integer> tzB = new HashMap();
    List<K> tzC = new LinkedList();
    public Vector<b> tzD = new Vector();
    List<String> tzE = new LinkedList();

    public enum a {
        DISABLED,
        CHECKED,
        UNCHECKED;

        static {
            AppMethodBeat.o(46789);
        }
    }

    public class b {
        public K tzK;
        public a tzL;
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.p$1 */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] tzF = new int[a.values().length];

        static {
            AppMethodBeat.i(46786);
            try {
                tzF[a.UNCHECKED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                tzF[a.CHECKED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                tzF[a.DISABLED.ordinal()] = 3;
                AppMethodBeat.o(46786);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(46786);
            }
        }
    }

    public abstract String a(Vector<b> vector, int i);

    public final void d(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.tzE = list3;
        this.tzC = list2;
        this.tzD.clear();
        this.tzD = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            b bVar = new b();
            Object obj = list.get(i);
            bVar.tzK = obj;
            if (this.tzC.contains(obj)) {
                bVar.tzL = a.CHECKED;
            } else {
                bVar.tzL = a.DISABLED;
            }
            this.tzD.add(bVar);
        }
        this.tzB.clear();
        for (i = 0; i < list3.size(); i++) {
            this.tzB.put(list3.get(i), Integer.valueOf(0));
        }
        cPC();
    }

    public final void a(int i, a aVar) {
        ((b) this.tzD.get(i)).tzL = aVar;
    }

    private void cPC() {
        for (int i = 0; i < this.tzD.size(); i++) {
            if (((b) this.tzD.get(i)).tzL != a.CHECKED) {
                String a = a(this.tzD, i);
                if (!this.tzB.containsKey(a)) {
                    Object obj;
                    String[] acV = com.tencent.mm.plugin.wallet_core.ui.b.acV(a);
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
                        a(i, a.DISABLED);
                    }
                }
                a(i, a.UNCHECKED);
            }
        }
    }
}
