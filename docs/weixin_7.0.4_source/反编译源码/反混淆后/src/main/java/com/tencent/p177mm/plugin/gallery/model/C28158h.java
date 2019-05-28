package com.tencent.p177mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.model.h */
public final class C28158h<E> extends LinkedList<E> {
    private byte[] eMl = new byte[0];

    public C28158h() {
        AppMethodBeat.m2504i(21297);
        AppMethodBeat.m2505o(21297);
    }

    public final E bCr() {
        E poll;
        AppMethodBeat.m2504i(21298);
        synchronized (this.eMl) {
            try {
                if (size() > 0) {
                    poll = super.poll();
                } else {
                    poll = null;
                    AppMethodBeat.m2505o(21298);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21298);
            }
        }
        return poll;
    }

    /* renamed from: aj */
    public final boolean mo46070aj(E e) {
        boolean contains;
        AppMethodBeat.m2504i(21299);
        synchronized (this.eMl) {
            try {
                contains = super.contains(e);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21299);
            }
        }
        return contains;
    }

    /* renamed from: bV */
    public final void mo46072bV(E e) {
        AppMethodBeat.m2504i(21300);
        synchronized (this.eMl) {
            try {
                if (mo46070aj(e)) {
                    super.remove(e);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21300);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        AppMethodBeat.m2504i(21301);
        synchronized (this.eMl) {
            try {
                add = super.add(e);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21301);
            }
        }
        return add;
    }

    public final int size() {
        int size;
        AppMethodBeat.m2504i(21302);
        synchronized (this.eMl) {
            try {
                size = super.size();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21302);
            }
        }
        return size;
    }
}
