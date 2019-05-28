package com.tencent.p177mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C45176b;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService */
public final class AppBrandMusicClientService {
    public static AppBrandMusicClientService ikP = new AppBrandMusicClientService();
    public HashMap<String, C10622a> ikO = new HashMap();
    public volatile String ikQ = "";

    /* renamed from: com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService$StopBackgroundMusicTask */
    public static class StopBackgroundMusicTask extends MainProcessTask {
        public static final Creator<StopBackgroundMusicTask> CREATOR = new C106201();
        public String appId;

        /* renamed from: com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService$StopBackgroundMusicTask$1 */
        static class C106201 implements Creator<StopBackgroundMusicTask> {
            C106201() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopBackgroundMusicTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137827);
                StopBackgroundMusicTask stopBackgroundMusicTask = new StopBackgroundMusicTask(parcel);
                AppMethodBeat.m2505o(137827);
                return stopBackgroundMusicTask;
            }
        }

        public StopBackgroundMusicTask(Parcel parcel) {
            AppMethodBeat.m2504i(137828);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137828);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137829);
            C4990ab.m7416i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
            String str = C19601a.ikU.ikS;
            if (!C5046bo.isNullOrNil(str) && !str.equals(this.appId)) {
                C4990ab.m7417i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
                aCb();
                AppMethodBeat.m2505o(137829);
            } else if (C19601a.ikU.mo34807Cw(this.appId)) {
                if (C45176b.ail()) {
                    C4990ab.m7416i("MicroMsg.AppBrandMusicClientService", "stop music ok");
                } else {
                    C4990ab.m7412e("MicroMsg.AppBrandMusicClientService", "stop music fail");
                }
                aCb();
                AppMethodBeat.m2505o(137829);
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", str, this.appId);
                aCb();
                AppMethodBeat.m2505o(137829);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(137830);
            this.appId = parcel.readString();
            AppMethodBeat.m2505o(137830);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137831);
            parcel.writeString(this.appId);
            AppMethodBeat.m2505o(137831);
        }

        static {
            AppMethodBeat.m2504i(137832);
            AppMethodBeat.m2505o(137832);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService$IPCQueryPlaying */
    static class IPCQueryPlaying extends MainProcessTask {
        public static final Creator<IPCQueryPlaying> CREATOR = new C106211();
        private String ikR = null;
        private boolean isPlaying = false;

        /* renamed from: com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService$IPCQueryPlaying$1 */
        static class C106211 implements Creator<IPCQueryPlaying> {
            C106211() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IPCQueryPlaying[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137821);
                IPCQueryPlaying iPCQueryPlaying = new IPCQueryPlaying(parcel);
                AppMethodBeat.m2505o(137821);
                return iPCQueryPlaying;
            }
        }

        IPCQueryPlaying() {
        }

        IPCQueryPlaying(Parcel parcel) {
            AppMethodBeat.m2504i(137822);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137822);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(137824);
            this.ikR = parcel.readString();
            this.isPlaying = parcel.readByte() != (byte) 0;
            AppMethodBeat.m2505o(137824);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137825);
            parcel.writeString(this.ikR);
            parcel.writeByte((byte) (this.isPlaying ? 1 : 0));
            AppMethodBeat.m2505o(137825);
        }

        static {
            AppMethodBeat.m2504i(137826);
            AppMethodBeat.m2505o(137826);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137823);
            this.isPlaying = C19601a.ikU.mo34807Cw(this.ikR);
            AppMethodBeat.m2505o(137823);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService$a */
    public interface C10622a {
        void awG();

        void onStop();
    }

    static {
        AppMethodBeat.m2504i(137835);
        AppMethodBeat.m2505o(137835);
    }

    private AppBrandMusicClientService() {
        AppMethodBeat.m2504i(137833);
        AppMethodBeat.m2505o(137833);
    }

    /* renamed from: Cu */
    public static boolean m18308Cu(String str) {
        AppMethodBeat.m2504i(137834);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(137834);
            return false;
        }
        MainProcessTask iPCQueryPlaying = new IPCQueryPlaying();
        iPCQueryPlaying.ikR = str;
        if (AppBrandMainProcessService.m54355b(iPCQueryPlaying)) {
            boolean a = iPCQueryPlaying.isPlaying;
            AppMethodBeat.m2505o(137834);
            return a;
        }
        AppMethodBeat.m2505o(137834);
        return false;
    }
}
