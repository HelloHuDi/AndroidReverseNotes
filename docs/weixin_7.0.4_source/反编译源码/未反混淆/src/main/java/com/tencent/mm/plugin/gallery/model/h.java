package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h<E> extends LinkedList<E> {
    private byte[] eMl = new byte[0];

    public h() {
        AppMethodBeat.i(21297);
        AppMethodBeat.o(21297);
    }

    public final E bCr() {
        E poll;
        AppMethodBeat.i(21298);
        synchronized (this.eMl) {
            try {
                if (size() > 0) {
                    poll = super.poll();
                } else {
                    poll = null;
                    AppMethodBeat.o(21298);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21298);
            }
        }
        return poll;
    }

    public final boolean aj(E e) {
        boolean contains;
        AppMethodBeat.i(21299);
        synchronized (this.eMl) {
            try {
                contains = super.contains(e);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21299);
            }
        }
        return contains;
    }

    public final void bV(E e) {
        AppMethodBeat.i(21300);
        synchronized (this.eMl) {
            try {
                if (aj(e)) {
                    super.remove(e);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21300);
            }
        }
    }

    public final boolean add(E e) {
        boolean add;
        AppMethodBeat.i(21301);
        synchronized (this.eMl) {
            try {
                add = super.add(e);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21301);
            }
        }
        return add;
    }

    public final int size() {
        int size;
        AppMethodBeat.i(21302);
        synchronized (this.eMl) {
            try {
                size = super.size();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21302);
            }
        }
        return size;
    }
}
