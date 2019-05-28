package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.voip.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener implements f {
    private boolean cFy = false;
    private e ilB;
    private CheckInterruptTask ilM;
    private StartInterruptEventListenTask ilN;
    private StopInterruptEventListenTask ilO;

    static class StopInterruptEventListenTask extends MainProcessTask {
        public static final Creator<StopInterruptEventListenTask> CREATOR = new Creator<StopInterruptEventListenTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopInterruptEventListenTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132183);
                StopInterruptEventListenTask stopInterruptEventListenTask = new StopInterruptEventListenTask(parcel);
                AppMethodBeat.o(132183);
                return stopInterruptEventListenTask;
            }
        };

        public StopInterruptEventListenTask(Parcel parcel) {
            AppMethodBeat.i(132184);
            g(parcel);
            AppMethodBeat.o(132184);
        }

        public final void asP() {
            AppMethodBeat.i(132185);
            ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
            a aIs = a.aIs();
            synchronized (a.class) {
                try {
                    Iterator it = aIs.ilQ.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.sdk.b.a.xxA.d((c) it.next());
                    }
                    aIs.ilQ.clear();
                } finally {
                    AppMethodBeat.o(132185);
                }
            }
        }

        static {
            AppMethodBeat.i(132186);
            AppMethodBeat.o(132186);
        }
    }

    static class CheckInterruptTask extends MainProcessTask {
        public static final Creator<CheckInterruptTask> CREATOR = new Creator<CheckInterruptTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckInterruptTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132159);
                CheckInterruptTask checkInterruptTask = new CheckInterruptTask(parcel);
                AppMethodBeat.o(132159);
                return checkInterruptTask;
            }
        };
        private e ilB;
        private boolean ilx = false;

        public CheckInterruptTask(e eVar) {
            this.ilB = eVar;
        }

        public CheckInterruptTask(Parcel parcel) {
            AppMethodBeat.i(132160);
            g(parcel);
            AppMethodBeat.o(132160);
        }

        public final void asP() {
            boolean z = false;
            AppMethodBeat.i(132161);
            this.ilx = false;
            ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b", Boolean.valueOf(e.cIm()), Boolean.valueOf(com.tencent.mm.r.a.Oo()));
            if (e.cIm() || r3) {
                z = true;
            }
            this.ilx = z;
            aCb();
            AppMethodBeat.o(132161);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(132162);
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.ilx = z;
            AppMethodBeat.o(132162);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(132163);
            parcel.writeInt(this.ilx ? 1 : 0);
            AppMethodBeat.o(132163);
        }

        static {
            AppMethodBeat.i(132164);
            AppMethodBeat.o(132164);
        }
    }

    static class StartInterruptEventListenTask extends MainProcessTask {
        public static final Creator<StartInterruptEventListenTask> CREATOR = new Creator<StartInterruptEventListenTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartInterruptEventListenTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(132168);
                StartInterruptEventListenTask startInterruptEventListenTask = new StartInterruptEventListenTask(parcel);
                AppMethodBeat.o(132168);
                return startInterruptEventListenTask;
            }
        };
        private e ilB;
        private int ilR = -1;
        private final c ilS = new c<ey>() {
            {
                AppMethodBeat.i(132169);
                this.xxI = ey.class.getName().hashCode();
                AppMethodBeat.o(132169);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(132170);
                StartInterruptEventListenTask.a(StartInterruptEventListenTask.this);
                ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "exit multi talk room event");
                AppMethodBeat.o(132170);
                return false;
            }
        };
        private final c ilT = new c<ui>() {
            {
                AppMethodBeat.i(132171);
                this.xxI = ui.class.getName().hashCode();
                AppMethodBeat.o(132171);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(132172);
                ui uiVar = (ui) bVar;
                if (uiVar.cQx.cAd == 11) {
                    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "stop voIP event");
                    StartInterruptEventListenTask.this.ilR = 11;
                    StartInterruptEventListenTask.b(StartInterruptEventListenTask.this);
                    AppMethodBeat.o(132172);
                    return true;
                } else if (uiVar.cQx.cAd == 3) {
                    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "start invite voIP event");
                    StartInterruptEventListenTask.this.ilR = 3;
                    StartInterruptEventListenTask.c(StartInterruptEventListenTask.this);
                    AppMethodBeat.o(132172);
                    return true;
                } else {
                    AppMethodBeat.o(132172);
                    return false;
                }
            }
        };

        static /* synthetic */ boolean a(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.i(132179);
            boolean aCb = startInterruptEventListenTask.aCb();
            AppMethodBeat.o(132179);
            return aCb;
        }

        static /* synthetic */ boolean b(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.i(132180);
            boolean aCb = startInterruptEventListenTask.aCb();
            AppMethodBeat.o(132180);
            return aCb;
        }

        static /* synthetic */ boolean c(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.i(132181);
            boolean aCb = startInterruptEventListenTask.aCb();
            AppMethodBeat.o(132181);
            return aCb;
        }

        public StartInterruptEventListenTask(e eVar) {
            AppMethodBeat.i(132173);
            this.ilB = eVar;
            AppMethodBeat.o(132173);
        }

        public StartInterruptEventListenTask(Parcel parcel) {
            AppMethodBeat.i(132174);
            g(parcel);
            AppMethodBeat.o(132174);
        }

        public final void asP() {
            AppMethodBeat.i(132175);
            ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
            if (!com.tencent.mm.sdk.b.a.xxA.e(this.ilS)) {
                com.tencent.mm.sdk.b.a.xxA.c(this.ilS);
                a.aIs();
                a.a(this.ilS);
            }
            if (!com.tencent.mm.sdk.b.a.xxA.e(this.ilT)) {
                com.tencent.mm.sdk.b.a.xxA.c(this.ilT);
                a.aIs();
                a.a(this.ilT);
            }
            AppMethodBeat.o(132175);
        }

        public final void asQ() {
            AppMethodBeat.i(132176);
            if (this.ilB != null) {
                if (this.ilR == 11) {
                    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
                    this.ilB.aIi();
                } else if (this.ilR == 3) {
                    ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
                    this.ilB.aIh();
                }
                this.ilR = -1;
            }
            AppMethodBeat.o(132176);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(132177);
            this.ilR = parcel.readInt();
            AppMethodBeat.o(132177);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(132178);
            parcel.writeInt(this.ilR);
            AppMethodBeat.o(132178);
        }

        static {
            AppMethodBeat.i(132182);
            AppMethodBeat.o(132182);
        }
    }

    static class a {
        private static a ilP;
        LinkedList<c<b>> ilQ = new LinkedList();

        private a() {
            AppMethodBeat.i(132165);
            AppMethodBeat.o(132165);
        }

        public static a aIs() {
            AppMethodBeat.i(132166);
            if (ilP == null) {
                synchronized (a.class) {
                    try {
                        if (ilP == null) {
                            ilP = new a();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(132166);
                        }
                    }
                }
            }
            a aVar = ilP;
            AppMethodBeat.o(132166);
            return aVar;
        }

        public static void a(c<b> cVar) {
            AppMethodBeat.i(132167);
            synchronized (a.class) {
                try {
                    aIs().ilQ.add(cVar);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(132167);
                }
            }
        }
    }

    public final void a(e eVar) {
        this.ilB = eVar;
    }

    public final boolean aIj() {
        AppMethodBeat.i(132187);
        if (this.ilB == null) {
            ab.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
            AppMethodBeat.o(132187);
            return false;
        }
        if (this.ilM == null) {
            this.ilM = new CheckInterruptTask(this.ilB);
        }
        AppBrandMainProcessService.b(this.ilM);
        ab.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", Boolean.valueOf(this.ilM.ilx));
        boolean a = this.ilM.ilx;
        AppMethodBeat.o(132187);
        return a;
    }

    public final void aIk() {
        AppMethodBeat.i(132188);
        if (this.ilB == null) {
            ab.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
            AppMethodBeat.o(132188);
            return;
        }
        if (this.ilN == null) {
            this.ilN = new StartInterruptEventListenTask(this.ilB);
        }
        this.cFy = true;
        AppBrandMainProcessService.a(this.ilN);
        AppMethodBeat.o(132188);
    }

    public final void aIl() {
        AppMethodBeat.i(132189);
        if (this.cFy) {
            this.cFy = false;
            if (this.ilO == null) {
                this.ilO = new StopInterruptEventListenTask();
            }
            AppBrandMainProcessService.b(this.ilO);
            AppMethodBeat.o(132189);
            return;
        }
        ab.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
        AppMethodBeat.o(132189);
    }
}
