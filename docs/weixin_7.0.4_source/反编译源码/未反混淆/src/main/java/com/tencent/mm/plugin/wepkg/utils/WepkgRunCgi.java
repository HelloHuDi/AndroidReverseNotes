package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class WepkgRunCgi {

    public interface a {
        void a(int i, int i2, String str, b bVar);
    }

    public static final class RemoteCgiTask extends WepkgMainProcessTask implements com.tencent.mm.ai.w.a {
        public static final Creator<RemoteCgiTask> CREATOR = new Creator<RemoteCgiTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemoteCgiTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(63639);
                RemoteCgiTask remoteCgiTask = new RemoteCgiTask(parcel);
                AppMethodBeat.o(63639);
                return remoteCgiTask;
            }
        };
        private String hxN;
        private int lqL;
        private int lqz;
        public int uYc = 0;
        private b uYd;
        public b uYe;
        public a uYf;

        public final void asP() {
            AppMethodBeat.i(63640);
            w.a(this.uYe, this, true);
            AppMethodBeat.o(63640);
        }

        public final void asQ() {
            AppMethodBeat.i(63642);
            d.at(this);
            if (this.uYf != null) {
                this.uYf.a(this.lqL, this.lqz, this.hxN, this.uYd);
            }
            AppMethodBeat.o(63642);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(63643);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.uYc);
            switch (this.uYc) {
                case 1:
                    WepkgRunCgi.a(this.uYe, parcel);
                    AppMethodBeat.o(63643);
                    return;
                case 2:
                    parcel.writeInt(this.lqL);
                    parcel.writeInt(this.lqz);
                    parcel.writeString(this.hxN);
                    WepkgRunCgi.a(this.uYd, parcel);
                    break;
            }
            AppMethodBeat.o(63643);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(63644);
            super.g(parcel);
            this.uYc = parcel.readInt();
            switch (this.uYc) {
                case 1:
                    this.uYe = WepkgRunCgi.n(parcel);
                    AppMethodBeat.o(63644);
                    return;
                case 2:
                    this.lqL = parcel.readInt();
                    this.lqz = parcel.readInt();
                    this.hxN = parcel.readString();
                    this.uYd = WepkgRunCgi.n(parcel);
                    break;
            }
            AppMethodBeat.o(63644);
        }

        RemoteCgiTask(Parcel parcel) {
            AppMethodBeat.i(63645);
            g(parcel);
            AppMethodBeat.o(63645);
        }

        static {
            AppMethodBeat.i(63646);
            AppMethodBeat.o(63646);
        }

        public final int a(int i, int i2, String str, b bVar, m mVar) {
            AppMethodBeat.i(63641);
            this.lqL = i;
            this.lqz = i2;
            this.hxN = str;
            this.uYd = bVar;
            this.uYc = 2;
            wM();
            AppMethodBeat.o(63641);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$1 */
    public static class AnonymousClass1 implements com.tencent.mm.ai.w.a {
        final /* synthetic */ a uYb;

        public AnonymousClass1(a aVar) {
            this.uYb = aVar;
        }

        public final int a(int i, int i2, String str, b bVar, m mVar) {
            AppMethodBeat.i(63638);
            if (this.uYb != null) {
                this.uYb.a(i, i2, str, bVar);
            }
            AppMethodBeat.o(63638);
            return 0;
        }
    }

    static b n(Parcel parcel) {
        AppMethodBeat.i(63647);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.fsJ = ((com.tencent.mm.bt.a) Class.forName(readString).newInstance()).parseFrom(bArr);
        } catch (Exception e) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            aVar.fsK = ((com.tencent.mm.bt.a) Class.forName(readString2).newInstance()).parseFrom(bArr2);
        } catch (Exception e2) {
            if (e2 instanceof e.a.a.b) {
                try {
                    aVar.fsK = (com.tencent.mm.bt.a) Class.forName(readString2).newInstance();
                } catch (Exception e22) {
                    ab.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", bo.l(e22));
                }
            }
        }
        aVar.uri = parcel.readString();
        aVar.fsI = parcel.readInt();
        aVar.fsL = parcel.readInt();
        aVar.fsM = parcel.readInt();
        b acD = aVar.acD();
        AppMethodBeat.o(63647);
        return acD;
    }

    static /* synthetic */ void a(b bVar, Parcel parcel) {
        AppMethodBeat.i(63648);
        parcel.writeString(bVar.fsG.fsP.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = bVar.fsG.fsP.toByteArray();
        } catch (Exception e) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.fsH.fsP.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = bVar.fsH.fsP.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.fsI);
        parcel.writeInt(bVar.fsG.cmdId);
        parcel.writeInt(bVar.fsH.cmdId);
        AppMethodBeat.o(63648);
    }
}
