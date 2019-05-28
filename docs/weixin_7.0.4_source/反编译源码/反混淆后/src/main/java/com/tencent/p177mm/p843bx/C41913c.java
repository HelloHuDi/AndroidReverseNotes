package com.tencent.p177mm.p843bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C37465p;
import com.tencent.p177mm.cache.ArtistCacheManager;
import com.tencent.p177mm.cache.C24666c;
import com.tencent.p177mm.cache.C26001b;
import com.tencent.p177mm.cache.C41918a;
import com.tencent.p177mm.cache.C41920g;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.p226e.C1493a;
import com.tencent.p177mm.p226e.C1497c;
import com.tencent.p177mm.p226e.C9268b;
import com.tencent.p177mm.p651y.C36398c;
import com.tencent.p177mm.p651y.C36890e;
import com.tencent.p177mm.p651y.C5755b;
import com.tencent.p177mm.view.footer.C16070a;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: com.tencent.mm.bx.c */
public final class C41913c implements C37465p {
    private C18117b cjc;

    public C41913c(C18117b c18117b) {
        this.cjc = c18117b;
    }

    /* renamed from: Ar */
    public final int mo60375Ar() {
        AppMethodBeat.m2504i(116356);
        C24666c c24666c = (C24666c) ArtistCacheManager.m28552Jc().mo33607a(C1493a.EMOJI_AND_TEXT);
        if (c24666c == null) {
            AppMethodBeat.m2505o(116356);
            return 0;
        }
        int i = c24666c.mo41560Jk()[1];
        AppMethodBeat.m2505o(116356);
        return i;
    }

    /* renamed from: As */
    public final int mo60376As() {
        AppMethodBeat.m2504i(116357);
        C24666c c24666c = (C24666c) ArtistCacheManager.m28552Jc().mo33607a(C1493a.EMOJI_AND_TEXT);
        if (c24666c == null) {
            AppMethodBeat.m2505o(116357);
            return 0;
        }
        int i = c24666c.mo41560Jk()[0];
        AppMethodBeat.m2505o(116357);
        return i;
    }

    /* renamed from: At */
    public final int mo60377At() {
        AppMethodBeat.m2504i(116358);
        C41920g c41920g = (C41920g) ArtistCacheManager.m28552Jc().mo33607a(C1493a.MOSAIC);
        if (c41920g == null) {
            AppMethodBeat.m2505o(116358);
            return 0;
        }
        int ac = c41920g.mo33616ac(false);
        AppMethodBeat.m2505o(116358);
        return ac;
    }

    /* renamed from: Au */
    public final int mo60378Au() {
        AppMethodBeat.m2504i(116359);
        C26001b c26001b = (C26001b) ArtistCacheManager.m28552Jc().mo33607a(C1493a.DOODLE);
        if (c26001b == null) {
            AppMethodBeat.m2505o(116359);
            return 0;
        }
        int ac = c26001b.mo33616ac(false);
        AppMethodBeat.m2505o(116359);
        return ac;
    }

    /* renamed from: Av */
    public final int mo60379Av() {
        AppMethodBeat.m2504i(116360);
        int i = 0;
        C26001b c26001b = (C26001b) ArtistCacheManager.m28552Jc().mo33607a(C1493a.DOODLE);
        if (c26001b != null) {
            i = c26001b.efs + 0;
        }
        C41920g c41920g = (C41920g) ArtistCacheManager.m28552Jc().mo33607a(C1493a.MOSAIC);
        if (c41920g != null) {
            i += c41920g.efs;
        }
        AppMethodBeat.m2505o(116360);
        return i;
    }

    public final boolean isCropped() {
        AppMethodBeat.m2504i(116361);
        C41918a c41918a = (C41918a) ArtistCacheManager.m28552Jc().mo33607a(C1493a.CROP_PHOTO);
        if (c41918a == null) {
            AppMethodBeat.m2505o(116361);
            return false;
        } else if (c41918a.mo33616ac(false) > 0) {
            AppMethodBeat.m2505o(116361);
            return true;
        } else {
            AppMethodBeat.m2505o(116361);
            return false;
        }
    }

