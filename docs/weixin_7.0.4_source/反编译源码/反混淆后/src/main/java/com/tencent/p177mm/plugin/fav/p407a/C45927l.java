package com.tencent.p177mm.plugin.fav.p407a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.protocal.protobuf.abp;
import com.tencent.p177mm.protocal.protobuf.abq;
import com.tencent.p177mm.protocal.protobuf.abr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.fav.a.l */
public final class C45927l {
    private boolean dirty = true;
    public HashMap<String, WeakReference<C43058a>> fBy = new HashMap();
    public abr mfn = new abr();
    private HashSet<Integer> mfo = new HashSet();
    private List<abp> mfp = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.fav.a.l$a */
    public interface C43058a {
        void buF();

        void buG();
    }

    public C45927l() {
        AppMethodBeat.m2504i(102673);
        try {
            this.mfn.parseFrom(C5046bo.anf((String) C1720g.m3536RP().mo5239Ry().get(225283, (Object) "")));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", e.getMessage());
            this.mfn = new abr();
        }
        C4990ab.m7417i("MicroMsg.FavTagSetMgr", "tag:\n%s", this.mfn.wiH);
        AppMethodBeat.m2505o(102673);
    }

    /* renamed from: a */
    public final void mo73772a(C43058a c43058a) {
        AppMethodBeat.m2504i(102674);
        if (c43058a == null) {
            AppMethodBeat.m2505o(102674);
            return;
        }
        this.fBy.put(c43058a.toString(), new WeakReference(c43058a));
        AppMethodBeat.m2505o(102674);
    }

    /* renamed from: hd */
    private void m85199hd(boolean z) {
        AppMethodBeat.m2504i(102675);
        for (WeakReference weakReference : this.fBy.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((C43058a) weakReference.get()).buF();
                } else {
                    ((C43058a) weakReference.get()).buG();
                }
            }
        }
        AppMethodBeat.m2505o(102675);
    }

    private void save() {
        byte[] toByteArray;
        AppMethodBeat.m2504i(102676);
        try {
            toByteArray = this.mfn.toByteArray();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            C4990ab.m7421w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", e.getMessage());
            toByteArray = null;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(102669);
                C1720g.m3536RP().mo5239Ry().set(225283, C5046bo.m7543cd(toByteArray));
                AppMethodBeat.m2505o(102669);
            }

            public final String toString() {
                AppMethodBeat.m2504i(102670);
                String str = super.toString() + "|save";
                AppMethodBeat.m2505o(102670);
                return str;
            }
        });
        this.dirty = true;
        AppMethodBeat.m2505o(102676);
    }

    /* renamed from: vy */
    public final List<abp> mo73776vy(int i) {
        AppMethodBeat.m2504i(102677);
        if (i < 0 || i > 1) {
            AppMethodBeat.m2505o(102677);
            return null;
        }
        if (this.dirty) {
            C4990ab.m7420w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.mfp.clear();
            Iterator it = this.mfn.wiH.iterator();
            while (it.hasNext()) {
                this.mfp.addAll(((abq) it.next()).wiG);
            }
            this.dirty = false;
        }
        C4990ab.m7417i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", Integer.valueOf(this.mfp.size()));
        List<abp> list = this.mfp;
        AppMethodBeat.m2505o(102677);
        return list;
    }

    public final int buE() {
        AppMethodBeat.m2504i(102678);
        int i = 0;
        Iterator it = this.mfn.wiH.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((abq) it.next()).wiG.size() + i2;
            } else {
                AppMethodBeat.m2505o(102678);
                return i2;
            }
        }
    }

    /* renamed from: LM */
    public final void mo73769LM(final String str) {
        AppMethodBeat.m2504i(102679);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102679);
        } else if (this.mfo.contains(Integer.valueOf(str.hashCode()))) {
            C4990ab.m7411d("MicroMsg.FavTagSetMgr", "has add tag %s", str);
            AppMethodBeat.m2505o(102679);
        } else {
            this.mfo.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                C4990ab.m7411d("MicroMsg.FavTagSetMgr", "add tag %s, post", str);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(102671);
                        C45927l.this.mo73770LN(str);
                        AppMethodBeat.m2505o(102671);
                    }
                });
                AppMethodBeat.m2505o(102679);
                return;
            }
            C4990ab.m7411d("MicroMsg.FavTagSetMgr", "add tag %s", str);
            mo73770LN(str);
            AppMethodBeat.m2505o(102679);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: LN */
    public final void mo73770LN(String str) {
        int i;
        abq abq;
        abq abq2;
        abp abp;
        int i2 = 0;
        AppMethodBeat.m2504i(102680);
        String vo = C9790g.m17432vo(str.toLowerCase());
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
                AppMethodBeat.m2505o(102680);
                return;
            } else if (compareTo > 0) {
                abp = new abp();
                abp.rMJ = str;
                abp.wiE = vo;
                abq2.wiG.add(i2, abp);
                save();
                m85199hd(true);
                AppMethodBeat.m2505o(102680);
                return;
            } else {
                i2++;
            }
        }
        abp = new abp();
        abp.rMJ = str;
        abp.wiE = vo;
        abq2.wiG.add(abp);
        m85199hd(true);
        save();
        AppMethodBeat.m2505o(102680);
    }

    /* renamed from: v */
    public final void mo73775v(C27966g c27966g) {
        AppMethodBeat.m2504i(102681);
        if (c27966g == null) {
            AppMethodBeat.m2505o(102681);
            return;
        }
        for (String removeTag : c27966g.field_tagProto.wiJ) {
            removeTag(removeTag);
        }
        AppMethodBeat.m2505o(102681);
    }

    /* renamed from: e */
    public final void mo73774e(Set<String> set) {
        AppMethodBeat.m2504i(102682);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.m2505o(102682);
            return;
        }
        C4990ab.m7411d("MicroMsg.FavTagSetMgr", "do remove tags: %s", set);
        for (String removeTag : set) {
            removeTag(removeTag);
        }
        AppMethodBeat.m2505o(102682);
    }

    private void removeTag(final String str) {
        AppMethodBeat.m2504i(102683);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102683);
            return;
        }
        this.mfo.remove(Integer.valueOf(str.hashCode()));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C4990ab.m7411d("MicroMsg.FavTagSetMgr", "remove tag %s, post", str);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(102672);
                    C45927l.this.mo73771LO(str);
                    AppMethodBeat.m2505o(102672);
                }
            });
            AppMethodBeat.m2505o(102683);
            return;
        }
        C4990ab.m7411d("MicroMsg.FavTagSetMgr", "remove tag %s", str);
        mo73771LO(str);
        AppMethodBeat.m2505o(102683);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: LO */
    public final void mo73771LO(String str) {
        char c;
        abq abq;
        AppMethodBeat.m2504i(102684);
        String vo = C9790g.m17432vo(str.toLowerCase());
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
                AppMethodBeat.m2505o(102684);
                return;
            } else {
                i++;
            }
        }
        abq = null;
        if (abq == null) {
            AppMethodBeat.m2505o(102684);
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
                if (!((C7604ae) C1720g.m3530M(C7604ae.class)).getFavSearchStorage().mo54686LT(abp.rMJ)) {
                    abq.wiG.remove(i2);
                    if (abq.wiG.isEmpty()) {
                        this.mfn.wiH.remove(i);
                    }
                    m85199hd(false);
                    save();
                }
                AppMethodBeat.m2505o(102684);
                return;
            } else if (compareTo > 0) {
                AppMethodBeat.m2505o(102684);
                return;
            } else {
                i2++;
            }
        }
        AppMethodBeat.m2505o(102684);
    }
}
