package com.tencent.p177mm.plugin.card.model.p353a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.protocal.protobuf.agh;
import com.tencent.p177mm.protocal.protobuf.agi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C17355d;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
/* renamed from: com.tencent.mm.plugin.card.model.a.f */
public final class C33765f extends C11283k<agi> {
    private static final String TAG = TAG;
    public static final C2758a kfh = new C2758a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
    /* renamed from: com.tencent.mm.plugin.card.model.a.f$a */
    public static final class C2758a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
        /* renamed from: com.tencent.mm.plugin.card.model.a.f$a$a */
        static final class C2759a<_Ret, _Var> implements C5681a<_Ret, _Var> {
            public static final C2759a kfi = new C2759a();

            static {
                AppMethodBeat.m2504i(89163);
                AppMethodBeat.m2505o(89163);
            }

            C2759a() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(89162);
                C37441a c37441a = (C37441a) obj;
                C2758a c2758a = C33765f.kfh;
                C4990ab.m7417i(C33765f.TAG, "errtype: %s, errcode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                if (c37441a.errType == 0 && c37441a.errCode == 0) {
                    agi agi = (agi) c37441a.fsy;
                    C2758a c2758a2 = C33765f.kfh;
                    C4990ab.m7417i(C33765f.TAG, "retCode: %s", Integer.valueOf(agi.kdT));
                    if (agi.kdT == 0) {
                        int i = agi.wne ? 1 : 0;
                        C2758a c2758a3 = C33765f.kfh;
                        C4990ab.m7417i(C33765f.TAG, "new version: %s, new version style: %s, trade area: %s", Boolean.valueOf(agi.wne), Integer.valueOf(agi.wnf), Integer.valueOf(agi.wng));
                        C1706e RP = C1720g.m3536RP();
                        C25052j.m39375o(RP, "MMKernel.storage()");
                        RP.mo5239Ry().set(C5127a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, Integer.valueOf(i));
                        C1706e RP2 = C1720g.m3536RP();
                        C25052j.m39375o(RP2, "MMKernel.storage()");
                        RP2.mo5239Ry().set(C5127a.USERINFO_CARD_ENTRANCE_SHOW_SORT_INT_SYNC, Integer.valueOf(agi.wnf));
                        RP2 = C1720g.m3536RP();
                        C25052j.m39375o(RP2, "MMKernel.storage()");
                        RP2.mo5239Ry().set(C5127a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(agi.wng));
                        if (agi.wnh != null) {
                            byte[] toByteArray = agi.wnh.toByteArray();
                            C25052j.m39375o(toByteArray, "trade_area_version_mini_app_info.toByteArray()");
                            Object str = new String(toByteArray, C17355d.ISO_8859_1);
                            C1706e RP3 = C1720g.m3536RP();
                            C25052j.m39375o(RP3, "MMKernel.storage()");
                            RP3.mo5239Ry().set(C5127a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INFO_STRING_SYNC, str);
                        }
                    }
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(89162);
                return c37091y;
            }
        }

        private C2758a() {
        }

        public /* synthetic */ C2758a(byte b) {
            this();
        }

        /* renamed from: fF */
        public static void m5011fF(boolean z) {
            AppMethodBeat.m2504i(89164);
            C4990ab.m7417i(C33765f.TAG, "trigger get card entrance: %s", Boolean.valueOf(z));
            C1706e RP = C1720g.m3536RP();
            C25052j.m39375o(RP, "MMKernel.storage()");
            Object obj = RP.mo5239Ry().get(C5127a.USERINFO_CARD_ENTRANCE_LAST_TIMESTAMP_LONG_SYNC, Long.valueOf(0));
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.Long");
                AppMethodBeat.m2505o(89164);
                throw c44941v;
            }
            long currentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
            if (z || currentTimeMillis > 86400000) {
                RP = C1720g.m3536RP();
                C25052j.m39375o(RP, "MMKernel.storage()");
                RP.mo5239Ry().set(C5127a.USERINFO_CARD_ENTRANCE_LAST_TIMESTAMP_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                new C33765f().acy().mo60492h(C2759a.kfi);
            }
            AppMethodBeat.m2505o(89164);
        }
    }

    public C33765f() {
        AppMethodBeat.m2504i(89165);
        mo22982a(new agh(), new agi(), 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
        C4990ab.m7416i(TAG, "do get card entrance style");
        AppMethodBeat.m2505o(89165);
    }

    static {
        AppMethodBeat.m2504i(89166);
        AppMethodBeat.m2505o(89166);
    }
}
