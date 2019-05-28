package com.tencent.mm.plugin.card.model.a;

import a.f.b.j;
import a.k.d;
import a.l;
import a.v;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class f extends k<agi> {
    private static final String TAG = TAG;
    public static final a kfh = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
        static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            public static final a kfi = new a();

            static {
                AppMethodBeat.i(89163);
                AppMethodBeat.o(89163);
            }

            a() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(89162);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                a aVar2 = f.kfh;
                ab.i(f.TAG, "errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    agi agi = (agi) aVar.fsy;
                    a aVar3 = f.kfh;
                    ab.i(f.TAG, "retCode: %s", Integer.valueOf(agi.kdT));
                    if (agi.kdT == 0) {
                        int i = agi.wne ? 1 : 0;
                        a aVar4 = f.kfh;
                        ab.i(f.TAG, "new version: %s, new version style: %s, trade area: %s", Boolean.valueOf(agi.wne), Integer.valueOf(agi.wnf), Integer.valueOf(agi.wng));
                        e RP = g.RP();
                        j.o(RP, "MMKernel.storage()");
                        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_SWITCH_INT_SYNC, Integer.valueOf(i));
                        e RP2 = g.RP();
                        j.o(RP2, "MMKernel.storage()");
                        RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_SHOW_SORT_INT_SYNC, Integer.valueOf(agi.wnf));
                        RP2 = g.RP();
                        j.o(RP2, "MMKernel.storage()");
                        RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INT_SYNC, Integer.valueOf(agi.wng));
                        if (agi.wnh != null) {
                            byte[] toByteArray = agi.wnh.toByteArray();
                            j.o(toByteArray, "trade_area_version_mini_app_info.toByteArray()");
                            Object str = new String(toByteArray, d.ISO_8859_1);
                            e RP3 = g.RP();
                            j.o(RP3, "MMKernel.storage()");
                            RP3.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_TRADE_AREA_INFO_STRING_SYNC, str);
                        }
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(89162);
                return yVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static void fF(boolean z) {
            AppMethodBeat.i(89164);
            ab.i(f.TAG, "trigger get card entrance: %s", Boolean.valueOf(z));
            e RP = g.RP();
            j.o(RP, "MMKernel.storage()");
            Object obj = RP.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_LAST_TIMESTAMP_LONG_SYNC, Long.valueOf(0));
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type kotlin.Long");
                AppMethodBeat.o(89164);
                throw vVar;
            }
            long currentTimeMillis = System.currentTimeMillis() - ((Long) obj).longValue();
            if (z || currentTimeMillis > 86400000) {
                RP = g.RP();
                j.o(RP, "MMKernel.storage()");
                RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CARD_ENTRANCE_LAST_TIMESTAMP_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                new f().acy().h(a.kfi);
            }
            AppMethodBeat.o(89164);
        }
    }

    public f() {
        AppMethodBeat.i(89165);
        a(new agh(), new agi(), 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
        ab.i(TAG, "do get card entrance style");
        AppMethodBeat.o(89165);
    }

    static {
        AppMethodBeat.i(89166);
        AppMethodBeat.o(89166);
    }
}
