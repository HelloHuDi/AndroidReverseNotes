package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C17940d.C9017a;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.b */
public final class C33731b implements C9017a {
    int jNL;
    public HashMap<Long, Integer> jNM = new HashMap();
    private C2697h jNN;

    public C33731b(C2697h c2697h) {
        AppMethodBeat.m2504i(14133);
        this.jNN = c2697h;
        AppMethodBeat.m2505o(14133);
    }

    /* renamed from: a */
    private void m55119a(C25822e c25822e, C46627q c46627q, int i, ImageView imageView) {
        AppMethodBeat.m2504i(14134);
        if (C32291o.ahm().mo33463a(c25822e.fDy, c46627q.field_msgId, 0, Integer.valueOf(i), C25738R.drawable.b0p, this, 0, false) == -2) {
            C4990ab.m7420w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
            C25822e b = C33731b.m55121b(c46627q);
            if (b == null) {
                C4990ab.m7420w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
                AppMethodBeat.m2505o(14134);
                return;
            }
            String g = C33731b.m55122g(b);
            if (C5730e.m8628ct(g)) {
                m55120a(g, imageView);
            }
        }
        AppMethodBeat.m2505o(14134);
    }

    /* renamed from: a */
    public final void mo54269a(C46627q c46627q, int i, ImageView imageView, int i2) {
        AppMethodBeat.m2504i(14135);
        this.jNL = i2;
        if (m55123gF(c46627q.field_msgId) == 2 || m55123gF(c46627q.field_msgId) == 3) {
            AppMethodBeat.m2505o(14135);
            return;
        }
        C25822e b = C33731b.m55121b(c46627q);
        if (b != null) {
            String g = C33731b.m55122g(b);
            if (C5730e.m8628ct(g)) {
                m55120a(g, imageView);
                m55124l(c46627q.field_msgId, 1);
                AppMethodBeat.m2505o(14135);
                return;
            }
            m55119a(b, c46627q, i, imageView);
            AppMethodBeat.m2505o(14135);
            return;
        }
        C4990ab.m7421w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", Long.valueOf(c46627q.field_msgId), Long.valueOf(c46627q.field_msgSvrId));
        AppMethodBeat.m2505o(14135);
    }

    /* renamed from: a */
    private void m55120a(String str, ImageView imageView) {
        AppMethodBeat.m2504i(14136);
        final int i = this.jNL != 0 ? C25738R.drawable.axk : 0;
        C25815a ahp = C32291o.ahp();
        C17927a c17927a = new C17927a();
        c17927a.ePX = "biz_nor_img".concat(String.valueOf(i));
        c17927a.ePV = C25738R.color.f11875k8;
        c17927a.fHe = 1;
        ahp.mo43767a(str, imageView, c17927a.ahG(), new C9014g() {
            /* renamed from: sH */
            public final void mo7596sH(String str) {
            }

            /* renamed from: a */
            public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                AppMethodBeat.m2504i(14132);
                if (i == 0) {
                    AppMethodBeat.m2505o(14132);
                    return null;
                } else if (c37477b == null || c37477b.bitmap == null || c37477b.bitmap.isRecycled()) {
                    C4990ab.m7420w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
                    AppMethodBeat.m2505o(14132);
                    return null;
                } else if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7420w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
                    AppMethodBeat.m2505o(14132);
                    return null;
                } else {
                    try {
                        int i;
                        int gd = C1338a.m2868gd(view.getContext()) - ((int) (C1338a.getDensity(view.getContext()) * 16.0f));
                        if (C33731b.this.jNL != 0) {
                            i = C33731b.this.jNL;
                        } else {
                            i = (int) (((double) gd) / 2.35d);
                        }
                        Bitmap b = C5056d.m7649b(c37477b.bitmap, gd, i, true);
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, gd, i, true);
                        if (!(createScaledBitmap == b || b == null || b.isRecycled())) {
                            C4990ab.m7417i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", b);
                            b.recycle();
                        }
                        Bitmap d = C5056d.m7658d(createScaledBitmap, i);
                        if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                            createScaledBitmap.recycle();
                        }
                        AppMethodBeat.m2505o(14132);
                        return d;
                    } catch (OutOfMemoryError e) {
                        C4990ab.m7421w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", e.getMessage());
                        AppMethodBeat.m2505o(14132);
                        return null;
                    }
                }
            }

            /* renamed from: b */
            public final void mo7595b(String str, View view, C37477b c37477b) {
            }
        });
        AppMethodBeat.m2505o(14136);
    }

    /* renamed from: g */
    private static String m55122g(C25822e c25822e) {
        String str = null;
        AppMethodBeat.m2504i(14137);
        if (c25822e == null) {
            AppMethodBeat.m2505o(14137);
        } else {
            String str2 = c25822e.fDz;
            if (c25822e.agQ()) {
                String d = C32291o.ahl().mo73109d(c25822e);
                if (d != null) {
                    d = C32291o.ahl().mo73118q(d, "", "");
                    if (C5730e.m8628ct(d)) {
                        C4990ab.m7416i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
                        str = d;
                    }
                }
            }
            if (str == null) {
                str = C32291o.ahl().mo73118q(str2, "", "");
            }
            AppMethodBeat.m2505o(14137);
        }
        return str;
    }

    /* renamed from: b */
    private static C25822e m55121b(C46627q c46627q) {
        AppMethodBeat.m2504i(14138);
        C25822e c25822e = null;
        if (c46627q.field_msgId > 0) {
            c25822e = C32291o.ahl().mo73113fJ(c46627q.field_msgId);
        }
        if ((c25822e == null || c25822e.fDy <= 0) && c46627q.field_msgSvrId > 0) {
            c25822e = C32291o.ahl().mo73112fI(c46627q.field_msgSvrId);
        }
        AppMethodBeat.m2505o(14138);
        return c25822e;
    }

    /* renamed from: a */
    public final void mo20450a(long j, long j2, int i, int i2, Object obj, int i3, int i4, C1207m c1207m) {
    }

    /* renamed from: a */
    public final void mo20451a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(14139);
        if (i3 == 0 && i4 == 0) {
            m55124l(j2, 1);
            this.jNN.aWv();
            AppMethodBeat.m2505o(14139);
            return;
        }
        C4990ab.m7417i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i4 == -5103059) {
            m55124l(j2, 2);
            AppMethodBeat.m2505o(14139);
            return;
        }
        m55124l(j2, 3);
        AppMethodBeat.m2505o(14139);
    }

    /* renamed from: a */
    public final void mo20449a(long j, long j2, int i, int i2, Object obj) {
    }

    /* renamed from: gF */
    private int m55123gF(long j) {
        AppMethodBeat.m2504i(14140);
        if (this.jNM.containsKey(Long.valueOf(j))) {
            int intValue = ((Integer) this.jNM.get(Long.valueOf(j))).intValue();
            AppMethodBeat.m2505o(14140);
            return intValue;
        }
        AppMethodBeat.m2505o(14140);
        return 0;
    }

    /* renamed from: l */
    private void m55124l(long j, int i) {
        AppMethodBeat.m2504i(14141);
        this.jNM.put(Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.m2505o(14141);
    }
}
