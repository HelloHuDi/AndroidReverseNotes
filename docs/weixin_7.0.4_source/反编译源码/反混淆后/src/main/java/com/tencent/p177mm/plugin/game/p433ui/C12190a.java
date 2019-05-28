package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1177f.C1174a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.a */
public abstract class C12190a<T> extends BaseAdapter {
    private static int nec = 500;
    protected Context mContext;
    protected LinkedList<T> mYj;
    private C12193a ndZ;
    protected boolean nea = false;
    private C1177f<String, Bitmap> neb;
    private C7564ap ned = new C7564ap(new C121912(), false);
    private final C4931a nee = new C121923();

    /* renamed from: com.tencent.mm.plugin.game.ui.a$2 */
    class C121912 implements C5015a {
        C121912() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(111696);
            C12190a.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(111696);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.a$3 */
    class C121923 implements C4931a {
        C121923() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(111697);
            C12190a.this.ned.stopTimer();
            long access$100 = (long) C12190a.nec;
            C12190a.this.ned.mo16770ae(access$100, access$100);
            AppMethodBeat.m2505o(111697);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.a$a */
    public interface C12193a {
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.a$1 */
    class C121941 implements C1174a<String, Bitmap> {
        C121941() {
        }
    }

    public C12190a(Context context) {
        this.mContext = context;
        this.mYj = new LinkedList();
        this.neb = new C26399b(20, getClass());
        C34832a.bYJ().mo10116c(this.nee);
    }

    /* renamed from: Y */
    public void mo24020Y(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.mYj.addAll(linkedList);
            if (this.ndZ != null) {
                this.mYj.size();
            }
            super.notifyDataSetChanged();
        } else if (this.ndZ != null) {
            this.mYj.size();
        }
    }

    /* renamed from: Z */
    public void mo24021Z(LinkedList<T> linkedList) {
        if (linkedList != null) {
            this.mYj = linkedList;
            if (this.ndZ != null) {
                this.mYj.size();
            }
            super.notifyDataSetChanged();
        } else if (this.ndZ != null) {
            this.mYj.size();
        }
    }

    public void clear() {
        if (this.mYj != null) {
            this.mYj.clear();
        }
        if (this.neb != null) {
            this.neb.mo4403a(new C121941());
        }
        this.neb = null;
        C34832a.bYJ().mo10117d(this.nee);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Oi */
    public final Bitmap mo24019Oi(String str) {
        if (C5046bo.isNullOrNil(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.neb.mo4405aj(str)) {
            bitmap = (Bitmap) this.neb.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = C46494g.m87732b(str, 1, C1338a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.neb.mo4412k(str, bitmap);
        return bitmap;
    }

    public int getCount() {
        return this.mYj.size();
    }

    public Object getItem(int i) {
        return this.mYj.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
