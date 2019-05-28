package com.tencent.mm.plugin.subapp.ui.openapi;

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
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter implements com.tencent.mm.sdk.e.k.a {
    private Context context;
    private List<f> qnw;
    boolean suv = false;
    private int suw = 0;

    public a(Context context, int i) {
        AppMethodBeat.i(25429);
        this.context = context;
        this.suw = i;
        init();
        AppMethodBeat.o(25429);
    }

    private void init() {
        int i = 0;
        AppMethodBeat.i(25430);
        this.qnw = new ArrayList();
        Cursor rawQuery = am.bYJ().rawQuery("select * from AppInfo where status = " + this.suw + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            ab.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            while (i < count) {
                rawQuery.moveToPosition(i);
                f fVar = new f();
                fVar.d(rawQuery);
                if (g.u(this.context, fVar.field_appId)) {
                    this.qnw.add(fVar);
                }
                i++;
            }
            rawQuery.close();
        }
        AppMethodBeat.o(25430);
    }

    public final void lX(boolean z) {
        AppMethodBeat.i(25431);
        this.suv = z;
        notifyDataSetChanged();
        AppMethodBeat.o(25431);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        AppMethodBeat.i(25432);
        if (view == null) {
            dVar = new d();
            view = View.inflate(this.context, R.layout.e3, null);
            dVar.iyo = (ImageView) view.findViewById(R.id.xm);
            dVar.suQ = (TextView) view.findViewById(R.id.xn);
            dVar.gtb = (TextView) view.findViewById(R.id.xp);
            dVar.suR = view.findViewById(R.id.xo);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.suR.setVisibility(4);
        if (wK(i)) {
            dVar.iyo.setVisibility(4);
            dVar.suQ.setVisibility(4);
            dVar.gtb.setVisibility(4);
            AppMethodBeat.o(25432);
        } else {
            f fVar = (f) getItem(i);
            dVar.iyo.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bz.a.getDensity(this.context));
            if (b == null) {
                dVar.iyo.setBackgroundResource(R.drawable.aau);
            } else {
                dVar.iyo.setBackgroundDrawable(new BitmapDrawable(b));
            }
            dVar.gtb.setVisibility(0);
            dVar.gtb.setText(g.b(this.context, fVar, null));
            if (this.suv) {
                dVar.suQ.setVisibility(0);
            } else {
                dVar.suQ.setVisibility(8);
            }
            AppMethodBeat.o(25432);
        }
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(25433);
        int realCount = getRealCount() + bFs();
        AppMethodBeat.o(25433);
        return realCount;
    }

    public final boolean wK(int i) {
        AppMethodBeat.i(25434);
        int size = this.qnw.size();
        if (i < size || i >= size + bFs()) {
            AppMethodBeat.o(25434);
            return false;
        }
        AppMethodBeat.o(25434);
        return true;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(25435);
        if (wK(i)) {
            AppMethodBeat.o(25435);
            return null;
        }
        Object obj = this.qnw.get(i);
        AppMethodBeat.o(25435);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int getRealCount() {
        AppMethodBeat.i(25436);
        int size = this.qnw.size();
        AppMethodBeat.o(25436);
        return size;
    }

    private int bFs() {
        AppMethodBeat.i(25437);
        int realCount = (4 - (getRealCount() % 4)) % 4;
        AppMethodBeat.o(25437);
        return realCount;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(25438);
        init();
        super.notifyDataSetChanged();
        AppMethodBeat.o(25438);
    }
}
