package com.tencent.p177mm.p612ui.chatting.p620k.p621a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p871b.C45437b.C9646b;
import com.tencent.p177mm.p612ui.widget.MMTextView.C15987a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23322n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.ui.chatting.k.a.a */
public class C5346a {
    private static volatile C5346a yZL = null;
    private static final C5004al yZM = new C5004al();

    /* renamed from: com.tencent.mm.ui.chatting.k.a.a$a */
    enum C5347a implements C15987a {
        ;

        private C5347a(String str) {
        }

        static {
            AppMethodBeat.m2505o(32676);
        }

        /* renamed from: a */
        public final void mo10976a(CharSequence charSequence, long j) {
            AppMethodBeat.m2504i(32675);
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
            if (C5046bo.isNullOrNil(jf.field_talker)) {
                C4990ab.m7421w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", Long.valueOf(j));
                AppMethodBeat.m2505o(32675);
            } else if ((jf.field_flag & 16) == 0) {
                C5346a.m8099b(charSequence, jf);
                AppMethodBeat.m2505o(32675);
            } else {
                C4990ab.m7419v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", Long.valueOf(j));
                AppMethodBeat.m2505o(32675);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.k.a.a$b */
    static class C5348b implements Runnable {
        private C7620bi csG;
        private int scene;
        private CharSequence text;

        /* renamed from: com.tencent.mm.ui.chatting.k.a.a$b$a */
        static class C5349a {

            /* renamed from: com.tencent.mm.ui.chatting.k.a.a$b$a$a */
            static class C5350a implements C5351b {
                private C5350a() {
                }

                /* synthetic */ C5350a(byte b) {
                    this();
                }

                /* renamed from: a */
                public final C5352c mo10978a(Object obj, Spannable spannable) {
                    String bc;
                    AppMethodBeat.m2504i(32677);
                    String substring = spannable.toString().substring(spannable.getSpanStart(obj), spannable.getSpanEnd(obj));
                    try {
                        bc = C5046bo.m7532bc(new JSONObject(obj.toString()).optString("type"), obj.getClass().getName());
                    } catch (JSONException e) {
                        bc = obj.getClass().getName();
                    }
                    C5352c c5352c = new C5352c(substring, bc);
                    AppMethodBeat.m2505o(32677);
                    return c5352c;
                }
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.k.a.a$b$b */
        interface C5351b {
            /* renamed from: a */
            C5352c mo10978a(Object obj, Spannable spannable);
        }

        /* renamed from: com.tencent.mm.ui.chatting.k.a.a$b$c */
        static class C5352c {
            String extInfo;
            String text;

            C5352c(String str, String str2) {
                this.text = str;
                this.extInfo = str2;
            }
        }

        C5348b(CharSequence charSequence, C7620bi c7620bi, int i) {
            this.text = charSequence;
            this.csG = c7620bi;
            this.scene = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(32678);
            if (this.text instanceof Spannable) {
                try {
                    Spannable spannable = (Spannable) this.text;
                    System.nanoTime();
                    Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
                    ArrayList arrayList = new ArrayList(1);
                    if (spans == null || spans.length == 0) {
                        arrayList = null;
                    } else {
                        for (Object obj : spans) {
                            if (obj != null && C6998b.oTO.mo8105c(obj, C23322n.class)) {
                                arrayList.add(new C5350a().mo10978a(obj, spannable));
                            }
                        }
                    }
                    if (!(arrayList == null || arrayList.size() == 0)) {
                        this.csG = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.csG.field_msgId);
                        if (!(this.csG == null || C5046bo.isNullOrNil(this.csG.field_talker))) {
                            this.csG.mo14783hY(this.csG.field_flag | 16);
                            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.csG.field_msgId, this.csG);
                        }
                        C9638aw.m17190ZK().mo33887Ym().aaV();
                        C9638aw.m17190ZK().mo33887Ym().mo73239b(C9646b.Chatting);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = ((C5352c) it.next()).extInfo;
                            C7060h.pYm.mo8381e(14237, "msg", Long.valueOf(this.csG.field_msgId), Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), str);
                            C7060h.pYm.mo8378a(587, 0, 1, false);
                        }
                    }
                    AppMethodBeat.m2505o(32678);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(32678);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m8099b(CharSequence charSequence, C7620bi c7620bi) {
        AppMethodBeat.m2504i(32682);
        C5346a.m8098a(charSequence, c7620bi, 0);
        AppMethodBeat.m2505o(32682);
    }

    static {
        AppMethodBeat.m2504i(32683);
        AppMethodBeat.m2505o(32683);
    }

    private C5346a() {
    }

    public static C5346a dHa() {
        AppMethodBeat.m2504i(32679);
        C5346a c5346a;
        if (yZL == null) {
            synchronized (C5346a.class) {
                try {
                    if (yZL == null) {
                        yZL = new C5346a();
                    }
                    c5346a = yZL;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(32679);
                }
            }
            return c5346a;
        }
        c5346a = yZL;
        AppMethodBeat.m2505o(32679);
        return c5346a;
    }

    public static C15987a dHb() {
        return C5347a.yZN;
    }

    /* renamed from: a */
    private static void m8098a(CharSequence charSequence, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(32680);
        if (charSequence instanceof Spannable) {
            yZM.mo10302aa(new C5348b(charSequence, c7620bi, i));
        }
        AppMethodBeat.m2505o(32680);
    }

    /* renamed from: a */
    public static void m8097a(CharSequence charSequence, C7620bi c7620bi) {
        AppMethodBeat.m2504i(32681);
        C5346a.m8098a(charSequence, c7620bi, 1);
        AppMethodBeat.m2505o(32681);
    }
}
