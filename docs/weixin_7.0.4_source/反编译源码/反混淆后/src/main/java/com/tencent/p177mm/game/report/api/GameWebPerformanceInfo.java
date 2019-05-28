package com.tencent.p177mm.game.report.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.game.report.api.GameWebPerformanceInfo */
public class GameWebPerformanceInfo implements Parcelable {
    public static final Creator<GameWebPerformanceInfo> CREATOR = new C263181();
    private static Map<String, GameWebPerformanceInfo> eCp = new HashMap();
    public String eBJ;
    public int eBK;
    public int eBL;
    public int eBM;
    public int eBN;
    public int eBO;
    public int eBP;
    public int eBQ;
    public int eBR;
    public String eBS;
    public long eBT;
    public long eBU;
    public long eBV;
    public long eBW;
    public long eBX;
    public long eBY;
    public long eBZ;
    public long eCa;
    public long eCb;
    public long eCc;
    public long eCd;
    public long eCe;
    public long eCf;
    public long eCg;
    public long eCh;
    public long eCi;
    public long eCj;
    public long eCk;
    public long eCl;
    public long eCm;
    public String eCn;
    public String eCo;
    public long startTime;
    public String url;

    /* renamed from: com.tencent.mm.game.report.api.GameWebPerformanceInfo$1 */
    static class C263181 implements Creator<GameWebPerformanceInfo> {
        C263181() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameWebPerformanceInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(128611);
            GameWebPerformanceInfo gameWebPerformanceInfo = new GameWebPerformanceInfo(parcel, (byte) 0);
            AppMethodBeat.m2505o(128611);
            return gameWebPerformanceInfo;
        }
    }

    /* synthetic */ GameWebPerformanceInfo(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(128612);
        parcel.writeString(this.url);
        parcel.writeString(this.eBJ);
        parcel.writeInt(this.eBK);
        parcel.writeInt(this.eBL);
        parcel.writeInt(this.eBM);
        parcel.writeInt(this.eBN);
        parcel.writeInt(this.eBO);
        parcel.writeInt(this.eBP);
        parcel.writeInt(this.eBQ);
        parcel.writeInt(this.eBR);
        parcel.writeString(this.eBS);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.eBT);
        parcel.writeLong(this.eBU);
        parcel.writeLong(this.eBV);
        parcel.writeLong(this.eBW);
        parcel.writeLong(this.eBX);
        parcel.writeLong(this.eBY);
        parcel.writeLong(this.eBZ);
        parcel.writeLong(this.eCa);
        parcel.writeLong(this.eCb);
        parcel.writeLong(this.eCc);
        parcel.writeLong(this.eCd);
        parcel.writeLong(this.eCe);
        parcel.writeLong(this.eCf);
        parcel.writeLong(this.eCg);
        parcel.writeLong(this.eCh);
        parcel.writeLong(this.eCi);
        parcel.writeLong(this.eCj);
        parcel.writeLong(this.eCk);
        parcel.writeLong(this.eCl);
        parcel.writeLong(this.eCm);
        parcel.writeString(this.eCn);
        parcel.writeString(this.eCo);
        AppMethodBeat.m2505o(128612);
    }

    private GameWebPerformanceInfo(Parcel parcel) {
        AppMethodBeat.m2504i(128613);
        this.url = parcel.readString();
        this.eBJ = parcel.readString();
        this.eBK = parcel.readInt();
        this.eBL = parcel.readInt();
        this.eBM = parcel.readInt();
        this.eBN = parcel.readInt();
        this.eBO = parcel.readInt();
        this.eBP = parcel.readInt();
        this.eBQ = parcel.readInt();
        this.eBR = parcel.readInt();
        this.eBS = parcel.readString();
        this.startTime = parcel.readLong();
        this.eBT = parcel.readLong();
        this.eBU = parcel.readLong();
        this.eBV = parcel.readLong();
        this.eBW = parcel.readLong();
        this.eBX = parcel.readLong();
        this.eBY = parcel.readLong();
        this.eBZ = parcel.readLong();
        this.eCa = parcel.readLong();
        this.eCb = parcel.readLong();
        this.eCc = parcel.readLong();
        this.eCd = parcel.readLong();
        this.eCe = parcel.readLong();
        this.eCf = parcel.readLong();
        this.eCg = parcel.readLong();
        this.eCh = parcel.readLong();
        this.eCi = parcel.readLong();
        this.eCj = parcel.readLong();
        this.eCk = parcel.readLong();
        this.eCl = parcel.readLong();
        this.eCm = parcel.readLong();
        this.eCn = parcel.readString();
        this.eCo = parcel.readString();
        AppMethodBeat.m2505o(128613);
    }

    static {
        AppMethodBeat.m2504i(128618);
        AppMethodBeat.m2505o(128618);
    }

    public String toString() {
        AppMethodBeat.m2504i(128614);
        String format = String.format("url: %s, isLuggage: %d, isWePkg: %d, isPreloadWebCore: %d, isFirstPage: %d, usedCacheUinKey: %d, jsapiCanUsed: %d, hasFloatLayer: %d, pkgId: %s,startTime: %d, gameCenterUICreate: %d, startWebUI: %d, preloadWePkgBgn: %d,preloadWePkgEnd: %d, preloadWebCoreBgn: %d, preloadWebCoreEnd: %d, webUICreate: %d, webUIOnShowBgn: %d, createViewBgn: %d,createViewEnd: %d, jsbridgeInject: %d, loadUrlBgn: %d, onPageStarted: %d,onPageFinished: %d, getA8keyBgn: %d, getA8keyEnd: %d, webUIInFront: %d, webUIDestroy: %d, commJsVersion: %s, pkgVersion: %s", new Object[]{this.url, Integer.valueOf(this.eBK), Integer.valueOf(this.eBL), Integer.valueOf(this.eBM), Integer.valueOf(this.eBN), Integer.valueOf(this.eBO), Integer.valueOf(this.eBQ), Integer.valueOf(this.eBR), this.eBS, Long.valueOf(this.startTime), Long.valueOf(this.eBT), Long.valueOf(this.eBU), Long.valueOf(this.eBX), Long.valueOf(this.eBW), Long.valueOf(this.eBX), Long.valueOf(this.eBY), Long.valueOf(this.eBZ), Long.valueOf(this.eCa), Long.valueOf(this.eCb), Long.valueOf(this.eCc), Long.valueOf(this.eCd), Long.valueOf(this.eCe), Long.valueOf(this.eCf), Long.valueOf(this.eCg), Long.valueOf(this.eCh), Long.valueOf(this.eCi), Long.valueOf(this.eCj), Long.valueOf(this.eCk), this.eCn, this.eCo});
        AppMethodBeat.m2505o(128614);
        return format;
    }

    /* renamed from: kU */
    public static synchronized GameWebPerformanceInfo m63878kU(String str) {
        GameWebPerformanceInfo gameWebPerformanceInfo;
        synchronized (GameWebPerformanceInfo.class) {
            AppMethodBeat.m2504i(128615);
            if (C5046bo.isNullOrNil(str)) {
                gameWebPerformanceInfo = new GameWebPerformanceInfo();
                AppMethodBeat.m2505o(128615);
            } else if (eCp.containsKey(str)) {
                gameWebPerformanceInfo = (GameWebPerformanceInfo) eCp.get(str);
                AppMethodBeat.m2505o(128615);
            } else {
                gameWebPerformanceInfo = new GameWebPerformanceInfo();
                eCp.put(str, gameWebPerformanceInfo);
                AppMethodBeat.m2505o(128615);
            }
        }
        return gameWebPerformanceInfo;
    }

    /* renamed from: kV */
    public static synchronized GameWebPerformanceInfo m63879kV(String str) {
        GameWebPerformanceInfo gameWebPerformanceInfo;
        synchronized (GameWebPerformanceInfo.class) {
            AppMethodBeat.m2504i(128616);
            if (eCp.containsKey(str)) {
                eCp.remove(str);
            }
            gameWebPerformanceInfo = new GameWebPerformanceInfo();
            eCp.put(str, gameWebPerformanceInfo);
            AppMethodBeat.m2505o(128616);
        }
        return gameWebPerformanceInfo;
    }

    /* renamed from: kW */
    public static GameWebPerformanceInfo m63880kW(String str) {
        AppMethodBeat.m2504i(128617);
        GameWebPerformanceInfo gameWebPerformanceInfo = (GameWebPerformanceInfo) eCp.remove(str);
        AppMethodBeat.m2505o(128617);
        return gameWebPerformanceInfo;
    }
}
