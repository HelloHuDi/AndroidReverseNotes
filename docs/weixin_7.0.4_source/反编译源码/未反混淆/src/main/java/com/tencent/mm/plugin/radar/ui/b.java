package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.i;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"})
public final class b extends i implements com.tencent.mm.ah.d.a {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"})
    public static final class a {
        private static com.tencent.mm.pluginsdk.ui.i.a pCc;
        public static final a pCd = new a();

        static {
            AppMethodBeat.i(102943);
            AppMethodBeat.o(102943);
        }

        private a() {
        }

        public static com.tencent.mm.pluginsdk.ui.i.a cdE() {
            return pCc;
        }

        public static void a(com.tencent.mm.pluginsdk.ui.i.a aVar) {
            AppMethodBeat.i(102941);
            j.p(aVar, "loader");
            pCc = aVar;
            AppMethodBeat.o(102941);
        }

        public static void b(ImageView imageView, String str) {
            b bVar;
            AppMethodBeat.i(102942);
            j.p(imageView, "iv");
            j.p(str, "tag");
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str, (byte) 0);
            } else {
                bVar = (b) drawable;
            }
            bVar.setTag(str);
            imageView.setImageDrawable(bVar);
            AppMethodBeat.o(102942);
        }
    }

    public /* synthetic */ b(String str, byte b) {
        this(str);
    }

    private b(String str) {
        a aVar = a.pCd;
        super(a.cdE(), str);
        AppMethodBeat.i(102945);
        AppMethodBeat.o(102945);
    }

    public final void qj(String str) {
        AppMethodBeat.i(102944);
        j.p(str, "tag");
        super.qj(str);
        AppMethodBeat.o(102944);
    }
}
