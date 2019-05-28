package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends h implements Iterable<b> {
    public final List<h> aCy = new ArrayList();
    public final List<String> aLq = new ArrayList();
    public transient a aLr = new a();

    public static class b {
        private final h aLw;
        private final String name;

        b(String str, h hVar) {
            this.name = str;
            this.aLw = hVar;
        }

        public final int hashCode() {
            AppMethodBeat.i(70537);
            int hashCode = ((this.name.hashCode() + 31) * 31) + this.aLw.hashCode();
            AppMethodBeat.o(70537);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(70538);
            if (this == obj) {
                AppMethodBeat.o(70538);
                return true;
            } else if (obj == null) {
                AppMethodBeat.o(70538);
                return false;
            } else if (getClass() != obj.getClass()) {
                AppMethodBeat.o(70538);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.name.equals(bVar.name) && this.aLw.equals(bVar.aLw)) {
                    AppMethodBeat.o(70538);
                    return true;
                }
                AppMethodBeat.o(70538);
                return false;
            }
        }
    }

    public static class a {
        private final byte[] aLv = new byte[32];

        public a() {
            AppMethodBeat.i(70533);
            AppMethodBeat.o(70533);
        }

        /* Access modifiers changed, original: final */
        public final void h(String str, int i) {
            AppMethodBeat.i(70534);
            int ab = ab(str);
            if (i < 255) {
                this.aLv[ab] = (byte) (i + 1);
                AppMethodBeat.o(70534);
                return;
            }
            this.aLv[ab] = (byte) 0;
            AppMethodBeat.o(70534);
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
            AppMethodBeat.i(70535);
            int i = (this.aLv[ab(obj)] & 255) - 1;
            AppMethodBeat.o(70535);
            return i;
        }

        private int ab(Object obj) {
            AppMethodBeat.i(70536);
            int hashCode = obj.hashCode() & (this.aLv.length - 1);
            AppMethodBeat.o(70536);
            return hashCode;
        }
    }

    public e() {
        AppMethodBeat.i(70539);
        AppMethodBeat.o(70539);
    }

    public final e a(String str, h hVar) {
        AppMethodBeat.i(70540);
        NullPointerException nullPointerException;
        if (str == null) {
            nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(70540);
            throw nullPointerException;
        } else if (hVar == null) {
            nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.o(70540);
            throw nullPointerException;
        } else {
            this.aLr.h(str, this.aLq.size());
            this.aLq.add(str);
            this.aCy.add(hVar);
            AppMethodBeat.o(70540);
            return this;
        }
    }

    public final e g(String str, int i) {
        AppMethodBeat.i(70541);
        b(str, a.dr(i));
        AppMethodBeat.o(70541);
        return this;
    }

    public final e b(String str, long j) {
        AppMethodBeat.i(70542);
        b(str, a.t(j));
        AppMethodBeat.o(70542);
        return this;
    }

    public final e d(String str, float f) {
        AppMethodBeat.i(70543);
        b(str, a.T(f));
        AppMethodBeat.o(70543);
        return this;
    }

    public final e b(String str, double d) {
        AppMethodBeat.i(70544);
        b(str, a.m(d));
        AppMethodBeat.o(70544);
        return this;
    }

    public final e d(String str, boolean z) {
        AppMethodBeat.i(70545);
        b(str, a.aB(z));
        AppMethodBeat.o(70545);
        return this;
    }

    public final e h(String str, String str2) {
        AppMethodBeat.i(70546);
        b(str, a.ag(str2));
        AppMethodBeat.o(70546);
        return this;
    }

    public final e b(String str, h hVar) {
        AppMethodBeat.i(70547);
        NullPointerException nullPointerException;
        if (str == null) {
            nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(70547);
            throw nullPointerException;
        } else if (hVar == null) {
            nullPointerException = new NullPointerException("value is null");
            AppMethodBeat.o(70547);
            throw nullPointerException;
        } else {
            int indexOf = indexOf(str);
            if (indexOf != -1) {
                this.aCy.set(indexOf, hVar);
            } else {
                this.aLr.h(str, this.aLq.size());
                this.aLq.add(str);
                this.aCy.add(hVar);
            }
            AppMethodBeat.o(70547);
            return this;
        }
    }

    public final h ak(String str) {
        AppMethodBeat.i(70548);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("name is null");
            AppMethodBeat.o(70548);
            throw nullPointerException;
        }
        int indexOf = indexOf(str);
        if (indexOf != -1) {
            h hVar = (h) this.aCy.get(indexOf);
            AppMethodBeat.o(70548);
            return hVar;
        }
        AppMethodBeat.o(70548);
        return null;
    }

    public final Iterator<b> iterator() {
        AppMethodBeat.i(70549);
        final Iterator it = this.aLq.iterator();
        final Iterator it2 = this.aCy.iterator();
        AnonymousClass1 anonymousClass1 = new Iterator<b>() {
            public final boolean hasNext() {
                AppMethodBeat.i(70530);
                boolean hasNext = it.hasNext();
                AppMethodBeat.o(70530);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(70531);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(70531);
                throw unsupportedOperationException;
            }

            public final /* synthetic */ Object next() {
                AppMethodBeat.i(70532);
                b bVar = new b((String) it.next(), (h) it2.next());
                AppMethodBeat.o(70532);
                return bVar;
            }
        };
        AppMethodBeat.o(70549);
        return anonymousClass1;
    }

    /* Access modifiers changed, original: final */
    public final void a(i iVar) {
        AppMethodBeat.i(70550);
        iVar.pu();
        Iterator it = this.aCy.iterator();
        Object obj = 1;
        for (String ap : this.aLq) {
            if (obj == null) {
                iVar.px();
            }
            iVar.ap(ap);
            iVar.pw();
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.pv();
        AppMethodBeat.o(70550);
    }

    public final boolean isObject() {
        return true;
    }

    public final e oS() {
        return this;
    }

    public final int hashCode() {
        AppMethodBeat.i(70551);
        int hashCode = ((this.aLq.hashCode() + 31) * 31) + this.aCy.hashCode();
        AppMethodBeat.o(70551);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70552);
        if (this == obj) {
            AppMethodBeat.o(70552);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(70552);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(70552);
            return false;
        } else {
            e eVar = (e) obj;
            if (this.aLq.equals(eVar.aLq) && this.aCy.equals(eVar.aCy)) {
                AppMethodBeat.o(70552);
                return true;
            }
            AppMethodBeat.o(70552);
            return false;
        }
    }

    public final int indexOf(String str) {
        AppMethodBeat.i(70553);
        int i = this.aLr.get(str);
        if (i == -1 || !str.equals(this.aLq.get(i))) {
            i = this.aLq.lastIndexOf(str);
            AppMethodBeat.o(70553);
            return i;
        }
        AppMethodBeat.o(70553);
        return i;
    }

    private synchronized void readObject(ObjectInputStream objectInputStream) {
        AppMethodBeat.i(70554);
        objectInputStream.defaultReadObject();
        this.aLr = new a();
        int size = this.aLq.size();
        for (int i = 0; i < size; i++) {
            this.aLr.h((String) this.aLq.get(i), i);
        }
        AppMethodBeat.o(70554);
    }
}
