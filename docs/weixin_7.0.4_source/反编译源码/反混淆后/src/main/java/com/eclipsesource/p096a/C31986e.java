package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.eclipsesource.a.e */
public final class C31986e extends C0803h implements Iterable<C17567b> {
    public final List<C0803h> aCy = new ArrayList();
    public final List<String> aLq = new ArrayList();
    public transient C25471a aLr = new C25471a();

    /* renamed from: com.eclipsesource.a.e$b */
    public static class C17567b {
        private final C0803h aLw;
        private final String name;

        C17567b(String str, C0803h c0803h) {
            this.name = str;
            this.aLw = c0803h;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(70537);
            int hashCode = ((this.name.hashCode() + 31) * 31) + this.aLw.hashCode();
            AppMethodBeat.m2505o(70537);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(70538);
            if (this == obj) {
                AppMethodBeat.m2505o(70538);
                return true;
            } else if (obj == null) {
                AppMethodBeat.m2505o(70538);
                return false;
            } else if (getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(70538);
                return false;
            } else {
                C17567b c17567b = (C17567b) obj;
                if (this.name.equals(c17567b.name) && this.aLw.equals(c17567b.aLw)) {
                    AppMethodBeat.m2505o(70538);
                    return true;
                }
                AppMethodBeat.m2505o(70538);
                return false;
            }
        }
    }

    /* renamed from: com.eclipsesource.a.e$a */
    public static class C25471a {
        private final byte[] aLv = new byte[32];

