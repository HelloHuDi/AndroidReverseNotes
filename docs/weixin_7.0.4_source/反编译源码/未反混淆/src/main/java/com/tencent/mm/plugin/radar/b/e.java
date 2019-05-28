package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.k.u;
import a.l;
import a.v;
import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0001\n\u0018\u0000 d2\u00020\u0001:\u0006cdefghB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\"J\u0010\u0010A\u001a\u00020/2\b\u0010B\u001a\u0004\u0018\u00010#J\u001a\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010B\u001a\u00020#2\b\b\u0002\u0010D\u001a\u00020\u0016J\u0010\u0010C\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020\u0010J\u001a\u0010F\u001a\u0004\u0018\u00010\u00182\u0006\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0016H\u0002J\u0006\u0010G\u001a\u00020>J\u0006\u0010H\u001a\u00020>J\u001a\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010K\u001a\u00020>J0\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u0006\u0010Q\u001a\u00020NH\u0002J0\u0010R\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\"2\u0006\u0010Q\u001a\u00020NH\u0002J\u0006\u0010S\u001a\u00020>J*\u0010T\u001a\u00020>2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\b\u0010U\u001a\u0004\u0018\u00010\u00102\u0006\u0010V\u001a\u00020WH\u0016J\u0016\u0010X\u001a\u00020>2\u0006\u0010B\u001a\u00020#2\u0006\u0010Y\u001a\u00020\u0018J\u0016\u0010X\u001a\u00020>2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u0018J\b\u0010Z\u001a\u00020>H\u0002J\b\u0010[\u001a\u00020>H\u0002J\u001a\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020\u00102\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010^\u001a\u00020>2\b\u0010B\u001a\u0004\u0018\u00010#J\u0006\u0010_\u001a\u00020>J\b\u0010`\u001a\u00020>H\u0002J\u0006\u0010a\u001a\u00020>J\u000e\u0010b\u001a\u00020>2\u0006\u0010B\u001a\u00020#J\u0010\u0010b\u001a\u00020>2\u0006\u0010]\u001a\u00020\u0010H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R&\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00180\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R&\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0012\"\u0004\b;\u0010\u0014R\u0010\u0010<\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006i"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "delegate", "Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "delayRadarRemove", "com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1;", "delayRadarSearch", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "encodeUserNameMap", "", "", "getEncodeUserNameMap", "()Ljava/util/Map;", "setEncodeUserNameMap", "(Ljava/util/Map;)V", "isCancel", "", "lastStateTable", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "getLastStateTable", "setLastStateTable", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "locationGeo", "Lcom/tencent/mm/modelgeo/LocationGeo;", "mOnLocationGet", "Lcom/tencent/mm/modelgeo/IGetLocation$IOnLocationGet;", "members", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "radarMemberList", "Lcom/tencent/mm/protocal/protobuf/RadarMember;", "getRadarMemberList", "()Ljava/util/LinkedList;", "setRadarMemberList", "(Ljava/util/LinkedList;)V", "sceneRadarRelationChain", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarRelationChain;", "sceneRadarSearch", "Lcom/tencent/mm/plugin/radar/model/NetSceneRadarSearch;", "selectedStatusMap", "Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "getSelectedStatusMap", "setSelectedStatusMap", "stateTable", "getStateTable", "setStateTable", "status", "Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "tempLatestChangeStatTable", "", "Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "getTempLatestChangeStatTable", "setTempLatestChangeStatTable", "ticket", "doRadarRelationChain", "", "memList", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "getChooseStatus", "member", "getState", "old", "username", "getStateImpl", "onCreate", "onDestroy", "onLocationGot", "isOk", "onPause", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "count", "onRadarRelationChainReturn", "onResume", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "putState", "state", "radarRemove", "reset", "saveLastState", "name", "setChooseStatus", "startRadarSearch", "stop", "stopRadarSearch", "syncStateToLastState", "ChooseStatus", "Companion", "LatestChangeStat", "RadarDelegate", "RadarStatus", "Status", "plugin-radar_release"})
public final class e implements com.tencent.mm.ai.f {
    private static final String TAG = TAG;
    private static final int pBD = 3000;
    private static final int pBE = 5000;
    private static final int pBF = 1;
    public static final b pBG = new b();
    private final Context context;
    private String cxb;
    private boolean eVT;
    public final com.tencent.mm.modelgeo.b.a ecy = new i(this);
    private final LinkedList<bpb> fLl = new LinkedList();
    public com.tencent.mm.modelgeo.d fwu;
    private final ap pBA = new ap(new h(this), false);
    private final g pBB = new g();
    private final d pBC;
    private Location pBr;
    private b pBs;
    private f pBt = f.Stopped;
    public LinkedList<boz> pBu;
    public Map<String, String> pBv = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> pBw = new LinkedHashMap();
    private Map<String, com.tencent.mm.plugin.radar.b.c.e> pBx = new LinkedHashMap();
    public Map<Long, c> pBy = new LinkedHashMap();
    public Map<String, a> pBz = new LinkedHashMap();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$ChooseStatus;", "", "(Ljava/lang/String;I)V", "Selected", "UnSelected", "plugin-radar_release"})
    public enum a {
        Selected,
        UnSelected;

