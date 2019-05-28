package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class AppBrandMusicClientService {
    public static AppBrandMusicClientService ikP = new AppBrandMusicClientService();
    public HashMap<String, a> ikO = new HashMap();
    public volatile String ikQ = "";

    public static class StopBackgroundMusicTask extends MainProcessTask {
        public static final Creator<StopBackgroundMusicTask> CREATOR = new Creator<StopBackgroundMusicTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopBackgroundMusicTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137827);
                StopBackgroundMusicTask stopBackgroundMusicTask = new StopBackgroundMusicTask(parcel);
                AppMethodBeat.o(137827);
                return stopBackgroundMusicTask;
            }
        };
        public String appId;

        public StopBackgroundMusicTask(Parcel parcel) {
            AppMethodBeat.i(137828);
            g(parcel);
            AppMethodBeat.o(137828);
        }

        public final void asP() {
            AppMethodBeat.i(137829);
            ab.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
            String str = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
            if (!bo.isNullOrNil(str) && !str.equals(this.appId)) {
                ab.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
                aCb();
                AppMethodBeat.o(137829);
            } else if (com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.Cw(this.appId)) {
                if (b.ail()) {
                    ab.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
                } else {
                    ab.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
                }
                aCb();
                AppMethodBeat.o(137829);
            } else {
                ab.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", str, this.appId);
                aCb();
                AppMethodBeat.o(137829);
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(137830);
            this.appId = parcel.readString();
            AppMethodBeat.o(137830);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137831);
            parcel.writeString(this.appId);
            AppMethodBeat.o(137831);
        }

        static {
            AppMethodBeat.i(137832);
            AppMethodBeat.o(137832);
        }
    }

    static class IPCQueryPlaying extends MainProcessTask {
        public static final Creator<IPCQueryPlaying> CREATOR = new Creator<IPCQueryPlaying>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IPCQueryPlaying[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137821);
                IPCQueryPlaying iPCQueryPlaying = new IPCQueryPlaying(parcel);
                AppMethodBeat.o(137821);
                return iPCQueryPlaying;
            }
        };
        private String ikR = null;
        private boolean isPlaying = false;

        IPCQueryPlaying() {
        }

        IPCQueryPlaying(Parcel parcel) {
            AppMethodBeat.i(137822);
            g(parcel);
            AppMethodBeat.o(137822);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(137824);
            this.ikR = parcel.readString();
            this.isPlaying = parcel.readByte() != (byte) 0;
            AppMethodBeat.o(137824);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137825);
            parcel.writeString(this.ikR);
            parcel.writeByte((byte) (this.isPlaying ? 1 : 0));
            AppMethodBeat.o(137825);
        }

        static {
            AppMethodBeat.i(137826);
            AppMethodBeat.o(137826);
        }

        public final void asP() {
            AppMethodBeat.i(137823);
            this.isPlaying = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.Cw(this.ikR);
            AppMethodBeat.o(137823);
        }
    }

    public interface a {
        void awG();

        void onStop();
    }

    static {
        AppMethodBeat.i(137835);
        AppMethodBeat.o(137835);
    }

    private AppBrandMusicClientService() {
        AppMethodBeat.i(137833);
        AppMethodBeat.o(137833);
    }

    public static boolean Cu(String str) {
        AppMethodBeat.i(137834);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(137834);
            return false;
        }
        MainProcessTask iPCQueryPlaying = new IPCQueryPlaying();
        iPCQueryPlaying.ikR = str;
        if (AppBrandMainProcessService.b(iPCQueryPlaying)) {
            boolean a = iPCQueryPlaying.isPlaying;
            AppMethodBeat.o(137834);
            return a;
        }
        AppMethodBeat.o(137834);
        return false;
    }
}
