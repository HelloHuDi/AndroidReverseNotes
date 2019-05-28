package com.tencent.p177mm.plugin.music.p460b;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p1181b.C37486c;
import com.tencent.p177mm.audio.mix.p1181b.C45166d;
import com.tencent.p177mm.audio.mix.p197h.C41782a;
import com.tencent.p177mm.audio.mix.p197h.C45174b;
import com.tencent.p177mm.audio.mix.p832f.C32316b;
import com.tencent.p177mm.audio.mix.p832f.C32317c;
import com.tencent.p177mm.audio.mix.p832f.C9056g;
import com.tencent.p177mm.p1176ag.C17874a;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C41729d;
import com.tencent.p177mm.p230g.p231a.C18405u;
import com.tencent.p177mm.plugin.music.p460b.p1281b.C39428a;
import com.tencent.p177mm.plugin.music.p460b.p996a.C28540d;
import com.tencent.p177mm.plugin.music.p463f.p1616c.C43329b;
import com.tencent.p177mm.plugin.music.p463f.p464a.C39436e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.music.b.f */
public final class C28543f {
    private static C28543f oJQ;
    C17874a csM = new C17874a();
    Object lrj = new Object();
    private HashMap<String, String> oJA = new HashMap();
    HashMap<String, LinkedList<String>> oJB = new HashMap();
    HashMap<String, C17875b> oJC = new HashMap();
    private HashMap<String, C41729d> oJD = new HashMap();
    private LinkedList<String> oJE = new LinkedList();
    HashMap<String, Integer> oJF = new HashMap();
    private LinkedList<String> oJG = new LinkedList();
    boolean oJH = false;
    private boolean oJI = false;
    long oJJ = 0;
    private long oJK = 0;
    C28540d oJL;
    private C39428a oJM = new C39428a();
    private HashMap<String, String> oJN = new HashMap();
    HashMap<String, Integer> oJO = new HashMap();
    C32317c oJP;
    private C28541c oJR = new C285441();
    private Runnable oJS = new C285452();
    Runnable oJT = new C35223();
    private C32316b oJU = new C285465();
    private C9056g oJV = new C35236();
    private LinkedList<String> oJu = new LinkedList();
    HashMap<String, C46094h> oJv = new HashMap();
    LinkedList<String> oJw = new LinkedList();
    HashMap<String, C46094h> oJx = new HashMap();
    LinkedList<String> oJy = new LinkedList();
    LinkedList<String> oJz = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.music.b.f$3 */
    class C35223 implements Runnable {
        C35223() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137272);
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
            Iterator it = C28543f.this.oJz.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (C28543f.this.mo46566SA(str) == 0) {
                    C28543f c28543f = C28543f.this;
                    C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", str);
                    LinkedList linkedList = (LinkedList) c28543f.oJB.get(str);
                    if (linkedList == null || linkedList.size() == 0) {
                        C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
                    } else {
                        synchronized (c28543f.lrj) {
                            try {
                                Iterator it2 = linkedList.iterator();
                                while (it2.hasNext()) {
                                    String str2 = (String) it2.next();
                                    if (c28543f.oJP.mo53033dR(str2)) {
                                        c28543f.oJP.mo53037dV(str2);
                                    }
                                    C46094h c46094h = (C46094h) c28543f.oJv.remove(str2);
                                    c28543f.oJw.remove(str2);
                                    if (c46094h != null) {
                                        c28543f.mo46580b(str2, c46094h);
                                        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                                        if (c46094h.fqY) {
                                            C28543f.m45260d(str2, c46094h);
                                        } else {
                                            C28543f.m45258c(str2, c46094h);
                                        }
                                    }
                                }
                                Iterator it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    str = (String) it3.next();
                                    if (c28543f.oJP.mo53033dR(str)) {
                                        c28543f.oJP.mo53037dV(str);
                                    }
                                    C46094h c46094h2 = (C46094h) c28543f.oJx.remove(str);
                                    c28543f.oJy.remove(str);
                                    if (c46094h2 != null) {
                                        c28543f.mo46580b(str, c46094h2);
                                        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                                        if (c46094h2.fqY) {
                                            C28543f.m45260d(str, c46094h2);
                                        } else {
                                            C28543f.m45258c(str, c46094h2);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(137272);
                            }
                        }
                    }
                    i2 = 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i == 0) {
                synchronized (C28543f.this.lrj) {
                    try {
                        C28543f.this.oJH = true;
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(137272);
                        }
                    }
                }
                C28543f.this.oJJ = System.currentTimeMillis();
                C5004al.m7442n(C28543f.this.oJT, 1800000);
            }
            AppMethodBeat.m2505o(137272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.b.f$6 */
    class C35236 implements C9056g {
        C35236() {
        }

        /* renamed from: gD */
        public final void mo8009gD(int i) {
            AppMethodBeat.m2504i(137284);
            if (C28543f.this.oJL != null) {
                C28543f.this.oJL.mo46558zq(i);
            }
            AppMethodBeat.m2505o(137284);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.b.f$a */
    public class C12658a implements Comparator<C17875b> {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C17875b c17875b = (C17875b) obj;
            C17875b c17875b2 = (C17875b) obj2;
            if (c17875b.fqM > c17875b2.fqM) {
                return 1;
            }
            if (c17875b.fqM < c17875b2.fqM) {
                return -1;
            }
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.b.f$1 */
    class C285441 implements C28541c {
        C285441() {
        }

        public final void onStart(String str) {
            AppMethodBeat.m2504i(137266);
            C46094h SB = C28543f.this.mo46567SB(str);
            if (SB == null) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
                AppMethodBeat.m2505o(137266);
                return;
            }
            C28543f.this.mo46588e(str, SB);
            synchronized (C28543f.this.lrj) {
                try {
                    C28543f.this.oJH = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(137266);
                }
            }
            C5004al.m7439af(C28543f.this.oJT);
        }

        /* renamed from: Ss */
        public final void mo46562Ss(String str) {
            AppMethodBeat.m2504i(137267);
            C46094h SB = C28543f.this.mo46567SB(str);
            if (SB == null) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
                AppMethodBeat.m2505o(137267);
                return;
            }
            C28543f.this.mo46580b(str, SB);
            C28543f.this.mo46589f(str, SB);
            C28543f.m45251a(C28543f.this);
            C28543f.this.bSD();
            AppMethodBeat.m2505o(137267);
        }

        /* renamed from: Lu */
        public final void mo46561Lu(String str) {
            AppMethodBeat.m2504i(137268);
            C46094h SB = C28543f.this.mo46567SB(str);
            if (SB == null) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
                AppMethodBeat.m2505o(137268);
                return;
            }
            C28543f.this.mo46580b(str, SB);
            C28543f.this.mo46589f(str, SB);
            C28543f.m45251a(C28543f.this);
            C28543f.this.bSD();
            C28543f.m45252a(C28543f.this, str);
            C28543f.this.mo46572SM(str);
            AppMethodBeat.m2505o(137268);
        }

        /* renamed from: dO */
        public final void mo46563dO(String str) {
            AppMethodBeat.m2504i(137269);
            C46094h SB = C28543f.this.mo46567SB(str);
            if (SB == null) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
                AppMethodBeat.m2505o(137269);
                return;
            }
            C28543f.this.mo46580b(str, SB);
            C28543f.this.mo46589f(str, SB);
            C28543f.m45251a(C28543f.this);
            C28543f.this.bSD();
            C28543f.m45252a(C28543f.this, str);
            C28543f.this.mo46572SM(str);
            AppMethodBeat.m2505o(137269);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(String str) {
            AppMethodBeat.m2504i(137270);
            C46094h SB = C28543f.this.mo46567SB(str);
            if (SB == null) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
                AppMethodBeat.m2505o(137270);
                return;
            }
            int intValue;
            Object obj;
            C28543f.this.mo46580b(str, SB);
            C28543f c28543f = C28543f.this;
            int i = SB.lqz;
            if (c28543f.oJF.containsKey(str)) {
                intValue = ((Integer) c28543f.oJF.get(str)).intValue();
            } else {
                intValue = 0;
            }
            if (intValue > 0) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
                c28543f.oJF.remove(str);
            } else if (66 != i) {
                c28543f.oJF.remove(str);
            } else if (c28543f.mo46571SL(str)) {
                c28543f.oJF.put(str, Integer.valueOf(intValue + 1));
                obj = 1;
                if (obj == null) {
                    C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
                    C28543f.this.bSH();
                    C28543f.this.mo46581b(str, null);
                    AppMethodBeat.m2505o(137270);
                    return;
                }
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
                C28543f.this.mo46589f(str, SB);
                C28543f.m45251a(C28543f.this);
                C28543f.this.bSD();
                AppMethodBeat.m2505o(137270);
                return;
            }
            obj = null;
            if (obj == null) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.b.f$2 */
    class C285452 implements Runnable {
        C285452() {
        }

        public final void run() {
            AppMethodBeat.m2504i(137271);
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
            Iterator it = C28543f.this.oJz.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (C28543f.this.mo46566SA(str) == 0) {
                    C28543f.this.mo46568SC(str);
                }
            }
            AppMethodBeat.m2505o(137271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.b.f$5 */
    class C285465 implements C32316b {
        C285465() {
        }

        /* renamed from: b */
        public final void mo46596b(C18405u c18405u) {
            AppMethodBeat.m2504i(137274);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137274);
        }

        /* renamed from: c */
        public final void mo46597c(C18405u c18405u) {
            AppMethodBeat.m2504i(137275);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137275);
        }

        /* renamed from: d */
        public final void mo46598d(C18405u c18405u) {
            AppMethodBeat.m2504i(137276);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137276);
        }

        /* renamed from: e */
        public final void mo46599e(C18405u c18405u) {
            AppMethodBeat.m2504i(137277);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137277);
        }

        /* renamed from: f */
        public final void mo46600f(C18405u c18405u) {
            AppMethodBeat.m2504i(137278);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137278);
        }

