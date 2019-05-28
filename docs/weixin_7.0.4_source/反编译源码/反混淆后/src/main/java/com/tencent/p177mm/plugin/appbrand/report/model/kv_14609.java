package com.tencent.p177mm.plugin.appbrand.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p230g.p231a.C18304iz;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.kv_14609 */
public final class kv_14609 implements Parcelable {
    public static final Creator<kv_14609> CREATOR = new C197001();
    public final String appId;
    public int cBc;
    private int cyE;
    public final int gTP;
    public String gTy;
    public long iCh;
    public final boolean iCi;
    public boolean iCj;
    public boolean iCk;
    public int iCl;
    public int iCm;
    public long iCn;
    private long iCo;
    public long iCp;
    public long iCq;
    public String igT;
    public final int ihB;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.model.kv_14609$1 */
    static class C197001 implements Creator<kv_14609> {
        C197001() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new kv_14609[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(132652);
            kv_14609 kv_14609 = new kv_14609(parcel);
            AppMethodBeat.m2505o(132652);
            return kv_14609;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kv_14609(String str, int i, int i2) {
        AppMethodBeat.m2504i(132653);
        C4990ab.m7417i("MicroMsg.AppBrand.Report.kv_14609", "appid:%s,oldVersion:%s,targetVersion:%s", str, Integer.valueOf(i), Integer.valueOf(i2));
        if ("@LibraryAppId".equals(str)) {
            this.appId = "publiclib";
            this.gTy = null;
            this.iCi = C19071r.avE();
        } else {
            if (str.contains("$")) {
                String[] split = str.split(Pattern.quote("$"));
                this.appId = split[0];
                if (split != null) {
                    switch (split.length) {
                        case 2:
                            String str2 = split[1];
                            if (!C5046bo.isNullOrNil(str2)) {
                                if (str2.equals("__WITHOUT_CODELIB__")) {
                                    this.cBc = 12;
                                    this.gTy = null;
                                } else if (str2.equals("__CODELIB__")) {
                                    this.cBc = 14;
                                    this.gTy = null;
                                } else {
                                    this.gTy = str2;
                                }
                            }
                            break;
                        case 3:
                            this.gTy = split[1];
                            if (!C5046bo.isNullOrNil(split[2]) && split[2].equals("__WITHOUT_CODELIB__")) {
                                this.cBc = 13;
                            }
                            C4990ab.m7417i("MicroMsg.AppBrand.Report.kv_14609", "getModuleName modulename:%s,appid:%s,pkgtype:%s", this.gTy, this.appId, Integer.valueOf(this.cBc));
                            break;
                    }
                }
                C4990ab.m7417i("MicroMsg.AppBrand.Report.kv_14609", "getModuleName modulename:%s,appid:%s,pkgtype:%s", this.gTy, this.appId, Integer.valueOf(this.cBc));
            } else {
                this.appId = str;
                this.gTy = null;
            }
            this.iCi = C19071r.avD();
        }
        this.gTP = i;
        this.ihB = i2;
        AppMethodBeat.m2505o(132653);
    }

    public final void aLx() {
        AppMethodBeat.m2504i(132654);
        long anU = C5046bo.anU();
        this.iCo = anU;
        this.iCh = anU - this.iCn;
        AppMethodBeat.m2505o(132654);
    }

    /* renamed from: pL */
    public final void mo61205pL(int i) {
        if (this.iCi) {
            this.cyE = i;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(132655);
        String str = "kv_14609{appId='" + this.appId + '\'' + ", oldVersion=" + this.gTP + ", targetVersion=" + this.ihB + ", spendTime=" + this.iCh + ", canUsePatchUpdate=" + this.iCi + ", isUpdateComplete=" + this.iCj + ", isUpdateCompleteWithPatch=" + this.iCk + ", fullPkgSize=" + this.iCl + ", patchSize=" + this.iCm + ", errcode=" + this.cyE + ", pkgType=" + this.cBc + '}';
        AppMethodBeat.m2505o(132655);
        return str;
    }

    /* renamed from: IF */
    public final void mo61202IF() {
        int i = 1;
        AppMethodBeat.m2504i(132656);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C18304iz c18304iz = new C18304iz();
            c18304iz.cEe.cEf = this;
            C4879a.xxA.mo10055m(c18304iz);
            C4990ab.m7410d("MicroMsg.AppBrand.Report.kv_14609", "report in mm process, publish event");
            AppMethodBeat.m2505o(132656);
            return;
        }
        int i2;
        C4990ab.m7417i("MicroMsg.AppBrand.Report.kv_14609", "report %s", toString());
        C7053e c7053e = C7053e.pXa;
        Object[] objArr = new Object[19];
        objArr[0] = this.appId;
        objArr[1] = Integer.valueOf(1);
        objArr[2] = C19690c.m30503cV(C4996ah.getContext());
        objArr[3] = Integer.valueOf(this.gTP);
        objArr[4] = Integer.valueOf(this.ihB);
        objArr[5] = Long.valueOf(this.iCh);
        objArr[6] = Integer.valueOf(this.iCi ? 1 : 0);
        if (this.iCj) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[7] = Integer.valueOf(i2);
        if (!this.iCk) {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        objArr[9] = Integer.valueOf(this.iCl);
        objArr[10] = Integer.valueOf(this.iCm);
        objArr[11] = Integer.valueOf(this.cyE);
        objArr[12] = this.gTy;
        objArr[13] = Long.valueOf(this.iCn);
        objArr[14] = Long.valueOf(this.iCo);
        objArr[15] = this.igT;
        objArr[16] = Long.valueOf(this.iCp);
        objArr[17] = Long.valueOf(this.iCq);
        objArr[18] = Integer.valueOf(this.cBc);
        c7053e.mo8381e(14609, objArr);
        AppMethodBeat.m2505o(132656);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        AppMethodBeat.m2504i(132657);
        parcel.writeString(this.appId);
        parcel.writeString(this.gTy);
        parcel.writeInt(this.gTP);
        parcel.writeInt(this.ihB);
        parcel.writeLong(this.iCh);
        parcel.writeByte(this.iCi ? (byte) 1 : (byte) 0);
        if (this.iCj) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.iCk) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.iCl);
        parcel.writeInt(this.iCm);
        parcel.writeInt(this.cyE);
        parcel.writeLong(this.iCn);
        parcel.writeLong(this.iCo);
        parcel.writeString(this.igT);
        parcel.writeLong(this.iCp);
        parcel.writeLong(this.iCq);
        parcel.writeInt(this.cBc);
        AppMethodBeat.m2505o(132657);
    }

    protected kv_14609(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(132658);
        this.appId = parcel.readString();
        this.gTy = parcel.readString();
        this.gTP = parcel.readInt();
        this.ihB = parcel.readInt();
        this.iCh = parcel.readLong();
        this.iCi = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iCj = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.iCk = z2;
        this.iCl = parcel.readInt();
        this.iCm = parcel.readInt();
        this.cyE = parcel.readInt();
        this.iCn = parcel.readLong();
        this.iCo = parcel.readLong();
        this.igT = parcel.readString();
        this.iCp = parcel.readLong();
        this.iCq = parcel.readLong();
        this.cBc = parcel.readInt();
        AppMethodBeat.m2505o(132658);
    }

    static {
        AppMethodBeat.m2504i(132659);
        AppMethodBeat.m2505o(132659);
    }
}
