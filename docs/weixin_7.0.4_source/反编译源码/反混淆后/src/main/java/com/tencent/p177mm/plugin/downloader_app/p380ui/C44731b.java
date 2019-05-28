package com.tencent.p177mm.plugin.downloader_app.p380ui;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.plugin.downloader_app.p377b.C20339h;
import com.tencent.p177mm.plugin.downloader_app.p377b.C38861i;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader_app.ui.b */
public final class C44731b extends C41523a<C44732a> {
    C20339h<C38861i> kQR = new C20339h();
    private boolean kQS = true;
    private boolean kQT = false;
    private boolean kQU = false;
    private boolean kQV = false;
    boolean kQW = false;
    boolean kQX = true;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.b$1 */
    class C277251 implements Runnable {
        C277251() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136281);
            C44731b.this.aop.notifyChanged();
            AppMethodBeat.m2505o(136281);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.b$3 */
    class C277263 implements Runnable {
        C277263() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136283);
            C44731b.this.aop.notifyChanged();
            AppMethodBeat.m2505o(136283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.ui.b$a */
    public static class C44732a extends C41531v {
        public View contentView;

        public C44732a(View view) {
            super(view);
            AppMethodBeat.m2504i(136284);
            this.contentView = ((ViewGroup) view).getChildAt(0);
            AppMethodBeat.m2505o(136284);
        }
    }

    public C44731b(Context context) {
        AppMethodBeat.m2504i(136285);
        this.mContext = context;
        AppMethodBeat.m2505o(136285);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(136286);
        int i2 = ((C38861i) this.kQR.get(i)).type;
        AppMethodBeat.m2505o(136286);
        return i2;
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(136287);
        int size = this.kQR.size();
        AppMethodBeat.m2505o(136287);
        return size;
    }

    /* renamed from: P */
    public final void mo71808P(LinkedList<C38861i> linkedList) {
        AppMethodBeat.m2504i(136288);
        if (C5046bo.m7548ek(linkedList)) {
            AppMethodBeat.m2505o(136288);
        } else if (linkedList.size() == 1) {
            final int indexOf = this.kQR.indexOf(linkedList.get(0));
            this.kQR.remove(indexOf);
            C18514l.m28819q(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(136282);
                    C44731b.this.mo66318ci(indexOf);
                    AppMethodBeat.m2505o(136282);
                }
            });
            AppMethodBeat.m2505o(136288);
        } else {
            this.kQR.removeAll(linkedList);
            C18514l.m28819q(new C277263());
            AppMethodBeat.m2505o(136288);
        }
    }

    public final boolean biL() {
        AppMethodBeat.m2504i(136289);
        if (this.kQR.size() <= 5) {
            AppMethodBeat.m2505o(136289);
            return true;
        }
        AppMethodBeat.m2505o(136289);
        return false;
    }
}