        /* renamed from: g */
        public final void mo46601g(C18405u c18405u) {
            AppMethodBeat.m2504i(137279);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137279);
        }

        /* renamed from: h */
        public final void mo46602h(C18405u c18405u) {
            AppMethodBeat.m2504i(137280);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137280);
        }

        /* renamed from: i */
        public final void mo46603i(C18405u c18405u) {
            AppMethodBeat.m2504i(137281);
            C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            AppMethodBeat.m2505o(137281);
        }

        /* renamed from: j */
        public final void mo46604j(C18405u c18405u) {
            AppMethodBeat.m2504i(137282);
            int i = c18405u.csP.errCode;
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", Integer.valueOf(i));
            if (i == 709 || i == 702 || i == 703 || i == 705 || i == 706) {
                C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
            } else {
                C4879a.xxA.mo10048a((C4883b) c18405u, Looper.getMainLooper());
            }
            if (C28543f.this.oJL != null) {
                C17875b c17875b = (C17875b) C28543f.this.oJC.get(c18405u.csP.ckD);
                if (c17875b == null) {
                    AppMethodBeat.m2505o(137282);
                    return;
                }
                C28543f.this.oJL.mo46559zr(c18405u.csP.errCode);
                if (!C28543f.this.oJP.mo53046ee(c17875b.filePath)) {
                    if (C28543f.this.oJO.containsKey(c17875b.filePath)) {
                        C28543f.this.oJO.put(c17875b.filePath, Integer.valueOf(((Integer) C28543f.this.oJO.get(c17875b.filePath)).intValue() + 1));
                        AppMethodBeat.m2505o(137282);
                        return;
                    }
                    C28543f.this.oJO.put(c17875b.filePath, Integer.valueOf(1));
                }
            }
            AppMethodBeat.m2505o(137282);
        }

        /* renamed from: k */
        public final void mo46605k(C18405u c18405u) {
            AppMethodBeat.m2504i(137283);
            if (C28543f.this.oJL != null) {
                C17875b c17875b = (C17875b) C28543f.this.oJC.get(c18405u.csP.ckD);
                if (c17875b == null) {
                    AppMethodBeat.m2505o(137283);
                    return;
                }
                if (c17875b.fqQ > 1000000) {
                    C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", c17875b.ckD, Long.valueOf(c17875b.fqQ));
                }
                String str = c18405u.csP.clP;
                if (TextUtils.isEmpty(str)) {
                    str = c17875b.clP;
                }
                C28543f.this.oJL.mo46550a(c17875b.ckD, str, System.currentTimeMillis() - c17875b.fqO, c17875b.fqP, c17875b.fqQ, false, c17875b.filePath, (long) C28543f.this.oJP.mo53042ea(c17875b.ckD), c17875b.fileSize, C45166d.m83168Dm().mo73136dy(c17875b.filePath));
                if (C28543f.this.oJO.containsKey(c17875b.filePath)) {
                    C28543f.this.oJO.remove(c17875b.filePath);
                }
            }
            AppMethodBeat.m2505o(137283);
        }
    }

    public static synchronized void bSz() {
        synchronized (C28543f.class) {
            AppMethodBeat.m2504i(137285);
            if (oJQ != null) {
                AppMethodBeat.m2505o(137285);
            } else {
                oJQ = new C28543f();
                AppMethodBeat.m2505o(137285);
            }
        }
    }

    public static C28543f bSA() {
        AppMethodBeat.m2504i(137286);
        if (oJQ == null) {
            oJQ = new C28543f();
        }
        C28543f c28543f = oJQ;
        AppMethodBeat.m2505o(137286);
        return c28543f;
    }

    private C28543f() {
        AppMethodBeat.m2504i(137287);
        bSB();
        this.oJP = new C32317c();
        this.oJP.mo53027a(this.oJU);
        this.oJP.mo53028a(this.oJV);
        AppMethodBeat.m2505o(137287);
    }

    public final void bSB() {
        AppMethodBeat.m2504i(137288);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "_release");
        this.oJu.clear();
        synchronized (this.lrj) {
            try {
                String str;
                Iterator it = this.oJw.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    C28543f.m45258c(str, (C46094h) this.oJv.remove(str));
                }
                this.oJw.clear();
                this.oJv.clear();
                it = this.oJy.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    C28543f.m45258c(str, (C46094h) this.oJx.remove(str));
                }
                this.oJy.clear();
                this.oJx.clear();
            } finally {
                AppMethodBeat.m2505o(137288);
            }
        }
        Iterator it2 = this.oJz.iterator();
        while (it2.hasNext()) {
            LinkedList linkedList = (LinkedList) this.oJB.remove((String) it2.next());
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.oJz.clear();
        this.oJA.clear();
        this.oJB.clear();
        this.oJC.clear();
        this.oJD.clear();
        this.oJF.clear();
        this.oJG.clear();
        C5004al.m7439af(this.oJS);
        C5004al.m7439af(this.oJT);
        this.oJH = false;
        this.oJI = false;
    }

    /* renamed from: a */
    private void m45253a(String str, C17875b c17875b) {
        AppMethodBeat.m2504i(137289);
        if (c17875b == null) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", str);
            AppMethodBeat.m2505o(137289);
            return;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", str);
        this.oJA.put(c17875b.appId, c17875b.processName);
        this.oJC.put(c17875b.ckD, c17875b);
        m45261fj(c17875b.appId, str);
        this.oJF.remove(str);
        AppMethodBeat.m2505o(137289);
    }

    /* renamed from: fj */
    private void m45261fj(String str, String str2) {
        AppMethodBeat.m2504i(137290);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(137290);
            return;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", str, str2);
        if (!this.oJz.contains(str)) {
            this.oJz.add(str);
        }
        if (!this.oJu.contains(str2)) {
            this.oJu.add(str2);
        }
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!linkedList.contains(str2)) {
            linkedList.add(str2);
        }
        this.oJB.put(str, linkedList);
        AppMethodBeat.m2505o(137290);
    }

    /* renamed from: fk */
    public final String mo46590fk(String str, String str2) {
        int i;
        AppMethodBeat.m2504i(137291);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        synchronized (this.lrj) {
            if (linkedList != null) {
                try {
                    if (linkedList.contains(str2) && (this.oJw.contains(str2) || this.oJy.contains(str2))) {
                        i = 1;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(137291);
                    }
                }
            }
            i = 0;
        }
        int SA = mo46566SA(str);
        if (TextUtils.isEmpty(str2)) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            m45256aS(604, str2);
            AppMethodBeat.m2505o(137291);
            return null;
        } else if (SA >= 10) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", Integer.valueOf(SA));
            m45261fj(str, str2);
            AppMethodBeat.m2505o(137291);
            return null;
        } else if (i != 0) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            m45256aS(603, str2);
            AppMethodBeat.m2505o(137291);
            return null;
        } else {
            m45261fj(str, str2);
            m45246SH(str2);
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", str, str2);
            AppMethodBeat.m2505o(137291);
            return str2;
        }
    }

    /* renamed from: g */
    public final boolean mo46591g(C17875b c17875b) {
        AppMethodBeat.m2504i(137292);
        if (c17875b == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
            AppMethodBeat.m2505o(137292);
            return false;
        }
        C17875b c17875b2 = (C17875b) this.oJC.get(c17875b.ckD);
        if (c17875b2 != null) {
            c17875b2.mo33377f(c17875b);
        } else {
            this.oJC.put(c17875b.ckD, c17875b);
            c17875b2 = c17875b;
        }
        C46094h SB = mo46567SB(c17875b.ckD);
        if (SB != null) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
            SB.mo74009b(c17875b2);
        } else {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
        }
        if (C12656b.bSx()) {
            if (this.oJP.mo53033dR(c17875b.ckD)) {
                this.oJP.mo53030c(c17875b);
            } else {
                this.oJP.mo53029b(c17875b);
            }
        }
        AppMethodBeat.m2505o(137292);
        return true;
    }

    /* renamed from: h */
    public final boolean mo46592h(C17875b c17875b) {
        AppMethodBeat.m2504i(137293);
        if (c17875b == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
            m45256aS(605, "");
            AppMethodBeat.m2505o(137293);
            return false;
        } else if (TextUtils.isEmpty(c17875b.ckD)) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
            m45256aS(604, c17875b.ckD);
            AppMethodBeat.m2505o(137293);
            return false;
        } else if (this.oJu.contains(c17875b.ckD)) {
            C46094h SB;
            if (c17875b.fqK) {
                m45263j(c17875b);
            }
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
            String SF = m45244SF(c17875b.ckD);
            C17875b pO = mo46594pO(c17875b.ckD);
            if (mo46566SA(SF) >= 10) {
                C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", Integer.valueOf(mo46566SA(SF)));
                this.oJC.put(c17875b.ckD, c17875b);
                C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", Boolean.valueOf(c17875b.fqK));
                if (c17875b.fqK && m45248SJ(c17875b.ckD)) {
                    bSH();
                } else if (c17875b.fqK) {
                    m45256aS(600, c17875b.ckD);
                    bSL();
                    AppMethodBeat.m2505o(137293);
                    return false;
                } else {
                    C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
                    SB = mo46567SB(c17875b.ckD);
                    if (SB != null) {
                        SB.mo74009b(c17875b);
                        SB.bSR();
                    }
                    AppMethodBeat.m2505o(137293);
                    return true;
                }
            }
            m45246SH(c17875b.ckD);
            bSI();
            this.oJA.put(SF, c17875b.processName);
            this.oJC.put(c17875b.ckD, c17875b);
            if (TextUtils.isEmpty(c17875b.filePath) && this.oJN.containsKey(c17875b.clP)) {
                c17875b.filePath = (String) this.oJN.get(c17875b.clP);
            }
            SB = mo46567SB(c17875b.ckD);
            boolean bSx = C12656b.bSx();
            if (bSx) {
                boolean a = C28543f.m45255a(SB);
                boolean z = (!TextUtils.isEmpty(c17875b.filePath) && this.oJP.mo53046ee(c17875b.filePath)) || (pO != null && c17875b.mo33376e(pO) && !TextUtils.isEmpty(pO.filePath) && this.oJP.mo53046ee(pO.filePath));
                C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a), Boolean.valueOf(z), c17875b.ckD);
                if (a && z) {
                    m45249a(c17875b, pO);
                    AppMethodBeat.m2505o(137293);
                    return true;
                }
            }
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
            m45257b(c17875b, pO);
            if (bSx) {
                m45262i(c17875b);
            }
            AppMethodBeat.m2505o(137293);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
            m45256aS(601, c17875b.ckD);
            AppMethodBeat.m2505o(137293);
            return false;
        }
    }

    /* renamed from: i */
    private void m45262i(C17875b c17875b) {
        AppMethodBeat.m2504i(137294);
        if (this.oJP.mo53033dR(c17875b.ckD)) {
            this.oJP.mo53030c(c17875b);
        } else {
            this.oJP.mo53029b(c17875b);
        }
        if (!TextUtils.isEmpty(c17875b.filePath)) {
            mo46572SM(c17875b.ckD);
        }
        AppMethodBeat.m2505o(137294);
    }

    /* renamed from: a */
    private void m45249a(C17875b c17875b, C17875b c17875b2) {
        AppMethodBeat.m2504i(137295);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
        m45245SG(c17875b.ckD);
        C28543f.m45264k(c17875b);
        if (TextUtils.isEmpty(c17875b.filePath) && c17875b2 != null && c17875b2.mo33376e(c17875b)) {
            c17875b.filePath = c17875b2.filePath;
        }
        if (!c17875b.fqK) {
            if (this.oJP.mo53033dR(c17875b.ckD)) {
                this.oJP.mo53030c(c17875b);
            } else {
                this.oJP.mo53029b(c17875b);
            }
            if (!(c17875b2 == null || c17875b2.mo33376e(c17875b))) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
                if (this.oJP.mo53032dF(c17875b.ckD) || this.oJP.mo53038dW(c17875b.ckD) || this.oJP.mo53039dX(c17875b.ckD) || this.oJP.mo53040dY(c17875b.ckD) || this.oJP.isPaused(c17875b.ckD)) {
                    this.oJP.mo53037dV(c17875b.ckD);
                }
            }
            this.oJP.mo53047i(7, c17875b.ckD);
            AppMethodBeat.m2505o(137295);
        } else if (c17875b2 != null && !c17875b2.mo33376e(c17875b)) {
            m45250a(c17875b, true, false);
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
            if (this.oJP.mo53032dF(c17875b.ckD) || this.oJP.mo53038dW(c17875b.ckD) || this.oJP.mo53039dX(c17875b.ckD) || this.oJP.mo53040dY(c17875b.ckD) || this.oJP.isPaused(c17875b.ckD)) {
                this.oJP.mo53037dV(c17875b.ckD);
            }
            this.oJP.mo53026a(c17875b);
            AppMethodBeat.m2505o(137295);
        } else if (this.oJP.mo53032dF(c17875b.ckD)) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
            AppMethodBeat.m2505o(137295);
        } else if (this.oJP.mo53038dW(c17875b.ckD) && this.oJP.isPaused(c17875b.ckD)) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
            m45250a(c17875b, true, false);
            this.oJP.mo53035dT(c17875b.ckD);
            AppMethodBeat.m2505o(137295);
        } else if (this.oJP.mo53040dY(c17875b.ckD)) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
            m45250a(c17875b, true, false);
            this.oJP.mo53035dT(c17875b.ckD);
            AppMethodBeat.m2505o(137295);
        } else if (this.oJP.mo53039dX(c17875b.ckD)) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
            AppMethodBeat.m2505o(137295);
        } else {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
            m45250a(c17875b, true, false);
            this.oJP.mo53026a(c17875b);
            AppMethodBeat.m2505o(137295);
        }
    }

    /* renamed from: b */
    private void m45257b(C17875b c17875b, C17875b c17875b2) {
        int i = 1;
        AppMethodBeat.m2504i(137296);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
        C46094h SB = mo46567SB(c17875b.ckD);
        if (SB == null) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", c17875b.ckD);
            C46094h bSC = bSC();
            bSC.mo62374a(this.oJR);
            bSC.mo74008SN(c17875b.ckD);
            bSC.mo74009b(c17875b);
            if (c17875b.fqK) {
                m45250a(c17875b, true, true);
                mo46588e(c17875b.ckD, bSC);
                c17875b.fqM = System.currentTimeMillis();
                bSC.mo74020l(c17875b);
                AppMethodBeat.m2505o(137296);
                return;
            }
            mo46589f(c17875b.ckD, bSC);
            bSC.bSR();
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
            AppMethodBeat.m2505o(137296);
            return;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", c17875b.ckD);
        if (c17875b.fqK) {
            mo46588e(c17875b.ckD, SB);
            c17875b.fqM = System.currentTimeMillis();
            SB.mo74009b(c17875b);
            if (c17875b2 != null && !c17875b2.mo33376e(c17875b)) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
                if (SB.aie() || SB.aig() || SB.bTc() || SB.bTd() || SB.isPaused()) {
                    SB.stopPlay();
                }
                m45250a(c17875b, true, true);
                SB.mo74020l(c17875b);
                AppMethodBeat.m2505o(137296);
                return;
            } else if (SB.aie()) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
                AppMethodBeat.m2505o(137296);
                return;
            } else if (SB.aig() && SB.isPaused()) {
                m45250a(c17875b, true, true);
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
                SB.resume();
                AppMethodBeat.m2505o(137296);
                return;
            } else if (SB.bTd()) {
                m45250a(c17875b, true, true);
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
                SB.resume();
                AppMethodBeat.m2505o(137296);
                return;
            } else if (SB.bTc()) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
                AppMethodBeat.m2505o(137296);
                return;
            } else {
                m45250a(c17875b, true, true);
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
                SB.mo74020l(c17875b);
                AppMethodBeat.m2505o(137296);
                return;
            }
        }
        synchronized (this.lrj) {
            try {
                if (!this.oJw.contains(c17875b.ckD)) {
                    i = 0;
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137296);
                }
            }
        }
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
            mo46589f(c17875b.ckD, SB);
        } else {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
        }
        SB.mo74009b(c17875b);
        if (!(c17875b2 == null || c17875b2.mo33376e(c17875b))) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
            if (SB.aie() || SB.aig() || SB.bTc() || SB.bTd() || SB.isPaused()) {
                SB.stopPlay();
            }
        }
        SB.bSR();
        C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
        AppMethodBeat.m2505o(137296);
    }

    /* renamed from: b */
    public final boolean mo46581b(String str, C17875b c17875b) {
        AppMethodBeat.m2504i(137297);
        C17875b c17875b2 = (C17875b) this.oJC.get(str);
        if ((!this.oJu.contains(str) || c17875b2 == null) && c17875b != null) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", str);
            m45253a(str, c17875b);
            if (c17875b2 == null) {
                c17875b2 = c17875b;
            }
        } else if (!this.oJu.contains(str)) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
            m45256aS(601, str);
            AppMethodBeat.m2505o(137297);
            return false;
        } else if (c17875b2 == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
            m45256aS(602, str);
            AppMethodBeat.m2505o(137297);
            return false;
        }
        m45263j(c17875b2);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", str);
        if (mo46566SA(m45244SF(str)) >= 10) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", Integer.valueOf(mo46566SA(m45244SF(str))));
            if (m45248SJ(str)) {
                bSH();
            } else {
                bSL();
                m45256aS(600, str);
                AppMethodBeat.m2505o(137297);
                return false;
            }
        }
        bSI();
        this.oJC.put(str, c17875b2);
        C46094h SB = mo46567SB(str);
        if (C12656b.bSx()) {
            boolean a = C28543f.m45255a(SB);
            boolean z = this.oJP.mo53033dR(str) && this.oJP.mo53045ed(str);
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a), Boolean.valueOf(z), c17875b2.ckD);
            if (a && z) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
                m45245SG(c17875b2.ckD);
                C28543f.m45264k(c17875b2);
                if (this.oJP.mo53032dF(c17875b2.ckD)) {
                    C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
                } else if (this.oJP.mo53039dX(c17875b2.ckD)) {
                    C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
                    c17875b2.fqK = true;
                    SB.mo74009b(c17875b2);
                } else {
                    m45250a(c17875b2, false, false);
                    this.oJP.mo53034dS(str);
                }
                AppMethodBeat.m2505o(137297);
                return true;
            }
        }
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
        if (SB == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
            m45246SH(str);
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", str);
            C46094h bSC = bSC();
            bSC.mo62374a(this.oJR);
            bSC.mo74008SN(str);
            mo46588e(str, bSC);
            c17875b2.fqK = true;
            c17875b2.startTime = 0;
            c17875b2.fqM = System.currentTimeMillis();
            m45250a(c17875b2, false, true);
            bSC.mo74020l(c17875b2);
            AppMethodBeat.m2505o(137297);
            return true;
        }
        mo46588e(str, SB);
        if (SB.aig() && !SB.aie()) {
            m45250a(c17875b2, false, true);
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
            SB.resume();
        } else if (SB.bTd()) {
            m45250a(c17875b2, false, true);
            c17875b2.fqK = true;
            c17875b2.fqM = System.currentTimeMillis();
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
            SB.resume();
            c17875b2.startTime = 0;
            SB.mo74009b(c17875b2);
        } else if (SB.bTc()) {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
            c17875b2.fqK = true;
            c17875b2.fqM = System.currentTimeMillis();
            SB.mo74009b(c17875b2);
        } else if (SB.aig()) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
            AppMethodBeat.m2505o(137297);
            return false;
        } else {
            m45250a(c17875b2, false, true);
            c17875b2.fqK = true;
            c17875b2.fqM = System.currentTimeMillis();
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
            SB.mo74020l(c17875b2);
            c17875b2.startTime = 0;
        }
        AppMethodBeat.m2505o(137297);
        return true;
    }

    /* renamed from: St */
    public final boolean mo46573St(String str) {
        AppMethodBeat.m2504i(137298);
        C46094h SB = mo46567SB(str);
        if (SB == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
            if (this.oJP.mo53033dR(str)) {
                this.oJP.mo53036dU(str);
                AppMethodBeat.m2505o(137298);
                return true;
            }
            AppMethodBeat.m2505o(137298);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", str);
        SB.pause();
        mo46580b(str, SB);
        mo46589f(str, SB);
        AppMethodBeat.m2505o(137298);
        return true;
    }

    /* renamed from: Su */
    public final boolean mo46574Su(String str) {
        AppMethodBeat.m2504i(137299);
        C46094h SB = mo46567SB(str);
        if (SB == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
            if (this.oJP.mo53033dR(str)) {
                this.oJP.mo53037dV(str);
                AppMethodBeat.m2505o(137299);
                return true;
            }
            AppMethodBeat.m2505o(137299);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", str);
        SB.stopPlay();
        C17875b c17875b = (C17875b) this.oJC.get(str);
        if (c17875b != null) {
            c17875b.startTime = 0;
            c17875b.fqK = true;
        }
        mo46580b(str, SB);
        mo46589f(str, SB);
        AppMethodBeat.m2505o(137299);
        return true;
    }

    /* renamed from: Sv */
    public final boolean mo46575Sv(String str) {
        AppMethodBeat.m2504i(137300);
        if (this.oJP.mo53033dR(str)) {
            this.oJP.mo53037dV(str);
        }
        C46094h SB = mo46567SB(str);
        if (SB == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
            AppMethodBeat.m2505o(137300);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", str);
        SB.bTg();
        C17875b c17875b = (C17875b) this.oJC.get(str);
        if (c17875b != null) {
            c17875b.startTime = 0;
            c17875b.fqK = true;
        }
        mo46580b(str, SB);
        mo46589f(str, SB);
        AppMethodBeat.m2505o(137300);
        return true;
    }

    /* renamed from: Sw */
    public final boolean mo46576Sw(String str) {
        AppMethodBeat.m2504i(137301);
        this.oJP.mo53037dV(str);
        this.oJP.remove(str);
        C46094h SB = mo46567SB(str);
        if (SB == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
            AppMethodBeat.m2505o(137301);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", str);
        C28543f.m45258c(str, SB);
        synchronized (this.lrj) {
            try {
                this.oJv.remove(str);
                this.oJw.remove(str);
                this.oJx.remove(str);
                this.oJy.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(137301);
                }
            }
        }
        this.oJu.remove(str);
        Iterator it = this.oJz.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oJB.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                linkedList.remove(str);
                if (linkedList.size() == 0) {
                    this.oJB.remove(str2);
                    this.oJz.remove(str2);
                    this.oJA.remove(str2);
                }
                this.oJC.remove(str);
                this.oJD.remove(str);
                AppMethodBeat.m2505o(137301);
                return true;
            }
        }
        this.oJC.remove(str);
        this.oJD.remove(str);
        AppMethodBeat.m2505o(137301);
        return true;
    }

    /* renamed from: cF */
    public final boolean mo46586cF(String str, int i) {
        AppMethodBeat.m2504i(137302);
        C46094h SB = mo46567SB(str);
        boolean cG;
        if (SB == null) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
            if (this.oJP.mo53033dR(str)) {
                this.oJP.mo53050w(str, i);
            }
            cG = m45259cG(str, i);
            AppMethodBeat.m2505o(137302);
            return cG;
        } else if (i < 0) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(SB.getDuration()));
            AppMethodBeat.m2505o(137302);
            return false;
        } else if (SB.getDuration() <= 0) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(SB.getDuration()));
            SB.bSW();
            cG = m45259cG(str, i);
            AppMethodBeat.m2505o(137302);
            return cG;
        } else if (i <= 0 || i <= SB.getDuration()) {
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", str, Integer.valueOf(i));
            if (SB.aie() || SB.aig() || SB.isPaused()) {
                cG = SB.mo8037lP(i);
                AppMethodBeat.m2505o(137302);
                return cG;
            }
            SB.bSW();
            cG = m45259cG(str, i);
            AppMethodBeat.m2505o(137302);
            return cG;
        } else {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(SB.getDuration()));
            AppMethodBeat.m2505o(137302);
            return false;
        }
    }

    /* renamed from: cG */
    private boolean m45259cG(String str, int i) {
        AppMethodBeat.m2504i(137303);
        C17875b c17875b = (C17875b) this.oJC.get(str);
        if (c17875b != null) {
            c17875b.startTime = i;
            AppMethodBeat.m2505o(137303);
            return true;
        }
        AppMethodBeat.m2505o(137303);
        return false;
    }

    /* renamed from: Sx */
    public final boolean mo46577Sx(String str) {
        AppMethodBeat.m2504i(137304);
        C46094h SB = mo46567SB(str);
        boolean aig;
        if (SB != null) {
            aig = SB.aig();
            AppMethodBeat.m2505o(137304);
            return aig;
        } else if (this.oJP.mo53033dR(str)) {
            aig = this.oJP.mo53038dW(str);
            AppMethodBeat.m2505o(137304);
            return aig;
        } else {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
            AppMethodBeat.m2505o(137304);
            return false;
        }
    }

    /* renamed from: pN */
    public final boolean mo46593pN(String str) {
        AppMethodBeat.m2504i(137305);
        C46094h SB = mo46567SB(str);
        boolean aie;
        if (SB != null) {
            aie = SB.aie();
            AppMethodBeat.m2505o(137305);
            return aie;
        } else if (this.oJP.mo53033dR(str)) {
            aie = this.oJP.mo53032dF(str);
            AppMethodBeat.m2505o(137305);
            return aie;
        } else {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
            AppMethodBeat.m2505o(137305);
            return false;
        }
    }

    /* renamed from: dZ */
    public final boolean mo46587dZ(String str) {
        AppMethodBeat.m2504i(137306);
        C46094h SB = mo46567SB(str);
        boolean isStopped;
        if (SB != null) {
            isStopped = SB.isStopped();
            AppMethodBeat.m2505o(137306);
            return isStopped;
        } else if (this.oJP.mo53033dR(str)) {
            isStopped = this.oJP.mo53041dZ(str);
            AppMethodBeat.m2505o(137306);
            return isStopped;
        } else {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
            AppMethodBeat.m2505o(137306);
            return true;
        }
    }

    /* renamed from: Sy */
    public final boolean mo46578Sy(String str) {
        AppMethodBeat.m2504i(137307);
        C46094h SB = mo46567SB(str);
        boolean z;
        if (SB != null) {
            z = SB.fqY;
            AppMethodBeat.m2505o(137307);
            return z;
        } else if (this.oJP.mo53033dR(str)) {
            z = this.oJP.mo53023Ei();
            AppMethodBeat.m2505o(137307);
            return z;
        } else {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
            C41729d Sz = mo46579Sz(str);
            if (Sz != null) {
                z = Sz.fqY;
                AppMethodBeat.m2505o(137307);
                return z;
            }
            AppMethodBeat.m2505o(137307);
            return false;
        }
    }

    /* renamed from: Sz */
    public final C41729d mo46579Sz(String str) {
        AppMethodBeat.m2504i(137308);
        C46094h SB = mo46567SB(str);
        C41729d bTj;
        if (SB != null) {
            bTj = SB.bTj();
            AppMethodBeat.m2505o(137308);
            return bTj;
        }
        if (this.oJP.mo53033dR(str)) {
            bTj = this.oJP.mo53043eb(str);
            if (bTj != null) {
                AppMethodBeat.m2505o(137308);
                return bTj;
            }
        }
        bTj = (C41729d) this.oJD.get(str);
        AppMethodBeat.m2505o(137308);
        return bTj;
    }

    /* renamed from: SA */
    public final int mo46566SA(String str) {
        int size;
        AppMethodBeat.m2504i(137309);
        int bSE = bSE();
        synchronized (this.lrj) {
            try {
                int size2 = this.oJu.size();
                size = this.oJv.size();
                int size3 = this.oJx.size();
                LinkedList linkedList = (LinkedList) this.oJB.get(str);
                int size4 = linkedList == null ? 0 : linkedList.size();
                C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(size4), Integer.valueOf(bSE));
            } finally {
                AppMethodBeat.m2505o(137309);
            }
        }
        return size;
    }

    /* renamed from: pO */
    public final C17875b mo46594pO(String str) {
        AppMethodBeat.m2504i(137310);
        if (this.oJC.containsKey(str)) {
            C17875b c17875b = (C17875b) this.oJC.get(str);
            AppMethodBeat.m2505o(137310);
            return c17875b;
        }
        AppMethodBeat.m2505o(137310);
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: SB */
    public final C46094h mo46567SB(String str) {
        AppMethodBeat.m2504i(137311);
        C46094h c46094h;
        if (this.oJv.containsKey(str)) {
            c46094h = (C46094h) this.oJv.get(str);
            AppMethodBeat.m2505o(137311);
            return c46094h;
        } else if (this.oJx.containsKey(str)) {
            c46094h = (C46094h) this.oJx.get(str);
            AppMethodBeat.m2505o(137311);
            return c46094h;
        } else {
            AppMethodBeat.m2505o(137311);
            return null;
        }
    }

    /* renamed from: SC */
    public final void mo46568SC(String str) {
        AppMethodBeat.m2504i(137312);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", str);
        this.oJP.mo53022Eh();
        bSK();
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        long Ek = this.oJP.mo53025Ek();
        long Dn = C45166d.m83168Dm().mo73130Dn();
        long Dl = Dn + C37486c.m63255Dk().mo60404Dl();
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", Long.valueOf(Ek), Long.valueOf(Dn), Long.valueOf(C37486c.m63255Dk().mo60404Dl()));
        this.oJL = (C28540d) C43329b.m77295ar(C28540d.class);
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
            AppMethodBeat.m2505o(137312);
        } else if (this.oJv.isEmpty() && this.oJx.isEmpty()) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
            if (this.oJL != null) {
                this.oJL.mo46551b(str, Ek, Dl, Dn);
            }
            AppMethodBeat.m2505o(137312);
        } else {
            LinkedList linkedList2 = new LinkedList();
            synchronized (this.lrj) {
                try {
                    linkedList2.addAll(linkedList);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(137312);
                    }
                }
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                C46094h c46094h = (C46094h) this.oJx.get(str2);
                if (c46094h != null) {
                    m45254a(str2, c46094h);
                }
            }
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", Integer.valueOf(this.oJv.size()));
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                C46094h c46094h2 = (C46094h) this.oJv.get(str3);
                if (c46094h2 != null) {
                    m45254a(str3, c46094h2);
                    mo46589f(str3, c46094h2);
                }
            }
            if (this.oJL != null) {
                this.oJL.mo46551b(str, Ek, Dl, Dn);
            }
            AppMethodBeat.m2505o(137312);
        }
    }

    /* renamed from: SD */
    public final void mo46569SD(String str) {
        AppMethodBeat.m2504i(137313);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", str);
        bSK();
        LinkedList linkedList = (LinkedList) this.oJB.remove(str);
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            AppMethodBeat.m2505o(137313);
            return;
        }
        synchronized (this.lrj) {
            try {
                String str2;
                C46094h c46094h;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    c46094h = (C46094h) this.oJv.remove(str2);
                    this.oJw.remove(str2);
                    C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
                    C28543f.m45258c(str2, c46094h);
                    this.oJC.remove(str2);
                    this.oJD.remove(str2);
                    if (this.oJP.mo53033dR(str2)) {
                        this.oJP.mo53037dV(str2);
                        this.oJP.remove(str2);
                    }
                }
                it = linkedList.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    c46094h = (C46094h) this.oJx.remove(str2);
                    this.oJy.remove(str2);
                    C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                    C28543f.m45258c(str2, c46094h);
                    this.oJC.remove(str2);
                    this.oJD.remove(str2);
                    if (this.oJP.mo53033dR(str2)) {
                        this.oJP.mo53037dV(str2);
                        this.oJP.remove(str2);
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137313);
            }
        }
        this.oJu.removeAll(linkedList);
        this.oJz.remove(str);
        this.oJA.remove(str);
        this.oJP.clearCache();
        this.oJP.mo53024Ej();
        this.oJN.clear();
        this.oJO.clear();
    }

    /* renamed from: SE */
    private void m45243SE(String str) {
        AppMethodBeat.m2504i(137314);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", str);
        LinkedList linkedList = (LinkedList) this.oJB.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            AppMethodBeat.m2505o(137314);
            return;
        }
        synchronized (this.lrj) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (this.oJP.mo53033dR(str2)) {
                        this.oJP.mo53037dV(str2);
                    }
                    C46094h c46094h = (C46094h) this.oJx.remove(str2);
                    this.oJy.remove(str2);
                    if (c46094h != null) {
                        mo46580b(str2, c46094h);
                        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                        if (c46094h.fqY) {
                            C28543f.m45260d(str2, c46094h);
                        } else {
                            C28543f.m45258c(str2, c46094h);
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137314);
            }
        }
    }

    /* renamed from: aS */
    private void m45256aS(int i, String str) {
        AppMethodBeat.m2504i(137315);
        C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", Integer.valueOf(i), str);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
            str = C28542e.bSy();
        }
        C4883b c18405u = new C18405u();
        c18405u.csP.action = 4;
        c18405u.csP.state = "error";
        c18405u.csP.errCode = C39436e.m67373zS(i);
        c18405u.csP.aIm = C39436e.m67372ph(i);
        c18405u.csP.ckD = str;
        c18405u.csP.appId = m45244SF(str);
        C4879a.xxA.mo10048a(c18405u, Looper.getMainLooper());
        AppMethodBeat.m2505o(137315);
    }

    /* JADX WARNING: Missing block: B:25:0x006c, code skipped:
            if (r6 != null) goto L_0x006e;
     */
    /* JADX WARNING: Missing block: B:68:?, code skipped:
            return r5;
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            return r5;
     */
    /* JADX WARNING: Missing block: B:73:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r0);
     */
    /* JADX WARNING: Missing block: B:75:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C46094h bSC() {
        AppMethodBeat.m2504i(137316);
        int i = "createOrReusePlayer";
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", i);
        synchronized (this.lrj) {
            int size;
            try {
                size = this.oJx.size();
                C46094h c46094h;
                if (size == 0) {
                    c46094h = new C46094h();
                } else {
                    c46094h = null;
                    Object obj = "";
                    long j = 0;
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = this.oJy.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        i = (C46094h) this.oJx.get(str);
                        if (i != null) {
                            if (!(i.fqY || i.isCompleted() || i.isStopped())) {
                                Object obj2;
                                if (i.oKc == null) {
                                    obj2 = null;
                                } else if (i.oKc.getPlayerState() == 9) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                            }
                            if (j == 0 || i.eDL < j) {
                                j = i.eDL;
                                obj = str;
                                c46094h = i;
                            }
                            str = obj;
                            i = c46094h;
                            obj = str;
                            c46094h = i;
                        }
                    }
                    if (c46094h == null || currentTimeMillis - j <= 500) {
                        c46094h = new C46094h();
                        AppMethodBeat.m2505o(137316);
                        return c46094h;
                    }
                    C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "player is be reuse to play again with other audio");
                    C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "unmarkPlayer, unmark player by audioId:%s", obj);
                    i = this.lrj;
                    synchronized (i) {
                        if (this.oJy.contains(obj)) {
                            this.oJx.remove(obj);
                            this.oJy.remove(obj);
                        }
                        size = this.oJw.contains(obj);
                        if (size == true) {
                            this.oJw.remove(obj);
                            size = this.oJv;
                            size.remove(obj);
                        }
                    }
                }
            } catch (Throwable th) {
                size = th;
                AppMethodBeat.m2505o(i);
            } finally {
                while (true) {
                }
                i = 137316;
                AppMethodBeat.m2505o(137316);
            }
        }
    }

    /* renamed from: SF */
    private String m45244SF(String str) {
        String str2;
        AppMethodBeat.m2504i(137317);
        Iterator it = this.oJz.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.oJB.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                AppMethodBeat.m2505o(137317);
                return str2;
            }
        }
        str2 = "";
        AppMethodBeat.m2505o(137317);
        return str2;
    }

    /* renamed from: a */
    private void m45254a(String str, C46094h c46094h) {
        AppMethodBeat.m2504i(137318);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", str);
        C17875b c17875b = (C17875b) this.oJC.get(str);
        if (c17875b != null && c46094h.aie() && c46094h.aig()) {
            c17875b.fqK = true;
            c17875b.startTime = c46094h.bTi();
        } else if (c17875b != null && c46094h.aig()) {
            c17875b.fqK = true;
            c17875b.startTime = c46094h.bTi();
        } else if (c17875b != null) {
            c17875b.fqK = true;
            c17875b.startTime = 0;
        }
        mo46580b(str, c46094h);
        C41729d Sz = mo46579Sz(str);
        if (Sz != null && c46094h.aie()) {
            Sz.f17164rw = true;
        }
        if (c46094h.aie() || c46094h.aig() || c46094h.bTc() || c46094h.bTd() || c46094h.isPaused()) {
            c46094h.bTf();
            AppMethodBeat.m2505o(137318);
            return;
        }
        c46094h.bTe();
        AppMethodBeat.m2505o(137318);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo46580b(String str, C46094h c46094h) {
        AppMethodBeat.m2504i(137319);
        this.oJD.put(str, c46094h.bTj());
        AppMethodBeat.m2505o(137319);
    }

    /* renamed from: c */
    static void m45258c(String str, C46094h c46094h) {
        AppMethodBeat.m2504i(137320);
        if (c46094h == null) {
            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", str);
            AppMethodBeat.m2505o(137320);
            return;
        }
        if (c46094h.aie() || c46094h.aig() || c46094h.bTc() || c46094h.bTd() || c46094h.isPaused()) {
            c46094h.stopPlay();
        }
        c46094h.release();
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", str);
        AppMethodBeat.m2505o(137320);
    }

    /* renamed from: d */
    static void m45260d(String str, C46094h c46094h) {
        AppMethodBeat.m2504i(137321);
        C4990ab.m7410d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
        C28543f.m45258c(str, c46094h);
        AppMethodBeat.m2505o(137321);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo46588e(String str, C46094h c46094h) {
        AppMethodBeat.m2504i(137322);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", str);
        synchronized (this.lrj) {
            try {
                if (this.oJy.contains(str)) {
                    this.oJx.remove(str);
                    this.oJy.remove(str);
                }
                if (!this.oJw.contains(str)) {
                    this.oJw.add(str);
                    this.oJv.put(str, c46094h);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137322);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final void mo46589f(String str, C46094h c46094h) {
        AppMethodBeat.m2504i(137323);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", str);
        synchronized (this.lrj) {
            try {
                if (this.oJw.contains(str)) {
                    this.oJv.remove(str);
                    this.oJw.remove(str);
                }
                if (!this.oJy.contains(str)) {
                    this.oJy.add(str);
                    this.oJx.put(str, c46094h);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137323);
            }
        }
    }

    /* renamed from: SG */
    private boolean m45245SG(String str) {
        AppMethodBeat.m2504i(137324);
        C46094h SB = mo46567SB(str);
        if (SB == null) {
            AppMethodBeat.m2505o(137324);
            return false;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", str);
        C28543f.m45258c(str, SB);
        synchronized (this.lrj) {
            try {
                this.oJv.remove(str);
                this.oJw.remove(str);
                this.oJx.remove(str);
                this.oJy.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137324);
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m45255a(C46094h c46094h) {
        AppMethodBeat.m2504i(137325);
        if (c46094h == null) {
            AppMethodBeat.m2505o(137325);
            return true;
        }
        boolean z;
        if (c46094h.aie() || c46094h.isPaused() || c46094h.bTc() || c46094h.bTd() || c46094h.aig()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.m2505o(137325);
            return false;
        }
        AppMethodBeat.m2505o(137325);
        return true;
    }

    public final void bSD() {
        AppMethodBeat.m2504i(137326);
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.oJH || currentTimeMillis - this.oJJ >= 10000) {
            this.oJJ = currentTimeMillis;
            synchronized (this.lrj) {
                try {
                    this.oJH = true;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(137326);
                }
            }
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", Integer.valueOf(1800000));
            C5004al.m7439af(this.oJT);
            C5004al.m7442n(this.oJT, 1800000);
            return;
        }
        AppMethodBeat.m2505o(137326);
    }

    private int bSE() {
        int i;
        AppMethodBeat.m2504i(137327);
        synchronized (this.lrj) {
            try {
                Iterator it = this.oJy.iterator();
                i = 0;
                while (it.hasNext()) {
                    boolean z;
                    int i2;
                    String str = (String) it.next();
                    C46094h SB = mo46567SB(str);
                    if (SB == null) {
                        C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
                        C41729d Sz = mo46579Sz(str);
                        if (Sz != null) {
                            z = Sz.f17164rw;
                        } else {
                            z = false;
                        }
                    } else {
                        z = SB.isPaused();
                    }
                    if (z) {
                        i2 = i + 1;
                    } else {
                        i2 = i;
                    }
                    i = i2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137327);
            }
        }
        return i;
    }

    /* renamed from: SH */
    private void m45246SH(String str) {
        AppMethodBeat.m2504i(137328);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
        int size = this.oJv.size();
        int size2 = this.oJx.size();
        int bSE = bSE();
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(bSE));
        if (size >= 10) {
            bSF();
        } else if (bSE >= 6) {
            bSF();
        } else if (size + bSE >= 8) {
            bSF();
        }
        String SF = m45244SF(str);
        bSE = this.oJv.size();
        size = this.oJx.size();
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(bSE), Integer.valueOf(size));
        Iterator it;
        String str2;
        if (size >= 50) {
            it = this.oJz.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(SF))) {
                    m45247SI(str2);
                }
            }
        } else if (size + bSE >= 50) {
            it = this.oJz.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(SF))) {
                    m45247SI(str2);
                }
            }
        } else {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
        }
        size = this.oJx.size();
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(bSE), Integer.valueOf(size));
        if (size >= 50) {
            bSG();
            AppMethodBeat.m2505o(137328);
        } else if (size + bSE >= 50) {
            bSG();
            AppMethodBeat.m2505o(137328);
        } else {
            C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
            AppMethodBeat.m2505o(137328);
        }
    }

    private void bSF() {
        AppMethodBeat.m2504i(137329);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
        synchronized (this.lrj) {
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.oJy);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    C46094h c46094h = (C46094h) this.oJx.get(str);
                    if (c46094h != null && c46094h.isPaused()) {
                        m45254a(str, c46094h);
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137329);
            }
        }
    }

    private void bSG() {
        AppMethodBeat.m2504i(137330);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
        synchronized (this.lrj) {
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.oJy);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    C46094h c46094h = (C46094h) this.oJx.remove(str);
                    this.oJy.remove(str);
                    if (c46094h != null) {
                        if (c46094h.fqY) {
                            mo46580b(str, c46094h);
                            C28543f.m45260d(str, c46094h);
                        } else if (!c46094h.isPaused()) {
                            mo46580b(str, c46094h);
                            C28543f.m45258c(str, c46094h);
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137330);
            }
        }
    }

    /* renamed from: SI */
    private void m45247SI(String str) {
        AppMethodBeat.m2504i(137331);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
        m45243SE(str);
        AppMethodBeat.m2505o(137331);
    }

    /* JADX WARNING: Missing block: B:29:0x00d9, code skipped:
            r4 = "";
            r6 = com.tencent.p177mm.plugin.music.cache.C39433g.bTA();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", java.lang.Integer.valueOf(r6));
            r10 = r3.iterator();
            r3 = r6;
     */
    /* JADX WARNING: Missing block: B:31:0x00fc, code skipped:
            if (r10.hasNext() == false) goto L_0x0133;
     */
    /* JADX WARNING: Missing block: B:32:0x00fe, code skipped:
            r1 = (java.lang.String) r10.next();
            r2 = ((java.lang.Integer) r7.get(r1)).intValue();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", java.lang.Integer.valueOf(r2), r1);
     */
    /* JADX WARNING: Missing block: B:33:0x0124, code skipped:
            if (r2 < r6) goto L_0x0258;
     */
    /* JADX WARNING: Missing block: B:34:0x0126, code skipped:
            r5 = true;
     */
    /* JADX WARNING: Missing block: B:35:0x0127, code skipped:
            if (r3 >= r2) goto L_0x0255;
     */
    /* JADX WARNING: Missing block: B:36:0x0129, code skipped:
            r4 = r1;
     */
    /* JADX WARNING: Missing block: B:38:0x012e, code skipped:
            if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0131;
     */
    /* JADX WARNING: Missing block: B:39:0x0130, code skipped:
            r4 = r1;
     */
    /* JADX WARNING: Missing block: B:40:0x0131, code skipped:
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:41:0x0133, code skipped:
            if (r5 == false) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:42:0x0135, code skipped:
            r1 = (com.tencent.p177mm.p1176ag.C17875b) r16.oJC.get(r17);
     */
    /* JADX WARNING: Missing block: B:43:0x0141, code skipped:
            if (r1 == null) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:44:0x0143, code skipped:
            if (r4 == null) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:46:0x014b, code skipped:
            if (r4.equalsIgnoreCase(r1.clP) == false) goto L_0x0252;
     */
    /* JADX WARNING: Missing block: B:47:0x014d, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:48:0x0158, code skipped:
            if (r2 == false) goto L_0x0241;
     */
    /* JADX WARNING: Missing block: B:49:0x015a, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
            r1 = (java.util.ArrayList) r8.get(r4);
     */
    /* JADX WARNING: Missing block: B:50:0x0169, code skipped:
            if (r1 == null) goto L_0x020d;
     */
    /* JADX WARNING: Missing block: B:52:0x016f, code skipped:
            if (r1.size() <= 0) goto L_0x020d;
     */
    /* JADX WARNING: Missing block: B:53:0x0171, code skipped:
            r3 = new java.util.LinkedList();
            r4 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:55:0x017e, code skipped:
            if (r4.hasNext() == false) goto L_0x0196;
     */
    /* JADX WARNING: Missing block: B:56:0x0180, code skipped:
            r1 = (com.tencent.p177mm.p1176ag.C17875b) r16.oJC.get((java.lang.String) r4.next());
     */
    /* JADX WARNING: Missing block: B:57:0x0190, code skipped:
            if (r1 == null) goto L_0x017a;
     */
    /* JADX WARNING: Missing block: B:58:0x0192, code skipped:
            r3.add(r1);
     */
    /* JADX WARNING: Missing block: B:59:0x0196, code skipped:
            java.util.Collections.sort(r3, new com.tencent.p177mm.plugin.music.p460b.C28543f.C12658a(r16));
            r4 = new java.util.LinkedList();
            r3 = r3.iterator();
     */
    /* JADX WARNING: Missing block: B:61:0x01ad, code skipped:
            if (r3.hasNext() == false) goto L_0x01bb;
     */
    /* JADX WARNING: Missing block: B:62:0x01af, code skipped:
            r4.add(((com.tencent.p177mm.p1176ag.C17875b) r3.next()).ckD);
     */
    /* JADX WARNING: Missing block: B:63:0x01bb, code skipped:
            r1 = r9 - 10;
     */
    /* JADX WARNING: Missing block: B:64:0x01bd, code skipped:
            if (r1 <= 0) goto L_0x0216;
     */
    /* JADX WARNING: Missing block: B:66:0x01c3, code skipped:
            if (r4.size() <= r1) goto L_0x0216;
     */
    /* JADX WARNING: Missing block: B:67:0x01c5, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", java.lang.Integer.valueOf(r1 + 1));
            r1 = r4.size() - r1;
     */
    /* JADX WARNING: Missing block: B:68:0x01e0, code skipped:
            if (r1 >= 0) goto L_0x01e3;
     */
    /* JADX WARNING: Missing block: B:69:0x01e2, code skipped:
            r1 = 1;
     */
    /* JADX WARNING: Missing block: B:70:0x01e3, code skipped:
            r16.oJE.addAll(r4.subList(r1, r4.size()));
     */
    /* JADX WARNING: Missing block: B:71:0x01f2, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", java.lang.Integer.valueOf(r16.oJE.size()));
     */
    /* JADX WARNING: Missing block: B:72:0x020d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(137332);
     */
    /* JADX WARNING: Missing block: B:73:0x0216, code skipped:
            if (r1 <= 0) goto L_0x022f;
     */
    /* JADX WARNING: Missing block: B:75:0x021c, code skipped:
            if (r4.size() >= r1) goto L_0x022f;
     */
    /* JADX WARNING: Missing block: B:76:0x021e, code skipped:
            r16.oJE.addAll(r4.subList(1, r4.size()));
     */
    /* JADX WARNING: Missing block: B:77:0x022f, code skipped:
            r16.oJE.add(r4.get(r4.size() - 1));
     */
    /* JADX WARNING: Missing block: B:78:0x0241, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
            r16.oJE.clear();
     */
    /* JADX WARNING: Missing block: B:79:0x0252, code skipped:
            r2 = r5;
     */
    /* JADX WARNING: Missing block: B:80:0x0255, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:81:0x0258, code skipped:
            r2 = r3;
     */
    /* JADX WARNING: Missing block: B:98:?, code skipped:
            return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: SJ */
    private boolean m45248SJ(String str) {
        AppMethodBeat.m2504i(137332);
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.lrj) {
            try {
                int size = this.oJv.size();
                if (size < 10) {
                    this.oJE.clear();
                    C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove", Integer.valueOf(size));
                } else {
                    Iterator it = this.oJw.iterator();
                    while (it.hasNext()) {
                        C17875b c17875b = (C17875b) this.oJC.get((String) it.next());
                        if (!(c17875b == null || c17875b.clP == null)) {
                            ArrayList arrayList2;
                            if (hashMap.containsKey(c17875b.clP)) {
                                hashMap.put(c17875b.clP, Integer.valueOf(((Integer) hashMap.get(c17875b.clP)).intValue() + 1));
                                arrayList2 = (ArrayList) hashMap2.get(c17875b.clP);
                                if (!arrayList2.contains(c17875b.ckD)) {
                                    arrayList2.add(c17875b.ckD);
                                }
                                hashMap2.put(c17875b.clP, arrayList2);
                            } else {
                                hashMap.put(c17875b.clP, Integer.valueOf(1));
                                arrayList2 = new ArrayList();
                                arrayList2.add(c17875b.ckD);
                                hashMap2.put(c17875b.clP, arrayList2);
                            }
                            if (!arrayList.contains(c17875b.clP)) {
                                arrayList.add(c17875b.clP);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137332);
            }
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bSH() {
        AppMethodBeat.m2504i(137333);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
        Iterator it = this.oJE.iterator();
        while (it.hasNext()) {
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", (String) it.next());
            mo46574Su(r0);
            bSL();
        }
        it = this.oJG.iterator();
        while (it.hasNext()) {
            C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", (String) it.next());
            mo46574Su(r0);
            bSL();
        }
        this.oJE.clear();
        this.oJG.clear();
        AppMethodBeat.m2505o(137333);
    }

    /* renamed from: SK */
    public final void mo46570SK(String str) {
        AppMethodBeat.m2504i(137334);
        if (this.oJz.size() == 0) {
            AppMethodBeat.m2505o(137334);
            return;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", str);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.oJz);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String str3 = (String) this.oJA.get(str2);
            if (str != null && str.equalsIgnoreCase(str3)) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
                mo46569SD(str2);
            }
        }
        AppMethodBeat.m2505o(137334);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Missing block: B:29:0x00d2, code skipped:
            r0 = (com.tencent.p177mm.p1176ag.C17875b) r13.oJC.get(r14);
            r2 = r5.iterator();
     */
    /* JADX WARNING: Missing block: B:31:0x00e2, code skipped:
            if (r2.hasNext() == false) goto L_0x0108;
     */
    /* JADX WARNING: Missing block: B:32:0x00e4, code skipped:
            r1 = (java.lang.String) r2.next();
     */
    /* JADX WARNING: Missing block: B:33:0x00ea, code skipped:
            if (r0 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:34:0x00ec, code skipped:
            if (r1 == null) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:36:0x00f4, code skipped:
            if (r1.equalsIgnoreCase(r0.clP) == false) goto L_0x00de;
     */
    /* JADX WARNING: Missing block: B:37:0x00f6, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(137335);
     */
    /* JADX WARNING: Missing block: B:38:0x0108, code skipped:
            r3 = "";
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", java.lang.Integer.valueOf(2));
            r2 = 2;
            r5 = r5.iterator();
     */
    /* JADX WARNING: Missing block: B:40:0x0128, code skipped:
            if (r5.hasNext() == false) goto L_0x0160;
     */
    /* JADX WARNING: Missing block: B:41:0x012a, code skipped:
            r0 = (java.lang.String) r5.next();
            r1 = ((java.lang.Integer) r6.get(r0)).intValue();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7411d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", java.lang.Integer.valueOf(r1), r0);
     */
    /* JADX WARNING: Missing block: B:42:0x0151, code skipped:
            if (r1 < 2) goto L_0x01f6;
     */
    /* JADX WARNING: Missing block: B:43:0x0153, code skipped:
            r4 = true;
     */
    /* JADX WARNING: Missing block: B:44:0x0154, code skipped:
            if (r2 >= r1) goto L_0x01f3;
     */
    /* JADX WARNING: Missing block: B:45:0x0156, code skipped:
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:47:0x015b, code skipped:
            if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x015e;
     */
    /* JADX WARNING: Missing block: B:48:0x015d, code skipped:
            r3 = r0;
     */
    /* JADX WARNING: Missing block: B:49:0x015e, code skipped:
            r2 = r1;
     */
    /* JADX WARNING: Missing block: B:50:0x0160, code skipped:
            if (r4 == false) goto L_0x01e9;
     */
    /* JADX WARNING: Missing block: B:51:0x0162, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
            r0 = (java.util.ArrayList) r7.get(r3);
     */
    /* JADX WARNING: Missing block: B:52:0x0171, code skipped:
            if (r0 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Missing block: B:54:0x0177, code skipped:
            if (r0.size() <= 0) goto L_0x01e1;
     */
    /* JADX WARNING: Missing block: B:55:0x0179, code skipped:
            r1 = new java.util.LinkedList();
            r2 = r0.iterator();
     */
    /* JADX WARNING: Missing block: B:57:0x0186, code skipped:
            if (r2.hasNext() == false) goto L_0x019c;
     */
    /* JADX WARNING: Missing block: B:58:0x0188, code skipped:
            r0 = (com.tencent.p177mm.p1176ag.C17875b) r13.oJC.get((java.lang.String) r2.next());
     */
    /* JADX WARNING: Missing block: B:59:0x0196, code skipped:
            if (r0 == null) goto L_0x0182;
     */
    /* JADX WARNING: Missing block: B:60:0x0198, code skipped:
            r1.add(r0);
     */
    /* JADX WARNING: Missing block: B:61:0x019c, code skipped:
            java.util.Collections.sort(r1, new com.tencent.p177mm.plugin.music.p460b.C28543f.C12658a(r13));
            r2 = new java.util.LinkedList();
            r1 = r1.iterator();
     */
    /* JADX WARNING: Missing block: B:63:0x01b1, code skipped:
            if (r1.hasNext() == false) goto L_0x01bf;
     */
    /* JADX WARNING: Missing block: B:64:0x01b3, code skipped:
            r2.add(((com.tencent.p177mm.p1176ag.C17875b) r1.next()).ckD);
     */
    /* JADX WARNING: Missing block: B:65:0x01bf, code skipped:
            r13.oJG.add(r2.getLast());
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", java.lang.Integer.valueOf(r13.oJG.size()));
     */
    /* JADX WARNING: Missing block: B:66:0x01e1, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(137335);
     */
    /* JADX WARNING: Missing block: B:67:0x01e9, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
     */
    /* JADX WARNING: Missing block: B:68:0x01f3, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:69:0x01f6, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:92:?, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:93:?, code skipped:
            return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: SL */
    public final boolean mo46571SL(String str) {
        AppMethodBeat.m2504i(137335);
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "canRemoveAudioPlayerInPlayingListForTry");
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.lrj) {
            try {
                if (this.oJv.size() <= 5) {
                    C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "playerCount:%d is not need to remove for try", Integer.valueOf(this.oJv.size()));
                    z = false;
                } else {
                    Iterator it = this.oJw.iterator();
                    while (it.hasNext()) {
                        C17875b c17875b = (C17875b) this.oJC.get((String) it.next());
                        if (!(c17875b == null || c17875b.clP == null)) {
                            ArrayList arrayList2;
                            if (hashMap.containsKey(c17875b.clP)) {
                                hashMap.put(c17875b.clP, Integer.valueOf(((Integer) hashMap.get(c17875b.clP)).intValue() + 1));
                                arrayList2 = (ArrayList) hashMap2.get(c17875b.clP);
                                if (!arrayList2.contains(c17875b.ckD)) {
                                    arrayList2.add(c17875b.ckD);
                                }
                                hashMap2.put(c17875b.clP, arrayList2);
                            } else {
                                hashMap.put(c17875b.clP, Integer.valueOf(1));
                                arrayList2 = new ArrayList();
                                arrayList2.add(c17875b.ckD);
                                hashMap2.put(c17875b.clP, arrayList2);
                            }
                            if (!arrayList.contains(c17875b.clP)) {
                                arrayList.add(c17875b.clP);
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(137335);
            }
        }
        return z;
    }

    private void bSI() {
        AppMethodBeat.m2504i(137336);
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", Boolean.valueOf(this.csM.fqI), Boolean.valueOf(this.oJM.oKT));
        if (this.csM.fqI || this.oJM.oKT) {
            if (this.csM.fqI && this.oJM.oKT) {
                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
                bSK();
            }
            AppMethodBeat.m2505o(137336);
            return;
        }
        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
        bSJ();
        AppMethodBeat.m2505o(137336);
    }

    private void bSL() {
        AppMethodBeat.m2504i(137339);
        this.oJL = (C28540d) C43329b.m77295ar(C28540d.class);
        if (this.oJL != null) {
            this.oJL.bTm();
        }
        AppMethodBeat.m2505o(137339);
    }

    /* renamed from: j */
    private void m45263j(C17875b c17875b) {
        AppMethodBeat.m2504i(137340);
        this.oJL = (C28540d) C43329b.m77295ar(C28540d.class);
        if (this.oJL != null) {
            this.oJL.mo46554fl(c17875b.ckD, c17875b.clP);
        }
        AppMethodBeat.m2505o(137340);
    }

    /* renamed from: a */
    private void m45250a(C17875b c17875b, boolean z, boolean z2) {
        long j;
        AppMethodBeat.m2504i(137341);
        this.oJL = (C28540d) C43329b.m77295ar(C28540d.class);
        if (this.oJL != null) {
            this.oJL.mo46555r(c17875b.ckD, c17875b.clP, z2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        c17875b.fqO = currentTimeMillis;
        if (z) {
            j = c17875b.fqS;
            c17875b.fqP = c17875b.fqR;
        } else {
            j = c17875b.fqU;
            c17875b.fqP = c17875b.fqT;
        }
        if (j <= 0 || currentTimeMillis <= j) {
            c17875b.fqQ = 0;
            AppMethodBeat.m2505o(137341);
            return;
        }
        c17875b.fqQ = currentTimeMillis - j;
        AppMethodBeat.m2505o(137341);
    }

    /* renamed from: k */
    private static void m45264k(C17875b c17875b) {
        AppMethodBeat.m2504i(137343);
        if (c17875b.fqV != null) {
            try {
                c17875b.fqV.close();
                c17875b.fqV = null;
                AppMethodBeat.m2505o(137343);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", e, "closeAudioDataSource", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(137343);
    }

    private void bSJ() {
        AppMethodBeat.m2504i(137337);
        if (this.oJM.oKT) {
            AppMethodBeat.m2505o(137337);
            return;
        }
        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", Boolean.valueOf(this.oJM.requestFocus()));
        AppMethodBeat.m2505o(137337);
    }

    /* Access modifiers changed, original: final */
    public final void bSK() {
        AppMethodBeat.m2504i(137338);
        if (this.oJM.oKT) {
            this.oJM.bSK();
        }
        AppMethodBeat.m2505o(137338);
    }

    /* renamed from: SM */
    public final void mo46572SM(final String str) {
        AppMethodBeat.m2504i(137342);
        if (C12656b.bSx()) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(137273);
                    C17875b c17875b = (C17875b) C28543f.this.oJC.get(str);
                    if (c17875b == null) {
                        C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null");
                    }
                    if (!TextUtils.isEmpty(c17875b.filePath) && !C28543f.this.oJP.mo53046ee(c17875b.filePath)) {
                        Object obj;
                        long ek = C41782a.m73756ek(c17875b.filePath);
                        C4990ab.m7417i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d", c17875b.filePath, Long.valueOf(ek));
                        long Dn = C45166d.m83168Dm().mo73130Dn();
                        C32317c c32317c = C28543f.this.oJP;
                        C45174b.m83210i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", Long.valueOf(C45166d.m83168Dm().mo73130Dn()), c32317c.appId);
                        if (C45166d.m83168Dm().mo73130Dn() >= 50000000) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            C45174b.m83208e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", c32317c.appId);
                        }
                        int i = 0;
                        if (C28543f.this.oJO.containsKey(c17875b.filePath)) {
                            i = ((Integer) C28543f.this.oJO.get(c17875b.filePath)).intValue();
                        }
                        if (obj != null) {
                            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
                            if (C28543f.this.oJL != null) {
                                C28543f.this.oJL.mo46560zs(713);
                            }
                            C28543f.this.oJP.mo53044ec("");
                        } else if (Dn + ek > 50000000) {
                            C4990ab.m7413e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", Long.valueOf(Dn), Long.valueOf(ek));
                            if (C28543f.this.oJL != null) {
                                C28543f.this.oJL.mo46560zs(714);
                            }
                            C28543f.this.oJP.mo53044ec("");
                        } else if (i >= 30) {
                            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
                        } else if (C41782a.m73755ej(c17875b.filePath)) {
                            C32317c c32317c2 = C28543f.this.oJP;
                            if (c32317c2.cnp.mo60409dB(c17875b.filePath)) {
                                C4990ab.m7416i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
                            } else {
                                c17875b.fqX = true;
                                c17875b.fileSize = ek;
                                C28543f.this.oJP.mo53026a(c17875b);
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
                        }
                    } else if (TextUtils.isEmpty(c17875b.filePath)) {
                        c17875b.fqX = false;
                    } else {
                        c17875b.fqX = false;
                        if (!C28543f.this.oJP.mo53033dR(str)) {
                            C28543f.this.oJP.mo53029b(c17875b);
                        }
                        c17875b.fileSize = C41782a.m73756ek(c17875b.filePath);
                    }
                    AppMethodBeat.m2505o(137273);
                    return false;
                }
            });
            AppMethodBeat.m2505o(137342);
            return;
        }
        AppMethodBeat.m2505o(137342);
    }
}
