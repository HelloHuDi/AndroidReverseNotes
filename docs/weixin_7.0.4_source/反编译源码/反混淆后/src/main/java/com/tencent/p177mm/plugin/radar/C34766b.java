package com.tencent.p177mm.plugin.radar;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.radar.p489ui.C46915b.C34778a;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.b */
public final class C34766b implements C1816at {
    private static final String TAG = TAG;
    public static final C21555a pAH = new C21555a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/SubCoreRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b$a */
    public static final class C21555a {
        private C21555a() {
        }

        public /* synthetic */ C21555a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016J*\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.b$b */
    public static final class C28787b implements C14947a {
        private Bitmap cdX;
        private Bitmap pAI;
        private final C6294h<String, WeakReference<Bitmap>> pAJ = new C6294h(15);

        C28787b() {
            AppMethodBeat.m2504i(102858);
            AppMethodBeat.m2505o(102858);
        }

        /* renamed from: a */
        public final void mo8230a(C46507i c46507i) {
            AppMethodBeat.m2504i(102852);
            C25052j.m39376p(c46507i, "drawable");
            if (c46507i instanceof C8915a) {
                C17884o.acd().mo67498a((C8915a) c46507i);
            }
            AppMethodBeat.m2505o(102852);
        }

        /* renamed from: cQ */
        public final Bitmap mo8232cQ(String str) {
            Bitmap bitmap;
            AppMethodBeat.m2504i(102853);
            C25052j.m39376p(str, "tag");
            WeakReference weakReference = (WeakReference) this.pAJ.get(str);
            if (!(weakReference == null || weakReference.get() == null)) {
                Object obj = weakReference.get();
                if (obj == null) {
                    C44941v c44941v = new C44941v("null cannot be cast to non-null type android.graphics.Bitmap");
                    AppMethodBeat.m2505o(102853);
                    throw c44941v;
                } else if (!((Bitmap) obj).isRecycled() && (C25052j.m39373j((Bitmap) weakReference.get(), mo8229AZ()) ^ 1) == 0) {
                    bitmap = (Bitmap) weakReference.get();
                    AppMethodBeat.m2505o(102853);
                    return bitmap;
                }
            }
            bitmap = C41730b.m73504pW(str);
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = cdw();
            } else {
                bitmap = C5056d.m7616a(bitmap, false, (float) (bitmap.getWidth() / 2));
                this.pAJ.mo4412k(str, new WeakReference(bitmap));
            }
            AppMethodBeat.m2505o(102853);
            return bitmap;
        }

        /* renamed from: AZ */
        public final Bitmap mo8229AZ() {
            AppMethodBeat.m2504i(102854);
            if (this.cdX == null) {
                try {
                    Context context = C4996ah.getContext();
                    C25052j.m39375o(context, "MMApplicationContext.getContext()");
                    this.cdX = C4977b.m7370a(context.getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
                } catch (IOException e) {
                    C4990ab.printErrStackTrace(C34766b.TAG, e, "", new Object[0]);
                }
            }
            Bitmap bitmap = this.cdX;
            AppMethodBeat.m2505o(102854);
            return bitmap;
        }

        private Bitmap cdw() {
            Bitmap bitmap;
            AppMethodBeat.m2504i(102855);
            if (this.pAI == null && mo8229AZ() != null) {
                try {
                    bitmap = this.cdX;
                    Bitmap bitmap2 = this.cdX;
                    if (bitmap2 == null) {
                        C25052j.dWJ();
                    }
                    this.pAI = C5056d.m7616a(bitmap, false, (float) (bitmap2.getWidth() / 2));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace(C34766b.TAG, e, "", new Object[0]);
                }
            }
            bitmap = this.pAI;
            AppMethodBeat.m2505o(102855);
            return bitmap;
        }

        /* renamed from: cR */
        public final Bitmap mo8233cR(String str) {
            AppMethodBeat.m2504i(102856);
            C25052j.m39376p(str, "tag");
            AppMethodBeat.m2505o(102856);
            return null;
        }

        /* renamed from: b */
        public final Bitmap mo8231b(String str, int i, int i2, int i3) {
            AppMethodBeat.m2504i(102857);
            C25052j.m39376p(str, "tag");
            AppMethodBeat.m2505o(102857);
            return null;
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(102859);
        C34778a c34778a = C34778a.pCd;
        C34778a.m57121a(new C28787b());
        AppMethodBeat.m2505o(102859);
    }

    public final void onAccountRelease() {
    }

    static {
        AppMethodBeat.m2504i(102860);
        AppMethodBeat.m2505o(102860);
    }
}
