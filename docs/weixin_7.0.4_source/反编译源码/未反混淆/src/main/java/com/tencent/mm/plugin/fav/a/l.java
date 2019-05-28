package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class l {
    private boolean dirty = true;
    public HashMap<String, WeakReference<a>> fBy = new HashMap();
    public abr mfn = new abr();
    private HashSet<Integer> mfo = new HashSet();
    private List<abp> mfp = new LinkedList();

    public interface a {
        void buF();

        void buG();
    }

    public l() {
        AppMethodBeat.i(102673);
        try {
            this.mfn.parseFrom(bo.anf((String) g.RP().Ry().get(225283, (Object) "")));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            ab.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", e.getMessage());
            this.mfn = new abr();
        }
        ab.i("MicroMsg.FavTagSetMgr", "tag:\n%s", this.mfn.wiH);
        AppMethodBeat.o(102673);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(102674);
        if (aVar == null) {
            AppMethodBeat.o(102674);
            return;
        }
        this.fBy.put(aVar.toString(), new WeakReference(aVar));
        AppMethodBeat.o(102674);
    }

    private void hd(boolean z) {
        AppMethodBeat.i(102675);
        for (WeakReference weakReference : this.fBy.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((a) weakReference.get()).buF();
                } else {
                    ((a) weakReference.get()).buG();
                }
            }
        }
        AppMethodBeat.o(102675);
    }

    private void save() {
        byte[] toByteArray;
        AppMethodBeat.i(102676);
        try {
            toByteArray = this.mfn.toByteArray();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            ab.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", e.getMessage());
            toByteArray = null;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(102669);
                g.RP().Ry().set(225283, bo.cd(toByteArray));
                AppMethodBeat.o(102669);
            }

            public final String toString() {
                AppMethodBeat.i(102670);
                String str = super.toString() + "|save";
                AppMethodBeat.o(102670);
                return str;
            }
        });
        this.dirty = true;
        AppMethodBeat.o(102676);
    }

    public final List<abp> vy(int i) {
        AppMethodBeat.i(102677);
        if (i < 0 || i > 1) {
            AppMethodBeat.o(102677);
            return null;
        }
        if (this.dirty) {
            ab.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.mfp.clear();
            Iterator it = this.mfn.wiH.iterator();
            while (it.hasNext()) {
                this.mfp.addAll(((abq) it.next()).wiG);
            }
            this.dirty = false;
        }
        ab.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", Integer.valueOf(this.mfp.size()));
        List<abp> list = this.mfp;
        AppMethodBeat.o(102677);
        return list;
    }

    public final int buE() {
        AppMethodBeat.i(102678);
        int i = 0;
        Iterator it = this.mfn.wiH.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((abq) it.next()).wiG.size() + i2;
            } else {
                AppMethodBeat.o(102678);
                return i2;
            }
        }
    }

    public final void LM(final String str) {
        AppMethodBeat.i(102679);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102679);
        } else if (this.mfo.contains(Integer.valueOf(str.hashCode()))) {
            ab.d("MicroMsg.FavTagSetMgr", "has add tag %s", str);
            AppMethodBeat.o(102679);
        } else {
            this.mfo.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                ab.d("MicroMsg.FavTagSetMgr", "add tag %s, post", str);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(102671);
                        l.this.LN(str);
                        AppMethodBeat.o(102671);
                    }
                });
                AppMethodBeat.o(102679);
                return;
            }
            ab.d("MicroMsg.FavTagSetMgr", "add tag %s", str);
            LN(str);
            AppMethodBeat.o(102679);
        }
    }

    /* Access modifiers changed, original: final */
    public final void LN(String str) {
        int i;
        abq abq;
        abq abq2;
        abp abp;
        int i2 = 0;
        AppMethodBeat.i(102680);
        String vo = com.tencent.mm.platformtools.g.vo(str.toLowerCase());
        if (vo == null || vo.length() <= 0) {
            i = 35;
        } else {
            i = vo.charAt(0);
        }
        Iterator it = this.mfn.wiH.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            abq = (abq) it.next();
            if (abq.wiF == i) {
                break;
            } else if (abq.wiF > i) {
                abq = new abq();
                abq.wiF = i;
                this.mfn.wiH.add(i3, abq);
                break;
            } else {
                i3++;
            }
        }
        abq = null;
        if (abq == null) {
            abq = new abq();
            abq.wiF = i;
            this.mfn.wiH.add(abq);
            abq2 = abq;
        } else {
            abq2 = abq;
        }
        Iterator it2 = abq2.wiG.iterator();
        while (it2.hasNext()) {
            int compareTo;
            abp = (abp) it2.next();
            i3 = abp.wiE.compareTo(vo);
            if (i3 == 0) {
                compareTo = abp.rMJ.compareTo(str);
            } else {
                compareTo = i3;
            }
            if (compareTo == 0) {
                AppMethodBeat.o(102680);
                return;
            } else if (compareTo > 0) {
                abp = new abp();
                abp.rMJ = str;
                abp.wiE = vo;
                abq2.wiG.add(i2, abp);
                save();
                hd(true);
                AppMethodBeat.o(102680);
                return;
            } else {
                i2++;
            }
        }
        abp = new abp();
        abp.rMJ = str;
        abp.wiE = vo;
        abq2.wiG.add(abp);
        hd(true);
        save();
        AppMethodBeat.o(102680);
    }

    public final void v(g gVar) {
        AppMethodBeat.i(102681);
        if (gVar == null) {
            AppMethodBeat.o(102681);
            return;
        }
        for (String removeTag : gVar.field_tagProto.wiJ) {
            removeTag(removeTag);
        }
        AppMethodBeat.o(102681);
    }

    public final void e(Set<String> set) {
        AppMethodBeat.i(102682);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.o(102682);
            return;
        }
        ab.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", set);
        for (String removeTag : set) {
            removeTag(removeTag);
        }
        AppMethodBeat.o(102682);
    }

    private void removeTag(final String str) {
        AppMethodBeat.i(102683);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102683);
            return;
        }
        this.mfo.remove(Integer.valueOf(str.hashCode()));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ab.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", str);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(102672);
                    l.this.LO(str);
                    AppMethodBeat.o(102672);
                }
            });
            AppMethodBeat.o(102683);
            return;
        }
        ab.d("MicroMsg.FavTagSetMgr", "remove tag %s", str);
        LO(str);
        AppMethodBeat.o(102683);
    }

    /* Access modifiers changed, original: final */
    public final void LO(String str) {
        char c;
        abq abq;
        AppMethodBeat.i(102684);
        String vo = com.tencent.mm.platformtools.g.vo(str.toLowerCase());
        if (vo == null || vo.length() <= 0) {
            c = '#';
        } else {
            c = vo.charAt(0);
        }
        Iterator it = this.mfn.wiH.iterator();
        int i = 0;
        while (it.hasNext()) {
            abq abq2 = (abq) it.next();
            if (abq2.wiF == c) {
                abq = abq2;
                break;
            } else if (abq2.wiF > c) {
                AppMethodBeat.o(102684);
                return;
            } else {
                i++;
            }
        }
        abq = null;
        if (abq == null) {
            AppMethodBeat.o(102684);
            return;
        }
        Iterator it2 = abq.wiG.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            abp abp = (abp) it2.next();
            int compareTo = abp.wiE.compareTo(vo);
            if (compareTo == 0) {
                compareTo = abp.rMJ.compareTo(str);
            }
            if (compareTo == 0) {
                if (!((ae) g.M(ae.class)).getFavSearchStorage().LT(abp.rMJ)) {
                    abq.wiG.remove(i2);
                    if (abq.wiG.isEmpty()) {
                        this.mfn.wiH.remove(i);
                    }
                    hd(false);
                    save();
                }
                AppMethodBeat.o(102684);
                return;
            } else if (compareTo > 0) {
                AppMethodBeat.o(102684);
                return;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(102684);
    }
}
