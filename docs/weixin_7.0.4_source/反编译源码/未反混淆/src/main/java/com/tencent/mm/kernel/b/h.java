package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;

public final class h extends g {
    public a<ApplicationLifeCycle> eMA = new a();
    public ApplicationLike eMz;
    public d ecL;
    public e mProfileCompat;

    /* renamed from: com.tencent.mm.kernel.b.h$3 */
    public class AnonymousClass3 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ int eMC;

        public AnonymousClass3(int i) {
            this.eMC = i;
        }

        public final /* synthetic */ void ax(Object obj) {
            AppMethodBeat.i(58076);
            ((ApplicationLifeCycle) obj).onTrimMemory(this.eMC);
            AppMethodBeat.o(58076);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$5 */
    public class AnonymousClass5 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ Configuration eMD;

        public AnonymousClass5(Configuration configuration) {
            this.eMD = configuration;
        }

        public final /* synthetic */ void ax(Object obj) {
            AppMethodBeat.i(58078);
            ((ApplicationLifeCycle) obj).onConfigurationChanged(this.eMD);
            AppMethodBeat.o(58078);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b.h$6 */
    public class AnonymousClass6 implements a.a<ApplicationLifeCycle> {
        final /* synthetic */ Context val$context;

        public AnonymousClass6(Context context) {
            this.val$context = context;
        }

        public final /* synthetic */ void ax(Object obj) {
            AppMethodBeat.i(58079);
            ((ApplicationLifeCycle) obj).onBaseContextAttached(this.val$context);
            AppMethodBeat.o(58079);
        }
    }

    public final String getPackageName() {
        AppMethodBeat.i(139006);
        String packageName = ah.getPackageName();
        AppMethodBeat.o(139006);
        return packageName;
    }

    public h(String str, Application application, ApplicationLike applicationLike) {
        super(str, application);
        AppMethodBeat.i(58081);
        ah.ce(str);
        this.eMz = applicationLike;
        AppMethodBeat.o(58081);
    }

    public final void onCreate() {
        AppMethodBeat.i(58082);
        this.eMA.a(new a.a<ApplicationLifeCycle>() {
            public final /* synthetic */ void ax(Object obj) {
                AppMethodBeat.i(58074);
                ((ApplicationLifeCycle) obj).onCreate();
                AppMethodBeat.o(58074);
            }
        });
        AppMethodBeat.o(58082);
    }
}
