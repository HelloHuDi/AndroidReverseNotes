package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class c implements Cloneable, Iterable<f> {
    private HashMap<String, ar> kSW;
    protected HashMap<String, ar> kSX;
    public boolean kSY;
    protected ArrayList<f> mItemList;

    class a implements Iterator<f> {
        private int mIndex;

        private a() {
            this.mIndex = 0;
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final boolean hasNext() {
            AppMethodBeat.i(52776);
            if (this.mIndex < c.this.size()) {
                AppMethodBeat.o(52776);
                return true;
            }
            AppMethodBeat.o(52776);
            return false;
        }

        public final void remove() {
        }

        public final /* synthetic */ Object next() {
            AppMethodBeat.i(52777);
            c cVar = c.this;
            int i = this.mIndex;
            this.mIndex = i + 1;
            f ub = cVar.ub(i);
            AppMethodBeat.o(52777);
            return ub;
        }
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(52794);
        c bjC = bjC();
        AppMethodBeat.o(52794);
        return bjC;
    }

    public void clear() {
        AppMethodBeat.i(52778);
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
        AppMethodBeat.o(52778);
    }

    public c(f fVar) {
        List list;
        if (fVar == null) {
            list = null;
        } else {
            list = fVar.kVq;
        }
        this(list);
        AppMethodBeat.i(52779);
        AppMethodBeat.o(52779);
    }

    public c() {
        AppMethodBeat.i(52780);
        this.kSW = new HashMap();
        this.kSX = new HashMap();
        this.kSY = r.YL();
        AppMethodBeat.o(52780);
    }

    public c(List<f> list) {
        this();
        AppMethodBeat.i(52781);
        if (list == null) {
            AppMethodBeat.o(52781);
            return;
        }
        this.mItemList = new ArrayList();
        this.mItemList.addAll(list);
        AppMethodBeat.o(52781);
    }

    public final int size() {
        AppMethodBeat.i(52782);
        if (this.mItemList == null) {
            AppMethodBeat.o(52782);
            return 0;
        }
        int size = this.mItemList.size();
        AppMethodBeat.o(52782);
        return size;
    }

    public final f ub(int i) {
        AppMethodBeat.i(52783);
        if (this.mItemList == null || this.mItemList.size() <= i || i < 0) {
            AppMethodBeat.o(52783);
            return null;
        } else if (this.mItemList == null) {
            AppMethodBeat.o(52783);
            return null;
        } else {
            f fVar = (f) this.mItemList.get(i);
            AppMethodBeat.o(52783);
            return fVar;
        }
    }

    public final f IT(String str) {
        AppMethodBeat.i(52784);
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                EmotionSummary emotionSummary = fVar.kTb;
                if (emotionSummary != null && emotionSummary.ProductID != null && emotionSummary.ProductID.equals(str)) {
                    AppMethodBeat.o(52784);
                    return fVar;
                }
            }
        }
        AppMethodBeat.o(52784);
        return null;
    }

    public final c bjC() {
        c cVar;
        AppMethodBeat.i(52785);
        try {
            cVar = (c) super.clone();
            try {
                if (this.mItemList != null) {
                    cVar.mItemList = (ArrayList) this.mItemList.clone();
                }
            } catch (CloneNotSupportedException e) {
            }
        } catch (CloneNotSupportedException e2) {
            cVar = null;
        }
        AppMethodBeat.o(52785);
        return cVar;
    }

    public void notifyDataSetChanged() {
        AppMethodBeat.i(52786);
        if (this.mItemList == null) {
            AppMethodBeat.o(52786);
            return;
        }
        this.kSX = j.getEmojiStorageMgr().xYo.duD();
        Iterator it = this.mItemList.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            EmotionSummary emotionSummary = fVar.kTb;
            if (emotionSummary != null) {
                if (com.tencent.mm.plugin.emoji.h.a.g(emotionSummary)) {
                    fVar.setStatus(com.tencent.mm.plugin.emoji.h.a.blE() ? 7 : 3);
                } else {
                    String str = emotionSummary.ProductID;
                    fVar.a(this.kSY, IX(str), IV(str));
                }
            }
        }
        bjD();
        AppMethodBeat.o(52786);
    }

    public final void IU(String str) {
        AppMethodBeat.i(52787);
        f IT = IT(str);
        if (IT == null) {
            AppMethodBeat.o(52787);
            return;
        }
        IT.setStatus(-1);
        IT.a(this.kSY, IX(str), IV(str));
        AppMethodBeat.o(52787);
    }

    public final boolean IV(String str) {
        AppMethodBeat.i(52788);
        if (this.kSX == null) {
            AppMethodBeat.o(52788);
            return false;
        }
        boolean containsKey = this.kSX.containsKey(str);
        AppMethodBeat.o(52788);
        return containsKey;
    }

    public final ar IW(String str) {
        AppMethodBeat.i(52789);
        ar IX = IX(str);
        if (IX == null) {
            IX = new ar(str);
            this.kSW.put(str, IX);
        }
        AppMethodBeat.o(52789);
        return IX;
    }

    public final ar IX(String str) {
        AppMethodBeat.i(52790);
        ar arVar = (ar) this.kSW.get(str);
        AppMethodBeat.o(52790);
        return arVar;
    }

    public Iterator<f> iterator() {
        AppMethodBeat.i(52791);
        a aVar = new a(this, (byte) 0);
        AppMethodBeat.o(52791);
        return aVar;
    }

    public final void bY(String str, int i) {
        AppMethodBeat.i(52792);
        ar arVar = (ar) this.kSW.get(str);
        if (arVar == null) {
            AppMethodBeat.o(52792);
            return;
        }
        arVar.Mo(i);
        AppMethodBeat.o(52792);
    }

    public void bjD() {
        AppMethodBeat.i(52793);
        if (this.mItemList == null) {
            AppMethodBeat.o(52793);
        } else if (j.bkn().kVo == null) {
            AppMethodBeat.o(52793);
        } else {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                EmotionSummary emotionSummary = fVar.kTb;
                if (emotionSummary != null) {
                    int i;
                    e bkn = j.bkn();
                    Integer num = (Integer) bkn.kVo.get(emotionSummary.ProductID);
                    if (num == null) {
                        i = -1;
                    } else {
                        i = num.intValue();
                    }
                    if (i >= 0) {
                        fVar.setStatus(6);
                        fVar.EV = i;
                    }
                    if (i < 0 && fVar.mStatus == 6) {
                        fVar.setStatus(3);
                    }
                }
            }
            AppMethodBeat.o(52793);
        }
    }
}
