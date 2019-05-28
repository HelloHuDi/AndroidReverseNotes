package com.tencent.mm.plugin.radar;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/radar/SubCoreRadar;", "Lcom/tencent/mm/model/ISubCore;", "()V", "clearPluginData", "", "pluginFlag", "", "doRadar", "getBaseDBFactories", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "onAccountPostReset", "updated", "", "onAccountRelease", "onSdcardMount", "mounted", "Companion", "plugin-radar_release"})
public final class b implements at {
    private static final String TAG = TAG;
    public static final a pAH = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/SubCoreRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016J*\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, dWq = {"com/tencent/mm/plugin/radar/SubCoreRadar$onAccountPostReset$1", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "defaultBitmap", "Landroid/graphics/Bitmap;", "defaultBitmapRoundCorner", "mAvatarBitmapCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Ljava/lang/ref/WeakReference;", "getDefaultBitmap", "getDefaultBitmapRoundCorner", "loadBitmap", "tag", "loadFromCache", "loadHdBitmap", "width", "", "height", "customFillet", "watch", "", "drawable", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "plugin-radar_release"})
    public static final class b implements com.tencent.mm.pluginsdk.ui.i.a {
        private Bitmap cdX;
        private Bitmap pAI;
        private final h<String, WeakReference<Bitmap>> pAJ = new h(15);

        b() {
            AppMethodBeat.i(102858);
            AppMethodBeat.o(102858);
        }

        public final void a(i iVar) {
            AppMethodBeat.i(102852);
            j.p(iVar, "drawable");
            if (iVar instanceof com.tencent.mm.ah.d.a) {
                o.acd().a((com.tencent.mm.ah.d.a) iVar);
            }
            AppMethodBeat.o(102852);
        }

        public final Bitmap cQ(String str) {
            Bitmap bitmap;
            AppMethodBeat.i(102853);
            j.p(str, "tag");
            WeakReference weakReference = (WeakReference) this.pAJ.get(str);
            if (!(weakReference == null || weakReference.get() == null)) {
                Object obj = weakReference.get();
                if (obj == null) {
                    v vVar = new v("null cannot be cast to non-null type android.graphics.Bitmap");
                    AppMethodBeat.o(102853);
                    throw vVar;
                } else if (!((Bitmap) obj).isRecycled() && (j.j((Bitmap) weakReference.get(), AZ()) ^ 1) == 0) {
                    bitmap = (Bitmap) weakReference.get();
                    AppMethodBeat.o(102853);
                    return bitmap;
                }
            }
            bitmap = com.tencent.mm.ah.b.pW(str);
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = cdw();
            } else {
                bitmap = d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
                this.pAJ.k(str, new WeakReference(bitmap));
            }
            AppMethodBeat.o(102853);
            return bitmap;
        }

        public final Bitmap AZ() {
            AppMethodBeat.i(102854);
            if (this.cdX == null) {
                try {
                    Context context = ah.getContext();
                    j.o(context, "MMApplicationContext.getContext()");
                    this.cdX = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
                } catch (IOException e) {
                    ab.printErrStackTrace(b.TAG, e, "", new Object[0]);
                }
            }
            Bitmap bitmap = this.cdX;
            AppMethodBeat.o(102854);
            return bitmap;
        }

        private Bitmap cdw() {
            Bitmap bitmap;
            AppMethodBeat.i(102855);
            if (this.pAI == null && AZ() != null) {
                try {
                    bitmap = this.cdX;
                    Bitmap bitmap2 = this.cdX;
                    if (bitmap2 == null) {
                        j.dWJ();
                    }
                    this.pAI = d.a(bitmap, false, (float) (bitmap2.getWidth() / 2));
                } catch (Exception e) {
                    ab.printErrStackTrace(b.TAG, e, "", new Object[0]);
                }
            }
            bitmap = this.pAI;
            AppMethodBeat.o(102855);
            return bitmap;
        }

        public final Bitmap cR(String str) {
            AppMethodBeat.i(102856);
            j.p(str, "tag");
            AppMethodBeat.o(102856);
            return null;
        }

        public final Bitmap b(String str, int i, int i2, int i3) {
            AppMethodBeat.i(102857);
            j.p(str, "tag");
            AppMethodBeat.o(102857);
            return null;
        }
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(102859);
        com.tencent.mm.plugin.radar.ui.b.a aVar = com.tencent.mm.plugin.radar.ui.b.a.pCd;
        com.tencent.mm.plugin.radar.ui.b.a.a(new b());
        AppMethodBeat.o(102859);
    }

    public final void onAccountRelease() {
    }

    static {
        AppMethodBeat.i(102860);
        AppMethodBeat.o(102860);
    }
}
