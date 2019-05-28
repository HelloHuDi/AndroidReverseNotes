package com.tencent.p177mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C37801tb;
import com.tencent.p177mm.p230g.p231a.C42061sy;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.plugin.talkroom.model.C39952b;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.talkroom.Plugin */
public class Plugin implements C40415c {

    /* renamed from: com.tencent.mm.plugin.talkroom.Plugin$a */
    class C7161a extends C4884c<C42061sy> {
        private C7161a() {
            AppMethodBeat.m2504i(25680);
            this.xxI = C42061sy.class.getName().hashCode();
            AppMethodBeat.m2505o(25680);
        }

        /* synthetic */ C7161a(Plugin plugin, byte b) {
            this();
            AppMethodBeat.m2504i(25682);
            this.xxI = C42061sy.class.getName().hashCode();
            AppMethodBeat.m2505o(25682);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25681);
            C42061sy c42061sy = (C42061sy) c4883b;
            if (!(c42061sy instanceof C42061sy)) {
                C4990ab.m7415f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", c42061sy.getClass().getName());
            } else if (c42061sy.cPd.cPe) {
                C39952b.cEk().syh = 1;
                AppMethodBeat.m2505o(25681);
                return true;
            }
            AppMethodBeat.m2505o(25681);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.Plugin$b */
    static class C7162b extends C4884c<C42062sz> {
        private C7162b() {
            AppMethodBeat.m2504i(25683);
            this.xxI = C42062sz.class.getName().hashCode();
            AppMethodBeat.m2505o(25683);
        }

        /* synthetic */ C7162b(byte b) {
            this();
            AppMethodBeat.m2504i(25685);
            this.xxI = C42062sz.class.getName().hashCode();
            AppMethodBeat.m2505o(25685);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25684);
            C42062sz c42062sz = (C42062sz) c4883b;
            if (c42062sz != null) {
                if (!(c42062sz instanceof C42062sz)) {
                    C4990ab.m7415f("MicroMsg.TalkRoomServerListener", "mismatch %s", c42062sz.getClass().getName());
                } else if (c42062sz.cPf.cPi) {
                    C39952b.cEh().cEw();
                    AppMethodBeat.m2505o(25684);
                    return true;
                } else if (!(!c42062sz.cPf.cPh || c42062sz.cPg == null || C39952b.cEh() == null)) {
                    c42062sz.cPg.cPj = C39952b.cEh().syD;
                    AppMethodBeat.m2505o(25684);
                    return true;
                }
            }
            AppMethodBeat.m2505o(25684);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.Plugin$1 */
    class C294121 extends C4884c<C26171jl> {
        C294121() {
            AppMethodBeat.m2504i(25678);
            this.xxI = C26171jl.class.getName().hashCode();
            AppMethodBeat.m2505o(25678);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25679);
            switch (((C26171jl) c4883b).cEK.status) {
                case 0:
                    if (C39952b.cEh() != null) {
                        C39952b.cEh().cEw();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(25679);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.Plugin$c */
    class C29413c extends C4884c<C37801tb> {
        private C29413c() {
            AppMethodBeat.m2504i(25686);
            this.xxI = C37801tb.class.getName().hashCode();
            AppMethodBeat.m2505o(25686);
        }

        /* synthetic */ C29413c(Plugin plugin, byte b) {
            this();
            AppMethodBeat.m2504i(25688);
            this.xxI = C37801tb.class.getName().hashCode();
            AppMethodBeat.m2505o(25688);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(25687);
            if (!(((C37801tb) c4883b) instanceof C37801tb)) {
                C4990ab.m7415f("MicroMsg.TalkRoom.Plugin", "mismatch %s", ((C37801tb) c4883b).getClass().getName());
            }
            AppMethodBeat.m2505o(25687);
            return false;
        }
    }

    public Plugin() {
        AppMethodBeat.m2504i(25689);
        C4879a.xxA.mo10052c(new C294121());
        C4879a.xxA.mo10052c(new C7162b());
        C4879a.xxA.mo10052c(new C7161a(this, (byte) 0));
        C4879a.xxA.mo10052c(new C29413c(this, (byte) 0));
        AppMethodBeat.m2505o(25689);
    }

    public C23256o createApplication() {
        AppMethodBeat.m2504i(25690);
        C39945a c39945a = new C39945a();
        AppMethodBeat.m2505o(25690);
        return c39945a;
    }

    public C44040b getContactWidgetFactory() {
        return null;
    }

    public C1816at createSubCore() {
        AppMethodBeat.m2504i(25691);
        C39952b c39952b = new C39952b();
        AppMethodBeat.m2505o(25691);
        return c39952b;
    }
}
