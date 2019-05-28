package com.tencent.mm.ui.chatting.k.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static volatile a yZL = null;
    private static final al yZM = new al();

    enum a implements com.tencent.mm.ui.widget.MMTextView.a {
        ;

        private a(String str) {
        }

        static {
            AppMethodBeat.o(32676);
        }

        public final void a(CharSequence charSequence, long j) {
            AppMethodBeat.i(32675);
            bi jf = ((j) g.K(j.class)).bOr().jf(j);
            if (bo.isNullOrNil(jf.field_talker)) {
                ab.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", Long.valueOf(j));
                AppMethodBeat.o(32675);
            } else if ((jf.field_flag & 16) == 0) {
                a.b(charSequence, jf);
                AppMethodBeat.o(32675);
            } else {
                ab.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", Long.valueOf(j));
                AppMethodBeat.o(32675);
            }
        }
    }

    static class b implements Runnable {
        private bi csG;
        private int scene;
        private CharSequence text;

        static class a {

            static class a implements b {
                private a() {
                }

                /* synthetic */ a(byte b) {
                    this();
                }

                public final c a(Object obj, Spannable spannable) {
                    String bc;
                    AppMethodBeat.i(32677);
                    String substring = spannable.toString().substring(spannable.getSpanStart(obj), spannable.getSpanEnd(obj));
                    try {
                        bc = bo.bc(new JSONObject(obj.toString()).optString("type"), obj.getClass().getName());
                    } catch (JSONException e) {
                        bc = obj.getClass().getName();
                    }
                    c cVar = new c(substring, bc);
                    AppMethodBeat.o(32677);
                    return cVar;
                }
            }
        }

        interface b {
            c a(Object obj, Spannable spannable);
        }

        static class c {
            String extInfo;
            String text;

            c(String str, String str2) {
                this.text = str;
                this.extInfo = str2;
            }
        }

        b(CharSequence charSequence, bi biVar, int i) {
            this.text = charSequence;
            this.csG = biVar;
            this.scene = i;
        }

        public final void run() {
            AppMethodBeat.i(32678);
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
                            if (obj != null && com.tencent.mm.plugin.normsg.a.b.oTO.c(obj, n.class)) {
                                arrayList.add(new a().a(obj, spannable));
                            }
                        }
                    }
                    if (!(arrayList == null || arrayList.size() == 0)) {
                        this.csG = ((j) g.K(j.class)).bOr().jf(this.csG.field_msgId);
                        if (!(this.csG == null || bo.isNullOrNil(this.csG.field_talker))) {
                            this.csG.hY(this.csG.field_flag | 16);
                            ((j) g.K(j.class)).bOr().a(this.csG.field_msgId, this.csG);
                        }
                        aw.ZK().Ym().aaV();
                        aw.ZK().Ym().b(com.tencent.mm.model.b.b.b.Chatting);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = ((c) it.next()).extInfo;
                            h.pYm.e(14237, "msg", Long.valueOf(this.csG.field_msgId), Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), str);
                            h.pYm.a(587, 0, 1, false);
                        }
                    }
                    AppMethodBeat.o(32678);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(32678);
        }
    }

    static /* synthetic */ void b(CharSequence charSequence, bi biVar) {
        AppMethodBeat.i(32682);
        a(charSequence, biVar, 0);
        AppMethodBeat.o(32682);
    }

    static {
        AppMethodBeat.i(32683);
        AppMethodBeat.o(32683);
    }

    private a() {
    }

    public static a dHa() {
        AppMethodBeat.i(32679);
        a aVar;
        if (yZL == null) {
            synchronized (a.class) {
                try {
                    if (yZL == null) {
                        yZL = new a();
                    }
                    aVar = yZL;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(32679);
                }
            }
            return aVar;
        }
        aVar = yZL;
        AppMethodBeat.o(32679);
        return aVar;
    }

    public static com.tencent.mm.ui.widget.MMTextView.a dHb() {
        return a.yZN;
    }

    private static void a(CharSequence charSequence, bi biVar, int i) {
        AppMethodBeat.i(32680);
        if (charSequence instanceof Spannable) {
            yZM.aa(new b(charSequence, biVar, i));
        }
        AppMethodBeat.o(32680);
    }

    public static void a(CharSequence charSequence, bi biVar) {
        AppMethodBeat.i(32681);
        a(charSequence, biVar, 1);
        AppMethodBeat.o(32681);
    }
}
