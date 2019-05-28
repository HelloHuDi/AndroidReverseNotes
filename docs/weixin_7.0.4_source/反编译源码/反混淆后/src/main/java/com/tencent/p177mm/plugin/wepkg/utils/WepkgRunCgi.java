package com.tencent.p177mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p690e.p691a.p692a.C6092b;

/* renamed from: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi */
public final class WepkgRunCgi {

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$a */
    public interface C23208a {
        /* renamed from: a */
        void mo27119a(int i, int i2, String str, C7472b c7472b);
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$RemoteCgiTask */
    public static final class RemoteCgiTask extends WepkgMainProcessTask implements C1224a {
        public static final Creator<RemoteCgiTask> CREATOR = new C300211();
        private String hxN;
        private int lqL;
        private int lqz;
        public int uYc = 0;
        private C7472b uYd;
        public C7472b uYe;
        public C23208a uYf;

        /* renamed from: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$RemoteCgiTask$1 */
        static class C300211 implements Creator<RemoteCgiTask> {
            C300211() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemoteCgiTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(63639);
                RemoteCgiTask remoteCgiTask = new RemoteCgiTask(parcel);
                AppMethodBeat.m2505o(63639);
                return remoteCgiTask;
            }
        }

        public final void asP() {
            AppMethodBeat.m2504i(63640);
            C1226w.m2655a(this.uYe, this, true);
            AppMethodBeat.m2505o(63640);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(63642);
            C30022d.m47515at(this);
            if (this.uYf != null) {
                this.uYf.mo27119a(this.lqL, this.lqz, this.hxN, this.uYd);
            }
            AppMethodBeat.m2505o(63642);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(63643);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.uYc);
            switch (this.uYc) {
                case 1:
                    WepkgRunCgi.m58629a(this.uYe, parcel);
                    AppMethodBeat.m2505o(63643);
                    return;
                case 2:
                    parcel.writeInt(this.lqL);
                    parcel.writeInt(this.lqz);
                    parcel.writeString(this.hxN);
                    WepkgRunCgi.m58629a(this.uYd, parcel);
                    break;
            }
            AppMethodBeat.m2505o(63643);
        }

        /* renamed from: g */
        public final void mo48259g(Parcel parcel) {
            AppMethodBeat.m2504i(63644);
            super.mo48259g(parcel);
            this.uYc = parcel.readInt();
            switch (this.uYc) {
                case 1:
                    this.uYe = WepkgRunCgi.m58630n(parcel);
                    AppMethodBeat.m2505o(63644);
                    return;
                case 2:
                    this.lqL = parcel.readInt();
                    this.lqz = parcel.readInt();
                    this.hxN = parcel.readString();
                    this.uYd = WepkgRunCgi.m58630n(parcel);
                    break;
            }
            AppMethodBeat.m2505o(63644);
        }

        RemoteCgiTask(Parcel parcel) {
            AppMethodBeat.m2504i(63645);
            mo48259g(parcel);
            AppMethodBeat.m2505o(63645);
        }

        static {
            AppMethodBeat.m2504i(63646);
            AppMethodBeat.m2505o(63646);
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(63641);
            this.lqL = i;
            this.lqz = i2;
            this.hxN = str;
            this.uYd = c7472b;
            this.uYc = 2;
            mo63809wM();
            AppMethodBeat.m2505o(63641);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$1 */
    public static class C357641 implements C1224a {
        final /* synthetic */ C23208a uYb;

        public C357641(C23208a c23208a) {
            this.uYb = c23208a;
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(63638);
            if (this.uYb != null) {
                this.uYb.mo27119a(i, i2, str, c7472b);
            }
            AppMethodBeat.m2505o(63638);
            return 0;
        }
    }

    /* renamed from: n */
    static C7472b m58630n(Parcel parcel) {
        AppMethodBeat.m2504i(63647);
        C1196a c1196a = new C1196a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            c1196a.fsJ = ((C1331a) Class.forName(readString).newInstance()).parseFrom(bArr);
        } catch (Exception e) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            c1196a.fsK = ((C1331a) Class.forName(readString2).newInstance()).parseFrom(bArr2);
        } catch (Exception e2) {
            if (e2 instanceof C6092b) {
                try {
                    c1196a.fsK = (C1331a) Class.forName(readString2).newInstance();
                } catch (Exception e22) {
                    C4990ab.m7413e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", C5046bo.m7574l(e22));
                }
            }
        }
        c1196a.uri = parcel.readString();
        c1196a.fsI = parcel.readInt();
        c1196a.fsL = parcel.readInt();
        c1196a.fsM = parcel.readInt();
        C7472b acD = c1196a.acD();
        AppMethodBeat.m2505o(63647);
        return acD;
    }

    /* renamed from: a */
    static /* synthetic */ void m58629a(C7472b c7472b, Parcel parcel) {
        AppMethodBeat.m2504i(63648);
        parcel.writeString(c7472b.fsG.fsP.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = c7472b.fsG.fsP.toByteArray();
        } catch (Exception e) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(c7472b.fsH.fsP.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = c7472b.fsH.fsP.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(c7472b.uri);
        parcel.writeInt(c7472b.fsI);
        parcel.writeInt(c7472b.fsG.cmdId);
        parcel.writeInt(c7472b.fsH.cmdId);
        AppMethodBeat.m2505o(63648);
    }
}