        static {
            AppMethodBeat.o(102904);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$Companion;", "", "()V", "REMOVE_RADAR_POSITION", "", "RadarRemoveDelay", "RadarTimerInterval", "TAG", "", "plugin-radar_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
    public static final class c {
        public final bpb pBK;
        public final com.tencent.mm.plugin.radar.b.c.e pBL;

        /* JADX WARNING: Missing block: B:7:0x0020, code skipped:
            if (a.f.b.j.j(r3.pBL, r4.pBL) != false) goto L_0x0022;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(102910);
            if (this != obj) {
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    if (j.j(this.pBK, cVar.pBK)) {
                    }
                }
                AppMethodBeat.o(102910);
                return false;
            }
            AppMethodBeat.o(102910);
            return true;
        }

        public final int hashCode() {
            int i = 0;
            AppMethodBeat.i(102909);
            bpb bpb = this.pBK;
            int hashCode = (bpb != null ? bpb.hashCode() : 0) * 31;
            com.tencent.mm.plugin.radar.b.c.e eVar = this.pBL;
            if (eVar != null) {
                i = eVar.hashCode();
            }
            hashCode += i;
            AppMethodBeat.o(102909);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(102908);
            String str = "LatestChangeStat(member=" + this.pBK + ", state=" + this.pBL + ")";
            AppMethodBeat.o(102908);
            return str;
        }

        public c(bpb bpb, com.tencent.mm.plugin.radar.b.c.e eVar) {
            j.p(bpb, "member");
            j.p(eVar, "state");
            AppMethodBeat.i(102907);
            this.pBK = bpb;
            this.pBL = eVar;
            AppMethodBeat.o(102907);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J0\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\nH&¨\u0006\u0013"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarDelegate;", "", "onLocationGot", "", "isOk", "", "location", "Lcom/tencent/mm/pluginsdk/model/lbs/Location;", "onRadarMemberReturn", "errType", "", "errCode", "radarMembers", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "count", "onRadarRelationChainReturn", "redarChatMember", "Lcom/tencent/mm/protocal/protobuf/RadarChatRoomMember;", "plugin-radar_release"})
    public interface d {
        void a(int i, int i2, LinkedList<bpb> linkedList);

        void b(int i, int i2, LinkedList<boy> linkedList);

        void ka(boolean z);
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$RadarStatus;", "", "(Ljava/lang/String;I)V", "SEARCHING", "SEARCH_RETRUN", "RALATIONCHAIN", "RALATIONCHAIN_RETRUN", "CREATING_CHAT", "plugin-radar_release"})
    public enum e {
        SEARCHING,
        SEARCH_RETRUN,
        RALATIONCHAIN,
        RALATIONCHAIN_RETRUN,
        CREATING_CHAT;

        static {
            AppMethodBeat.o(102911);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/radar/model/RadarManager$Status;", "", "(Ljava/lang/String;I)V", "Stopped", "Locating", "RadarSearching", "Waiting", "plugin-radar_release"})
    enum f {
        Stopped,
        Locating,
        RadarSearching,
        Waiting;

        static {
            AppMethodBeat.o(102914);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/radar/model/RadarManager$delayRadarRemove$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
    public static final class g extends ak {
        g() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(102918);
            j.p(message, "msg");
            if (message.what == e.pBF) {
                com.tencent.mm.kernel.g.Rg().d((m) new b());
            }
            AppMethodBeat.o(102918);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTimerExpired"})
    static final class h implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ e pBX;

        h(e eVar) {
            this.pBX = eVar;
        }

        public final boolean BI() {
            AppMethodBeat.i(102919);
            if (this.pBX.eVT) {
                ab.d(e.TAG, "cancel radar searching");
                AppMethodBeat.o(102919);
            } else {
                this.pBX.pBt = f.RadarSearching;
                ab.d(e.TAG, "status: %s", this.pBX.pBt);
                Location c = this.pBX.pBr;
                if (c == null) {
                    ab.e(e.TAG, "error! location is null!");
                    AppMethodBeat.o(102919);
                } else if (c.dhR()) {
                    ab.e(e.TAG, "error! location is null!");
                    AppMethodBeat.o(102919);
                } else {
                    ab.d(e.TAG, "do once search");
                    e eVar = this.pBX;
                    float f = c.fBr;
                    float f2 = c.fBs;
                    int i = c.accuracy;
                    int i2 = c.cGo;
                    String str = c.mac;
                    j.o(str, "it.mac");
                    String str2 = c.cGq;
                    j.o(str2, "it.cellId");
                    eVar.pBs = new b(1, f, f2, i, i2, str, str2);
                    com.tencent.mm.kernel.g.Rg().d((m) this.pBX.pBs);
                    AppMethodBeat.o(102919);
                }
            }
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\n¢\u0006\u0002\b\f"}, dWq = {"<anonymous>", "", "isOk", "fLongitude", "", "fLatitude", "locType", "", "<anonymous parameter 4>", "", "maccuracy", "<anonymous parameter 6>", "onGetLocation"})
    static final class i implements com.tencent.mm.modelgeo.b.a {
        final /* synthetic */ e pBX;

        i(e eVar) {
            this.pBX = eVar;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(102920);
            if (this.pBX.eVT) {
                ab.d(e.TAG, "cancel location");
                AppMethodBeat.o(102920);
                return false;
            } else if (this.pBX.pBr != null) {
                AppMethodBeat.o(102920);
                return false;
            } else {
                e eVar;
                if (z) {
                    eVar = this.pBX;
                    this.pBX.pBr;
                    e.a(eVar, true);
                    o.a(TXLiveConstants.PLAY_EVT_PLAY_END, f, f2, (int) d2);
                    ab.d(e.TAG, "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
                    this.pBX.pBr = new Location(f2, f, (int) d2, i, "", "");
                    this.pBX.pBA.ms(0);
                } else {
                    eVar = this.pBX;
                    this.pBX.pBr;
                    e.a(eVar, false);
                    e.f(this.pBX);
                }
                AppMethodBeat.o(102920);
                return false;
            }
        }
    }

    public e(d dVar, Context context) {
        j.p(dVar, "delegate");
        j.p(context, "context");
        AppMethodBeat.i(102936);
        this.pBC = dVar;
        this.context = context;
        AppMethodBeat.o(102936);
    }

    public static final /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(102939);
        eVar.stop();
        AppMethodBeat.o(102939);
    }

    public final void cdA() {
        AppMethodBeat.i(102921);
        cdB();
        this.eVT = false;
        this.pBr = null;
        this.pBt = f.Stopped;
        this.pBA.stopTimer();
        ab.d(TAG, "start radar");
        if (this.fwu == null) {
            this.fwu = com.tencent.mm.modelgeo.d.agz();
        }
        this.pBt = f.Locating;
        com.tencent.mm.modelgeo.d dVar = this.fwu;
        if (dVar != null) {
            dVar.b(this.ecy);
        }
        ab.d(TAG, "status: %s", this.pBt);
        AppMethodBeat.o(102921);
    }

    public final void cdB() {
        AppMethodBeat.i(102922);
        switch (f.eQZ[this.pBt.ordinal()]) {
            case 1:
                AppMethodBeat.o(102922);
                return;
            case 2:
                stop();
                break;
            case 3:
                if (this.pBs != null) {
                    stop();
                    com.tencent.mm.kernel.g.Rg().c((m) this.pBs);
                    cdC();
                    break;
                }
                break;
            case 4:
                stop();
                cdC();
                break;
        }
        ab.d(TAG, "stop radar");
        AppMethodBeat.o(102922);
    }

    private final void cdC() {
        AppMethodBeat.i(102923);
        this.pBB.sendEmptyMessageDelayed(pBF, (long) pBE);
        AppMethodBeat.o(102923);
    }

    public final void onResume() {
        AppMethodBeat.i(102924);
        com.tencent.mm.modelgeo.d dVar = this.fwu;
        if (dVar != null) {
            dVar.b(this.ecy);
            AppMethodBeat.o(102924);
            return;
        }
        AppMethodBeat.o(102924);
    }

    public final void stop() {
        AppMethodBeat.i(102925);
        this.eVT = true;
        this.pBt = f.Stopped;
        this.pBA.stopTimer();
        AppMethodBeat.o(102925);
    }

    private final void a(int i, int i2, LinkedList<bpb> linkedList) {
        AppMethodBeat.i(102926);
        this.pBC.a(i, i2, linkedList);
        AppMethodBeat.o(102926);
    }

    private final void b(int i, int i2, LinkedList<boy> linkedList) {
        AppMethodBeat.i(102927);
        this.pBC.b(i, i2, linkedList);
        AppMethodBeat.o(102927);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        LinkedList linkedList = null;
        AppMethodBeat.i(102928);
        j.p(mVar, "scene");
        switch (mVar.getType()) {
            case 425:
                if (this.pBs == mVar) {
                    if (((b) mVar).czE == 1) {
                        this.pBt = f.Waiting;
                        if (i == 0 && i2 == 0) {
                            int i3;
                            String str2 = TAG;
                            String str3 = "rader members count: %s ticket: %s";
                            Object[] objArr = new Object[2];
                            com.tencent.mm.ai.b bVar = ((b) mVar).ehh;
                            bpd bpd = (bpd) (bVar != null ? bVar.acA() : null);
                            if (bpd != null) {
                                i3 = bpd.ehB;
                            } else {
                                i3 = 0;
                            }
                            objArr[0] = Integer.valueOf(i3);
                            objArr[1] = this.cxb;
                            ab.d(str2, str3, objArr);
                            this.pBA.ms((long) pBD);
                            bVar = ((b) mVar).ehh;
                            bpd = (bpd) (bVar != null ? bVar.acA() : null);
                            if (bpd != null) {
                                linkedList = bpd.vEh;
                            }
                            if (linkedList != null) {
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    bpb bpb = (bpb) it.next();
                                    com.tencent.mm.plugin.c.a ask = com.tencent.mm.plugin.c.a.ask();
                                    j.o(ask, "PinAntispam.instance()");
                                    ask.Yn().ia(bpb.jBB, bpb.wlF);
                                }
                            }
                            if (linkedList != null) {
                                this.fLl.clear();
                                this.fLl.addAll(linkedList);
                            }
                            a(i, i2, this.fLl);
                            ab.d(TAG, "status: %s", this.pBt);
                            AppMethodBeat.o(102928);
                            return;
                        }
                        stop();
                        a(i, i2, null);
                        AppMethodBeat.o(102928);
                        return;
                    }
                    a(i, i2, null);
                    AppMethodBeat.o(102928);
                    return;
                }
                break;
            case 602:
                ab.d(TAG, " MMFunc_MMRadarRelationChain ");
                if (i != 0 || i2 != 0) {
                    b(i, i2, null);
                    break;
                }
                com.tencent.mm.bt.a acA = ((a) mVar).ehh.acA();
                if (acA == null) {
                    v vVar = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RadarRelationChainResponse");
                    AppMethodBeat.o(102928);
                    throw vVar;
                }
                bpa bpa = (bpa) acA;
                this.cxb = bpa.wdB;
                if (bpa.ehB > 0) {
                    b(i, i2, bpa.vEh);
                    AppMethodBeat.o(102928);
                    return;
                }
                b(i, i2, null);
                AppMethodBeat.o(102928);
                return;
        }
        AppMethodBeat.o(102928);
    }

