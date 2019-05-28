package com.tencent.p177mm.plugin.ext.p962b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C17915b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42002hl;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.ext.C45904a;
import com.tencent.p177mm.plugin.messenger.p993a.C12518f;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ext.b.c */
public final class C45906c {
    private static Map<String, C34084a> mCache = null;
    final C1202f ehi = new C459051();
    private String lPB = "";
    private boolean lPC = false;
    private Context mContext = null;

    /* renamed from: com.tencent.mm.plugin.ext.b.c$a */
    class C34084a {
        buv lPE = null;
        but lPF = null;
        String userName = "";

        public C34084a(String str, buv buv, but but) {
            this.userName = str;
            this.lPE = buv;
            this.lPF = but;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ext.b.c$1 */
    class C459051 implements C1202f {
        C459051() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20298);
            C9638aw.m17182Rg().mo14546b(106, (C1202f) this);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
                buv bOj = ((C12518f) c1207m).bOj();
                C4990ab.m7417i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", Integer.valueOf(bOj.wod));
                if (bOj.wod > 0) {
                    if (bOj.woe.isEmpty()) {
                        C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                        C45906c.m85114a(C45906c.this, bOj);
                    }
                    if (bOj.woe.size() > 1) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("add_more_friend_search_scene", 3);
                            intent.putExtra("result", bOj.toByteArray());
                            C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                            C45904a.gkE.mo38935t(intent, C45906c.this.mContext);
                            AppMethodBeat.m2505o(20298);
                            return;
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.RedirectToChattingByPhoneHelper", e, "", new Object[0]);
                            AppMethodBeat.m2505o(20298);
                            return;
                        }
                    }
                    C45906c.m85113a(C45906c.this, (but) bOj.woe.getFirst());
                    AppMethodBeat.m2505o(20298);
                    return;
                }
                C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
                C45906c.m85118b(C45906c.this, bOj);
                AppMethodBeat.m2505o(20298);
                return;
            }
            C4990ab.m7421w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            C45906c.m85114a(C45906c.this, null);
            AppMethodBeat.m2505o(20298);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m85118b(C45906c c45906c, buv buv) {
        AppMethodBeat.m2504i(20308);
        c45906c.m85116a(buv);
        AppMethodBeat.m2505o(20308);
    }

    public C45906c(Context context, String str) {
        AppMethodBeat.m2504i(20299);
        this.mContext = context;
        this.lPB = str;
        this.lPC = true;
        AppMethodBeat.m2505o(20299);
    }

    public final int brH() {
        AppMethodBeat.m2504i(20300);
        if (this.mContext == null) {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            AppMethodBeat.m2505o(20300);
            return -1;
        } else if (C5046bo.isNullOrNil(this.lPB)) {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            AppMethodBeat.m2505o(20300);
            return -1;
        } else {
            String amN = C5025av.amN(this.lPB);
            if (C5046bo.isNullOrNil(amN)) {
                C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                AppMethodBeat.m2505o(20300);
                return -1;
            }
            C34084a c34084a;
            String str = this.lPB;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                c34084a = null;
            } else {
                if (mCache == null) {
                    mCache = new HashMap();
                }
                c34084a = (C34084a) mCache.get(str);
            }
            int a;
            if (c34084a != null) {
                C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                a = m85111a(c34084a.userName, c34084a.lPE, c34084a.lPF);
                AppMethodBeat.m2505o(20300);
                return a;
            }
            C42002hl c42002hl = new C42002hl();
            c42002hl.cCl.cCn = amN;
            C4879a.xxA.mo10055m(c42002hl);
            str = c42002hl.cCm.userName;
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
                C9638aw.m17182Rg().mo14539a(106, this.ehi);
                C9638aw.m17182Rg().mo14541a(new C12518f(amN, 3), 0);
                Intent intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI");
                intent.setFlags(268435456);
                this.mContext.startActivity(intent);
                AppMethodBeat.m2505o(20300);
                return 2;
            }
            C4990ab.m7417i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", str);
            a = m85111a(str, null, null);
            AppMethodBeat.m2505o(20300);
            return a;
        }
    }

    /* renamed from: a */
    private static void m85117a(String str, C34084a c34084a) {
        AppMethodBeat.m2504i(20301);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            AppMethodBeat.m2505o(20301);
            return;
        }
        if (mCache == null) {
            mCache = new HashMap();
        }
        mCache.put(str, c34084a);
        AppMethodBeat.m2505o(20301);
    }

    /* renamed from: a */
    private int m85111a(String str, buv buv, but but) {
        AppMethodBeat.m2504i(CdnLogic.kMediaTypeAppVideo);
        if (this.mContext == null) {
            C4990ab.m7420w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeAppVideo);
            return -1;
        }
        if (!C5046bo.isNullOrNil(str)) {
            C9638aw.m17190ZK();
            if (C18628c.m29078XM().aoJ(str)) {
                C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                m85110Lf(str);
                AppMethodBeat.m2505o(CdnLogic.kMediaTypeAppVideo);
                return 0;
            }
        }
        if (buv != null) {
            C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            m85116a(buv);
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeAppVideo);
            return 1;
        } else if (but != null) {
            C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            m85115a(but);
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeAppVideo);
            return 1;
        } else {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            AppMethodBeat.m2505o(CdnLogic.kMediaTypeAppVideo);
            return -1;
        }
    }

    /* renamed from: Lf */
    private void m85110Lf(String str) {
        AppMethodBeat.m2504i(20303);
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        C25985d.m41473f(this.mContext, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.m2505o(20303);
    }

    /* renamed from: a */
    private void m85116a(buv buv) {
        AppMethodBeat.m2504i(20304);
        if (buv == null) {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            AppMethodBeat.m2505o(20304);
            return;
        }
        String a = C1946aa.m4148a(buv.wcB);
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            AppMethodBeat.m2505o(20304);
            return;
        }
        C45906c.m85117a(this.lPB, new C34084a(C1946aa.m4148a(buv.wcB), buv, null));
        C9638aw.m17190ZK();
        if (C18628c.m29078XM().aoJ(a)) {
            C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
            m85110Lf(a);
            AppMethodBeat.m2505o(20304);
            return;
        }
        Intent intent = new Intent();
        C17915b.m28130a(intent, buv, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        C45904a.gkE.mo38912c(intent, this.mContext);
        AppMethodBeat.m2505o(20304);
    }

    /* renamed from: a */
    private void m85115a(but but) {
        AppMethodBeat.m2504i(20305);
        if (but == null) {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            AppMethodBeat.m2505o(20305);
            return;
        }
        String a = C1946aa.m4148a(but.wcB);
        if (C5046bo.isNullOrNil(a)) {
            C4990ab.m7412e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            AppMethodBeat.m2505o(20305);
            return;
        }
        C45906c.m85117a(this.lPB, new C34084a(C1946aa.m4148a(but.wcB), null, but));
        C9638aw.m17190ZK();
        if (C18628c.m29078XM().aoJ(a)) {
            C4990ab.m7416i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
            m85110Lf(a);
            AppMethodBeat.m2505o(20305);
            return;
        }
        Intent intent = new Intent();
        C17915b.m28129a(intent, but);
        intent.putExtra("add_more_friend_search_scene", 2);
        C45904a.gkE.mo38912c(intent, this.mContext);
        AppMethodBeat.m2505o(20305);
    }
}