    /* renamed from: Aw */
    public final boolean mo60380Aw() {
        boolean z = false;
        AppMethodBeat.m2504i(116362);
        C9268b b = this.cjc.mo33566b(C32247e.CROP_PHOTO);
        if (b != null && b.mo4943CG() == C1493a.CROP_PHOTO) {
            boolean z2;
            if (((C1497c) b).cjO > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2;
        }
        AppMethodBeat.m2505o(116362);
        return z;
    }

    public final int getTextColor() {
        AppMethodBeat.m2504i(116363);
        C24666c c24666c = (C24666c) ArtistCacheManager.m28552Jc().mo33607a(C1493a.EMOJI_AND_TEXT);
        if (c24666c == null) {
            AppMethodBeat.m2505o(116363);
            return 0;
        }
        int i;
        Stack stack = c24666c.efq;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                C36398c c36398c = (C36398c) it.next();
                if (c36398c instanceof C36890e) {
                    C36890e c36890e = (C36890e) c36398c;
                    int[] iArr = C16070a.AcD;
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (c36890e.mColor == iArr[i2]) {
                            i = (1 << i2) | i;
                            break;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(116363);
        return i;
    }

    /* renamed from: Ax */
    public final int mo60381Ax() {
        AppMethodBeat.m2504i(116364);
        C26001b c26001b = (C26001b) ArtistCacheManager.m28552Jc().mo33607a(C1493a.DOODLE);
        if (c26001b == null) {
            AppMethodBeat.m2505o(116364);
            return 0;
        }
        int i;
        Stack stack = c26001b.efq;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                C5755b c5755b = (C5755b) it.next();
                int[] iArr = C16070a.AcD;
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (c5755b.mColor == iArr[i2]) {
                        i = (1 << i2) | i;
                        break;
                    }
                }
            }
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(116364);
        return i;
    }

    /* renamed from: Ay */
    public final boolean mo60382Ay() {
        AppMethodBeat.m2504i(116365);
        C26001b c26001b = (C26001b) ArtistCacheManager.m28552Jc().mo33607a(C1493a.DOODLE);
        C41920g c41920g = (C41920g) ArtistCacheManager.m28552Jc().mo33607a(C1493a.MOSAIC);
        C41918a c41918a = (C41918a) ArtistCacheManager.m28552Jc().mo33607a(C1493a.CROP_PHOTO);
        C24666c c24666c = (C24666c) ArtistCacheManager.m28552Jc().mo33607a(C1493a.EMOJI_AND_TEXT);
        if ((c26001b == null || c26001b.mo33616ac(true) <= 0) && ((c41920g == null || c41920g.mo33616ac(true) <= 0) && ((c24666c == null || c24666c.mo33616ac(true) <= 0) && (c41918a == null || c41918a.mo33616ac(true) <= 0)))) {
            AppMethodBeat.m2505o(116365);
            return false;
        }
        AppMethodBeat.m2505o(116365);
        return true;
    }

    /* renamed from: Az */
    public final String mo60383Az() {
        AppMethodBeat.m2504i(116366);
        String str = ((C24666c) ArtistCacheManager.m28552Jc().mo33607a(C1493a.EMOJI_AND_TEXT)).mo41563kb(",")[0];
        AppMethodBeat.m2505o(116366);
        return str;
    }

    /* renamed from: AA */
    public final String mo60374AA() {
        AppMethodBeat.m2504i(116367);
        String str = ((C24666c) ArtistCacheManager.m28552Jc().mo33607a(C1493a.EMOJI_AND_TEXT)).mo41563kb("||")[1];
        AppMethodBeat.m2505o(116367);
        return str;
    }
}
