package com.tencent.p177mm.p612ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p178a.C1177f.C1175b;
import com.tencent.p177mm.sdk.platformtools.C23498az;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.chatting.gallery.g */
public final class C15656g {
    private C23498az fwL = new C23498az(1, "chatting-image-gallery-preload-loader");
    protected C1177f<String, Bitmap> mQK = new C26399b(4, new C156581(), getClass());
    public LinkedList<String> mQM = new LinkedList();
    private boolean mQO = false;
    private int mScrollState = 0;
    protected HashMap<String, Long> yVB = new HashMap();

    /* renamed from: com.tencent.mm.ui.chatting.gallery.g$a */
    public static final class C5340a {
        public static C15656g yVD = new C15656g();

        static {
            AppMethodBeat.m2504i(32162);
            AppMethodBeat.m2505o(32162);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.g$2 */
    class C156572 implements C1174a<String, Bitmap> {
        C156572() {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.g$1 */
    class C156581 implements C1175b<String, Bitmap> {
        C156581() {
        }

        /* renamed from: c */
        public final /* synthetic */ void mo4401c(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(32161);
            C15656g.this.yVB.remove((String) obj);
            AppMethodBeat.m2505o(32161);
        }
    }

    public C15656g() {
        AppMethodBeat.m2504i(32163);
        AppMethodBeat.m2505o(32163);
    }

    public final void bCH() {
        AppMethodBeat.m2504i(32164);
        this.mQK.mo4403a(new C156572());
        AppMethodBeat.m2505o(32164);
    }
}
