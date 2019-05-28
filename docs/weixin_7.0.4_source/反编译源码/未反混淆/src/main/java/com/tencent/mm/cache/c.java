package com.tencent.mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.e;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public final class c implements d<com.tencent.mm.y.c> {
    public Stack<com.tencent.mm.y.c> efp;
    public Stack<com.tencent.mm.y.c> efq;
    private int efs;

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.i(116249);
        a((com.tencent.mm.y.c) obj);
        AppMethodBeat.o(116249);
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.i(116250);
        com.tencent.mm.y.c Jh = Jh();
        AppMethodBeat.o(116250);
        return Jh;
    }

    public final void onCreate() {
        AppMethodBeat.i(116235);
        ab.i("MicroMsg.EmojiAndTextCache", "[onCreate]");
        this.efp = new Stack();
        AppMethodBeat.o(116235);
    }

    public final void onDestroy() {
        Iterator it;
        AppMethodBeat.i(116236);
        ab.i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
        if (this.efp != null) {
            it = this.efp.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.y.c) it.next()).clear();
            }
            this.efp.clear();
        }
        if (this.efq != null) {
            it = this.efq.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.y.c) it.next()).clear();
            }
            this.efq.clear();
        }
        AppMethodBeat.o(116236);
    }

    public final void by(boolean z) {
        AppMethodBeat.i(116237);
        ab.i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", Integer.valueOf(this.efp.size()), Boolean.valueOf(z));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = new Stack();
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            this.efq.push(((com.tencent.mm.y.c) it.next()).Qh());
        }
        ab.i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", Integer.valueOf(this.efq.size()));
        if (z) {
            this.efp.clear();
            it = this.efq.iterator();
            while (it.hasNext()) {
                com.tencent.mm.y.c cVar = (com.tencent.mm.y.c) it.next();
                ab.d("MicroMsg.EmojiItem", "[recycleBitmap]");
                if (!(cVar.eHh == null || cVar.eHh.isRecycled())) {
                    ab.i("MicroMsg.EmojiItem", "bitmap recycle %s", cVar.eHh.toString());
                    cVar.eHh.recycle();
                }
            }
        }
        AppMethodBeat.o(116237);
    }

    public final void Je() {
        AppMethodBeat.i(116238);
        ab.i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", Integer.valueOf(this.efp.size()), Boolean.FALSE);
        this.efp.clear();
        if (this.efq != null) {
            ab.i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        ab.i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", Integer.valueOf(this.efp.size()));
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.y.c) it.next()).Qc();
        }
        AppMethodBeat.o(116238);
    }

    public final void a(Canvas canvas, boolean z) {
        AppMethodBeat.i(116239);
        com.tencent.mm.y.c cVar;
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.efp.iterator();
            while (it.hasNext()) {
                cVar = (com.tencent.mm.y.c) it.next();
                if (!cVar.ejw) {
                    cVar.draw(canvas);
                }
            }
            AppMethodBeat.o(116239);
            return;
        }
        cVar = Ji();
        if (!(cVar == null || cVar.ejw)) {
            cVar.draw(canvas);
        }
        AppMethodBeat.o(116239);
    }

    public final void b(Canvas canvas) {
        AppMethodBeat.i(116240);
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            com.tencent.mm.y.c cVar = (com.tencent.mm.y.c) it.next();
            cVar.setSelected(false);
            cVar.draw(canvas);
        }
        AppMethodBeat.o(116240);
    }

    public final com.tencent.mm.y.c Jh() {
        AppMethodBeat.i(116241);
        com.tencent.mm.y.c cVar = (com.tencent.mm.y.c) this.efp.pop();
        AppMethodBeat.o(116241);
        return cVar;
    }

    public final com.tencent.mm.y.c Ji() {
        AppMethodBeat.i(116242);
        if (this.efp == null || this.efp.size() <= 0) {
            AppMethodBeat.o(116242);
            return null;
        }
        com.tencent.mm.y.c cVar = (com.tencent.mm.y.c) this.efp.peek();
        AppMethodBeat.o(116242);
        return cVar;
    }

    public final void a(com.tencent.mm.y.c cVar) {
        AppMethodBeat.i(116243);
        if (this.efp != null) {
            this.efp.push(cVar);
        }
        AppMethodBeat.o(116243);
    }

    public final int ac(boolean z) {
        AppMethodBeat.i(116244);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.o(116244);
                return size;
            }
            AppMethodBeat.o(116244);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.o(116244);
            return size;
        } else {
            AppMethodBeat.o(116244);
            return 0;
        }
    }

    public final void CO() {
        this.efs++;
    }

    public final void b(com.tencent.mm.y.c cVar) {
        AppMethodBeat.i(116245);
        if (cVar == null) {
            AppMethodBeat.o(116245);
            return;
        }
        this.efp.remove(this.efp.indexOf(cVar));
        this.efp.push(cVar);
        AppMethodBeat.o(116245);
    }

    public final ListIterator<com.tencent.mm.y.c> Jj() {
        AppMethodBeat.i(116246);
        ListIterator listIterator = this.efp.listIterator(this.efp.size());
        AppMethodBeat.o(116246);
        return listIterator;
    }

    public final int[] Jk() {
        AppMethodBeat.i(116247);
        int[] iArr = new int[2];
        if (this.efq != null) {
            Iterator it = this.efq.iterator();
            while (it.hasNext()) {
                if (((com.tencent.mm.y.c) it.next()) instanceof e) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        AppMethodBeat.o(116247);
        return iArr;
    }

    public final String[] kb(String str) {
        AppMethodBeat.i(116248);
        String[] strArr = new String[]{"", ""};
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            com.tencent.mm.y.c cVar = (com.tencent.mm.y.c) it.next();
            if (cVar instanceof e) {
                strArr[1] = strArr[1] + ((e) cVar).eHF.toString() + str;
            } else {
                strArr[0] = strArr[0] + cVar.eHg.Aq() + str;
            }
        }
        AppMethodBeat.o(116248);
        return strArr;
    }
}
