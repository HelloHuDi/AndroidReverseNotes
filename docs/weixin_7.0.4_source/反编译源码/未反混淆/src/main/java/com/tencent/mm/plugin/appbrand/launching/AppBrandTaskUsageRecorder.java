package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cyb;

public final class AppBrandTaskUsageRecorder {

    public static final class LaunchCheckParams implements Parcelable {
        public static final Creator<LaunchCheckParams> CREATOR = new Creator<LaunchCheckParams>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchCheckParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131760);
                LaunchCheckParams launchCheckParams = new LaunchCheckParams(parcel);
                AppMethodBeat.o(131760);
                return launchCheckParams;
            }
        };
        final String bQd;
        final int gVu;
        final int hCY;
        final QualitySession hgN;
        final boolean hop = true;
        final AppBrandInitConfigWC igx;
        final AppBrandStatObject igy;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131761);
            parcel.writeParcelable(this.igx, i);
            parcel.writeParcelable(this.igy, i);
            parcel.writeInt(this.gVu);
            parcel.writeInt(this.hCY);
            parcel.writeString(this.bQd);
            parcel.writeParcelable(this.hgN, i);
            AppMethodBeat.o(131761);
        }

        public LaunchCheckParams(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i, int i2, String str, QualitySession qualitySession) {
            this.igx = appBrandInitConfigWC;
            this.igy = appBrandStatObject;
            this.gVu = i;
            this.hCY = i2;
            this.bQd = str;
            this.hgN = qualitySession;
        }

        LaunchCheckParams(Parcel parcel) {
            AppMethodBeat.i(131762);
            this.igx = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            this.igy = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.gVu = parcel.readInt();
            this.hCY = parcel.readInt();
            this.bQd = parcel.readString();
            this.hgN = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
            AppMethodBeat.o(131762);
        }

        static {
            AppMethodBeat.i(131763);
            AppMethodBeat.o(131763);
        }
    }

    public static final class UpdateTask extends MainProcessTask {
        public static final Creator<UpdateTask> CREATOR = new Creator<UpdateTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UpdateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131764);
                UpdateTask updateTask = new UpdateTask(parcel);
                AppMethodBeat.o(131764);
                return updateTask;
            }
        };
        LaunchCheckParams igz;

        public final void asP() {
            AppMethodBeat.i(131765);
            if (!g.RN().eJb || a.QT()) {
                AppMethodBeat.o(131765);
                return;
            }
            this.igz.getClass();
            AppBrandLaunchReferrer appBrandLaunchReferrer = this.igz.igx.hgF;
            cyb b = b.b(appBrandLaunchReferrer);
            cxj c = b.c(appBrandLaunchReferrer);
            cwf cwf = new cwf();
            cwf.wzF = this.igz.igx.gVs;
            cwf.vMG = this.igz.gVu;
            cwf.Scene = this.igz.igy.scene;
            cwf.wDB = this.igz.igx.hgC;
            cwf.wDA = 1;
            cwf.wDz = this.igz.igy.cOq;
            new com.tencent.mm.plugin.appbrand.launching.a.a(this.igz.igx.appId, false, cwf, b, c, this.igz.bQd, this.igz.hCY, this.igz.hgN).aHF();
            AppMethodBeat.o(131765);
        }

        public UpdateTask(LaunchCheckParams launchCheckParams) {
            this.igz = launchCheckParams;
        }

        UpdateTask(Parcel parcel) {
            AppMethodBeat.i(131766);
            g(parcel);
            AppMethodBeat.o(131766);
        }

        public final int describeContents() {
            return 0;
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(131767);
            this.igz = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
            AppMethodBeat.o(131767);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131768);
            parcel.writeParcelable(this.igz, i);
            AppMethodBeat.o(131768);
        }

        static {
            AppMethodBeat.i(131769);
            AppMethodBeat.o(131769);
        }
    }
}
