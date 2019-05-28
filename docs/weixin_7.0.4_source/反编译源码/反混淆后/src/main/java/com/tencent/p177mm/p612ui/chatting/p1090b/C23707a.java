package com.tencent.p177mm.p612ui.chatting.p1090b;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.C32464b;
import com.tencent.p177mm.choosemsgfile.compat.C32464b.C32465a;
import com.tencent.p177mm.choosemsgfile.compat.C32464b.C32466b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p612ui.chatting.gallery.C40775c;
import com.tencent.p177mm.p612ui.chatting.gallery.C40780e;
import com.tencent.p177mm.plugin.record.p492b.C43430c;
import com.tencent.p177mm.plugin.record.p492b.C43432e;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.model.app.C4733l.C4734a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vending.p639e.C5684a;

/* renamed from: com.tencent.mm.ui.chatting.b.a */
public final class C23707a implements C32464b {
    /* renamed from: a */
    public final boolean mo39537a(C7620bi c7620bi, C30065b c30065b) {
        AppMethodBeat.m2504i(31165);
        boolean a = C4733l.m7096a(c7620bi, c30065b);
        AppMethodBeat.m2505o(31165);
        return a;
    }

    /* renamed from: i */
    public final C30065b mo39543i(String str, long j) {
        AppMethodBeat.m2504i(31166);
        C30065b i = C4733l.m7103i(str, j);
        AppMethodBeat.m2505o(31166);
        return i;
    }

