package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C42541c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C27003i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42523ac;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C27067l;
import com.tencent.p177mm.plugin.appbrand.jsapi.p314q.C45616h;
import com.tencent.p659pb.common.p1102c.C40956g;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p1102c.C46729d;
import com.tencent.p659pb.common.p1102c.C46730f;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.util.ArrayList;

/* renamed from: com.tencent.wecall.talkroom.model.h */
public class C36578h {
    public static C36578h AKQ = new C36578h();
    static final String TAG = C36578h.class.getCanonicalName();
    public int AKR = 0;
    int AKS = 0;
    long AKT = 0;
    long AKU = 0;
    int AKV = 0;
    public int AKW = 0;
    int AKX = 0;
    long AKY = 0;
    private int AKZ;
    private int ALa = -1;
    private String ALb;
    private int ALc;
    private StringBuffer ALd = new StringBuffer();
    private long ALe = 0;
    long ALf = 0;
    long ALg = 0;
    public String Amx = "";
    private String deviceModel;
    public String groupId = "";
    public int kyZ = -1;
    public int netType = -1;
    public int nwu = 0;
    public long nwv = 0;
    long nxK = 0;
    int nxL = 0;
    public int sUl = 1;
    public int sUo = 0;
    public int sUp = 0;
    public int sUs = 0;
    public int sUz = -1;
    int tdf = 0;
    int tdi = 0;
    int tdm = 0;
    long tdn = 0;
    int tds = 0;
    public int tdt = 0;
    private String tdy = "";

    public C36578h() {
        AppMethodBeat.m2504i(127978);
        AppMethodBeat.m2505o(127978);
    }

    static {
        AppMethodBeat.m2504i(127999);
        AppMethodBeat.m2505o(127999);
    }

    public final void reset() {
        AppMethodBeat.m2504i(127979);
        C44443c.m80389d(TAG, "reset");
        this.ALg = 0;
        this.ALf = 0;
        this.ALe = 0;
        this.groupId = "";
        this.Amx = "";
        this.sUl = 1;
        this.nwu = 0;
        this.nwv = 0;
        this.kyZ = -1;
        this.tdf = 0;
        this.tdm = 0;
        this.tdi = 0;
        this.nxL = 0;
        this.AKR = 0;
        this.AKS = 0;
        this.AKT = 0;
        this.AKU = 0;
        this.AKV = 0;
        this.AKW = 0;
        this.AKX = 0;
        this.AKY = 0;
        this.tdn = 0;
        this.nxK = 0;
        this.tds = 0;
        this.tdt = 0;
        this.netType = -1;
        this.AKZ = 0;
        this.ALa = 0;
        this.ALb = "";
        this.deviceModel = "";
        this.ALc = -1;
        this.tdy = "";
        this.ALd.setLength(0);
        this.sUz = -1;
        this.sUs = 0;
        this.sUo = 0;
        this.sUp = 0;
        AppMethodBeat.m2505o(127979);
    }

