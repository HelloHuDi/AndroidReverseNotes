package com.tencent.mm.plugin.talkroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tb;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public class Plugin implements com.tencent.mm.pluginsdk.b.c {

    class a extends com.tencent.mm.sdk.b.c<sy> {
        private a() {
            AppMethodBeat.i(25680);
            this.xxI = sy.class.getName().hashCode();
            AppMethodBeat.o(25680);
        }

        /* synthetic */ a(Plugin plugin, byte b) {
            this();
            AppMethodBeat.i(25682);
            this.xxI = sy.class.getName().hashCode();
            AppMethodBeat.o(25682);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25681);
            sy syVar = (sy) bVar;
            if (!(syVar instanceof sy)) {
                ab.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", syVar.getClass().getName());
            } else if (syVar.cPd.cPe) {
                com.tencent.mm.plugin.talkroom.model.b.cEk().syh = 1;
                AppMethodBeat.o(25681);
                return true;
            }
            AppMethodBeat.o(25681);
            return false;
        }
    }

    static class b extends com.tencent.mm.sdk.b.c<sz> {
        private b() {
            AppMethodBeat.i(25683);
            this.xxI = sz.class.getName().hashCode();
            AppMethodBeat.o(25683);
        }

        /* synthetic */ b(byte b) {
            this();
            AppMethodBeat.i(25685);
            this.xxI = sz.class.getName().hashCode();
            AppMethodBeat.o(25685);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25684);
            sz szVar = (sz) bVar;
            if (szVar != null) {
                if (!(szVar instanceof sz)) {
                    ab.f("MicroMsg.TalkRoomServerListener", "mismatch %s", szVar.getClass().getName());
                } else if (szVar.cPf.cPi) {
                    com.tencent.mm.plugin.talkroom.model.b.cEh().cEw();
                    AppMethodBeat.o(25684);
                    return true;
                } else if (!(!szVar.cPf.cPh || szVar.cPg == null || com.tencent.mm.plugin.talkroom.model.b.cEh() == null)) {
                    szVar.cPg.cPj = com.tencent.mm.plugin.talkroom.model.b.cEh().syD;
                    AppMethodBeat.o(25684);
                    return true;
                }
            }
            AppMethodBeat.o(25684);
            return false;
        }
    }

    class c extends com.tencent.mm.sdk.b.c<tb> {
        private c() {
            AppMethodBeat.i(25686);
            this.xxI = tb.class.getName().hashCode();
            AppMethodBeat.o(25686);
        }

        /* synthetic */ c(Plugin plugin, byte b) {
            this();
            AppMethodBeat.i(25688);
            this.xxI = tb.class.getName().hashCode();
            AppMethodBeat.o(25688);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(25687);
            if (!(((tb) bVar) instanceof tb)) {
                ab.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", ((tb) bVar).getClass().getName());
            }
            AppMethodBeat.o(25687);
            return false;
        }
    }

    public Plugin() {
        AppMethodBeat.i(25689);
        com.tencent.mm.sdk.b.a.xxA.c(new com.tencent.mm.sdk.b.c<jl>() {
            {
                AppMethodBeat.i(25678);
                this.xxI = jl.class.getName().hashCode();
                AppMethodBeat.o(25678);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(25679);
                switch (((jl) bVar).cEK.status) {
                    case 0:
                        if (com.tencent.mm.plugin.talkroom.model.b.cEh() != null) {
                            com.tencent.mm.plugin.talkroom.model.b.cEh().cEw();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(25679);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(new b());
        com.tencent.mm.sdk.b.a.xxA.c(new a(this, (byte) 0));
        com.tencent.mm.sdk.b.a.xxA.c(new c(this, (byte) 0));
        AppMethodBeat.o(25689);
    }

    public o createApplication() {
        AppMethodBeat.i(25690);
        a aVar = new a();
        AppMethodBeat.o(25690);
        return aVar;
    }

    public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(25691);
        com.tencent.mm.plugin.talkroom.model.b bVar = new com.tencent.mm.plugin.talkroom.model.b();
        AppMethodBeat.o(25691);
        return bVar;
    }
}
