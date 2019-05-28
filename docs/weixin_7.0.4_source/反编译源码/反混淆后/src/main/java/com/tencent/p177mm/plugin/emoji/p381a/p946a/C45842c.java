package com.tencent.p177mm.plugin.emoji.p381a.p946a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.emoji.model.C20382e;
import com.tencent.p177mm.plugin.emoji.model.C20383f;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p383h.C2932a;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.storage.C44221ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.a.a.c */
public class C45842c implements Cloneable, Iterable<C11546f> {
    private HashMap<String, C44221ar> kSW;
    protected HashMap<String, C44221ar> kSX;
    public boolean kSY;
    protected ArrayList<C11546f> mItemList;

    /* renamed from: com.tencent.mm.plugin.emoji.a.a.c$a */
    class C33946a implements Iterator<C11546f> {
        private int mIndex;

        private C33946a() {
            this.mIndex = 0;
        }

        /* synthetic */ C33946a(C45842c c45842c, byte b) {
            this();
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(52776);
            if (this.mIndex < C45842c.this.size()) {
                AppMethodBeat.m2505o(52776);
                return true;
            }
            AppMethodBeat.m2505o(52776);
            return false;
        }

        public final void remove() {
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.m2504i(52777);
            C45842c c45842c = C45842c.this;
            int i = this.mIndex;
            this.mIndex = i + 1;
            C11546f ub = c45842c.mo73645ub(i);
            AppMethodBeat.m2505o(52777);
            return ub;
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.m2504i(52794);
        C45842c bjC = bjC();
        AppMethodBeat.m2505o(52794);
        return bjC;
    }

    public void clear() {
        AppMethodBeat.m2504i(52778);
        if (this.mItemList != null) {
            this.mItemList.clear();
            this.mItemList = null;
        }
        if (this.kSW != null) {
            this.kSW.clear();
            this.kSW = null;
        }
        if (this.kSX != null) {
            this.kSX.clear();
            this.kSX = null;
        }
        AppMethodBeat.m2505o(52778);
    }

    public C45842c(C20383f c20383f) {
        List list;
        if (c20383f == null) {
            list = null;
        } else {
            list = c20383f.kVq;
        }
        this(list);
        AppMethodBeat.m2504i(52779);
        AppMethodBeat.m2505o(52779);
    }

    public C45842c() {
        AppMethodBeat.m2504i(52780);
        this.kSW = new HashMap();
        this.kSX = new HashMap();
        this.kSY = C1853r.m3830YL();
        AppMethodBeat.m2505o(52780);
    }

    public C45842c(List<C11546f> list) {
        this();
        AppMethodBeat.m2504i(52781);
        if (list == null) {
            AppMethodBeat.m2505o(52781);
            return;
        }
        this.mItemList = new ArrayList();
        this.mItemList.addAll(list);
        AppMethodBeat.m2505o(52781);
    }

    public final int size() {
        AppMethodBeat.m2504i(52782);
        if (this.mItemList == null) {
            AppMethodBeat.m2505o(52782);
            return 0;
        }
        int size = this.mItemList.size();
        AppMethodBeat.m2505o(52782);
        return size;
    }

    /* renamed from: ub */
    public final C11546f mo73645ub(int i) {
        AppMethodBeat.m2504i(52783);
        if (this.mItemList == null || this.mItemList.size() <= i || i < 0) {
            AppMethodBeat.m2505o(52783);
            return null;
        } else if (this.mItemList == null) {
            AppMethodBeat.m2505o(52783);
            return null;
        } else {
            C11546f c11546f = (C11546f) this.mItemList.get(i);
            AppMethodBeat.m2505o(52783);
            return c11546f;
        }
    }

