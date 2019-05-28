package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.i.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.ac;
import com.tencent.mm.plugin.appbrand.jsapi.q.l;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.f;
import com.tencent.pb.common.c.g;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;
import java.util.ArrayList;

public class h {
    public static h AKQ = new h();
    static final String TAG = h.class.getCanonicalName();
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

    public h() {
        AppMethodBeat.i(127978);
        AppMethodBeat.o(127978);
    }

    static {
        AppMethodBeat.i(127999);
        AppMethodBeat.o(127999);
    }

    public final void reset() {
        AppMethodBeat.i(127979);
        c.d(TAG, "reset");
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
        AppMethodBeat.o(127979);
    }

    public final String dTB() {
        AppMethodBeat.i(127980);
        c.d(TAG, "collectInfo");
        this.ALb = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.ALc = VERSION.SDK_INT;
        this.tdy = VERSION.RELEASE;
        this.netType = k.ju(d.sZj);
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
        arrayList.add(Integer.valueOf(c.dTg().auI(this.groupId)));
        arrayList.add(this.ALd.toString());
        arrayList.add(Integer.valueOf(this.sUz));
        arrayList.add(Integer.valueOf(this.sUs));
        arrayList.add(Integer.valueOf(this.sUo));
        arrayList.add(Integer.valueOf(this.sUp));
        String a = g.a(arrayList, ",", "_");
        c.d(TAG, "logBuf: ", this.ALd.toString());
        c.d(TAG, "statresult", a);
        AppMethodBeat.o(127980);
        return a;
    }

    public static void a(String str, int i, long j, String... strArr) {
        AppMethodBeat.i(127981);
        if (TextUtils.isEmpty(str)) {
            c.w(TAG, "uploadTempReport groupId is null");
            AppMethodBeat.o(127981);
            return;
        }
        c.w(TAG, "uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.nwu = i;
        hVar.nwv = j;
        hVar.aa(strArr);
        auO(hVar.dTB());
        AppMethodBeat.o(127981);
    }

    public static void a(String str, String str2, int i, long j, String... strArr) {
        AppMethodBeat.i(127982);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            c.w(TAG, "uploadTempReport groupId and clientGroupId is null");
            AppMethodBeat.o(127982);
            return;
        }
        c.w(TAG, "uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = "";
        }
        hVar.groupId = str;
        hVar.nwu = i;
        hVar.nwv = j;
        if (str2 == null) {
            str2 = "";
        }
        hVar.Amx = str2;
        hVar.aa(strArr);
        auO(hVar.dTB());
        f.dPL();
        AppMethodBeat.o(127982);
    }

    public static void a(int i, long j, String... strArr) {
        AppMethodBeat.i(127983);
        h hVar = new h();
        hVar.groupId = "";
        hVar.nwu = i;
        hVar.nwv = j;
        hVar.Amx = "";
        hVar.aa(strArr);
        auO(hVar.dTB());
        f.dPL();
        AppMethodBeat.o(127983);
    }

    public final void aa(String... strArr) {
        int i = 0;
        AppMethodBeat.i(127984);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(127984);
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
        AppMethodBeat.o(127984);
    }

    public final void dTC() {
        AppMethodBeat.i(127985);
        this.ALe = System.currentTimeMillis();
        c.d(TAG, "beginCreateOrEnter", Long.valueOf(this.ALe));
        AppMethodBeat.o(127985);
    }

    public final void dTD() {
        AppMethodBeat.i(127986);
        c.d(TAG, "endCancelCreate", Long.valueOf(System.currentTimeMillis() - this.ALe), Long.valueOf(this.AKT));
        if (this.AKT > 0) {
            AppMethodBeat.o(127986);
            return;
        }
        this.tdm = 1;
        if (this.ALe == 0) {
            this.tdn = 0;
            AppMethodBeat.o(127986);
            return;
        }
        this.tdn = System.currentTimeMillis() - this.ALe;
        AppMethodBeat.o(127986);
    }

    public final void dTE() {
        AppMethodBeat.i(127987);
        c.w(TAG, "beginCreateOrNotify");
        this.ALf = System.currentTimeMillis();
        AppMethodBeat.o(127987);
    }

    public final void dTF() {
        AppMethodBeat.i(127988);
        c.d(TAG, "endAnswerTime", Long.valueOf(this.ALg));
        if (this.ALg == 0) {
            this.nxK = 0;
            AppMethodBeat.o(127988);
            return;
        }
        this.nxK = System.currentTimeMillis() - this.ALg;
        AppMethodBeat.o(127988);
    }

    public static void Sq(int i) {
        AppMethodBeat.i(127989);
        c.d(TAG, "sendNetSceneStat", Integer.valueOf(i));
        f.C(JsApiGetABTestConfig.CTRL_INDEX, 3, String.valueOf(i));
        AppMethodBeat.o(127989);
    }

    public static void Sr(int i) {
        AppMethodBeat.i(127990);
        c.d(TAG, "sendDeviceStat", Integer.valueOf(i));
        f.C(528, 3, String.valueOf(i));
        AppMethodBeat.o(127990);
    }

    public static void Ss(int i) {
        AppMethodBeat.i(127991);
        c.d(TAG, "sendtalkRoomDialStat", Integer.valueOf(i));
        f.C(530, 3, String.valueOf(i));
        AppMethodBeat.o(127991);
    }

    public static void dTG() {
        AppMethodBeat.i(127992);
        c.d(TAG, "sendTalkRoomOnDialStat", Integer.valueOf(-5001));
        f.C(531, 3, "-5001");
        AppMethodBeat.o(127992);
    }

    public static void St(int i) {
        AppMethodBeat.i(127993);
        c.d(TAG, "sendEngineStat", Integer.valueOf(i));
        f.C(i.CTRL_INDEX, 3, String.valueOf(i));
        AppMethodBeat.o(127993);
    }

    public static void auO(String str) {
        AppMethodBeat.i(127994);
        c.d(TAG, "sendSummaryNetScene", str);
        f.C(com.tencent.mm.plugin.appbrand.jsapi.media.c.CTRL_INDEX, 3, str);
        AppMethodBeat.o(127994);
    }

    public static void auP(String str) {
        AppMethodBeat.i(127995);
        c.d(TAG, "sendEngineRecv", str);
        f.C(ac.CTRL_INDEX, 3, str);
        AppMethodBeat.o(127995);
    }

    public static void auQ(String str) {
        AppMethodBeat.i(127996);
        c.d(TAG, "sendEngineSend", str);
        f.C(l.CTRL_INDEX, 3, str);
        AppMethodBeat.o(127996);
    }

    public static void auR(String str) {
        AppMethodBeat.i(127997);
        c.d(TAG, "sendChannelStat", str);
        f.C(com.tencent.mm.plugin.appbrand.jsapi.q.h.CTRL_INDEX, 3, str);
        AppMethodBeat.o(127997);
    }

    public final void Su(int i) {
        AppMethodBeat.i(127998);
        c.d(TAG, "stopStatus", Integer.valueOf(i));
        this.tdf = i;
        AppMethodBeat.o(127998);
    }
}
