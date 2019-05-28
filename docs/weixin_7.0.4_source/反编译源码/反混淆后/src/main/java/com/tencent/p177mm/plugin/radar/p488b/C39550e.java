package com.tencent.p177mm.plugin.radar.p488b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.plugin.radar.p488b.C43413c.C21556e;
import com.tencent.p177mm.plugin.radar.p489ui.C39561g;
import com.tencent.p177mm.pluginsdk.model.lbs.Location;
import com.tencent.p177mm.protocal.protobuf.boy;
import com.tencent.p177mm.protocal.protobuf.boz;
import com.tencent.p177mm.protocal.protobuf.bpa;
import com.tencent.p177mm.protocal.protobuf.bpb;
import com.tencent.p177mm.protocal.protobuf.bpd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\n\u0018\u0000 d2\u00020\u0001:\u0006cdefghB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\"J\u0010\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010#J\u001a\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010B\u001a\u00020#2\b\b\u0002\u0010D\u001a\u00020\u0016J\u0010\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020\u0010J\u001a\u0010F\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0016H\u0002J\u0006\u0010G\u001a\u00020>J\u0006\u0010H\u001a\u00020>J\u001a\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010K\u001a\u00020>J0\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010Q\u001a\u00020NH\u0002J0\u0010R\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\"2\u0006\u0010Q\u001a\u00020NH\u0002J\u0006\u0010S\u001a\u00020>J*\u0010T\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\b\u0010U\u001a\u0004\u0018\u00010\u00102\u0006\u0010V\u001a\u00020WH\u0016J\u0016\u0010X\u001a\u00020>2\u0006\u0010B\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u0018J\u0016\u0010X\u001a\u00020>2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u0018J\b\u0010Z\u001a\u00020>H\u0002J\b\u0010[\u001a\u00020>H\u0002J\u001a\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020\u00102\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010^\u001a\u00020>2\b\u0010B\u001a\u0004\u0018\u00010#J\u0006\u0010_\u001a\u00020>J\b\u0010`\u001a\u00020>H\u0002J\u0006\u0010a\u001a\u00020>J\u000e\u0010b\u001a\u00020>2\u0006\u0010B\u001a\u00020#J\u0010\u0010b\u001a\u00020>2\u0006\u0010]\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R&\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R&\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u0010\u0010<\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.b.e */
public final class C39550e implements C1202f {
    private static final String TAG = TAG;
    private static final int pBD = 3000;
    private static final int pBE = 5000;
    private static final int pBF = 1;
    public static final C21558b pBG = new C21558b();
    private final Context context;
    private String cxb;
    private boolean eVT;
    public final C42206a ecy = new C39554i(this);
    private final LinkedList<bpb> fLl = new LinkedList();
    public C26443d fwu;
    private final C7564ap pBA = new C7564ap(new C39553h(this), false);
    private final C39552g pBB = new C39552g();
    private final C34765d pBC;
    private Location pBr;
    private C39546b pBs;
    private C39551f pBt = C39551f.Stopped;
    public LinkedList<boz> pBu;
    public Map<String, String> pBv = new LinkedHashMap();
    private Map<String, C21556e> pBw = new LinkedHashMap();
    private Map<String, C21556e> pBx = new LinkedHashMap();
    public Map<Long, C21559c> pBy = new LinkedHashMap();
    public Map<String, C21557a> pBz = new LinkedHashMap();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "", "(Ljava/lang/String;I)V", "Selected", "UnSelected", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$a */
    public enum C21557a {
        Selected,
        UnSelected;

