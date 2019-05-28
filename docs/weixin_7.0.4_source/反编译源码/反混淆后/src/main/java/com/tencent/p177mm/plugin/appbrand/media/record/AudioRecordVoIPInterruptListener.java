package com.tencent.p177mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C41994ey;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.voip.C14034e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener */
public final class AudioRecordVoIPInterruptListener implements C45656f {
    private boolean cFy = false;
    private C38445e ilB;
    private CheckInterruptTask ilM;
    private StartInterruptEventListenTask ilN;
    private StopInterruptEventListenTask ilO;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$StopInterruptEventListenTask */
    static class StopInterruptEventListenTask extends MainProcessTask {
        public static final Creator<StopInterruptEventListenTask> CREATOR = new C106231();

        /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$StopInterruptEventListenTask$1 */
        static class C106231 implements Creator<StopInterruptEventListenTask> {
            C106231() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopInterruptEventListenTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132183);
                StopInterruptEventListenTask stopInterruptEventListenTask = new StopInterruptEventListenTask(parcel);
                AppMethodBeat.m2505o(132183);
                return stopInterruptEventListenTask;
            }
        }

        public StopInterruptEventListenTask(Parcel parcel) {
            AppMethodBeat.m2504i(132184);
            mo6032g(parcel);
            AppMethodBeat.m2505o(132184);
        }

        public final void asP() {
            AppMethodBeat.m2504i(132185);
            C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
            C45653a aIs = C45653a.aIs();
            synchronized (C45653a.class) {
                try {
                    Iterator it = aIs.ilQ.iterator();
                    while (it.hasNext()) {
                        C4879a.xxA.mo10053d((C4884c) it.next());
                    }
                    aIs.ilQ.clear();
                } finally {
                    AppMethodBeat.m2505o(132185);
                }
            }
        }

        static {
            AppMethodBeat.m2504i(132186);
            AppMethodBeat.m2505o(132186);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$CheckInterruptTask */
    static class CheckInterruptTask extends MainProcessTask {
        public static final Creator<CheckInterruptTask> CREATOR = new C334481();
        private C38445e ilB;
        private boolean ilx = false;

        /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$CheckInterruptTask$1 */
        static class C334481 implements Creator<CheckInterruptTask> {
            C334481() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckInterruptTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132159);
                CheckInterruptTask checkInterruptTask = new CheckInterruptTask(parcel);
                AppMethodBeat.m2505o(132159);
                return checkInterruptTask;
            }
        }

        public CheckInterruptTask(C38445e c38445e) {
            this.ilB = c38445e;
        }

        public CheckInterruptTask(Parcel parcel) {
            AppMethodBeat.m2504i(132160);
            mo6032g(parcel);
            AppMethodBeat.m2505o(132160);
        }

        public final void asP() {
            boolean z = false;
            AppMethodBeat.m2504i(132161);
            this.ilx = false;
            C4990ab.m7417i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b", Boolean.valueOf(C14034e.cIm()), Boolean.valueOf(C35973a.m59176Oo()));
            if (C14034e.cIm() || r3) {
                z = true;
            }
            this.ilx = z;
            aCb();
            AppMethodBeat.m2505o(132161);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(132162);
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.ilx = z;
            AppMethodBeat.m2505o(132162);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(132163);
            parcel.writeInt(this.ilx ? 1 : 0);
            AppMethodBeat.m2505o(132163);
        }

        static {
            AppMethodBeat.m2504i(132164);
            AppMethodBeat.m2505o(132164);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$StartInterruptEventListenTask */
    static class StartInterruptEventListenTask extends MainProcessTask {
        public static final Creator<StartInterruptEventListenTask> CREATOR = new C334491();
        private C38445e ilB;
        private int ilR = -1;
        private final C4884c ilS = new C334502();
        private final C4884c ilT = new C384433();

        /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$StartInterruptEventListenTask$1 */
        static class C334491 implements Creator<StartInterruptEventListenTask> {
            C334491() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartInterruptEventListenTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(132168);
                StartInterruptEventListenTask startInterruptEventListenTask = new StartInterruptEventListenTask(parcel);
                AppMethodBeat.m2505o(132168);
                return startInterruptEventListenTask;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$StartInterruptEventListenTask$2 */
        class C334502 extends C4884c<C41994ey> {
            C334502() {
                AppMethodBeat.m2504i(132169);
                this.xxI = C41994ey.class.getName().hashCode();
                AppMethodBeat.m2505o(132169);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(132170);
                StartInterruptEventListenTask.m84299a(StartInterruptEventListenTask.this);
                C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "exit multi talk room event");
                AppMethodBeat.m2505o(132170);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$StartInterruptEventListenTask$3 */
        class C384433 extends C4884c<C26250ui> {
            C384433() {
                AppMethodBeat.m2504i(132171);
                this.xxI = C26250ui.class.getName().hashCode();
                AppMethodBeat.m2505o(132171);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(132172);
                C26250ui c26250ui = (C26250ui) c4883b;
                if (c26250ui.cQx.cAd == 11) {
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "stop voIP event");
                    StartInterruptEventListenTask.this.ilR = 11;
                    StartInterruptEventListenTask.m84300b(StartInterruptEventListenTask.this);
                    AppMethodBeat.m2505o(132172);
                    return true;
                } else if (c26250ui.cQx.cAd == 3) {
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "start invite voIP event");
                    StartInterruptEventListenTask.this.ilR = 3;
                    StartInterruptEventListenTask.m84301c(StartInterruptEventListenTask.this);
                    AppMethodBeat.m2505o(132172);
                    return true;
                } else {
                    AppMethodBeat.m2505o(132172);
                    return false;
                }
            }
        }

        /* renamed from: a */
        static /* synthetic */ boolean m84299a(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.m2504i(132179);
            boolean aCb = startInterruptEventListenTask.aCb();
            AppMethodBeat.m2505o(132179);
            return aCb;
        }

        /* renamed from: b */
        static /* synthetic */ boolean m84300b(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.m2504i(132180);
            boolean aCb = startInterruptEventListenTask.aCb();
            AppMethodBeat.m2505o(132180);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m84301c(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.m2504i(132181);
            boolean aCb = startInterruptEventListenTask.aCb();
            AppMethodBeat.m2505o(132181);
            return aCb;
        }

        public StartInterruptEventListenTask(C38445e c38445e) {
            AppMethodBeat.m2504i(132173);
            this.ilB = c38445e;
            AppMethodBeat.m2505o(132173);
        }

        public StartInterruptEventListenTask(Parcel parcel) {
            AppMethodBeat.m2504i(132174);
            mo6032g(parcel);
            AppMethodBeat.m2505o(132174);
        }

        public final void asP() {
            AppMethodBeat.m2504i(132175);
            C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
            if (!C4879a.xxA.mo10054e(this.ilS)) {
                C4879a.xxA.mo10052c(this.ilS);
                C45653a.aIs();
                C45653a.m84303a(this.ilS);
            }
            if (!C4879a.xxA.mo10054e(this.ilT)) {
                C4879a.xxA.mo10052c(this.ilT);
                C45653a.aIs();
                C45653a.m84303a(this.ilT);
            }
            AppMethodBeat.m2505o(132175);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(132176);
            if (this.ilB != null) {
                if (this.ilR == 11) {
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
                    this.ilB.aIi();
                } else if (this.ilR == 3) {
                    C4990ab.m7416i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
                    this.ilB.aIh();
                }
                this.ilR = -1;
            }
            AppMethodBeat.m2505o(132176);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(132177);
            this.ilR = parcel.readInt();
            AppMethodBeat.m2505o(132177);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(132178);
            parcel.writeInt(this.ilR);
            AppMethodBeat.m2505o(132178);
        }

        static {
            AppMethodBeat.m2504i(132182);
            AppMethodBeat.m2505o(132182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener$a */
    static class C45653a {
        private static C45653a ilP;
        LinkedList<C4884c<C4883b>> ilQ = new LinkedList();

        private C45653a() {
            AppMethodBeat.m2504i(132165);
            AppMethodBeat.m2505o(132165);
        }

        public static C45653a aIs() {
            AppMethodBeat.m2504i(132166);
            if (ilP == null) {
                synchronized (C45653a.class) {
                    try {
                        if (ilP == null) {
                            ilP = new C45653a();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(132166);
                        }
                    }
                }
            }
            C45653a c45653a = ilP;
            AppMethodBeat.m2505o(132166);
            return c45653a;
        }

        /* renamed from: a */
        public static void m84303a(C4884c<C4883b> c4884c) {
            AppMethodBeat.m2504i(132167);
            synchronized (C45653a.class) {
                try {
                    C45653a.aIs().ilQ.add(c4884c);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(132167);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo73433a(C38445e c38445e) {
        this.ilB = c38445e;
    }

    public final boolean aIj() {
        AppMethodBeat.m2504i(132187);
        if (this.ilB == null) {
            C4990ab.m7412e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
            AppMethodBeat.m2505o(132187);
            return false;
        }
        if (this.ilM == null) {
            this.ilM = new CheckInterruptTask(this.ilB);
        }
        AppBrandMainProcessService.m54355b(this.ilM);
        C4990ab.m7417i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", Boolean.valueOf(this.ilM.ilx));
        boolean a = this.ilM.ilx;
        AppMethodBeat.m2505o(132187);
        return a;
    }

    public final void aIk() {
        AppMethodBeat.m2504i(132188);
        if (this.ilB == null) {
            C4990ab.m7412e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
            AppMethodBeat.m2505o(132188);
            return;
        }
        if (this.ilN == null) {
            this.ilN = new StartInterruptEventListenTask(this.ilB);
        }
        this.cFy = true;
        AppBrandMainProcessService.m54349a(this.ilN);
        AppMethodBeat.m2505o(132188);
    }

    public final void aIl() {
        AppMethodBeat.m2504i(132189);
        if (this.cFy) {
            this.cFy = false;
            if (this.ilO == null) {
                this.ilO = new StopInterruptEventListenTask();
            }
            AppBrandMainProcessService.m54355b(this.ilO);
            AppMethodBeat.m2505o(132189);
            return;
        }
        C4990ab.m7412e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
        AppMethodBeat.m2505o(132189);
    }
}
