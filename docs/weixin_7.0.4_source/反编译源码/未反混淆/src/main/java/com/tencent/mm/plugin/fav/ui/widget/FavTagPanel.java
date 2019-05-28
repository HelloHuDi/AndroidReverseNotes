package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;
import java.util.LinkedList;

public class FavTagPanel extends MMTagPanel {
    private LinkedList<d> mpZ = new LinkedList();
    private a mqa = null;
    private OnClickListener mqb = new OnClickListener() {
        public final void onClick(final View view) {
            AppMethodBeat.i(74707);
            if (((Integer) view.getTag()).intValue() == 0) {
                FavTagPanel.a(FavTagPanel.this, (TextView) view);
                if (FavTagPanel.this.mqa != null) {
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(74705);
                            FavTagPanel.this.mqa;
                            ((TextView) view).getText().toString();
                            AppMethodBeat.o(74705);
                        }
                    });
                    AppMethodBeat.o(74707);
                    return;
                }
            }
            FavTagPanel.b(FavTagPanel.this, (TextView) view);
            if (FavTagPanel.this.mqa != null) {
                view.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74706);
                        FavTagPanel.this.mqa.Mi(((TextView) view).getText().toString());
                        AppMethodBeat.o(74706);
                    }
                });
            }
            AppMethodBeat.o(74707);
        }
    };

    public interface a extends com.tencent.mm.ui.base.MMTagPanel.a {
        void Mi(String str);
    }

    static /* synthetic */ void a(FavTagPanel favTagPanel, TextView textView) {
        AppMethodBeat.i(74712);
        favTagPanel.a(textView, true, false);
        AppMethodBeat.o(74712);
    }

    static /* synthetic */ void b(FavTagPanel favTagPanel, TextView textView) {
        AppMethodBeat.i(74713);
        favTagPanel.a(textView, false, false);
        AppMethodBeat.o(74713);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(74708);
        AppMethodBeat.o(74708);
    }

    public FavTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(74709);
        AppMethodBeat.o(74709);
    }

    public void setCallBack(a aVar) {
        AppMethodBeat.i(74710);
        this.mqa = aVar;
        super.setCallBack(aVar);
        AppMethodBeat.o(74710);
    }

    public final void bwC() {
    }

    public void setType(String str) {
        AppMethodBeat.i(74711);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
            AppMethodBeat.o(74711);
            return;
        }
        String trim = str.trim();
        Iterator it = this.mpZ.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).yxM)) {
                ab.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", trim);
                AppMethodBeat.o(74711);
                return;
            }
        }
        this.mpZ.clear();
        d dAe = dAe();
        this.mpZ.add(dAe);
        a(dAe, trim, true);
        dAe.yxN.setOnClickListener(this.mqb);
        removeViews(0, getChildCount() - 1);
        addView(dAe.yxN, 0);
        dAf();
        AppMethodBeat.o(74711);
    }
}