    /* renamed from: a */
    public final boolean mo39538a(final String str, C7620bi c7620bi, final C32466b c32466b) {
        AppMethodBeat.m2504i(31167);
        if (C5046bo.isNullOrNil(str) || c7620bi == null) {
            C45124d.m82928e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", str);
            AppMethodBeat.m2505o(31167);
            return false;
        }
        C1202f c237091 = new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(31160);
                C45124d.m82930i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
                if (c1207m.getType() != 728) {
                    AppMethodBeat.m2505o(31160);
                    return;
                }
                if (str.equals(((C43430c) c1207m).getMediaId())) {
                    C9638aw.m17182Rg().mo14546b(728, (C1202f) this);
                    if (i == 0 && i2 == 0) {
                        if (c32466b != null) {
                            c32466b.mo45482n(0, "");
                            AppMethodBeat.m2505o(31160);
                            return;
                        }
                    } else if (c32466b != null) {
                        c32466b.mo45482n(i2, str);
                    }
                    AppMethodBeat.m2505o(31160);
                    return;
                }
                C45124d.m82934w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", str, ((C43430c) c1207m).getMediaId());
                AppMethodBeat.m2505o(31160);
            }
        };
        C9638aw.m17182Rg().mo14539a(728, c237091);
        if (!(!C4733l.m7102d(str, c7620bi))) {
            c32466b.mo45482n(0, "");
            C9638aw.m17182Rg().mo14546b(728, c237091);
        }
        AppMethodBeat.m2505o(31167);
        return true;
    }

    /* renamed from: a */
    public final void mo39535a(C30065b c30065b) {
        AppMethodBeat.m2504i(31168);
        if (c30065b != null) {
            c30065b.field_status = 101;
            c30065b.field_lastModifyTime = C5046bo.anT();
            C14877am.aUq().mo48326a(c30065b, new String[0]);
        }
        AppMethodBeat.m2505o(31168);
    }

    /* renamed from: a */
    public final C5684a mo39533a(long j, String str, final C32465a c32465a) {
        AppMethodBeat.m2504i(31169);
        if (C5046bo.isNullOrNil(str)) {
            C45124d.m82927e("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect() mediaId is null, return");
            AppMethodBeat.m2505o(31169);
            return null;
        }
        final String str2 = str;
        final C32465a c32465a2 = c32465a;
        final long j2 = j;
        C9638aw.m17182Rg().mo14539a(221, new C1202f() {
            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(31161);
                C45124d.m82930i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(c1207m.getType()));
                if (c1207m.getType() != 221) {
                    AppMethodBeat.m2505o(31161);
                    return;
                }
                C43432e c43432e = (C43432e) c1207m;
                if (str2.equals(c43432e.getMediaId())) {
                    C9638aw.m17182Rg().mo14546b(221, (C1202f) this);
                    if (i == 0 && i2 == 0) {
                        int i3 = c43432e.retCode;
                        C45124d.m82930i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", Integer.valueOf(i3));
                        if (i3 < 0 && c32465a2 != null) {
                            c32465a2.mo35450m(i3, "");
                        }
                        AppMethodBeat.m2505o(31161);
                        return;
                    }
                    C30065b i4 = C4733l.m7103i(str2, j2);
                    if (i4 == null || i4.field_status != 102) {
                        if (c32465a2 != null) {
                            c32465a2.mo35450m(-1, str);
                        }
                        AppMethodBeat.m2505o(31161);
                        return;
                    }
                    if (c32465a2 != null) {
                        c32465a2.mo35450m(1, str);
                    }
                    AppMethodBeat.m2505o(31161);
                    return;
                }
                C45124d.m82934w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", str2, c43432e.getMediaId());
                AppMethodBeat.m2505o(31161);
            }
        });
        final C1207m c43432e = new C43432e(j, str, new C32231g() {
            /* renamed from: a */
            public final void mo8280a(int i, int i2, C1207m c1207m) {
                AppMethodBeat.m2504i(31162);
                if (c32465a != null) {
                    c32465a.mo35449bQ(i, i2);
                }
                if (i >= i2 && c32465a != null) {
                    c32465a.mo35450m(0, "");
                }
                AppMethodBeat.m2505o(31162);
            }
        });
        C9638aw.m17182Rg().mo14541a(c43432e, 0);
        C5684a c237054 = new C5684a() {
            public final void dead() {
                AppMethodBeat.m2504i(31163);
                c43432e.mo68987a(null);
                C1720g.m3540Rg().mo14547c(c43432e);
                AppMethodBeat.m2505o(31163);
            }
        };
        AppMethodBeat.m2505o(31169);
        return c237054;
    }

    /* renamed from: c */
    public final boolean mo39539c(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31170);
        boolean c = C40775c.m70571c(c7620bi);
        AppMethodBeat.m2505o(31170);
        return c;
    }

    /* renamed from: d */
    public final C25822e mo39540d(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31171);
        C25822e d = C40780e.m70619d(c7620bi);
        AppMethodBeat.m2505o(31171);
        return d;
    }

    /* renamed from: a */
    public final String mo39534a(C7620bi c7620bi, C25822e c25822e) {
        AppMethodBeat.m2504i(31172);
        String a = C40780e.m70601a(c7620bi, c25822e);
        AppMethodBeat.m2505o(31172);
        return a;
    }

    /* renamed from: e */
    public final String mo39541e(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31173);
        String e = C40775c.m70572e(c7620bi);
        AppMethodBeat.m2505o(31173);
        return e;
    }

    /* renamed from: a */
    public final void mo39536a(C7620bi c7620bi, final C32465a c32465a) {
        AppMethodBeat.m2504i(31174);
        C4733l.m7095a(c7620bi, new C4734a() {
            /* renamed from: gK */
            public final void mo9875gK(int i, int i2) {
                AppMethodBeat.m2504i(31164);
                if (c32465a != null) {
                    c32465a.mo35449bQ(i, i2);
                }
                if (i >= i2 && c32465a != null) {
                    c32465a.mo35450m(0, "");
                }
                AppMethodBeat.m2505o(31164);
            }
        });
        AppMethodBeat.m2505o(31174);
    }

    /* renamed from: f */
    public final boolean mo39542f(C7620bi c7620bi) {
        AppMethodBeat.m2504i(31175);
        boolean f = C40775c.m70574f(c7620bi);
        AppMethodBeat.m2505o(31175);
        return f;
    }
}
