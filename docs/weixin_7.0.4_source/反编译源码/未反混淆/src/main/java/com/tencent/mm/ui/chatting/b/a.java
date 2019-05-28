package com.tencent.mm.ui.chatting.b;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.choosemsgfile.compat.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.record.b.c;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a implements b {
    public final boolean a(bi biVar, com.tencent.mm.pluginsdk.model.app.b bVar) {
        AppMethodBeat.i(31165);
        boolean a = l.a(biVar, bVar);
        AppMethodBeat.o(31165);
        return a;
    }

    public final com.tencent.mm.pluginsdk.model.app.b i(String str, long j) {
        AppMethodBeat.i(31166);
        com.tencent.mm.pluginsdk.model.app.b i = l.i(str, j);
        AppMethodBeat.o(31166);
        return i;
    }

    public final boolean a(final String str, bi biVar, final b.b bVar) {
        AppMethodBeat.i(31167);
        if (bo.isNullOrNil(str) || biVar == null) {
            d.e("MicroMsg.ChooseMsgFileCompat", "mediaId:%s or msg is null, err", str);
            AppMethodBeat.o(31167);
            return false;
        }
        f anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(31160);
                d.i("MicroMsg.ChooseMsgFileCompat", "tryInitAttachInfo errType:%d errCode:%d, errMsg:%s type:%d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
                if (mVar.getType() != 728) {
                    AppMethodBeat.o(31160);
                    return;
                }
                if (str.equals(((c) mVar).getMediaId())) {
                    aw.Rg().b(728, (f) this);
                    if (i == 0 && i2 == 0) {
                        if (bVar != null) {
                            bVar.n(0, "");
                            AppMethodBeat.o(31160);
                            return;
                        }
                    } else if (bVar != null) {
                        bVar.n(i2, str);
                    }
                    AppMethodBeat.o(31160);
                    return;
                }
                d.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", str, ((c) mVar).getMediaId());
                AppMethodBeat.o(31160);
            }
        };
        aw.Rg().a(728, anonymousClass1);
        if (!(!l.d(str, biVar))) {
            bVar.n(0, "");
            aw.Rg().b(728, anonymousClass1);
        }
        AppMethodBeat.o(31167);
        return true;
    }

    public final void a(com.tencent.mm.pluginsdk.model.app.b bVar) {
        AppMethodBeat.i(31168);
        if (bVar != null) {
            bVar.field_status = 101;
            bVar.field_lastModifyTime = bo.anT();
            am.aUq().a(bVar, new String[0]);
        }
        AppMethodBeat.o(31168);
    }

    public final com.tencent.mm.vending.e.a a(long j, String str, final com.tencent.mm.choosemsgfile.compat.b.a aVar) {
        AppMethodBeat.i(31169);
        if (bo.isNullOrNil(str)) {
            d.e("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect() mediaId is null, return");
            AppMethodBeat.o(31169);
            return null;
        }
        final String str2 = str;
        final com.tencent.mm.choosemsgfile.compat.b.a aVar2 = aVar;
        final long j2 = j;
        aw.Rg().a(221, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(31161);
                d.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect errType:%d errCode:%d, errMsg:%s type:%d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(mVar.getType()));
                if (mVar.getType() != 221) {
                    AppMethodBeat.o(31161);
                    return;
                }
                e eVar = (e) mVar;
                if (str2.equals(eVar.getMediaId())) {
                    aw.Rg().b(221, (f) this);
                    if (i == 0 && i2 == 0) {
                        int i3 = eVar.retCode;
                        d.i("MicroMsg.ChooseMsgFileCompat", "downloadAppAttachDirect retCode:%d", Integer.valueOf(i3));
                        if (i3 < 0 && aVar2 != null) {
                            aVar2.m(i3, "");
                        }
                        AppMethodBeat.o(31161);
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.b i4 = l.i(str2, j2);
                    if (i4 == null || i4.field_status != 102) {
                        if (aVar2 != null) {
                            aVar2.m(-1, str);
                        }
                        AppMethodBeat.o(31161);
                        return;
                    }
                    if (aVar2 != null) {
                        aVar2.m(1, str);
                    }
                    AppMethodBeat.o(31161);
                    return;
                }
                d.w("MicroMsg.ChooseMsgFileCompat", "media:%s is not equal targetMedia:%s", str2, eVar.getMediaId());
                AppMethodBeat.o(31161);
            }
        });
        final m eVar = new e(j, str, new g() {
            public final void a(int i, int i2, m mVar) {
                AppMethodBeat.i(31162);
                if (aVar != null) {
                    aVar.bQ(i, i2);
                }
                if (i >= i2 && aVar != null) {
                    aVar.m(0, "");
                }
                AppMethodBeat.o(31162);
            }
        });
        aw.Rg().a(eVar, 0);
        com.tencent.mm.vending.e.a anonymousClass4 = new com.tencent.mm.vending.e.a() {
            public final void dead() {
                AppMethodBeat.i(31163);
                eVar.a(null);
                com.tencent.mm.kernel.g.Rg().c(eVar);
                AppMethodBeat.o(31163);
            }
        };
        AppMethodBeat.o(31169);
        return anonymousClass4;
    }

    public final boolean c(bi biVar) {
        AppMethodBeat.i(31170);
        boolean c = com.tencent.mm.ui.chatting.gallery.c.c(biVar);
        AppMethodBeat.o(31170);
        return c;
    }

    public final com.tencent.mm.at.e d(bi biVar) {
        AppMethodBeat.i(31171);
        com.tencent.mm.at.e d = com.tencent.mm.ui.chatting.gallery.e.d(biVar);
        AppMethodBeat.o(31171);
        return d;
    }

    public final String a(bi biVar, com.tencent.mm.at.e eVar) {
        AppMethodBeat.i(31172);
        String a = com.tencent.mm.ui.chatting.gallery.e.a(biVar, eVar);
        AppMethodBeat.o(31172);
        return a;
    }

    public final String e(bi biVar) {
        AppMethodBeat.i(31173);
        String e = com.tencent.mm.ui.chatting.gallery.c.e(biVar);
        AppMethodBeat.o(31173);
        return e;
    }

    public final void a(bi biVar, final com.tencent.mm.choosemsgfile.compat.b.a aVar) {
        AppMethodBeat.i(31174);
        l.a(biVar, new com.tencent.mm.pluginsdk.model.app.l.a() {
            public final void gK(int i, int i2) {
                AppMethodBeat.i(31164);
                if (aVar != null) {
                    aVar.bQ(i, i2);
                }
                if (i >= i2 && aVar != null) {
                    aVar.m(0, "");
                }
                AppMethodBeat.o(31164);
            }
        });
        AppMethodBeat.o(31174);
    }

    public final boolean f(bi biVar) {
        AppMethodBeat.i(31175);
        boolean f = com.tencent.mm.ui.chatting.gallery.c.f(biVar);
        AppMethodBeat.o(31175);
        return f;
    }
}
