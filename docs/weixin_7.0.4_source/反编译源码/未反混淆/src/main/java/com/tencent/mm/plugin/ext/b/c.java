package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.api.b;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, a> mCache = null;
    final f ehi = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(20298);
            aw.Rg().b(106, (f) this);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
                buv bOj = ((com.tencent.mm.plugin.messenger.a.f) mVar).bOj();
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", Integer.valueOf(bOj.wod));
                if (bOj.wod > 0) {
                    if (bOj.woe.isEmpty()) {
                        ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                        c.a(c.this, bOj);
                    }
                    if (bOj.woe.size() > 1) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("add_more_friend_search_scene", 3);
                            intent.putExtra("result", bOj.toByteArray());
                            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                            com.tencent.mm.plugin.ext.a.gkE.t(intent, c.this.mContext);
                            AppMethodBeat.o(20298);
                            return;
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", e, "", new Object[0]);
                            AppMethodBeat.o(20298);
                            return;
                        }
                    }
                    c.a(c.this, (but) bOj.woe.getFirst());
                    AppMethodBeat.o(20298);
                    return;
                }
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
                c.b(c.this, bOj);
                AppMethodBeat.o(20298);
                return;
            }
            ab.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            c.a(c.this, null);
            AppMethodBeat.o(20298);
        }
    };
    private String lPB = "";
    private boolean lPC = false;
    private Context mContext = null;

    class a {
        buv lPE = null;
        but lPF = null;
        String userName = "";

        public a(String str, buv buv, but but) {
            this.userName = str;
            this.lPE = buv;
            this.lPF = but;
        }
    }

    static /* synthetic */ void b(c cVar, buv buv) {
        AppMethodBeat.i(20308);
        cVar.a(buv);
        AppMethodBeat.o(20308);
    }

    public c(Context context, String str) {
        AppMethodBeat.i(20299);
        this.mContext = context;
        this.lPB = str;
        this.lPC = true;
        AppMethodBeat.o(20299);
    }

    public final int brH() {
        AppMethodBeat.i(20300);
        if (this.mContext == null) {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            AppMethodBeat.o(20300);
            return -1;
        } else if (bo.isNullOrNil(this.lPB)) {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            AppMethodBeat.o(20300);
            return -1;
        } else {
            String amN = av.amN(this.lPB);
            if (bo.isNullOrNil(amN)) {
                ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                AppMethodBeat.o(20300);
                return -1;
            }
            a aVar;
            String str = this.lPB;
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                aVar = null;
            } else {
                if (mCache == null) {
                    mCache = new HashMap();
                }
                aVar = (a) mCache.get(str);
            }
            int a;
            if (aVar != null) {
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                a = a(aVar.userName, aVar.lPE, aVar.lPF);
                AppMethodBeat.o(20300);
                return a;
            }
            hl hlVar = new hl();
            hlVar.cCl.cCn = amN;
            com.tencent.mm.sdk.b.a.xxA.m(hlVar);
            str = hlVar.cCm.userName;
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
                aw.Rg().a(106, this.ehi);
                aw.Rg().a(new com.tencent.mm.plugin.messenger.a.f(amN, 3), 0);
                Intent intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
                intent.setFlags(268435456);
                this.mContext.startActivity(intent);
                AppMethodBeat.o(20300);
                return 2;
            }
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", str);
            a = a(str, null, null);
            AppMethodBeat.o(20300);
            return a;
        }
    }

    private static void a(String str, a aVar) {
        AppMethodBeat.i(20301);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            AppMethodBeat.o(20301);
            return;
        }
        if (mCache == null) {
            mCache = new HashMap();
        }
        mCache.put(str, aVar);
        AppMethodBeat.o(20301);
    }

    private int a(String str, buv buv, but but) {
        AppMethodBeat.i(CdnLogic.kMediaTypeAppVideo);
        if (this.mContext == null) {
            ab.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            AppMethodBeat.o(CdnLogic.kMediaTypeAppVideo);
            return -1;
        }
        if (!bo.isNullOrNil(str)) {
            aw.ZK();
            if (com.tencent.mm.model.c.XM().aoJ(str)) {
                ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                Lf(str);
                AppMethodBeat.o(CdnLogic.kMediaTypeAppVideo);
                return 0;
            }
        }
        if (buv != null) {
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            a(buv);
            AppMethodBeat.o(CdnLogic.kMediaTypeAppVideo);
            return 1;
        } else if (but != null) {
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            a(but);
            AppMethodBeat.o(CdnLogic.kMediaTypeAppVideo);
            return 1;
        } else {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            AppMethodBeat.o(CdnLogic.kMediaTypeAppVideo);
            return -1;
        }
    }

    private void Lf(String str) {
        AppMethodBeat.i(20303);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        d.f(this.mContext, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(20303);
    }

    private void a(buv buv) {
        AppMethodBeat.i(20304);
        if (buv == null) {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            AppMethodBeat.o(20304);
            return;
        }
        String a = aa.a(buv.wcB);
        if (bo.isNullOrNil(a)) {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            AppMethodBeat.o(20304);
            return;
        }
        a(this.lPB, new a(aa.a(buv.wcB), buv, null));
        aw.ZK();
        if (com.tencent.mm.model.c.XM().aoJ(a)) {
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
            Lf(a);
            AppMethodBeat.o(20304);
            return;
        }
        Intent intent = new Intent();
        b.a(intent, buv, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.gkE.c(intent, this.mContext);
        AppMethodBeat.o(20304);
    }

    private void a(but but) {
        AppMethodBeat.i(20305);
        if (but == null) {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            AppMethodBeat.o(20305);
            return;
        }
        String a = aa.a(but.wcB);
        if (bo.isNullOrNil(a)) {
            ab.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            AppMethodBeat.o(20305);
            return;
        }
        a(this.lPB, new a(aa.a(but.wcB), null, but));
        aw.ZK();
        if (com.tencent.mm.model.c.XM().aoJ(a)) {
            ab.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
            Lf(a);
            AppMethodBeat.o(20305);
            return;
        }
        Intent intent = new Intent();
        b.a(intent, but);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.gkE.c(intent, this.mContext);
        AppMethodBeat.o(20305);
    }
}
