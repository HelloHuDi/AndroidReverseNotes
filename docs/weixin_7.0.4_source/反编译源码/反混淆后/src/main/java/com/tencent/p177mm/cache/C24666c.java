package com.tencent.p177mm.cache;

import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p651y.C36398c;
import com.tencent.p177mm.p651y.C36890e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/* renamed from: com.tencent.mm.cache.c */
public final class C24666c implements C18128d<C36398c> {
    public Stack<C36398c> efp;
    public Stack<C36398c> efq;
    private int efs;

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.m2504i(116249);
        mo41561a((C36398c) obj);
        AppMethodBeat.m2505o(116249);
    }

    public final /* synthetic */ Object pop() {
        AppMethodBeat.m2504i(116250);
        C36398c Jh = mo41557Jh();
        AppMethodBeat.m2505o(116250);
        return Jh;
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(116235);
        C4990ab.m7416i("MicroMsg.EmojiAndTextCache", "[onCreate]");
        this.efp = new Stack();
        AppMethodBeat.m2505o(116235);
    }

    public final void onDestroy() {
        Iterator it;
        AppMethodBeat.m2504i(116236);
        C4990ab.m7416i("MicroMsg.EmojiAndTextCache", "[onDestroy]");
        if (this.efp != null) {
            it = this.efp.iterator();
            while (it.hasNext()) {
                ((C36398c) it.next()).clear();
            }
            this.efp.clear();
        }
        if (this.efq != null) {
            it = this.efq.iterator();
            while (it.hasNext()) {
                ((C36398c) it.next()).clear();
            }
            this.efq.clear();
        }
        AppMethodBeat.m2505o(116236);
    }

    /* renamed from: by */
    public final void mo33619by(boolean z) {
        AppMethodBeat.m2504i(116237);
        C4990ab.m7417i("MicroMsg.EmojiAndTextCache", "[onSave] size:%s isExit:%s", Integer.valueOf(this.efp.size()), Boolean.valueOf(z));
        if (this.efq != null) {
            this.efq.clear();
        }
        this.efq = new Stack();
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            this.efq.push(((C36398c) it.next()).mo57318Qh());
        }
        C4990ab.m7417i("MicroMsg.EmojiAndTextCache", "[onSave] mLastStack size:%s", Integer.valueOf(this.efq.size()));
        if (z) {
            this.efp.clear();
            it = this.efq.iterator();
            while (it.hasNext()) {
                C36398c c36398c = (C36398c) it.next();
                C4990ab.m7410d("MicroMsg.EmojiItem", "[recycleBitmap]");
                if (!(c36398c.eHh == null || c36398c.eHh.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.EmojiItem", "bitmap recycle %s", c36398c.eHh.toString());
                    c36398c.eHh.recycle();
                }
            }
        }
        AppMethodBeat.m2505o(116237);
    }

    /* renamed from: Je */
    public final void mo33614Je() {
        AppMethodBeat.m2504i(116238);
        C4990ab.m7417i("MicroMsg.EmojiAndTextCache", "[onRestore] size:%s isExit:%s", Integer.valueOf(this.efp.size()), Boolean.FALSE);
        this.efp.clear();
        if (this.efq != null) {
            C4990ab.m7417i("MicroMsg.EmojiAndTextCache", "[onRestore] %s", Integer.valueOf(this.efq.size()));
            this.efp.addAll(this.efq);
        }
        C4990ab.m7417i("MicroMsg.EmojiAndTextCache", "[onRestore] mCurStack size:%s ", Integer.valueOf(this.efp.size()));
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            ((C36398c) it.next()).mo57315Qc();
        }
        AppMethodBeat.m2505o(116238);
    }

    /* renamed from: a */
    public final void mo33615a(Canvas canvas, boolean z) {
        AppMethodBeat.m2504i(116239);
        C36398c c36398c;
        if (z) {
            canvas.drawColor(0, Mode.CLEAR);
            Iterator it = this.efp.iterator();
            while (it.hasNext()) {
                c36398c = (C36398c) it.next();
                if (!c36398c.ejw) {
                    c36398c.draw(canvas);
                }
            }
            AppMethodBeat.m2505o(116239);
            return;
        }
        c36398c = mo41558Ji();
        if (!(c36398c == null || c36398c.ejw)) {
            c36398c.draw(canvas);
        }
        AppMethodBeat.m2505o(116239);
    }

    /* renamed from: b */
    public final void mo33618b(Canvas canvas) {
        AppMethodBeat.m2504i(116240);
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            C36398c c36398c = (C36398c) it.next();
            c36398c.setSelected(false);
            c36398c.draw(canvas);
        }
        AppMethodBeat.m2505o(116240);
    }

    /* renamed from: Jh */
    public final C36398c mo41557Jh() {
        AppMethodBeat.m2504i(116241);
        C36398c c36398c = (C36398c) this.efp.pop();
        AppMethodBeat.m2505o(116241);
        return c36398c;
    }

    /* renamed from: Ji */
    public final C36398c mo41558Ji() {
        AppMethodBeat.m2504i(116242);
        if (this.efp == null || this.efp.size() <= 0) {
            AppMethodBeat.m2505o(116242);
            return null;
        }
        C36398c c36398c = (C36398c) this.efp.peek();
        AppMethodBeat.m2505o(116242);
        return c36398c;
    }

    /* renamed from: a */
    public final void mo41561a(C36398c c36398c) {
        AppMethodBeat.m2504i(116243);
        if (this.efp != null) {
            this.efp.push(c36398c);
        }
        AppMethodBeat.m2505o(116243);
    }

    /* renamed from: ac */
    public final int mo33616ac(boolean z) {
        AppMethodBeat.m2504i(116244);
        int size;
        if (z) {
            if (this.efp != null) {
                size = this.efp.size();
                AppMethodBeat.m2505o(116244);
                return size;
            }
            AppMethodBeat.m2505o(116244);
            return 0;
        } else if (this.efq != null) {
            size = this.efq.size();
            AppMethodBeat.m2505o(116244);
            return size;
        } else {
            AppMethodBeat.m2505o(116244);
            return 0;
        }
    }

    /* renamed from: CO */
    public final void mo33613CO() {
        this.efs++;
    }

    /* renamed from: b */
    public final void mo41562b(C36398c c36398c) {
        AppMethodBeat.m2504i(116245);
        if (c36398c == null) {
            AppMethodBeat.m2505o(116245);
            return;
        }
        this.efp.remove(this.efp.indexOf(c36398c));
        this.efp.push(c36398c);
        AppMethodBeat.m2505o(116245);
    }

    /* renamed from: Jj */
    public final ListIterator<C36398c> mo41559Jj() {
        AppMethodBeat.m2504i(116246);
        ListIterator listIterator = this.efp.listIterator(this.efp.size());
        AppMethodBeat.m2505o(116246);
        return listIterator;
    }

    /* renamed from: Jk */
    public final int[] mo41560Jk() {
        AppMethodBeat.m2504i(116247);
        int[] iArr = new int[2];
        if (this.efq != null) {
            Iterator it = this.efq.iterator();
            while (it.hasNext()) {
                if (((C36398c) it.next()) instanceof C36890e) {
                    iArr[1] = iArr[1] + 1;
                } else {
                    iArr[0] = iArr[0] + 1;
                }
            }
        }
        AppMethodBeat.m2505o(116247);
        return iArr;
    }

    /* renamed from: kb */
    public final String[] mo41563kb(String str) {
        AppMethodBeat.m2504i(116248);
        String[] strArr = new String[]{"", ""};
        Iterator it = this.efp.iterator();
        while (it.hasNext()) {
            C36398c c36398c = (C36398c) it.next();
            if (c36398c instanceof C36890e) {
                strArr[1] = strArr[1] + ((C36890e) c36398c).eHF.toString() + str;
            } else {
                strArr[0] = strArr[0] + c36398c.eHg.mo20410Aq() + str;
            }
        }
        AppMethodBeat.m2505o(116248);
        return strArr;
    }
}
