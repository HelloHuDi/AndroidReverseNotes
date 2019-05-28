package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.element.C17842h;
import com.tencent.map.lib.element.C17843i;
import com.tencent.map.lib.element.C32207f;
import com.tencent.map.lib.element.C41717j;
import com.tencent.map.lib.element.C41718k;
import com.tencent.map.lib.element.C44680l;
import com.tencent.map.lib.element.C45134b;
import com.tencent.map.lib.element.C8886a;
import com.tencent.map.lib.element.C8888g;
import com.tencent.map.lib.listener.C41721a;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.C37428d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gl */
public class C41053gl {
    /* renamed from: a */
    private CopyOnWriteArrayList<C41717j> f16472a = new CopyOnWriteArrayList();
    /* renamed from: b */
    private CopyOnWriteArrayList<C41717j> f16473b = new CopyOnWriteArrayList();
    /* renamed from: c */
    private CopyOnWriteArrayList<C41717j> f16474c = new CopyOnWriteArrayList();
    /* renamed from: d */
    private C5876fn f16475d;
    /* renamed from: e */
    private C8888g f16476e;
    /* renamed from: f */
    private List<C32207f> f16477f;
    /* renamed from: g */
    private C45134b f16478g;
    /* renamed from: h */
    private C17843i f16479h;
    /* renamed from: i */
    private C41721a f16480i;
    /* renamed from: j */
    private CopyOnWriteArrayList<Integer> f16481j = new CopyOnWriteArrayList();

    public C41053gl(C5876fn c5876fn) {
        AppMethodBeat.m2504i(99281);
        this.f16475d = c5876fn;
        AppMethodBeat.m2505o(99281);
    }

    /* renamed from: a */
    public void mo65140a(C41717j c41717j) {
        AppMethodBeat.m2504i(99282);
        synchronized (this.f16472a) {
            try {
                if (this.f16472a.contains(c41717j)) {
                } else {
                    this.f16472a.add(c41717j);
                    this.f16475d.mo12440a().mo58862z();
                    AppMethodBeat.m2505o(99282);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99282);
            }
        }
    }

    /* renamed from: b */
    public void mo65145b(C41717j c41717j) {
        AppMethodBeat.m2504i(99283);
        if (c41717j == null) {
            AppMethodBeat.m2505o(99283);
            return;
        }
        synchronized (this.f16472a) {
            try {
                if (this.f16472a.remove(c41717j)) {
                    this.f16475d.mo12440a().mo58862z();
                }
                this.f16474c.add(c41717j);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99283);
            }
        }
    }

    /* renamed from: a */
    public boolean mo65144a(C16263gj c16263gj, C24374fw c24374fw) {
        AppMethodBeat.m2504i(99284);
        m71386a();
        this.f16473b.clear();
        synchronized (this.f16472a) {
            try {
                this.f16473b.addAll(this.f16472a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99284);
            }
        }
        Iterator it = this.f16473b.iterator();
        while (it.hasNext()) {
            C41717j c41717j = (C41717j) it.next();
            if (c41717j instanceof C8886a) {
                ((C8886a) c41717j).mo20128a(c16263gj, c24374fw);
            } else {
                c41717j.mo20132b(c16263gj, c24374fw);
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m71386a() {
        AppMethodBeat.m2504i(99285);
        synchronized (this.f16472a) {
            try {
                int i;
                int f;
                ArrayList arrayList = new ArrayList();
                int size = this.f16474c.size();
                for (int i2 = 0; i2 < size; i2++) {
                    C41717j c41717j = (C41717j) this.f16474c.get(i2);
                    if (c41717j instanceof C41718k) {
                        C41718k c41718k = (C41718k) c41717j;
                        int c = c41718k.mo20134c();
                        for (i = 0; i < c; i++) {
                            C41717j a = c41718k.mo20126a(i);
                            if (a instanceof C44680l) {
                                f = ((C44680l) a).mo71723f();
                                if (f >= 0) {
                                    arrayList.add(Integer.valueOf(f));
                                }
                            }
                        }
                    } else if (c41717j instanceof C44680l) {
                        int f2 = ((C44680l) c41717j).mo71723f();
                        if (f2 >= 0) {
                            arrayList.add(Integer.valueOf(f2));
                        }
                    }
                }
                i = arrayList.size();
                int[] iArr = new int[i];
                for (f = 0; f < i; f++) {
                    iArr[f] = ((Integer) arrayList.get(f)).intValue();
                }
                this.f16475d.mo12445f().mo29346a(iArr, i);
                this.f16474c.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99285);
            }
        }
    }

    /* renamed from: a */
    public boolean mo65143a(C24374fw c24374fw, float f, float f2) {
        AppMethodBeat.m2504i(99286);
        synchronized (this.f16472a) {
            try {
                int size = this.f16472a.size() - 1;
                while (size >= 0) {
                    C41717j c41717j = (C41717j) this.f16472a.get(size);
                    if (c41717j == null || !c41717j.mo20130a(c24374fw, f, f2)) {
                        size--;
                    }
                }
                boolean b = m71387b(f, f2);
                AppMethodBeat.m2505o(99286);
                return b;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(99286);
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo65141a(C41721a c41721a) {
        this.f16480i = c41721a;
    }

    /* renamed from: a */
    public void mo65139a(int i, int i2) {
    }

    /* renamed from: b */
    private boolean m71387b(float f, float f2) {
        AppMethodBeat.m2504i(99287);
        TappedElement a = this.f16475d.mo12445f().mo29314a(f, f2);
        if (a == null) {
            AppMethodBeat.m2505o(99287);
            return false;
        } else if (a.type == 1 && this.f16476e != null) {
            this.f16476e.mo20137a(new C17842h(a.name, C37428d.m63087a(a.pixelX, a.pixelY)));
            AppMethodBeat.m2505o(99287);
            return true;
        } else if (a.type == 6 && this.f16477f != null) {
            for (C32207f c32207f : this.f16477f) {
                if (c32207f != null) {
                    c32207f.mo52871a();
                }
            }
            AppMethodBeat.m2505o(99287);
            return true;
        } else if (a.type != 7 || this.f16478g == null) {
            if (this.f16479h != null) {
                this.f16479h.mo33057a();
            }
            AppMethodBeat.m2505o(99287);
            return false;
        } else {
            this.f16478g.mo72961a(a.itemType, a.nameLen);
            AppMethodBeat.m2505o(99287);
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo65142a(float f, float f2) {
        AppMethodBeat.m2504i(99288);
        TappedElement a = this.f16475d.mo12445f().mo29314a(f, f2);
        if (a == null) {
            AppMethodBeat.m2505o(99288);
            return false;
        } else if (a.type == 3) {
            if (this.f16480i != null) {
                this.f16480i.mo50430a();
            }
            AppMethodBeat.m2505o(99288);
            return true;
        } else {
            AppMethodBeat.m2505o(99288);
            return false;
        }
    }
}