        static {
            AppMethodBeat.m2505o(102904);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$Companion;", "", "()V", "REMOVE_RADAR_POSITION", "", "RadarRemoveDelay", "RadarTimerInterval", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$b */
    public static final class C21558b {
        private C21558b() {
        }

        public /* synthetic */ C21558b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$c */
    public static final class C21559c {
        public final bpb pBK;
        public final C21556e pBL;

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r3.pBL, r4.pBL) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(102910);
            if (this != obj) {
                if (obj instanceof C21559c) {
                    C21559c c21559c = (C21559c) obj;
                    if (C25052j.m39373j(this.pBK, c21559c.pBK)) {
                    }
                }
                AppMethodBeat.m2505o(102910);
                return false;
            }
            AppMethodBeat.m2505o(102910);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.m2504i(102909);
            bpb bpb = this.pBK;
            int hashCode = (bpb != null ? bpb.hashCode() : 0) * 31;
            C21556e c21556e = this.pBL;
            if (c21556e != null) {
                i = c21556e.hashCode();
            }
            hashCode += i;
            AppMethodBeat.m2505o(102909);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(102908);
            String str = "LatestChangeStat(member=" + this.pBK + ", state=" + this.pBL + ")";
            AppMethodBeat.m2505o(102908);
            return str;
        }

        public C21559c(bpb bpb, C21556e c21556e) {
            C25052j.m39376p(bpb, "member");
            C25052j.m39376p(c21556e, "state");
            AppMethodBeat.m2504i(102907);
            this.pBK = bpb;
            this.pBL = c21556e;
            AppMethodBeat.m2505o(102907);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J0\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH&¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$d */
    public interface C34765d {
        /* renamed from: a */
        void mo55374a(int i, int i2, LinkedList<bpb> linkedList);

        /* renamed from: b */
        void mo55375b(int i, int i2, LinkedList<boy> linkedList);

        /* renamed from: ka */
        void mo55376ka(boolean z);
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$e */
    public enum C39549e {
        SEARCHING,
        SEARCH_RETRUN,
        RALATIONCHAIN,
        RALATIONCHAIN_RETRUN,
        CREATING_CHAT;

        static {
            AppMethodBeat.m2505o(102911);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$f */
    enum C39551f {
        Stopped,
        Locating,
        RadarSearching,
        Waiting;

        static {
            AppMethodBeat.m2505o(102914);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$g */
    public static final class C39552g extends C7306ak {
        C39552g() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(102918);
            C25052j.m39376p(message, "msg");
            if (message.what == C39550e.pBF) {
                C1720g.m3540Rg().mo14552d((C1207m) new C39546b());
            }
            AppMethodBeat.m2505o(102918);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTimerExpired"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$h */
    static final class C39553h implements C5015a {
        final /* synthetic */ C39550e pBX;

        C39553h(C39550e c39550e) {
            this.pBX = c39550e;
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(102919);
            if (this.pBX.eVT) {
                C4990ab.m7410d(C39550e.TAG, "cancel radar searching");
                AppMethodBeat.m2505o(102919);
            } else {
                this.pBX.pBt = C39551f.RadarSearching;
                C4990ab.m7411d(C39550e.TAG, "status: %s", this.pBX.pBt);
                Location c = this.pBX.pBr;
                if (c == null) {
                    C4990ab.m7412e(C39550e.TAG, "error! location is null!");
                    AppMethodBeat.m2505o(102919);
                } else if (c.dhR()) {
                    C4990ab.m7412e(C39550e.TAG, "error! location is null!");
                    AppMethodBeat.m2505o(102919);
                } else {
                    C4990ab.m7410d(C39550e.TAG, "do once search");
                    C39550e c39550e = this.pBX;
                    float f = c.fBr;
                    float f2 = c.fBs;
                    int i = c.accuracy;
                    int i2 = c.cGo;
                    String str = c.mac;
                    C25052j.m39375o(str, "it.mac");
                    String str2 = c.cGq;
                    C25052j.m39375o(str2, "it.cellId");
                    c39550e.pBs = new C39546b(1, f, f2, i, i2, str, str2);
                    C1720g.m3540Rg().mo14552d((C1207m) this.pBX.pBs);
                    AppMethodBeat.m2505o(102919);
                }
            }
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\n¢\u0006\u0002\b\f"}, dWq = {"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
    /* renamed from: com.tencent.mm.plugin.radar.b.e$i */
    static final class C39554i implements C42206a {
        final /* synthetic */ C39550e pBX;

        C39554i(C39550e c39550e) {
            this.pBX = c39550e;
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(102920);
            if (this.pBX.eVT) {
                C4990ab.m7410d(C39550e.TAG, "cancel location");
                AppMethodBeat.m2505o(102920);
                return false;
            } else if (this.pBX.pBr != null) {
                AppMethodBeat.m2505o(102920);
                return false;
            } else {
                C39550e c39550e;
                if (z) {
                    c39550e = this.pBX;
                    this.pBX.pBr;
                    C39550e.m67585a(c39550e, true);
                    C18698o.m29222a(TXLiveConstants.PLAY_EVT_PLAY_END, f, f2, (int) d2);
                    C4990ab.m7411d(C39550e.TAG, "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
                    this.pBX.pBr = new Location(f2, f, (int) d2, i, "", "");
                    this.pBX.pBA.mo16773ms(0);
                } else {
                    c39550e = this.pBX;
                    this.pBX.pBr;
                    C39550e.m67585a(c39550e, false);
                    C39550e.m67593f(this.pBX);
                }
                AppMethodBeat.m2505o(102920);
                return false;
            }
        }
    }

    public C39550e(C34765d c34765d, Context context) {
        C25052j.m39376p(c34765d, "delegate");
        C25052j.m39376p(context, "context");
        AppMethodBeat.m2504i(102936);
        this.pBC = c34765d;
        this.context = context;
        AppMethodBeat.m2505o(102936);
    }

    /* renamed from: f */
    public static final /* synthetic */ void m67593f(C39550e c39550e) {
        AppMethodBeat.m2504i(102939);
        c39550e.stop();
        AppMethodBeat.m2505o(102939);
    }

    public final void cdA() {
        AppMethodBeat.m2504i(102921);
        cdB();
        this.eVT = false;
        this.pBr = null;
        this.pBt = C39551f.Stopped;
        this.pBA.stopTimer();
        C4990ab.m7410d(TAG, "start radar");
        if (this.fwu == null) {
            this.fwu = C26443d.agz();
        }
        this.pBt = C39551f.Locating;
        C26443d c26443d = this.fwu;
        if (c26443d != null) {
            c26443d.mo44206b(this.ecy);
        }
        C4990ab.m7411d(TAG, "status: %s", this.pBt);
        AppMethodBeat.m2505o(102921);
    }

    public final void cdB() {
        AppMethodBeat.m2504i(102922);
        switch (C28788f.eQZ[this.pBt.ordinal()]) {
            case 1:
                AppMethodBeat.m2505o(102922);
                return;
            case 2:
                stop();
                break;
            case 3:
                if (this.pBs != null) {
                    stop();
                    C1720g.m3540Rg().mo14547c((C1207m) this.pBs);
                    cdC();
                    break;
                }
                break;
            case 4:
                stop();
                cdC();
                break;
        }
        C4990ab.m7410d(TAG, "stop radar");
        AppMethodBeat.m2505o(102922);
    }

    private final void cdC() {
        AppMethodBeat.m2504i(102923);
        this.pBB.sendEmptyMessageDelayed(pBF, (long) pBE);
        AppMethodBeat.m2505o(102923);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(102924);
        C26443d c26443d = this.fwu;
        if (c26443d != null) {
            c26443d.mo44206b(this.ecy);
            AppMethodBeat.m2505o(102924);
            return;
        }
        AppMethodBeat.m2505o(102924);
    }

    public final void stop() {
        AppMethodBeat.m2504i(102925);
        this.eVT = true;
        this.pBt = C39551f.Stopped;
        this.pBA.stopTimer();
        AppMethodBeat.m2505o(102925);
    }

    /* renamed from: a */
    private final void m67581a(int i, int i2, LinkedList<bpb> linkedList) {
        AppMethodBeat.m2504i(102926);
        this.pBC.mo55374a(i, i2, linkedList);
        AppMethodBeat.m2505o(102926);
    }

    /* renamed from: b */
    private final void m67588b(int i, int i2, LinkedList<boy> linkedList) {
        AppMethodBeat.m2504i(102927);
        this.pBC.mo55375b(i, i2, linkedList);
        AppMethodBeat.m2505o(102927);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        LinkedList linkedList = null;
        AppMethodBeat.m2504i(102928);
        C25052j.m39376p(c1207m, "scene");
        switch (c1207m.getType()) {
            case 425:
                if (this.pBs == c1207m) {
                    if (((C39546b) c1207m).czE == 1) {
                        this.pBt = C39551f.Waiting;
                        if (i == 0 && i2 == 0) {
                            int i3;
                            String str2 = TAG;
                            String str3 = "rader members count: %s ticket: %s";
                            Object[] objArr = new Object[2];
                            C7472b c7472b = ((C39546b) c1207m).ehh;
                            bpd bpd = (bpd) (c7472b != null ? c7472b.acA() : null);
                            if (bpd != null) {
                                i3 = bpd.ehB;
                            } else {
                                i3 = 0;
                            }
                            objArr[0] = Integer.valueOf(i3);
                            objArr[1] = this.cxb;
                            C4990ab.m7411d(str2, str3, objArr);
                            this.pBA.mo16773ms((long) pBD);
                            c7472b = ((C39546b) c1207m).ehh;
                            bpd = (bpd) (c7472b != null ? c7472b.acA() : null);
                            if (bpd != null) {
                                linkedList = bpd.vEh;
                            }
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    bpb bpb = (bpb) it.next();
                                    C20118a ask = C20118a.ask();
                                    C25052j.m39375o(ask, "PinAntispam.instance()");
                                    ask.mo35364Yn().mo56747ia(bpb.jBB, bpb.wlF);
                                }
                            }
                            if (linkedList != null) {
                                this.fLl.clear();
                                this.fLl.addAll(linkedList);
                            }
                            m67581a(i, i2, this.fLl);
                            C4990ab.m7411d(TAG, "status: %s", this.pBt);
                            AppMethodBeat.m2505o(102928);
                            return;
                        }
                        stop();
                        m67581a(i, i2, null);
                        AppMethodBeat.m2505o(102928);
                        return;
                    }
                    m67581a(i, i2, null);
                    AppMethodBeat.m2505o(102928);
                    return;
                }
                break;
            case 602:
                C4990ab.m7410d(TAG, " MMFunc_MMRadarRelationChain ");
                if (i != 0 || i2 != 0) {
                    m67588b(i, i2, null);
                    break;
                }
                C1331a acA = ((C43411a) c1207m).ehh.acA();
                if (acA == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
                    AppMethodBeat.m2505o(102928);
                    throw c44941v;
                }
                bpa bpa = (bpa) acA;
                this.cxb = bpa.wdB;
                if (bpa.ehB > 0) {
                    m67588b(i, i2, bpa.vEh);
                    AppMethodBeat.m2505o(102928);
                    return;
                }
                m67588b(i, i2, null);
                AppMethodBeat.m2505o(102928);
                return;
        }
        AppMethodBeat.m2505o(102928);
    }

    /* renamed from: a */
    public final void mo62506a(String str, C21556e c21556e) {
        AppMethodBeat.m2504i(102929);
        C21556e c21556e2 = (C21556e) this.pBw.get(str);
        if (!(c21556e2 == null || c21556e2 == c21556e)) {
            this.pBx.put(str, c21556e2);
        }
        AppMethodBeat.m2505o(102929);
    }

    /* renamed from: b */
    public final void mo62507b(String str, C21556e c21556e) {
        AppMethodBeat.m2504i(102930);
        C25052j.m39376p(str, "username");
        C25052j.m39376p(c21556e, "state");
        if (!C6163u.m9837ar(str)) {
            mo62506a(str, c21556e);
            this.pBw.put(str, c21556e);
        }
        AppMethodBeat.m2505o(102930);
    }

    /* renamed from: a */
    public final C21556e mo62504a(bpb bpb, boolean z) {
        AppMethodBeat.m2504i(102931);
        C25052j.m39376p(bpb, "member");
        String str = bpb.jBB;
        C25052j.m39375o(str, "member.UserName");
        C21556e bb = m67589bb(str, z);
        if (bb == null) {
            str = bpb.wfK;
            C25052j.m39375o(str, "member.EncodeUserName");
            bb = m67589bb(str, z);
        }
        AppMethodBeat.m2505o(102931);
        return bb;
    }

    /* renamed from: Vy */
    public final C21556e mo62503Vy(String str) {
        AppMethodBeat.m2504i(102933);
        C25052j.m39376p(str, "username");
        C21556e bb = m67589bb(str, false);
        AppMethodBeat.m2505o(102933);
        return bb;
    }

    /* renamed from: bb */
    private final C21556e m67589bb(String str, boolean z) {
        AppMethodBeat.m2504i(102934);
        C21556e c21556e;
        if (z) {
            c21556e = (C21556e) this.pBx.get(str);
            AppMethodBeat.m2505o(102934);
            return c21556e;
        }
        c21556e = (C21556e) this.pBw.get(str);
        AppMethodBeat.m2505o(102934);
        return c21556e;
    }

    /* renamed from: a */
    public final void mo62505a(bpb bpb) {
        AppMethodBeat.m2504i(102935);
        if (bpb != null) {
            C39561g c39561g = C39561g.pDK;
            String b = C39561g.m67618b(bpb);
            if (this.pBz.containsKey(b)) {
                this.pBz.remove(b);
                AppMethodBeat.m2505o(102935);
                return;
            }
            this.pBz.put(b, C21557a.Selected);
        }
        AppMethodBeat.m2505o(102935);
    }

    static {
        AppMethodBeat.m2504i(102937);
        AppMethodBeat.m2505o(102937);
    }
}
