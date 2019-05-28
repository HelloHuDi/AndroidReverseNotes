package com.tencent.p177mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.launching.p905a.C33430a;
import com.tencent.p177mm.plugin.appbrand.launching.p905a.C33431b;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.protocal.protobuf.cwf;
import com.tencent.p177mm.protocal.protobuf.cxj;
import com.tencent.p177mm.protocal.protobuf.cyb;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder */
public final class AppBrandTaskUsageRecorder {

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder$LaunchCheckParams */
    public static final class LaunchCheckParams implements Parcelable {
        public static final Creator<LaunchCheckParams> CREATOR = new C23731();
        final String bQd;
        final int gVu;
        final int hCY;
        final QualitySession hgN;
        final boolean hop = true;
        final AppBrandInitConfigWC igx;
        final AppBrandStatObject igy;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder$LaunchCheckParams$1 */
        static class C23731 implements Creator<LaunchCheckParams> {
            C23731() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchCheckParams[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131760);
                LaunchCheckParams launchCheckParams = new LaunchCheckParams(parcel);
                AppMethodBeat.m2505o(131760);
                return launchCheckParams;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131761);
            parcel.writeParcelable(this.igx, i);
            parcel.writeParcelable(this.igy, i);
            parcel.writeInt(this.gVu);
            parcel.writeInt(this.hCY);
            parcel.writeString(this.bQd);
            parcel.writeParcelable(this.hgN, i);
            AppMethodBeat.m2505o(131761);
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
            AppMethodBeat.m2504i(131762);
            this.igx = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            this.igy = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.gVu = parcel.readInt();
            this.hCY = parcel.readInt();
            this.bQd = parcel.readString();
            this.hgN = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
            AppMethodBeat.m2505o(131762);
        }

        static {
            AppMethodBeat.m2504i(131763);
            AppMethodBeat.m2505o(131763);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder$UpdateTask */
    public static final class UpdateTask extends MainProcessTask {
        public static final Creator<UpdateTask> CREATOR = new C313161();
        LaunchCheckParams igz;

        /* renamed from: com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder$UpdateTask$1 */
        static class C313161 implements Creator<UpdateTask> {
            C313161() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new UpdateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131764);
                UpdateTask updateTask = new UpdateTask(parcel);
                AppMethodBeat.m2505o(131764);
                return updateTask;
            }
        }

        public final void asP() {
            AppMethodBeat.m2504i(131765);
            if (!C1720g.m3534RN().eJb || C1668a.m3393QT()) {
                AppMethodBeat.m2505o(131765);
                return;
            }
            this.igz.getClass();
            AppBrandLaunchReferrer appBrandLaunchReferrer = this.igz.igx.hgF;
            cyb b = C33431b.m54639b(appBrandLaunchReferrer);
            cxj c = C33431b.m54640c(appBrandLaunchReferrer);
            cwf cwf = new cwf();
            cwf.wzF = this.igz.igx.gVs;
            cwf.vMG = this.igz.gVu;
            cwf.Scene = this.igz.igy.scene;
            cwf.wDB = this.igz.igx.hgC;
            cwf.wDA = 1;
            cwf.wDz = this.igz.igy.cOq;
            new C33430a(this.igz.igx.appId, false, cwf, b, c, this.igz.bQd, this.igz.hCY, this.igz.hgN).aHF();
            AppMethodBeat.m2505o(131765);
        }

        public UpdateTask(LaunchCheckParams launchCheckParams) {
            this.igz = launchCheckParams;
        }

        UpdateTask(Parcel parcel) {
            AppMethodBeat.m2504i(131766);
            mo6032g(parcel);
            AppMethodBeat.m2505o(131766);
        }

        public final int describeContents() {
            return 0;
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(131767);
            this.igz = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
            AppMethodBeat.m2505o(131767);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(131768);
            parcel.writeParcelable(this.igz, i);
            AppMethodBeat.m2505o(131768);
        }

        static {
            AppMethodBeat.m2504i(131769);
            AppMethodBeat.m2505o(131769);
        }
    }
}
