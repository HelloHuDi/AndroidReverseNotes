package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public abstract class a<T> extends BaseAdapter {
    private static int nec = 500;
    protected Context mContext;
    protected LinkedList<T> mYj;
    private a ndZ;
    protected boolean nea = false;
    private f<String, Bitmap> neb;
    private ap ned = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(111696);
            a.this.notifyDataSetChanged();
            AppMethodBeat.o(111696);
            return false;
        }
    }, false);
    private final com.tencent.mm.sdk.e.k.a nee = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(111697);
            a.this.ned.stopTimer();
            long access$100 = (long) a.nec;
            a.this.ned.ae(access$100, access$100);
            AppMethodBeat.o(111697);
        }
    };

    public interface a {
    }

    public a(Context context) {
        this.mContext = context;
        this.mYj = new LinkedList();
        this.neb = new b(20, getClass());
        com.tencent.mm.plugin.s.a.bYJ().c(this.nee);
    }

    public void Y(LinkedList<T> linkedList) {
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

    public void Z(LinkedList<T> linkedList) {
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
            this.neb.a(new com.tencent.mm.a.f.a<String, Bitmap>() {
            });
        }
        this.neb = null;
        com.tencent.mm.plugin.s.a.bYJ().d(this.nee);
    }

    /* Access modifiers changed, original: protected|final */
    public final Bitmap Oi(String str) {
        if (bo.isNullOrNil(str)) {
            return null;
        }
        Bitmap bitmap;
        if (this.neb.aj(str)) {
            bitmap = (Bitmap) this.neb.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                return bitmap;
            }
        }
        bitmap = g.b(str, 1, com.tencent.mm.bz.a.getDensity(this.mContext));
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        this.neb.k(str, bitmap);
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