    /* renamed from: IT */
    public final C11546f mo73635IT(String str) {
        AppMethodBeat.m2504i(52784);
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                C11546f c11546f = (C11546f) it.next();
                EmotionSummary emotionSummary = c11546f.kTb;
                if (emotionSummary != null && emotionSummary.ProductID != null && emotionSummary.ProductID.equals(str)) {
                    AppMethodBeat.m2505o(52784);
                    return c11546f;
                }
            }
        }
        AppMethodBeat.m2505o(52784);
        return null;
    }

    public final C45842c bjC() {
        C45842c c45842c;
        AppMethodBeat.m2504i(52785);
        try {
            c45842c = (C45842c) super.clone();
            try {
                if (this.mItemList != null) {
                    c45842c.mItemList = (ArrayList) this.mItemList.clone();
                }
            } catch (CloneNotSupportedException e) {
            }
        } catch (CloneNotSupportedException e2) {
            c45842c = null;
        }
        AppMethodBeat.m2505o(52785);
        return c45842c;
    }

    public void notifyDataSetChanged() {
        AppMethodBeat.m2504i(52786);
        if (this.mItemList == null) {
            AppMethodBeat.m2505o(52786);
            return;
        }
        this.kSX = C42952j.getEmojiStorageMgr().xYo.duD();
        Iterator it = this.mItemList.iterator();
        while (it.hasNext()) {
            C11546f c11546f = (C11546f) it.next();
            EmotionSummary emotionSummary = c11546f.kTb;
            if (emotionSummary != null) {
                if (C2932a.m5218g(emotionSummary)) {
                    c11546f.setStatus(C2932a.blE() ? 7 : 3);
                } else {
                    String str = emotionSummary.ProductID;
                    c11546f.mo23260a(this.kSY, mo73639IX(str), mo73637IV(str));
                }
            }
        }
        bjD();
        AppMethodBeat.m2505o(52786);
    }

    /* renamed from: IU */
    public final void mo73636IU(String str) {
        AppMethodBeat.m2504i(52787);
        C11546f IT = mo73635IT(str);
        if (IT == null) {
            AppMethodBeat.m2505o(52787);
            return;
        }
        IT.setStatus(-1);
        IT.mo23260a(this.kSY, mo73639IX(str), mo73637IV(str));
        AppMethodBeat.m2505o(52787);
    }

    /* renamed from: IV */
    public final boolean mo73637IV(String str) {
        AppMethodBeat.m2504i(52788);
        if (this.kSX == null) {
            AppMethodBeat.m2505o(52788);
            return false;
        }
        boolean containsKey = this.kSX.containsKey(str);
        AppMethodBeat.m2505o(52788);
        return containsKey;
    }

    /* renamed from: IW */
    public final C44221ar mo73638IW(String str) {
        AppMethodBeat.m2504i(52789);
        C44221ar IX = mo73639IX(str);
        if (IX == null) {
            IX = new C44221ar(str);
            this.kSW.put(str, IX);
        }
        AppMethodBeat.m2505o(52789);
        return IX;
    }

    /* renamed from: IX */
    public final C44221ar mo73639IX(String str) {
        AppMethodBeat.m2504i(52790);
        C44221ar c44221ar = (C44221ar) this.kSW.get(str);
        AppMethodBeat.m2505o(52790);
        return c44221ar;
    }

    public Iterator<C11546f> iterator() {
        AppMethodBeat.m2504i(52791);
        C33946a c33946a = new C33946a(this, (byte) 0);
        AppMethodBeat.m2505o(52791);
        return c33946a;
    }

    /* renamed from: bY */
    public final void mo73640bY(String str, int i) {
        AppMethodBeat.m2504i(52792);
        C44221ar c44221ar = (C44221ar) this.kSW.get(str);
        if (c44221ar == null) {
            AppMethodBeat.m2505o(52792);
            return;
        }
        c44221ar.mo69859Mo(i);
        AppMethodBeat.m2505o(52792);
    }

    public void bjD() {
        AppMethodBeat.m2504i(52793);
        if (this.mItemList == null) {
            AppMethodBeat.m2505o(52793);
        } else if (C42952j.bkn().kVo == null) {
            AppMethodBeat.m2505o(52793);
        } else {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                C11546f c11546f = (C11546f) it.next();
                EmotionSummary emotionSummary = c11546f.kTb;
                if (emotionSummary != null) {
                    int i;
                    C20382e bkn = C42952j.bkn();
                    Integer num = (Integer) bkn.kVo.get(emotionSummary.ProductID);
                    if (num == null) {
                        i = -1;
                    } else {
                        i = num.intValue();
                    }
                    if (i >= 0) {
                        c11546f.setStatus(6);
                        c11546f.f2905EV = i;
                    }
                    if (i < 0 && c11546f.mStatus == 6) {
                        c11546f.setStatus(3);
                    }
                }
            }
            AppMethodBeat.m2505o(52793);
        }
    }
}