    public final void a(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        AppMethodBeat.i(102929);
        com.tencent.mm.plugin.radar.b.c.e eVar2 = (com.tencent.mm.plugin.radar.b.c.e) this.pBw.get(str);
        if (!(eVar2 == null || eVar2 == eVar)) {
            this.pBx.put(str, eVar2);
        }
        AppMethodBeat.o(102929);
    }

    public final void b(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        AppMethodBeat.i(102930);
        j.p(str, "username");
        j.p(eVar, "state");
        if (!u.ar(str)) {
            a(str, eVar);
            this.pBw.put(str, eVar);
        }
        AppMethodBeat.o(102930);
    }

    public final com.tencent.mm.plugin.radar.b.c.e a(bpb bpb, boolean z) {
        AppMethodBeat.i(102931);
        j.p(bpb, "member");
        String str = bpb.jBB;
        j.o(str, "member.UserName");
        com.tencent.mm.plugin.radar.b.c.e bb = bb(str, z);
        if (bb == null) {
            str = bpb.wfK;
            j.o(str, "member.EncodeUserName");
            bb = bb(str, z);
        }
        AppMethodBeat.o(102931);
        return bb;
    }

    public final com.tencent.mm.plugin.radar.b.c.e Vy(String str) {
        AppMethodBeat.i(102933);
        j.p(str, "username");
        com.tencent.mm.plugin.radar.b.c.e bb = bb(str, false);
        AppMethodBeat.o(102933);
        return bb;
    }

    private final com.tencent.mm.plugin.radar.b.c.e bb(String str, boolean z) {
        AppMethodBeat.i(102934);
        com.tencent.mm.plugin.radar.b.c.e eVar;
        if (z) {
            eVar = (com.tencent.mm.plugin.radar.b.c.e) this.pBx.get(str);
            AppMethodBeat.o(102934);
            return eVar;
        }
        eVar = (com.tencent.mm.plugin.radar.b.c.e) this.pBw.get(str);
        AppMethodBeat.o(102934);
        return eVar;
    }

    public final void a(bpb bpb) {
        AppMethodBeat.i(102935);
        if (bpb != null) {
            com.tencent.mm.plugin.radar.ui.g gVar = com.tencent.mm.plugin.radar.ui.g.pDK;
            String b = com.tencent.mm.plugin.radar.ui.g.b(bpb);
            if (this.pBz.containsKey(b)) {
                this.pBz.remove(b);
                AppMethodBeat.o(102935);
                return;
            }
            this.pBz.put(b, a.Selected);
        }
        AppMethodBeat.o(102935);
    }

    static {
        AppMethodBeat.i(102937);
        AppMethodBeat.o(102937);
    }
}
