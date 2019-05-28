package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3158b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39147k;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39152n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.a */
public abstract class C39153a extends C3158b implements C28114l {
    HashSet<String> mEu = new HashSet();
    private C28106a mEx;
    public List<C34203a> mHp = Collections.synchronizedList(new LinkedList());
    protected String query;

    /* renamed from: a */
    public abstract C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet);

    /* renamed from: a */
    public abstract C3154a mo7331a(int i, C34203a c34203a);

    /* renamed from: a */
    public abstract void mo7332a(C28109j c28109j, HashSet<String> hashSet);

    public C39153a(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final void mo62049a(String str, C7306ak c7306ak, HashSet<String> hashSet) {
        bAr();
        clearData();
        this.query = str;
        this.mEx = mo7330a(c7306ak, (HashSet) hashSet);
    }

    public final void bAr() {
        if (this.mEx != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
            this.mEx = null;
        }
    }

    /* renamed from: vY */
    public int mo51308vY(int i) {
        int size = this.mHp.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            int i4;
            C34203a c34203a = (C34203a) this.mHp.get(i2);
            c34203a.mFb = i3;
            if (c34203a.mFc) {
                i3++;
            }
            i3 += c34203a.mFf.size() + c34203a.mFi;
            c34203a.mFd = i3;
            if (c34203a.mFe) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    /* renamed from: vZ */
    public final C3154a mo62055vZ(int i) {
        int size = this.mHp.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3154a b;
            C34203a c34203a = (C34203a) this.mHp.get(i2);
            if (c34203a.mFb == i && c34203a.mFc) {
                b = mo51306b(i, c34203a);
            } else if (c34203a.mFd == i && c34203a.mFe) {
                b = mo51307c(i, c34203a);
            } else if (i <= c34203a.mFd) {
                b = mo7331a(i, c34203a);
            } else {
                b = null;
            }
            if (b != null) {
                if (b.position == c34203a.mFd) {
                    b.mFk = false;
                }
                b.mFa = this.mFa;
                b.mDz = c34203a.mDz;
                b.mFl = c34203a.businessType;
                return b;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public C39147k mo51306b(int i, C34203a c34203a) {
        return new C39147k(i);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public C39152n mo51307c(int i, C34203a c34203a) {
        C39152n c39152n = new C39152n(i);
        c39152n.mFn = c34203a.mFd - c34203a.mFb;
        c39152n.mFt = true;
        return c39152n;
    }

    public final void clearData() {
        this.query = null;
        this.mEu.clear();
        this.mHp.clear();
    }

    /* renamed from: b */
    public final void mo8215b(C28109j c28109j) {
        switch (c28109j.bFZ) {
            case -3:
            case -2:
            case -1:
                C4990ab.m7417i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", Integer.valueOf(getType()), Integer.valueOf(c28109j.bFZ), c28109j.mAJ.query);
                if (!c28109j.mAJ.query.equals(this.query)) {
                    C4990ab.m7416i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
                    return;
                }
                break;
            case 0:
                C4990ab.m7417i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", Integer.valueOf(getType()), Integer.valueOf(c28109j.mEy.size()));
                if (this.query != null && this.query.equals(c28109j.mAJ.query)) {
                    this.mEu = c28109j.mAJ.mEu;
                    mo7332a(c28109j, this.mEu);
                    break;
                }
                C4990ab.m7417i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", c28109j.mAJ.query, this.query);
                return;
            default:
                return;
        }
        this.mEZ.mo7490a(this, c28109j.mAJ.query);
    }

    public final LinkedList<Integer> bAs() {
        LinkedList linkedList = new LinkedList();
        int size = this.mHp.size();
        for (int i = 0; i < size; i++) {
            C34203a c34203a = (C34203a) this.mHp.get(i);
            if (c34203a.mFb != BaseClientBuilder.API_PRIORITY_OTHER) {
                linkedList.add(Integer.valueOf(c34203a.mFb));
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    public C3154a mo7489a(int i, int i2, C45966l c45966l, C34203a c34203a) {
        return null;
    }

    public final int bAK() {
        int size = this.mHp.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            for (C45966l c45966l : ((C34203a) this.mHp.get(i2)).mFf) {
                String bc = C5046bo.m7532bc(c45966l.mDx, "");
                Object obj = -1;
                switch (bc.hashCode()) {
                    case -19329355:
                        if (bc.equals("create_chatroom​")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 255180560:
                        if (bc.equals("no_result​")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 541269703:
                        if (bc.equals("create_talker_message​")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                    case 1:
                    case 2:
                        break;
                    default:
                        i++;
                        break;
                }
            }
        }
        return i;
    }

    public final int bAt() {
        return bAK();
    }
}