    public final String dTB() {
        AppMethodBeat.m2504i(127980);
        C44443c.m80389d(TAG, "collectInfo");
        this.ALb = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.ALc = VERSION.SDK_INT;
        this.tdy = VERSION.RELEASE;
        this.netType = C41114k.m71547ju(C46729d.sZj);
        this.AKZ = -1;
        this.ALa = -1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.groupId);
        arrayList.add(this.Amx);
        arrayList.add(Integer.valueOf(this.sUl));
        arrayList.add(Integer.valueOf(this.nwu));
        arrayList.add(Long.valueOf(this.nwv));
        arrayList.add(Integer.valueOf(this.kyZ));
        arrayList.add(Integer.valueOf(this.tdf));
        arrayList.add(Integer.valueOf(this.tdm));
        arrayList.add(Integer.valueOf(this.tdi));
        arrayList.add(Integer.valueOf(this.nxL));
        arrayList.add(Integer.valueOf(this.AKR));
        arrayList.add(Integer.valueOf(this.AKS));
        arrayList.add(Long.valueOf(this.AKT));
        arrayList.add(Long.valueOf(this.AKU));
        arrayList.add(Integer.valueOf(this.AKV));
        arrayList.add(Integer.valueOf(this.AKW));
        arrayList.add(Integer.valueOf(this.AKX));
        arrayList.add(Long.valueOf(this.AKY));
        arrayList.add(Long.valueOf(this.tdn));
        arrayList.add(Long.valueOf(this.nxK));
        arrayList.add(Integer.valueOf(this.tds));
        arrayList.add(Integer.valueOf(this.tdt));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.AKZ));
        arrayList.add(Integer.valueOf(this.ALa));
        arrayList.add(this.ALb);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.ALc));
        arrayList.add(this.tdy);
        arrayList.add(Integer.valueOf(C6001c.dTg().auI(this.groupId)));
        arrayList.add(this.ALd.toString());
        arrayList.add(Integer.valueOf(this.sUz));
        arrayList.add(Integer.valueOf(this.sUs));
        arrayList.add(Integer.valueOf(this.sUo));
        arrayList.add(Integer.valueOf(this.sUp));
        String a = C40956g.m71018a(arrayList, ",", "_");
        C44443c.m80389d(TAG, "logBuf: ", this.ALd.toString());
        C44443c.m80389d(TAG, "statresult", a);
        AppMethodBeat.m2505o(127980);
        return a;
    }

    /* renamed from: a */
    public static void m60652a(String str, int i, long j, String... strArr) {
        AppMethodBeat.m2504i(127981);
        if (TextUtils.isEmpty(str)) {
            C44443c.m80392w(TAG, "uploadTempReport groupId is null");
            AppMethodBeat.m2505o(127981);
            return;
        }
        C44443c.m80392w(TAG, "uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j));
        C36578h c36578h = new C36578h();
        if (str == null) {
            str = "";
        }
        c36578h.groupId = str;
        c36578h.nwu = i;
        c36578h.nwv = j;
        c36578h.mo58376aa(strArr);
        C36578h.auO(c36578h.dTB());
        AppMethodBeat.m2505o(127981);
    }

    /* renamed from: a */
    public static void m60653a(String str, String str2, int i, long j, String... strArr) {
        AppMethodBeat.m2504i(127982);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            C44443c.m80392w(TAG, "uploadTempReport groupId and clientGroupId is null");
            AppMethodBeat.m2505o(127982);
            return;
        }
        C44443c.m80392w(TAG, "uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j));
        C36578h c36578h = new C36578h();
        if (str == null) {
            str = "";
        }
        c36578h.groupId = str;
        c36578h.nwu = i;
        c36578h.nwv = j;
        if (str2 == null) {
            str2 = "";
        }
        c36578h.Amx = str2;
        c36578h.mo58376aa(strArr);
        C36578h.auO(c36578h.dTB());
        C46730f.dPL();
        AppMethodBeat.m2505o(127982);
    }

    /* renamed from: a */
    public static void m60651a(int i, long j, String... strArr) {
        AppMethodBeat.m2504i(127983);
        C36578h c36578h = new C36578h();
        c36578h.groupId = "";
        c36578h.nwu = i;
        c36578h.nwv = j;
        c36578h.Amx = "";
        c36578h.mo58376aa(strArr);
        C36578h.auO(c36578h.dTB());
        C46730f.dPL();
        AppMethodBeat.m2505o(127983);
    }

    /* renamed from: aa */
    public final void mo58376aa(String... strArr) {
        int i = 0;
        AppMethodBeat.m2504i(127984);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(127984);
            return;
        }
        if (this.ALd.length() > TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR) {
            this.ALd.setLength(0);
            this.ALd.append("overmaxsize");
        }
        if (this.ALd.length() != 0) {
            this.ALd.append("-");
        }
        int length = strArr.length;
        while (i < length) {
            this.ALd.append(strArr[i]);
            this.ALd.append("|");
            i++;
        }
        AppMethodBeat.m2505o(127984);
    }

    public final void dTC() {
        AppMethodBeat.m2504i(127985);
        this.ALe = System.currentTimeMillis();
        C44443c.m80389d(TAG, "beginCreateOrEnter", Long.valueOf(this.ALe));
        AppMethodBeat.m2505o(127985);
    }

    public final void dTD() {
        AppMethodBeat.m2504i(127986);
        C44443c.m80389d(TAG, "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.ALe), Long.valueOf(this.AKT));
        if (this.AKT > 0) {
            AppMethodBeat.m2505o(127986);
            return;
        }
        this.tdm = 1;
        if (this.ALe == 0) {
            this.tdn = 0;
            AppMethodBeat.m2505o(127986);
            return;
        }
        this.tdn = System.currentTimeMillis() - this.ALe;
        AppMethodBeat.m2505o(127986);
    }

    public final void dTE() {
        AppMethodBeat.m2504i(127987);
        C44443c.m80392w(TAG, "beginCreateOrNotify");
        this.ALf = System.currentTimeMillis();
        AppMethodBeat.m2505o(127987);
    }

    public final void dTF() {
        AppMethodBeat.m2504i(127988);
        C44443c.m80389d(TAG, "endAnswerTime", Long.valueOf(this.ALg));
        if (this.ALg == 0) {
            this.nxK = 0;
            AppMethodBeat.m2505o(127988);
            return;
        }
        this.nxK = System.currentTimeMillis() - this.ALg;
        AppMethodBeat.m2505o(127988);
    }

    /* renamed from: Sq */
    public static void m60647Sq(int i) {
        AppMethodBeat.m2504i(127989);
        C44443c.m80389d(TAG, "sendNetSceneStat", Integer.valueOf(i));
        C46730f.m88557C(JsApiGetABTestConfig.CTRL_INDEX, 3, String.valueOf(i));
        AppMethodBeat.m2505o(127989);
    }

    /* renamed from: Sr */
    public static void m60648Sr(int i) {
        AppMethodBeat.m2504i(127990);
        C44443c.m80389d(TAG, "sendDeviceStat", Integer.valueOf(i));
        C46730f.m88557C(528, 3, String.valueOf(i));
        AppMethodBeat.m2505o(127990);
    }

    /* renamed from: Ss */
    public static void m60649Ss(int i) {
        AppMethodBeat.m2504i(127991);
        C44443c.m80389d(TAG, "sendtalkRoomDialStat", Integer.valueOf(i));
        C46730f.m88557C(530, 3, String.valueOf(i));
        AppMethodBeat.m2505o(127991);
    }

    public static void dTG() {
        AppMethodBeat.m2504i(127992);
        C44443c.m80389d(TAG, "sendTalkRoomOnDialStat", Integer.valueOf(-5001));
        C46730f.m88557C(531, 3, "-5001");
        AppMethodBeat.m2505o(127992);
    }

    /* renamed from: St */
    public static void m60650St(int i) {
        AppMethodBeat.m2504i(127993);
        C44443c.m80389d(TAG, "sendEngineStat", Integer.valueOf(i));
        C46730f.m88557C(C27003i.CTRL_INDEX, 3, String.valueOf(i));
        AppMethodBeat.m2505o(127993);
    }

    public static void auO(String str) {
        AppMethodBeat.m2504i(127994);
        C44443c.m80389d(TAG, "sendSummaryNetScene", str);
        C46730f.m88557C(C42541c.CTRL_INDEX, 3, str);
        AppMethodBeat.m2505o(127994);
    }

    public static void auP(String str) {
        AppMethodBeat.m2504i(127995);
        C44443c.m80389d(TAG, "sendEngineRecv", str);
        C46730f.m88557C(C42523ac.CTRL_INDEX, 3, str);
        AppMethodBeat.m2505o(127995);
    }

    public static void auQ(String str) {
        AppMethodBeat.m2504i(127996);
        C44443c.m80389d(TAG, "sendEngineSend", str);
        C46730f.m88557C(C27067l.CTRL_INDEX, 3, str);
        AppMethodBeat.m2505o(127996);
    }

    public static void auR(String str) {
        AppMethodBeat.m2504i(127997);
        C44443c.m80389d(TAG, "sendChannelStat", str);
        C46730f.m88557C(C45616h.CTRL_INDEX, 3, str);
        AppMethodBeat.m2505o(127997);
    }

    /* renamed from: Su */
    public final void mo58375Su(int i) {
        AppMethodBeat.m2504i(127998);
        C44443c.m80389d(TAG, "stopStatus", Integer.valueOf(i));
        this.tdf = i;
        AppMethodBeat.m2505o(127998);
    }
}
