package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTagPanel;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44270d;
import com.tencent.p177mm.p612ui.base.MMTagPanel.C44799a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavTagPanel */
public class FavTagPanel extends MMTagPanel {
    private LinkedList<C44270d> mpZ = new LinkedList();
    private C20749a mqa = null;
    private OnClickListener mqb = new C390781();

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavTagPanel$a */
    public interface C20749a extends C44799a {
        /* renamed from: Mi */
        void mo36054Mi(String str);
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.FavTagPanel$1 */
    class C390781 implements OnClickListener {
        C390781() {
        }

        public final void onClick(final View view) {
            AppMethodBeat.m2504i(74707);
            if (((Integer) view.getTag()).intValue() == 0) {
                FavTagPanel.m66502a(FavTagPanel.this, (TextView) view);
                if (FavTagPanel.this.mqa != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(74705);
                            FavTagPanel.this.mqa;
                            ((TextView) view).getText().toString();
                            AppMethodBeat.m2505o(74705);
                        }
                    });
                    AppMethodBeat.m2505o(74707);
                    return;
                }
            }
            FavTagPanel.m66503b(FavTagPanel.this, (TextView) view);
            if (FavTagPanel.this.mqa != null) {
                view.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74706);
                        FavTagPanel.this.mqa.mo36054Mi(((TextView) view).getText().toString());
                        AppMethodBeat.m2505o(74706);
                    }
                });
            }
            AppMethodBeat.m2505o(74707);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m66502a(FavTagPanel favTagPanel, TextView textView) {
        AppMethodBeat.m2504i(74712);
        favTagPanel.mo71948a(textView, true, false);
        AppMethodBeat.m2505o(74712);
    }

    /* renamed from: b */
    static /* synthetic */ void m66503b(FavTagPanel favTagPanel, TextView textView) {
        AppMethodBeat.m2504i(74713);
        favTagPanel.mo71948a(textView, false, false);
        AppMethodBeat.m2505o(74713);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(74708);
        AppMethodBeat.m2505o(74708);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(74709);
        AppMethodBeat.m2505o(74709);
    }

    public void setCallBack(C20749a c20749a) {
        AppMethodBeat.m2504i(74710);
        this.mqa = c20749a;
        super.setCallBack(c20749a);
        AppMethodBeat.m2505o(74710);
    }

    public final void bwC() {
    }

    public void setType(String str) {
        AppMethodBeat.m2504i(74711);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
            AppMethodBeat.m2505o(74711);
            return;
        }
        String trim = str.trim();
        Iterator it = this.mpZ.iterator();
        while (it.hasNext()) {
            if (trim.equals(((C44270d) it.next()).yxM)) {
                C4990ab.m7421w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", trim);
                AppMethodBeat.m2505o(74711);
                return;
            }
        }
        this.mpZ.clear();
        C44270d dAe = dAe();
        this.mpZ.add(dAe);
        mo71949a(dAe, trim, true);
        dAe.yxN.setOnClickListener(this.mqb);
        removeViews(0, getChildCount() - 1);
        addView(dAe.yxN, 0);
        dAf();
        AppMethodBeat.m2505o(74711);
    }
}
