package com.tencent.p177mm.plugin.subapp.p537ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.subapp.ui.openapi.a */
public final class C29400a extends BaseAdapter implements C4931a {
    private Context context;
    private List<C40439f> qnw;
    boolean suv = false;
    private int suw = 0;

    public C29400a(Context context, int i) {
        AppMethodBeat.m2504i(25429);
        this.context = context;
        this.suw = i;
        init();
        AppMethodBeat.m2505o(25429);
    }

    private void init() {
        int i = 0;
        AppMethodBeat.m2504i(25430);
        this.qnw = new ArrayList();
        Cursor rawQuery = C14877am.bYJ().rawQuery("select * from AppInfo where status = " + this.suw + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            while (i < count) {
                rawQuery.moveToPosition(i);
                C40439f c40439f = new C40439f();
                c40439f.mo8995d(rawQuery);
                if (C46494g.m87757u(this.context, c40439f.field_appId)) {
                    this.qnw.add(c40439f);
                }
                i++;
            }
            rawQuery.close();
        }
        AppMethodBeat.m2505o(25430);
    }

    /* renamed from: lX */
    public final void mo47639lX(boolean z) {
        AppMethodBeat.m2504i(25431);
        this.suv = z;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(25431);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C43675d c43675d;
        AppMethodBeat.m2504i(25432);
        if (view == null) {
            c43675d = new C43675d();
            view = View.inflate(this.context, 2130968753, null);
            c43675d.iyo = (ImageView) view.findViewById(2131821444);
            c43675d.suQ = (TextView) view.findViewById(2131821445);
            c43675d.gtb = (TextView) view.findViewById(2131821447);
            c43675d.suR = view.findViewById(2131821446);
            view.setTag(c43675d);
        } else {
            c43675d = (C43675d) view.getTag();
        }
        c43675d.suR.setVisibility(4);
        if (mo47640wK(i)) {
            c43675d.iyo.setVisibility(4);
            c43675d.suQ.setVisibility(4);
            c43675d.gtb.setVisibility(4);
            AppMethodBeat.m2505o(25432);
        } else {
            C40439f c40439f = (C40439f) getItem(i);
            c43675d.iyo.setVisibility(0);
            Bitmap b = C46494g.m87732b(c40439f.field_appId, 1, C1338a.getDensity(this.context));
            if (b == null) {
                c43675d.iyo.setBackgroundResource(C25738R.drawable.aau);
            } else {
                c43675d.iyo.setBackgroundDrawable(new BitmapDrawable(b));
            }
            c43675d.gtb.setVisibility(0);
            c43675d.gtb.setText(C46494g.m87733b(this.context, c40439f, null));
            if (this.suv) {
                c43675d.suQ.setVisibility(0);
            } else {
                c43675d.suQ.setVisibility(8);
            }
            AppMethodBeat.m2505o(25432);
        }
        return view;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(25433);
        int realCount = getRealCount() + bFs();
        AppMethodBeat.m2505o(25433);
        return realCount;
    }

    /* renamed from: wK */
    public final boolean mo47640wK(int i) {
        AppMethodBeat.m2504i(25434);
        int size = this.qnw.size();
        if (i < size || i >= size + bFs()) {
            AppMethodBeat.m2505o(25434);
            return false;
        }
        AppMethodBeat.m2505o(25434);
        return true;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(25435);
        if (mo47640wK(i)) {
            AppMethodBeat.m2505o(25435);
            return null;
        }
        Object obj = this.qnw.get(i);
        AppMethodBeat.m2505o(25435);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int getRealCount() {
        AppMethodBeat.m2504i(25436);
        int size = this.qnw.size();
        AppMethodBeat.m2505o(25436);
        return size;
    }

    private int bFs() {
        AppMethodBeat.m2504i(25437);
        int realCount = (4 - (getRealCount() % 4)) % 4;
        AppMethodBeat.m2505o(25437);
        return realCount;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(25438);
        init();
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(25438);
    }
}