        public C25471a() {
            AppMethodBeat.m2504i(70533);
            AppMethodBeat.m2505o(70533);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: h */
        public final void mo42524h(String str, int i) {
            AppMethodBeat.m2504i(70534);
            int ab = m40255ab(str);
            if (i < 255) {
                this.aLv[ab] = (byte) (i + 1);
                AppMethodBeat.m2505o(70534);
                return;
            }
            this.aLv[ab] = (byte) 0;
            AppMethodBeat.m2505o(70534);
        }

        public final void remove(int i) {
            for (int i2 = 0; i2 < this.aLv.length; i2++) {
                if (this.aLv[i2] == i + 1) {
                    this.aLv[i2] = (byte) 0;
                } else if (this.aLv[i2] > i + 1) {
                    byte[] bArr = this.aLv;
                    bArr[i2] = (byte) (bArr[i2] - 1);
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final int get(Object obj) {
            AppMethodBeat.m2504i(70535);
            int i = (this.aLv[m40255ab(obj)] & 255) - 1;
            AppMethodBeat.m2505o(70535);
            return i;
        }

        /* renamed from: ab */
        private int m40255ab(Object obj) {
            AppMethodBeat.m2504i(70536);
            int hashCode = obj.hashCode() & (this.aLv.length - 1);
            AppMethodBeat.m2505o(70536);
            return hashCode;
        }
    }

    public C31986e() {
        AppMethodBeat.m2504i(70539);
        AppMethodBeat.m2505o(70539);
    }

    /* renamed from: a */
    public final C31986e mo52093a(String str, C0803h c0803h) {
        AppMethodBeat.m2504i(70540);
        NullPointerException nullPointerException;
        if (str == null) {
            nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.m2505o(70540);
            throw nullPointerException;
        } else if (c0803h == null) {
            nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.m2505o(70540);
            throw nullPointerException;
        } else {
            this.aLr.mo42524h(str, this.aLq.size());
            this.aLq.add(str);
            this.aCy.add(c0803h);
            AppMethodBeat.m2505o(70540);
            return this;
        }
    }

    /* renamed from: g */
    public final C31986e mo52100g(String str, int i) {
        AppMethodBeat.m2504i(70541);
        mo52097b(str, C25470a.m40252dr(i));
        AppMethodBeat.m2505o(70541);
        return this;
    }

    /* renamed from: b */
    public final C31986e mo52096b(String str, long j) {
        AppMethodBeat.m2504i(70542);
        mo52097b(str, C25470a.m40254t(j));
        AppMethodBeat.m2505o(70542);
        return this;
    }

    /* renamed from: d */
    public final C31986e mo52098d(String str, float f) {
        AppMethodBeat.m2504i(70543);
        mo52097b(str, C25470a.m40247T(f));
        AppMethodBeat.m2505o(70543);
        return this;
    }

    /* renamed from: b */
    public final C31986e mo52095b(String str, double d) {
        AppMethodBeat.m2504i(70544);
        mo52097b(str, C25470a.m40253m(d));
        AppMethodBeat.m2505o(70544);
        return this;
    }

    /* renamed from: d */
    public final C31986e mo52099d(String str, boolean z) {
        AppMethodBeat.m2504i(70545);
        mo52097b(str, C25470a.m40248aB(z));
        AppMethodBeat.m2505o(70545);
        return this;
    }

    /* renamed from: h */
    public final C31986e mo52101h(String str, String str2) {
        AppMethodBeat.m2504i(70546);
        mo52097b(str, C25470a.m40249ag(str2));
        AppMethodBeat.m2505o(70546);
        return this;
    }

    /* renamed from: b */
    public final C31986e mo52097b(String str, C0803h c0803h) {
        AppMethodBeat.m2504i(70547);
        NullPointerException nullPointerException;
        if (str == null) {
            nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.m2505o(70547);
            throw nullPointerException;
        } else if (c0803h == null) {
            nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.m2505o(70547);
            throw nullPointerException;
        } else {
            int indexOf = indexOf(str);
            if (indexOf != -1) {
                this.aCy.set(indexOf, c0803h);
            } else {
                this.aLr.mo42524h(str, this.aLq.size());
                this.aLq.add(str);
                this.aCy.add(c0803h);
            }
            AppMethodBeat.m2505o(70547);
            return this;
        }
    }

    /* renamed from: ak */
    public final C0803h mo52094ak(String str) {
        AppMethodBeat.m2504i(70548);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.m2505o(70548);
            throw nullPointerException;
        }
        int indexOf = indexOf(str);
        if (indexOf != -1) {
            C0803h c0803h = (C0803h) this.aCy.get(indexOf);
            AppMethodBeat.m2505o(70548);
            return c0803h;
        }
        AppMethodBeat.m2505o(70548);
        return null;
    }

    public final Iterator<C17567b> iterator() {
        AppMethodBeat.m2504i(70549);
        final Iterator it = this.aLq.iterator();
        final Iterator it2 = this.aCy.iterator();
        C319871 c319871 = new Iterator<C17567b>() {
            public final boolean hasNext() {
                AppMethodBeat.m2504i(70530);
                boolean hasNext = it.hasNext();
                AppMethodBeat.m2505o(70530);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.m2504i(70531);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(70531);
                throw unsupportedOperationException;
            }

            public final /* synthetic */ Object next() {
                AppMethodBeat.m2504i(70532);
                C17567b c17567b = new C17567b((String) it.next(), (C0803h) it2.next());
                AppMethodBeat.m2505o(70532);
                return c17567b;
            }
        };
        AppMethodBeat.m2505o(70549);
        return c319871;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2353a(C0804i c0804i) {
        AppMethodBeat.m2504i(70550);
        c0804i.mo2375pu();
        Iterator it = this.aCy.iterator();
        Object obj = 1;
        for (String ap : this.aLq) {
            if (obj == null) {
                c0804i.mo2378px();
            }
            c0804i.mo2371ap(ap);
            c0804i.mo2377pw();
            ((C0803h) it.next()).mo2353a(c0804i);
            obj = null;
        }
        c0804i.mo2376pv();
        AppMethodBeat.m2505o(70550);
    }

    public final boolean isObject() {
        return true;
    }

    /* renamed from: oS */
    public final C31986e mo2366oS() {
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70551);
        int hashCode = ((this.aLq.hashCode() + 31) * 31) + this.aCy.hashCode();
        AppMethodBeat.m2505o(70551);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70552);
        if (this == obj) {
            AppMethodBeat.m2505o(70552);
            return true;
        } else if (obj == null) {
            AppMethodBeat.m2505o(70552);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(70552);
            return false;
        } else {
            C31986e c31986e = (C31986e) obj;
            if (this.aLq.equals(c31986e.aLq) && this.aCy.equals(c31986e.aCy)) {
                AppMethodBeat.m2505o(70552);
                return true;
            }
            AppMethodBeat.m2505o(70552);
            return false;
        }
    }

    public final int indexOf(String str) {
        AppMethodBeat.m2504i(70553);
        int i = this.aLr.get(str);
        if (i == -1 || !str.equals(this.aLq.get(i))) {
            i = this.aLq.lastIndexOf(str);
            AppMethodBeat.m2505o(70553);
            return i;
        }
        AppMethodBeat.m2505o(70553);
        return i;
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.m2504i(70554);
        objectInputStream.defaultReadObject();
        this.aLr = new C25471a();
        int size = this.aLq.size();
        for (int i = 0; i < size; i++) {
            this.aLr.mo42524h((String) this.aLq.get(i), i);
        }
        AppMethodBeat.m2505o(70554);
    }
}
