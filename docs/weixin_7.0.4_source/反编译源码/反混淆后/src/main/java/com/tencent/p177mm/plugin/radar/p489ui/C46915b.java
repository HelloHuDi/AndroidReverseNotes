package com.tencent.p177mm.plugin.radar.p489ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable;", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable;", "Lcom/tencent/mm/modelavatar/AvatarStorage$IOnAvatarChanged;", "tag", "", "(Ljava/lang/String;)V", "isCrop", "", "(Ljava/lang/String;Z)V", "notifyChanged", "", "Factory", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.ui.b */
public final class C46915b extends C46507i implements C8915a {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/radar/ui/RadarAvatarDrawable$Factory;", "", "()V", "aLoader", "Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "getALoader", "()Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;", "setALoader", "(Lcom/tencent/mm/pluginsdk/ui/LazyBitmapDrawable$BitmapLoader;)V", "attach", "", "iv", "Landroid/widget/ImageView;", "tag", "", "setLoader", "loader", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.ui.b$a */
    public static final class C34778a {
        private static C14947a pCc;
        public static final C34778a pCd = new C34778a();

        static {
            AppMethodBeat.m2504i(102943);
            AppMethodBeat.m2505o(102943);
        }

        private C34778a() {
        }

        public static C14947a cdE() {
            return pCc;
        }

        /* renamed from: a */
        public static void m57121a(C14947a c14947a) {
            AppMethodBeat.m2504i(102941);
            C25052j.m39376p(c14947a, "loader");
            pCc = c14947a;
            AppMethodBeat.m2505o(102941);
        }

        /* renamed from: b */
        public static void m57122b(ImageView imageView, String str) {
            C46915b c46915b;
            AppMethodBeat.m2504i(102942);
            C25052j.m39376p(imageView, "iv");
            C25052j.m39376p(str, "tag");
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof C46915b)) {
                c46915b = new C46915b(str, (byte) 0);
            } else {
                c46915b = (C46915b) drawable;
            }
            c46915b.setTag(str);
            imageView.setImageDrawable(c46915b);
            AppMethodBeat.m2505o(102942);
        }
    }

    public /* synthetic */ C46915b(String str, byte b) {
        this(str);
    }

    private C46915b(String str) {
        C34778a c34778a = C34778a.pCd;
        super(C34778a.cdE(), str);
        AppMethodBeat.m2504i(102945);
        AppMethodBeat.m2505o(102945);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(102944);
        C25052j.m39376p(str, "tag");
        super.mo20342qj(str);
        AppMethodBeat.m2505o(102944);
    }
}
